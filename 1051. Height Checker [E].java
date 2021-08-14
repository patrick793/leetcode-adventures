/*
  Problem: Height Checker
  Difficulty: Easy Peasy Lemon Squeezy

  Given:
  - Array of heights -> heights[]

  Constraints:
  - 1 <= heights.length <= 100
  - 1 <= heights[i] <= 100

  Possible edge cases:
  - Are the heights distinct? Yes
  
  Off-the-bat solution:
 
  TC -> O(nlog(n)), where n is the length of heights
  SC -> O(n), where n is the length of heights

  1. Create a copy of heights array. Let's call it sortedHeights
  2. Initialize an int variable differences to 0
  2. Sort sortedHeights in ascending order
  3. For i = 0 ; i < heights.length ; i++:
     a. If heights[i] != sortedHeights[i], increment differences
  4. Return differences
   
*/

class Solution {
  public int heightChecker(int[] heights) {
    int length = heights.length;
    int[] expected = Arrays.stream(heights).sorted().toArray();

    int differences = 0;
    for(int i = 0 ; i < length ; i++) {
      if(heights[i] != expected[i]) {
        differences++;
      }
    }
    return differences;
  }   
}

/*

  Best solution:

  TC -> O(n), where n is the length of heights
  SC -> O(1)

  1. Create a bucket int array with a length of 101. (This doesn't add to worst-case space complexity, cuz it's freaking constant)
  2. For each height in heights:
     a. Increment bucket[height] by 1
  3. For i = 1 ; i < 101 ; i++:
     a. ARGHH CAN'T EXPLAIN IT CLEARLY. JUST FOLLOW THE CODE
*/

class Solution {
    public int heightChecker(int[] heights) {
        
        int length = heights.length;
        int[] bucket = new int[101]; // O(constant) space
        
        // O(n) loop here
        for(int height : heights) {
            bucket[height]++;
        }

        int heightIdx = 0;
        int differences = 0;

        // O(constant + n) loop here
        for(int i = 1 ; i < 101 ; i++) {
           for(int unused = 0 ; unused < bucket[i] ; unused++) {
               if(i != heights[heightIdx++]) {
                   differences++;
               }
           }
        }
        
        return differences;
    }
}
