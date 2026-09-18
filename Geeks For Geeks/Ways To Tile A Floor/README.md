# Ways To Tile A Floor

- Platform: GeeksforGeeks
- Language: Java
- Difficulty: Medium
- Topics: Fibonacci, Dynamic Programming, Recursion
- Runtime: 0.15 s
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1
- Synced: 2026-09-18T20:41:08.000Z

## Problem Description

<p><span style="font-size: 14pt;">Given a floor of dimensions <strong>2 x n</strong> and tiles of dimensions <strong>2 x 1</strong>, the task is to find the <strong>number of ways</strong> the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile.&nbsp;<br /></span></p>
<p><span style="font-size: 14pt;"><strong>Note:</strong> Two tiling arrangements are considered different if the placement of at least one tile differs.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>n = 3
<strong>Output: </strong>3
<strong>Explanation: </strong>We need 3 tiles to tile the board of size 2 x 3.
We can tile in following ways:
1) Place all 3 tiles vertically.
2) Place first tile vertically and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally and remaining tiles vertically.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>n = 4
<strong>Output: </strong>5
<strong>Explanation: </strong>We need 4 tiles to tile the board of size 2 x 4.
We can tile in following ways:
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining 2 horizontal.
4) First 2 horizontal, remaining 2 vertical.
5) Corner 2 vertical, middle 2 horizontal.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong></span><br /><span style="font-size: 14pt;">1 &le; n &le; 45</span></p>

## Explanation

This solution was accepted on GeeksforGeeks using Java. The detected topics are Fibonacci, Dynamic Programming, Recursion. Review the synced source file for the implementation details.
