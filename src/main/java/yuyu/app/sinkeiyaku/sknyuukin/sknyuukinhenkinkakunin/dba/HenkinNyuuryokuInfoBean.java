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
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 新契約 入金／返金状況確認 返金入力情報Beanクラス<br/>
 */
public class HenkinNyuuryokuInfoBean implements Serializable {

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
    private C_HnknhouKbn hnknhoukbn;

    @Getter
    @Setter
    private BizCurrency hnkngk;

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
    private String henkinsyoritime ;

    @Getter
    @Setter
    private C_Tuukasyu hnkntuukasyu ;

    @Getter
    @Setter
    private C_SeirituKbn seiritukbn;

    public HenkinNyuuryokuInfoBean(String pMosno, C_KykKbn pKykkbn, String pHhknnmkn, String pKyknmkn,
        C_Tuukasyu pKyktuukasyu, C_HnknhouKbn pHnknhoukbn, String pHnkngkType, BigDecimal pHnkngkValue,
        String pDenyenkagkType, BigDecimal pDenyenkagkValue, BizDate pFstpryosyuymd, BizNumber pDenkawaserate,
        String pHenkinsyoritime, C_Tuukasyu pHnkntuukasyu, C_SeirituKbn pSeirituKbn) {
        mosno = pMosno;
        kykkbn = pKykkbn;
        hhknnmkn = pHhknnmkn;
        kyknmkn = pKyknmkn;
        kyktuukasyu = pKyktuukasyu;
        hnknhoukbn = pHnknhoukbn;
        hnkngk = new BizCurrencySum(pHnkngkType, pHnkngkValue).toBizCurrency();
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        fstpryosyuymd = pFstpryosyuymd;
        denkawaserate = pDenkawaserate;
        henkinsyoritime = pHenkinsyoritime;
        hnkntuukasyu = pHnkntuukasyu;
        seiritukbn = pSeirituKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
