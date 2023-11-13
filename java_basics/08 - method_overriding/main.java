class Bank {
    double getInterestRate() {
        return 0.0;
    }
}

class SVB extends main {
    double getInterestRate() {
        return 5.5;
    }
}

class FED extends main {
    double getInterestRate() {
        return 6.0;
    }
}

public class main {
    public static void main(String args[]) {
        FED F = new FED();
        SVB S = new SVB();

        System.out.println(F.getInterestRate());
        System.out.println(S.getInterestRate());
    }
}