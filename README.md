# Cache Simulation Project

<p>To start the project, please access the directory that contains the jar file and input the following in your terminal. This is also demonstrated in the video.</p>

```java -jar CacheSimulation.jar```

<p>This cache simulation project uses a <b>full associative mapping function and random replacement algorithm</b>. It uses the Random class from the Java standard library to generate a pseudo-random number that determines what cache block will be replaced. In this cache operation, the given are the following:</p>
<ul>
  <li>Number of cache blocks = 32 blocks</li>
  <li>Cache line = 16 words</li>
  <li>Read policy: non load-through</li>
</ul>
<p>The number of memory blocks are inputted by the user if required, though this was not used in our project. There are a total of three test cases for this project: <b>(1) Sequential Sequence, (2) Random Sequence</b>, and <b>(3) Mid-repeat Blocks</b>. A detailed analysis of each case is described below.</p>

## Sequential Sequence
<p>In the Sequential Sequence, the cache block pattern follows a sequence of up to 2<i>n</i> cache blocks, with <i>n</i> set as 32 cache blocks. Consequently, the pattern spans 64 cache blocks, denoted as 0, 1, 2, 3...63. Notably, this sequence repeats four times, resulting in the series 0...63, 0...63, 0...63, 0...63. Table 1 below displays a total of ten test cases for the sequential sequence.</p>

