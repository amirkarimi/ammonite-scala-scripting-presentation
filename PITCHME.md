
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
- Hard to maintain
- Not so composable (pipes are good but not enough)
  - List files which are less than 1KB and the file name length is less than 20
- Magic switches (Ex. file size filter)
- You know the algorithm but you don't know how to implement

+++

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

You're not sure that it works before running it!

```bash
let c = $a - $b    // Incorrect
let c=$a-$b        // Correct
```
```bash
if [ $a -le 5]     // Incorrect
if [ $a -le 5 ]    // Correct
```
```bash
cp $file $target         // Not safe
cp -- "$file" "$target"  // More safe
```

Checkout http://tldp.org/LDP/abs/html/gotchas.html

---

## Why we haven't replaced Bash with something better?

+++

- <span style="color: #ffb500">File Operations</span> are almost always hard in real programming languages
- <span style="color: #ffb500">REPL</span> didn't exist for many languages (even Java is in the process of getting a REPL)
- Once upon a time... <span style="color: #ffb500">DevOps</span> wasn't even defined
  - Developers used to have nothing to do with operations. There was a separate network/sysadmin team
  - Operation guys didn't like programming, they just wanted everything up and running

---

# Now What?

+++

## Ammonite Shell ##

http://ammonite.io/

Automate your life using <span style="color: #ffb500">Scala</span> without having to setup a huge `build.sbt`

![Happy](assets/img/happy-meme.jpg)

+++

### Benefits

- A real language, a powerful one!
- Single file scripts
- Typesafety
- Functional
- Composable
- JVM libraries
  - You can even spin up a web server in your script

+++

### Install

```bash
$ sudo curl -L -o /usr/local/bin/amm https://git.io/vHugK \
    && sudo chmod +x /usr/local/bin/amm \
    && amm

$ amm your-awesome-script.sc
```

+++

### Demo: Ammonite REPL & Scala

- `Seq`
- Infix notation (`1 to 10`)
- `map`, `filter`
- `_` placeholder

+++

## Case Study

### A colon-separeted list of files ###

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

(ls! pwd) |? (_.isFile)
```

+++

### Filter out hidden files

Scala

``` scala
(ls! pwd)
  .filter(_.isFile)
  .filterNot(_.name.start("."))

(ls! pwd)
  .filter(f => f.isFile && !f.name.startsWith("."))
```
+++

### Filter on extension

Scala

```scala
(ls! pwd)
  .filter(f =>
    f.isFile &&
    !f.name.startsWith(".") &&
    f.ext == "pem"
  )
```

---

## Scala Script File ##

We saw the REPL, let's write real scripts

+++

### Shebang \#! ###

my_script.sc

```scala
#!/usr/bin/env amm

(ls! pwd)
  .filter(f => f.isFile && !f.name.startsWith("."))
  .mkString(":")
```

Run

```bash
$ ./my_script.sc
```

```bash
$ amm my_script.sc
```

+++

### Running other programs

```scala
%git 'status

%%git 'status
```
+++

### JVM Libraries

```scala
import $ivy.`joda-time:joda-time:2.8.2`

import org.joda.time.DateTime
```

```scala
import $ivy.`joda-time:joda-time:2.8.2`, org.joda.time._
```

+++

### Demo - Script Arguments

arguments.sc

+++

### Demo - Some Real Scripts

AWS CloudFormation Recreation (recreat-stack.sc)

+++

### Demo: Watch and Reload

```bash
amm -w foo.sc
```

+++

## Demo: Webserver

play-demo.sc

---

## Summary

- As a DevOps, you can
  - learn Scala by using that in your day-to-day works
  - build more reliable and maintanable scripts/tools
- As a Dev, you can
  - Enjoy doing DevOps tasks
  - Be a real DevOps
- As a team, we can
  - Have a common language for our tools

---

# Thank you
@4m1rk
