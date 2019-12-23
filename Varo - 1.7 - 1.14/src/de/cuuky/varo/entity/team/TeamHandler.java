package de.cuuky.varo.entity.team;

import de.cuuky.varo.serialize.VaroSerializeObject;

public class TeamHandler extends VaroSerializeObject {

	private static TeamHandler instance;

	private TeamHandler() {
		super(Team.class, "/stats/teams.yml");

		load();
	}

	public static void initialise() {
		if (instance == null) {
			instance = new TeamHandler();
		}
	}

	@Override
	public void onSave() {
		clearOld();

		for (Team team : Team.getTeams())
			save(String.valueOf(team.getId()), team, getConfiguration());

		saveFile();
	}
}