<p align=center><b>Table 1. Sequential Sequence Test Cases</b></p>
<table align=center>
  <tr>
    <th>Test Case</th>
    <th colspan="2">Final Snapshot</th>
    <th>Output</th>
  </tr>
  <tr>
    <td align=center>1</td>
    <td>
      <p>Block 0: 23</p>
      <p>Block 1: 56</p>
      <p>Block 2: 29</p>
      <p>Block 3: 50</p>
      <p>Block 4: 52</p>
      <p>Block 5: 43</p>
      <p>Block 6: 31</p>
      <p>Block 7: 7</p>
      <p>Block 8: 33</p>
      <p>Block 9: 61</p>
      <p>Block 10: 60</p>
      <p>Block 11: 36</p>
      <p>Block 12: 57</p>
      <p>Block 13: 47</p>
      <p>Block 14: 16</p>
      <p>Block 15: 32</p>
    </td>
    <td>
      <p>Block 16: 51</p>
      <p>Block 17: 24</p>
      <p>Block 18: 40</p>
      <p>Block 19: 53</p>
      <p>Block 20: 30</p>
      <p>Block 21: 55</p>
      <p>Block 22: 62</p>
      <p>Block 23: 42</p>
      <p>Block 24: 46</p>
      <p>Block 25: 45</p>
      <p>Block 26: 63</p>
      <p>Block 27: 54</p>
      <p>Block 28: 39</p>
      <p>Block 29: 38</p>
      <p>Block 30: 34</p>
      <p>Block 31: 41</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>44</p>
      <p><b>Cache Miss Count</b></p>
      <p>212</p>
      <p><b>Cache Hit Rate</b></p>
      <p>44/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>212/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>134.3281ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>38228.0ns</p>
    </td>
  </tr>
  <tr bg=white>
    <td align=center>2</td>
    <td>
      <p>Block 0: 50</p>
      <p>Block 1: 46</p>
      <p>Block 2: 63</p>
      <p>Block 3: 20</p>
      <p>Block 4: 62</p>
      <p>Block 5: 4</p>
      <p>Block 6: 18</p>
      <p>Block 7: 61</p>
      <p>Block 8: 32</p>
      <p>Block 9: 29</p>
      <p>Block 10: 26</p>
      <p>Block 11: 41</p>
      <p>Block 12: 53</p>
      <p>Block 13: 27</p>
      <p>Block 14: 39</p>
      <p>Block 15: 54</p>
    </td>
    <td>
      <p>Block 16: 33</p>
      <p>Block 17: 56</p>
      <p>Block 18: 52</p>
      <p>Block 19: 51</p>
      <p>Block 20: 60</p>
      <p>Block 21: 58</p>
      <p>Block 22: 36</p>
      <p>Block 23: 48</p>
      <p>Block 24: 7</p>
      <p>Block 25: 45</p>
      <p>Block 26: 47</p>
      <p>Block 27: 30</p>
      <p>Block 28: 42</p>
      <p>Block 29: 35</p>
      <p>Block 30: 1</p>
      <p>Block 31: 44</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>44</p>
      <p><b>Cache Miss Count</b></p>
      <p>212</p>
      <p><b>Cache Hit Rate</b></p>
      <p>44/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>212/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>134.3281ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>38228.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>3</td>
    <td>
      <p>Block 0: 53</p>
      <p>Block 1: 20</p>
      <p>Block 2: 41</p>
      <p>Block 3: 40</p>
      <p>Block 4: 28</p>
      <p>Block 5: 60</p>
      <p>Block 6: 50</p>
      <p>Block 7: 11</p>
      <p>Block 8: 43</p>
      <p>Block 9: 18</p>
      <p>Block 10: 47</p>
      <p>Block 11: 55</p>
      <p>Block 12: 36</p>
      <p>Block 13: 46</p>
      <p>Block 14: 61</p>
      <p>Block 15: 23</p>
    </td>
    <td>
      <p>Block 16: 57</p>
      <p>Block 17: 27</p>
      <p>Block 18: 10</p>
      <p>Block 19: 37</p>
      <p>Block 20: 54</p>
      <p>Block 21: 45</p>
      <p>Block 22: 7</p>
      <p>Block 23: 62</p>
      <p>Block 24: 63</p>
      <p>Block 25: 34</p>
      <p>Block 26: 59</p>
      <p>Block 27: 25</p>
      <p>Block 28: 56</p>
      <p>Block 29: 51</p>
      <p>Block 30: 58</p>
      <p>Block 31: 30</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>52</p>
      <p><b>Cache Miss Count</b></p>
      <p>204</p>
      <p><b>Cache Hit Rate</b></p>
      <p>52/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>204/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>129.2969ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>36940.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>4</td>
    <td>
      <p>Block 0: 32</p>
      <p>Block 1: 59</p>
      <p>Block 2: 36</p>
      <p>Block 3: 52</p>
      <p>Block 4: 26</p>
      <p>Block 5: 60</p>
      <p>Block 6: 28</p>
      <p>Block 7: 54</p>
      <p>Block 8: 49</p>
      <p>Block 9: 44</p>
      <p>Block 10: 42</p>
      <p>Block 11: 12</p>
      <p>Block 12: 58</p>
      <p>Block 13: 0</p>
      <p>Block 14: 40</p>
      <p>Block 15: 55</p>
    </td>
    <td>
      <p>Block 16: 31</p>
      <p>Block 17: 48</p>
      <p>Block 18: 17</p>
      <p>Block 19: 57</p>
      <p>Block 20: 51</p>
      <p>Block 21: 50</p>
      <p>Block 22: 53</p>
      <p>Block 23: 46</p>
      <p>Block 24: 47</p>
      <p>Block 25: 37</p>
      <p>Block 26: 61</p>
      <p>Block 27: 21</p>
      <p>Block 28: 22</p>
      <p>Block 29: 62</p>
      <p>Block 30: 63</p>
      <p>Block 31: 14</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>37</p>
      <p><b>Cache Miss Count</b></p>
      <p>219</p>
      <p><b>Cache Hit Rate</b></p>
      <p>37/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>219/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>138.7305ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>39355.0</p>
    </td>
  </tr>
  <tr>
    <td align=center>5</td>
    <td>
      <p>Block 0: 22</p>
      <p>Block 1: 62</p>
      <p>Block 2: 53</p>
      <p>Block 3: 56</p>
      <p>Block 4: 59</p>
      <p>Block 5: 41</p>
      <p>Block 6: 9</p>
      <p>Block 7: 52</p>
      <p>Block 8: 61</p>
      <p>Block 9: 28</p>
      <p>Block 10: 46</p>
      <p>Block 11: 32</p>
      <p>Block 12: 39</p>
      <p>Block 13: 42</p>
      <p>Block 14: 54</p>
      <p>Block 15: 57</p>
    </td>
    <td>
      <p>Block 16: 43</p>
      <p>Block 17: 24</p>
      <p>Block 18: 36</p>
      <p>Block 19: 40</p>
      <p>Block 20: 63</p>
      <p>Block 21: 19</p>
      <p>Block 22: 47</p>
      <p>Block 23: 33</p>
      <p>Block 24: 27</p>
      <p>Block 25: 16</p>
      <p>Block 26: 60</p>
      <p>Block 27: 6</p>
      <p>Block 28: 45</p>
      <p>Block 29: 58</p>
      <p>Block 30: 49</p>
      <p>Block 31: 55</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>40</p>
      <p><b>Cache Miss Count</b></p>
      <p>216</p>
      <p><b>Cache Hit Rate</b></p>
      <p>40/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>216/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>136.8438ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>388722.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>6</td>
    <td>
      <p>Block 0: 44</p>
      <p>Block 1: 61</p>
      <p>Block 2: 47</p>
      <p>Block 3: 52</p>
      <p>Block 4: 59</p>
      <p>Block 5: 56</p>
      <p>Block 6: 22</p>
      <p>Block 7: 11</p>
      <p>Block 8: 16</p>
      <p>Block 9: 32</p>
      <p>Block 10: 53</p>
      <p>Block 11: 45</p>
      <p>Block 12: 57</p>
      <p>Block 13: 50</p>
      <p>Block 14: 14</p>
      <p>Block 15: 37</p>
    </td>
    <td>
      <p>Block 16: 58</p>
      <p>Block 17: 39</p>
      <p>Block 18: 60</p>
      <p>Block 19: 54</p>
      <p>Block 20: 42</p>
      <p>Block 21: 35</p>
      <p>Block 22: 48</p>
      <p>Block 23: 34</p>
      <p>Block 24: 7</p>
      <p>Block 25: 33</p>
      <p>Block 26: 0</p>
      <p>Block 27: 24</p>
      <p>Block 28: 63</p>
      <p>Block 29: 36</p>
      <p>Block 30: 31</p>
      <p>Block 31: 20</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>43</p>
      <p><b>Cache Miss Count</b></p>
      <p>213</p>
      <p><b>Cache Hit Rate</b></p>
      <p>43/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>213/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>134.957ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>38389.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>7</td>
    <td>
      <p>Block 0: 25</p>
      <p>Block 1: 32</p>
      <p>Block 2: 1</p>
      <p>Block 3: 53</p>
      <p>Block 4: 42</p>
      <p>Block 5: 47</p>
      <p>Block 6: 10</p>
      <p>Block 7: 14</p>
      <p>Block 8: 52</p>
      <p>Block 9: 63</p>
      <p>Block 10: 55</p>
      <p>Block 11: 4</p>
      <p>Block 12: 62</p>
      <p>Block 13: 49</p>
      <p>Block 14: 19</p>
      <p>Block 15: 45</p>
    </td>
    <td>
      <p>Block 16: 57</p>
      <p>Block 17: 54</p>
      <p>Block 18: 58</p>
      <p>Block 19: 61</p>
      <p>Block 20: 59</p>
      <p>Block 21: 8</p>
      <p>Block 22: 56</p>
      <p>Block 23: 44</p>
      <p>Block 24: 60</p>
      <p>Block 25: 6</p>
      <p>Block 26: 29</p>
      <p>Block 27: 16</p>
      <p>Block 28: 48</p>
      <p>Block 29: 11</p>
      <p>Block 30: 26</p>
      <p>Block 31: 51</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>39</p>
      <p><b>Cache Miss Count</b></p>
      <p>217</p>
      <p><b>Cache Hit Rate</b></p>
      <p>39/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>217/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>137.4727ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>39033.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>8</td>
    <td>
      <p>Block 0: 17</p>
      <p>Block 1: 58</p>
      <p>Block 2: 8</p>
      <p>Block 3: 54</p>
      <p>Block 4: 57</p>
      <p>Block 5: 48</p>
      <p>Block 6: 38</p>
      <p>Block 7: 62</p>
      <p>Block 8: 61</p>
      <p>Block 9: 59</p>
      <p>Block 10: 40</p>
      <p>Block 11: 47</p>
      <p>Block 12: 39</p>
      <p>Block 13: 31</p>
      <p>Block 14: 30</p>
      <p>Block 15: 52</p>
    </td>
    <td>
      <p>Block 16: 63</p>
      <p>Block 17: 51</p>
      <p>Block 18: 55</p>
      <p>Block 19: 45</p>
      <p>Block 20: 49</p>
      <p>Block 21: 19</p>
      <p>Block 22: 50</p>
      <p>Block 23: 60</p>
      <p>Block 24: 53</p>
      <p>Block 25: 26</p>
      <p>Block 26: 44</p>
      <p>Block 27: 46</p>
      <p>Block 28: 32</p>
      <p>Block 29: 7</p>
      <p>Block 30: 12</p>
      <p>Block 31: 24</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>33</p>
      <p><b>Cache Miss Count</b></p>
      <p>223</p>
      <p><b>Cache Hit Rate</b></p>
      <p>33/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>223/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>141.2461ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>39999.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>9</td>
    <td>
      <p>Block 0: 59</p>
      <p>Block 1: 47</p>
      <p>Block 2: 35</p>
      <p>Block 3: 41</p>
      <p>Block 4: 62</p>
      <p>Block 5: 60</p>
      <p>Block 6: 26</p>
      <p>Block 7: 52</p>
      <p>Block 8: 56</p>
      <p>Block 9: 45</p>
      <p>Block 10: 24</p>
      <p>Block 11: 46</p>
      <p>Block 12: 57</p>
      <p>Block 13: 54</p>
      <p>Block 14: 18</p>
      <p>Block 15: 6</p>
    </td>
    <td>
      <p>Block 16: 36</p>
      <p>Block 17: 31</p>
      <p>Block 18: 32</p>
      <p>Block 19: 48</p>
      <p>Block 20: 50</p>
      <p>Block 21: 53</p>
      <p>Block 22: 61</p>
      <p>Block 23: 49</p>
      <p>Block 24: 58</p>
      <p>Block 25: 63</p>
      <p>Block 26: 55</p>
      <p>Block 27: 17</p>
      <p>Block 28: 38</p>
      <p>Block 29: 19</p>
      <p>Block 30: 43</p>
      <p>Block 31: 51</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>39</p>
      <p><b>Cache Miss Count</b></p>
      <p>217</p>
      <p><b>Cache Hit Rate</b></p>
      <p>39/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>217/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>137.4727ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>39033.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>10</td>
    <td>
      <p>Block 0: 28</p>
      <p>Block 1: 55</p>
      <p>Block 2: 33</p>
      <p>Block 3: 46</p>
      <p>Block 4: 16</p>
      <p>Block 5: 60</p>
      <p>Block 6: 41</p>
      <p>Block 7: 61</p>
      <p>Block 8: 21</p>
      <p>Block 9: 38</p>
      <p>Block 10: 53</p>
      <p>Block 11: 51</p>
      <p>Block 12: 26</p>
      <p>Block 13: 54</p>
      <p>Block 14: 31</p>
      <p>Block 15: 59</p>
    </td>
    <td>
      <p>Block 16: 42</p>
      <p>Block 17: 58</p>
      <p>Block 18: 22</p>
      <p>Block 19: 52</p>
      <p>Block 20: 63</p>
      <p>Block 21: 17</p>
      <p>Block 22: 62</p>
      <p>Block 23: 50</p>
      <p>Block 24: 44</p>
      <p>Block 25: 45</p>
      <p>Block 26: 47</p>
      <p>Block 27: 39</p>
      <p>Block 28: 4</p>
      <p>Block 29: 10</p>
      <p>Block 30: 57</p>
      <p>Block 31: 27</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Count</b></p>
      <p>49</p>
      <p><b>Cache Miss Count</b></p>
      <p>207</p>
      <p><b>Cache Hit Rate</b></p>
      <p>49/256</p>
      <p><b>Cache Miss Rate</b></p>
      <p>207/256</p>
      <p><b>Average Memory Access Time</b></p>
      <p>131.1836ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>37423.0ns</p>
    </td>
  </tr>
