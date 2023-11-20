# Cache Simulation Project

<p>This cache simulation project uses a <b>full associative mapping function and random replacement algorithm</b>. It uses the Random class from the Java standard library to generate a pseudo-random number that determines what cache block will be replaced. In this cache operation, the given are the following:</p>
<ul>
  <li>Number of cache blocks = 32 blocks</li>
  <li>Cache line = 16 words</li>
  <li>Read policy: non load-through</li>
</ul>
<p>The number of memory blocks are inputted by the user if required, though this was not used in our project. There are a total of three test cases for this project: <b>(1) Sequential Sequence, (2) Random Sequence</b>, and <b>(3) Mid-repeat Blocks</b>. A detailed analysis of each case is described below.</p>

## Sequential Sequence
<p>In the Sequential Sequence, the cache block pattern follows a sequence of up to 2<i>n</i> cache blocks, with <i>n</i> set as 32 cache blocks. Consequently, the pattern spans 64 cache blocks, denoted as 0, 1, 2, 3...63. Notably, this sequence repeats four times, resulting in the series 0...63, 0...63, 0...63, 0...63. Table 1 below displays a total of ten (10) test cases for the sequential sequence.
</p>

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
<p align=center><b>Table 1. Sequential Sequence Test Cases</b></p>

<p>	Based on the collected data as seen in Table 1, the number of cache hits consistently falls within the range of 30 to 60, yet it remains susceptible to fluctuations outside this range due to the unpredictable nature of the randomized algorithm used in the  cache Block replacement. The replacement process, which is randomized, introduces variability to both the average access time and the total access time. Despite minor variations in the recorded data for average access time and total access time, these differences do not appear to be outliers based on visual inspection.
</p>

<p>The sequential Block and randomized algorithm combination introduces uncertainty regarding the persistence or replacement of specific Blocks as the iteration progresses through the range of 0 to 63 that is repeated 4 times. This uncertainty contributes to an increased occurrence of cache misses, given the unpredictable nature of the replacement algorithm and the lack of assurance regarding the retention or replacement of specific Blocks within the sequence.</p>
