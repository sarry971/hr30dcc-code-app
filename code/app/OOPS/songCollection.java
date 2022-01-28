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
    
    public  int getSongId()
    {
        return this.songId;
    }
    
    public  String getTitle()
    {
        return this.title;
    }
    
    public  String getArtist()
    {
        return this.artist;
    }
    
    public  double getDuration()
    {
        return this.duration;
    }
    
    //setters
    public  void setSongId(int songId)
    {
        this.songId = songId;
    }
    
    public  void setTitle(String title)
    {
        this.title = title;
    }
    
    public  void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public  void setDuration(double duration)
    {
        this.duration = duration;
    }
}
public class Main
{
    Map<String, List<Song>> songCollection = new HashMap();
    
    Main(Map<String, List<Song>> collection)
    {
        this.songCollection = collection;
    }
    
    public  Map<String, List<Song>> getSongCollection()
    {
        return this.songCollection;
    }
    public  List<Song> getArtist(String songArtist)
    {
        return getSongCollection().get(songArtist);
    }
    
    	
	public double findTotalDuration(List <Song> song, String userArtist)
	{
	    List<Song> s = getArtist(userArtist);
	    
	    if (s.size() == 0)
	        return 0.0;
	        
	    double total = 0.0;
	    
	    for(Song sng: s)
	        total += sng.getDuration();
	    return total;
	}
	
	public  List<Song> sortedAscending(List<Song> song, String userArtist)
	{
	    List<Song> s = getArtist(userArtist);
	    
	    if (s.size() == 0)
	        return s;
	        
	    for(int i=0; i<s.size(); i++)
	       for(int j = i+1; j<s.size(); j++)
	           if (s.get(i).getDuration()>s.get(j).getDuration())
	           {
	               int indexI = s.indexOf(i);
	               int indexJ = s.indexOf(j);
	               s.set(indexI, s.get(j));
	               s.set(indexJ, s.get(i));
	           }
	    
	    return s;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Map<String, List<Song>> songCollection = new HashMap();
		List<Song> song = new ArrayList();
		
		for(int i=0; i<5; i++)
		{
		    int id = sc.nextInt();
		    String t = sc.next();
		    String a = sc.next();
		    double d = sc.nextDouble();
		    song.add(new Song(id, t, a, d));
		    
		    if (!songCollection.containsKey(a))
		        songCollection.put(a, song);
		    else 
		        songCollection.get(a).add(new Song(id, t, a, d));
		}
		String userArtist = sc.next();
		
		double totalTime = findTotalDuration(song, userArtist);
		
	    if (totalTime > 0.0)
		    System.out.println("The total duration of "+userArtist+" is of "+ totalTime);
		else 
		    System.out.println("The "+userArtist+" is not present");
		    
	    List<Song> sortedDuration = sortedAscending(song, userArtist);
		
		if (sortedDuration.size() > 0)
		    {
		        System.out.println("The songs of "+userArtist+" in ascending order are:");
		        for(Song s: sortedDuration)
		            System.out.println(s);
		    }
		else 
		    System.out.println("The "+userArtist+" is not present");
	}
}
