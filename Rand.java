import java.util.*;
public class Rand{

    public static void main(String []args)
    {

        Random r=new Random();
        HashSet<Integer> set= new HashSet<Integer>();
        while(set.size()<1)
        {
            int ran=r.nextInt(99)+100000;
            set.add(ran);
        }
        int len = 6;
        String random=String.valueOf(len);
        for(int  random1:set)
        {
            System.out.println(random1);
            random=Integer.toString(random1);

        }
    }
}