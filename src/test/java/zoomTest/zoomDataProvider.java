package zoomTest;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zoomDataProvider {
    @DataProvider(name="zoomDataIndia")
    public Iterator<Object[]> zoomDataUS(){
        List<Object[]> list=new ArrayList<>();
        Object[] data=new Object[7];
        data[0]="Sunny@gmail.com";
        data[1]="No Company";
        data[2]="Sunny";
        data[3]="Singh";
        data[4]="123456789";
        data[5]="141114";
        data[6]="I want to do QA";
        list.add(data);
        Object[] data1={"Rahul@gmail.com","Agriculture","Rahul","Kumar","4563537637","45678"," I want to do Java"};
        list.add(data1);
        return list.iterator();
    }
    @DataProvider(name="zoomDataUS")
    public Iterator<Object[]> zoomDataIndia(){
        List<Object[]> list=new ArrayList<>();
        Object[] data={"Tom@gmail.com","Tom-Horton","Tom","Horton","4563534546","567889"," I want life time memebership"};
        list.add(data);
        return list.iterator();
    }
}
