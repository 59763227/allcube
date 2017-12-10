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
