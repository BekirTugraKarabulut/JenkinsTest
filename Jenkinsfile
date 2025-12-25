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
                        // Proje dosyalarını listele (Windows)
                        bat 'dir'
                        
                        // Maven ile test çalıştır (Windows)
                        bat 'mvn clean test'
                        
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
                // Deploy komutlarınızı buraya ekleyin (Windows)
                bat '''
                    echo Uygulama deploy ediliyor...
                    REM Örnek deploy komutları:
                    REM xcopy target\\*.war \\\\server\\share\\
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
