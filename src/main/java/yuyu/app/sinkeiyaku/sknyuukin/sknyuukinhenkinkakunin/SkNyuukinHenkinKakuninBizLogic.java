package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin;
import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.GenSkNyuukinHenkinKakuninConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.SkNyuukinHenkinKakuninConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.dba.HenkinNyuuryokuInfoBean;
import yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.dba.NyuukinNyuuryokuInfoBean;
import yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin.dba.SkNyuukinHenkinKakuninDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

import com.google.common.collect.Lists;

/**
 * 入金／返金状況確認 のビジネスロジックです。
 */
public class SkNyuukinHenkinKakuninBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkNyuukinHenkinKakuninUiBean uiBean;

    @Inject
    private SkNyuukinHenkinKakuninDao skNyuukinHenkinKakuninDao;

    @Inject
    private MessageManager messageManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setNyuukinhenkinsyorikbn(C_NyuukinHenkinSyoriKbn.NYUUKIN);
        uiBean.setSyoriYmd(BizDate.getSysDate());
    }

    void clear() {
    }

    void pushSyoukaibtnByInputkeyBL() {

        BizDate sysDate =  BizDate.getSysDate();

        checkError(sysDate);
        checkWarningMsg(sysDate);

        List<String> yuukoutuukasyuLst = YuyuSinkeiyakuConfig.getInstance().getYuukoutuukasyuList();

        List<GoukeiInfoDataSourceBean> goukeiInfoLst = Lists.newArrayList();
        List<NyuukinMeisaiDataSourceBean> nyuukinMeisaiLst = Lists.newArrayList();
        List<HenkinMeisaiDataSourceBean> henkinMeisaiLst = Lists.newArrayList();

        if (C_NyuukinHenkinSyoriKbn.NYUUKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) {
            setUiBeanNyuukinNyuuryoku(yuukoutuukasyuLst, goukeiInfoLst,nyuukinMeisaiLst);
        }
        else if (C_NyuukinHenkinSyoriKbn.HENKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) {
            setUiBeanHenkinNyuuryoku(yuukoutuukasyuLst, goukeiInfoLst,henkinMeisaiLst);
        }

        uiBean.setGoukeiInfo(goukeiInfoLst);
        uiBean.setNyuukinMeisai(nyuukinMeisaiLst);
        uiBean.setHenkinMeisai(henkinMeisaiLst);
    }

    void pushSyousaiBL() {

        if (C_NyuukinHenkinSyoriKbn.NYUUKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) {
            if (uiBean.getNyuukinMeisaiDataSource().getAllData().size() == 0) {
                throw new BizLogicException(MessageId.EBA0048);
            }
        }
        else if (C_NyuukinHenkinSyoriKbn.HENKIN.eq(uiBean.getNyuukinhenkinsyorikbn())) {
            if (uiBean.getHenkinMeisaiDataSource().getAllData().size() == 0) {
                throw new BizLogicException(MessageId.EBA0048);
            }
        }
    }

    void pushFunctionNameBL () {

        if (uiBean.getPageNo() == PAGENO_INPUTKEY) {

            init();
        }
        else {

            inputKeyInit();
        }
    }

    void pushModorubtnBySyoukaiBL() {
        inputKeyInit();
    }


    private void inputKeyInit() {
        uiBean.setNyuukinhenkinsyorikbn(C_NyuukinHenkinSyoriKbn.NYUUKIN);

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
    }

    private BizNumber zeroToOptional(BizNumber pHenkanTaiyou) {

        if (pHenkanTaiyou == null || pHenkanTaiyou.isOptional() || pHenkanTaiyou.compareTo(BizNumber.ZERO) == 0) {
            return BizNumber.optional();
        }

        return pHenkanTaiyou;
    }

    private void checkError(BizDate pSysDate) {

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), pSysDate.addYears(-1)) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(uiBean.getSyoriYmd(), pSysDate.addYears(-1)) == BizDateUtil.COMPARE_EQUAL) {
            throw new BizLogicException(MessageId.EHC1001,
                MessageUtil.getMessage(DDID_BASEINFO_SYORIYMD.getErrorResourceKey()));
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), pSysDate) == BizDateUtil.COMPARE_GREATER ) {
            throw new BizLogicException(MessageId.EBA0026,
                MessageUtil.getMessage(DDID_BASEINFO_SYORIYMD.getErrorResourceKey()));
        }
    }

    private void checkWarningMsg(BizDate pSysDate) {

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmd(), pSysDate) == BizDateUtil.COMPARE_EQUAL ) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,MessageId.WHC1012);
        }
    }

    private void setUiBeanNyuukinNyuuryoku(List<String> pYuukoutuukasyuLst,
        List<GoukeiInfoDataSourceBean> pGoukeiInfoLst, List<NyuukinMeisaiDataSourceBean> pNyuukinMeisaiLst) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        Map<C_Tuukasyu,Integer> tuukabetuSumMapKensu = new HashMap<C_Tuukasyu, Integer>();
        Map<C_Tuukasyu,BizCurrency> tuukabetuSumMapRsKingaku = new HashMap<C_Tuukasyu, BizCurrency>();
        Map<C_Tuukasyu,BizCurrency> tuukabetuSumMapRsKingakuYen = new HashMap<C_Tuukasyu, BizCurrency>();

        Integer tuukabetuSumKensu = 0;
        BizCurrency tuukabetuSumRsKingaku = BizCurrency.valueOf(0);
        BizCurrency tuukabetuSumRsKingakuYen = BizCurrency.valueOf(0);

        for (String yuukoutuukasyu  : pYuukoutuukasyuLst) {

            tuukabetuSumMapKensu.put(C_Tuukasyu.valueOf(yuukoutuukasyu), Integer.valueOf(0));

            tuukabetuSumMapRsKingaku.put(C_Tuukasyu.valueOf(yuukoutuukasyu), BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.valueOf(yuukoutuukasyu))));

            tuukabetuSumMapRsKingakuYen.put(C_Tuukasyu.valueOf(yuukoutuukasyu), BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        }


        List<NyuukinNyuuryokuInfoBean> nyuukinNyuuryokuInfoLst =
            skNyuukinHenkinKakuninDao.getNyuukinNyuuryokuInfo(uiBean.getSyoriYmd());

        for (NyuukinNyuuryokuInfoBean nyuukinNyuuryokuInfoBean  : nyuukinNyuuryokuInfoLst) {

            NyuukinMeisaiDataSourceBean nyuukinMeisaiDataSourceBean = SWAKInjector.getInstance(NyuukinMeisaiDataSourceBean.class);

            nyuukinMeisaiDataSourceBean.setMosno(nyuukinNyuuryokuInfoBean.getMosno());
            nyuukinMeisaiDataSourceBean.setNyknsyubetu(nyuukinNyuuryokuInfoBean.getNyknsyubetu());
            nyuukinMeisaiDataSourceBean.setRyosyuymd(nyuukinNyuuryokuInfoBean.getRyosyuymd());
            nyuukinMeisaiDataSourceBean.setRsgaku(nyuukinNyuuryokuInfoBean.getRsgaku());
            nyuukinMeisaiDataSourceBean.setDenyenkagk(nyuukinNyuuryokuInfoBean.getDenyenkagk());

            if (!C_Tuukasyu.JPY.eq(nyuukinNyuuryokuInfoBean.getRstuukasyu())) {

                if (!nyuukinNyuuryokuInfoBean.getFstpryosyuymd().isBusinessDay()) {

                    nyuukinMeisaiDataSourceBean.setFstpryosyuymd(nyuukinNyuuryokuInfoBean.getFstpryosyuymd()
                        .addBusinessDays(1));
                }
                else {
                    nyuukinMeisaiDataSourceBean.setFstpryosyuymd(nyuukinNyuuryokuInfoBean.getFstpryosyuymd());
                }
            }

            nyuukinMeisaiDataSourceBean.setDenkawaserate(
                zeroToOptional(nyuukinNyuuryokuInfoBean.getDenkawaserate()));

            nyuukinMeisaiDataSourceBean.setSeiritukbn(nyuukinNyuuryokuInfoBean.getSeiritukbn());

            if (C_KykKbn.KEIHI_DOUITU.eq(nyuukinNyuuryokuInfoBean.getKykkbn())) {
                nyuukinMeisaiDataSourceBean.setKyknmkn(nyuukinNyuuryokuInfoBean.getHhknnmkn());
            }
            else {
                nyuukinMeisaiDataSourceBean.setKyknmkn(nyuukinNyuuryokuInfoBean.getKyknmkn());
            }

            if (!C_Tuukasyu.JPY.eq(nyuukinNyuuryokuInfoBean.getKyktuukasyu())) {
                nyuukinMeisaiDataSourceBean.setGkdtendt(STR_GAIKAKEN);
            }
            else {
                nyuukinMeisaiDataSourceBean.setGkdtendt(STR_YENKEN);
            }

            pNyuukinMeisaiLst.add(nyuukinMeisaiDataSourceBean);

            if (!C_Tuukasyu.JPY.eq(nyuukinNyuuryokuInfoBean.getKyktuukasyu())) {
                tuukabetuSumMapKensu.put(nyuukinNyuuryokuInfoBean.getRstuukasyu(),
                    tuukabetuSumMapKensu.get(nyuukinNyuuryokuInfoBean.getRstuukasyu()) +1 );
                tuukabetuSumMapRsKingaku.put(nyuukinNyuuryokuInfoBean.getRstuukasyu(),
                    tuukabetuSumMapRsKingaku.get
                    (nyuukinNyuuryokuInfoBean.getRstuukasyu()).add(nyuukinNyuuryokuInfoBean.getRsgaku()));
                tuukabetuSumMapRsKingakuYen.put(nyuukinNyuuryokuInfoBean.getRstuukasyu(),
                    tuukabetuSumMapRsKingakuYen.get(
                        nyuukinNyuuryokuInfoBean.getRstuukasyu()).add(nyuukinNyuuryokuInfoBean.getDenyenkagk()));
            }
            else {
                tuukabetuSumKensu = tuukabetuSumKensu + 1;
                tuukabetuSumRsKingaku = tuukabetuSumRsKingaku.add(nyuukinNyuuryokuInfoBean.getRsgaku());
                tuukabetuSumRsKingakuYen = tuukabetuSumRsKingakuYen.add(nyuukinNyuuryokuInfoBean.getDenyenkagk());
            }
        }

        for (String yuukoutuukasyu  : pYuukoutuukasyuLst) {

            GoukeiInfoDataSourceBean goukeiInfoDataSourceBean = SWAKInjector.getInstance(GoukeiInfoDataSourceBean.class);

            goukeiInfoDataSourceBean.setDispgkdtendt(STR_GAIKAKEN);
            goukeiInfoDataSourceBean.setDisprstuukasyu(C_Tuukasyu.valueOf(yuukoutuukasyu));
            goukeiInfoDataSourceBean.setDispkensuu(tuukabetuSumMapKensu.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));
            goukeiInfoDataSourceBean.setDisprskingaku(tuukabetuSumMapRsKingaku.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));
            goukeiInfoDataSourceBean.setDisprsdengkyen(tuukabetuSumMapRsKingakuYen.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));
            pGoukeiInfoLst.add(goukeiInfoDataSourceBean);
        }

        GoukeiInfoDataSourceBean goukeiInfoDataSourceBean = SWAKInjector.getInstance(GoukeiInfoDataSourceBean.class);

        goukeiInfoDataSourceBean.setDispgkdtendt(STR_YENKEN);
        goukeiInfoDataSourceBean.setDisprstuukasyu(C_Tuukasyu.JPY);
        goukeiInfoDataSourceBean.setDispkensuu(tuukabetuSumKensu);
        goukeiInfoDataSourceBean.setDisprskingaku(tuukabetuSumRsKingaku);
        goukeiInfoDataSourceBean.setDisprsdengkyen(tuukabetuSumRsKingakuYen);

        pGoukeiInfoLst.add(goukeiInfoDataSourceBean);
    }

    private void setUiBeanHenkinNyuuryoku(List<String> pYuukoutuukasyuLst,
        List<GoukeiInfoDataSourceBean> pGoukeiInfoLst, List<HenkinMeisaiDataSourceBean> pHenkinMeisaiLst) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        Map<C_Tuukasyu,Integer> tuukabetuSumMapKensu = new HashMap<C_Tuukasyu, Integer>();
        Map<C_Tuukasyu,BizCurrency> tuukabetuSumMapRsKingaku = new HashMap<C_Tuukasyu, BizCurrency>();
        Map<C_Tuukasyu,BizCurrency> tuukabetuSumMapRsKingakuYen = new HashMap<C_Tuukasyu, BizCurrency>();

        Integer tuukabetuSumKensu = 0;
        BizCurrency tuukabetuSumRsKingaku = BizCurrency.valueOf(0);
        BizCurrency tuukabetuSumRsKingakuYen = BizCurrency.valueOf(0);

        for (String yuukoutuukasyu  : pYuukoutuukasyuLst) {

            tuukabetuSumMapKensu.put(C_Tuukasyu.valueOf(yuukoutuukasyu), Integer.valueOf(0));

            tuukabetuSumMapRsKingaku.put(C_Tuukasyu.valueOf(yuukoutuukasyu), BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.valueOf(yuukoutuukasyu))));

            tuukabetuSumMapRsKingakuYen.put(C_Tuukasyu.valueOf(yuukoutuukasyu), BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        }

        List<HenkinNyuuryokuInfoBean> henkinNyuuryokuInfoLst =
            skNyuukinHenkinKakuninDao.getHenkinNyuuryokuInfo(uiBean.getSyoriYmd());


        for (HenkinNyuuryokuInfoBean henkinNyuuryokuInfoBean : henkinNyuuryokuInfoLst) {
            HenkinMeisaiDataSourceBean henkinMeisaiDataSourceBean =
                SWAKInjector.getInstance(HenkinMeisaiDataSourceBean.class);

            henkinMeisaiDataSourceBean.setMosno(henkinNyuuryokuInfoBean.getMosno());
            henkinMeisaiDataSourceBean.setHnknhoukbn(henkinNyuuryokuInfoBean.getHnknhoukbn());
            henkinMeisaiDataSourceBean.setHnkngk(henkinNyuuryokuInfoBean.getHnkngk());
            henkinMeisaiDataSourceBean.setDenyenkagk(henkinNyuuryokuInfoBean.getDenyenkagk());

            if (!C_Tuukasyu.JPY.eq(henkinNyuuryokuInfoBean.getHnkntuukasyu())) {

                if (!henkinNyuuryokuInfoBean.getFstpryosyuymd().isBusinessDay()) {

                    henkinMeisaiDataSourceBean.setFstpryosyuymd(henkinNyuuryokuInfoBean.getFstpryosyuymd()
                        .addBusinessDays(1));
                }
                else {
                    henkinMeisaiDataSourceBean.setFstpryosyuymd(henkinNyuuryokuInfoBean.getFstpryosyuymd());
                }
            }

            henkinMeisaiDataSourceBean.setDenkawaserate(zeroToOptional(henkinNyuuryokuInfoBean.getDenkawaserate()));

            henkinMeisaiDataSourceBean.setSeiritukbn(henkinNyuuryokuInfoBean.getSeiritukbn());

            if (C_KykKbn.KEIHI_DOUITU.eq(henkinNyuuryokuInfoBean.getKykkbn())) {
                henkinMeisaiDataSourceBean.setKyknmkn(henkinNyuuryokuInfoBean.getHhknnmkn());
            }
            else {
                henkinMeisaiDataSourceBean.setKyknmkn(henkinNyuuryokuInfoBean.getKyknmkn());
            }

            if (!C_Tuukasyu.JPY.eq(henkinNyuuryokuInfoBean.getKyktuukasyu())) {
                henkinMeisaiDataSourceBean.setGkdtendt(STR_GAIKAKEN);
            }
            else {
                henkinMeisaiDataSourceBean.setGkdtendt(STR_YENKEN);
            }

            pHenkinMeisaiLst.add(henkinMeisaiDataSourceBean);

            if (!C_Tuukasyu.JPY.eq(henkinNyuuryokuInfoBean.getKyktuukasyu())) {
                tuukabetuSumMapKensu.put(henkinNyuuryokuInfoBean.getHnkntuukasyu(),
                    tuukabetuSumMapKensu.get(henkinNyuuryokuInfoBean.getHnkntuukasyu()) + Integer.valueOf(1) );
                tuukabetuSumMapRsKingaku.put(henkinNyuuryokuInfoBean.getHnkntuukasyu(),
                    tuukabetuSumMapRsKingaku.get(
                        henkinNyuuryokuInfoBean.getHnkntuukasyu()).add(henkinNyuuryokuInfoBean.getHnkngk()));
                tuukabetuSumMapRsKingakuYen.put(henkinNyuuryokuInfoBean.getHnkntuukasyu(),
                    tuukabetuSumMapRsKingakuYen.get(
                        henkinNyuuryokuInfoBean.getHnkntuukasyu()).add(henkinNyuuryokuInfoBean.getDenyenkagk()));
            }
            else {
                tuukabetuSumKensu = tuukabetuSumKensu + 1;
                tuukabetuSumRsKingaku = tuukabetuSumRsKingaku.add(henkinNyuuryokuInfoBean.getHnkngk());
                tuukabetuSumRsKingakuYen = tuukabetuSumRsKingakuYen.add(henkinNyuuryokuInfoBean.getDenyenkagk());
            }
        }

        for (String yuukoutuukasyu  : pYuukoutuukasyuLst) {

            GoukeiInfoDataSourceBean goukeiInfoDataSourceBean = SWAKInjector.getInstance(GoukeiInfoDataSourceBean.class);

            goukeiInfoDataSourceBean.setDispgkdtendt(STR_GAIKAKEN);
            goukeiInfoDataSourceBean.setDisprstuukasyu(C_Tuukasyu.valueOf(yuukoutuukasyu));
            goukeiInfoDataSourceBean.setDispkensuu(tuukabetuSumMapKensu.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));
            goukeiInfoDataSourceBean.setDisprskingaku(tuukabetuSumMapRsKingaku.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));
            goukeiInfoDataSourceBean.setDisprsdengkyen(tuukabetuSumMapRsKingakuYen.get(C_Tuukasyu.valueOf(yuukoutuukasyu)));

            pGoukeiInfoLst.add(goukeiInfoDataSourceBean);

        }

        GoukeiInfoDataSourceBean goukeiInfoDataSourceBean = SWAKInjector.getInstance(GoukeiInfoDataSourceBean.class);

        goukeiInfoDataSourceBean.setDispgkdtendt(STR_YENKEN);
        goukeiInfoDataSourceBean.setDisprstuukasyu(C_Tuukasyu.JPY);
        goukeiInfoDataSourceBean.setDispkensuu(tuukabetuSumKensu);
        goukeiInfoDataSourceBean.setDisprskingaku(tuukabetuSumRsKingaku);
        goukeiInfoDataSourceBean.setDisprsdengkyen(tuukabetuSumRsKingakuYen);

        pGoukeiInfoLst.add(goukeiInfoDataSourceBean);
    }
}
