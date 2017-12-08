import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
	
	public static void main(String[] args) {
		for (String s : input) {
			System.out.println(solve(s));
		}
	}

	private static class Result {
		int max, maxTemp;
		
		public Result(int m, int mT) {
			max =m;
			maxTemp = mT;
		}
		
		public String toString() {
			return "Max value: " + max + ", Max temporary value: " + maxTemp;
		}
	}
	
	public static Result solve(final String list) {
		Scanner s = new Scanner(list);
		
		Map<String, Integer> register = new HashMap<>();
		int max = Integer.MIN_VALUE;
		
		while(s.hasNext()) {
			String reg = s.next(), // Register
					op = s.next(); // Inc / dec
			
			int count = s.nextInt(); // Count (10, -5 ..)
			
			s.next(); // if
			
			String boolReg = s.next(), // Boolean Reg1
					boolOp = s.next(), // Boolean operator
					boolParam = s.next(); // Boolean Reg1 or Literal
			
			int c1_value = register.computeIfAbsent(boolReg, unused -> 0);
			
			Integer c2_value = getIntOrNull(boolParam);
			
			if(null == c2_value) {
				c2_value = register.computeIfAbsent(boolParam, unused -> 0);
			}
			
			if(applyOp(c1_value, boolOp, c2_value)) {
				int n = register.compute(reg, (key, i) -> applyOperator(i == null ? 0 : i, op, count));
				
				if(max < n) max = n;
			}
		}
		
		s.close();
		
		return new Result(Collections.max(register.values()), max);
	} 
	
	private static Integer getIntOrNull(String s) {
		return s.matches("-?[0-9]+") ? Integer.parseInt(s) : null;
	}
	
	private static int applyOperator(int old, String op, int val) {
		switch(op) {
			case "inc": return old + val;
			case "dec": return old - val;
		}
		throw new IllegalArgumentException("Should not happen, right ..?");
	}
	
	private static boolean applyOp(int a, String op, int b) {
		switch(op) {
			case "==": return a == b;
			case "!=": return a != b;
			case ">": return a > b;
			case ">=": return a >= b;
			case "<": return a < b;
			case "<=": return a <= b;
		}
		throw new IllegalArgumentException("Should not happen, right ..?");
	}
	
	private static final String[] input = {
			"b inc 5 if a > 1\n" + 
			"a inc 1 if b < 5\n" + 
			"c dec -10 if a >= 1\n" + 
			"c inc -20 if c == 10\n",
			
			"a dec -511 if x >= -4\n" + 
			"pq inc -45 if cfa == 7\n" + 
			"vby dec 69 if tl < 1\n" + 
			"yg dec 844 if v > -6\n" + 
			"tl inc -756 if u != 9\n" + 
			"l inc -267 if f == 0\n" + 
			"hnd dec 74 if qcg < 9\n" + 
			"pq inc 4 if f >= 0\n" + 
			"pq dec -168 if u < 2\n" + 
			"vby inc -778 if jus == 0\n" + 
			"yg inc 676 if pq < 179\n" + 
			"f dec 12 if u == 0\n" + 
			"zo dec 347 if e == 0\n" + 
			"q inc -934 if u >= -5\n" + 
			"jus dec 40 if ewg > -2\n" + 
			"f inc 8 if t != -7\n" + 
			"u inc 610 if pq > 170\n" + 
			"pq dec 565 if pq >= 176\n" + 
			"ss dec 948 if x != -6\n" + 
			"a dec 387 if ewg == 0\n" + 
			"qcg inc -513 if v < 7\n" + 
			"f dec -289 if uwm != -7\n" + 
			"ewg dec 269 if u == 610\n" + 
			"t dec 614 if ewg <= -263\n" + 
			"f dec 411 if cfa <= 9\n" + 
			"yg inc -62 if l != -271\n" + 
			"x dec 210 if ss == -948\n" + 
			"e dec 376 if l >= -259\n" + 
			"jus dec 709 if v < 9\n" + 
			"ewg inc -787 if l <= -266\n" + 
			"tl inc -643 if vby == -847\n" + 
			"zo inc 201 if e == 0\n" + 
			"f dec -379 if t == -614\n" + 
			"jus inc -963 if zo <= -147\n" + 
			"v inc 653 if tl == -1399\n" + 
			"ss dec 238 if v > 652\n" + 
			"jus inc 551 if u <= 614\n" + 
			"qcg inc 731 if ss > -1190\n" + 
			"a inc 503 if x < -200\n" + 
			"vby inc 209 if x != -204\n" + 
			"f dec 434 if f > 260\n" + 
			"t dec -364 if uwm > -6\n" + 
			"vpd dec 616 if vpd < 8\n" + 
			"v inc 100 if ss <= -1182\n" + 
			"f dec -825 if a != 623\n" + 
			"vby dec -51 if vpd > -620\n" + 
			"v dec 861 if ss < -1184\n" + 
			"hnd inc 270 if u >= 607\n" + 
			"vpd dec -111 if a >= 637\n" + 
			"a dec -720 if vpd < -615\n" + 
			"l dec 882 if qcg < 215\n" + 
			"zo inc -720 if ewg != -1062\n" + 
			"q inc 109 if yg <= -229\n" + 
			"a dec -599 if vby <= -586\n" + 
			"vpd inc -111 if q != -827\n" + 
			"cfa dec -775 if pq == 172\n" + 
			"hnd dec -402 if txc == 0\n" + 
			"t dec -886 if txc > -9\n" + 
			"t dec -805 if ewg >= -1057\n" + 
			"e dec -483 if yg < -224\n" + 
			"pq dec 400 if pq == 172\n" + 
			"t dec 125 if vby < -583\n" + 
			"qos dec 318 if q <= -821\n" + 
			"q dec 882 if qos <= -313\n" + 
			"pq inc 333 if pq >= -232\n" + 
			"v dec -378 if u <= 611\n" + 
			"txc dec 863 if l != -260\n" + 
			"vby dec 60 if x <= -218\n" + 
			"u dec 386 if u != 610\n" + 
			"q dec 876 if l == -267\n" + 
			"l dec -884 if e == 483\n" + 
			"u dec -445 if qos != -318\n" + 
			"cfa dec -412 if v > 260\n" + 
			"hnd dec -376 if q == -2580\n" + 
			"yg dec -458 if a >= 1942\n" + 
			"tl dec 783 if l <= 614\n" + 
			"qos inc -864 if f <= 1081\n" + 
			"uwm dec 872 if x > -211\n" + 
			"t dec 988 if qos < -1187\n" + 
			"jus dec -489 if x >= -212\n" + 
			"ewg inc 410 if cfa < 1181\n" + 
			"x inc 694 if vby == -587\n" + 
			"q dec -185 if f <= 1084\n" + 
			"txc dec -801 if v >= 263\n" + 
			"uwm inc -52 if ewg > -1065\n" + 
			"tl dec 535 if u <= 607\n" + 
			"v dec 252 if yg == 228\n" + 
			"jus dec 671 if t == 1319\n" + 
			"yg inc 386 if l != 609\n" + 
			"f dec 914 if cfa > 1185\n" + 
			"yg inc -365 if zo > -870\n" + 
			"ewg dec -439 if tl > -1393\n" + 
			"qcg dec -325 if pq < 110\n" + 
			"pq inc 303 if v >= 18\n" + 
			"u inc -85 if vpd != -727\n" + 
			"pq inc 41 if qos >= -1182\n" + 
			"uwm inc -824 if cfa < 1178\n" + 
			"txc inc 85 if hnd >= 591\n" + 
			"hnd inc -107 if vpd == -727\n" + 
			"x inc -73 if uwm < -917\n" + 
			"e inc -257 if pq <= 458\n" + 
			"v dec 122 if jus == 291\n" + 
			"v inc 886 if qcg > 538\n" + 
			"hnd inc -348 if cfa == 1187\n" + 
			"yg dec 350 if u == 610\n" + 
			"a dec 516 if ewg != -1051\n" + 
			"qos dec 68 if f > 158\n" + 
			"t dec 277 if qcg != 538\n" + 
			"txc inc 594 if f == 164\n" + 
			"ewg dec 873 if uwm == -932\n" + 
			"yg dec 152 if l < 621\n" + 
			"ewg inc 930 if v > 774\n" + 
			"ss dec -229 if zo != -858\n" + 
			"e inc 275 if ss >= -963\n" + 
			"e inc -649 if tl != -1409\n" + 
			"zo inc 976 if uwm >= -928\n" + 
			"v dec -812 if e == -150\n" + 
			"hnd inc -207 if v > 789\n" + 
			"pq inc -614 if uwm >= -927\n" + 
			"ss dec 16 if txc > 608\n" + 
			"qos dec 312 if ss == -973\n" + 
			"yg inc 615 if u <= 619\n" + 
			"e inc -842 if ewg < -125\n" + 
			"txc inc 109 if f <= 171\n" + 
			"f dec 179 if t > 1045\n" + 
			"pq dec 806 if ss <= -969\n" + 
			"a inc -665 if hnd == 143\n" + 
			"qos dec 31 if yg > 361\n" + 
			"q dec -924 if uwm == -924\n" + 
			"a dec 590 if pq > -975\n" + 
			"cfa inc -56 if qos > -1597\n" + 
			"vpd inc 318 if qcg != 548\n" + 
			"cfa dec 755 if t > 1030\n" + 
			"u inc -853 if vpd >= -414\n" + 
			"uwm dec 247 if v != 789\n" + 
			"qcg inc -746 if v < 784\n" + 
			"vby dec -290 if u >= -247\n" + 
			"v inc 474 if t != 1049\n" + 
			"u dec -681 if q < -1464\n" + 
			"uwm inc 290 if e < -983\n" + 
			"f dec 220 if tl > -1393\n" + 
			"ss inc 241 if l >= 615\n" + 
			"ewg inc -502 if tl <= -1390\n" + 
			"vby inc -960 if zo <= 113\n" + 
			"a dec -112 if tl <= -1397\n" + 
			"qos dec 787 if q <= -1470\n" + 
			"x dec 836 if ewg > -631\n" + 
			"ewg inc -665 if f <= 166\n" + 
			"qcg inc 56 if pq >= -978\n" + 
			"qcg dec -441 if vby >= -1257\n" + 
			"l inc 176 if l != 615\n" + 
			"jus dec -403 if cfa > 383\n" + 
			"vpd dec 428 if qos <= -2371\n" + 
			"u dec 232 if t < 1048\n" + 
			"v dec 254 if f >= 158\n" + 
			"txc inc 590 if vpd != -829\n" + 
			"a dec -882 if txc > 1314\n" + 
			"v inc -610 if v < 1007\n" + 
			"e inc -388 if yg >= 357\n" + 
			"qcg inc 229 if x != -419\n" + 
			"hnd dec 873 if cfa <= 377\n" + 
			"f dec -699 if vby > -1265\n" + 
			"txc inc 38 if yg != 360\n" + 
			"v dec -794 if jus == 291\n" + 
			"txc inc -382 if jus <= 294\n" + 
			"f inc 4 if uwm == -881\n" + 
			"vpd inc -853 if hnd == -730\n" + 
			"a inc 872 if cfa < 383\n" + 
			"ss inc -131 if f > 858\n" + 
			"jus dec -389 if txc > 978\n" + 
			"vpd inc -61 if hnd >= -735\n" + 
			"uwm dec -961 if cfa <= 384\n" + 
			"f dec -264 if q <= -1481\n" + 
			"f dec 946 if cfa >= 371\n" + 
			"uwm dec 376 if pq > -978\n" + 
			"qcg dec 652 if x == -425\n" + 
			"vpd dec 285 if qcg <= -128\n" + 
			"t dec -750 if l <= 799\n" + 
			"cfa inc 638 if yg < 367\n" + 
			"e inc -139 if hnd != -738\n" + 
			"f inc 510 if qcg <= -128\n" + 
			"v dec 114 if zo >= 107\n" + 
			"zo inc -783 if uwm != -302\n" + 
			"pq dec 116 if tl < -1397\n" + 
			"tl inc 83 if uwm > -297\n" + 
			"l inc 400 if qos >= -2383\n" + 
			"l dec 0 if ss != -872\n" + 
			"qcg inc -62 if tl != -1312\n" + 
			"vby dec -417 if uwm == -303\n" + 
			"ewg inc 356 if uwm == -296\n" + 
			"zo dec 138 if hnd == -730\n" + 
			"qcg inc 58 if cfa <= 1014\n" + 
			"txc inc 283 if qos < -2379\n" + 
			"qcg dec 572 if cfa <= 1017\n" + 
			"x dec 213 if qos <= -2374\n" + 
			"zo dec -884 if yg > 367\n" + 
			"uwm dec 868 if q != -1483\n" + 
			"zo dec -983 if ss == -863\n" + 
			"ss inc -635 if tl == -1316\n" + 
			"zo dec 383 if ewg == -931\n" + 
			"ss inc -911 if q != -1469\n" + 
			"txc inc -569 if v < 1079\n" + 
			"v inc 372 if ewg > -947\n" + 
			"v dec 936 if yg != 353\n" + 
			"x dec -972 if a == 2041\n" + 
			"yg dec 756 if q != -1467\n" + 
			"vpd dec -696 if vpd >= -2034\n" + 
			"txc dec -822 if cfa != 1021\n" + 
			"l inc -211 if pq >= -1088\n" + 
			"qcg dec -770 if e > -1520\n" + 
			"qcg inc -787 if hnd != -725\n" + 
			"vpd dec -689 if uwm <= -1161\n" + 
			"l dec -219 if vpd >= -1347\n" + 
			"l dec -344 if uwm <= -1163\n" + 
			"f inc -545 if e > -1526\n" + 
			"hnd dec 856 if e > -1518\n" + 
			"cfa dec 993 if jus == 291\n" + 
			"e dec -559 if txc > 1505\n" + 
			"e inc -179 if txc < 1510\n" + 
			"yg inc -230 if tl <= -1324\n" + 
			"ss inc 117 if vby == -1257\n" + 
			"f inc -398 if a >= 2035\n" + 
			"x inc 302 if zo == 181\n" + 
			"vpd dec 739 if vpd != -1355\n" + 
			"t inc -165 if hnd <= -1585\n" + 
			"pq inc 948 if ewg <= -930\n" + 
			"ss dec -489 if cfa >= 15\n" + 
			"ewg dec -937 if qos < -2377\n" + 
			"q dec 209 if pq == -139\n" + 
			"f dec -911 if v <= 515\n" + 
			"zo dec -437 if x > 336\n" + 
			"vpd inc 907 if jus < 300\n" + 
			"e dec 957 if q == -1683\n" + 
			"jus inc 153 if tl <= -1320\n" + 
			"v inc 752 if qcg <= -717\n" + 
			"tl inc -884 if q != -1688\n" + 
			"a inc 363 if txc >= 1502\n" + 
			"qos inc 469 if vpd > -1183\n" + 
			"tl inc -524 if l > 1540\n" + 
			"cfa dec -632 if e > -2102\n" + 
			"f dec -31 if e < -2091\n" + 
			"hnd inc 602 if hnd > -1594\n" + 
			"e dec -373 if v == 1260\n" + 
			"qcg dec 61 if t <= 1630\n" + 
			"v inc -982 if vpd == -1183\n" + 
			"uwm dec -308 if a != 2408\n" + 
			"l dec 996 if qos > -1912\n" + 
			"yg dec 977 if qcg != -775\n" + 
			"tl inc 56 if t == 1624\n" + 
			"pq dec -106 if l != 554\n" + 
			"hnd dec 770 if ewg == 0\n" + 
			"qos inc 553 if zo <= 180\n" + 
			"f inc -879 if hnd < -1749\n" + 
			"e dec -556 if f > -450\n" + 
			"zo inc 564 if e >= -1166\n" + 
			"qcg dec 937 if f <= -449\n" + 
			"v inc -552 if q > -1693\n" + 
			"a dec 450 if uwm != -854\n" + 
			"a inc 18 if e <= -1162\n" + 
			"ewg dec 754 if v <= 698\n" + 
			"ewg dec -47 if uwm != -847\n" + 
			"cfa inc 374 if vby < -1251\n" + 
			"e dec 369 if e > -1162\n" + 
			"hnd dec -203 if yg != -1371\n" + 
			"ss dec -919 if q < -1677\n" + 
			"txc dec 937 if qcg >= -1729\n" + 
			"vby inc -105 if a >= 1972\n" + 
			"ss inc -204 if txc <= 573\n" + 
			"jus inc 626 if a >= 1968\n" + 
			"ss dec 783 if v != 708\n" + 
			"t inc -734 if cfa >= 1021\n" + 
			"vby inc 899 if qcg == -1720\n" + 
			"jus inc -5 if pq > -32\n" + 
			"uwm dec -717 if zo <= 733\n" + 
			"hnd inc -613 if x > 332\n" + 
			"l inc -854 if pq <= -28\n" + 
			"e inc 615 if u != 206\n" + 
			"ss dec 944 if uwm > -862\n" + 
			"a inc -491 if f > -451\n" + 
			"yg inc 595 if txc < 580\n" + 
			"cfa dec -628 if uwm < -849\n" + 
			"uwm dec 171 if uwm <= -848\n" + 
			"e dec 397 if vpd != -1171\n" + 
			"tl dec -491 if l != -297\n" + 
			"t dec 610 if q >= -1692\n" + 
			"v inc 634 if vby < -456\n" + 
			"jus dec 401 if vby != -471\n" + 
			"ss inc 576 if a != 1481\n" + 
			"f inc 885 if pq > -36\n" + 
			"hnd dec 102 if x == 334\n" + 
			"x dec -578 if e != -1567\n" + 
			"txc inc -122 if cfa != 1660\n" + 
			"e inc -915 if txc <= 451\n" + 
			"uwm dec 683 if v >= 1336\n" + 
			"a dec -523 if yg <= -771\n" + 
			"jus dec 72 if cfa != 1650\n" + 
			"u dec 524 if vpd != -1171\n" + 
			"e inc 786 if qcg <= -1711\n" + 
			"e inc -254 if q <= -1687\n" + 
			"tl dec 992 if ewg > 50\n" + 
			"vby dec 157 if u != -309\n" + 
			"x dec -774 if cfa == 1655\n" + 
			"v inc 842 if vby <= -612\n" + 
			"t inc 64 if uwm < -1703\n" + 
			"e inc 928 if f < 440\n" + 
			"a dec -150 if hnd <= -2463\n" + 
			"vpd inc -685 if yg == -776\n" + 
			"tl inc -963 if a == 2154\n" + 
			"ewg inc -804 if qos != -1363\n" + 
			"tl dec -363 if ewg > -762\n" + 
			"tl inc -769 if zo < 730\n" + 
			"yg inc 635 if zo <= 732\n" + 
			"tl inc -283 if jus < 447\n" + 
			"uwm dec -918 if tl >= -3069\n" + 
			"q dec -216 if jus != 452\n" + 
			"a dec 727 if e == -763\n" + 
			"q dec 467 if hnd > -2470\n" + 
			"qos dec -420 if u <= -316\n" + 
			"cfa dec 686 if q < -1930\n" + 
			"tl dec 953 if v > 2182\n" + 
			"f dec 473 if a != 1427\n" + 
			"a inc 110 if uwm < -784\n" + 
			"u inc -543 if qos == -938\n" + 
			"x inc 591 if qcg != -1721\n" + 
			"x dec 58 if f > 435\n" + 
			"a dec -670 if yg < -774\n" + 
			"pq inc -119 if hnd < -2468\n" + 
			"ewg dec -254 if ss == -2031\n" + 
			"cfa dec 279 if pq < -151\n" + 
			"pq inc 274 if uwm > -801\n" + 
			"tl inc -361 if cfa != 697\n" + 
			"ss inc 797 if v > 2174\n" + 
			"uwm inc -8 if x >= 2218\n" + 
			"l dec -769 if u != -861\n" + 
			"ewg inc -899 if vby >= -610\n" + 
			"hnd inc -950 if qcg < -1712\n" + 
			"jus inc 905 if e != -757\n" + 
			"v dec 825 if vby >= -610\n" + 
			"uwm dec -905 if a <= 2214\n" + 
			"vpd inc -154 if l <= -301\n" + 
			"vpd dec -345 if pq == 122\n" + 
			"yg inc 75 if ss >= -1240\n" + 
			"pq inc 208 if ewg <= -761\n" + 
			"u dec -569 if qos >= -942\n" + 
			"vby inc -840 if l >= -297\n" + 
			"uwm inc 219 if u != -285\n" + 
			"tl dec 956 if vby >= -625\n" + 
			"zo inc -885 if vpd != -1673\n" + 
			"ewg inc 536 if a < 2212\n" + 
			"u inc -628 if ss > -1244\n" + 
			"q inc 94 if ewg >= -216\n" + 
			"cfa dec 212 if uwm >= 316\n" + 
			"pq inc 776 if q != -1943\n" + 
			"x dec 244 if zo < 745\n" + 
			"vby inc 267 if pq <= 899\n" + 
			"jus inc 512 if vby < -352\n" + 
			"v inc 942 if jus < 1852\n" + 
			"qos dec 364 if t > 341\n" + 
			"qcg inc -695 if cfa <= 483\n" + 
			"zo dec 221 if e < -758\n" + 
			"u inc 218 if vby == -353\n" + 
			"e inc -423 if hnd != -3419\n" + 
			"f inc 631 if ss >= -1244\n" + 
			"ss inc -487 if t < 352\n" + 
			"txc dec 351 if l == -308\n" + 
			"pq inc 581 if qos > -1305\n" + 
			"q inc -740 if uwm != 324\n" + 
			"v dec -929 if x <= 1981\n" + 
			"jus dec -782 if u == -702\n" + 
			"yg inc 197 if vpd < -1663\n" + 
			"ewg inc 604 if ss != -1721\n" + 
			"tl dec -426 if qos == -1308\n" + 
			"zo inc 627 if q < -1941\n" + 
			"f inc 815 if ewg == 383\n" + 
			"f dec -567 if x != 1981\n" + 
			"u inc 836 if tl > -5332\n" + 
			"ewg inc -787 if ss >= -1715\n" + 
			"uwm dec -513 if qcg <= -2423\n" + 
			"l dec 396 if zo != 511\n" + 
			"f dec 928 if u <= 139\n" + 
			"txc inc -2 if cfa == 478\n" + 
			"vpd dec -936 if t != 352\n" + 
			"zo inc -269 if q <= -1931\n" + 
			"zo inc -600 if zo != 246\n" + 
			"f dec 723 if hnd > -3416\n" + 
			"v inc -707 if vby < -348\n" + 
			"a dec -205 if l <= -710\n" + 
			"qos dec -396 if jus < 2651\n" + 
			"cfa dec 107 if qos > -913\n" + 
			"a inc 861 if txc >= 456\n" + 
			"uwm inc -700 if hnd == -3420\n" + 
			"x dec -347 if uwm >= 331\n" + 
			"t dec -857 if qcg < -2408\n" + 
			"a dec -876 if a >= 2204\n" + 
			"qos inc 563 if pq < 1487\n" + 
			"x dec -11 if cfa >= 363\n" + 
			"yg inc -114 if e <= -759\n" + 
			"vby inc 439 if pq < 1485\n" + 
			"a inc 394 if x < 1989\n" + 
			"zo inc -996 if zo <= 246\n" + 
			"jus dec -685 if hnd != -3426\n" + 
			"t dec 465 if q != -1929\n" + 
			"txc inc 728 if vpd >= -742\n" + 
			"vby dec -134 if hnd < -3412\n" + 
			"jus inc -485 if e >= -765\n" + 
			"v inc 220 if l == -697\n" + 
			"f inc 470 if txc <= 1175\n" + 
			"e dec 783 if uwm == 324\n" + 
			"jus dec -697 if cfa >= 369\n" + 
			"qos dec 790 if vpd >= -737\n" + 
			"jus inc 654 if l < -693\n" + 
			"tl dec -803 if a >= 3470\n" + 
			"txc dec -738 if vpd <= -745\n" + 
			"uwm inc 67 if cfa != 371\n" + 
			"f dec -702 if l < -692\n" + 
			"x dec -280 if qos == -1133\n" + 
			"jus inc 917 if ewg == 383\n" + 
			"e inc -198 if yg <= -610\n" + 
			"v dec -387 if hnd <= -3415\n" + 
			"u inc 751 if uwm >= 318\n" + 
			"a dec -432 if pq >= 1485\n" + 
			"t inc -946 if vby >= 218\n" + 
			"pq dec -76 if f >= 2690\n" + 
			"txc dec 16 if qcg >= -2415\n" + 
			"t dec 302 if txc != 1158\n" + 
			"pq dec -818 if uwm <= 316\n" + 
			"q dec -404 if zo < -748\n" + 
			"f inc -563 if yg != -625\n" + 
			"x inc -686 if e != -1750\n" + 
			"txc dec -413 if vby >= 214\n" + 
			"uwm dec 968 if vpd != -730\n" + 
			"e dec 908 if txc <= 1575\n" + 
			"cfa dec -787 if a >= 3470\n" + 
			"yg inc -393 if qcg >= -2417\n" + 
			"cfa inc -874 if uwm == -644\n" + 
			"ss inc 466 if ewg < 387\n" + 
			"zo dec -858 if vpd < -731\n" + 
			"ss dec 566 if txc <= 1562\n" + 
			"vpd dec -237 if tl != -4529\n" + 
			"yg inc -486 if vpd < -494\n" + 
			"cfa dec 635 if qos >= -1131\n" + 
			"jus dec -62 if x > 1572\n" + 
			"cfa dec 76 if e >= -2643\n" + 
			"a inc -207 if ewg == 383\n" + 
			"pq inc -674 if yg < -1497\n" + 
			"zo inc -952 if jus != 5182\n" + 
			"tl inc -258 if yg <= -1488\n" + 
			"cfa dec -818 if txc <= 1580\n" + 
			"tl inc 695 if pq >= 1548\n" + 
			"e inc 919 if q == -1530\n" + 
			"t inc -340 if u >= 881\n" + 
			"e dec -449 if vby >= 218\n" + 
			"ewg dec -468 if cfa == 1102\n" + 
			"yg inc 617 if pq != 1548\n" + 
			"zo dec 809 if pq <= 1563\n" + 
			"vby dec -685 if uwm == -644\n" + 
			"cfa inc -157 if e < -1283\n" + 
			"zo inc 65 if uwm <= -640\n" + 
			"f dec 729 if e != -1278\n" + 
			"l inc -313 if hnd > -3423\n" + 
			"jus dec 180 if x >= 1574\n" + 
			"jus inc -520 if ss < -1255\n" + 
			"hnd dec -493 if f >= 1403\n" + 
			"jus inc -783 if qos < -1136\n" + 
			"e dec -486 if t <= -848\n" + 
			"u dec 248 if q >= -1530\n" + 
			"u inc -379 if vby != 901\n" + 
			"pq inc 590 if qcg > -2408\n" + 
			"l inc 757 if uwm <= -644\n" + 
			"q dec 283 if uwm >= -644\n" + 
			"t inc 681 if tl > -4097\n" + 
			"uwm inc 359 if ss < -1248\n" + 
			"v dec -725 if ss > -1260\n" + 
			"x dec 584 if txc != 1573\n" + 
			"ss dec 938 if x < 1002\n" + 
			"cfa dec -19 if ewg <= 851\n" + 
			"f dec 909 if u == 258\n" + 
			"v dec -295 if f < 498\n" + 
			"l inc -132 if uwm >= -291\n" + 
			"u inc 921 if l >= -390\n" + 
			"pq inc -253 if u == 1189\n" + 
			"l inc -431 if jus != 4473\n" + 
			"qos dec -855 if qos <= -1132\n" + 
			"qos dec 691 if yg >= -882\n" + 
			"jus inc 117 if cfa >= 955\n" + 
			"qcg dec 438 if yg < -875\n" + 
			"tl dec -922 if tl <= -4088\n" + 
			"ewg dec -424 if qcg == -2862\n" + 
			"l dec 249 if x < 1004\n" + 
			"tl inc 388 if e >= -800\n" + 
			"ss inc -962 if q > -1820\n" + 
			"zo inc -141 if ss <= -3147\n" + 
			"pq inc -508 if vby < 908\n" + 
			"t inc -64 if l == -638\n" + 
			"cfa dec 534 if qos <= -968\n" + 
			"v inc 906 if tl == -2780\n" + 
			"hnd inc -830 if f != 497\n" + 
			"qcg dec -186 if vby >= 907\n" + 
			"uwm dec -155 if t < -242\n" + 
			"ss dec -312 if hnd <= -4251\n" + 
			"tl inc -619 if x == 996\n" + 
			"txc inc -620 if e == -798\n" + 
			"uwm dec 861 if l == -638\n" + 
			"t inc 715 if t > -233\n" + 
			"cfa dec 603 if zo > -1726\n" + 
			"cfa inc -523 if pq > 1042\n" + 
			"a dec 547 if uwm == -1151\n" + 
			"l dec -8 if jus < 4593\n" + 
			"e inc -601 if t <= -230\n" + 
			"qcg dec -637 if yg >= -879\n" + 
			"l dec 814 if qos != -969\n" + 
			"jus inc 204 if tl < -3399\n" + 
			"yg dec 111 if pq > 1050\n" + 
			"qcg inc -188 if qos >= -971\n" + 
			"a dec 760 if vpd > -504\n" + 
			"jus dec -523 if hnd != -4247\n" + 
			"q dec 664 if e <= -1398\n" + 
			"txc inc -8 if q >= -2477\n" + 
			"e inc -333 if yg >= -888\n" + 
			"txc inc -222 if u >= 1173\n" + 
			"jus dec 304 if x < 987\n" + 
			"a inc -766 if vby < 912\n" + 
			"qos inc 464 if pq > 1037\n" + 
			"cfa inc 500 if q >= -2479\n" + 
			"jus dec 49 if u < 1187\n" + 
			"hnd inc -440 if cfa >= 403\n" + 
			"txc inc -741 if yg <= -873\n" + 
			"ewg inc 836 if hnd > -4696\n" + 
			"v dec -890 if vpd != -500\n" + 
			"q dec 954 if vpd != -509\n" + 
			"t inc 846 if e > -1739\n" + 
			"ewg dec -458 if vpd == -500\n" + 
			"t inc -995 if e <= -1732\n" + 
			"u dec -987 if q < -3427\n" + 
			"l dec -303 if pq < 1054\n" + 
			"t dec 527 if qos <= -498\n" + 
			"ewg inc 607 if hnd >= -4689\n" + 
			"l dec 203 if e >= -1733\n" + 
			"zo dec -961 if qcg != -3032\n" + 
			"t dec 880 if a >= 1741\n" + 
			"x dec -447 if t != -1787\n" + 
			"pq inc 735 if pq > 1043\n" + 
			"f inc 386 if u > 2167\n" + 
			"t dec 886 if hnd != -4689\n" + 
			"e inc 395 if yg < -889\n" + 
			"a dec -361 if txc != -24\n" + 
			"q inc 837 if e >= -1732\n" + 
			"uwm inc 779 if qcg >= -3050\n" + 
			"ewg dec -506 if ewg <= 2761\n" + 
			"e inc 367 if v >= 4717\n" + 
			"jus dec 710 if vby <= 908\n" + 
			"v inc 956 if l != -531\n" + 
			"e inc -724 if cfa != 417\n" + 
			"a dec -54 if v < 5685\n" + 
			"qos inc -463 if tl >= -3405\n" + 
			"a inc 634 if hnd < -4695\n" + 
			"txc dec -613 if x <= 1450\n" + 
			"t inc -595 if txc > 602\n" + 
			"zo inc 807 if yg < -870\n" + 
			"uwm dec -253 if x != 1444\n" + 
			"v dec 249 if u != 2173\n" + 
			"cfa dec 286 if pq != 1791\n" + 
			"jus dec 340 if ewg < 3261\n" + 
			"e inc 391 if yg <= -879\n" + 
			"v inc -554 if qos >= -961\n" + 
			"u inc 118 if a < 2168\n" + 
			"ss dec -898 if txc == 590\n" + 
			"ewg inc 757 if l > -525\n" + 
			"tl dec -250 if u != 2284\n" + 
			"f inc -51 if l > -525\n" + 
			"f inc 574 if x >= 1437\n" + 
			"e inc -55 if yg >= -881\n" + 
			"yg dec -832 if tl == -3391\n" + 
			"yg dec 176 if vby <= 899\n" + 
			"u dec 215 if a <= 2155\n" + 
			"x inc -411 if ewg <= 3264\n" + 
			"u inc -76 if vby <= 912\n" + 
			"q dec -479 if ss > -3163\n" + 
			"qos dec -136 if tl < -3398\n" + 
			"ss inc -631 if qos <= -839\n" + 
			"cfa dec 561 if pq < 1786\n" + 
			"ss inc -817 if uwm > -119\n" + 
			"qos dec -544 if l >= -522\n" + 
			"qos dec -82 if u != 2205\n" + 
			"vpd dec 427 if qcg >= -3049\n" + 
			"u dec 296 if uwm > -115\n" + 
			"x inc -533 if tl >= -3405\n" + 
			"ss inc -529 if q > -2125\n" + 
			"e inc 745 if uwm < -109\n" + 
			"cfa inc -488 if l == -530\n" + 
			"vpd inc 778 if txc > 593\n" + 
			"jus dec -399 if l < -526\n" + 
			"u inc 144 if x < 500\n" + 
			"t dec -554 if u < 2066\n" + 
			"txc inc -200 if u > 2055\n" + 
			"zo inc 382 if qos != -750\n" + 
			"pq inc -191 if jus != 4409\n" + 
			"vby dec 602 if a >= 2150\n" + 
			"qcg dec -517 if tl < -3397\n" + 
			"jus dec -416 if jus == 4413\n" + 
			"uwm inc 157 if f != 1066\n" + 
			"vpd dec -888 if yg == -880\n" + 
			"tl dec 79 if qcg > -2533\n" + 
			"pq dec 604 if e < -1006\n" + 
			"hnd dec -901 if l != -522\n" + 
			"qcg dec 328 if qos != -744\n" + 
			"yg inc -412 if cfa != -938\n" + 
			"ewg dec -571 if vpd < 744\n" + 
			"cfa inc -925 if qos == -750\n" + 
			"qcg dec -605 if yg < -1284\n" + 
			"x inc 470 if pq >= 987\n" + 
			"hnd dec 82 if yg < -1286\n" + 
			"qcg dec -874 if pq != 987\n" + 
			"x dec 457 if hnd <= -3862\n" + 
			"ewg dec -591 if qos > -752\n" + 
			"ss dec -820 if zo >= 39\n" + 
			"v inc -967 if tl != -3482\n" + 
			"v inc 742 if jus > 4825\n" + 
			"f dec -381 if cfa != -1862\n" + 
			"qcg inc -868 if cfa <= -1850\n" + 
			"qcg dec -358 if x < 518\n" + 
			"txc inc -23 if x != 503\n" + 
			"l dec -239 if jus <= 4830\n" + 
			"qcg inc -771 if pq == 996\n" + 
			"hnd dec -724 if vby <= 310\n" + 
			"cfa inc -823 if hnd > -3140\n" + 
			"v dec -558 if x > 504\n" + 
			"t inc -89 if uwm > -118\n" + 
			"jus inc 432 if ss <= -3678\n" + 
			"jus inc -343 if zo >= 31\n" + 
			"yg dec 474 if ewg == 4420\n" + 
			"q dec 330 if jus >= 4915\n" + 
			"qos dec 805 if zo == 46\n" + 
			"qcg inc 670 if t >= -1326\n" + 
			"f dec 945 if vby > 310\n" + 
			"jus inc -68 if q <= -2440\n" + 
			"tl dec -424 if a == 2159\n" + 
			"tl inc 460 if u <= 2063\n" + 
			"f dec -759 if uwm != -120\n" + 
			"v inc 507 if qcg == -2078\n" + 
			"zo inc 881 if pq <= 990\n" + 
			"qcg inc -792 if yg <= -1769\n" + 
			"qos dec -730 if ewg <= 4420\n" + 
			"f inc 968 if pq <= 989\n" + 
			"tl dec -539 if txc < 376\n" + 
			"vpd dec 823 if ewg >= 4429\n" + 
			"qos dec -476 if ss <= -3692\n" + 
			"qos dec 609 if vby > 303\n" + 
			"u inc -266 if x == 506\n" + 
			"v inc -99 if pq < 990\n" + 
			"q dec -627 if ss <= -3680\n" + 
			"qos dec 372 if t >= -1334\n" + 
			"cfa inc 959 if qcg >= -2086\n" + 
			"x dec -893 if hnd > -3156\n" + 
			"x inc 69 if vby > 300\n" + 
			"qcg inc 333 if ss <= -3673\n" + 
			"e dec 525 if u < 2064\n" + 
			"yg inc 402 if tl == -2055\n" + 
			"ewg dec 938 if u > 2050\n" + 
			"tl dec 989 if e != -1526\n" + 
			"f inc 894 if cfa != -1854\n" + 
			"t inc -834 if txc >= 370\n" + 
			"yg dec 197 if ss != -3682\n" + 
			"f inc -741 if zo >= 926\n" + 
			"l dec -257 if v != 5659\n" + 
			"a dec -713 if a > 2158\n" + 
			"jus inc -279 if ewg <= 3487\n" + 
			"v dec -910 if ss < -3673\n" + 
			"e dec -601 if cfa >= -1854\n" + 
			"tl dec -106 if ewg > 3477\n" + 
			"x inc -144 if yg < -1361\n" + 
			"zo dec -454 if ss != -3678\n" + 
			"a inc -887 if l > -43\n" + 
			"ss inc 184 if ewg >= 3490\n" + 
			"jus dec 865 if txc == 371\n" + 
			"q dec 156 if cfa == -1853\n" + 
			"ss inc 435 if a != 1989\n" + 
			"l inc -121 if a < 1995\n" + 
			"qos dec 846 if f < 4076\n" + 
			"jus inc -580 if q == -1974\n" + 
			"vby inc 11 if e != -938\n" + 
			"q dec -355 if hnd >= -3146\n" + 
			"vpd dec -49 if jus <= 3132\n" + 
			"cfa inc -311 if uwm != -123\n" + 
			"vby inc -541 if a >= 1990\n" + 
			"f dec -11 if ss < -3238\n" + 
			"e inc 964 if zo == 1374\n" + 
			"pq inc -380 if yg > -1369\n" + 
			"q dec -140 if x > 1320\n" + 
			"jus inc -605 if yg < -1362\n" + 
			"ss inc -520 if pq > 616\n" + 
			"uwm inc -686 if jus != 2528\n" + 
			"jus inc 523 if e <= 32\n" + 
			"pq inc 658 if x >= 1329\n" + 
			"pq inc -513 if vby >= 320\n" + 
			"q dec 161 if x != 1330\n" + 
			"u dec 943 if a == 1985\n" + 
			"yg inc 785 if cfa < -2156\n" + 
			"hnd dec -969 if txc > 362\n" + 
			"ss inc 74 if l < -146\n" + 
			"ss dec 63 if cfa >= -2171\n" + 
			"txc inc 331 if ss > -3246\n" + 
			"qcg dec 229 if uwm <= -792\n" + 
			"u inc -497 if v == 6570\n" + 
			"uwm dec -725 if cfa >= -2163\n" + 
			"f dec -439 if u != 616\n" + 
			"a dec 11 if v >= 6563\n" + 
			"e dec 176 if u != 618\n" + 
			"v inc 921 if e < -138\n" + 
			"e dec 656 if a == 1974\n" + 
			"hnd dec 64 if qcg == -1983\n" + 
			"hnd inc 779 if v > 7481\n" + 
			"tl inc 421 if cfa == -2157\n" + 
			"ewg dec -732 if uwm == -800\n" + 
			"x dec 223 if q <= -1473\n" + 
			"zo inc 74 if ss == -3242\n" + 
			"ss dec -594 if uwm <= -793\n" + 
			"x inc -507 if ss < -2639\n" + 
			"f dec -68 if e == -800\n" + 
			"cfa dec -763 if jus == 3044\n" + 
			"t inc 931 if a <= 1978\n" + 
			"pq inc -602 if ewg <= 4217\n" + 
			"ss dec 512 if l <= -154\n" + 
			"t dec 145 if qcg > -1989\n" + 
			"cfa inc -621 if f == 4147\n" + 
			"e inc 430 if f > 4145\n" + 
			"f dec -800 if ss > -3157\n" + 
			"a dec 496 if v > 7482\n" + 
			"qcg dec 289 if t <= -1369\n" + 
			"yg inc -634 if vpd >= 783\n" + 
			"e dec 722 if ewg <= 4214\n" + 
			"ewg dec 506 if qcg != -2272\n" + 
			"q dec 911 if f == 4947\n" + 
			"f inc -515 if tl < -2932\n" + 
			"x dec 788 if qcg >= -2280\n" + 
			"a dec -542 if yg != -1218\n" + 
			"yg inc -124 if ss != -3155\n" + 
			"v dec 510 if vpd != 795\n" + 
			"l inc 920 if vpd == 783\n" + 
			"u dec 314 if tl != -2940\n" + 
			"tl dec 375 if pq == 663\n" + 
			"tl inc 358 if jus != 3049\n" + 
			"x dec 41 if uwm <= -805\n" + 
			"zo inc 844 if yg != -1343\n" + 
			"v inc -463 if ss <= -3148\n" + 
			"hnd dec 99 if hnd >= -1462\n" + 
			"v dec 357 if pq > 670\n" + 
			"v dec 974 if u < 294\n" + 
			"e inc -375 if e < -1090\n" + 
			"u inc -501 if yg <= -1336\n" + 
			"zo inc -563 if a <= 2018\n" + 
			"t inc -602 if v == 6518\n" + 
			"qos inc 366 if vby >= 316\n" + 
			"jus inc -366 if t >= -1985\n" + 
			"f inc -218 if u > -202\n" + 
			"zo inc 932 if jus >= 2676\n" + 
			"l inc -50 if qcg > -2268\n" + 
			"ewg inc 170 if pq == 670\n" + 
			"hnd dec 605 if f < 4221\n" + 
			"pq inc 746 if u <= -205\n" + 
			"f inc 582 if uwm == -800\n" + 
			"x dec -43 if tl != -2955\n" + 
			"ss dec -420 if q >= -2395\n" + 
			"jus dec -493 if ss > -2736\n" + 
			"x dec 977 if ss >= -2736\n" + 
			"uwm inc 956 if e < -1461\n" + 
			"l dec -397 if vpd <= 791\n" + 
			"vpd inc 548 if pq > 655\n" + 
			"vby dec -958 if t != -1976\n" + 
			"pq dec -565 if jus >= 3163\n" + 
			"q dec -667 if yg >= -1345\n" + 
			"cfa dec -6 if jus < 3179\n" + 
			"e inc 842 if tl <= -2953\n" + 
			"q inc 680 if jus > 3166\n" + 
			"txc dec -618 if l > 238\n" + 
			"cfa dec -494 if l >= 242\n" + 
			"t dec -969 if uwm <= 163\n" + 
			"ss dec 421 if ss != -2734\n" + 
			"t inc -548 if tl <= -2949\n" + 
			"uwm dec -835 if t >= -1546\n" + 
			"tl inc -393 if f == 4796\n" + 
			"vpd dec 643 if cfa == -1530\n" + 
			"x inc 768 if vby == 314\n" + 
			"a inc -252 if jus == 3171\n" + 
			"f inc 177 if f >= 4797\n" + 
			"v dec -352 if e >= -615\n" + 
			"yg inc -913 if jus < 3181\n" + 
			"qos dec -893 if l == 242\n" + 
			"a inc -627 if vby <= 321\n" + 
			"txc dec -351 if tl != -3343\n" + 
			"cfa dec -913 if zo < 3150\n" + 
			"txc dec -750 if txc < 1672\n" + 
			"a inc 803 if hnd == -2176\n" + 
			"jus dec 188 if jus < 3178\n" + 
			"zo dec -350 if ewg > 4206\n" + 
			"f dec -941 if ewg >= 4206\n" + 
			"pq inc -603 if hnd > -2175\n" + 
			"q inc 360 if t <= -1547\n" + 
			"pq dec 475 if pq >= 630\n" + 
			"yg inc 931 if l >= 235\n" + 
			"t dec 361 if x > -399\n" + 
			"a dec -383 if yg <= -1313\n" + 
			"f dec -777 if t != -1914\n" + 
			"yg inc 169 if uwm > 149\n" + 
			"qos inc 239 if t >= -1920\n" + 
			"vby dec -903 if txc < 2424\n" + 
			"jus dec 889 if jus >= 2983\n" + 
			"v inc -172 if cfa <= -1514\n" + 
			"v inc -278 if e >= -633\n" + 
			"t dec -929 if hnd != -2164\n" + 
			"a inc 918 if t >= -996\n" + 
			"x inc -690 if vby == 1217\n" + 
			"zo dec 268 if txc >= 2420\n" + 
			"v dec -591 if t >= -989\n" + 
			"x inc -620 if vpd != 1332\n" + 
			"l inc 51 if ewg < 4220\n" + 
			"f inc -518 if qcg != -2267\n" + 
			"vby dec 898 if uwm == 156\n" + 
			"jus dec -53 if l == 293\n" + 
			"hnd dec -127 if qos == -105\n" + 
			"uwm dec -99 if q >= -692\n" + 
			"q inc 340 if hnd >= -2175\n" + 
			"vpd dec 740 if vby <= 321\n" + 
			"a inc -931 if qos > -105\n" + 
			"hnd inc -25 if qos < -100\n" + 
			"pq dec 366 if tl >= -3353\n" + 
			"f dec -126 if a <= 2449\n" + 
			"yg dec 642 if ss >= -2739\n" + 
			"ss inc 735 if jus > 2156\n" + 
			"t dec -329 if qos <= -104\n" + 
			"q inc -292 if x > -1714\n" + 
			"vpd inc -406 if hnd != -2183\n" + 
			"e dec -367 if tl != -3343\n" + 
			"yg inc 891 if x == -1707\n" + 
			"uwm dec -520 if vpd >= 184\n" + 
			"yg inc -180 if jus == 2147\n" + 
			"uwm inc -767 if l >= 300\n" + 
			"txc inc -728 if jus == 2147\n" + 
			"q dec -876 if zo == 3232\n" + 
			"ss dec -255 if vpd > 187\n" + 
			"qcg inc -360 if t > -667\n" + 
			"jus dec 357 if v != 6658\n" + 
			"ss dec 239 if t > -652\n" + 
			"cfa inc 349 if txc < 1701\n" + 
			"cfa inc 185 if hnd <= -2188\n" + 
			"q dec 858 if vby <= 323\n" + 
			"ss dec 290 if yg == -1081\n" + 
			"cfa dec -473 if yg > -1073\n" + 
			"qcg inc -333 if ss < -2766\n" + 
			"l dec 539 if hnd > -2200\n" + 
			"v inc -210 if hnd <= -2190\n" + 
			"e inc 531 if a < 2447\n" + 
			"yg dec -156 if e != 265\n" + 
			"t dec -188 if q < -610\n" + 
			"vpd inc 757 if qos == -106\n" + 
			"zo dec 801 if x > -1713\n" + 
			"u dec -49 if a < 2445\n" + 
			"qos inc -451 if tl >= -3352\n" + 
			"q dec -531 if x >= -1712\n" + 
			"a inc 32 if jus > 1784\n" + 
			"ss inc -258 if pq != 261\n" + 
			"cfa dec 445 if l >= -251\n" + 
			"t inc 897 if l <= -256\n" + 
			"e dec -199 if hnd < -2182\n" + 
			"vby inc 309 if v == 6449\n" + 
			"ewg dec 839 if qos == -565\n" + 
			"hnd inc 961 if hnd >= -2199\n" + 
			"cfa inc -780 if qcg == -2974\n" + 
			"ewg dec 443 if qcg == -2965\n" + 
			"hnd inc -901 if uwm < 780\n" + 
			"ss inc 597 if vpd == 947\n" + 
			"txc inc 453 if yg > -930\n" + 
			"u dec -871 if a < 2468\n" + 
			"x dec -789 if u > -160\n" + 
			"jus dec 702 if f >= 6127\n" + 
			"v inc -298 if u < -141\n" + 
			"uwm dec 424 if uwm == 775\n" + 
			"cfa dec -497 if pq == 259\n" + 
			"ewg dec 984 if t == -470\n" + 
			"vpd dec -287 if t > -478\n" + 
			"q dec -288 if zo == 2431\n" + 
			"a dec -402 if l < -240\n" + 
			"cfa dec 560 if cfa == -926\n" + 
			"u inc -127 if jus == 1790\n" + 
			"yg dec -832 if yg > -930\n" + 
			"uwm inc 366 if hnd < -2128\n" + 
			"tl dec 18 if l > -252\n" + 
			"vby dec -423 if vpd < 1239\n" + 
			"u dec -879 if ewg == 2780\n" + 
			"uwm inc 204 if uwm >= 711\n" + 
			"l inc 545 if ewg > 2794\n" + 
			"t dec 383 if uwm == 921\n" + 
			"t inc 464 if vby != 1054\n" + 
			"jus inc -997 if vby < 1060\n" + 
			"u inc 347 if uwm <= 926\n" + 
			"v inc 468 if tl >= -3372\n" + 
			"v dec 797 if v <= 6626\n" + 
			"u inc 971 if l >= -252\n" + 
			"ewg dec -319 if vpd < 1239\n" + 
			"hnd dec 893 if x < -913\n" + 
			"tl inc -593 if txc <= 2148\n" + 
			"qcg inc 382 if q >= 193\n" + 
			"pq dec -987 if tl >= -3951\n" + 
			"yg inc -111 if jus == 793\n" + 
			"tl dec -780 if uwm != 919\n" + 
			"pq inc -914 if tl < -3176\n" + 
			"t dec 677 if jus >= 789\n" + 
			"ewg dec -842 if cfa <= -944\n" + 
			"uwm inc 736 if pq >= -648\n" + 
			"ewg inc 106 if jus > 784\n" + 
			"f dec -472 if jus != 785\n" + 
			"e inc 382 if qos != -549\n" + 
			"vpd inc 955 if yg < -197\n" + 
			"txc dec -976 if pq == -660\n" + 
			"a inc 453 if x != -908\n" + 
			"q inc 287 if t >= -1072\n" + 
			"uwm inc 422 if l > -255\n" + 
			"hnd dec -230 if qcg <= -2580\n" + 
			"v dec 868 if ewg == 3212\n" + 
			"x dec -567 if l < -238\n" + 
			"tl dec 595 if jus != 788\n" + 
			"u dec -860 if pq != -662\n" + 
			"e inc -541 if cfa >= -940\n" + 
			"f dec 330 if vby < 1059\n" + 
			"tl dec -41 if qcg == -2583\n" + 
			"f inc -394 if u != 1899\n" + 
			"a dec -962 if x < -353\n" + 
			"a dec 303 if vpd != 2189\n" + 
			"u inc -371 if q < 493\n" + 
			"yg inc 0 if tl < -3734\n" + 
			"hnd dec -273 if e >= 311\n" + 
			"t dec -138 if qcg > -2588\n" + 
			"e dec 644 if f == 5877\n" + 
			"qcg dec 968 if yg < -202\n" + 
			"x dec 208 if tl <= -3730\n" + 
			"u dec -776 if txc < 2153\n" + 
			"q inc -432 if vpd == 2189\n" + 
			"cfa dec -325 if uwm != 1344\n" + 
			"e dec -384 if zo >= 2429\n" + 
			"ss dec -879 if a < 3332\n" + 
			"u inc -571 if t != -925\n" + 
			"t dec 970 if l >= -244\n" + 
			"ewg dec 713 if uwm > 1333\n" + 
			"a dec 527 if uwm < 1348\n" + 
			"f inc -962 if u == 1737\n" + 
			"cfa dec -790 if e < 704\n" + 
			"cfa inc 516 if yg > -210\n" + 
			"uwm dec 654 if zo == 2428\n" + 
			"qcg inc -176 if ewg != 2507\n" + 
			"u inc -92 if e >= 696\n" + 
			"a inc -14 if yg == -204\n" + 
			"vby inc -72 if v < 4956\n" + 
			"a dec -983 if q <= 62\n" + 
			"yg inc 422 if cfa > 696\n" + 
			"jus inc 685 if t > -938\n" + 
			"e inc 449 if jus < 1483\n" + 
			"v dec 593 if t >= -932\n" + 
			"v dec 595 if q >= 55\n" + 
			"e inc 332 if e <= 1154\n" + 
			"tl dec -34 if ewg == 2499\n" + 
			"ewg inc 24 if f < 5872\n" + 
			"ewg dec -129 if txc == 2146\n" + 
			"pq dec 815 if hnd != -2531\n" + 
			"tl inc 456 if a == 3764\n" + 
			"tl dec 942 if a <= 3773\n" + 
			"x inc 610 if x >= -558\n" + 
			"u inc -68 if txc < 2150\n" + 
			"ewg dec -897 if jus == 1474\n" + 
			"vpd inc -158 if jus != 1475\n" + 
			"e inc 852 if v != 3775\n" + 
			"pq inc 169 if zo >= 2427\n" + 
			"zo dec -82 if v >= 3765\n" + 
			"qcg inc 221 if u < 1584\n" + 
			"ss dec 958 if tl > -4640\n" + 
			"a inc -545 if f >= 5868\n" + 
			"ss dec -864 if qcg != -3515\n" + 
			"t inc 980 if cfa < 698\n" + 
			"zo dec 58 if f > 5867\n" + 
			"q dec 43 if u == 1575\n" + 
			"qos dec -992 if vpd == 2031\n" + 
			"t dec -823 if x >= -564\n" + 
			"x inc 647 if qos != 445\n" + 
			"l inc 231 if l == -246\n" + 
			"ewg inc -776 if zo < 2464\n" + 
			"q dec 367 if q > 13\n" + 
			"jus dec 956 if v != 3770\n" + 
			"txc dec 952 if v != 3766\n" + 
			"x inc 145 if qcg >= -3507\n" + 
			"e dec 597 if x <= 236\n" + 
			"cfa inc -860 if f <= 5878\n" + 
			"f inc -649 if jus != 512\n" + 
			"tl inc -885 if f != 5227\n" + 
			"qcg inc -610 if q == -353\n" + 
			"ewg dec 342 if txc <= 2137\n" + 
			"hnd dec 495 if yg >= -207\n" + 
			"vby dec -713 if q < -345\n" + 
			"ewg dec 72 if cfa > -174\n" + 
			"jus inc 897 if zo == 2455\n" + 
			"v dec -582 if zo > 2452\n" + 
			"x dec 368 if f >= 5212\n"
	};
}
