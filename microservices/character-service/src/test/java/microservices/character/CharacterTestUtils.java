package microservices.character;

public class CharacterTestUtils {

	public static Character newCharacter() {
		Character character = new Character();
		character.setId(1);
		character.setHouse("house");
		character.setName("name");
		character.setPatronus("patronus");
		character.setRole("role");
		character.setSchool("school");
		return character;
	}
}
