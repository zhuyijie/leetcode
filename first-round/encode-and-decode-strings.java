public class Codec {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append(':');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> strs = new ArrayList<String>(); 
        int from = 0, idx;
        while ((idx = s.indexOf(':', from)) != -1) {
            int len = Integer.parseInt(s.substring(from, idx));
            strs.add(s.substring(idx + 1, idx + 1 + len));
            from = idx + 1 + len;
        }
        return strs;
    }
}
