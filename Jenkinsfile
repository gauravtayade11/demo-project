def gv
pipeline {
    agent any
    // environment{
    //     // use to declare the env variable 
    // }
    parameters{
        choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
        booleanParam(name:'executeTest',defaultValue: true, description:'')
    }

    stages {
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                script{
                    gv.buildApp()
                }
            }
        }

        stage('test') {
            when{
                expression{
                    params.executeTest
                }
            }
            steps {
                script{
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            input{
                message "Select the environment to deploy"
                ok "Done"
                parameters{
                    choice(name: 'ENV_1', choices: ['dev','stage','prod'], description: '')
                    choice(name: 'ENV_2', choices: ['dev','stage','prod'], description: '')
                }
            }
            steps {
                script{
                    gv.deployApp()
                    echo "Deploying to ${ENV_1}"
                }
            }
        }
    }
}
