import React, { useState } from 'react';
import axios from 'axios';
import AsyncSelect from 'react-select/async';
import './App.css';

const PlayerData = () => {
  const [selectedPlayer, setSelectedPlayer] = useState(null);
  const [playerData, setPlayerData] = useState(null);

  const loadOptions = (inputValue, callback) => {
    // Fetch player data based on the input value
    fetch(`http://localhost:8080/PlayerNames/${inputValue}`)
      .then((response) => response.json())
      .then((data) => {
        const options = data.map((player) => ({
          value: player.playerId,
          label: player.nameoftheplayer,
        }));
        callback(options);
      })
      .catch((error) => {
        console.error('Error fetching player data:', error);
        callback([]);
      });
  };

  const handlePlayerSelect = (option) => {
    setSelectedPlayer(option);
    fetchPlayerData(option.value);
  };

  const fetchPlayerData = async (playerId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/PlayerStatistics/PlayerID/${playerId}`
      );
      setPlayerData(response.data);
    } catch (error) {
      console.error('Error fetching player data:', error);
      setPlayerData(null);
    }
  };

  const renderPlayerData = () => {
    if (!playerData) return null;

    return (
      <div className="player-data-container">
        <h2>{playerData.nameoftheplayer}</h2>
        <div className="player-details">
          <div className="detail-block">
            <h3>Player ID</h3>
            <p>{playerData.playerId}</p>
          </div>
          <div className="detail-block">
            <h3>DOB</h3>
            <p>{playerData.dateOfBirth}</p>
          </div>
          <div className="detail-block">
            <h3>Batting Hand</h3>
            <p>{playerData.battingHand}</p>
          </div>
          <div className="detail-block">
            <h3>Bowling Skill</h3>
            <p>{playerData.bowlingSkill}</p>
          </div>
          <div className="detail-block">
            <h3>Country</h3>
            <p>{playerData.countryName}</p>
          </div>
          <div className="detail-block">
            <h3>Teams Played For</h3>
            <p>{playerData.teamsPlayedFor}</p>
          </div>
          <div className="detail-block">
            <h3>Total Runs</h3>
            <p>{playerData.totalRuns}</p>
          </div>
          <div className="detail-block">
            <h3>Strike Rate</h3>
            <p>{playerData.strikeRate}</p>
          </div>
          <div className="detail-block">
            <h3>Fours Scored</h3>
            <p>{playerData.foursScored}</p>
          </div>
          <div className="detail-block">
            <h3>Sixes Scored</h3>
            <p>{playerData.sixesScored}</p>
          </div>
          <div className="detail-block">
            <h3>Balls Bowled</h3>
            <p>{playerData.ballsBowled}</p>
          </div>
          <div className="detail-block">
            <h3>Runs Given</h3>
            <p>{playerData.runsGiven}</p>
          </div>
          <div className="detail-block">
            <h3>Wickets Taken</h3>
            <p>{playerData.wicketsTaken}</p>
          </div>
          <div className="detail-block">
            <h3>Bowling Economy</h3>
            <p>{playerData.bowlingEconomy}</p>
          </div>
          <div className="detail-block">
            <h3>Bowling Strike Rate</h3>
            <p>{playerData.bowlingStrikeRate}</p>
          </div>
        </div>
      </div>
    );
  };

  return (
    <div>
      <h1>IPL Database</h1>
      <div className='Drop'>
      <AsyncSelect
        cacheOptions
        defaultOptions
        loadOptions={loadOptions}
        onChange={handlePlayerSelect}
        value={selectedPlayer}
        placeholder="Search for a player"
        styles={{
          control: (provided) => ({
            ...provided,
            width: '300px', 
            height: '40px', 
          }),
          menu: (provided) => ({
            ...provided,
            width: '300px', 
          }),
        }}
      />
      </div>
      {renderPlayerData()}
    </div>
  );
};

export default PlayerData;
