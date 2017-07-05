
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

You're 20% sure that it works before you run it!

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
- Not maintainable if not too short
- Not so composable (pipes are good but not enough)
  - List files which are less than 1KB and the file name length is less than 20
---
IDEAS:
- Ask people what work is very hard or imposible to do with `ls` which you know how it can be done (Algorithm)
- (Porbably appropirate for last slide) Ammonite Scripting is not against Unix phylosophy, it just does one thing; just runs the algorithms, and does it well! (Read about "Linux is dead...")
- Use ammonite to fetch some data from inside an AWS (http://169.254.169.254/latest/placement/availability-zone)

# Bye bye
