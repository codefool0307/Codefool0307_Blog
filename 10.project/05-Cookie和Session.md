<!--
 * @Author: 孙浩然
 * @Date: 2020-05-18 20:09:36
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-05-18 21:07:52
 * @FilePath: \docs\10.project\05-Cookie和Session.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 
# 5. Cookie和Session
## 5.1 Cookie和Session的概述

可以理解为Cookie是一个银行卡，Session是一个账户，

比如说看一个例子：


## 5.2 导航条升级
那么根据这个这个例子，我就想实现一个功能了：

1. 登陆成功，只显示“我”
2. 没有登录，只显示“登录”

同时我不想在网站显示那么一大串符号，看起来好麻烦呀。

登录成功或者失败的时候，进行展示

```java
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientid;
    @Value("${github.client.secret}")
    private String clientsecret;
    @Value("${github.client.uri}")
    private String redirecturi;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(clientsecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirecturi);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GihubUser user = githubProvider.getUser(accessToken);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else{
            return "redirect:/";
        }

    }
}
```
```java
<html xmlns:th="http://www.thymeleaf.org">

<ul class="nav navbar-nav navbar-right">
                <li th:if="${ session.user == null }">
                    <a href="https://github.com/login/oauth/authorize?client_id=Iv1.2bc3b748c47800d6&redirect_uri=http://localhost:9997/callback&scope=user&state=1">登录</a></li>
                <li class="dropdown" th:if="${ session.user !=null}">
                    <a href="#" class="dropdown-toggle"
                       data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">
                        我<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">消息中心</a></li>
                        <li><a href="#">个人资料</a></li>
                        <li><a href="#">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
```

但是，为什么要这样做呢？原因之后解释。