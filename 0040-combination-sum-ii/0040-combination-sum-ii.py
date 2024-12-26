class Solution:
    def combinationSum2(self, candidates, target):
        result = []
        candidates.sort()  
        self.backtrack(candidates, target, 0, [], result)
        return result

    def backtrack(self, candidates, target, start, current, result):
        if target == 0:
            result.append(list(current))  
            return
        if target < 0:
            return  
        
        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i - 1]:
                continue  # Skip duplicates
            current.append(candidates[i])  
            self.backtrack(candidates, target - candidates[i], i + 1, current, result) 
            current.pop() 
