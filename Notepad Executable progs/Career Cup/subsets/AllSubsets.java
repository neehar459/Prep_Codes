public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    Set<Set<T>> sets = new HashSet<Set<T>>();
    if (originalSet.isEmpty()) {
    	sets.add(new HashSet<T>());
    	return sets;
    }
    List<T> list = new ArrayList<T>(originalSet);
    T head = list.get(0);
    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
    for (Set<T> set : powerSet(rest)) {
    	Set<T> newSet = new HashSet<T>();
    	newSet.add(head);
    	newSet.addAll(set);
    	sets.add(newSet);
    	sets.add(set);
    }		
    return sets;
}

private static void buildPowerSet(List<String> list, int count)
{
    powerSet.add(list);

    for(int i=0; i<list.size(); i++)
    {
        List<String> temp = new ArrayList<String>(list);
        temp.remove(i);
        buildPowerSet(temp, temp.size());
    }
}