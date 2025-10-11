
class Demo
{
    public int Division(int no1,int no2)throws ArithmeticException
    {
        int Ans = 0;
        Ans = no1/no2;
        return Ans;
    }
}
class ThrowsDemo
{
    public static void main(String A[])
    {
        Demo obj = new Demo();
        int Ret = 0;

        try
        {
            Ret = obj.Division(11,0);
        }
        catch(ArithmeticException aobj)
        {
            System.out.println("Inside catch"+aobj);
        }
        System.out.println("Division is : "+Ret);

    }
}