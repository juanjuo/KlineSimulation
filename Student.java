import java.util.Objects;

public class Student {
    private KlineCommons dinningHall;
    private int id;
    private double glutenFree;
    private double time; //time in seconds

    public Student(int id_, KlineCommons _dinningHall){
        id = id_;
        dinningHall = _dinningHall;
        glutenFree = Math.random() -0.45; glutenFree = Math.round(glutenFree); // 5% chance
        time = 0;
    }

    public double isFoodGood(double percent){
        double isFoodGood = Math.random() + percent;
        isFoodGood = Math.round(isFoodGood);
        return isFoodGood;
    }

    public void doRun(){
        double percent = 0.0;
        for (KlineCommons.Station p: dinningHall.getMainStations()){
            if (isFoodGood(percent) > 0 && p.getName() == "sandwichStation") {
                time += 120 * p.getLine();
                walkToStation();
                p.addStudent();
                percent -= 0.4;
            }
            else if (isFoodGood(percent) > 0) {
                time += getFood() * p.getLine();
                walkToStation();
                p.addStudent();
                percent -= 0.4;
            }
        }

        percent = 0.0;
        for (KlineCommons.Station t: dinningHall.getSecondaryStations()){
            if (t.getName() == "sodaStation"){
                time += getFood() * t.getLine();
                walkToStation();
                t.addStudent();
                percent -= 0.1;
            }
            else if (isFoodGood(percent) > 0 && !Objects.equals(t.getName(), "glutenFreeSection")){
                time += getFood() * t.getLine();
                walkToStation();
                t.addStudent();
                percent -= 0.3;
            }
            else {
               if (isFoodGood(percent) > 0 && this.isGlutenFree()){
                   time += getFood() * t.getLine();
                   walkToStation();
                   t.addStudent();
               }
            }
        }
    }

    public int getFood(){
        return 15;
    }

    public void walkToStation(){
        time += 15;
    }

    public double getTime(){
        return time/60;
    }

    public int getId(){
        return id;
    }

    public boolean isGlutenFree(){
        return glutenFree > 0;
    }
}
