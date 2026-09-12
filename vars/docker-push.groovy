```groovy
def call() {

    echo "This is pushing the image to DockerHub"

    withCredentials([
        usernamePassword(
            credentialsId: "aa17f279-a000-421e-8e22-ac321947ae95",
            usernameVariable: "dockerHubUser",
            passwordVariable: "dockerHubPass"
        )
    ]) {

        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"

        sh "docker image tag todo-app:latest ${env.dockerHubUser}/notes-todo:latest"

        sh "docker push ${env.dockerHubUser}/notes-todo:latest"
    }
}
```
