####  增加解码器解决半包问题

channel.pipeline().addLast(new LineBasedFrameDecoder(1024));  
channel.pipeline().addLast(new StringDecoder());
