package yuyu.batch.hozen.khinterf.khseihowebdrtenminyuudtlfsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DrtenChannelSyurui;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ用未入明細Beanクラス<br />
 */
public class SeihoWebMinyuuDtlBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDateYM syoriym;

    @Getter
    @Setter
    private String bosyuucd;

    @Getter
    @Setter
    private BizDateYM pjytym;

    @Getter
    @Setter
    private BizDate keiyakuymd;

    @Getter
    @Setter
    private BizDateYM bosyuuym;

    @Getter
    @Setter
    private String hjnkykhyj;

    @Getter
    @Setter
    private String drtenkanrisosikicd;

    @Getter
    @Setter
    private C_DrtenChannelSyurui bosyuudairitengyousyukbn;

    @Getter
    @Setter
    private String drtencd;

    @Getter
    @Setter
    private String cifcd;

    @Getter
    @Setter
    private String atesakinm;

    @Getter
    @Setter
    private String minyujytymdyofuri;

    @Getter
    @Setter
    private String minyujytymdyofuriigi;

    @Getter
    @Setter
    private String hassinka;

    @Getter
    @Setter
    private String telno;

    @Getter
    @Setter
    private String tntnm10keta;

    @Getter
    @Setter
    private String kydatkikbnkj;

    @Getter
    @Setter
    private String kyknm35keta;

    @Getter
    @Setter
    private String hrkkaisuukj;

    @Getter
    @Setter
    private String hrkkeirokj;

    @Getter
    @Setter
    private BizCurrency hrkp;

    @Getter
    @Setter
    private String knkimnyuuryu;

    @Getter
    @Setter
    private String jikaiminyuuji;

    @Getter
    @Setter
    private String tntusygyouhaiinfo;

    @Getter
    @Setter
    private String hrkkeirobtjhmidasi;

    @Getter
    @Setter
    private String hrkkeirobtjh;

    @Getter
    @Setter
    private String hknsyuruinm30keta;

    @Getter
    @Setter
    private BizDateYM dbskyoteiym;

    public SeihoWebMinyuuDtlBean(
        String pKbnkey,
        String pSyono,
        BizDateYM pSyoriym,
        String pBosyuucd,
        BizDateYM pPjytym,
        BizDate pKeiyakuymd,
        BizDateYM pBosyuuym,
        String pHjnkykhyj,
        String pDrtenkanrisosikicd,
        C_DrtenChannelSyurui pBosyuudairitengyousyukbn,
        String pDrtencd,
        String pCifcd,
        String pAtesakinm,
        String pMinyujytymdyofuri,
        String pMinyujytymdyofuriigi,
        String pHassinka,
        String pTelno,
        String pTntnm10keta,
        String pKydatkikbnkj,
        String pKyknm35keta,
        String pHrkkaisuukj,
        String pHrkkeirokj,
        String pHrkpType,
        BigDecimal pHrkpValue,
        String pKnkimnyuuryu,
        String pJikaiminyuuji,
        String pTntusygyouhaiinfo,
        String pHrkkeirobtjhmidasi,
        String pHrkkeirobtjh,
        String pHknsyuruinm30keta,
        BizDateYM pDbskyoteiym) {

        kbnkey = pKbnkey;
        syono = pSyono;
        syoriym = pSyoriym;
        bosyuucd = pBosyuucd;
        pjytym = pPjytym;
        keiyakuymd = pKeiyakuymd;
        bosyuuym = pBosyuuym;
        hjnkykhyj = pHjnkykhyj;
        drtenkanrisosikicd = pDrtenkanrisosikicd;
        bosyuudairitengyousyukbn = pBosyuudairitengyousyukbn;
        drtencd = pDrtencd;
        cifcd = pCifcd;
        atesakinm = pAtesakinm;
        minyujytymdyofuri = pMinyujytymdyofuri;
        minyujytymdyofuriigi = pMinyujytymdyofuriigi;
        hassinka = pHassinka;
        telno = pTelno;
        tntnm10keta = pTntnm10keta;
        kydatkikbnkj = pKydatkikbnkj;
        kyknm35keta = pKyknm35keta;
        hrkkaisuukj = pHrkkaisuukj;
        hrkkeirokj = pHrkkeirokj;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        knkimnyuuryu = pKnkimnyuuryu;
        jikaiminyuuji = pJikaiminyuuji;
        tntusygyouhaiinfo = pTntusygyouhaiinfo;
        hrkkeirobtjhmidasi = pHrkkeirobtjhmidasi;
        hrkkeirobtjh = pHrkkeirobtjh;
        hknsyuruinm30keta = pHknsyuruinm30keta;
        dbskyoteiym = pDbskyoteiym;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
