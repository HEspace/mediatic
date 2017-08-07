echo "======================================================"
echo "====================== git pull ======================"
echo "======================================================"
git pull


echo "======================================================"
echo "====================== git add ======================="
echo "======================================================"
echo "=media/* - ajout*/ - accueil/* - recherche/* - css/* ="
echo "========== mediatic* - js/* - index.html - ==========="

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

echo "======================================================"
echo "=================== git commit -m ===================="
echo "======================================================"
git commit -m "$1"

echo "======================================================"
echo "===================== git push ======================="
echo "======================================================"
git push origin master