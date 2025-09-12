class Solution {
    public String destCity(List<List<String>> paths) {
        List<String> from=new ArrayList<>();
        List<String> to=new ArrayList<>();
        for(List<String> path:paths)
        {
            from.add(path.get(0));
            to.add(path.get(1));
        }
        for(String place:to)
        {
            if(!from.contains(place))
            {
                return place;
            }
        }
        return paths.get(0).get(0);
    }
}