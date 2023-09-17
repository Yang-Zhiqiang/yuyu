package yuyu.def.biz.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 即時分資金移動リスト作成用データBeanです。<br />
 */
public class SokujiSikinIdouListSkssBySyoriYmdBean implements Serializable {

    public SokujiSikinIdouListSkssBySyoriYmdBean(
        C_Segcd pSeg1cd, C_Tuukasyu pKyktuukasyu,
        String pKeiyakutuukagkSumType, BigDecimal pKeiyakutuukagkSumValue,
        C_SikinIdouKbn pSikinidoukbn, C_SikinidougroupKbn pSikinidougroupkbn,
        C_SikinidoumeisaiKbn pSikinidoumeisaikbn) {

        seg1cd = pSeg1cd;
        kyktuukasyu = pKyktuukasyu;
        keiyakutuukagkSum = new BizCurrencySum(pKeiyakutuukagkSumType, pKeiyakutuukagkSumValue).toBizCurrency();
        sikinidoukbn = pSikinidoukbn;
        sikinidougroupkbn = pSikinidougroupkbn;
        sikinidoumeisaikbn = pSikinidoumeisaikbn;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizCurrency keiyakutuukagkSum;

    @Getter @Setter
    private C_SikinIdouKbn sikinidoukbn;

    @Getter @Setter
    private C_SikinidougroupKbn sikinidougroupkbn;

    @Getter @Setter
    private C_SikinidoumeisaiKbn sikinidoumeisaikbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
