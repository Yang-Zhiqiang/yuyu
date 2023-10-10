package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 補助簿累計額入力 - 補助簿累計額リスト の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHojyoboRuikeigakuInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syukanjokamokucd;

    public String getSyukanjokamokucd() {
        return syukanjokamokucd;
    }

    public void setSyukanjokamokucd(String pSyukanjokamokucd) {
        syukanjokamokucd = pSyukanjokamokucd;
    }


    private String kanjyoukmknm;

    public String getKanjyoukmknm() {
        return kanjyoukmknm;
    }

    public void setKanjyoukmknm(String pKanjyoukmknm) {
        kanjyoukmknm = pKanjyoukmknm;
    }


    private BizCurrency karikataruigk;

    public BizCurrency getKarikataruigk() {
        return karikataruigk;
    }

    public void setKarikataruigk(BizCurrency pKarikataruigk) {
        karikataruigk = pKarikataruigk;
    }


    private BizCurrency kasikataruigk;

    public BizCurrency getKasikataruigk() {
        return kasikataruigk;
    }

    public void setKasikataruigk(BizCurrency pKasikataruigk) {
        kasikataruigk = pKasikataruigk;
    }


    private BizCurrency karikatateiseigk;

    public BizCurrency getKarikatateiseigk() {
        return karikatateiseigk;
    }

    public void setKarikatateiseigk(BizCurrency pKarikatateiseigk) {
        karikatateiseigk = pKarikatateiseigk;
    }


    private BizCurrency kasikatateiseigk;

    public BizCurrency getKasikatateiseigk() {
        return kasikatateiseigk;
    }

    public void setKasikatateiseigk(BizCurrency pKasikatateiseigk) {
        kasikatateiseigk = pKasikatateiseigk;
    }

}
