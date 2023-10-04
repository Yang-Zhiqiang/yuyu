package yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityContainer;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 円建変更契約Beanクラス
 */
public class KhYendtHnkKykBean implements Serializable ,EntityContainer{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KykKihon kykKihon;

    @Getter
    @Setter
    private String syouhncd;

    @Getter
    @Setter
    private Integer syouhnsdno;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter
    @Setter
    private C_Syoumetujiyuu syoumetujiyuu;

    @Getter
    @Setter
    private Integer hknkkn;

    @Getter
    @Setter
    private Integer hozenhenkouuktkrenno;

    @Getter
    @Setter
    private C_UktkSyoriKbn uktksyorikbn;

    @Getter
    @Setter
    private BizDate yendthnkymd;

    @Getter
    @Setter
    private BizCurrency yendthnkkaiyakuhryen;

    @Getter
    @Setter
    private BizCurrency yendthnkhr;

    @Getter
    @Setter
    private BizCurrency yendthnkkihons;

    @Getter
    @Setter
    private String kyknmkj;

    public KhYendtHnkKykBean(IT_KykKihon pKykKihon,
        String pSyouhncd,
        Integer pSyouhnsdno,
        BizDate pKykymd,
        C_YuukousyoumetuKbn pYuukousyoumetukbn,
        C_Syoumetujiyuu pSyoumetujiyuu,
        Integer pHknkkn,
        Integer pHozenhenkouuktkrenno,
        C_UktkSyoriKbn pUktksyorikbn,
        BizDate pYendthnkymd,
        String pYendthnkkaiyakuhryenType,
        BigDecimal pYendthnkkaiyakuhryenValue,
        String pYendthnkhrType,
        BigDecimal pYendthnkhrValue,
        String pYendthnkkihonsType,
        BigDecimal pYendthnkkihonsValue,
        String pKyknmkj) {

        kykKihon = pKykKihon;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kykymd= pKykymd;
        yuukousyoumetukbn= pYuukousyoumetukbn;
        syoumetujiyuu= pSyoumetujiyuu;
        hknkkn= pHknkkn;
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
        uktksyorikbn = pUktksyorikbn;
        yendthnkymd= pYendthnkymd;
        yendthnkkaiyakuhryen = new BizCurrencySum(pYendthnkkaiyakuhryenType, pYendthnkkaiyakuhryenValue).toBizCurrency();
        yendthnkhr = new BizCurrencySum(pYendthnkhrType, pYendthnkhrValue).toBizCurrency();
        yendthnkkihons = new BizCurrencySum(pYendthnkkihonsType, pYendthnkkihonsValue).toBizCurrency();
        kyknmkj = pKyknmkj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
