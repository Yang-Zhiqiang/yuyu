package yuyu.app.hozen.khhubikanri.khhubitouroku;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全不備登録 - 発信済み不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HashinzumiHubiListDataSourceBean extends GenHashinzumiHubiListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public HashinzumiHubiListDataSourceBean() {
    }

    private C_SyoruiCdKbn hubisyoruicd;

    private String hubinaiyoucd;

    private String nyuryokutantouid;

    private String syounintantouid;

    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        this.hubisyoruicd = pHubisyoruicd;
    }

    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    public void setHubinaiyoucd(String pHubinaiyoucd) {
        this.hubinaiyoucd = pHubinaiyoucd;
    }

    public String getNyuryokutantouid() {
        return nyuryokutantouid;
    }

    public void setNyuryokutantouid(String pHyuryokutantouid) {
        this.nyuryokutantouid = pHyuryokutantouid;
    }

    public String getSyounintantouid() {
        return syounintantouid;
    }

    public void setSyounintantouid(String pSyounintantouid) {
        this.syounintantouid = pSyounintantouid;
    }
}
