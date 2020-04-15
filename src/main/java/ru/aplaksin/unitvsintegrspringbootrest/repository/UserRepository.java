package ru.aplaksin.unitvsintegrspringbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aplaksin.unitvsintegrspringbootrest.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
