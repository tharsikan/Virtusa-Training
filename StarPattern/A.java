import java.util.Scanner;

class A{
static int rowLimit=0;

static void star(int no){
int starNo=(no+no+1);
String spaces="";
String stars="";

if(!(no>rowLimit)){
for(int i=0;i<(rowLimit-starNo/2);i++)
spaces+=" ";
for(int i=0;i<starNo;i++)
stars+="*";
System.out.println(spaces+stars);
star(no+1);
}

if(!spaces.equals(""))
System.out.println(spaces+stars);
return;
}

public static void printStarPattern(int rowLimit){
A.rowLimit=rowLimit;
star(0);

}

public static void main(String args[]){
System.out.print("Enter the amount of rows in one star without middle line :");
printStarPattern(new Scanner(System.in).nextInt());
}
}