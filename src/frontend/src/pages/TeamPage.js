import { React, useEffect, useState } from 'react';
import MatchDetailCard from '../components/MatchDetailCard';
import MatchSmallCard from '../components/MatchSmallCard';

function TeamPage() {
	const [team, setTeam] = useState({ matches: [] });

	useEffect(() => {
		const fetchMatches = async () => {
			const response = await fetch(
				'http://localhost:8080/team/Chennai%20Super%20Kings'
			);
			const data = await response.json();
			setTeam(data);
		};
		fetchMatches();
	}, []);

	return (
		<div className='TeamPage'>
			<h1>IPL Dashboard</h1>
			<h3>{team.teamName}</h3>
			<MatchDetailCard match={team.matches[0]} />
			{team.matches !== undefined && team.matches.length > 0
				? team.matches
						.slice(1)
						.map(match => <MatchSmallCard key={match.id} match={match} />)
				: null}
		</div>
	);
}

export default TeamPage;
