package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.GambitResult;

public interface GambitResultRepository extends CrudRepository<GambitResult, BigInteger> {

}
