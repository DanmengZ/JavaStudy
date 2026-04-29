package com.test;
import java.math.BigDecimal;
import java.util.Scanner;

interface Payable{
    boolean pay(double amount);
}

abstract class Wallet{
    private String owner;

    public Wallet(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }
    public abstract void showBalance();
}

class StarWallet extends Wallet implements Payable{
    private BigDecimal balance;

    public StarWallet(String owner,String initialBalance){
        super(owner);
        this.balance = new BigDecimal(initialBalance);
    }

    @Override
    public boolean pay(double amount){
        BigDecimal payAmt = BigDecimal.valueOf(amount);
        if(balance.compareTo(payAmt)>= 0) {
            balance = balance.subtract(payAmt);
            new TransactionRecord().log(payAmt);
            return true;
        }else{
            System.out.println("\n>>>支付失败：余额不足！（当前余额："+ balance+ "）");
            return false;
        }
    }

    private class TransactionRecord{
        void log(BigDecimal amt){
            System.out.println("\n>>>【系统日志】"+ getOwner()+ "支付成功：—— "+ amt);
            System.out.println("\n>>>【系统日志】当前账户余额: "+ balance);
        }
    }

    @Override
    public void showBalance(){
        System.out.println("\n账户名称："+ getOwner());
        System.out.println("\n账户余额："+ balance);
    }
}

class ExchangeManager{
    private static ExchangeManager instance = new ExchangeManager();
    private ExchangeManager(){}
    public static ExchangeManager getInstance(){
        return instance;
    }
    public double getRate(){
        return 7.0;
    }
}

class RewardUtil {
    private RewardUtil(){}

    public static Integer calculate(double amt){
        return (int)amt;
    }
}

public class StarPaySystem {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== 欢迎来到星际支付账户开立中心 ======");

        //创建账户
        System.out.println("请输入您的姓名：");
        String name = scanner.next();

        System.out.println("请输入初始存款金额: ");
        String initialMoney = scanner.next();

        StarWallet userWallet = new StarWallet(name, initialMoney);
        System.out.println("账户创建成功！");

        //进入功能循环菜单
        boolean running = true;
        while (running) {
            System.out.println("\n----------------------------");
            System.out.println("请选择操作：1.查询余额  2.进行支付  3.查看汇率  4.退出系统");
            System.out.print("您的选择: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    userWallet.showBalance();
                    break;
                case 2:
                    System.out.println("请输入支付金额：");
                    double amt = scanner.nextDouble();
                    boolean success = userWallet.pay(amt);

                    if (success) {
                        // 展示积分
                        Integer points = RewardUtil.calculate(amt);
                        System.out.println("恭喜！本次交易获得积分: " + points);
                    }
                    break;

                case 3:
                    // 展示单例模式
                    double rate = ExchangeManager.getInstance().getRate();
                    System.out.println("\n实时星际汇率: 1 星际币 = " + rate + " 地球币");
                    break;

                case 4:
                    running = false;
                    System.out.println("感谢使用，系统已安全退出。");
                    break;

                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
        scanner.close();
    }
}