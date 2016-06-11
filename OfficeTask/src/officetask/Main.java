
package officetask;

/**
 *
 * @author dutchman
 */
public class Main {
    
    public static void main(String[] args){
        
        //IPU -> Host
        
        String report = "H|\\^&|||XE-2100^00-22^11001^^^^12345678||||||||E1394-97<CR>\n" +
    "Q|1|2^1^ 1234567890^B||||20011001153000<CR>\n" +
    "L|1|N<CR>";

        // Three Lines are availabel H,Q,L
        
        String[] lines = report.split("[\n]");

        for(String line : lines){
            
            System.out.println(line);
            String regex = "\\|";
            
            if(line.charAt(0) == 'H'){
                //System.out.println(line);
                
                
                String[] hr = line.split(regex);
                System.out.println("Header Record:");
                for(int j=2; j<hr.length; j++){
                    //System.out.println("Header "+hr[j]);
                    String[] fr = hr[j].split("\\^");
                    int count=1;
                    for(String f : fr){
                       if(!f.equals("")){
                           switch(count){
                               case 1:
                                   System.out.println("Analyzer name: "+f);
                                   break;
                               case 2:
                                   System.out.println("Software version: "+f);
                                   break;
                                case 3:
                                   System.out.println("PS code: "+f);
                                   break;
                                case 4:
                                   System.out.println("ASTM version no: "+f);
                                   break;
                           }
                           count++;
                       }
                    }
                }
            } else if(line.charAt(0) == 'Q'){
                
                String[] qr = line.split(regex);
                
                String[] sr = qr[2].split("\\^");
                
                System.out.println("Request Record:");
                
                System.out.println("Sequence No: "+qr[1]);
                
                System.out.println("Rack No: "+sr[0]);
                
                System.out.println("Tube Position: "+sr[1]);
                
                System.out.println("Sample No: "+sr[2]);
                
                System.out.println("Sample No Attribute: "+sr[3]);
            }
            System.out.println();
        }
        
        
        
    }
    
}
