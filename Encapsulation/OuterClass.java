class OuterClass{
private int data=10;

 
class InnerClass{
private int data=20;
//public static void m(){} static baaa
public void m(){ System.out.println("Regular Inner Class "+(OuterClass.this.data+data));}
}


public void getMethodLocalInnerClass(){
int methodLocal=30;
class MethodLocalInnerClass{
public void m(){System.out.println(methodLocal+" local class ");}
}
new MethodLocalInnerClass().m();
}

static class StaticInnerClass{
static int data=50;
public static void main(String[] args) {
System.out.println("Static");
}
}

    
public static void main(String[] args) {
OuterClass.InnerClass  innerClass= new OuterClass().new InnerClass();
innerClass.m();
       
OuterClass anonymousInnerClass= new OuterClass(){
public void getMethodLocalInnerClass(){System.out.println("anonymous override");}};
anonymousInnerClass.getMethodLocalInnerClass();
      
new OuterClass().getMethodLocalInnerClass();
        
OuterClass.StaticInnerClass staticInnerClass= new OuterClass.StaticInnerClass();
System.out.println(OuterClass.StaticInnerClass.data);

}
}