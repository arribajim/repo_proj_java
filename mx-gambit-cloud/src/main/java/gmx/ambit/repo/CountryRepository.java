package gmx.ambit.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import gmx.ambit.data.Country;

public interface CountryRepository extends CrudRepository<Country, BigInteger> {

}
