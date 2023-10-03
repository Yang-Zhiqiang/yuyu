package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;

/**
 * 仮割当配当金明細データBeanクラス<br/>
 */
@AllArgsConstructor
public class KariDMeisaiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkeiriyousegmentkbn;

    @Getter @Setter
    private String kbnkeiriyourgnbnskkbn;

    @Getter @Setter
    private String syukeiyakusyuruicd;

    @Getter @Setter
    private C_SrHaitoukinSyuukeiPtnKbn srhaitoukinsyuukeiptnkbn;

    @Getter @Setter
    private BizNumber kensuu;

    @Getter @Setter
    private BizCurrency hsys;

    @Getter @Setter
    private BizCurrency znnndkrkskrwratdruigk;

    @Getter @Setter
    private BizCurrency kariwariatedrisoku;

    @Getter @Setter
    private BizCurrency tounendokariwariated;

    @Getter @Setter
    private BizCurrency tndmatukrkskrwratdruigk;

    public KariDMeisaiDataBean(
        String pKbnkeiriyousegmentkbn,
        String pKbnkeiriyourgnbnskkbn,
        String pSyukeiyakusyuruicd,
        C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn,
        Long pKensuu,
        String pHsysType,
        BigDecimal pHsysValue,
        String pZnnndkrkskrwratdruigkType,
        BigDecimal pZnnndkrkskrwratdruigkValue,
        String pKariwariatedrisokuType,
        BigDecimal pKariwariatedrisokuValue,
        String pTounendokariwariatedType,
        BigDecimal pTounendokariwariatedValue,
        String pTndmatukrkskrwratdruigkType,
        BigDecimal pTndmatukrkskrwratdruigkValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        syukeiyakusyuruicd = pSyukeiyakusyuruicd;
        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        hsys = new BizCurrencySum(pHsysType, pHsysValue).toBizCurrency();
        znnndkrkskrwratdruigk = new BizCurrencySum(pZnnndkrkskrwratdruigkType, pZnnndkrkskrwratdruigkValue)
        .toBizCurrency();
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        tounendokariwariated = new BizCurrencySum(pTounendokariwariatedType, pTounendokariwariatedValue)
        .toBizCurrency();
        tndmatukrkskrwratdruigk = new BizCurrencySum(pTndmatukrkskrwratdruigkType, pTndmatukrkskrwratdruigkValue)
        .toBizCurrency();
    }

    public KariDMeisaiDataBean(
        String pKbnkeiriyousegmentkbn,
        String pKbnkeiriyourgnbnskkbn,
        C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn,
        Long pKensuu,
        String pHsysType,
        BigDecimal pHsysValue,
        String pZnnndkrkskrwratdruigkType,
        BigDecimal pZnnndkrkskrwratdruigkValue,
        String pKariwariatedrisokuType,
        BigDecimal pKariwariatedrisokuValue,
        String pTounendokariwariatedType,
        BigDecimal pTounendokariwariatedValue,
        String pTndmatukrkskrwratdruigkType,
        BigDecimal pTndmatukrkskrwratdruigkValue) {

        kbnkeiriyousegmentkbn = pKbnkeiriyousegmentkbn;
        kbnkeiriyourgnbnskkbn = pKbnkeiriyourgnbnskkbn;
        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        hsys = new BizCurrencySum(pHsysType, pHsysValue).toBizCurrency();
        znnndkrkskrwratdruigk = new BizCurrencySum(pZnnndkrkskrwratdruigkType, pZnnndkrkskrwratdruigkValue)
        .toBizCurrency();
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        tounendokariwariated = new BizCurrencySum(pTounendokariwariatedType, pTounendokariwariatedValue)
        .toBizCurrency();
        tndmatukrkskrwratdruigk = new BizCurrencySum(pTndmatukrkskrwratdruigkType, pTndmatukrkskrwratdruigkValue)
        .toBizCurrency();
    }

    public KariDMeisaiDataBean(
        C_SrHaitoukinSyuukeiPtnKbn pSrhaitoukinsyuukeiptnkbn,
        Long pKensuu,
        String pHsysType,
        BigDecimal pHsysValue,
        String pZnnndkrkskrwratdruigkType,
        BigDecimal pZnnndkrkskrwratdruigkValue,
        String pKariwariatedrisokuType,
        BigDecimal pKariwariatedrisokuValue,
        String pTounendokariwariatedType,
        BigDecimal pTounendokariwariatedValue,
        String pTndmatukrkskrwratdruigkType,
        BigDecimal pTndmatukrkskrwratdruigkValue) {

        srhaitoukinsyuukeiptnkbn = pSrhaitoukinsyuukeiptnkbn;
        kensuu = BizNumber.valueOf(pKensuu);
        hsys = new BizCurrencySum(pHsysType, pHsysValue).toBizCurrency();
        znnndkrkskrwratdruigk = new BizCurrencySum(pZnnndkrkskrwratdruigkType, pZnnndkrkskrwratdruigkValue)
        .toBizCurrency();
        kariwariatedrisoku = new BizCurrencySum(pKariwariatedrisokuType, pKariwariatedrisokuValue).toBizCurrency();
        tounendokariwariated = new BizCurrencySum(pTounendokariwariatedType, pTounendokariwariatedValue)
        .toBizCurrency();
        tndmatukrkskrwratdruigk = new BizCurrencySum(pTndmatukrkskrwratdruigkType, pTndmatukrkskrwratdruigkValue)
        .toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}