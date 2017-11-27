package ads2;

/* This class is used within HashMap class.
 * The members are public so you can access them directly */
public class HashPair 
{
  //Define member variables of HashPair class  
    String data;
    String key;
    HashPair next;

  //Default Constructor function
    HashPair(String data, String key){
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public void setData(String data){
        this.data = data;
    }
    
  //Optional: Create some helper methods below for your implementation.
    public String getData(){
        return this.data;
    }
    public String getKey(){

        return this.key;

    }

    public void setHashPair (HashPair next){
        if(this.next == null){
            this.next = next;
        }
        else
            this.next.setHashPair(next);
    }

    public String query(String key) {

        if (next == null)
            return null;

        else
            if (next.getKey() == key)
                return next.getData();
        else
            return next.query(key);
    }

    public void delete(String key){

        if(next == null){
            System.out.println("Next is Null\n");
        }
        else
            if(next.getKey() == key){

            next = next.next;
            }
            else
            {
                next.delete(key);
            }
    }
}
