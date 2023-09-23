package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_SinsakuseiKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;

/**
 * 契約保全 契約保全共通 控除証明書作成用パラメータ
 */
public class EditKoujyoSyoumeiParam {

    private C_SinsakuseiKbn sinkiSakusei;
    private String koujyoNendo;
    private C_KoujyosyoumeisyuKbn koujyoSyuKbn;
    private C_KoujyosyoumeisakuseisyoriKbn koujyoSakuseiSyoriKbn;
    private C_KoujyosyoumeisentakuKbn koujyosyoumeisentakuKbn;
    private BizDate syoumeiYmd;
    private C_Hrkkaisuu hrkkaisuu;
    private C_TekiyouseidoKbn tekiyouSeidoKbn;
    private BizDateYM syoumeiStartYm;
    private BizDateYM syoumeiEndYm;
    private BizCurrency oldIppanJissekiP          = BizCurrency.valueOf(0);
    private BizCurrency oldIppanNenkanP           = BizCurrency.valueOf(0);
    private BizCurrency oldIppanJissekiHaitoukin  = BizCurrency.valueOf(0);
    private BizCurrency oldIppanNenkanHaitoukin   = BizCurrency.valueOf(0);
    private BizCurrency oldIppanJissekiSyoumeigk  = BizCurrency.valueOf(0);
    private BizCurrency oldIppanNenkanSyoumeigk   = BizCurrency.valueOf(0);
    private BizCurrency newIppanJissekiP          = BizCurrency.valueOf(0);
    private BizCurrency newIppanNenkanP           = BizCurrency.valueOf(0);
    private BizCurrency newIppanJissekiHaitoukin  = BizCurrency.valueOf(0);
    private BizCurrency newIppanNenkanHaitoukin   = BizCurrency.valueOf(0);
    private BizCurrency newIppanJissekiSyoumeigk  = BizCurrency.valueOf(0);
    private BizCurrency newIppanNenkanSyoumeigk   = BizCurrency.valueOf(0);
    private BizCurrency newIryouJissekiP          = BizCurrency.valueOf(0);
    private BizCurrency newIryouNenkanP           = BizCurrency.valueOf(0);
    private BizCurrency newIryouJissekiHaitoukin  = BizCurrency.valueOf(0);
    private BizCurrency newIryouNenkanHaitoukin   = BizCurrency.valueOf(0);
    private BizCurrency newIryouJissekiSyoumeigk  = BizCurrency.valueOf(0);
    private BizCurrency newIryouNenkanSyoumeigk   = BizCurrency.valueOf(0);
    private BizCurrency newNenkinJissekiP         = BizCurrency.valueOf(0);
    private BizCurrency newNenkinNenkanP          = BizCurrency.valueOf(0);
    private BizCurrency newNenkinJissekiHaitoukin = BizCurrency.valueOf(0);
    private BizCurrency newNenkinNenkanHaitoukin  = BizCurrency.valueOf(0);
    private BizCurrency newNenkinJissekiSyoumeigk = BizCurrency.valueOf(0);
    private BizCurrency newNenkinNenkanSyoumeigk  = BizCurrency.valueOf(0);
    private C_SaihkHyjKbn saihkhyjkbn;
    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgKbn;

    public EditKoujyoSyoumeiParam() {
        super();
    }

    public C_SinsakuseiKbn getSinkiSakusei() {
        return sinkiSakusei;
    }

    public void setSinkiSakusei(C_SinsakuseiKbn pSinkiSakusei) {
        sinkiSakusei = pSinkiSakusei;
    }

    public String getKoujyoNendo() {
        return koujyoNendo;
    }

    public void setKoujyoNendo(String pKoujyoNendo) {
        koujyoNendo = pKoujyoNendo;
    }

    public C_KoujyosyoumeisyuKbn getKoujyoSyuKbn() {
        return koujyoSyuKbn;
    }

    public void setKoujyoSyuKbn(C_KoujyosyoumeisyuKbn pKoujyoSyuKbn) {
        koujyoSyuKbn = pKoujyoSyuKbn;
    }

    public C_KoujyosyoumeisakuseisyoriKbn getKoujyoSakuseiSyoriKbn() {
        return koujyoSakuseiSyoriKbn;
    }

