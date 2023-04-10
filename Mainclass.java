package payrollmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mainclass {
	
	public static void main(String[] args) {
		Vairables v3=new Vairables(0);
		CallingMethod m6=new CallingMethod(v3);
		m6.methodCall();
	}
}

interface InterCreateAdminLogin{
	public void createAdminLoginMethod();
}
interface InterCreateUserLogin{
	public void createUserLoginMethod();
}
interface InterAdminLogin{
	public void methodAdminLogin();
}
interface InterUserLogin{
	public void methodUserLogin();
}
interface InterAddEmpDetail{
	public void methodAddEmployeeDetail();
	public void methodDisplayEmployeeDetailUser();
	public void methodDisplayEmployeeDetailAdmin();
}
interface InterModifyDetails{
	public void methodModifyEmployeeDetails();
	public void methodDeleteEmployeeDetails();
}
interface InterPayroll{
	public void methodGeneratePayroll();
	
}


class Vairables{
	String username,password,username1,password1;
	Vairables(String username,String password,String username1,String password1){
		this.username=username;
		this.password=password;
		this.username1=username1;
		this.password1=password1;
	}
	double EmployeeId;
	double BasicPay,Hra,ConveyanceAllowance,FoodAllowance,GrossSalary,NetPay,Pf,Esi,DaysPresent,PerDaySalary;
	Vairables(double EmployeeId, double BasicPay, double Hra, double ConveyanceAllowance,double FoodAllowance,double GrossSalary,double NetPay,double Pf,double Esi,double DaysPresent,double PerDaySalary)
	{
		this.EmployeeId=EmployeeId;
		this.BasicPay=BasicPay;
		this.Hra=Hra;
		this.ConveyanceAllowance=ConveyanceAllowance;
		this.FoodAllowance=FoodAllowance;
		this.GrossSalary=GrossSalary;
		this.NetPay=NetPay;
		this.Pf=Pf;
		this.Esi=Esi;
		this.DaysPresent=DaysPresent;
		this.PerDaySalary=PerDaySalary;
	}
	
	String EmployeeName,EmployeeAddress,Pincode,EmployeeEmail,EmployeePhno,EmployeeDob;
	Vairables(String EmployeeName,String Dob,String EmployeeAddress,String Pincode,String EmployeeEmail,String EmployeePhno)
	{
		this.EmployeeName=EmployeeName;
		this.EmployeeDob=EmployeeDob;
		this.EmployeeAddress=EmployeeAddress;
		this.Pincode=Pincode;
		this.EmployeeEmail=EmployeeEmail;
		this.EmployeePhno=EmployeePhno;
	}
	int getoption;
	Vairables(int getoption)
	{
		this.getoption=getoption;
	}
}


