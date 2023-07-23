package yuyu.infr.report.swakreport.config;

/**
 * 文書情報格納部品<br />
 * 文書情報はSVF用の設定項目であり、JasperReportでは使用されない。
 */
public class DocumentInfoConfig {

    @Deprecated
    public DocumentInfoConfig() { }

    private String title;

    private String subTitle;

    private String author;

    private String keywords;

    private String pageMode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String pTitle) {
        title = pTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String pSubTitle) {
        subTitle = pSubTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String pAuthor) {
        author = pAuthor;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String pKeywords) {
        keywords = pKeywords;
    }

    public String getPageMode() {
        return pageMode;
    }

    public void setPageMode(String pPageMode) {
        pageMode = pPageMode;
    }
}
