package part2;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by jsong on 17/05/2017.
 *
 * @email jsong00505@gmail.com
 * @name the transformation company
 */
public class Main {
  private static char AUTOBOT = 'A';
  private static char DECEPTICON = 'D';
  private static char NONE = 'N';
  private static char BIGBANG = 'B';

  private static String OPTIMUS_PRIME = "Optimus Prime";
  private static String PREDAKING = "Predaking";

  /**
   * Print out the name of all members who survived
   *
   * @param transformers
   * @param out
   */
  public static void print(List<Transformer> transformers, PrintWriter out) {
    boolean firstComma = false;
    for (int i = 0; i < transformers.size(); i++) {
      Transformer transformer = transformers.get(i);

      if (transformer.getWin()) {
        if (firstComma) {
          out.print(", ");
        } else {
          firstComma = true;
        }
        out.print(transformer.getName());
      }
    } // for
    out.println();
  }

  /**
   * @param autobot
   * @param decepticon
   * @return a winner team
   */
  public static char fight(Transformer autobot, Transformer decepticon) {
    char winner = NONE;

    // check if the transformer is Optimus Prime or Predaking first
    if (autobot.getName().equals(OPTIMUS_PRIME) && decepticon.getName().equals(PREDAKING)) {
      return BIGBANG;
    } else if (autobot.getName().equals(OPTIMUS_PRIME)) {
      return AUTOBOT;
    } else if (decepticon.getName().equals(PREDAKING)) {
      return DECEPTICON;
    } // if-else

    // check courage and strength differences between both transformers
    if (Math.abs(autobot.getCourage() - decepticon.getCourage()) >= 4
        && Math.abs(autobot.getStrength() - decepticon.getStrength()) >= 3) {
      // if autobot's stats is more than decepticon's
      // or decepticon's stats is more than autobot's
      // the fight is end immediately
      if (autobot.getCourage() > decepticon.getCourage()
          && autobot.getStrength() > decepticon.getStrength()) {
        return AUTOBOT;
      } else if (decepticon.getCourage() > autobot.getCourage()
          && decepticon.getStrength() > autobot.getStrength()) {
        return DECEPTICON;
      } // if-else
    } // if

    // check the skill difference between both transformers
    // same as above but check only skill difference
    if (Math.abs(autobot.getSkill() - decepticon.getSkill()) >= 3) {
      if (autobot.getSkill() > decepticon.getSkill()) {
        return AUTOBOT;
      } else if (decepticon.getSkill() > autobot.getSkill()) {
        return DECEPTICON;
      } // if-else
    } // if

    // compare overall ratings
    if (autobot.getOverall() > decepticon.getOverall()) {
      return AUTOBOT;
    } else if (decepticon.getOverall() > autobot.getOverall()) {
      return DECEPTICON;
    } // if-else

    // only the result of a tie will return here
    return winner;
  }

  public static void main(String args[]) {
    List<Transformer> autobots = new ArrayList<>();
    List<Transformer> decepticons = new ArrayList<>();

    int numberOfWinForAutobots = 0;
    int numberOfWinForDecepticons = 0;
    char winner = NONE;

    try (Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out)) {
      String line;
      while (!(line = in.nextLine()).equals("")) {
        String[] stats = line.split(",");

        // validation
        if (stats.length != 10) {
          throw new Exception("The number of stats should be ten.");
        }

        // declare and set this value for validation
        char team = stats[1].trim().charAt(0);

        if (team != AUTOBOT && team != DECEPTICON) {
          throw new Exception("The team of the transformer should be Autobot or Decepticon.");
        }

        // set a transformer in the proper team
        Transformer transformer = new Transformer(stats);

        if (transformer.getTeam() == AUTOBOT) {
          autobots.add(transformer);
        } else if (transformer.getTeam() == DECEPTICON) {
          decepticons.add(transformer);
        } // if-else
      } // while

      // sorting by their rank
      Collections.sort(autobots, (o1, o2) -> (o1.getRank() < o2.getRank()) ? 1 : -1);
      Collections.sort(decepticons, (o1, o2) -> (o1.getRank() < o2.getRank()) ? 1 : -1);

      // the number of battle will be smaller number of both teams' members
      int numberOfBattle =
          (autobots.size() > decepticons.size()) ? decepticons.size() : autobots.size();

      // do battle
      for (int i = 0; i < numberOfBattle; i++) {
        Transformer autobot = autobots.get(i);
        Transformer decepticon = decepticons.get(i);

        winner = fight(autobot, decepticon);

        if (winner == AUTOBOT) {
          decepticon.setLose();
          numberOfWinForAutobots++;
        } else if (winner == DECEPTICON) {
          autobot.setLose();
          numberOfWinForDecepticons++;
        } else if (winner == NONE) {
          autobot.setLose();
          decepticon.setLose();
        } else if (winner == BIGBANG) {
          // Optimus Prime and Predaking fought and both were died
          // So stop the battle immediately
          break;
        } // if-else
      } // for

      // output
      if (winner != BIGBANG) {
        // print the number of battle
        out.println(numberOfBattle + " battle" + ((numberOfBattle > 1) ? "s" : ""));

        out.print("Winning team ");
        if (numberOfWinForAutobots > numberOfWinForDecepticons) {
          out.print("(Autobots): ");
          print(autobots, out);
          out.print("Survivors from the losing team (Decepticons): ");
          print(decepticons, out);
        } else if (numberOfWinForDecepticons > numberOfWinForAutobots) {
          out.print("(Decepticons): ");
          print(decepticons, out);
          out.print("Survivors from the losing team (Autobots): ");
          print(autobots, out);
        } else {
          // tie
          out.println(": This game is a tie. They will face to fight in soon.");
          out.print("Survivors from Autobots: ");
          print(autobots, out);
          out.print("Survivors from Decepticons: ");
          print(decepticons, out);
        } // if-else
      } else {
        out.println(
            "Autobots and Decepticons lost their great own leaders.\nHowever, they don't want to fight each other.\nSo they live in the earth together happily.");
      } // if-else
    } catch (Exception e) {
      System.err.println(e.toString());
    } // try-catch
  }
}
