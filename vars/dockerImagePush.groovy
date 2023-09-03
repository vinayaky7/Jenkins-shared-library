// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }


def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
    aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 434093523956.dkr.ecr.us-west-2.amazonaws.com
    // aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push 434093523956.dkr.ecr.us-west-2.amazonaws.com/vinayakyadav:latest
    // docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}
