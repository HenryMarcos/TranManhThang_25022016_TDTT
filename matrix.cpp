#include<bits/stdc++.h>

using namespace std;

ifstream input_file;
ofstream output_file;

vector<vector<float>> matrix1(100005);
vector<vector<float>> matrix2(100005);

void open() {
    input_file.open("matrix.INP", ios::in);
    if (input_file.is_open()) {
        output_file.open("matrix.OUT", ios::out);
    }
}

vector<vector<float>> multiplyMatrix(vector<vector<float>> m1, vector<vector<float>> m2) {
    
}

void input() {
    int m, n, p;
    cin >> m >> n;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            float num;
            cin >> num;
            matrix1[i].push_back(num);
        }
    }
    cin >> n >> p;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < p; j++) {
            float num;
            cin >> num;
            matrix2[i].push_back(num);
        }
    }
}

void main() {
    ios::sync_with_stdio();
    cin.tie(0); cout.tie(0);
    open();
    if (input_file.is_open()) {

    }
}