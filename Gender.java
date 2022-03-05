package programs;

public enum Gender {
	
	FEMALE("F",26),
	MALE("M",29),
	TRANSGENDER("T",35);
	
	public String shortName;
	public int age;
	
	Gender(String shName, int age){
		shortName = shName;
		this.age = age;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getAgeForGender(Gender gen) {
		return gen.getAge();
		
	}
	
	
	
}
