/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import Entity.Champion;
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
    public int checkID(ArrayList<Champion> cpList, String id){
        for (int i = 0; i < cpList.size(); i++) {
            if(cpList.get(i).id.equals(id)){
                return i;
            }
        }
        return -1;
    }
    // thêm học sinh
    public Champion addChampion(ArrayList<Champion> cpList){
        Champion cp = null;
        Scanner scan = new Scanner(System.in);
        // Thực hiện nhập thông tin của học sinh
        System.out.println("Enter thông tin tướng");
        // ID của học sinh
        System.out.println("Tướng ID: ");
        String id; 
        String name;
        String type;
        int index;
        do{
            // Tên của học sinh
            System.out.println("ID Tướng");
            id = scan.nextLine();
            index = checkID(cpList, id);
            if(index >= 0){
                System.out.println("Tướng đã tồn tại");
            }
        }while(index >= 0);
        boolean rs = false;
        do{
            System.out.println("Tên tướng: ");
            name = scan.nextLine();
            rs = checkInput("^[ A-Za-z]+$", name);
            if(rs == false){
                System.out.println("Tên sai");
            }
        }while(!rs);

        // HP tướng
        System.out.println("HP Tướng: ");
        float hp = scan.nextFloat();
        // MP tướng
        System.out.println("MP Tướng: ");
        float mp = scan.nextFloat();
        // Tấn công
        System.out.println("ATK Tướng: ");
        float atk = scan.nextFloat();
        // Phòng thủ
        System.out.println("DEF Tướng: ");
        float def = scan.nextFloat();
        // Loại
        System.out.println("Chủng loại ");
        type = scan.nextLine();
        // Lực chiến
        float power = atk + def + mp + hp;
        
        cp = new Champion();
        cp.id = id;
        cp.name = name;
        cp.hp = hp;
        cp.mp = mp;
        cp.atk = atk;
        cp.def = def;
        cp.type = type;
        cp.power = power;
        return cp;
    }
    // show toàn bộ học sinh đã thêm
    public void showAll(ArrayList<Champion> cpList){
        System.out.println("--List of Champion--");
        System.out.println("ID\tName\tHP\tMP\tATK\tDEF\tLoại\tLực chiến");
        for (int i = 0; i < cpList.size(); i++) {
            System.out.println(cpList.get(i).id+"\t"
                    +cpList.get(i).name+"\t"+cpList.get(i).hp
                    +"\t"+cpList.get(i).mp +"\t"+cpList.get(i).atk
            +"\t"+cpList.get(i).def +"\t"+cpList.get(i).type
            +"\t"+cpList.get(i).power);
        }
    }
    // xóa học sinh
    public boolean delChampion(ArrayList<Champion> cpList){
        System.out.println("Nhập vào id của Tuong: ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        int index = checkID(cpList, id);
        if(index < 0){
            return false;
        }
        else{
            cpList.remove(index);
        }
        return true;
    }
    
    public boolean isEmpty(int n){
        return n == 0;
    }
    // Sửa thông tin của học sinh
    public boolean updateChampion(ArrayList<Champion> cpList){
        if(isEmpty(cpList.size())){
            System.out.println("Danh sách trống");
            return false;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập id cần sửa: ");
        String id = scan.nextLine();
        String name;
        int index = checkID(cpList, id);
        if(index < 0){
            System.out.println("Lỗi");
            return false;
        }
        boolean rs = false;
        do{
            System.out.println("Tên tướng: ");
            name = scan.nextLine();
            rs = checkInput("^[ A-Za-z]+$", name);
            if(rs == false){
                System.out.println("Tên sai");
            }
        }while(!rs);

        // HP tướng
        System.out.println("HP Tướng: ");
        float hp = scan.nextFloat();
        // MP tướng
        System.out.println("MP Tướng: ");
        float mp = scan.nextFloat();
        // Tấn công
        System.out.println("ATK Tướng: ");
        float atk = scan.nextFloat();
        // Phòng thủ
        System.out.println("DEF Tướng: ");
        float def = scan.nextFloat();
        // Loại
        System.out.println("Chủng loại ");
        String type = scan.nextLine();
        // Lực chiến
        float power = atk + def + mp + hp;
            
        cpList.get(index).name = name;
        cpList.get(index).hp = hp;
        cpList.get(index).mp = mp;
        cpList.get(index).atk = atk;
        cpList.get(index).def = def;
        cpList.get(index).type = type;
        cpList.get(index).power = power;
        
        return true;
    }
    public boolean checkInput(String reg, String inp){
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(inp);
        boolean b = m.matches();
        return b;
    }
    public void Search(ArrayList<Champion> cpList){
    System.out.println("Nhap ID Tuong muon tim kiem: ");
    Scanner se =new Scanner(System.in);
    String id  = se.nextLine();
    int index = checkID( cpList,  id );
    if (index < 0){
    System.out.println("Khong tim thay tuong ");
    }
    else{
    Champion cp = cpList.get(index);    
    System.out.println("Danh sach tuong dang co la :");
    System.out.println("ID\tName\tHP\tMP\tATK\tDEF\tLoại\tLực chiến");
    System.out.println("=================================================");
    for (int i = 0; i < cpList.size(); i++) {
            System.out.println(cpList.get(i).id+"\t"
                    +cpList.get(i).name+"\t"+cpList.get(i).hp
                    +"\t"+cpList.get(i).mp +"\t"+cpList.get(i).atk
            +"\t"+cpList.get(i).def +"\t"+cpList.get(i).type
            +"\t"+cpList.get(i).power);
        }
    
    }
    }
}
