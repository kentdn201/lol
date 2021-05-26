/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Entity.Champion;
import Function.Function;
import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("2. Show Champion");
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
                    break;
                }
                // Hiển thị toàn bộ học sinh vừa thêm
                case 2:
                {
                    f.showAll(cpList);
                    break;
                }
                // Thoát trương trình
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
                f.Search(stList);
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
