package demoBank;

public abstract class Shopping {
    public abstract void chooseStore();
    public final void viewThings(){
        System.out.println("i am looking things");
    }
    public final void selected() {
        System.out.println("i have selected ");
    }
    public abstract void callHelp();
    public final void calculation() {
        System.out.println("calculation is finished");
    }
    public abstract void payfor();
    public abstract void sends();
    public final void watchList(){
        System.out.println("i am looking list!");
    }
//    public final boolean judge(){
//
//    }
    public final void process(){
        chooseStore();
        viewThings();
        selected();
        callHelp();
        calculation();
        payfor();
        sends();
        watchList();
    }
}
