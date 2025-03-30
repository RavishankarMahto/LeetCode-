const readline = require("readline");

function countAndSay(n) {
    if (n === 1) return "1"; // Base case

    // Get the previous term recursively
    const prev = countAndSay(n - 1);
    let result = "";
    let count = 1;

    // Generate the nth term using Run-Length Encoding (RLE)
    for (let i = 1; i < prev.length; i++) {
        if (prev[i] === prev[i - 1]) {
            count++; // Increment the count for the same character
        } else {
            // Append the count and the character to the result
            result += count + prev[i - 1];
            count = 1; // Reset the count
        }
    }

    // Append the last character and its count
    result += count + prev[prev.length - 1];
    return result;
}

// Input and output logic using readline
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.question("Enter n: ", (input) => {
    const n = parseInt(input, 10);
    if (isNaN(n) || n < 1 || n > 30) {
        console.log("Please enter a valid number between 1 and 30.");
    } else {
        console.log(`Count-and-Say Sequence at n = ${n}: ${countAndSay(n)}`);
    }
    rl.close();
});
