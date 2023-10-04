package yuyu.batch.hozen.khinterf.khdairitengtmtzndkinfofsks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khdairitengtmtzndkinfofsks.dba.DairitenGtmtZndkInfosBean;
import yuyu.batch.hozen.khinterf.khdairitengtmtzndkinfofsks.dba.KhDairitenGtmtZndkInfoFSksDao;
import yuyu.batch.hozen.khinterf.khdairitengtmtzndkinfofsks.dba.KhHenkouUktkBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.result.bean.SumNyknJissekiRirekiBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 普保Ⅱ代理店月末残高情報Ｆ作成クラス
 */
public class KhDairitenGtmtZndkInfoFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    private final String TUUKA_USD = "01";

    private final String TUUKA_AUD = "15";

    private final String TUUKA_JPY = "17";

    private final String HRKHOUHOU_ITIJI = "1";

    private final String HRKHOUHOU_NEN = "5";

    private final String HRKHOUHOU_HALFY = "6";

    private final String HRKHOUHOU_TUKI = "8";

    private final String HRKHOUHOU_ZENNOU = "Z";

    private final String HRKKAISUU_ITIJI = "0";

    private final String HRKKAISUU_NEN = "1";

    private final String HRKKAISUU_HALFY = "2";

    private final String HRKKAISUU_TUKI = "3";

    private final String YENKANSAN_HKNKAISYA = "2";

    private final String SONEKICALCFLG_ERR = "1";

    private final String SONEKICALCFLG_KOSYA_SEIJYOU = "0";

    private final String SONEKICALCFLG_KOSYA_KEISANWHUYOU = "1";

    private final String SONEKICALCFLG_KOSYA_KEISANWERR = "2";

    private final String SONEKICALCFLG_KOSYA_YENDTHNKZUMI = "3";

    private final String SONEKICALCFLG_KOSYA_GNGKPHNDARI = "4";

    private final int YEAR_10_TUKIKANSAN = 120;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private KhDairitenGtmtZndkInfoFSksDao khDairitenGtmtZndkInfoFSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        long sonekiCalchunouKensuu = 0;
        long sonekiHunouCntSmbcKeisanWHuyou = 0;
        long sonekiHunouCntSmbcKeisanWErr = 0;
        long sonekiHunouCntSmbcYendthnkZumi = 0;
        long sonekiHunouCntSmbcGngkPhndAri = 0;
        long sonekiHunouCntSmtbKeisanWHuyou = 0;
        long sonekiHunouCntSmtbKeisanWErr = 0;
        long sonekiHunouCntSmtbGngkPhndAri = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(ibKakutyoujobcd)));

        BizNumber gmeigyoubijiYenShrRateUSD = BizNumber.valueOf(0);
        BizNumber gmeigyoubijiYenShrRateAUD = BizNumber.valueOf(0);
        BizNumber gmeigyoubijiKawaserateUSD = BizNumber.valueOf(0);
        BizNumber gmeigyoubijiKawaserateAUD = BizNumber.valueOf(0);
        BizNumber gmeigyoubijiYenNyknRateUSD = BizNumber.valueOf(0);
        BizNumber gmeigyoubijiYenNyknRateAUD = BizNumber.valueOf(0);

        gmeigyoubijiYenShrRateUSD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);
        gmeigyoubijiYenShrRateAUD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);

        gmeigyoubijiKawaserateUSD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);
        gmeigyoubijiKawaserateAUD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);

        gmeigyoubijiYenNyknRateUSD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.YOU);
        gmeigyoubijiYenNyknRateAUD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.YOU);

        try (ExDBResults<DairitenGtmtZndkInfosBean> dairitenGtmtZndkInfosBeanLst =
            khDairitenGtmtZndkInfoFSksDao.getDairitenGtmtZndkInfos(ibKakutyoujobcd);
            EntityInserter<ZT_DairitenGtmtZndkTy> dairitenGtmtZndkTyInserter = new EntityInserter<>();) {

            KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
            KeisanKaiyakuBean keisanKaiyakuBean = null;
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
            KeisanWKijunYM keisanWKijunYM = null;

            for (DairitenGtmtZndkInfosBean dairitenGtmtZndkInfosBean : dairitenGtmtZndkInfosBeanLst) {

                IT_KykKihon kykKihon = dairitenGtmtZndkInfosBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = dairitenGtmtZndkInfosBean.getKykSyouhn();
                IT_KykSonotaTkyk kykSonotaTkyk = dairitenGtmtZndkInfosBean.getKykSonotaTkyk();
                IT_KykSya kykSya = dairitenGtmtZndkInfosBean.getKykSya();
                IT_HhknSya hhknSya = dairitenGtmtZndkInfosBean.getHhknSya();
                IT_AnsyuKihon ansyuKihon = dairitenGtmtZndkInfosBean.getAnsyuKihon();
                String syono = kykKihon.getSyono();

                if(BizDateUtil.compareYmd(syoriYmd, kykKihon.getSeirituymd()) == BizDateUtil.COMPARE_LESSER ){
                    continue;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                C_Hrkkaisuu hrkKaisuu = kykKihon.getHrkkaisuu();
                BizDate fstPNyknYmd = kykKihon.getFstpnyknymd();
                C_TkiktbrisyuruiKbn tikiktbriSyuruiKbn = kykKihon.getTikiktbrisyuruikbn();
                String syouhnCd = kykSyouhn.getSyouhncd();
                C_Kykjyoutai kykJyoutai = kykSyouhn.getKykjyoutai();
                BizDate kykYmd = kykSyouhn.getKykymd();
                C_Tuukasyu kykTuukasyu = kykSyouhn.getKyktuukasyu();
                BizDate yendthnkYmd = kykSyouhn.getYendthnkymd();
                BizDate tmttknitenYmd = kykSyouhn.getTmttknitenymd();

                C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

                int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                if (syouhnZokusei == null) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0005,
                        ResourceUtil.getApplicationResources().getString(BM_SyouhnZokusei.TABLE_NAME),
                        BM_SyouhnZokusei.SYOUHNCD, syouhnCd,
                        BM_SyouhnZokusei.SYOUHNSDNO, kykSyouhn.getSyouhnsdno().toString()));
                }

                String aAtukaiOyadrtncd = "";
                String bAtukaiOyadrtncd = "";
                String aAtukaiDrtncd = "";
                String bAtukaiDrtncd = "";
                String aAtukaiBosyuunincd = "000000";
                String bAtukaiBosyuunincd = "000000";

                List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();

                if (kykDairitenList.size() > 0) {

                    aAtukaiOyadrtncd = kykDairitenList.get(0).getOyadrtencd();
                    aAtukaiDrtncd = kykDairitenList.get(0).getDrtencd();
                    aAtukaiBosyuunincd = kykDairitenList.get(0).getBosyuucd();

                    if (C_UmuKbn.ARI.eq(kykDairitenList.get(0).getDrtenbunumu()) && kykDairitenList.size() > 1) {
                        bAtukaiOyadrtncd = kykDairitenList.get(1).getOyadrtencd();
                        bAtukaiDrtncd = kykDairitenList.get(1).getDrtencd();
                        bAtukaiBosyuunincd = kykDairitenList.get(1).getBosyuucd();
                    }
                }

                List<IT_NyknJissekiRireki> nyknJissekiRirekiList =
                    kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

                if (nyknJissekiRirekiList.size() == 0) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                        ResourceUtil.getApplicationResources().getString(IT_NyknJissekiRireki.TABLE_NAME),
                        syono));
                }

                SortIT_NyknJissekiRireki sortIT_NyknJissekiRireki =
                    SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);
                IT_NyknJissekiRireki nyknJissekiRireki =
                    sortIT_NyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiList).get(0);

                C_Tuukasyu hrkTuukasyu = nyknJissekiRireki.getRstuukasyu();

                BizNumber gmeigyoubijiYenShrRate = BizNumber.valueOf(0);
                BizNumber gmeigyoubijiKawaserate = BizNumber.valueOf(0);
                BizNumber gmeigyoubijiYenNyknRate = BizNumber.valueOf(0);
                BizNumber tousyoKykjiKawaserate = BizNumber.valueOf(0);
                BizNumber tousyokykjiYenNyknRate = BizNumber.valueOf(0);
                BizNumber tousyokykjiGaikaNyknRate = BizNumber.valueOf(0);
                BizNumber fstPNyuukinRate = BizNumber.valueOf(0);
                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                C_UmuKbn zennouMousideUmu = C_UmuKbn.NONE;
                C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

                if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {
                    zennouMousideUmu = C_UmuKbn.ARI;
                }
                if (C_UmuKbn.ARI.eq(nyknJissekiRireki.getIktnyuukinnumu())) {
                    ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                }

                if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                    if (C_Tuukasyu.USD.eq(kykTuukasyu)) {
                        gmeigyoubijiYenShrRate = gmeigyoubijiYenShrRateUSD;
                        gmeigyoubijiKawaserate = gmeigyoubijiKawaserateUSD;
                        gmeigyoubijiYenNyknRate = gmeigyoubijiYenNyknRateUSD;
                    }
                    else {
                        gmeigyoubijiYenShrRate = gmeigyoubijiYenShrRateAUD;
                        gmeigyoubijiKawaserate = gmeigyoubijiKawaserateAUD;
                        gmeigyoubijiYenNyknRate = gmeigyoubijiYenNyknRateAUD;
                    }

                    kekkaKbn = getKawaseRate.execHyoukagk(
                        fstPNyknYmd,
                        kykTuukasyu,
                        C_Tuukasyu.JPY,
                        C_YouhiKbn.HUYOU,
                        hrkKaisuu,
                        zennouMousideUmu,
                        ikkatubaraiKbn);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        BizDate msgKwsrateKjYmd = fstPNyknYmd;
                        if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu) &&
                            (C_UmuKbn.NONE.eq(zennouMousideUmu) || C_IkkatubaraiKbn.TEIKIIKKATU.eq(ikkatubaraiKbn))) {
                            msgKwsrateKjYmd = fstPNyknYmd.getPreviousDay();
                        }
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                            msgKwsrateKjYmd.toString(),
                            kykTuukasyu.getValue(),
                            C_Tuukasyu.JPY.getValue()));
                    }

                    tousyoKykjiKawaserate = getKawaseRate.getKawaserate();

                    if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) ||
                        C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
                        kekkaKbn = getKawaseRate.execFstPNyuukin(
                            fstPNyknYmd,
                            kykTuukasyu,
                            hrkTuukasyu,
                            C_YouhiKbn.HUYOU,
                            hrkKaisuu,
                            C_SysKbn.SKEI,
                            zennouMousideUmu,
                            ikkatubaraiKbn);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                            BizDate msgKwsrateKjYmd = fstPNyknYmd;
                            if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu) &&
                                (C_UmuKbn.NONE.eq(zennouMousideUmu) || C_IkkatubaraiKbn.TEIKIIKKATU.eq(ikkatubaraiKbn))) {
                                msgKwsrateKjYmd = fstPNyknYmd.getPreviousDay();
                            }
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                                msgKwsrateKjYmd.toString(),
                                kykTuukasyu.getValue(),
                                hrkTuukasyu.getValue()));
                        }
                        fstPNyuukinRate = getKawaseRate.getKawaserate();

                        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                            tousyokykjiYenNyknRate = fstPNyuukinRate;
                        }
                        else {
                            tousyokykjiGaikaNyknRate = fstPNyuukinRate;
                        }
                    }
                }

                C_UmuKbn gngkPhndUmu = C_UmuKbn.NONE;

                List<IT_KhTtdkRireki> ttdkRirekiListGengaku =
                    kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                if (ttdkRirekiListGengaku.size() > 0) {
                    gngkPhndUmu = C_UmuKbn.ARI;
                }

                if (C_UmuKbn.NONE.eq(gngkPhndUmu)) {
                    List<IT_KhHenkouRireki> khHenkouRirekiList =
                        khDairitenGtmtZndkInfoFSksDao.getKhHenkouRirekisBySyonoGyoumuKousinKinouTableidHenkoukoumokuid(
                            syono,
                            IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                            IT_KykSyouhn.TABLE_NAME,
                            IT_KykSyouhn.HOKENRYOU);

                    if (khHenkouRirekiList.size() > 0) {
                        gngkPhndUmu = C_UmuKbn.ARI;
                    }
                }

                BizDate tmmsMhneiKjYmd = null;
                C_UmuKbn tumimasiMihanei = C_UmuKbn.NONE;

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    if (yendthnkYmd == null && (
                        BizDateUtil.compareYmd(kykYmd, syoriYmd) == BizDateUtil.COMPARE_EQUAL ||
                        BizDateUtil.compareYmd(kykYmd, syoriYmd) == BizDateUtil.COMPARE_LESSER)) {

                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                            SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean =
                            SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                        hanteiTmttknJyoutaiBean.setSyono(syono);
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                        hanteiTmttknJyoutaiBean.setKykymd(kykYmd);

                        boolean result =
                            hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!result) {
                            tumimasiMihanei = C_UmuKbn.ARI;

                            SisurendoTmttknInfoBean sisurendoTmttknInfoBean =
                                hozenDomManager.getSisurendoTmttknInfoBean(syono, syoriYmd);

                            if (sisurendoTmttknInfoBean == null) {
                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                    ResourceUtil.getApplicationResources().getString(IT_KhSisuurendoTmttkn.TABLE_NAME),
                                    syono + "　計算基準日：" + syoriYmd));
                            }

                            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                            tmmsMhneiKjYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                kykYmd,
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(sisurendoTmttknInfoBean.getTmttknTaisyouYM(), kykYmd.getDay()).getRekijyou()
                                ).getPreviousDay();
                        }
                    }
                }

                BizDate calcKijyunYmd = null;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){
                    calcKijyunYmd = tmmsMhneiKjYmd;
                }
                else {
                    calcKijyunYmd = syoriYmd;

                    if (yendthnkYmd != null &&
                        BizDateUtil.compareYmd(syoriYmd, yendthnkYmd) == BizDateUtil.COMPARE_LESSER) {
                        calcKijyunYmd = yendthnkYmd;
                    }
                    else {
                        if (tmttknitenYmd != null &&
                            BizDateUtil.compareYmd(syoriYmd, tmttknitenYmd) == BizDateUtil.COMPARE_LESSER) {
                            calcKijyunYmd = tmttknitenYmd;
                        }
                    }
                }

                boolean keisanTaisyouFlg = true;
                boolean keisanErrFlg = false;
                boolean keisanErrFlgSmtb = false;
                KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = null;

                keisanTaisyouFlg = checkKeisanCommonKaiyaku(syono, calcKijyunYmd, kykSyouhn.getKouryokuhasseiymd());

                if (keisanTaisyouFlg) {
                    keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);

                    keisanKaiyakuBean.setSyoruiukeymd(calcKijyunYmd);
                    keisanKaiyakuBean.setKaiykymd(calcKijyunYmd);
                    keisanKaiyakuBean.setYenshrkwsrate(gmeigyoubijiYenShrRate);
                    keisanKaiyakuBean.setGkshrkwsrate(gmeigyoubijiYenShrRate);

                    kekkaKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                        KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                        kykKihon,
                        calcKijyunYmd,
                        keisanKaiyakuBean);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        keisanErrFlg = true;
                        keisanErrFlgSmtb = true;
                    }
                    else {
                        if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai) &&
                            C_UmuKbn.ARI.eq(keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean().getZennoumijyuutouFlg())) {
                            keisanErrFlg = true;
                            keisanErrFlgSmtb = true;
                        }
                        else {
                            keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
                        }
                    }
                }

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = null;
                BizNumber tousyoKykjiKawaserateSmtb = BizNumber.valueOf(0);

                if (yendthnkYmd != null) {

                    kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syono);

                    if (kykSyouhnHnkmae == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KykSyouhnHnkmae.TABLE_NAME), syono));
                    }

                    kekkaKbn = getKawaseRate.execHyoukagk(
                        fstPNyknYmd,
                        kykSyouhnHnkmae.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_YouhiKbn.HUYOU,
                        hrkKaisuu,
                        zennouMousideUmu,
                        ikkatubaraiKbn);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                            fstPNyknYmd.toString(),
                            kykSyouhnHnkmae.getKyktuukasyu().getValue(),
                            C_Tuukasyu.JPY.getValue()));
                    }

                    tousyoKykjiKawaserateSmtb = getKawaseRate.getKawaserate();
                }

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType kykTuukaType = henkanTuuka.henkanTuukaKbnToType(kykTuukasyu);
                CurrencyType hrkTuukaType = henkanTuuka.henkanTuukaKbnToType(hrkTuukasyu);

                String tuuka = TUUKA_JPY;
                String hrkhouhouKbn = "";
                BizCurrency itijibrP = BizCurrency.valueOf(0, hrkTuukaType);
                BizCurrency goukeiP2 = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency iktnyknkgk = BizCurrency.valueOf(0, hrkTuukaType);
                BizCurrency nenkansanP = BizCurrency.valueOf(0, hrkTuukaType);
                BizCurrency zennouP = BizCurrency.valueOf(0, hrkTuukaType);
                BizCurrency tumitateKngk = BizCurrency.valueOf(0, kykTuukaType);
                BizDate targettkToutatubi = BizDate.valueOf("00000000");
                Integer mokuhyouTi = 0;
                BizCurrency mokuhyouKngk = BizCurrency.valueOf(0);
                BizCurrency kaiyakuHr = BizCurrency.valueOf(0, kykTuukaType);
                String kihrkmPJytYm = "";
                BizCurrency kihrPRuikeigk = BizCurrency.valueOf(0, hrkTuukaType);
                BizDate mankiYmd = BizDate.valueOf("00000000");
                BizCurrency sjkkkTyouseiGk = BizCurrency.valueOf(0);
                BizCurrency kaiyakuKjGk = BizCurrency.valueOf(0);
                BizCurrency soneki = BizCurrency.valueOf(0);
                String sonekiCalcHunouFlg = "";
                BizCurrency sibouS = BizCurrency.valueOf(0, kykTuukaType);
                String hrkstGkTuuka = "";
                String mokuhyouKngkTuuka = "";
                BizCurrency sonotaSeisankin = BizCurrency.valueOf(0);
                String yenkansanSaiyouSign = "";
                BizNumber kykjiYoteiTmttRiritu = BizNumber.valueOf(0);
                String tyusyaku20 = "";
                BizCurrency yenHtykeihi = BizCurrency.valueOf(0);
                BizCurrency yenKaiyakuHr = BizCurrency.valueOf(0);
                BizCurrency yenTumitateKngk = BizCurrency.valueOf(0);
                String hrkkaisuuKbn = "";
                BizCurrency itijibrPKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency goukeiP2Kyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency zennouPKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency tumitateKngkKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency kaiyakuHrKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency sjkkkTyouseiGkKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency kaiyakuKjGkKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency sonekiKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                String sonekiCalcHunouFlgSmbc = SONEKICALCFLG_KOSYA_SEIJYOU;
                BizCurrency sonotaSeisankinKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency kihrPRuikeigkKyktuuka = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency goukeiP2Smtb = BizCurrency.valueOf(0, kykTuukaType);
                BizCurrency sonekiSmtb = BizCurrency.valueOf(0);
                String sonekiCalcHunouFlgSmtb = SONEKICALCFLG_KOSYA_SEIJYOU;

                tuuka = convertTuukaCd(kykTuukasyu);

                if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                    hrkhouhouKbn = HRKHOUHOU_ITIJI;
                    hrkkaisuuKbn = HRKKAISUU_ITIJI;
                }
                else {
                    if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {
                        hrkhouhouKbn = HRKHOUHOU_ZENNOU;
                        hrkkaisuuKbn = HRKKAISUU_NEN;
                    }
                    else {
                        if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikiktbriSyuruiKbn) ||
                            C_Hrkkaisuu.NEN.eq(hrkKaisuu)){
                            hrkhouhouKbn = HRKHOUHOU_NEN;
                            hrkkaisuuKbn = HRKKAISUU_NEN;
                        }
                        else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikiktbriSyuruiKbn) ||
                            C_Hrkkaisuu.HALFY.eq(hrkKaisuu)){
                            hrkhouhouKbn = HRKHOUHOU_HALFY;
                            hrkkaisuuKbn = HRKKAISUU_HALFY;
                        }
                        else {
                            hrkhouhouKbn = HRKHOUHOU_TUKI;
                            hrkkaisuuKbn = HRKKAISUU_TUKI;
                        }
                    }
                }

                if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                    if (yendthnkYmd == null) {
                        if (C_UmuKbn.NONE.eq(gngkPhndUmu)) {
                            itijibrP = nyknJissekiRireki.getRsgaku();
                            if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {
                                yenHtykeihi = itijibrP;
                            }
                        }
                        else {
                            if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu()) ||
                                C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
                                itijibrP = keisanGaikakanzan.exec(
                                    hrkTuukasyu,
                                    kykKihon.getHrkp(),
                                    fstPNyuukinRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                            else {
                                itijibrP = kykKihon.getHrkp();
                            }
                        }
                    }
                    else {
                        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                            itijibrP = kykSyouhn.getKihons();
                        }
                        else {
                            keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                            KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
                            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

                            BizDateYM kijunYm = keisanWKijunYM.exec(
                                kykYmd,
                                yendthnkYmd,
                                null,
                                null,
                                kykJyoutai,
                                syouhnCd,
                                yendthnkYmd);

                            kekkaKbn = keisanWExt.exec(
                                syono,
                                yendthnkYmd);

                            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                                keisanErrFlg = true;
                            }
                            else {
                                keisanWExtBean = keisanWExt.getKeisanWExtBean();

                                kekkaKbn = keisanW.exec(
                                    yendthnkYmd,
                                    kijunYm,
                                    keisanWExtBean);

                                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                                    keisanErrFlg = true;
                                }
                                else {
                                    itijibrP = keisanW.getV();
                                }
                            }
                        }
                    }
                }

                if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                    if (yendthnkYmd == null) {
                        goukeiP2 = kykKihon.getHrkp();

                        if (!(C_UmuKbn.NONE.eq(gngkPhndUmu) && C_Tuukasyu.JPY.eq(hrkTuukasyu))) {
                            yenHtykeihi = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                goukeiP2,
                                tousyoKykjiKawaserate,
                                C_HasuusyoriKbn.AGE);
                        }
                    }
                    else {
                        goukeiP2 = itijibrP;

                        yenHtykeihi = goukeiP2;
                    }
                }

                else {
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
                        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean =
                            SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
                        KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean =
                            SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
                        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

                        keisanIkkatuNkgSyouhnBean.setSyouhnCd(syouhnCd);
                        keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                        keisanIkkatuNkgSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
                        keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.ZERO);
                        keisanIkkatuNkgSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());

                        keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

                        keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
                        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(tikiktbriSyuruiKbn.getValue()));
                        keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(tikiktbriSyuruiKbn);
                        keisanIkkatuNkgBean.setRstuukasyu(hrkTuukasyu);
                        keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                        keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
                        keisanIkkatuNkgBean.setSyokaiprsYmd(null);
                        keisanIkkatuNkgBean.setJyutoustartYm(null);

                        kekkaKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010,
                                "月払一括入金額計算",
                                syono));
                        }
                        iktnyknkgk = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

                        nenkansanP = iktnyknkgk.multiply(12 / Integer.valueOf(tikiktbriSyuruiKbn.getValue()));

                        goukeiP2 = keisanGaikakanzan.execDivide(
                            kykTuukasyu,
                            nenkansanP,
                            tousyokykjiYenNyknRate,
                            C_HasuusyoriKbn.AGE);
                    }

                    else {
                        goukeiP2 = kykSyouhn.getHokenryou().multiply(12 / Integer.valueOf(hrkKaisuu.getValue()));
                    }
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                    if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                        ansyuKihon = IT_AnsyuKihonDetacher.detachZennoustouched(ansyuKihon);
                        List<IT_Zennou> zennouList = ansyuKihon.getZennous();

                        if (zennouList.size() == 0) {
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                ResourceUtil.getApplicationResources().getString(IT_Zennou.TABLE_NAME),
                                syono));
                        }

                        SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                        IT_Zennou zennou = sortIT_Zennou.OrderIT_ZennouByPkDesc(zennouList).get(0);

                        if (kykTuukasyu.eq(hrkTuukasyu)) {
                            zennouP = zennou.getZennoujihrkp().add(zennou.getZennounyuukinkgk());
                            zennouPKyktuuka = zennouP;
                        }

                        else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                            zennouP = zennou.getZennoujihrkp().add(zennou.getZennounyuukinkgk());

                            BizCurrency fstPKykKanzan = keisanGaikakanzan.execDivide(
                                kykTuukasyu,
                                zennou.getZennoujihrkp(),
                                tousyokykjiYenNyknRate,
                                C_HasuusyoriKbn.AGE);

                            BizCurrency zennouPKykKanzan = keisanGaikakanzan.execDivide(
                                kykTuukasyu,
                                zennou.getZennounyuukinkgk(),
                                tousyokykjiYenNyknRate,
                                C_HasuusyoriKbn.AGE);

                            zennouPKyktuuka = fstPKykKanzan.add(zennouPKykKanzan);
                        }

                        else {
                            if (C_UmuKbn.NONE.eq(gngkPhndUmu)) {
                                zennouP = nyknJissekiRireki.getRsgaku().add(zennou.getZennounyuukinkgkrstk());
                            }
                            else {
                                BizCurrency fstPHrkKanzan = keisanGaikakanzan.exec(
                                    hrkTuukasyu,
                                    zennou.getZennoujihrkp(),
                                    tousyokykjiYenNyknRate,
                                    C_HasuusyoriKbn.SUTE);

                                BizCurrency zennouPHrkKanzan = keisanGaikakanzan.exec(
                                    hrkTuukasyu,
                                    zennou.getZennounyuukinkgk(),
                                    tousyokykjiYenNyknRate,
                                    C_HasuusyoriKbn.SUTE);

                                zennouP = fstPHrkKanzan.add(zennouPHrkKanzan);
                            }
                            zennouPKyktuuka = zennou.getZennoujihrkp().add(zennou.getZennounyuukinkgk());
                        }

                        kihrkmPJytYm = zennou.getAnnaisaikaiym().getPreviousMonth().toString();
                        kihrPRuikeigk = zennouP;
                        kihrPRuikeigkKyktuuka = zennouPKyktuuka;
                    }

                    else {
                        kihrkmPJytYm = ansyuKihon.getJkipjytym().getPreviousMonth().toString();

                        if (C_UmuKbn.NONE.eq(gngkPhndUmu)) {

                            SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean =
                                kykKihon.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.TORIKESI);

                            kihrPRuikeigk = sumNyknJissekiRirekiBean.getSumRsgaku()
                                .get(nyknJissekiRireki.getRsgaku().getType());

                            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                                kihrPRuikeigkKyktuuka = keisanGaikakanzan.execDivide(
                                    kykTuukasyu,
                                    kihrPRuikeigk,
                                    tousyokykjiYenNyknRate,
                                    C_HasuusyoriKbn.AGE);
                            }

                            else {
                                kihrPRuikeigkKyktuuka = sumNyknJissekiRirekiBean.getSumHrkp()
                                    .get(nyknJissekiRireki.getHrkp().getType());
                            }
                        }
                        else {
                            int jyuutouM = BizDateUtil.calcDifferenceMonths(
                                kykYmd.getBizDateYM(),
                                ansyuKihon.getJkipjytym());

                            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                                kihrPRuikeigk = iktnyknkgk.multiply(jyuutouM / Integer.valueOf(
                                    tikiktbriSyuruiKbn.getValue()));

                                BizCurrency saisinPKykKanzan = keisanGaikakanzan.execDivide(
                                    kykTuukasyu,
                                    iktnyknkgk,
                                    tousyokykjiYenNyknRate,
                                    C_HasuusyoriKbn.AGE);

                                kihrPRuikeigkKyktuuka = saisinPKykKanzan.multiply(jyuutouM / Integer.valueOf(
                                    tikiktbriSyuruiKbn.getValue()));
                            }

                            else {
                                if (kykTuukasyu.eq(hrkTuukasyu)) {
                                    kihrPRuikeigk = kykSyouhn.getHokenryou().multiply(jyuutouM / Integer.valueOf(
                                        hrkKaisuu.getValue()));
                                    kihrPRuikeigkKyktuuka = kihrPRuikeigk;
                                }
                                else {
                                    BizCurrency saisinPHrkKanzan = keisanGaikakanzan.exec(
                                        hrkTuukasyu,
                                        kykSyouhn.getHokenryou(),
                                        tousyokykjiYenNyknRate,
                                        C_HasuusyoriKbn.SUTE);

                                    kihrPRuikeigk = saisinPHrkKanzan.multiply(jyuutouM / Integer.valueOf(
                                        hrkKaisuu.getValue()));
                                    kihrPRuikeigkKyktuuka = kykSyouhn.getHokenryou().multiply(jyuutouM / Integer.valueOf(
                                        hrkKaisuu.getValue()));
                                }
                            }
                        }
                    }

                    if (C_Tuukasyu.JPY.eq(hrkTuukasyu)) {
                        yenHtykeihi = kihrPRuikeigk;
                    }
                    else {
                        yenHtykeihi = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            kihrPRuikeigk,
                            tousyoKykjiKawaserate,
                            C_HasuusyoriKbn.AGE);
                    }
                }

                if (yendthnkYmd != null) {

                    List<IT_KhTtdkRireki> ttdkRirekiListYendthnk =
                        kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

                    if (ttdkRirekiListYendthnk.size() == 0) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KhTtdkRireki.TABLE_NAME),
                            syono));
                    }

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(ttdkRirekiListYendthnk.get(0).getSyorikbn())) {
                        targettkToutatubi = yendthnkYmd.getPreviousDay();
                    }
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                    mokuhyouTi = kykSonotaTkyk.getTargettkmokuhyouti();

                    if (mokuhyouTi != 0) {

                        KeisanTargetMokuhyougk keisanTargetMokuhyougk =
                            SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
                        mokuhyouKngk = keisanTargetMokuhyougk.exec(
                            kykSonotaTkyk.getTargettkykkijyungk(),
                            mokuhyouTi);

                        mokuhyouKngkTuuka = TUUKA_JPY;
                    }
                }

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 ||
                    syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                    mankiYmd = BizDate.valueOf("99999999");
                }
                else {
                    mankiYmd = kykSyouhn.getHknkknmanryouymd().getPreviousDay();

                }

                if (keisanCommonKaiyakuOutBean != null) {
                    kaiyakuHr = keisanCommonKaiyakuOutBean.getKaiyakuHr();
                    yenKaiyakuHr = keisanCommonKaiyakuOutBean.getKaiyakuHrYen();
                }

                if (keisanCommonKaiyakuOutBean != null) {

                    if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

                        tumitateKngk = keisanCommonKaiyakuOutBean.getPtumitatekin();

                        if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                            yenTumitateKngk = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                tumitateKngk,
                                gmeigyoubijiYenShrRate,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {
                            yenTumitateKngk = tumitateKngk;
                        }

                        kaiyakuKjGk = keisanCommonKaiyakuOutBean.getKaiyakuKjgk();

                        if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                            kaiyakuKjGk = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                kaiyakuKjGk,
                                gmeigyoubijiYenShrRate,
                                C_HasuusyoriKbn.AGE
                                ).multiply(-1);
                        }
                        else {
                            kaiyakuKjGk = kaiyakuKjGk.multiply(-1);
                        }

                        sjkkkTyouseiGk = yenKaiyakuHr.subtract(kaiyakuKjGk).subtract(yenTumitateKngk);
                    }
                }

                kekkaKbn = calcHkShrKngk.execByKeisanWExt(
                    syono,
                    calcKijyunYmd,
                    C_SiinKbn.SP,
                    C_HokenkinsyuruiKbn.SBHOKENKIN,
                    kykKihon.getSdpdkbn(),
                    kykKihon.getHrkkeiro());


                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010,
                        "保険金額計算",
                        syono));
                }

                sibouS = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();

                if (yendthnkYmd == null) {
                    hrkstGkTuuka = convertTuukaCd(hrkTuukasyu);
                }
                else {
                    hrkstGkTuuka = TUUKA_JPY;
                }

                if (keisanCommonKaiyakuOutBean != null) {
                    BizCurrency sonotaSeisankinGaikaYenkanzan = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        keisanCommonKaiyakuOutBean.getZennouseisankGk()
                        .add(keisanCommonKaiyakuOutBean.getMikeikapGk()),
                        gmeigyoubijiYenShrRate,
                        C_HasuusyoriKbn.SUTE);

                    sonotaSeisankin =
                        keisanCommonKaiyakuOutBean.getZennouseisankYen()
                        .add(keisanCommonKaiyakuOutBean.getMikeikapYen())
                        .add(keisanCommonKaiyakuOutBean.getHaitoukinYen())
                        .add(keisanCommonKaiyakuOutBean.getYentkbthaitoukin())
                        .add(sonotaSeisankinGaikaYenkanzan);
                }

                if (!C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                    yenkansanSaiyouSign = YENKANSAN_HKNKAISYA;
                }

                if (keisanErrFlg == true || keisanTaisyouFlg == false ||
                    yendthnkYmd != null || C_UmuKbn.ARI.eq(gngkPhndUmu)) {
                    sonekiCalcHunouFlg = SONEKICALCFLG_ERR;
                    sonekiCalchunouKensuu++;
                }

                if (!SONEKICALCFLG_ERR.equals(sonekiCalcHunouFlg)) {
                    soneki = yenKaiyakuHr.add(sonotaSeisankin).subtract(yenHtykeihi);
                }

                if (yendthnkYmd == null) {

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        kykjiYoteiTmttRiritu = kykSyouhn.getYoteiriritu().multiply(100);
                    }

                    else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                        keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                        BizDateYM kijunYm = keisanWKijunYM.exec(
                            kykYmd,
                            calcKijyunYmd,
                            null,
                            null,
                            kykJyoutai,
                            syouhnCd,
                            null);

                        int keikaYmTukikansan = BizDateUtil.calcDifferenceMonths(kijunYm, kykYmd.getBizDateYM());

                        if (keikaYmTukikansan <= YEAR_10_TUKIKANSAN) {
                            kykjiYoteiTmttRiritu = kykSyouhn.getTumitateriritu().multiply(100);
                        }
                        else {
                            kykjiYoteiTmttRiritu = kykSyouhn.getLoadinghnkgtumitateriritu().multiply(100);
                        }
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        kykjiYoteiTmttRiritu = kykSyouhn.getTumitateriritu().multiply(100);
                    }
                }
                else {
                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                        kykjiYoteiTmttRiritu = kykSyouhn.getTumitateriritu().multiply(100);
                    }
                }

                if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

                    itijibrPKyktuuka = goukeiP2;

                    if (keisanCommonKaiyakuOutBean != null) {
                        tumitateKngkKyktuuka = tumitateKngk;

                        sjkkkTyouseiGkKyktuuka = keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk();

                        kaiyakuKjGkKyktuuka = keisanCommonKaiyakuOutBean.getKaiyakuKjgk().multiply(-1);
                    }
                }

                goukeiP2Kyktuuka = goukeiP2;

                if (keisanCommonKaiyakuOutBean != null) {

                    kaiyakuHrKyktuuka = kaiyakuHr;

                    if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {
                        sonotaSeisankinKyktuuka = sonotaSeisankin;
                    }
                    else {
                        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                            sonotaSeisankinKyktuuka = keisanGaikakanzan.execDivide(
                                kykTuukasyu,
                                sonotaSeisankin,
                                gmeigyoubijiYenNyknRate,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {
                            BizCurrency sonotaSeisankinYenKykkanzan = keisanGaikakanzan.execDivide(
                                kykTuukasyu,
                                keisanCommonKaiyakuOutBean.getZennouseisankYen()
                                .add(keisanCommonKaiyakuOutBean.getMikeikapYen())
                                .add(keisanCommonKaiyakuOutBean.getHaitoukinYen())
                                .add(keisanCommonKaiyakuOutBean.getYentkbthaitoukin()),
                                gmeigyoubijiYenNyknRate,
                                C_HasuusyoriKbn.SUTE);

                            sonotaSeisankinKyktuuka =
                                keisanCommonKaiyakuOutBean.getZennouseisankGk()
                                .add(keisanCommonKaiyakuOutBean.getMikeikapGk())
                                .add(sonotaSeisankinYenKykkanzan);
                        }
                    }
                }
                if (keisanTaisyouFlg == false) {
                    sonekiCalcHunouFlgSmbc = SONEKICALCFLG_KOSYA_KEISANWHUYOU;
                    sonekiHunouCntSmbcKeisanWHuyou++;
                }
                else if (keisanErrFlg == true) {
                    sonekiCalcHunouFlgSmbc = SONEKICALCFLG_KOSYA_KEISANWERR;
                    sonekiHunouCntSmbcKeisanWErr++;
                }
                else if (C_UmuKbn.ARI.eq(gngkPhndUmu)) {
                    sonekiCalcHunouFlgSmbc = SONEKICALCFLG_KOSYA_GNGKPHNDARI;
                    sonekiHunouCntSmbcGngkPhndAri++;
                }
                else if (yendthnkYmd != null) {
                    sonekiCalcHunouFlgSmbc = SONEKICALCFLG_KOSYA_YENDTHNKZUMI;
                    sonekiHunouCntSmbcYendthnkZumi++;
                }

                if (!SONEKICALCFLG_KOSYA_KEISANWHUYOU.equals(sonekiCalcHunouFlgSmbc) &&
                    !SONEKICALCFLG_KOSYA_KEISANWERR.equals(sonekiCalcHunouFlgSmbc)) {
                    if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
                        sonekiKyktuuka = kaiyakuHrKyktuuka.add(sonotaSeisankinKyktuuka).subtract(itijibrPKyktuuka);
                    }
                    else {
                        sonekiKyktuuka = kaiyakuHrKyktuuka.add(sonotaSeisankinKyktuuka).subtract(kihrPRuikeigkKyktuuka);
                    }
                }

                if (yendthnkYmd != null) {
                    goukeiP2Smtb = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        kykSyouhnHnkmae.getHokenryou(),
                        tousyoKykjiKawaserateSmtb,
                        C_HasuusyoriKbn.AGE);
                }
                else {
                    goukeiP2Smtb = goukeiP2;
                }

                if (keisanTaisyouFlg == false) {
                    sonekiCalcHunouFlgSmtb = SONEKICALCFLG_KOSYA_KEISANWHUYOU;
                    sonekiHunouCntSmtbKeisanWHuyou++;
                }
                else if (keisanErrFlgSmtb == true) {
                    sonekiCalcHunouFlgSmtb = SONEKICALCFLG_KOSYA_KEISANWERR;
                    sonekiHunouCntSmtbKeisanWErr++;
                }
                else if (C_UmuKbn.ARI.eq(gngkPhndUmu)) {
                    sonekiCalcHunouFlgSmtb = SONEKICALCFLG_KOSYA_GNGKPHNDARI;
                    sonekiHunouCntSmtbGngkPhndAri++;
                }

                if (SONEKICALCFLG_KOSYA_SEIJYOU.equals(sonekiCalcHunouFlgSmtb)) {
                    if (yendthnkYmd != null) {
                        sonekiSmtb = kaiyakuHr.add(sonotaSeisankin).subtract(goukeiP2Smtb);
                    }
                    else {
                        sonekiSmtb = soneki;
                    }

                }

                ZT_DairitenGtmtZndkTy dairitenGtmtZndkTy = new ZT_DairitenGtmtZndkTy();

                dairitenGtmtZndkTy.setZtydatakijyunymd(syoriYmd.toString());
                dairitenGtmtZndkTy.setZtysyono(syono);
                dairitenGtmtZndkTy.setZtyhknsyukigou(syouhnCd.substring(0, 2));
                dairitenGtmtZndkTy.setZtyhknsyuruikigousedaikbn(kykSyouhn.getRyouritusdno().substring(0, 1));
                dairitenGtmtZndkTy.setZtymdhnaisyoumeicd(kykKihon.getAisyoumeikbn().getValue());
                dairitenGtmtZndkTy.setZtytuuka(tuuka);
                dairitenGtmtZndkTy.setZtyhrkhuhukbn(hrkhouhouKbn);
                dairitenGtmtZndkTy.setZtykyknmkndrtengtmtzndk(kykSya.getKyknmkn());
                dairitenGtmtZndkTy.setZtykyknmkjdrtengtmtzndk(kykSya.getKyknmkj());
                dairitenGtmtZndkTy.setZtyhhknnmkjdrtengtmtzndk(hhknSya.getHhknnmkj());
                dairitenGtmtZndkTy.setZtyitijibrp(new BigDecimal(itijibrP.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtygoukeip2(new BigDecimal(goukeiP2.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtyzennoup(new BigDecimal(zennouP.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtytumitatekngk(new BigDecimal(tumitateKngk.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtytargettktoutatubi(targettkToutatubi.toString());
                dairitenGtmtZndkTy.setZtymokuhyouti(mokuhyouTi.longValue());
                dairitenGtmtZndkTy.setZtymokuhyoukngk(Long.parseLong(mokuhyouKngk.toString()));
                dairitenGtmtZndkTy.setZtykaiyakuhr(new BigDecimal(kaiyakuHr.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtykihrkmpjytym(kihrkmPJytYm);
                dairitenGtmtZndkTy.setZtykihrpruikeigk(new BigDecimal(kihrPRuikeigk.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtytousyokykjikawaserate(tousyoKykjiKawaserate);
                dairitenGtmtZndkTy.setZtykykymd(kykYmd.toString());
                dairitenGtmtZndkTy.setZtymankiymd(mankiYmd.toString());
                dairitenGtmtZndkTy.setZtykishrkinruikeigk(0L);
                dairitenGtmtZndkTy.setZtysjkkktyouseigk(Long.parseLong(sjkkkTyouseiGk.toString()));
                dairitenGtmtZndkTy.setZtykaiyakukjgk(Long.parseLong(kaiyakuKjGk.toString()));
                dairitenGtmtZndkTy.setZtysoneki(Long.parseLong(soneki.toString()));
                dairitenGtmtZndkTy.setZtysonekicalchunouflg(sonekiCalcHunouFlg);
                dairitenGtmtZndkTy.setZtysibous(new BigDecimal(sibouS.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtygmeigyoubijiyenshrrate(gmeigyoubijiYenShrRate);
                dairitenGtmtZndkTy.setZtygmeigyoubijikawaserate(gmeigyoubijiKawaserate);
                dairitenGtmtZndkTy.setZtytousyokykjiyennyknrate(tousyokykjiYenNyknRate);
                dairitenGtmtZndkTy.setZtytousyokykjigaikanyknrate(tousyokykjiGaikaNyknRate);
                dairitenGtmtZndkTy.setZtykanyuusyaknrno(kykKihon.getCifcd());
                dairitenGtmtZndkTy.setZtyhrkstgktuuka(hrkstGkTuuka);
                dairitenGtmtZndkTy.setZtymokuhyoukngktuuka(mokuhyouKngkTuuka);
                dairitenGtmtZndkTy.setZtysonotaseisankin(Long.parseLong(sonotaSeisankin.toString()));
                dairitenGtmtZndkTy.setZtyyenkansansaiyousign(yenkansanSaiyouSign);
                dairitenGtmtZndkTy.setZtykykjiyoteitmttriritu(kykjiYoteiTmttRiritu);
                dairitenGtmtZndkTy.setZtyhukusuutuukaflg("");
                dairitenGtmtZndkTy.setZtyyenkansanhunoflg("");
                dairitenGtmtZndkTy.setZtytyusyaku20(tyusyaku20);
                dairitenGtmtZndkTy.setZtyskeibsyaatkioydrtencd(aAtukaiOyadrtncd);
                dairitenGtmtZndkTy.setZtyskeibsybatkioydrtencd(bAtukaiOyadrtncd);
                dairitenGtmtZndkTy.setZtyskeibsyaatkidrtencd(aAtukaiDrtncd);
                dairitenGtmtZndkTy.setZtyskeibsybatkidrtencd(bAtukaiDrtncd);
                dairitenGtmtZndkTy.setZtyskeibsyaatkibosyuucd(aAtukaiBosyuunincd);
                dairitenGtmtZndkTy.setZtyskeibsybatkibosyuucd(bAtukaiBosyuunincd);
                dairitenGtmtZndkTy.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                dairitenGtmtZndkTy.setZtyitijibrpkyktuukagtmtzndk(new BigDecimal(itijibrPKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtygoukeip2kyktuuka(new BigDecimal(goukeiP2Kyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtyzennoupkyktuuka(new BigDecimal(zennouPKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtytmttkngkkyktuuka(new BigDecimal(tumitateKngkKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtykaiyakuhrkyktuuka(new BigDecimal(kaiyakuHrKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtykishrkinruikeigkkyktuuka(0L);
                dairitenGtmtZndkTy.setZtysjkkktyouseigkkyktuuka(new BigDecimal(sjkkkTyouseiGkKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtykaiyakukjgkkyktuuka(new BigDecimal(kaiyakuKjGkKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtysonekikyktuuka(new BigDecimal(sonekiKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtysonekicalchunouflgsmbc(sonekiCalcHunouFlgSmbc);
                dairitenGtmtZndkTy.setZtysonotaseisankinkyktuuka(new BigDecimal(sonotaSeisankinKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtytyusyakusmbc("");
                dairitenGtmtZndkTy.setZtygmeigyoubijigaikashrrate(gmeigyoubijiYenNyknRate);
                dairitenGtmtZndkTy.setZtykihrpruikeigkkyktuuka(new BigDecimal(kihrPRuikeigkKyktuuka.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtygoukeip2smtb(new BigDecimal(goukeiP2Smtb.toAdsoluteString()).longValue());
                dairitenGtmtZndkTy.setZtysonekismtb(Long.parseLong(sonekiSmtb.toString()));
                dairitenGtmtZndkTy.setZtysonekicalchunouflgsmtb(sonekiCalcHunouFlgSmtb);
                dairitenGtmtZndkTy.setZtyyobin11(0L);
                dairitenGtmtZndkTy.setZtyyobin11x2(0L);
                dairitenGtmtZndkTy.setZtyyobin11x3(0L);
                dairitenGtmtZndkTy.setZtyyobin11x4(0L);
                dairitenGtmtZndkTy.setZtyyobin11x5(0L);
                dairitenGtmtZndkTy.setZtyyobin11x6(0L);
                dairitenGtmtZndkTy.setZtyyobin11x7(0L);
                dairitenGtmtZndkTy.setZtyyobin11x8(0L);
                dairitenGtmtZndkTy.setZtyyobin11x9(0L);
                dairitenGtmtZndkTy.setZtyyobin11x10(0L);
                dairitenGtmtZndkTy.setZtyyobiv20("");
                dairitenGtmtZndkTy.setZtyyobiv6("000000");
                dairitenGtmtZndkTy.setZtyyobiv56("");

                BizPropertyInitializer.initialize(dairitenGtmtZndkTy);

                dairitenGtmtZndkTyInserter.add(dairitenGtmtZndkTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        if (sonekiCalchunouKensuu > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiCalchunouKensuu),
                "損益計算不能"));
        }
        if (sonekiHunouCntSmbcKeisanWHuyou > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmbcKeisanWHuyou),
                "損益計算不能（ＳＭＢＣ用）・解約返戻金等計算対象外"));
        }
        if (sonekiHunouCntSmbcKeisanWErr > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmbcKeisanWErr),
                "損益計算不能（ＳＭＢＣ用）・解約返戻金等計算エラー"));
        }
        if (sonekiHunouCntSmbcYendthnkZumi > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmbcYendthnkZumi),
                "損益計算不能（ＳＭＢＣ用）・円建変更済"));
        }
        if (sonekiHunouCntSmbcGngkPhndAri > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmbcGngkPhndAri),
                "損益計算不能（ＳＭＢＣ用）・減額・Ｐ変動経緯あり"));
        }
        if (sonekiHunouCntSmtbKeisanWHuyou > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmtbKeisanWHuyou),
                "損益計算不能（ＳＭＴＢ用）・解約返戻金等計算対象外"));
        }
        if (sonekiHunouCntSmtbKeisanWErr > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmtbKeisanWErr),
                "損益計算不能（ＳＭＴＢ用）・解約返戻金等計算エラー"));
        }
        if (sonekiHunouCntSmtbGngkPhndAri > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiHunouCntSmtbGngkPhndAri),
                "損益計算不能（ＳＭＴＢ用）・減額・Ｐ変動経緯あり"));
        }
    }

    private String convertTuukaCd(C_Tuukasyu pTuukasyu) {

        String tuukaCd = "  ";

        if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            tuukaCd = TUUKA_USD;
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

            tuukaCd = TUUKA_AUD;
        }
        else {

            tuukaCd = TUUKA_JPY;
        }

        return tuukaCd;
    }

    private BizNumber getKawaserate(BizDate pKwsrateKjYmd, C_KawaserateSyuruiKbn pKawaserateSyuruiKbn,
        C_Tuukasyu pMototuuka, C_Tuukasyu pKanzantuuka, C_KawasetekiyoKbn pKawaseteKiyoKbn,
        C_KawasetsryKbn pKawasetsryKbn, C_EigyoubiHoseiKbn pEigyoubiHoseiKbn, C_YouhiKbn pZenEigyoubiKsSyutokuYouhi) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pKwsrateKjYmd,
            pKawaserateSyuruiKbn,
            pMototuuka,
            pKanzantuuka,
            pKawaseteKiyoKbn,
            pKawasetsryKbn,
            pEigyoubiHoseiKbn,
            pZenEigyoubiKsSyutokuYouhi);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047, pKwsrateKjYmd.toString(),
                pKawaserateSyuruiKbn.getValue(), pMototuuka.getValue(), pKanzantuuka.getValue(),
                pKawaseteKiyoKbn.getValue(), pKawasetsryKbn.getValue(), pEigyoubiHoseiKbn.getValue(),
                pZenEigyoubiKsSyutokuYouhi.getValue()));
        }

        return getKawaseRate.getKawaserate();
    }

    private boolean checkKeisanCommonKaiyaku(String pSyono, BizDate pCalcKijyunYmd, BizDate pKouryokuHasseiYmd) {

        if ((BizDateUtil.compareYmd(pCalcKijyunYmd, pKouryokuHasseiYmd) == BizDateUtil.COMPARE_LESSER)) {
            return false;
        }

        List<JT_SkKihon> skKihonList = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
            pSyono, C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonList);

        if (skKihonList.size() != 0) {
            return false;
        }

        C_UktkSyoriKbn uktkSyoriKbn = C_UktkSyoriKbn.BLNK;

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = khDairitenGtmtZndkInfoFSksDao.getKhHenkouUktkBySyono(pSyono);

        for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

            uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();

            if (C_UktkSyoriKbn.KAIYAKU.eq(uktkSyoriKbn)) {
                return false;
            }
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean processSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

            String jimuTetuzukiCd = processSummaryOutBean.getJimuTetuzukiCd();
            String syoriTaskid = processSummaryOutBean.getNowNodoId();

            if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK.equals(jimuTetuzukiCd) ||
                IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI.equals(jimuTetuzukiCd)) {

                if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(syoriTaskid)) {
                    return false;
                }
            }

            else if (TeisuuSiharai.JIMUTETUZUKICD_SISIBOU.equals(jimuTetuzukiCd)) {
                return false;
            }
        }

        return true;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
