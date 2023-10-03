package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoubikinkykseisandlistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 数理 数理統計 区分経理用備金契約精算Ｄ集計データBean<br />
 */
public class KbnkeiriyouBknKykSeisanDDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkeiriyousegmentkbn;

    @Getter @Setter
    private String kbnkeiriyourgnbnskkbn;

    @Getter @Setter
    private String bikinnendokbn;

    @Getter @Setter
    private String bikinkbn;

    @Getter @Setter
    private BizNumber kensuu;

    @Getter @Setter
    private BizCurrency tumitaterisoku;

    @Getter @Setter
    private BizCurrency seisand;

    public KbnkeiriyouBknKykSeisanDDataBean(String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn,
        String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pTumitaterisokuType,
        BigDecimal pTumitaterisokuValue, String pSeisandType, BigDecimal pSeisandValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        seisand = new BizCurrencySum(pSeisandType, pSeisandValue).toBizCurrency();
    }

    public KbnkeiriyouBknKykSeisanDDataBean(String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pTumitaterisokuType,
        BigDecimal pTumitaterisokuValue, String pSeisandType, BigDecimal pSeisandValue) {

        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        seisand = new BizCurrencySum(pSeisandType, pSeisandValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
