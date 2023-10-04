package yuyu.batch.hozen.khozen.khmkhgktttyendthnksel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba.KhHenkouUktkYykBean;
import yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba.KhMkhgkTttYendtHnkSelDao;
import yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba.KhTttHntiKykBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.haitou.CheckDJyoutai;
import yuyu.common.hozen.haitou.CheckDSeigou;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KeisanYendtHnkS;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 目標額到達時円建変更対象抽出
 */
public class KhMkhgkTttYendtHnkSelBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private KhozenCommonParam khozenCommonParam;

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMkhgkTttYendtHnkSelDao khMkhgkTttYendtHnkSelDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn kekkaKbnUsd = getKawaseRate.exec(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(kekkaKbnUsd)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                syoriYmd.toString(), C_Tuukasyu.USD.getContent(), C_Tuukasyu.JPY.getContent()));
        }

        BizNumber usdKawaserate = getKawaseRate.getKawaserate();

        C_ErrorKbn kekkaKbnAud = getKawaseRate.exec(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(kekkaKbnAud)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                syoriYmd.toString(), C_Tuukasyu.AUD.getContent(), C_Tuukasyu.JPY.getContent()));
        }

        BizNumber audKawaserate = getKawaseRate.getKawaserate();

        long yendthnkInKensuu = 0;
        long khHnkUktkOutKensuu = 0;
        long khHnkUktkYendtHnkOutKensuu = 0;

        List<C_HnskariyuuKbn> hnskaRiyuuLst = null;

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = null;
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanW keisanW =SWAKInjector.getInstance(KeisanW.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        KeisanYendtHnkS keisanYendtHnkS = SWAKInjector.getInstance(KeisanYendtHnkS.class);
        IT_KhHenkouUktk khHenkouUktk = null;
        IT_KhHenkouUktkYendtHnk khHenkouUktkYendtHnk = null;
        int missListOutKensuu = 0;
        List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<EditKhMisslstParam>();
        KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

        BizDate yendtHnkYmd = syoriYmd.addDays(1);

        List<BM_YoteiRiritu3> yoteiRiritu3Lst = khMkhgkTttYendtHnkSelDao.getYoteiRiritus3ByKijyunYmd(yendtHnkYmd);

        C_UktkSyoriKbn[] uktkSyoriKbn = { C_UktkSyoriKbn.KAIYAKU, C_UktkSyoriKbn.TMTTKNITEN };
        List<KhHenkouUktkYykBean> khHenkouUktkYykBeanLst = khMkhgkTttYendtHnkSelDao
            .getKhHenkouUktkYykBeansByUktkSyoriKbn(uktkSyoriKbn);

        BizDate syoriYmdPreYear = syoriYmd.addYears(-1).getRekijyou();

        try (
            ExDBResults<KhTttHntiKykBean> khTttHntiKykBeanLst = khMkhgkTttYendtHnkSelDao.getKhTttHntiKykBySyoriYmd(
                kakutyouJobCd, syoriYmdPreYear);
            MultipleEntityInserter dataIns = new MultipleEntityInserter()) {

            for (KhTttHntiKykBean khTttHntiKykBean : khTttHntiKykBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khTttHntiKykBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khTttHntiKykBean.getSyono());

                int syohinHanteiKbn = SyouhinUtil.hantei(khTttHntiKykBean.getSyouhncd());

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR  == syohinHanteiKbn) {

                    hanteiHokenKikanBean = new HanteiHokenKikanBean();

                    BM_SyouhnZokusei syouhnZokusei =
                        bizDomManager.getSyouhnZokusei(khTttHntiKykBean.getSyouhncd(), khTttHntiKykBean.getSyouhnsdno());
                    hanteiHokenKikanBean.setKykYmd(khTttHntiKykBean.getKykymd());
                    hanteiHokenKikanBean.setCalcKijyunYmd(syoriYmd);
                    hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
                    hanteiHokenKikanBean.setDai1hknkkn(khTttHntiKykBean.getDai1hknkkn());
                    C_HknKknKbn hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

                    if (C_HknKknKbn.DAI3HKNKKN.eq(hknKknKbn)) {
                        continue;
                    }
                }

                yendthnkInKensuu = yendthnkInKensuu + 1;

                hnskaRiyuuLst = new ArrayList<C_HnskariyuuKbn>();

                checkYuukouJyoutaiParam = new CheckYuukouJyoutaiParam();

                checkYuukouJyoutaiParam.setSyono(khTttHntiKykBean.getSyono());

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                boolean yoyakuUmu = checkKhHenkouUktkYyk(khHenkouUktkYykBeanLst, khTttHntiKykBean.getSyono(),
                    C_UktkSyoriKbn.KAIYAKU);
                if (yoyakuUmu) {

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
                    hnskaRiyuuLst.add(C_HnskariyuuKbn.JIMU_ARI);
                }
                else {
                    yoyakuUmu = checkKhHenkouUktkYyk(khHenkouUktkYykBeanLst, khTttHntiKykBean.getSyono(),
                        C_UktkSyoriKbn.TMTTKNITEN);
                    if (yoyakuUmu) {
                        hnskaRiyuuLst.add(C_HnskariyuuKbn.JIMU_ARI);
                    }
                }

                if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  == syohinHanteiKbn) {

                    HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = new HanteiTmttknJyoutaiBean();
                    hanteiTmttknJyoutaiBean.setSyono(khTttHntiKykBean.getSyono());
                    hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                    hanteiTmttknJyoutaiBean.setKykymd(khTttHntiKykBean.getKykymd());

                    HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
                        .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                    boolean hanteiHekka = hanteiKhSisuurendoTmttknJyoutai
                        .execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);
                    if (!hanteiHekka) {

                        missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(),
                            C_Dbhanei.NONE, MessageUtil.getMessage(MessageId.EBA1052), editKhMisslstParamLst);

                        detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                        continue;
                    }
                }

                BizDateYM kijunYm = keisanWKijunYM.exec(khTttHntiKykBean.getKykymd(), syoriYmd, null,
                    khTttHntiKykBean.getHrkkaisuu(), khTttHntiKykBean.getKykjyoutai(), khTttHntiKykBean.getSyouhncd(),
                    null);

                C_ErrorKbn keisanWExtErrorKbn = keisanWExt.exec(khTttHntiKykBean.getSyono(), syoriYmd);

                if (C_ErrorKbn.ERROR.eq(keisanWExtErrorKbn)) {

                    missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                        MessageUtil.getMessage(MessageId.EIA1058), editKhMisslstParamLst);

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                C_ErrorKbn keisanWErrorKbn = keisanW.exec(syoriYmd, kijunYm, keisanWExt.getKeisanWExtBean());

                if (C_ErrorKbn.ERROR.eq(keisanWErrorKbn)) {

                    missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                        MessageUtil.getMessage(MessageId.EIA1059), editKhMisslstParamLst);

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                BizCurrency yendtHnkKaiyakuHrGaika = keisanW.getW();
                int keikaNensuu = keisanW.getKeikanensuu();
                int keikaTukisuu = keisanW.getKeikatukisuu();
                BizCurrency ptumitatekin = keisanW.getV();
                BizNumber sjkkkTyouseiRitu = keisanW.getSjkkktyouseiritu().multiply(100);
                BizCurrency kaiyakuKjgk = keisanW.getKaiyakukjgk();
                BizNumber kaiyakuKjRitu = keisanW.getKaiyakukjritu();
                C_UmuKbn kaiyakukoujyoritutekiumu = khTttHntiKykBean.getKaiyakukoujyoritutekiumu();

                BizNumber kawaseRate = BizNumber.ZERO;

                if (C_Tuukasyu.USD.eq(khTttHntiKykBean.getKyktuukasyu())) {
                    kawaseRate = usdKawaserate;
                }
                else if (C_Tuukasyu.AUD.eq(khTttHntiKykBean.getKyktuukasyu())) {
                    kawaseRate = audKawaserate;
                }

                BizCurrency oldKaiyakuhr = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, yendtHnkKaiyakuHrGaika, kawaseRate, C_HasuusyoriKbn.AGE);

                BizCurrency mokuhyouGk = keisanTargetMokuhyougk.exec(
                    khTttHntiKykBean.getTargettkykkijyungk(), khTttHntiKykBean.getTargettkmokuhyouti());

                if (oldKaiyakuhr.compareTo(mokuhyouGk) < 0) {

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                CheckDSeigou checkDSeigou = getInjectInstanceForInLoop(CheckDSeigou.class);
                C_ErrorKbn errorKbn = checkDSeigou.exec(khTttHntiKykBean.getSyono(), khTttHntiKykBean.getHaitounendo(),
                    khTttHntiKykBean.getKykymd(), null, syoriYmd);

                C_UmuKbn dHuseigouUmu = checkDSeigou.getDHuseigouUmu();

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                        MessageUtil.getMessage(MessageId.EIA1060), editKhMisslstParamLst);

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                if (C_UmuKbn.ARI.eq(dHuseigouUmu)) {

                    missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                        MessageUtil.getMessage(MessageId.EIF1120), editKhMisslstParamLst);

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                CheckDJyoutai checkDJyoutai = getInjectInstanceForInLoop(CheckDJyoutai.class);
                C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn = checkDJyoutai.execForHaitouJyoutaiHantei(
                    syoriYmd, khTttHntiKykBean.getKykymd(), null, khTttHntiKykBean.getHaitounendo());

                if (!C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI.eq(haitoujyoutaiHanteiKbn)) {

                    String missListMsg = editMisslistmsg(khTttHntiKykBean.getSyono());

                    missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                        missListMsg, editKhMisslstParamLst);

                    detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                    continue;
                }

                Integer syouhnsdNoMax = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(
                    khTttHntiKykBean.getYendthnksyouhncd(), yendtHnkYmd);

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                    khTttHntiKykBean.getYendthnksyouhncd(), syouhnsdNoMax);

                String newSyouhncd = syouhnZokusei.getSyouhncd();
                Integer newSyouhnSdno = syouhnZokusei.getSyouhnsdno();
                String newRyourituSdno = syouhnZokusei.getRyouritusdno();
                BizNumber newYoteiRiritu = BizNumber.ZERO;
                BizCurrency yendthnkS = BizCurrency.valueOf(0);
                BizCurrency yendthnkHrgk = BizCurrency.valueOf(0);
                BizCurrency newKaiyakuhr = BizCurrency.valueOf(0);
                BizNumber newTumitateRiritu = BizNumber.ZERO;
                BizCurrency yendthnkSibous = BizCurrency.valueOf(0);

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {

                    yendthnkS = oldKaiyakuhr;

                    newKaiyakuhr = oldKaiyakuhr;

                    yendthnkSibous = oldKaiyakuhr;

                    BM_YoteiRiritu3 yoteiRiritu3 = getYoteiRiritu3(yoteiRiritu3Lst, khTttHntiKykBean.getYendthnksyouhncd());

                    if (yoteiRiritu3 == null) {

                        missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                            MessageUtil.getMessage(MessageId.EIA1061), editKhMisslstParamLst);

                        detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                        continue;
                    }

                    newTumitateRiritu = yoteiRiritu3.getTumitateriritu();

                    newYoteiRiritu =  yoteiRiritu3.getYoteiriritu();
                }
                else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {

                    yendthnkS = oldKaiyakuhr;
                    newKaiyakuhr = oldKaiyakuhr;
                    yendthnkSibous = oldKaiyakuhr;

                    BM_YoteiRiritu3 yoteiRiritu3 = getYoteiRiritu3(yoteiRiritu3Lst, khTttHntiKykBean.getYendthnksyouhncd());

                    if(yoteiRiritu3 == null){
                        missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                            MessageUtil.getMessage(MessageId.EIA1061), editKhMisslstParamLst);

                        detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                        continue;
                    }

                    newTumitateRiritu = yoteiRiritu3.getTumitateriritu();

                    newYoteiRiritu =  yoteiRiritu3.getYoteiriritu();
                }
                else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR  == syohinHanteiKbn) {

                    C_ErrorKbn calcHkShrKngkErrorKbn = calcHkShrKngk.execByKeisanWExt(
                        khTttHntiKykBean.getSyono(),
                        syoriYmd,
                        C_SiinKbn.SP,
                        C_HokenkinsyuruiKbn.SBHOKENKIN,
                        khTttHntiKykBean.getSdpdkbn(),
                        khTttHntiKykBean.getHrkkeiro());

                    if (C_ErrorKbn.ERROR.eq(calcHkShrKngkErrorKbn)) {

                        missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                            MessageUtil.getMessage(MessageId.EIA1062), editKhMisslstParamLst);

                        detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                        continue;
                    }

                    yendthnkSibous = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY, calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk(), kawaseRate, C_HasuusyoriKbn.AGE);

                    C_ErrorKbn keisanYendtHnkSErrorKbn = keisanYendtHnkS.exec(syoriYmd,
                        oldKaiyakuhr,
                        yendthnkSibous,
                        newSyouhncd,
                        newSyouhnSdno,
                        newRyourituSdno,
                        newYoteiRiritu,
                        khTttHntiKykBean.getHrkkaisuu(),
                        khTttHntiKykBean.getHhknsei(),
                        khTttHntiKykBean.getHhknnen(),
                        khTttHntiKykBean.getHknkknsmnkbn(),
                        khTttHntiKykBean.getHknkkn(),
                        khTttHntiKykBean.getHrkkkn(),
                        keikaNensuu,
                        keikaTukisuu,
                        khTttHntiKykBean.getKykymd(),
                        kijunYm);

                    if (C_ErrorKbn.ERROR.eq(keisanYendtHnkSErrorKbn)) {

                        missListOutKensuu = editKhMisslst(missListOutKensuu, khTttHntiKykBean.getSyono(), C_Dbhanei.NONE,
                            MessageUtil.getMessage(MessageId.EIF1121), editKhMisslstParamLst);

                        detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());

                        continue;
                    }

                    yendthnkS = keisanYendtHnkS.getYendthnkKihonSAfter();
                    yendthnkHrgk = keisanYendtHnkS.getYendthnkhr();
                    newKaiyakuhr = keisanYendtHnkS.getYendthnkW();

                    if (C_UmuKbn.ARI.eq(keisanYendtHnkS.getYendthnkhrUmu())) {
                        hnskaRiyuuLst.add(C_HnskariyuuKbn.YENDTHNKHR_ARI);
                    }
                }

                int hzHenkouUktkRenno = Integer.valueOf(SaibanBiz.getHozenHenkouUktkrenNo(khTttHntiKykBean.getSyono()));

                khHenkouUktk = new IT_KhHenkouUktk(khTttHntiKykBean.getSyono(), hzHenkouUktkRenno);

                khHenkouUktk.setUktkymd(syoriYmd);
                khHenkouUktk.setTourokuroute(C_TourokuRouteKbn.BATCH);
                khHenkouUktk.setUktksyorikbn(C_UktkSyoriKbn.MKHGKTTTYENDTHNK);
                khHenkouUktk.setKouryokuhasseiymd(yendtHnkYmd);
                khHenkouUktk.setSyoriyoteiymd(syoriYmd);
                khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.MISYORI);
                khHenkouUktk.setGyoumuKousinKinou(kinouId);
                khHenkouUktk.setGyoumuKousinsyaId(userId);
                khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(khHenkouUktk);

                dataIns.add(khHenkouUktk);

                khHenkouUktkYendtHnk = new IT_KhHenkouUktkYendtHnk(khTttHntiKykBean.getSyono(), hzHenkouUktkRenno);

                khHenkouUktkYendtHnk.setYendthnkymd(yendtHnkYmd);
                khHenkouUktkYendtHnk.setMkhgktttymd(syoriYmd);
                khHenkouUktkYendtHnk.setMkhgktttkaiyakuhr(oldKaiyakuhr);
                khHenkouUktkYendtHnk.setNewkaiyakuhr(newKaiyakuhr);
                khHenkouUktkYendtHnk.setYendthnkhr(yendthnkHrgk);
                khHenkouUktkYendtHnk.setNewtumitateriritu(newTumitateRiritu);
                khHenkouUktkYendtHnk.setNewyoteiriritu(newYoteiRiritu);

                if (hnskaRiyuuLst.size() > 0) {
                    khHenkouUktkYendtHnk.setHnskariyuu1(hnskaRiyuuLst.get(0));
                }
                else {
                    khHenkouUktkYendtHnk.setHnskariyuu1(C_HnskariyuuKbn.BLNK);
                }

                if (hnskaRiyuuLst.size() > 1) {
                    khHenkouUktkYendtHnk.setHnskariyuu2(hnskaRiyuuLst.get(1));
                }
                else {
                    khHenkouUktkYendtHnk.setHnskariyuu2(C_HnskariyuuKbn.BLNK);
                }

                khHenkouUktkYendtHnk.setYendthnkkaiyakuhrgaika(yendtHnkKaiyakuHrGaika);
                khHenkouUktkYendtHnk.setYendthnkkaiyakuhryen(oldKaiyakuhr);
                khHenkouUktkYendtHnk.setYendthnkjikwsrate(kawaseRate);
                khHenkouUktkYendtHnk.setNewsyouhncd(newSyouhncd);
                khHenkouUktkYendtHnk.setNewsyouhnsdno(newSyouhnSdno);
                khHenkouUktkYendtHnk.setYendthnkkihons(yendthnkS);
                khHenkouUktkYendtHnk.setNewhokenryou(BizCurrency.valueOf(0));
                khHenkouUktkYendtHnk.setNewkyktuukasyu(C_Tuukasyu.JPY);
                khHenkouUktkYendtHnk.setNewryouritusdno(newRyourituSdno);
                khHenkouUktkYendtHnk.setMkhgk(mokuhyouGk);
                khHenkouUktkYendtHnk.setYendthnkkjnkg(khTttHntiKykBean.getTargettkykkijyungk());
                khHenkouUktkYendtHnk.setTargettkmokuhyouti(khTttHntiKykBean.getTargettkmokuhyouti());
                khHenkouUktkYendtHnk.setYendthnkbfrsibousyen(yendthnkSibous);
                khHenkouUktkYendtHnk.setYendthnkjiptumitatekin(ptumitatekin);
                khHenkouUktkYendtHnk.setYendthnkjisjkkktyouseiritu(sjkkkTyouseiRitu);
                khHenkouUktkYendtHnk.setYendthnkjikaiyakukjgk(kaiyakuKjgk);
                khHenkouUktkYendtHnk.setYendthnkjikaiyakukoujyoritu(kaiyakuKjRitu);
                khHenkouUktkYendtHnk.setKaiyakukoujyoritutekiumu(kaiyakukoujyoritutekiumu);
                khHenkouUktkYendtHnk.setGyoumuKousinKinou(kinouId);
                khHenkouUktkYendtHnk.setGyoumuKousinsyaId(userId);
                khHenkouUktkYendtHnk.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(khHenkouUktkYendtHnk);

                dataIns.add(khHenkouUktkYendtHnk);

                khHnkUktkOutKensuu = khHnkUktkOutKensuu + 1;
                khHnkUktkYendtHnkOutKensuu = khHnkUktkYendtHnkOutKensuu + 1;

                detachAllEntity(checkYuukouJyoutai, khTttHntiKykBean.getSyono());
            }
        }

        if (editKhMisslstParamLst.size() > 0) {

            khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);

            C_SyoruiCdKbn[] syoruiCdKbnLst = new C_SyoruiCdKbn[1];

            syoruiCdKbnLst[0] = C_SyoruiCdKbn.KK_YENDTHNKSEL_MISSLIST;

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbnLst, C_YouhiKbn.YOU);
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0020, String.valueOf(yendthnkInKensuu)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(khHnkUktkOutKensuu), "保全変更受付テーブル"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(khHnkUktkYendtHnkOutKensuu), "保全変更受付内容（円建変更）テーブル"));
    }

    private BM_YoteiRiritu3 getYoteiRiritu3(List<BM_YoteiRiritu3> pYoteiRiritu3Lst, String pSyouhnCd) {

        for(BM_YoteiRiritu3 yoteiRiritu3 : pYoteiRiritu3Lst){
            if(yoteiRiritu3.getSyouhncd().equals(pSyouhnCd)){
                return yoteiRiritu3;
            }
        }
        return null;
    }

    private int editKhMisslst(int pMissListOutKensuu, String pSyono, C_Dbhanei pDbhanei, String pMissListMsg,
        List<EditKhMisslstParam> pEditKhMisslstParamLst) {

        int missListOutKensuu = pMissListOutKensuu + 1;

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(missListOutKensuu);

        editKhMisslstParam.setSeqNo(missListOutKensuu);

        editKhMisslstParam.setSyoNo(pSyono);

        editKhMisslstParam.setDBhaneikbn(pDbhanei);

        editKhMisslstParam.setMisslistMsg(pMissListMsg);

        pEditKhMisslstParamLst.add(editKhMisslstParam);

        return missListOutKensuu;
    }

    private void detachAllEntity(CheckYuukouJyoutai pCheckYuukouJyoutai, String pSyono) {

        pCheckYuukouJyoutai.detachAllEntities(pSyono);
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessInLoopSet) {
            haitouDetachProcess.detach();
        }
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessOutLoopSet) {
            haitouDetachProcess.detach();
        }
        haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();
    }

    private String editMisslistmsg(String pSyono) {

        String setteiyouMissListMsg = "";

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyono);

        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(
            bzGetProcessSummaryInBean);

        List<BzGetProcessSummaryOutBean> syoritaskLst = bzGetProcessSummaryOutBeanLst;

        C_UmuKbn uketukeblnk = C_UmuKbn.NONE;

        for (BzGetProcessSummaryOutBean syoritask : syoritaskLst) {

            String jimutetuzukicd = syoritask.getJimuTetuzukiCd();

            String syoritaskid = syoritask.getNowNodoId();

            if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(jimutetuzukicd)) {

                if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(syoritaskid)) {

                    uketukeblnk = C_UmuKbn.ARI;
                }
            }
        }

        if (C_UmuKbn.ARI.eq(uketukeblnk)) {

            setteiyouMissListMsg = MessageUtil.getMessage("EIA1030");
        }
        else {

            setteiyouMissListMsg = MessageUtil.getMessage("EIA1029");
        }

        return setteiyouMissListMsg;
    }

    private boolean checkKhHenkouUktkYyk(List<KhHenkouUktkYykBean> pKhHenkouUktkYykBeanLst, String pSyono,
        C_UktkSyoriKbn pUktkSyoriKbn) {

        for (KhHenkouUktkYykBean khHenkouUktkYykBean : pKhHenkouUktkYykBeanLst) {
            if (khHenkouUktkYykBean.getSyono().equals(pSyono)
                && khHenkouUktkYykBean.getUktksyorikbn().eq(pUktkSyoriKbn)) {
                return true;
            }
        }

        return false;
    }

    private <T> T getInjectInstanceForInLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessInLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }

    private <T> T getInjectInstanceForOutLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessOutLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
