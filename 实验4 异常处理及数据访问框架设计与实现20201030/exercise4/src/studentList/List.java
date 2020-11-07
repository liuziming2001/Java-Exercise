package studentList;

public class List {
    public static int count = 0;
    public Storage store;
    public static Student[] Stu = new Student[100];
    public void setStoreType(Storage s){
        this.store = s;
    }
}
