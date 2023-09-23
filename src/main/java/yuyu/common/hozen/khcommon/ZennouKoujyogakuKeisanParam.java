package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 契約保全 契約保全共通 前納用控除証明額計算パラメ－タ
 */
public class ZennouKoujyogakuKeisanParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kjsmyouzennoukaisiymd = null;

    private String kjsmyouzennoukikanm = "";

    private BizCurrency kjsmyouzennounyuukinkgk = BizCurrency.valueOf(0);

    private BizCurrency hrkp = BizCurrency.valueOf(0);

    private C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

    private BizDate zennoukaisiymd = null;

    private int zennourenno = 0;

    private BizNumber kjsmyouyenknsnkawaserate = BizNumber.valueOf(0);

    public ZennouKoujyogakuKeisanParam() {
        super();
    }

    public BizDate getKjsmyouzennoukaisiymd() {
        return kjsmyouzennoukaisiymd;
    }

    public void setKjsmyouzennoukaisiymd(BizDate pKjsmyouzennoukaisiymd) {
        kjsmyouzennoukaisiymd = pKjsmyouzennoukaisiymd;
    }

    public String getKjsmyouzennoukikanm() {
        return kjsmyouzennoukikanm;
    }

    public void setKjsmyouzennoukikanm(String pKjsmyouzennoukikanm) {
        kjsmyouzennoukikanm = pKjsmyouzennoukikanm;
    }

    public BizCurrency getKjsmyouzennounyuukinkgk() {
        return kjsmyouzennounyuukinkgk;
    }

    public void setKjsmyouzennounyuukinkgk(BizCurrency pKjsmyouzennounyuukinkgk) {
        kjsmyouzennounyuukinkgk = pKjsmyouzennounyuukinkgk;
    }

    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    public int getZennourenno() {
        return zennourenno;
    }

    public void setZennourenno(int pZennourenno) {
        zennourenno = pZennourenno;
    }

    public BizNumber getKjsmyouyenknsnkawaserate() {
        return kjsmyouyenknsnkawaserate;
    }

    public void setKjsmyouyenknsnkawaserate(BizNumber pKjsmyouyenknsnkawaserate) {
        kjsmyouyenknsnkawaserate = pKjsmyouyenknsnkawaserate;
    }
}
