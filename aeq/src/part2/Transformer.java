package part2;

/**
 * Created by jsong on 18/05/2017.
 *
 * @email jsong00505@gmail.com
 * @name the transformation company*
 */
class Transformer {
  private String name;
  private char team;
  private int strength;
  private int intelligence;
  private int speed;
  private int endurance;
  private int rank;
  private int courage;
  private int firepower;
  private int skill;
  private int overall;
  private boolean win = true;

  Transformer(String[] stats) {
    // set a stat to a proper position
    name = stats[0].trim();
    team = stats[1].trim().charAt(0);
    strength = Integer.parseInt(stats[2].trim());
    intelligence = Integer.parseInt(stats[3].trim());
    speed = Integer.parseInt(stats[4].trim());
    endurance = Integer.parseInt(stats[5].trim());
    rank = Integer.parseInt(stats[6].trim());
    courage = Integer.parseInt(stats[7].trim());
    firepower = Integer.parseInt(stats[8].trim());
    skill = Integer.parseInt(stats[9].trim());

    // formula: Strength + Intelligence + Speed + Endurance + Firepower
    overall = strength + intelligence + speed + endurance + firepower;
  }

  @Override
  public String toString() {
    return name;
  }

  public void setLose() {
    win = false;
  }

  public String getName() {
    return name;
  }

  public char getTeam() {
    return team;
  }

  public int getStrength() {
    return strength;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public int getSpeed() {
    return speed;
  }

  public int getEndurance() {
    return endurance;
  }

  public int getRank() {
    return rank;
  }

  public int getCourage() {
    return courage;
  }

  public int getFirepower() {
    return firepower;
  }

  public int getSkill() {
    return skill;
  }

  public int getOverall() {
    return overall;
  }

  public boolean getWin() {
    return win;
  }
}
