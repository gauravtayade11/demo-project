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
        stage('build') {
            steps {
                echo 'From Build'
            }
        }
        stage('test') {
            when{
                expression{
                    params.executeTest
                }
            }
            steps {
                echo 'From test'
            }
        }
        stage('deploy') {
            steps {
                echo 'From deploy'
                echo "Deploying version ${params.VERSION}"
            }
        }
    }
}
