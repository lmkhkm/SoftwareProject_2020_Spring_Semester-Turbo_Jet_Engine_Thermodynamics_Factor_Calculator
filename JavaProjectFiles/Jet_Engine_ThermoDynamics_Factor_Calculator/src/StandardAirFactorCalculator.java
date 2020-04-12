import java.util.LinkedList;
import java.util.List;

public class StandardAirFactorCalculator 
{
	
	List<List> dataList = new LinkedList<>();
	List height = new LinkedList();
	List pressure = new LinkedList();
	List interpolationCoefficient = new LinkedList();
	
	public StandardAirFactorCalculator()
	{
		DefaultClassSetting();
		dataList.add(height);
		dataList.add(pressure);
	}
	
	public void DefaultClassSetting()
	{
		for(int i=0;i<4;i++)
		{
			height.add((int)i*1500+500);
		}
		pressure.add((float)0.9546);
		pressure.add((float)0.795);
		pressure.add((float)0.6578);
		pressure.add((float)0.5405);
	}
	
	private void NewtonInterpolation()
	{
		float [] iter1 = new float[this.height.size()-1];
		float [] iter2 = new float[this.height.size()-2];
		float [] iter3 = new float[this.height.size()-3];
		
		for (int i=0;i<3;i++)
		{
			iter1[i] = ((float)pressure.get(i+1)-(float)pressure.get(i))/((float)height.get(i+1)-(float)height.get(i));
		}
		for (int i=0;i<2;i++)
		{
			iter2[i] = (iter1[i+1]-iter1[0])/((float)height.get(i+2)-(float)height.get(i));
		}
		iter3[0] = (iter2[1]-iter2[0])/((float)height.get(3)-(float)height.get(0));
		
		interpolationCoefficient.add(pressure.get(0));
		interpolationCoefficient.add(iter1[0]);
		interpolationCoefficient.add(iter2[0]);
		interpolationCoefficient.add(iter3[0]);
		
		
		
	}
	
	public boolean ChangeData()
	{
		return false;
	}
	
}
