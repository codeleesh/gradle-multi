pipeline {
    agent any

    environment {
        BUILD_TARGET_HOME = '${BUILD_HOME}'
        PROJECT = 'gradle-multi'
        APP_MEMBER = 'app-member'
        APP_ORDER = 'app-order'
        APP_PRODUCT = 'app-product'
    }

    stages {
        stage('Build') {
            parallel {
                stage('build-app-member') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-member/**/*"
                        }
                    }
                    steps {
                        echo 'Build Start "${APP_MEMBER}"'
                        sh './gradlew ${APP_MEMBER}:build -x test'
                        echo 'Build End "${APP_MEMBER}"'
                    }
                }
                stage('build-app-order') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-order/**/*"
                        }
                    }
                    steps {
                        echo 'Build Start "${APP_ORDER}"'
                        sh './gradlew ${APP_ORDER}:build -x test'
                        echo 'Build End "${APP_ORDER}"'
                    }
                }
                stage('build-app-product') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-product/**/*"
                        }
                    }
                    steps {
                        echo 'Build Start "${APP_PRODUCT}"'
                        sh './gradlew ${APP_PRODUCT}:build -x test'
                        echo 'Build End "${APP_PRODUCT}"'
                    }
                }
            }
        }
        stage('Backup & Copy') {
            parallel {
                stage('back-copy-app-member') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-member/**/*"
                        }
                    }
                    steps {
                        echo 'Backup & Copy Start "${APP_MEMBER}"'
                        echo 'Backup & Copy End "${APP_MEMBER}"'
                    }
                }
                stage('back-copy-app-order') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-order/**/*"
                        }
                    }
                    steps {
                        echo 'Backup & Copy Start "${APP_ORDER}"'
                        echo 'Backup & Copy End "${APP_ORDER}"'
                    }
                }
                stage('back-copy-app-product') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-product/**/*"
                        }
                    }
                    steps {
                        echo 'Backup & Copy Start "${APP_PRODUCT}"'
                        echo 'Backup & Copy End "${APP_PRODUCT}"'
                    }
                }
            }
        }
        stage('Deploy') {
            parallel {
                stage('deploy-app-member') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-member/**/*"
                        }
                    }
                    steps {
                        echo 'Deploy Start "${APP_MEMBER}"'
                        echo 'Deploy End "${APP_MEMBER}"'
                    }
                }
                stage('deploy-app-order') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-order/**/*"
                        }
                    }
                    steps {
                        echo 'Deploy Start "${APP_ORDER}"'
                        echo 'Deploy End "${APP_ORDER}"'
                    }
                }
                stage('deploy-app-product') {
                    when {
                        anyOf {
                            changeset "app-common/**/*"
                            changeset "app-product/**/*"
                        }
                    }
                    steps {
                        echo 'Deploy Start "${APP_PRODUCT}"'
                        echo 'Deploy End "${APP_PRODUCT}"'
                    }
                }
            }
        }
    }
}