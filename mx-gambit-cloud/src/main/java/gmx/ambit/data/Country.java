package gmx.ambit.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import tacos.Taco;

@Data
@Entity
@Table(name="countries")
public class Country{
	
	@Id
	@Column(name="nodeid")
	private BigInteger NodeId;
	@NotNull
	@Column(name="countrycode")
	private String CountryCode;
	@NotNull
	@Column(name="name")
	private String Name;	
	@Column(name="priority")
	private Integer Priority;	
	
	 @ManyToMany(targetEntity=League.class)
	  private List<League> leagues = new ArrayList<>();
	  
	  public void addDesign(League luague) {
	    this.leagues.add(luague);
	  }
	
	
}