class AdminLoginCredentialsClass extends Thread implements InterCreateAdminLogin{
	//this is an original
	Scanner scan=new Scanner(System.in);
	Vairables got;
	String qry;
	AdminLoginCredentialsClass(Vairables got){
		this.got=got;
	}
public void createAdminLoginMethod() {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
		
		System.out.println("                  -- Create Admin Login --\n");
		System.out.println();
		System.out.print("create username : ");
		got.username=scan.nextLine();
		System.out.print("create password : ");
		got.password=scan.nextLine();
		qry="insert into adminlogintable values(?,?)";
		ps=con.prepareStatement(qry);
		ps.setString(1, got.username);
		ps.setString(2,got.password);
		ps.executeUpdate();
		Thread.sleep(1000);
		System.out.println("\n\n             ---Login ID created successfully---\n\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


class UserLoginCredentialsClass extends Thread implements InterCreateUserLogin{
	Scanner scan=new Scanner(System.in);
	
	Vairables wire;
	String qry;
	UserLoginCredentialsClass(Vairables wire){
		this.wire=wire;
	}
public void createUserLoginMethod() {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
		
		System.out.println("                  -- Create User Login --\n");
		System.out.print("create username : ");
		wire.username=scan.nextLine();
		System.out.print("create password : ");
		wire.password=scan.nextLine();
		qry="insert into userlogintable values(?,?)";
		ps=con.prepareStatement(qry);
		ps.setString(1, wire.username);
		ps.setString(2,wire.password);
		ps.executeUpdate();
		Thread.sleep(1000);
		System.out.println("\n      ---User Login created successfully---\n");
		System.out.println();
	
		Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
		Vairables v2=new Vairables("B","R","I","G","H","T");
		InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
		while(true)
		{
		System.out.println("\n1) Sign Up        2) Press any number to exit\n");
		System.out.print("Select : ");
		int gets=scan.nextInt();
		System.out.println();
		switch(gets) {
		
		case 1:{
			m3.methodDisplayEmployeeDetailUser();        //displaying  employee the details for employee
		}break;
		default :{
			System.exit(0);
		}break;
		}//switch
		}//while-true
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


class AdminLoginClass extends Thread implements InterAdminLogin{
	Scanner scanstring=new Scanner(System.in);
	Scanner scanint=new Scanner(System.in);

	Vairables get;
	String qry;
	int gets;
	AdminLoginClass(Vairables get){
		this.get=get;
	}
public void methodAdminLogin() {
		System.out.println("1) SignUp        2)Reset Password\n");
		System.out.print("Select : ");
		gets=scanint.nextInt();
		System.out.println();
		switch(gets) {
		
		case 1:{
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
		
		System.out.println("                    -- Admin Signin --\n");
		boolean check=false;
		System.out.print("username : ");
		get.username1=scanstring.nextLine();
		System.out.print("password : ");
		get.password1=scanstring.nextLine();
		qry="select * from adminlogintable";
		rs=st.executeQuery(qry);
		while(rs.next()) {
			if(get.username1.equals(rs.getString(1))&&get.password1.equals(rs.getString(2)))
			{
				check=true;
				Thread.sleep(1000);
				System.out.println("\n                 --- Login successfully ---\n");
				System.out.println();
				while(true)
				{
				System.out.println("\n1) Add new details        2) Modify details        3) Delete details        4) Generate Payroll        5)View details        6) Press any number to exit\n");
				System.out.print("Select : ");
				gets=scanint.nextInt();
				
				Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
				Vairables v2=new Vairables("B","R","I","G","H","T");
				InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
				InterModifyDetails m4=new ModifyEmployeeDetails();
				InterPayroll m5=new GeneratePayroll();
				
				switch(gets)
				{
				case 1:{
					m3.methodAddEmployeeDetail();	
				}break;//add details
				case 2:{
					m4.methodModifyEmployeeDetails();
				}break;
				case 3:{
					m4.methodDeleteEmployeeDetails();        //delete employee details admin
				}break;		
				case 4:{
					m5.methodGeneratePayroll();              //admin generate payroll
				}break;
				case 5:{
					m3.methodDisplayEmployeeDetailUser();
				}break;                                      //view details
				default:{
					System.exit(0);
				}break;
				}//switch
				}//while-true
			}
		}
		if(!check) 
			System.out.println("\n                   ---  Try again!! ---\n");
		
		while(true) {
			System.out.println("                    -- Admin Signin --\n");
		System.out.print("username : ");
		get.username1=scanstring.nextLine();
		System.out.print("password : ");
		get.password1=scanstring.nextLine();
		qry="select * from adminlogintable";
		rs=st.executeQuery(qry);
		while(rs.next()) {
			if(get.username1.equals(rs.getString(1))&&get.password1.equals(rs.getString(2)))
			{
				check=true;
				Thread.sleep(1000);
				System.out.println("\n                 --- Login successfully ---\n");
				System.out.println();
				
				Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
				Vairables v2=new Vairables("B","R","I","G","H","T");
				InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
				InterModifyDetails m4=new ModifyEmployeeDetails();
				InterPayroll m5=new GeneratePayroll();
				
				while(true) 
				{
					System.out.println("\n1) Add new details        2) Modify details        3) Delete details        4) Generate Payroll        5)View details        6) Press any number to exit\n");
				System.out.print("Select : ");
				gets=scanint.nextInt();
				System.out.println();
				switch(gets)
				{
				case 1:{
					m3.methodAddEmployeeDetail();	
				}break;                                   //add details
				case 2:{
					m4.methodModifyEmployeeDetails();
				}break;
				case 3:{
					m4.methodDeleteEmployeeDetails();      //delete employee details admin
				}break;
				
				case 4:{
					m5.methodGeneratePayroll();            //admin generate payroll
				}break;
				case 5:{
					m3.methodDisplayEmployeeDetailAdmin();
				}break;//view details
				default:{
					System.exit(0);
				}break;
		
				}//switch
				}//while-true
			}
		}
		if(!check) {
			System.out.println("\n                   ---  Try again!! ---\n");
					}
		}
		} catch (Exception e) {
			System.out.println(e);
		}
		}break;
		case 2:
		{
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
				Statement st=con.createStatement();
				ResultSet rs;
				PreparedStatement ps;
				boolean check=false;
				System.out.print("enter username	 : ");
				get.username=scanstring.nextLine();
				System.out.print("enter new password : ");
				get.password=scanstring.nextLine();
				qry="select * from adminlogintable";
				rs=st.executeQuery(qry);
				while(rs.next()) {
				if(get.username.equals(rs.getString(1))) {
					check=true;
				qry="update adminlogintable set password=? where username=?";
				ps=con.prepareStatement(qry);
				ps.setString(1, get.password);
				ps.setString(2, get.username);
				ps.executeUpdate();
				System.out.println();
				System.out.println("                      ---Reset successfully---\n");
//-----------------		
				while(true) {
				System.out.println("\n1) Login        2) Press any number to exit\n");
				System.out.print("Select : ");
				gets=scanint.nextInt();
				System.out.println();
				Vairables v=new Vairables("D","A","W","N");
				InterAdminLogin m1=new AdminLoginClass(v);
							
				switch(gets)
				{
				case 1:{
					m1.methodAdminLogin();                //signing up the admin userlogin
				}break;
				default :{
					System.exit(0);
				}break;
				}//switch
				}//while-true
				}//while-ResultSet
				}//if
				if(!check)
				{//if(!check)
					System.out.println("\n                   Entered ID is incorrect !!");
					System.out.println("\n                     --- Try again!!  ---\n");
					
					while(true) {//while
					System.out.print("enter username	 : ");
					get.username=scanstring.nextLine();
					System.out.print("enter new password : ");
					get.password=scanstring.nextLine();
					qry="select * from adminlogintable";
					rs=st.executeQuery(qry);
					while(rs.next()) {
						if(get.username.equals(rs.getString(1))) {
						check=true;
					qry="update adminlogintable set password=? where username=?";
					ps=con.prepareStatement(qry);
					ps.setString(1, get.password);
					ps.setString(2, get.username);
					ps.executeUpdate();
					System.out.println();
					System.out.println("                      ---Reset successfully---\n");
					while(true) {
						System.out.println("\n1) Login        2) Press any number to exit\n");
						System.out.print("Select : ");
						gets=scanint.nextInt();
						System.out.println();
						Vairables v=new Vairables("D","A","W","N");
						InterAdminLogin m1=new AdminLoginClass(v);				
						switch(gets)
						{
						case 1:{
							m1.methodAdminLogin();             //signing up the admin userlogin
						}break;
						default :{
							System.exit(0);
						}break;
						}//switch
						}//while-true
					}//if
					}//while-ResultSet
					if(!check) { //if(!check-this) 
						System.out.println("\n                   Entered ID is incorrect !!");
						System.out.println("\n                     --- Try again!!  ---\n");
					}//if(!check-this)
					}//while-True
					}//if(!check)
					
			} catch (Exception e) {
				System.out.println(e);
			}	
		}break;
		}//switch
	}
}


class UserloginClass extends Thread implements InterUserLogin{
	Scanner scan=new Scanner(System.in);
	Scanner scanint=new Scanner(System.in);

	Vairables gett;
	String qry;
	int gets;
	UserloginClass(Vairables gett){
		this.gett=gett;
	}
public void methodUserLogin() {
		System.out.println("1) SignUp        2)Reset Password\n");
		System.out.print("Select : ");
		gets=scanint.nextInt();
		System.out.println();
		switch(gets) {
		
		case 1:{
			try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
		
		System.out.println("\n                  -- User Signin --\n");
		boolean check=false;
		System.out.print("username : ");
		gett.username1=scan.nextLine();
		System.out.print("password : ");
		gett.password1=scan.nextLine();
		qry="select * from userlogintable";
		rs=st.executeQuery(qry);
		while(rs.next()) {
			if(gett.username1.equals(rs.getString(1))&&gett.password1.equals(rs.getString(2)))
			{
				check=true;
				Thread.sleep(1000);
				System.out.println("\n      ---Login successfully---");

				Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
				Vairables v2=new Vairables("B","R","I","G","H","T");
				InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
	
				while(true) 
				{
				System.out.println("\n1) View details        2) Press any number to exit\n");
				System.out.print("Select : ");
				gets=scanint.nextInt();
				System.out.println();
				switch(gets)
				{
				case 1:{
					m3.methodDisplayEmployeeDetailUser();    //displaying  employee the details for employee	
				}break;                                      //add details
				default :{
					System.exit(0);
				}break;
				}//switch
				}//while-True
			}
		}
		if(!check) 
			System.out.println("\n                   Entered ID is incorrect !!");
		System.out.println("\n                     --- Try again!!  ---\n");
	
		while(true) 
		{
		System.out.println("\n                  -- User Signin --\n");
		System.out.print("username : ");
		gett.username1=scan.nextLine();
		System.out.print("password : ");
		gett.password1=scan.nextLine();
		qry="select * from userlogintable";
		rs=st.executeQuery(qry);
		while(rs.next()) {
			if(gett.username1.equals(rs.getString(1))&&gett.password1.equals(rs.getString(2)))
			{
				check=true;
				Thread.sleep(1000);
				System.out.println("\n      ---Login successfully---\n");

				Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
				Vairables v2=new Vairables("B","R","I","G","H","T");
				InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
	
				while(true) 
				{
				System.out.println("\n1) View details        2) Press any number to exit\n");
				System.out.print("Select : ");
				gets=scanint.nextInt();
				System.out.println();
				switch(gets)
				{
				case 1:{
					m3.methodDisplayEmployeeDetailUser();           //displaying  employee the details for employee	
				}break;//add details
				default :{
					System.exit(0);
				}break;
				}//switch
				}
			}//while-True
		}
		if(!check) {
			System.out.println("\n                   Entered ID is incorrect !!");
			System.out.println("\n                     --- Try again!!  ---\n");
			}
			}//while-True
		
		} catch (Exception e) {
			System.out.println(e);
		}
		}break;
		
		case 2:{
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
					Statement st=con.createStatement();
					ResultSet rs;
					PreparedStatement ps;
					boolean check=false;
					System.out.print("enter username	 : ");
					gett.username=scan.nextLine();
					System.out.print("enter new password : ");
					gett.password=scan.nextLine();
					qry="select * from userlogintable";
					rs=st.executeQuery(qry);
					while(rs.next()) {
						if(gett.username.equals(rs.getString(1))) {
							check=true;						
					qry="update userlogintable set password=? where username=?";
					ps=con.prepareStatement(qry);
					ps.setString(1, gett.password);
					ps.setString(2, gett.username);
					ps.executeUpdate();
					System.out.println();
					System.out.println("                      ---Reset successfully---\n");
					
		//--------------------------------
					while(true) {
						System.out.println("\n1) Sign Up        2) Press any number to exit\n");
						System.out.print("Select : ");
						gets=scanint.nextInt();
						System.out.println();
						Vairables v=new Vairables("D","A","W","N");
						InterUserLogin m2=new UserloginClass(v);
	
						switch(gets)
						{
						case 1:{
						m2.methodUserLogin(); //signing up the employee userlogin
						}break;
						default :{
							System.exit(0);
						}break;
						}//switch
						}//while-true
	    //--------------------------------
						}//while-Result
					}//if
					if(!check) // if(!check)-1
					{
						System.out.println("\n                   Entered ID is incorrect !!");
						System.out.println("\n                     --- Try again!!  ---\n");
						while(true) 
						{
							System.out.print("enter username	 : ");
							gett.username=scan.nextLine();
							System.out.print("enter new password : ");
							gett.password=scan.nextLine();
							qry="select * from userlogintable";
							rs=st.executeQuery(qry);
							while(rs.next()) {
								if(gett.username.equals(rs.getString(1))) {
									check=true;						
							qry="update userlogintable set password=? where username=?";
							ps=con.prepareStatement(qry);
							ps.setString(1, gett.password);
							ps.setString(2, gett.username);
							ps.executeUpdate();
							System.out.println();
							System.out.println("                      ---Reset successfully---\n");	
		//--------------------------------
							while(true) {
								System.out.println("\n1) Sign Up        2) Press any number to exit\n");
								System.out.print("Select : ");
								gets=scanint.nextInt();
								System.out.println();
								Vairables v=new Vairables("D","A","W","N");
								InterUserLogin m2=new UserloginClass(v);
			
								switch(gets)
								{
								case 1:{
									m2.methodUserLogin(); //signing up the employee userlogin
								}break;
								default:{
									System.exit(0);
								}break;
								}//switch
								}//while-true
		//--------------------------------
							}//while-Result
							}//if
							if(!check) {
								System.out.println("\n                   Entered ID is incorrect !!");
								System.out.println("\n                     --- Try again!!  ---\n");		
						}//if-(!check)
						}//while-True
					}//if-(!check)-1
					}//try
				 catch (Exception e) {
					System.out.println(e);
				}		
		}break;
		}//switch
	}
}


class AddEmployeeDetails implements InterAddEmpDetail{
	Scanner scanint=new Scanner(System.in);
	Scanner scandouble=new Scanner(System.in);
	Scanner scanstring=new Scanner(System.in);
	