    public void setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisakuseisyoriKbn pKoujyoSakuseiSyoriKbn) {
        koujyoSakuseiSyoriKbn = pKoujyoSakuseiSyoriKbn;
    }

    public C_KoujyosyoumeisentakuKbn getKoujyosyoumeisentakuKbn() {
        return koujyosyoumeisentakuKbn;
    }

    public void setKoujyoSakuseiSyoriKbn(C_KoujyosyoumeisentakuKbn pKoujyosyoumeisentakuKbn) {
        koujyosyoumeisentakuKbn = pKoujyosyoumeisentakuKbn;
    }

    public BizDate getSyoumeiYmd() {
        return syoumeiYmd;
    }

    public void setSyoumeiYmd(BizDate pSyoumeiYmd) {
        syoumeiYmd = pSyoumeiYmd;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public C_TekiyouseidoKbn getTekiyouSeidoKbn() {
        return tekiyouSeidoKbn;
    }

    public void setTekiyouSeidoKbn(C_TekiyouseidoKbn pTekiyouSeidoKbn) {
        tekiyouSeidoKbn = pTekiyouSeidoKbn;
    }

    public BizDateYM getSyoumeiStartYm() {
        return syoumeiStartYm;
    }

    public void setSyoumeiStartYm(BizDateYM pSyoumeiStartYm) {
        syoumeiStartYm = pSyoumeiStartYm;
    }

    public BizDateYM getSyoumeiEndYm() {
        return syoumeiEndYm;
    }

    public void setSyoumeiEndYm(BizDateYM pSyoumeiEndYm) {
        syoumeiEndYm = pSyoumeiEndYm;
    }

    public BizCurrency getOldIppanJissekiP() {
        return oldIppanJissekiP;
    }

    public void setOldIppanJissekiP(BizCurrency pOldIppanJissekiP) {
        oldIppanJissekiP = pOldIppanJissekiP;
    }

    public BizCurrency getOldIppanNenkanP() {
        return oldIppanNenkanP;
    }

    public void setOldIppanNenkanP(BizCurrency pOldIppanNenkanP) {
        oldIppanNenkanP = pOldIppanNenkanP;
    }

    public BizCurrency getOldIppanJissekiHaitoukin() {
        return oldIppanJissekiHaitoukin;
    }

    public void setOldIppanJissekiHaitoukin(BizCurrency pOldIppanJissekiHaitoukin) {
        oldIppanJissekiHaitoukin = pOldIppanJissekiHaitoukin;
    }

    public BizCurrency getOldIppanNenkanHaitoukin() {
        return oldIppanNenkanHaitoukin;
    }

    public void setOldIppanNenkanHaitoukin(BizCurrency pOldIppanNenkanHaitoukin) {
        oldIppanNenkanHaitoukin = pOldIppanNenkanHaitoukin;
    }

    public BizCurrency getOldIppanJissekiSyoumeigk() {
        return oldIppanJissekiSyoumeigk;
    }

    public void setOldIppanJissekiSyoumeigk(BizCurrency pOldIppanJissekiSyoumeigk) {
        oldIppanJissekiSyoumeigk = pOldIppanJissekiSyoumeigk;
    }

    public BizCurrency getOldIppanNenkanSyoumeigk() {
        return oldIppanNenkanSyoumeigk;
    }

    public void setOldIppanNenkanSyoumeigk(BizCurrency pOldIppanNenkanSyoumeigk) {
        oldIppanNenkanSyoumeigk = pOldIppanNenkanSyoumeigk;
    }

    public BizCurrency getNewIppanJissekiP() {
        return newIppanJissekiP;
    }

    public void setNewIppanJissekiP(BizCurrency pNewIppanJissekiP) {
        newIppanJissekiP = pNewIppanJissekiP;
    }

    public BizCurrency getNewIppanNenkanP() {
        return newIppanNenkanP;
    }

    public void setNewIppanNenkanP(BizCurrency pNewIppanNenkanP) {
        newIppanNenkanP = pNewIppanNenkanP;
    }

    public BizCurrency getNewIppanJissekiHaitoukin() {
        return newIppanJissekiHaitoukin;
    }

    public void setNewIppanJissekiHaitoukin(BizCurrency pNewIppanJissekiHaitoukin) {
        newIppanJissekiHaitoukin = pNewIppanJissekiHaitoukin;
    }

    public BizCurrency getNewIppanNenkanHaitoukin() {
        return newIppanNenkanHaitoukin;
    }

    public void setNewIppanNenkanHaitoukin(BizCurrency pNewIppanNenkanHaitoukin) {
        newIppanNenkanHaitoukin = pNewIppanNenkanHaitoukin;
    }

    public BizCurrency getNewIppanJissekiSyoumeigk() {
        return newIppanJissekiSyoumeigk;
    }

    public void setNewIppanJissekiSyoumeigk(BizCurrency pNewIppanJissekiSyoumeigk) {
        newIppanJissekiSyoumeigk = pNewIppanJissekiSyoumeigk;
    }

    public BizCurrency getNewIppanNenkanSyoumeigk() {
        return newIppanNenkanSyoumeigk;
    }

    public void setNewIppanNenkanSyoumeigk(BizCurrency pNewIppanNenkanSyoumeigk) {
        newIppanNenkanSyoumeigk = pNewIppanNenkanSyoumeigk;
    }

    public BizCurrency getNewIryouJissekiP() {
        return newIryouJissekiP;
    }

    public void setNewIryouJissekiP(BizCurrency pNewIryouJissekiP) {
        newIryouJissekiP = pNewIryouJissekiP;
    }

    public BizCurrency getNewIryouNenkanP() {
        return newIryouNenkanP;
    }

    public void setNewIryouNenkanP(BizCurrency pNewIryouNenkanP) {
        newIryouNenkanP = pNewIryouNenkanP;
    }

    public BizCurrency getNewIryouJissekiHaitoukin() {
        return newIryouJissekiHaitoukin;
    }

    public void setNewIryouJissekiHaitoukin(BizCurrency pNewIryouJissekiHaitoukin) {
        newIryouJissekiHaitoukin = pNewIryouJissekiHaitoukin;
    }

    public BizCurrency getNewIryouNenkanHaitoukin() {
        return newIryouNenkanHaitoukin;
    }

    public void setNewIryouNenkanHaitoukin(BizCurrency pNewIryouNenkanHaitoukin) {
        newIryouNenkanHaitoukin = pNewIryouNenkanHaitoukin;
    }

    public BizCurrency getNewIryouJissekiSyoumeigk() {
        return newIryouJissekiSyoumeigk;
    }

    public void setNewIryouJissekiSyoumeigk(BizCurrency pNewIryouJissekiSyoumeigk) {
        newIryouJissekiSyoumeigk = pNewIryouJissekiSyoumeigk;
    }

    public BizCurrency getNewIryouNenkanSyoumeigk() {
        return newIryouNenkanSyoumeigk;
    }

    public void setNewIryouNenkanSyoumeigk(BizCurrency pNewIryouNenkanSyoumeigk) {
        newIryouNenkanSyoumeigk = pNewIryouNenkanSyoumeigk;
    }

    public BizCurrency getNewNenkinJissekiP() {
        return newNenkinJissekiP;
    }

    public void setNewNenkinJissekiP(BizCurrency pNewNenkinJissekiP) {
        newNenkinJissekiP = pNewNenkinJissekiP;
    }

    public BizCurrency getNewNenkinNenkanP() {
        return newNenkinNenkanP;
    }

    public void setNewNenkinNenkanP(BizCurrency pNewNenkinNenkanP) {
        newNenkinNenkanP = pNewNenkinNenkanP;
    }

    public BizCurrency getNewNenkinJissekiHaitoukin() {
        return newNenkinJissekiHaitoukin;
    }

    public void setNewNenkinJissekiHaitoukin(BizCurrency pNewNenkinJissekiHaitoukin) {
        newNenkinJissekiHaitoukin = pNewNenkinJissekiHaitoukin;
    }

    public BizCurrency getNewNenkinNenkanHaitoukin() {
        return newNenkinNenkanHaitoukin;
    }

    public void setNewNenkinNenkanHaitoukin(BizCurrency pNewNenkinNenkanHaitoukin) {
        newNenkinNenkanHaitoukin = pNewNenkinNenkanHaitoukin;
    }

    public BizCurrency getNewNenkinJissekiSyoumeigk() {
        return newNenkinJissekiSyoumeigk;
    }

    public void setNewNenkinJissekiSyoumeigk(BizCurrency pNewNenkinJissekiSyoumeigk) {
        newNenkinJissekiSyoumeigk = pNewNenkinJissekiSyoumeigk;
    }

    public BizCurrency getNewNenkinNenkanSyoumeigk() {
        return newNenkinNenkanSyoumeigk;
    }

    public void setNewNenkinNenkanSyoumeigk(BizCurrency pNewNenkinNenkanSyoumeigk) {
        newNenkinNenkanSyoumeigk = pNewNenkinNenkanSyoumeigk;
    }

    public C_SaihkHyjKbn getSaihkhyjkbn() {
        return saihkhyjkbn;
    }

    public void setSaihkhyjkbn(C_SaihkHyjKbn pSaihkhyjkbn) {
        saihkhyjkbn = pSaihkhyjkbn;
    }

    public C_KoujyosyoumeimsgKbn getKoujyosyoumeimsgKbn() {
        return koujyosyoumeimsgKbn;
    }

    public void setKoujyosyoumeimsgKbn(C_KoujyosyoumeimsgKbn pKoujyosyoumeimsgKbn) {
        koujyosyoumeimsgKbn = pKoujyosyoumeimsgKbn;
    }
}
