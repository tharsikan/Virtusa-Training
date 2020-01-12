import java.io.FileReader;

public class UpperCaseFileReader extends FileReader{
public UpperCaseFileReader(String string) throws Exception{
super(string);
}

public int read(String args[])throws Exception{
int read=super.read();
return (read<123&&read>96)?read-32:read;
}

}