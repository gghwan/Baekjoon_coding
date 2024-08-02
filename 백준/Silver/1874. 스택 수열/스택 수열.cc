#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;
    
    vector<int> input(N);
    for(int i = 0; i < N; ++i) {
        cin >> input[i];
    }
    
    stack<int> stack;
    string result;
    int j = 1;

    for(int i = 0; i < N; ++i) {
        while(j <= input[i]) {
            stack.push(j);
            result += "+\n";
            j++;
        }

        int num = stack.top();
        stack.pop();
        if(num != input[i]) {
            result = "NO";
            break;
        }
        result += "-\n";
    }

    cout << result;
    return 0;
}
