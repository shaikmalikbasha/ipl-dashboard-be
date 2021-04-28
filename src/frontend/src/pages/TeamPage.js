import React from 'react';
import MatchDetailCard from '../components/MatchDetailCard';
import MatchSmallCard from '../components/MatchSmallCard';

function TeamPage() {
	return (
		<div className='TeamPage'>
			<h1>IPL Dashboard</h1>
			<h3>Chennai Super Kings</h3>
			<MatchDetailCard />
			<MatchSmallCard />
			<MatchSmallCard />
			<MatchSmallCard />
		</div>
	);
}

export default TeamPage;
