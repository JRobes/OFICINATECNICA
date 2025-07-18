package com.coterena.oficinatecnica.security;

import com.coterena.oficinatecnica.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //IMPORTANTE YA QUE SE VAN A HACER LLAMADAS A LA VBASE DE DATOS
@AllArgsConstructor
public class CustomerUserDetails implements UserDetailsService {

   private final CustomerRepository customerRepository;

    //En teoria, poniendo en la clase @AllArgsConstructor debería no se necesario poner el constructor
    //Pero algo no funiona en la configuracion de Lombok. Entonces sale el error en
    //CustomerRepository ya que esta marcado como final
    //public CustomerUserDetails(CustomerRepository customerRepository) {
    //    this.customerRepository = customerRepository;
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerRepository.findByEmail(username)
                .map(customer -> {
                    var authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
                    return new User(customer.getEmail(), customer.getPassword(), authorities);
                }).orElseThrow(() -> new UsernameNotFoundException("User noooolll found"));
    }
}
