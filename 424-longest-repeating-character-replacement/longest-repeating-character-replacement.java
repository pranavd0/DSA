class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxlen=0;
        int maxfreq=0;
        HashMap<Character,Integer> m=new HashMap<>();
        for(int r=0;r<s.length();r++){
            
            m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0)+1);
            maxfreq=Math.max(maxfreq,m.get(s.charAt(r)));
            int changesneeded= (r-l+1)-maxfreq;
            if(changesneeded<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            while(changesneeded>k){
                m.put(s.charAt(l), m.get(s.charAt(l))-1);
                if(m.get(s.charAt(l))==0){
                    m.remove(s.charAt(l));
                }
                l++;
                changesneeded= (r-l+1)-maxfreq;
            }
        }
        return maxlen;
    }
}