package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 新契約 入金／返金状況確認 入金入力情報Beanクラス<br/>
 */
public class NyuukinNyuuryokuInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String mosno;

    @Getter
    @Setter
    private C_KykKbn kykkbn;

    @Getter
    @Setter
    private String hhknnmkn;

    @Getter
    @Setter
    private String kyknmkn;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private C_NyknsyubetuKbn nyknsyubetu;

    @Getter
    @Setter
    private BizDate ryosyuymd;

    @Getter
    @Setter
    private BizCurrency rsgaku;

    @Getter
    @Setter
    private BizCurrency denyenkagk;

    @Getter
    @Setter
    private BizDate fstpryosyuymd;

    @Getter
    @Setter
    private BizNumber denkawaserate;

    @Getter
    @Setter
    private String nyuukinsyoritime;

    @Getter
    @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter
    @Setter
    private C_SeirituKbn seiritukbn;

    public NyuukinNyuuryokuInfoBean(String pMosno, C_KykKbn pKykkbn, String pHhknnmkn, String pKyknmkn,
        C_Tuukasyu pKyktuukasyu, C_NyknsyubetuKbn pNyknsyubetu, BizDate pRyosyuymd, String pRsgakuType,
        BigDecimal pRsgakuValue, String pDenyenkagkType, BigDecimal pDenyenkagkValue, BizDate pFstpryosyuymd,
        BizNumber pDenkawaserate, String pNyuukinsyoritime, C_Tuukasyu pRstuukasyu, C_SeirituKbn pSeirituKbn) {
        mosno = pMosno;
        kykkbn = pKykkbn;
        hhknnmkn = pHhknnmkn;
        kyknmkn = pKyknmkn;
        kyktuukasyu = pKyktuukasyu;
        nyknsyubetu = pNyknsyubetu;
        ryosyuymd = pRyosyuymd;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        fstpryosyuymd = pFstpryosyuymd;
        denkawaserate = pDenkawaserate;
        nyuukinsyoritime = pNyuukinsyoritime;
        rstuukasyu = pRstuukasyu;
        seiritukbn = pSeirituKbn;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
