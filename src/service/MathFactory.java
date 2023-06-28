package service;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import exceptions.MethodsAlgException;

/*
 * This class is just to practice lambda and Generics concepts implementing some Funcional Interfaces
 * I know there are some ways to implement some methods but i wanted to use the concepts mentioned before
 * 
 * Cc: Essa classe é somente para praticar os conceitos de lambda e generics, implementando algumas Interfaces funcionais
 * Eu sei que tem várias maneiras para implementar alguns métodos, mas eu queria usar os conceitos mencionados anteriormente
 * 
 */

public class MathFactory<T extends Number> {
	
	private Predicate<? super T> predicate = a -> a.intValue() % 2 == 0;
	
	
	public Boolean isEvenOrOdd(T number) {
		
		if(number.getClass() != Integer.class) {
			throw new MethodsAlgException("Only integer can be even or odd");
		}
		
		return predicate.test(number);
	}
	
	//This operation modify a number function based
	public T modifyNumber(T number1,Function<T, T> operation) {
		return operation.apply(number1);
	}
	
	public void modifyListElements(List<T> list , Consumer<T> cons) {
		for (T t : list) {
			cons.accept(t);
		}
	}
	
	//Mini Function to test predicate as a parameter 
	public Boolean isEvenOrOdd(T number, Predicate<T> pred) {
		
		if(number.getClass() != Integer.class) {
			throw new MethodsAlgException("Only integer can be even or odd");
		}
		
		return pred.test(number);
	}
	
	//Function able to perform an calculation defined by user
	public T calculatorFunction(T number1, T number2 , BinaryOperator<T> binOp) {
		return binOp.apply(number1 , number2) ;
	}
	
	//function to make it return a phrase based on the mathematical operation and the text that the user has entered
	//NOTE: I think the algorithm is not the best but I really cant think of a better algorithm than this one
	public String calculatorFunction(String anwser, T number1, T number2 , BiFunction<T, T, String> biFunc) {
		
		String response = biFunc.andThen(a -> anwser).apply(number1, number2);
		
		String result = biFunc.apply(number1, number2);
		
		return response.concat(result);
	}
	
}
