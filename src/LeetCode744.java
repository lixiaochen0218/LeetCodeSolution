public class LeetCode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        if (target > letters[end] || target < letters[start]) {
            return letters[0];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            }
            else if (letters[mid] > target) {
                end = mid - 1;
            }
        }
        if (start == letters.length){
            return letters[0];
        }
        return letters[start];
    }
}
