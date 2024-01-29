node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      sh "cd /var/jenkins_home/workspace/testing"
      sh "chmod +x ./gradlew"
      sh "./gradlew sonar"
    }
  }
}
