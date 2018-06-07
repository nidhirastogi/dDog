---------
Problem 1
---------

You have been provided two files, scenario1.txt and scenario2.txt
which each contain simulated application logs in the following format:

Column 1: # seconds since time t=0
Column 2: # requests processed since last log
Column 3: Mean response time for requests processed since last log

The logging frequency is 1 per second, but there are no logs for seconds in
which there were no requests. The data span two simulated weeks and were
generated under an idealized/simplified model in which there is a single
application server which processes requests sequentially using a single thread.
If a request arrives while the server is busy, it waits in a queue until
the server is free to process it. There is no limit to the size of the queue.

For each scenario, please answer the following questions.
Note that we define "week 2" to begin at second 626400 (6 am on the 8th day).

1) How much has the mean response time (specifically, the mean of the response
times for each individual request) changed from week 1 to week 2?

2) Create a plot illustrating the probability distribution of the amount of
server time it takes to process a request (excluding the time the request
spends waiting in the queue). How would you describe the distribution?

3) Propose a potential cause for the change in response times. Give both a
qualitative answer as if you were explaining it to a client and a quantitative
answer as if you were explaining it to a statistician. Create 1 or 2 plots to
support and illustrate your argument.

Your submission should include sufficient code and instructions to reproduce
your analysis (any quantitative results as well as your plots).

---------
Problem 2
---------

We have provided files that provide yearly game appearance statistics for every
player to have played in Major League Baseball between the years 1871 and 2014.

The files can be found on:

https://s3.amazonaws.com/dd-interview-data/data_scientist/baseball/appearances/YYYY/YYYY-0,000

The header for these files is as follows:

Year,Team,League,Player ID code,Player Name,Total games played,Games started,Games in which player batted,Games in which player appeared on defense,Games as pitcher,Games as catcher,Games as firstbaseman,Games as secondbaseman,Games as thirdbaseman,Games as shortstop,Games as leftfielder,Games as centerfielder,Games as right fielder,Games as outfielder,Games as designated hitter,Games as pinch hitter,Games as pinch runner

Write a program that downloads these files and produces a list of triples of
teams for which at least 50 players have played for all three teams.

For instance, Alex Rodriguez has played for the Mariners, Rangers, and Yankees,
and thus he would count once for the Mariners/Rangers/Yankees triple.

Please include a brief analysis of the run-time and space complexity of your
algorithm. Your solution should preferably be implemented in Go, Python, Java,
Ruby, C, C++, or Perl. Please include compilation/runtime instructions with
your code.

