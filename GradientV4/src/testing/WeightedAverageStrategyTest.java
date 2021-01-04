package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;



import grading.Grade;
import grading.LeafGrade;
import grading.WeightedAverageStrategy;


/**
 * 
 * @author Bunguiu Norales
 *
 */
class WeightedAverageStrategyTest 
{

	@Test
	void testGradeCalculateWithNoWeights()
	{

		Grade leGrade = new LeafGrade("one", 5.0);
		Grade ilGrade = new LeafGrade("two", 8.0);
		Grade loGrade = new LeafGrade("three", null);
		Grade maGrade = new LeafGrade("four", 2.0);
		Grade eGrade = new LeafGrade("five", null);
		
		Grade saveGrade;
		
		List<Grade> list = new ArrayList<Grade>();
		list.add(leGrade);
		list.add(ilGrade);
		list.add(loGrade);
		list.add(maGrade);
		list.add(eGrade);
		
		WeightedAverageStrategy weights = new WeightedAverageStrategy(null,true);
		
		saveGrade = weights.calculate("total 1", list);
		assertEquals(5.0, saveGrade.getValue());
		
//-------------------------------------------------------------------------------------		
		
		Grade testGrade;
		WeightedAverageStrategy averageStrategy = new WeightedAverageStrategy();
		testGrade = averageStrategy.calculate("total 2", list);
		
		assertEquals(3.0,testGrade.getValue() );
		
		
		List<Grade> list2 = new ArrayList<Grade>();
		
		WeightedAverageStrategy strategy = new WeightedAverageStrategy();
		

		Grade holaGrade;
		
		holaGrade = strategy.calculate("kik", null);
		
		
		WeightedAverageStrategy pop = new WeightedAverageStrategy(null, true);
		
		
		
	}
	
	
	
	@Test
	void testGradeCalculateWithWeights()
	{
		

		Grade opGrade = new LeafGrade("uno", 5.0);
		Grade uvGrade = new LeafGrade("dos", 8.0 );
		Grade loGrade = new LeafGrade("tres", 2.0);
		
		Grade leadGrade;
		
		List<Grade> grades = new ArrayList<Grade>();
		grades.add(opGrade);
		grades.add(uvGrade);
		grades.add(loGrade);
		
		Map<String, Double> doMap = new HashMap<String, Double>();
		doMap.put("uno", 30.0);
		doMap.put("dos", 30.0);
		doMap.put("tres", 40.0);
		
		WeightedAverageStrategy weight = new WeightedAverageStrategy(doMap);
		leadGrade = weight.calculate("total", grades);
		
		List<Grade> olGrade = new ArrayList<Grade>();
		
		WeightedAverageStrategy weight3 = new WeightedAverageStrategy(null, false);
		
		Map<String, Double> map = new HashMap<String, Double>();
		WeightedAverageStrategy strategy = new WeightedAverageStrategy(map);
		
		assertEquals(5.0, strategy.calculate("test", grades).getValue());
		assertEquals(0.0, weight3.calculate("prueba", olGrade).getValue());
		assertEquals(5.0, weight3.calculate("testing", grades).getValue());
		assertEquals(4.7, leadGrade.getValue());
	}
	
	@Test
	void testIgnoreMissing() 
	{
		WeightedAverageStrategy srStrategy;
		
		Grade beneGrade = new LeafGrade("uno", null);
		Grade yoGrade = new LeafGrade("due", null);
		Grade uovaGrade = new LeafGrade("tre", null);
		
		List<Grade> lista = new ArrayList<Grade>();
		lista.add(beneGrade);
		lista.add(yoGrade);
		lista.add(uovaGrade);
		
		srStrategy = new WeightedAverageStrategy(null, true);
		
		assertEquals(0.0,srStrategy.calculate("ignore ", lista).getValue() );
		
		//----------------------------------------------------------------
		
		Grade neGrade = new LeafGrade("uno", null);
		Grade oGrade = new LeafGrade("due", null);
		Grade ovaGrade = new LeafGrade("tre", 9.0);
		
		List<Grade> gradelista = new ArrayList<Grade>();
//		gradelista.add(neGrade);
//		gradelista.add(oGrade);
//		gradelista.add(ovaGrade);
		
		WeightedAverageStrategy popStrategy = new WeightedAverageStrategy(null, true);
		
		System.out.println(popStrategy.calculate("noo", gradelista));
		

	}

}
