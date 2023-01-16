package fileio;
import java.lang.*;
import java.io.*;
public class FileReadWrite
{
	private File f;					//to create a File
	private FileWriter w;				//to write in a file
	private FileReader r;				//to read from a file
	private BufferedReader br;			//to read file content
		
	public void writeInFile(String s)
	{
		try							//we need to write the whole thing in try-catch for Checked Exceptions (compile time)
		{
			f= new File("fileio/History.txt");		//Declaring a file named named History.txt for creating
			f.createNewFile();				//If the file does not exists, creates and opens the file, else, just opens the file
			w= new FileWriter(f, true);			//creating the writer object to write in the file
			w.write(s+"\r"+"\n");				//writing a string s in the file. the "\r" and "\n" has been concat to go to a newline
			w.flush();						//After writing, we need to flush to indicate that we have completed writing
			w.close();						//After flushing, we need to close the file to save our writing
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public void readFromFile()
	{
		try							//we need to write the whole thing in try-catch for Checked Exceptions (compile time)
		{
			r= new FileReader(f);				//creating the reader object to read from a file.
			br = new BufferedReader(r);			//creating the BufferedReader object using the reader object to read the file content.
			String text="", temp;				//declaring two string variables to read the file content and storing them.
			while((temp=br.readLine())!=null)		//reading one line from the file, storing it in the variable temp and checking whether it is null or not
			{							//It will be null at the end of reading from the file
				text=text+temp+"\n"+"\r";			//storing the temp string in text by concating it with text and "\n" and "\r" is used to go to a newline
			}
			System.out.println(text);			//printing the whole string in console
			r.close();						//closing the file
		}

		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}