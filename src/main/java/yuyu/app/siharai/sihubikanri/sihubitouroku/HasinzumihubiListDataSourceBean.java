package yuyu.app.siharai.sihubikanri.sihubitouroku;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 保険金給付金不備登録 - ●発信済み不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HasinzumihubiListDataSourceBean extends GenHasinzumihubiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    private String hubiNaiyouCd;

    private String hubiTourokuTantouId;

    private String hubiSyouninnTantouId;

    public HasinzumihubiListDataSourceBean() {
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    public String getHubiNaiyouCd() {
        return hubiNaiyouCd;
    }

    public void setHubiNaiyouCd(String pHubiNaiyouCd) {
        this.hubiNaiyouCd = pHubiNaiyouCd;
    }

    public String getHubiTourokuTantouId() {
        return hubiTourokuTantouId;
    }

    public void setHubiTourokuTantouId(String pHubiTourokuTantouId) {
        this.hubiTourokuTantouId = pHubiTourokuTantouId;
    }

    public String getHubiSyouninnTantouId() {
        return hubiSyouninnTantouId;
    }

    public void setHubiSyouninnTantouId(String pHubiSyouninnTantouId) {
        this.hubiSyouninnTantouId = pHubiSyouninnTantouId;
    }
}
