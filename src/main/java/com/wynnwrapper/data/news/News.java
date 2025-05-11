package com.wynnwrapper.data.news;

public record News(

        String title,
        String date,
        String forumthread,
        String author,
        String content,
        String comments
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News news)) return false;
        return title.equals(news.title) &&
                date.equals(news.date) &&
                forumthread.equals(news.forumthread) &&
                author.equals(news.author) &&
                content.equals(news.content) &&
                comments.equals(news.comments);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", forumthread='" + forumthread + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}