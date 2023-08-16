package com.tamvn.bt1.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.tamvn.bt1.DAO.*;
import com.tamvn.bt1.entities.*;


@Repository
public interface UserRepository extends JpaRepository<TurbineUser, Integer> {
    List<TurbineUser> findAll();
}
