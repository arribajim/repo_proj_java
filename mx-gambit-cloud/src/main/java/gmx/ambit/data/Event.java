package gmx.ambit.data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="Events")
public class Event {

	@Id
	@Column(name="nodeid")
	private BigInteger NodeId;
	@NotNull
	@Column(name="name")
	private String Name;
	@Column(name="startdate")
	private Date StarDate;
			
	@Column(name="priority")
	private Integer Priority;
	@Column(name="locked")
	private Boolean Locked;
	
	@Column(name="statisticsid")
	private String StatisticsId;
	
	@NotNull
	@Column(name="parentnodeid")
	private BigInteger parentnodeid;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="event", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Game> games;
}
