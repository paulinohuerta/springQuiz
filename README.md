# springQuiz
## Synopsis
This project is Spring Quiz as it's name says. It needs a Redis server working and the execution of the perl script *load-data.pl*. It loads questions and responses from *content-data* to the server. Then, the Spring webapp will show these questions anyway Redis is working.

## Requirements:
- Insert in Redis server values for questions.
- Steps:
```
 select 9
 sadd quiz:set 1 2 3 4 5 6 7 8 9 (index for questions)
 hmset quiz:hash :9 texto "El anillo unico lo llevo un..." link "ESDLA" op1 Humano op2 Mediano op3 Enano op4 Elfo well 2 (Insert questions in redis, scheme)
```
### Scheme: 

|   |   |
|---|---|
|quiz:hash :9|key of hashmap|
|field: texto | value: "El anillo unico lo llevo un..." |
|field: link | value: "ESDLA" |
| field: op1 | value: Humano |
| field: op2 | value: Mediano |
| field: op3 | value: Enano |
| field: op4 | value: Elfo |
| field: well | value: 2 |


## Improvements
- Finish the quiz when all questions are answered (currently it shows all question in loop).
- Getting score answering the correct option, and showing it at the end of the quiz.
- Introducing a player name (now it's always *Paulino*).

