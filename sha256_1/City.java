package sha256_1;

public class City {
	private String name;
	private String region;
	private String country;
	private long population;
	private String postalCode;
	private String phoneCode;
	
	public String getName() {
	    return name;
	}

	public String getRegion() {
	    return region;
	}

	public String getCountry() {
	    return country;
	}

	public long getPopulation() {
	    return population;
	}

	public String getPostalCode() {
	    return postalCode;
	}

	public String getPhoneCode() {
	    return phoneCode;
	}
	
	public void setName(String name) {
	    this.name = name;
	}

	public void setRegion(String region) {
	    this.region = region;
	}

	public void setCountry(String country) {
	    this.country = country;
	}

	public void setPopulation(long population) {
	    if (population < 0) {
	        throw new IllegalArgumentException("Population cannot be negative! (╯‵□′)╯︵┻━┻");
	    }
	    this.population = population;
	}

	public void setPostalCode(String postalCode) {
	    this.postalCode = postalCode;
	}

	public void setPhoneCode(String phoneCode) {
	    this.phoneCode = phoneCode;
	}
}
