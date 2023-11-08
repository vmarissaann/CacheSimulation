public class MainMemory {
    public Block nArray[];
    public int nCurr = 0;

    public MainMemory(int nInput[])
    {
        this.nArray = new Block[nInput.length];
        for(int i = 0; i < nArray.length; i++)
            this.nArray[i] = new Block(nInput[i]);
    }
}
class Block
{
    public int nNum = 0;
    public String cHit = "";
    public Block(int nNum)
    {
        this.nNum = nNum;
    }
}
