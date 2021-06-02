/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Entity.Champion;
import Function.Function;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here
        // Số học sinh có thể thêm
        ArrayList<Champion> cpList = new ArrayList<Champion>();
        // số học sinh hiện tại
        Function f = new Function();
        while(true){
            Scanner scan = new Scanner(System.in);
            // Menu chọn tính năng
            System.out.println("Choose Function");
            System.out.println("1. Add Champion");
            System.out.println("2. Hiển thị toàn bộ dữ liệu trong file");
            System.out.println("3. Delete Champion");
            System.out.println("4. Edit Champion");
            System.out.println("5. Search Champion");
            System.out.println("6. Exit");
            
            int choice = scan.nextInt();
            switch(choice){
                // Thêm học sinh 
                case 1:
                {
                    Champion cp = f.addChampion(cpList);
                    cpList.add(cp);
                    String path = "D:\\code\\Data\\data.txt";
                    File f1 = new File(path);
                    try {
                        FileOutputStream fos = new FileOutputStream(f1);
                            try {
                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                                oos.writeObject(cpList);
                                System.out.println("Thành Công");
                            } catch (IOException ex) {
                                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                // Hiển thị toàn bộ học sinh vừa thêm
                case 2:
                {
                    String path = "D:\\code\\Data\\data.txt";
                    File f1 = new File(path);
                    try {
                        FileInputStream fis = new FileInputStream(f1);
                            try {
                                ObjectInputStream ois = new ObjectInputStream(fis);
                            try {
                                ArrayList<Champion> cpList1 =(ArrayList<Champion>) ois.readObject();
                                System.out.println("ID\tName\tHP\tMP\tATK\tDEF\tLoại\tLực chiến");
                                System.out.println("=================================================");
                                for (int i = 0; i < cpList1.size(); i++) {
                                    System.out.println(cpList1.get(i).id + "\t" + cpList1.get(i).name
                                    + "\t" + cpList1.get(i).hp + "\t" + cpList1.get(i).mp
                                    + "\t" + cpList1.get(i).atk + "\t" + cpList1.get(i).def
                                    + "\t" + cpList1.get(i).type+ "\t" + cpList1.get(i).power);
                                }
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            } catch (IOException ex) {
                                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                }
                
                case 3:
                {
                    boolean rs = f.delChampion(cpList);
                    if(rs){
                        System.out.println("Delete Success");
                    }else{
                        System.out.println("ID không có trong danh sách");
                    }
                    break;
                }
                case 4:
                {
                    boolean update =f.updateChampion(cpList);
                    if(update){
                        System.out.println("Update Success");
                    }else{
                        System.out.println("Update False");
                    }
                    break;
                }
                case 5:
                {
                    f.Search(cpList);
                    break;
                }
                case 6:
                {
                    System.exit(0);
                    break;
                }
                default:
                {
                    System.out.println("Bye");
                    break;
                }
            }
        }
    }

}
