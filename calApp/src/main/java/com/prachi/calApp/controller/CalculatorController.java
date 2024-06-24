package com.prachi.calApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.prachi.calApp.exception.OperatorException;
import com.prachi.calApp.service.CalculatorService;

@ControllerAdvice
@RestController
public class CalculatorController {
  
  @Autowired
  private CalculatorService service;
  
  @GetMapping("/calculator")
  public ModelAndView showCalculatorEntryPage()
  {
    ModelAndView mv=new ModelAndView("CalculatorEntry");
    return mv;
  }
  
  @PostMapping("/calculate")
  public ModelAndView showCalculatorResultPage(@RequestParam("operand1") String s1, @RequestParam("operand2") String s2, @RequestParam("operator") String s3)
  {
    String result=service.performCalculation(s1, s2, s3);
    if(result.equals("ABC"))
      throw new OperatorException();
    ModelAndView mv=new ModelAndView("CalculatorResult");
    mv.addObject("output",result);
    return mv;
  }
  
  @ExceptionHandler(ArithmeticException.class)
  public ModelAndView handleArithmeticException(ArithmeticException exception)
  {
    String message="Divide by zero not possible";
    ModelAndView mv=new ModelAndView("errorPage");
    mv.addObject("errorMessage",message);
    return mv;  
  }
  @ExceptionHandler(NumberFormatException.class)
  public ModelAndView handleNumberFormatException(NumberFormatException exception)
  {
    String message="Wrong Number Format";
    ModelAndView mv=new ModelAndView("errorPage");
    mv.addObject("errorMessage",message);
    return mv;  
  }
  @ExceptionHandler(OperatorException.class)
  public ModelAndView handleOperatorException(OperatorException exception)
  {
    String message="Wrong Math Operator";
    ModelAndView mv=new ModelAndView("errorPage");
    mv.addObject("errorMessage",message);
    return mv;  
  }
}
