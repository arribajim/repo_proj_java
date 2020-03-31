package gmx.ambit.data;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
		
	@ManyToOne
	@JoinColumn(name = "parentnodeid",  foreignKey = @ForeignKey(name = "game_parentnodeid_fkey" ))
	private Event event;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="game", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<GambitResult> results;
}
