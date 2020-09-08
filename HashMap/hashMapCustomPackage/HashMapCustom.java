package hashMapCustomPackage;
class HashMapCustom<K, V> {
    private KeyValuePair<K,V>[] table;   //Array of Entry.
    private int capacity= 4;  //Initial capacity of HashMap
    static class KeyValuePair<K,V>{
        K key;
        V value;
        KeyValuePair<K,V> next;
        KeyValuePair(K key, V value, KeyValuePair<K,V> next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

    }

    @SuppressWarnings("unchecked")
    public HashMapCustom(){
       table = new KeyValuePair[capacity];
    }

  

   /**
    * Method allows you put key-value pair in HashMapCustom.
    * If the map already contains a mapping for the key, the old value is replaced.
    * Note: method does not allows you to put null key though it allows null values.
    * Implementation allows you to put custom objects as a key as well.
    * Key Features: implementation provides you with following features:-
    *     >provide complete functionality how to override equals method.
    *  >provide complete functionality how to override hashCode method.
    * @param newKey
    * @param data
    */
    public V put(K newKey,V value) throws Exception{
        if(newKey==null){
            throw new Exception("key cannot be null");
        }
        int hash=hash(newKey);
        KeyValuePair<K,V> newEntry=new  KeyValuePair<K,V>(newKey,value,null);
        KeyValuePair<K,V> oldValue=table[hash];
        if(oldValue==null){
            table[hash]=newEntry;
        }else{
            KeyValuePair<K,V> current=oldValue;
            while(current!=null){
                if(current.key !=newEntry.key){
                    current=current.next;
                }else{
                    throw new Exception("key already present");
                } 
            }
            newEntry.next=table[hash];
            table[hash]=newEntry;
        }

       return newEntry.value;
    }
   
   /**
    * Method returns value corresponding to key.
    * @param key
    */
   public V get(K key){
       int hash = hash(key);
       if(table[hash] == null){
        return null;
       }else{
        KeyValuePair<K,V> temp = table[hash];
        while(temp!= null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next; //return value corresponding to key.
        }         
        return null;   //returns null if key is not found.
       }
   }


   /**
    * Method removes key-value pair from HashMapCustom.
    * @param key
    */
   
    public boolean remove(K deleteKey){
        int hash=hash(deleteKey);
        if(table[hash]==null){
            return false;
        }
        KeyValuePair<K,V> current=table[hash];
        KeyValuePair<K,V> previous=null;
        while(current!=null){
            if(current==deleteKey)
                    {  if(previous!=null){
                            previous.next=current.next;
                            return true;
                            }
                        else{
                            table[hash]=current.next;
                            return true;
                        }

                    }
            else{
                previous=current;
                current=current.next;
            }
        }
        
        return false;
    }
  

   /**
    * Method displays all key-value pairs present in HashMapCustom.,
    * insertion order is not guaranteed, for maintaining insertion order
    * refer LinkedHashMapCustom.
    * @param key
    */
   public void display(){
      
      for(int i=0;i<capacity;i++){
          KeyValuePair<K,V> current=table[i];
          while(current!=null){
             System.out.println("key is "+current.key+" corresponding Value is "+current.value);
              current=current.next;   
          }
      }             
   
   }
   /**
    * Method implements hashing functionality, which helps in finding the appropriate
    * bucket location to store our data.
    * This is very important method, as performance of HashMapCustom is very much
    * dependent on  this method's implementation.
    * @param key
    */
   private int hash(K key){
       return Math.abs(key.hashCode()) % capacity;
   }

}


