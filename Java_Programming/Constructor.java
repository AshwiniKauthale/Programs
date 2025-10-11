class Demo
{
    public int iN01;
    public int No2;

    public Demo()
    {
        System.out.println("Inside Default Constructor");
    }
    public Demo(int i, int j)
    {
        System.out.println("Inside Parameterised Constructor");
    }
}




class Constructor
{
    public static void main(String Arg[])
    {
        Demo doji1 = new Demo();

        Demo dobj2 = new Demo(11,21);
    }
}