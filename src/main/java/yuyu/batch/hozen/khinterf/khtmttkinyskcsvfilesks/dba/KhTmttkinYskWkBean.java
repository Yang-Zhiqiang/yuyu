package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 インターフェイス 積立金予測ワークBeanクラス<br />
 */
@AllArgsConstructor
public class KhTmttkinYskWkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_SyouhnBunruiTmttkinyskKbn syouhnbunruitmttkinyskkbn;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private BizNumber kyksjkkktyouseiriritu;

    @Getter
    @Setter
    private C_UmuKbn targettkhkumu;

    @Getter
    @Setter
    private Integer targettkmokuhyouti;

    @Getter
    @Setter
    private BizCurrency sumKyktuukap;

    @Getter
    @Setter
    private BizCurrency sumKyktuukatmttkngk;

    @Getter
    @Setter
    private BizCurrency sumKyktuukakaiyakuhrgk;

    public KhTmttkinYskWkBean(
        C_SyouhnBunruiTmttkinyskKbn pSyouhnbunruitmttkinyskkbn,
        C_Tuukasyu pKyktuukasyu,
        BizDate pKykymd,
        BizNumber pKyksjkkktyouseiriritu,
        C_UmuKbn pTargettkhkumu,
        Integer pTargettkmokuhyouti,
        String pSumKyktuukapType,
        BigDecimal pSumKyktuukapValue,
        String pSumKyktuukatmttkngkType,
        BigDecimal pSumKyktuukatmttkngkValue,
        String pSumKyktuukakaiyakuhrgkType,
        BigDecimal pSumKyktuukakaiyakuhrgkValue) {

        syouhnbunruitmttkinyskkbn = pSyouhnbunruitmttkinyskkbn;
        kyktuukasyu = pKyktuukasyu;
        kykymd = pKykymd;
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
        targettkhkumu = pTargettkhkumu;
        targettkmokuhyouti = pTargettkmokuhyouti;
        sumKyktuukap = new BizCurrencySum(pSumKyktuukapType, pSumKyktuukapValue).toBizCurrency();
        sumKyktuukatmttkngk = new BizCurrencySum(pSumKyktuukatmttkngkType, pSumKyktuukatmttkngkValue).toBizCurrency();
        sumKyktuukakaiyakuhrgk = new BizCurrencySum(pSumKyktuukakaiyakuhrgkType, pSumKyktuukakaiyakuhrgkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
