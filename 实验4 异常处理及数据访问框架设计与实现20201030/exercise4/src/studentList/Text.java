package studentList;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Text implements Storage {

    @Override
    public void add() throws IOException {
        Student stu = new Student();
        System.out.println("请依次输入学生姓名 性别 学号 电话号码 备注（选填）");
        Scanner scanner_ = new Scanner(System.in);  //读取键盘输入
        String line = scanner_.nextLine();
        Scanner scanner = new Scanner(line);    //将读取的一行信息通过以下方式分解
        stu.setNo(List.count + 1);
        stu.setName(scanner.next());
        stu.setGender(scanner.next());
        String id = scanner.next();
        String number = scanner.next();
        for(int i = 0;i<List.count;i++){
            if(List.Stu[i].getStudentId().equals(id)){
                System.out.println("该学号已存在，请重新输入：");
                Scanner scanner_id = new Scanner(System.in);
                id = scanner_id.nextLine();
                i = 0;
            }
            if(List.Stu[i].getMobilePhoneNumber().equals(number)){
                System.out.println("该电话号码已存在，请重新输入：");
                Scanner scanner_number = new Scanner(System.in);
                number = scanner_number.nextLine();
                i = 0;
            }
        }
        stu.setStudentId(id);
        stu.setMobilePhoneNumber(number);
        try {
            stu.setMemo(scanner.next());    //备注（可以不填）
        } catch (NoSuchElementException e)  //无内容错误，即没有备注
        {
            stu.setMemo(" ");
        }
        scanner.close();
        List.Stu[List.count] = stu;
        List.count++;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt", true)));
        bw.newLine();
        bw.write(String.format("%02d",stu.getNo())+'\t'+stu.getName()+'\t'+stu.getGender()+'\t'+stu.getStudentId()+'\t'+stu.getMobilePhoneNumber()+'\t'+stu.getMemo());
        bw.close();
    }

    @Override
    public void findAll() throws IOException {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);

        }
        br.close();

    }

    @Override
    public void findByStudentId() {
        int flag = 0;
        System.out.println("请输入您要寻找的学生学号：");
        Scanner scanner_id = new Scanner(System.in);
        String id_ = scanner_id.nextLine();
        for(int i = 0;i<List.count;i++){
            if(List.Stu[i].getStudentId().equals(id_)) {
                System.out.println("您所找的学生基本信息为：");
                System.out.println(String.format("%02d",List.Stu[i].getNo()) + '\t' + List.Stu[i].getName() + '\t' + List.Stu[i].getGender() + '\t' + List.Stu[i].getStudentId() + '\t' + List.Stu[i].getMobilePhoneNumber() + '\t' + List.Stu[i].getMemo());
                flag = 1;
            }
        }
        if(flag==0)
            System.out.println("未找到学号为"+id_+"的学生");
    }

    @Override
    public void findByStudentName() {
        int flag = 0;
        System.out.println("请输入您要寻找的学生姓名：");
        Scanner scanner = new Scanner(System.in);
        String name_ = scanner.nextLine();
        for(int i = 0;i<List.count;i++){
            if(List.Stu[i].getName().equals(name_)) {
                if(flag == 0)
                   System.out.println("您所找的学生基本信息为：");
                System.out.println(String.format("%02d",List.Stu[i].getNo()) + '\t' + List.Stu[i].getName() + '\t' + List.Stu[i].getGender() + '\t' + List.Stu[i].getStudentId() + '\t' + List.Stu[i].getMobilePhoneNumber() + '\t' + List.Stu[i].getMemo());
                flag = 1;

            }
        }
        if(flag==0)
            System.out.println("未找到姓名为"+name_+"的学生");

    }

    @Override
    public void update() throws IOException {
        int flag = 0;
        System.out.println("请输入您要更新的学生的学号：");
        Scanner scanner_id = new Scanner(System.in);
        String id_ = scanner_id.nextLine();
        for(int i = 0;i<List.count;i++){
            if(List.Stu[i].getStudentId().equals(id_)) {
                System.out.println("请依次输入更新后的学生姓名 性别 电话号码 备注（选填）");
                Scanner scanner_ = new Scanner(System.in);  //读取键盘输入
                String line = scanner_.nextLine();
                Scanner scanner = new Scanner(line);    //将读取的一行信息通过以下方式分解
                List.Stu[i].setName(scanner.next());
                List.Stu[i].setGender(scanner.next());
                List.Stu[i].setMobilePhoneNumber(scanner.next());
                try {
                    List.Stu[i].setMemo(scanner.next());    //备注（可以不填）
                } catch (NoSuchElementException e)  //无内容错误，即没有备注
                {
                    List.Stu[i].setMemo(" ");
                }
                scanner.close();
                System.out.println("已将学号为"+"_id"+"的学生信息更新为：");
                System.out.println(String.format("%02d",List.Stu[i].getNo()) + '\t' + List.Stu[i].getName() + '\t' + List.Stu[i].getGender() + '\t' + List.Stu[i].getStudentId() + '\t' + List.Stu[i].getMobilePhoneNumber() + '\t' + List.Stu[i].getMemo());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt", false)));
                for(int j = 0;j<List.count;j++){
                    if(List.Stu[j] != null){
                        bw.write(String.format("%02d",List.Stu[j].getNo())+'\t'+List.Stu[j].getName()+'\t'+List.Stu[j].getGender()+'\t'+List.Stu[j].getStudentId()+'\t'+List.Stu[j].getMobilePhoneNumber()+'\t'+List.Stu[j].getMemo());
                        if(j!=List.count-1)
                            bw.newLine();
                    }
                }
                flag = 1;
                bw.close();
            }
        }
        if(flag==0)
            System.out.println("未找到学号为"+id_+"的学生");


    }

    @Override
    public void delete() throws IOException {
        int flag = 0;
        System.out.println("请输入您要删除的学生的学号：");
        Scanner scanner_id = new Scanner(System.in);
        String id_ = scanner_id.nextLine();
        for(int i = 0;i<List.count;i++){
            if(List.Stu[i].getStudentId().equals(id_)) {
                System.out.println("已将该条信息删除：");
                System.out.println(String.format("%02d",List.Stu[i].getNo()) + '\t' + List.Stu[i].getName() + '\t' + List.Stu[i].getGender() + '\t' + List.Stu[i].getStudentId() + '\t' + List.Stu[i].getMobilePhoneNumber() + '\t' + List.Stu[i].getMemo());
                List.Stu[i] = null;
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt", false)));
                for(int j = 0;j<List.count;j++){
                       if(List.Stu[j] != null){
                           bw.write(String.format("%02d",List.Stu[j].getNo())+'\t'+List.Stu[j].getName()+'\t'+List.Stu[j].getGender()+'\t'+List.Stu[j].getStudentId()+'\t'+List.Stu[j].getMobilePhoneNumber()+'\t'+List.Stu[j].getMemo());
                           if(j!=List.count-2)
                               bw.newLine();
                       }
                }
                flag = 1;
                bw.close();
            }
        }
        if(flag==0)
            System.out.println("未找到学号为"+id_+"的学生");

    }
}
