// def call(String project, String ImageTag, String hubUser){
    
//     sh """
//      docker image build -t ${hubUser}/${project} . 
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
//      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
//     """
// }

def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
     docker build -t ${ecr_repoName} .
     // docker build -t vinayakyadav .
     // docker tag vinayakyadav:latest 434093523956.dkr.ecr.us-west-2.amazonaws.com/vinayakyadav:latest
     docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    """
}

