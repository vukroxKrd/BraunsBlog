package net.braun.blog.exception;

public class RedirectToValidUrlException extends Exception {
    private static final long serialVersionUID = 5312499281206432988L;

    private String url;

    public RedirectToValidUrlException(String url) {

        super("Should bre redirected to" + url);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
