public class Search<T> {

    /**
     * Performs a linear search on the specified array to find the index of the given key.
     *
     * @param arr the array to be searched
     * @param key the key to search for
     * @return the index of the key if found; otherwise, -1
     */
    public int linearSearch(T[] arr, T key)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i].equals(key))
            {
                return i;
            }
        }
        return -1;
    }
}
