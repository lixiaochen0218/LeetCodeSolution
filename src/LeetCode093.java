import java.util.ArrayList;
import java.util.List;

public class LeetCode093 {
    List<String> list = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0) return list;
        helper(s, 0, "", 0);
        return list;
    }

    private void helper(String ip, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) list.add(restored);

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) > 255)) continue;
            helper(ip, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
}