</table>

<p>Based on the collected data as seen in Table 1, the number of cache hits consistently falls within the range of 30 to 60, yet it remains susceptible to fluctuations outside this range due to the unpredictable nature of the randomized algorithm used in the  cache Block replacement. The replacement process, which is randomized, introduces variability to both the average access time and the total access time. Despite minor variations in the recorded data for average access time and total access time, these differences do not appear to be outliers based on visual inspection.</p>

<p>The sequential block and randomized algorithm combination introduces uncertainty regarding the persistence or replacement of specific blocks as the iteration progresses through the range of 0 to 63 that is repeated 4 times. This uncertainty contributes to an increased occurrence of cache misses, given the unpredictable nature of the replacement algorithm and the lack of assurance regarding the retention or replacement of specific blocks within the sequence.</p>

## Random Sequence
<p>The Random Sequence has 4<i>n</i> blocks, where <i>n</i> is the number of cache blocks. The number of cache blocks is always 32. Therefore in total, there will always be 128 blocks found in the Random Sequence input. When selecting the Random Sequence option, the user will input a positive integer <i>x</i>. The numbers from the random number generator would only range from 0 to <i>x</i>-1. This gives an <i>x</i> amount of unique numbers to randomly choose from. The random number generator function used is from java.util.Random.  The Random class alters 48-bits through a linear congruential formula, which it then uses the result as a seed (Knuth, 1970).</p>

<p>One thing to note about the Random Sequence is that when the <i>x</i> or the range increases, the hit rate usually decreases. Since there are more unique numbers for the number generator to choose from, the likelihood for it to choose the same number that is present in the cache decreases. For example let us compare Case A and Case B. Case A has an <i>x</i> equal to 200, meaning that the random number generator has a range from 0 to 199. Case B has an <i>x</i> equal to 500, a range from  0 to 499. Assuming the current cache is full, there should be 32 out of the 200 unique numbers in the cache of Case A and 32 out of the 500 unique numbers for Case B. </p>

<p>When the next random input is read, Case A has a 32/200 or 16% chance to have a hit. Case B on the other hand has a 32/500 or a 6.4%.  With this in mind Case B has a lesser chance of having a hit than Case A simply because it has a bigger <i>x</i>. Of course, this is still up to chance. The input sequence of Case A could have all unique numbers leading to 128 misses, while Case B could have a miniscule chance of having all 128 numbers equal to the same thing leading to 127 hits and 1 miss. The tables below shows three test cases each for Case A and B that display this behavior.</p>

