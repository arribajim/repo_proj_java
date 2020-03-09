package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.League;

public interface LeagueRepository extends CrudRepository<League, BigInteger> {

}
