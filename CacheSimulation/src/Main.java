import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public Cache cache = new Cache();
    public MainMemory mainMemory;

    public static void main(String[] args) {
        // Random sample input
        int nInput[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 50, 30, 20, 10, 11, 1, 2, 67, 4, 100, 23, 205, 34, 512, 12, 56, 53, 2, 1, 16, 73, 267, 282, 124, 132, 23, 15};
        // Initialize all the variables
        Main main = new Main();
        main.mainMemory = new MainMemory(nInput);
        MainFrame frame = new MainFrame(main);
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
        int missCount = mainMemory.missCount();
        int hitCount = mainMemory.hitCount();
        double avgAccessTime = averageAccessTime();
        double totalAccessTime = totalAccessTime();

        try {

            PrintStream fileStream = new PrintStream(new File("output.txt"));
            System.setOut(fileStream);

            System.out.println("Memory Access Count: " + mainMemory.nArray.length);
            System.out.println("Cache Hit Count: " + hitCount);
            System.out.println("Cache Miss Count: " + missCount);
            System.out.println("Cache Hit Rate: " + hitCount + "/" + mainMemory.nArray.length);
            System.out.println("Cache Miss Rate: " + missCount + "/" + mainMemory.nArray.length);
            System.out.println("Average Memory Access Time: " + avgAccessTime + "ns");
            System.out.println("Total Memory Access Time: " + totalAccessTime + "ns");
            System.out.println();
            System.out.println("Cache Contents: ");
            for (int i = 0; i < cache.nBlock; i++) {
                System.out.println("Block " + i + ":" + cache.nArray[i]);
            }
            System.out.println();


            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double averageAccessTime (){
        double missCount = mainMemory.missCount();
        double hitCount = mainMemory.hitCount();
        double total = mainMemory.nArray.length;

        return hitCount/total + (1 + cache.nCacheLine*10 + 1)*missCount/total;
    }

    public double totalAccessTime (){
        double missCount = mainMemory.missCount();
        double hitCount = mainMemory.hitCount();
        double total = mainMemory.nArray.length;

        return hitCount + (1 + cache.nCacheLine*10 + 1)*missCount;
    }

}
