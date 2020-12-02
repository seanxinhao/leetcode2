import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFindSet ufs = new UnionFindSet();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            emailToName.put(firstEmail, name);
            String parent = ufs.find(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                ufs.union(parent, email);
            }
        }
        return ufs.getResult(emailToName);
    }

    static class Account {
        String name;
        Set<String> emails;

        public static Account build(List<String> account) {
            Account a = new Account();
            a.emails = new LinkedHashSet<>(30);
            a.name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                a.emails.add(account.get(i));
            }
            return a;
        }

        public boolean equals(Account other) {
            for (String otherEmail : other.emails) {
                if (this.emails.contains(otherEmail)) {
                    return true;
                }
            }
            return false;
        }
    }

    class UnionFindSet {
        Map<String, String> parents = new LinkedHashMap<>();

        public String find(String a) {
            if (!parents.containsKey(a)) {
                parents.put(a, a);
                return a;
            } else {
                String p = parents.get(a);
                if (p.equals(a)) {
                    return p;
                } else {
                    return parents.get(find(p));
                }
            }
        }

        public void union(String a, String b) {
            String pa = find(a);
            String pb = find(b);
            if (!pa.equals(pb)) {
                parents.put(pa, pb);
            }
        }

        public List<List<String>> getResult(Map<String, String> emailToNameMap) {
            Map<String, List<String>> resMap = new LinkedHashMap<>(30);
            for (String email : parents.keySet()) {
                String p = find(email);
                List<String> children = resMap.getOrDefault(p, new ArrayList<>());
                children.add(email);
                resMap.put(p, children);
            }
            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : resMap.entrySet()) {
                String name = emailToNameMap.get(entry.getKey());
                Set<String> emailSet = new TreeSet<>();
                emailSet.addAll(entry.getValue());
                List<String> merged = new ArrayList<>();
                merged.add(name);
                merged.addAll(emailSet);
                res.add(merged);
            }
            return res;
        }
    }
}
// @lc code=end
