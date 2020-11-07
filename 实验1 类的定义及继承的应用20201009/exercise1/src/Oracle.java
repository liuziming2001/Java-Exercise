public class Oracle extends SQL{
    public void RegistrationDriver(){
        System.out.println("Registration Oracle Driver");
    }
    public void EstablishConnection(){
        System.out.println("Establish Oracle Connection");
    }
    public void useSQL(){
        RegistrationDriver();
        EstablishConnection();
        CreateExecuteStatements();
        ExecuteStatement();
        ProcessingResults();
        FreeResource();
    }
}
