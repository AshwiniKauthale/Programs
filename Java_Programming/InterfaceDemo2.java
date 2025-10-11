
interface Demo
{
    int no = 11;
    void Display();
}

abstract class Hello implements Demo
{

}

class interfaceDemo2
{
    public static void main(String A[])
    {
        Hello hobj = new Hello();    //Error

    }
}