	Vairables emvar;
	Vairables emsal;
	String qry;
	
	AddEmployeeDetails(Vairables emvar,Vairables emsal){
		this.emvar=emvar;
		this.emsal=emsal;
	}
	
public void methodAddEmployeeDetail() {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			
		System.out.println("             --- Enter Employee Details ---	 ");
		System.out.println();
		System.out.print("Enter Employee ID  	  	: ");
		while(!scanint.hasNextDouble()) {
			System.out.println("\n 			!!  Enter in numbers  !!\n");
			scanint.nextLine();
			System.out.print("Enter Employee ID  	  	: ");
		}
		emvar.EmployeeId=scanint.nextDouble();
		System.out.print("Enter Employee Name     	: ");
		emvar.EmployeeName=scanstring.nextLine();
		
		System.out.println("\n          Date Format (YYYY-MM-DD) \n");
		System.out.print("Enter Employee DateOfBirth     	: ");
		emvar.EmployeeDob=scanstring.nextLine();
		
		System.out.println();
		System.out.println("           Address Format  ");
		System.out.println("(# HOUSE NO, STREET, CITY, COUNTRY)\n");
		System.out.print("Enter Employee Address  	: ");
		emvar.EmployeeAddress=scanstring.nextLine();
		System.out.print("Enter Employee Pincode  	: ");
		emvar.Pincode=scanstring.nextLine();
		System.out.print("Enter Employee E-Mail   	: ");
		emvar.EmployeeEmail=scanstring.nextLine();
		System.out.print("Enter Employee Contact Number   : ");
		emvar.EmployeePhno=scanstring.nextLine();
		System.out.print("Enter Employee No of Days Present     : ");
		while(!scandouble.hasNextDouble()) {
			System.out.println("\n 			!!  Enter in numbers  !!\n");
			System.out.print("Enter Employee No of Days Present   : ");
			scandouble.nextLine();
		}
		emsal.DaysPresent=scandouble.nextDouble();
		System.out.print("Enter Per Day Salary     : ");
		while(!scandouble.hasNextDouble()) {
			System.out.println("\n 			!!  Enter in numbers  !!\n");
			System.out.print("Enter Per Day Salary     : ");
			scandouble.nextLine();
		}
		emsal.PerDaySalary=scandouble.nextDouble();
		emsal.BasicPay=(emsal.DaysPresent*emsal.PerDaySalary);
		emsal.Hra=(double) (emsal.BasicPay*6/100);
		//System.out.println("hra "+emsal.Hra);    //-----
		emsal.FoodAllowance=(double)(emsal.BasicPay*4/100);
		//System.out.println("food "+emsal.FoodAllowance);   //-----
		emsal.ConveyanceAllowance=(double)(emsal.BasicPay*3/100);
		//System.out.println("conveyance "+emsal.ConveyanceAllowance);   //-----
		emsal.GrossSalary=(emsal.BasicPay+emsal.Hra+emsal.FoodAllowance+emsal.ConveyanceAllowance);
		//System.out.println("grosspay "+emsal.GrossSalary);   //-----
		emsal.Pf=(double)(emsal.GrossSalary*12/100);
		//System.out.println("pf "+emsal.Pf);   //-----
		emsal.Esi=(double)(emsal.GrossSalary*12/100);
		//System.out.println("esi "+emsal.Esi);   //-----
		emsal.NetPay=(double)(emsal.GrossSalary-emsal.Pf-emsal.Esi);
		//System.out.println("netpay "+emsal.NetPay);
		
		qry="insert into employeedetails (id,name,dob,address,pincode,email,phno,NoOfDaysPresent,PerDaySalary) values(?,?,?,?,?,?,?,?,?);";
		ps=con.prepareStatement(qry);
		ps.setDouble(1, emvar.EmployeeId);
		ps.setString(2, emvar.EmployeeName);
		ps.setString(3, emvar.EmployeeDob);
		ps.setString(4, emvar.EmployeeAddress);
		ps.setString(5, emvar.Pincode);
		ps.setString(6, emvar.EmployeeEmail);
		ps.setString(7, emvar.EmployeePhno);
		ps.setDouble(8, emsal.DaysPresent);
		ps.setDouble(9, emsal.PerDaySalary);
		ps.executeUpdate();
		System.out.println();
		System.out.println("                      ---Details added successfully---\n");
		
		} catch (Exception e) {
			System.out.println("\n               !! Please enter in correct format to save the details !!\n");
		}
	}
public void methodDisplayEmployeeDetailUser() {
		
	try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			boolean check=false;
			System.out.print("\nEnter Employee ID  	  	: ");
			emvar.EmployeeId=scanint.nextDouble();
			qry="select * from employeecheckdetails";
			rs=st.executeQuery(qry);	
			while(rs.next()) {
				if(emvar.EmployeeId==(rs.getDouble(1)))
				{
				check=true;
				System.out.println("\nID      : "+rs.getInt(1)+"\nName    : "+rs.getString(2)+"\nD.O.B   : "+rs.getString(3)+"\nAddress : "+rs.getString(4)+"\nPincode : "+rs.getInt(5)+"\nE-mail  : "+rs.getString(6)+"\nPhno    : "+rs.getString(7));
				}
				}
				{	if(!check)
					System.out.println("\n                   Entered ID is incorrect !!");
				}
		} catch (Exception e) {
			System.out.println(e);
		}	
	} 

