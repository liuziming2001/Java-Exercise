public abstract class SQL {
    public void CreateExecuteStatements(){
        System.out.println("Create Execute Statements");
    }
    public void ExecuteStatement(){
        System.out.println("Execute Statement");
    }
    public void ProcessingResults(){
        System.out.println("Processing Results");
    }
    public void FreeResource(){
        System.out.println("Free Resource");
    }
    public final void useSQL(){
        RegistrationDriver();
        EstablishConnection();
        CreateExecuteStatements();
        ExecuteStatement();
        ProcessingResults();
        FreeResource();
    }
    public abstract void RegistrationDriver();
    public abstract void EstablishConnection();
}