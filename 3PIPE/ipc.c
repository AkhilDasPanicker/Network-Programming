#include<stdio.h>
#include<stdlib.h>
/*
#include<unistd.h>
#include<sys/types.h>
#include<string.h>
#include<sys/wait.h>
*/

void main()
{
int pipefd[2],pid,n;
char buffer[20];
pipe(pipefd);
printf("\nreadfd:%d",pipefd[0]);
printf("\nwritefd:%d",pipefd[1]);
pid=fork();
if(pid==0)
{
close(pipefd[0]);
printf("\nchild process is sending data");
write(pipefd[1],"hello world",12);
}
else if(pid>0)
{
close(pipefd[1]);
printf("\nparent process is receiving data");
n=read(pipefd[0],buffer,sizeof(buffer));
printf("\nsize of data received:%d",n);
printf("\ndata received:%s",buffer);
}
else
{
printf("\nerror...");
}
}
