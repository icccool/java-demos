
###日期 2021-10-29

1. 解决无法提交github  
(1) 本地开代理  
(2) 修改git配置文件 .git/config文件增加以下内容  
```
[http]
proxy = socks5://127.0.0.1:7890

[https]
proxy = socks5://127.0.0.1:7890
```