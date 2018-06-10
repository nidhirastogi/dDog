# dDog
##### For Problem 1: All code in Problem1 folder. Please follow the ipython code notebook called: problem1.ipynb 
##### For Problem 2: All code in Problem2 folder. The following code is followed in the order given below: 
-   DownloadFiles.java -> Downloads all files within the given range of years from the link provided in instructions.txt 
-   For quick manipulation of downloaded data -> problem2.ipynb 
-   For using intermediary csv files created in previous steps, and to get the final result of this problem -> DataManipulation2.java
###### For Problem 2, Our results show that there is no team-triple combination that has more than 50 players who've played for them. The output screenshots are saved in individual folders for the two problems
-----------------
##### Discussion on Time-Space Complexity for Problem 2
 - n = length of entire list from all years
 - k = number of unique teams
 - p = number of unique players
 
 #####  The overall Program Complexity is: 
             Time: O(k^3)
             Space: O(k^3), worst case
 #####  For individual methods, the space-time is as follows (worst case scenarios):
        In problem2.ipynb : Sorting T - O(nlog n), where n is the size of the file. S-O(1), since sorting was in-place. This was the most expensive computation in terms of Time. In terms of Space, the most expensive computations were creating unique lists of players along with the teams they've played for: O(p), and unique list of teams - O(k).
        In DownloadFiles.java : T- O(n), S- O(n), where n is the number of events.
        In DataManipulation.java:
                    getListTeams: T- O(n), S- O(k), where n is the size of the original file containing all teams, and k i sthe hashset size containing unique values of team names.
            getTeamUniqueTriples: T- O(k^3), S- O(k^3), where k is the team size
                  getListPlayers: T- O(p), S- O(p), where p is the number of player that have played for >2 teams.
          getPlayersTeamsTriples: T- O(p^3), S- O(p^3)
     getTripleTeamswith50Players: T- O(p^3)+O(k^3), S- O(k^3)
     
 #####  Steps for the Program2: 
 1. Get all Unique Team Names	and player names - Time: O(n), Space : O(k)+O(p) = O(k+p)
 2. Sort List by Player names - O(n log n)
 3. HashSet containing unique combination of 3 teams, in alphabetical order or team names (to avoid multiple of same combination of teams). Time - O(k3), Space O(k^3)
 4. HasSet in this Format : HashSet<String, List<List<String>,Integer>> -> hashset with key value pair. Here "key" is unique triple combination and value is a list of names of players and "count" of these players
 5. Finally select only those keys that have count in the value as greater than or equal to 50.
