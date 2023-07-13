import React, { useEffect, useState } from 'react'
import './Tournaments.css'
import { useNavigate } from 'react-router-dom';

const Tournaments = () => {

    const navigate = useNavigate();

    //стейтовые переменные
    const [selectedButton, setSelectedButton] = useState('upcoming');
    const [tournaments, setTournaments] = useState([]);
    const [filteredTournaments, setFilteredTournaments] = useState([]);

    //получение всех турниров и их изначальная фильтрация
    useEffect(() => {
        const currentDateTime = new Date();
        fetch('http://localhost:8080/get-all-tournaments', {
        }).then(res => res.json()).then(res => {
            setTournaments(res);
            setFilteredTournaments(
                res.filter(tournament => {
                    const startDate = new Date(tournament.start_date);
                    return startDate > currentDateTime;
                })
            )
        })
    }, [])

    //переключение цвета кнопки выбранного турнира и фильтрация
    const handleButtonClick = (buttonName) => {
        setSelectedButton(buttonName);
        const currentDateTime = new Date();
        if(buttonName === 'upcoming'){
            setFilteredTournaments(
                tournaments.filter(tournament => {
                    const startDate = new Date(tournament.start_date);
                    return startDate > currentDateTime;
                })
            )
        }
        if(buttonName === 'current'){
            setFilteredTournaments(
                tournaments.filter(tournament => {
                    const startDate = new Date(tournament.start_date);
                    const endDate = new Date(tournament.end_date);
                    return startDate <= currentDateTime && endDate >= currentDateTime;
                })
            )
        }
        if(buttonName === 'past'){
            setFilteredTournaments(
                tournaments.filter(tournament => {
                    const endDate = new Date(tournament.end_date);
                    return endDate < currentDateTime;
                })
            )
        }
        console.log(filteredTournaments);
    };

    const handleNavigateTournamentReg = (id) => {
        navigate('/tournament-reg/'+ id)
    }

  return (
    <div className='tournaments-container'>
        <h2>ТУРНИРЫ</h2>
        <div className='tournament-filters'>

            <button 
                className={selectedButton === 'upcoming' ? 'selected-filter' : ''} 
                onClick={() => handleButtonClick('upcoming')}
            >
                ПРЕДСТОЯЩИЕ ТУРНИРЫ
            </button>

            <button 
                className={selectedButton === 'current' ? 'selected-filter' : ''}
                onClick={() => handleButtonClick('current')}
            >
                ТЕКУЩИЕ ТУРНИРЫ
            </button>

            <button 
                className={selectedButton === 'past' ? 'selected-filter' : ''}
                onClick={() => handleButtonClick('past')}
            >
                ПРОШЕДШИЕ ТУРНИРЫ
            </button>

        </div>
        <div className='tournaments'>
            {filteredTournaments.map((tournament) => (
                <div key={tournament.id} className='tournament'>
                    <img src={'http://localhost:8080/static/' + tournament.logo} alt='valorant_logo'></img>
                    <p>{tournament.start_date}</p>
                    <a href='/'>Информация о турнире</a>
                    {selectedButton === 'upcoming' && <button onClick={() => handleNavigateTournamentReg(tournament.id)}>ЗАПИСАТЬСЯ</button>}
                    {selectedButton === 'past' && <button>РЕЗУЛЬТАТЫ</button>}
                </div>
            ))}
        </div>
    </div>
  )
}

export default Tournaments