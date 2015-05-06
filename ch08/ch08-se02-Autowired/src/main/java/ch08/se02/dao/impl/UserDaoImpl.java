package ch08.se02.dao.impl;

import org.springframework.stereotype.Repository;

import ch08.se02.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> {

}
