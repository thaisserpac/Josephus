The program receives its input from the command line, and must have either
two or three command-line parameters:

- First, the number of zealots (must be from from 1 to 50)

- Second, the "elimination gap" (the number n mentioned above)

- Third, and optionally, an integer seed value (>0) for the random generator

It then produces a random list of zealot names, which are taken from a list
of fifty 3-character first names, and which always include the name of our
good friend Josehpus.

The program then first displays the full list of zealots, including Joe,
and next begins the elimination process. It shows the name of each successive
victim, followed by the list of remaining zealots after that victim has been
eliminated.

Once the list has been reduced to a single zealot, it is clear that this
particular zealot's position is the one Joe should be occupying before the
process begins. It may be that he should just stay put, but more likely he
will have to convice someone to exchange places with him. The program will
end by advising him accordingly.
