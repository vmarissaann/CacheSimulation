import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private int choice;
    public Cache cache = new Cache();
    public MainMemory mainMemory;

    public static void main(String[] args) {
        Main main = new Main();
        main.startApplication();
    }

    public void startApplication() {
        // Random sample input
        Integer nInput[];
        int nInput2[];
        // Initialize all the variables

        // Set up an array of button options
        Object[] options = {"Sequential", "Random", "Mid-Repeat"};

        // Show the option dialog
        int choice = JOptionPane.showOptionDialog(
                null,                       // Parent component (null for default)
                "Please select an input from below.",       // Message to be displayed
                "Input",   // Dialog title
                JOptionPane.DEFAULT_OPTION, // Option type (default)
                JOptionPane.PLAIN_MESSAGE,  // Message type (plain)
                null,                       // Icon (null for default)
                options,                    // Options (array of buttons)
                options[0]);                // Default option

        // The choice variable now contains the index of the selected option
        // Index starts from 0, so we add 1 to get values from 1 to 3.
        int result = choice;

        ArrayList sequence = new ArrayList<Integer>();

        int count = 0;
        if (choice == 0) {
            //Condition for setting sequence
            for (int i = 0; i < 64; i++) {
                sequence.add(i);
                if (i == 63 && count != 3) {
                    i = -1;
                    count++;
                }
            }
        }
        else if (choice == 1)
        {
            Random rand = new Random();
            int countMainMemory = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter main memory block size:","Block Size", JOptionPane.PLAIN_MESSAGE));
            int int_random=0;
            for (int i=0; i<32*4;i++){
                int_random = rand.nextInt(countMainMemory);
                sequence.add(int_random);
            }
        }
        else
        {
            for (int repeat = 0; repeat < 4; repeat++) {
                // First part: 0 to n-1
                for (int i = 0; i < 32 - 1; i++) {
                    sequence.add(i);
                }

                // Second part: 1 to n-1
                for (int i = 1; i < 32 - 1; i++) {
                    sequence.add(i);
                }

                // Third part: n to 2n-1
                for (int i = 31; i <  64; i++) {
                    sequence.add(i);
                }
            }
        }

        nInput = (Integer[]) sequence.toArray(new Integer[0]);

        // Now, convert Integer array to int array
        nInput2 = Arrays.stream(nInput).mapToInt(Integer::intValue).toArray();

        Main main = new Main();
        main.choice = choice;
        main.mainMemory = new MainMemory(nInput2);
        MainFrame frame = new MainFrame(main);
    }

    public int testCase() 
    {
        return choice;
    }

    public int replaceCache()
    {
        // Boolean variables to check if there is still an empty slot in the cache or if the block is already found in the cache
        boolean isEmpty = false, contains = false;
        // nReplace = The container for the location of the cache to be replaced or found
        // num = The current number to be transferred
        // curr = The current main memory block to transfer
        int nReplace = 0, num = mainMemory.nCurr, curr = mainMemory.nArray[num].nNum;

        // Check if the number to transfer is already in the cache
        for(int i = 0; i < cache.nBlock; i++)
        {
            if (cache.nArray[i] != null) {
                if (cache.nArray[i] == curr) {
                    contains = true;
                    nReplace = i;
                    break;
                }
            }
        }

        // If it is not found then check if there are still empty slots
        if (!contains)
            for(int i = 0; i < cache.nBlock; i++)
            {
                if (cache.nArray[i] == null)
                {
                    isEmpty = true;
                    nReplace = i;
                    break;
                }
            }

        // If it is there, label it as a hit
        if (contains)
            mainMemory.nArray[num].cHit = "Hit";
        else
        {
            // If there is no empty slot then randomly replace a cache block
            if (!isEmpty)
                nReplace = ThreadLocalRandom.current().nextInt(0, this.cache.nBlock);

            // Overwrite the number into the cache block and label it as a miss
            cache.nArray[nReplace] = curr;
            mainMemory.nArray[num].cHit = "Miss";
        }

        // Increment the current counter
        mainMemory.nCurr++;
        // Return the cache location
        return nReplace;
    }

    public void outputTextFile() {
        int memoryAccessCount = memoryAccessCount();
        int missCount = missCnt();
        int hitCount = hitCnt();
        double avgAccessTime = averageAccessTime();
        double totalAccessTime = totalAccessTime();

        try {

            PrintStream fileStream = new PrintStream(new File("output.txt"));
            System.setOut(fileStream);

            System.out.println("Memory Access Count: " + memoryAccessCount);
            System.out.println("Cache Hit Count: " + hitCount);
            System.out.println("Cache Miss Count: " + missCount);
            System.out.println("Cache Hit Rate: " + hitCount + "/" + memoryAccessCount);
            System.out.println("Cache Miss Rate: " + missCount + "/" + memoryAccessCount);
            System.out.println("Average Memory Access Time: " + avgAccessTime + "ns");
            System.out.println("Total Memory Access Time: " + totalAccessTime + "ns");
            System.out.println();
            System.out.println("Cache Contents: ");
            for (int i = 0; i < cache.nBlock; i++) {
                System.out.println("Block " + i + ":" + cache.nArray[i]);
            }
            System.out.println();

            System.out.println("Input Sequence and hit/misses");
            for(int i=0; i<mainMemory.nArray.length; i++){
                System.out.println("Input " + (i+1) + ": " + mainMemory.nArray[i].nNum + " | " + mainMemory.nArray[i].cHit);
            }


            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int memoryAccessCount() {
        return mainMemory.nArray.length;
    }

    public int hitCnt() {
        return mainMemory.hitCount();
    }

    public int missCnt() {
        return mainMemory.missCount();
    }

    public double averageAccessTime() {
        double missCount = mainMemory.missCount();
        double hitCount = mainMemory.hitCount();
        double total = mainMemory.nArray.length;
    
        double result = hitCount / total + (1 + cache.nCacheLine * 10 + 1) * missCount / total;
    
        return Double.parseDouble(String.format("%.4f", result));
    }

    public double totalAccessTime (){
        double missCount = missCnt();
        double hitCount = hitCnt();

        return hitCount + (1 + cache.nCacheLine*10 + 1)*missCount;
    }


}
