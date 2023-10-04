package yuyu.batch.hozen.khinterf.khheijunbaraiinfosel;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Sets;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khheijunbaraiinfosel.dba.HeijunbaraiInfoBean;
import yuyu.batch.hozen.khinterf.khheijunbaraiinfosel.dba.KhHeijunbaraiInfoSelDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 平準払情報抽出
 */
public class KhHeijunbaraiInfoSelBatch implements Batch {

    private final static String TABLEID = IT_KykKihon.TABLE_NAME;

    private final static String FILTERID = "Kh001";

    private static final String KZKP_YOKUGETU_JYUTOUYOTEI_JNINFOSKS = "継続Ｐ翌月充当予定情報作成";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private KhHeijunbaraiInfoSelDao khHeijunbaraiInfoSelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    private BizDate syoriYMD;

    private String kinouId;

    private String userId;

    private Set<String> syorihukaInfoSet = Sets.newHashSet();

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long khHeijunbaraiInfoSelCount = 0;
        long count = 0;
        String kinouNm = kinou.getKinouNm();
        kinouId = kinou.getKinouId();
        userId = baseUserInfo.getUserId();
        syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        try (ExDBResults<HeijunbaraiInfoBean> heijunbaraiInfoBeanList = khHeijunbaraiInfoSelDao
            .getHeijunbaraiInfoByKakutyoujobcdTysytkijyunkykymd(kakutyoujobCd, syoriYMD.getBizDateYM().getLastDay());
            EntityInserter<IW_KhKzkPYokuJyuutouYoteiWk> entityInserter = new EntityInserter<>();) {

            khHeijunbaraiInfoSelDao.deleteKhKzkPYokuJyuutouYoteiWk();

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            C_ErrorKbn errorKbn = C_ErrorKbn.OK;
            errorKbn = getKawaseRate.exec(syoriYMD.getBizDateYM().getLastDay(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                C_Tuukasyu.USD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, kinouNm));
            }
            BizNumber usdKawaserate = getKawaseRate.getKawaserate();