<p align=center><b>Table 2. Random Sequence Test Cases (Case A)</b></p>
<table align=center>
  <tr>
    <th>Test Case</th>
    <th colspan="2">Final Snapshot</th>
    <th>Output</th>
  </tr>
  <tr>
    <td align=center>1</td>
    <td>
      <p>Block 0: 166</p>
      <p>Block 1: 74</p>
      <p>Block 2: 87</p>
      <p>Block 3: 82</p>
      <p>Block 4: 27</p>
      <p>Block 5: 84</p>
      <p>Block 6: 165</p>
      <p>Block 7: 35</p>
      <p>Block 8: 180</p>
      <p>Block 9: 25</p>
      <p>Block 10: 146</p>
      <p>Block 11: 156</p>
      <p>Block 12: 67</p>
      <p>Block 13: 111</p>
      <p>Block 14: 170</p>
      <p>Block 15: 135</p>
    </td>
    <td>
      <p>Block 16: 9</p>
      <p>Block 17: 178</p>
      <p>Block 18: 153</p>
      <p>Block 19: 140</p>
      <p>Block 20: 42</p>
      <p>Block 21: 39</p>
      <p>Block 22: 142</p>
      <p>Block 23: 199</p>
      <p>Block 24: 186</p>
      <p>Block 25: 108</p>
      <p>Block 26: 30</p>
      <p>Block 27: 164</p>
      <p>Block 28: 143</p>
      <p>Block 29: 77</p>
      <p>Block 30: 195</p>
      <p>Block 31: 36</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>22</p>
      <p><b>Cache Miss Count</b></p>
      <p>106</p>
      <p><b>Cache Hit Rate</b></p>
      <p>22/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>106/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>134.3281ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>19114.0ns</p>
    </td>
  </tr>
  <tr bg="white">
    <td align=center>2</td>
    <td>
      <p>Block 0: 107</p>
      <p>Block 1: 42</p>
      <p>Block 2: 187</p>
      <p>Block 3: 174</p>
      <p>Block 4: 186</p>
      <p>Block 5: 198</p>
      <p>Block 6: 77</p>
      <p>Block 7: 138</p>
      <p>Block 8: 148</p>
      <p>Block 9: 26</p>
      <p>Block 10: 153</p>
      <p>Block 11: 158</p>
      <p>Block 12: 137</p>
      <p>Block 13: 66</p>
      <p>Block 14: 59</p>
      <p>Block 15: 197</p>
    </td>
    <td>
      <p>Block 16: 38</p>
      <p>Block 17: 185</p>
      <p>Block 18: 31</p>
      <p>Block 19: 11</p>
      <p>Block 20: 95</p>
      <p>Block 21: 2</p>
      <p>Block 22: 4</p>
      <p>Block 23: 125</p>
      <p>Block 24: 18</p>
      <p>Block 25: 133</p>
      <p>Block 26: 152</p>
      <p>Block 27: 43</p>
      <p>Block 28: 8</p>
      <p>Block 29: 89</p>
      <p>Block 30: 143</p>
      <p>Block 31: 101</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>17</p>
      <p><b>Cache Miss Count</b></p>
      <p>111</p>
      <p><b>Cache Hit Rate</b></p>
      <p>17/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>111/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>140.6172ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>19919.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>3</td>
    <td>
      <p>Block 0: 8</p>
      <p>Block 1: 180</p>
      <p>Block 2: 10</p>
      <p>Block 3: 109</p>
      <p>Block 4: 162</p>
      <p>Block 5: 59</p>
      <p>Block 6: 24</p>
      <p>Block 7: 127</p>
      <p>Block 8: 92</p>
      <p>Block 9: 173</p>
      <p>Block 10: 126</p>
      <p>Block 11: 21</p>
      <p>Block 12: 91</p>
      <p>Block 13: 65</p>
      <p>Block 14: 104</p>
      <p>Block 15: 97</p>
    </td>
    <td>
      <p>Block 16: 78</p>
      <p>Block 17: 113</p>
      <p>Block 18: 30</p>
      <p>Block 19: 110</p>
      <p>Block 20: 100</p>
      <p>Block 21: 172</p>
      <p>Block 22: 176</p>
      <p>Block 23: 86</p>
      <p>Block 24: 71</p>
      <p>Block 25: 16</p>
      <p>Block 26: 49</p>
      <p>Block 27: 101</p>
      <p>Block 28: 139</p>
      <p>Block 29: 23</p>
      <p>Block 30: 99</p>
      <p>Block 31: 197</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>12</p>
      <p><b>Cache Miss Count</b></p>
      <p>116</p>
      <p><b>Cache Hit Rate</b></p>
      <p>12/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>116/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>146.9063ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>20724.0ns</p>
    </td>
  </tr>
</table>

<p align=center><b>Table 3. Random Sequence Test Cases (Case B)</b></p>
<table align=center>
  <tr>
    <th>Test Case</th>
    <th colspan="2">Final Snapshot</th>
    <th>Output</th>
  </tr>
  <tr>
    <td align=center>1</td>
    <td>
      <p>Block 0: 301</p>
      <p>Block 1: 33</p>
      <p>Block 2: 207</p>
      <p>Block 3: 274</p>
      <p>Block 4: 354</p>
      <p>Block 5: 491</p>
      <p>Block 6: 328</p>
      <p>Block 7: 295</p>
      <p>Block 8: 162</p>
      <p>Block 9: 321</p>
      <p>Block 10: 478</p>
      <p>Block 11: 235</p>
      <p>Block 12: 463</p>
      <p>Block 13: 410</p>
      <p>Block 14: 131</p>
      <p>Block 15: 292</p>
    </td>
    <td>
      <p>Block 16: 439</p>
      <p>Block 17: 26</p>
      <p>Block 18: 258</p>
      <p>Block 19: 389</p>
      <p>Block 20: 429</p>
      <p>Block 21: 384</p>
      <p>Block 22: 34</p>
      <p>Block 23: 22</p>
      <p>Block 24: 160</p>
      <p>Block 25: 498</p>
      <p>Block 26: 342</p>
      <p>Block 27: 370</p>
      <p>Block 28: 44</p>
      <p>Block 29: 175</p>
      <p>Block 30: 157</p>
      <p>Block 31: 194</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>7</p>
      <p><b>Cache Miss Count</b></p>
      <p>121</p>
      <p><b>Cache Hit Rate</b></p>
      <p>7/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>121/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>153.1953ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>21529.0ns</p>
    </td>
  </tr>
  <tr bg="white">
    <td align=center>2</td>
    <td>
      <p>Block 0: 303</p>
      <p>Block 1: 471</p>
      <p>Block 2: 8</p>
      <p>Block 3: 494</p>
      <p>Block 4: 0</p>
      <p>Block 5: 54</p>
      <p>Block 6: 469</p>
      <p>Block 7: 483</p>
      <p>Block 8: 226</p>
      <p>Block 9: 61</p>
      <p>Block 10: 183</p>
      <p>Block 11: 156</p>
      <p>Block 12: 437</p>
      <p>Block 13: 257</p>
      <p>Block 14: 289</p>
      <p>Block 15: 392</p>
    </td>
    <td>
      <p>Block 16: 65</p>
      <p>Block 17: 419</p>
      <p>Block 18: 315</p>
      <p>Block 19: 481</p>
      <p>Block 20: 368</p>
      <p>Block 21: 194</p>
      <p>Block 22: 394</p>
      <p>Block 23: 465</p>
      <p>Block 24: 159</p>
      <p>Block 25: 413</p>
      <p>Block 26: 301</p>
      <p>Block 27: 182</p>
      <p>Block 28: 242</p>
      <p>Block 29: 499</p>
      <p>Block 30: 449</p>
      <p>Block 31: 269</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>6</p>
      <p><b>Cache Miss Count</b></p>
      <p>122</p>
      <p><b>Cache Hit Rate</b></p>
      <p>6/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>122/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>154.4531ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>21690.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>3</td>
    <td>
      <p>Block 0: 291</p>
      <p>Block 1: 462</p>
      <p>Block 2: 349</p>
      <p>Block 3: 324</p>
      <p>Block 4: 332</p>
      <p>Block 5: 257</p>
      <p>Block 6: 472</p>
      <p>Block 7: 45</p>
      <p>Block 8: 453</p>
      <p>Block 9: 277</p>
      <p>Block 10: 43</p>
      <p>Block 11: 440</p>
      <p>Block 12: 342</p>
      <p>Block 13: 333</p>
      <p>Block 14: 178</p>
      <p>Block 15: 344</p>
    </td>
    <td>
      <p>Block 16: 99</p>
      <p>Block 17: 355</p>
      <p>Block 18: 419</p>
      <p>Block 19: 194</p>
      <p>Block 20: 146</p>
      <p>Block 21: 358</p>
      <p>Block 22: 77</p>
      <p>Block 23: 289</p>
      <p>Block 24: 488</p>
      <p>Block 25: 84</p>
      <p>Block 26: 387</p>
      <p>Block 27: 316</p>
      <p>Block 28: 393</p>
      <p>Block 29: 115</p>
      <p>Block 30: 356</p>
      <p>Block 31: 244</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>7</p>
      <p><b>Cache Miss Count</b></p>
      <p>121</p>
      <p><b>Cache Hit Rate</b></p>
      <p>7/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>121/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>153.1953ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>21529.0ns</p>
    </td>
  </tr>
