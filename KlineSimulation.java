import java.util.ArrayList;

public class KlineSimulation {
    private ArrayList<Student> studentList;
    private Time timer = new Time();


    public KlineSimulation(ArrayList<Student> _studentList) {
        studentList = _studentList;

    }

    public void run() {
        int num = 0;
        for (Student s : studentList) {
            s.doRun();
            System.out.println("student #" + s.getId() + " " + s.getTime() + " " + s.isGlutenFree());
            if (s.isGlutenFree())
                num++;
        }
        System.out.println(num);
    }


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        KlineCommons klineCommons = new KlineCommons();
        int numberOfStudents = 1;

        for (int i = 1; i <= numberOfStudents; i++) {
            students.add(new Student(i, klineCommons));
        }

        KlineSimulation klineSimulation = new KlineSimulation(students);
        klineSimulation.run();
        for (KlineCommons.Station p : klineCommons.getAllStations()) {
            System.out.println(p.getNum() + " " + p.getLine() + " " + p.getName());
        }
    }
}
