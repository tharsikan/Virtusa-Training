import java.io.FileWriter;
public class Application{

public static void main(String args[])throws Exception{

UpperCaseFileReader upperCaseReader= new UpperCaseFileReader("input.txt");
FileWriter fileWriter= new FileWriter("output.txt");
int ascii;

while ((ascii=upperCaseReader.read())!=-1){
char character=(char)ascii;
System.out.print(character);
fileWriter.write(character);
}           

fileWriter.close();
}
}