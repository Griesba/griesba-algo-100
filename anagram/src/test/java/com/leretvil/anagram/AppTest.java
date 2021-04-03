package com.leretvil.anagram;

import com.leretvil.quicksort.QuickSort;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {

    @Test
    public void mainTest() {
        String pattern = "documenting";

        try {
            QuickSort<Character> qs = new QuickSort<>();

            Character[] re = qs.sort(pattern.chars().mapToObj(c -> (char)c).toArray(Character[]::new), 0, pattern.length()-1);
            String patternSorted = Arrays.stream(re).map(String::valueOf).collect(Collectors.joining());

            URL url = new URL("https://gist.githubusercontent.com/calvinmetcalf/084ab003b295ee70c8fc/raw/314abfdc74b50f45f3dbbfa169892eff08f940f2/wordlist.txt");
            Scanner scanner = new Scanner(url.openStream());

            int N = pattern.length();
            while (scanner.hasNext()) {
                String input = scanner.next();
                Scanner scanner2 = new Scanner(url.openStream());
                while (scanner2.hasNext()) {
                    String input2 = scanner.next();
                    if (!input.equalsIgnoreCase(input2) && (input.length() + input2.length()) == N) {
                        String compinedInput = input + input2;
                        Character[] res = qs.sort(compinedInput.chars().mapToObj(c -> (char)c).toArray(Character[]::new), 0, compinedInput.length()-1);
                        String output = Arrays.stream(res).map(String::valueOf).collect(Collectors.joining());
                        if (output.equalsIgnoreCase(patternSorted)){
                            System.out.println(input + " "+ input2);
                        }
                    }
                }
                scanner2.close();
            }
            scanner.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
