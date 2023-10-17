package yuyu.app.workflow.imagekanri.imagesyoukai;

/**
 * イメージ照会 - ankenList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class AnkenListDataSourceBean extends GenAnkenListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public AnkenListDataSourceBean() {
    }

    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    private Integer indexId;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

}
