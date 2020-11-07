package studentList;

import java.io.IOException;

public interface Storage {
    public abstract void add() throws IOException;
    public abstract void findAll() throws IOException;
    public abstract void findByStudentId();
    public abstract void findByStudentName();
    public abstract void update() throws IOException;
    public abstract void delete() throws IOException;

}
