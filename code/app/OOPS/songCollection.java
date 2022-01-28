import java.util.*;

class Song
{
    int songId;
    String title;
    String artist;
    double duration;
    
    Song(int songId, String title, String artist, double duration)
    {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    // getters
    
    public int getSongId()
    {
        return this.songId;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public String getArtist()
    {
        return this.artist;
    }
    
    public double getDuration()
    {
        return this.duration;
    }
    
    //setters
    public void setSongId(int songId)
    {
        this.songId = songId;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
}
public class MyClass
{
    Map<String, Song[]> songCollection = new HashMap<String, Song>();
    
    public MyClass(Map<String, Song[]> collection)
    {
        this.songCollection = collection;
    }
    
    public Map<String, Song[]> getSongCollection()
    {
        return this.songCollection;
    }
    public Song[] getArtist(String songArtist)
    {
        return getSongCollection().get(songArtist);
    }
    
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Map<String, Song[]> songCollection = new HashMap();
		Song[] song = new Song[5];
		
		for(int i=0; i<5; i++)
		{
		    int id = sc.nextInt();
		    String t = sc.next();
		    String a = sc.next();
		    double d = sc.nextDouble();
		    song[i] = new Song(id, t, a, d);
		    if (!songCollection.containsKey(a))
		        songCollection.put(a, song[i]);
		    else 
		        songCollection.put(a, songCollection.get(a).add(song[i]));
		}
		String userArtist = sc.next();
		double totalTime = findTotalDuration(song, userArtist);
		if (totalTime != null)
		    System.out.println("The total duration of "+userArtist+" is of "+ totalTime);
		else 
		    System.out.println("The "+userArtist+" is not present");
		    
		Song[] sortedDuration = sortedAscending(song, userArtist);
		
		if (sortedDuration != null)
		    {
		        System.out.println("The songs of "+userArtist+" in ascending order are:");
		        for(Song s: sortedDuration)
		            System.out.println(s);
		    }
		else 
		    System.out.println("The "+userArtist+" is not present");
	}
	
	public static double findTotalDuration(Song[] song, String userArtist)
	{
	    Song[] s = getArtist(userArtist);
	    
	    if (s == null)
	        return 0.0;
	        
	    double total = 0.0;
	    
	    for(Song sng: s)
	        total += sng.getDuration();
	    return total;
	}
	
	public static Song[] sortedAscending(Song[] song, String userArtist)
	{
	    Song[] s = getArtist(userArtist);
	    
	    if (s == null)
	        return null;
	        
	    // double total = 0.0;
	    
	    for(int i=0; i<s.length(); i++)
	    {
	       for(int j = i+1; j<s.length(); j++)
	       {
	           if (s[i].getDuration()>s[j].getDuration())
	           {
	               Song temp = s[i];
	               s[i] = s[j];
	               s[j] = temp;
	           }
	       }
	    }
	    
	    return s;
	}
}
