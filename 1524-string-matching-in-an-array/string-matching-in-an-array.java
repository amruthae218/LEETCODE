class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].length()>=words[j].length())
                {
                    if(words[i].contains(words[j]))
                    {
                        if(!res.contains(words[j]))res.add(words[j]);
                    }
                }
                else
                {
                    if(words[j].contains(words[i]))
                    {
                        if(!res.contains(words[i]))res.add(words[i]);
                    }
                }
            }
        }
        return res;
    }
}