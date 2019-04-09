package demoBank;

public class Jingdong extends Shopping {
    @Override
    public void chooseStore() {
        System.out.println("i choose JingDong");
    }

    @Override
    public void callHelp() {
        System.out.println("i am JingDong's Help");
    }

    @Override
    public void payfor() {
        System.out.println("wechat pay");
    }

    @Override
    public void sends() {
        System.out.println("JingDong sends");
    }
}
