def buildApp(){
    echo "build Application"
}
def testApp(){
    echo "test Application"
}
def deployApp(){
    echo "deploy Application"
    echo "printing version ${params.VERSION}"
}
