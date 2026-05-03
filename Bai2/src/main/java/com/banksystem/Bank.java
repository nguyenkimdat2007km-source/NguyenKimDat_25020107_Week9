package com.banksystem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);

    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    public void readCustomerList(InputStream inputStream) {
        logger.debug("Bat dau doc du lieu khach hang...");
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            Customer current = null;
            try {
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        int last = line.lastIndexOf(' ');
                        if (last > 0) {
                            String token = line.substring(last + 1).trim();
                            if (token.matches("\\d{9}")) {
                                String name = line.substring(0, last).trim();
                                current = new Customer(Long.parseLong(token), name);
                                customerList.add(current);
                                logger.info("Them khach hang: {}", name);
                            } else {
                                if (current != null) {
                                    String[] parts = line.split("\\s+");
                                    if (parts.length >= 3) {
                                        long num = Long.parseLong(parts[0]);
                                        double bal = Double.parseDouble(parts[2]);
                                        if ("CHECKING".equals(parts[1])) {
                                            current.addAccount(new CheckingAccount(num, bal));
                                        } else if ("SAVINGS".equals(parts[1])) {
                                            current.addAccount(new SavingsAccount(num, bal));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Loi khi doc du lieu: {}", e.getMessage());
            }
        }
    }

    public String getCustomersInfoByIdOrder() {
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return Long.compare(o1.getIdNumber(), o2.getIdNumber());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            sb.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String getCustomersInfoByNameOrder() {
        List<Customer> copy = new ArrayList<>(customerList);
        Collections.sort(copy, (c1, c2) -> {
            int res = c1.getFullName().compareTo(c2.getFullName());
            return res != 0 ? res : Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        StringBuilder sb = new StringBuilder();
        for (Customer c : copy) {
            sb.append(c.getCustomerInfo()).append("\n");
        }
        return sb.toString().trim();
    }
}