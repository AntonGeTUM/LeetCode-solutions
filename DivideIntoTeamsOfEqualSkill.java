public class DivideIntoTeamsOfEqualSkill {

    /**
     * Given an array 'skill', where skill[i] denotes the skill of player i, divide all players
     * into teams of size 2 and equal team skill. Return the sum of each team chemistry, where chemistry
     * is calculated using skill[i] * skill[j]. If players cannot be divided into teams of equal skill, return -1.
     * Skill is in the range of [1, 1000].
     * Example: skill = [3,2,5,1,3,4] => 22
     * Explanation: The teams are (1, 5), (2, 4), and (3, 3) and the resulting total chemistry
     *              1 * 5 + 2 * 4 + 3 * 3 = 22.
     * Solution: Assuming a sorted array, you can only form teams of equal skill by taking one player from each end
     *           of the skill array and putting them in a team. Thus, we start by sorting the given array. We use
     *           bucket sort as the value range of skill is very limited. We determine the skill target by looking
     *           at the highest and lowest existing skill levels. We iterate using two pointers, and if any team
     *           skill does not match the target value we return -1. Otherwise, we calculate the chemistry.
     * **/

    public long dividePlayers(int[] skill) {
        int[] arr = new int[1001];
        for (int i : skill) {
            arr[i]++;
        }

        int left = 0, right = 1000;
        while (arr[left] == 0) left++;
        while (arr[right] == 0) right--;
        long res = 0;
        int target = left + right;
        int n = skill.length;
        while(n > 0) {
            while (arr[left] == 0)
                left++;
            while (arr[right] == 0)
                right--;
            if (left + right != target)
                return -1;
            res += left * right;
            arr[left]--;
            arr[right]--;
            n -= 2;
        }
        return res;
    }
}
