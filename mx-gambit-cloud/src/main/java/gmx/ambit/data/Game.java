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
@Table(name="Games")
public class Game {
	@Id
	@Column(name="nodeid")
	private BigInteger NodeId;
	@NotNull
	@Column(name="name")
	private String Name;
				
	@Column(name="priority")
	private Integer Priority;
	
	@Column(name="locked")
	private Boolean Locked;
		
	
	@Column(name="parentnodeid")
	private Integer parentnodeid;
}
