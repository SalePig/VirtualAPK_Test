# VirtualAPK_Test

《Android 插件化框架VirtualAPK ：（一）基本集成》

滴滴VirtualAPK github : didi/VirtualAPK

一.环境搭建 
gradle-wrapper.properties
distributionUrl=https\://services.gradle.org/distributions/gradle-2.14.1-all.zip

工程根目录 build.gradle
dependencies {
    classpath 'com.android.tools.build:gradle:2.1.3'
    classpath 'com.didi.virtualapk:gradle:0.9.0'
}
Host Project build.gradle
apply plugin: 'com.didi.virtualapk.host'
dependencies {
    	compile 'com.didi.virtualapk:core:0.9.0'
}

Plugin Project build.gradle
dependencies {
    compile 'com.didi.virtualapk:core:0.9.0'
}
apply plugin: 'com.didi.virtualapk.plugin'
virtualApk {
    packageId = 0x6f // the package id of Resources.
    targetHost = '../VirtualAPK-master/app' // the path of application module in host project.
    applyHostMapping = true //optional, default value: true.
}

packageId 用于定义每个插件的资源id，多个插件间的资源Id前缀要不同，避免资源合并时产生冲突
targetHost 指明宿主工程的应用模块，插件编译时需要获取宿主的一些信息，比如mapping文件、依赖的SDK版本信息、R资源文件，一定不能填错，否则在编译插件时会提示找不到宿主工程。
applyHostMapping 表示插件是否开启apply mapping功能。当宿主开启混淆时，一般情况下插件就要开启applyHostMapping功能。因为宿主混淆后函数名可能有fun()变为a()，插件使用宿主混淆后的	mapping映射来编译插件包，这样插件调用fun()时实际调用的是a()，才能找到正确的函数调用。				   


在这之前，请确保Gradle和adb命令都在环境变量中。
构建环境建议：
Gradle                   2.14.1
com.android.tools.build  2.1.3

首先，连接手机并编译宿主工程
cd VirtualAPK
./gradlew clean iR

然后构建插件并将插件推送到手机sd卡的根目录
cd PluginDemo
./gradlew clean assemblePlugin
adb push app/build/outputs/apk/app-beijing-release-unsigned.apk /sdcard/Test.apk
adb push C:\Users\Administrator\Desktop\Plugin_Test.apk  /storage/emulated/0/Plugin_Test.apk

当然，为了方便，也可以直接执行./make.sh来完成这整个过程。

环境搭建遇到的问题
1.gradle 配置错误  全部按上面的配置 依然 报gradle错误
决绝办法 下载 gradle-2.14.1 放到.gradle中 

2.targetHost  配置错误  
如果是同一工程 ../    目录名称一定要对

3.官方demo 宿主app中有个坑
intent.setClassName("插件app报名", "com.didi.virtualapk.demo.aidl.BookManagerActivity");
4.新建插件app


解决方式：插件中至少包含一个资源文件。  

drawable 目录下必须有个文件

4.加载插件 SDCard  6.0 需开启读写文件权限
5.插件app中资源文件 不要与 宿主 同名 不然会被覆盖掉 （layou）

二.深入学习
1.实现原理
2.插件与宿主的通讯
要想清楚宿主和插件的业务边界很重要，才能找到插件的入口点。Demo中是以ImageBrowserActivity为边界，从这个Activity之后的功能来来自于插件中。其实我们可以把插件看成一个类提供者，可以使用Class.forName()这种方式使用插件中的类，所以不是只能从Activity/Fragment作为入口点。 ？？？？？
基本上无差别  只是将公用的资源 方法 另建库 分别依赖即可
SharedPreferences
intent
sqlit

3.插件与插件的通讯
4.不支持与强制约束
5.兼容性
三.主流插件化框架了解
1.主流n种插件有哪些？
2.插件兼容性对比 （为何选择VirtualAPK 有何优势）
3.了解插件化实现原理
四.需求划分->插件化原则



