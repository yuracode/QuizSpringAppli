package com.example.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
public class SecurityConfig {
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password("$2a$10$37pvt9phv.DPNF/lFcHIP.MpiBPWh5eokVXX66rWw98.GyrDtCYpi")
            .roles("USER")
            .build();
        
        return new InMemoryUserDetailsManager(user);
    }
    
	// SecurityFilterChainのBean定義
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		//パターン１（とりあえず全部ログインへ）
		http
				.csrf(csrf -> csrf.disable())
				// ★HTTPリクエストに対するセキュリティ設定
				.authorizeHttpRequests(authz -> authz
						// 「/login」へのアクセスは認証を必要としない
						.requestMatchers("/login").permitAll()
						.requestMatchers("/h2-console/**").permitAll()
						// その他のリクエストは認証が必要
						.anyRequest().authenticated())
				// ★フォームベースのログイン設定
				.formLogin(form -> form
						// カスタムログインページのURLを指定
						.loginPage("/login")
						//パターン２　ログイン処理へ					

						// ログイン処理のURLを指定
						.loginProcessingUrl("/authentication")
						// ユーザー名のname属性を指定
						.usernameParameter("usernameInput")
						// パスワードのname属性を指定
						.passwordParameter("passwordInput")
						// ログイン成功時のリダイレクト先を指定
						.defaultSuccessUrl("/")
						// ログイン失敗時のリダイレクト先を指定
						.failureUrl("/login?error"))
				// ★ログアウト設定
				.logout(logout -> logout
						// ログアウトを処理するURLを指定
						.logoutUrl("/logout")
						// ログアウト成功時のリダイレクト先を指定
						.logoutSuccessUrl("/login?logout")
						// ログアウト時にセッションを無効にする
						.invalidateHttpSession(true)
						// ログアウト時にCookieを削除する
						.deleteCookies("JSESSIONID"))
				.headers(headers -> headers
		                .frameOptions(frame -> frame.disable()));

		return http.build();
	}
}
