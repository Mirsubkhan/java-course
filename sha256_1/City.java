package sha256_1;

import java.util.Scanner;

public class City {
	private String name;
	private String region;
	private String country;
	private long population;
	private String postalCode;
	private String phoneCode;
	
	// I haven't added a constructor because i didn't see this clause in the homework :) 
	
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
	
	public void print() {
		System.out.printf("Name -> %s%n"
				+ "Region -> %s%n"
				+ "Country -> %s%n"
				+ "Population -> %d%n"
				+ "Postal Code ->%s%n"
				+ "Phone Code ->%s%n", 
				name, region, country,
				population, postalCode, phoneCode);
	}
	
	public void setVariables() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Name: ");
		setName(scanner.next());
		
		System.out.println("Region: ");
		setRegion(scanner.next());
		
		System.out.println("Country: ");
		setCountry(scanner.next());
		
		System.out.println("Population: ");
		setPopulation(scanner.nextLong());
		
		System.out.println("ostalCode: ");
		setPostalCode(scanner.next());
		
		System.out.println("PhoneCode: ");
		setPhoneCode(scanner.next());
	}
}
