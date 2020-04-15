/* 
 * Class 설명 Standard Air 표를 이용한 값들을 보간하여 여러 값들을 출력하는 클래스이다.
 * 디폴트 값이 입력되어 있으며 값을 수정할 수 있다.
 * 
 */


import java.util.LinkedList;
import java.util.List;
// java Import


public class StandardAirFactorCalculator //클래스 이름
{
	
	List<List<Float>> dataList = new LinkedList<>(); //데이터를 표 형태로 저장하기 위한 리스트
	List<Float> height = new LinkedList<>(); // 고도 값을 저장하기 위한 리스트
	List<Float> pressure = new LinkedList<>(); // 압력 값을 저장하기 위한 리스트
	List<Float> interpolationCoefficient = new LinkedList<>(); //보간 다항식의 항의 계수를 저장하기 위한 리스트
	
	public StandardAirFactorCalculator() //생성자
	{
		DefaultClassSetting();//생성자가 호출될 때 같이 호출되어 클래스 인자를 디폴트 값으로 초기화 시켜줌
		dataList.add(height);//데이터 리스트에 고도를 추가
		dataList.add(pressure);//데이터 리스트에 압력을 추가
	}
	
	public void DefaultClassSetting()//생성자와 같이 호출되거나 독립적으로 사용되어 클래스 필드를 디폴트 값으로 초기화하는 함수
	{
		for(int i=0;i<4;i++)
		{
			height.add(i*1500f+500f);
		}
		pressure.add((float)0.9546);
		pressure.add((float)0.795);
		pressure.add((float)0.6578);
		pressure.add((float)0.5405);
		//이상 디폴트값
	}
	
	private void NewtonInterpolation() //뉴턴 보간을 해주는 함수 작성중
	{
		float [] iter1 = new float[this.height.size()-1];
		float [] iter2 = new float[this.height.size()-2];
		float [] iter3 = new float[this.height.size()-3];
		
		for (int i=0;i<3;i++)
		{
			iter1[i] = (pressure.get(i+1)-pressure.get(i))/(height.get(i+1)-height.get(i));
		}
		for (int i=0;i<2;i++)
		{
			iter2[i] = (iter1[i+1]-iter1[i])/((float)height.get(i+2)-(float)height.get(i));
		}
		iter3[0] = (iter2[1]-iter2[0])/((float)height.get(3)-(float)height.get(0));
		
		interpolationCoefficient.add(pressure.get(0));
		interpolationCoefficient.add(iter1[0]);
		interpolationCoefficient.add(iter2[0]);
		interpolationCoefficient.add(iter3[0]);
		
	}
	
	public boolean ChangeData()//데이터를 바꾸는 함수 작성중
	{
		return false;
	}
	
	public void ShowAllData()//데이터를 전부 보여주는 함수 작성중
	{
		
	}
	
	public float Calculate(float height)//고도를 입력하면 압력을 보여주는 함수
	{
		float calculatedFactor;
		
		NewtonInterpolation();
		
		calculatedFactor = 
				interpolationCoefficient.get(0)
				+ 
				interpolationCoefficient.get(1)*(height-this.height.get(0))
				+ 
				interpolationCoefficient.get(2)*(height-this.height.get(0))*(height-this.height.get(1))
				+ 
				interpolationCoefficient.get(3)*(height-this.height.get(0))*(height-this.height.get(1))*(height-this.height.get(2));
		
		System.out.println("계산값 : "+calculatedFactor);
		return calculatedFactor;
	}
}
