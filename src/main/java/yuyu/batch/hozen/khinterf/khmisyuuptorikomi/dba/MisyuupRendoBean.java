package yuyu.batch.hozen.khinterf.khmisyuuptorikomi.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 インターフェイス 未収Ｐ連動Bean
 */
public class MisyuupRendoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer datarenno;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private C_UmuKbn iktnyuukinnumu;

    @Getter @Setter
    private BizDateYM misyuupjyuutouym;

    @Getter @Setter
    private Integer misyuupjyuutoukaisuuy;

    @Getter @Setter
    private Integer misyuupjyuutoukaisuum;

    @Getter @Setter
    private BizCurrency misyuup;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private BizDate denymd;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private C_Tuukasyu shrtuukasyu;

    @Getter @Setter
    private BizDate nyknkwsratekijyunymd;

    public MisyuupRendoBean(String pSyono,
        Integer pDatarenno,
        C_Nykkeiro pNykkeiro,
        C_Hrkkaisuu pHrkkaisuu,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_UmuKbn pIktnyuukinnumu,
        BizDateYM pMisyuupjyuutouym,
        Integer pMisyuupjyuutoukaisuuy,
        Integer pMisyuupjyuutoukaisuum,
        String pType,
        BigDecimal pValue,
        BizDate pRyosyuymd,
        BizDate pDenymd,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        C_Tuukasyu pShrtuukasyu,
        BizDate pNyknkwsratekijyunymd) {

        syono = pSyono;
        datarenno = pDatarenno;
        nykkeiro = pNykkeiro;
        hrkkaisuu = pHrkkaisuu;
        nyknaiyoukbn = pNyknaiyoukbn;
        iktnyuukinnumu = pIktnyuukinnumu;
        misyuupjyuutouym = pMisyuupjyuutouym;
        misyuupjyuutoukaisuuy = pMisyuupjyuutoukaisuuy;
        misyuupjyuutoukaisuum = pMisyuupjyuutoukaisuum;
        misyuup = new BizCurrencySum(pType, pValue).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        denymd = pDenymd;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        shrtuukasyu = pShrtuukasyu;
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}