#include <iostream>
#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

char str[200][30];

int val(int k) {
	int len = strlen(str[k]);
	int bo[26];
	memset(bo, 0, sizeof(bo));
	for (int i = 0; i < len; ++i)
		if (isupper(str[k][i])) bo[str[k][i] - 'A'] = 1;
	int ans = 0;
	for (int i = 0; i < 26; ++i)
		ans += bo[i];
	return ans;
}

int main() {
	freopen("a.txt", "r", stdin);
	freopen("out.txt", "w", stdout);
	int T;
	scanf("%d", &T);
	//cout << T << endl;
	while (T--) {
		int n;
		scanf("%d", &n);
		gets(str[0]);
		for (int i = 1; i <= n; ++i) {
			gets(str[i]);
		}
		int k = 1;
		for (int i = 2; i <= n; ++i) {
			int z1 = val(k), z2 = val(i);
			if (z1 < z2 || (z1 == z2 && strcmp(str[i], str[k]) < 0)) k = i;
		}
		static int ca = 0;
		printf("Case #%d: %s\n", ++ca, str[k]);
	}
	return 0;
}