public void methodDisplayEmployeeDetailAdmin() {
	Scanner scanstring=new Scanner(System.in);
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			boolean checks=false;
			int k=1;
			
			System.out.print("Enter Admin ID  	  	: ");
			String admin=scanstring.nextLine();
			qry="select * from adminlogintable";
			rs=st.executeQuery(qry);	
			while(rs.next()) {
				if(admin.equals(rs.getString(1)))
				{
					checks=true;
					qry="select * from employeedetails";
					rs=st.executeQuery(qry);	
					while(rs.next()) {
				System.out.println("\nSno             : "+k+"\nID              : "+rs.getInt(1)+"\nName            : "+rs.getString(2)+"\nD.O.B           : "+rs.getString(3)+"\nAddress         : "+rs.getString(4)+"\nPincode         : "+rs.getInt(5)+"\nE-mail          : "+rs.getString(6)+"\nPhno            : "+rs.getString(7) +"\nDays Present    : "+rs.getInt(8)+"\nPer Day Salary  : "+rs.getInt(9)+"\n---------------------------\n"+"Basic Pay       : "+rs.getDouble(10)+"\n---------------------------\n"+"HRA             : "+rs.getDouble(11)+"\nFood Allowance  : "+rs.getDouble(12)+"\nConveyance      : "+rs.getDouble(13)+"\nGross Salary    : "+rs.getDouble(14)+"\nPF              : "+rs.getDouble(15)+"\nESI             : "+rs.getDouble(16)+"\n---------------------------\n"+"Total Deduction : "+rs.getDouble(17)+"\n---------------------------\n"+"Net Pay         : "+rs.getDouble(18)+"\n---------------------------\n\n");
				k++;
				}
				}
				}
				{	if(!checks)
					System.out.println("\n                   Entered ID is incorrect !!");
				}
		} catch (Exception e) {
			System.out.println(e);
		}
	} 
}


