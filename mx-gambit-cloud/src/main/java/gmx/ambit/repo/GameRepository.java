package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.Game;

public interface GameRepository extends CrudRepository<Game, BigInteger> {

}
