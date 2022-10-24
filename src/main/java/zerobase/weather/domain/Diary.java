package zerobase.weather.domain;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String weather;
	private String icon;
	private Double temperature;
	private String text;
	private LocalDate date;

	public void setDateWeather(DateWeather dateWeather){
		this.date = dateWeather.getDate();
		this.weather = dateWeather.getWeather();
		this.icon = dateWeather.getIcon();
		this.temperature = dateWeather.getTemperature();
	}
}
