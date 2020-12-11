package project;

import java.util.Scanner;

public class AccountingBook {

	public static void main(String[] args) {
		boolean isFlag=true;
		String details="����覡\t   ������B\t�������\t     �l�B\n";
		int balance=10000;
		
		while(isFlag) {
			
			System.out.print("		   �O�b�� \n");
			System.out.println();
			System.out.print("		1.   ����\n");
			System.out.print("		2.   ���J\n");
			System.out.print("		3.   ��X\n");
			System.out.print("		4.   �h�X\n");
			System.out.println();
			System.out.print("	             �п�� 1-4�i�J\n");
		
			char getNumber=ReadSelection();
			
			switch(getNumber) {
			case '1':
				System.out.println("		   �ثe���� ");
				System.out.println("-------------------------------------------");
				//System.out.println("����覡\t   ������B\t�������\t     �l�B");
				System.out.println(details);
				
				System.out.println("-------------------------------------------");
				break;
				
			case '2':
				System.out.print("	               ��J���J���B: ");
				int getIncomeMoney=MoneyInsert();
				System.out.print("	           �������J���B����: ");
				String infoIn=Discription();
				System.out.println("	               ���J�n�O���� ");
				System.out.println("-------------------------------------------");
				balance+=getIncomeMoney;
				details+="���J\t  "+getIncomeMoney+"\t\t"+infoIn+"\t  "+balance+"\n";
				
				
				break;
			case '3':
				System.out.print("	               ��J��X���B: ");
				int getOutcomeMoney=MoneyInsert();
				System.out.print("	           ������X���B����: ");
				String infoOut=Discription();
				
				if(balance>=getOutcomeMoney) {
					balance-=getOutcomeMoney;
					details+="��X\t  "+getOutcomeMoney+"\t\t"+infoOut+"\t  "+balance+"\n";
					System.out.println("	                ��X�n�O���� ");
				}else {
					System.out.println("	                    �l�B���� ");
				}
				
				System.out.println("-------------------------------------------");
				break;
				
			case '4':
				System.out.print("	          �T�w�n�h�X��? (Y/N)");
				char isExit=ConfirmSelection();
				if(isExit=='Y') {
					isFlag=false;
					System.out.print("	               �U����!");
				}
			
			}
		}
	}
	
	//Ū���Ȥ��J���Ʀr
	public static char ReadSelection() {
		char c;
		for(;;) {
			String str=readNumber(1);
			c=str.charAt(0);
			if(str.length()>=2) {
				System.out.println("�r�ƹL�h! �п�J 1-4�C");
			}else if((c!='1') && (c!='2') && (c!='3') && (c!='4')) {
				System.out.println("�L�k�P�O! �п�J 1-4�C");
			}else {
				break;
			}
		}
		return c;
	}
	
	//Ū���Ȥ�����Ʀr
	private static String readNumber(int c) {
		Scanner scan=new Scanner(System.in);
		String readNumber=scan.next();
		return readNumber;
	}
	
	

	//���B��J
	public static int MoneyInsert() {
		int money;
		for(;;) {
			try{
				String str=readNumber(4);
				money=Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("���B��J���~�A�Э��s��J!");
			}
		}
		return money;
	}
	
	//������
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
				System.out.print("�r�ƹL�h�A�Э��s��J");
			}else if((c=='Y') || (c=='N')) {
				break;
			}else {
				System.out.print("�L�k�P�O�A�Э��s��J");
			}
				
		}
		return c;
	}

}
