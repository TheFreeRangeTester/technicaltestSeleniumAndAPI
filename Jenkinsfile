pipeline{
    //En que agente esto va a estar corriendo
  agent any 
  //Que herramientas vamos a estar instalando al principio
  tools{
      gradle "Gradle"
  }
  
  stages{
      stage("Tareas de limpieza"){
          steps{
              //Agarrar el repo en el que esta el codigo que necesitamos correr
              git 'https://github.com/TheFreeRangeTester/SeleniumCucumber.git'
              //Ejecutar la tarea clean de Gradle
              sh 'gradle clean'
          }
      }
      stage("Imprimo cositas"){
          steps{
              echo "Soy un Stage aparte"
          }
      }
  }
  
}