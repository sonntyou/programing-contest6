package pgcon06;

import java.util.Scanner;

public class Pgcon06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = 0;
		System.out.println("棒の長さを入力してください。");
		int L = scan.nextInt();
		int L2, L3;
		System.out.println("要素数を入力してください。");
		int N = (scan.nextInt());
		// List<Integer> list = new ArrayList<Integer>();
		int list[] = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = scan.nextInt();
		}

		quickSort(list, 0, (N - 1));

		// 1つ目の長さ
		for (int j = 0; j < N; j++) {
			// 一つ目の棒の長さが入力値を超えたら終了
			// または、入力値の半分を超えたら終了
			if ((L - list[j]) <= 0 || list[j] > (L / 2)) {
				break;
			}
			L2 = (L - list[j]);

			// 2つ目の数字
			for (int k = j + 1; k < N; k++) {
				// 1,2番目の合計値が棒の長さを超えたら終了
				// または2番目が残りの数より大きかったら終了。
				if ((L2 - list[k]) <= 0 || (L2 - list[k]) <= list[k + 1]) {
					break;
				}
				L3 = (L2 - list[k]);
				// 3つ目の長さ
				for (int l = k + 1; l < N; l++) {
					//
					if ((L3 - list[l]) == 0) {
						c++;

						break;
					} else {
						continue;
					}
				}// 3つ目の長さ
			}// ２つ目の長さ
		}// １つ目の長さ
		System.out.println("組み合わせは" + (c) + "通りです");
	}

	// 以下クイックソート用
	public static int base(int[] a, int first, int end) {
		int second = first + 1;
		while (second <= end && a[first] == a[second]) {
			second++;
		}
		if (second > end) {
			return -1;
		}
		if (a[first] >= a[second]) {
			return first;
		} else {
			return second;
		}

	}

	public static int partition(int[] a, int i, int j, int x) {
		int l = i, r = j;

		while (l <= r) {

			while (l <= j && a[l] < x) {
				l++;
			}

			while (r >= i && a[r] >= x) {
				r--;
			}

			if (l > r)
				break;
			int t = a[l];
			a[l] = a[r];
			a[r] = t;
			l++;
			r--;
		}
		return l;
	}

	public static void quickSort(int[] a, int i, int j) {
		if (i == j)
			return;
		int p = base(a, i, j);
		if (p != -1) {
			int k = partition(a, i, j, a[p]);
			quickSort(a, i, k - 1);
			quickSort(a, k, j);
		}
	}

}
