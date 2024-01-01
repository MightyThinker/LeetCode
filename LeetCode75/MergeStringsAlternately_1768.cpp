/* 
 * Question 1768: Merging Strings Alternately

 ? You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 ? If a string is longer than the other, append the additional letters onto the end of the merged string.
 ? Return the merged string.

 */


#include <iostream>
#include <cstring>
using namespace std;

// Function to merge strings alternately
string mergedAlternately(string word1, string word2){
    // Value to be returned
    string mergedWord;

    // Smaller Sized from both strings
    int smaller_size = (word1.size()>word2.size() ? word2.size() : word1.size());

    // Push Alternately
    for(int i = 0;i < smaller_size;i++){
        mergedWord.push_back(word1[i]);
        mergedWord.push_back(word2[i]);
    }

    // If any characters left
    if(word1.size() > smaller_size){
        mergedWord += word1.substr(smaller_size);
    }else if(word2.size() > smaller_size){
        mergedWord += word2.substr(smaller_size);
    }

    // Return merged string
    return mergedWord;
}

int main()
{
    // Two Strings
    string word1;
    string word2;

    // Input
    cout<<"Enter Word 1: ";
    cin>>word1;
    cout<<"Enter Word 2: ";
    cin>>word2;

    // Merging Alternately
    string mergedWord = mergedAlternately(word1, word2);

    // Output
    cout<<"Merged Word: "<<mergedWord<<endl;

    return 0;
}