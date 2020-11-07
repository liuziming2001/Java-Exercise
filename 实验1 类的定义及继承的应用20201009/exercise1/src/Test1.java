public class Test1 {
    public static void main(String args[]){
        System.out.println("use MySQL:");
        MySQL sql1 = new MySQL();
        sql1.useSQL();
        System.out.println("================");
        System.out.println("use Oracle:");
        Oracle sql2 = new Oracle();
        sql2.useSQL();
    }
}
