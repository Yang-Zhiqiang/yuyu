package yuyu.batch.hozen.khinterf.khyuukouseingtuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 有効性確認ＮＧ通知Beanクラス <br />
 */
@AllArgsConstructor
public class KhYuukouseiNgTuutiBean implements Serializable {

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
    private String toiawasesosikinmkj;

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
    private String osirasemongon46keta1;

    @Getter
    @Setter
    private String osirasemongon46keta2;

    @Getter
    @Setter
    private String osirasemongon46keta3;

    @Getter
    @Setter
    private String osirasemongon46keta4;

    @Getter
    @Setter
    private String osirasemongon46keta5;

    @Getter
    @Setter
    private String osirasemongon46keta6;

    @Getter
    @Setter
    private String osirasemongon46keta7;

    @Getter
    @Setter
    private String osirasemongon46keta8;

    @Getter
    @Setter
    private String osirasemongon46keta9;

    @Getter
    @Setter
    private String osirasemongon46keta10;

    @Getter
    @Setter
    private String kyknmkj;

    @Getter
    @Setter
    private BizCurrency hokenryou;

    @Getter
    @Setter
    private String creditcardinfo1;

    @Getter
    @Setter
    private String creditcardinfo2;

    @Getter
    @Setter
    private String creditcardinfo3;

    @Getter
    @Setter
    private String creditcardmaskingmsg;

    @Getter
    @Setter
    private String goiraijikoutoumongon1;

    @Getter
    @Setter
    private String goiraijikoutoumongon2;

    @Getter
    @Setter
    private String goiraijikoutoumongon3;

    @Getter
    @Setter
    private String phrkmongon1;

    @Getter
    @Setter
    private String phrkmongon2;

    @Getter
    @Setter
    private String phrkmongon3;

    @Getter
    @Setter
    private String phrkmongon4;

    @Getter
    @Setter
    private String phrkmongon5;

    @Getter
    @Setter
    private String phrkmongon6;

    @Getter
    @Setter
    private String phrkmongon7;

    @Getter
    @Setter
    private String phrkmongon8;

    @Getter
    @Setter
    private String phrkmongon9;

    @Getter
    @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter
    @Setter
    private C_HassouKbn hassoukbn;

    public KhYuukouseiNgTuutiBean(String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd,
        String pShskyno,
        String pShsadr1kj,
        String pShsadr2kj,
        String pShsadr3kj,
        String pShsnmkj,
        String pToiawasesosikinmkj,
        String pToiawaseyno,
        String pToiawaseadr1kj,
        String pToiawaseadr2kj,
        String pToiawaseadr3kj,
        String pToiawasetelno,
        String pToiawaseteluktkkanou1,
        String pToiawaseteluktkkanou2,
        String pToiawasesosikinmkj2,
        String pToiawasetelno2,
        String pOsirasemongon46keta1,
        String pOsirasemongon46keta2,
        String pOsirasemongon46keta3,
        String pOsirasemongon46keta4,
        String pOsirasemongon46keta5,
        String pOsirasemongon46keta6,
        String pOsirasemongon46keta7,
        String pOsirasemongon46keta8,
        String pOsirasemongon46keta9,
        String pOsirasemongon46keta10,
        String pKyknmkj,
        String pHokenryouType,
        BigDecimal pHokenryouValue,
        String pCreditcardinfo1,
        String pCreditcardinfo2,
        String pCreditcardinfo3,
        String pCreditcardmaskingmsg,
        String pGoiraijikoutoumongon1,
        String pGoiraijikoutoumongon2,
        String pGoiraijikoutoumongon3,
        String pPhrkmongon1,
        String pPhrkmongon2,
        String pPhrkmongon3,
        String pPhrkmongon4,
        String pPhrkmongon5,
        String pPhrkmongon6,
        String pPhrkmongon7,
        String pPhrkmongon8,
        String pPhrkmongon9,
        C_SyoruiCdKbn pSyoruiCd,
        C_HassouKbn pHassoukbn){

        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
        shskyno = pShskyno;
        shsadr1kj = pShsadr1kj;
        shsadr2kj = pShsadr2kj;
        shsadr3kj = pShsadr3kj;
        shsnmkj = pShsnmkj;
        toiawasesosikinmkj = pToiawasesosikinmkj;
        toiawaseyno = pToiawaseyno;
        toiawaseadr1kj = pToiawaseadr1kj;
        toiawaseadr2kj = pToiawaseadr2kj;
        toiawaseadr3kj = pToiawaseadr3kj;
        toiawasetelno = pToiawasetelno;
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
        toiawasetelno2 = pToiawasetelno2;
        osirasemongon46keta1 = pOsirasemongon46keta1;
        osirasemongon46keta2 = pOsirasemongon46keta2;
        osirasemongon46keta3 = pOsirasemongon46keta3;
        osirasemongon46keta4 = pOsirasemongon46keta4;
        osirasemongon46keta5 = pOsirasemongon46keta5;
        osirasemongon46keta6 = pOsirasemongon46keta6;
        osirasemongon46keta7 = pOsirasemongon46keta7;
        osirasemongon46keta8 = pOsirasemongon46keta8;
        osirasemongon46keta9 = pOsirasemongon46keta9;
        osirasemongon46keta10 = pOsirasemongon46keta10;
        kyknmkj = pKyknmkj;
        hokenryou =  new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        creditcardinfo1 = pCreditcardinfo1;
        creditcardinfo2 = pCreditcardinfo2;
        creditcardinfo3 = pCreditcardinfo3;
        creditcardmaskingmsg = pCreditcardmaskingmsg;
        goiraijikoutoumongon1 = pGoiraijikoutoumongon1;
        goiraijikoutoumongon2 = pGoiraijikoutoumongon2;
        goiraijikoutoumongon3 = pGoiraijikoutoumongon3;
        phrkmongon1 = pPhrkmongon1;
        phrkmongon2 = pPhrkmongon2;
        phrkmongon3 = pPhrkmongon3;
        phrkmongon4 = pPhrkmongon4;
        phrkmongon5 = pPhrkmongon5;
        phrkmongon6 = pPhrkmongon6;
        phrkmongon7 = pPhrkmongon7;
        phrkmongon8 = pPhrkmongon8;
        phrkmongon9 = pPhrkmongon9;
        syoruiCd = pSyoruiCd;
        hassoukbn = pHassoukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
