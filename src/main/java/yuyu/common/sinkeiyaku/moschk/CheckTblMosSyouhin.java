package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.ChkSaikouSSTaniParam;
import yuyu.common.biz.bzcommon.ChkSaiteiSParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.DrtenTkykTratkiHantei;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditString;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KktatkichkkekkaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_MosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.entity.BM_ChkJhNenreiHani2;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 申込内容チェック 申込商品TBLチェック
 */
public class CheckTblMosSyouhin {

    private static final int TKYK_NEN = 80;

    private static final String KYK_KNNEN_NJCHK_SKB = "DUP";

    private static final String[][] SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR = {{"ﾕｳ","ﾕｱ"},{"ﾕｴ","ﾕｲ"},{"ﾕｷ","ﾕｵ"},{"ﾕｸ","ﾕｶ"}};

    private static final String[][] SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 = {{"ﾕﾋ","ﾕﾉ"},{"ﾕﾌ","ﾕﾊ"}};

    private static final String[] SAITEIHOSHOU_NASHI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR = {"ﾕｱ","ﾕｲ","ﾕｵ","ﾕｶ"};

    private static final String[] SAITEIHOSHOU_ARI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR = {"ﾕｳ","ﾕｴ","ﾕｷ","ﾕｸ"};

    private static final String[] SAITEIHOSHOU_NASHI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 = { "ﾕﾉ", "ﾕﾊ" };

    private static final String[] SAITEIHOSHOU_ARI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 = { "ﾕﾋ", "ﾕﾌ" };

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SyouhinUtil syouhinUtil;

    @Inject
    private SetHutuuSibouS setHutuuSibouS;

    @Inject
    private SetKyuuhuNitigaku setKyuuhuNitigaku;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public CheckTblMosSyouhin() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        HT_SyoriCTL syoriCtl = null;
        HT_MosKihon mosKihon = null;
        String mosNo = null;
        C_Channelcd channelCd = null;
        C_UmuKbn koktiCheckHuyoUmu;
        C_UmuKbn tokubetuKokutiUmu;
        C_NenkkntknKbn nenKknTknKbn;
        C_SpgndtknKbn spGndTknKbn;
        C_SysKbn sysKbn;
        StringBuffer kykknnennjchkskb = new StringBuffer();
        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector
            .getInstance(GetKiteiCheckYenkansangk.class);
        BizCurrency yenknsnKihons = BizCurrency.valueOf(0);
        HanteiMoschk hanteiMoschk = SWAKInjector.getInstance(HanteiMoschk.class);


        if (logger.isDebugEnabled()) {
            logger.debug("▽ 申込商品テーブルチェック 開始");
        }

        syoriCtl = pMP.getDataSyoriControl();
        mosNo = syoriCtl.getMosno();
        sysKbn = pMP.getSysKbn();
        koktiCheckHuyoUmu = pMP.getKokutiChkHuyoUmu();
        tokubetuKokutiUmu = syoriCtl.getTkbtkktumu();
        channelCd = pMP.getKiteiCheckChannelCd();

        if (C_SysKbn.ESHIEN.eq(sysKbn)) {
            nenKknTknKbn = C_NenkkntknKbn.NONE;
            spGndTknKbn = C_SpgndtknKbn.NONE;
        }
        else {
            HT_Tokunin tokunin = syoriCtl.getTokunin();

            if (tokunin == null) {
                nenKknTknKbn = C_NenkkntknKbn.NONE;
                spGndTknKbn = C_SpgndtknKbn.NONE;
            }
            else {
                if (C_NenkkntknKbn.NONE.eq(tokunin.getNenkkntknkbn())) {
                    nenKknTknKbn = C_NenkkntknKbn.NONE;
                }
                else {
                    nenKknTknKbn = C_NenkkntknKbn.ARI;
                }

                if (C_SpgndtknKbn.NONE.eq(tokunin.getSpgndtknkbn())) {
                    spGndTknKbn = C_SpgndtknKbn.NONE;
                }
                else {
                    spGndTknKbn = C_SpgndtknKbn.ARI;
                }
            }
        }

        mosKihon = syoriCtl.getMosKihon();

