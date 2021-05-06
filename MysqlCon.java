import java.sql.*;

import java.util.*;  
class MysqlCon{  
public static void main(String args[]){  
   
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");  

Statement stmt=con.createStatement(); 
Scanner sc= new Scanner(System.in); 
int a;
int id,mark,rno;


do
{
    System.out.println("choose option:");
    System.out.println("1:Insert Student Data:");
    System.out.println("2:Display Student Data:");
    System.out.println("3:Display Particluar Student Data:");
    System.out.println("4:Upadate mark:");
    System.out.println("Press any key:exit");
    a= sc.nextInt();  
    if(a==1)
    {
        System.out.println("Enter Student Id,Name,roll no and Mark:");
        id= sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        mark= sc.nextInt();
        rno= sc.nextInt();
        String query = " insert into student1 (id,name,rollno,mark)"
        + " values ("+id+",'"+name+"',"+rno+","+mark+")";
        try{
        stmt.executeUpdate(query);
        System.out.println("Record added successfully");
        }
        catch(Exception e)
        {
            System.out.println("Duplicate Data "+e);
        }

        
    }
    else if(a==2)
    {
        try
        {
        ResultSet rs=stmt.executeQuery("select * from student1");
        while(rs.next())
            {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4));
               }
        }
        catch(Exception e)
        {
             System.out.println("Exception"+e);
        }
     }
    else if(a==3)
    {
        System.out.println("Enter Student Id:");
        id= sc.nextInt();
         ResultSet rs=stmt.executeQuery("select * from student1 where id="+id+"");
      
       
          while(rs.next())
            {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+" "+rs.getInt(4));
               }
       
         if(rs.next()==false)
       {
             System.out.println("no Such Student Exist");
       }
        
        
    }
    else if(a==4)
    {
          System.out.println("Enter Student Id:");
          id= sc.nextInt();
          System.out.println("Enter new Mark:");
          mark= sc.nextInt();
          String query = "update student1 set mark="+mark+" where id="+id+"";
          try{
              
            ResultSet rs=stmt.executeQuery("select * from student1 where id="+id+"");
            if(rs.next()==false)
            {
                 System.out.println("No such data exist");
                 break;
             }
            stmt.executeUpdate(query);
            System.out.println("Record Updated successfully");
            }
          catch(Exception e)
          {
              System.out.println(e);
          }     
    }   
    
}while(a!=5);
con.close();  
}
catch(Exception e)
{ System.out.println(e);
}  
}  
}  