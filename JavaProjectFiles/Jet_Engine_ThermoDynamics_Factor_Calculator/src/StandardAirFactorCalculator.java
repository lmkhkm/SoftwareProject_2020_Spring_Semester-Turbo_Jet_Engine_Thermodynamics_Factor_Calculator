/* 
 * Class ���� Standard Air ǥ�� �̿��� ������ �����Ͽ� ���� ������ ����ϴ� Ŭ�����̴�.
 * ����Ʈ ���� �ԷµǾ� ������ ���� ������ �� �ִ�.
 * 
 */


import java.util.LinkedList;
import java.util.List;
// java Import


public class StandardAirFactorCalculator //Ŭ���� �̸�
{
	
	List<List<Float>> dataList = new LinkedList<>(); //�����͸� ǥ ���·� �����ϱ� ���� ����Ʈ
	List<Float> height = new LinkedList<>(); // �� ���� �����ϱ� ���� ����Ʈ
	List<Float> pressure = new LinkedList<>(); // �з� ���� �����ϱ� ���� ����Ʈ
	List<Float> interpolationCoefficient = new LinkedList<>(); //���� ���׽��� ���� ����� �����ϱ� ���� ����Ʈ
	
	public StandardAirFactorCalculator() //������
	{
		DefaultClassSetting();//�����ڰ� ȣ��� �� ���� ȣ��Ǿ� Ŭ���� ���ڸ� ����Ʈ ������ �ʱ�ȭ ������
		dataList.add(height);//������ ����Ʈ�� ���� �߰�
		dataList.add(pressure);//������ ����Ʈ�� �з��� �߰�
	}
	
	public void DefaultClassSetting()//�����ڿ� ���� ȣ��ǰų� ���������� ���Ǿ� Ŭ���� �ʵ带 ����Ʈ ������ �ʱ�ȭ�ϴ� �Լ�
	{
		for(int i=0;i<4;i++)
		{
			height.add(i*1500f+500f);
		}
		pressure.add((float)0.9546);
		pressure.add((float)0.795);
		pressure.add((float)0.6578);
		pressure.add((float)0.5405);
		//�̻� ����Ʈ��
	}
	
	private void NewtonInterpolation() //���� ������ ���ִ� �Լ� �ۼ���
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
	
	public boolean ChangeData()//�����͸� �ٲٴ� �Լ� �ۼ���
	{
		return false;
	}
	
	public void ShowAllData()//�����͸� ���� �����ִ� �Լ� �ۼ���
	{
		
	}
	
	public float Calculate(float height)//���� �Է��ϸ� �з��� �����ִ� �Լ�
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
		
		System.out.println("��갪 : "+calculatedFactor);
		return calculatedFactor;
	}
}
