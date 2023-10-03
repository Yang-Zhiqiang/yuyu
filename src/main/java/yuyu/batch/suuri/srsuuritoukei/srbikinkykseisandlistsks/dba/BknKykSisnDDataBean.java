package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisandlistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 数理 数理統計 備金契約精算ＤデータBean<br />
 */
public class BknKykSisnDDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkeiriyousegmentkbn;

    @Getter @Setter
    private String kbnkeiriyourgnbnskkbn;

    @Getter @Setter
    private String syukeiyakusyuruicd;

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

    public BknKykSisnDDataBean(String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn, String pSyukeiyakusyuruicd,
        String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pTumitaterisokuType,
        BigDecimal pTumitaterisokuValue, String pSeisandType, BigDecimal pSeisandValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        seisand = new BizCurrencySum(pSeisandType, pSeisandValue).toBizCurrency();
    }

    public BknKykSisnDDataBean(String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn, String pBikinnendokbn,
        String pBikinkbn, Long pKensuu, String pTumitaterisokuType, BigDecimal pTumitaterisokuValue,
        String pSeisandType, BigDecimal pSeisandValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        seisand = new BizCurrencySum(pSeisandType, pSeisandValue).toBizCurrency();
    }

    public BknKykSisnDDataBean(String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pTumitaterisokuType,
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
