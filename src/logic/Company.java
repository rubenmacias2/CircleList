package logic;

import java.util.Comparator;

public class Company {
    private String id;
    private String name;
    private int income;

    public Company(String id, String name, int income) {
        this.id = id;
        this.name = name;
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public static Comparator<Company> compId = new Comparator<Company>() {
        @Override
        public int compare(Company o1, Company o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };
    public static Comparator<Company> comName = new Comparator<Company>() {
        @Override
        public int compare(Company o1, Company o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Company> compIncome = new Comparator<Company>(){

        @Override
        public int compare(Company o1, Company o2) {
            return (int) (o1.getIncome() - o2.getIncome());
        }
    };

    @Override
    public String toString() {
        return "logic.Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", income=" + income +
                '}';
    }
}
