class Factorial {
    
    public int solve(int n) {
        if (n == 1) return 1;
        return solve(n-1) * n;
    }

    public static void main(String args[]) {
        Factorial f = new Factorial();
        int result = f.solve(8);
        
        System.out.println("Result of 8! is " + result);
    }
}
