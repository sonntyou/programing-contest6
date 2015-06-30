package pgcon06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pgcon06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int c = 0;
		int L = Integer.parseInt(scan.next());
		int L2, L3;
		int N = Integer.parseInt(scan.next());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(scan.next()));
		}

		// 1つ目の長さ
		for (int j = 0; j < N; j++) {
			// 棒の長さを入力値が超えたら弾く
			if ((L - list.get(j)) <= 0) {
				continue;
			}
			L2 = (L - list.get(j));
			int firstnum = list.get(j);

			// 2つ目の数字
			for (int k = 0; k < N; k++) {
				// // 一番目と同じ要素を弾く
				if (k == j) {
					continue;
				}

				if ((L2 - list.get(k)) <= 0) {
					continue;
				}
				L3 = (L2 - list.get(k));
				int secondnum = list.get(k);
				// 3つ目の長さ
				for (int l = 0; l < N; l++) {

					// 1,2番目と同じ要素を弾く。
					if (l == k || l == j) {
						continue;
					}
					if ((L3 - list.get(l)) == 0) {
						int thirdnum = list.get(l);
						c++;

						break;
					} else {
						continue;
					}
				}// 3つ目の長さ
			}// ２つ目の長さ
		}// １つ目の長さ
		System.out.println("組み合わせは" + (c / 6) + "通りです");
	}

}
