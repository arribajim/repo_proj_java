package tacos.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tacos.Order;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {
	List<Order> findByDeliveryZip(String deliveryZip);
//	The predicate follows the word By in the method name and is the most interesting part of the method signature. 
//	In this case, the predicate refers to two Order properties: deliveryZip and placedAt. 
//	The deliveryZip property must be equal to the value passed into the first parameter of the method. 
//	The keyword Between indicates that the value of deliveryZip must fall between the values passed into
//	the last two parameters of the method.
//
//	In addition to an implicit Equals operation and the Between operation, Spring Data method signatures
//	can also include any of these operators:
//
//	IsAfter, After, IsGreaterThan, GreaterThan
//	IsGreaterThanEqual, GreaterThanEqual
//	IsBefore, Before, IsLessThan, LessThan
//	IsLessThanEqual, LessThanEqual
//	IsBetween, Between
//	IsNull, Null
//	IsNotNull, NotNull
//	IsIn, In
//	IsNotIn, NotIn
//	IsStartingWith, StartingWith, StartsWith
//	IsEndingWith, EndingWith, EndsWith
//	IsContaining, Containing, Contains
//	IsLike, Like
//	IsNotLike, NotLike
//	IsTrue, True
//	IsFalse, False
//	Is, Equals
//	IsNot, Not
//	IgnoringCase, IgnoresCase
	List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
		      String deliveryZip, Date startDate, Date endDate);
//	As alternatives for IgnoringCase and IgnoresCase, you can place either 
//	AllIgnoringCase or AllIgnoresCase on the method to ignore case for all 
//	String comparisons. For example, consider the following method:
		List<Order> findByDeliveryStateAndDeliveryCityIgnoringCase(
		        String deliveryState, String deliveryCity);	
	
//		OrderBy at the end of the method name to sort the results by a specified column. For example, to order by the deliveryTo property:
		List<Order> findByDeliveryCityOrderByDeliveryName(String city);

//		@Query("Order by where deliveryCity like 'Seattle'")
//		List<Order> readOrdersDeliveredInSeattle();
}
