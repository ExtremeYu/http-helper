#!/bin/bash

rm -fr ./releases

mkdir -p ./releases/http-helper-0.0.1-release/md/
cp ./README.md ./releases/http-helper-0.0.1-release/md/index.md
generate-md --layout ./mixu-gray --input ./releases/http-helper-0.0.1-release/md/ --output ./releases/http-helper-0.0.1-release/
rm -fr ./releases/http-helper-0.0.1-release/md/

mvn clean package -DskipTests -Dmaven.test.skip=true

cp ./target/http-helper-0.0.1.jar ./releases/http-helper-0.0.1-release/

tar zcvf ./releases/http-helper-0.0.1-release/http-helper-0.0.1-src.tar.gz ./src ./README.md ./pom.xml ./make-release.sh ./LICENSE ./.gitignore ./deploy-maven.sh



tar zcvf ./releases/http-helper-0.0.1-release.tar.gz -C ./releases http-helper-0.0.1-release
rm -fr ./releases/http-helper-0.0.1-release
