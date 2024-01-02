/*
    * Question 2610: Convert an Array Into a 2D Array With Conditions
    * Date: January 02, 2024

    ? You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
    ? * The 2D array should contain only the elements of the array nums.
    ? * Each row in the 2D array contains distinct integers.
    ? * The number of rows in the 2D array should be minimal.
    ? Return the resulting array. If there are multiple answers, return any of them.

    ! Note that the 2D array can have a different number of elements on each row.
*/

#include <bits/stdc++.h>
using namespace std;

// Function to convert Array to 2D array with conditions
vector<vector<int>> findMatrix(vector<int> &nums)
{
    // Frequency of Elements to be stored in num
    map<int, int> freqMap;
    // Counting Frequency
    for (int i = 0; i < nums.size(); i++)
    {
        freqMap[nums[i]]++;
    }

    // Get Max-Freq stored in freqMap
    int maxVal = INT_MIN;
    for (auto pr : freqMap)
    {
        maxVal = max(maxVal, pr.second);
    }

    // 2-D Array Initialization
    vector<vector<int>> resultArr;

    // Pushing Arrays in 2-D Array
    for (int i = 0; i < maxVal; i++)
    {
        vector<int> row;
        for (auto &itr : freqMap)
        {
            if (itr.second > 0)
            {
                row.push_back(itr.first);
                itr.second--;
            }
        }
        resultArr.push_back(row);
    }

    return resultArr;
}

// Driver Code
int main()
{
    // Number Array
    vector<int> nums;
    int temp;
    while (cin >> temp)
    {
        nums.push_back(temp);
    }

    // Result Array
    vector<vector<int>> resultArr = findMatrix(nums);

    // Displaying Result Array
    for (auto itr : resultArr)
    {
        for (auto itr1 : itr)
        {
            cout << itr1 << " ";
        }
        cout << endl;
    }

    return 0;
}