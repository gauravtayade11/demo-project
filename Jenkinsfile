// def gv
// pipeline {
//     agent any
//     // environment{
//     //     // use to declare the env variable 
//     // }
//     parameters{
//         choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
//         booleanParam(name:'executeTest',defaultValue: true, description:'')
//     }

//     stages {
//         stage('init'){
//             steps{
//                 script{
//                     gv = load "script.groovy"
//                 }
//             }
//         }
//         stage('build') {
//             steps {
//                 script{
//                     gv.buildApp()
//                 }
//             }
//         }

//         stage('test') {
//             when{
//                 expression{
//                     params.executeTest
//                 }
//             }
//             steps {
//                 script{
//                     gv.testApp()
//                 }
//             }
//         }
//         stage('deploy') {
//             input{
//                 message "Select the environment to deploy"
//                 ok "Done"
//                 parameters{
//                     choice(name: 'ENV_1', choices: ['dev','stage','prod'], description: '')
//                     choice(name: 'ENV_2', choices: ['dev','stage','prod'], description: '')
//                 }
//             }
//             steps {
//                 script{
//                     gv.deployApp()
//                     echo "Deploying to ${ENV_1}"
//                 }
//             }
//         }
//     }
// }


pipeline {
    agent any
    // environment{
    //     // use to declare the env variable 
    // }
    tools{
        maven 'Maven'
    }
    stages{
        stage('build jar'){
            steps{
                script{
                    echo "building the jar "
                    sh 'mvn package'
                }
            }
        }
        stage('build images'){
            steps{
                script{
                    echo "building the images "
                    withCredential([usernamePassword(credentialsId: 'docker-creds',passwordVariable:'PASS',usernameVariable:'USER')]){
                        sh 'docker build -t gauravt11/demo-app:1.0.x .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push gauravt11/demo-app:1.0.x '
                    }
                }
            }
        }
    }