</table>

<p>As seen in the two tables, Case A has an average of 17 hits per run, while Case B has an average of 6.67 hits per run. This shows that as the range increases hit rate decreases in random sequencing.</p>

<p>Another thing to note is that the cache may not be filled up after a run. For example if the range is less than 32, even if all the unique numbers have been used, there is not enough to fill up the cache. For example, the <i>x</i> is 10, which is from 0 to 9. There are only 10 unique numbers to choose from and only a maximum of ten spaces would be filled up since there will be no repeats in a cache. There is also a chance that not all the blocks in the cache are filled up even when the range is equal or greater than 32. For example, the <i>x</i> is 100 which is from 0 to 90, but all the numbers found in the input sequence are from 40 to 59. Therefore only 20 out of the 32 cache blocks would be filled up in this case The table below shows one test case of <i>x</i> < 32 and one test case where <i>x</i> > 32.</p>

<p align=center><b>Table 4. Random Sequence Test Cases (Unfilled Cache)</b></p>
<table align=center>
  <tr>
    <th>Test Case</th>
    <th colspan="2">Final Snapshot</th>
    <th>Output</th>
  </tr>
  <tr>
    <td align=center>
      <p><i>x</i> < 32</p>
      <p><i>x</i> = 20</p>
    </td>
    <td>
      <p>Block 0: 14</p>
      <p>Block 1: 3</p>
      <p>Block 2: 7</p>
      <p>Block 3: 18</p>
      <p>Block 4: 16</p>
      <p>Block 5: 6</p>
      <p>Block 6: 8</p>
      <p>Block 7: 19</p>
      <p>Block 8: 11</p>
      <p>Block 9: 5</p>
      <p>Block 10: 9</p>
      <p>Block 11: 13</p>
      <p>Block 12: 10</p>
      <p>Block 13: 4</p>
      <p>Block 14: 17</p>
      <p>Block 15: 12</p>
    </td>
    <td>
      <p>Block 16: 2</p>
      <p>Block 17: 0</p>
      <p>Block 18: 1</p>
      <p>Block 19: 15</p>
      <p>Block 20: null</p>
      <p>Block 21: null</p>
      <p>Block 22: null</p>
      <p>Block 23: null</p>
      <p>Block 24: null</p>
      <p>Block 25: null</p>
      <p>Block 26: null</p>
      <p>Block 27: null</p>
      <p>Block 28: null</p>
      <p>Block 29: null</p>
      <p>Block 30: null</p>
      <p>Block 31: null</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>108</p>
      <p><b>Cache Miss Count</b></p>
      <p>20</p>
      <p><b>Cache Hit Rate</b></p>
      <p>108/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>20/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>26.1563ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>5268.0ns</p>
    </td>
  </tr>
  <tr bg="white">
    <td align=center>
      <p><i>x</i> > 32</p>
      <p><i>x</i> = 33</p>
    </td>
    <td>
      <p>Block 0: 32
      <p>Block 1: 27
      <p>Block 2: 29
      <p>Block 3: 21
      <p>Block 4: 1
      <p>Block 5: 23
      <p>Block 6: 10
      <p>Block 7: 3
      <p>Block 8: 18
      <p>Block 9: 0
      <p>Block 10: 24
      <p>Block 11: 16
      <p>Block 12: 13
      <p>Block 13: 15
      <p>Block 14: 7
      <p>Block 15: 11
    </td>
    <td>
      <p>Block 16: 22
      <p>Block 17: 20
      <p>Block 18: 5
      <p>Block 19: 12
      <p>Block 20: 28
      <p>Block 21: 8
      <p>Block 22: 26
      <p>Block 23: 25
      <p>Block 24: 30
      <p>Block 25: 31
      <p>Block 26: 14
      <p>Block 27: 6
      <p>Block 28: 9
      <p>Block 29: 17
      <p>Block 30: null
      <p>Block 31: null
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>128</p>
      <p><b>Cache Hit Count</b></p>
      <p>98</p>
      <p><b>Cache Miss Count</b></p>
      <p>30</p>
      <p><b>Cache Hit Rate</b></p>
      <p>98/128</p>
      <p><b>Cache Miss Rate</b></p>
      <p>30/128</p>
      <p><b>Average Memory Access Time</b></p>
      <p>38.7344ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>6878.0ns</p>
    </td>
  </tr>
</table>

