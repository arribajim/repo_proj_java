package gmx.ambit.bean;

import java.util.List;

import lombok.Data;

@Data
public class LocalizedName {
	private Integer ReferenceId;
	private List<LocalizedValue> LocalizedValues;
	public String toString() {
		return ReferenceId+ " "+LocalizedValues;
	}
}
