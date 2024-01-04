/*
    * Question 2125: Number of Laser Beams in a Bank
    * Date : January 03, 2024
    ? Anti-theft security devices are activated inside a bank.
    ? You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix.
    ? bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

    ? There is one laser beam between any two security devices if both conditions are met:
    ? * The two devices are located on two different rows: r1 and r2, where r1 < r2.
    ? * For each row i where r1 < i < r2, there are no security devices in the ith row.
    ? Laser beams are independent, i.e., one beam does not interfere nor join with another.
    
    ? Return the total number of laser beams in the bank.
*/

#include <bits/stdc++.h>
using namespace std;

// Function to find Number of Laser Beams in a Bank
int numberOfBeams(vector<string> &bank)
{
    int rows = bank.size();          // total rows in bank
    vector<int> secDevices(rows, 0); // number of security devices in each row

    // Calculate the number of security devices in each row
    for (int r = 0; r < rows; r++)
    {
        for (char c : bank[r])
        {
            if (c == '1')
            {
                secDevices[r]++;
            }
        }
    }

    int laserCount = 0;
    // Calculate the number of laser beams
    for (int r1 = 0; r1 < rows - 1; r1++)
    {
        if (secDevices[r1] > 0)
        {
            for (int r2 = r1 + 1; r2 < rows; r2++)
            {
                if (secDevices[r2] > 0)
                {
                    laserCount += secDevices[r1] * secDevices[r2];
                    break;
                }
            }
        }
    }

    return laserCount;
}

// Driver Code
int main()
{
    vector<string> bank;
    string inp;
    while(cin>>inp){
        bank.push_back(inp);
    }
    cout<<numberOfBeams(bank)<<endl;
    return 0;
}
