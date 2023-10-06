package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshtkin.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 *配当金資金移動ワークテーブルBeanクラスです。<br />
 */
public class HtkinSikinIdouWkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate kijyunymd;

    @Getter
    @Setter
    private BizDateY haitounendo;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizCurrency seisikiwariategaku;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private BizNumber sikinidoukawaserate;

    public HtkinSikinIdouWkBean(
        String pSyono,
        BizDate pKijyunymd,
        BizDateY pHaitounendo,
        C_Tuukasyu pKyktuukasyu,
        String pSeisikiwariategakuType,
        BigDecimal pSeisikiwariategakuValue,
        C_Segcd pSeg1cd,
        BizNumber pSikinidoukawaserate) {

        syono = pSyono;
        kijyunymd = pKijyunymd;
        haitounendo = pHaitounendo;
        kyktuukasyu = pKyktuukasyu;
        seisikiwariategaku = new BizCurrencySum(pSeisikiwariategakuType, pSeisikiwariategakuValue).toBizCurrency();
        seg1cd = pSeg1cd;
        sikinidoukawaserate = pSikinidoukawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
