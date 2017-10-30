功能：
	向URL为“http://jwbinfosys.zju.edu.cn/CheckCode.aspx”的网址抓取验证码，存储到本地。

使用方法：
	运行getData类。

参数：
	sleepTime：每两次抓取时间间隔。（时间间隔太小的话，两次抓取的验证码可能一样）。默认设置为1000ms
	savePath：存储本地的文件夹名。默认设置为c:/KnnData
	total：抓取的验证码图片总数量。
	
注意：
	抓取的验证码按jpg格式存储，需要存储成其他格式可以更改第54行代码。