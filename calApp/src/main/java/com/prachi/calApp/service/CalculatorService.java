package com.prachi.calApp.service;
import org.springframework.stereotype.Service;
@Service
public class CalculatorService {
  public String performCalculation(String operand1, String operand2,String operator)
  {
    int x=Integer.parseInt(operand1);
    int y=Integer.parseInt(operand2);
    int r=0;
    String p="";
    switch(operator)
    {
    case "+":   r=x+y;
          break;
    case "-":   r=x-y;
          break;
    case "*":   r=x*y;
          break;
    case "/":   r=x/y;
          break;
    case "%":   r=x%y;
          break;
    default:    p="ABC";
          break;
    }
    if(p.equals("ABC"))
    	return p;
    else
    	return String.valueOf(r);
  }
}

