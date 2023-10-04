package yuyu.batch.hozen.khinterf.khgnkumdhnflwcallfilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 インターフェイス 銀行窓販フォローコール対象Beanクラス
 */
public class KhFollowCallTaisyouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kykSakuinmeiNo;

    @Getter @Setter
    private BizDate kykSeiYmd;

    @Getter @Setter
    private String kykNmKj;

    @Getter @Setter
    private String kykNmKn;

    @Getter @Setter
    private String tsinTelNo;

    @Getter @Setter
    private String followCallSyoriKbn;

    @Getter @Setter
    private String tsinYno;

    @Getter @Setter
    private String tsinAdr1Kj;

    @Getter @Setter
    private String tsinAdr2Kj;

    @Getter @Setter
    private String tsinAdr3Kj;

    @Getter @Setter
    private String bsyujDrtenCd1;

    @Getter @Setter
    private String bsyujBosyuuCd1;

    @Getter @Setter
    private String bsyujDrtenCd2;

    @Getter @Setter
    private String bsyujBosyuuCd2;

    @Getter @Setter
    private String bsyujDrtenCd3;

    @Getter @Setter
    private String bsyujBosyuuCd3;

    @Getter @Setter
    private String bsyujDrtenCd4;

    @Getter @Setter
    private String bsyujBosyuuCd4;

    @Getter @Setter
    private String bsyujDrtenCd5;

    @Getter @Setter
    private String bsyujBosyuuCd5;

    @Getter @Setter
    private String saisinDrtenCd;

    @Getter @Setter
    private String saisinBosyuuCd;

    @Getter @Setter
    private String syouhnNm;

    @Getter @Setter
    private BizDate kykYmd;

    @Getter @Setter
    private BizDateYM jkipJytYm;

    @Getter @Setter
    private BizCurrency annaiGk;

    @Getter @Setter
    private C_Hrkkeiro hrkKeiro;

    @Getter @Setter
    private String fchrkKaisuu;

    @Getter @Setter
    private String anniSkCd;

    @Getter @Setter
    private String bankCd;

    @Getter @Setter
    private String sitenCd;

    @Getter @Setter
    private C_YokinKbn yokinKbn;

    @Getter @Setter
    private String kouzaNo;

    @Getter @Setter
    private String kzMeigiNmKn;

    @Getter @Setter
    private String hhknNmKj;

    @Getter @Setter
    private String hhknNmKn;

    @Getter @Setter
    private C_Hhknsei hhknSei;

    @Getter @Setter
    private BizDate hhknSeiYmd;

    @Getter @Setter
    private BizDateYM minyuYm;

    @Getter @Setter
    private String kykNmHnykKbn ;

    @Getter @Setter
    private String hhknNmHnykKbn;

    public KhFollowCallTaisyouDataBean(String pKbnkey,
        BizDate pSyoriYmd,
        String pSyono,
        String pKykSakuinmeiNo,
        BizDate pKykSeiYmd,
        String pKykNmKj,
        String pKykNmKn,
        String pTsinTelNo,
        String pFollowCallSyoriKbn,
        String pTsinYno,
        String pTsinAdr1Kj,
        String pTsinAdr2Kj,
        String pTsinAdr3Kj,
        String pSyujDrtenCd1,
        String pBsyujBosyuuCd1,
        String pBsyujDrtenCd2,
        String pBsyujBosyuuCd2,
        String pBsyujDrtenCd3,
        String pBsyujBosyuuCd3,
        String pBsyujDrtenCd4,
        String pBsyujBosyuuCd4,
        String pBsyujDrtenCd5,
        String pBsyujBosyuuCd5,
        String pSaisinDrtenCd,
        String pSaisinBosyuuCd,
        String pSyouhnNm,
        BizDate pKykYmd,
        BizDateYM pIkipJytYm,
        String pAnnaiGkType,
        BigDecimal pAnnaiGkValue,
        C_Hrkkeiro pHrkKeiro,
        String pFchrkKaisuu,
        String pAnniSkCd,
        String pBankCd,
        String pSitenCd,
        C_YokinKbn pYokinKbn,
        String pKouzaNo,
        String pKzMeigiNmKn,
        String pHhknNmKj,
        String pHhknNmKn,
        C_Hhknsei pHhknSei,
        BizDate pHhknSeiYmd,
        BizDateYM pMinyuYm,
        String pKykNmHnykKbn,
        String pHhknNmHnykKbn
        ) {
        kbnkey = pKbnkey;
        syoriYmd = pSyoriYmd;
        syono=pSyono;
        kykSakuinmeiNo=pKykSakuinmeiNo;
        kykSeiYmd=pKykSeiYmd;
        kykNmKj=pKykNmKj;
        kykNmKn=pKykNmKn;
        tsinTelNo=pTsinTelNo;
        followCallSyoriKbn=pFollowCallSyoriKbn;
        tsinYno=pTsinYno;
        tsinAdr1Kj=pTsinAdr1Kj;
        tsinAdr2Kj=pTsinAdr2Kj;
        tsinAdr3Kj=pTsinAdr3Kj;
        bsyujDrtenCd1=pSyujDrtenCd1;
        bsyujBosyuuCd1=pBsyujBosyuuCd1;
        bsyujDrtenCd2=pBsyujDrtenCd2;
        bsyujBosyuuCd2=pBsyujBosyuuCd2;
        bsyujDrtenCd3=pBsyujDrtenCd3;
        bsyujBosyuuCd3=pBsyujBosyuuCd3;
        bsyujDrtenCd4=pBsyujDrtenCd4;
        bsyujBosyuuCd4=pBsyujBosyuuCd4;
        bsyujDrtenCd5=pBsyujDrtenCd5;
        bsyujBosyuuCd5=pBsyujBosyuuCd5;
        saisinDrtenCd=pSaisinDrtenCd;
        saisinBosyuuCd=pSaisinBosyuuCd;
        syouhnNm=pSyouhnNm;
        kykYmd=pKykYmd;
        jkipJytYm=pIkipJytYm;
        annaiGk=new BizCurrencySum(pAnnaiGkType,pAnnaiGkValue).toBizCurrency();
        hrkKeiro=pHrkKeiro;
        fchrkKaisuu=pFchrkKaisuu;
        anniSkCd=pAnniSkCd;
        bankCd=pBankCd;
        sitenCd=pSitenCd;
        yokinKbn=pYokinKbn;
        kouzaNo=pKouzaNo;
        kzMeigiNmKn=pKzMeigiNmKn;
        hhknNmKj=pHhknNmKj;
        hhknNmKn=pHhknNmKn;
        hhknSei=pHhknSei;
        hhknSeiYmd=pHhknSeiYmd;
        minyuYm=pMinyuYm;
        kykNmHnykKbn=pKykNmHnykKbn;
        hhknNmHnykKbn=pHhknNmHnykKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}