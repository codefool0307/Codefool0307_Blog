<!--
 * @Author: your name
 * @Date: 2021-03-04 08:21:06
 * @LastEditTime: 2021-03-04 08:21:15
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \docs\7.Andriod\1.Andriodbasic\README.md
-->

可执行文件同目录的url.txt为视频监控界面对应通道加载的url地址，如果文件名为url1.txt表示不启用。
格式说明：
通道1则为1:rtsp://192.168.1.128:554/1，依次类推，如果有多个重复的则取最后一个。

如果是编译安卓版本，建议不要使用源码目录下的android配置，里面写死了目标版本28，建议删除该文件夹并重新在qtcreator的项目页面创建。
（目前android版本正在开发当中，还存在rtsp传输失败问题，请不要打开android版本）

配置文件说明：
Hardware=none  表示解码器名称
Transport=udp  表示通信协议，如果要保证画质可以改成tcp
Callback=true  表示回调读取实时图像 vlc才有
Caching=500    表示缓存时间，值越小越流畅，和本地网络环境有关系 vlc才有
ImageFlag=0    表示图片质量,0-速度优先 1-质量优先 2-均衡 ffmpeg才有
VideoWidth=1280表示USB摄像机的分辨率宽度
VideoHeight=720表示USB摄像机的分辨率高度

公网地址1：rtsp://182.50.115.100:554/hikvision://172.16.10.2:8000:32:1?username=admin&password=jy123456
公网地址2：rtsp://182.50.115.100:554/hikvision://58.23.169.36:8000:3:1?username=admin&password=bjjy.123
大雄兔：rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov

带用户名密码验证的视频流地址格式
rstp://admin:1111@192.168.1.14:554/1/1
卡口摄像机：rtsp://admin:12345&192.168.1.64:554/Streaming/Channels/1?transportmode=unicast

测试数据，64位WIN10+32位qt5.7+32位ffmpeg3+6路1080P主码流+6路子码流
方案：none+none 	CPU：12%  内存：147MB  GPU：0%
方案：dxva2+none 	CPU：3%   内存：360MB  GPU：38%
方案：d3d11va+none 	CPU：2%   内存：277MB  GPU：62%

方案：none+painter 	CPU：30%  内存：147MB  GPU：0%
方案：dxva2+painter 	CPU：30%  内存：360MB  GPU：38%
方案：d3d11va+painter 	CPU：21%  内存：277MB  GPU：62%

方案：none+yuvopengl  	CPU：17%  内存：177MB  GPU：22%
方案：dxva2+yuvopengl	CPU：25%  内存：400MB  GPU：38%
方案：d3d11va+yuvopengl	CPU：18%  内存：330MB  GPU：65%

方案：qsv+nvopengl	CPU：22%  内存：970MB  GPU：40%
方案：dxva2+nvopengl	CPU：20%  内存：380MB  GPU：40%
方案：d3d11va+nvopengl	CPU：15%  内存：320MB  GPU：62%

测试发现，如果采用64位的ffmpeg4，方案d3d11va+nvopengl，CPU占用大概稳定在6%，udp协议比tcp协议占用更低。

支持音视频同步，了播放声音，包括本地视频文件和网络流文件的声音，支持mp3 wav wma等常见格式，可提取音频文件封面等信息