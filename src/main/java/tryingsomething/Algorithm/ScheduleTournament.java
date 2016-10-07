package tryingsomething.Algorithm;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import java.util.Arrays;

/**
 * Created by rmukherj on 10/6/16.
 */
public class ScheduleTournament {

    public void computeMatches(int teams, int days) throws InvalidInputException{
        if(teams%2!=0 || days <=0){
            throw new InvalidInputException();
        }

        int teamMatchesPerDay = (teams/days)+(teams%days);
        int maxRotation = teams - 1;
        int rot = 0;
        int dayIdx = 1;
        int[] teamArray = new int[teams];
        for (int i = 0; i < teamArray.length ; i++) {
            teamArray[i] = i+1;
        }

        while(rot<maxRotation){
            for (int i = 0; i < teamMatchesPerDay && rot<maxRotation; i++) {
                rotate(1,teams - 1, teamArray);
                rotate(2, teams - 1, teamArray);
                rot++;
                //Neighboring values represent teams playing one another.
                System.out.println("day " + dayIdx+ ":" + Arrays.toString(teamArray));
                dayIdx++;
            }
        }
    }

    private void rotate(int start, int end, int[] arr){
        int i = start;
        int j = end;
        while(i<j){
            int tmp = arr[i];
            arr[i++]= arr[j];
            arr[j--] = tmp;
        }
    }

    public static void main(String[] args) throws InvalidInputException {
        int game = 4;
        int gameDays = 3;
        ScheduleTournament st = new ScheduleTournament();
        try {
            st.computeMatches(game, gameDays);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}

//Time: O(n^2) where n is the number of teams.
// Space is O(n) where n is the number of teams.
