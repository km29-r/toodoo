# Java 17 の公式イメージを使う（Render でよく使われる）
FROM eclipse-temurin:17-jdk

# 作業ディレクトリを設定
WORKDIR /app

# Maven Wrapper 関連のファイルを先にコピー
COPY .mvn /app/.mvn
COPY mvnw /app
COPY pom.xml /app

# ソースコードをコピー (依存関係解決後にコピーすることでレイヤーを効率化)
COPY src /app/src

# Maven Wrapper に実行権限を与える
RUN chmod +x /app/mvnw

# Maven のビルドを実行 (テストはスキップして高速化)
RUN ./mvnw clean package -DskipTests

# アプリが使うポートを開放（Spring Bootのデフォルト）
EXPOSE 8080

# jarファイルを実行 (target ディレクトリにある生成された jar ファイル名を指定)
CMD ["java", "-jar", "target/toodoo-0.0.1-SNAPSHOT.jar"]