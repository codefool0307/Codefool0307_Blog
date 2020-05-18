<!--
 * @Author: 孙浩然
 * @Date: 2020-05-18 09:19:17
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-05-18 09:57:54
 * @FilePath: \docs\10.project\01.Project01\03-Github登录.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 
<!--
 * @Author: 孙浩然
 * @Date: 2020-05-18 09:19:17
 * @LastEditors: 孙浩然
 * @LastEditTime: 2020-05-18 09:19:18
 * @FilePath: \docs\10.project\01.Project01\03-Github登录.md
 * @博客地址: 个人博客，如果各位客官觉得不错，请点个赞，谢谢。[地址](https://codefool0307.github.io/JavaScholar/#/)
--> 

GitHub登录

最下面有一个api
找到一个GitHub APP和一个授权app
然后找到一个building outh app一步一步来

找到settings-developer看手机图片

4-5张可能

登录流程：

用户发送请求，社区会点击登录（）自己的
之后调用GitHub，调用了一个授权地址
GitHub验证完成之后，会回调url地址并携带code
社区解析一下url地址，解析结束之后，会有一个access和code
再次调用GitHub，如果是正确的胡，就睡返回access——token，使用gaccess的调用GitHub的user的api
获取真实用户信息：user携带token去GitHub，如果正确，会返回给社区一个user信息
最后一步，社区就会把信息存入数据库，更新登录状态。
最后返回到用户，表示登录成功

去index找到啊登录标签，a hrefclientid和redirecturi还有一个scope还有一个state=1随便的写

启动服务运行一下试试呗

由于没有编辑地址，会显示error page
获取code吧

在Controller中新创建一个AuthorizeCOntroller
初始页面一致
参数接受，两个参数用post，嗲用access接口，java模拟post请求，经常会使用http的client

本节使用okhttp，

手机图

copy到我们的项目中，创建了一个provider包，叫GitHubprovider的文件

不需要实例化对象，ioc功能，
GitHub文档要求五个对象，那么创建一个dto-accesstokendto来进行封装
因为比较多，所以我们使用dto

之后再provider文件中，放置okhttp，不需要那个string那一部分

将类转换为json，用mvnresopr，反应比较慢，方拾二：
command+n找fastjason，
点击相对应版本粘贴进来，

再次进入provider，uil问题，拷贝GitHub的uil进来就好了，

GitHub封装好了，但是没有调用他，去authcontroleer嗲用

使用自动注入注解进行注入，

手机图

拿到accesstoken调用挨批，来获取user的信息

去GitHub文档，
看3.
回到developer页面就是有id页面去personal access tokens 中gerate new token
然后点击user写一下community，用来验证是否可以回来数据
然后打开一个无痕模式，用api.github.io+上面这个东西，试试能不能获取
这样3.   就可以了


provider中创建一个新方法id，那么，bio
在dto创建爱你githubuser封装
之后再OKhttp的个体中，进行copy

url就是api。。。。。。的

惦记登录你看网址和蓝有变化
对这个进行拆分，以$拆分

运行，看看能不能出现东西


配置文件分离

appli的peoperties文件，吧authcontoller的一些放进来


手机图

运行


看一下session和cookies

cookie银行卡，session银行账户，domain是哪个银行，exp是过期时间

登录之后，我显示小区登录会去掉，

autho文件

写入user不为空判断


去index中，修改登录，看一下thymeleaf判断session取值，百度一下
indexde htmml的xmlns：th换一下
在li中写一个属性 th:if

运行一下

手机图

变更一下，
但是不能持久化，之后会用数据库




之后引入jar包就是maven，                                           

引用第三方工具，





快捷键alt+鼠标左键下拉即可






