package yuyu.common.hozen.haitou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 配当 Dレート年度回数設定
 */
public class SetDNnd extends BaseDCommon {

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "期間不正", "期間（自） > 期間（至） or 期間（至）－ 期間（自）＞ １年");
    }

    public DRateBean exec(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        Integer pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        Integer pHknkkn,
        Integer pHrkkkn,
        C_Kykjyoutai pKykjyoutai,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        C_Tuukasyu pTuukasyu,
        Integer pDai1hknkkn,
        BizDate pDretokijyunymd,
        BizDate pKykymd,
        BizDate pYendthnkymd,
        BizDateY pCalckijyunYmdTyokuzenHaitounendo,
        BizDate pCalckijyunymd,
        BizDate pSyoriYmd,
        C_UmuKbn pKessanumu) {

        logger.debug("▽ Ｄレート年度設定（パラメータ版） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            BizDateY dRateNenndo = dRateNenndoKeisan(pDretokijyunymd);

            NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = getInjectInstance(NaiteiKakuteiRateHantei.class);
            C_ErrorKbn errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, dRateNenndo, pKessanumu);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(naiteiKakuteiRateHantei);

                logger.debug("△ Ｄレート年度設定（パラメータ版） 終了");

                return null;
            }

            C_NaiteiKakuteiKbn naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

            DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateSyutokuZyoukenSakusei(
                pSyouhncd,
                pRyouritusdno,
                pYoteiriritu,
                pHrkkaisuu,
                pHhknsei,
                pHhknnen,
                pHknkknsmnkbn,
                pHknkkn,
                pHrkkkn,
                pKykjyoutai,
                pCalckijyunymd,
                pKykymd,
                pHrkkknsmnkbn,
                pTuukasyu,
                pDai1hknkkn,
                dRateNenndo,
                naiteiKakuteiKbn);

            List<HaitouKaisuuBean> haitouKaisuuBeanLst = setKeisanKikan(pKykymd, pYendthnkymd,
                pCalckijyunYmdTyokuzenHaitounendo, pCalckijyunymd);

            if (haitouKaisuuBeanLst == null) {

                logger.debug("△ Ｄレート年度設定（パラメータ版） 終了");

                return null;
            }

            DRateBean dRateBean = new DRateBean();
            dRateBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);
            dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

            logger.debug("△ Ｄレート年度設定（パラメータ版） 終了");

            return dRateBean;

        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public DRateBean exec(
        IT_KykKihon pKykKihon,
        IT_KykSyouhn pKykSyouhn,
        BizDate pDretokijyunymd,
        BizDate pCalckijyunymd,
        BizDate pSyoriYmd,
        C_UmuKbn pKessanumu) {

        logger.debug("▽ Ｄレート年度設定（エンティティ版） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            BizDateY pCalckijyunYmdTyokuzenHaitounendo = getKeisanKijunbiTyokuzenHaitounendo(pKykSyouhn.getSyono(),
                pKykSyouhn.getKykymd(),  pCalckijyunymd);
            if (pCalckijyunYmdTyokuzenHaitounendo == null) {
                logger.debug("△ Ｄレート年度設定（エンティティ版） 終了");
                return null;
            }

            DRateBean dRateBean = exec(pKykSyouhn.getSyouhncd(),
                pKykSyouhn.getRyouritusdno(),
                pKykSyouhn.getYoteiriritu(),
                pKykKihon.getHrkkaisuu(),
                pKykSyouhn.getHhknsei(),
                pKykSyouhn.getHhknnen(),
                pKykSyouhn.getHknkknsmnkbn(),
                pKykSyouhn.getHknkkn(),
                pKykSyouhn.getHrkkkn(),
                pKykSyouhn.getKykjyoutai(),
                pKykSyouhn.getHrkkknsmnkbn(),
                pKykSyouhn.getKyktuukasyu(),
                pKykSyouhn.getDai1hknkkn(),
                pDretokijyunymd,
                pKykSyouhn.getKykymd(),
                pKykSyouhn.getYendthnkymd(),
                pCalckijyunYmdTyokuzenHaitounendo,
                pCalckijyunymd,
                pSyoriYmd,
                pKessanumu);

            logger.debug("△ Ｄレート年度設定（エンティティ版） 終了");

            return dRateBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        BizDateY pCalckijyunYmdTyokuzenHaitounendo,
        BizDate pCalckijyunymd) {

        logger.debug("▽ Ｄレート年度設定（期間取得のみ版[配当年度]） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            List<HaitouKaisuuBean> haitouKaisuuBeanLst = setKeisanKikan(pKykymd, pYendthnkymd,
                pCalckijyunYmdTyokuzenHaitounendo, pCalckijyunymd);

            if (haitouKaisuuBeanLst == null) {

                logger.debug("△ Ｄレート年度設定（期間取得のみ版[配当年度]） 終了");

                return null;
            }

            DRateBean dRateBean = new DRateBean();
            dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);

            logger.debug("△ Ｄレート年度設定（期間取得のみ版[配当年度]） 終了");

            return dRateBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        String  pSyono,
        BizDate pCalckijyunymd) {

        logger.debug("▽ Ｄレート年度設定（期間取得のみ版[証券番号]） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();
        clear();

        try {
            BizDateY pCalckijyunYmdTyokuzenHaitounendo = getKeisanKijunbiTyokuzenHaitounendo(pSyono, pKykymd,  pCalckijyunymd);
            if (pCalckijyunYmdTyokuzenHaitounendo == null) {
                logger.debug("△ Ｄレート年度設定（期間取得のみ版[証券番号]） 終了");
                return null;
            }

            DRateBean dRateBean = exec(pKykymd, pYendthnkymd, pCalckijyunYmdTyokuzenHaitounendo, pCalckijyunymd);

            logger.debug("△ Ｄレート年度設定（期間取得のみ版[証券番号]） 終了");

            return dRateBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        IT_KhHaitouKanri tyokuzenHaitouKanri,
        BizDate pCalckijyunymd) {

        logger.debug("▽ Ｄレート年度設定（期間取得のみ版[配当管理ＴＢＬエンティティ]） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            BizDateY calckijyunYmdTyokuzenHaitounendo;
            if (tyokuzenHaitouKanri == null) {
                calckijyunYmdTyokuzenHaitounendo = null;
            }
            else {
                calckijyunYmdTyokuzenHaitounendo = tyokuzenHaitouKanri.getHaitounendo();
            }

            DRateBean dRateBean = exec(pKykymd, pYendthnkymd, calckijyunYmdTyokuzenHaitounendo, pCalckijyunymd);

            logger.debug("△ Ｄレート年度設定（期間取得のみ版[配当管理ＴＢＬエンティティ]） 終了");

            return dRateBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public DRateBean exec(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        IT_KhTumitateDKanri tyokuzenTumitateDKanri,
        BizDate pCalckijyunymd) {

        logger.debug("▽ Ｄレート年度設定（期間取得のみ版[積立Ｄ管理ＴＢＬエンティティ]） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            BizDateY calckijyunYmdTyokuzenHaitounendo;
            if (tyokuzenTumitateDKanri == null) {
                calckijyunYmdTyokuzenHaitounendo = null;
            } else {
                SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

                calckijyunYmdTyokuzenHaitounendo  = setKessanNensibi.exec(
                    tyokuzenTumitateDKanri.getTumitatedtumitateymd()).getBizDateY();
            }

            DRateBean dRateBean = exec(pKykymd, pYendthnkymd, calckijyunYmdTyokuzenHaitounendo, pCalckijyunymd);

            logger.debug("△ Ｄレート年度設定（期間取得のみ版[積立Ｄ管理ＴＢＬエンティティ]） 終了");

            return dRateBean;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }
    public BizDateY getKeisanKijunbiTyokuzenHaitounendo(String pSyono, BizDate pKykymd, BizDate pCalckijyunymd) {

        DBAccessDCommon dbaDc = getInjectInstance(DBAccessDCommon.class);
        C_ErrorKbn errorKbn = dbaDc.getKijyunymdTykzenHaitouKanriSyu(pSyono, pCalckijyunymd);
        if (C_ErrorKbn.ERROR.equals(errorKbn)) {

            setErrorLink(dbaDc);

            return null;
        }
        IT_KhHaitouKanri hitouKanriEntity = dbaDc.getKhHaitouKanri();

        if (hitouKanriEntity == null) {

            return calcKykymdHaiouNendo(pKykymd);

        }
        else {

            return hitouKanriEntity.getHaitounendo();
        }
    }

    private BizDateY calcKykymdHaiouNendo(BizDate pKykymd) {
        SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);
        HokenNndBean hokenNndBean = setHokenNnd.exec(pKykymd, pKykymd);

        if (hokenNndBean == null) {

            setErrorLink(setHokenNnd);

            return null;
        }

        return hokenNndBean.getHokenNnd();
    }

    private BizDateY dRateNenndoKeisan(BizDate pDretokijyunymd) {

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDateY dRetoNendo = setKessanNensibi.exec(pDretokijyunymd).getBizDateY();

        return dRetoNendo;
    }

    private DRateSyutokuInfoBean dRateSyutokuZyoukenSakusei(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hhknsei pHhknsei,
        Integer pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        Integer pHknkkn,
        Integer pHrkkkn,
        C_Kykjyoutai pKykjyoutai,
        BizDate pCalckijyunymd,
        BizDate pKykymd,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        C_Tuukasyu pTuukasyu,
        Integer pDai1hknkkn,
        BizDateY pDretonendo,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn) {

        C_Kykjyoutai kykjyoutai = henkanKykjyoutai(pKykjyoutai, pCalckijyunymd, pKykymd, pHhknnen, pHrkkkn, pHrkkknsmnkbn);

        DRateSyutokuInfoBean dRateSyutokuInfoBean = new DRateSyutokuInfoBean();
        dRateSyutokuInfoBean.setSyouhncd(pSyouhncd);
        dRateSyutokuInfoBean.setRyouritusdno(pRyouritusdno);
        dRateSyutokuInfoBean.setYoteiriritu(pYoteiriritu);
        dRateSyutokuInfoBean.setHrkkaisuu(pHrkkaisuu);
        dRateSyutokuInfoBean.setHhknsei(pHhknsei);
        dRateSyutokuInfoBean.setHhknnen(pHhknnen);
        dRateSyutokuInfoBean.setHknkknsmnkbn(pHknkknsmnkbn);
        dRateSyutokuInfoBean.setHknkkn(pHknkkn);
        dRateSyutokuInfoBean.setHrkkkn(pHrkkkn);
        dRateSyutokuInfoBean.setKykjyoutai(kykjyoutai);
        dRateSyutokuInfoBean.setTuukasyu(pTuukasyu);
        dRateSyutokuInfoBean.setDai1hknkkn(pDai1hknkkn);
        dRateSyutokuInfoBean.setDratenendo(pDretonendo);
        dRateSyutokuInfoBean.setNaiteikakuteikbn(pNaiteikakuteikbn);

        return dRateSyutokuInfoBean;
    }

    private List<HaitouKaisuuBean> setKeisanKikan(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        BizDateY pCalckijyunYmdTyokuzenHaitounendo,
        BizDate pCalckijyunymd) {

        BizDate haitouSiharaiKijyunymd = null;
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        if (pCalckijyunYmdTyokuzenHaitounendo == null) {
            pCalckijyunYmdTyokuzenHaitounendo = calcKykymdHaiouNendo(pKykymd);
        }

        if (pYendthnkymd == null) {
            haitouSiharaiKijyunymd = pKykymd;
        }
        else {
            haitouSiharaiKijyunymd = pYendthnkymd;
        }

        if (BizDateUtil.compareYmd(pCalckijyunymd, haitouSiharaiKijyunymd) == BizDateUtil.COMPARE_LESSER ) {

            return haitouKaisuuBeanLst;
        }

        HaitouKaisuuBean haitouKaisuuBean = new HaitouKaisuuBean();

        haitouKaisuuBean = haitouKeisanKikanKeisan(haitouSiharaiKijyunymd, pCalckijyunymd,
            pCalckijyunYmdTyokuzenHaitounendo, haitouKaisuuBean);

        if (haitouKaisuuBean == null) {

            return null;
        }

        haitouKaisuuBean = haitouKaisuKeisan(pKykymd, haitouKaisuuBean);

        if (haitouKaisuuBean == null) {

            return null;
        }

        haitouKaisuuBeanLst = houganKikanSettei(pKykymd, haitouKaisuuBean);

        haitouKaisuuBeanLst = keikatukisuSettei(pKykymd, pYendthnkymd, haitouKaisuuBeanLst);

        if (logger.isDebugEnabled()) {
            for (HaitouKaisuuBean bean : haitouKaisuuBeanLst) {
                logger.debug("｜ ▽ 配当回数Bean");
                logger.debug("｜ ｜ 期間（自） ＝ " + bean.getKikanfrom().toString());
                logger.debug("｜ ｜ 期間（至） ＝ " + bean.getKikanto().toString());
                logger.debug("｜ ｜ 経過月数   ＝ " + bean.getKeikamon().toString());
                logger.debug("｜ ｜ 配当回数   ＝ " + bean.getHaitoukaisuu().toString());
                logger.debug("｜ △");
            }
        }

        return haitouKaisuuBeanLst;
    }

    private HaitouKaisuuBean haitouKeisanKikanKeisan(
        BizDate pHaitouSiharaiKijyunymd,
        BizDate pCalckijyunymd,
        BizDateY pCalckijyunYmdTyokuzenHaitounendo,
        HaitouKaisuuBean pHaitouKaisuuBean) {

        BizDate keisankijunbiTyokuzenOutouYmd = calcHaitouSiharaiYmdForNendo(pHaitouSiharaiKijyunymd, pCalckijyunYmdTyokuzenHaitounendo);

        if (checkKikannHusei(keisankijunbiTyokuzenOutouYmd, pCalckijyunymd)) {

            setErrorInfo("001");

            return null;
        }

        pHaitouKaisuuBean.setKikanfrom(keisankijunbiTyokuzenOutouYmd);
        pHaitouKaisuuBean.setKikanto(pCalckijyunymd);

        return pHaitouKaisuuBean;
    }

    private BizDate calcHaitouSiharaiYmdForNendo(BizDate pHaitouSiharaiKijyunymd, BizDateY haitouNendo) {

        if (pHaitouSiharaiKijyunymd.getMonth() < 4) {
            return BizDate.valueOf(haitouNendo.addYears(1), pHaitouSiharaiKijyunymd.getBizDateMD()).getRekijyou();
        }
        else {
            return BizDate.valueOf(haitouNendo, pHaitouSiharaiKijyunymd.getBizDateMD());
        }
    }

    private boolean checkKikannHusei(BizDate fromDate, BizDate toDate) {
        if (fromDate.compareTo(toDate) > 0) {
            return true;
        }

        BizDate sakunenDate = toDate.addYears(-1).getRekijyou();
        if (fromDate.compareTo(sakunenDate) < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private HaitouKaisuuBean haitouKaisuKeisan(
        BizDate pKykymd,
        HaitouKaisuuBean
        pHaitouKaisuuBean) {

        SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);
        HokenNndBean hokenNndBean = setHokenNnd.exec(pKykymd, pKykymd);

        if (hokenNndBean == null) {

            setErrorLink(setHokenNnd);

            return null;
        }

        BizDateY kykymdHaitouNendo = hokenNndBean.getHokenNnd();

        BizDate tyokugoOutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKGO,
            C_TykzentykgoKbn.TYKGO,
            pKykymd,
            pHaitouKaisuuBean.getKikanto());

        hokenNndBean = setHokenNnd.exec(pKykymd, tyokugoOutouymd);

        if (hokenNndBean == null) {

            setErrorLink(setHokenNnd);

            return null;
        }

        BizDateY calckijyunymdHaitouNendo = hokenNndBean.getHokenNnd();

        pHaitouKaisuuBean.setHaitoukaisuu(calckijyunymdHaitouNendo.getYear() - kykymdHaitouNendo.getYear());

        return pHaitouKaisuuBean;
    }

    private List<HaitouKaisuuBean> houganKikanSettei(BizDate pKykymd, HaitouKaisuuBean pHaitouKaisuuBean) {

        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();

        BizDate kknfromTyokugoKykOutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKZEN,
            C_TykzentykgoKbn.TYKGO,
            pKykymd,
            pHaitouKaisuuBean.getKikanfrom());

        if (BizDateUtil.compareYmd(kknfromTyokugoKykOutouymd, pHaitouKaisuuBean.getKikanto()) == BizDateUtil.COMPARE_LESSER) {

            HaitouKaisuuBean haitouKaisuuBeanbefore = new HaitouKaisuuBean();
            haitouKaisuuBeanbefore.setKikanfrom(pHaitouKaisuuBean.getKikanfrom());
            haitouKaisuuBeanbefore.setKikanto(kknfromTyokugoKykOutouymd);
            haitouKaisuuBeanbefore.setHaitoukaisuu(pHaitouKaisuuBean.getHaitoukaisuu() - 1);

            HaitouKaisuuBean haitouKaisuuBeanafter = new HaitouKaisuuBean();
            haitouKaisuuBeanafter.setKikanfrom(kknfromTyokugoKykOutouymd);
            haitouKaisuuBeanafter.setKikanto(pHaitouKaisuuBean.getKikanto());
            haitouKaisuuBeanafter.setHaitoukaisuu(pHaitouKaisuuBean.getHaitoukaisuu());

            haitouKaisuuBeanLst.add(haitouKaisuuBeanbefore);
            haitouKaisuuBeanLst.add(haitouKaisuuBeanafter);
        }
        else {

            haitouKaisuuBeanLst.add(pHaitouKaisuuBean);
        }

        return haitouKaisuuBeanLst;
    }

    private List<HaitouKaisuuBean> keikatukisuSettei(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        List<HaitouKaisuuBean> pHaitouKaisuuBeanLst) {

        if (pYendthnkymd == null) {
            Integer keikamon = keikatukisuuKeisan(pHaitouKaisuuBeanLst.get(0).getKikanfrom(),
                pHaitouKaisuuBeanLst.get(0).getKikanto());

            pHaitouKaisuuBeanLst.get(0).setKeikamon(keikamon);
        }
        else {
            kykYmdBaseKeikatukisuuKeisanForYendtHnkGo(pKykymd, pYendthnkymd, pHaitouKaisuuBeanLst);
        }

        return pHaitouKaisuuBeanLst;
    }

    private void kykYmdBaseKeikatukisuuKeisanForYendtHnkGo(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        List<HaitouKaisuuBean> pHaitouKaisuuBeanLst) {

        for (HaitouKaisuuBean haitouKaisuuBean : pHaitouKaisuuBeanLst) {

            BizDate kikanTyokuzenKykoutouymd = tyokuzenTyokugoOutoubiKeisan(
                C_TykzentykgoKbn.TYKZEN,
                C_TykzentykgoKbn.TYKZEN,
                pKykymd,
                haitouKaisuuBean.getKikanfrom());

            if (BizDateUtil.compareYmd(kikanTyokuzenKykoutouymd, haitouKaisuuBean.getKikanfrom()) != BizDateUtil.COMPARE_EQUAL) {

                kykYmdBaseKeikatukisuuKeisanMaekikanForYendtHnkGo(pKykymd, pYendthnkymd, haitouKaisuuBean);
            }
            else {
                kykYmdBaseKeikatukisuuKeisanAtokikanForYendtHnkGo(pKykymd, pYendthnkymd, haitouKaisuuBean);
            }
        }
    }

    private void kykYmdBaseKeikatukisuuKeisanMaekikanForYendtHnkGo(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        HaitouKaisuuBean pHaitouKaisuuBean) {

        BizDate kikanTyokuzenKykoutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKZEN,
            C_TykzentykgoKbn.TYKZEN,
            pKykymd,
            pHaitouKaisuuBean.getKikanfrom());

        Integer zentaikikanKeikamon = keikatukisuuKeisan(kikanTyokuzenKykoutouymd, pHaitouKaisuuBean.getKikanto());

        Integer kykKijyunmaekknKeikamon = yendtHnkJiKeikatukisuuKeisan(pKykymd, pYendthnkymd);

        pHaitouKaisuuBean.setKeikamon(zentaikikanKeikamon - kykKijyunmaekknKeikamon);
    }

    private void kykYmdBaseKeikatukisuuKeisanAtokikanForYendtHnkGo(
        BizDate pKykymd,
        BizDate pYendthnkymd,
        HaitouKaisuuBean pHaitouKaisuuBean) {

        Integer keikamon = 0;

        BizDate kikanTyokuzenYendthnkOutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKZEN,
            C_TykzentykgoKbn.TYKZEN,
            pYendthnkymd,
            pHaitouKaisuuBean.getKikanfrom());

        BizDate kikanTyokugoYendthnkOutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKZEN,
            C_TykzentykgoKbn.TYKGO,
            pYendthnkymd,
            pHaitouKaisuuBean.getKikanfrom());

        if (BizDateUtil.compareYmd(pHaitouKaisuuBean.getKikanfrom(), kikanTyokuzenYendthnkOutouymd) != BizDateUtil.COMPARE_EQUAL &&
            BizDateUtil.compareYmd(pHaitouKaisuuBean.getKikanto(), kikanTyokugoYendthnkOutouymd) == BizDateUtil.COMPARE_EQUAL) {

            keikamon = yendtHnkJiKeikatukisuuKeisan(pKykymd, pYendthnkymd);
        }
        else {

            keikamon = keikatukisuuKeisan(pHaitouKaisuuBean.getKikanfrom(), pHaitouKaisuuBean.getKikanto());
        }

        pHaitouKaisuuBean.setKeikamon(keikamon);
    }

    private Integer yendtHnkJiKeikatukisuuKeisan(BizDate pKykymd, BizDate pYendthnkymd) {

        BizDate mkhgktttTyokuzenKykoutouymd = tyokuzenTyokugoOutoubiKeisan(
            C_TykzentykgoKbn.TYKGO,
            C_TykzentykgoKbn.TYKZEN,
            pKykymd,
            pYendthnkymd);

        Integer yendthnkKeikamon = keikatukisuuKeisan(mkhgktttTyokuzenKykoutouymd, pYendthnkymd);

        return yendthnkKeikamon;
    }

    private Integer keikatukisuuKeisan(BizDate pKikanfrom, BizDate pKikanto) {

        BizDateYM hoseigoEndym = pKikanto.getBizDateYM();

        if (pKikanfrom.getDay() <= pKikanto.getDay()) {
            if (pKikanto.getDay() - pKikanfrom.getDay() >= 15) {

                hoseigoEndym = hoseigoEndym.addMonths(1);
            }
        }
        else {
            if (pKikanfrom.getDay() - pKikanto.getDay() > 15) {

                hoseigoEndym = hoseigoEndym.addMonths(-1);
            }
        }

        Integer keikamon = hoseigoEndym.subtractMonths(pKikanfrom.getBizDateYM());

        return keikamon;
    }

    private BizDate tyokuzenTyokugoOutoubiKeisan(
        C_TykzentykgoKbn pHanteikijyun,
        C_TykzentykgoKbn pTykzentykgokbn,
        BizDate pKijyunymd,
        BizDate pHanteiymd) {

        BizDate outouymd = null;

        if (C_TykzentykgoKbn.TYKZEN.eq(pHanteikijyun)) {

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            outouymd = setOutoubi.exec(
                pTykzentykgokbn,
                pKijyunymd,
                C_Hrkkaisuu.NEN,
                pHanteiymd);
        }
        else if (C_TykzentykgoKbn.TYKGO.eq(pHanteikijyun)) {

            BizDate hanteiyOutouymd = BizDate.valueOf(pHanteiymd.getBizDateY(), pKijyunymd.getBizDateMD()).getRekijyou();

            if (BizDateUtil.compareYmd(hanteiyOutouymd, pHanteiymd) == BizDateUtil.COMPARE_EQUAL) {
                if (C_TykzentykgoKbn.TYKZEN.eq(pTykzentykgokbn)) {

                    outouymd = BizDate.valueOf(pHanteiymd.getBizDateY().addYears(-1), pKijyunymd.getBizDateMD())
                        .getRekijyou();
                }
                else if (C_TykzentykgoKbn.TYKGO.eq(pTykzentykgokbn)) {

                    outouymd = pHanteiymd;
                }
            }
            else {

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                outouymd = setOutoubi.exec(
                    pTykzentykgokbn,
                    pKijyunymd,
                    C_Hrkkaisuu.NEN,
                    pHanteiymd);
            }
        }

        return outouymd;
    }

    public List<DRateBean> execCorrespoindingOverAYear(
        BizDate pKykymd,
        String pSyono,
        BizDate pCalckijyunymd,
        BizDate pTyouseizCalckijyunymd){

        logger.debug("▽ Ｄレート年度設定(期間取得のみ_1年超版[証券番号]） 開始");

        final boolean collectEntityFlg = getCollectEntityFlg();

        clear();

        try {
            BizDateY  calckKaisiHaitounendo = getKeisanKijunbiTyokuzenHaitounendo(
                pSyono,
                pKykymd,
                pTyouseizCalckijyunymd);

            if(calckKaisiHaitounendo == null){

                logger.debug("△ Ｄレート年度設定(期間取得のみ_1年超版[証券番号]） 終了");
                return null;
            }

            BizDate calckijyunkuzenKykoutouymd = calcHaitouSiharaiYmdForNendo(pKykymd, calckKaisiHaitounendo.getNextYear());

            List<DRateBean> ｄRateBeanList = new ArrayList<DRateBean>();

            while(calckijyunkuzenKykoutouymd.compareTo(pCalckijyunymd) < 0){

                ｄRateBeanList.add(exec(pKykymd, null, calckKaisiHaitounendo, calckijyunkuzenKykoutouymd));

                calckKaisiHaitounendo = calckKaisiHaitounendo.getNextYear();

                calckijyunkuzenKykoutouymd = calcHaitouSiharaiYmdForNendo(pKykymd, calckKaisiHaitounendo.getNextYear());
            }

            ｄRateBeanList.add(exec(pKykymd,null, calckKaisiHaitounendo, pCalckijyunymd));

            logger.debug("△ Ｄレート年度設定(期間取得のみ_1年超版[証券番号]） 終了");

            return ｄRateBeanList;

        }
        finally{
            collectEntity(collectEntityFlg);
        }

    }

    public C_Kykjyoutai henkanKykjyoutai(C_Kykjyoutai pKykjyoutai, BizDate pCalckijyunymd, BizDate pKykymd,
        Integer pHhknnen, Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn){

        C_Kykjyoutai kykjyoutai;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pKykjyoutai)) {

            kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        }
        else {

            BizDate calckijyunZenYmd = pCalckijyunymd.addDays(-1);

            SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);

            BizDate hrkkknmnryYmd = setManryoubi.exec(pKykymd, pHhknnen, pHrkkkn, C_KknsmnKbn.valueOf(pHrkkknsmnkbn.getValue()));

            if (BizDateUtil.compareYmd(calckijyunZenYmd, hrkkknmnryYmd) == BizDateUtil.COMPARE_LESSER) {

                kykjyoutai = C_Kykjyoutai.HRKMTYUU;
            }
            else {

                kykjyoutai = C_Kykjyoutai.HARAIMAN;
            }
        }

        return kykjyoutai;
    }

    public class HaitouKaisuuBean {

        private BizDate kikanfrom;

        private BizDate kikanto;

        private Integer keikamon;

        private Integer haitoukaisuu;

        protected HaitouKaisuuBean() {

            kikanfrom = null;
            kikanto = null;
            keikamon = 0;
            haitoukaisuu = 0;
        }

        public BizDate getKikanfrom() {
            return kikanfrom;
        }

        protected void setKikanfrom(BizDate pKikanfrom) {
            kikanfrom = pKikanfrom;
        }

        public BizDate getKikanto() {
            return kikanto;
        }

        protected void setKikanto(BizDate pKikanto) {
            kikanto = pKikanto;
        }

        public Integer getKeikamon() {
            return keikamon;
        }

        protected void setKeikamon(Integer pKeikamon) {
            keikamon = pKeikamon;
        }

        public Integer getHaitoukaisuu() {
            return haitoukaisuu;
        }

        protected void setHaitoukaisuu(Integer pHaitoukaisuu) {
            haitoukaisuu = pHaitoukaisuu;
        }
    }

    public class DRateSyutokuInfoBean {

        private String syouhncd;

        private String ryouritusdno;

        private BizNumber yoteiriritu;

        private C_Hrkkaisuu hrkkaisuu;

        private C_Hhknsei hhknsei;

        private Integer hhknnen;

        private C_HknkknsmnKbn hknkknsmnkbn;

        private Integer hknkkn;

        private Integer hrkkkn;

        private C_Kykjyoutai kykjyoutai;

        private C_Tuukasyu tuukasyu;

        private Integer dai1hknkkn;

        private BizDateY dratenendo;

        private C_NaiteiKakuteiKbn naiteikakuteikbn;

        protected DRateSyutokuInfoBean() {
        }

        public String getSyouhncd() {
            return syouhncd;
        }

        protected void setSyouhncd(String pSyouhncd) {
            syouhncd = pSyouhncd;
        }

        public String getRyouritusdno() {
            return ryouritusdno;
        }

        protected void setRyouritusdno(String pRyouritusdno) {
            ryouritusdno = pRyouritusdno;
        }

        public BizNumber getYoteiriritu() {
            return yoteiriritu;
        }

        protected void setYoteiriritu(BizNumber pYoteiriritu) {
            yoteiriritu = pYoteiriritu;
        }

        public C_Hrkkaisuu getHrkkaisuu() {
            return hrkkaisuu;
        }

        protected void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
            hrkkaisuu = pHrkkaisuu;
        }

        public C_Hhknsei getHhknsei() {
            return hhknsei;
        }

        protected void setHhknsei(C_Hhknsei pHhknsei) {
            hhknsei = pHhknsei;
        }

        public Integer getHhknnen() {
            return hhknnen;
        }

        protected void setHhknnen(Integer pHhknnen) {
            hhknnen = pHhknnen;
        }

        public C_HknkknsmnKbn getHknkknsmnkbn() {
            return hknkknsmnkbn;
        }

        protected void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
            hknkknsmnkbn = pHknkknsmnkbn;
        }

        public Integer getHknkkn() {
            return hknkkn;
        }

        protected void setHknkkn(Integer pHknkkn) {
            hknkkn = pHknkkn;
        }

        public Integer getHrkkkn() {
            return hrkkkn;
        }

        protected void setHrkkkn(Integer pHrkkkn) {
            hrkkkn = pHrkkkn;
        }

        public C_Kykjyoutai getKykjyoutai() {
            return kykjyoutai;
        }

        protected void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
            kykjyoutai = pKykjyoutai;
        }

        public C_Tuukasyu getTuukasyu() {
            return tuukasyu;
        }

        protected void setTuukasyu(C_Tuukasyu pTuukasyu) {
            tuukasyu = pTuukasyu;
        }

        public Integer getDai1hknkkn() {
            return dai1hknkkn;
        }

        protected void setDai1hknkkn(Integer pDai1hknkkn) {
            dai1hknkkn = pDai1hknkkn;
        }

        public BizDateY getDratenendo() {
            return dratenendo;
        }

        protected void setDratenendo(BizDateY pDratenendo) {
            dratenendo = pDratenendo;
        }

        public C_NaiteiKakuteiKbn getNaiteikakuteikbn() {
            return naiteikakuteikbn;
        }

        protected void setNaiteikakuteikbn(C_NaiteiKakuteiKbn pNaiteikakuteikbn) {
            naiteikakuteikbn = pNaiteikakuteikbn;
        }
    }

    public class DRateBean  {

        private DRateSyutokuInfoBean dRateSyutokuInfoBean;

        private List<HaitouKaisuuBean> haitouKaisuuBeanLst;

        protected DRateBean() {
        }

        public DRateSyutokuInfoBean getDRateSyutokuInfoBean() {
            return dRateSyutokuInfoBean;
        }

        protected void setDRateSyutokuInfoBean(DRateSyutokuInfoBean pDRateSyutokuInfoBean) {
            dRateSyutokuInfoBean = pDRateSyutokuInfoBean;
        }

        public List<HaitouKaisuuBean> getHaitouKaisuuBeanLst() {
            return haitouKaisuuBeanLst;
        }

        protected void setHaitouKaisuuBeanLst(List<HaitouKaisuuBean> pHaitouKaisuuBeanLst) {
            haitouKaisuuBeanLst = pHaitouKaisuuBeanLst;
        }
    }
}
