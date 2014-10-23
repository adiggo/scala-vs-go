time = read.table("./result",header=FALSE)

avgtime = rep(0,26)
avgtime[1]=mean(time[1:10,])
for(i in 2:length(avgtime)){
	avgtime[i] = mean(time[-10+(1:10)+(i-1)*10,])
}

png("goLang.png")
plot(y=avgtime,x=c(1,200*(1:25)),type="l",lwd = 2, main="Golang response time ~ number of socket connections",ylab="time",xlab="# connections",yaxt="n",ylim=c(0,7))
axis(2,at=0:7)
dev.off()
