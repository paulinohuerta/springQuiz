# springQuiz
## Synopsis
This project is Spring Quiz as it's name says. It needs a Redis server working and the execution of the pearl script *load-data.pl*. It loads questions and responses from *content-data* to the server. Then, the Spring webapp will show these questions anyway Redis is working.

## Improvements
- Finish the quiz when all questions are answered (currently it shows all question in loop).
- Getting score answering the correct option, and showing it at the end of the quiz.
- Introducing a player name (now it's always *Paulino*).
