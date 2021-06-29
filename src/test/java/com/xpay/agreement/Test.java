package com.xpay.agreement;

import java.util.*;

public class Test {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk < n && !occ.contains(s.charAt(rk))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk));
                rk++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i);
        }
        System.out.println(ans);
        System.out.println(occ);
        return ans;
    }



    public static void main(String[] args) {
        Test test = new Test();
        String s = "ABAACBABCBDAD";
        String[] m = new String[]{"foo","bar"};
        String t = "ABCD";
        int[] int_array = new int[]{1,3,-1,-3,5,3,6,7};
        Integer target = 7;
        int k =3;
        test.a(int_array, k);

    }

    public void a(int[] nums, int k){
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }

    }

    public void z(Integer[] s, Integer target){
        Integer length = s.length;
        Integer left = 0;
        Integer all = 0;
        Integer res = Integer.MAX_VALUE;
        Integer res_l = 0;
        Integer res_r = 0;
        for(int i=0; i<length; i++){

            all += s[i];
            while(all >= target && left <= i){
                res_l = left;
                res_r = i;
                res = Math.min(res, res_r-res_l+1);
                all -= s[left];
                left++;
            }
        }
        System.out.println("左边: " + res_l);
        System.out.println("右边: " + res_r);
        System.out.println("结果: " + res);
    }

    public void x(){
        String s = "pwwkewdfmcmfcmsl";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }

        System.out.println(max);
        System.out.println(map);
    }

    public void y(){
        String s = "sefjdgdogjdpgjdogj";
        Map<Character, Integer> set = new HashMap<>();
        Integer max = 0;
        Integer left = 0;
        for(int i=0; i<s.length();i++){
            if(i != 0 && set.containsKey(s.charAt(i))){
                left = Math.max(left, set.get(s.charAt(i)) +1);
            }
            set.put(s.charAt(i), i);
            max = Math.max(max, i-left);
        }
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
//                    if (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
//                        String t_w = s.substring(left, left + one_word);
//                        count--;
//                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
//                        left += one_word;
//                    }
                    if (count == word_num) res.add(left);
                }
            }
        }

        System.out.println(res);
        return res;
    }
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        System.out.println(res);
        return res;
    }
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        System.out.println(res);
        return res;
    }
    public void findSubstring4(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++){
            Character w = t.charAt(i);
            map.put(w, map.getOrDefault(w, 0)+1);
        }

        Integer all = s.length();
        Integer target = t.length();
        Integer left = 0;
        HashMap<Character, Integer> res = new HashMap<>();
        Integer lenght = all;
        Integer res_l = 0;
        Integer res_r = 0;
        for(int i=0; i<all; i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                res.put(c, res.getOrDefault(c, 0) + 1);
            }

            while(check(map, res) && left <= i){
                lenght = Math.min(lenght, i-left);
                res_l = left;
                res_r = left + lenght;
                if(map.containsKey(s.charAt(left))){
                    res.put(s.charAt(left), res.getOrDefault(s.charAt(left), 0) -1);
                }
                left++;
            }
        }

        System.out.println(res_l);
        System.out.println(res_r);
        System.out.println(res);
    }

    public Boolean check(HashMap<Character, Integer> res, HashMap<Character, Integer> tmp){
        Iterator x = res.entrySet().iterator();
        while (x.hasNext()){
            Map.Entry entry = (Map.Entry) x.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(tmp.getOrDefault(key, 0) < val){
                return false;
            }
        }
        return true;
    }

}

