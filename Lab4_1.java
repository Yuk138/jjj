public class Lab4_1 {
	public static void main (String[] args) {
		float a[]=new float[5];
		float sum=0.0f;
		if (args.length != 5)
		{
			// throw new IllegalArgumentException("程序需要5个参数");
			System.err.println("程序需要5个参数");
			return;
		}
		for(int i=0;i<a.length;i++){
			try
			{
				a[i]=Float.parseFloat(args[i]);
			}
			catch (NumberFormatException e)
			{
				// 字符转浮点数失败
				System.err.println("第" + (i + 1) + 
						"门字符转浮点数失败");
				return;
			}
			System.out.println ("第"+(i+1)+"门课程的成绩是:"+a[i]);
			sum=sum+a[i];
		}
		System.out.println("总成绩是："+sum);
		float avg=sum/a.length;
		System.out.println ("平均成绩是:"+avg);
	}
}
