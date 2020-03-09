package gmx.ambit.data;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="gambit_trace")
public class GambitTrace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nodeid")
	private BigInteger NodeId;
		
	private Date createTime;
	
	@PrePersist
	void createTime() {
	    this.createTime = new Date();
	}
	
	@Column(name="odd")
	private Number odd;
			
	@Column(name="parentnodeid")
	private Integer parentnodeid;
}
