"3-Card Poker"
==============

This is a poker game where the winner of a round is the player with the best hand.
The hierarchy of hands are below:

**Straight Flush:** A hand that is both a straight and a flush (Check Straight and Flush below).

**Three Of A Kind:** A hand in which all three of the cards have the same rank.

**Straight:** a hand in which the cards have ranks that are in a "run". A run is when three cards are of the format `n, n+1, n+2`. E.g `2-3-4`.

**Flush:** A hand in which all three cards have the same suit.

**Pair:** A hand in which two of the cards have the same rank, but the third is different.

**High Card:** Any hand that doesn't fit into one of the other categories is considered a "high card" hand.



This program is written in Java 11.0.4. and will run on Java 8 upward.

I used the Factory design pattern while making this program because the type of hand a player has depends on the cards the player has.

The program collects input from `stdin`. I used `Scanner`

Input Data
----------
The first line of input will contain a single integer `n` representing the number of players. This number will always be greater than 0 and less than 24.

The next `n` lines will represent each player with the input format of `<player_id> <card1> <card2> <card3>` where `player_id` is an integer, and the remaining space-seperated values are cards with the format of `<Rank><Suit>` 


Output Format
-------------
All outputs are printed to `stdout`.

If all inputs are valid, the output should be the id of the winning player.
```
2
```
If there is a tie between players, the output will the ids of the players seperated by space.
```
2 3
```
If there is an invalid input, the output will be
```
Invalid input.
```

Compliation and Running
-----------------------

The file with the `main` method is in the `poker.java` file.

Using the terminal, navigate into the `10_21-mark43` directory and use the `javac` command on the `poker.java` file to compile the program. So it will look like `javac poker.java`.

To run the program, use `java poker`. So to run against tests, use `./run_tests "java poker"`

