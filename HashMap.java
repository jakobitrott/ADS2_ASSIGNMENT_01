package ads2;

/* This collection represents a hashmap that contain pairs of strings
 * You must implement this hashmap using open addressing and full resize rehashing
 * with linear probing
 */

public class HashMap
{
  // Define member variables of HashMap object
  // You must use the HashPair object you defined in the HashPair class
  public HashPair[] map;
  private int size;

  // Creates a hashmap with a specified initial capacity
  // You must use the provided length (i.e. initlen) to initialise a new hash map
  public HashMap(int initlen)
  {
      this.size = initlen;
      this.map = new HashPair[initlen];

  }

  //Optional: Create some helper methods below for your implementation.






  /* Function used to create a hash from the key String passed in
   * Provide a basic hash function that mashes all the ascii values of key into
   * an index and return that */
  private int HashFunction(String key)
  {
      int hash = 7;

      for (int i = 0; i < key.length(); i++) {
          hash = hash*31 + key.charAt(i);
      }

    return hash;
  }



  /* Adds the pair <key, value> to the hash map.
   * Key is case sensitive
   * You must use the hash function method you have defined.
   * You must check load factor here and resize if over 0.7.
   * Use full rehashing.
   * Place item into data, but check and resolve collisions first using linear probing.
   */
  public void AddItem(String key, String value)
  {
    int index=HashFunction(key);

    if(map[index] == null)
    {
      map[index] = new HashPair(value, key);
    }
    else
    {
      map[index].setHashPair(new HashPair(value, key));
    }
  }


  /* Deletes the {key, value} pair for key from the hash map if it exists.
   * key is case sensitive.
   * You must use the hash function method you have defined.
   * You will need to implement the same linear probing to resolve collisions.
   * If the key is not in the hash map then the hash map remains unchanged
   */
  public void DeleteItem(String key)
  {
    int index=HashFunction(key);

    if(map[index]==null)
    {
      System.out.println("NULL\n");
    }
    else if (map[index] != null)
    {
      if(map[index].getKey() == key)
      {
        map[index] = map[index].next; //breaks the node
      }
      else
      {
        map[index].delete(key);
      }
    }


  }


  /* Returns the value associated with the key stored in the hash map.
   * key is case sensitive.
   * You must use the hash function method you have defined.
   * You will need to implement the same linear probing to resolve collisions.
   * If the key is not in the hash map then null should be returned
   */
  public String SearchValue(String key)
  {
    int index=HashFunction(key);

    if(map[index] == null)
    {
      return null;
    }
    else if(map[index].getKey() == key)
    {
      return map[index].getData();
    }
    else
    {
      return map[index].query(key);
    }


  }
}

