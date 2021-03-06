public abstract class Moving extends GameElement{
  
  int level = 1;
  private double MaxHP;
  private double CurrentHP;
  private double DefendP;
  private double StrikeP;
  private boolean isDead;
  protected int heroMoveCounter = 0;
  boolean hasKey;
  
  Moving(){
  }
  
  void depriveFromKey(){
    hasKey = false;
  }
  
  void giveKey(){
    hasKey = true;
  }
  boolean getHasKey(){
    return hasKey;
  }
  
  protected void moveUp(){
    if (getPositionY() != 0)  {
      if (!(Table.fieldLists[getPositionX()][getPositionY()-1] instanceof Wall)) {
        setPositionY(getPositionY() - 1);
      }
    }
  }
  protected void moveDown(){
    if (super.getPositionY() < 9) {
      if (!(Table.fieldLists[super.getPositionX()][getPositionY()+1] instanceof Wall)) {
        super.setPositionY(super.getPositionY() + 1);
      }
    }
  }
  protected void moveRight(){
    if (super.getPositionX() < 9) {
      if (!(Table.fieldLists[super.getPositionX()+1][super.getPositionY()] instanceof Wall)) {
        super.setPositionX(super.getPositionX() + 1);
      }
    }
  }
  protected void moveLeft(){
    if(super.getPositionX() != 0) {
      if (!(Table.fieldLists[super.getPositionX()-1][super.getPositionY()] instanceof Wall)) {
        super.setPositionX(super.getPositionX() - 1);
      }
    }
  }
  
  double getMaxHP() {
    return MaxHP;
  }
  void setMaxHP(double maxHP) {
    MaxHP = maxHP;
  }
  
  public double getCurrentHP() {
    return CurrentHP;
  }
  void setCurrentHP(double currentHP) {
    CurrentHP = currentHP;
  }
  
  double getDefendP() {
    return DefendP;
  }
  void setDefendP(double defendP) {
    DefendP = defendP;
  }
  
  public double getStrikeP() {
    return StrikeP;
  }
  void setStrikeP(double strikeP) {
    StrikeP = strikeP;
  }
  
  void restoreHP(){
    setCurrentHP(getMaxHP());
  }
  
  boolean isDead() {
    return isDead;
  }
  
  void execute(){
    isDead = true;
  }
  
  void resurrect(){
    isDead = false;
  }
  
  void levelUp(){
    level++;
  }
  
  int getLevel(){
    return level;
  }
  
  @Override
  public String toString() {
    return getClass().getSimpleName() + " " + "Level " + getLevel() + " " +
                   "HP: " + getCurrentHP()+"/"+getMaxHP() + " | DP: " + getDefendP() + " | SP: " + getStrikeP();
  }
}