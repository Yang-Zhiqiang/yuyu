package yuyu.app.hozen.khozen.khtetudukityuui;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TtdktyuuiKbn;

/**
 * 契約保全手続注意設定 - ttdkTyuui1 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TtdkTyuui1DataSourceBean extends GenTtdkTyuui1DataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_TtdktyuuiKbn bfrTtdktyuuikbn;

    private String bfrTtdktyuuikbnhsknaiyou;

    private BizDate bfrTtdktyuuikbnsetymd;

    private String bfrSetsosikiCd;

    private String bfrSetsosikiNm;

    private String setsosikiCd;

    public TtdkTyuui1DataSourceBean() {
    }

    public C_TtdktyuuiKbn getBfrTtdktyuuikbn() {
        return bfrTtdktyuuikbn;
    }

    public void setBfrTtdktyuuikbn(C_TtdktyuuiKbn pBfrTtdktyuuikbn) {
        bfrTtdktyuuikbn = pBfrTtdktyuuikbn;
    }

    public String getBfrTtdktyuuikbnhsknaiyou() {
        return bfrTtdktyuuikbnhsknaiyou;
    }

    public void setBfrTtdktyuuikbnhsknaiyou(String pBfrTtdktyuuikbnhsknaiyou) {
        this.bfrTtdktyuuikbnhsknaiyou = pBfrTtdktyuuikbnhsknaiyou;
    }

    public BizDate getBfrTtdktyuuikbnsetymd() {
        return bfrTtdktyuuikbnsetymd;
    }

    public void setBfrTtdktyuuikbnsetymd(BizDate pBfrTtdktyuuikbnsetymd) {
        bfrTtdktyuuikbnsetymd = pBfrTtdktyuuikbnsetymd;
    }

    public String getBfrSetsosikiCd() {
        return bfrSetsosikiCd;
    }

    public void setBfrSetsosikiCd(String pBfrSetsosikiCd) {
        bfrSetsosikiCd = pBfrSetsosikiCd;
    }

    public String getBfrSetsosikiNm() {
        return bfrSetsosikiNm;
    }

    public void setBfrSetsosikiNm(String pBfrSetsosikiNm) {
        bfrSetsosikiNm = pBfrSetsosikiNm;
    }

    public String getSetsosikiCd() {
        return setsosikiCd;
    }

    public void setSetsosikiCd(String pSetsosikiCd) {
        setsosikiCd = pSetsosikiCd;
    }

}
