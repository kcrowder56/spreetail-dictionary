import java.util.Scanner;

public class runDictionary {
	public static void main(String[] args) {
		
		//Instantiate the custom dictionary
		myDictionary<String, String> d = new myDictionary<String, String>();
		
		//Create and run scanner for user input from the command line
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			
			//Parse the incoming arguments
			String[] inputs = scanner.nextLine().split(" ");

			//Get the command keyword as first given argument
			String command = inputs[0];
			
			//Validate remaining arguments and call corresponding methods based on given command
			try {
				switch(command) {
					case "KEYS" :
						if(inputs.length > 1) {
							System.out.println("KEYS command cannot have any other arguments.");
							break;
						}
						System.out.println(d.keys());
						break;
						
						
					case "MEMBERS" :
						if(inputs.length != 2) {
							System.out.println("MEMBERS command strictly takes one key as an argument.");
							break;
						}
						System.out.println(d.members(inputs[1]));
						break;
						
						
					case "ADD" :
						if(inputs.length != 3) {
							System.out.println("ADD command strictly takes a key and a value as arguments.");
							break;
						}
						d.add(inputs[1], inputs[2]);
						System.out.println("Added value ["+inputs[2]+"] as a new member of key ["+inputs[1]+"]");
						break;
						
						
					case "REMOVE" :
						if(inputs.length != 3) {
							System.out.println("REMOVE command strictly takes a key and a value as arguments.");
							break;
						}
						d.remove(inputs[1], inputs[2]);
						System.out.println("Removed value ["+inputs[2]+"] as a member of key ["+inputs[1]+"]");
						break;
						
						
					case "REMOVEALL" :
						if(inputs.length != 2) {
							System.out.println("REMOVEALL command strictly takes one key as arguments.");
							break;
						}
						d.removeAll(inputs[1]);
						System.out.println("Removed key ["+inputs[1]+"] and its members from the dictionary.");
						break;
						
						
					case "CLEAR" :
						if(inputs.length != 1) {
							System.out.println("CLEAR command cannot have any other arguments.");
							break;
						}
						d.clear();
						System.out.println("Dictionary has been cleared");
						break;
						
						
					case "KEYEXISTS" :
						if(inputs.length != 2) {
							System.out.println("KEYEXISTS command strictly takes one key as an argument.");
							break;
						}
						System.out.println("Key ["+inputs[1]+"] exists in the dictionary: "+d.keyExists(inputs[1]));
						break;
						
						
					case "VALUEEXISTS" :
						if(inputs.length != 3) {
							System.out.println("VALUEEXISTS command strictly takes one key and one value as arguments.");
							break;
						}
						System.out.println("Value ["+inputs[2]+"] exists as a member of key ["+inputs[1]+"]: "+d.valueExists(inputs[1], inputs[2]));
						break;
						
					case "ALLMEMBERS" :
						if(inputs.length != 1) {
							System.out.println("ALLMEMBERS command cannot have any other arguments.");
							break;
						}
						System.out.println(d.allMembers());
						break;
						
						
					case "ITEMS" :
						if(inputs.length != 1) {
							System.out.println("ITEMS command cannot have any other arguments.");
							break;
						}
						System.out.println(d.items());
						break;
						
					case "EXIT" :
						System.exit(0);

					default : 
						System.out.println("["+command+"] is not a recognized command.");
						break;
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		scanner.close();
	}
}
