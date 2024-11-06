package com.example.PracticeSpringSecurity.config;

import com.example.PracticeSpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// このクラスはSpringSecurityを使用してWebアプリケーションのセキュリティ設定をカスタマイズするための設定クラス。
@Configuration //このクラスがSpringの設定クラスであることを定義しているアノテーション
@EnableWebSecurity // SpringSecurityを有効化して、Webセキュリティの設定をカスタマイズすることを意味している
public class SecurityConfig {

    // SecurityFilterChainのBean定義＝HTTPリクエストに対するセキュリティ設定をしている
    @Bean
    // SecurityFilterChainはWebリクエストがサーバーに到達する際に一連のセキュリティチェックを行う
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 認証方法をベーシックにしているので、ログインフォームではなくポップアップ
                .httpBasic(Customizer.withDefaults())
                // ★HTTPリクエストに対するセキュリティ設定。
                // authorizeHttpRequestsはどのHTTPリクエストに認証が必要かを定義している
                .authorizeHttpRequests(auth -> auth
                // 「/login」へのアクセスのみ認証を必要としないようにする(誰でもアクセス可能)
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/fuga").hasRole("USER")
                        .requestMatchers("/piyo").hasRole("ADMIN")
                //その他のリクエストは認証を必要とする
                        .anyRequest().authenticated()
//
//                //★フォームベースのログイン設定
//                .formLogin(form -> form
//                // 自作のログインページのURLを指定
//                        .loginPage("/login")
//                        //ログイン処理のURLを指定。デフォルトは「/login」をログイン処理のURLとして使用する
//                                .loginProcessingUrl("/login")
//                        //ユーザー名のname属性を指定
//                                .usernameParameter("account")
//                        //パスワードのname属性を指定
//                                .passwordParameter("password")
//                        //ログイン成功時のリダイレクト先を指定。デフォルトだとログイン前にユーザがアクセスしようとしていたページにリダイレクトする。
//                                .defaultSuccessUrl("/")
//                        //ログイン失敗時のリダイレクト先を指定
//                                .failureUrl("/login?error"))
//
//                //★ログアウト設定
//                .logout(logout -> logout
//                        //ログアウト処理をするURLを指定。デフォルトも「/logout」。
//                        .logoutUrl("/logout")
//                        //ログアウト成功時のリダイレクト先を指定(今回はメッセージを表示させるために?logoutをつけている)
//                        .logoutSuccessUrl("/login?logout")
//                        //ログアウト時にセッションを無効にする。セッションハイジャックを防ぐ。デフォルトでこの設定はされているが明示的に記述
//                        .invalidateHttpSession(true)
//                        //ログアウト時にCookieを削除する。古いセッションが再利用されるのを防ぐ。
//                        .deleteCookies("JSESSIONID")
                );
        // セキュリティ設定を構築し、最終的なSecurityFilterChainオブジェクトを返すために以下の文を使用
        return http.build();
    }

    @Bean //パスワードのハッシュ化をする
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users() {
        return new UserService();
    }
}
