pipeline {
  agent {
    node {
      label 'maven'
    }

  }
  stages {
    stage('拉代码') {
      steps {
        container('maven') {
          git(credentialsId: 'githubid', branch: 'master', url: 'https://github.com/937327493/wangziweiddd.git', changelog: true, poll: false)
        }

      }
    }
    stage('编译打包代码') {
      steps {
        container('maven') {
          sh 'mvn clean package -Dmaven.test.skip=true -gs `pwd`/mvn-settings.xml'
        }

      }
    }
    stage('代码质量分析') {
      steps {
        container('maven') {
          withCredentials([string(credentialsId : 'sonar-token' ,variable : 'sonartoken' ,)]) {
            withSonarQubeEnv('sonar') {
              sh 'mvn sonar:sonar -gs `pwd`/mvn-settings.xml -Dsonar.branch=\'master\' -Dsonar.login=$sonartoken'
            }

          }

        }

      }
    }
    stage('构建镜像') {
      steps {
        container('maven') {
          sh 'cd $PROJECT_NAME && docker build -f Dockerfile -t $REGISTRY/$DOCKERHUB_NAMESPACE/$PROJECT_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER .'
          withCredentials([usernamePassword(credentialsId : 'hubid' ,passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,)]) {
            sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
            sh 'docker push  $REGISTRY/$DOCKERHUB_NAMESPACE/$PROJECT_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER'
          }

        }

      }
    }
    stage('部署镜像') {
      steps {
        script {
          input(id: "deploy-to-dev-$PROJECT_NAME", message: '是部署到k8s?')
        }

        kubernetesDeploy(enableConfigSubstitution: true, deleteResource: false, kubeconfigId: 'ddd-kubeconfig', configs: "$PROJECT_NAME/deploy/**", dockerCredentials: [[credentialsId: 'hubid', url: 'registry.cn-hangzhou.aliyuncs.com/com_wzw/wangziweiddd-start']])
      }
    }
  }
  environment {
    KUBECONFIG_CREDENTIAL_ID = 'demo-kubeconfig'
    REGISTRY = 'registry.cn-hangzhou.aliyuncs.com'
    DOCKERHUB_NAMESPACE = 'com_wzw'
    SONAR_CREDENTIAL_ID = 'sonar-token'
    BRANCH_NAME = 'master'
  }
  parameters {
    string(name: 'PROJECT_VERSION', defaultValue: 'v0.0Beta', description: '项目版本')
    string(name: 'PROJECT_NAME', defaultValue: 'wangziweiddd-cicd', description: '构建模块')
    string(name: 'BUILD_NUMBER', defaultValue: '1.0', description: '镜像版本')
  }
}