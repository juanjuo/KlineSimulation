import java.util.ArrayList;

public class KlineCommons {

    public class Station{
        private String name;
        private int num;
        private double rate;
        private int capacity;
        private int line;

        public Station(String _name, int _num, double _rate, int _capacity, int _line){
            name = _name;
            num = _num;
            rate = _rate;
            capacity = _capacity;
            line = _line;
        }

        public Station(){
            new Station("null", 0,0,0,0);
        }

        public void addStudent(){
            num++;
        }

        public int getNum(){
            return num;
        }

        public String getName(){
            return name;
        }

        public int getLine(){
            return line;
        }
    }

    private ArrayList<Station> mainStations = new ArrayList<>();
    private ArrayList<Station> secondaryStations = new ArrayList<>();
    private int numOfStations;
    private String[] secondaryNames = new String[] {"glutenFreeSection","saladStation","sodaStation","dessertStation"
            ,"pizzaStation","grillStation"};

    private String[] mainNames = new String[] {"spoonNfork", "cleanPlate","bigGrillStation","sandwichStation"};


    public KlineCommons(){


        for (String name: mainNames) {
            int max = 10;
            int min = 1;
            int n = (int) Math.floor(Math.random()*(max-min+1)+min);
            mainStations.add(new Station(name, 0, 0, 0, n));
            numOfStations++;
        }
        for (String name2: secondaryNames) {
            secondaryStations.add(new Station(name2, 0, 0, 0, 1));
            numOfStations++;
        }
    }

    public ArrayList<Station> getMainStations(){
        return mainStations;
    }

    public ArrayList<Station> getSecondaryStations(){
        return secondaryStations;
    }

    public ArrayList<Station> getAllStations(){
        ArrayList<Station> allStations = new ArrayList<>(mainStations);
        allStations.addAll(secondaryStations);
        return allStations;
    }



}
