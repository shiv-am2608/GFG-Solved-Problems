# Edit Distance
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given two strings <strong>s</strong>&nbsp;and <strong>t. </strong>Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:</span></p>

<ol>
	<li><span style="font-size:18px">Insert a character at any position of the string.</span></li>
	<li><span style="font-size:18px">Remove any character from the string.</span></li>
	<li><span style="font-size:18px">Replace any character from the string with any other character.</span></li>
</ol>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>
s = "geek", t = "gesek"
<strong>Output:</strong>&nbsp;1
<strong>Explanation: </strong>One operation is required 
inserting 's' between two 'e's of str1.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>
s = "gfg", t = "gfg"
<strong>Output: </strong>
0
<strong>Explanation: </strong>Both strings are same.</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or&nbsp;print anything. Your task is to complete the function <strong>editDistance()&nbsp;</strong>which takes strings s and t as input parameters and returns the minimum number of operation required to make both strings equal.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|s|*|t|)<br>
<strong>Expected Space Complexity:&nbsp;</strong>O(|s|*|t|)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ Length of both strings ≤ 100<br>
Both&nbsp;the strings are in&nbsp;lowercase.</span></p>
 <p></p>
            </div>