import groovy.json.JsonSlurperClassic

def jsonParse(def json) {
    new groovy.json.JsonSlurperClassic().parseText(json)
}

pipeline {
    agent any
    stages {
        stage('compile') {
            steps {
                script {
                    sh "echo 'Compilando el Código'"
                    sh "mvn clean compile -e"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    sh "echo 'Testenado el codigo'"
                    sh "mvn clean test -e"
                }
            }
        }
        stage('jar') {
            steps {
                script {
                    sh "echo 'Generando el jar'"
                    sh "mvn clean package -e"
                }
            }
            post {
                success {
                    archiveArtifacts artifacts:'build/*.jar'
                }
            }
        }
        stage('sonar') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "echo 'Llamando a sonarqube'"
                    // Run Maven on a Unix agent to execute Sonar.
                    sh 'mvn clean verify sonar:sonar'
                }
            }
        }
        stage('uploadNexus') {
            steps {
                script {
                    sh "echo 'Subiendo a nexus...'"
                    nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'devops-usach-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '${WORKSPACE}/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
                }
            }
        }
    }
    post {
        always {
            sh "echo 'fase always executed post'"
        }
        success {
            sh "echo 'fase success'"
        }
        failure {
            sh "echo 'fase failure'"
        }
    }
}
