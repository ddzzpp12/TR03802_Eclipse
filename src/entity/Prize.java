package entity;

public class Prize {
	private Integer prize_id;
	private String country;
	private Integer gold_medal_count;
	private Integer silver_medal_count;
	private Integer brass_medal_count;
	
	
	
	public Prize() {
		super();
	}

	public Prize(Integer prize_id, String country, Integer gold_medal_count, Integer silver_medal_count,
			Integer brass_medal_count) {
		super();
		this.prize_id = prize_id;
		this.country = country;
		this.gold_medal_count = gold_medal_count;
		this.silver_medal_count = silver_medal_count;
		this.brass_medal_count = brass_medal_count;
	}

	@Override
	public String toString() {
		return "Prize [prize_id=" + prize_id + ", country=" + country + ", gold_medal_count=" + gold_medal_count
				+ ", silver_medal_count=" + silver_medal_count + ", brass_medal_count=" + brass_medal_count + "]";
	}
	
	public Integer getPrize_id() {
		return prize_id;
	}
	public void setPrize_id(Integer prize_id) {
		this.prize_id = prize_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getGold_medal_count() {
		return gold_medal_count;
	}
	public void setGold_medal_count(Integer gold_medal_count) {
		this.gold_medal_count = gold_medal_count;
	}
	public Integer getSilver_medal_count() {
		return silver_medal_count;
	}
	public void setSilver_medal_count(Integer silver_medal_count) {
		this.silver_medal_count = silver_medal_count;
	}
	public Integer getBrass_medal_count() {
		return brass_medal_count;
	}
	public void setBrass_medal_count(Integer brass_medal_count) {
		this.brass_medal_count = brass_medal_count;
	}
	
}
