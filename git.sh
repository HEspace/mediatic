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
echo "=media/* - ajout*/ - accueil/* - recherche/* - css/* ="
echo "====== mediatic* - js/* - index.html - login/* ======="
echo "======================================================"

git add src/main/resources/public/app/ajoutMedia/*
git add src/main/resources/public/app/ajoutAdherent/*
git add src/main/resources/public/app/accueil/*
git add src/main/resources/public/app/recherche/*
git add src/main/resources/public/app/login/*
git add src/main/resources/public/app/css/*
git add src/main/resources/public/app/Image/*
git add src/main/resources/public/app/js/*
git add src/main/resources/public/app/mediatic.js
git add src/main/resources/public/app/mediatic.css
git add src/main/resources/public/app/index.html
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


