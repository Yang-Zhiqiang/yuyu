package yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai;

import static yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.BzKensyouyouRatedbsyoukaiConstants.*;
import static yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai.GenBzKensyouyouRatedbsyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetDrate2;
import yuyu.common.biz.bzcommon.BzGetDrateBean;
import yuyu.common.biz.bzcommon.BzGetPrate2;
import yuyu.common.biz.bzcommon.BzGetPrateBean;
import yuyu.common.biz.bzcommon.BzGetVrate2;
import yuyu.common.biz.bzcommon.BzGetVrateBean;
import yuyu.common.biz.bzcommon.BzGetWrate;
import yuyu.common.biz.bzcommon.BzGetWrateBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.hozen.haitou.NaiteiKakuteiRateHantei;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzKensyouyouRatedbsyoukaiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DRateGetKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_PalAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_PalHhknsei;
import yuyu.def.classification.C_PalHrkkaisuuKbn;
import yuyu.def.classification.C_PalPmenKbn;
import yuyu.def.classification.C_PalRyourituKbn;
import yuyu.def.classification.C_PalSaimankikykhyoujiKbn;
import yuyu.def.classification.C_RateSyoukaiKbn;
import yuyu.def.classification.C_RateTuukasyuKbn;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VRateGetKbn;
import yuyu.def.classification.C_WRateGetKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * 検証用レートＤＢ照会 のビジネスロジックです。
 */
public class BzKensyouyouRatedbsyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzKensyouyouRatedbsyoukaiUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    @Transactional
    void pushSyoukaibtnbyinputkeyBL() {

        BizNumber yoteiriritu = BizNumber.ZERO;
        String reportYoteiriritu = "";
        String ryouritusdno = "";
        C_Hrkkaisuu hrkkaisuu= C_Hrkkaisuu.BLNK;
        C_Hhknsei hhknsei = C_Hhknsei.BLNK;
        C_HknkknsmnKbn hknkknsmnkbn = C_HknkknsmnKbn.BLNK;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.BLNK;
        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
        int dai1hknkkn = 0;
        C_RyourituKbn ryouritukbn = C_RyourituKbn.BLNK;
        BzGetPrateBean bzGetPrateBean = SWAKInjector.getInstance(BzGetPrateBean.class);
        BzGetVrateBean bzGetVrateBean = SWAKInjector.getInstance(BzGetVrateBean.class);
        BzGetDrateBean bzGetDrateBean = SWAKInjector.getInstance(BzGetDrateBean.class);
        BzGetWrateBean bzGetWrateBean = SWAKInjector.getInstance(BzGetWrateBean.class);
        String syouhnnm = "";
        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        resultKbn = chkRateSyoukaiTaisyouSyouhn();

        if (C_ErrorKbn.ERROR.eq(resultKbn)) {
            throw new BizLogicException(MessageId.EBF1029);
        }

        int syouhinUtilKekka = SyouhinUtil.hantei(uiBean.getDisppalhokensyuruikigou());

        if (syouhinUtilKekka == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
            syouhinUtilKekka == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            if (uiBean.getSuurikykymd() != null &&
                C_HokenSyuruiKigouSedaiKbn.BLNK.eq(uiBean.getDisphksyuruikigousedaikbn()) &&
                uiBean.getDispyoteiriritu() == null) {
                resultKbn = C_ErrorKbn.OK;
            }
            else if(uiBean.getSuurikykymd() == null &&
                !C_HokenSyuruiKigouSedaiKbn.BLNK.eq(uiBean.getDisphksyuruikigousedaikbn()) &&
                uiBean.getDispyoteiriritu() != null) {
                resultKbn = C_ErrorKbn.OK;
            }
            else {
                resultKbn = C_ErrorKbn.ERROR;
            }

            if (C_ErrorKbn.ERROR.eq(resultKbn)) {
                throw new BizLogicException(MessageId.EBC1016,
                    DDID_RATEKEYNYUURYOKUGROUP_SUURIKYKYMD,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPHKSYURUIKIGOUSEDAIKBN,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPYOTEIRIRITU);
            }
        }
        else {
            if (uiBean.getSuurikykymd() != null &&
                C_HokenSyuruiKigouSedaiKbn.BLNK.eq(uiBean.getDisphksyuruikigousedaikbn()) &&
                uiBean.getDispyoteiriritu() == null &&
                !C_RateTuukasyuKbn.BLNK.eq(uiBean.getDispratetuukasyukbn())) {
                resultKbn = C_ErrorKbn.OK;
            }
            else if (uiBean.getSuurikykymd() == null &&
                !C_HokenSyuruiKigouSedaiKbn.BLNK.eq(uiBean.getDisphksyuruikigousedaikbn()) &&
                uiBean.getDispyoteiriritu() != null &&
                !C_RateTuukasyuKbn.BLNK.eq(uiBean.getDispratetuukasyukbn())) {
                resultKbn = C_ErrorKbn.OK;
            }
            else {
                resultKbn = C_ErrorKbn.ERROR;
            }

            if (C_ErrorKbn.ERROR.eq(resultKbn)) {
                throw new BizLogicException(MessageId.EBC1019,
                    DDID_RATEKEYNYUURYOKUGROUP_SUURIKYKYMD,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPRATETUUKASYUKBN,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPHKSYURUIKIGOUSEDAIKBN,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPYOTEIRIRITU,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPRATETUUKASYUKBN);
            }
        }

        if (syouhinUtilKekka != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
            syouhinUtilKekka != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            if (C_PalAnnaiFuyouRiyuuKbn.BLNK.eq(uiBean.getDisppalannaihuyouriyuukbn()) ||
                C_RateTuukasyuKbn.BLNK.eq(uiBean.getDispratetuukasyukbn()) ||
                uiBean.getDai1hknkkn() == null) {
                throw new BizLogicException(MessageId.EBC1020,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPPALANNAIHUYOURIYUUKBN,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPRATETUUKASYUKBN,
                    DDID_RATEKEYNYUURYOKUGROUP_DAI1HKNKKN);
            }
        }

        if (C_RateSyoukaiKbn.PRATE.eq(uiBean.getRatesyoukaikbn())) {
            if (syouhinUtilKekka != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR &&
                syouhinUtilKekka != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                if (C_PalRyourituKbn.BLNK.eq(uiBean.getDisppalryouritukbn())) {
                    throw new BizLogicException(MessageId.EAC0042, DDID_RATEKEYNYUURYOKUGROUP_DISPPALRYOURITUKBN);
                }
            }
        }
        else {
            if (!C_PalRyourituKbn.BLNK.eq(uiBean.getDisppalryouritukbn())) {
                throw new BizLogicException(MessageId.EBC0006, DDID_RATEKEYNYUURYOKUGROUP_DISPPALRYOURITUKBN);
            }
        }

        if (C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn())) {
            if (uiBean.getDispdnendo() == null || C_NaiteiKakuteiKbn.BLNK.eq(uiBean.getDispdratenaiteikakuteikbn())) {
                throw new BizLogicException(MessageId.EBC1017,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPDNENDO,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPDRATENAITEIKAKUTEIKBN);
            }
        }

        if (!C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn())) {
            if (uiBean.getDispdnendo() != null || !C_NaiteiKakuteiKbn.BLNK.eq(uiBean.getDispdratenaiteikakuteikbn())) {
                throw new BizLogicException(MessageId.EBC1018,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPDNENDO,
                    DDID_RATEKEYNYUURYOKUGROUP_DISPDRATENAITEIKAKUTEIKBN);
            }
        }

        if (C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn()) &&
            C_NaiteiKakuteiKbn.KAKUTEI.eq(uiBean.getDispdratenaiteikakuteikbn())){

            NaiteiKakuteiRateHantei kakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);

            C_ErrorKbn errorKbn = kakuteiRateHantei.exec(
                BizDate.getSysDate(), BizDateY.valueOf(uiBean.getDispdnendo()), C_UmuKbn.NONE);

            if (C_ErrorKbn.ERROR.eq(errorKbn)){
                throw new BizLogicException(MessageId.EBC1015);
            }

            if (C_NaiteiKakuteiKbn.NAITEI.eq(kakuteiRateHantei.getNaiteiKakuteiKbn())){
                throw new BizLogicException(MessageId.EBC1015);
            }
        }

        if (C_RateTuukasyuKbn.JPY.eq(uiBean.getDispratetuukasyukbn())){
            tuukasyu = C_Tuukasyu.JPY;
        }
        else if (C_RateTuukasyuKbn.USD.eq(uiBean.getDispratetuukasyukbn())){
            tuukasyu = C_Tuukasyu.USD;
        }
        else if (C_RateTuukasyuKbn.AUD.eq(uiBean.getDispratetuukasyukbn())){
            tuukasyu = C_Tuukasyu.AUD;
        }

        if (uiBean.getSuurikykymd() != null) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            getYoteirirituBean.setSyouhncd(uiBean.getDisppalhokensyuruikigou());
            getYoteirirituBean.setKijyunymd(DATE_INIT);
            getYoteirirituBean.setSknnkaisiymd(DATE_INIT);
            getYoteirirituBean.setKykymd(uiBean.getSuurikykymd());
            getYoteirirituBean.setHknkkn(0);
            getYoteirirituBean.setHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
            getYoteirirituBean.setHhknnen(0);
            getYoteirirituBean.setSitihsyuriritu(BizNumber.ZERO);
            getYoteirirituBean.setTuukasyu(tuukasyu);

            C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                yoteiriritu = RIRITU_ZERO;
                reportYoteiriritu = YOTEIRIRITU_NONE;
            }
            else {
                yoteiriritu = getYoteiriritu.getYoteiriritu();

                reportYoteiriritu = Strings.padStart(
                    yoteiriritu.multiply(PRATETANI).toString(), 5, '0');

                reportYoteiriritu = reportYoteiriritu.substring(
                    reportYoteiriritu.length() - 3, reportYoteiriritu.length());
            }
        }
        else {
            yoteiriritu = BizNumber.valueOf(uiBean.getDispyoteiriritu()).divide(PRATETANI);
            reportYoteiriritu = BizUtil.num(String.valueOf(uiBean.getDispyoteiriritu()), BizUtil.ZERO_FILL, 3);
        }

        if (uiBean.getSuurikykymd() != null) {
            List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(
                uiBean.getDisppalhokensyuruikigou(), uiBean.getSuurikykymd());

            if (syouhnZokuseiLst.size() == 0) {

                ryouritusdno = RYOURITUSDNO_NONE;
            }
            else {
                BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

                ryouritusdno = syouhnZokusei.getRyouritusdno().substring(0,1);
            }
        }
        else {
            ryouritusdno = uiBean.getDisphksyuruikigousedaikbn().getValue();
        }

        if (C_PalHrkkaisuuKbn.ITIJI.eq(uiBean.getDispharaikomikaisuukbn())) {
            hrkkaisuu = C_Hrkkaisuu.ITIJI;
        }
        else if (C_PalHrkkaisuuKbn.TUKI.eq(uiBean.getDispharaikomikaisuukbn())) {
            hrkkaisuu = C_Hrkkaisuu.TUKI;
        }

        if (C_PalHhknsei.MALE.eq(uiBean.getSuurihhknsei())) {
            hhknsei = C_Hhknsei.MALE;
        }
        else if (C_PalHhknsei.FEMALE.eq(uiBean.getSuurihhknsei())) {
            hhknsei = C_Hhknsei.FEMALE;
        }

        if (C_PalSaimankikykhyoujiKbn.NEN.eq(uiBean.getPalsaimankikykhyoujikbn())) {
            hknkknsmnkbn = C_HknkknsmnKbn.NENMANKI;
        }
        else if (C_PalSaimankikykhyoujiKbn.SAI.eq(uiBean.getPalsaimankikykhyoujikbn())) {
            hknkknsmnkbn = C_HknkknsmnKbn.SAIMANKI;
        }

        if (C_PalAnnaiFuyouRiyuuKbn.ANNAITYUU.eq(uiBean.getDisppalannaihuyouriyuukbn())) {
            kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        }
        else if (C_PalAnnaiFuyouRiyuuKbn.ITIJI.eq(uiBean.getDisppalannaihuyouriyuukbn())) {
            kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        }
        else if (C_PalAnnaiFuyouRiyuuKbn.HRIMN_KRISG.eq(uiBean.getDisppalannaihuyouriyuukbn())) {
            kykjyoutai = C_Kykjyoutai.HARAIMAN;
        }

        if (uiBean.getDai1hknkkn() == null) {
            dai1hknkkn = NUMBER_ZERO;
        }
        else {
            dai1hknkkn = uiBean.getDai1hknkkn();
        }

        if (C_RateSyoukaiKbn.PRATE.eq(uiBean.getRatesyoukaikbn())) {
            if(C_PalRyourituKbn.OTHER.eq(uiBean.getDisppalryouritukbn())) {
                ryouritukbn = C_RyourituKbn.OTHER;
            }
            else if(C_PalRyourituKbn.KOUHURI.eq(uiBean.getDisppalryouritukbn())) {
                ryouritukbn = C_RyourituKbn.KOUHURI;
            }
        }

        List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd(uiBean.
            getDisppalhokensyuruikigou());

        if (syouhnZokuseiLst.size() != 0) {
            BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);
            syouhnnm = syouhnZokusei.getSyouhnnm();
        }

        if (C_RateSyoukaiKbn.PRATE.eq(uiBean.getRatesyoukaikbn())) {
            BzGetPrate2 bzGetPrate2 = SWAKInjector.getInstance(BzGetPrate2.class);

            bzGetPrateBean = bzGetPrate2.exec(
                uiBean.getDisppalhokensyuruikigou(),
                ryouritusdno,
                yoteiriritu,
                hrkkaisuu,
                hhknsei,
                uiBean.getHhknnen(),
                hknkknsmnkbn,
                uiBean.getHknkkn(),
                uiBean.getHrkkkn(),
                kykjyoutai,
                tuukasyu,
                dai1hknkkn,
                ryouritukbn);

            if (C_ErrorKbn.ERROR.eq(bzGetPrateBean.getErrorKbn())) {
                throw new BizLogicException(MessageId.EBC1015);
            }
        }
        else if (C_RateSyoukaiKbn.VRATE.eq(uiBean.getRatesyoukaikbn())) {
            BzGetVrate2 bzGetVrate2 = SWAKInjector.getInstance(BzGetVrate2.class);

            bzGetVrateBean = bzGetVrate2.exec(
                uiBean.getDisppalhokensyuruikigou(),
                ryouritusdno,
                yoteiriritu,
                hrkkaisuu,
                hhknsei,
                uiBean.getHhknnen(),
                hknkknsmnkbn,
                uiBean.getHknkkn(),
                uiBean.getHrkkkn(),
                kykjyoutai,
                tuukasyu,
                dai1hknkkn,
                C_VRateGetKbn.ALL,
                NUMBER_ZERO);

            if (C_ErrorKbn.ERROR.eq(bzGetVrateBean.getErrorKbn())) {
                throw new BizLogicException(MessageId.EBC1015);
            }
        }
        else if (C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn())) {
            BzGetDrate2 bzGetDrate2 = SWAKInjector.getInstance(BzGetDrate2.class);

            bzGetDrateBean = bzGetDrate2.exec(
                uiBean.getDisppalhokensyuruikigou(),
                ryouritusdno,
                yoteiriritu,
                hrkkaisuu,
                hhknsei,
                uiBean.getHhknnen(),
                hknkknsmnkbn,
                uiBean.getHknkkn(),
                uiBean.getHrkkkn(),
                kykjyoutai,
                tuukasyu,
                dai1hknkkn,
                uiBean.getDispdnendo().toString(),
                uiBean.getDispdratenaiteikakuteikbn(),
                C_DRateGetKbn.ALL,
                NUMBER_ZERO);

            if (C_ErrorKbn.ERROR.eq(bzGetDrateBean.getErrorKbn())) {
                throw new BizLogicException(MessageId.EBC1015);
            }
        }
        else if (C_RateSyoukaiKbn.WRATE.eq(uiBean.getRatesyoukaikbn())) {
            BzGetWrate bzGetWrate = SWAKInjector.getInstance(BzGetWrate.class);

            bzGetWrateBean = bzGetWrate.exec(
                uiBean.getDisppalhokensyuruikigou(),
                ryouritusdno,
                yoteiriritu,
                hrkkaisuu,
                hhknsei,
                uiBean.getHhknnen(),
                hknkknsmnkbn,
                uiBean.getHknkkn(),
                uiBean.getHrkkkn(),
                kykjyoutai,
                tuukasyu,
                dai1hknkkn,
                C_WRateGetKbn.ALL,
                NUMBER_ZERO);

            if (C_ErrorKbn.ERROR.eq(bzGetWrateBean.getErrorKbn())) {
                throw new BizLogicException(MessageId.EBC1015);
            }
        }

        messageManager.addMessageId(MessageId.IBC1020);

        BzKensyouyouRatedbsyoukaiBean bzKensyouyouRatedbsyoukaiBean = editCreateReportBean(syouhnnm, ryouritusdno,
            reportYoteiriritu, bzGetPrateBean, bzGetVrateBean, bzGetDrateBean, bzGetWrateBean);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.CM_RATEDBSYOUKAIKEKKA);

        reportServicesBean.addParamObjects(bzKensyouyouRatedbsyoukaiBean, BizDate.getSysDate());

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setTyouhyouKey(tyouhyouKey);
    }

    void pushPrintReportBL() {

        String tyouhyouKey = uiBean.getTyouhyouKey();

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFWithDel(tyouhyouKey);
    }


    private BzKensyouyouRatedbsyoukaiBean editCreateReportBean(String pSyouhnNm,String pRyouritusdNo,
        String pYoteiriritu, BzGetPrateBean pBzGetPrateBean, BzGetVrateBean pBzGetVrateBean,
        BzGetDrateBean pBzGetDrateBean, BzGetWrateBean pBzGetWrateBean) {

        BzKensyouyouRatedbsyoukaiBean bzKensyouyouRatedbsyoukaiBean = SWAKInjector.getInstance(
            BzKensyouyouRatedbsyoukaiBean.class);
        bzKensyouyouRatedbsyoukaiBean.setIrUsernm(baseUserInfo.getUserNm());
        String sysDateTime = BizDate.getSysDateTime();
        BizDateFormat bizDateFormat = new BizDateFormat("yyyy/MM/dd");
        String sysDate = bizDateFormat.format(BizDate.valueOf(sysDateTime.substring(0, 8)));
        bzKensyouyouRatedbsyoukaiBean.setIrCurrentday(sysDate);
        bzKensyouyouRatedbsyoukaiBean.setIrCurrenttime(sysDateTime.substring(8, 10) + "：" + sysDateTime.substring(10, 12));
        bzKensyouyouRatedbsyoukaiBean.setIrSyoukaikbn(uiBean.getRatesyoukaikbn().getContent(C_RateSyoukaiKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrHokensyuruikigouname(uiBean.getDisppalhokensyuruikigou() + "：" + pSyouhnNm);
        if (uiBean.getSuurikykymd() != null) {

            BizDateFormat dateFormat = new BizDateFormat("yyyy/MM/dd");
            String suurikykymd = dateFormat.format(uiBean.getSuurikykymd());
            bzKensyouyouRatedbsyoukaiBean.setIrRatesyoukaiyoukykymd(suurikykymd);
        }

        bzKensyouyouRatedbsyoukaiBean.setIrHokensyuruikigousedaikbn(C_HokenSyuruiKigouSedaiKbn.valueOf(pRyouritusdNo).
            getContent(C_HokenSyuruiKigouSedaiKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrYoteiriritu(pYoteiriritu);
        bzKensyouyouRatedbsyoukaiBean.setIrKeiyakujihhknnen(Strings.padStart(String.valueOf(uiBean.getHhknnen()), 3, '0'));
        bzKensyouyouRatedbsyoukaiBean.setIrHhknseikbnari(
            uiBean.getSuurihhknsei().getContent(C_PalHhknsei.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrSaimankikykhyouji(
            uiBean.getPalsaimankikykhyoujikbn().getContent(C_PalSaimankikykhyoujiKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrHknkkn(Strings.padStart(String.valueOf(uiBean.getHknkkn()), 2, '0'));
        bzKensyouyouRatedbsyoukaiBean.setIrPharaikomikikan(Strings.padStart(String.valueOf(uiBean.getHrkkkn()), 2, '0'));
        bzKensyouyouRatedbsyoukaiBean.setIrHaraikomikaisukbn(
            uiBean.getDispharaikomikaisuukbn().getContent(C_PalHrkkaisuuKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrRatesyoukaiyoupmenkbn(
            uiBean.getDisppalpmenkbn().getContent(C_PalPmenKbn.PATTERN_SELECT));

        if (uiBean.getDispdnendo() != null) {
            bzKensyouyouRatedbsyoukaiBean.setIrDnendo(String.valueOf(uiBean.getDispdnendo()));
        }
        bzKensyouyouRatedbsyoukaiBean.setIrDratenaiteikakuteikbn(
            uiBean.getDispdratenaiteikakuteikbn().getContent(C_NaiteiKakuteiKbn.PATTERN_SELECT));

        bzKensyouyouRatedbsyoukaiBean.setIrAnnaihuyouriyuukbn(
            uiBean.getDisppalannaihuyouriyuukbn().getContent(C_PalAnnaiFuyouRiyuuKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrTuukasyukbn(
            uiBean.getDispratetuukasyukbn().getContent(C_RateTuukasyuKbn.PATTERN_SELECT));
        bzKensyouyouRatedbsyoukaiBean.setIrRyouritukbn(
            uiBean.getDisppalryouritukbn().getContent(C_PalRyourituKbn.PATTERN_SELECT));

        if (uiBean.getDai1hknkkn() != null) {
            bzKensyouyouRatedbsyoukaiBean.setIrDai1hknkkn(
                Strings.padStart(String.valueOf(uiBean.getDai1hknkkn()), 2, '0'));
        }

        if (C_RateSyoukaiKbn.VRATE.eq(uiBean.getRatesyoukaikbn())) {
            bzKensyouyouRatedbsyoukaiBean.setIrVrate00(pBzGetVrateBean.getVrate().get(0));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate01(pBzGetVrateBean.getVrate().get(1));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate02(pBzGetVrateBean.getVrate().get(2));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate03(pBzGetVrateBean.getVrate().get(3));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate04(pBzGetVrateBean.getVrate().get(4));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate05(pBzGetVrateBean.getVrate().get(5));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate06(pBzGetVrateBean.getVrate().get(6));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate07(pBzGetVrateBean.getVrate().get(7));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate08(pBzGetVrateBean.getVrate().get(8));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate09(pBzGetVrateBean.getVrate().get(9));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate10(pBzGetVrateBean.getVrate().get(10));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate11(pBzGetVrateBean.getVrate().get(11));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate12(pBzGetVrateBean.getVrate().get(12));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate13(pBzGetVrateBean.getVrate().get(13));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate14(pBzGetVrateBean.getVrate().get(14));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate15(pBzGetVrateBean.getVrate().get(15));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate16(pBzGetVrateBean.getVrate().get(16));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate17(pBzGetVrateBean.getVrate().get(17));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate18(pBzGetVrateBean.getVrate().get(18));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate19(pBzGetVrateBean.getVrate().get(19));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate20(pBzGetVrateBean.getVrate().get(20));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate21(pBzGetVrateBean.getVrate().get(21));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate22(pBzGetVrateBean.getVrate().get(22));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate23(pBzGetVrateBean.getVrate().get(23));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate24(pBzGetVrateBean.getVrate().get(24));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate25(pBzGetVrateBean.getVrate().get(25));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate26(pBzGetVrateBean.getVrate().get(26));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate27(pBzGetVrateBean.getVrate().get(27));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate28(pBzGetVrateBean.getVrate().get(28));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate29(pBzGetVrateBean.getVrate().get(29));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate30(pBzGetVrateBean.getVrate().get(30));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate31(pBzGetVrateBean.getVrate().get(31));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate32(pBzGetVrateBean.getVrate().get(32));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate33(pBzGetVrateBean.getVrate().get(33));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate34(pBzGetVrateBean.getVrate().get(34));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate35(pBzGetVrateBean.getVrate().get(35));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate36(pBzGetVrateBean.getVrate().get(36));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate37(pBzGetVrateBean.getVrate().get(37));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate38(pBzGetVrateBean.getVrate().get(38));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate39(pBzGetVrateBean.getVrate().get(39));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate40(pBzGetVrateBean.getVrate().get(40));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate41(pBzGetVrateBean.getVrate().get(41));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate42(pBzGetVrateBean.getVrate().get(42));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate43(pBzGetVrateBean.getVrate().get(43));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate44(pBzGetVrateBean.getVrate().get(44));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate45(pBzGetVrateBean.getVrate().get(45));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate46(pBzGetVrateBean.getVrate().get(46));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate47(pBzGetVrateBean.getVrate().get(47));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate48(pBzGetVrateBean.getVrate().get(48));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate49(pBzGetVrateBean.getVrate().get(49));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate50(pBzGetVrateBean.getVrate().get(50));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate51(pBzGetVrateBean.getVrate().get(51));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate52(pBzGetVrateBean.getVrate().get(52));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate53(pBzGetVrateBean.getVrate().get(53));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate54(pBzGetVrateBean.getVrate().get(54));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate55(pBzGetVrateBean.getVrate().get(55));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate56(pBzGetVrateBean.getVrate().get(56));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate57(pBzGetVrateBean.getVrate().get(57));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate58(pBzGetVrateBean.getVrate().get(58));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate59(pBzGetVrateBean.getVrate().get(59));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate60(pBzGetVrateBean.getVrate().get(60));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate61(pBzGetVrateBean.getVrate().get(61));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate62(pBzGetVrateBean.getVrate().get(62));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate63(pBzGetVrateBean.getVrate().get(63));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate64(pBzGetVrateBean.getVrate().get(64));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate65(pBzGetVrateBean.getVrate().get(65));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate66(pBzGetVrateBean.getVrate().get(66));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate67(pBzGetVrateBean.getVrate().get(67));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate68(pBzGetVrateBean.getVrate().get(68));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate69(pBzGetVrateBean.getVrate().get(69));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate70(pBzGetVrateBean.getVrate().get(70));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate71(pBzGetVrateBean.getVrate().get(71));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate72(pBzGetVrateBean.getVrate().get(72));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate73(pBzGetVrateBean.getVrate().get(73));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate74(pBzGetVrateBean.getVrate().get(74));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate75(pBzGetVrateBean.getVrate().get(75));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate76(pBzGetVrateBean.getVrate().get(76));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate77(pBzGetVrateBean.getVrate().get(77));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate78(pBzGetVrateBean.getVrate().get(78));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate79(pBzGetVrateBean.getVrate().get(79));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate80(pBzGetVrateBean.getVrate().get(80));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate81(pBzGetVrateBean.getVrate().get(81));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate82(pBzGetVrateBean.getVrate().get(82));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate83(pBzGetVrateBean.getVrate().get(83));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate84(pBzGetVrateBean.getVrate().get(84));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate85(pBzGetVrateBean.getVrate().get(85));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate86(pBzGetVrateBean.getVrate().get(86));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate87(pBzGetVrateBean.getVrate().get(87));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate88(pBzGetVrateBean.getVrate().get(88));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate89(pBzGetVrateBean.getVrate().get(89));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate90(pBzGetVrateBean.getVrate().get(90));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate91(pBzGetVrateBean.getVrate().get(91));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate92(pBzGetVrateBean.getVrate().get(92));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate93(pBzGetVrateBean.getVrate().get(93));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate94(pBzGetVrateBean.getVrate().get(94));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate95(pBzGetVrateBean.getVrate().get(95));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate96(pBzGetVrateBean.getVrate().get(96));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate97(pBzGetVrateBean.getVrate().get(97));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate98(pBzGetVrateBean.getVrate().get(98));
            bzKensyouyouRatedbsyoukaiBean.setIrVrate99(pBzGetVrateBean.getVrate().get(99));
        }

        if (C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn())) {
            bzKensyouyouRatedbsyoukaiBean.setIrDrate00(pBzGetDrateBean.getDrate().get(0));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate01(pBzGetDrateBean.getDrate().get(1));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate02(pBzGetDrateBean.getDrate().get(2));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate03(pBzGetDrateBean.getDrate().get(3));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate04(pBzGetDrateBean.getDrate().get(4));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate05(pBzGetDrateBean.getDrate().get(5));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate06(pBzGetDrateBean.getDrate().get(6));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate07(pBzGetDrateBean.getDrate().get(7));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate08(pBzGetDrateBean.getDrate().get(8));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate09(pBzGetDrateBean.getDrate().get(9));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate10(pBzGetDrateBean.getDrate().get(10));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate11(pBzGetDrateBean.getDrate().get(11));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate12(pBzGetDrateBean.getDrate().get(12));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate13(pBzGetDrateBean.getDrate().get(13));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate14(pBzGetDrateBean.getDrate().get(14));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate15(pBzGetDrateBean.getDrate().get(15));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate16(pBzGetDrateBean.getDrate().get(16));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate17(pBzGetDrateBean.getDrate().get(17));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate18(pBzGetDrateBean.getDrate().get(18));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate19(pBzGetDrateBean.getDrate().get(19));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate20(pBzGetDrateBean.getDrate().get(20));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate21(pBzGetDrateBean.getDrate().get(21));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate22(pBzGetDrateBean.getDrate().get(22));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate23(pBzGetDrateBean.getDrate().get(23));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate24(pBzGetDrateBean.getDrate().get(24));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate25(pBzGetDrateBean.getDrate().get(25));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate26(pBzGetDrateBean.getDrate().get(26));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate27(pBzGetDrateBean.getDrate().get(27));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate28(pBzGetDrateBean.getDrate().get(28));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate29(pBzGetDrateBean.getDrate().get(29));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate30(pBzGetDrateBean.getDrate().get(30));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate31(pBzGetDrateBean.getDrate().get(31));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate32(pBzGetDrateBean.getDrate().get(32));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate33(pBzGetDrateBean.getDrate().get(33));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate34(pBzGetDrateBean.getDrate().get(34));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate35(pBzGetDrateBean.getDrate().get(35));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate36(pBzGetDrateBean.getDrate().get(36));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate37(pBzGetDrateBean.getDrate().get(37));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate38(pBzGetDrateBean.getDrate().get(38));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate39(pBzGetDrateBean.getDrate().get(39));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate40(pBzGetDrateBean.getDrate().get(40));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate41(pBzGetDrateBean.getDrate().get(41));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate42(pBzGetDrateBean.getDrate().get(42));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate43(pBzGetDrateBean.getDrate().get(43));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate44(pBzGetDrateBean.getDrate().get(44));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate45(pBzGetDrateBean.getDrate().get(45));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate46(pBzGetDrateBean.getDrate().get(46));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate47(pBzGetDrateBean.getDrate().get(47));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate48(pBzGetDrateBean.getDrate().get(48));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate49(pBzGetDrateBean.getDrate().get(49));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate50(pBzGetDrateBean.getDrate().get(50));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate51(pBzGetDrateBean.getDrate().get(51));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate52(pBzGetDrateBean.getDrate().get(52));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate53(pBzGetDrateBean.getDrate().get(53));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate54(pBzGetDrateBean.getDrate().get(54));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate55(pBzGetDrateBean.getDrate().get(55));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate56(pBzGetDrateBean.getDrate().get(56));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate57(pBzGetDrateBean.getDrate().get(57));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate58(pBzGetDrateBean.getDrate().get(58));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate59(pBzGetDrateBean.getDrate().get(59));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate60(pBzGetDrateBean.getDrate().get(60));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate61(pBzGetDrateBean.getDrate().get(61));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate62(pBzGetDrateBean.getDrate().get(62));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate63(pBzGetDrateBean.getDrate().get(63));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate64(pBzGetDrateBean.getDrate().get(64));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate65(pBzGetDrateBean.getDrate().get(65));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate66(pBzGetDrateBean.getDrate().get(66));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate67(pBzGetDrateBean.getDrate().get(67));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate68(pBzGetDrateBean.getDrate().get(68));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate69(pBzGetDrateBean.getDrate().get(69));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate70(pBzGetDrateBean.getDrate().get(70));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate71(pBzGetDrateBean.getDrate().get(71));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate72(pBzGetDrateBean.getDrate().get(72));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate73(pBzGetDrateBean.getDrate().get(73));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate74(pBzGetDrateBean.getDrate().get(74));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate75(pBzGetDrateBean.getDrate().get(75));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate76(pBzGetDrateBean.getDrate().get(76));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate77(pBzGetDrateBean.getDrate().get(77));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate78(pBzGetDrateBean.getDrate().get(78));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate79(pBzGetDrateBean.getDrate().get(79));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate80(pBzGetDrateBean.getDrate().get(80));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate81(pBzGetDrateBean.getDrate().get(81));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate82(pBzGetDrateBean.getDrate().get(82));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate83(pBzGetDrateBean.getDrate().get(83));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate84(pBzGetDrateBean.getDrate().get(84));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate85(pBzGetDrateBean.getDrate().get(85));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate86(pBzGetDrateBean.getDrate().get(86));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate87(pBzGetDrateBean.getDrate().get(87));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate88(pBzGetDrateBean.getDrate().get(88));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate89(pBzGetDrateBean.getDrate().get(89));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate90(pBzGetDrateBean.getDrate().get(90));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate91(pBzGetDrateBean.getDrate().get(91));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate92(pBzGetDrateBean.getDrate().get(92));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate93(pBzGetDrateBean.getDrate().get(93));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate94(pBzGetDrateBean.getDrate().get(94));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate95(pBzGetDrateBean.getDrate().get(95));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate96(pBzGetDrateBean.getDrate().get(96));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate97(pBzGetDrateBean.getDrate().get(97));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate98(pBzGetDrateBean.getDrate().get(98));
            bzKensyouyouRatedbsyoukaiBean.setIrDrate99(pBzGetDrateBean.getDrate().get(99));
        }

        if (C_RateSyoukaiKbn.PRATE.eq(uiBean.getRatesyoukaikbn())) {
            bzKensyouyouRatedbsyoukaiBean.setIrPrate(pBzGetPrateBean.getPrate());
            bzKensyouyouRatedbsyoukaiBean.setIrPdatesrate(pBzGetPrateBean.getPsRate());
        }

        if (C_RateSyoukaiKbn.WRATE.eq(uiBean.getRatesyoukaikbn())) {
            bzKensyouyouRatedbsyoukaiBean.setIrWrate00(pBzGetWrateBean.getWrate().get(0));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate01(pBzGetWrateBean.getWrate().get(1));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate02(pBzGetWrateBean.getWrate().get(2));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate03(pBzGetWrateBean.getWrate().get(3));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate04(pBzGetWrateBean.getWrate().get(4));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate05(pBzGetWrateBean.getWrate().get(5));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate06(pBzGetWrateBean.getWrate().get(6));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate07(pBzGetWrateBean.getWrate().get(7));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate08(pBzGetWrateBean.getWrate().get(8));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate09(pBzGetWrateBean.getWrate().get(9));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate10(pBzGetWrateBean.getWrate().get(10));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate11(pBzGetWrateBean.getWrate().get(11));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate12(pBzGetWrateBean.getWrate().get(12));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate13(pBzGetWrateBean.getWrate().get(13));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate14(pBzGetWrateBean.getWrate().get(14));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate15(pBzGetWrateBean.getWrate().get(15));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate16(pBzGetWrateBean.getWrate().get(16));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate17(pBzGetWrateBean.getWrate().get(17));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate18(pBzGetWrateBean.getWrate().get(18));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate19(pBzGetWrateBean.getWrate().get(19));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate20(pBzGetWrateBean.getWrate().get(20));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate21(pBzGetWrateBean.getWrate().get(21));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate22(pBzGetWrateBean.getWrate().get(22));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate23(pBzGetWrateBean.getWrate().get(23));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate24(pBzGetWrateBean.getWrate().get(24));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate25(pBzGetWrateBean.getWrate().get(25));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate26(pBzGetWrateBean.getWrate().get(26));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate27(pBzGetWrateBean.getWrate().get(27));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate28(pBzGetWrateBean.getWrate().get(28));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate29(pBzGetWrateBean.getWrate().get(29));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate30(pBzGetWrateBean.getWrate().get(30));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate31(pBzGetWrateBean.getWrate().get(31));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate32(pBzGetWrateBean.getWrate().get(32));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate33(pBzGetWrateBean.getWrate().get(33));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate34(pBzGetWrateBean.getWrate().get(34));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate35(pBzGetWrateBean.getWrate().get(35));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate36(pBzGetWrateBean.getWrate().get(36));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate37(pBzGetWrateBean.getWrate().get(37));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate38(pBzGetWrateBean.getWrate().get(38));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate39(pBzGetWrateBean.getWrate().get(39));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate40(pBzGetWrateBean.getWrate().get(40));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate41(pBzGetWrateBean.getWrate().get(41));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate42(pBzGetWrateBean.getWrate().get(42));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate43(pBzGetWrateBean.getWrate().get(43));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate44(pBzGetWrateBean.getWrate().get(44));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate45(pBzGetWrateBean.getWrate().get(45));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate46(pBzGetWrateBean.getWrate().get(46));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate47(pBzGetWrateBean.getWrate().get(47));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate48(pBzGetWrateBean.getWrate().get(48));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate49(pBzGetWrateBean.getWrate().get(49));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate50(pBzGetWrateBean.getWrate().get(50));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate51(pBzGetWrateBean.getWrate().get(51));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate52(pBzGetWrateBean.getWrate().get(52));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate53(pBzGetWrateBean.getWrate().get(53));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate54(pBzGetWrateBean.getWrate().get(54));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate55(pBzGetWrateBean.getWrate().get(55));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate56(pBzGetWrateBean.getWrate().get(56));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate57(pBzGetWrateBean.getWrate().get(57));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate58(pBzGetWrateBean.getWrate().get(58));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate59(pBzGetWrateBean.getWrate().get(59));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate60(pBzGetWrateBean.getWrate().get(60));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate61(pBzGetWrateBean.getWrate().get(61));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate62(pBzGetWrateBean.getWrate().get(62));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate63(pBzGetWrateBean.getWrate().get(63));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate64(pBzGetWrateBean.getWrate().get(64));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate65(pBzGetWrateBean.getWrate().get(65));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate66(pBzGetWrateBean.getWrate().get(66));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate67(pBzGetWrateBean.getWrate().get(67));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate68(pBzGetWrateBean.getWrate().get(68));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate69(pBzGetWrateBean.getWrate().get(69));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate70(pBzGetWrateBean.getWrate().get(70));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate71(pBzGetWrateBean.getWrate().get(71));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate72(pBzGetWrateBean.getWrate().get(72));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate73(pBzGetWrateBean.getWrate().get(73));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate74(pBzGetWrateBean.getWrate().get(74));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate75(pBzGetWrateBean.getWrate().get(75));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate76(pBzGetWrateBean.getWrate().get(76));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate77(pBzGetWrateBean.getWrate().get(77));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate78(pBzGetWrateBean.getWrate().get(78));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate79(pBzGetWrateBean.getWrate().get(79));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate80(pBzGetWrateBean.getWrate().get(80));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate81(pBzGetWrateBean.getWrate().get(81));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate82(pBzGetWrateBean.getWrate().get(82));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate83(pBzGetWrateBean.getWrate().get(83));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate84(pBzGetWrateBean.getWrate().get(84));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate85(pBzGetWrateBean.getWrate().get(85));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate86(pBzGetWrateBean.getWrate().get(86));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate87(pBzGetWrateBean.getWrate().get(87));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate88(pBzGetWrateBean.getWrate().get(88));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate89(pBzGetWrateBean.getWrate().get(89));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate90(pBzGetWrateBean.getWrate().get(90));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate91(pBzGetWrateBean.getWrate().get(91));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate92(pBzGetWrateBean.getWrate().get(92));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate93(pBzGetWrateBean.getWrate().get(93));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate94(pBzGetWrateBean.getWrate().get(94));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate95(pBzGetWrateBean.getWrate().get(95));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate96(pBzGetWrateBean.getWrate().get(96));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate97(pBzGetWrateBean.getWrate().get(97));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate98(pBzGetWrateBean.getWrate().get(98));
            bzKensyouyouRatedbsyoukaiBean.setIrWrate99(pBzGetWrateBean.getWrate().get(99));
        }

        return bzKensyouyouRatedbsyoukaiBean;
    }

    private C_ErrorKbn chkRateSyoukaiTaisyouSyouhn() {
        C_ErrorKbn checkKekkaKbn = C_ErrorKbn.OK;

        int henkoukubetuSyohinHanteiKbn =  SyouhinUtil.henkouKubetuHantei(uiBean.getDisppalhokensyuruikigou());

        if (C_RateSyoukaiKbn.PRATE.eq(uiBean.getRatesyoukaikbn())) {
            if (henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                checkKekkaKbn = C_ErrorKbn.ERROR;
            }
        }
        else if (C_RateSyoukaiKbn.VRATE.eq(uiBean.getRatesyoukaikbn())){
            if (henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                checkKekkaKbn = C_ErrorKbn.ERROR;
            }
        }
        else if (C_RateSyoukaiKbn.DRATE.eq(uiBean.getRatesyoukaikbn())){
            if (henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE &&
                henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                checkKekkaKbn = C_ErrorKbn.ERROR;
            }
        }
        else if (C_RateSyoukaiKbn.WRATE.eq(uiBean.getRatesyoukaikbn())){
            if (henkoukubetuSyohinHanteiKbn !=
                SyouhinUtil.HENKOUKUBETU_TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                checkKekkaKbn = C_ErrorKbn.ERROR;
            }
        }

        return checkKekkaKbn;
    }
}
