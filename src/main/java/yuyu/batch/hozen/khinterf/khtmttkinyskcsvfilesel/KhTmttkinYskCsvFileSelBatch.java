package yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesel.dba.KhTmttkinYskCsvFileSelBean;
import yuyu.batch.hozen.khinterf.khtmttkinyskcsvfilesel.dba.KhTmttkinYskCsvFileSelDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyouhnBunruiTmttkinyskKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Sets;

/**
 * 契約保全 インターフェース 積立金予測ＣＳＶファイル抽出
 */
public class KhTmttkinYskCsvFileSelBatch implements Batch{

    private static final String TYSYTTAISYOU_TABLE_ID = ZT_SinBosyuuDrtenHoyuuKykRn.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Bz001";

    private Set<String> kensakuKeySet = Sets.newHashSet();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhTmttkinYskCsvFileSelDao khTmttkinYskCsvFileSelDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        int syoriTaisyoukykTysytKensuu = 0;
        int tourokuKensuu = 0;
        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        List<IM_Syorijtkahi> syorijtkahiLst = hozenDomManager.getSyorijtkahiByKinouidYuukoujyotaikahikbn(
            IKhozenCommonConstants.KINOUID_KHTMTTKINYSKCSVFILESEL, C_YuukoujyotaikahiKbn.HUKA);

        for (IM_Syorijtkahi syoriJtKahi : syorijtkahiLst) {

            String syoriJimuttdkCd = syoriJtKahi.getSyorijimuttdkcd();

            String syoriTaskid = syoriJtKahi.getSyoritaskid();

            String kensakuKey = syoriJimuttdkCd + syoriTaskid;

            kensakuKeySet.add(kensakuKey);
        }

        List<IW_TmttkinYskWk> tmttkinYskWkLst = hozenDomManager.getAllTmttkinYskWk();

        hozenDomManager.delete(tmttkinYskWkLst);

        hozenDomManager.flush();

        try (ExDBResults<KhTmttkinYskCsvFileSelBean> khTmttkinYskCsvFileSelBeanLst = khTmttkinYskCsvFileSelDao
            .getTmttkinYskKykBeans(bzBatchParam.getIbKakutyoujobcd(), syoriYmd);

            EntityInserter<IW_TmttkinYskWk> tmttkinYskWkInserter = new EntityInserter<>();){

            for (KhTmttkinYskCsvFileSelBean khTmttkinYskCsvFileSelBean : khTmttkinYskCsvFileSelBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khTmttkinYskCsvFileSelBean.getZrnsyono());

                syoriTaisyoukykTysytKensuu++;

                C_KahiKbn kahiKbn = syoriJyotaiChk(khTmttkinYskCsvFileSelBean.getZrnsyono());

                if (C_KahiKbn.HUKA.eq(kahiKbn)) {

                    continue;
                }

                C_SyouhnBunruiTmttkinyskKbn syouhnBunruiTmttkinyskKbn = syouhnBunruiHantei(
                    khTmttkinYskCsvFileSelBean.getSyouhncd(),
                    khTmttkinYskCsvFileSelBean.getTmttknhaibunjyoutai(),
                    khTmttkinYskCsvFileSelBean.getTeikishrtkykhukaumu());

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(khTmttkinYskCsvFileSelBean.getKyktuukasyu());

                IW_TmttkinYskWk tmttkinYskWk = new IW_TmttkinYskWk();

                tmttkinYskWk.setSyono(khTmttkinYskCsvFileSelBean.getZrnsyono());
                tmttkinYskWk.setSyouhnbunruitmttkinyskkbn(syouhnBunruiTmttkinyskKbn);
                tmttkinYskWk.setKyktuukasyu(khTmttkinYskCsvFileSelBean.getKyktuukasyu());
                tmttkinYskWk.setKykymd(BizDate.valueOf(khTmttkinYskCsvFileSelBean.getZrnkykymd()));
                tmttkinYskWk.setKyksjkkktyouseiriritu(khTmttkinYskCsvFileSelBean.getKyksjkkktyouseiriritu());
                tmttkinYskWk.setTargettkhkumu(khTmttkinYskCsvFileSelBean.getTargettkhkumu());
                tmttkinYskWk.setTargettkmokuhyouti(khTmttkinYskCsvFileSelBean.getTargettkmokuhyouti());
                tmttkinYskWk.setKyktuukap(BizCurrency.valueOf(
                    new BigDecimal(khTmttkinYskCsvFileSelBean.getZrnitijibrpgaika().toString()), currencyType));
                tmttkinYskWk.setKyktuukatmttkngk(BizCurrency.valueOf(
                    new BigDecimal(khTmttkinYskCsvFileSelBean.getZrntmttkngaika().toString()), currencyType));
                tmttkinYskWk.setKyktuukakaiyakuhrgk(BizCurrency.valueOf(
                    new BigDecimal(khTmttkinYskCsvFileSelBean.getZrnkaiyakuhrkngaika().toString()), currencyType));
                tmttkinYskWk.setGyoumuKousinKinou(kinouId);
                tmttkinYskWk.setGyoumuKousinsyaId(userId);
                tmttkinYskWk.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(tmttkinYskWk);

                tmttkinYskWkInserter.add(tmttkinYskWk);

                tourokuKensuu++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(syoriTaisyoukykTysytKensuu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(tourokuKensuu)));
    }

    private C_KahiKbn syoriJyotaiChk(String pSyono) {

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono,
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        skKihonLst = JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonLst);

        if (skKihonLst.size() > 0) {

            return C_KahiKbn.HUKA;
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummaryComparatorWorkListHyoujijun korkListHyoujijun = SWAKInjector.getInstance(
            BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(korkListHyoujijun);

        List<BzGetProcessSummaryOutBean> syoritaskLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean syoritask : syoritaskLst) {

            String jimutetuzukiCd = syoritask.getJimuTetuzukiCd();

            String syoritaskId = syoritask.getNowNodoId();

            String kensakuKey = jimutetuzukiCd + syoritaskId;

            if (kensakuKeySet.contains(kensakuKey)) {

                return C_KahiKbn.HUKA;
            }
        }

        return C_KahiKbn.KA;
    }

    private C_SyouhnBunruiTmttkinyskKbn syouhnBunruiHantei(String pSyouhncd, C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai, C_UmuKbn pTeikishrtkykhukaumu) {

        C_SyouhnBunruiTmttkinyskKbn syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.BLNK;

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

            syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.JGRO;
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.JGRO2;
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pTmttknhaibunjyoutai)) {

                syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.TANOGRO_SISU;
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTmttknhaibunjyoutai)) {

                syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.TANOGRO_TEIRITU;
            }
        }
        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pTmttknhaibunjyoutai)) {

                syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.TANOGRO2_SISU;
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTmttknhaibunjyoutai)) {

                if (C_UmuKbn.NONE.eq(pTeikishrtkykhukaumu)) {

                    syouhnBunruiTmttkinyskKbn = C_SyouhnBunruiTmttkinyskKbn.TANOGRO2_TEIRITU_TEIKI_NASI;
                }
            }
        }
        return syouhnBunruiTmttkinyskKbn;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
