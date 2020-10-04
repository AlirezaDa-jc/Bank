package ir.maktab.services;

import ir.maktab.MainApp;
import ir.maktab.Scan;
import ir.maktab.entities.Customer;
import ir.maktab.entities.Role;
import ir.maktab.repository.Impl.RoleRepositoryImpl;
import ir.maktab.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleService {
    private static Role role = new Role();
    private static RoleRepository repository = new RoleRepositoryImpl();
    private static Scan sc = MainApp.getSc();


    public static Role getRole() {
        return role;
    }

    public static void setRole(Role role) {
        RoleService.role = role;
    }

    public static void checkRole(String roleTitle) {
        try {
            role = repository.findByTitle(roleTitle);
            System.out.println("Welcome " + role.getRoleTitle());
        } catch (NullPointerException ex) {
            System.out.println("Invalid Role Title!");
        }

    }

    public static Set<Customer> displayUsers() {

        Role userRole = null;
        List<Role> roles = repository.findAll();
        for (Role value : roles) {
            if (value.getRoleTitle().equals("USER")) {
                userRole = value;
            }
        }
        Set<Customer> customerSet = new HashSet<>();
        if (userRole != null) {
            customerSet = userRole.getCustomers();
            for (Customer customer : customerSet) {
                System.out.println(customer.getName());
            }
            return customerSet;
        }
        System.out.println("No User Found");

        return customerSet;
    }

    public static void display() {
        repository.display();

    }

    public static void add() {
        String roleTitle = sc.getString("Title For Role: ");
        roleTitle = roleTitle.toUpperCase();
        List<Role> roleList = repository.findAll();
        for (Role value : roleList) {
            if (value.getRoleTitle().equals(roleTitle)) {
                System.out.println("Duplicate Title For Role");
                return;
            }
        }
        Role newRole = new Role();
        newRole.setRoleTitle(roleTitle);
        repository.insert(newRole);
    }

}
