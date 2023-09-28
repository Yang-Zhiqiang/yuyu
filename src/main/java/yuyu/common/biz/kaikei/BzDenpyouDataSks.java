package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.JT_SiDenpyoData;

/**
 * 業務共通 経理・会計 伝票データ作成
 */
public class BzDenpyouDataSks {

    private int edaBanngou;

    private int creditHnknEdaBanngou;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator unique;

    public BzDenpyouDataSks() {
        super();
    }

    public int getEdano() {
        return edaBanngou;
    }

    public int getCreditHnknEdano() {
        return creditHnknEdaBanngou;
    }

    public List<HT_SkDenpyoData> execSk(BzSinkeiyakuDenpyouDataTourokuBean pBzSinkeiyakuDenpyouDataTourokuBean) {

        logger.debug("▽ 伝票データ作成 開始");

        if (!isGkSiwakeYenkonzai(pBzSinkeiyakuDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
            pBzSinkeiyakuDenpyouDataTourokuBean.getIbTuukasyu())) {

            boolean result = kariCheck(pBzSinkeiyakuDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbTuukasyu());

            if (!result) {
                throw new BizAppException(MessageId.EBA0043, pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyono());
            }
        }

        String denrenNo = unique.generateUniqueKey();
        int edaNo = 0;
        String syoriTime = BizDate.getSysDateTimeMilli();
        List<HT_SkDenpyoData> skDenpyoDataLst = new ArrayList<>();

        BizDate tempIbKakokawaserateshiteiymd = kakokawaserateshiteiymdHantei(pBzSinkeiyakuDenpyouDataTourokuBean.getIbKakokawaserateshiteiflg(),
            pBzSinkeiyakuDenpyouDataTourokuBean.getIbKakokawaserateshiteiymd());

        Boolean fBresult = checkFbSoukinSiwake(pBzSinkeiyakuDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList());

        String denGyoumuCd =  "";
        if (fBresult) {

            BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

            denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbShrhousiteiKbn(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyoricd(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyusyouhncd(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyouhnsdno(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbTuukasyu(),
                pBzSinkeiyakuDenpyouDataTourokuBean.getIbTantocd());
        } else {

            denGyoumuCd = "";
        }

        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : pBzSinkeiyakuDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList()) {

            C_YouhiKbn youhiKbn = kubunKeiriHanntei(bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

            C_Segcd segcd1;
            C_Segcd segcd2;
            if (C_YouhiKbn.YOU.eq(youhiKbn)) {
                segcd1 = bzSiwakeMeisaiBean.getIbSeg1cd();
                segcd2 = bzSiwakeMeisaiBean.getIbSeg2cd();
            }
            else {
                segcd1 = C_Segcd.BLNK;
                segcd2 = C_Segcd.BLNK;
            }

            edaNo++;
            HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();

            skDenpyoData.setDenrenno(denrenNo);
            skDenpyoData.setEdano(edaNo);
            skDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
            skDenpyoData.setSyono(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyono());
            skDenpyoData.setMosno(pBzSinkeiyakuDenpyouDataTourokuBean.getIbMosno());
            skDenpyoData.setHuridenatesakicd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbHuridenatesakicd());
            skDenpyoData.setTantocd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbTantocd());
            skDenpyoData.setDenymd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbDenymd());
            skDenpyoData.setTaisyakukbn(bzSiwakeMeisaiBean.getIbTaisyakukbn());
            skDenpyoData.setKanjyoukmkcd(bzSiwakeMeisaiBean.getIbKanjyoukmkcd());
            skDenpyoData.setSuitoubumoncd(bzSiwakeMeisaiBean.getIbSuitoubumoncd());
            skDenpyoData.setTuukasyu(pBzSinkeiyakuDenpyouDataTourokuBean.getIbTuukasyu());
            skDenpyoData.setDengaikagk(bzSiwakeMeisaiBean.getIbDengaikagk());
            skDenpyoData.setDenkawaserate(BizNumber.ZERO);
            skDenpyoData.setDenyenkagk(bzSiwakeMeisaiBean.getIbDenyenkagk());
            skDenpyoData.setSyoriYmd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyoriymd());
            skDenpyoData.setSyoricd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyoricd());
            skDenpyoData.setSyorisosikicd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyorisosikicd());
            skDenpyoData.setSeg1cd(segcd1);
            skDenpyoData.setSeg2cd(segcd2);
            skDenpyoData.setKessantyouseikbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbKessantyouseikbn());
            skDenpyoData.setNaibukeiyakukbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbNaibukeiyakukbn());
            skDenpyoData.setTekiyoukbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbTekiyoukbn());
            skDenpyoData.setDensyorikbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbDensyorikbn());
            skDenpyoData.setAatsukaishasuitososhikicd(pBzSinkeiyakuDenpyouDataTourokuBean
                .getIbAatsukaishasuitososhikicd());
            skDenpyoData.setKykymd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbKykymd());
            skDenpyoData.setBosyuuym(pBzSinkeiyakuDenpyouDataTourokuBean.getIbBosyuuym());
            skDenpyoData.setAatsukaishasoshikicd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbAatsukaishasoshikicd());
            skDenpyoData.setAatkisyadaibosyuucd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbAatkisyadaibosyuucd());
            skDenpyoData.setSyusyouhncd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyusyouhncd());
            skDenpyoData.setSdpdkbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSdpdkbn());
            skDenpyoData.setHrkkaisuu(pBzSinkeiyakuDenpyouDataTourokuBean.getIbHrkkaisuu());
            skDenpyoData.setHrkkeiro(pBzSinkeiyakuDenpyouDataTourokuBean.getIbHrkkeiro());
            skDenpyoData.setSknnkaisiymd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSknnkaisiymd());
            skDenpyoData.setMosymd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbMosymd());
            skDenpyoData.setHnknriyuukbn(pBzSinkeiyakuDenpyouDataTourokuBean.getIbHnknriyuukbn());
            skDenpyoData.setFstpryosyuymd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbFstpryosyuymd());
            skDenpyoData.setAatkisyabosyuucd(pBzSinkeiyakuDenpyouDataTourokuBean.getIbAatkisyabosyuucd());
            skDenpyoData.setRyouritusdno(pBzSinkeiyakuDenpyouDataTourokuBean.getIbRyouritusdno());
            skDenpyoData.setKakokawaserateshiteiflg(pBzSinkeiyakuDenpyouDataTourokuBean.getIbKakokawaserateshiteiflg());
            skDenpyoData.setKakokawaserateshiteiymd(tempIbKakokawaserateshiteiymd);
            skDenpyoData.setKyktuukasyu(pBzSinkeiyakuDenpyouDataTourokuBean.getIbKyktuukasyu());
            skDenpyoData.setKeiyakutuukagk(bzSiwakeMeisaiBean.getIbKeiyakutuukagk());
            skDenpyoData.setGyoumuKousinsyaId(pBzSinkeiyakuDenpyouDataTourokuBean.getIbGyoumuKousinsyaId());
            skDenpyoData.setGyoumuKousinTime(syoriTime);
            skDenpyoData.setDengyoumucd(denGyoumuCd);
            skDenpyoData.setSyouhnsdno(pBzSinkeiyakuDenpyouDataTourokuBean.getIbSyouhnsdno());
            skDenpyoData.setDenkarikanjyono(bzSiwakeMeisaiBean.getIbDenkarikanjyono());
            skDenpyoData.setTaisyakutyouseiflg(bzSiwakeMeisaiBean.getIbTaisyakutyouseiflg());
            BizPropertyInitializer.initialize(skDenpyoData);

            skDenpyoDataLst.add(skDenpyoData);

            /* 2016/10/31 区分整理に向けたコメントアウト
            if (C_Kanjyoukmkcd.KARIUKE_FBSOKIN.eq(bzSiwakeMeisaiBean.getIbKanjyoukmkcd()) ||
                C_Kanjyoukmkcd.KARIUKE_FBSOKIN_JPY.eq(bzSiwakeMeisaiBean.getIbKanjyoukmkcd()) ||
                C_Kanjyoukmkcd.KARIUKE_FBSOKIN_USD.eq(bzSiwakeMeisaiBean.getIbKanjyoukmkcd()) ||
                C_Kanjyoukmkcd.KARIUKE_FBSOKIN_EUR.eq(bzSiwakeMeisaiBean.getIbKanjyoukmkcd()) ||
                C_Kanjyoukmkcd.KARIUKE_FBSOKIN_AUD.eq(bzSiwakeMeisaiBean.getIbKanjyoukmkcd()) ||
             */

            boolean fBsoukinResult = checkFbSoukin(bzSiwakeMeisaiBean.getIbTaisyakukbn(),
                bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

            if(fBsoukinResult){

                edaBanngou = edaNo;
            }
        }

        logger.debug("△ 伝票データ作成 終了");

        return skDenpyoDataLst;
    }

    public List<IT_KhDenpyoData> execKh(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {

        logger.debug("▽ 伝票データ作成 開始");

        if (!isGkSiwakeYenkonzai(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
            pBzDenpyouDataTourokuBean.getIbTuukasyu())) {

            boolean result = kariCheck(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
                pBzDenpyouDataTourokuBean.getIbTuukasyu());
            if (!result) {
                throw new BizAppException(MessageId.EBA0043, pBzDenpyouDataTourokuBean.getIbSyono());
            }
        }

        String denrenNo = unique.generateUniqueKey();
        List<IT_KhDenpyoData> khDenpyoDataLst = new ArrayList<>();

        Boolean fBresult = checkFbSoukinSiwake(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList());
        String denGyoumuCd =  "";
        if (fBresult) {

            BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

            denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(
                pBzDenpyouDataTourokuBean.getIbShrhousiteiKbn(),
                pBzDenpyouDataTourokuBean.getIbSyoricd(),
                pBzDenpyouDataTourokuBean.getIbSyouhncd(),
                pBzDenpyouDataTourokuBean.getIbSyouhnsdno(),
                pBzDenpyouDataTourokuBean.getIbTuukasyu(),
                pBzDenpyouDataTourokuBean.getIbTantocd());
        } else {

            denGyoumuCd = "";
        }

        for (int m = 0; m < pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList().size(); m++) {

            IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();

            setTblInfo(pBzDenpyouDataTourokuBean, C_DensysKbn.HOZEN, denrenNo, m, khDenpyoData, denGyoumuCd);

            BizPropertyInitializer.initialize(khDenpyoData);

            khDenpyoDataLst.add(khDenpyoData);
        }

        logger.debug("△ 伝票データ作成 終了");

        return khDenpyoDataLst;
    }

    public List<JT_SiDenpyoData> execSi(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {

        logger.debug("▽ 伝票データ作成 開始");

        if (!isGkSiwakeYenkonzai(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
            pBzDenpyouDataTourokuBean.getIbTuukasyu())) {

            boolean result = kariCheck(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
                pBzDenpyouDataTourokuBean.getIbTuukasyu());
            if (!result) {
                throw new BizAppException(MessageId.EBA0043, pBzDenpyouDataTourokuBean.getIbSyono());
            }
        }

        String denrenNo = unique.generateUniqueKey();
        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();

        Boolean fBresult = checkFbSoukinSiwake(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList());
        String denGyoumuCd =  "";
        if (fBresult) {

            BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

            denGyoumuCd = bzGyoumuCdSyutoku.getDenGyoumuCd(
                pBzDenpyouDataTourokuBean.getIbShrhousiteiKbn(),
                pBzDenpyouDataTourokuBean.getIbSyoricd(),
                pBzDenpyouDataTourokuBean.getIbSyouhncd(),
                pBzDenpyouDataTourokuBean.getIbSyouhnsdno(),
                pBzDenpyouDataTourokuBean.getIbTuukasyu(),
                pBzDenpyouDataTourokuBean.getIbTantocd());
        } else {

            denGyoumuCd = "";
        }

        for (int m = 0; m < pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList().size(); m++) {
            JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();

            setTblInfo(pBzDenpyouDataTourokuBean, C_DensysKbn.HKSIHARAI, denrenNo, m, siDenpyoData, denGyoumuCd);

            BizPropertyInitializer.initialize(siDenpyoData);

            siDenpyoDataLst.add(siDenpyoData);
        }

        logger.debug("△ 伝票データ作成 終了");

        return siDenpyoDataLst;
    }

    // 2016/11/07 熊谷 年金削除対応
    //    public List<KT_NkDenpyoData> execNk(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean) {
    //
    //        logger.debug("▽ 伝票データ作成 開始");
    //
    //        boolean result = kariCheck(pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList(),
    //            pBzDenpyouDataTourokuBean.getIbTuukasyu());
    //        if (!result) {
    //            throw new BizAppException(MessageId.EBA0043, pBzDenpyouDataTourokuBean.getIbSyono());
    //        }
    //
    //        String denrenNo = unique.generateUniqueKey();
    //        List<KT_NkDenpyoData> nkDenpyoDataLst = new ArrayList<>();
    //
    //        for (int m = 0; m < pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList().size(); m++) {
    //            KT_NkDenpyoData nkDenpyoData = new KT_NkDenpyoData();
    //
    //            setTblInfo(pBzDenpyouDataTourokuBean, C_DensysKbn.NENKIN, denrenNo, m, nkDenpyoData);
    //
    //            BizPropertyInitializer.initialize(nkDenpyoData);
    //
    //            nkDenpyoDataLst.add(nkDenpyoData);
    //        }
    //
    //        logger.debug("△ 伝票データ作成 終了");
    //
    //        return nkDenpyoDataLst;
    //    }

    private void setTblInfo(BzDenpyouDataTourokuBean pBzDenpyouDataTourokuBean,
        C_DensysKbn pDensysKbn, String pDenrenNo, Integer pIndexM, DenpyouDataParam pDenpyouDataParam,
        String pDengyoumuCd) {

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = pBzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList().get(pIndexM);

        String syoriTime = BizDate.getSysDateTimeMilli();

        C_YouhiKbn youhiKbn = kubunKeiriHanntei(bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

        C_Segcd segcd1;
        C_Segcd segcd2;
        if (C_YouhiKbn.YOU.eq(youhiKbn)) {
            segcd1 = bzSiwakeMeisaiBean.getIbSeg1cd();
            segcd2 = bzSiwakeMeisaiBean.getIbSeg2cd();
        }
        else {
            segcd1 = C_Segcd.BLNK;
            segcd2 = C_Segcd.BLNK;
        }

        BizDate tempIbKakokawaserateshiteiymd = kakokawaserateshiteiymdHantei(pBzDenpyouDataTourokuBean.getIbKakokawaserateshiteiflg(),
            pBzDenpyouDataTourokuBean.getIbKakokawaserateshiteiymd());

        int edaNo = pIndexM + 1;

        pDenpyouDataParam.setDenrenno(pDenrenNo);
        pDenpyouDataParam.setEdano(edaNo);
        pDenpyouDataParam.setDensyskbn(pDensysKbn);
        pDenpyouDataParam.setSyono(pBzDenpyouDataTourokuBean.getIbSyono());
        pDenpyouDataParam.setHuridenatesakicd(pBzDenpyouDataTourokuBean.getIbHuridenatesakicd());
        pDenpyouDataParam.setTantocd(pBzDenpyouDataTourokuBean.getIbTantocd());
        pDenpyouDataParam.setDenymd(pBzDenpyouDataTourokuBean.getIbDenymd());
        pDenpyouDataParam.setTaisyakukbn(bzSiwakeMeisaiBean.getIbTaisyakukbn());
        pDenpyouDataParam.setKanjyoukmkcd(bzSiwakeMeisaiBean.getIbKanjyoukmkcd());
        pDenpyouDataParam.setSuitoubumoncd(bzSiwakeMeisaiBean.getIbSuitoubumoncd());
        pDenpyouDataParam.setTuukasyu(pBzDenpyouDataTourokuBean.getIbTuukasyu());
        pDenpyouDataParam.setDengaikagk(bzSiwakeMeisaiBean.getIbDengaikagk());
        pDenpyouDataParam.setDenkawaserate(BizNumber.ZERO);
        pDenpyouDataParam.setDenyenkagk(bzSiwakeMeisaiBean.getIbDenyenkagk());
        pDenpyouDataParam.setHuridenskskbn(pBzDenpyouDataTourokuBean.getIbHuridenskskbn());
        pDenpyouDataParam.setDenhnknhoukbn(pBzDenpyouDataTourokuBean.getIbDenhnknhoukbn());
        pDenpyouDataParam.setDenshrhoukbn(pBzDenpyouDataTourokuBean.getIbDenshrhoukbn());
        pDenpyouDataParam.setSyoriYmd(pBzDenpyouDataTourokuBean.getIbSyoriymd());
        pDenpyouDataParam.setSyoricd(pBzDenpyouDataTourokuBean.getIbSyoricd());
        pDenpyouDataParam.setSyorisosikicd(pBzDenpyouDataTourokuBean.getIbSyorisosikicd());
        pDenpyouDataParam.setSeg1cd(segcd1);
        pDenpyouDataParam.setSeg2cd(segcd2);
        pDenpyouDataParam.setKakokawaserateshiteiflg(pBzDenpyouDataTourokuBean.getIbKakokawaserateshiteiflg());
        pDenpyouDataParam.setKakokawaserateshiteiymd(tempIbKakokawaserateshiteiymd);
        pDenpyouDataParam.setKyktuukasyu(pBzDenpyouDataTourokuBean.getIbKyktuukasyu());
        pDenpyouDataParam.setKeiyakutuukagk(bzSiwakeMeisaiBean.getIbKeiyakutuukagk());
        pDenpyouDataParam.setGyoumuKousinsyaId(pBzDenpyouDataTourokuBean.getIbGyoumuKousinsyaId());
        pDenpyouDataParam.setGyoumuKousinTime(syoriTime);
        pDenpyouDataParam.setDengyoumucd(pDengyoumuCd);
        pDenpyouDataParam.setSyusyouhncd(pBzDenpyouDataTourokuBean.getIbSyouhncd());
        pDenpyouDataParam.setSyouhnsdno(pBzDenpyouDataTourokuBean.getIbSyouhnsdno());
        pDenpyouDataParam.setKawasetekiyokbn(bzSiwakeMeisaiBean.getIbKawasetekiyokbn());
        pDenpyouDataParam.setDenkarikanjyono(bzSiwakeMeisaiBean.getIbDenkarikanjyono());
        pDenpyouDataParam.setTaisyakutyouseiflg(bzSiwakeMeisaiBean.getIbTaisyakutyouseiflg());
        pDenpyouDataParam.setDensyorisyousaikbn(pBzDenpyouDataTourokuBean.getIbDensyorisyousaikbn());

        boolean fBsoukinResult = checkFbSoukin(bzSiwakeMeisaiBean.getIbTaisyakukbn(),
            bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

        if(fBsoukinResult){

            edaBanngou = edaNo;
        }

        boolean creditHnknResult = checkCreditHnkn(bzSiwakeMeisaiBean.getIbTaisyakukbn(),
            bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

        if(creditHnknResult){

            creditHnknEdaBanngou = edaNo;
        }

    }

    private boolean kariCheck(List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst, C_Tuukasyu pTuukasyu) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        BizCurrency denKagk = BizCurrency.valueOf(0, type);
        BizCurrency taiKagk = BizCurrency.valueOf(0, type);
        BizCurrency syaKagk = BizCurrency.valueOf(0, type);
        boolean result = false;

        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : pBzSiwakeMeisaiBeanLst) {

            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
                denKagk = bzSiwakeMeisaiBean.getIbDenyenkagk();
            } else {
                denKagk = bzSiwakeMeisaiBean.getIbDengaikagk();
            }

            if (C_TaisyakuKbn.KASIKATA.eq(bzSiwakeMeisaiBean.getIbTaisyakukbn())) {
                taiKagk = taiKagk.add(denKagk);
            }
            else if (C_TaisyakuKbn.KARIKATA.eq(bzSiwakeMeisaiBean.getIbTaisyakukbn())) {
                syaKagk = syaKagk.add(denKagk);
            }
        }

        if (taiKagk.equalsValue(syaKagk)) {
            result = true;
        }

        return result;
    }

    private C_YouhiKbn kubunKeiriHanntei(C_Kanjyoukmkcd pKanjyoukmkcd) {

        BM_KanjyouKamoku kanjyouKamoku = bizDomManager.getKanjyouKamoku(pKanjyoukmkcd);
        if (kanjyouKamoku != null) {
            return kanjyouKamoku.getKbnkeiriyouhi();
        }
        return null;
    }

    private BizDate kakokawaserateshiteiymdHantei(boolean pIbKakokawaserateshiteiflg, BizDate pIbKakokawaserateshiteiymd){

        BizDate hanteigoYmd = pIbKakokawaserateshiteiymd;

        if(pIbKakokawaserateshiteiflg && pIbKakokawaserateshiteiymd != null && !pIbKakokawaserateshiteiymd.isBusinessDay()){
            hanteigoYmd = pIbKakokawaserateshiteiymd.addBusinessDays(1);
        }

        return hanteigoYmd;

    }

    private boolean checkFbSoukinSiwake(List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst) {

        boolean result = false;

        for(BzSiwakeMeisaiBean bzSiwakeMeisaiBean : pBzSiwakeMeisaiBeanLst){

            boolean fBresult = checkFbSoukin(bzSiwakeMeisaiBean.getIbTaisyakukbn(), bzSiwakeMeisaiBean.getIbKanjyoukmkcd());

            if(fBresult){

                result = true;

                break;
            }
        }

        return result;
    }

    private boolean checkFbSoukin(C_TaisyakuKbn pTaisyakuKbn, C_Kanjyoukmkcd pKanjyoukmkCd) {

        boolean result = false;

        if (C_TaisyakuKbn.KASIKATA.eq(pTaisyakuKbn) && (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN.eq(pKanjyoukmkCd) ||
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN.eq(pKanjyoukmkCd))) {

            result = true;
        }

        return result;
    }

    private boolean isGkSiwakeYenkonzai(List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst, C_Tuukasyu pTuukasyu) {

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {
            return false;
        }

        BizCurrency zeroyen;

        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : pBzSiwakeMeisaiBeanLst) {
            zeroyen = BizCurrency.valueOf(0, bzSiwakeMeisaiBean.getIbDenyenkagk().getType());

            if (!zeroyen.equalsValue(bzSiwakeMeisaiBean.getIbDenyenkagk())) {
                return true;
            }
        }

        return false;
    }

    private boolean checkCreditHnkn(C_TaisyakuKbn pTaisyakuKbn, C_Kanjyoukmkcd pKanjyoukmkCd) {

        boolean result = false;

    	if (C_TaisyakuKbn.KASIKATA.eq(pTaisyakuKbn) && C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE.eq(pKanjyoukmkCd)){

            result = true;
        }

        return result;
    }

}
