package yuyu.batch.hozen.khinterf.khhrhnkanryotuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 契約保全 インターフェイス 手続完了（払方変更）データBeanクラス
 */
public class KhHrhnKanryoTuutiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private BizDate tyouhyouymd ;

    @Getter @Setter
    private String shskyno;

    @Getter @Setter
    private String shsadr1kj;

    @Getter @Setter
    private String shsadr2kj;

    @Getter @Setter
    private String shsadr3kj;

    @Getter @Setter
    private String shsnmkj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private String kouzamaskingmsg;

    @Getter @Setter
    private String hrkkaisuutkiktbrisyu;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizDateYM kouryokuhasseiym;

    @Getter @Setter
    private String msgarea34keta1;

    @Getter @Setter
    private String msgarea34keta2;

    @Getter @Setter
    private String msgarea34keta3;

    @Getter @Setter
    private String msgarea34keta4;

    @Getter @Setter
    private String msgarea34keta5;

    @Getter @Setter
    private String msgarea34keta6;

    @Getter @Setter
    private String msgarea34keta7;

    @Getter @Setter
    private String hrkykkmsg34keta1;

    @Getter @Setter
    private String hrkykkmsg34keta2;

    @Getter @Setter
    private String hrkykkmsg34keta3;

    @Getter @Setter
    private String hrkykkmsg34keta4;

    @Getter @Setter
    private String hrkykkmsg34keta5;

    @Getter @Setter
    private String hrkykkmsg34keta6;

    @Getter @Setter
    private String hrkykkmsg34keta7;

    @Getter @Setter
    private String hrkykkmsg34keta8;

    @Getter @Setter
    private String hrkykkmsg34keta9;

    @Getter @Setter
    private String hrkykkmsg34keta10;

    @Getter @Setter
    private String hrkykkmsg34keta11;

    @Getter @Setter
    private String hrkykkmsg34keta12;

    @Getter @Setter
    private String hrkykkmsg34keta13;

    @Getter @Setter
    private String hrkykkmsg34keta14;

    @Getter @Setter
    private String hrkykkmsg34keta15;

    @Getter @Setter
    private String hrkykkmsg34keta16;

    @Getter @Setter
    private String hrkykkmsg34keta17;

    @Getter @Setter
    private String hrkykkmsg34keta18;

    @Getter @Setter
    private String hrkykkmsg34keta19;

    @Getter @Setter
    private String hrkykkmsg34keta20;

    @Getter @Setter
    private String hrkykkmsg34keta21;

    @Getter @Setter
    private String hrkykkmsg34keta22;

    @Getter @Setter
    private String hrkykkmsg34keta23;

    @Getter @Setter
    private String hrkykkmsg34keta24;

    @Getter @Setter
    private String hrkykkmsg34keta25;

    @Getter @Setter
    private String hrkykkmsg34keta26;

    @Getter @Setter
    private String hrkykkmsg34keta27;

    @Getter @Setter
    private String hrkykkmsg34keta28;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String honsyakaisouriyuu;

    public KhHrhnKanryoTuutiBean(String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        C_SyoruiCdKbn pSyoruiCd,
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
        String pKouzamaskingmsg,
        String pHrkkaisuutkiktbrisyu,
        C_Hrkkeiro pHrkkeiro,
        String pType,
        BigDecimal pValue,
        BizDateYM pKouryokuhasseiym,
        String pMsgarea34keta1,
        String pMsgarea34keta2,
        String pMsgarea34keta3,
        String pMsgarea34keta4,
        String pMsgarea34keta5,
        String pMsgarea34keta6,
        String pMsgarea34keta7,
        String pHrkykkmsg34keta1,
        String pHrkykkmsg34keta2,
        String pHrkykkmsg34keta3,
        String pHrkykkmsg34keta4,
        String pHrkykkmsg34keta5,
        String pHrkykkmsg34keta6,
        String pHrkykkmsg34keta7,
        String pHrkykkmsg34keta8,
        String pHrkykkmsg34keta9,
        String pHrkykkmsg34keta10,
        String pHrkykkmsg34keta11,
        String pHrkykkmsg34keta12,
        String pHrkykkmsg34keta13,
        String pHrkykkmsg34keta14,
        String pHrkykkmsg34keta15,
        String pHrkykkmsg34keta16,
        String pHrkykkmsg34keta17,
        String pHrkykkmsg34keta18,
        String pHrkykkmsg34keta19,
        String pHrkykkmsg34keta20,
        String pHrkykkmsg34keta21,
        String pHrkykkmsg34keta22,
        String pHrkykkmsg34keta23,
        String pHrkykkmsg34keta24,
        String pHrkykkmsg34keta25,
        String pHrkykkmsg34keta26,
        String pHrkykkmsg34keta27,
        String pHrkykkmsg34keta28,
        C_HassouKbn pHassoukbn,
        String pHonsyakaisouriyuu) {

        kbnkey = pKbnkey;

        syono = pSyono;

        henkousikibetukey = pHenkousikibetukey;

        syoruiCd = pSyoruiCd;

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

        kouzamaskingmsg = pKouzamaskingmsg;

        hrkkaisuutkiktbrisyu = pHrkkaisuutkiktbrisyu;

        hrkkeiro = pHrkkeiro;

        hrkp = new BizCurrencySum(pType, pValue).toBizCurrency();

        kouryokuhasseiym = pKouryokuhasseiym;

        msgarea34keta1 = pMsgarea34keta1;

        msgarea34keta2 = pMsgarea34keta2;

        msgarea34keta3 = pMsgarea34keta3;

        msgarea34keta4 = pMsgarea34keta4;

        msgarea34keta5 = pMsgarea34keta5;

        msgarea34keta6 = pMsgarea34keta6;

        msgarea34keta7 = pMsgarea34keta7;

        hrkykkmsg34keta1 = pHrkykkmsg34keta1;

        hrkykkmsg34keta2 = pHrkykkmsg34keta2;

        hrkykkmsg34keta3 = pHrkykkmsg34keta3;

        hrkykkmsg34keta4 = pHrkykkmsg34keta4;

        hrkykkmsg34keta5 = pHrkykkmsg34keta5;

        hrkykkmsg34keta6 = pHrkykkmsg34keta6;

        hrkykkmsg34keta7 = pHrkykkmsg34keta7;

        hrkykkmsg34keta8 = pHrkykkmsg34keta8;

        hrkykkmsg34keta9 = pHrkykkmsg34keta9;

        hrkykkmsg34keta10 = pHrkykkmsg34keta10;

        hrkykkmsg34keta11 = pHrkykkmsg34keta11;

        hrkykkmsg34keta12 = pHrkykkmsg34keta12;

        hrkykkmsg34keta13 = pHrkykkmsg34keta13;

        hrkykkmsg34keta14 = pHrkykkmsg34keta14;

        hrkykkmsg34keta15 = pHrkykkmsg34keta15;

        hrkykkmsg34keta16 = pHrkykkmsg34keta16;

        hrkykkmsg34keta17 = pHrkykkmsg34keta17;

        hrkykkmsg34keta18 = pHrkykkmsg34keta18;

        hrkykkmsg34keta19 = pHrkykkmsg34keta19;

        hrkykkmsg34keta20 = pHrkykkmsg34keta20;

        hrkykkmsg34keta21 = pHrkykkmsg34keta21;

        hrkykkmsg34keta22 = pHrkykkmsg34keta22;

        hrkykkmsg34keta23 = pHrkykkmsg34keta23;

        hrkykkmsg34keta24 = pHrkykkmsg34keta24;

        hrkykkmsg34keta25 = pHrkykkmsg34keta25;

        hrkykkmsg34keta26 = pHrkykkmsg34keta26;

        hrkykkmsg34keta27 = pHrkykkmsg34keta27;

        hrkykkmsg34keta28 = pHrkykkmsg34keta28;

        hassoukbn = pHassoukbn;

        honsyakaisouriyuu = pHonsyakaisouriyuu;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
