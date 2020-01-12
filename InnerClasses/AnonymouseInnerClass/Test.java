class A{
void m(){
}
}

abstract class B{
abstract void m();
}

interface C{
void m();
}

class Test{

public static void main(String args[]){
A a= new A(){
public void m(){
System.out.println("Anonymous of A");
}
};
a.m();

B b= new B(){
public void m(){
System.out.println("Anonymous of B");
}
};
b.m();

C c= new C(){
public void m(){
System.out.println("Anonymous of C");
}
};
c.m();

}
}