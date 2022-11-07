const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm591p5/",
            name: "ssm591p5",
            // sign out到Home链接
            indexUrl: 'http://localhost:8080/ssm591p5/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "Campus second-hand book trading system"
        } 
    }
}
export default base
