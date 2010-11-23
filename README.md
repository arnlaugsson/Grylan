# Introduction

This is a part of a final project for an NLP course in Reykjavik University. The goal is to build a grammar checker for the Icelandic language using existing Open-Source tools ([IceNLP]). 

**Authors:** 

+ Kristján Guðni Halldórsson <kristjanh07@ru.is>
+ Skúli Arnlaugsson <skuli06@ru.is>

# Some more details

+ We decided to implement a rule-based grammar checker, that has predefined rules that look for certain grammar errors.
+ We will implement an add-on to the [IceNLP] suite, which will accept icelandic sentences and return a list of errors that match the predefined rules.
+ We will also implement a plugin to MS Word that uses Málgrýlan (*Mál* means language and *[Grýlan]* is a Icelandic ogress, who is mother to the 13 Icelandic Yule lads) to find errors and report them.

# About this part

Málgrýlan (or Grýlan for short) is a Java module that uses [IceNLP] to parse and tag icelandic text, then it takes the tagged text and runs it through a set of predefined grammar rules. The output is either an `ok` flag or a list of found errors (formatted according to a given [BNF]).

[BNF]:https://github.com/arnlaugsson/Malgrylan/tree/master/BNF/
[IceNLP]:http://nlp.cs.ru.is/
[Grýlan]:http://en.wikipedia.org/wiki/Gr%C3%BDla