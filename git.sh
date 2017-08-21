erreur1(){
echo "Erreur sur le pull"
exit 1
}

erreur2(){
echo "Erreur sur le push"
exit 1
}

parfait(){
echo "Aucune Erreur"
exit 0
}

echo "======================================================"
echo "====================== git pull ======================"
echo "======================================================"
git pull
if [ "$?" != 0 ];then
    erreur1
fi
sleep 2

echo "======================================================"
echo "====================== git add ======================="
echo "======================================================"
echo "========== Tout les fichier pour Angularjs ==========="
echo "=============== Toute les classes JAVA ==============="
echo "======================================================"

git add src/main/webapp/*
git add src/main/java/*
git add src/main/resources/*
git add git.sh
sleep 2

echo "======================================================"
echo "=================== git commit -m ===================="
echo "======================================================"
if [ "$1" != "" ];then
    git commit -m "$1"
else
    echo -n "Votre message pour le commit : "
    read message
    git commit -m "$message"
fi
sleep 2

echo "======================================================"
echo "===================== git push ======================="
echo "======================================================"
git push origin master

if [ "$?" != 0 ];then
    erreur2
else
    parfait
fi


