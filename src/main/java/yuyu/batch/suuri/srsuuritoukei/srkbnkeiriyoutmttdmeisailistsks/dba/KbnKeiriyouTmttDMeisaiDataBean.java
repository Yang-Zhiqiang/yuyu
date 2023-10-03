package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;

/**
 * 数理 数理統計 区分経理用積立配当金明細データBeanクラス
 */
public class KbnKeiriyouTmttDMeisaiDataBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkeiriyousegmentkbn;

    @Getter @Setter
    private String kbnkeiriyourgnbnskkbn;

    @Getter @Setter
    private C_SrHaitoukinSyuukeiPtnKbn srhaitoukinsyuukeiptnkbn;

    @Getter @Setter
    private BizNumber kensuu;

    @Getter @Setter
    private BizCurrency hsys;

    @Getter @Setter
    private BizCurrency zennendkurikosid;

    @Getter @Setter
    private BizCurrency tumitaterisoku;

    @Getter @Setter
    private BizCurrency tounendod;

    @Getter @Setter
    private BizCurrency tndmatutumitated;

    public KbnKeiriyouTmttDMeisaiDataBean(
        String pKbnkeiriyousegmentkbn,
        String pKbnkeiriyourgnbnskkbn,
        C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn,
        Long pKensuu,
        String pHsysType,
        BigDecimal pHsysValue,
        String pZennendkurikosidType,
        BigDecimal pZennendkurikosidValue,
        String pTumitaterisokuType,
        BigDecimal pTumitaterisokuValue,
        String pTounendodType,
        BigDecimal pTounendodValue,
        String pTndmatutumitatedType,
        BigDecimal pTndmatutumitatedValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        hsys = new BizCurrencySum(pHsysType, pHsysValue).toBizCurrency();
        zennendkurikosid = new BizCurrencySum(pZennendkurikosidType, pZennendkurikosidValue).toBizCurrency();
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        tounendod = new BizCurrencySum(pTounendodType, pTounendodValue).toBizCurrency();
        tndmatutumitated = new BizCurrencySum(pTndmatutumitatedType, pTndmatutumitatedValue).toBizCurrency();
    }

    public KbnKeiriyouTmttDMeisaiDataBean(
        C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn,
        Long pKensuu,
        String pHsysType,
        BigDecimal pHsysValue,
        String pZennendkurikosidType,
        BigDecimal pZennendkurikosidValue,
        String pTumitaterisokuType,
        BigDecimal pTumitaterisokuValue,
        String pTounendodType,
        BigDecimal pTounendodValue,
        String pTndmatutumitatedType,
        BigDecimal pTndmatutumitatedValue) {

        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        hsys = new BizCurrencySum(pHsysType, pHsysValue).toBizCurrency();
        zennendkurikosid = new BizCurrencySum(pZennendkurikosidType, pZennendkurikosidValue).toBizCurrency();
        tumitaterisoku = new BizCurrencySum(pTumitaterisokuType, pTumitaterisokuValue).toBizCurrency();
        tounendod = new BizCurrencySum(pTounendodType, pTounendodValue).toBizCurrency();
        tndmatutumitated = new BizCurrencySum(pTndmatutumitatedType, pTndmatutumitatedValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
