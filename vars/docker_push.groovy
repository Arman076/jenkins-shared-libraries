def call(String Project, String ImageTag, String dockerHubUser)
{
withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')])
                {
                    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
                }
                    // sh "docker image tag $IMAGE_NAME $PUSH_IMAGE"
                    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
                    echo "Image pushed to Docker Hub successfully."
}
