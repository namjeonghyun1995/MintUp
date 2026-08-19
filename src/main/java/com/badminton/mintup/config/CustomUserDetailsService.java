package com.badminton.mintup.config;

import com.badminton.mintup.dao.AuthDao;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthDao authDao;

    @Override
    public UserDetails loadUserByUsername(String userId)throws UsernameNotFoundException {
        UserInfoVo user = authDao.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return new CustomUserDetails(user);
    }
}
