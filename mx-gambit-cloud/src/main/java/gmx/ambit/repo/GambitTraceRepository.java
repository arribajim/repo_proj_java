package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.GambitTrace;

public interface GambitTraceRepository extends CrudRepository<GambitTrace, BigInteger> {

}
