class Demo {
    public int iN01;
    public int No2;

    public Demo() {
        System.out.println("Inside Default Constructor");
    }

    public Demo(int i, int j) {
        System.out.println("Inside Parameterised Constructor");
    }

    protected void finalize() {
        System.out.println("Inside finalize");
    }
}

class ConstructorDestructor {
    public static void main(String Arg[]) {

        Demo dobj1 = new Demo();

        Demo dobj2 = new Demo(11, 21);

        dobj1 = null;
        dobj2 = null;

        System.gc();

        System.out.println("End of main");
    }
}