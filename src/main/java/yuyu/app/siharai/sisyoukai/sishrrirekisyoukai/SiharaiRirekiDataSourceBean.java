package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

/**
 * 支払履歴照会 - ●支払履歴 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SiharaiRirekiDataSourceBean extends GenSiharaiRirekiDataSourceBean {

    private static final long serialVersionUID = 1L;

    private String dispskno;

    private Integer dispskrrkno;

    public SiharaiRirekiDataSourceBean() {
    }

    public String getDispskno() {
        return dispskno;
    }

    public void setDispskno(String pDispskno) {
        this.dispskno = pDispskno;
    }

    public Integer getDispskrrkno() {
        return dispskrrkno;
    }

    public void setDispskrrkno(Integer pDispskrrkno) {
        this.dispskrrkno = pDispskrrkno;
    }

}