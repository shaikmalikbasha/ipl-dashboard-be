import React from 'react';

function MatchDetailCard({ match }) {
	console.log(match);
	if (!match) return null;
	return (
		<div>
			Match Detail Card
			<h4>
				{match.team1} vs {match.team2}
			</h4>
		</div>
	);
}

export default MatchDetailCard;
