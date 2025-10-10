#include<stdio.h>

struct Demo
{
    int i;
    float f;
};

struct Hello
{
    int no;
    float marks;
    struct Demo dobj;  //Nested
};

int main()
{

    printf("Size of Hello Structure is : %lu\n",sizeof(struct Hello));



    return 0;
}