class ModifyEmployeeDetails implements InterModifyDetails{
	Scanner scandouble=new Scanner(System.in);
	Scanner scanstring=new Scanner(System.in);
public void methodModifyEmployeeDetails() 
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			InterModifyDetails m4=new ModifyEmployeeDetails();
		
		System.out.println("\n1) Address        2) Pincode        3) E-mail        4) Phone No        5)Press any number to exit");
		System.out.print("\nSelect to modify : ");
		int getswich=scandouble.nextInt();
		System.out.println();
		int getid;
		boolean tru=false;
		String qry,modifydetails;
		switch(getswich) 
		{
			case 1:{
			System.out.print("Enter Employee ID : ");
			getid=scandouble.nextInt();
			qry="select * from employeedetails";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(getid==(rs.getDouble(1))) {
					tru=true;
			System.out.print("Enter New Address : ");
			modifydetails=scanstring.nextLine();
			qry="update employeedetails set Address=? where id=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, modifydetails);
			ps.setInt(2, getid);
			ps.executeUpdate();
			System.out.println("\n                 --- Address updated successfully ---\n");
			m4.methodModifyEmployeeDetails();
			}//if
			}//while ResultSet
			if(!tru) {
				System.out.println("\n                   Entered ID is incorrect !!");
				while(true)
				{
					System.out.print("Enter Employee ID : ");
					getid=scandouble.nextInt();
					qry="select * from employeedetails";
					rs=st.executeQuery(qry);
					while(rs.next()) {
						if(getid==(rs.getDouble(1))) {
							tru=true;
					System.out.print("Enter New Address : ");
					modifydetails=scanstring.nextLine();
					qry="update employeedetails set Address=? where id=?";
					ps=con.prepareStatement(qry);
					ps.setString(1, modifydetails);
					ps.setInt(2, getid);
					ps.executeUpdate();
					System.out.println("\n                 --- Address updated successfully ---\n");
					m4.methodModifyEmployeeDetails();
					}//if
					}//while ResultSet
				
				if(!tru) {
						System.out.println("\n                   Entered ID is incorrect !!");
				}
				}
			}
		}break;                                    //address
		
