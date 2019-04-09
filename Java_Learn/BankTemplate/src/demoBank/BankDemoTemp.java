package demoBank;

import java.util.Scanner;

public class BankDemoTemp {
    public final void getNumber(){
        System.out.println("you got a num, please wait");
    }
    public String chooseDemo() {
        System.out.println("withdraw , please input w, if transfer , please input t");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }
    public void demoDeal(){
        getNumber();
        if(chooseDemo().equals("w")){
            withDraw();
        }else{
            transfer();
        }
    }
    public final void withDraw(){
        System.out.println("withDraw successfully!");
    }
    public final void transfer(){
        System.out.println("transfer successfully");
    }
}
