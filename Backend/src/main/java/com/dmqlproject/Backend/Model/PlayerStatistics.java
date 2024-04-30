package com.dmqlproject.Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.text.DecimalFormat; // Import DecimalFormat class
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class PlayerStatistics {

    @Id
    private int playerId;
    private String nameoftheplayer;
    private LocalDate dateOfBirth;
    private String battingHand;
    private String bowlingSkill;
    private String countryName;
    private String teamsPlayedFor;

    private double battingAverage;

    private int ballsFaced;

    private int totalRuns;


    private double strikeRate;
    private int foursScored;
    private int sixesScored;

    private int ballsBowled;
    private int runsGiven;
    private int wicketsTaken;
    private double bowlingEconomy;
    private double bowlingStrikeRate;

    public String getPlayerName() {
        return nameoftheplayer;
    }

    public int getPlayerId() {
        return playerId;
    }

    // Method to format double value to two decimal places
    private double formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.##"); // Define the format
        return Double.parseDouble(df.format(value)); // Parse the formatted string back to double
    }

    // Getter method for battingAverage with formatted decimal
    public double getBattingAverage() {
        return formatDecimal(battingAverage);
    }

    // Getter method for strikeRate with formatted decimal
    public double getStrikeRate() {
        return formatDecimal(strikeRate);
    }

    // Getter method for bowlingEconomy with formatted decimal
    public double getBowlingEconomy() {
        return formatDecimal(bowlingEconomy);
    }

    // Getter method for bowlingStrikeRate with formatted decimal
    public double getBowlingStrikeRate() {
        return formatDecimal(bowlingStrikeRate);
    }
}

