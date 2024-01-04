/*
    * Question 2870 : Minimum Number of Operations to Make Array Empty
    * Date : January 04, 2024

    ? You are given a 0-indexed array nums consisting of positive integers.

    ? There are two types of operations that you can apply on the array any number of times:
    ? * Choose two elements with equal values and delete them from the array.
    ? * Choose three elements with equal values and delete them from the array.

    ? Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
*/

#include <bits/stdc++.h>
using namespace std;

int minOperations(vector<int> &nums)
{
    map<int, int> freq;
    // Frequency Array to count occurence of elements
    for (int i = 0; i < nums.size(); i++)
    {
        freq[nums[i]]++;
    }

    int oprCount = 0;
    int tempRem;
    for (auto itr : freq)
    {
        if (itr.second == 1)
        {
            return -1;
        }
        else
        {
            if (itr.second % 3 == 0) // Fully divisible
            {
                oprCount += itr.second / 3;
            }
            else if (itr.second % 3 == 1)  // Remainder 1 i.e., 4,7,10,13,16,19
            {
                oprCount = oprCount + (itr.second / 3) - 1 + ((itr.second % 3 + 3) / 2);
            }
            else // Reamainder 2 i.e., 5,8,11,14,17,20
            {
                oprCount = oprCount + (itr.second / 3) + ((itr.second % 3) / 2);
            }
        }
    }
    return oprCount;
}

// Driver Code
int main(int argc, char const *argv[])
{
    vector<int> nums;
    int inp;
    while(cin>>inp){
        nums.push_back(inp);
    }
    cout<<minOperations(nums)<<endl;
    return 0;
}
