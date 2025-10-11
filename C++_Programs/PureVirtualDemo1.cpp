#include<iostream>
using namespace std;

class Base
{
    public:
    int i,j;

    int Addition(int A, int B)  ///concrete
    {
        return A+B;
    }
    virtual int Substraction(int A, int B) = 0;    // Abstract

};

class Derived : public Base     // ERROR
{
    public:
    int x;

};

int main()
{
    Base *bp = new Derived();   // upcasting
    

    return 0;
}