package yuyu.batch.hozen.khozen.tyohyouhonbankakunin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.tyohyouhonbankakunin.dba.TyohyouHonbanKakuninBatchDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.hozen.khcommon.CheckTyohyouHnbnKknSyouken;
import yuyu.common.hozen.khcommon.CheckTyohyouHnbnKknTtdkKanryou;
import yuyu.common.hozen.khcommon.HanteiKekkaBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TyohyouHonbanKakuninBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 帳票本番確認
 */
public class TyohyouHonbanKakuninBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final String TYOUHYOUYBDSKINOU_IDAKIAWASETYOUHYOU = "01";

    C_TokusyuSyoriNaiyouKbn tokusyuSyoriNaiyou = C_TokusyuSyoriNaiyouKbn.HONBANKAKUNINTAISYO;

    private KhozenCommonParam khozenCommonParam;

    private String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

    private List<C_SyoruiCdKbn> syoruiCdList = new ArrayList<>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private TyohyouHonbanKakuninBatchParam batchParam;

    @Inject
    private TyohyouHonbanKakuninBatchDao tyohyouHonbanKakuninBatchDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;


    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();
        String ibKakutyoujobCd = batchParam.getIbKakutyoujobcd();
        String reportYdKinou = batchParam.getTyouhyouybdskinou();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        syoruiCdList.add(C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI);
        syoruiCdList.add(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_STDRHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2);
        syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3);
        syoruiCdList.add(C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR);
        syoruiCdList.add(C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR);

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        int khtyouhyouHonbanCount = 0;

        if (TYOUHYOUYBDSKINOU_IDAKIAWASETYOUHYOU.equals(reportYdKinou)) {

            List<TyohyouHonbanKakuninBean> khTyouhyouHonbanHknList = new ArrayList<>();
            List<TyohyouHonbanKakuninBean> khTyouhyouHonbanTtdkkrList = new ArrayList<>();
            List<TyohyouHonbanKakuninBean> khTyouhyouHonbanUbdList = new ArrayList<>();

            khTyouhyouHonbanHknList = getTyohyouHonbanJyoken(C_TyouhyouBunruiKbn.SYOUKEN);

            khTyouhyouHonbanTtdkkrList = getTyohyouHonbanJyoken(C_TyouhyouBunruiKbn.TTDKKR);

            int hokenSyoukenCnt = 0;
            int ttdkKanCnt = 0;
            int sinBoreroCnt = 0;

            if (khTyouhyouHonbanHknList.size() > 0 || khTyouhyouHonbanTtdkkrList.size() > 0) {
                try (
                    ExDBUpdatableResults<IT_KykKihon> kykKihonLst =
                    tyohyouHonbanKakuninBatchDao.getKykKihonInfos(ibKakutyoujobCd, syoriYmd.toString() + "000000000");
                    MultipleEntityUpdater dataUpd = new MultipleEntityUpdater();) {

                    for (IT_KykKihon kykKihon : kykKihonLst) {

                        boolean ttdkKanUpdFlg = false;
                        boolean sinBoreroUpdFlg = false;
                        boolean saiBoreroUpdFlg = false;

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                        bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(syoriYmd);

                        if (khTyouhyouHonbanHknList.size() > 0) {
                            if (hokenSyouken != null) {

                                HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknSyouken.exec(
                                    kykKihon, hokenSyouken, khTyouhyouHonbanHknList);

                                if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getUpdateKbn())) {

                                    if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getSinBoreroKbn())) {
                                        sinBoreroCnt = sinBoreroCnt + 1;
                                        sinBoreroUpdFlg = true;
                                    }

                                    if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getSaiBoreroKbn())) {
                                        saiBoreroUpdFlg = true;
                                    }

                                    if ((sinBoreroUpdFlg && sinBoreroCnt <= 5) ||
                                        saiBoreroUpdFlg) {

                                        updTokusyuSyoriNaiyou(hokenSyouken);
                                        hokenSyouken.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
                                        hokenSyouken.setGyoumuKousinKinou(kinouId);
                                        hokenSyouken.setGyoumuKousinsyaId(userId);
                                        hokenSyouken.setGyoumuKousinTime(sysDateTimeMilli);

                                        if (C_UmuKbn.ARI.eq(hokenSyouken.getKanryoutuutiumukbn())) {
                                            ttdkKanUpdFlg = true;
                                        }
                                    }
                                    hokenSyoukenCnt++;
                                }

                                if (hanteiKekkaBean.getTyohyouHonbanKakuninBeanList() != null &&
                                    hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size() > 0) {

                                    khTyouhyouHonbanUbdList.addAll(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList());
                                }
                            }
                        }

                        List<IT_TtdkKan>  ttdkKanLst = kykKihon.getTtdkKansByTyouhyouymd(syoriYmd);

                        if (khTyouhyouHonbanTtdkkrList.size() > 0) {
                            for (IT_TtdkKan ttdkKan : ttdkKanLst) {

                                C_SyoruiCdKbn filtersyoruiCd = ttdkKan.getSyoruiCd();

                                if (!syoruiCdList.contains(filtersyoruiCd)) {

                                    continue;
                                }

                                HanteiKekkaBean hanteiKekkaBean = CheckTyohyouHnbnKknTtdkKanryou.exec(
                                    kykKihon, ttdkKan, khTyouhyouHonbanTtdkkrList);

                                if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getUpdateKbn())) {

                                    if (!C_HassouKbn.HONSYAKAISOU.eq(ttdkKan.getHassoukbn())) {

                                        ttdkKan.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
                                        ttdkKan.setGyoumuKousinKinou(kinouId);
                                        ttdkKan.setGyoumuKousinsyaId(userId);
                                        ttdkKan.setGyoumuKousinTime(sysDateTimeMilli);
                                        ttdkKanCnt++;
                                    }

                                    if (hokenSyouken != null && !ttdkKanUpdFlg &&
                                        ttdkKan.getHenkousikibetukey().equals(hokenSyouken.getHenkousikibetukey())) {

                                        updTokusyuSyoriNaiyou(hokenSyouken);
                                        hokenSyouken.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
                                        hokenSyouken.setGyoumuKousinKinou(kinouId);
                                        hokenSyouken.setGyoumuKousinsyaId(userId);
                                        hokenSyouken.setGyoumuKousinTime(sysDateTimeMilli);
                                        hokenSyoukenCnt++;
                                    }
                                }
                                else {

                                    if (ttdkKanUpdFlg && !C_HassouKbn.HONSYAKAISOU.eq(ttdkKan.getHassoukbn()) &&
                                        ttdkKan.getHenkousikibetukey().equals(hokenSyouken.getHenkousikibetukey())) {

                                        ttdkKan.setHassoukbn(C_HassouKbn.HONSYAKAISOU);
                                        ttdkKan.setGyoumuKousinKinou(kinouId);
                                        ttdkKan.setGyoumuKousinsyaId(userId);
                                        ttdkKan.setGyoumuKousinTime(sysDateTimeMilli);
                                        ttdkKanCnt++;
                                    }
                                }

                                if (hanteiKekkaBean.getTyohyouHonbanKakuninBeanList() != null &&
                                    hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size() > 0) {

                                    khTyouhyouHonbanUbdList.addAll(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList());
                                }
                            }
                        }
                    }

                    if (khTyouhyouHonbanUbdList.size() > 0) {
                        HashSet<TyohyouHonbanKakuninBean>  khTyouhyouHonbanUbdListSet = new HashSet<TyohyouHonbanKakuninBean>();

                        khTyouhyouHonbanUbdListSet.addAll(khTyouhyouHonbanUbdList);

                        khTyouhyouHonbanUbdList.clear();

                        khTyouhyouHonbanUbdList.addAll(khTyouhyouHonbanUbdListSet);

                        for (TyohyouHonbanKakuninBean khTyouhyouHonbanUbd : khTyouhyouHonbanUbdList) {

                            IT_KhTyouhyouHonbanKakunin khTyouhyouHonbanKakunin = hozenDomManager.getKhTyouhyouHonbanKakunin(
                                khTyouhyouHonbanUbd.getTyouhyoubunrui(),
                                khTyouhyouHonbanUbd.getSyoruiCd(), khTyouhyouHonbanUbd.getJyoukenbunrui1(),
                                khTyouhyouHonbanUbd.getJyoukenbunrui2(), khTyouhyouHonbanUbd.getJyoukenbunrui3());

                            if (!C_KakuninjyoutaiKbn.KAKUNINZUMI.eq(khTyouhyouHonbanKakunin.getKakuninjyoutaikbn())) {

                                khTyouhyouHonbanKakunin.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.KAKUNINZUMI);
                                khTyouhyouHonbanKakunin.setFirstkaisouymd(syoriYmd);
                                khTyouhyouHonbanKakunin.setHonbankakuninymd(syoriYmd);
                                khTyouhyouHonbanKakunin.setGyoumuKousinKinou(kinouId);
                                khTyouhyouHonbanKakunin.setGyoumuKousinsyaId(userId);
                                khTyouhyouHonbanKakunin.setGyoumuKousinTime(sysDateTimeMilli);

                                dataUpd.add(khTyouhyouHonbanKakunin);

                                khtyouhyouHonbanCount++;
                            }
                        }
                    }

                    bzRecoveryDatasikibetuBean.initializeBlank();
                }
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(hokenSyoukenCnt),
                "保険証券テーブル"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(ttdkKanCnt),
                "手続完了通知テーブル"));

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(khtyouhyouHonbanCount),
            "契約保全帳票本番テーブル"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private List<TyohyouHonbanKakuninBean> getTyohyouHonbanJyoken(C_TyouhyouBunruiKbn pTyouhyouBunruiKbn) {

        return tyohyouHonbanKakuninBatchDao.getKhTyouhyouHonbanKakuninMikakuninInfos(pTyouhyouBunruiKbn,
            batchParam.getSyoriYmd());
    }

    private void updTokusyuSyoriNaiyou(IT_HokenSyouken pHokenSyouken) {

        if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn1())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn1(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn2())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn2(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn3())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn3(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn4())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn4(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn5())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn5(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn6())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn6(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn7())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn7(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn8())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn8(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn9())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn9(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn10())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn10(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn11())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn11(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn12())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn12(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn13())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn13(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn14())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn14(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn15())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn15(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn16())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn16(tokusyuSyoriNaiyou);
        }
        else if (C_TokusyuSyoriNaiyouKbn.BLNK.eq(pHokenSyouken.getTokusyusyorinaiyoukbn17())) {
            pHokenSyouken.setTokusyusyorinaiyoukbn17(tokusyuSyoriNaiyou);
        }
    }
}
