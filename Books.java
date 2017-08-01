
public class Books {
	private String Name;
	private String Author;
	private String Year;
	private String MainCharacter;
	private String Description;
	String text;
	static String fileName = "Books.txt";
	static int Quantity = 0;
	static int number;
	Books(String name, String author, String year, String mainCharacrer, String description)
	{
		
		Name = name;
		Author = author;
		Year = year;
		MainCharacter = mainCharacrer;
		Description = description;
		
		text = Name +"//" +  Author +"//" + Year +"//" + MainCharacter +"//" + Description +"///"+System.lineSeparator();
		
	}
	String getName()
	{
		return Name;
	}
	String getAuthor()
	{
		return Author;
	}
	String getYear()
	{
		return Year;
	}
	String getMainCharacter()
	{
		return MainCharacter;
	}
	String getDescription()
	{
		return Description;
	}
}
