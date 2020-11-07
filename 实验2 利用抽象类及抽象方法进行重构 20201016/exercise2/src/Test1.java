public class Test1 {
    public static void main(String[] args){
        System.out.println("use MySQL:");
        MySQL sql1 = new MySQL();
        sql1.useSQL();
        System.out.println("================");
        System.out.println("use Oracle:");
        Oracle sql2 = new Oracle();
        sql2.useSQL();
        System.out.println("================");
        System.out.println("use Access:");
        Access sql3 = new Access();
        sql3.useSQL();
    }
}