package FlappyBird;

import java.text.DecimalFormat;

public class CurrencyConvertor {

	public static double covFromILS(String coin, String amount) // convert from ILD to USD or EUR
	{
		double result = 0;              // creating a var to save the return amount
		if(coin.equals("ILS"))          // if the coin is ILS to IL
			result = Double.parseDouble(amount);
		else
		{
			if(coin.equals("DOLLAR"))     // if the coin is ILS to USD
			{
				result = Double.parseDouble(amount)/3.2;
			}
			else
				result = Double.parseDouble(amount) /3.7;          // if the coin is ILS to EUR
		}
		return result;  //returning
	}
	
	public static double covFromUSD(String coin, String amount) // convert from USD to EUR or ILS
	{
		double result = 0;   // creating a var to save the return amount
		if(coin.equals("DOLLAR"))   // if the coin is USD to USD
			result = Double.parseDouble(amount);
		else 
		{
			if(coin.equals("ILS"))   // if the coin is USD to ILS
				result = Double.parseDouble(amount)*3.2;
			else                     // if the coin is USD to EUR
				result = Double.parseDouble(amount) /1.16;
		}
		return result;             //returning
	}
	public static double covFromEUR(String coin, String amount) // convert from EUR to USD or ILS
	{
		double result = 0;       // creating a var to save the return amount
		if(coin.equals("EURO"))   // if the coin is EUR to EUR
			result = Double.parseDouble(amount);
		else 
		{ 
			if(coin.equals("ILS"))   // if the coin is EUR to ILS
				result = Double.parseDouble(amount)*3.7;
			else                     // if the coin is EUR to USD
				result = Double.parseDouble(amount)/0.86;
		}
		return result;     //returning
	}
}
