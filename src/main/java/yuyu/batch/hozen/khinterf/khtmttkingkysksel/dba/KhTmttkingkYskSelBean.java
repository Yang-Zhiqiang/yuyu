package yuyu.batch.hozen.khinterf.khtmttkingkysksel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 積立金額予測ファイル抽出Beanクラス<br />
 */
public class KhTmttkingkYskSelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String syouhncd;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private Integer hknkkn;

    @Getter
    @Setter
    private BizCurrency hokenryou;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private BizNumber setteibairitu;

    @Getter
    @Setter
    private BizNumber kykjisisuurendourate;

    @Getter
    @Setter
    private BizNumber tmttknzoukaritujygn;

    @Getter
    @Setter
    private BizNumber tumitateriritu;

    @Getter
    @Setter
    private C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutai;

    @Getter
    @Setter
    private C_Sisuukbn sisuukbn;

    @Getter
    @Setter
    private BizNumber rendouritu;

    @Getter
    @Setter
    private C_UmuKbn teikisiharaikinumu;

    @Getter
    @Setter
    private BizDateYM tmttkntaisyouym;

    @Getter
    @Setter
    private Integer renno;

    @Getter
    @Setter
    private BizNumber tmttknhaneisisuu;

    @Getter
    @Setter
    private BizCurrency sisuurendoutmttkngk;

    @Getter
    @Setter
    private BizCurrency teiritutmttkngk;


    public KhTmttkingkYskSelBean(
        String pKbnkey,
        String pSyono,
        String pSyouhncd,
        BizDate pKykymd,
        Integer pHknkkn,
        String pHokenryouType,
        BigDecimal pHokenryouValue,
        C_Tuukasyu pKyktuukasyu,
        BizNumber pSetteibairitu,
        BizNumber pKykjisisuurendourate,
        BizNumber pTmttknzoukaritujygn,
        BizNumber pTumitateriritu,
        C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai,
        C_Sisuukbn pSisuukbn,
        BizNumber pRendouritu,
        C_UmuKbn pTeikisiharaikinumu,
        BizDateYM pTmttkntaisyouym,
        Integer pRenno,
        BizNumber pTmttknhaneisisuu,
        String pSisuurendoutmttkngkType,
        BigDecimal pSisuurendoutmttkngkValue,
        String pTeiritutmttkngkType,
        BigDecimal pTeiritutmttkngkValue) {

        kbnkey = pKbnkey;
        syono = pSyono;
        syouhncd = pSyouhncd;
        kykymd = pKykymd;
        hknkkn = pHknkkn;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        kyktuukasyu = pKyktuukasyu;
        setteibairitu = pSetteibairitu;
        kykjisisuurendourate = pKykjisisuurendourate;
        tmttknzoukaritujygn = pTmttknzoukaritujygn;
        tumitateriritu = pTumitateriritu;
        tmttknhaibunjyoutai = pTmttknhaibunjyoutai;
        sisuukbn = pSisuukbn;
        rendouritu = pRendouritu;
        teikisiharaikinumu = pTeikisiharaikinumu;
        tmttkntaisyouym = pTmttkntaisyouym;
        renno = pRenno;
        tmttknhaneisisuu = pTmttknhaneisisuu;
        sisuurendoutmttkngk = new BizCurrencySum(pSisuurendoutmttkngkType, pSisuurendoutmttkngkValue).toBizCurrency();
        teiritutmttkngk = new BizCurrencySum(pTeiritutmttkngkType, pTeiritutmttkngkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
