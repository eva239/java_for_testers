package ru.stqa.mantis.model;

public record IssueData(String summery, String description, Long project, Long category ) {

    public IssueData(){
        this("","",0L,1L);
    }
    public IssueData withSummary(String summary){
        return new IssueData(summery, this.description,this.project,this.category);
    }

    public IssueData withDescription(String description){
        return new IssueData( this.summery,description,this.project,this.category);
    }

    public IssueData withProject(Long project){
        return new IssueData(this.summery, this.description,project,this.category);
    }

    public IssueData withCategory(Long category){
        return new IssueData(this.summery, this.description,this.project,category);
    }
}