        List<HT_MosSyouhn> syuMosSyouhnParamLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuMosSyouhnParamLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosNo);
        }

        HT_MosSyouhn syuMosSyouhnParam = syuMosSyouhnParamLst.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei = pMP.getSyuSyouhnZokusei();

        List<BM_SyouhnZokusei> tkSyouhnZokuseiList = pMP.getListTkSyouhnZokusei();

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiSueokiKikan(syuSyouhnZokusei, tkSyouhnZokuseiList);

        if (C_YouhiKbn.YOU.eq(youhiKbn)) {

            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);

            C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(syuMosSyouhnParam.getHknkkn(),
                syuMosSyouhnParam.getHknkknsmnkbn(), syuMosSyouhnParam.getHrkkkn(),
                syuMosSyouhnParam.getHrkkknsmnkbn(), mosKihon.getHhknnen());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EBC0046 + " " + MessageUtil.getMessage(MessageId.EBC0046, "据置期間"),
                    pMP);
            }
            else {
                String syuSyouhnCd = syuMosSyouhnParam.getSyouhncd();
                Integer syuSyouhnSdNo = syuMosSyouhnParam.getSyouhnsdno();
                Integer sueokiKkn = editNenkinKoumokuUtil.getNenkinSueokikikan();
                C_SueokikknsmnKbn sueokiKknsmnKbn = C_SueokikknsmnKbn.NENMANKI;

                List<BM_ChkSueokiKikan> chkSueokiKikanList = bizDomManager.getChkSueokiKikansByPk(syuSyouhnCd,
                    syuSyouhnSdNo, channelCd, sueokiKkn, sueokiKknsmnKbn);

                checkSueokiKikan(chkSueokiKikanList, pMP);
            }
        }

        int hhknNen = mosKihon.getHhknnen();
        C_Hhknsei hhknSei = mosKihon.getHhknsei();
        C_MosKbn mosKbn = C_MosKbn.BLNK;
        int tkCount = 0;

        List<HT_MosSyouhn> mosSyouhnLstTk = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        if (mosSyouhnLstTk != null) {
            tkCount = mosSyouhnLstTk.size();
        }

        checkSKykKanouNenrei(syuMosSyouhnParam,
            syuSyouhnZokusei,
            mosKihon,
            pMP,
            nenKknTknKbn,
            kykknnennjchkskb,
            sysKbn,
            hhknNen,
            hhknSei,
            tkCount,
            channelCd);


        String syuSyouhnCd = syuMosSyouhnParam.getSyouhncd();
        Integer syuSyouhnSdNo = syuMosSyouhnParam.getSyouhnsdno();
        C_KataKbn syuKataKbn = syuMosSyouhnParam.getKatakbn();

        List<BM_ChkKata> syuChkKataLst =
            bizDomManager.getChkKatasByPk(syuSyouhnCd, syuSyouhnSdNo, C_UmuKbn.NONE, syuKataKbn);

        checkSyukykKata(syuChkKataLst,
            syuMosSyouhnParam,
            syuSyouhnZokusei,
            pMP);


        C_UmuKbn syuKyuhuUmu = syuSyouhnZokusei.getKyhkataumu();
        C_KyhgndkataKbn syuKyuhuKata = syuMosSyouhnParam.getKyhkatakbn();

        if (C_UmuKbn.ARI.eq(syuKyuhuUmu)) {
            List<BM_ChkKyuuhuKata> chkKyuuhuKataLst =
                bizDomManager.getChkKyuuhuKatasByPk(syuSyouhnCd, syuSyouhnSdNo, syuKyuhuKata);

            checkKyuhuKata(chkKyuuhuKataLst, syuMosSyouhnParam, syuSyouhnZokusei, pMP);
        }
        else {
            if (syuKyuhuKata != null) {
                if (!C_KyhgndkataKbn.BLNK.eq(syuKyuhuKata)) {
                    checkKyuhuKataMs(syuSyouhnZokusei, pMP);
                }
            }
        }

        C_UmuKbn syuKyhkinKataUmu = syuSyouhnZokusei.getSyukyhkinkataumu();
        C_SyukyhkinkataKbn syuKyhkinKataKbn = syuMosSyouhnParam.getSyukyhkinkatakbn();

        if (C_UmuKbn.ARI.eq(syuKyhkinKataUmu) && C_SyukyhkinkataKbn.BLNK.eq(syuKyhkinKataKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0045 + " " + MessageUtil.getMessage(MessageId.EBC0045, ICommonKoumoku.DISP_N_SYUKYHKINKATAKBN),
                pMP);
        }

        if (C_UmuKbn.NONE.eq(syuKyhkinKataUmu) && !C_SyukyhkinkataKbn.BLNK.eq(syuKyhkinKataKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0007 + " " + MessageUtil.getMessage(MessageId.EBC0007, ICommonKoumoku.DISP_N_SYUKYHKINKATAKBN),
                pMP);
        }

        C_UmuKbn syuKhnkyhKgbairituUmu = syuSyouhnZokusei.getKhnkyhkgbairituumu();
        C_KhnkyhkgbairituKbn syuKhnkyhKgbairituKbn = syuMosSyouhnParam.getKhnkyhkgbairitukbn();

        if (C_UmuKbn.ARI.eq(syuKhnkyhKgbairituUmu)) {
            if (C_KhnkyhkgbairituKbn.BLNK.eq(syuKhnkyhKgbairituKbn)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EBC0045 + " " + MessageUtil.getMessage(MessageId.EBC0045, ICommonKoumoku.DISP_N_KHNKYHKGBAIRITUKBN),
                    pMP);
            }
            else {
                List<BM_ChkKhnKyhKgBairitu> chkKhnKyhKgBairituLst =
                    bizDomManager.getChkKhnKyhKgBairitusByPk(syuSyouhnCd, syuSyouhnSdNo, syuKhnkyhKgbairituKbn);

                if (chkKhnKyhKgBairituLst == null || chkKhnKyhKgBairituLst.size() == 0) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0019 + " " + MessageUtil.getMessage(
                            MessageId.EHC0019, syuSyouhnZokusei.getSyouhnnm(), syuKhnkyhKgbairituKbn.getContent()),
                            pMP);
                }
            }
        }

        if (C_UmuKbn.NONE.eq(syuKhnkyhKgbairituUmu) && !C_KhnkyhkgbairituKbn.BLNK.eq(syuKhnkyhKgbairituKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0007 + " " + MessageUtil.getMessage(
                    MessageId.EBC0007, ICommonKoumoku.DISP_N_KHNKYHKGBAIRITUKBN),
                    pMP);
        }

        C_UmuKbn rokuDaisktKataUmu = syuSyouhnZokusei.getRokudaildumu();
        C_6daiLdKbn rokuDaisktKataKbn = syuMosSyouhnParam.getRokudaildkbn();

        if (C_UmuKbn.ARI.eq(rokuDaisktKataUmu) && C_6daiLdKbn.BLNK.eq(rokuDaisktKataKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0045 + " " + MessageUtil.getMessage(
                    MessageId.EBC0045, ICommonKoumoku.DISP_N_6DAISKTSYKNTUIKAKYHKATAKBN),
                    pMP);
        }

        if (C_UmuKbn.NONE.eq(rokuDaisktKataUmu) && !C_6daiLdKbn.BLNK.eq(rokuDaisktKataKbn)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0007 + " " + MessageUtil.getMessage(
                    MessageId.EBC0007, ICommonKoumoku.DISP_N_6DAISKTSYKNTUIKAKYHKATAKBN),
                    pMP);
        }


        BizDate mosYmd = mosKihon.getMosymd();
        C_Tuukasyu kykTuukaKbn = mosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukaSyu = mosKihon.getHrktuukasyu();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();
        BizCurrency kihons = syuMosSyouhnParam.getKihons();
        BizCurrency mosSyuTkp = syuMosSyouhnParam.getHrktuukasyutkp();

        if(!C_Tuukasyu.JPY.eq(kykTuukaKbn)) {

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            String kijunNendo = setKessanNensibi.exec(mosYmd).getBizDateY().toString();

            BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate = bizDomManager.getKijyungkHanteiKawaseRate(kijunNendo, kykTuukaKbn);
            if (kijyungkHanteiKawaseRate == null) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC1053 + " " + MessageUtil.getMessage(MessageId.EHC1053, mosYmd.toString()),
                    pMP);
            }

        }

        BizCurrency ptani = null;
        boolean ptaniChkHannteiFlg = true;
        C_Sdpd sdpdKbn = mosKihon.getSdpdkbn();
        List<BM_ChkHrkPTani> chkHrkPTaniLst = new ArrayList<>();

        C_Tuukasyu tuukaKbn = null;
        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syuSyouhnZokusei.getPtratkituukasiteikbn())) {

            tuukaKbn = hrkTuukaSyu;
        }
        else {

            tuukaKbn = kykTuukaKbn;
        }

        if (!C_Sdpd.PD.eq(sdpdKbn)) {

            ptaniChkHannteiFlg = false;
        }

        if (ptaniChkHannteiFlg) {

            chkHrkPTaniLst = bizDomManager.getChkHrkPTanisByPK(syuSyouhnCd, hrkKaisuu, syuSyouhnSdNo, channelCd, tuukaKbn);

            if (chkHrkPTaniLst != null && chkHrkPTaniLst.size() != 0) {
                ptani = chkHrkPTaniLst.get(0).getHrkptani();
            }

            checkPtani(ptani,
                tuukaKbn,
                syuMosSyouhnParam,
                syuSyouhnZokusei,
                pMP);
        }

        CheckSaiteiP checkSaiteiP = SWAKInjector.getInstance(CheckSaiteiP.class);

        C_YouhiKbn checkSaiteiPyouhiKbn = hanteiMoschk.hanteiMosSyouhnSaiteiP(syuSyouhnZokusei, tkSyouhnZokuseiList);

        if (C_YouhiKbn.YOU.eq(checkSaiteiPyouhiKbn)) {

            checkSaiteiP.exec(pMP, syuMosSyouhnParam, syuSyouhnZokusei, mosSyuTkp, tuukaKbn);
        }

        youhiKbn = hanteiMoschk.hanteiItijiSaikouP(syuSyouhnZokusei, tkSyouhnZokuseiList);
        if (C_YouhiKbn.YOU.eq(youhiKbn) && C_Hrkkaisuu.ITIJI.eq(hrkKaisuu) && C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {
            List<ChkSaikouSSTaniParam> syuChkSaikouSSTaniParamLst = new ArrayList<>();
            List<BM_ChkSaikouSSTani> chkSaikouSSTaniLst = bizDomManager.getChkSaikouSSTanisByPk(syuSyouhnCd,
                syuSyouhnSdNo, BizNumber.valueOf(hhknNen), Integer.parseInt(C_MosKbn.BLNK.getValue()), C_Tuukasyu.JPY);

            if (chkSaikouSSTaniLst != null && chkSaikouSSTaniLst.size() != 0) {

                syuChkSaikouSSTaniParamLst.addAll(chkSaikouSSTaniLst);
            }
            else {
                throw new CommonBizAppException("最高ＳＳ単位テーブルにデータが見つかりません。");
            }

            BizCurrency saikouP = syuChkSaikouSSTaniParamLst.get(0).getSaikous();
            checkSaikouP(pMP, syoriCtl, mosKihon, syuMosSyouhnParam, syuSyouhnZokusei, mosSyuTkp, saikouP, ptani);
        }

        boolean sCheckFlag = true;
        BizCurrency stani = null;

        if (!C_Sdpd.SD.eq(sdpdKbn)) {

            sCheckFlag = false;
        }

        if (sCheckFlag) {
            List<ChkSaikouSSTaniParam> syuChkSaikouSSTaniParamLst = new ArrayList<>();

            yenknsnKihons = getKiteiCheckYenkansangk.exec(mosYmd, kihons, kykTuukaKbn);

            if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {

                List<BM_ChkSaikouSSTani> chkSaikouSSTaniLst = bizDomManager.getChkSaikouSSTanisByPk(
                    syuSyouhnCd, syuSyouhnSdNo, BizNumber.valueOf(hhknNen),
                    Integer.parseInt(C_MosKbn.BLNK.getValue()), C_Tuukasyu.JPY);

                if (chkSaikouSSTaniLst != null && chkSaikouSSTaniLst.size() != 0) {
                    syuChkSaikouSSTaniParamLst.addAll(chkSaikouSSTaniLst);
                }
            }
            else if (C_SpgndtknKbn.ARI.eq(spGndTknKbn)) {

                List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTaniLst = bizDomManager.getChkJhSaikouSSTanisByPk(
                    syuSyouhnCd, syuSyouhnSdNo, BizNumber.valueOf(hhknNen),
                    Integer.parseInt(C_MosKbn.BLNK.getValue()), C_Tuukasyu.JPY);

                if (chkJhSaikouSSTaniLst != null) {
                    syuChkSaikouSSTaniParamLst.addAll(chkJhSaikouSSTaniLst);
                }
            }

            List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK(
                syuSyouhnCd, syuSyouhnSdNo, BizNumber.valueOf(hhknNen), kykTuukaKbn);

            if (chkSTaniLst == null || chkSTaniLst.size() == 0) {

                throw new CommonBizAppException("Ｓ単位テーブルにデータが見つかりません。");
            }

            stani = chkSTaniLst.get(0).getStani();

            checkSaikouTaniS(syuChkSaikouSSTaniParamLst,
                chkSTaniLst.get(0),
                syuMosSyouhnParam,
                syuSyouhnZokusei,
                spGndTknKbn,
                pMP,
                sysKbn,
                yenknsnKihons);
        }

        if (sCheckFlag) {
            List<ChkSaiteiSParam> syuChkSaiteiSParamLst = new ArrayList<>();

            C_Hrkkeiro hrkkeiro = mosKihon.getHrkkeiro();
            C_UmuKbn saiteiSKanwaTkykUmu = syuSyouhnZokusei.getSaiteisknwtkumu();

            if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {

                List<BM_ChkSaiteiS> chkSaiteiSLst = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(
                    syuSyouhnCd, syuSyouhnSdNo, hrkkeiro, Integer.parseInt(C_UmuKbn.NONE.getValue()), kykTuukaKbn);

                if (chkSaiteiSLst != null) {
                    syuChkSaiteiSParamLst.addAll(chkSaiteiSLst);
                }
            }
            else if (C_SpgndtknKbn.ARI.eq(spGndTknKbn)) {

                List<BM_ChkJhSaiteiS> chkJhSaiteiSLst =
                    bizDomManager.getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(
                        syuSyouhnCd, syuSyouhnSdNo, hrkkeiro, Integer.parseInt(saiteiSKanwaTkykUmu.getValue()), kykTuukaKbn);

                if (chkJhSaiteiSLst != null) {
                    syuChkSaiteiSParamLst.addAll(chkJhSaiteiSLst);
                }
            }

            checkSaiteiS(syuChkSaiteiSParamLst,
                syuMosSyouhnParam,
                syuSyouhnZokusei,
                spGndTknKbn,
                pMP,
                sysKbn,
                stani);
        }

        checkJigyouIkkatu(syoriCtl,
            syuMosSyouhnParam,
            pMP);

        List<HT_MosSyouhn> tkMosSyouhnParamLst = new ArrayList<>();
        List<String> tkSyouhin = new ArrayList<>();

        tkMosSyouhnParamLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        if (!C_Channelcd.BLNK.eq(channelCd)) {

            List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst =
                bizDomManager.getChkTkykHukaKahisBySyusyouhncdSyusyouhnsdnoChannelcdTkhukahissuumu(
                    syuSyouhnCd, syuSyouhnSdNo, channelCd, C_UmuKbn.ARI);

            if (chkTkykHukaKahiLst != null && chkTkykHukaKahiLst.size() > 0) {

                for (HT_MosSyouhn mosSyouhnParam : tkMosSyouhnParamLst) {
                    tkSyouhin.add(mosSyouhnParam.getSyouhncd());
                }

                for (BM_ChkTkykHukaKahi chkTkykHukaKahi : chkTkykHukaKahiLst) {

                    String tkHkKhSyouhinCd = chkTkykHukaKahi.getTksyouhncd();

                    if (!tkSyouhin.contains(tkHkKhSyouhinCd)) {
                        String tkSyohinNm = syouhinUtil.getSyouhnNm(tkHkKhSyouhinCd, pMP.getSysDate());

                        checkTokHkaHs(syuSyouhnZokusei, tkSyohinNm, pMP);
                    }
                }
            }
        }

        String tkSyouhinCdSyori = null;
        Integer tkSyouhinSdNoSyori = null;

        boolean firstFlgNtgk = true;
        BizCurrency douNtgk = null;
        BizCurrency currentDouNtgk = null;
        String syouhnNmNtgk = null;
        boolean firstFlgKkn = true;
        Integer douHknkkn = 0;
        Integer douHrkkkn = 0;
        Integer currentDouHknkkn = 0;
        Integer currentDouHrkkkn = 0;
        String syouhnNmKkn = null;
        boolean firstFlgKata = true;
        C_KataKbn douKata = null;
        C_KataKbn currentDouKata = null;
        String syouhnNmKata = null;

        for (HT_MosSyouhn tkMosSyouhnParam : tkMosSyouhnParamLst) {

            BizCurrency hutuuSibous = setHutuuSibouS.exec(pMP);

            C_UmuKbn douNtgkChkUmu = null;
            C_UmuKbn doukknChkUmu = null;
            C_UmuKbn doukataChkUmu = null;

            BM_SyouhnZokusei tkSyouhnZokusei = pMP.getSyouhnZokusei(tkMosSyouhnParam.getSyouhncd(),
                tkMosSyouhnParam.getSyouhnsdno());

            tkSyouhinCdSyori = tkSyouhnZokusei.getSyouhncd();
            tkSyouhinSdNoSyori = tkSyouhnZokusei.getSyouhnsdno();

            checkYourouTokuyakuHuka(syuMosSyouhnParam, syuSyouhnZokusei,
                tkSyouhnZokusei, pMP);

            List<BM_ChkTkykHukaKahi> chkTkykHukaKahiLst = null;

            if (!C_Channelcd.BLNK.eq(channelCd)) {
                chkTkykHukaKahiLst = bizDomManager.getChkTkykHukaKahisByPk(
                    tkSyouhinCdSyori, syuSyouhnCd, syuSyouhnSdNo, channelCd);

                checkTokuyakuFukaKahi(chkTkykHukaKahiLst, syuMosSyouhnParam, tkMosSyouhnParam, syuSyouhnZokusei,
                    tkSyouhnZokusei, pMP);
            }

            checkTokBairitu(chkTkykHukaKahiLst, tkMosSyouhnParam, syuMosSyouhnParam, syuSyouhnZokusei,
                tkSyouhnZokusei, hutuuSibous, pMP);

            C_SntkhouKbn sntkHouKbn = mosKihon.getSntkhoukbn();

            List<BM_ChkTkykHukaSeigen> chkTkykHukaSeigenLst =
                bizDomManager.getChkTkykHukaSeigensByPk(syuSyouhnCd, syuSyouhnSdNo,
                    Integer.parseInt(sntkHouKbn.getValue()), BizNumber.valueOf(hhknNen), tkSyouhinCdSyori);

            if ((!C_SysKbn.ESHIEN.eq(sysKbn)) ||
                (C_SysKbn.ESHIEN.eq(sysKbn) &&
                    C_UmuKbn.NONE.eq(koktiCheckHuyoUmu) &&
                    C_UmuKbn.NONE.eq(tokubetuKokutiUmu))) {

                checkTokHukaSeigen(chkTkykHukaSeigenLst, sysKbn, nenKknTknKbn,
                    tkSyouhnZokusei, pMP);
            }

            checkSetTokHukaSeigen(syuSyouhnCd,
                tkSyouhinCdSyori,
                sysKbn,
                mosKihon,
                syuSyouhnZokusei,
                tkSyouhnZokusei,
                pMP);

            C_UmuKbn eightytkumu = tkSyouhnZokusei.getEightysaimnrytkumu();

            checkTKykKanouNenrei(syuMosSyouhnParam,
                tkMosSyouhnParam,
                tkSyouhnZokusei,
                pMP,
                nenKknTknKbn,
                kykknnennjchkskb,
                sysKbn,
                hhknNen,
                hhknSei,
                channelCd);

            if (C_UmuKbn.ARI.eq(eightytkumu)) {

                check80tkumu(syuMosSyouhnParam, tkMosSyouhnParam, tkSyouhnZokusei, pMP, hhknNen);
            }
            else {
                checkNenreiHani(syuMosSyouhnParam, tkMosSyouhnParam, tkSyouhnZokusei, pMP);
            }

            C_KataKbn tkKataKbn = tkMosSyouhnParam.getKatakbn();

            List<BM_ChkKata> chkKataLstTk = bizDomManager.getChkKatasByPk(
                tkSyouhinCdSyori, tkSyouhinSdNoSyori, C_UmuKbn.NONE, tkKataKbn);

            checkSyukykKata(chkKataLstTk, tkMosSyouhnParam, tkSyouhnZokusei, pMP);

            C_UmuKbn tkKyuhuUmu = tkSyouhnZokusei.getKyhkataumu();
            C_KyhgndkataKbn tkKyuhuKata = tkMosSyouhnParam.getKyhkatakbn();

            if (C_UmuKbn.ARI.eq(tkKyuhuUmu)) {

                List<BM_ChkKyuuhuKata> chkKyuuhuKataLst =
                    bizDomManager.getChkKyuuhuKatasByPk(tkSyouhinCdSyori, tkSyouhinSdNoSyori, tkKyuhuKata);

                checkKyuhuKata(chkKyuuhuKataLst, tkMosSyouhnParam, tkSyouhnZokusei, pMP);
            }
            else {
                if (!C_KyhgndkataKbn.BLNK.eq(tkKyuhuKata)) {

                    checkKyuhuKataMs(tkSyouhnZokusei, pMP);
                }
            }

            if (ptaniChkHannteiFlg) {

                ptani = null;

                chkHrkPTaniLst = bizDomManager.getChkHrkPTanisByPK(tkSyouhinCdSyori, hrkKaisuu,
                    tkSyouhinSdNoSyori, channelCd, tuukaKbn);

                if (chkHrkPTaniLst != null && chkHrkPTaniLst.size() != 0) {
                    ptani = chkHrkPTaniLst.get(0).getHrkptani();
                }

                checkPtani(ptani,
                    tuukaKbn,
                    tkMosSyouhnParam,
                    tkSyouhnZokusei,
                    pMP);
            }

            if (C_YouhiKbn.YOU.eq(checkSaiteiPyouhiKbn)) {

                checkSaiteiP.exec(pMP, tkMosSyouhnParam, syuSyouhnZokusei, tkMosSyouhnParam.getHrktuukasyutkp(), tuukaKbn);
            }


            if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu) && C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {
                List<ChkSaikouSSTaniParam> tkChkSaikouSSTaniParamLst = new ArrayList<>();

                List<BM_ChkSaikouSSTani> chkSaikouSSTaniLst = bizDomManager.getChkSaikouSSTanisByPk(tkSyouhinCdSyori,
                    tkSyouhinSdNoSyori, BizNumber.valueOf(hhknNen), Integer.parseInt(C_MosKbn.BLNK.getValue()),
                    C_Tuukasyu.JPY);

                if (chkSaikouSSTaniLst != null && chkSaikouSSTaniLst.size() != 0) {

                    tkChkSaikouSSTaniParamLst.addAll(chkSaikouSSTaniLst);
                }
                else {
                    throw new CommonBizAppException("最高ＳＳ単位テーブルにデータが見つかりません。");
                }

                BizCurrency saikouP = tkChkSaikouSSTaniParamLst.get(0).getSaikous();
                checkSaikouP(pMP, syoriCtl, mosKihon, tkMosSyouhnParam, tkSyouhnZokusei,
                    tkMosSyouhnParam.getHrktuukasyutkp(), saikouP, ptani);
            }

            if (sCheckFlag) {
                List<ChkSaikouSSTaniParam> tkChkSaikouSSTaniParamLst = new ArrayList<>();

                kihons = tkMosSyouhnParam.getKihons();

                yenknsnKihons = getKiteiCheckYenkansangk.exec(mosYmd, kihons, kykTuukaKbn);

                if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {

                    List<BM_ChkSaikouSSTani> chkSaikouSSTaniLstTk = bizDomManager.getChkSaikouSSTanisByPk(
                        tkSyouhinCdSyori, tkSyouhinSdNoSyori, BizNumber.valueOf(hhknNen),
                        Integer.parseInt(C_MosKbn.BLNK.getValue()), C_Tuukasyu.JPY);

                    if (chkSaikouSSTaniLstTk != null) {
                        tkChkSaikouSSTaniParamLst.addAll(chkSaikouSSTaniLstTk);
                    }
                }
                else if (C_SpgndtknKbn.ARI.eq(spGndTknKbn)) {

                    List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTaniLstTk = bizDomManager.getChkJhSaikouSSTanisByPk(
                        tkSyouhinCdSyori, tkSyouhinSdNoSyori, BizNumber.valueOf(hhknNen),
                        Integer.parseInt(C_MosKbn.BLNK.getValue()), C_Tuukasyu.JPY);

                    if (chkJhSaikouSSTaniLstTk != null) {
                        tkChkSaikouSSTaniParamLst.addAll(chkJhSaikouSSTaniLstTk);
                    }
                }

                List<BM_ChkSTani> chkSTaniLst = bizDomManager.getChkSTanisByPK(
                    tkSyouhinCdSyori, tkSyouhinSdNoSyori, BizNumber.valueOf(hhknNen), kykTuukaKbn);

                if (chkSTaniLst == null || chkSTaniLst.size() == 0) {

                    throw new CommonBizAppException("Ｓ単位テーブルにデータが見つかりません。");
                }

                stani = chkSTaniLst.get(0).getStani();

                checkSaikouTaniS(tkChkSaikouSSTaniParamLst,
                    chkSTaniLst.get(0),
                    tkMosSyouhnParam,
                    tkSyouhnZokusei,
                    spGndTknKbn,
                    pMP,
                    sysKbn,
                    yenknsnKihons);
            }

            if (sCheckFlag) {
                List<ChkSaiteiSParam> tkChkSaiteiSParamLst = new ArrayList<>();
                Integer tkSaiteiSKanwaTkykUmu = Integer.parseInt(tkSyouhnZokusei.getSaiteisknwtkumu().getValue());
                C_Hrkkeiro hrkkeiro = mosKihon.getHrkkeiro();

                if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {
                    List<BM_ChkSaiteiS> chkSaiteiSLst = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(
                        tkSyouhinCdSyori, tkSyouhinSdNoSyori, hrkkeiro, tkSaiteiSKanwaTkykUmu, kykTuukaKbn);

                    if (chkSaiteiSLst != null) {
                        tkChkSaiteiSParamLst.addAll(chkSaiteiSLst);
                    }
                }
                else if (C_SpgndtknKbn.ARI.eq(spGndTknKbn)) {
                    List<BM_ChkJhSaiteiS> chkJhSaiteiSLst =
                        bizDomManager.getChkJhSaiteiSsBySyouhncdSyouhnsdnoItems(
                            tkSyouhinCdSyori, tkSyouhinSdNoSyori, hrkkeiro, tkSaiteiSKanwaTkykUmu, kykTuukaKbn);

                    if (chkJhSaiteiSLst != null) {
                        tkChkSaiteiSParamLst.addAll(chkJhSaiteiSLst);
                    }
                }

                checkSaiteiS(tkChkSaiteiSParamLst, tkMosSyouhnParam, tkSyouhnZokusei, spGndTknKbn, pMP, sysKbn, stani);
            }

            douNtgkChkUmu = tkSyouhnZokusei.getDountgkchkumu();

            if (C_UmuKbn.ARI.eq(douNtgkChkUmu)) {
                currentDouNtgk = tkMosSyouhnParam.getKihons();

                if (firstFlgNtgk) {
                    douNtgk = currentDouNtgk;
                    syouhnNmNtgk = tkSyouhnZokusei.getSyouhnnm();
                    firstFlgNtgk = false;
                }
                else {
                    if (!currentDouNtgk.equalsValue(douNtgk)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageId.EHC0039 + " " + MessageUtil.getMessage(
                                MessageId.EHC0039, syouhnNmNtgk, tkSyouhnZokusei.getSyouhnnm()), pMP);
                    }
                }
            }

            doukknChkUmu = tkSyouhnZokusei.getDoukknchkumu();

            if (C_UmuKbn.ARI.eq(doukknChkUmu)) {
                currentDouHknkkn = tkMosSyouhnParam.getHknkkn();
                currentDouHrkkkn = tkMosSyouhnParam.getHrkkkn();

                if (firstFlgKkn) {
                    douHknkkn = currentDouHknkkn;
                    douHrkkkn = currentDouHrkkkn;
                    syouhnNmKkn = tkSyouhnZokusei.getSyouhnnm();
                    firstFlgKkn = false;
                }
                else {
                    if ((!currentDouHknkkn.equals(douHknkkn)) || (!currentDouHrkkkn.equals(douHrkkkn))) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageId.EHC0040 + " " + MessageUtil.getMessage(
                                MessageId.EHC0040, syouhnNmKkn, tkSyouhnZokusei.getSyouhnnm()), pMP);
                    }
                }
            }

            doukataChkUmu = tkSyouhnZokusei.getDoukatachkumu();

            if (C_UmuKbn.ARI.eq(doukataChkUmu)) {

                currentDouKata = tkMosSyouhnParam.getKatakbn();

                if (firstFlgKata) {
                    douKata = currentDouKata;
                    syouhnNmKata = tkSyouhnZokusei.getSyouhnnm();
                    firstFlgKata = false;
                }
                else {
                    if (!currentDouKata.eq(douKata)) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageId.EHC0027 + " " + MessageUtil.getMessage(
                                MessageId.EHC0027, syouhnNmKata, tkSyouhnZokusei.getSyouhnnm()), pMP);
                    }
                }
            }

            if (C_UmuKbn.ARI.eq(syuKyuhuUmu) &&
                C_UmuKbn.ARI.eq(tkKyuhuUmu) &&
                !syuKyuhuKata.eq(tkKyuhuKata)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0150 + " " + MessageUtil.getMessage(
                        MessageId.EHC0150, syuSyouhnZokusei.getSyouhnnm(), tkSyouhnZokusei.getSyouhnnm()),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
            }

            if (C_UmuKbn.ARI.eq(syuKyuhuUmu) && C_UmuKbn.ARI.eq(tkKyuhuUmu)
                && ((!syuKyuhuKata.eq(tkKyuhuKata) &&
                    C_6daiLdKbn.NONE.eq(rokuDaisktKataKbn)) ||
                    (C_6daiLdKbn.ARI.eq(rokuDaisktKataKbn) &&
                        ((C_KyhgndkataKbn.TYPE60.eq(syuKyuhuKata) &&
                            !C_KyhgndkataKbn.TYPE120.eq(tkKyuhuKata)) ||
                            (C_KyhgndkataKbn.TYPE120.eq(syuKyuhuKata) &&
                                !C_KyhgndkataKbn.TYPE180.eq(tkKyuhuKata)))))) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0150 + " " + MessageUtil.getMessage(
                        MessageId.EHC0150, syuSyouhnZokusei.getSyouhnnm(), tkSyouhnZokusei.getSyouhnnm()),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.ERROR);
            }

            List<BM_ChkSyouhnKokutiJougenS> chkSyouhnKokutiJougenSLst =
                bizDomManager.getChkSyouhnKokutiJougenSsByPk(tkSyouhinCdSyori, tkSyouhinSdNoSyori,
                    BizNumber.valueOf(hhknNen), Integer.parseInt(mosKbn.getValue()));

            BizCurrency tkKihonS = tkMosSyouhnParam.getKihons();
            C_UmuKbn ganSdKyhUmu = tkSyouhnZokusei.getGansdkyhumu();
            C_KihonssyuruiKbn kihonssyuruiKbn = tkSyouhnZokusei.getKihonssyuruikbn();

            if ((!C_SysKbn.ESHIEN.eq(sysKbn)) ||
                (C_SysKbn.ESHIEN.eq(sysKbn) &&
                    C_UmuKbn.NONE.eq(koktiCheckHuyoUmu) &&
                    C_UmuKbn.NONE.eq(tokubetuKokutiUmu))) {

                checkSyhnKokutiJougenS(chkSyouhnKokutiJougenSLst,
                    tkSyouhinCdSyori,
                    tkKihonS,
                    sysKbn,
                    spGndTknKbn,
                    sntkHouKbn,
                    pMP,
                    ganSdKyhUmu,
                    kihonssyuruiKbn);
            }
        }

        setKyuuhuNitigaku.exec(syuMosSyouhnParamLst, tkMosSyouhnParamLst);

        List<BM_ChkKeiyakuTaniSaikouS> chkKeiyakuTaniSaikouSLst =
            bizDomManager.getChkKeiyakuTaniSaikouSsByPk(syuSyouhnCd, syuSyouhnSdNo);

        checkKyktaniKitei(chkKeiyakuTaniSaikouSLst,
            setKyuuhuNitigaku,
            sysKbn,
            spGndTknKbn,
            pMP,
            syuMosSyouhnParam);

        C_SntkhouKbn sntkhouKbn = mosKihon.getSntkhoukbn();

        List<BM_ChkKokutiJougenS> chkKokutiJougenSLst = bizDomManager.getChkKokutiJougenSsByPk(
            syuSyouhnCd, syuSyouhnSdNo, BizNumber.valueOf(hhknNen), Integer.parseInt(mosKbn.getValue()));

        if ((!C_SysKbn.ESHIEN.eq(sysKbn)) ||
            (C_SysKbn.ESHIEN.eq(sysKbn) &&
                C_UmuKbn.NONE.eq(koktiCheckHuyoUmu) &&
                C_UmuKbn.NONE.eq(tokubetuKokutiUmu))) {

            checkKokutiJougenS(chkKokutiJougenSLst,
                setKyuuhuNitigaku.getSipnyutsnntgk2(),
                sysKbn,
                spGndTknKbn,
                sntkhouKbn,
                pMP);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 申込商品テーブルチェック 終了");
        }
    }


    private boolean isTokBaiCheck(BizCurrency pMosS, BizCurrency pTokS, String pHugou) {

        boolean result = false;
        char fugous[] = pHugou.trim().toCharArray();
        int fugouToInt;

        for (int index = 0; index < fugous.length; index++) {
            char fugou = fugous[index];

            if (fugou == '<') {
                fugouToInt = -1;
            }
            else if (fugou == '=') {
                fugouToInt = 0;
            }
            else if (fugou == '>') {
                fugouToInt = 1;
            }
            else {
                throw new CommonBizAppException("特約倍率チェック：予期していない演算子が登録されています。:" + fugou);
            }

            if (pMosS.compareTo(pTokS) == fugouToInt) {
                result = true;
            } else {
            }
        }

        return result;
    }

    private void checkSKykKanouNenrei(HT_MosSyouhn pSyuMosSyouhnParam,
        BM_SyouhnZokusei pSyuSyouhnZokusei,
        HT_MosKihon pMosKihon,
        MosnaiCheckParam pMP,
        C_NenkkntknKbn pNenkkntknKbn,
        StringBuffer pKykknnennjchkskb,
        C_SysKbn pSysKbn,
        int pHhknNen,
        C_Hhknsei pHhknSei,
        int pTokCount,
        C_Channelcd pChannelCd) {

        if (C_Channelcd.BLNK.eq(pChannelCd)) {
            return;
        }

        C_Channelcd aftChannelCd = pChannelCd;

        C_TknKbn tknKbn = C_TknKbn.KANOU;
        if (C_NenkkntknKbn.ARI.eq(pNenkkntknKbn)) {
            tknKbn = C_TknKbn.NONE;
        }

        BM_SyouhnZokusei syouhnZokusei = pSyuSyouhnZokusei;

        String syukykSyouhnNm = syouhnZokusei.getSyouhnnm();
        List<BM_ChkNenreiHani2> chkNenreiHani2Lst = null;
        List<BM_ChkJhNenreiHani2> chkJhNenreiHani2Lst = null;
        int kensuu = 0;
        BizNumber tokusyuChkNo = BizNumber.ZERO;

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyuMosSyouhnParam.getSyouhncd());

        if (C_NenkkntknKbn.NONE.eq(pNenkkntknKbn)) {
            if (C_SysKbn.ESHIEN.eq(pSysKbn)) {

                chkNenreiHani2Lst = bizDomManager.
                    getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(aftChannelCd,
                        pSyuMosSyouhnParam.getSyouhncd(),
                        pSyuMosSyouhnParam.getSyouhnsdno(),
                        BizNumber.valueOf(pHhknNen),
                        Integer.parseInt(pHhknSei.getValue()),
                        pSyuMosSyouhnParam.getKatakbn(),
                        pSyuMosSyouhnParam.getHknkkn(),
                        pSyuMosSyouhnParam.getHknkknsmnkbn(),
                        pSyuMosSyouhnParam.getHrkkkn(),
                        pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                        pSyuMosSyouhnParam.getYoteiriritu(),
                        pSyuMosSyouhnParam.getDai1hknkkn(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        C_UmuKbn.NONE,
                        C_UmuKbn.NONE);

                C_YoteirirituhendouKbn yoteiRirituHendouKbn = syouhnZokusei.getYoteirirituhendoukbn();

                if (chkNenreiHani2Lst.size() == 0) {

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR  ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                        String [] nenreiHaniCheckMaster2SyouhncdLst;
                        if (C_Tkhukaumu.HUKA.eq(pMosKihon.getSyksbyensitihsyutkhkkbn())) {

                            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                                nenreiHaniCheckMaster2SyouhncdLst = SAITEIHOSHOU_ARI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19;
                            }
                            else {
                                nenreiHaniCheckMaster2SyouhncdLst = SAITEIHOSHOU_ARI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR;
                            }
                        }
                        else {
                            if(syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19){
                                nenreiHaniCheckMaster2SyouhncdLst = SAITEIHOSHOU_NASHI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19;
                            }
                            else {
                                nenreiHaniCheckMaster2SyouhncdLst = SAITEIHOSHOU_NASHI_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR;
                            }

                        }

                        boolean shutokuKeqkaFlg = false;
                        BizNumber syufromnenMin = BizNumber.ZERO;
                        BizNumber syutonenMax = BizNumber.ZERO;

                        for (String nenreiHaniCheckMaster2Syouhncd : nenreiHaniCheckMaster2SyouhncdLst) {

                            Integer nenreiHaniCheckMaster2Syouhnsdno = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(nenreiHaniCheckMaster2Syouhncd,
                                pMosKihon.getKykymd());

                            List<BM_ChkNenreiHani2> chkNenreiHani2LstNenNone = bizDomManager.
                                getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(aftChannelCd,
                                    nenreiHaniCheckMaster2Syouhncd,
                                    nenreiHaniCheckMaster2Syouhnsdno,
                                    C_UmuKbn.NONE,
                                    pSyuMosSyouhnParam.getKatakbn(),
                                    pSyuMosSyouhnParam.getHknkkn(),
                                    pSyuMosSyouhnParam.getHknkknsmnkbn(),
                                    pSyuMosSyouhnParam.getHrkkkn(),
                                    pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                                    pSyuMosSyouhnParam.getYoteiriritu(),
                                    pSyuMosSyouhnParam.getDai1hknkkn(),
                                    Integer.parseInt(pHhknSei.getValue()),
                                    C_UmuKbn.NONE,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null);

                            if (chkNenreiHani2LstNenNone.size() != 0) {
                                if (!shutokuKeqkaFlg) {
                                    shutokuKeqkaFlg = true;
                                    syufromnenMin = chkNenreiHani2LstNenNone.get(0).getSyufromnen();
                                    syutonenMax = chkNenreiHani2LstNenNone.get(0).getSyutonen();
                                }

                                for (BM_ChkNenreiHani2 chkNenreiHani2 : chkNenreiHani2LstNenNone) {
                                    BizNumber syufromnen = chkNenreiHani2.getSyufromnen();
                                    BizNumber syutonen = chkNenreiHani2.getSyutonen();

                                    if (syufromnen.compareTo(syufromnenMin) < 0) {
                                        syufromnenMin = syufromnen;
                                    }

                                    if (syutonen.compareTo(syutonenMax) > 0) {
                                        syutonenMax = syutonen;
                                    }
                                }
                            }
                        }

                        String msg = "";
                        if (shutokuKeqkaFlg) {
                            if (C_Tkhukaumu.HUKA.eq(pMosKihon.getSyksbyensitihsyutkhkkbn())) {
                                DrtenTkykTratkiHantei drtenTkykTratkiHantei = SWAKInjector.getInstance(DrtenTkykTratkiHantei.class);

                                C_UmuKbn tktekiumu = syouhnZokusei.getSyksbyensitihsyutktekiumu();
                                C_SkeijimuKbn skeiJimuKbn = pMP.getDataSyoriControl().getSkeijimukbn();
                                String oyadrtenCd = pMP.getSekmossakuseiOyaAgCd();

                                C_TkykTratkiKbn tkykTratkiKbn =
                                    drtenTkykTratkiHantei.initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(
                                        pSyuMosSyouhnParam.getSyouhncd(), tktekiumu, skeiJimuKbn, oyadrtenCd);

                                if (!C_TkykTratkiKbn.HUKAHISSU.eq(tkykTratkiKbn)) {
                                    String henkanmaeSyouhncd = null;
                                    String henkangoSyouhncd = null;
                                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                                        for (int n = 0; n < SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19.length; n++) {
                                            henkanmaeSyouhncd = SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[n][0];

                                            if (henkanmaeSyouhncd.equals(pSyuMosSyouhnParam.getSyouhncd())) {

                                                henkangoSyouhncd = SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[n][1];
                                            }
                                        }
                                    }
                                    else {
                                        for (int n = 0; n < SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR.length; n++) {
                                            henkanmaeSyouhncd = SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[n][0];

                                            if (henkanmaeSyouhncd.equals(pSyuMosSyouhnParam.getSyouhncd())) {

                                                henkangoSyouhncd = SYOUHNCD_HENKAN_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[n][1];
                                            }
                                        }
                                    }

                                    if (henkangoSyouhncd == null) {
                                        msg = MessageUtil.getMessage(
                                            MessageId.EGA1032, String.valueOf(syufromnenMin), String.valueOf(syutonenMax));
                                    }
                                    else {
                                        Integer henkangoSyouhnsdNo =
                                            bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(henkangoSyouhncd,
                                                pMosKihon.getKykymd());

                                        List<BM_ChkNenreiHani2> henkangoChkNenreiHani2List =
                                            bizDomManager.getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(
                                                aftChannelCd,
                                                henkangoSyouhncd,
                                                henkangoSyouhnsdNo,
                                                BizNumber.valueOf(pHhknNen),
                                                Integer.parseInt(pHhknSei.getValue()),
                                                pSyuMosSyouhnParam.getKatakbn(),
                                                pSyuMosSyouhnParam.getHknkkn(),
                                                pSyuMosSyouhnParam.getHknkknsmnkbn(),
                                                pSyuMosSyouhnParam.getHrkkkn(),
                                                pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                                                pSyuMosSyouhnParam.getYoteiriritu(),
                                                pSyuMosSyouhnParam.getDai1hknkkn(),
                                                null, null, null, null, null,
                                                C_UmuKbn.NONE,
                                                C_UmuKbn.NONE);

                                        if (henkangoChkNenreiHani2List.size() == 0) {
                                            msg = MessageUtil.getMessage(MessageId.EGA1032, String.valueOf(syufromnenMin),
                                                String.valueOf(syutonenMax));
                                        }
                                        else {
                                            msg = MessageUtil.getMessage(MessageId.EGA1042,
                                                "初期死亡時円換算支払額最低保証特約",
                                                String.valueOf(syufromnenMin),
                                                String.valueOf(syutonenMax));
                                        }
                                    }
                                }
                                else {
                                    msg = MessageUtil.getMessage(MessageId.EGA1032, String.valueOf(syufromnenMin),
                                        String.valueOf(syutonenMax));
                                }
                            }
                            else {
                                msg = MessageUtil.getMessage(MessageId.EGA1032, String.valueOf(syufromnenMin),
                                    String.valueOf(syutonenMax));
                            }
                            setHubiMsg.exec("", msg, C_SekmossakuseiErroutKbn.GAMEN, pMP);
                        }
                        else {
                            if (C_YoteirirituhendouKbn.NONE.eq(yoteiRirituHendouKbn)) {
                                msg = MessageUtil.getMessage(MessageId.EGA1031);
                            }
                            else{
                                msg = MessageUtil.getMessage(MessageId.EGA1033);
                            }
                            setHubiMsg.exec("", msg, C_SekmossakuseiErroutKbn.GAMEN, pMP);
                        }
                        pKykknnennjchkskb.append(KYK_KNNEN_NJCHK_SKB);
                    }
                    else {
                        List<BM_ChkNenreiHani2> chkNenreiHani2LstNenNone = bizDomManager.
                            getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu2(aftChannelCd,
                                pSyuMosSyouhnParam.getSyouhncd(),
                                pSyuMosSyouhnParam.getSyouhnsdno(),
                                C_UmuKbn.NONE,
                                pSyuMosSyouhnParam.getKatakbn(),
                                pSyuMosSyouhnParam.getHknkkn(),
                                pSyuMosSyouhnParam.getHknkknsmnkbn(),
                                pSyuMosSyouhnParam.getHrkkkn(),
                                pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                                pSyuMosSyouhnParam.getYoteiriritu(),
                                pSyuMosSyouhnParam.getDai1hknkkn(),
                                Integer.parseInt(pHhknSei.getValue()),
                                C_UmuKbn.NONE,
                                null,
                                null,
                                null,
                                null,
                                null);

                        if (chkNenreiHani2LstNenNone.size() != 0) {
                            BizNumber syufromnenMin = chkNenreiHani2LstNenNone.get(0).getSyufromnen();
                            BizNumber syutonenMax = chkNenreiHani2LstNenNone.get(0).getSyutonen();

                            for (BM_ChkNenreiHani2 chkNenreiHani2 : chkNenreiHani2LstNenNone) {
                                BizNumber syufromnen = chkNenreiHani2.getSyufromnen();
                                BizNumber syutonen = chkNenreiHani2.getSyutonen();

                                if (syufromnen.compareTo(syufromnenMin) < 0) {
                                    syufromnenMin = syufromnen;
                                }

                                if (syutonen.compareTo(syutonenMax) > 0) {
                                    syutonenMax = syutonen;
                                }
                            }

                            String msg = "";
                            if (C_YoteirirituhendouKbn.NONE.eq(yoteiRirituHendouKbn)) {
                                msg = MessageUtil.getMessage(MessageId.EGA1030, syufromnenMin.toString(),
                                    syutonenMax.toString());

                                setHubiMsg.exec("", msg, C_SekmossakuseiErroutKbn.GAMEN, pMP);
                            }
                            else {
                                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                                    if (pHhknNen >= 81 && pHhknNen <= 85 && pSyuMosSyouhnParam.getHknkkn() == 10) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1043,
                                            pSyuMosSyouhnParam.getHknkkn().toString());
                                    }

                                    else if (pHhknNen >= 30 && pHhknNen <= 34
                                        && C_Sknenkinsyu.SGKHSYSYSN.eq(pSyuMosSyouhnParam.getSknenkinsyu())
                                        && pSyuMosSyouhnParam.getHknkkn() == 5) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1044,
                                            pSyuMosSyouhnParam.getHknkkn().toString());
                                    }
                                    else if (pHhknNen >= 0 && pHhknNen <= 29
                                        && C_Sknenkinsyu.SGKHSYSYSN.eq(pSyuMosSyouhnParam.getSknenkinsyu())) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1045);
                                    }
                                    else {
                                        msg = MessageUtil.getMessage(MessageId.EGA1033);
                                    }
                                    setHubiMsg.exec("",
                                        msg,
                                        C_SekmossakuseiErroutKbn.GAMEN,
                                        pMP);
                                }
                                else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                                    if (pHhknNen >= 86 && pHhknNen <= 90 && pSyuMosSyouhnParam.getHknkkn() == 10) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1043,
                                            pSyuMosSyouhnParam.getHknkkn().toString());
                                    }

                                    else if (pHhknNen >= 30 && pHhknNen <= 34
                                        && C_Sknenkinsyu.SGKHSYSYSN.eq(pSyuMosSyouhnParam.getSknenkinsyu())
                                        && pSyuMosSyouhnParam.getHknkkn() == 5) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1044,
                                            pSyuMosSyouhnParam.getHknkkn().toString());
                                    }
                                    else if (pHhknNen >= 0 && pHhknNen <= 29
                                        && C_Sknenkinsyu.SGKHSYSYSN.eq(pSyuMosSyouhnParam.getSknenkinsyu())) {
                                        msg = MessageUtil.getMessage(MessageId.EGA1045);
                                    }
                                    else {
                                        msg = MessageUtil.getMessage(MessageId.EGA1033);
                                    }

                                    setHubiMsg.exec("",
                                        msg,
                                        C_SekmossakuseiErroutKbn.GAMEN,
                                        pMP);
                                }
                                else {

                                    msg = MessageUtil.getMessage(MessageId.EGA1032, syufromnenMin.toString(),
                                        syutonenMax.toString());

                                    setHubiMsg.exec("", msg, C_SekmossakuseiErroutKbn.GAMEN, pMP);
                                }
                            }
                        }
                        else {
                            String msg = "";
                            if (C_YoteirirituhendouKbn.NONE.eq(yoteiRirituHendouKbn)) {
                                msg = MessageUtil.getMessage(MessageId.EGA1031);
                            }
                            else {
                                msg = MessageUtil.getMessage(MessageId.EGA1033);
                            }

                            setHubiMsg.exec("",
                                msg,
                                C_SekmossakuseiErroutKbn.GAMEN,
                                pMP);
                        }

                        pKykknnennjchkskb.append(KYK_KNNEN_NJCHK_SKB);
                    }
                }
                else {

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

                        int hrkkknNen = 0;

                        C_ErrorKbn convHrkkknNen = convNenSaiManki.convHrkkknNen(pSyuMosSyouhnParam.getHrkkkn(),
                            pSyuMosSyouhnParam.getHrkkknsmnkbn(), pHhknNen);

                        if (C_ErrorKbn.OK.eq(convHrkkknNen)) {

                            hrkkknNen = convNenSaiManki.getHrkkknNen();
                        }

                        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager
                            .getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(aftChannelCd,
                                pSyuMosSyouhnParam.getSyouhncd(), pSyuMosSyouhnParam.getSyouhnsdno(),
                                BizNumber.valueOf(pHhknNen), Integer.parseInt(pHhknSei.getValue()),
                                pSyuMosSyouhnParam.getKatakbn(), pSyuMosSyouhnParam.getHknkkn(),
                                pSyuMosSyouhnParam.getHknkknsmnkbn(), hrkkknNen, C_HrkkknsmnKbn.NENMANKI,
                                pSyuMosSyouhnParam.getYoteiriritu(), pSyuMosSyouhnParam.getDai1hknkkn(),
                                null, null, null, null, null, C_UmuKbn.NONE, C_UmuKbn.NONE);

                        if (chkNenreiHani2List.size() == 0) {

                            String msg = MessageUtil.getMessage("EGA1033");

                            setHubiMsg.exec("", msg, C_SekmossakuseiErroutKbn.GAMEN, pMP);

                            pKykknnennjchkskb.append(KYK_KNNEN_NJCHK_SKB);
                        }
                    }
                    chkNenreiHani2Lst = bizDomManager.
                        getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(aftChannelCd,
                            pSyuMosSyouhnParam.getSyouhncd(),
                            pSyuMosSyouhnParam.getSyouhnsdno(),
                            BizNumber.valueOf(pHhknNen),
                            Integer.parseInt(pHhknSei.getValue()),
                            pSyuMosSyouhnParam.getKatakbn(),
                            pSyuMosSyouhnParam.getHknkkn(),
                            pSyuMosSyouhnParam.getHknkknsmnkbn(),
                            pSyuMosSyouhnParam.getHrkkkn(),
                            pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                            pSyuMosSyouhnParam.getYoteiriritu(),
                            pSyuMosSyouhnParam.getDai1hknkkn(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            C_UmuKbn.ARI,
                            C_UmuKbn.NONE);

                    if (chkNenreiHani2Lst.size() == 0) {
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageId.EHC0189 + " " + MessageUtil.getMessage(MessageId.EHC0189),
                            pMP,
                            tknKbn,
                            C_MsgKbn.ERROR);

                        pKykknnennjchkskb.append(KYK_KNNEN_NJCHK_SKB);
                    }
                }
            }
            else {
                chkNenreiHani2Lst = bizDomManager.
                    getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(aftChannelCd,
                        pSyuMosSyouhnParam.getSyouhncd(),
                        pSyuMosSyouhnParam.getSyouhnsdno(),
                        BizNumber.valueOf(pHhknNen),
                        Integer.parseInt(pHhknSei.getValue()),
                        pSyuMosSyouhnParam.getKatakbn(),
                        pSyuMosSyouhnParam.getHknkkn(),
                        pSyuMosSyouhnParam.getHknkknsmnkbn(),
                        pSyuMosSyouhnParam.getHrkkkn(),
                        pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                        pSyuMosSyouhnParam.getYoteiriritu(),
                        pSyuMosSyouhnParam.getDai1hknkkn(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        C_UmuKbn.ARI,
                        C_UmuKbn.NONE);

                if (chkNenreiHani2Lst.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0028 + " " + MessageUtil.getMessage(MessageId.EHC0028, syukykSyouhnNm),
                        pMP,
                        tknKbn,
                        C_MsgKbn.ERROR);
                }
                else {

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

                        convNenSaiManki.convHrkkknNen(pSyuMosSyouhnParam.getHrkkkn(),
                            pSyuMosSyouhnParam.getHrkkknsmnkbn(), pHhknNen);

                        int hrkkknNen = 0;

                        hrkkknNen = convNenSaiManki.getHrkkknNen();


                        List<BM_ChkNenreiHani2> chkNenreiHani2List = bizDomManager
                            .getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumuSeibetu1(aftChannelCd,
                                pSyuMosSyouhnParam.getSyouhncd(), pSyuMosSyouhnParam.getSyouhnsdno(),
                                BizNumber.valueOf(pHhknNen), Integer.parseInt(pHhknSei.getValue()),
                                pSyuMosSyouhnParam.getKatakbn(), pSyuMosSyouhnParam.getHknkkn(),
                                pSyuMosSyouhnParam.getHknkknsmnkbn(), hrkkknNen, C_HrkkknsmnKbn.NENMANKI,
                                pSyuMosSyouhnParam.getYoteiriritu(), pSyuMosSyouhnParam.getDai1hknkkn(),
                                null, null, null, null, null, C_UmuKbn.ARI, C_UmuKbn.NONE);

                        if (chkNenreiHani2List.size() == 0) {

                            String msg = MessageId.EHC0028 + " " + MessageUtil.getMessage(MessageId.EHC0028, syukykSyouhnNm);

                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMP, tknKbn, C_MsgKbn.ERROR);
                        }

                    }
                }
            }

            kensuu = chkNenreiHani2Lst.size();
            if (kensuu > 0) {
                tokusyuChkNo = chkNenreiHani2Lst.get(0).getTokusyuchkno();
            }
        }
        else {
            chkJhNenreiHani2Lst = bizDomManager.getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(aftChannelCd,
                pSyuMosSyouhnParam.getSyouhncd(),
                pSyuMosSyouhnParam.getSyouhnsdno(),
                pSyuMosSyouhnParam.getKatakbn(),
                pSyuMosSyouhnParam.getHknkkn(),
                pSyuMosSyouhnParam.getHknkknsmnkbn(),
                pSyuMosSyouhnParam.getHrkkkn(),
                pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                BizNumber.valueOf(pHhknNen),
                Integer.parseInt(pHhknSei.getValue()),
                pSyuMosSyouhnParam.getYoteiriritu(),
                pSyuMosSyouhnParam.getDai1hknkkn(),
                C_UmuKbn.NONE,
                null,
                null,
                null,
                null,
                null);

            if (chkJhNenreiHani2Lst == null || chkJhNenreiHani2Lst.size() == 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0028 + " " + MessageUtil.getMessage(MessageId.EHC0028, syukykSyouhnNm),
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }
            else {

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

                    convNenSaiManki.convHrkkknNen(pSyuMosSyouhnParam.getHrkkkn(),
                        pSyuMosSyouhnParam.getHrkkknsmnkbn(), pHhknNen);

                    int hrkkknNen = 0;

                    hrkkknNen = convNenSaiManki.getHrkkknNen();

                    List<BM_ChkJhNenreiHani2> chkJhNenreiHani2List = bizDomManager
                        .getChkJhNenreiHani2sByPkTkykmossyouhnumuSeibetu1(aftChannelCd,
                            pSyuMosSyouhnParam.getSyouhncd(), pSyuMosSyouhnParam.getSyouhnsdno(),
                            pSyuMosSyouhnParam.getKatakbn(), pSyuMosSyouhnParam.getHknkkn(),
                            pSyuMosSyouhnParam.getHknkknsmnkbn(), hrkkknNen, C_HrkkknsmnKbn.NENMANKI,
                            BizNumber.valueOf(pHhknNen), Integer.parseInt(pHhknSei.getValue()),
                            pSyuMosSyouhnParam.getYoteiriritu(), pSyuMosSyouhnParam.getDai1hknkkn(),
                            C_UmuKbn.NONE, null, null, null, null, null);

                    if (chkJhNenreiHani2List.size() == 0) {

                        String msg = MessageId.EHC0028 + " " + MessageUtil.getMessage("EHC0028", syukykSyouhnNm);

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMP, tknKbn, C_MsgKbn.ERROR);
                    }
                }
            }
            kensuu = chkJhNenreiHani2Lst.size();
            if (kensuu > 0) {
                tokusyuChkNo = chkJhNenreiHani2Lst.get(0).getTokusyuchkno();
            }
        }

        if (kensuu != 0) {

            C_Hrkkeiro hrkKeiro = pMosKihon.getHrkkeiro();
            String hrkKeiroContent = hrkKeiro.getContent();
            C_Hrkkaisuu hrkKaisuu = pMosKihon.getHrkkaisuu();

            if (tokusyuChkNo.compareTo(BizNumber.ZERO) == 0) {
            }
            else if (tokusyuChkNo.compareTo(BizNumber.ONE) == 0) {
                if (C_Hrkkeiro.SYUUDAN.eq(hrkKeiro)) {
                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019, syukykSyouhnNm, hrkKeiroContent),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }
            }
            else if (tokusyuChkNo.compareTo(BizNumber.valueOf(2)) == 0) {
                C_KataKbn kataKbn = pSyuMosSyouhnParam.getKatakbn();

                if (C_Hrkkeiro.DANTAI.eq(hrkKeiro) || C_Hrkkeiro.SYUUDAN.eq(hrkKeiro)) {

                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019, syukykSyouhnNm, hrkKeiroContent),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }
                else if (!C_KataKbn.HONNIN.eq(kataKbn) && !C_KataKbn.HONNIN_TUMA.eq(kataKbn)) {
                    String kataKbnContent = kataKbn.getContent();

                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019, syukykSyouhnNm, kataKbnContent),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }
                else if (!C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {

                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0030 + " " + MessageUtil.getMessage(MessageId.EHC0030, syukykSyouhnNm),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }
            }
            else if (tokusyuChkNo.compareTo(BizNumber.valueOf(3)) == 0) {
                if (C_Hrkkeiro.DANTAI.eq(hrkKeiro) || C_Hrkkeiro.SYUUDAN.eq(hrkKeiro)) {
                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019, syukykSyouhnNm, hrkKeiroContent),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }

                else if (!C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {
                    setHubiMsg.exec(
                        C_KetsrhkosKbn.KETHORYU_HUBI,
                        C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHC0030 + " " + MessageUtil.getMessage(MessageId.EHC0030, syukykSyouhnNm),
                        pMP,
                        tknKbn, C_MsgKbn.ERROR);
                }
                else {
                    if (pTokCount > 0 && pMosKihon.getHhknnen() > 70) {
                        setHubiMsg.exec(
                            C_KetsrhkosKbn.KETHORYU_HUBI,
                            C_SpKeisanKahiKbn.SPKEISANKA,
                            C_HubisyubetusyousaiKbn.NONE,
                            MessageId.EHC0091 + " " + MessageUtil.getMessage(MessageId.EHC0091),
                            pMP,
                            tknKbn, C_MsgKbn.ERROR);
                    }
                }
            }
            else {
                throw new CommonBizAppException();
            }
        }

        return;
    }

    private void checkSyukykKata(List<BM_ChkKata> pChkKataLst,
        HT_MosSyouhn pMosSyouhnParam, BM_SyouhnZokusei pSyouhnZokusei, MosnaiCheckParam pMP) {

        if (pChkKataLst.size() == 0) {
            BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019,
                    syouhnZokusei.getSyouhnnm(), pMosSyouhnParam.getKatakbn().getContent()),
                    pMP);
        }

        return;
    }

    private void checkKyuhuKata(List<BM_ChkKyuuhuKata> pChkKyuuhuKataLst,
        HT_MosSyouhn pMosSyouhnParam, BM_SyouhnZokusei pSyouhnZokusei, MosnaiCheckParam pMP) {

        if (pChkKyuuhuKataLst.size() == 0) {
            C_KyhgndkataKbn kyhgndkataKbn = pMosSyouhnParam.getKyhkatakbn();
            BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;

            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EHC0019 + " " + MessageUtil.getMessage(MessageId.EHC0019,
                    syouhnZokusei.getSyouhnnm(), kyhgndkataKbn.getContent()),
                    pMP);
        }

        return;
    }

    private void checkKyuhuKataMs(BM_SyouhnZokusei pSyouhnZokusei, MosnaiCheckParam pMP) {

        BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;

        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
            MessageId.EHC0130 + " " + MessageUtil.getMessage(MessageId.EHC0130, syouhnZokusei.getSyouhnnm()),
            pMP);

        return;
    }

    private void checkSaikouTaniS(List<ChkSaikouSSTaniParam> pChkSaikouSSTaniParamLst,
        BM_ChkSTani pChkSTani,
        HT_MosSyouhn pMosSyouhnParam,
        BM_SyouhnZokusei pSyouhnZokusei,
        C_SpgndtknKbn pSpgndtknKbn,
        MosnaiCheckParam pMP,
        C_SysKbn pSysKbn,
        BizCurrency pYenknsnKihons) {

        if (pChkSaikouSSTaniParamLst.size() == 0) {
            throw new CommonBizAppException("最高ＳＳ単位テーブルにデータが見つかりません。");
        }
        ChkSaikouSSTaniParam chkSaikouSSTaniParam = pChkSaikouSSTaniParamLst.get(0);
        BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;
        boolean taniChkKekka = false;
        BizCurrency kihonS = pMosSyouhnParam.getKihons();
        BizCurrency yenknsnKihons = pYenknsnKihons;
        C_KihonssyuruiKbn kihonSSyuruiKbn = syouhnZokusei.getKihonssyuruikbn();
        BizCurrency stani = pChkSTani.getStani();
        String syouhnNm = syouhnZokusei.getSyouhnnm();
        BizCurrency saikouS = chkSaikouSSTaniParam.getSaikous();
        HT_SyoriCTL syoriCtl = pMP.getDataSyoriControl();

        HT_MosKihon mosKihon = syoriCtl.getMosKihon();

        C_Tuukasyu tuukasyu = mosKihon.getKyktuukasyu();

        if (kihonS.compareTo(kihonS.divideCurrency(stani, 0
            , RoundingMode.HALF_UP).multiplyCurrency(stani)) != 0) {

            taniChkKekka = true;
            String taniSComma = ViewReport.editCommaTuukaNoSpace(stani, BizUtil.ZERO_FILL);
            String msgID = null;
            String msgBungen = null;

            if (C_SysKbn.SKEI.eq(pSysKbn)) {
                if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {

                    if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0033;
                    }

                    if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0083;
                    }

                    if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0114;
                    }

                    if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0203;
                    }

                    if (msgID != null) {
                        if (!C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                            if (!BizUtil.isBlank(msgID)) {
                                msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, taniSComma);
                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    msgBungen,
                                    pMP,
                                    C_TknKbn.KANOU);
                            }
                        }
                    }
                }
                else if (C_SpgndtknKbn.ARI.eq(pSpgndtknKbn)) {

                    if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0033;
                    }

                    if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0083;
                    }

                    if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0114;
                    }

                    if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0203;
                    }

                    if (msgID != null) {
                        if (!C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                            if (!BizUtil.isBlank(msgID)) {
                                msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, taniSComma);
                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    msgBungen,
                                    pMP);
                            }
                        }
                    }
                }
            }
            else if (C_SysKbn.ESHIEN.eq(pSysKbn)) {

                String hubiMsg = setHubiMsg.editHubiMsgKingaku(stani, stani, tuukasyu);

                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1028, "保険金額", hubiMsg),
                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
            }
        }

        if (!taniChkKekka) {

            String saikouSComma = ViewReport.editCommaTuukaNoSpace(saikouS, BizUtil.ZERO_FILL);

            if (saikouS.compareTo(yenknsnKihons) < 0) {

                if (C_SysKbn.SKEI.eq(pSysKbn)) {
                    String msgID = null;
                    String msgBungen = null;

                    if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {
                        if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) ||
                            C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0032;
                        }

                        if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0082;
                        }

                        if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0113;
                        }

                        if (C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0126;
                        }

                        if (C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0201;
                        }

                        if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0202;
                        }

                        if (msgID != null) {
                            msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, saikouSComma);
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                msgBungen,
                                pMP,
                                C_TknKbn.KANOU);
                        }
                    }
                    else if (C_SpgndtknKbn.ARI.eq(pSpgndtknKbn)) {
                        if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) ||
                            C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0032;
                        }

                        if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0082;
                        }

                        if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0113;
                        }

                        if (C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0126;
                        }

                        if (C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0201;
                        }

                        if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                            msgID = MessageId.EHC0202;
                        }

                        if (msgID != null) {
                            msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, saikouSComma);
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                msgBungen,
                                pMP);
                        }
                    }
                }

                else if (C_SysKbn.ESHIEN.eq(pSysKbn)) {

                    String msgSaikouS = null;
                    BizCurrency msgSaikouSgndgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                        msgSaikouSgndgk = saikouS;
                    }
                    else {

                        msgSaikouSgndgk = editTuukaEnToKyktuuka(syoriCtl, mosKihon, saikouS);
                        msgSaikouSgndgk = stani.multiply(msgSaikouSgndgk.divideBizCurrency(stani, 0, RoundingMode.DOWN));
                    }

                    msgSaikouS = setHubiMsg.editHubiMsgKingaku(msgSaikouSgndgk, stani, tuukasyu);

                    String msgTknMji = "";
                    HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                    msgTknMji = hubiMsgEdit.editSeihoWebMsg_Hokenkngk(pMP, mosKihon, syouhnZokusei);

                    setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1024, msgTknMji, msgSaikouS),
                        C_SekmossakuseiErroutKbn.GAMEN, pMP);

                }
            }
        }
    }

    private void checkSaiteiS(List<ChkSaiteiSParam> pChkSaiteiSParam,
        HT_MosSyouhn pMosSyouhnParam,
        BM_SyouhnZokusei pSyouhnZokusei,
        C_SpgndtknKbn pSpgndtknKbn,
        MosnaiCheckParam pMP,
        C_SysKbn pSysKbn,
        BizCurrency pStani) {

        if (pChkSaiteiSParam.size() == 0) {
            throw new CommonBizAppException("最低Ｓテーブルにデータが見つかりません。");
        }
        ChkSaiteiSParam chkSaiteiS = pChkSaiteiSParam.get(0);
        BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;

        C_KihonssyuruiKbn kihonSSyuruiKbn = syouhnZokusei.getKihonssyuruikbn();
        BizCurrency kihonS = pMosSyouhnParam.getKihons();
        BizCurrency saiteiS = chkSaiteiS.getSaiteis();
        String saiteiSComma = ViewReport.editCommaTuukaNoSpace(saiteiS, BizUtil.ZERO_FILL);
        String syouhnNm = syouhnZokusei.getSyouhnnm();

        String msgID = null;
        String msgBungen = null;

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        C_Tuukasyu tuukasyu = mosKihon.getKyktuukasyu();

        if (saiteiS.compareTo(kihonS) > 0) {

            if (C_SysKbn.SKEI.eq(pSysKbn)) {
                if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {
                    if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) || C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0031;
                    }

                    if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0081;
                    }

                    if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0115;
                    }

                    if (C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0127;
                    }

                    if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0204;
                    }

                    if (msgID != null) {
                        msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, saiteiSComma);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgBungen,
                            pMP,
                            C_TknKbn.KANOU);
                    }
                }
                else if (C_SpgndtknKbn.ARI.eq(pSpgndtknKbn)) {
                    if (C_KihonssyuruiKbn.BLNK.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.HKNKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0031;
                    }

                    if (C_KihonssyuruiKbn.NICHIGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0081;
                    }

                    if (C_KihonssyuruiKbn.SYUJYUTUKYHKIN.eq(kihonSSyuruiKbn) ||
                        C_KihonssyuruiKbn.KYHKIN.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0115;
                    }

                    if (C_KihonssyuruiKbn.TUUSANGENDO.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0127;
                    }

                    if (C_KihonssyuruiKbn.GETUGAKU.eq(kihonSSyuruiKbn)) {
                        msgID = MessageId.EHC0204;
                    }

                    if (msgID != null) {
                        msgBungen = msgID + " " + MessageUtil.getMessage(msgID, syouhnNm, saiteiSComma);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgBungen,
                            pMP);
                    }
                }
            }
            else if (C_SysKbn.ESHIEN.eq(pSysKbn)) {

                String hubiMsg = setHubiMsg.editHubiMsgKingaku(saiteiS, pStani, tuukasyu);

                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1022, "保険金額", hubiMsg),
                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
            }
        }

        return;
    }

    private void checkPtani(BizCurrency pPtani,
        C_Tuukasyu pTuukaSyu,
        HT_MosSyouhn pMosSyouhnParam,
        BM_SyouhnZokusei pSyouhnZokusei,
        MosnaiCheckParam pMP) {

        if (pPtani == null) {
            throw new CommonBizAppException("最低Ｐテーブルにデータが見つかりません。");
        }

        BizCurrency mosSyuTkp = pMosSyouhnParam.getHrktuukasyutkp();
        BizCurrency ptani = pPtani;
        HT_SyoriCTL syoriCtl = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();

        if (mosSyuTkp.compareTo(mosSyuTkp.divideCurrency(ptani, 0
            , RoundingMode.HALF_UP).multiplyCurrency(ptani)) != 0) {
            String ptaniComma = null;
            String msgID = null;
            String msgBungen = null;

            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {
                msgID = MessageId.EHC1015;
                ptaniComma = ViewReport.editCommaTuukaNoSpace(ptani, BizUtil.ZERO_FILL);
                msgBungen = msgID + " " + MessageUtil.getMessage(msgID, pSyouhnZokusei.getSyouhnnm(), ptaniComma);
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    msgBungen,
                    pMP);
            }
            else if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

                String msgTknMji = "";
                HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);
                C_Tuukasyu tuukasyu = null;
                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

                    tuukasyu = mosKihon.getHrktuukasyu();
                }
                else {

                    tuukasyu = mosKihon.getKyktuukasyu();
                }

                msgTknMji = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMP, mosKihon, pSyouhnZokusei);

                String hubiMsg = setHubiMsg.editHubiMsgKingaku(ptani, ptani, tuukasyu);

                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1028, msgTknMji, hubiMsg),
                    C_SekmossakuseiErroutKbn.GAMEN, pMP);

            }
        }
    }

    private void checkSaikouP(MosnaiCheckParam pMP,
        HT_SyoriCTL pSyoriCtl,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhnParam,
        BM_SyouhnZokusei pSyouhnZokusei,
        BizCurrency pHanteiyuuP,
        BizCurrency pSaikouP,
        BizCurrency pPtani) {

        BizCurrency hanteiyuuPEn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        C_Tuukasyu pYkjyTuukaSyu = null;

        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

            pYkjyTuukaSyu = pMosKihon.getHrktuukasyu();
        }
        else {

            pYkjyTuukaSyu = pMosKihon.getKyktuukasyu();
        }

        if (C_Tuukasyu.JPY.eq(pYkjyTuukaSyu)) {

            hanteiyuuPEn = pHanteiyuuP;
        }
        else {

            BizCurrency hanteiyuuPHrkTuuka = BizCurrency.valueOf(0);

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

                hanteiyuuPHrkTuuka = editTuukaKyktuukaToHrkTuuka(pSyoriCtl, pMosKihon, pHanteiyuuP);
            }
            else {

                hanteiyuuPHrkTuuka = pHanteiyuuP;
            }

            hanteiyuuPEn = editTuukaKyktuukaToEn(pMosKihon, hanteiyuuPHrkTuuka);
        }

        C_SysKbn sysKbn = pMP.getSysKbn();

        if (hanteiyuuPEn.compareTo(pSaikouP) > 0) {

            if (C_SysKbn.ESHIEN.eq(sysKbn)) {

                String msgSaikouP = null;
                BizCurrency msgSaikouPGndgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (C_Tuukasyu.JPY.eq(pYkjyTuukaSyu)) {

                    msgSaikouPGndgk = pSaikouP;
                }
                else {
                    BizCurrency kansanGkKykTuuka = editTuukaEnToKyktuuka(pSyoriCtl, pMosKihon, pSaikouP);

                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

                        msgSaikouPGndgk = editTuukaHrkTuukaToKyktuuka(pSyoriCtl, pMosKihon, kansanGkKykTuuka);
                    }
                    else {

                        msgSaikouPGndgk = kansanGkKykTuuka;
                    }
                }

                msgSaikouPGndgk = pPtani.multiply(msgSaikouPGndgk.divideBizCurrency(pPtani, 0, RoundingMode.DOWN));

                msgSaikouP = setHubiMsg.editHubiMsgKingakuPKans(
                    msgSaikouPGndgk, pPtani, pYkjyTuukaSyu, true, pMP, pMosKihon, pSyouhnZokusei);

                String msgChange = "";
                HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                msgChange = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMP, pMosKihon, pSyouhnZokusei);

                setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1023, msgChange, msgSaikouP),
                    C_SekmossakuseiErroutKbn.GAMEN, pMP);
            }
            if (C_SysKbn.SKEI.eq(sysKbn)) {

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, MessageId.EHC1038 + " " + MessageUtil.getMessage(MessageId.EHC1038, pSyouhnZokusei.getSyouhnnm(),
                    ViewReport.editCommaTuukaNoSpace(pSaikouP, BizUtil.ZERO_FILL)), pMP, C_TknKbn.KANOU, C_MsgKbn.ERROR );
            }
        }
    }

    private BizCurrency editTuukaKyktuukaToEn(HT_MosKihon pMosKihon,
        BizCurrency pKgkKykTuuka) {

        BizCurrency kansanGk = BizCurrency.valueOf(0);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector
            .getInstance(GetKiteiCheckYenkansangk.class);
        kansanGk = getKiteiCheckYenkansangk.exec(pMosKihon.getMosymd(), pKgkKykTuuka,
            pMosKihon.getKyktuukasyu());

        return kansanGk;
    }

    private BizCurrency editTuukaKyktuukaToHrkTuuka(HT_SyoriCTL pSyoriCtl, HT_MosKihon pMosKihon,
        BizCurrency pKgkHrkTuuka) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());
        BizCurrency kansanGk = BizCurrency.valueOf(0, currencyType);

        if (pMosKihon.getKyktuukasyu().eq(pMosKihon.getHrktuukasyu())) {
            kansanGk = pKgkHrkTuuka;
        }
        else if (!pMosKihon.getKyktuukasyu().eq(pMosKihon.getHrktuukasyu())) {

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            kansanGk = keisanGaikakanzan.execDivide(pMosKihon.getKyktuukasyu(), pKgkHrkTuuka,
                pSyoriCtl.getNyknkwsrate(), C_HasuusyoriKbn.AGE);

        }

        return kansanGk;
    }

    private BizCurrency editTuukaEnToKyktuuka(HT_SyoriCTL pSyoriCtl, HT_MosKihon pMosKihon,
        BizCurrency pKgkEn) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());
        BizCurrency kansanGk = BizCurrency.valueOf(0, currencyType);
        C_Tuukasyu kykTuukaSyu = pMosKihon.getKyktuukasyu();
        String mosNo = pMosKihon.getMosno();

        if (C_Tuukasyu.JPY.eq(kykTuukaSyu)) {
            kansanGk = pKgkEn;
        }
        else {
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            int kijunNendo = setKessanNensibi.exec(pMosKihon.getMosymd()).getYear();

            BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate = bizDomManager.getKijyungkHanteiKawaseRate(
                String.valueOf(kijunNendo), kykTuukaSyu);

            if (kijyungkHanteiKawaseRate == null) {
                throw new CommonBizAppException("申込番号 = " + mosNo);
            }

            BizNumber kjngkHntiyuKawaseRate = kijyungkHanteiKawaseRate.getKjngkhntiyukawaserate();
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            kansanGk = keisanGaikakanzan.execDivide(
                pMosKihon.getKyktuukasyu(), pKgkEn, kjngkHntiyuKawaseRate, C_HasuusyoriKbn.AGE) ;

        }

        return kansanGk;
    }

    private BizCurrency editTuukaHrkTuukaToKyktuuka(HT_SyoriCTL pSyoriCtl, HT_MosKihon pMosKihon,
        BizCurrency pKgkKykTuuka) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getHrktuukasyu());
        BizCurrency kansanGk = BizCurrency.valueOf(0, currencyType);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        C_Tuukasyu kykTuukaSyu = pMosKihon.getKyktuukasyu();
        C_Tuukasyu hrkTuukaSyu = pMosKihon.getHrktuukasyu();

        if (kykTuukaSyu.eq(hrkTuukaSyu)) {
            kansanGk = pKgkKykTuuka;
        }
        else if (!kykTuukaSyu.eq(hrkTuukaSyu)) {
            BizNumber kwsRate = pSyoriCtl.getNyknkwsrate();

            kansanGk = keisanGaikakanzan.exec(
                pMosKihon.getHrktuukasyu(), pKgkKykTuuka, kwsRate, C_HasuusyoriKbn.SUTE) ;

        }

        return kansanGk;
    }

    private void checkKyktaniKitei(List<BM_ChkKeiyakuTaniSaikouS> pChkKeiyakuTaniSaikouSLst,
        SetKyuuhuNitigaku pSetKyuuhuNitigaku,
        C_SysKbn pSysKbn,
        C_SpgndtknKbn pSpgndtknKbn,
        MosnaiCheckParam pMP,
        HT_MosSyouhn pMosSyouhnSyu) {

        BizDate systemDate = pMP.getSysDate();

        if (pChkKeiyakuTaniSaikouSLst.size() > 0) {
            C_TknKbn tknKbn = C_TknKbn.NONE;

            if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {
                tknKbn = C_TknKbn.KANOU;
            }
            else {
                tknKbn = C_TknKbn.SUMI;
            }

            String syuSyohinName = null;
            String seikatuSyukanSyohinName = null;
            String jyoseiSyohinName = null;
            String ganNyuinSyohinName = null;

            Integer mosSyouhinHanteiKbn = SyouhinUtil.hantei(pMosSyouhnSyu.getSyouhncd());
            if (mosSyouhinHanteiKbn == null) {
                syuSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                seikatuSyukanSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                jyoseiSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                ganNyuinSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
            }

            if (mosSyouhinHanteiKbn == null) {
                syuSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                seikatuSyukanSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                jyoseiSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
                ganNyuinSyohinName = syouhinUtil.getSyouhnNm(null, systemDate);
            }

            if (pSetKyuuhuNitigaku.getSipnyutsnntgk1().compareTo(pChkKeiyakuTaniSaikouSLst.get(0).getSaikous1()) > 0) {

                String msg = null;

                if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                    String message = EditString.editStringJoint(new String[]{ syuSyohinName });
                    String saikous1 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous1(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0154 + " " + MessageUtil.getMessage(MessageId.EHC0154, saikous1, message);
                }
                else {
                    String saikous1 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous1(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0151 + " " + MessageUtil.getMessage(MessageId.EHC0151, saikous1);
                }

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    msg,
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }

            if (pSetKyuuhuNitigaku.getSipnyutsnntgk2().compareTo(pChkKeiyakuTaniSaikouSLst.get(0).getSaikous2()) > 0) {

                String msg = null;

                if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                    String message = EditString.editStringJoint(
                        new String[]{ syuSyohinName, seikatuSyukanSyohinName, jyoseiSyohinName });
                    String saikous2 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous2(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0154 + " " + MessageUtil.getMessage(MessageId.EHC0154, saikous2, message);
                }
                else {
                    String saikous2 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous2(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0152 + " " + MessageUtil.getMessage(MessageId.EHC0152, saikous2);
                }

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    msg,
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }

            if (pSetKyuuhuNitigaku.getSipnyutsnntgk3().compareTo(pChkKeiyakuTaniSaikouSLst.get(0).getSaikous3()) > 0) {

                String msg = null;

                if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                    String message = EditString.editStringJoint(
                        new String[]{ syuSyohinName, seikatuSyukanSyohinName, jyoseiSyohinName, ganNyuinSyohinName });
                    String saikous3 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous3(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0154 + " " + MessageUtil.getMessage(MessageId.EHC0154, saikous3, message);
                }
                else {
                    String saikous3 = ViewReport.editCommaTuukaNoSpace(
                        pChkKeiyakuTaniSaikouSLst.get(0).getSaikous3(), BizUtil.ZERO_FILL);

                    msg = MessageId.EHC0153 + " " + MessageUtil.getMessage(MessageId.EHC0153, saikous3);
                }

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    msg,
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }
        }
    }

    private void checkSyhnKokutiJougenS(List<BM_ChkSyouhnKokutiJougenS> pChkSyouhnKokutiJougenSLst,
        String pTokSyouhinCd,
        BizCurrency pTokKihonS,
        C_SysKbn pSysKbn,
        C_SpgndtknKbn pSpgndtknKbn,
        C_SntkhouKbn pSntkhouKbn,
        MosnaiCheckParam pMP,
        C_UmuKbn pGanSdKyhUmu,
        C_KihonssyuruiKbn pKihonssyuruiKbn) {

        BizDate systemDate = pMP.getSysDate();
        BizCurrency saikouS;

        if (C_SntkhouKbn.KKT.eq(pSntkhouKbn) && pChkSyouhnKokutiJougenSLst.size() > 0) {

            saikouS = pChkSyouhnKokutiJougenSLst.get(0).getSaikous();

            if (C_UmuKbn.ARI.eq(pGanSdKyhUmu)) {

                BizCurrency ganhsyNg = getGanhsyNg(pMP.getDataSyoriControl());
                BizCurrency ganhsyNgBai = ganhsyNg.multiply(pChkSyouhnKokutiJougenSLst.get(0).getBairitu());

                if (saikouS.equalsValue(BizCurrency.valueOf(0, saikouS.getType())) || saikouS.compareTo(ganhsyNgBai) > 0) {
                    saikouS = ganhsyNgBai;
                }
            }

            if (pTokKihonS.compareTo(saikouS) > 0) {
                if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        MessageId.WHA0008 + " " + MessageUtil.getMessage(MessageId.WHA0008),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.WARNING);

                    pMP.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.KKTJGSOV);
                }
                else {
                    C_TknKbn tknKbn = C_TknKbn.NONE;
                    if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {
                        tknKbn = C_TknKbn.KANOU;
                    }
                    else {
                        tknKbn = C_TknKbn.SUMI;
                    }

                    String tokSyouhinNm = syouhinUtil.getSyouhnNm(pTokSyouhinCd, systemDate);
                    String msgId = null;

                    if (C_KihonssyuruiKbn.NICHIGAKU.eq(pKihonssyuruiKbn)) {
                        msgId = MessageId.EHC0187;
                    }

                    if (msgId != null) {
                        String saikouSComma = ViewReport.editCommaTuukaNoSpace(saikouS, BizUtil.ZERO_FILL);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            msgId + " " + MessageUtil.getMessage(msgId, saikouSComma, tokSyouhinNm),
                            pMP,
                            tknKbn,
                            C_MsgKbn.ERROR);
                    }
                }
            }
        }
    }

    private void checkKokutiJougenS(List<BM_ChkKokutiJougenS> pChkKokutiJougenSLst,
        BizCurrency pSipnyutsnntgk2,
        C_SysKbn pSysKbn,
        C_SpgndtknKbn pSpgndtknKbn,
        C_SntkhouKbn pSntkhouKbn,
        MosnaiCheckParam pMP) {

        if (C_SntkhouKbn.KKT.eq(pSntkhouKbn) && pChkKokutiJougenSLst.size() > 0) {
            if (pSipnyutsnntgk2.compareTo(pChkKokutiJougenSLst.get(0).getSaikous()) > 0) {

                if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                        MessageId.WHA0008 + " " + MessageUtil.getMessage(MessageId.WHA0008),
                        pMP,
                        C_TknKbn.NONE,
                        C_MsgKbn.WARNING);

                    pMP.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.KKTJGSOV);
                }
                else {
                    C_TknKbn tknKbn = C_TknKbn.NONE;

                    if (C_SpgndtknKbn.NONE.eq(pSpgndtknKbn)) {
                        tknKbn = C_TknKbn.KANOU;
                    }
                    else {
                        tknKbn = C_TknKbn.SUMI;
                    }

                    String saikouSComma = ViewReport.editCommaTuukaNoSpace(
                        pChkKokutiJougenSLst.get(0).getSaikous(), BizUtil.ZERO_FILL);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0155 + " " + MessageUtil.getMessage(MessageId.EHC0155, saikouSComma),
                        pMP,
                        tknKbn,
                        C_MsgKbn.ERROR);
                }
            }
        }
    }

    private void checkTokHkaHs(BM_SyouhnZokusei pSyouhnZokusei,
        String pTokSyouhinNm, MosnaiCheckParam pMP) {

        BM_SyouhnZokusei syouhnZokusei = pSyouhnZokusei;
        String syouhnNm = syouhnZokusei.getSyouhnnm();

        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
            MessageId.EHC0117 + " " + MessageUtil.getMessage(MessageId.EHC0117, syouhnNm, pTokSyouhinNm),
            pMP);
    }

    private void checkYourouTokuyakuHuka(HT_MosSyouhn pSyuMosSyouhnParam,
        BM_SyouhnZokusei pSyuSyouhnZokusei,
        BM_SyouhnZokusei pTkSyouhnZokusei, MosnaiCheckParam pMP) {

        C_SysKbn sysKbn = pMP.getSysKbn();

        BM_SyouhnZokusei syuSyouhnZokusei = pSyuSyouhnZokusei;
        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;

        C_UmuKbn yourouUmu = syuSyouhnZokusei.getYrhknumu();
        int  hknkkn = pSyuMosSyouhnParam.getHknkkn();

        if (C_UmuKbn.ARI.eq(yourouUmu)) {
            if (hknkkn == 6 || hknkkn == 9 || hknkkn == 12) {
                if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0197 + " " + MessageUtil.getMessage(
                            MessageId.EHC0197, syuSyouhnZokusei.getSyouhnnm(), tkSyouhnZokusei.getSyouhnnm()),
                            pMP);
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EBC0014 + " " + MessageUtil.getMessage(
                            MessageId.EBC0014, tkSyouhnZokusei.getSyouhnnm()),
                            pMP);
                }
            }
        }

        return;
    }

    private void checkTokuyakuFukaKahi(List<BM_ChkTkykHukaKahi> pChkTkykHukaKahiLst,
        HT_MosSyouhn pSyuMosSyouhnParam,
        HT_MosSyouhn pTkMosSyouhnParam,
        BM_SyouhnZokusei pSyuSyouhnZokusei,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP) {

        BM_SyouhnZokusei syuSyouhnZokusei = pSyuSyouhnZokusei;
        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;
        C_SysKbn sysKbn = pMP.getSysKbn();

        if (pChkTkykHukaKahiLst.size() == 0) {
            if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0197 + " " + MessageUtil.getMessage(
                        MessageId.EHC0197, syuSyouhnZokusei.getSyouhnnm(), tkSyouhnZokusei.getSyouhnnm()),
                        pMP);
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EBC0014 + " " + MessageUtil.getMessage(
                        MessageId.EBC0014, tkSyouhnZokusei.getSyouhnnm()), pMP);
            }
        }
        else {
            Integer hukaKahiKbn = pChkTkykHukaKahiLst.get(0).getHukakahikbn();

            if (hukaKahiKbn == 1) {
            }
            else if (hukaKahiKbn == 2) {

                if (pSyuMosSyouhnParam.getHrkkkn() > pTkMosSyouhnParam.getHknkkn()) {
                } else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0035 + " " + MessageUtil.getMessage(MessageId.EHC0035, tkSyouhnZokusei.getSyouhnnm()),
                        pMP);
                }
            }
            else if (hukaKahiKbn == 3) {

                if (C_KataKbn.HONNIN.eq(pTkMosSyouhnParam.getKatakbn())) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0036 + " " + MessageUtil.getMessage(MessageId.EHC0036, tkSyouhnZokusei.getSyouhnnm()),
                        pMP);
                }
            }
            else if (hukaKahiKbn == 4) {

                if (C_KataKbn.HONNIN.eq(pTkMosSyouhnParam.getKatakbn())) {
                }
                else if (C_KataKbn.HONNIN_TUMA.eq(pTkMosSyouhnParam.getKatakbn())) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0029 + " " + MessageUtil.getMessage(MessageId.EHC0029, tkSyouhnZokusei.getSyouhnnm()),
                        pMP);
                }
            }
            else if (hukaKahiKbn == 5) {

                if (C_HknkknsmnKbn.NENMANKI.eq(pSyuMosSyouhnParam.getHknkknsmnkbn()) &&
                    !C_HknkknsmnKbn.NENMANKI.eq(pTkMosSyouhnParam.getHknkknsmnkbn())) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0077 + " " + MessageUtil.getMessage(MessageId.EHC0077, tkSyouhnZokusei.getSyouhnnm()),
                        pMP);
                }
                else {
                }
            }
            else {
                throw new CommonBizAppException();
            }
        }

        return;
    }

    private void checkTokBairitu(List<BM_ChkTkykHukaKahi> pChkTkykHukaKahiLst,
        HT_MosSyouhn pTkMosSyouhnParam,
        HT_MosSyouhn pSyuMosSyouhnParam,
        BM_SyouhnZokusei pSyuSyouhnZokusei,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        BizCurrency pHutuuSibous,
        MosnaiCheckParam pMP) {

        BM_SyouhnZokusei syuSyouhnZokusei = pSyuSyouhnZokusei;
        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;

        if (pChkTkykHukaKahiLst == null || pChkTkykHukaKahiLst.size() == 0) {
        }
        else {

            BM_ChkTkykHukaKahi chkTkykHukaKahi = pChkTkykHukaKahiLst.get(0);

            BizNumber tkBairitu = chkTkykHukaKahi.getTkbairitu();
            BizCurrency futuuS = pHutuuSibous.multiply(tkBairitu);
            BizCurrency tkSyouhinKihonS = pTkMosSyouhnParam.getKihons();
            BizCurrency syuSyouhinKihonS = pSyuMosSyouhnParam.getKihons();
            BizCurrency kihonS = syuSyouhinKihonS.multiply(tkBairitu);
            C_UmuKbn nitigakuUmu = syuSyouhnZokusei.getKihonsntgkumu();
            String hugou = chkTkykHukaKahi.getTkbairituhugou();

            String messageId = null;

            if (C_UmuKbn.NONE.eq(nitigakuUmu)) {

                boolean result = isTokBaiCheck(futuuS, tkSyouhinKihonS, hugou);
                if (result) {
                }
                else {
                    if (hugou.equals("=")) {
                        messageId = MessageId.EHC0141;
                    }
                    else {
                        messageId = MessageId.EHC0037;
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        messageId + " " + MessageUtil.getMessage(messageId, tkSyouhnZokusei.getSyouhnnm(),
                            ViewReport.editCommaTuukaNoSpace(futuuS, BizUtil.ZERO_FILL)),
                            pMP);
                }
            }
            else if (C_UmuKbn.ARI.eq(nitigakuUmu)) {

                boolean result = isTokBaiCheck(kihonS, tkSyouhinKihonS, hugou);
                if (result) {
                }
                else {
                    if (hugou.equals("=")) {
                        messageId = MessageId.EHC0141;
                    }
                    else {
                        messageId = MessageId.EHC0037;
                    }

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        messageId + " " + MessageUtil.getMessage(messageId, tkSyouhnZokusei.getSyouhnnm(),
                            ViewReport.editCommaTuukaNoSpace(kihonS, BizUtil.ZERO_FILL)),
                            pMP);
                }
            }
        }

        return;
    }

    private void checkTokHukaSeigen(List<BM_ChkTkykHukaSeigen> pChkTkykHukaSeigenLst,
        C_SysKbn pSysKbn,
        C_NenkkntknKbn pNenkkntknKbn,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP) {

        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;

        if (pChkTkykHukaSeigenLst.size() != 0) {
            if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
                setHubiMsg.exec(C_KetsrhkosKbn.WARNING,
                    MessageId.WHA0011 + " " + MessageUtil.getMessage(MessageId.WHA0011, tkSyouhnZokusei.getSyouhnnm()),
                    pMP,
                    C_TknKbn.NONE,
                    C_MsgKbn.WARNING);

                pMP.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.TKHKSGERR);
            }
            else {
                C_TknKbn tknKbn = C_TknKbn.NONE;

                if (C_NenkkntknKbn.NONE.eq(pNenkkntknKbn)) {
                    tknKbn = C_TknKbn.KANOU;
                }
                else {
                    tknKbn = C_TknKbn.SUMI;
                }

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0162 + " " + MessageUtil.getMessage(MessageId.EHC0162, tkSyouhnZokusei.getSyouhnnm()),
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }
        }
    }

    private void checkSetTokHukaSeigen(String pSyuSyouhinCd,
        String pTkSyouhinCd,
        C_SysKbn pSysKbn,
        HT_MosKihon pMosKihon,
        BM_SyouhnZokusei pSyuSyouhnZokusei,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP) {

        BM_SyouhnZokusei syuSyouhnZokusei = pSyuSyouhnZokusei;
        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;

        Integer syuSyouhinHanteiKbn = SyouhinUtil.hantei(pSyuSyouhinCd);
        if (syuSyouhinHanteiKbn == null) {

            if ((C_SysKbn.ESHIEN.eq(pSysKbn) && !BizUtil.isBlank(pMP.getSetAiteMosNo())) ||
                (C_SysKbn.SKEI.eq(pSysKbn) && !BizUtil.isBlank(pMosKihon.getAitemosno()))) {

                Integer tkSyouhinHanteiKbn = SyouhinUtil.hantei(pTkSyouhinCd);
                if (tkSyouhinHanteiKbn == null) {

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0149 + " " + MessageUtil.getMessage(MessageId.EHC0149,
                            syuSyouhnZokusei.getSyouhnnm(), tkSyouhnZokusei.getSyouhnnm()),
                            pMP,
                            C_TknKbn.NONE,
                            C_MsgKbn.ERROR);
                }
            }
        }
    }

    private void checkTKykKanouNenrei(HT_MosSyouhn pSyuMosSyouhnParam,
        HT_MosSyouhn pTkMosSyouhnParam,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP,
        C_NenkkntknKbn pNenkkntknKbn,
        StringBuffer pKykknnennjchkskb,
        C_SysKbn pSysKbn,
        int pHhknNen,
        C_Hhknsei pHhknSei,
        C_Channelcd pChannelCd) {

        if (C_Channelcd.BLNK.eq(pChannelCd)) {
            return;
        }

        C_TknKbn tknKbn = C_TknKbn.KANOU;
        if (C_NenkkntknKbn.ARI.eq(pNenkkntknKbn)) {
            tknKbn = C_TknKbn.NONE;
        }

        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;
        String tkSyouhinNm = tkSyouhnZokusei.getSyouhnnm();

        if (C_NenkkntknKbn.NONE.eq(pNenkkntknKbn)) {
            if (C_SysKbn.ESHIEN.eq(pSysKbn)) {

                if (!KYK_KNNEN_NJCHK_SKB.equals(pKykknnennjchkskb.toString())) {

                    List<BM_ChkNenreiHani2> chkNenreiHani2Lst = bizDomManager.
                        getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(pChannelCd,
                            pSyuMosSyouhnParam.getSyouhncd(),
                            pSyuMosSyouhnParam.getSyouhnsdno(),
                            BizNumber.valueOf(pHhknNen),
                            Integer.parseInt(pHhknSei.getValue()),
                            pSyuMosSyouhnParam.getKatakbn(),
                            pSyuMosSyouhnParam.getHknkkn(),
                            pSyuMosSyouhnParam.getHknkknsmnkbn(),
                            pSyuMosSyouhnParam.getHrkkkn(),
                            pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                            pSyuMosSyouhnParam.getDai1hknkkn(),
                            pTkMosSyouhnParam.getSyouhncd(),
                            BizNumber.valueOf(pTkMosSyouhnParam.getHknkkn()),
                            pTkMosSyouhnParam.getHknkknsmnkbn(),
                            BizNumber.valueOf(pTkMosSyouhnParam.getHrkkkn()),
                            pTkMosSyouhnParam.getHrkkknsmnkbn(),
                            C_UmuKbn.NONE,
                            C_UmuKbn.ARI);

                    if (chkNenreiHani2Lst.size() == 0) {

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                            MessageId.EHC0186 + " " + MessageUtil.getMessage(MessageId.EHC0186, tkSyouhinNm),
                            pMP,
                            tknKbn,
                            C_MsgKbn.ERROR);

                        pKykknnennjchkskb.append(KYK_KNNEN_NJCHK_SKB);
                    }
                }
            }
            else {
                List<BM_ChkNenreiHani2> chkNenreiHani2Lst = bizDomManager.
                    getChkNenreiHani2sByPkSyukatakbnumuTkykmossyouhnumu(pChannelCd,
                        pSyuMosSyouhnParam.getSyouhncd(),
                        pSyuMosSyouhnParam.getSyouhnsdno(),
                        BizNumber.valueOf(pHhknNen),
                        Integer.parseInt(pHhknSei.getValue()),
                        pSyuMosSyouhnParam.getKatakbn(),
                        pSyuMosSyouhnParam.getHknkkn(),
                        pSyuMosSyouhnParam.getHknkknsmnkbn(),
                        pSyuMosSyouhnParam.getHrkkkn(),
                        pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                        pSyuMosSyouhnParam.getDai1hknkkn(),
                        pTkMosSyouhnParam.getSyouhncd(),
                        BizNumber.valueOf(pTkMosSyouhnParam.getHknkkn()),
                        pTkMosSyouhnParam.getHknkknsmnkbn(),
                        BizNumber.valueOf(pTkMosSyouhnParam.getHrkkkn()),
                        pTkMosSyouhnParam.getHrkkknsmnkbn(),
                        C_UmuKbn.ARI,
                        C_UmuKbn.ARI);

                if (chkNenreiHani2Lst.size() == 0) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0028 + " " + MessageUtil.getMessage(MessageId.EHC0028, tkSyouhinNm),
                        pMP,
                        tknKbn,
                        C_MsgKbn.ERROR);
                }
            }
        }
        else {
            List<BM_ChkJhNenreiHani2> chkJhNenreiHani2Lst = bizDomManager.
                getChkJhNenreiHani2sByPkTkykmossyouhnumu(pChannelCd,
                    pSyuMosSyouhnParam.getSyouhncd(),
                    pSyuMosSyouhnParam.getSyouhnsdno(),
                    BizNumber.valueOf(pHhknNen),
                    Integer.parseInt(pHhknSei.getValue()),
                    pSyuMosSyouhnParam.getKatakbn(),
                    pSyuMosSyouhnParam.getHknkkn(),
                    pSyuMosSyouhnParam.getHknkknsmnkbn(),
                    pSyuMosSyouhnParam.getHrkkkn(),
                    pSyuMosSyouhnParam.getHrkkknsmnkbn(),
                    pSyuMosSyouhnParam.getDai1hknkkn(),
                    pTkMosSyouhnParam.getSyouhncd(),
                    BizNumber.valueOf(pTkMosSyouhnParam.getHknkkn()),
                    pTkMosSyouhnParam.getHknkknsmnkbn(),
                    BizNumber.valueOf(pTkMosSyouhnParam.getHrkkkn()),
                    pTkMosSyouhnParam.getHrkkknsmnkbn(),
                    C_UmuKbn.ARI);

            if (chkJhNenreiHani2Lst.size() == 0) {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0028 + " " + MessageUtil.getMessage(MessageId.EHC0028, tkSyouhinNm),
                    pMP,
                    tknKbn,
                    C_MsgKbn.ERROR);
            }
        }
    }

    private void check80tkumu(HT_MosSyouhn pSyuMosSyouhnParam,
        HT_MosSyouhn pTkMosSyouhnParam,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP,
        int pHhknNen) {

        int syuHknkkn = pSyuMosSyouhnParam.getHknkkn();
        int syuHrkkkn = pSyuMosSyouhnParam.getHrkkkn();
        int tkHknkkn = pTkMosSyouhnParam.getHknkkn();
        int tkHrkkkn = pTkMosSyouhnParam.getHrkkkn();
        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;
        int hhknNen = pHhknNen;

        if (syuHknkkn > TKYK_NEN) {
            if (tkHknkkn == TKYK_NEN) {
                if (tkHrkkkn == TKYK_NEN) {
                }
                else if (tkHrkkkn == syuHrkkkn) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0038 + " " + MessageUtil.getMessage(
                            MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HRKKKN),
                            pMP);
                }
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0038 + " " + MessageUtil.getMessage(
                        MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HKNKKN),
                        pMP);
            }
        }
        else {

            int tkHknnen;
            if (C_HknkknsmnKbn.NENMANKI.eq(pTkMosSyouhnParam.getHknkknsmnkbn())) {
                tkHknnen = hhknNen + tkHknkkn;
            }
            else {
                tkHknnen = tkHknkkn;
            }

            if (syuHknkkn == tkHknkkn && tkHknnen <= TKYK_NEN) {

                int tkHrknen;
                if (C_HrkkknsmnKbn.NENMANKI.eq(pTkMosSyouhnParam.getHrkkknsmnkbn())) {
                    tkHrknen = hhknNen + tkHrkkkn;
                }
                else {
                    tkHrknen = tkHrkkkn;
                }

                if (tkHrkkkn == syuHrkkkn && tkHrknen <= TKYK_NEN) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0038 + " " + MessageUtil.getMessage(
                            MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HRKKKN),
                            pMP);
                }
            }
            else if (tkHknkkn == TKYK_NEN) {
                if (tkHrkkkn == TKYK_NEN) {
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        MessageId.EHC0038 + " " + MessageUtil.getMessage(
                            MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HRKKKN),
                            pMP);
                }
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0038 + " " + MessageUtil.getMessage(
                        MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HKNKKN),
                        pMP);
            }
        }

        return;
    }

    private void checkNenreiHani(HT_MosSyouhn pSyuMosSyouhnParam,
        HT_MosSyouhn pTkMosSyouhnParam,
        BM_SyouhnZokusei pTkSyouhnZokusei,
        MosnaiCheckParam pMP) {

        int syuHknkkn = pSyuMosSyouhnParam.getHknkkn();
        int syuHrkkkn = pSyuMosSyouhnParam.getHrkkkn();
        int tkHknkkn = pTkMosSyouhnParam.getHknkkn();
        int tkHrkkkn = pTkMosSyouhnParam.getHrkkkn();

        BM_SyouhnZokusei tkSyouhnZokusei = pTkSyouhnZokusei;

        if (tkHknkkn == syuHknkkn) {
            if (tkHrkkkn == syuHrkkkn) {
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                    MessageId.EHC0038 + " " + MessageUtil.getMessage(
                        MessageId.EHC0038, tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HRKKKN),
                        pMP);
            }
        }
        else {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EHC0038 + " " +
                    MessageUtil.getMessage(MessageId.EHC0038,
                        tkSyouhnZokusei.getSyouhnnm(), ICommonKoumoku.DISP_N_HKNKKN),
                        pMP);
        }

        return;
    }

    private void checkJigyouIkkatu(HT_SyoriCTL pSyoriCTL,
        HT_MosSyouhn pSyuMosSyouhnParam,
        MosnaiCheckParam pMP) {

        String daiMosno = pSyoriCTL.getDaimosno();
        if (daiMosno == null || daiMosno.length() == 0) {
            return;
        }

        List<HT_MosSyouhn> moschkMosSyouhnParamLst = new ArrayList<>();

        List<HT_MosSyouhn> mosSyouhnLst = sinkeiyakuDomManager.getSyoriCTL(daiMosno).getMosSyouhnsBySyutkkbn(
            C_SyutkKbn.SYU);
        if (mosSyouhnLst != null) {
            moschkMosSyouhnParamLst.addAll(mosSyouhnLst);
        }

        if (moschkMosSyouhnParamLst.size() == 0) {
            throw new CommonBizAppException("代表申込番号の異常");
        }

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(
            daiMosno, C_SyutkKbn.SYU, pMP.getSysDate());
        BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);
        C_UmuKbn jgyIktUmu = syouhnZokusei.getJgyiktumu();

        if (C_UmuKbn.ARI.eq(jgyIktUmu)) {

            String syouhinCd = pSyuMosSyouhnParam.getSyouhncd();
            String dSyouhinCd = moschkMosSyouhnParamLst.get(0).getSyouhncd();

            if (syouhinCd.equals(dSyouhinCd)) {
            }
            else {
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                    C_HubisyubetusyousaiKbn.NONE,
                    MessageId.EHC0084 + " " + MessageUtil.getMessage(MessageId.EHC0084),
                    pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
            }
        }
        else {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA, C_HubisyubetusyousaiKbn.NONE,
                MessageId.EHC0085 + " " + MessageUtil.getMessage(MessageId.EHC0085),
                pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }
    }

    private BizCurrency getGanhsyNg(HT_SyoriCTL pSyoriCTL) {

        List<HT_MosSyouhn> mosSyouhnParamLst = new ArrayList<>();

        mosSyouhnParamLst = pSyoriCTL.getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType kyktuukaType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());
        BizCurrency ganHsyNg = BizCurrency.valueOf(0, kyktuukaType);

        for (HT_MosSyouhn mosSyouhnParam : mosSyouhnParamLst) {
            ganHsyNg = ganHsyNg.add(mosSyouhnParam.getKihons());
        }

        return ganHsyNg;
    }

    private void checkSueokiKikan(List<BM_ChkSueokiKikan> pChkSueokiKikanList, MosnaiCheckParam pMP) {
        if (pChkSueokiKikanList.size() == 0) {
            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                MessageId.EBC0046 + " " + MessageUtil.getMessage(MessageId.EBC0046, "据置期間"), pMP);
        }
    }
}