//Implement a banking system using java. Create 3 sub class of Bank : SBI, BOI, ICICI
    //Classes should have attributes like Name, headofficeAddress, chairmanName, branchCount, fdInterestRate, personalLoanInterestRate, homeLoanInterestRate. All 3 should have following methods:
    //1. add getters and setters for the fields
    //2. print details of every bank (override toString)

class Question6{
    public static void main(String[] args) {
        SBI sbi1 = new SBI();
        BOI boi1 = new BOI();
        ICICI icici1 = new ICICI();

        System.out.println(sbi1.toString());
        System.out.println(boi1.toString());
        System.out.println(icici1.toString());

        SBI sbi2 = new SBI("SBI Custom", "Mumbai, India", "Dhruv", 9000, 5.8, 10.8, 7.8);
        BOI boi2 = new BOI("BOI Custom", "Chennai, India", "Ramesh", 1300, 6.2, 11.2, 8.2);
        ICICI icici2 = new ICICI("ICICI Custom", "Bangalore, India", "Amit", 6000, 6.8, 12.2, 8.8);

        System.out.println(sbi2.toString());
        System.out.println(boi2.toString());
        System.out.println(icici2.toString());

        sbi2.setName("SBI Modified");
        System.out.println("Modified SBI Name: " + sbi2.getName());
        sbi2.setHeadOfficeAddress("Pune, India");
        System.out.println("Modified SBI Head Office Address: " + sbi2.getHeadOfficeAddress());
        sbi2.setChairmanName("Vikram");
        System.out.println("Modified SBI Chairman Name: " + sbi2.getChairmanName());
        sbi2.setBranchCount(9500);
        System.out.println("Modified SBI Branch Count: " + sbi2.getBranchCount());
        sbi2.setFdInterestRate(6.0);
        System.out.println("Modified SBI FD Interest Rate: " + sbi2.getFdInterestRate());
        sbi2.setPersonalLoanInterestRate(11.0);
        System.out.println("Modified SBI Personal Loan Interest Rate: " + sbi2.getPersonalLoanInterestRate());
        sbi2.setHomeLoanInterestRate(8.0);
        System.out.println("Modified SBI Home Loan Interest Rate: " + sbi2.getHomeLoanInterestRate());
        
    }
}
class Bank {
    String name;
    String headOfficeAddress;
    String chairmanName;
    int branchCount;
    double fdInterestRate;
    double personalLoanInterestRate;
    double homeLoanInterestRate;

    // Getters
    public String getName() {
        return name;
    }
    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }
    public String getChairmanName() {
        return chairmanName;
    }
    public int getBranchCount() {
        return branchCount;
    }
    public double getFdInterestRate() {
        return fdInterestRate;
    }
    public double getPersonalLoanInterestRate() {
        return personalLoanInterestRate;
    }
    public double getHomeLoanInterestRate() {
        return homeLoanInterestRate;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHeadOfficeAddress(String headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress;
    }
    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }
    public void setBranchCount(int branchCount) {
        this.branchCount = branchCount;
    }
    public void setFdInterestRate(double fdInterestRate) {
        this.fdInterestRate = fdInterestRate;
    }
    public void setPersonalLoanInterestRate(double personalLoanInterestRate) {
        this.personalLoanInterestRate = personalLoanInterestRate;
    }
    public void setHomeLoanInterestRate(double homeLoanInterestRate) {
        this.homeLoanInterestRate = homeLoanInterestRate;
    }
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", headOfficeAddress='" + headOfficeAddress + '\'' +
                ", chairmanName='" + chairmanName + '\'' +
                ", branchCount=" + branchCount +
                ", fdInterestRate=" + fdInterestRate +
                ", personalLoanInterestRate=" + personalLoanInterestRate +
                ", homeLoanInterestRate=" + homeLoanInterestRate +
                '}';
    }
}
class SBI extends Bank {
    SBI() {
        setName("State Bank of India");
        setHeadOfficeAddress("Nainital, India");
        setChairmanName("Saurabh Singh");
        setBranchCount(8875);
        setFdInterestRate(5.5);
        setPersonalLoanInterestRate(10.5);
        setHomeLoanInterestRate(7.5);
    }
    SBI(String name, String headOfficeAddress, String chairmanName, int branchCount, double fdInterestRate, double personalLoanInterestRate, double homeLoanInterestRate) {
        setName(name);
        setHeadOfficeAddress(headOfficeAddress);
        setChairmanName(chairmanName);
        setBranchCount(branchCount);
        setFdInterestRate(fdInterestRate);
        setPersonalLoanInterestRate(personalLoanInterestRate);
        setHomeLoanInterestRate(homeLoanInterestRate);
    }
}
class BOI extends Bank {
    BOI() {
        setName("Bank of India");
        setHeadOfficeAddress("Delhi, India");
        setChairmanName("Babulal");
        setBranchCount(1212);
        setFdInterestRate(6.0);
        setPersonalLoanInterestRate(11.0);
        setHomeLoanInterestRate(8.0);
    }
    BOI(String name, String headOfficeAddress, String chairmanName, int branchCount, double fdInterestRate, double personalLoanInterestRate, double homeLoanInterestRate) {
        setName(name);
        setHeadOfficeAddress(headOfficeAddress);
        setChairmanName(chairmanName);
        setBranchCount(branchCount);
        setFdInterestRate(fdInterestRate);
        setPersonalLoanInterestRate(personalLoanInterestRate);
        setHomeLoanInterestRate(homeLoanInterestRate);
    }
}
class ICICI extends Bank {
    ICICI() {
        setName("ICICI Bank");
        setHeadOfficeAddress("Kanpur, India");
        setChairmanName("Padam Awasthi");
        setBranchCount(5432);
        setFdInterestRate(6.5);
        setPersonalLoanInterestRate(12.0);
        setHomeLoanInterestRate(8.5);
    }
    ICICI(String name, String headOfficeAddress, String chairmanName, int branchCount, double fdInterestRate, double personalLoanInterestRate, double homeLoanInterestRate) {
        setName(name);
        setHeadOfficeAddress(headOfficeAddress);
        setChairmanName(chairmanName);
        setBranchCount(branchCount);
        setFdInterestRate(fdInterestRate);
        setPersonalLoanInterestRate(personalLoanInterestRate);
        setHomeLoanInterestRate(homeLoanInterestRate);
    }
}