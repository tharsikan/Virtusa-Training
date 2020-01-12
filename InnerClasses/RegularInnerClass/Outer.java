class Outer{
class Inner{
public void print(){
System.out.println("Inner");
}
}
public void outerPrint(){
new Inner().print();
}

public static void main(String args[]){
new Outer().new Inner().print();
Outer o=new Outer();
o.outerPrint();
}
}