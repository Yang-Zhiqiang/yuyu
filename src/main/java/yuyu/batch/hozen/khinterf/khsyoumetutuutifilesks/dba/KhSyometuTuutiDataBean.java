package yuyu.batch.hozen.khinterf.khsyoumetutuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;

/**
 * 契約保全 インターフェイス 消滅通知データBeanクラス<br />
 */
public class KhSyometuTuutiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate tyouhyouymd;

    @Getter
    @Setter
    private String henkousikibetukey;

    @Getter
    @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter
    @Setter
    private C_HassouKbn hassoukbn;

    @Getter
    @Setter
    private C_UmuKbn sksdoufuukbn;

    @Getter
    @Setter
    private C_UmuKbn mynosinkokuiraidoufuukbn;

    @Getter
    @Setter
    private String shskyno;

    @Getter
    @Setter
    private String shsadr1kj;

    @Getter
    @Setter
    private String shsadr2kj;

    @Getter
    @Setter
    private String shsadr3kj;

    @Getter
    @Setter
    private String shsnmkj;

    @Getter
    @Setter
    private String toiawaseyno;

    @Getter
    @Setter
    private String toiawaseadr1kj;

    @Getter
    @Setter
    private String toiawaseadr2kj;

    @Getter
    @Setter
    private String toiawaseadr3kj;

    @Getter
    @Setter
    private String toiawasekaisyanmkj;

    @Getter
    @Setter
    private String toiawasesosikinmkj;

    @Getter
    @Setter
    private String toiawasetelno;

    @Getter
    @Setter
    private String toiawaseteluktkkanou1;

    @Getter
    @Setter
    private String toiawaseteluktkkanou2;

    @Getter
    @Setter
    private String toiawasesosikinmkj2;

    @Getter
    @Setter
    private String toiawasetelno2;

    @Getter
    @Setter
    private BizDate syoumetuymd;

    @Getter
    @Setter
    private BizDate shrymd;

    @Getter
    @Setter
    private String kyknmkj;

    @Getter
    @Setter
    private String hhknnmkj;

    @Getter
    @Setter
    private BizDate keiyakuymd;

    @Getter
    @Setter
    private BizCurrency shrtuukakaiyakuhrkngkkei;

    @Getter
    @Setter
    private BizCurrency kaiyakuhrkngkkeisiteituuka;

    @Getter
    @Setter
    private BizCurrency sonotaseisan;

    @Getter
    @Setter
    private BizCurrency yenkansanhaitoukin;

    @Getter
    @Setter
    private BizCurrency yensonotahaitoukin;

    @Getter
    @Setter
    private BizCurrency shrtuukagstszeigk;

    @Getter
    @Setter
    private BizCurrency zitkazukarikingksiteituuka;

    @Getter
    @Setter
    private BizCurrency shrgkkei;

    @Getter
    @Setter
    private C_Tuukasyu shrtuukasyu;

    @Getter
    @Setter
    private BizNumber shrkwsrate;

    @Getter
    @Setter
    private String bankcd;

    @Getter
    @Setter
    private String sitencd;

    @Getter
    @Setter
    private String banknmkj;

    @Getter
    @Setter
    private String sitennmkj;

    @Getter
    @Setter
    private C_YokinKbn yokinkbn;

    @Getter
    @Setter
    private String kouzano;

    @Getter
    @Setter
    private C_KouzasyuruiKbn kzsyuruikbn;

    @Getter
    @Setter
    private String kzmeiginmkn;

    @Getter
    @Setter
    private C_HtsiryosyuKbn htsiryosyukbn;

    @Getter
    @Setter
    private BizCurrency synykngk;

    @Getter
    @Setter
    private BizCurrency htykeihi;

    @Getter
    @Setter
    private BizCurrency shrkykhtykeihi;

    @Getter
    @Setter
    private C_ZeimuNaiyouHnsyuCtrlKbn zeimunaiyouhensyuctrlkbn;

    @Getter
    @Setter
    private Integer kykhnkkaisuu;

    @Getter
    @Setter
    private C_KykMsnKbn kykmsnkbn;

    @Getter
    @Setter
    private BizDate lastsyosaihkymd;

    @Getter
    @Setter
    private String tsinyno;

    @Getter
    @Setter
    private String tsintelno;

    @Getter
    @Setter
    private String tsinadr1kj;

    @Getter
    @Setter
    private String tsinadr2kj;

    @Getter
    @Setter
    private String tsinadr3kj;

    @Getter
    @Setter
    private String toritugisyasyozokunm;

    @Getter
    @Setter
    private String toritugisyakjncd;

    @Getter
    @Setter
    private String toritugisyanm;


    public KhSyometuTuutiDataBean(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd,
        String pHenkousikibetukey,
        C_SyoruiCdKbn pSyoruiCd,
        C_HassouKbn pHassoukbn,
        C_UmuKbn pSksdoufuukbn,
        C_UmuKbn pMynosinkokuiraidoufuukbn,
        String pShskyno,
        String pShsadr1kj,
        String pShsadr2kj,
        String pShsadr3kj,
        String pShsnmkj,
        String pToiawaseyno,
        String pToiawaseadr1kj,
        String pToiawaseadr2kj,
        String pToiawaseadr3kj,
        String pToiawasekaisyanmkj,
        String pToiawasesosikinmkj,
        String pToiawasetelno,
        String pToiawaseteluktkkanou1,
        String pToiawaseteluktkkanou2,
        String pToiawasesosikinmkj2,
        String pToiawasetelno2,
        BizDate pSyoumetuymd,
        BizDate pShrymd,
        String  pKyknmkj,
        String  pHhknnmkj,
        BizDate pKeiyakuymd,
        String pShrtuukakaiyakuhrkngkkeiType,
        BigDecimal pShrtuukakaiyakuhrkngkkeiValue,
        String pKaiyakuhrkngkkeisiteituukaType,
        BigDecimal pKaiyakuhrkngkkeisiteituukaValue,
        String pSonotaseisanType,
        BigDecimal pSonotaseisanValue,
        String pYenkansanhaitoukinType,
        BigDecimal pYenkansanhaitoukinValue,
        String pYensonotahaitoukinType,
        BigDecimal pYensonotahaitoukinValue,
        String pShrtuukagstszeigkType,
        BigDecimal pShrtuukagstszeigkValue,
        String pZitkazukarikingksiteituukaType,
        BigDecimal pZitkazukarikingksiteituukaValue,
        String pShrgkkeiType,
        BigDecimal pShrgkkeiValue,
        C_Tuukasyu pShrtuukasyu,
        BizNumber pShrkwsrate,
        String pBankcd,
        String pSitencd,
        String pBanknmkj,
        String pSitennmkj,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        C_KouzasyuruiKbn pKzsyuruikbn,
        String pKzmeiginmkn,
        C_HtsiryosyuKbn pHtsiryosyukbn,
        String pSynykngkType,
        BigDecimal pSynykngkValue,
        String pHtykeihiType,
        BigDecimal pHtykeihiValue,
        String pShrkykhtykeihiType,
        BigDecimal pShrkykhtykeihiValue,
        C_ZeimuNaiyouHnsyuCtrlKbn pZeimunaiyouhensyuctrlkbn,
        Integer pKykhnkkaisuu,
        C_KykMsnKbn pKykmsnkbn,
        BizDate pLastsyosaihkymd,
        String pTsinyno,
        String pTsintelno,
        String pTsinadr1kj,
        String pTsinadr2kj,
        String pTsinadr3kj,
        String pToritugisyasyozokunm,
        String pToritugisyakjncd,
        String pToritugisyanm) {

        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
        henkousikibetukey = pHenkousikibetukey;
        syoruiCd =  pSyoruiCd;
        hassoukbn =  pHassoukbn;
        sksdoufuukbn = pSksdoufuukbn;
        mynosinkokuiraidoufuukbn =  pMynosinkokuiraidoufuukbn;
        shskyno = pShskyno;
        shsadr1kj = pShsadr1kj;
        shsadr2kj = pShsadr2kj;
        shsadr3kj = pShsadr3kj;
        shsnmkj = pShsnmkj;
        toiawaseyno = pToiawaseyno;
        toiawaseadr1kj = pToiawaseadr1kj;
        toiawaseadr2kj = pToiawaseadr2kj;
        toiawaseadr3kj = pToiawaseadr3kj;
        toiawasekaisyanmkj = pToiawasekaisyanmkj;
        toiawasesosikinmkj = pToiawasesosikinmkj;
        toiawasetelno = pToiawasetelno;
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
        toiawasetelno2 = pToiawasetelno2;
        syoumetuymd = pSyoumetuymd;
        shrymd = pShrymd;
        kyknmkj = pKyknmkj;
        hhknnmkj = pHhknnmkj;
        keiyakuymd = pKeiyakuymd;
        shrtuukakaiyakuhrkngkkei = new BizCurrencySum(pShrtuukakaiyakuhrkngkkeiType, pShrtuukakaiyakuhrkngkkeiValue).toBizCurrency();
        kaiyakuhrkngkkeisiteituuka = new BizCurrencySum(pKaiyakuhrkngkkeisiteituukaType, pKaiyakuhrkngkkeisiteituukaValue).toBizCurrency();
        sonotaseisan = new BizCurrencySum(pSonotaseisanType, pSonotaseisanValue).toBizCurrency();
        yenkansanhaitoukin = new BizCurrencySum(pYenkansanhaitoukinType, pYenkansanhaitoukinValue).toBizCurrency();
        yensonotahaitoukin = new BizCurrencySum(pYensonotahaitoukinType, pYensonotahaitoukinValue).toBizCurrency();
        shrtuukagstszeigk = new BizCurrencySum(pShrtuukagstszeigkType, pShrtuukagstszeigkValue).toBizCurrency();
        zitkazukarikingksiteituuka = new BizCurrencySum(pZitkazukarikingksiteituukaType, pZitkazukarikingksiteituukaValue).toBizCurrency();
        shrgkkei = new BizCurrencySum(pShrgkkeiType, pShrgkkeiValue).toBizCurrency();
        shrtuukasyu = pShrtuukasyu;
        shrkwsrate = pShrkwsrate;
        bankcd = pBankcd;
        sitencd = pSitencd;
        banknmkj = pBanknmkj;
        sitennmkj = pSitennmkj;
        yokinkbn =  pYokinkbn;
        kouzano = pKouzano;
        kzsyuruikbn = pKzsyuruikbn;
        kzmeiginmkn = pKzmeiginmkn;
        htsiryosyukbn = pHtsiryosyukbn;
        synykngk = new BizCurrencySum(pSynykngkType, pSynykngkValue).toBizCurrency();
        htykeihi = new BizCurrencySum(pHtykeihiType, pHtykeihiValue).toBizCurrency();
        shrkykhtykeihi = new BizCurrencySum(pShrkykhtykeihiType, pShrkykhtykeihiValue).toBizCurrency();
        zeimunaiyouhensyuctrlkbn =  pZeimunaiyouhensyuctrlkbn;
        kykhnkkaisuu = pKykhnkkaisuu;
        kykmsnkbn = pKykmsnkbn;
        lastsyosaihkymd = pLastsyosaihkymd;
        tsinyno = pTsinyno;
        tsintelno = pTsintelno;
        tsinadr1kj = pTsinadr1kj;
        tsinadr2kj = pTsinadr2kj;
        tsinadr3kj = pTsinadr3kj;
        toritugisyasyozokunm = pToritugisyasyozokunm;
        toritugisyakjncd = pToritugisyakjncd;
        toritugisyanm = pToritugisyanm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
