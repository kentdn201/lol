/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Entity.Student;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author admin
 */
public class Function {
    // hàm kiểm tra id
    public int checkID(ArrayList<Student> stList, String id){
        for (int i = 0; i < stList.size(); i++) {
            if(stList.get(i).id.equals(id)){
                return i;
            }
        }
        return -1;
    }
    // thêm học sinh
    public Student addStudent(ArrayList<Student> stList){
        Student st = null;
        Scanner scan = new Scanner(System.in);
        // Thực hiện nhập thông tin của học sinh
        System.out.println("Enter student information");
        // ID của học sinh
        System.out.println("Student ID: ");
        String id; 
        String name;
        int index;
        do{
            // Tên của học sinh
            System.out.println("ID Student");
            id = scan.nextLine();
            index = checkID(stList, id);
            if(index >= 0){
                System.out.println("Student đã tồn tại");
            }
        }while(index >= 0);
        boolean rs = false;
        do{
            System.out.println("Student Name: ");
            name = scan.nextLine();
            rs = checkInput("^[ A-Za-z]+$", name);
            if(rs == false){
                System.out.println("Tên sai");
            }
        }while(!rs);

        // Mail của học sinh
        System.out.println("Student Mail: ");
        String mail = scan.nextLine();
        // Điểm của học sinh
        System.out.println("Student Mark: ");
        float mark = scan.nextFloat();

        st = new Student();
        st.id = id;
        st.name = name;
        st.mail = mail;
        st.mark = mark;
        return st;
    }
    // show toàn bộ học sinh đã thêm
    public void showAll(ArrayList<Student> stList){
        System.out.println("--List of Student--");
        System.out.println("ID\tName\tMail\tMark");
        for (int i = 0; i < stList.size(); i++) {
            System.out.println(stList.get(i).id+"\t"
                    +stList.get(i).name+"\t"+stList.get(i).mail
                    +"\t"+stList.get(i).mark);
        }
    }
    // xóa học sinh
    public boolean delStudent(ArrayList<Student> stList){
        System.out.println("Nhập vào id của học sinh: ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        int index = checkID(stList, id);
        if(index < 0){
            return false;
        }
        else{
            stList.remove(index);
        }
        return true;
    }
    
    public boolean isEmpty(int n){
        return n == 0;
    }
    // Sửa thông tin của học sinh
    public boolean updateStudent(ArrayList<Student> stList){
        if(isEmpty(stList.size())){
            System.out.println("Danh sách trống");
            return false;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        String id = scan.nextLine();
        int index = checkID(stList, id);
        if(index < 0){
            System.out.println("Lỗi");
            return false;
        }
        System.out.println("Student Name: ");
        String name = scan.nextLine();
        // Mail của học sinh
        System.out.println("Student Mail: ");
        String mail = scan.nextLine();
        // Điểm của học sinh
        System.out.println("Student Mark: ");
        float mark = scan.nextFloat();
            
        stList.get(index).name = name;
        stList.get(index).mail = mail;
        stList.get(index).mark = mark;
        
        return true;
    }
    public boolean checkInput(String reg, String inp){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(inp);
        boolean b = m.matches();
        return b;
    }
}
