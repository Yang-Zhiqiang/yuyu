package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理･会計 Ｐ未入消滅自動送金不可BEAN
 */
public class PMinyuuSymtJidouSkHukaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizCurrency kaiyakuhrknsiteituuka;

    @Getter @Setter
    private BizCurrency zitkazukarikingksiteituuka;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private String syouhnCd;

    public PMinyuuSymtJidouSkHukaBean (
        String pSyono,
        String pKaiyakuhrknsiteituukaType,
        BigDecimal pKaiyakuhrknsiteituukaValue,
        String pZitkazukarikingksiteituukaType,
        BigDecimal pZitkazukarikingksiteituukaValue,
        String pSyouhnCd,
        C_Tuukasyu pKyktuukasyu) {
        syono = pSyono;
        kaiyakuhrknsiteituuka = new BizCurrencySum(pKaiyakuhrknsiteituukaType,
            pKaiyakuhrknsiteituukaValue).toBizCurrency();
        zitkazukarikingksiteituuka = new BizCurrencySum(pZitkazukarikingksiteituukaType,
            pZitkazukarikingksiteituukaValue).toBizCurrency();
        syouhnCd = pSyouhnCd;
        kyktuukasyu = pKyktuukasyu;
    }


    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
