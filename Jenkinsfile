node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      chmod +x ./gradlew
      sh "./gradlew sonar"
    }
  }
}
