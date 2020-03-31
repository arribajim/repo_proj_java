package gmx.ambit.bean;

import lombok.Data;

@Data
public class LocalizedValue {
	private String CountryCode;
	private String Value;
	public String toString() {
		return this.CountryCode + " " +this.Value;
	}
}
