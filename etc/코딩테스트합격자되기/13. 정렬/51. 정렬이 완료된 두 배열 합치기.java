import java.util.*;

class Solution {

	public static int[] solution(int[] arr1, int[] arr2) {

		int[] ans = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < arr1.length || j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				ans[k++] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				ans[k++] = arr2[j];
				j++;
			} else {
				ans[k++] = arr1[i];
				ans[k++] = arr2[j];
				i++;
				j++;
			}

			if (i == arr1.length) {
				while (j < arr2.length) {
					ans[k++] = arr2[j++];
				}
			} else if (j == arr2.length) {
				while (i < arr1.length) {
					ans[k++] = arr1[i++];
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] ans = solution(new int[] {1,3,5}, new int[] {2,4,6});
		// int[] ans = solution(new int[] {1,2,3}, new int[] {4,5,6});
		System.out.println(Arrays.toString(ans));
	}
}
