package com.enigmacamp.mandiri.goldmarket.configs;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;
import com.enigmacamp.mandiri.goldmarket.entities.Role;
import com.enigmacamp.mandiri.goldmarket.services.CustomerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final CustomerService customerService;

    public JwtUserDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findByUserName(username);
        List<GrantedAuthority> authorities = getUserAuthority(customer.getRoles());
        return buildUserForAuthentication(customer, authorities);
//        if (customer.getUserName().equals(username)) {
//            return buildUserForAuthentication(customer, authorities);
////            return new User(customer.getUserName(), customer.getPassword(),
////                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Customer customer, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(customer.getUserName(), customer.getPassword(),
                customer.isStatus(), true, true, true, authorities);
    }
}
