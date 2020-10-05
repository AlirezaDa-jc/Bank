package ir.maktab.Menu;


import ir.maktab.FactoryMethod.Menu;
import ir.maktab.FactoryMethod.MenuImpl;
import ir.maktab.MainApp;
import ir.maktab.Scan;
import ir.maktab.services.*;

public class EmployeeMenu extends MenuImpl implements Menu {
    private Scan sc;

    public EmployeeMenu() {
        sc = MainApp.getSc();
    }
    @Override
    public void display() {
        System.out.println("To Display All Accounts Press 1");
        System.out.println("To Delete Any Account Press 2");
        System.out.println("To Add Branch Press 3");
        System.out.println("To Remove Suspension Of Customers' Account Press 4");
        System.out.println("To Add Employee To A Branch Press 5");
    }

    @Override
    public void menuHandler() {
        boolean flag = true;
        while (flag) {
            display();
            setOption(sc);
            int option = getOption();
            switch (option) {
                case 1:
                    AccountService.displayAll();
                    break;
                case 2:
                    AccountService.deleteAccountAdmin();
                    break;
                case 3:
                    BranchService.add();
                    break;
                case 4:
                    CustomerService.updateSuspension();
                    break;
                case 5:
                    EmployeeService.insert();
                    break;
                case 11:
                    flag = false;
            }
        }
    }

    @Override
    public boolean checkChoice() {
        return false;
    }

    public void setOption(Scan sc){
        while(true) {
            try {
                option = Integer.parseInt(sc.getString("Enter a Number: "));
                super.setOption(option);
                break;
            } catch (NumberFormatException e) {
                e.getMessage();
            }
        }
    }

    public int getOption(){
        return super.getOption();
    }


}