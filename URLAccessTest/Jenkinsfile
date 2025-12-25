pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Kod deposundan çekiliyor...'
                // Git checkout yapılabilir
                // git 'https://github.com/yourrepo/project.git'
            }
        }

        stage('URL Erişim Testi') {
            steps {
                echo 'JUnit ile URL erişim kontrolü yapılıyor...'
                script {
                    try {
                        // Proje dosyalarını listele
                        sh 'dir'

                        // Maven ile test çalıştır
                        sh 'mvn clean test'

                        // Test sonuçlarını JUnit plugin'i ile kaydet
                        junit '**/target/surefire-reports/*.xml'

                        echo '✓ URL erişim testi başarılı!'

                    } catch (Exception e) {
                        echo "✗ URL erişim testi başarısız! Hata: ${e.message}"
                        error("URL'ye erişilemedi. Pipeline durduruluyor.")
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy işlemi başlatılıyor...'
                // Deploy komutlarınızı buraya ekleyin
                sh '''
                    echo "Uygulama deploy ediliyor..."
                    # Örnek deploy komutları:
                    # scp target/*.war user@server:/opt/tomcat/webapps/
                    # ssh user@server 'systemctl restart tomcat'
                '''
                echo '✓ Deploy işlemi tamamlandı!'
            }
        }
    }

    post {
        success {
            echo '✓ Pipeline başarıyla tamamlandı!'
        }
        failure {
            echo '✗ Pipeline başarısız oldu!'
        }
        always {
            echo 'Pipeline tamamlandı.'
        }
    }
}