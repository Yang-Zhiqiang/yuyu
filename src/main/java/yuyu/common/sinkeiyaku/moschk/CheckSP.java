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
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.EditHeijyunbaraiP;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
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
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.entity.BM_ChkJhSaiteiS;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.entity.BM_ChkSaiteiS;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック SPチェック
 */
public class CheckSP {

    public static final int YENKA_MIN_TANI = 1;

    public static final double GAIKA_MIN_TANI = 0.01d;

    public static final int YENKA_TANI_100YEN = 100;

    public static final int GAIKA_TANI_1DOLLAR = 1;

    private boolean checkSPErrFlg = false;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private CheckSaiteiP checkSaiteiP;

    @Inject
    private BizDomManager bizDomManager;

    public CheckSP() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ＳＰチェック 開始");
        }

        HanteiMoschk hanteiMoschk = SWAKInjector.getInstance(HanteiMoschk.class);
        CheckTuusan checkTuusan = SWAKInjector.getInstance(CheckTuusan.class);

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        C_SysKbn sysKbn = pMp.getSysKbn();
        C_Channelcd kiteichkChcd = pMp.getKiteiCheckChannelCd();
        String mosno = syoriCTL.getMosno();
        checkSPErrFlg = false;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_Sdpd sdpdKbn = mosKihon.getSdpdkbn();
        C_Tuukasyu kykTuukasyu = mosKihon.getKyktuukasyu();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();
        C_Hrkkeiro hrkkeiro = mosKihon.getHrkkeiro();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getKyktuukasyu());

        CurrencyType hrkCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon.getHrktuukasyu());

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();

        if (mosSyouhnLst == null || mosSyouhnLst.size() == 0) {
            throw new CommonBizAppException("申込番号 = " + mosno);
        }

        List<HT_MosSyouhn> syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuMosSyouhnLst.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + mosno);
        }

        HT_MosSyouhn syuSyouhnnm = syuMosSyouhnLst.get(0);

        BM_SyouhnZokusei syuSyouhnZokusei = pMp.getSyuSyouhnZokusei();
        List<BM_SyouhnZokusei> syouhnZokuseiList = pMp.getListTkSyouhnZokusei();

        int syohinHanteiKbn = SyouhinUtil.hantei(pMp.getSyuSyouhnZokusei().getSyouhncd());
        C_PtratkituukasiteiKbn ptratkituukasiteikbn = syuSyouhnZokusei.getPtratkituukasiteikbn();

        BizCurrency taniP = checkTuusan.getPTani(syoriCTL, mosKihon, syuSyouhnnm, kiteichkChcd, ptratkituukasiteikbn);

        C_YouhiKbn saiteiYouhiKbnP = hanteiMoschk.hanteiMosSyouhnSaiteiP(syuSyouhnZokusei, syouhnZokuseiList);

        if (C_YouhiKbn.YOU.eq(saiteiYouhiKbnP) && C_Sdpd.SD.eq(sdpdKbn)) {
            checkSaiteiP.exec(pMp, syuSyouhnnm, syuSyouhnZokusei, syuSyouhnnm.getSyutkp(), kykTuukasyu);

            boolean chkhubigaitouflg = checkSaiteiP.getChkhubigaitouflg();

            if (chkhubigaitouflg) {
                checkSPErrFlg = true;
            }
        }

        C_YouhiKbn saiteiYouhiKbn = hanteiMoschk.hanteiSpSaiteiS(syuSyouhnZokusei, syouhnZokuseiList);
        if (C_YouhiKbn.YOU.eq(saiteiYouhiKbn)) {
            if (C_Sdpd.PD.eq(sdpdKbn)) {
                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                    C_TknKbn spgndTknkbn = C_TknKbn.KANOU;
                    C_SpgndtknKbn spGndTknKbn = C_SpgndtknKbn.NONE;

                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        HT_Tokunin tokunin = syoriCTL.getTokunin();

                        if (tokunin != null) {
                            if (C_SpgndtknKbn.ARI.eq(tokunin.getSpgndtknkbn())) {
                                spgndTknkbn = C_TknKbn.NONE;
                                spGndTknKbn = C_SpgndtknKbn.ARI;
                            }
                        }
                    }
                    BizCurrency saiteiS = BizCurrency.valueOf(0);
                    BizCurrency seitouKihonS = new BizCurrency();

                    if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {
                        List<BM_ChkSaiteiS> chkSaiteiSLst = bizDomManager.getChkSaiteiSsBySyouhncdSyouhnsdnoItems(
                            syuSyouhnnm.getSyouhncd(),
                            syuSyouhnnm.getSyouhnsdno(),
                            hrkkeiro,
                            Integer.parseInt(C_UmuKbn.NONE.getValue()),
                            kykTuukasyu);

                        if (chkSaiteiSLst.size() == 0) {
                            throw new CommonBizAppException("最低Ｓチェックマスタにデータが存在しません。");
                        }

                        saiteiS = chkSaiteiSLst.get(0).getSaiteis();
                        seitouKihonS = syuSyouhnnm.getSeitoukihons();
                    }
                    else {
                        List<BM_ChkJhSaiteiS> chkJhSaiteiSLst =
                            bizDomManager.getChkJhSaiteiSsByPk(syuSyouhnnm.getSyouhncd(),
                                syuSyouhnnm.getSyouhnsdno(),
                                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                                Integer.parseInt(syuSyouhnnm.getHrkkknsmnkbn().getValue()),
                                BizNumber.valueOf(syuSyouhnnm.getHknkkn()),
                                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                                Integer.parseInt(C_UmuKbn.NONE.getValue()),
                                kykTuukasyu);

                        if (chkJhSaiteiSLst.size() == 0) {
                            throw new CommonBizAppException("最低Ｓ事方書チェックマスタにデータが存在しません。");
                        }
                        saiteiS = chkJhSaiteiSLst.get(0).getSaiteis();
                        seitouKihonS = syuSyouhnnm.getSeitoukihons();
                    }

                    if (seitouKihonS != null && saiteiS.compareTo(seitouKihonS) > 0) {
                        if (C_SysKbn.SKEI.eq(sysKbn)) {
                            String saiteiSComma = ViewReport.editCommaTuukaNoSpace(saiteiS, BizUtil.ZERO_FILL);

                            String msgBungen = MessageId.EHC0031 + " " + MessageUtil.getMessage(MessageId.EHC0031,
                                syuSyouhnZokusei.getSyouhnnm(), saiteiSComma);

                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgBungen, pMp, spgndTknkbn);
                        }
                        else if (C_SysKbn.ESHIEN.eq(sysKbn)) {
                            String msgChange = "";
                            HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                            msgChange = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syuSyouhnZokusei);

                            BizCurrency saiteiP = getHrkTuukasyuP(syoriCTL, mosKihon, syuSyouhnnm, saiteiS, syohinHanteiKbn, pMp,
                                ptratkituukasiteikbn, taniP);

                            String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(saiteiP,
                                taniP, henkanTuuka.henkanTuukaTypeToKbn(saiteiP.getType()), false, pMp, mosKihon, syuSyouhnZokusei);

                            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1022, msgChange, hubiMsg),
                                C_SekmossakuseiErroutKbn.GAMEN, pMp);
                        }

                        checkSPErrFlg = true;
                    }
                }
                else {
                    List<BM_ChkJhSaiteiS> chkJhSaiteiSLst =
                        bizDomManager.getChkJhSaiteiSsByPk(syuSyouhnnm.getSyouhncd(),
                            syuSyouhnnm.getSyouhnsdno(),
                            Integer.parseInt(C_UmuKbn.NONE.getValue()),
                            Integer.parseInt(C_UmuKbn.NONE.getValue()),
                            Integer.parseInt(syuSyouhnnm.getHrkkknsmnkbn().getValue()),
                            BizNumber.valueOf(syuSyouhnnm.getHknkkn()),
                            Integer.parseInt(C_UmuKbn.NONE.getValue()),
                            Integer.parseInt(C_UmuKbn.NONE.getValue()),
                            kykTuukasyu);

                    if (chkJhSaiteiSLst.size() == 0) {
                        throw new CommonBizAppException("最低Ｓ事方書チェックマスタにデータが存在しません。");
                    }
                    BizCurrency seitouKihonS = syuSyouhnnm.getSeitoukihons();
                    BizCurrency saiteiS = chkJhSaiteiSLst.get(0).getSaiteis();
                    if (seitouKihonS != null && saiteiS.compareTo(seitouKihonS) > 0) {
                        if (C_SysKbn.SKEI.eq(sysKbn)) {
                            String saiteiSComma = ViewReport.editCommaTuukaNoSpace(saiteiS, BizUtil.ZERO_FILL);
                            String msgBungen = MessageId.EHC0031 + " " + MessageUtil.getMessage(MessageId.EHC0031,
                                syuSyouhnZokusei.getSyouhnnm(), saiteiSComma);
                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msgBungen, pMp);
                        }
                        else if (C_SysKbn.ESHIEN.eq(sysKbn)) {

                            String msgChange = "";
                            HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

                            msgChange = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syuSyouhnZokusei);

                            BizCurrency saiteiP = getHrkTuukasyuP(syoriCTL, mosKihon, syuSyouhnnm, saiteiS, syohinHanteiKbn, pMp,
                                ptratkituukasiteikbn, taniP);

                            String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(
                                saiteiP, taniP, henkanTuuka.henkanTuukaTypeToKbn(saiteiP.getType()), false, pMp, mosKihon, syuSyouhnZokusei);

                            setHubiMsg.exec("", MessageUtil.getMessage(MessageId.EGA1022, msgChange, hubiMsg),
                                C_SekmossakuseiErroutKbn.GAMEN, pMp);
                        }
                        checkSPErrFlg = true;
                    }
                }
            }
        }

        C_YouhiKbn spSaikouYouhiKbn = hanteiMoschk.hanteiSpSaikouS(syuSyouhnZokusei, syouhnZokuseiList);
        if (C_YouhiKbn.YOU.eq(spSaikouYouhiKbn) && C_Sdpd.PD.eq(sdpdKbn)) {
            C_TknKbn spgndTknkbn = C_TknKbn.KANOU;
            C_SpgndtknKbn spGndTknKbn = C_SpgndtknKbn.NONE;
            if (C_SysKbn.SKEI.eq(sysKbn)) {
                HT_Tokunin tokunin = syoriCTL.getTokunin();
                if (tokunin != null) {
                    if (C_SpgndtknKbn.ARI.eq(tokunin.getSpgndtknkbn())) {
                        spgndTknkbn = C_TknKbn.NONE;
                        spGndTknKbn = C_SpgndtknKbn.ARI;
                    }
                }
            }

            BizCurrency saikousGndgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            if (C_SpgndtknKbn.NONE.eq(spGndTknKbn)) {
                List<BM_ChkSaikouSSTani> chkSaikouSSTani = bizDomManager.getChkSaikouSSTanisByPk(
                    syuSyouhnnm.getSyouhncd(),
                    syuSyouhnnm.getSyouhnsdno(),
                    BizNumber.valueOf(mosKihon.getHhknnen()),
                    Integer.valueOf(C_MosKbn.BLNK.getValue()),
                    C_Tuukasyu.JPY);
                if (chkSaikouSSTani != null && chkSaikouSSTani.size() != 0) {
                    saikousGndgkYen = chkSaikouSSTani.get(0).getSaikous();
                }
                else {
                    throw new CommonBizAppException("最高ＳＳ単位テーブルにデータが存在しません。");
                }
            }
            else {
                List<BM_ChkJhSaikouSSTani> chkJhSaikouSSTani = bizDomManager.getChkJhSaikouSSTanisByPk(
                    syuSyouhnnm.getSyouhncd(),
                    syuSyouhnnm.getSyouhnsdno(),
                    BizNumber.valueOf(mosKihon.getHhknnen()),
                    Integer.valueOf(C_MosKbn.BLNK.getValue()),
                    C_Tuukasyu.JPY);
                if (chkJhSaikouSSTani != null && chkJhSaikouSSTani.size() != 0) {
                    saikousGndgkYen = chkJhSaikouSSTani.get(0).getSaikous();
                }
                else {
                    throw new CommonBizAppException("最高ＳＳ単位事方書テーブルにデータが存在しません。");
                }
            }

            GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector
                .getInstance(GetKiteiCheckYenkansangk.class);
            BizCurrency kihonSYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

            boolean saikouHokenkngkFlg = false;

            for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                BizCurrency yenkansanGk = getKiteiCheckYenkansangk.exec(mosKihon.getMosymd(), mosSyouhn.getSeitoukihons(),
                    mosKihon.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
                    String errMsg = null;
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        errMsg = new StringBuffer(MessageId.EHC1039)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC1039, "最高保険金額（ＳＰ）チェック")).toString();
                    }
                    else {
                        errMsg = new StringBuffer(MessageId.EHC0125)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC0125)).toString();
                    }
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    saikouHokenkngkFlg = true;
                    break;
                }
                kihonSYen = kihonSYen.add(yenkansanGk);
            }
            if (!saikouHokenkngkFlg) {

                if (saikousGndgkYen.compareTo(kihonSYen) < 0) {
                    BizCurrency saikousP = checkTuusan.getGndHaninaiP(syoriCTL, mosKihon, syuSyouhnnm, kiteichkChcd,
                        saikousGndgkYen, pMp.getPdateSRate(), pMp.getHrbtJyousu(), ptratkituukasiteikbn);
                    String hubiMsgSaikousP;
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        String hubiMsgSaikousYen = ViewReport.editCommaTuukaNoSpace(saikousGndgkYen, BizUtil.ZERO_FILL);
                        String tikanMsg = null;
                        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                            tikanMsg = "一時払保険料";
                        }
                        else {
                            tikanMsg = "保険料";
                        }
                        hubiMsgSaikousP = ViewReport.editCommaTuukaNoSpace(saikousP, BizUtil.ZERO_FILL);
                        String errMsg = MakeHubiMsg.exec(MessageId.EHC1118, MessageId.EHC1118, hubiMsgSaikousYen, tikanMsg, hubiMsgSaikousP);
                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp, spgndTknkbn, C_MsgKbn.ERROR);
                    }
                    else {
                        hubiMsgSaikousP = setHubiMsg.editHubiMsgKingakuPKans(
                            saikousP, taniP, henkanTuuka.henkanTuukaTypeToKbn(saikousP.getType()), true, pMp, mosKihon, syuSyouhnZokusei);
                        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);
                        String errMsg = MessageUtil.getMessage(MessageId.EGA1024,
                            hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syuSyouhnZokusei), hubiMsgSaikousP);
                        setHubiMsg.exec("", errMsg, C_SekmossakuseiErroutKbn.GAMEN, pMp);
                    }
                    checkSPErrFlg = true;
                }
            }
        }

        if (C_Sdpd.PD.eq(sdpdKbn)) {
            if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
            }
        }

        C_YouhiKbn saikouYouhiKbn = hanteiMoschk.hanteiSpSaikouNenkinGensiGendo(syuSyouhnZokusei, syouhnZokuseiList);
        if (C_YouhiKbn.YOU.eq(saikouYouhiKbn)) {
            List<BM_ChkNkgnsHonken> chkNkgnsHonkenList = bizDomManager.getChkNkgnsHonkenByPk(syuSyouhnnm.getSyouhncd(),
                syuSyouhnnm.getSyouhnsdno(), mosKihon.getHhknnen());

            if (chkNkgnsHonkenList.size() == 0) {
                throw new CommonBizAppException("年金原資本件チェックマスタにデータが存在しません。");
            }
            BizCurrency maxNKgnsgndgkYen = chkNkgnsHonkenList.get(0).getNkgnsgndgk();

            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);
            BizCurrency nkGnsgndgkKyk = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syuSyouhnZokusei, mosKihon, syuSyouhnnm);

            C_Tuukasyu nkGnsgndgkKykTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(nkGnsgndgkKyk.getType());

            BizCurrency nkGnsgndgkKykYen = BizCurrency.optional();
            boolean maxNKgnsgndFlg = false;
            if(C_Tuukasyu.JPY.eq(nkGnsgndgkKykTuukasyu)){

                nkGnsgndgkKykYen = nkGnsgndgkKyk;
            }
            else{

                GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
                nkGnsgndgkKykYen = getKiteiCheckYenkansangk.exec(mosKihon.getMosymd(), nkGnsgndgkKyk, nkGnsgndgkKykTuukasyu);

                if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
                    String errMsg = null;
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        errMsg = new StringBuffer(MessageId.EHC1039)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC1039, "年金原資限度額（本件）チェック")).toString();
                    }
                    else {
                        errMsg = new StringBuffer(MessageId.EHC0125)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC0125)).toString();
                    }
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    maxNKgnsgndFlg = true;
                }
            }
            if (!maxNKgnsgndFlg) {
                if (maxNKgnsgndgkYen.compareTo(nkGnsgndgkKykYen) < 0 ) {
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        String henkanKekka = ViewReport.editCommaTuukaNoSpace(maxNKgnsgndgkYen, BizUtil.ZERO_FILL);
                        String errMsg = new StringBuffer(MessageId.EHC1062)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC1062, syuSyouhnZokusei.getSyouhnnm(), henkanKekka)).toString();

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp);
                    }
                    else {
                        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);
                        String gkKoumokuDisp = hubiMsgEdit.editSeihoWebMsg_Hokenryou(pMp, mosKihon, syuSyouhnZokusei);

                        BizCurrency maxNKgnsgndgkpHrktuuka = BizCurrency.optional();
                        if(!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

                            EditHeijyunbaraiP editHeijyunbaraiP = SWAKInjector.getInstance(EditHeijyunbaraiP.class);
                            maxNKgnsgndgkpHrktuuka = maxNKgnsgndgkYen;
                            C_ErrorKbn errorKbn = editHeijyunbaraiP
                                .editSouharaiPToHeijyunbaraiP(maxNKgnsgndgkpHrktuuka, hrkKaisuu, syuSyouhnnm.getHrkkkn(),
                                    syuSyouhnnm.getHrkkknsmnkbn(), mosKihon.getHhknnen(), C_HasuusyoriKbn.SUTE);

                            if (C_ErrorKbn.OK.eq(errorKbn)){

                                BizCurrency heijyunbaraiP = editHeijyunbaraiP.getHeijyunbaraiP();
                                maxNKgnsgndgkpHrktuuka = heijyunbaraiP;
                            }
                        }
                        else {

                            maxNKgnsgndgkpHrktuuka = checkTuusan.getGndHaninaiPbyItjbrSouhrkp(syoriCTL, mosKihon, syuSyouhnnm,
                                kiteichkChcd, maxNKgnsgndgkYen, C_UmuKbn.NONE, ptratkituukasiteikbn);
                        }
                        maxNKgnsgndgkpHrktuuka = taniP.multiply(maxNKgnsgndgkpHrktuuka.divideBizCurrency(taniP, 0, RoundingMode.DOWN));
                        String maxNKgnsgndDisp = setHubiMsg.editHubiMsgKingakuPKans(
                            maxNKgnsgndgkpHrktuuka, taniP,
                            henkanTuuka.henkanTuukaTypeToKbn(maxNKgnsgndgkpHrktuuka.getType()), true, pMp, mosKihon,
                            syuSyouhnZokusei);
                        String errMsg = MessageUtil.getMessage(MessageId.EGA1041, gkKoumokuDisp, maxNKgnsgndDisp);

                        setHubiMsg.exec("", errMsg, C_SekmossakuseiErroutKbn.GAMEN, pMp);
                    }
                    checkSPErrFlg = true;
                }
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            C_BlnktkumuKbn blnktkumuKbn = hanteiMoschk.hanteiSpCheckKingakuSouiJissiyouhi(syuSyouhnZokusei, syouhnZokuseiList, mosKihon);
            if (C_BlnktkumuKbn.ARI.eq(blnktkumuKbn)) {
                if (C_Sdpd.SD.eq(sdpdKbn)) {

                    BizCurrency temp = null;

                    CurrencyType yakujouCurrencyTypeP = currencyType;

                    if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syuSyouhnZokusei.getPtratkituukasiteikbn())) {
                        yakujouCurrencyTypeP = hrkCurrencyType;
                    }

                    BizCurrency mosSyokai = BizCurrency.valueOf(0, yakujouCurrencyTypeP);

                    temp = mosKihon.getMosheijyunp();

                    if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                        temp = mosKihon.getMosfstpkei();
                    }

                    if (temp != null) {
                        mosSyokai = temp;
                    }

                    BizCurrency keisannkgk = BizCurrency.valueOf(0, yakujouCurrencyTypeP);

                    temp = mosKihon.getHeijyunp();
                    if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                        temp = mosKihon.getFstphrkgk();
                    }

                    if (temp != null) {
                        keisannkgk = temp;
                    }

                    if (mosSyokai.compareTo(keisannkgk) != 0) {
                        String errMsg = new StringBuffer(MessageId.EHC0060)
                        .append(" ")
                        .append(MessageUtil.getMessage(MessageId.EHC0060,
                            syuSyouhnZokusei.getSyouhnnm(),
                            ViewReport.editCommaTuukaNoSpace(keisannkgk, BizUtil.ZERO_FILL)))
                            .toString();

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp);

                        checkSPErrFlg = true;
                    }
                }

                if (C_Sdpd.PD.eq(sdpdKbn) && C_UmuKbn.ARI.eq(syuSyouhnZokusei.getHokenkngkyakujyouumu())) {

                    BizCurrency temp = null;

                    for (HT_MosSyouhn mosSyouhntemp : mosSyouhnLst) {

                        BizCurrency kihonS = BizCurrency.valueOf(0, currencyType);

                        temp = mosSyouhntemp.getKihons();

                        if (temp != null) {
                            kihonS = temp;
                        }

                        BizCurrency seitouKihonS = BizCurrency.valueOf(0, currencyType);

                        temp = mosSyouhntemp.getSeitoukihons();

                        if (temp != null) {
                            seitouKihonS = temp;
                        }

                        if (kihonS.compareTo(seitouKihonS) != 0) {

                            String syouhncd = mosSyouhntemp.getSyouhncd();
                            Integer syouhnsdno = mosSyouhntemp.getSyouhnsdno();

                            String syouhinNm = bizDomManager.getSyouhnZokusei(syouhncd, syouhnsdno).getSyouhnnm();
                            String errMsg = new StringBuffer(MessageId.EHC0061)
                            .append(" ")
                            .append(MessageUtil.getMessage(MessageId.EHC0061, syouhinNm,
                                ViewReport.editCommaTuukaNoSpace(seitouKihonS, BizUtil.ZERO_FILL)))
                                .toString();

                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp);

                            checkSPErrFlg = true;
                        }
                    }
                }
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if((C_UmuKbn.ARI.eq(syuSyouhnZokusei.getIkkatubaraiumu()) || C_UmuKbn.ARI.eq(syuSyouhnZokusei.getTeikiikkatubaraiumu()))
                && !C_IkkatubaraiKaisuuKbn.BLNK.eq(mosKihon.getIkkatubaraikaisuu())
                && mosKihon.getMosikkatup().compareTo(BizCurrency.valueOf(0, mosKihon.getMosikkatup().getType())) != 0
                && mosKihon.getIkkatup().compareTo(BizCurrency.valueOf(0, mosKihon.getIkkatup().getType())) != 0
                && mosKihon.getMosikkatup().compareTo(mosKihon.getIkkatup()) != 0) {

                String errMsg = new StringBuffer(MessageId.EHC1110)
                .append(" ")
                .append(MessageUtil.getMessage(MessageId.EHC1110,
                    ICommonKoumoku.DISP_S_TEIKIIKKTUBARAIP, ICommonKoumoku.DISP_S_TEIKIIKKTUBARAIP,
                    ViewReport.editCommaTuukaNoSpace(mosKihon.getIkkatup(), BizUtil.ZERO_FILL))).toString();

                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp);

                checkSPErrFlg = true;
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            if(C_UmuKbn.ARI.eq(syuSyouhnZokusei.getZennouumu()) && C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())
                && mosKihon.getMoszennoupsyokaiari().compareTo(BizCurrency.valueOf(0, mosKihon.getMoszennoupsyokaiari().getType())) != 0
                && mosKihon.getZennoup().compareTo(BizCurrency.valueOf(0, mosKihon.getZennoup().getType())) != 0
                && mosKihon.getZennoujyuutoup().compareTo(BizCurrency.valueOf(0, mosKihon.getZennoujyuutoup().getType())) != 0) {

                BizCurrency kikaiKeisanZennouP = mosKihon.getZennoup().add(mosKihon.getZennoujyuutoup());

                if(mosKihon.getMoszennoupsyokaiari().compareTo(kikaiKeisanZennouP) != 0) {

                    String errMsg = new StringBuffer(MessageId.EHC1110)
                    .append(" ")
                    .append(MessageUtil.getMessage(MessageId.EHC1110,
                        ICommonKoumoku.DISP_S_ZENNOUP, ICommonKoumoku.DISP_S_ZENNOUP,
                        ViewReport.editCommaTuukaNoSpace(kikaiKeisanZennouP, BizUtil.ZERO_FILL))).toString();

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, errMsg, pMp);

                    checkSPErrFlg = true;
                }
            }
        }

        if (!checkSPErrFlg) {
            pMp.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ ＳＰチェック 終了");

        }
    }

    private BizCurrency getHrkTuukasyuP(
        HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn,
        BizCurrency pKykTuukaS,
        int pSyohinHanteiKbn,
        MosnaiCheckParam pMp,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn,
        BizCurrency pTaniP) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        C_Tuukasyu kykTuukasyu = pMosKihon.getKyktuukasyu();

        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);
        BizCurrency kykTuukaP = BizCurrency.valueOf(0, kykCurrencyType);

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == pSyohinHanteiKbn  ||
            SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == pSyohinHanteiKbn  ||
            SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyohinHanteiKbn) {
            kykTuukaP = getKagenP(
                pSyoriCTL,
                pMosKihon,
                pMosSyouhn,
                pKykTuukaS,
                kykTuukasyu,
                pMp.getPdateSRate(),
                pMp.getHrbtJyousu(),
                pPtratkituukasiteiKbn,
                pTaniP);
        }

        return kykTuukaP;
    }

    public BizCurrency getKagenP(
        HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn,
        BizCurrency pKykTuukaS,
        C_Tuukasyu pKykTuukasyu,
        BizNumber pPdateSRat,
        BizNumber pHrbtJyousu,
        C_PtratkituukasiteiKbn pPtratkituukasiteiKbn,
        BizCurrency pTaniP) {

        CheckTuusan checkTuusan = SWAKInjector.getInstance(yuyu.common.sinkeiyaku.moschk.CheckTuusan.class);
        C_Tuukasyu kykTuukasyu = pKykTuukasyu;
        C_Tuukasyu hrktuukasyu = pMosKihon.getHrktuukasyu();
        C_Hrkkaisuu hrkKaisuu = pMosKihon.getHrkkaisuu();
        BizNumber pdateSRat = pPdateSRat;
        BizNumber hrbtJyousu = pHrbtJyousu;
        C_PtratkituukasiteiKbn ptratkituukasiteiKbn = pPtratkituukasiteiKbn;
        BizCurrency  taniP = pTaniP;

        BizCurrency kykTuukaS = pKykTuukaS.subtract(BizCurrency.valueOf(GAIKA_TANI_1DOLLAR, pKykTuukaS.getType()));
        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
            kykTuukaS = pKykTuukaS.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, pKykTuukaS.getType()));
        }
        else{
            if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                kykTuukaS = pKykTuukaS.subtract(BizCurrency.valueOf(YENKA_TANI_100YEN, BizCurrencyTypes.YEN));
            }
        }

        BizCurrency kykTuukaP = pKykTuukaS;
        if (pdateSRat != null) {
            kykTuukaP = kykTuukaS.divide(pdateSRat, 0, RoundingMode.DOWN);

            if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                kykTuukaP = kykTuukaP.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));
            }
            else {
                kykTuukaP = kykTuukaP.add(BizCurrency.valueOf(GAIKA_MIN_TANI, kykTuukaP.getType()));
            }
        }
        else {
            return kykTuukaP;
        }

        if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
            kykTuukaP = kykTuukaP.multiply(hrbtJyousu);
        }

        BizCurrency yakujouTuukaP = kykTuukaP;
        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(ptratkituukasiteiKbn) &&
            !hrktuukasyu.eq(kykTuukasyu)) {

            kykTuukaP = kykTuukaP.subtract(BizCurrency.valueOf(GAIKA_MIN_TANI, kykTuukaP.getType()));
            yakujouTuukaP = checkTuusan.editTuukaKykToHrk(pSyoriCTL, pMosKihon, kykTuukaP);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            if (C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(yakujouTuukaP.getType()))) {
                yakujouTuukaP = yakujouTuukaP.add(BizCurrency.valueOf(YENKA_MIN_TANI, BizCurrencyTypes.YEN));
            }
            else {
                yakujouTuukaP = yakujouTuukaP.add(BizCurrency.valueOf(GAIKA_MIN_TANI, yakujouTuukaP.getType()));
            }
        }

        return taniP.multiply(yakujouTuukaP.divideBizCurrency(taniP, 0, RoundingMode.UP));
    }
}
