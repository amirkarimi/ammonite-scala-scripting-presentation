#!/usr/bin/env amm

import ammonite.ops._

@main
def main(i: Int, s: String, path: Path = pwd) = {
  s"Hello! ${s * i} ${path}."
}
