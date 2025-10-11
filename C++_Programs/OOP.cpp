#include<iostream>
using namespace std;

class Arithmetic
{
    public:
    int iNo1;
    int iNo2;

    Arithmetic()
    {
        iNo1 = 0;
        iNo2 = 0;
    }

    Arithmetic(int A, int B)
    {
        iNo1 = A;
        iNo2 = B;
    }

    int Addition()
    {
        int iAns = 0;
        iAns = iNo1 + iNo2;
        return iAns;
    }

    int Substraction()
    {
        int iAns = 0;
        iAns = iNo1 - iNo2;
        return iAns;
    }

};

int main()
{
    Arithmetic aobj1(11,10);

    int iRet = 0;

    iRet = aobj1.Addition();
    cout<<"Addition is : "<<iRet<<"\n";

    iRet = aobj1.Substraction();
    cout<<"Substraction is : "<<iRet<<"\n";


    return 0;
}