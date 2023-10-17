package yuyu.app.siharai.sisonota.simakesyorui;

/**
 * 保険金給付金書類作成 - ankenSearchResultList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class AnkenSearchResultListDataSourceBean extends GenAnkenSearchResultListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String kouteiKnrId;

    public AnkenSearchResultListDataSourceBean() {
    }

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String kouteiKnrId) {
        this.kouteiKnrId = kouteiKnrId;
    }
}