            errorKbn = getKawaseRate.exec(syoriYMD.getBizDateYM().getLastDay(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                C_Tuukasyu.AUD,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, kinouNm));
            }
            BizNumber audKawaserate = getKawaseRate.getKawaserate();

            List<IM_Syorijtkahi> syorijtkahiLst = hozenDomManager.getSyorijtkahiByKinouidYuukoujyotaikahikbn(
                IKhozenCommonConstants.KINOUID_KHHEIJUNBARAIINFOSEL, C_YuukoujyotaikahiKbn.HUKA);

            for (IM_Syorijtkahi syoriJtKahi : syorijtkahiLst) {

                String jimutetuzukiCd = syoriJtKahi.getSyorijimuttdkcd();
                String syoritaskId = syoriJtKahi.getSyoritaskid();
                String kensakuKey = jimutetuzukiCd + syoritaskId;
                syorihukaInfoSet.add(kensakuKey);
            }

            for (HeijunbaraiInfoBean heijunbaraiInfoBean : heijunbaraiInfoBeanList) {

                IT_KykKihon kykKihon = heijunbaraiInfoBean.getKykKihon();
                IT_AnsyuKihon ansyuKihon = heijunbaraiInfoBean.getAnsyuKihon();

                khHeijunbaraiInfoSelCount++;
                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
                BizNumber kawaserate = BizNumber.valueOf(0);
                if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                    kawaserate = usdKawaserate;
                }
                else {
                    kawaserate = audKawaserate;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykSyouhn.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykSyouhn.getSyono());

                boolean result = kzkpYokugetuJyutouyotei(kykSyouhn, ansyuKihon, kawaserate, kykKihon, entityInserter);
                if (result) {
                    count++;
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger
        .info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(khHeijunbaraiInfoSelCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));

    }

    private boolean kzkpYokugetuJyutouyotei(IT_KykSyouhn pKykSyouhn, IT_AnsyuKihon pAnsyuKihon, BizNumber pKawaserate,
        IT_KykKihon pKykKihon, EntityInserter<IW_KhKzkPYokuJyuutouYoteiWk> pEntityInserter) {

        if (BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
            pKykSyouhn.getHaraimanymd().getBizDateYM()) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
                pKykSyouhn.getHaraimanymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {

            return false;
        }

        BizDate syoumetuYmd = BizDate.valueOf(pAnsyuKihon.getJkipjytym().addMonths(3).getRekijyou(), 1);

        if (BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
            syoumetuYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
                syoumetuYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {

            SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
            setYuuyokknmanryobi.exec(pAnsyuKihon.getSyono(), pAnsyuKihon.getJkipjytym());
            syoumetuYmd = setYuuyokknmanryobi.getSyoumetubi();

            if (BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
                syoumetuYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER
                || BizDateUtil.compareYm(syoriYMD.getNextMonth().getBizDateYM(),
                    syoumetuYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {

                return false;
            }
        }

        if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {

            if (C_Kykjyoutai.ZENNOU.eq(pKykSyouhn.getKykjyoutai())) {

                return false;
            }
            else if (C_Kykjyoutai.HRKMTYUU.eq(pKykSyouhn.getKykjyoutai())
                && syoriYMD.getNextMonth().getMonth() != pKykSyouhn.getKykymd().getMonth()) {

                return false;
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())
            && syoriYMD.getNextMonth().getMonth() != pKykSyouhn.getKykymd().getMonth()
            && syoriYMD.getNextMonth().getMonth() != pKykSyouhn.getKykymd().addMonths(6).getMonth()) {

            return false;
        }

        C_KahiKbn kahiKbn = syoriJyotaiChk(pKykSyouhn.getSyono(), syorihukaInfoSet);

        if (C_KahiKbn.HUKA.eq(kahiKbn)) {

            return false;
        }

        BizCurrency kyktuukaHrkp = BizCurrency.valueOf(0);
        IT_KykSonotaTkyk kykSonotaTkyk = pKykKihon.getKykSonotaTkyk();
        if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {

            KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
            C_ErrorKbn kekkakbn = keisanGaikaP.execKawaseSitei(pKykSyouhn.getHokenryou(), pKykSyouhn.getKyktuukasyu(),
                pKawaserate);
            if (C_ErrorKbn.ERROR.eq(kekkakbn)) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    KZKP_YOKUGETU_JYUTOUYOTEI_JNINFOSKS));
            }
            kyktuukaHrkp = keisanGaikaP.getP();
        }
        else {

            kyktuukaHrkp = pKykSyouhn.getHokenryou();
        }

        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);
        C_ErrorKbn errorKbn = convNenSaiManki.convHknkknNen(pKykSyouhn.getHknkkn(), pKykSyouhn.getHknkknsmnkbn(),
            pKykSyouhn.getHhknnen());
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129
                , KZKP_YOKUGETU_JYUTOUYOTEI_JNINFOSKS));
        }
        Integer hknkknNen = convNenSaiManki.getHknkknNen();

        IW_KhKzkPYokuJyuutouYoteiWk khKzkPYokuJyuutouYoteiWk = new IW_KhKzkPYokuJyuutouYoteiWk();

        khKzkPYokuJyuutouYoteiWk.setKbnkey(pKykSyouhn.getKbnkey());
        khKzkPYokuJyuutouYoteiWk.setSyono(pKykSyouhn.getSyono());
        khKzkPYokuJyuutouYoteiWk.setSyouhncd(pKykSyouhn.getSyouhncd());
        khKzkPYokuJyuutouYoteiWk.setKyktuukasyu(pKykSyouhn.getKyktuukasyu());
        khKzkPYokuJyuutouYoteiWk.setKykym(pKykSyouhn.getKykymd().getBizDateYM());
        khKzkPYokuJyuutouYoteiWk.setJyuutouym(syoriYMD.getNextMonth().getBizDateYM());
        khKzkPYokuJyuutouYoteiWk.setHknkkn(hknkknNen);
        khKzkPYokuJyuutouYoteiWk.setHokenryou(kyktuukaHrkp);
        khKzkPYokuJyuutouYoteiWk.setKousinsyaId(userId);
        khKzkPYokuJyuutouYoteiWk.setKousinTime(BizDate.getSysDateTimeMilli());
        khKzkPYokuJyuutouYoteiWk.setKousinKinou(kinouId);
        BizPropertyInitializer.initialize(khKzkPYokuJyuutouYoteiWk);
        pEntityInserter.add(khKzkPYokuJyuutouYoteiWk);

        return true;
    }

    private C_KahiKbn syoriJyotaiChk(String pSyono, Set<String> pSyorihukaInfoSet) {

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono,
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        skKihonLst = JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonLst);

        if (skKihonLst.size() > 0) {

            return C_KahiKbn.HUKA;
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummaryComparatorWorkListHyoujijun workListHyoujijun = SWAKInjector.getInstance(
            BzGetProcessSummaryComparatorWorkListHyoujijun.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(workListHyoujijun);
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

        List<BzGetProcessSummaryOutBean> syoritaskLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean syoritask : syoritaskLst) {

            String jimutetuzukiCd = syoritask.getJimuTetuzukiCd();
            String syoritaskId = syoritask.getNowNodoId();
            String kensakuKey = jimutetuzukiCd + syoritaskId;

            if (pSyorihukaInfoSet.contains(kensakuKey)) {

                return C_KahiKbn.HUKA;
            }
        }

        return C_KahiKbn.KA;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}