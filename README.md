# Movie-Theater-Seating-Challenge

## What is it?
Simulate a application to allocate the seats in the movie theater for users to get the max satisfaction and the theater to have the most utilization. I use the two pointers (include the upper and downner pointer) algorithm and make some assumption.

## Assumptions: 

1. The audience like to seat in the middle row of the theater in order to have the good view of the movie.

2. The audience like to seat at the same row. if they can not seat at the same row, then they would like to seat near closeast to the middle row.

## The allocate algorithm to allocate the seatworks in the following:
1. The system starts to allocate the seats in the middle rows of the room. This is because the audiences like to sit in the middle row of the room.

2. We will have two pointer up pointer and down pointer. Up pointer will start to move from the middle rows to the upper row until it meets the last row. Down pointer will also start to move from the middle rows to the downer row until it meets the first rows of the room.

3. The system will assign the seat adjacently. If that rows is filled, then two pointers will keep going to move down and up until all the request are meet. 

The time complexity of the O(n) where the n is the number of the seats in the room.


## How to run in the console:

java -cp seatChallenge.jar ReservationService  --input= {INPUTFILEPATH} --output= {OUTPUTFILEPATH}
