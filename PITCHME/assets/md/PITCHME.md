
## Scripting for Scala lovers
#### <span style="color: gray">or</span>
### <span style="color: #ffb500">How to push Scala Devs to Ops</span>
---
# Bash
---
## Bash <small>Pros</small>

- Accessible
- No learning curve
- Pipes
- etc.

---
## Bash <small>Cons</small>
### Not a real programming language

Not good at:

- Structures
- If/else
- Loop
- etc.

+++

## Bash <small>Cons</small>
### No checking/safety mechanism

You're 20% sure that it works before running it!

```bash
let c = $a - $b    // Incorrect
let c=$a-$b        // Correct
```
```
if [ $a -le 5]     // Incorrect
if [ $a -le 5 ]    // Correct
```

Checkout http://tldp.org/LDP/abs/html/gotchas.html

+++

## Bash <small>Cons</small>
- Hard to maintain
- Not so composable (pipes are good but not enough)
  - List files which are less than 1KB and the file name length is less than 20
- Magic switches (Ex. file size filter)

---

## Why we haven't replaced Bash with something better?

+++

- <span style="color: #ffb500">File Operations</span> are almost always hard in other languages
- <span style="color: #ffb500">REPL</span> didn't exist for many languages (Java is in the process of getting REPL)
- Once upon a time... <span style="color: #ffb500">DevOps</span> wasn't even defined
  - Developers used to have nothing to do with operations. There was a separate network/sysadmin team
  - Operation guys didn't like programming, they just wanted everything up and running

---

# Now What?

+++

## Scala Scripting ##

Automate your life using <span style="color: #ffb500">Scala</span> without having to setup a huge `build.sbt`

![Happy](assets/img/happy-meme.jpg)

+++

```bash
$ sudo curl -L -o /usr/local/bin/amm https://git.io/vHugK \
    && sudo chmod +x /usr/local/bin/amm \
    && amm

$ amm your-awesome-script.sc
```

+++

## Demo: Ammonite REPL ##

+++

### A colon-separeted list of files in current directory ###

Bash

```bash
ls -dm *    # Not really the answer but close enough
```

Scala

```scala
(ls! pwd).mkString(":")
```

+++

### Only files, not directories ###

Bash

```bash
# Sorry, too hard for me
```

Scala

```scala
(ls! pwd).filter(_.isFile).mkString(":")
```

+++

### Filter out hidden files

Scala

``` scala
(ls! pwd)
  .filter(_.isFile)
  .filterNot(_.name.start("."))
  .mkString(":")

(ls! pwd)
  .filter(f => f.isFile && !f.name.startsWith("."))
  .mkString(":")
```

---

## Scala Script File ##

We saw the REPL, let's write real scripts

+++

### \#! ###

MyScript.sc

```scala
#!/usr/bin/env amm

(ls! pwd)
  .filter(f => f.isFile && !f.name.startsWith("."))
  .mkString(":")
```

Run

```
$ ./MyScript.sc
```

```
$ amm MyScript.sc
```

+++

## Demo: Some Cool Script

TODO:
AWS CloudFormation Recreation

---

## Demo: Create a webserver

---

IDEAS:
- Ask people what work is very hard or imposible to do with `ls` which you know how it can be done (Algorithm)
- (Porbably appropirate for last slide) Ammonite Scripting is not against Unix phylosophy, it just does one thing; just runs the algorithms, and does it well! (Read about "Linux is dead...")
- Use ammonite to fetch some data from inside an AWS (http://169.254.169.254/latest/placement/availability-zone)

# Bye bye
