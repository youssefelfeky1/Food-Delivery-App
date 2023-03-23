package com.example.foodapp.Model;

public class CategoryDomain {
    private String title;
    private String pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public CategoryDomain(String name, String pic) {
        this.title = name;
        this.pic = pic;
    }
}
