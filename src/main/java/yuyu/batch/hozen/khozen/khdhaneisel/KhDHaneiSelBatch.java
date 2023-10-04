package yuyu.batch.hozen.khozen.khdhaneisel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khdhaneisel.dba.HaitoukinHanneiBean;
import yuyu.batch.hozen.khozen.khdhaneisel.dba.KhDHaneiSelDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.haitou.CheckDJyoutai;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.haitou.SetHokenNnd;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 配当金反映対象抽出
 */
public class KhDHaneiSelBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERID = "Kh001";

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhDHaneiSelDao khDHaneiSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        String kinouId = khozenCommonParam.getFunctionId();

        String kousinsyaId = khozenCommonParam.getUserID();

        String kousinTime = BizDate.getSysDateTimeMilli();


        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobcd));


        hozenDomManager.delete(hozenDomManager.getAllKhHaitouTaisyouWK());

        hozenDomManager.flush();


        BizDate syoriYokueigyoYmd = syoriYmd.addBusinessDays(1);

        BizDate syoriYmdZennen = syoriYmd.addYears(-1).getRekijyou();


        BizDate syoriYokueigyohiZennen = null;

        if (syoriYmdZennen.getBizDateY().isLeapYear() &&
            syoriYokueigyoYmd.getBizDateMD().compareTo(BizDateMD.valueOf(2, 28)) == 0) {

            syoriYokueigyohiZennen = syoriYokueigyoYmd.addYears(-1).getRekijyou().addDays(1);
        }
        else {
            syoriYokueigyohiZennen = syoriYokueigyoYmd.addYears(-1).getRekijyou();
        }


        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDateY syoriYokueigyohiJigyounendo = setKessanNensibi.exec(syoriYokueigyoYmd).getBizDateY();

        long haitoukinHanneiInkns = 0;

        long haitoukinSsyyuWkinfoOutkns = 0;

        try (
            ExDBResults<HaitoukinHanneiBean> haitoukinHanneiBeanLst = khDHaneiSelDao.getHaitoukinHanneiByKakutyoujobcd(
                syoriYokueigyohiZennen, syoriYokueigyohiJigyounendo, kakutyoujobcd);
            EntityInserter<IW_KhHaitouTaisyouWK> khHaitouTaisyouWKIns = new EntityInserter<>()) {

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            BizDate haitoushrKijyunYmd = null;
            BizDate yendtHnkYmd = null;

            for (HaitoukinHanneiBean haitoukinHanneiBean : haitoukinHanneiBeanLst) {


                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(haitoukinHanneiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(haitoukinHanneiBean.getSyono());

                haitoukinHanneiInkns = haitoukinHanneiInkns + 1;
                yendtHnkYmd = haitoukinHanneiBean.getYendthnkYmd();

                if (yendtHnkYmd != null) {

                    haitoushrKijyunYmd = yendtHnkYmd;
                }
                else {

                    haitoushrKijyunYmd = haitoukinHanneiBean.getKykYmd();
                }


                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(
                    BzGetProcessSummaryInBean.class);

                bzGetProcessSummaryInBean.setSyoNo(haitoukinHanneiBean.getSyono());
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(
                    bzGetProcessSummaryInBean);

                C_UmuKbn ukeFlg = C_UmuKbn.NONE;

                for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

                    String jimuTetuzukiCd = bzGetProcessSummaryOutBean.getJimuTetuzukiCd();
                    String syoriTaskId = bzGetProcessSummaryOutBean.getNowNodoId();


                    if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI.equals(jimuTetuzukiCd)) {

                        if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(syoriTaskId)) {
                            ukeFlg = C_UmuKbn.ARI;
                        }
                    }
                }


                if (C_UmuKbn.ARI.eq(ukeFlg)) {
                    detach();
                    continue;
                }



                C_UmuKbn umuKbn = checkKykMfHitounendo(haitoukinHanneiBean.getHaitouNendo(),
                    haitoukinHanneiBean.getKykYmd(), haitoukinHanneiBean.getYendthnkYmd(), syoriYokueigyoYmd);

                if (umuKbn == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }
                else if (C_UmuKbn.ARI.eq(umuKbn)) {

                    IW_KhHaitouTaisyouWK khHaitouTaisyouWK = new IW_KhHaitouTaisyouWK(haitoukinHanneiBean.getSyono(),
                        syoriYmd,
                        haitoukinHanneiBean.getHaitoukinUketorihouKbn(),
                        C_HaitoumeisaiKbn.SYU,
                        1);

                    khHaitouTaisyouWK.setHaitoujyoutaihanteikbn(C_HaitoujyoutaiHanteiKbn.MF_HUSEIGOU);
                    khHaitouTaisyouWK.setHaitoushrkijyunymd(haitoushrKijyunYmd);
                    khHaitouTaisyouWK.setHaitoukbn(haitoukinHanneiBean.getHaitouKbn());
                    khHaitouTaisyouWK.setKihons(haitoukinHanneiBean.getKihonS());
                    khHaitouTaisyouWK.setSyouhncd(haitoukinHanneiBean.getSyouhnCd());
                    khHaitouTaisyouWK.setRyouritusdno(haitoukinHanneiBean.getRyourituSdNo());
                    khHaitouTaisyouWK.setYoteiriritu(haitoukinHanneiBean.getYoteiRiritu());
                    khHaitouTaisyouWK.setHrkkaisuu(haitoukinHanneiBean.getHrkKaisuu());
                    khHaitouTaisyouWK.setHhknsei(haitoukinHanneiBean.getHhknSei());
                    khHaitouTaisyouWK.setHhknnen(haitoukinHanneiBean.getHhknNen());
                    khHaitouTaisyouWK.setHknkknsmnkbn(haitoukinHanneiBean.getHknkknSmnKbn());
                    khHaitouTaisyouWK.setHknkkn(haitoukinHanneiBean.getHknKkn());
                    khHaitouTaisyouWK.setHrkkkn(haitoukinHanneiBean.getHrkKkn());
                    khHaitouTaisyouWK.setKyktuukasyu(haitoukinHanneiBean.getTuukaSyu());
                    khHaitouTaisyouWK.setGyoumuKousinKinou(kinouId);
                    khHaitouTaisyouWK.setGyoumuKousinsyaId(kousinsyaId);
                    khHaitouTaisyouWK.setGyoumuKousinTime(kousinTime);
                    khHaitouTaisyouWK.setKykymd(haitoukinHanneiBean.getKykYmd());
                    khHaitouTaisyouWK.setKykjyoutai(haitoukinHanneiBean.getKykjyoutai());
                    khHaitouTaisyouWK.setDai1hknkkn(haitoukinHanneiBean.getDai1hknkkn());
                    khHaitouTaisyouWK.setHrkkknsmnkbn(haitoukinHanneiBean.getHrkkknsmnkbn());
                    BizPropertyInitializer.initialize(khHaitouTaisyouWK);

                    khHaitouTaisyouWKIns.add(khHaitouTaisyouWK);

                    haitoukinSsyyuWkinfoOutkns = haitoukinSsyyuWkinfoOutkns + 1;

                    detach();

                    continue;
                }

                CheckDJyoutai checkDJyoutai = getInjectInstanceForInLoop(CheckDJyoutai.class);
                C_HaitoujyoutaiHanteiKbn haitouJyoutaiHanteiKbn = checkDJyoutai.execForHaitouJyoutaiHantei(
                    syoriYokueigyoYmd, haitoukinHanneiBean.getKykYmd(), haitoukinHanneiBean.getYendthnkYmd(),
                    haitoukinHanneiBean.getHaitouNendo());

                if (C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI.eq(haitouJyoutaiHanteiKbn)) {
                    detach();
                    continue;
                }

                int lastHaitouNendo = 0;

                if (haitoukinHanneiBean.getHaitouNendo() == null) {

                    lastHaitouNendo = setKessanNensibi.exec(haitoukinHanneiBean.getKykYmd()).getYear();
                }
                else {

                    lastHaitouNendo = haitoukinHanneiBean.getHaitouNendo().getYear();
                }

                BizDateY keisandNendo = BizDateY.valueOf(lastHaitouNendo).addYears(1);

                IW_KhHaitouTaisyouWK khHaitouTaisyouWK = new IW_KhHaitouTaisyouWK(haitoukinHanneiBean.getSyono(),
                    syoriYmd,
                    haitoukinHanneiBean.getHaitoukinUketorihouKbn(),
                    C_HaitoumeisaiKbn.SYU,
                    1);

                khHaitouTaisyouWK.setHaitoujyoutaihanteikbn(haitouJyoutaiHanteiKbn);
                khHaitouTaisyouWK.setHaitoushrkijyunymd(haitoushrKijyunYmd);
                khHaitouTaisyouWK.setHaitoukbn(haitoukinHanneiBean.getHaitouKbn());
                khHaitouTaisyouWK.setKihons(haitoukinHanneiBean.getKihonS());
                khHaitouTaisyouWK.setSyouhncd(haitoukinHanneiBean.getSyouhnCd());
                khHaitouTaisyouWK.setRyouritusdno(haitoukinHanneiBean.getRyourituSdNo());
                khHaitouTaisyouWK.setYoteiriritu(haitoukinHanneiBean.getYoteiRiritu());
                khHaitouTaisyouWK.setHrkkaisuu(haitoukinHanneiBean.getHrkKaisuu());
                khHaitouTaisyouWK.setHhknsei(haitoukinHanneiBean.getHhknSei());
                khHaitouTaisyouWK.setHhknnen(haitoukinHanneiBean.getHhknNen());
                khHaitouTaisyouWK.setHknkknsmnkbn(haitoukinHanneiBean.getHknkknSmnKbn());
                khHaitouTaisyouWK.setHknkkn(haitoukinHanneiBean.getHknKkn());
                khHaitouTaisyouWK.setHrkkkn(haitoukinHanneiBean.getHrkKkn());
                khHaitouTaisyouWK.setKeisandnendo(keisandNendo);
                khHaitouTaisyouWK.setKyktuukasyu(haitoukinHanneiBean.getTuukaSyu());
                khHaitouTaisyouWK.setGyoumuKousinKinou(kinouId);
                khHaitouTaisyouWK.setGyoumuKousinsyaId(kousinsyaId);
                khHaitouTaisyouWK.setGyoumuKousinTime(kousinTime);
                khHaitouTaisyouWK.setKykymd(haitoukinHanneiBean.getKykYmd());
                khHaitouTaisyouWK.setKykjyoutai(haitoukinHanneiBean.getKykjyoutai());
                khHaitouTaisyouWK.setDai1hknkkn(haitoukinHanneiBean.getDai1hknkkn());
                khHaitouTaisyouWK.setHrkkknsmnkbn(haitoukinHanneiBean.getHrkkknsmnkbn());

                BizPropertyInitializer.initialize(khHaitouTaisyouWK);

                khHaitouTaisyouWKIns.add(khHaitouTaisyouWK);

                haitoukinSsyyuWkinfoOutkns = haitoukinSsyyuWkinfoOutkns + 1;
                detach();
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(haitoukinHanneiInkns)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haitoukinSsyyuWkinfoOutkns),
            "配当金算出用ワーク情報テーブル"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private C_UmuKbn checkKykMfHitounendo(BizDateY pKykMfHaitouNendo, BizDate pKykYmd, BizDate pYendtHnkYmd,
        BizDate pSyoriYmd) {

        BizDate haitoushrKijyunYmd = null;
        BizDateY syoriYmdhaitouNendo = null;
        BizDateY kykMfHaitouNendo = null;
        SetHokenNnd setHokenNnd = getInjectInstanceForInLoop(SetHokenNnd.class);

        if (pKykMfHaitouNendo == null) {

            HokenNndBean hokenNndBean = setHokenNnd.exec(pKykYmd, pKykYmd);
            if (hokenNndBean == null) {

                return null;
            }

            kykMfHaitouNendo = hokenNndBean.getHokenNnd();

        }
        else {

            kykMfHaitouNendo = pKykMfHaitouNendo;
        }

        if (pYendtHnkYmd == null) {

            haitoushrKijyunYmd = pKykYmd;
        }
        else {

            haitoushrKijyunYmd = pYendtHnkYmd;
        }

        HokenNndBean hokenNndBean = setHokenNnd.exec(haitoushrKijyunYmd, pSyoriYmd);
        if (hokenNndBean == null) {

            return null;
        }

        syoriYmdhaitouNendo = hokenNndBean.getHokenNnd();

        if (kykMfHaitouNendo.compareTo(syoriYmdhaitouNendo) > 0) {

            return C_UmuKbn.ARI;
        }

        return C_UmuKbn.NONE;
    }

    private void detach() {
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessInLoopSet) {
            haitouDetachProcess.detach();
        }
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessOutLoopSet) {
            haitouDetachProcess.detach();
        }
        haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();
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

}
