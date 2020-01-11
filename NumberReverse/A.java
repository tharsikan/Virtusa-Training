import java.util.Scanner;

class A{

static int reversedNo;
static boolean isNegative=false;
static boolean firstTime=true;

public static int reverseNo(int no){

//handle negative numbers
if(firstTime){
if(no<0){
isNegative=!isNegative;
no*=-1;
}
firstTime=!firstTime;
}

if(no>0){
//getLast no from no
reversedNo=(reversedNo*10)+no%10;
//send recursively removing lastNo
reverseNo(no/10);
}
return (isNegative)?reversedNo*-1:reversedNo;
}

public static void main(String ishan[]){
while(true){
//reset static variables
firstTime=true;
isNegative=false;
reversedNo=0;
try
{
System.out.print("Enter a number to reverse :- ");
System.out.println("Your Answer is :- "+reverseNo(new Scanner(System.in).nextInt()));
}
catch(Exception e)
{
System.out.println("Please Enter numerical value only !");
}
}
}
}
