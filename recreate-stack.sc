#!/usr/bin/env amm

import scala.util._
import ammonite.ops._
import ammonite.ops.ImplicitWd._

def getStackStatus(stackName: String) = {
  val result = Try(%%('aws, "cloudformation", "describe-stacks", "--stack-name", stackName)).map(_.out.string).getOrElse("")
  // We could use a powerful JSON library here easily
  val regEx = "\"StackStatus\": \"(.+)\"".r.unanchored
  result match {
    case regEx(s) => s
    case _ => ""
  }
}

def checkAndWait(count: Int): Boolean = {
  val status = getStackStatus("my-stack")
  if (status.isEmpty || status == "DELETE_COMPLETE") {
    println(s"Status: ${status}")
    true
  } else {
    if (count == 0) {
      println("Giving up...")
      false
    } else {
      println(s"Status: ${status}. Wait for another 5 seconds...")
      Thread.sleep(5000)
      checkAndWait(count - 1)
    }
  }
}

// Delete the stack
%('aws, "cloudformation", "delete-stack", "--stack-name", "my-stack")

// Wait to be deleted
if (checkAndWait(100)) {
  %("aws", "cloudformation", "create-stack",
    "--template-body", "file://cloud-formation.yaml",
    "--stack-name", "my-stack",
    "--parameters",
    "ParameterKey=KeyName,ParameterValue=some-project",
    "ParameterKey=DBUser,ParameterValue=changeme",
    "ParameterKey=DBPassword,ParameterValue=changeme",
    "ParameterKey=ApplicationSecret,ParameterValue=changeme",
    "ParameterKey=VpcId,ParameterValue=vpc-1234",
    """ParameterKey=SubnetIds,ParameterValue="subnet-123,subnet-456""""
  )
}
