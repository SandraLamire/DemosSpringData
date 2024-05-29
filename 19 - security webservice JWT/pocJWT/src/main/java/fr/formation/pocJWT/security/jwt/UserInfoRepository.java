package fr.formation.pocJWT.security.jwt;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
}
