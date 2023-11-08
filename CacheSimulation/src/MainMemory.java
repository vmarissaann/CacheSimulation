public class MainMemory {
    public Block nArray[];
    public int nCurr = 0;

    public MainMemory(int nInput[])
    {
        // initializes length of the nInput array, creating an array of Block objects.
        this.nArray = new Block[nInput.length];
        for(int i = 0; i < nArray.length; i++)
            //  initializes each element of the nArray
            //  equates to a Block element by creating a Block object
            this.nArray[i] = new Block(nInput[i]);
    }
}
class Block
{
    public int nNum = 0;
    public String cHit = "";
    // Assigns the value of nNum (passed to the constructor) to the nNum variable within the Block object.
    public Block(int nNum)
    {
        this.nNum = nNum;
    }
}
