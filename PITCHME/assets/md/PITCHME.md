
## Scripting for Scala lovers
#### <span style="color: gray">or</span>
### <span style="color: #ffb500">How to push Scala Devs to Ops</span>
---
# Bash
---
## Bash <small>Pros</small>
- Accessible
- Easy to start
- Pipes
- TBD
---
## Bash <small>Cons</small>
### Not a real programming language
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
- File Operations - are almost always hard in other languages
- REPL didn't exist for many languages (Java is in the process of getting REPL)
- Once upon a time... "DevOps" wasn't defined
  - Developers used to have nothing to do with operations. There was a separate network/sysadmin team.
  - Operation guys didn't like programming itself, they just wanted everything to be up and running
---
IDEAS:
- Use ammonite to fetch some data from inside an AWS (http://169.254.169.254/latest/placement/availability-zone)

# Bye bye
