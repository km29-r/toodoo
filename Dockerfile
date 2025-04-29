# Java 17 の公式イメージを使う（Render でよく使われる）
FROM eclipse-temurin:17-jdk

# 作業ディレクトリを設定
WORKDIR /app

# ホストからコンテナへ、すべてのファイルをコピー
COPY . .

# Maven Wrapper を使ってビルド。テストはスキップして高速化
RUN ./mvnw clean package -DskipTests

# アプリが使うポートを開放（Spring Bootのデフォルト）
EXPOSE 8080

# jarファイルを実行
CMD ["java", "-jar", "target/*.jar"]
