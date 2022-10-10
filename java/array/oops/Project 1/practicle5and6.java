

import java.io.*;

class Invalid_team_name extends Exception{
    public String toString(){
        return "Invalid team name";
    }
}
class Invalid_count_exception extends Exception{
    public String toString(){
        return "Invalid_count_exception";
    }
}
class ipl{
    String Team_name;
    int total_matches_played;
    int matches_won;
    int matches_lost;

    ipl(String Team_name,int total_matches_played,int matches_won,int matches_lost){
        this.Team_name=Team_name;
        this.total_matches_played=total_matches_played;
        this.matches_won=matches_won;
        this.matches_lost=matches_lost;
    }

    void register_team()  {
        int i;
        char []ch=Team_name.toCharArray();
        for(i=0;i<Team_name.length();i++){
            try {
                if (Character.isDigit(Team_name.charAt(i))) {
                    throw new Invalid_team_name();
                }
            }
            catch(Invalid_team_name e){
                System.out.println(e);
            }
        }
        for(i=0;i<Team_name.length();i++){
            try {
                if (ch[i] == '@' || ch[i] == '*' || ch[i] == '#' || ch[i] == '$') {
                    throw new Invalid_team_name();
                }
            }
            catch (Invalid_team_name e){
                System.out.println(e);
            }

        }

    }

    void update_count(String wl) {
        total_matches_played++;
        if(wl=="won"){
            System.out.println("you have won");
            matches_won++;
        }
        else{
            matches_lost++;
        }
        try {
            if (total_matches_played != (matches_lost + matches_won)) {
                throw new Invalid_count_exception();
            }
        }
        catch(Invalid_count_exception e){
            System.out.println(e);
        }
        if(0.04*total_matches_played<matches_lost){
            System.out.println("you are disqualified");
        }
        else{
            System.out.println("you are qualified");
        }
    }
}
public class practicle5and6 {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        File f= new File("C:\\Users\\chira\\IdeaProjects\\FirstJavaProgram\\src\\oops\\ipl.txt");
        BufferedReader in= new BufferedReader(new FileReader(f));

        String Team_name;
        int Matches_won;
        int Matches_lost;
        int Total_Matches;
        ipl p1[]= new ipl[5];
        int i=0;
        String str;

        try{
            while((str=in.readLine())!=null) {
                String[] split = str.split(" ");
                Team_name = split[0];
                Total_Matches = Integer.parseInt(split[1]);
                Matches_won = Integer.parseInt(split[2]);
                Matches_lost = Integer.parseInt(split[3]);
                p1[i] = new ipl(Team_name, Total_Matches, Matches_won, Matches_lost);
                i++;

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        for(i=0;i<3;i++) {
            // ------------ Team_Name -------------------
            System.out.println("------------ Team" + i + "_Name -------------------");
            System.out.println("Team Name = " + p1[i].Team_name);
            System.out.print("Total Matches Played = " + p1[i].total_matches_played);
            System.out.print(" Matches Won = " + p1[i].matches_won);
            System.out.println(" Matches Lost = " + p1[i].matches_lost);

            System.out.println("registering team ..........");
            p1[i].register_team();
            System.out.println("upadating count and checking if qualified or disqualified");
            p1[i].update_count("won");
        }


    }
}
