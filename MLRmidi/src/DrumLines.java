import java.io.InputStream;
import java.util.Scanner;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class DrumLines {

	String tempo;
	int drumbeat; // 1 for rock
	
	public DrumLines (String tempo, int drumbeat) {
		this.tempo = tempo;
		this.drumbeat = drumbeat;
	}
	
	public String getTempo() {
		return "T"+tempo;
	}
	
	// 0 is bass and snare, 1 is cymbals
	String[] rockBeat = { "V9 L0 36q 40q 36q 40q | 36q 40q 36q 40q | 36q 40q 36q 40q | 36q 40q 48s 48s 47s 47s 43s 43s 43s 43s | Rw", 
			              "V9 L1 42i 42i 42i 42i 42i 42i 42i 42i | 42i 42i 42i 42i 42i 42i 42i 42i | 42i 42i 42i 42i 42i 42i 42i 42i | 42i 42i 42i 42i Rh" };
	String[] edmBeat = { "V9 L0 35q 35q+38q 35q 35+38q | 35q 35q+38q 35q 35+38q | 35q 35q+38q 35q 35+38q | 35q 35q+38q 35q 35+38q | Rw " ,
			             "V9 L1 Ri 42i Ri 42i Ri 42i Ri 42i | Ri 42i Ri 42i Ri 42i Ri 42s 42s | Ri 42i Ri 42i Ri 42i Ri 42i | Ri 42i Ri 42i Ri 42i Ri 42s 42s| Rw"};
	String[] jazzBeat =  {  "V9 L0 36h 40h | 36h 40h | 36h 40h | 36h 48i* 48i* 48i* 43i* 43i* 43i* | Rw", 
			               "V9 L1 51q 51q* 51i* 51q 51q* 51i*| 51q 51q* 51i* 51q 51q* 51i* | 51q 51q* 51i* 51q 51q* 51i* | 51q 51q* 51i* Rh | Rw"}; 
	String[] blastBeat = {"V9 L0 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s | 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s | 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s | 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s 36s | Rw ",
			              "V9 L1 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i | 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i 49i+51i 49i+51i 49i+51i 49i+51i | \"V9 L1 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i | 49i-+51i- 49-s+51-s 49i-+51i- 49-s+51-s 49i+51i 49i+51i 49i+51i 49i+51i 49i+51i | Rw"
	                      };
	
	public int getDrumbeat() {
		return drumbeat;
	}
	
	// add more for more drum stuff
	public void playDrumbeat() {
		
		String[] midi = new String[4];
		Pattern pattern = new Pattern(getTempo());
		switch (drumbeat) {
	
		case 1: 
			midi[0] = rockBeat[0];
            midi[1] = rockBeat[1];
		    break;
		case 2:
			midi[0] = edmBeat[0];
			midi[1] = edmBeat[1];
			break;
		case 3:
			midi[0] = jazzBeat[0];
			midi[1] = jazzBeat[1];
			break;
		default:
			midi[0] = blastBeat[0];
			midi[1] = blastBeat[1];
			//System.out.println("Sorry, we don't have that yet. Desole, nous ne l'avons pas maintenant.");
		}
		pattern.add(midi[0]);
		pattern.add(midi[1]);
    	Player player = new Player();
    	player.play(pattern);
 	   
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Boolean runAgain = true;
		while (runAgain == true) {
				
     		Scanner in = new Scanner(System.in);	
     		
     		int drum;
     	//	String[] playedBeats = new String[4];
 
         	System.out.println("Enter what tempo you want in BPM.");
         	String tempoIn = in.nextLine();
         	
         	System.out.println("Enter which drum loop to play: \n" + "1 for rock \n" + "2 for edm \n" + "3 for jazz \n" + "4 for something else \n");
         	drum = in.nextInt();
        /*	
         * String tempoIn = in.nextLine();  	
         * String tempoOut = "T"+tempoIn;
        */ 
         	// old code Before adding the class
         	
			DrumLines yourDrum = new DrumLines(tempoIn, drum);
			
	      /*Pattern pattern = new Pattern(yourDrum.getTempo());
	         plays the actual stuff (might take a while in this ide)
	    	*/
			
			yourDrum.playDrumbeat();
			
	    	System.out.println("Run again? \n" + "1 for yes. \n" + "0 for no. \n");
	    	Integer y_or_n = in.nextInt();
	    	
	    	switch (y_or_n) {
	    	case 0:
	    		runAgain = false;
	    		break;
	    	default:
	    		runAgain = true;	
	    	}
		}	 
		
	    System.exit(0);
	}
    

}
