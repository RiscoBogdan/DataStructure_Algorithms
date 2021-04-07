package DataStructure_Algorithms.InternTehnicalCodingTest;
interface b{
    //metoda este abstracta => nu are body => este automat public
     public int draw(int x, int y);
    //variabilele de instanta sunt  => public static final
     public static final int x =5;
    //private => nu mai este abstract si il pot folosii doar in aceasta interfata fara sa poata fi accesat in alta parte sau suprascris.
    private static void desen() {
        System.out.println("desenez");
    }
    //by default este abstracta => public
     void method1(); // public abstract
    default void method2() { //default means i can have a body
        //we can call static methods here
        D.gmethod();
        method4();
        method5();
        System.out.println("Inside default method");
    }
    static void methodStatic(){
        System.out.println("StaticMethod");
    }
    static void method3() {
        method5();    //  static method inside other static method
        System.out.println("Inside static method");
    }
     private void method4() {    // private method
        System.out.println("Inside private method");
    }
      static void method5() {    // private static method
        System.out.println("Inside private static method");
    }
}

interface g{
    public abstract void m1();//don't need a body because it abstract also public
    private void m2(){
        //because i can use it only here
    }
    private static void m4(){
       //also private static and it can be used only in static methods and only within interface / class aswel
    }
    static void m3(){
        //can be used outside the class anywhere
    }
    default void defaultMethod(){
        //call any method, abstract, static ,non static
    }



}
abstract class A implements b,g{

}
class D extends A{
    public void m1(){
    }
    void display(){
        System.out.println("D");
    }
    public int draw(int a, int b){
       System.out.println(a+b);
       return 0;
    }
    public void method1(){
        System.out.println("method1");
    }
    static void gmethod(){
        System.out.println("Gmethod");

    }
//    @Override
//    public void method2(){
//        System.out.println("OtherStuff");
//    }
}
public class Test {
    public static void main(String[] args) {
        D d = new D();
        d.display();
        d.draw(5,6);
        d.method1();
        d.method2();
        b.method3();
        b.methodStatic();

    }

}
