package yuyu.batch.biz.bzkaikei.bztienrskutiwakelistsks;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 業務共通 経理・会計 支払遅延利息内訳リスト作成用Bean
 */
public class BzTienrskUtiwakeListSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriCd;

    private BizCurrency kasikatagk;

    private BizCurrency karikatagk;

    private String shiharaiTienRisoCd;

    private String shiharaiTienRisoNm;

    private int kensuu;

    public String getSyoriCd() {
        return syoriCd;
    }

    public void setSyoriCd(String pSyoriCd) {
        syoriCd = pSyoriCd;
    }

    public BizCurrency getKasikatagk() {
        return kasikatagk;
    }

    public void setKasikatagk(BizCurrency pKasikatagk) {
        kasikatagk = pKasikatagk;
    }

    public BizCurrency getKarikatagk() {
        return karikatagk;
    }

    public void setKarikatagk(BizCurrency pKarikatagk) {
        karikatagk = pKarikatagk;
    }

    public String getShiharaiTienRisoCd() {
        return shiharaiTienRisoCd;
    }

    public void setShiharaiTienRisoCd(String pShiharaiTienRisoCd) {
        shiharaiTienRisoCd = pShiharaiTienRisoCd;
    }

    public String getShiharaiTienRisoNm() {
        return shiharaiTienRisoNm;
    }

    public void setShiharaiTienRisoNm(String pShiharaiTienRisoNm) {
        shiharaiTienRisoNm = pShiharaiTienRisoNm;
    }

    public int getKensuu() {
        return kensuu;
    }

    public void setKensuu(int pKensuu) {
        kensuu = pKensuu;
    }
}
