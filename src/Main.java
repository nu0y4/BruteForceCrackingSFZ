import java.util.*;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
	
	/*
	*
	*此项目未过滤男女性别
	*
	*/
        System.out.print("请输入带*号的身份证：");

        Scanner sc = new Scanner(System.in);
        String idcard = sc.nextLine();

        Writer wr = new FileWriter("/sdcard/网络安全/" + idcard + ".txt");
      
        //4002812004****1025
        if ((idcard.substring(idcard.indexOf("*") - 1, idcard.lastIndexOf("*")).length()) == 4 && idcard.indexOf("*") == 10)
        {
            String fist = idcard.substring(0, idcard.indexOf("*"));
            String last = idcard.substring(idcard.lastIndexOf("*") + 1, idcard.length());
            System.out.println("");
            String out_idcard = "";
            String momo,day = null; 
            Integer mo[] = new Integer[]{31,29,31,30,31,30,31,31,30,31,30,31};
            //System.out.println(fist+last);
            for (int i = 0;i < mo.length;i++)
            {

                if ((i + 1 + "").length() == 1)
                {                   
                    momo = "0" + (i + 1);
                }
                else
                {                   
                    momo = "" + (i + 1);
                }
                for (int b = 1;b <= mo[i];b++)
                {
                    //System.out.print("  日份："+b);

                    if ((b + "").length() == 1)
                    {
                        //System.out.println(out_idcard + "0" + last);

                        day = momo + "0" + b;
                    }
                    else
                    {
                        // System.out.println(out_idcard + last);
                        day = momo + b;
                    }
                    System.out.println("[*]" + fist + day + last);//输出身份证
                    wr.write(fist + day + last + "\r\n");
                }


            }
            wr.close();
        }
        
        //4508619521003****
        else if (idcard.substring(idcard.indexOf("*") - 1, idcard.lastIndexOf("*")).length() == 4 && idcard.lastIndexOf("*") + 1 == idcard.length())
        {
            String fist = idcard.substring(0, idcard.indexOf("*"));
            String yz[] = new String[]{"0","1","2","3","4","5","6","7","8","9","x"};
            for (int i=0;i <= 99;i++)
            {
                for (int b = 1;b <= 9;b++)
                {
                    if (("" + i).length() == 1)
                    {
                        for (int x = 0;x < yz.length;x++)
                        {
                            System.out.println("[*]" + fist + "0" + i + b + yz[x]);
                            wr.write(fist + "0" + i + b + yz[x] + "\r\n");
                        }
                    }
                    else
                    {
                        for (int x = 0;x < yz.length;x++)
                        {
                            System.out.println("[*]" + fist + i + b + yz[x]);
                            wr.write(fist + i + b + yz[x] + "\r\n");
                        }
                    }
                }
                
            }
            wr.close();
        }                
	}
}
