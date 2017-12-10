git clone git@github.com:gavin2lee/allcube.git

create branches
git branch dev
git checkout dev
git branch --list
git branch -r


git push --set-upstream origin dev

分支、远程分支、upstream
git branch -va
查看upstream
git branch -vv

git remote add upstream https://github.com/user1/repository.git
git remote show origin


git commit -a -m "my first commit"

使用git push [remote-name] [branch-name]将本机的工作成果推送到远程仓库


回滚到某个版本
git log
git reset –hard 8ff24a6803173208f3e606e32dfcf82db9ac84d8
1.git reset -mixed：此为默认方式，不带任何参数的git reset，这种方式，它回退到某个版本，只保留源码，回退commit和index信息
2.git reset -soft:回退到某个版本，只回退了commit的信息，不会恢复到index file一级。如果还要提交，直接commit即可
3.git reset -hard 彻底回退到某个版本，本地的源码也会变成为上一个版本的内容
