public class MySQL extends SQL{
    public void RegistrationDriver(){
        System.out.println("Registration MySQL Driver");
    }
    public void EstablishConnection() {
        System.out.println("Establish MySQL Connection"); }
    public void useSQL(){
        RegistrationDriver();
        EstablishConnection();
        CreateExecuteStatements();
        ExecuteStatement();
        ProcessingResults();
        FreeResource();
    }
}
