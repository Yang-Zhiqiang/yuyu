package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 帳票一括出力 - searchResultList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SearchResultListDataSourceBean extends GenSearchResultListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    private String knskkmkId1;

    private String knskkmkId2;

    private String knskkmkId3;

    private String knskkmkId4;

    private String knskkmkId5;

    public SearchResultListDataSourceBean() {
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        this.syoruiCd = pSyoruiCd;
    }

    public String getKnskkmkId1() {
        return knskkmkId1;
    }

    public void setKnskkmkId1(String pKnskkmkId1) {
        this.knskkmkId1 = pKnskkmkId1;
    }

    public String getKnskkmkId2() {
        return knskkmkId2;
    }

    public void setKnskkmkId2(String pKnskkmkId2) {
        this.knskkmkId2 = pKnskkmkId2;
    }

    public String getKnskkmkId3() {
        return knskkmkId3;
    }

    public void setKnskkmkId3(String pKnskkmkId3) {
        this.knskkmkId3 = pKnskkmkId3;
    }

    public String getKnskkmkId4() {
        return knskkmkId4;
    }

    public void setKnskkmkId4(String pKnskkmkId4) {
        this.knskkmkId4 = pKnskkmkId4;
    }

    public String getKnskkmkId5() {
        return knskkmkId5;
    }

    public void setKnskkmkId5(String pKnskkmkId5) {
        this.knskkmkId5 = pKnskkmkId5;
    }

}
