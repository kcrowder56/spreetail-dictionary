import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class myDictionary<E, T> {

	private final Map<E,Set<T>> map = new HashMap<E,Set<T>>();
	
	//KEYS - Returns all the keys in the dictionary. Order is not guaranteed.
	public Set<E> keys() {
		
		return map.keySet();
		
	}
	
	//MEMBERS - Returns the collection of strings for the given key. Return order is not guaranteed. Returns an error if the key does not exists.
	public Set<T> members(E key) {
		
		if(map.get(key) == null) {
			throw new IllegalArgumentException("ERROR: No members were found for the given key ["+key+"]");
		}
		return map.get(key);
		
	}
	
	//ADD - Add a member to a collection for a given key. Displays an error if the value already existed in the collection.
	public Boolean add(E key, T val) {
		
        //If members is null, then we are adding a brand new key ... instantiate a new set of values and add the key/values to the map
        Set<T> members = map.get(key);
        if(members == null) {
        	members = new HashSet<T>();
            map.put(key,members);
        }
        if(members.contains(val)) {
        	throw new IllegalArgumentException("ERROR: key ["+key+"] already contains value ["+val+"]");
        }
        return members.add(val);
	
	}
	
	//REMOVE - Removes a value from a key. If the last value is removed from the key, they key is removed from the dictionary. If the key or value does not exist, displays an error.
	public Boolean remove(E key, T val) {
		
		//Existence checks
		if(!map.containsKey(key)) {
			throw new IllegalArgumentException("ERROR: Given key ["+key+"] does not exist in the dictionary.");
		}
		if(!map.get(key).contains(val)) {
			throw new IllegalArgumentException("ERROR: Given value ["+val+"] is not a member of the given key ["+key+"].");
		} else {
			//If this value is the only member left of this key, remove the entire key mapping
			if(map.get(key).size() == 1) {
				map.remove(key);
				return true;
			}
			//Else simply remove the given value
			return map.get(key).remove(val);
		}
		
	}
	
	//REMOVEALL - Removes all value for a key and removes the key from the dictionary. Returns an error if the key does not exist.
	public Boolean removeAll(E key) {
		
		//Existence checks
		if(!map.containsKey(key)) {
			throw new IllegalArgumentException("ERROR: Given key ["+key+"] does not exist in the dictionary.");
		}
		map.remove(key);
		return true;
	}
	
	//CLEAR - Removes all keys and all values from the dictionary.
	public Boolean clear() {
		map.clear();
		return true;
	}
	
	//KEYEXISTS - Returns whether a key exists or not.
	public Boolean keyExists(E key) {
		return map.containsKey(key);
	}
	
	//VALUEEXISTS - Returns whether a value exists within a key. Returns false if the key does not exist.
	public Boolean valueExists(E key, T val) {
		if(map.containsKey(key)) {
			if(map.get(key).contains(val)) {
				return true;
			}
		}
		return false;
	}
	
	//ALLMEMBERS - Returns all the values in the dictionary. Returns nothing if there are none. Order is not guaranteed.
	public Collection<Set<T>> allMembers() {
		return map.values();
	}
	
	//ITEMS - Returns all keys in the dictionary and all of their values. Returns nothing if there are none. Order is not guaranteed.
	public Set<Entry<E, Set<T>>> items() {
		return map.entrySet();
	}
}
