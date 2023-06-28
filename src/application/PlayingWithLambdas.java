package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import service.MathFactory;

public class PlayingWithLambdas {

	public static void main(String[] args) {
		
		MathFactory<Integer> mf = new MathFactory<>();
		List<Integer> list = new ArrayList<>();
		
		//Testing a function with predicate
		Predicate<Integer> pred = x -> x % 2 == 0;
		
		System.out.println(mf.isEvenOrOdd(6) ? "is Even" : "is Odd");
		
		for (int i = 0; i < 7; i++) {
			System.out.println(mf.isEvenOrOdd(i, pred) ? (i + " is Even") : (i + " is Odd"));
			list.add(i);
		}
		
		//Testing the function modifyNumber
		Function<Integer, Integer> func = x -> x * 2;
		System.out.println(mf.modifyNumber(5, func));
		
		//Testing the function modifyListElements
		Consumer<Integer> consumer = x -> System.out.print(x + ", ");
		mf.modifyListElements(list, consumer);
		
		//Testing a function with BinaryOperator
		BinaryOperator<Integer> binOp = (number1 , number2) -> (number1 * number2) / 2;
		
		System.out.println("\nResult: " + mf.calculatorFunction(10, 5, binOp));
		
		//Testing biFunction
		BiFunction<Integer, Integer, String> biFunc = (x , y) -> "" + (x + y) / 3;
		
		System.out.println(mf.calculatorFunction("Result = ", 3, 6, biFunc));
		
	}

}
