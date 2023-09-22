package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.sinkeiyaku.skcommon.EditHeijyunbaraiP;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.entity.BM_ChkItijibrTuusanP;
import yuyu.def.db.entity.BM_ChkItijibrTuusanS;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkJhNkgns;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import yuyu.def.db.entity.BM_ChkNkgns;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import yuyu.def.db.entity.BM_ChkTuusanS;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.HT_Tuusan;

/**
 * 新契約 申込内容チェック 通算チェック
 */
public class CheckTuusan {

    public static final int YENKA_MIN_TANI = 1;

    public static final double GAIKA_MIN_TANI = 0.01d;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public CheckTuusan() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, Tuusan pTuusan) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 通算チェック 開始");
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        String mosNo = syoriCtl.getMosno();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();

        List<HT_MosSyouhn> mosSyouhnLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }
        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei =
            pMp.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        C_SysKbn sysKbn = pMp.getSysKbn();
        BizNumber hhknNen = BizNumber.valueOf(mosKihon.getHhknnen());
        C_Hrkkaisuu hrkkaisuu = mosKihon.getHrkkaisuu();
        String hhknSykgycd = mosKihon.getHhknsykgycd();
        C_NensyuuKbn nensyuuKbn = mosKihon.getHhknnensyuukbn();
        C_KihonssyuruiKbn kihonsSyuruiKbn = syouhnZokusei.getKihonssyuruikbn();
        C_PtratkituukasiteiKbn ptratkituukasiteiKbn = syouhnZokusei.getPtratkituukasiteikbn();
        C_UmuKbn nkhknUmu = syouhnZokusei.getNkhknumu();
        C_UmuKbn saiteiSKanwaTkykUmu = syouhnZokusei.getSaiteisknwtkumu();
        C_TsngndtknKbn tsnGndTknKbn = C_TsngndtknKbn.NONE;
        C_SpgndtknKbn spGndTknKbn = C_SpgndtknKbn.NONE;
        BizCurrency tsnSibouGndS1 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tsnSibouGndS2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tsnSibouGndS3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tsnSibouGndS4 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tsnSibouGndS5 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kktTsnsGndS1 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kktTsnsGndS2 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency kktTsnsGndS3 = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency nkGnsGndgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency skgyouTsnGndS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency itijibrTsnGndS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency nsyuBairetuGndS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_TknKbn tstkTuukahijynSysnsTknKbn = C_TknKbn.NONE;
        String msgMongon = "";
        C_UmuKbn tsnSouSbsUmu = pTuusan.getTuusanSouSibouSUmu();
        C_UmuKbn tsnNinenMiKkSouSbsUmu = pTuusan.getTuusan2NenMikeikaSouSibouSUmu();
        C_UmuKbn tsnSouKktJituHosyouGkUmu = pTuusan.getTuusanSouKokurtisyoJituHosyougakuUmu();
        C_UmuKbn tsnKktJituHosyouGk1Umu = pTuusan.getTuusanKokurtisyoJituHosyougaku1Umu();
        C_UmuKbn tsnKktJituHosyouGk2Umu = pTuusan.getTuusanKokurtisyoJituHosyougaku2Umu();
        C_UmuKbn tsnNenkinGensiUmu = pTuusan.getTuusanNenkinGensiUmu();
        C_UmuKbn tsnMsnyouNrbtSouSbsUmu = pTuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu();
        C_UmuKbn tsnNrbtItijibrSouSbsUmu = pTuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu();
        C_UmuKbn kyksyaDouituDrtTsnsUmu = pTuusan.getKeiyakusyaDouituDairitenTuusanSUmu();
        C_TkthknsyruitsnKbn tkthknsyruitsnKbn = pTuusan.getTktHknsyruiTsnKbn();
        BizCurrency tsnSouSbs = pTuusan.getTuusanSouSibouS();
        BizCurrency tsnNinenMiKkSouSbs = pTuusan.getTuusan2NenMikeikaSouSibouS();
        BizCurrency tsnSouKktJituHosyouGk = pTuusan.getTuusanSouKokurtisyoJituHosyougaku();
        BizCurrency tsnKktJituHosyouGk1 = pTuusan.getTuusanKokurtisyoJituHosyougaku1();
        BizCurrency tsnKktJituHosyouGk2 = pTuusan.getTuusanKokurtisyoJituHosyougaku2();
        BizCurrency tsnNenkinGensi = pTuusan.getTuusanNenkinGensi();
        BizCurrency tsnMsnyouNrbtSouSbs = pTuusan.getTuusanMiseinenyouNenreibetuSouSibouS();
        C_UmuKbn tsnNrbtSouSbsUmu = pTuusan.getTuusanNenreibetuSouSibouSUmu();
        BizCurrency tsnNrbtItijibrSouSbs = pTuusan.getTuusanNenreibetuItijibaraiSouSibouS();
        BizCurrency kyksyaDouituDrtTsns = pTuusan.getKeiyakusyaDouituDairitenTuusanS();
        BizCurrency tsnItijibrSysnP = pTuusan.getTsnItijibrSysnP();
        BizCurrency tsnSntktuukaHijynSysnS = pTuusan.getTsnSntktuukaHijynSysnS();
        BizCurrency hanteiTsnKanouGks = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        C_Sdpd sdpdKbn = mosKihon.getSdpdkbn();
        C_Tuukasyu hrkTuukasyu = mosKihon.getHrktuukasyu();
        C_Tuukasyu kykTuukasyu = mosKihon.getKyktuukasyu();
        String hubiMsgS = "";

        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            hubiMsgS = "一時払保険料";
        }
        else {
            hubiMsgS = "保険料";
        }
        String hubiMsgSkykhkkmds = "保険金額";
        HanteiMoschk hanteiMoschk = SWAKInjector.getInstance(HanteiMoschk.class);
        boolean saiteipSyutkGtFlg = true;
        boolean gkKansMsgGtFlg = false;

        if (C_SysKbn.ESHIEN.eq(sysKbn)) {
            tsnGndTknKbn = C_TsngndtknKbn.NONE;
            spGndTknKbn = C_SpgndtknKbn.NONE;
        }
        else {
            HT_Tokunin tokunin = syoriCtl.getTokunin();
            if (tokunin == null) {
                tsnGndTknKbn = C_TsngndtknKbn.NONE;
                spGndTknKbn = C_SpgndtknKbn.NONE;
            }
            else {
                tsnGndTknKbn = tokunin.getTsngndtknkbn();
                spGndTknKbn = tokunin.getSpgndtknkbn();
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("WK.通算限度特認区分 = " + tsnGndTknKbn);
        }

        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);
        C_YouhiKbn itijipTsnCheckYouhi = syouhinUtil.hanteiItijibaraiPTuusanCheckYouhi(syouhnZokusei);


        if (C_UmuKbn.ARI.eq(tsnSouSbsUmu) ||
            C_UmuKbn.ARI.eq(tsnNinenMiKkSouSbsUmu) ||
            C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN.eq(tkthknsyruitsnKbn) ||
            C_UmuKbn.ARI.eq(tsnMsnyouNrbtSouSbsUmu)) {

            C_UmuKbn tsngndsKyuuKijunSiyouUmu = C_UmuKbn.NONE;

            if (C_BlnktkumuKbn.ARI.eq(syouhinUtil.hanteiTuusanSousibouSKyuuKijun(syouhnZokusei))) {
                tsngndsKyuuKijunSiyouUmu = C_UmuKbn.ARI;
            }

            if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn)) {
                List<BM_ChkTuusanS> chkTuusanSLst = bizDomManager.getChkTuusanSsByPk(hhknNen);
                if (chkTuusanSLst == null || chkTuusanSLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                if (C_UmuKbn.NONE.eq(tsngndsKyuuKijunSiyouUmu)) {
                    tsnSibouGndS1 = chkTuusanSLst.get(0).getGnds1();
                    tsnSibouGndS2 = chkTuusanSLst.get(0).getGnds2();
                }
                else {
                    tsnSibouGndS1 = chkTuusanSLst.get(0).getOldkijyungnds1();
                    tsnSibouGndS2 = chkTuusanSLst.get(0).getOldkijyungnds2();
                }

                tsnSibouGndS3 = chkTuusanSLst.get(0).getGnds3();
                tsnSibouGndS4 = chkTuusanSLst.get(0).getGnds4();
                tsnSibouGndS5 = chkTuusanSLst.get(0).getGnds5();
                tknKbn = C_TknKbn.KANOU;
                tstkTuukahijynSysnsTknKbn = C_TknKbn.KANOU;
            }
            else if (C_TsngndtknKbn.ARI.eq(tsnGndTknKbn)) {
                List<BM_ChkJhTuusanS> chkJhTuusanSLst = bizDomManager.getChkJhTuusanSsByPk(hhknNen);
                if (chkJhTuusanSLst == null || chkJhTuusanSLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                if (C_UmuKbn.NONE.eq(tsngndsKyuuKijunSiyouUmu)) {
                    tsnSibouGndS1 = chkJhTuusanSLst.get(0).getGnds1();
                    tsnSibouGndS2 = chkJhTuusanSLst.get(0).getGnds2();
                }
                else {
                    tsnSibouGndS1 = chkJhTuusanSLst.get(0).getOldkijyungnds1();
                    tsnSibouGndS2 = chkJhTuusanSLst.get(0).getOldkijyungnds2();
                }

                tsnSibouGndS3 = chkJhTuusanSLst.get(0).getGnds3();
                tsnSibouGndS4 = chkJhTuusanSLst.get(0).getGnds4();
                tsnSibouGndS5 = chkJhTuusanSLst.get(0).getGnds5();
                tknKbn = C_TknKbn.NONE;
                tstkTuukahijynSysnsTknKbn = C_TknKbn.SUMI;
            }
        }


        if (C_UmuKbn.ARI.eq(tsnSouKktJituHosyouGkUmu) ||
            C_UmuKbn.ARI.eq(tsnKktJituHosyouGk1Umu) ||
            C_UmuKbn.ARI.eq(tsnKktJituHosyouGk2Umu)) {

            if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn)) {
                List<BM_ChkKokutiTuusanS> chkKokutiTuusanSLst = bizDomManager.getChkKokutiTuusanSsByHhknnen(hhknNen);
                if (chkKokutiTuusanSLst == null || chkKokutiTuusanSLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                kktTsnsGndS1 = chkKokutiTuusanSLst.get(0).getGnds1();
                kktTsnsGndS2 = chkKokutiTuusanSLst.get(0).getGnds2();
                kktTsnsGndS3 = chkKokutiTuusanSLst.get(0).getGnds3();
                tknKbn = C_TknKbn.KANOU;
            }
            else if (C_TsngndtknKbn.ARI.eq(tsnGndTknKbn)) {
                List<BM_ChkJhKokutiTuusanS> chkJhTuusanSLst = bizDomManager.getChkJhKokutiTuusanSsByHhknnen(hhknNen);
                if (chkJhTuusanSLst == null || chkJhTuusanSLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                kktTsnsGndS1 = chkJhTuusanSLst.get(0).getGnds1();
                kktTsnsGndS2 = chkJhTuusanSLst.get(0).getGnds2();
                kktTsnsGndS3 = chkJhTuusanSLst.get(0).getGnds3();
                tknKbn = C_TknKbn.NONE;
            }
        }


        HT_Tuusan tuusan = syoriCtl.getTuusan();
        BizCurrency saiteiP = null;


        BizCurrency taniP = getPTani(syoriCtl, mosKihon, mosSyouhn, pMp.getKiteiCheckChannelCd(), ptratkituukasiteiKbn);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiMosSyouhnSaiteiP(syouhnZokusei, null);
        if (C_YouhiKbn.HUYOU.eq(youhiKbn)) {

            saiteipSyutkGtFlg = false;
        }
        else {

            CheckSaiteiP checkSaiteiP = SWAKInjector.getInstance(CheckSaiteiP.class);
            saiteiP = checkSaiteiP.getSaiteiP(pMp, syoriCtl, mosKihon, mosSyouhn, syouhnZokusei);
        }


        BizCurrency saiteis = null;
        if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {

            List<BM_ChkSaiteiS> chkSaiteiSList = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(
                mosSyouhn.getSyouhncd(),
                mosSyouhn.getSyouhnsdno(),
                mosKihon.getHrkkeiro(),
                Integer.valueOf(C_UmuKbn.NONE.getValue()),
                kykTuukasyu);

            if (chkSaiteiSList != null && chkSaiteiSList.size() != 0) {
                saiteis = chkSaiteiSList.get(0).getSaiteis();
            }
            else {

                saiteis = BizCurrency.valueOf(0);
            }
        }
        else {

            List<BM_ChkJhSaiteiS> chkJhSaiteiSList = bizDomManager.getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(
                mosSyouhn.getSyouhncd(),
                mosSyouhn.getSyouhnsdno(),
                mosKihon.getHrkkeiro(),
                Integer.parseInt(saiteiSKanwaTkykUmu.getValue()),
                kykTuukasyu);

            if (chkJhSaiteiSList != null && chkJhSaiteiSList.size() != 0) {
                saiteis = chkJhSaiteiSList.get(0).getSaiteis();
            }
            else {

                saiteis = BizCurrency.valueOf(0);
            }
        }


        BizCurrency taniS = null;

        if (C_Sdpd.SD.eq(sdpdKbn)) {

            taniS = getSTani(syoriCtl, mosKihon, mosSyouhn);
        }


        if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn) && C_YouhiKbn.YOU.eq(itijipTsnCheckYouhi) &&
            !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            List<BM_ChkItijibrTuusanP> chkItijibrTuusanPLst = bizDomManager.getChkItijibrTuusanPsByPK(hhknNen);

            if (chkItijibrTuusanPLst == null || chkItijibrTuusanPLst.size() == 0) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }
            BizCurrency itijibrTsnGndP = chkItijibrTuusanPLst.get(0).getGnditijibaraip();

            if (itijibrTsnGndP.compareTo(tsnItijibrSysnP) < 0) {
                BizCurrency hanteiTuusanKanouGkEnP = itijibrTsnGndP.subtract(tuusan.getTsnitijibrsysnp());
                BizCurrency hanteiTsnKanouGkpHrk = BizCurrency.valueOf(0);

                if(C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                    hanteiTsnKanouGkpHrk = hanteiTuusanKanouGkEnP;
                } else {
                    BizCurrency enToKykKansanGk = editTuukaEnToKyktuuka(syoriCtl, mosKihon, hanteiTuusanKanouGkEnP);
                    hanteiTsnKanouGkpHrk = editTuukaKykToHrk(syoriCtl, mosKihon, enToKykKansanGk);
                }

                hanteiTsnKanouGkpHrk = taniP.multiplyCurrency(hanteiTsnKanouGkpHrk.divideCurrency(taniP, 0, RoundingMode.DOWN));

                if (!C_Tuukasyu.JPY.eq(hrkTuukasyu)) {
                    BizCurrency kansanGk = editTuukaHrkToKyk(syoriCtl, mosKihon, hanteiTsnKanouGkpHrk);

                    BizCurrency hanteiTsnKanouGkPEnSaiKnsn = editTuukaKyktuukaToEn(mosKihon, kansanGk);

                    BizCurrency kensanItijiBryTusanGkPEn = hanteiTsnKanouGkPEnSaiKnsn.add(tuusan.getTsnitijibrsysnp());

                    if (itijibrTsnGndP.compareTo(kensanItijiBryTusanGkPEn) < 0) {
                        hanteiTsnKanouGkpHrk = hanteiTsnKanouGkpHrk.subtract(taniP);
                    }

                }

                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    if (hanteiTsnKanouGkpHrk.compareTo(saiteiP) < 0) {
                        String hubiMsgTuuka = ViewReport.editCommaTuukaNoSpace(itijibrTsnGndP, BizUtil.ZERO_FILL);
                        msgMongon = MakeHubiMsg.exec(MessageId.EHC1040, MessageId.EHC1040, hubiMsgTuuka);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    }
                    else {
                        String hubiMsgGendoP = ViewReport.editCommaTuukaNoSpace(itijibrTsnGndP, BizUtil.ZERO_FILL);
                        String hubiMsgTsnKanouGkp = ViewReport.editCommaTuukaNoSpace(hanteiTsnKanouGkpHrk, BizUtil.ZERO_FILL);
                        msgMongon = MakeHubiMsg.exec(MessageId.EHC1041, MessageId.EHC1041, hubiMsgGendoP, hubiMsgTsnKanouGkp);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    }
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                else {
                    if (hanteiTsnKanouGkpHrk.compareTo(saiteiP) < 0) {
                        setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1019), C_SekmossakuseiErroutKbn.GAMEN, pMp);
                    }
                    else {
                        String hubiMsgTuuka = setHubiMsg.editHubiMsgKingakuPKans(
                            hanteiTsnKanouGkpHrk,
                            taniP,
                            mosKihon.getHrktuukasyu(),
                            true,
                            pMp,
                            mosKihon,
                            syouhnZokusei);
                        String replaceMsg = "";
                        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                        replaceMsg = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syouhnZokusei);

                        setHubiMsg.exec(MessageUtil.getMessage(MessageId.EGA1034),
                            MessageUtil.getMessage(MessageId.EGA1027, replaceMsg, hubiMsgTuuka),
                            C_SekmossakuseiErroutKbn.GAMEN, pMp);
                    }

                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN.eq(tkthknsyruitsnKbn) &&
            !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {

            BizCurrency gndSKykTuuka = null;

            if (tsnSibouGndS5.compareTo(tsnSntktuukaHijynSysnS) < 0) {

                BizCurrency gndPHknnYkjTuuka = null;

                if (C_Sdpd.PD.eq(sdpdKbn)) {

                    hanteiTsnKanouGks = tsnSibouGndS5.subtract(tuusan.getTsnsntktuukahijynsysns());

                    gndPHknnYkjTuuka = getGndHaninaiP(
                        syoriCtl,
                        mosKihon,
                        mosSyouhn,
                        pMp.getKiteiCheckChannelCd(),
                        hanteiTsnKanouGks,
                        pMp.getPdateSRate(),
                        pMp.getHrbtJyousu(),
                        ptratkituukasiteiKbn);

                    if (!saiteipSyutkGtFlg) {

                        C_Kykjyoutai kykJyoutai = getKykjyoutai(mosKihon);

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
                        C_ErrorKbn errorKbn = keisanSP.exec(
                            mosSyouhn.getSyouhncd(),
                            mosSyouhn.getRyouritusdno(),
                            mosSyouhn.getYoteiriritu(),
                            mosKihon.getHrkkaisuu(),
                            mosKihon.getHhknnen(),
                            mosKihon.getHhknsei(),
                            mosSyouhn.getHknkknsmnkbn(),
                            mosSyouhn.getHknkkn(),
                            mosSyouhn.getHrkkkn(),
                            C_Sdpd.PD,
                            null,
                            gndPHknnYkjTuuka,
                            kykTuukasyu,
                            kykJyoutai,
                            mosSyouhn.getDai1hknkkn(),
                            mosKihon.getHrkkeiro());

                        BizCurrency kennshouS = null;

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            kennshouS = BizCurrency.valueOf(0);

                        }
                        else {

                            kennshouS = keisanSP.getS();
                        }

                        if (kennshouS.compareTo(saiteis) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                    else {

                        if (gndPHknnYkjTuuka.compareTo(saiteiP) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                }
                else {

                    hanteiTsnKanouGks = tsnSibouGndS5.subtract(tuusan.getTsnsntktuukahijynsysns());

                    gndSKykTuuka = getGndHaninaiS(
                        syoriCtl,
                        mosKihon,
                        mosSyouhn,
                        hanteiTsnKanouGks);

                    if (gndSKykTuuka.compareTo(saiteis) < 0) {

                        gkKansMsgGtFlg = false;
                    }
                    else {

                        gkKansMsgGtFlg = true;
                    }
                }

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    if (!gkKansMsgGtFlg) {

                        String hubiMsgYen = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS5, BizUtil.ZERO_FILL);

                        msgMongon = MakeHubiMsg.exec(MessageId.EHC1167, MessageId.EHC1167, hubiMsgYen);

                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgMongon,
                            pMp,
                            tstkTuukahijynSysnsTknKbn,
                            C_MsgKbn.ERROR);
                    }
                    else {

                        String hubiMsgYen = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS5, BizUtil.ZERO_FILL);

                        BizCurrency kingaku = null;

                        if (C_Sdpd.PD.eq(sdpdKbn)) {

                            kingaku = gndPHknnYkjTuuka;
                        }
                        else {

                            kingaku = gndSKykTuuka;
                        }

                        String hubiMsgTuuka = ViewReport.editCommaTuukaNoSpace(kingaku, BizUtil.ZERO_FILL);

                        if (C_Sdpd.PD.eq(sdpdKbn)) {

                            msgMongon = MakeHubiMsg.exec(MessageId.EHC1168, MessageId.EHC1168, hubiMsgYen, hubiMsgS, hubiMsgTuuka);
                        }
                        else {

                            msgMongon = MakeHubiMsg.exec(MessageId.EHC1168, MessageId.EHC1168, hubiMsgYen, hubiMsgSkykhkkmds, hubiMsgTuuka);
                        }

                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgMongon,
                            pMp,
                            tstkTuukahijynSysnsTknKbn,
                            C_MsgKbn.ERROR);
                    }

                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                else {

                    makeMsgEigyouSien(
                        pMp,
                        mosKihon,
                        syouhnZokusei,
                        gndPHknnYkjTuuka,
                        taniP,
                        gndSKykTuuka,
                        taniS,
                        gkKansMsgGtFlg);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnNinenMiKkSouSbsUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {

            if (tsnSibouGndS2.compareTo(tsnNinenMiKkSouSbs) < 0) {

                BizCurrency gndPHknnYkjTuuka = null;

                BizCurrency gndSKykTuuka = null;

                if (C_Sdpd.PD.equals(sdpdKbn)) {
                    BizCurrency takykTsnNinenMikeikaSouSbs =
                        tuusan.getTsnninenmikeikas().subtract(tuusan.getTsnninenmikeikahtnkns()).add(tuusan.getTsnninenkeikadfp());

                    hanteiTsnKanouGks = tsnSibouGndS2.subtract(takykTsnNinenMikeikaSouSbs);

                    gndPHknnYkjTuuka = getGndHaninaiP(
                        syoriCtl, mosKihon, mosSyouhn, pMp.getKiteiCheckChannelCd(), hanteiTsnKanouGks,
                        pMp.getPdateSRate(), pMp.getHrbtJyousu(), ptratkituukasiteiKbn);

                    if (!saiteipSyutkGtFlg) {

                        C_Kykjyoutai kykJyoutai = getKykjyoutai(mosKihon);

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
                        C_ErrorKbn errorKbn = keisanSP.exec(
                            mosSyouhn.getSyouhncd(),
                            mosSyouhn.getRyouritusdno(),
                            mosSyouhn.getYoteiriritu(),
                            mosKihon.getHrkkaisuu(),
                            mosKihon.getHhknnen(),
                            mosKihon.getHhknsei(),
                            mosSyouhn.getHknkknsmnkbn(),
                            mosSyouhn.getHknkkn(),
                            mosSyouhn.getHrkkkn(),
                            C_Sdpd.PD,
                            null,
                            gndPHknnYkjTuuka,
                            kykTuukasyu,
                            kykJyoutai,
                            mosSyouhn.getDai1hknkkn(),
                            mosKihon.getHrkkeiro());

                        BizCurrency kennshouS = null;

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            kennshouS = BizCurrency.valueOf(0);

                        }
                        else {

                            kennshouS = keisanSP.getS();
                        }

                        if (kennshouS.compareTo(saiteis) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                    else {

                        if (gndPHknnYkjTuuka.compareTo(saiteiP) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                }
                else {

                    BizCurrency takykTsnNinenMikeikaSouSbs =
                        tuusan.getTsnninenmikeikas().subtract(tuusan.getTsnninenmikeikahtnkns()).add(tuusan.getTsnninenkeikadfp());
                    hanteiTsnKanouGks = tsnSibouGndS2.subtract(takykTsnNinenMikeikaSouSbs);

                    gndSKykTuuka = getGndHaninaiS(syoriCtl, mosKihon, mosSyouhn, hanteiTsnKanouGks);

                    if (gndSKykTuuka.compareTo(saiteis) < 0) {

                        gkKansMsgGtFlg = false;
                    }
                    else {

                        gkKansMsgGtFlg = true;
                    }
                }

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    if (!gkKansMsgGtFlg) {

                        String hubiMsgYen = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS2, BizUtil.ZERO_FILL);

                        msgMongon = MakeHubiMsg.exec(MessageId.EHC1044, MessageId.EHC1044, hubiMsgYen);

                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgMongon,
                            pMp,
                            tknKbn,
                            C_MsgKbn.ERROR);
                    }
                    else {
                        String hubiMsgTsnS = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS2, BizUtil.ZERO_FILL);

                        BizCurrency kingaku = null;
                        String replaceStr2 = null;

                        if (C_Sdpd.PD.eq(sdpdKbn)) {

                            kingaku = gndPHknnYkjTuuka;
                            replaceStr2 = hubiMsgS;
                        }
                        else {

                            kingaku = gndSKykTuuka;
                            replaceStr2 = hubiMsgSkykhkkmds;
                        }

                        String hubiMsgTuuka = ViewReport.editCommaTuukaNoSpace(kingaku, BizUtil.ZERO_FILL);

                        msgMongon = MakeHubiMsg.exec(
                            MessageId.EHC1045, MessageId.EHC1045, hubiMsgTsnS, replaceStr2, hubiMsgTuuka);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    }

                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                else {

                    makeMsgEigyouSien(
                        pMp,
                        mosKihon,
                        syouhnZokusei,
                        gndPHknnYkjTuuka,
                        taniP,
                        gndSKykTuuka,
                        taniS,
                        gkKansMsgGtFlg);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnSouSbsUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (tsnSibouGndS1.compareTo(tsnSouSbs) < 0) {

                BizCurrency gndPHknnYkjTuuka = null;
                BizCurrency gndSKykTuuka = null;

                if (C_Sdpd.PD.equals(sdpdKbn)) {
                    hanteiTsnKanouGks = tsnSibouGndS1.subtract(tuusan.getTsnsibous());
                    gndPHknnYkjTuuka = getGndHaninaiP(
                        syoriCtl, mosKihon, mosSyouhn, pMp.getKiteiCheckChannelCd(), hanteiTsnKanouGks,
                        pMp.getPdateSRate(), pMp.getHrbtJyousu(), ptratkituukasiteiKbn);

                    if (!saiteipSyutkGtFlg) {

                        C_Kykjyoutai kykJyoutai = getKykjyoutai(mosKihon);

                        KeisanSP keisanSP = SWAKInjector.getInstance(KeisanSP.class);
                        C_ErrorKbn errorKbn = keisanSP.exec(
                            mosSyouhn.getSyouhncd(),
                            mosSyouhn.getRyouritusdno(),
                            mosSyouhn.getYoteiriritu(),
                            mosKihon.getHrkkaisuu(),
                            mosKihon.getHhknnen(),
                            mosKihon.getHhknsei(),
                            mosSyouhn.getHknkknsmnkbn(),
                            mosSyouhn.getHknkkn(),
                            mosSyouhn.getHrkkkn(),
                            C_Sdpd.PD,
                            null,
                            gndPHknnYkjTuuka,
                            kykTuukasyu,
                            kykJyoutai,
                            mosSyouhn.getDai1hknkkn(),
                            mosKihon.getHrkkeiro());

                        BizCurrency kennshouS = null;

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            kennshouS = BizCurrency.valueOf(0);

                        }
                        else {

                            kennshouS = keisanSP.getS();
                        }

                        if (kennshouS.compareTo(saiteis) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                    else {

                        if (gndPHknnYkjTuuka.compareTo(saiteiP) < 0) {

                            gkKansMsgGtFlg = false;
                        }
                        else {

                            gkKansMsgGtFlg = true;
                        }
                    }
                }
                else {

                    hanteiTsnKanouGks = tsnSibouGndS1.subtract(tuusan.getTsnsibous());

                    gndSKykTuuka = getGndHaninaiS(
                        syoriCtl,
                        mosKihon,
                        mosSyouhn,
                        hanteiTsnKanouGks);

                    if (gndSKykTuuka.compareTo(saiteis) < 0) {

                        gkKansMsgGtFlg = false;
                    }
                    else {

                        gkKansMsgGtFlg = true;
                    }
                }

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    if (!gkKansMsgGtFlg) {

                        String hubiMsgYen = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS1, BizUtil.ZERO_FILL);

                        msgMongon = MakeHubiMsg.exec(MessageId.EHC1042, MessageId.EHC1042, hubiMsgYen);

                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgMongon,
                            pMp,
                            tknKbn,
                            C_MsgKbn.ERROR);
                    }
                    else {

                        String hubiMsgYen = ViewReport.editCommaTuukaNoSpace(tsnSibouGndS1, BizUtil.ZERO_FILL);

                        BizCurrency kingaku = null;
                        String replaceStr2 = null;

                        if (C_Sdpd.PD.eq(sdpdKbn)) {

                            kingaku = gndPHknnYkjTuuka;
                            replaceStr2 = hubiMsgS;
                        }
                        else {

                            kingaku = gndSKykTuuka;
                            replaceStr2 = hubiMsgSkykhkkmds;
                        }

                        String hubiMsgTuuka = ViewReport.editCommaTuukaNoSpace(kingaku, BizUtil.ZERO_FILL);
                        msgMongon = MakeHubiMsg.exec(
                            MessageId.EHC1043, MessageId.EHC1043, hubiMsgYen, replaceStr2, hubiMsgTuuka);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    }

                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                else {

                    makeMsgEigyouSien(
                        pMp,
                        mosKihon,
                        syouhnZokusei,
                        gndPHknnYkjTuuka,
                        taniP,
                        gndSKykTuuka,
                        taniS,
                        gkKansMsgGtFlg);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnNenkinGensiUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn)) {
                List<BM_ChkNkgns> chkNkgnsLst = bizDomManager.getChkNkgnssByPK(hhknNen);
                if (chkNkgnsLst == null || chkNkgnsLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                nkGnsGndgk = chkNkgnsLst.get(0).getNkgnsgndgk();
                tknKbn = C_TknKbn.KANOU;
            }
            if (C_TsngndtknKbn.ARI.eq(tsnGndTknKbn)) {
                List<BM_ChkJhNkgns> chkJhNkgnsLst = bizDomManager.getChkJhNkgnssByPK(hhknNen);
                if (chkJhNkgnsLst == null || chkJhNkgnsLst.size() == 0) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                nkGnsGndgk = chkJhNkgnsLst.get(0).getNkgnsgndgk();
                tknKbn = C_TknKbn.NONE;
            }

            if (nkGnsGndgk.compareTo(tsnNenkinGensi) < 0) {
                if (C_Sdpd.PD.eq(sdpdKbn)) {
                    BizCurrency hanteiTuusanKanouNkgnsYen = nkGnsGndgk.subtract(tuusan.getTsnnkgns());
                    boolean kanouHanipAriFlg = false;

                    BizCurrency hrktuukaGendoP = BizCurrency.valueOf(0);

                    if (hanteiTuusanKanouNkgnsYen
                        .compareTo(BizCurrency.valueOf(0, hanteiTuusanKanouNkgnsYen.getType())) > 0) {
                        if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                            EditHeijyunbaraiP editHeijyunbaraiP = SWAKInjector.getInstance(EditHeijyunbaraiP.class);

                            C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(
                                hanteiTuusanKanouNkgnsYen, hrkkaisuu, mosSyouhn.getHrkkkn(),
                                mosSyouhn.getHrkkknsmnkbn(), Integer.valueOf(hhknNen.toString()), C_HasuusyoriKbn.SUTE);

                            if (C_ErrorKbn.OK.eq(errorKbn)) {
                                BizCurrency heijyunbaraiP = editHeijyunbaraiP.getHeijyunbaraiP();

                                heijyunbaraiP = taniP.multiplyCurrency(heijyunbaraiP.divideCurrency(taniP, 0,
                                    RoundingMode.DOWN));

                                if (heijyunbaraiP.compareTo(saiteiP) >= 0) {
                                    hrktuukaGendoP = heijyunbaraiP;

                                    kanouHanipAriFlg = true;
                                }
                            }
                        }
                        else {
                            BizCurrency haseiSyupHrk = getGndHaninaiPbyItjbrSouhrkp(syoriCtl, mosKihon, mosSyouhn,
                                pMp.getKiteiCheckChannelCd(), hanteiTuusanKanouNkgnsYen, C_UmuKbn.ARI, ptratkituukasiteiKbn);

                            if (haseiSyupHrk.compareTo(saiteiP) >= 0) {
                                hrktuukaGendoP = haseiSyupHrk;
                                kanouHanipAriFlg = true;
                            }

                        }

                    }
                    if (!kanouHanipAriFlg) {
                        if (C_SysKbn.SKEI.eq(sysKbn)) {
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                MessageId.EHC1063 + " " + MessageUtil.getMessage(MessageId.EHC1063, ViewReport.editCommaTuukaNoSpace(nkGnsGndgk, BizUtil.ZERO_FILL)),
                                pMp, tknKbn, C_MsgKbn.ERROR);
                        }
                        else {
                            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1039),
                                C_SekmossakuseiErroutKbn.GAMEN, pMp);
                        }
                    }
                    else {
                        if (C_SysKbn.SKEI.eq(sysKbn)) {
                            msgMongon = MakeHubiMsg.exec(MessageId.EHC1064, MessageId.EHC1064,
                                ViewReport.editCommaTuukaNoSpace(nkGnsGndgk, BizUtil.ZERO_FILL), hubiMsgS,
                                ViewReport.editCommaTuukaNoSpace(hrktuukaGendoP, BizUtil.ZERO_FILL));
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                        }
                        else {
                            String messageUpper = MessageUtil.getMessage(MessageId.EGA1040);

                            HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);
                            String editMoji = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syouhnZokusei);

                            String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(
                                hrktuukaGendoP, taniP, hrkTuukasyu, true, pMp, mosKihon, syouhnZokusei);

                            String messageLower = MessageUtil.getMessage(MessageId.EGA1027, editMoji, hubiMsg);

                            setHubiMsg.exec(messageUpper, messageLower, C_SekmossakuseiErroutKbn.GAMEN, pMp);
                        }
                    }
                }
                else {
                    msgMongon = makeMsg(MessageId.EHC1027, MessageId.EHC1027, nkGnsGndgk, tsnNenkinGensi);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                }
                pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
            }
        }


        if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn) && C_UmuKbn.ARI.eq(tsnNrbtItijibrSouSbsUmu) &&
            !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (!BizUtil.isBlank(hhknSykgycd)) {
                BM_ChkSyokugyou chkSyokugyou = bizDomManager.getChkSyokugyou(hhknSykgycd);
                if (chkSyokugyou != null) {
                    skgyouTsnGndS = chkSyokugyou.getGnds();
                    if (skgyouTsnGndS.compareTo(tsnSouSbs) < 0) {
                        if (C_SysKbn.SKEI.eq(sysKbn)) {
                            msgMongon = makeMsg(MessageId.EHC1029, MessageId.EHC1029, skgyouTsnGndS, tsnSouSbs);
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                            pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                        }
                        if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                            pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                        }
                    }
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnNrbtSouSbsUmu) &&
            !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (tsnSibouGndS3.compareTo(tsnSouSbs) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1030, MessageId.EHC1030, tsnSibouGndS3, tsnSouSbs);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }
        else if (C_UmuKbn.ARI.eq(tsnNrbtItijibrSouSbsUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            List<BM_ChkItijibrTuusanS> chkItijibrTuusanSLst = bizDomManager.getChkItijibrTuusanSsByPK(hhknNen);
            if (chkItijibrTuusanSLst == null || chkItijibrTuusanSLst.size() == 0) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            itijibrTsnGndS = chkItijibrTuusanSLst.get(0).getGnds();
            if (itijibrTsnGndS.compareTo(tsnNrbtItijibrSouSbs) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1030, MessageId.EHC1030, itijibrTsnGndS, tsnNrbtItijibrSouSbs);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        C_UmuKbn nensyuuTsnOverUmu = C_UmuKbn.NONE;

        if (C_UmuKbn.NONE.eq(nkhknUmu) && !C_NensyuuKbn.BLNK.eq(nensyuuKbn)) {
            BM_ChkNensyuuBairitu chkNensyuuBairitu = bizDomManager.getChkNensyuuBairitu(nensyuuKbn);
            if (chkNensyuuBairitu == null) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            nsyuBairetuGndS = chkNensyuuBairitu.getGnds();

            if (nsyuBairetuGndS.compareTo(tsnSouSbs) < 0) {
                nensyuuTsnOverUmu =C_UmuKbn.ARI;
                pMp.setNensyuTuusanSOverHanteiKekka(true);
            }
        }


        if (C_TsngndtknKbn.NONE.eq(tsnGndTknKbn) &&
            C_UmuKbn.ARI.eq(tsnNrbtItijibrSouSbsUmu) &&
            !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {

            if (C_UmuKbn.ARI.eq(nensyuuTsnOverUmu)) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1032, MessageId.EHC1032, nsyuBairetuGndS, tsnSouSbs);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                    pMp.setNensyuTuusanSOverHanteiKekka(true);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnMsnyouNrbtSouSbsUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (tsnSibouGndS4.compareTo(tsnMsnyouNrbtSouSbs) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1028, MessageId.EHC1028, tsnSibouGndS4, tsnMsnyouNrbtSouSbs);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnSouKktJituHosyouGkUmu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (kktTsnsGndS1.compareTo(tsnSouKktJituHosyouGk) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1024, MessageId.EHC1024, kktTsnsGndS1, tsnSouKktJituHosyouGk);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnKktJituHosyouGk1Umu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (kktTsnsGndS2.compareTo(tsnKktJituHosyouGk1) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1025, MessageId.EHC1025, kktTsnsGndS2, tsnKktJituHosyouGk1);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_UmuKbn.ARI.eq(tsnKktJituHosyouGk2Umu) && !C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            if (kktTsnsGndS3.compareTo(tsnKktJituHosyouGk2) < 0) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    msgMongon = makeMsg(MessageId.EHC1026, MessageId.EHC1026, kktTsnsGndS3, tsnKktJituHosyouGk2);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, tknKbn, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }


        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if (C_UmuKbn.ARI.eq(kyksyaDouituDrtTsnsUmu) &&
                (C_UmuKbn.ARI.eq(pMp.getTkrtkKinyuuknUmuKbn()) || C_UmuKbn.ARI.eq(pMp.getKydsskKinyuuknUmuKbn())) &&
                !C_UmuKbn.ARI.eq(syoriCtl.getTkhsyouryakuumukbn())) {

                BM_ChkKykDairitenTuusanS chkKykDairitenTuusanS = bizDomManager.getChkKykDairitenTuusanS(kihonsSyuruiKbn);
                if (chkKykDairitenTuusanS == null) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                BizCurrency kykDrtenGnds = chkKykDairitenTuusanS.getGnds();

                if (kykDrtenGnds.compareTo(kyksyaDouituDrtTsns) < 0) {
                    String msgKykDrtenGnds = BizUtil.comma(kykDrtenGnds.toString());
                    String msgKykDrtenTsnS = BizUtil.comma(kyksyaDouituDrtTsns.toString());

                    msgMongon = makeMsg(MessageId.EHC1031, MessageId.EHC1031, kykDrtenGnds, kyksyaDouituDrtTsns);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgMongon, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 通算チェック 終了");

        }
    }

    public BizCurrency getPTani(HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn,
        C_Channelcd pChannelcd,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {
        BizCurrency ptani = null;
        String mosNo = pSyoriCTL.getMosno();

        C_Tuukasyu tuukasyu = null;

        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pPtratkituukasiteiKbn)) {

            tuukasyu = pMosKihon.getHrktuukasyu();
        }
        else {

            tuukasyu = pMosKihon.getKyktuukasyu();
        }

        List<BM_ChkHrkPTani> chkHrkPTaniLst = bizDomManager.getChkHrkPTanisByPK(
            pMosSyouhn.getSyouhncd(),
            pMosKihon.getHrkkaisuu(),
            pMosSyouhn.getSyouhnsdno(),
            pChannelcd,
            tuukasyu);

        if (chkHrkPTaniLst.size() > 0) {
            ptani = chkHrkPTaniLst.get(0).getHrkptani();
        }
        else {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        return ptani;
    }

    public BizCurrency getSTani(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn) {

        BizCurrency stani = null;

        List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK(
            pMosSyouhn.getSyouhncd(),
            pMosSyouhn.getSyouhnsdno(),
            BizNumber.valueOf(pMosKihon.getHhknnen()),
            pMosKihon.getKyktuukasyu());

        if (chkSTaniLst == null || chkSTaniLst.size() == 0) {

            throw new CommonBizAppException("Ｓ単位テーブルにデータが見つかりません。");
        }
        stani = chkSTaniLst.get(0).getStani();

        return stani;
    }

    public BizCurrency editTuukaKykToHrk(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, BizCurrency pKyktuukaGk) {
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency kansanGk = null;
        C_Tuukasyu kykTuukasyu = pMosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukasyu = pMosKihon.getHrktuukasyu();

        if (kykTuukasyu.eq(hrkTuukasyu)) {
            kansanGk = pKyktuukaGk;
        }
        else {
            BizNumber nyknkwsRate = pSyoriCTL.getNyknkwsrate();

            kansanGk = keisanGaikakanzan.exec(pMosKihon.getHrktuukasyu(), pKyktuukaGk, nyknkwsRate,
                C_HasuusyoriKbn.SUTE);
        }

        return kansanGk;
    }

    public BizCurrency editTuukaKyktuukaToEn(HT_MosKihon pMosKihon, BizCurrency pKyktuukaGk) {
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        BizCurrency kansanGk = getKiteiCheckYenkansangk.exec(
            pMosKihon.getMosymd(), pKyktuukaGk, pMosKihon.getKyktuukasyu());

        return kansanGk;
    }

    public BizCurrency editTuukaEnToKyktuuka(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, BizCurrency pYenGk) {
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency kansanGk = null;
        C_Tuukasyu kykTuukasyu = pMosKihon.getKyktuukasyu();
        String mosNo = pSyoriCTL.getMosno();

        if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {
            kansanGk = pYenGk;
        }
        else {
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            int kijunNendo = setKessanNensibi.exec(pMosKihon.getMosymd()).getYear();

            BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate =
                bizDomManager.getKijyungkHanteiKawaseRate(String.valueOf(kijunNendo), kykTuukasyu);

            if (kijyungkHanteiKawaseRate == null) {
                throw new CommonBizAppException("申込番号 = " + mosNo);
            }

            BizNumber kjngkHntiyuKawaseRate = kijyungkHanteiKawaseRate.getKjngkhntiyukawaserate();

            kansanGk = keisanGaikakanzan.execDivide(kykTuukasyu, pYenGk, kjngkHntiyuKawaseRate, C_HasuusyoriKbn.AGE);
        }

        return kansanGk;
    }

    public BizCurrency getGndHaninaiP(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn,
        C_Channelcd pChannelcd, BizCurrency pHanteiTsnKanouGks, BizNumber pPdatesrate, BizNumber pHrbtJyousu,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu kykTuukasyu = pMosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukasyu = pMosKihon.getHrktuukasyu();
        C_Hrkkaisuu hrkkaisuu = pMosKihon.getHrkkaisuu();
        BizNumber pdatesrate = pPdatesrate;
        BizNumber hrbtJyousu = pHrbtJyousu;
        C_PtratkituukasiteiKbn ptratkituukasiteiKbn = pPtratkituukasiteiKbn;
        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);
        BizCurrency hanteiTsnKanouGkpKyk = BizCurrency.valueOf(0, kykCurrencyType);


        BizCurrency hanteiTsnKanouGkKykutuuka = null;
        if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {

            BizCurrency hanteiTsnKanouGksYen = pHanteiTsnKanouGks.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));

            hanteiTsnKanouGkKykutuuka = editTuukaEnToKyktuuka(pSyoriCTL, pMosKihon, hanteiTsnKanouGksYen);

            hanteiTsnKanouGkKykutuuka = hanteiTsnKanouGkKykutuuka.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, hanteiTsnKanouGkKykutuuka.getType()));
        }
        else {

            hanteiTsnKanouGkKykutuuka = pHanteiTsnKanouGks;
        }

        if (pdatesrate != null) {

            hanteiTsnKanouGkpKyk = hanteiTsnKanouGkKykutuuka.divide(pdatesrate, 0 ,RoundingMode.DOWN);
        }
        else {

            BizCurrency hanteiTsnKanouGkpkpnKyk = BizCurrency.valueOf(0, kykCurrencyType);

            return hanteiTsnKanouGkpkpnKyk;
        }

        if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

            if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                hanteiTsnKanouGkpKyk = hanteiTsnKanouGkpKyk.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));
            }
            else {
                hanteiTsnKanouGkpKyk = hanteiTsnKanouGkpKyk.add(BizCurrency.valueOf(GAIKA_MIN_TANI, hanteiTsnKanouGkpKyk.getType()));
            }

            hanteiTsnKanouGkpKyk = hanteiTsnKanouGkpKyk.multiply(hrbtJyousu);

            if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                hanteiTsnKanouGkpKyk = hanteiTsnKanouGkpKyk.subtract(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));
            }
            else {
                hanteiTsnKanouGkpKyk = hanteiTsnKanouGkpKyk.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, hanteiTsnKanouGkpKyk.getType()));
            }
        }

        BizCurrency hntiTsnKanouGkpPYakujyoutuuka = null;

        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(ptratkituukasiteiKbn) && !hrkTuukasyu.eq(kykTuukasyu)) {

            hntiTsnKanouGkpPYakujyoutuuka = editTuukaKykToHrk(pSyoriCTL, pMosKihon, hanteiTsnKanouGkpKyk);

        }
        else {

            hntiTsnKanouGkpPYakujyoutuuka = hanteiTsnKanouGkpKyk;
        }


        BizCurrency ptani = getPTani(pSyoriCTL,
            pMosKihon,
            pMosSyouhn,
            pChannelcd,
            ptratkituukasiteiKbn);

        hntiTsnKanouGkpPYakujyoutuuka = ptani.multiply(hntiTsnKanouGkpPYakujyoutuuka.divideBizCurrency(ptani, 0, RoundingMode.DOWN));

        return hntiTsnKanouGkpPYakujyoutuuka;
    }

    public BizCurrency getGndHaninaiPbyItjbrSouhrkp(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn, C_Channelcd pChannelCd, BizCurrency pHanteiTsnKanouGk, C_UmuKbn pPTaniTyouseiUmu,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn) {

        C_Tuukasyu kykTuukasyu = pMosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukasyu = pMosKihon.getHrktuukasyu();

        BizCurrency hanteiSouHrkP_Hrk;
        if (!C_Tuukasyu.JPY.eq(hrkTuukasyu)) {
            BizCurrency hanteiTsnKanouGk = pHanteiTsnKanouGk.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));
            BizCurrency hanteiSouHrkP_Kyk = editTuukaEnToKyktuuka(pSyoriCTL, pMosKihon, hanteiTsnKanouGk);
            hanteiSouHrkP_Kyk = hanteiSouHrkP_Kyk.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, hanteiSouHrkP_Kyk.getType()));

            if (!kykTuukasyu.eq(hrkTuukasyu)) {
                hanteiSouHrkP_Hrk = editTuukaKykToHrk(pSyoriCTL, pMosKihon, hanteiSouHrkP_Kyk);
            }
            else {
                hanteiSouHrkP_Hrk = hanteiSouHrkP_Kyk;
            }
        }
        else {
            hanteiSouHrkP_Hrk = pHanteiTsnKanouGk;
        }

        BizCurrency hanteiHrkTaniP_Hrk = hanteiSouHrkP_Hrk;

        if (!C_UmuKbn.ARI.eq(pPTaniTyouseiUmu)) {
            return hanteiHrkTaniP_Hrk;
        }

        BizCurrency taniP = getPTani(pSyoriCTL, pMosKihon, pMosSyouhn, pChannelCd, pPtratkituukasiteiKbn);
        hanteiHrkTaniP_Hrk = taniP.multiplyCurrency(hanteiHrkTaniP_Hrk.divideCurrency(taniP, 0, RoundingMode.DOWN));

        if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {
            return hanteiHrkTaniP_Hrk;
        }

        BizCurrency testSouHrkP_Hrk = hanteiHrkTaniP_Hrk;

        BizCurrency testSouHrkP_Kyk;
        if (!kykTuukasyu.eq(hrkTuukasyu)) {
            testSouHrkP_Kyk = editTuukaHrkToKyk(pSyoriCTL, pMosKihon, testSouHrkP_Hrk);
        }
        else {
            testSouHrkP_Kyk = testSouHrkP_Hrk;
        }

        BizCurrency testSouHrkP_Yen = editTuukaKyktuukaToEn(pMosKihon, testSouHrkP_Kyk);

        if (testSouHrkP_Yen.compareTo(pHanteiTsnKanouGk) > 0) {
            return hanteiHrkTaniP_Hrk.subtract(taniP);
        }
        else {
            return hanteiHrkTaniP_Hrk;
        }
    }

    public BizCurrency getGndHaninaiS(
        HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn,
        BizCurrency pHanteiTsnKanouGks) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu Kyktuukasyu = pMosKihon.getKyktuukasyu();

        CurrencyType kyktuukaType = henkanTuuka.henkanTuukaKbnToType(Kyktuukasyu);

        BizCurrency hntiTsnKanouGkSKyktuuka = BizCurrency.valueOf(0, kyktuukaType);

        if (!C_Tuukasyu.JPY.eq(Kyktuukasyu)) {

            BizCurrency hanteiTsnKanouGks = pHanteiTsnKanouGks.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));

            hntiTsnKanouGkSKyktuuka = editTuukaEnToKyktuuka(pSyoriCTL, pMosKihon, hanteiTsnKanouGks);

            hntiTsnKanouGkSKyktuuka = hntiTsnKanouGkSKyktuuka.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, hntiTsnKanouGkSKyktuuka.getType()));
        }
        else {

            hntiTsnKanouGkSKyktuuka = pHanteiTsnKanouGks;
        }

        BizCurrency taniS = getSTani(pSyoriCTL, pMosKihon, pMosSyouhn);
        hntiTsnKanouGkSKyktuuka = taniS.multiply(
            hntiTsnKanouGkSKyktuuka.divideBizCurrency(taniS, 0, RoundingMode.DOWN));

        return hntiTsnKanouGkSKyktuuka;
    }

    private String makeMsg(String pInMessageId,
        String pMsgId,
        BizCurrency pReplaceMsg1,
        BizCurrency pReplaceMsg2) {

        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageId);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgId,
            ViewReport.editCommaTuukaNoSpace(pReplaceMsg1, BizUtil.ZERO_FILL),
            ViewReport.editCommaTuukaNoSpace(pReplaceMsg2, BizUtil.ZERO_FILL)));
        return ret.toString();
    }

    private BizCurrency editTuukaHrkToKyk(HT_SyoriCTL pSyoriCTL, HT_MosKihon pMosKihon, BizCurrency pHrktuukaGk) {
        BizCurrency kansanGk = null;
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (pMosKihon.getKyktuukasyu().eq(pMosKihon.getHrktuukasyu())) {
            kansanGk = pHrktuukaGk;
        }
        else {
            kansanGk = keisanGaikakanzan.execDivide(
                pMosKihon.getKyktuukasyu(),
                pHrktuukaGk,
                pSyoriCTL.getNyknkwsrate(),
                C_HasuusyoriKbn.AGE);
        }

        return kansanGk;
    }


    private void makeMsgEigyouSien(MosnaiCheckParam pMp,
        HT_MosKihon pMosKihon,
        BM_SyouhnZokusei pSyouhnZokusei,
        BizCurrency pHknYakujouTuukaGendoP,
        BizCurrency pPTani,
        BizCurrency pGndS,
        BizCurrency pStani,
        boolean pKgkkshMsggtFlg) {

        if (!pKgkkshMsggtFlg) {
            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1020), C_SekmossakuseiErroutKbn.GAMEN, pMp);
        }
        else {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            BizCurrency kingaku = null;
            BizCurrency gkSiteiTani = null;
            C_Tuukasyu tuukasyu =  null;

            if (C_Sdpd.PD.eq(pMosKihon.getSdpdkbn())) {

                kingaku = pHknYakujouTuukaGendoP;

                gkSiteiTani = pPTani;

                tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pHknYakujouTuukaGendoP.getType());
            }
            else {

                kingaku = pGndS;
                gkSiteiTani = pStani;
                tuukasyu =  henkanTuuka.henkanTuukaTypeToKbn(pGndS.getType());
            }

            String hubiMsgTuuka = setHubiMsg.editHubiMsgKingakuPKans(
                kingaku, gkSiteiTani, tuukasyu, true, pMp, pMosKihon, pSyouhnZokusei);
            String replaceMsg = "";
            HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

            if (C_Sdpd.PD.eq(pMosKihon.getSdpdkbn())) {

                replaceMsg = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, pMosKihon, pSyouhnZokusei);
            }
            else {

                replaceMsg = hubiMsgEdit.editSeihoWebMsg_Hokenkngk(pMp, pMosKihon, pSyouhnZokusei);
            }

            setHubiMsg.exec(MessageUtil.getMessage(MessageId.EGA1026),
                MessageUtil.getMessage(MessageId.EGA1027, replaceMsg, hubiMsgTuuka),
                C_SekmossakuseiErroutKbn.GAMEN, pMp);
        }

        pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
    }

    private C_Kykjyoutai getKykjyoutai(HT_MosKihon pMosKihon) {

        C_Kykjyoutai kykJyoutai = null;

        if (C_Hrkkaisuu.ITIJI.eq(pMosKihon.getHrkkaisuu())) {

            kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        }
        else if (C_UmuKbn.ARI.eq(pMosKihon.getZennoumousideumu())) {

            kykJyoutai = C_Kykjyoutai.ZENNOU;
        }
        else if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {

            kykJyoutai = C_Kykjyoutai.IKKATUNK;
        }
        else {

            kykJyoutai = C_Kykjyoutai.HRKMTYUU;
        }

        return kykJyoutai;

    }
}