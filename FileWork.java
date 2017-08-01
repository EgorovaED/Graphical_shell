import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Vector;

import javax.swing.DefaultListModel;




public class FileWork {
	public static void write( String fileName, Books books) {
	    //Определяем файл
		
	    File file = new File(fileName);
	  
	    try {
	        //проверяем, что если файл не существует то создаем его
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        //PrintWriter обеспечит возможности записи в файл
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //Записываем текст у файл
	            out.write(books.text);
	            
	        } finally {
	            //После чего мы должны закрыть файл
	            //Иначе файл не запишется
	            out.close();
	        }
	    } catch(IOException e) {
	    	
	        throw new RuntimeException(e);
	    }
	}
	static Books[] st= new Books[Books.Quantity];
	public static void read(String fileName) throws FileNotFoundException {
	    //Этот спец. объект для построения строки
	    File file = new File(fileName);
	    exist(fileName);
	        //Объект для чтения файла в буфер
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        try {
	            //В цикле построчно считываем файл
	            String s;
	            
	            String line = null;  
	        	while ((line = reader.readLine()) != null) 
	        	{  	        		
	        			makeFilm(line);	        		
	        		
	        	}
	        	reader.close();  

	        } catch(IOException e) {
	        	e.printStackTrace();
	        }
	    
	    }

	static Vector vPoints = new Vector();
	static DefaultListModel films = new DefaultListModel();
	
    protected static void makeFilm(String lineToParse) { 
    		
    		String[] result = lineToParse.split("//"); 
    		
    		Books st1 = new Books(result[0], result[1],result[2], result[3], result[4]);
    		films.addElement(result[0]);
    		vPoints.add(st1);
    	} 
    
	private static void exist(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
		
	public static void DeletEl(int number) throws FileNotFoundException  
	{
		Books[] newFile = new Books [vPoints.size()-1];
		for(int i =0; i<number;i++)
		{
			newFile[i]=(Books)FileWork.vPoints.get(i);
		}
		for(int i =(number+1); i<vPoints.size();i++)
		{
			newFile[i-1]=(Books)FileWork.vPoints.get(i);
		}
		write(Books.fileName, newFile[0]);
		for(int i =1; i<vPoints.size()-1;i++)
		{
			update(Books.fileName, newFile[i]);
		}
		FileWork.vPoints.clear();
		//new MainWindow();
	}
	public static void update(String nameFile, Books film)  {
	
		 try {
	          BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile,true));
	         film.Quantity++;
	             writer.write(film.text );
	           
	            // System.out.print(newText );
	          
	         writer.close();


	       } catch(IOException ex) {
	           System.out.println("couldn't write ");
	           ex.printStackTrace();
	       }
	
	}

	public static void delete(String nameFile) throws FileNotFoundException {
	    exist(nameFile);
	    new File(nameFile).delete();
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Books a = new Books("451DegreeFarenget", "Author", "2016", "Character", "description");
		update(Books.fileName, a );
		Books b = new Books("TriymfalnayArka", "Author2", "2016", "Character2", "description2");
		update(Books.fileName, b );
		Books c = new Books("TreeTovaresha", "Author3", "2016", "Character3", "description3");
		update(Books.fileName, c);
		//read(Books.fileName);
		//DeletEl(2);
		
	}
	
		
	
}
