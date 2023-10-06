package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;

/**
 * 業務共通 経理・会計 既払込Ｐ精算履歴データBeanクラス
 */
public class KihrkmpSeisanRirekiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private BizCurrency tuityouk;

    @Getter @Setter
    private BizCurrency yenkansantuityoukin;

    @Getter @Setter
    private BizNumber zeimukwsrate;

    @Getter @Setter
    private C_Segcd segcd;

    public KihrkmpSeisanRirekiDataBean(
        String pSyono,
        Integer pRenno,
        BigDecimal pTuityoukValue,
        String pTuityoukType,
        BigDecimal pYenkansantuityoukinValue,
        String pyenkansantuityoukinType,
        BizNumber pZeimukwsrate,
        C_Segcd pSegcd) {

        syono = pSyono;
        renno = pRenno;
        tuityouk = new BizCurrencySum(pTuityoukType, pTuityoukValue).toBizCurrency();
        yenkansantuityoukin = new BizCurrencySum(pyenkansantuityoukinType, pYenkansantuityoukinValue).toBizCurrency();
        zeimukwsrate = pZeimukwsrate;
        segcd = pSegcd;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
