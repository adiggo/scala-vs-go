data = read.table("result",header=FALSE)
x=c(4,400*(1:10))
y=rep(0,11)
for(i in 1:11){
	y[i]=mean(data[c(2*i-1,2*i),])
}

png("java.png")
plot(y=y,x=x,type="l",lwd = 2, main="Java response time ~ number of socket connections",ylab="time",xlab="# connections",yaxt="n",ylim=c(0,4))
axis(2,at=0:4)
dev.off()
