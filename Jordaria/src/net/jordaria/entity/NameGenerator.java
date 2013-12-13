package net.jordaria.entity;

public class NameGenerator {
	public NameGenerator(){
		
	}
	
	private String[] prefixNordic = new String[]{"Fa","Ae","Ja","Du","Mo","Ne","Ro","Te","Ga","Va"};
	private String[] middleNordic = new String[]{"dor","sorn","par","bard","jur","nen","rist","thek","zar","wren"};
	private String[] suffixNordic = new String[]{"and","marth","eth","orn","son","ath","lea","wrath","don","ria"};
	
	public String getCharacterNameNordic(){
		String name = "Tim?";
		String p = prefixNordic[(int)(Math.random()*prefixNordic.length)];
		String m = middleNordic[(int)(Math.random()*middleNordic.length)];
		String s = suffixNordic[(int)(Math.random()*suffixNordic.length)];
		name = p.concat(m).concat(s);
		return name;
	}
	
}
