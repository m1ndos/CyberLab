import './Team.css'

const Team = ({ name, image, players }) => {

    console.log(players);
    return (
      <div className="team">
        <div className='team-main-info'>
        <img className='team-logo' src={image} alt='team logo' />
        <span className="team-name">{name}</span>
        </div>
        <div className='all-players'>
        {players.map((player) => (
          <div className="player" key={player.id}>
            <img className='player-avatar' src={player.avatar} alt='player avatar' />
            <span className='player-nickname'>{player.nickname}</span>
          </div>
        ))}
        </div>
      </div>
    );
  };
  
  export default Team;
  