import java.util.Scanner;
/**
 * 为一个公司编写一个奖金计算程序，用当前年份减去某位员工入职的年份来计算该员工的在该公
 * 司工作的工龄，如果工龄为零，即当年才入职的员工，奖金为其一个月的工资；如果工龄没超过
 * 3年，奖金为其月工资乘以1.3；如果工龄为3年以上5年以下，奖金为其月工资*1.5；如果工龄为
 * 5年以上，奖金为其月工资*2。计算公式如下：
 * 	工龄不足一年：奖金=工资
 * 	工龄不足3年：奖金=工资*1.3
 * 	工龄3年以上、5年以下：奖金=工资*1.5
 * 	工龄5年以上：奖金=工资*2
 * 该程序需要入职的年份和月工资作为程序的输入数据，输出是该员工的奖金。如果输入的年份
 * 比当前年份大或者是负数或无效的字符串，则抛出一个自定义异常（IllegalYearException），
 * 并输出“无效入职年份”；如果输入的工资低于500或负数或者抛出一个
 * 自定义异常（IllegalSalaryException），并输出“无效月工资”。因此该程序需要定义两个
 * 用户自定义异常。 当有无效的入职年份或月工资数据输入时，程序显式抛出自定义异常
 * （建议完成时间40分钟）。
 */
public class CountSalary
{
	public static void main(String[] args)
	{
		var in = new Scanner(System.in);
		int yearOfEntry;
		int yearOfNow = java.time.LocalDate.now().getYear();
		System.out.print("请输入入职年份: ");
		yearOfEntry = in.nextInt();
		if (yearOfEntry > yearOfNow || yearOfEntry < 0)
		{
			throw new IllegalYearException();
		}
		System.out.print("请输入月工资: ");
		int salaryOfMonth = in.nextInt();
		if (salaryOfMonth < 500 || salaryOfMonth < 0)
		{
			throw new IllegalSalaryException();
		}
		
		double bonus;
		if (yearOfNow == yearOfEntry)
		{
			bonus = salaryOfMonth;
		}
		else if (yearOfNow - yearOfEntry < 3)
		{
			bonus = salaryOfMonth * 1.3;
		}
		else if (yearOfNow - yearOfEntry < 5)
		{
			bonus = salaryOfMonth * 1.5;
		}
		else
		{
			bonus = salaryOfMonth * 2;
		}
		System.out.println("奖金是" + bonus + "元。");
	}
}
/**
 * 如果输入的年份比当前年份大或者是负数或无效的字符串，
 * 则抛出一个自定义异常（IllegalYearException），并输出“无效入职年份”；
 */
class IllegalYearException extends RuntimeException
{
	public IllegalYearException()
	{
		super("无效入职年份");
	}
}
/**
 * 如果输入的工资低于500或负数或者抛出一个自定义异常（IllegalSalaryException），
 * 并输出“无效月工资”。
 */
class IllegalSalaryException extends RuntimeException
{
	public IllegalSalaryException()
	{
		super("无效月工资");
	}
}
