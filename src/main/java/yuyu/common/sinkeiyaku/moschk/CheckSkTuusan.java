package yuyu.common.sinkeiyaku.moschk;

import java.math.BigDecimal;
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

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.TakeiyakuTuusanInfoParam;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.common.biz.bzcommon.TuusanKeiyakuInfoParam;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SkeikikeiyakuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tuusan;

/**
 * 新契約 申込内容チェック 新契約通算チェック
 */
public class CheckSkTuusan {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private CheckTuusan checkTuusan;

    @Inject
    private Tuusan tuusan;

    public CheckSkTuusan() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 新契約通算チェック 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        C_SysKbn sysKbn = pMp.getSysKbn();
        String mosNo = syoriCTL.getMosno();
        List<TuusanKeiyakuInfoParam> tuusanKykInfoParamLst = new ArrayList<>();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_SntkhouKbn sntkhouKbn = mosKihon.getSntkhoukbn();
        BizDate mosYmd = mosKihon.getMosymd();
        C_Tuukasyu tuukasyu = mosKihon.getKyktuukasyu();
        BizCurrency yenkansanKihonS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency tkhKihonS = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenkansanSyutkp = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenkansanJituhsgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenkansanNkgnsgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        if (mosSyouhnLst.size() == 0) {
            throw new CommonBizAppException("申込番号 =" + mosNo);
        }

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

            BM_SyouhnZokusei syouhnZokusei = pMp.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

            TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);

            yenkansanKihonS = getKiteiCheckYenkansangk.exec(mosYmd, mosSyouhn.getSeitoukihons(), tuukasyu);

            if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
                String msg = "";
                msg = makeMsgYenKanzanError(sysKbn);
                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);

                break;
            }

            if(C_SysKbn.SKEI.eq(sysKbn) && !C_UmuKbn.ARI.eq(syoriCTL.getTkhsyouryakuumukbn())){
                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

                if (mosDairitenLst.size() == 0) {
                }
                else if (mosDairitenLst.size() > 2) {

                    throw new CommonBizAppException("申込代理店件数異常 申込番号：" + mosNo);
                }
                else {

                    BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);

                    if (mosDairitenLst.size() == 2) {
                        HT_MosDairiten mosDairiten1 = syoriCTL.getMosDairitenByRenno(1);
                        HT_MosDairiten mosDairiten2 = syoriCTL.getMosDairitenByRenno(2);

                        bzGetTuukeiBunwari.exec(mosDairiten1.getTratkiagcd(), mosDairiten1.getOyadrtencd(), mosDairiten1.getBunwari(),
                            mosDairiten2.getTratkiagcd(), mosDairiten2.getOyadrtencd(), mosDairiten2.getBunwari(),
                            pMp.getSysDate().getBizDateYM(), syouhnZokusei.getDrtsyouhinsikibetukbn(), mosKihon.getHrkkaisuu(), C_DiritenplannmKbn.BLNK);
                    }

                    int count = 0;
                    BizNumber bunwari = BizNumber.ZERO;
                    C_TkrtkKinyuuknHyouji tkrtkKinyuuknHyouji = C_TkrtkKinyuuknHyouji.BLNK;
                    C_KydsskKinyuuknHyouji kydsskKinyuuknHyouji = C_KydsskKinyuuknHyouji.BLNK;
                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    for (HT_MosDairiten mosDairiten : mosDairitenLst) {
                        if (count == 1 && mosDairitenLst.get(0).getOyadrtencd().equals(mosDairitenLst.get(1).getOyadrtencd())){
                            break;
                        }
                        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(mosDairiten.getOyadrtencd());
                        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
                            if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                                tkrtkKinyuuknHyouji = bzGetAgInfoBean.getTkrtkKinyuuknHyouji();
                                kydsskKinyuuknHyouji = bzGetAgInfoBean.getKydsskKinyuuknHyouji();

                            }
                        }
                        if (C_TkrtkKinyuuknHyouji.TOKUREITIIKI.eq(tkrtkKinyuuknHyouji) ||
                            C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI.eq(kydsskKinyuuknHyouji)) {

                            if (mosDairitenLst.size() == 1) {
                                bunwari = BizNumber.valueOf(new BigDecimal(100));
                            }
                            else if (mosDairiten.getRenno() == 1) {
                                bunwari = bzGetTuukeiBunwari.getBuntanWariai1();
                            }
                            else {
                                bunwari = bzGetTuukeiBunwari.getBuntanWariai2();
                            }

                            tkhKihonS = yenkansanKihonS.multiply((bunwari.divide(100)), 0, RoundingMode.HALF_UP);

                            break;
                        }
                        count++;
                    }

                    if (C_TkrtkKinyuuknHyouji.TOKUREITIIKI.eq(tkrtkKinyuuknHyouji)) {
                        pMp.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);
                    }

                    if (C_KydsskKinyuuknHyouji.KYOUDOUSOSIKI.eq(kydsskKinyuuknHyouji)) {
                        pMp.setKydsskKinyuuknUmuKbn(C_UmuKbn.ARI);
                    }
                }
            }

            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                yenkansanSyutkp = mosSyouhn.getHrktuukasyutkp();
            }
            else {
                yenkansanSyutkp = getKiteiCheckYenkansangk.exec(mosYmd, mosSyouhn.getSyutkp(), tuukasyu);
                if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
                    String msg = "";
                    msg = makeMsgYenKanzanError(sysKbn);
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                    break;
                }
            }

            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                BizCurrency jituhsgkKeiyakuTuuka = mosSyouhn.getSeitoukihons().subtract(mosSyouhn.getSyutkp());
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukasyu);
                if (jituhsgkKeiyakuTuuka.compareTo(BizCurrency.valueOf(0, currencyType)) < 0) {

                    jituhsgkKeiyakuTuuka = BizCurrency.valueOf(0, currencyType);
                }
                yenkansanJituhsgk = getKiteiCheckYenkansangk.exec(mosYmd, jituhsgkKeiyakuTuuka, tuukasyu);

                if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {
                    String msg = "";
                    msg = makeMsgYenKanzanError(sysKbn);

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                    break;
                }
            }

            if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {

                EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                BizCurrency nkgnsgk = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);

                C_Tuukasyu nkgnsgkTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(nkgnsgk.getType());
                if (C_Tuukasyu.JPY.eq(nkgnsgkTuukasyu)) {

                    yenkansanNkgnsgk = nkgnsgk;
                }
                else {
                    yenkansanNkgnsgk = getKiteiCheckYenkansangk.exec(mosYmd, nkgnsgk, nkgnsgkTuukasyu);

                    if (C_ErrorKbn.ERROR.eq(getKiteiCheckYenkansangk.getErrorKbn())) {

                        String msg = "";
                        msg = makeMsgYenKanzanError(sysKbn);

                        setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, msg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
                        pMp.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
                        break;
                    }
                }
            }


            tuusanKeiyakuInfoParam.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.SKEI);
            tuusanKeiyakuInfoParam.setSntkhouKbn(sntkhouKbn);
            tuusanKeiyakuInfoParam.setKijyunYmd(mosKihon.getMosymd());
            tuusanKeiyakuInfoParam.setKykYmd(null);
            tuusanKeiyakuInfoParam.setHhknNen(mosKihon.getHhknnen());
            tuusanKeiyakuInfoParam.setHrkKaisuu(mosKihon.getHrkkaisuu());
            tuusanKeiyakuInfoParam.setKihonS(yenkansanKihonS);
            tuusanKeiyakuInfoParam.setTkhKihonS(tkhKihonS);
            tuusanKeiyakuInfoParam.setItijibrp(yenkansanSyutkp);
            tuusanKeiyakuInfoParam.setJituHsgk(yenkansanJituhsgk);
            tuusanKeiyakuInfoParam.setNkgnsgk(yenkansanNkgnsgk);
            tuusanKeiyakuInfoParam.setSyuusinhknUmu(syouhnZokusei.getSyuusinhknumu());
            tuusanKeiyakuInfoParam.setStsnUmu(syouhnZokusei.getStsnumu());
            tuusanKeiyakuInfoParam.setNkgnsTuusanUmu(syouhnZokusei.getNkgnstuusanumu());
            tuusanKeiyakuInfoParam.setNenbtSouSbusTuusanUmu(syouhnZokusei.getNenbtsousbustuusanumu());
            tuusanKeiyakuInfoParam.setSouKktJituHsgkTuusanUmu(syouhnZokusei.getSoukktjituhsgktuusanumu());
            tuusanKeiyakuInfoParam.setMsnyNenbtSbusTuusanUmu(syouhnZokusei.getMsnynenbtsbustuusanumu());
            tuusanKeiyakuInfoParam.setKktJituHsgk1TuusanUmu(syouhnZokusei.getKktjituhsgk1tuusanumu());
            tuusanKeiyakuInfoParam.setKktJituHsgk2TuusanUmu(syouhnZokusei.getKktjituhsgk2tuusanumu());
            tuusanKeiyakuInfoParam.setKykDrtenTuusanUmuKbn(syouhnZokusei.getKykdrtentuusanumu());
            tuusanKeiyakuInfoParam.setItijibrpTsnUmu(syouhnZokusei.getItijibrptsnumu());
            tuusanKeiyakuInfoParam.setTktHknsyruiTsnKbn(syouhnZokusei.getTkthknsyruitsnkbn());
            tuusanKykInfoParamLst.add(tuusanKeiyakuInfoParam);
        }

        if (!C_SakuintsnKbn.ERROR.eq(pMp.getSakuinTsnKbn())) {
            HT_Tuusan tuusanTbl = syoriCTL.getTuusan();

            TakeiyakuTuusanInfoParam takeiyakuTuusanInfoParam = null;
            BizCurrency tsnketSibous = BizCurrency.valueOf(0);

            if (tuusanTbl != null) {
                takeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);

                takeiyakuTuusanInfoParam.setTsnSibouS(tuusanTbl.getTsnsibous());
                takeiyakuTuusanInfoParam.setTsnNinenMikeikaS(tuusanTbl.getTsnninenmikeikas());
                takeiyakuTuusanInfoParam.setTsnNinenKeikaS(tuusanTbl.getTsnninenkeikas());
                takeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(tuusanTbl.getTsnninenmikeikahtnkns());
                takeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(tuusanTbl.getTsnninenkeikadfp());
                takeiyakuTuusanInfoParam.setTsnKetSibouS(tuusanTbl.getTsnketsibous());
                takeiyakuTuusanInfoParam.setTsnKetSibouS2(tuusanTbl.getTsnketsibous2());
                takeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(tuusanTbl.getTsnsoukktjituhsgk());
                takeiyakuTuusanInfoParam.setTsnKktJituHsgk1(tuusanTbl.getTsnkktjituhsgk1());
                takeiyakuTuusanInfoParam.setTsnKktJituHsgk2(tuusanTbl.getTsnkktjituhsgk2());
                takeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(tuusanTbl.getTsnkktitijibrsysnjs());
                takeiyakuTuusanInfoParam.setTsnNkgns(tuusanTbl.getTsnnkgns());
                takeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(tuusanTbl.getTsnmsnynenbtsousbus());
                takeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(tuusanTbl.getTsnnenbtitijibrssbs());
                takeiyakuTuusanInfoParam.setKykDrtenTsns(tuusanTbl.getKykdrtentsns());
                takeiyakuTuusanInfoParam.setTsnItijibrSysnp(tuusanTbl.getTsnitijibrsysnp());
                takeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(tuusanTbl.getTsnsntktuukahijynsysns());
                tsnketSibous = tuusanTbl.getTsnketsibous();
            }

            tuusan.exec(tuusanKykInfoParamLst, takeiyakuTuusanInfoParam);

            for (TuusanKeiyakuInfoParam tuusanKykInfoParam :tuusanKykInfoParamLst) {
                tsnketSibous = tsnketSibous.add(tuusanKykInfoParam.getKihonS());
            }
            pMp.setTsnketsibous(tsnketSibous);

            pMp.setTuusan(tuusan);

            checkTuusan.exec(pMp, tuusan);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 新契約通算チェック 終了");
        }
    }

    private String makeMsgYenKanzanError(C_SysKbn pSysKbn) {

        String msg = "";

        if (C_SysKbn.SKEI.eq(pSysKbn)) {

            msg = MessageUtil.getMessage(MessageId.EHC1021);

            return MessageId.EHC1021 + " " + msg;
        }

        msg = MessageUtil.getMessage(MessageId.EHC0125);

        return MessageId.EHC0125 + " " + msg;
    }
}