## Mid-repeat Blocks

<p>Below is the mid-repeat blocks sequence in the main memory. Note that `highlighted` numbers indicate a hit.</p>

0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,` 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,

0, `1,` 2, 3, 4, `5, 6,` 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, `19, 20,` 21, 22, 23, 24, 25, `26, 27,` 28, `29,` 30, 1, `2,` 3, `4,` 5, `6,` 7, 8, 9, 10, `11, 12,` 13, 14, 15, `16, 17,` 18, `19, 20,` 21, 22, `23, 24,` 25, `26,` 27, `28,` 29, `30,` 31, 32, 33, 34, `35,` 36, 37, 38, 39, 40, 41, 42, `43, 44, 45,` 46, 47, 48, 49, 50, 51, `52,` 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 

0, 1, `2,` 3, 4, 5, 6, 7, `8,` 9, 10, 11, 12, `13,` 14, 15, 16, 17, 18, `19,` 20, `21,` 22, 23, 24, 25, 26, 27, `28, 29, 30, 1, 2,` 3, 4, `5,` 6, 7, `8, 9,` 10, 11, `12, 13,` 14, `15,` 16, 17, 18, `19, 20, 21,` 22, 23, `24,` 25, `26,` 27, `28, 29,` 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, `47,` 48, 49, 50, 51, 52, `53,` 54, 55, 56, 57, 58, `59,` 60, 61, `62,` 63, 

0, `1,` 2, 3, 4, 5, 6, 7, 8, 9, 10, `11,` 12, `13,` 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 1, 2, 3, `4, 5, 6, 7,` 8, `9, 10, 11, 12, 13, 14, 15,` 16, `17,` 18, `19, 20,` 21, 22, 23, `24,` 25, `26, 27, 28, 29, 30,` 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, `63` 

<p>We can see here that the blocks went 0 to 30, 1 to 63, 0 to 30, 1 to 63,  0 to 30, 1 to 63, 0 to 30, and another 1 to 63.
Just like the specifications, the sequence starts at  0 then it repeats the sequence 1-30 twice then it continues the second one till 63. This was then repeated 4 times.</p>

<p>At the start, we can see that while it was filling the cache blocks, they were all misses. However the next part of the sequence where it repeats from 1 to <i>n</i>-1 fills 1-30 with hits, and 31 to 63 with misses as they have not been placed in the cache before. After this, the remaining iterations are filled with random misses and hits due to the random replacement algorithm of the simulation. To demonstrate this further, Table 5 below displays a total of ten test cases for the mid-repeat blocks.</p>

<p align=center><b>Table 5. Mid-repeat Blocks Test Cases</b></p>
<table align=center>
  <tr>
    <th>Test Case</th>
    <th colspan="2">Final Snapshot</th>
    <th>Output</th>
  </tr>
  <tr>
    <td align=center>1</td>
    <td>
      <p>Block 0: 54</p>
      <p>Block 1: 44</p>
      <p>Block 2: 38</p>
      <p>Block 3: 13</p>
      <p>Block 4: 55</p>
      <p>Block 5: 58</p>
      <p>Block 6: 4</p>
      <p>Block 7: 48</p>
      <p>Block 8: 40</p>
      <p>Block 9: 59</p>
      <p>Block 10: 18</p>
      <p>Block 11: 30</p>
      <p>Block 12: 37</p>
      <p>Block 13: 63</p>
      <p>Block 14: 9</p>
      <p>Block 15: 61</p>
    </td>
    <td>
      <p>Block 16: 56</p>
      <p>Block 17: 41</p>
      <p>Block 18: 26</p>
      <p>Block 19: 12</p>
      <p>Block 20: 53</p>
      <p>Block 21: 33</p>
      <p>Block 22: 35</p>
      <p>Block 23: 19</p>
      <p>Block 24: 57</p>
      <p>Block 25: 51</p>
      <p>Block 26: 34</p>
      <p>Block 27: 10</p>
      <p>Block 28: 45</p>
      <p>Block 29: 60</p>
      <p>Block 30: 62</p>
      <p>Block 31: 16</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>113</p>
      <p><b>Cache Miss Count</b></p>
      <p>263</p>
      <p><b>Cache Hit Rate</b></p>
      <p>113/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>263/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>113.6144ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48359.0ns</p>
    </td>
  </tr>
  <tr bg=white>
    <td align=center>2</td>
    <td>
      <p>Block 0: 62</p>
      <p>Block 1: 60</p>
      <p>Block 2: 59</p>
      <p>Block 3: 54</p>
      <p>Block 4: 31</p>
      <p>Block 5: 32</p>
      <p>Block 6: 47</p>
      <p>Block 7: 15</p>
      <p>Block 8: 3</p>
      <p>Block 9: 33</p>
      <p>Block 10: 1</p>
      <p>Block 11: 21</p>
      <p>Block 12: 57</p>
      <p>Block 13: 10</p>
      <p>Block 14: 43</p>
      <p>Block 15: 11</p>
    </td>
    <td>
      <p>Block 16: 56</p>
      <p>Block 17: 46</p>
      <p>Block 18: 38</p>
      <p>Block 19: 20</p>
      <p>Block 20: 4</p>
      <p>Block 21: 48</p>
      <p>Block 22: 55</p>
      <p>Block 23: 26</p>
      <p>Block 24: 61</p>
      <p>Block 25: 44</p>
      <p>Block 26: 49</p>
      <p>Block 27: 58</p>
      <p>Block 28: 30</p>
      <p>Block 29: 50</p>
      <p>Block 30: 63</p>
      <p>Block 31: 40</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>113</p>
      <p><b>Cache Miss Count</b></p>
      <p>263</p>
      <p><b>Cache Hit Rate</b></p>
      <p>113/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>263/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>113.6144ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48359.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>3</td>
    <td>
      <p>Block 0: 28</p>
      <p>Block 1: 31</p>
      <p>Block 2: 41</p>
      <p>Block 3: 61</p>
      <p>Block 4: 55</p>
      <p>Block 5: 29</p>
      <p>Block 6: 25</p>
      <p>Block 7: 33</p>
      <p>Block 8: 62</p>
      <p>Block 9: 21</p>
      <p>Block 10: 44</p>
      <p>Block 11: 40</p>
      <p>Block 12: 3</p>
      <p>Block 13: 10</p>
      <p>Block 14: 9</p>
      <p>Block 15: 60</p>
    </td>
    <td>
      <p>Block 16: 32</p>
      <p>Block 17: 43</p>
      <p>Block 18: 48</p>
      <p>Block 19: 23</p>
      <p>Block 20: 2</p>
      <p>Block 21: 53</p>
      <p>Block 22: 6</p>
      <p>Block 23: 38</p>
      <p>Block 24: 8</p>
      <p>Block 25: 58</p>
      <p>Block 26: 56</p>
      <p>Block 27: 26</p>
      <p>Block 28: 22</p>
      <p>Block 29: 50</p>
      <p>Block 30: 63</p>
      <p>Block 31: 4</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>120</p>
      <p><b>Cache Miss Count</b></p>
      <p>256</p>
      <p><b>Cache Hit Rate</b></p>
      <p>120/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>256/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>110.617ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>47232.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>4</td>
    <td>
      <p>Block 0: 35</p>
      <p>Block 1: 43</p>
      <p>Block 2: 26</p>
      <p>Block 3: 50</p>
      <p>Block 4: 6</p>
      <p>Block 5: 49</p>
      <p>Block 6: 62</p>
      <p>Block 7: 25</p>
      <p>Block 8: 37</p>
      <p>Block 9: 60</p>
      <p>Block 10: 5</p>
      <p>Block 11: 31</p>
      <p>Block 12: 59</p>
      <p>Block 13: 36</p>
      <p>Block 14: 34</p>
      <p>Block 15: 47</p>
    </td>
    <td>
      <p>Block 16: 56</p>
      <p>Block 17: 48</p>
      <p>Block 18: 32</p>
      <p>Block 19: 61</p>
      <p>Block 20: 38</p>
      <p>Block 21: 57</p>
      <p>Block 22: 52</p>
      <p>Block 23: 24</p>
      <p>Block 24: 58</p>
      <p>Block 25: 41</p>
      <p>Block 26: 20</p>
      <p>Block 27: 63</p>
      <p>Block 28: 29</p>
      <p>Block 29: 55</p>
      <p>Block 30: 51</p>
      <p>Block 31: 27</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>111</p>
      <p><b>Cache Miss Count</b></p>
      <p>265</p>
      <p><b>Cache Hit Rate</b></p>
      <p>111/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>265/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>114.4707ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48681.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>5</td>
    <td>
      <p>Block 0: 52</p>
      <p>Block 1: 49</p>
      <p>Block 2: 59</p>
      <p>Block 3: 61</p>
      <p>Block 4: 53</p>
      <p>Block 5: 51</p>
      <p>Block 6: 54</p>
      <p>Block 7: 63</p>
      <p>Block 8: 19</p>
      <p>Block 9: 57</p>
      <p>Block 10: 41</p>
      <p>Block 11: 18</p>
      <p>Block 12: 7</p>
      <p>Block 13: 55</p>
      <p>Block 14: 47</p>
      <p>Block 15: 23</p>
    </td>
    <td>
      <p>Block 16: 16</p>
      <p>Block 17: 38</p>
      <p>Block 18: 33</p>
      <p>Block 19: 58</p>
      <p>Block 20: 29</p>
      <p>Block 21: 56</p>
      <p>Block 22: 62</p>
      <p>Block 23: 60</p>
      <p>Block 24: 50</p>
      <p>Block 25: 0</p>
      <p>Block 26: 45</p>
      <p>Block 27: 24</p>
      <p>Block 28: 46</p>
      <p>Block 29: 48</p>
      <p>Block 30: 44</p>
      <p>Block 31: 15</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>114</p>
      <p><b>Cache Miss Count</b></p>
      <p>262</p>
      <p><b>Cache Hit Rate</b></p>
      <p>114/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>262/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>113.1862ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48198.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>6</td>
    <td>
      <p>Block 0: 24</p>
      <p>Block 1: 50</p>
      <p>Block 2: 19</p>
      <p>Block 3: 47</p>
      <p>Block 4: 57</p>
      <p>Block 5: 61</p>
      <p>Block 6: 58</p>
      <p>Block 7: 46</p>
      <p>Block 8: 15</p>
      <p>Block 9: 45</p>
      <p>Block 10: 56</p>
      <p>Block 11: 63</p>
      <p>Block 12: 10</p>
      <p>Block 13: 54</p>
      <p>Block 14: 4</p>
      <p>Block 15: 12</p>
    </td>
    <td>
      <p>Block 16: 60</p>
      <p>Block 17: 44</p>
      <p>Block 18: 59</p>
      <p>Block 19: 52</p>
      <p>Block 20: 23</p>
      <p>Block 21: 55</p>
      <p>Block 22: 62</p>
      <p>Block 23: 33</p>
      <p>Block 24: 41</p>
      <p>Block 25: 34</p>
      <p>Block 26: 20</p>
      <p>Block 27: 51</p>
      <p>Block 28: 1</p>
      <p>Block 29: 35</p>
      <p>Block 30: 6</p>
      <p>Block 31: 22</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>118</p>
      <p><b>Cache Miss Count</b></p>
      <p>258</p>
      <p><b>Cache Hit Rate</b></p>
      <p>118/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>258/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>111.4734ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>47554.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>7</td>
    <td>
      <p>Block 0: 6</p>
      <p>Block 1: 29</p>
      <p>Block 2: 35</p>
      <p>Block 3: 3</p>
      <p>Block 4: 46</p>
      <p>Block 5: 60</p>
      <p>Block 6: 48</p>
      <p>Block 7: 57</p>
      <p>Block 8: 49</p>
      <p>Block 9: 61</p>
      <p>Block 10: 45</p>
      <p>Block 11: 50</p>
      <p>Block 12: 51</p>
      <p>Block 13: 52</p>
      <p>Block 14: 17</p>
      <p>Block 15: 24</p>
    </td>
    <td>
      <p>Block 16: 63</p>
      <p>Block 17: 53</p>
      <p>Block 18: 19</p>
      <p>Block 19: 56</p>
      <p>Block 20: 54</p>
      <p>Block 21: 47</p>
      <p>Block 22: 27</p>
      <p>Block 23: 32</p>
      <p>Block 24: 59</p>
      <p>Block 25: 2</p>
      <p>Block 26: 42</p>
      <p>Block 27: 41</p>
      <p>Block 28: 33</p>
      <p>Block 29: 62</p>
      <p>Block 30: 43</p>
      <p>Block 31: 58</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>111</p>
      <p><b>Cache Miss Count</b></p>
      <p>265</p>
      <p><b>Cache Hit Rate</b></p>
      <p>111/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>265/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>114.4707ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48681.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>8</td>
    <td>
      <p>Block 0: 46</p>
      <p>Block 1: 45</p>
      <p>Block 2: 60</p>
      <p>Block 3: 30</p>
      <p>Block 4: 25</p>
      <p>Block 5: 36</p>
      <p>Block 6: 62</p>
      <p>Block 7: 4</p>
      <p>Block 8: 54</p>
      <p>Block 9: 48</p>
      <p>Block 10: 35</p>
      <p>Block 11: 31</p>
      <p>Block 12: 41</p>
      <p>Block 13: 6</p>
      <p>Block 14: 61</p>
      <p>Block 15: 14</p>
    </td>
    <td>
      <p>Block 16: 39</p>
      <p>Block 17: 47</p>
      <p>Block 18: 18</p>
      <p>Block 19: 59</p>
      <p>Block 20: 16</p>
      <p>Block 21: 40</p>
      <p>Block 22: 27</p>
      <p>Block 23: 23</p>
      <p>Block 24: 11</p>
      <p>Block 25: 26</p>
      <p>Block 26: 52</p>
      <p>Block 27: 57</p>
      <p>Block 28: 44</p>
      <p>Block 29: 49</p>
      <p>Block 30: 63</p>
      <p>Block 31: 56</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>110</p>
      <p><b>Cache Miss Count</b></p>
      <p>266</p>
      <p><b>Cache Hit Rate</b></p>
      <p>110/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>266/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>114.8989ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48842.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>9</td>
    <td>
      <p>Block 0: 51</p>
      <p>Block 1: 12</p>
      <p>Block 2: 59</p>
      <p>Block 3: 36</p>
      <p>Block 4: 43</p>
      <p>Block 5: 60</p>
      <p>Block 6: 31</p>
      <p>Block 7: 33</p>
      <p>Block 8: 26</p>
      <p>Block 9: 61</p>
      <p>Block 10: 44</p>
      <p>Block 11: 45</p>
      <p>Block 12: 63</p>
      <p>Block 13: 49</p>
      <p>Block 14: 25</p>
      <p>Block 15: 55</p>
    </td>
    <td>
      <p>Block 16: 53</p>
      <p>Block 17: 28</p>
      <p>Block 18: 32</p>
      <p>Block 19: 50</p>
      <p>Block 20: 58</p>
      <p>Block 21: 20</p>
      <p>Block 22: 62</p>
      <p>Block 23: 48</p>
      <p>Block 24: 27</p>
      <p>Block 25: 7</p>
      <p>Block 26: 52</p>
      <p>Block 27: 29</p>
      <p>Block 28: 56</p>
      <p>Block 29: 23</p>
      <p>Block 30: 35</p>
      <p>Block 31: 40</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>107</p>
      <p><b>Cache Miss Count</b></p>
      <p>269</p>
      <p><b>Cache Hit Rate</b></p>
      <p>107/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>269/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>116.1835ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>49325.0ns</p>
    </td>
  </tr>
  <tr>
    <td align=center>10</td>
    <td>
      <p>Block 0: 27</p>
      <p>Block 1: 55</p>
      <p>Block 2: 42</p>
      <p>Block 3: 58</p>
      <p>Block 4: 46</p>
      <p>Block 5: 32</p>
      <p>Block 6: 50</p>
      <p>Block 7: 45</p>
      <p>Block 8: 48</p>
      <p>Block 9: 26</p>
      <p>Block 10: 57</p>
      <p>Block 11: 60</p>
      <p>Block 12: 62</p>
      <p>Block 13: 10</p>
      <p>Block 14: 63</p>
      <p>Block 15: 1</p>
    </td>
    <td>
      <p>Block 16: 19</p>
      <p>Block 17: 41</p>
      <p>Block 18: 51</p>
      <p>Block 19: 35</p>
      <p>Block 20: 59</p>
      <p>Block 21: 29</p>
      <p>Block 22: 53</p>
      <p>Block 23: 52</p>
      <p>Block 24: 24</p>
      <p>Block 25: 49</p>
      <p>Block 26: 54</p>
      <p>Block 27: 61</p>
      <p>Block 28: 9</p>
      <p>Block 29: 39</p>
      <p>Block 30: 56</p>
      <p>Block 31: 18</p>
    </td>
    <td align="center">
      <p><b>Memory Access Count</b></p>
      <p>376</p>
      <p><b>Cache Hit Count</b></p>
      <p>110</p>
      <p><b>Cache Miss Count</b></p>
      <p>266</p>
      <p><b>Cache Hit Rate</b></p>
      <p>110/376</p>
      <p><b>Cache Miss Rate</b></p>
      <p>266/376</p>
      <p><b>Average Memory Access Time</b></p>
      <p>114.8989ns</p>
      <p><b>Total Memory Access Time</b></p>
      <p>48842.0ns</p>
    </td>
  </tr>
</table>

<p>We can see that overall cache hit is around 107 to 120 while overall cache miss is 256 to 269. This disparity may be because the test case has the numbers going beyond 32 which randomly replaces the blocks from 1 to 30. These blocks are frequently accessed in the cache memory, which may lead to more cache misses. It is also noted that the contents of the cache towards the end usually contain bigger numbers. This is likely because in the transfer from main memory to cache, the blocks near the end are usually 31-63, hence why they are more likely to stay in the final snapshot.</p>

## Conclusion
<p>The results of the three test cases found the following.</p>

<p>For the sequential sequence, though the number of cache hits falls within the range of 30 to 60, the randomized algorithm used in cache block replacement introduced variability that can lead to fluctuations. The unpredictable nature of the replacement algirthm then raises the chance of cache misses.</p>

<p>In the case of the random sequence, the positive integer <i>x</i> that determines the range of numbers produced affects the hit rate. As <i>x</i> increases, the hit rate tends to decrease as there are more unique numbers to choose from, reducing the likelihood of choosing a number that is already present in the cache. Moreover, it was observed that a cache may not be filled up regardless of whether it is less or more than 32. This is due to the nature of random sequencing and the size of <i>x</i>.</p>

<p>Lastly, it is observed in mid-repeat blocks that the cache is initially filled with misses. However, as the sequence repeats until <i>n</i>-1, all subsequent iterations become hits. Moving from <i>n</i>-1 to 2<i>n</i> introduces misses again as these blocks have not been placed into the cache before. The cache hit rate then starts to fluctuate due to the random replacement algorithm.</p>

## References
<p>Knuth, D. E. (1970). The art of computer programming. Volume 2:  Seminumerical algorithms. <i>American Mathematical Monthly, 77</i>(8), 900. https: //doi.org/10.2307/2317055</p>
