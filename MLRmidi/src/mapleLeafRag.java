import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class mapleLeafRag
{
	public static void main (String[] args)
	{
		System.out.println("Maple Leaf Rag");
		Pattern pattern = new Pattern("T[Allegretto]");	
		//Pattern pat2 = new Pattern("T[Allegretto]");
		
        pattern.add(" V0  Ri | Rs Ab5s Eb5s+Eb6s Ab5s C6s Eb5i+Eb6i G5s | Eb5s+Eb6s G5s Bb5s Eb5s-Eb5i+Eb6s-Eb6i Ri");
		pattern.add( "V1 Eb2i+Eb3i | Ab2i+Ab3i Eb3i+Ab3i+C4i Eb3i+Ab3i+C4i A2i+A3i | Bb2i+Bb3i Eb3i+G3i+Db4i Eb3i+G3i+Db4i Eb2i+Eb3i");
		
		pattern.add(" V0  Rs Ab5s Eb5s+Eb6s Ab5s C6s Eb5i+Eb6i G5s | Eb5s+Eb6s G5s Bb5s Eb5s-Eb5i+Eb6s-Eb6i Rs Eb5s+Eb6s");
		pattern.add("V1  Ab2i+Ab3i Eb3i+Ab3i+C4i Eb3i+Ab3i+C4i A2i+A3i | Bb2i+Bb3i Eb3i+G3i+Db4i Eb3i+G3i+Db4i Eb2i+Eb3i"); 
		
		Player verse1 = new Player();
		//Player verse2 = new Player();
		verse1.play(pattern);
		//verse2.play(pat2);
		
    System.exit(0);
	}

}