		case 2:{
			System.out.print("Enter Employee ID : ");
			getid=scandouble.nextInt();
			qry="select * from employeedetails";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(getid==(rs.getDouble(1))) {
					tru=true;
			System.out.print("Enter Pincode : ");
			modifydetails=scanstring.nextLine();
			qry="update employeedetails set Pincode=? where id=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, modifydetails);
			ps.setInt(2, getid);
			ps.executeUpdate();
			System.out.println("\n                 --- Pincode updated successfully ---\n");
			m4.methodModifyEmployeeDetails();
				}
			}if(!tru) {
				System.out.println("\n                   Entered ID is incorrect !!");
				while(true)
				{
				System.out.print("Enter Employee ID : ");
				getid=scandouble.nextInt();
				qry="select * from employeedetails";
				rs=st.executeQuery(qry);
				while(rs.next()) {
					if(getid==(rs.getDouble(1))) {
						tru=true;
				System.out.print("Enter Pincode : ");
				modifydetails=scanstring.nextLine();
				qry="update employeedetails set Pincode=? where id=?";
				ps=con.prepareStatement(qry);
				ps.setString(1, modifydetails);
				ps.setInt(2, getid);
				ps.executeUpdate();
				System.out.println("\n                 --- Pincode updated successfully ---\n");
				m4.methodModifyEmployeeDetails();
					}
				}if(!tru) {
					System.out.println("\n                   Entered ID is incorrect !!");
				}
				}
			}
		}break;                                    //pincode

		case 3:{
			System.out.print("Enter Employee ID : ");
			getid=scandouble.nextInt();
			qry="select * from employeedetails";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(getid==(rs.getDouble(1))) {
					tru=true;
			System.out.print("Enter New E-mail : ");
			modifydetails=scanstring.nextLine();
			qry="update employeedetails set Email=? where id=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, modifydetails);
			ps.setInt(2, getid);
			ps.executeUpdate();
			System.out.println("\n                 --- E-mail updated successfully ---\n");
			m4.methodModifyEmployeeDetails();
				}
			}
			if(!tru) {
				System.out.println("\n                   Entered ID is incorrect !!");
				while(true)
				{
					System.out.print("Enter Employee ID : ");
					getid=scandouble.nextInt();
					qry="select * from employeedetails";
					rs=st.executeQuery(qry);
					while(rs.next()) {
						if(getid==(rs.getDouble(1))) {
							tru=true;
					System.out.print("Enter New E-mail : ");
					modifydetails=scanstring.nextLine();
					qry="update employeedetails set Email=? where id=?";
					ps=con.prepareStatement(qry);
					ps.setString(1, modifydetails);
					ps.setInt(2, getid);
					ps.executeUpdate();
					System.out.println("\n                 --- E-mail updated successfully ---\n");
					m4.methodModifyEmployeeDetails();
						}
					}
					if(!tru) {
						System.out.println("\n                   Entered ID is incorrect !!");
					}
				}
			}
		}break;                                      //e-mail
	
		case 4:{
			System.out.print("Enter Employee ID : ");
			getid=scandouble.nextInt();
			qry="select * from employeedetails";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(getid==(rs.getDouble(1))) {
					tru=true;
			System.out.print("Enter Phone no : ");
			modifydetails=scanstring.nextLine();
			qry="update employeedetails set Phno=? where id=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, modifydetails);
			ps.setInt(2, getid);
			ps.executeUpdate();
			System.out.println("\n                 --- Phone no updated successfully ---\n");
			m4.methodModifyEmployeeDetails();
				}
			}
			if(!tru) 
			{
				System.out.println("\n                   Entered ID is incorrect !!");
				while(true)
				{
					System.out.print("Enter Employee ID : ");
					getid=scandouble.nextInt();
					qry="select * from employeedetails";
					rs=st.executeQuery(qry);
					while(rs.next()) {
						if(getid==(rs.getDouble(1))) {
							tru=true;
					System.out.print("Enter Phone no : ");
					modifydetails=scanstring.nextLine();
					qry="update employeedetails set Phno=? where id=?";
					ps=con.prepareStatement(qry);
					ps.setString(1, modifydetails);
					ps.setInt(2, getid);
					ps.executeUpdate();
					System.out.println("\n                 --- Phone no updated successfully ---\n");
					m4.methodModifyEmployeeDetails();
						}
					}
					if(!tru) 
					{
						System.out.println("\n                   Entered ID is incorrect !!");				
					}
				}
			}
		}break;//phone no
	
		default:{
			System.exit(0);
		}break;                                   //exit (break to stop the case)
		
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
public void methodDeleteEmployeeDetails()
	{
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			Double emp;
			boolean check=false;
			System.out.print("Enter Employee ID to delete from record : ");
			emp=scandouble.nextDouble();
			String qry="select * from employeedetails";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(emp==(rs.getDouble(1)))
				{
					check=true;
					qry="delete from employeedetails where id=?";
					ps=con.prepareStatement(qry);
					ps.setDouble(1, emp);
					ps.executeUpdate();
					System.out.println("\n                 --- Record deleted successfully ---\n");
				}
			}
			if(!check)
			{
				System.out.println("\n              Employee ID doesn't match !!");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


class GeneratePayroll implements InterPayroll{
	Scanner scandouble=new Scanner(System.in);
public void methodGeneratePayroll() 
	{
		int getswich;
		System.out.println("\n1) Search by Employee ID        2) View All\n");
		System.out.print("Select : ");
		getswich=scandouble.nextInt();
		System.out.println();
		switch(getswich) {
		
		case 1:{
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
			Statement st=con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			double getid;
			boolean check=false;
			System.out.println("\n       --- Generate Payroll ---");
			System.out.print("\nEnter Employee Id : ");
			getid=scandouble.nextDouble();
			String qry="select * from employeepayroll";
			rs=st.executeQuery(qry);
			while(rs.next()) {
				if(getid==(rs.getDouble(1)))
				{	
					check=true;
					qry="select * from employeepayroll where id=?";
					System.out.println("\nID              : "+rs.getInt(1)+"\nBasic Pay       : "+rs.getLong(2)+"\nHRA             : "+rs.getDouble(3)+"\nFood Allowance  : "+rs.getDouble(4)+"\nConveyance      : "+rs.getDouble(5)+"\nGross Salary    : "+rs.getDouble(6)+"\nPF              : "+rs.getDouble(7)+"\nESI             : "+rs.getDouble(8)+"\nTotal Deduction : "+rs.getDouble(9)+"\nNet Pay         : "+rs.getDouble(10));
				}
			}
			if(!check) {
				System.out.println("\n              Employee ID doesn't match !!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		}break;                                       // search by id
		
		case 2:{
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/payrollmanagement","root","");
				Statement st=con.createStatement();
				ResultSet rs;
				int k=1;
				String qry="select * from employeepayroll";
				rs=st.executeQuery(qry);
				while(rs.next()) {
					System.out.println("\nSno             : "+k+"\nID              : "+rs.getInt(1)+"\nBasic Pay       : "+rs.getDouble(2)+"\nHRA             : "+rs.getDouble(3)+"\nFood Allowance  : "+rs.getDouble(4)+"\nConveyance      : "+rs.getDouble(5)+"\nGross Salary    : "+rs.getDouble(6)+"\nPF              : "+rs.getDouble(7)+"\nESI             : "+rs.getDouble(8)+"\nNet Pay         : "+rs.getDouble(9)+"\n---------------------------\n");
				k++;}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}break;                                        //view all
		}
	}
}


class CallingMethod{
	Scanner scandint=new Scanner(System.in);

	Vairables v=new Vairables("D","A","W","N");
	Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
	Vairables v2=new Vairables("B","R","I","G","H","T");
	Vairables v3=new Vairables(0);	

	InterCreateAdminLogin l=new AdminLoginCredentialsClass(v);//	
	InterAdminLogin m1=new AdminLoginClass(v);
	InterCreateUserLogin m0=new UserLoginCredentialsClass(v);
	InterUserLogin m2=new UserloginClass(v);
	InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);

	Vairables gets;
	CallingMethod(Vairables gets)
	{
		this.gets=gets;
	}
	
public void methodCall() {
		
		System.out.println("1) Admin Login        2)Employee Login        3) Press any number to exit\n");
		System.out.print("Select : ");
		gets.getoption=scandint.nextInt();
		System.out.println();
		switch(gets.getoption)
		{
		case 1:{							    //-------------------Maincase-----------------------------------------------------
			System.out.println("1) Create Admin login        2) Sign Up Admin login        3) Press any number to exit\n");
			System.out.print("Select : ");
			gets.getoption=scandint.nextInt();
			System.out.println();
			switch(gets.getoption) 
			{
			case 1:{
				l.createAdminLoginMethod();    //creating admin username/password
				m1.methodAdminLogin();         //signing up the admin userlogin
				}break;		                   //create admin login   ---> sign up
			case 2:{
				m1.methodAdminLogin();         //signing up the admin userlogin
				m3.methodAddEmployeeDetail();  // adding new employee details
				System.exit(0);	
				}break;		                   //sign up admin login  ---> add employee details(add record, delete, modify, display, generate payroll)
			
			default :{
				System.exit(0);
			}break;		                      //exit
			}
		}break;		                          // admin login //-------------------Maincase-----------------------------------------------------
		
		case 2:{ 						      //-------------------Maincase-----------------------------------------------------
			System.out.println("1) Create Employee login        2) Sign Up Employee login        3) Press any number to exit\n");
			System.out.print("Select : ");
			gets.getoption=scandint.nextInt();
			System.out.println();
			switch(gets.getoption) 
			{
			case 1:{
				m0.createUserLoginMethod(); //creating employee username/password
					}break;		                   //create Employee login   ---> sign up
			case 2:{
				m2.methodUserLogin();     //signing up the employee userlogin
					}break;		                  //sign up Employee login  ---> //displaying  employee the details for employee
			default :{
				System.exit(0);
					}break;		                  //exit
			}
		}break;		                      // employee login     //-------------------Maincase-----------------------------------------------------
				
		default :				         //-------------------Maincase-----------------------------------------------------
		{
			System.exit(0);
		}break;		                     //Exit              //--------------------Maincase----------------------------------------------------
		}
	}
}





/*
callingOfMethods{
//	Vairables v=new Vairables("D","A","W","N");
//	Vairables v1=new Vairables(1,2,3,4,5,6,7,8,9,0,1);
//	Vairables v2=new Vairables("B","R","I","G","H","T");
	Vairables v3=new Vairables(0);
	
	
	
//	InterCreateAdminLogin l=new AdminLoginCredentialsClass(v);
//	l.createAdminLoginMethod(); //creating admin username/password
//	
//	InterAdminLogin m1=new AdminLoginClass(v);
//	m1.methodAdminLogin(); //signing up the admin userlogin
//	
//	InterCreateUserLogin m0=new UserLoginCredentialsClass(v);
//	m0.createUserLoginMethod(); //creating employee username/password
//	
//	InterUserLogin m2=new UserloginClass(v);
//	m2.methodUserLogin(); //signing up the employee userlogin
	
//	InterAddEmpDetail m3=new AddEmployeeDetails(v2,v1);
//	m3.methodAddEmployeeDetail(); // adding new employee details
//	m3.methodDisplayEmployeeDetailUser(); //displaying  employee the details for employee
//	m3.methodDisplayEmployeeDetailAdmin(); //displaying  employee the details for admin

//	InterModifyDetails m4=new ModifyEmployeeDetails();
//	m4.methodDeleteEmployeeDetails(); //delete employee details admin
//	m4.methodModifyEmployeeDetails(); 

//	InterPayroll m5=new GeneratePayroll();
//	m5.methodGeneratePayroll(); //admin generate payroll
	
	CallingMethod m6=new CallingMethod(v3);
	m6.methodCall();

}*/