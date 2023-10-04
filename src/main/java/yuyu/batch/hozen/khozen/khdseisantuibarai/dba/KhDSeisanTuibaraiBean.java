package yuyu.batch.hozen.khozen.khdseisantuibarai.dba;

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
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;

/**
 * Ｄ精算追払管理情報Beanクラスです。<br />
 */
public class KhDSeisanTuibaraiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private C_ShrhousiteiKbn shrhousiteikbn;

    @Getter @Setter
    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Getter @Setter
    private C_YouhiKbn tuibaraiyouhikbn;

    @Getter @Setter
    private C_YouhiKbn tuutisakuseiyouhikbn;

    @Getter @Setter
    private C_DseisantetudukimeiKbn dseisantetudukimeikbn;

    @Getter @Setter
    private BizDate shrymd;

    @Getter @Setter
    private BizDate shrtienrskkisanymd;

    @Getter @Setter
    private Integer tienrsknissuu;

    @Getter @Setter
    private BizDate syoruiukeymd;

    @Getter @Setter
    private BizDate kouryokuhasseiymd;

    @Getter @Setter
    private C_Tuukasyu shrtuukasyu;

    @Getter @Setter
    private C_UmuKbn gsbunritaisyou;

    @Getter @Setter
    private C_UmuKbn yenshrtkumu;

    @Getter @Setter
    private C_KouzasyuruiKbn kzsyuruikbn;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private C_Kzdou kzdoukbn;

    @Getter @Setter
    private String kzmeiginmkn;

    @Getter @Setter
    private BizDate gaikashrkwsratekjnymd;

    @Getter @Setter
    private BizNumber gaikashrkwsrate;

    @Getter @Setter
    private BizDate zeimukwsratekjnymd;

    @Getter @Setter
    private BizNumber zeimukwsrate;

    @Getter @Setter
    private String nztodouhukencd;

    @Getter @Setter
    private BizCurrency yensynykngk;

    @Getter @Setter
    private BizCurrency yenhtykeihi;

    @Getter @Setter
    private BizCurrency yenkztgk;

    @Getter @Setter
    private BizCurrency yenshrkykhtykeihi;

    @Getter @Setter
    private Integer kykhnkkaisuu;

    @Getter @Setter
    private C_YouhiKbn shrtysykurikosiyouhi;

    @Getter @Setter
    private BizCurrency shrtuukashrgkgoukei;

    @Getter @Setter
    private BizCurrency shrtuukagstszeigk;

    @Getter @Setter
    private BizCurrency shrtuukashrtienrsk;

    @Getter @Setter
    private BizCurrency shrtuukasonotashrkngk;

    @Getter @Setter
    private BizCurrency yenkansanhaitoukin;

    @Getter @Setter
    private BizCurrency yensonotahaitoukin;

    @Getter @Setter
    private BizCurrency yenshrgkgoukei;

    @Getter @Setter
    private BizCurrency yengstszeigk;

    @Getter @Setter
    private BizCurrency yengstszeigknationaltax;

    @Getter @Setter
    private BizCurrency yengstszeigklocaltax;

    @Getter @Setter
    private BizCurrency yenshrtienrsk;

    @Getter @Setter
    private BizCurrency sonotashrkngkyen;

    @Getter @Setter
    private BizCurrency sonotashrkngksiteituuka;

    @Getter @Setter
    private C_Kaiyakujiyuu kaiyakujiyuu;

    @Getter @Setter
    private String soukinsakiyno;

    @Getter @Setter
    private String soukinsakiadr1kj;

    @Getter @Setter
    private String soukinsakiadr2kj;

    @Getter @Setter
    private String soukinsakiadr3kj;

    @Getter @Setter
    private String soukinsakinmkj;

    @Getter @Setter
    private C_DseisansouhusakihnsyuKbn dseisansouhusakihnsyukbn;

    @Getter @Setter
    private C_ZeitratkiKbn zeitratkiKbn;

    public KhDSeisanTuibaraiBean(String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        String pSyouhncd,
        Integer pSyouhnsdno,
        BizDate pKykYmd,
        C_Tuukasyu pKyktuukasyu,
        C_ShrhousiteiKbn pShrhousiteiKbn,
        C_InputShrhousiteiKbn pInputshrhousiteiKbn,
        C_YouhiKbn pTuibaraiyouhiKbn,
        C_YouhiKbn pTuutisakuseiyouhiKbn,
        C_DseisantetudukimeiKbn pDseisantetudukimeiKbn,
        BizDate pShrYmd,
        BizDate pShrtienrskkisanYmd,
        Integer pTienrsknissuu,
        BizDate pSyoruiukeYmd,
        BizDate pKouryokuhasseiYmd,
        C_Tuukasyu pShrtuukasyu,
        C_UmuKbn pGsbunritaisyou,
        C_UmuKbn pYenshrtkumu,
        C_KouzasyuruiKbn pKzsyuruiKbn,
        String pBankCd,
        String pSitenCd,
        C_YokinKbn pYokinKbn,
        String pKouzano,
        C_Kzdou pKzdouKbn,
        String pKzmeiginmkn,
        BizDate pGaikashrkwsratekjnYmd,
        BizNumber pGaikashrkwsrate,
        BizDate pZeimukwsratekjnYmd,
        BizNumber pZeimukwsrate,
        String pNztodouhukenCd,
        String pYensynyknGkType,
        BigDecimal pYensynyknGkValue,
        String pYenhtykeihiType,
        BigDecimal pYenhtykeihiValue,
        String pYenkztGkType,
        BigDecimal pYenkztGkValue,
        String pYenshrkykhtykeihiType,
        BigDecimal pYenshrkykhtykeihiValue,
        Integer pKykhnkkaisuu,
        C_YouhiKbn pShrtysykurikosiyouhi,
        String pShrtuukashrgkgoukeiType,
        BigDecimal pShrtuukashrgkgoukeiValue,
        String pShrtuukagstszeiGkType,
        BigDecimal pShrtuukagstszeiGkValue,
        String pShrtuukashrtienrskType,
        BigDecimal pShrtuukashrtienrskValue,
        String pShrtuukasonotashrknGkType,
        BigDecimal pShrtuukasonotashrknGkValue,
        String pYenkansanhaitoukinType,
        BigDecimal pYenkansanhaitoukinValue,
        String pYensonotahaitoukinType,
        BigDecimal pYensonotahaitoukinValue,
        String pYenshrgkgoukeiType,
        BigDecimal pYenshrgkgoukeiValue,
        String pYengstszeiGkType,
        BigDecimal pYengstszeiGkValue,
        String pYengstszeigknationaltaxType,
        BigDecimal pYengstszeigknationaltaxValue,
        String pYengstszeigklocaltaxType,
        BigDecimal pYengstszeigklocaltaxValue,
        String pYenshrtienrskType,
        BigDecimal pYenshrtienrskValue,
        String pSonotashrkngkyenType,
        BigDecimal pSonotashrkngkyenValue,
        String pSonotashrkngksiteituukaType,
        BigDecimal pSonotashrkngksiteituukaValue,
        C_Kaiyakujiyuu pKaiyakujiyuu,
        String pSoukinsakiyNo,
        String pSoukinsakiadr1kj,
        String pSoukinsakiadr2kj,
        String pSoukinsakiadr3kj,
        String pSoukinsakinmkj,
        C_DseisansouhusakihnsyuKbn pDseisansouhusakihnsyuKbn,
        C_ZeitratkiKbn pZeitratkiKbn) {

        kbnkey = pKbnkey;
        syono = pSyono;
        haitounendo = pHaitounendo;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kykymd = pKykYmd;
        kyktuukasyu = pKyktuukasyu;
        shrhousiteikbn = pShrhousiteiKbn;
        inputshrhousiteikbn = pInputshrhousiteiKbn;
        tuibaraiyouhikbn = pTuibaraiyouhiKbn;
        tuutisakuseiyouhikbn = pTuutisakuseiyouhiKbn;
        dseisantetudukimeikbn = pDseisantetudukimeiKbn;
        shrymd = pShrYmd;
        shrtienrskkisanymd = pShrtienrskkisanYmd;
        tienrsknissuu = pTienrsknissuu;
        syoruiukeymd = pSyoruiukeYmd;
        kouryokuhasseiymd = pKouryokuhasseiYmd;
        shrtuukasyu = pShrtuukasyu;
        gsbunritaisyou = pGsbunritaisyou;
        yenshrtkumu = pYenshrtkumu;
        kzsyuruikbn = pKzsyuruiKbn;
        bankcd = pBankCd;
        sitencd = pSitenCd;
        yokinkbn = pYokinKbn;
        kouzano = pKouzano;
        kzdoukbn = pKzdouKbn;
        kzmeiginmkn = pKzmeiginmkn;
        gaikashrkwsratekjnymd = pGaikashrkwsratekjnYmd;
        gaikashrkwsrate = pGaikashrkwsrate;
        zeimukwsratekjnymd = pZeimukwsratekjnYmd;
        zeimukwsrate = pZeimukwsrate;
        nztodouhukencd = pNztodouhukenCd;
        yensynykngk = new BizCurrencySum(pYensynyknGkType, pYensynyknGkValue).toBizCurrency();
        yenhtykeihi = new BizCurrencySum(pYenhtykeihiType, pYenhtykeihiValue).toBizCurrency();
        yenkztgk = new BizCurrencySum(pYenkztGkType, pYenkztGkValue).toBizCurrency();
        yenshrkykhtykeihi = new BizCurrencySum(pYenshrkykhtykeihiType, pYenshrkykhtykeihiValue).toBizCurrency();
        kykhnkkaisuu= pKykhnkkaisuu;
        shrtysykurikosiyouhi= pShrtysykurikosiyouhi;
        shrtuukashrgkgoukei = new BizCurrencySum(pShrtuukashrgkgoukeiType, pShrtuukashrgkgoukeiValue).toBizCurrency();
        shrtuukagstszeigk = new BizCurrencySum(pShrtuukagstszeiGkType, pShrtuukagstszeiGkValue).toBizCurrency();
        shrtuukashrtienrsk = new BizCurrencySum(pShrtuukashrtienrskType, pShrtuukashrtienrskValue).toBizCurrency();
        shrtuukasonotashrkngk = new BizCurrencySum(pShrtuukasonotashrknGkType, pShrtuukasonotashrknGkValue).toBizCurrency();
        yenkansanhaitoukin = new BizCurrencySum(pYenkansanhaitoukinType, pYenkansanhaitoukinValue).toBizCurrency();
        yensonotahaitoukin = new BizCurrencySum(pYensonotahaitoukinType, pYensonotahaitoukinValue).toBizCurrency();
        yenshrgkgoukei = new BizCurrencySum(pYenshrgkgoukeiType, pYenshrgkgoukeiValue).toBizCurrency();
        yengstszeigk = new BizCurrencySum(pYengstszeiGkType, pYengstszeiGkValue).toBizCurrency();
        yengstszeigknationaltax = new BizCurrencySum(pYengstszeigknationaltaxType, pYengstszeigknationaltaxValue).toBizCurrency();
        yengstszeigklocaltax = new BizCurrencySum(pYengstszeigklocaltaxType, pYengstszeigklocaltaxValue).toBizCurrency();
        yenshrtienrsk = new BizCurrencySum(pYenshrtienrskType, pYenshrtienrskValue).toBizCurrency();
        sonotashrkngkyen = new BizCurrencySum(pSonotashrkngkyenType, pSonotashrkngkyenValue).toBizCurrency();
        sonotashrkngksiteituuka = new BizCurrencySum(pSonotashrkngksiteituukaType, pSonotashrkngksiteituukaValue).toBizCurrency();
        kaiyakujiyuu = pKaiyakujiyuu;
        soukinsakiyno = pSoukinsakiyNo;
        soukinsakiadr1kj = pSoukinsakiadr1kj;
        soukinsakiadr2kj = pSoukinsakiadr2kj;
        soukinsakiadr3kj = pSoukinsakiadr3kj;
        soukinsakinmkj = pSoukinsakinmkj;
        dseisansouhusakihnsyukbn = pDseisansouhusakihnsyuKbn;
        zeitratkiKbn = pZeitratkiKbn;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}