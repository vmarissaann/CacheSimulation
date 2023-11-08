import java.util.concurrent.ThreadLocalRandom;

public class Main {
    // initialize Cache object
    public Cache cache = new Cache();
    // initialize MainMemory object
    public MainMemory mainMemory;

    public static void main(String[] args) {
        int nInput[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 50, 30, 20, 10, 11, 1, 2, 67, 4, 100, 23, 205, 34, 512, 12, 56, 53, 2, 1, 16, 73, 267, 282, 124, 132, 23, 15};
        Main main = new Main();
        main.mainMemory = new MainMemory(nInput);

        MainFrame frame = new MainFrame(main);
    }

    public int replaceCache()
    {
        boolean isEmpty = false, contains = false;
        int nReplace = 0, num = mainMemory.nCurr, curr = mainMemory.nArray[num].nNum;

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

        if (contains)
            mainMemory.nArray[num].cHit = "Hit";
        else
        {
            if (!isEmpty)
                nReplace = ThreadLocalRandom.current().nextInt(0, this.cache.nBlock);

            cache.nArray[nReplace] = curr;
            mainMemory.nArray[num].cHit = "Miss";
        }

        mainMemory.nCurr++;
        return nReplace;
    }

}

