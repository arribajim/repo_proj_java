package gmx.ambit.data;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="countries")
public class League {
	@Id
	@Column(name="nodeid")
	private BigInteger NodeId;	
	@NotNull
	@Column(name="name")
	private String Name;	
	@Column(name="priority")
	private Integer Priority;
	@NotNull
	@Column(name="parentnodeid")
	private Integer parentnodeid;
}
