package cn.cqu.vspace.pojo;

public class Condition {
    private String searchWord;
    private int searchCategoryId;

    public Condition() {
    }

    public Condition(String searchWord, int searchCategoryId) {
        this.searchWord = searchWord;
        this.searchCategoryId = searchCategoryId;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public int getSearchCategoryId() {
        return searchCategoryId;
    }

    public void setSearchCategoryId(int searchCategoryId) {
        this.searchCategoryId = searchCategoryId;
    }
}
