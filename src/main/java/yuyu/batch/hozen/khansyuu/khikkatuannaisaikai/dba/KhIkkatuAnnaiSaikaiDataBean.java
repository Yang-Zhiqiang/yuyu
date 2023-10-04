package yuyu.batch.hozen.khansyuu.khikkatuannaisaikai.dba;

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

/**
 * 一括案内再開データBeanクラスです。<br />
 */
public class KhIkkatuAnnaiSaikaiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDateYM jkipjytYm;

    @Getter @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter @Setter
    private BizCurrency hrkP;

    @Getter @Setter
    private BizDate kykYmd;

    @Getter @Setter
    private String syouhnCd;

    @Getter @Setter
    private Integer syouhnsdNo;

    public KhIkkatuAnnaiSaikaiDataBean(String pSyoNo, String pKbnKey, BizDateYM pJkipjytYm, C_Hrkkaisuu pHrkKaisuu,
        String pHrkPType, BigDecimal pHrkPValue, BizDate pKykYmd, String pSyouhnCd, Integer pSyouhnsdNo) {

        syono = pSyoNo;
        kbnkey = pKbnKey;
        jkipjytYm = pJkipjytYm;
        hrkKaisuu = pHrkKaisuu;
        hrkP = new BizCurrencySum(pHrkPType, pHrkPValue).toBizCurrency();
        kykYmd = pKykYmd;
        syouhnCd = pSyouhnCd;
        syouhnsdNo = pSyouhnsdNo;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
