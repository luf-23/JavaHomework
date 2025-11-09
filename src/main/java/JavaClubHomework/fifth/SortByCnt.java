package JavaClubHomework.fifth;

import javafx.util.Pair;

import java.util.*;

public class SortByCnt {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!mp.containsKey(s.charAt(i))) mp.put(s.charAt(i), 0);
            mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
        }
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a, b) -> (b.getKey() - a.getKey()));
        for (Character ch : mp.keySet()) pq.offer(new Pair<>(mp.get(ch), ch));
        String str = new String();
        while (!pq.isEmpty()) {
            Pair<Integer, Character> now = pq.poll();
            for (int i = 0; i < now.getKey(); i++) str += now.getValue();
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        SortByCnt s1 = new SortByCnt();
        System.out.println(s1.frequencySort(s));
    }
}
