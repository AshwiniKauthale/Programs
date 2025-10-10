#include<stdio.h>

int main()
{
    int iValue = 11;
    char cValue = 'M';

    int *iPtr = &iValue;
    char *cPtr = &cValue;

    printf("Sizeof iptr : %lu\n", sizeof(iPtr));
    printf("Sizeof cptr : %lu\n", sizeof(cPtr));


    return 0;
}