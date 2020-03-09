package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.Event;

public interface EventRepository extends CrudRepository<Event, BigInteger> {

}
