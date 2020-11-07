import studentList.List;
import studentList.Student;
import studentList.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class test {
    public static void traverseList(){
        int i = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            String line;
            for (i = 0; i < 100; i++) {    //对数组内的对象都开辟空间
                List.Stu[i] = new Student();
            }
            i = 0;
            while ((line = br.readLine()) != null) {
                Scanner scanner = new Scanner(line);    //以下方式可以过滤一行中的空格
                List.Stu[i].setNo(scanner.nextInt());    //序号
                List.Stu[i].setName(scanner.next());    //姓名
                List.Stu[i].setGender(scanner.next());    //性别
                List.Stu[i].setStudentId(scanner.next());    //学号
                List.Stu[i].setMobilePhoneNumber(scanner.next());    //手机号
                try {
                    List.Stu[i].setMemo(scanner.next());    //备注（可以不填）
                } catch (NoSuchElementException e)  //无内容错误，即没有备注
                {
                    List.Stu[i].setMemo(" ");
                }
                scanner.close();
                i++;
            }
            List.count = i;
        } catch (FileNotFoundException e) { //找不到文件错误
            e.printStackTrace();
        } catch (IOException e) {   //读取行错误
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {   //文件关闭错误
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws IOException {
        List a = new List();
        a.setStoreType(new Text());
        traverseList();
        System.out.println("学生总数为：");
        System.out.println(List.count);
        a.store.findAll();
        a.store.add();
        //a.store.findByStudentId();
        //a.store.findByStudentName();
        //a.store.delete();
        //a.store.update();
    }
}
