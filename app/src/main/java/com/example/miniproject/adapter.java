package com.example.miniproject;

import com.example.miniproject.models.Customer;

import java.util.List;

public class adapter {
    private List<Customer> customers;
    private CustomerAdapterCallback listener;

    public void addAll(List<Customer> customers) {
        if (customers != null) {
            if (this.customers != null && !this.customers.isEmpty()) {
                this.customers.clear();
            }
            this.customers = customers;
          //  notifyDataSetChanged();
        }
    }
    public interface CustomerAdapterCallback {
        void onEmployeeClicked(Customer customer);

        void onEmployeeDelete(Customer customer);

        void onEmployeeEdit(Customer customer);
    }
    public adapter(CustomerAdapterCallback listener)  {
        this.listener = listener;
    }
}
