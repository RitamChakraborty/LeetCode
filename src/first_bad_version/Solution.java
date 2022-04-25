package first_bad_version;

class VersionControl {
    int badVersion;

    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    public boolean isBadVersion(int n) {
        return n >= badVersion;
    }
}

public class Solution extends VersionControl {
    public Solution(int badVersion) {
        super(badVersion);
    }

    public static void main(String[] args) {
        Solution solution = new Solution(1702766719);
        System.out.println(solution.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (start - end) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }

        return start;
    }
}
