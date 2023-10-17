package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import static yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.GenSkHurikomiNyuukinHaneiYoyakuConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.SkHurikomiNyuukinHaneiYoyakuConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.dba.SkHurikomiNyuukinHaneiYoyakuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.entity.HT_GrossNyknMeisai;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.sinkeiyaku.file.excel.SkHurikomiNyuukinMeisaiLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 振込入金反映予約 のビジネスロジックです。
 */
public class SkHurikomiNyuukinHaneiYoyakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkHurikomiNyuukinHaneiYoyakuUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private MessageManager messageManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private SkHurikomiNyuukinHaneiYoyakuDao skHurikomiNyuukinHaneiYoyakuDao;

    void init() {
    }

    void clear() {
    }

    void pushTourokuBL() {

        BizPropertyInitializer.initialize(uiBean);

        if (uiBean.getUploadfile().getFileSize() <= 0) {
            throw new BizLogicException(MessageId.EAC0001, DDID_UPLOADFILEINFO_UPLOADFILE);
        }

        FileEntityManager fileEntityManager =
            FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.XLSX);

        List<SkHurikomiNyuukinMeisaiLayoutFile> nyuukinDataList = Lists.newArrayList();

        try {
            nyuukinDataList = fileEntityManager.read(
                SkHurikomiNyuukinMeisaiLayoutFile.class, uiBean.getUploadfile().getInputStream());
        } catch (Exception e) {
            throw new BizLogicException(MessageId.EHA0493);
        }

        if (nyuukinDataList.size() == 0) {
            throw new BizLogicException(MessageId.EHA0486);
        }

        if (nyuukinDataList.size() > TORIKOMIMAXKENSUU) {
            throw new BizLogicException(MessageId.EHA1044, String.valueOf(TORIKOMIMAXKENSUU));
        }

        List<HM_HurikomiKouza> hurikomiKouzaLst = sinkeiyakuDomManager.getAllHurikomiKouza();

        if (hurikomiKouzaLst.size() == 0) {
            throw new CommonBizAppException(HM_HurikomiKouza.TABLE_NAME + " 取得エラー");
        }

        uiBean.setHurikomiKouzaLst(hurikomiKouzaLst);

        LinkedHashMap<String, HM_HurikomiKouza> hurikomiKouzaMap = new LinkedHashMap<>();

        for (HM_HurikomiKouza hurikomiKouza : hurikomiKouzaLst) {

            if (!hurikomiKouzaMap.containsKey(hurikomiKouza.getOyadrtencd())) {

                hurikomiKouzaMap.put(hurikomiKouza.getOyadrtencd(), hurikomiKouza);
            }
        }

        UserDefsList oyaDrtenCdLst = new UserDefsList();

        oyaDrtenCdLst.add(new LabelValuePair("", ""));

        for (String oyaDrtenCd : hurikomiKouzaMap.keySet()) {

            oyaDrtenCdLst.add(new LabelValuePair(hurikomiKouzaMap.get(oyaDrtenCd).getNyuukinoyadrtennm(), oyaDrtenCd));
        }

        List<HrkmnyknInfoDataSourceBean> hrkmnyknInfoDsBeanList = new ArrayList<>();

        int renNo = 0;

        for (SkHurikomiNyuukinMeisaiLayoutFile nyuukinData : nyuukinDataList) {

            renNo = renNo + 1;

            String nyknOyaDrtencd = "";

            for (String oyaDrtenCd : hurikomiKouzaMap.keySet()) {

                if (hurikomiKouzaMap.get(oyaDrtenCd).getNyuukinoyadrtennm().equals(
                    nyuukinData.getIfeNyuukinoyadrtennm())) {

                    nyknOyaDrtencd = oyaDrtenCd;

                    break;
                }
            }

            HrkmnyknInfoDataSourceBean hrkmnyknInfoDsBean = SWAKInjector.getInstance(HrkmnyknInfoDataSourceBean.class);
            hrkmnyknInfoDsBean.setDisprenno3keta(renNo);
            hrkmnyknInfoDsBean.setMosnochknasi(nyuukinData.getIfeMosno());
            hrkmnyknInfoDsBean.setNyknoyadrtencd(nyknOyaDrtencd);
            hrkmnyknInfoDsBean.setNyknoyadrtencdOptionBeanList(oyaDrtenCdLst);
            hrkmnyknInfoDsBean.setHrkmirninnm48(nyuukinData.getIfeHrkmirninnm());
            hrkmnyknInfoDsBean.setHrktuukasyu(convTuukaSyuruiKbn(nyuukinData.getIfeHrktuuka()));
            hrkmnyknInfoDsBean.setSiteituuka(convTuukaSyuruiKbn(nyuukinData.getIfeSiteituuka()));
            hrkmnyknInfoDsBean.setRsgaku(convRsgaku(nyuukinData));
            hrkmnyknInfoDsBean.setDengk(BizCurrency.optional(BizCurrencyTypes.YEN));
            hrkmnyknInfoDsBean.setRyosyuymd(getRyosyuYmd(nyuukinData));
            hrkmnyknInfoDsBean.setSimukebanknm15(nyuukinData.getIfeHrkmmotobanknm());
            hrkmnyknInfoDsBean.setSimuketennm15(nyuukinData.getIfeSitennm());
            RayConvertUtil.toValidString(hrkmnyknInfoDsBean);

            hrkmnyknInfoDsBeanList.add(hrkmnyknInfoDsBean);
        }

        uiBean.setHrkmnyknInfo(hrkmnyknInfoDsBeanList);
    }

    void pushKakuninBL() {

        int syoriCount = 0;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        String checkNyknoyadrtencd = "";
        BizDate checkRyosyuymd = null;
        boolean drtensaifalg = false;
        boolean ryosyuymdsaifalg = false;

        for (HrkmnyknInfoDataSourceBean dsBean : uiBean.getHrkmnyknInfoDataSource().getAllData()) {

            HM_HurikomiKouza hurikomiKouza = getHurikomiKouza(dsBean.getNyknoyadrtencd(),
                dsBean.getHrktuukasyu(),
                dsBean.getSiteituuka());

            if (hurikomiKouza == null) {
                errorMessageCollector.addMessage(MessageId.EHA1070,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_NYKNOYADRTENCD,
                    DDID_HRKMNYKNINFO_HRKTUUKASYU,
                    DDID_HRKMNYKNINFO_SITEITUUKA);
            }

            if (!BizUtil.isBlank(dsBean.getHrkmirninnm48()) &&
                !CheckMeigininNmKana.isCheckOK(dsBean.getHrkmirninnm48())) {
                errorMessageCollector.addMessage(MessageId.EBA1043,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_HRKMIRNINNM48);
            }

            if (C_Tuukasyu.JPY.eq(dsBean.getHrktuukasyu()) && BizUtil.isBlank(dsBean.getHrkmirninnm48())) {
                errorMessageCollector.addMessage(MessageId.EBA1047,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_HRKMIRNINNM48);
            }

            if (BizUtil.isZero(dsBean.getRsgaku())) {
                errorMessageCollector.addMessage(MessageId.EBA1044,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_RSGAKU);
            }

            BizDate syoriYmd3mae;
            syoriYmd3mae = BizDate.getSysDate().addMonths(-3);

            if (BizDateUtil.compareYmd(
                dsBean.getRyosyuymd(), syoriYmd3mae.getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                errorMessageCollector.addMessage(MessageId.EBA1045,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_RYOSYUYMD);
            }

            if (BizDateUtil.compareYmd(dsBean.getRyosyuymd(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
                errorMessageCollector.addMessage(MessageId.EBA1046,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_RYOSYUYMD);
            }

            if (!BizUtil.isBlank(dsBean.getSimukebanknm15()) &&
                !CheckMeigininNmKana.isCheckOK(dsBean.getSimukebanknm15())) {
                errorMessageCollector.addMessage(MessageId.EBA1043,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_SIMUKEBANKNM15);
            }

            if (!BizUtil.isBlank(dsBean.getSimuketennm15()) &&
                !CheckMeigininNmKana.isCheckOK(dsBean.getSimuketennm15())) {
                errorMessageCollector.addMessage(MessageId.EBA1043,
                    dsBean.getDisprenno3keta() - 1,
                    DDID_HRKMNYKNINFO_SIMUKETENNM15);
            }

            if (C_Tuukasyu.USD.eq(dsBean.getHrktuukasyu()) ||
                C_Tuukasyu.AUD.eq(dsBean.getHrktuukasyu())) {
                dsBean.setSimukebanknm15(ConvertUtil.toHanAll(dsBean.getSimukebanknm15(), 0, 0));
                dsBean.setSimuketennm15(ConvertUtil.toHanAll(dsBean.getSimuketennm15(), 0, 0));
            }

            if (syoriCount == 0) {
                checkNyknoyadrtencd = dsBean.getNyknoyadrtencd();
                checkRyosyuymd = dsBean.getRyosyuymd();
                drtensaifalg = false;
                ryosyuymdsaifalg = false;
            }

            if (!checkNyknoyadrtencd.equals(dsBean.getNyknoyadrtencd())) {
                drtensaifalg = true;
            }

            if (BizDateUtil.compareYmd(checkRyosyuymd, dsBean.getRyosyuymd()) != BizDateUtil.COMPARE_EQUAL) {
                ryosyuymdsaifalg = true;
            }

            if (!C_Tuukasyu.JPY.eq(dsBean.getHrktuukasyu())) {
                C_ErrorKbn errorKbn = getKawaseRate.exec(dsBean.getRyosyuymd(), C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                    dsBean.getHrktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.JISSEIRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                if (!C_ErrorKbn.ERROR.eq(errorKbn)) {
                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, dsBean.getRsgaku(),
                        getKawaseRate.getKawaserate(), C_HasuusyoriKbn.SUTE);

                    dsBean.setDengk(kanzanGaku);
                }
                else {
                    dsBean.setDengk(BizCurrency.optional(BizCurrencyTypes.YEN));
                }
            }

            syoriCount = syoriCount + 1;
        }

        if (drtensaifalg) {
            errorMessageCollector.addMessage(MessageId.EHA1101,
                MessageUtil.getMessage(DDID_IKKTNYKNINFO_IKKTNYKNINFONYKNOYADRTENNM.getErrorResourceKey()));
        }

        if (ryosyuymdsaifalg) {
            errorMessageCollector.addMessage(MessageId.EHA1101,
                MessageUtil.getMessage(DDID_IKKTNYKNINFO_IKKTNYKNINFORYOSYUYMD.getErrorResourceKey()));
        }

        if (errorMessageCollector.exists()) {

            throw new BizLogicException(errorMessageCollector);
        }

        messageManager.addMessageId(MessageId.QAC0008);

        uiBean.setIkktnyknInfo(null);
        uiBean.setGkkwssekInfo(null);

        UserDefsList userDefsList = setOyaDrtenCdLst();

        LinkedHashMap<String, GkkwssekInfoDataSourceBean> gkkwssekInfoMap = new LinkedHashMap<>();

        for (HrkmnyknInfoDataSourceBean dsBean : uiBean.getHrkmnyknInfoDataSource().getAllData()) {
            if (!C_Tuukasyu.JPY.eq(dsBean.getHrktuukasyu())) {
                String mapKey = dsBean.getHrktuukasyu().getValue() + "." + dsBean.getSiteituuka().getValue();
                if (!gkkwssekInfoMap.containsKey(mapKey)) {
                    GkkwssekInfoDataSourceBean gkkwssekInfo = SWAKInjector.getInstance(GkkwssekInfoDataSourceBean.class);
                    gkkwssekInfo.setGkkwssekinfonyknoyadrtennm(dsBean.getNyknoyadrtencd());
                    gkkwssekInfo.setGkkwssekinfonyknoyadrtennmOptionBeanList(userDefsList);
                    gkkwssekInfo.setGkkwssekinfohrktuukasyu(dsBean.getHrktuukasyu());
                    gkkwssekInfo.setGkkwssekinfositeituukasyu(dsBean.getSiteituuka());
                    gkkwssekInfo.setGkkwssekinfokouzano("");
                    gkkwssekInfo.setGrossnykngk(dsBean.getRsgaku());
                    gkkwssekInfo.setGrossdengk(BizCurrency.optional(BizCurrencyTypes.YEN));

                    if (dsBean.getDengk().isOptional()) {
                        gkkwssekInfo.setMeisaigoukeidengk(BizCurrency.optional(BizCurrencyTypes.YEN));
                    }
                    else {
                        gkkwssekInfo.setMeisaigoukeidengk(dsBean.getDengk());
                    }

                    gkkwssekInfo.setKawasesasonekikngk(BizCurrency.optional(BizCurrencyTypes.YEN));
                    gkkwssekInfoMap.put(mapKey, gkkwssekInfo);
                }
                else {
                    GkkwssekInfoDataSourceBean gkkwssekInfo = gkkwssekInfoMap.get(mapKey);
                    gkkwssekInfo.setGrossnykngk(gkkwssekInfo.getGrossnykngk().add(dsBean.getRsgaku()));
                    if (dsBean.getDengk().isOptional()) {
                        gkkwssekInfo.setMeisaigoukeidengk(BizCurrency.optional(BizCurrencyTypes.YEN));
                    }
                    else {
                        if (!gkkwssekInfo.getMeisaigoukeidengk().isOptional()) {
                            gkkwssekInfo.setMeisaigoukeidengk(gkkwssekInfo.getMeisaigoukeidengk().add(dsBean.getDengk()));
                        }
                    }
                }
            }
        }

        List<GkkwssekInfoDataSourceBean> gkkwssekInfoLst = Lists.newArrayList();

        for (String mapKey : gkkwssekInfoMap.keySet()) {
            GkkwssekInfoDataSourceBean gkkwssekInfoDataSourceBean = gkkwssekInfoMap.get(mapKey);

            gkkwssekInfoLst.add(gkkwssekInfoDataSourceBean);
        }

        List<IkktnyknInfoDataSourceBean> ikktnyknInfoLst = Lists.newArrayList();

        for (GkkwssekInfoDataSourceBean gkkwssekInfoBean : gkkwssekInfoLst) {

            HM_HurikomiKouza hurikomiKouza =
                getHurikomiKouza(gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm(),
                    gkkwssekInfoBean.getGkkwssekinfohrktuukasyu(), gkkwssekInfoBean.getGkkwssekinfositeituukasyu());

            if (hurikomiKouza != null) {
                gkkwssekInfoBean.setGkkwssekinfokouzano(hurikomiKouza.getKouzano());
            }

            BizNumber kawaserate = BizNumber.optional();

            C_ErrorKbn errorKbn = getKawaseRate.exec(checkRyosyuymd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                gkkwssekInfoBean.getGkkwssekinfohrktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            if (!C_ErrorKbn.ERROR.eq(errorKbn)) {
                BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gkkwssekInfoBean.getGrossnykngk(),
                    getKawaseRate.getKawaserate(), C_HasuusyoriKbn.SUTE);

                kawaserate = getKawaseRate.getKawaserate();

                gkkwssekInfoBean.setGrossdengk(kanzanGaku);

                gkkwssekInfoBean.setKawasesasonekikngk(optionalToZero(gkkwssekInfoBean.getGrossdengk()).subtract(
                    optionalToZero(gkkwssekInfoBean.getMeisaigoukeidengk())));
            }

            gkkwssekInfoBean.setRyosyuymd(checkRyosyuymd);
            gkkwssekInfoBean.setKawaserate(kawaserate);

            IkktnyknInfoDataSourceBean ikktnyknInfo = SWAKInjector.getInstance(IkktnyknInfoDataSourceBean.class);

            ikktnyknInfo.setIkktnykninfonyknoyadrtennm(gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm());
            ikktnyknInfo.setIkktnykninfonyknoyadrtennmOptionBeanList(userDefsList);
            ikktnyknInfo.setIkktnykninfohrktuukasyu(gkkwssekInfoBean.getGkkwssekinfohrktuukasyu());
            ikktnyknInfo.setIkktnykninfositeituukasyu(gkkwssekInfoBean.getGkkwssekinfositeituukasyu());
            ikktnyknInfo.setIkktnykninfokouzano(gkkwssekInfoBean.getGkkwssekinfokouzano());
            ikktnyknInfo.setIkktnykninfoikktnyuukingk(gkkwssekInfoBean.getGrossnykngk());
            ikktnyknInfo.setIkktnykninfodengk(gkkwssekInfoBean.getGrossdengk());
            ikktnyknInfo.setIkktnykninforyosyuymd(checkRyosyuymd);
            ikktnyknInfo.setIkktnykninfokawaserate(kawaserate);

            ikktnyknInfoLst.add(ikktnyknInfo);
        }

        IkktnyknInfoDataSourceBeanSortComparator ikktnyknInfoDataSourceBeanSortComparator =
            SWAKInjector.getInstance(IkktnyknInfoDataSourceBeanSortComparator.class);

        Ordering<IkktnyknInfoDataSourceBean> ikktnyknInfoOrdering = Ordering.from(ikktnyknInfoDataSourceBeanSortComparator);

        ikktnyknInfoLst = ikktnyknInfoOrdering.sortedCopy(ikktnyknInfoLst);

        GkkwssekInfoDataSourceBeanSortComparator gkkwssekInfoDataSourceBeanSortComparator =
            SWAKInjector.getInstance(GkkwssekInfoDataSourceBeanSortComparator.class);

        Ordering<GkkwssekInfoDataSourceBean> gkkwssekInfoOrdering = Ordering.from(gkkwssekInfoDataSourceBeanSortComparator);

        gkkwssekInfoLst = gkkwssekInfoOrdering.sortedCopy(gkkwssekInfoLst);

        uiBean.setGkkwssekInfo(gkkwssekInfoLst);

        uiBean.setIkktnyknInfo(ikktnyknInfoLst);

        if (gkkwssekInfoLst.size() > 0) {
            messageManager.addMessageId(MessageId.IHF1032);
        }
    }

    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        List<HT_HrkmNyknData> hrkmNyknDataLst = Lists.newArrayList();
        List<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataLst =  Lists.newArrayList();

        for (HrkmnyknInfoDataSourceBean dsBean : uiBean.getHrkmnyknInfoDataSource().getAllData()) {
            HM_HurikomiKouza hurikomiKouza =
                getHurikomiKouza(dsBean.getNyknoyadrtencd(), dsBean.getHrktuukasyu(), dsBean.getSiteituuka());

            if (C_Tuukasyu.JPY.eq(dsBean.getHrktuukasyu())) {

                insertHrkmNyknData(dsBean, hurikomiKouza, sysDate, hrkmNyknDataLst, sysDateTime);
            }
            else {
                insertGaikaHrkmNyknData(dsBean, hurikomiKouza, sysDate, gaikaHrkmNyknDataLst, sysDateTime);
            }
        }


        Integer renno = 0;
        List<HT_GrossNykn> grossNyknLst = Lists.newArrayList();

        for (GkkwssekInfoDataSourceBean gkkwssekInfoBean : uiBean.getGkkwssekInfoDataSource().getAllData()) {

            if (renno == 0) {
                Integer maxRenno = skHurikomiNyuukinHaneiYoyakuDao.getGrossNyknMaxRennoByRyosyuymdOyadrtencd(
                    gkkwssekInfoBean.getRyosyuymd(), gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm());

                if (maxRenno != null) {
                    renno = maxRenno;
                }
            }

            renno = renno + 1;

            HM_HurikomiKouza hurikomiKouza =
                getHurikomiKouza(gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm(),
                    gkkwssekInfoBean.getGkkwssekinfohrktuukasyu(), gkkwssekInfoBean.getGkkwssekinfositeituukasyu());

            HT_GrossNykn grossNykn = new HT_GrossNykn();
            grossNykn.setRyosyuymd(gkkwssekInfoBean.getRyosyuymd());
            grossNykn.setOyadrtencd(gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm());
            grossNykn.setRenno(renno);
            grossNykn.setNyksyoriymd(sysDate);
            grossNykn.setHrktuukasyu(gkkwssekInfoBean.getGkkwssekinfohrktuukasyu());
            grossNykn.setKyktuukasyu(gkkwssekInfoBean.getGkkwssekinfositeituukasyu());
            grossNykn.setKouzano(gkkwssekInfoBean.getGkkwssekinfokouzano());
            grossNykn.setNyuukinoyadrtennm(hurikomiKouza.getNyuukinoyadrtennm());
            grossNykn.setKawaserate(gkkwssekInfoBean.getKawaserate());
            grossNykn.setGrossnykngk(gkkwssekInfoBean.getGrossnykngk());
            grossNykn.setGrossdengk(gkkwssekInfoBean.getGrossdengk());
            grossNykn.setMeisaigoukeidengk(gkkwssekInfoBean.getMeisaigoukeidengk());
            grossNykn.setKawasesasonekikngk(gkkwssekInfoBean.getKawasesasonekikngk());
            grossNykn.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            grossNykn.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(grossNykn);

            Integer meisairenno = 0;

            for (HrkmnyknInfoDataSourceBean dsBean : uiBean.getHrkmnyknInfoDataSource().getAllData()) {
                if (dsBean.getHrktuukasyu().eq(gkkwssekInfoBean.getGkkwssekinfohrktuukasyu()) &&
                    dsBean.getSiteituuka().eq(gkkwssekInfoBean.getGkkwssekinfositeituukasyu()) ) {
                    HT_GrossNyknMeisai grossNyknMeisai = grossNykn.createGrossNyknMeisai();
                    meisairenno = meisairenno + 1;

                    grossNyknMeisai.setRyosyuymd(gkkwssekInfoBean.getRyosyuymd());
                    grossNyknMeisai.setOyadrtencd(gkkwssekInfoBean.getGkkwssekinfonyknoyadrtennm());
                    grossNyknMeisai.setRenno(renno);
                    grossNyknMeisai.setMeisairenno(meisairenno);
                    grossNyknMeisai.setNykmosno(dsBean.getMosnochknasi());
                    grossNyknMeisai.setRsgaku(dsBean.getRsgaku());
                    grossNyknMeisai.setDengk(dsBean.getDengk());
                    grossNyknMeisai.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    grossNyknMeisai.setGyoumuKousinTime(sysDateTime);

                    BizPropertyInitializer.initialize(grossNyknMeisai);
                }

            }

            grossNyknLst.add(grossNykn);
        }

        sinkeiyakuDomManager.insert(grossNyknLst);

        sinkeiyakuDomManager.insert(hrkmNyknDataLst);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknDataLst);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    @SuppressWarnings("resource")
    void callAjaxCommonBL() throws IOException {
        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);
        List<String> outStrLst = Lists.newArrayList();
        C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));
        int rowNo = Integer.valueOf(request.getParameter(AJAX_POST_PARAM_ROWNO));
        outStrLst = ajaxCurrencyChange(tuukasyu, rowNo);
        String responseJson = JSON.encode(outStrLst);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
    }

    private C_Tuukasyu convTuukaSyuruiKbn(String pTuukasyu) {

        C_Tuukasyu tuukasyu;

        if (JPY.equals(pTuukasyu)) {

            tuukasyu = C_Tuukasyu.JPY;
        }
        else if (USD.equals(pTuukasyu)) {

            tuukasyu = C_Tuukasyu.USD;
        }
        else if (AUD.equals(pTuukasyu)) {

            tuukasyu = C_Tuukasyu.AUD;
        }
        else {
            tuukasyu = C_Tuukasyu.BLNK;
        }

        return tuukasyu;
    }

    private BizCurrency convRsgaku(SkHurikomiNyuukinMeisaiLayoutFile pNyuukinData) {

        BizCurrency convRsgaku;
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        String hrktuuka = pNyuukinData.getIfeHrktuuka();
        String rsgaku = pNyuukinData.getIfeRsgaku();

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(convTuukaSyuruiKbn(hrktuuka));

        try {

            int decimalLength = new BigDecimal(rsgaku).scale();

            if (JPY.equals(hrktuuka)) {

                if (decimalLength > 0) {
                    return BizCurrency.optional();
                }
            }
            else if (USD.equals(hrktuuka) || AUD.equals(hrktuuka)) {

                if (decimalLength > 2) {
                    return BizCurrency.optional(currencyType);
                }
            }
            else {
                return BizCurrency.optional();
            }

            convRsgaku = BizCurrency.valueOf(new BigDecimal(rsgaku), currencyType);

        } catch(Exception e) {
            return BizCurrency.optional(currencyType);
        }

        return convRsgaku;
    }

    private BizDate getRyosyuYmd(SkHurikomiNyuukinMeisaiLayoutFile pNyuukinData) {

        try {
            BizDate ryosyuYmd = BizDate.valueOf(pNyuukinData.getIfeRyosyuymd());

            if (ryosyuYmd.isRekijyou()) {
                return ryosyuYmd;
            }

            return null;

        } catch(Exception e) {
            return null;
        }
    }

    private HM_HurikomiKouza getHurikomiKouza(String pOyaDrtenCd, C_Tuukasyu pHrkTuuka, C_Tuukasyu pSiteiTuuka) {

        HM_HurikomiKouza hurikomiKouza = null;

        for (HM_HurikomiKouza bean : uiBean.getHurikomiKouzaLst()) {
            if (bean.getOyadrtencd().equals(pOyaDrtenCd) &&
                bean.getTuukasyu().equals(pHrkTuuka) &&
                bean.getSiteituuka().equals(pSiteiTuuka)) {

                hurikomiKouza = bean;

                break;
            }
        }

        return hurikomiKouza;
    }

    private void insertHrkmNyknData(HrkmnyknInfoDataSourceBean pDsBean, HM_HurikomiKouza pHurikomiKouza,
        BizDate pSysDate, List<HT_HrkmNyknData> pHrkmNyknDataLst, String pSysDateTime) {

        String uniqueKey = uniqueKeyGenerator.generateUniqueKey();

        HT_HrkmNyknData hrkmNyknData = new HT_HrkmNyknData();

        hrkmNyknData.setDensyskbn(C_DensysKbn.SKEI);
        hrkmNyknData.setSyoriYmd(pSysDate);
        hrkmNyknData.setItirenno(uniqueKey);
        hrkmNyknData.setNykmosno(pDsBean.getMosnochknasi());
        hrkmNyknData.setSyubetucd(SYUBETUCD_ENKA);
        hrkmNyknData.setCdkbn(CDKBN);
        hrkmNyknData.setSakuseiymd(pSysDate);
        hrkmNyknData.setBankcd(pHurikomiKouza.getBankcd());
        hrkmNyknData.setSitencd(pHurikomiKouza.getSitencd());
        hrkmNyknData.setYokinkbn(pHurikomiKouza.getYokinkbn());
        hrkmNyknData.setKouzano(pHurikomiKouza.getKouzano());
        hrkmNyknData.setKnjyymd(pDsBean.getRyosyuymd());
        hrkmNyknData.setAzkrhrdsymd(pDsBean.getRyosyuymd());
        hrkmNyknData.setIribaraikbn(IRIBARAIKBN);
        hrkmNyknData.setTrhkkgk(pDsBean.getRsgaku());
        hrkmNyknData.setHrkmirnincd(HRKMIRNINCD);
        hrkmNyknData.setHrkmirninnm(pDsBean.getHrkmirninnm48());
        hrkmNyknData.setHrkmirninnm140(ConvertUtil.toZenAll(pDsBean.getMosnochknasi(), 0, 0) +
            "　" + pDsBean.getHrkmirninnm48());
        hrkmNyknData.setSimukebanknmkn(pDsBean.getSimukebanknm15());
        hrkmNyknData.setSimuketennmkn(pDsBean.getSimuketennm15());
        hrkmNyknData.setOyadrtencd(pDsBean.getNyknoyadrtencd());
        hrkmNyknData.setOyadrtensyoritarget(pHurikomiKouza.getOyadrtensyoritarget());
        hrkmNyknData.setJidonykntargethyouji(pHurikomiKouza.getJidonykntargethyouji());
        hrkmNyknData.setMostokusokuumu(C_UmuKbn.NONE);
        hrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
        hrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        hrkmNyknData.setGyoumuKousinTime(pSysDateTime);
        hrkmNyknData.setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);
        hrkmNyknData.setNyuukinoyadrtennm(pHurikomiKouza.getNyuukinoyadrtennm());
        hrkmNyknData.setSiteituuka(pDsBean.getSiteituuka());
        hrkmNyknData.setHonkouzacd(pHurikomiKouza.getHonkouzacd());

        BizPropertyInitializer.initialize(hrkmNyknData);

        pHrkmNyknDataLst.add(hrkmNyknData);
    }

    private void insertGaikaHrkmNyknData(HrkmnyknInfoDataSourceBean pDsBean, HM_HurikomiKouza pHurikomiKouza,
        BizDate pSysDate, List<HT_GaikaHrkmNyknData> pGaikaHrkmNyknDataLst, String pSysDateTime) {

        String uniqueKey = uniqueKeyGenerator.generateUniqueKey();

        HT_GaikaHrkmNyknData gaikaHrkmNyknData = new HT_GaikaHrkmNyknData();

        gaikaHrkmNyknData.setDensyskbn(C_DensysKbn.SKEI);
        gaikaHrkmNyknData.setSyoriYmd(pSysDate);
        gaikaHrkmNyknData.setItirenno(uniqueKey);
        gaikaHrkmNyknData.setNykmosno(pDsBean.getMosnochknasi());
        gaikaHrkmNyknData.setSyubetucd(SYUBETUCD_GAIKA);
        gaikaHrkmNyknData.setCdkbn(CDKBN);
        gaikaHrkmNyknData.setSakuseiymd(pSysDate);
        gaikaHrkmNyknData.setBankcd(pHurikomiKouza.getBankcd());
        gaikaHrkmNyknData.setSitencd(pHurikomiKouza.getSitencd());
        gaikaHrkmNyknData.setYokinkbn(pHurikomiKouza.getYokinkbn());
        gaikaHrkmNyknData.setKouzano(pHurikomiKouza.getKouzano());
        gaikaHrkmNyknData.setKnjyymd(pDsBean.getRyosyuymd());
        gaikaHrkmNyknData.setKsnymd(pDsBean.getRyosyuymd());
        gaikaHrkmNyknData.setIribaraikbn(IRIBARAIKBN);
        gaikaHrkmNyknData.setTrhkkgk(pDsBean.getRsgaku());
        gaikaHrkmNyknData.setTuukasyu(pDsBean.getHrktuukasyu());
        gaikaHrkmNyknData.setHrkmirninnm(pDsBean.getHrkmirninnm48());
        gaikaHrkmNyknData.setHrkmirninnm140(ConvertUtil.toZenAll(pDsBean.getMosnochknasi(), 0, 0) +
            "　" + pDsBean.getHrkmirninnm48());
        gaikaHrkmNyknData.setSimukebanknmeiji(pDsBean.getSimukebanknm15());
        gaikaHrkmNyknData.setSimuketennmeiji(pDsBean.getSimuketennm15());
        gaikaHrkmNyknData.setOyadrtencd(pDsBean.getNyknoyadrtencd());
        gaikaHrkmNyknData.setOyadrtensyoritarget(pHurikomiKouza.getOyadrtensyoritarget());
        gaikaHrkmNyknData.setJidonykntargethyouji(pHurikomiKouza.getJidonykntargethyouji());
        gaikaHrkmNyknData.setMostokusokuumu(C_UmuKbn.NONE);
        gaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        gaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
        gaikaHrkmNyknData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        gaikaHrkmNyknData.setGyoumuKousinTime(pSysDateTime);
        gaikaHrkmNyknData.setHrkmnykndatarenmotoKbn(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI);
        gaikaHrkmNyknData.setNyuukinoyadrtennm(pHurikomiKouza.getNyuukinoyadrtennm());
        gaikaHrkmNyknData.setSiteituuka(pDsBean.getSiteituuka());
        gaikaHrkmNyknData.setHonkouzacd(pHurikomiKouza.getHonkouzacd());

        BizPropertyInitializer.initialize(gaikaHrkmNyknData);

        pGaikaHrkmNyknDataLst.add(gaikaHrkmNyknData);
    }

    private List<String> ajaxCurrencyChange(C_Tuukasyu pTuukasyu, int pRowNo) {
        List<String> outStrLst = Lists.newArrayList();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
        BizCurrency initKingaku = BizCurrency.optional(currencyType);

        outStrLst.add(initKingaku.toString());
        outStrLst.add(initKingaku.toPattern());
        outStrLst.add(currencyType.getUnitValue());
        outStrLst.add(currencyType.toString());

        uiBean.getHrkmnyknInfoDataSource().getAllData().get(pRowNo).setRsgaku(initKingaku);

        return outStrLst;
    }

    private UserDefsList setOyaDrtenCdLst() {

        List<HM_HurikomiKouza> hurikomiKouzaLst = uiBean.getHurikomiKouzaLst();

        LinkedHashMap<String, HM_HurikomiKouza> hurikomiKouzaMap = new LinkedHashMap<>();

        for (HM_HurikomiKouza hurikomiKouza : hurikomiKouzaLst) {

            if (!hurikomiKouzaMap.containsKey(hurikomiKouza.getOyadrtencd())) {

                hurikomiKouzaMap.put(hurikomiKouza.getOyadrtencd(), hurikomiKouza);
            }
        }

        UserDefsList oyaDrtenCdLst = new UserDefsList();

        for (String oyaDrtenCd : hurikomiKouzaMap.keySet()) {

            oyaDrtenCdLst.add(new LabelValuePair(hurikomiKouzaMap.get(oyaDrtenCd).getNyuukinoyadrtennm(), oyaDrtenCd));
        }

        return oyaDrtenCdLst;
    }

    private BizCurrency optionalToZero(BizCurrency pHenkanTaiyou) {
        if (pHenkanTaiyou == null || pHenkanTaiyou.isOptional()) {
            return BizCurrency.valueOf(0);
        }

        return pHenkanTaiyou;
    }
}
