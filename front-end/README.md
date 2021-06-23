# XLearn

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```


1. 静态资源文件需要放在public文件夹，如img/css/icon/json等
2. 可以使用混入mixin，将axios变成vue实例的一部分，方便各组件调用请求
3. 为避免main.js文件复杂，可将路由配置提取到router/index.js中
4. 为避免所有组件打包到app.js导致文件过大，首屏加载缓慢，可以使用路由懒加载来分别打包成多个文件，可以使用注释分组打包
```
            component: () => import(/* webpackChunkName:"Home" */ '@/page/Home')
```
5. 路由中可以使用meta保存元数据信息，如title,是否需要登录等
6. 导航：路由发生改变，页面跳转
7. 导航守卫：拦截器
```
//导航守卫 路由跳转之前会被此拦截
// to 跳转到的页面 from 源页面 next 调用该方法后才跳转
router.beforeEach((to, from, next) => { 
    //设置标题、判断登录操作等操作 
    next()
})

router.afterEach(() => {
})
```
8. axios请求方法
```
axios.get({url,
    params:{
        id:1
    }
})

axios.post({
    id:1
})

//同时发起多个请求
axios.all

axios({
    method:'post',
    url:'/user/12345',
    data:{
        id:1
    }
})
```



## Brief

```
运行方式：
1. 把 Xlearn.zip 压缩包下载到自己的电脑上。
2. 在自己的电脑上提前安装好node.js、npm等。
3. 解压 Xlearn.zip 压缩包，打开它，在根目录下依次运行以下npm命令：
· npm install
· npm run serve
注意：npm使用的是国外的服务器，在国内运行npm命令可能会比较慢。取而代之的有cnpm，功能与npm一样，用的是国内的服务器，因此速度会快一些。
· npm install 意思是安装能够支持项目运行的环境依赖，如果无法成功install，按着系统报错提示去做就行，最后都能install成功的。
· npm run serve 意思是启动服务，让项目在你的电脑上跑起来，成功后会给你两个网址，复制任意一个网址到浏览器上就能看到项目编译后在前台的展示效果啦。
4. 如果所有代码都改好了，想要打包，运行以下npm命令即可：
· npm run build
这样就会生成一个干干净净的成品，可以拿给企业用，也可以部署到前端服务器上。
```

