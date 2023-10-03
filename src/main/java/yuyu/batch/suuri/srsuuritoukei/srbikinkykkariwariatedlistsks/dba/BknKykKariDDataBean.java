package yuyu.batch.suuri.srsuuritoukei.srbikinkykkariwariatedlistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 数理 数理統計 備金契約仮割当Ｄ集計データBean<br />
 */
public class BknKykKariDDataBean implements Serializable {

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
    private BizCurrency kariwariatedrisoku;

    @Getter @Setter
    private BizCurrency kariwariatedganrikin;

    public BknKykKariDDataBean(String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn, String pSyukeiyakusyuruicd,
        String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pKariwariatedrisokuType,
        BigDecimal pKariwariatedrisokuValue, String pKariwariatedganrikinType, BigDecimal pKariwariatedganrikinValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        kariwariatedganrikin = new BizCurrencySum(pKariwariatedganrikinType, pKariwariatedganrikinValue).toBizCurrency();
    }

    public BknKykKariDDataBean(String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn, String pBikinnendokbn,
        String pBikinkbn, Long pKensuu, String pKariwariatedrisokuType, BigDecimal pKariwariatedrisokuValue,
        String pKariwariatedganrikinType, BigDecimal pKariwariatedganrikinValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        kariwariatedganrikin = new BizCurrencySum(pKariwariatedganrikinType, pKariwariatedganrikinValue).toBizCurrency();
    }

    public BknKykKariDDataBean(String pBikinnendokbn, String pBikinkbn, Long pKensuu, String pKariwariatedrisokuType,
        BigDecimal pKariwariatedrisokuValue, String pKariwariatedganrikinType, BigDecimal pKariwariatedganrikinValue) {

        bikinnendokbn = pBikinnendokbn;
        bikinkbn = pBikinkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        kariwariatedganrikin = new BizCurrencySum(pKariwariatedganrikinType, pKariwariatedganrikinValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
