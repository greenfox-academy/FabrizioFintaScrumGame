import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Table {
  
  public static GameElement[][] mapLists = new GameElement[10][10];
  ArrayList<GameElement> elementList = new ArrayList<>();
  Hero hero = new Hero();
  
  public Table(){
  }
  
  public void fill(String MAP_SOURCE){
    Path file = Paths.get(MAP_SOURCE);
  
    try {
      ArrayList<String> dataList = new ArrayList<>(Files.readAllLines(file));
    
      int posXCounter = 0;
      int posYCounter = 0;
      for (int index = 0; index < dataList.size(); index++) {
        String[] rows = (dataList.get(index).split(" "));
        for (int subIndex = 0; subIndex < rows.length; subIndex++) {
          if (Integer.parseInt(rows[subIndex]) == 1) {
            GameElement element = new Wall(posXCounter, posYCounter);
            mapLists[index][subIndex] = element;
            elementList.add(element);
          } else {
            GameElement element = new Floor(posXCounter, posYCounter);
            mapLists[index][subIndex] = element;
            elementList.add(element);
          }
          posXCounter += 1;
        }
        posXCounter = 0;
        posYCounter += 1;
      }
      elementList.add(hero);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void drawTable(Graphics graphics){
    for (int index = 0; index < elementList.size(); index++) {
      elementList.get(index).draw(graphics);
    }
    System.out.println(mapLists[1][0] instanceof Wall);
    System.out.println(mapLists[0][1] instanceof Wall);
  }
  
  public void moveHero(KeyEvent e){
    
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      hero.moveUp();
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      hero.moveDown();
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      hero.moveLeft();
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      hero.moveRight();
    }
  }
  
  
}
