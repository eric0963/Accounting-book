package project;

import java.util.Scanner;

public class AccountingBook {

	public static void main(String[] args) {
		boolean isFlag=true;
		String details="交易方式\t   交易金額\t交易說明\t     餘額\n";
		int balance=10000;
		
		while(isFlag) {
			
			System.out.print("		   記帳本 \n");
			System.out.println();
			System.out.print("		1.   明細\n");
			System.out.print("		2.   收入\n");
			System.out.print("		3.   支出\n");
			System.out.print("		4.   退出\n");
			System.out.println();
			System.out.print("	             請選擇 1-4進入\n");
		
			char getNumber=ReadSelection();
			
			switch(getNumber) {
			case '1':
				System.out.println("		   目前明細 ");
				System.out.println("-------------------------------------------");
				//System.out.println("交易方式\t   交易金額\t交易說明\t     餘額");
				System.out.println(details);
				
				System.out.println("-------------------------------------------");
				break;
				
			case '2':
				System.out.print("	               輸入收入金額: ");
				int getIncomeMoney=MoneyInsert();
				System.out.print("	           本次收入金額說明: ");
				String infoIn=Discription();
				System.out.println("	               收入登記完成 ");
				System.out.println("-------------------------------------------");
				balance+=getIncomeMoney;
				details+="收入\t  "+getIncomeMoney+"\t\t"+infoIn+"\t  "+balance+"\n";
				
				
				break;
			case '3':
				System.out.print("	               輸入支出金額: ");
				int getOutcomeMoney=MoneyInsert();
				System.out.print("	           本次支出金額說明: ");
				String infoOut=Discription();
				
				if(balance>=getOutcomeMoney) {
					balance-=getOutcomeMoney;
					details+="支出\t  "+getOutcomeMoney+"\t\t"+infoOut+"\t  "+balance+"\n";
					System.out.println("	                支出登記完成 ");
				}else {
					System.out.println("	                    餘額不足 ");
				}
				
				System.out.println("-------------------------------------------");
				break;
				
			case '4':
				System.out.print("	          確定要退出嗎? (Y/N)");
				char isExit=ConfirmSelection();
				if(isExit=='Y') {
					isFlag=false;
					System.out.print("	               下次見!");
				}
			
			}
		}
	}
	
	//讀取客戶輸入的數字
	public static char ReadSelection() {
		char c;
		for(;;) {
			String str=readNumber(1);
			c=str.charAt(0);
			if(str.length()>=2) {
				System.out.println("字數過多! 請輸入 1-4。");
			}else if((c!='1') && (c!='2') && (c!='3') && (c!='4')) {
				System.out.println("無法判別! 請輸入 1-4。");
			}else {
				break;
			}
		}
		return c;
	}
	
	//讀取客戶按的數字
	private static String readNumber(int c) {
		Scanner scan=new Scanner(System.in);
		String readNumber=scan.next();
		return readNumber;
	}
	
	

	//金額輸入
	public static int MoneyInsert() {
		int money;
		for(;;) {
			try{
				String str=readNumber(4);
				money=Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("金額輸入錯誤，請重新輸入!");
			}
		}
		return money;
	}
	
	//說明欄
	public static String Discription() {
		String str=readNumber(32);
		return str;
	}
	
	//yes & no
	public static char ConfirmSelection() {
		char c;
		for(;;) {
			String str=readNumber(1).toUpperCase();
			c=str.charAt(0);
			
			if(str.length()>=2) {
				System.out.print("字數過多，請重新輸入");
			}else if((c=='Y') || (c=='N')) {
				break;
			}else {
				System.out.print("無法判別，請重新輸入");
			}
				
		}
		return c;
	}

}
