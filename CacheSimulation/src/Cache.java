public class Cache {
    // number of cache blocks
    public int nBlock = 32;
    // number of cache lines in each cache block
    public int nCacheLine = 16;
    // array of Integer objects with size nBlock
    public Integer nArray[] = new Integer[nBlock];
}
