###gradlew构建工具
1. gradle wrap(radle包装器)
   gradle wrapper
   gradle clean build
2. ./gradlew clean build(默认下载路径:/root/.gradle/wrapper/dists/)
3. shasum -a 256 *.zip
   在gradle.properties文件新增#distributionSha256Sum=
   