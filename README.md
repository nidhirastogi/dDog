# dDog
##### For Problem 1: Please follow the ipython code notebook called: problem1.ipynb 
##### For Problem 2: The following code is followed in the order given below: 
-   DownloadFiles.java -> Downloads all files within the given range of years from the link provided in instructions.txt 
-   For quick manipulation of downloaded data -> problem1.ipynb 
-   For using intermediary csv files created in previous steps, and to get the final result of this problem -> DataManipulation2.java
###### For Problem 2, Our results show that there is no team-triple combination that has more than 50 players who've played for them. The output screenshots are saved in individual folders for the two problems
-----------------
##### Discussion on Time-Space Complexity for Problem 2
 - n = length of entire list from all years
 - k = number of unique teams
 - p = number of unique players
 
 #####  The overall Time Complexity is: 
             Space Complexity is:
 #####  For individual methods, the space-time is as follows:
 
 #####  Steps for the Program2: 
 1. Get all Unique Team Names	and player names - Time: O(n), Space : O(k)+O(p) = O(k+p)
 2. Sort List by Player names - O(n log n)
 3. HashSet containing unique combination of 3 teams, in alphabetical order or team names (to avoid multiple of same combination of teams). Time - O(k3), Space O(k*k*k)
 4. HasSet in this Format : HashSet<String, List<List<String>,Integer>> -> hashset with key value pair. Here "key" is unique triple combination and value is a list of names of players and "count" of these players
 5. Finally select only those keys that have count in the value as greater than or equal to 50.
