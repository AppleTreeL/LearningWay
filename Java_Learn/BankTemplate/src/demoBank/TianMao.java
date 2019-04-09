package demoBank;

public class TianMao extends Shopping {
    @Override
    public void chooseStore() {
        System.out.println("i choose TianMao");
    }

    @Override
    public void callHelp() {
        System.out.println(" i am TianMao's Help");
    }

    @Override
    public void payfor() {
        System.out.println("you can allpay or wechat");
    }

    @Override
    public void sends() {
        System.out.println("anyway sends");
    }
}
