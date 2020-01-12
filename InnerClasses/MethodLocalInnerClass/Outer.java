class Outer{
private int outerValue=10;

public void outerMethod(){
//can access non final values after jdk8
int outerMethodValue=10;

class Inner{
public void print(){
System.out.println("OuterClassValue "+outerValue);
System.out.println("OuterMethodValue "+outerMethodValue);
}
}

new Inner().print();
}

public static void main(String args[]){

Outer o=new Outer();
o.outerMethod();
}
}