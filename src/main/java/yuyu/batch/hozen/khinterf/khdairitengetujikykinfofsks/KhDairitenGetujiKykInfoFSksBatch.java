package yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba.DairitenGetujiKykInfosBean;
import yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba.KhDairitenGetujiKykInfoFSksDao;
import yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba.KhHenkouUktkBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
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
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
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
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
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
import yuyu.def.db.entity.ZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiByNyktrksflgBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 普保Ⅱ代理店月次契約情報Ｆ作成クラス
 */
public class KhDairitenGetujiKykInfoFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhDairitenGetujiKykInfoFSksDao khDairitenGetujiKykInfoFSksDao;

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
        long keisanWErrorCnts = 0;
        long keisanWErrorSyoumetuTimeCnts = 0;
        long sonekiCalchunouCnts = 0;
        long mnkNksKeisanErrCnts = 0;
        long nenkansanPKeisanErrCnts = 0;
        BizNumber gmeiGyoubijiKawaserateUSD = BizNumber.valueOf(0);
        BizNumber gmeiGyoubijiKawaserateAUD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonthUSD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonthAUD = BizNumber.valueOf(0);
        BizNumber nyuukinyouRateLastmonth = BizNumber.valueOf(0);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(ibKakutyoujobcd)));

        gmeiGyoubijiKawaserateUSD = getKawaserate(syoriYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);
        gmeiGyoubijiKawaserateAUD = getKawaserate(syoriYmd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
            C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.HUYOU);

        nyuukinyouRateLastmonthUSD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        nyuukinyouRateLastmonthAUD = getKawaserate(syoriYmd.getBizDateYM().getPreviousMonth().getLastDay(),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

        try (ExDBResults<DairitenGetujiKykInfosBean> dairitenGetujiKykInfosBeanLst = khDairitenGetujiKykInfoFSksDao
            .getDairitenGetujiKykInfos(ibKakutyoujobcd);
            EntityInserter<ZT_SinBosyuuDrtenHoyuuKykTy> sinBosyuuDrtenHoyuuKykTyInserter = new EntityInserter<>();) {

            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            KeisanCommonKaiyaku keisanCommonKaiyaku;
            KeisanKaiyakuBean keisanKaiyakuBean;
            KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBeanSyoriTime = SWAKInjector.getInstance(KeisanCommonKaiyakuOutBean.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

            for (DairitenGetujiKykInfosBean dairitenGetujiKykInfosBean : dairitenGetujiKykInfosBeanLst) {

                IT_KykDairiten kykDairiten = dairitenGetujiKykInfosBean.getKykDairiten();
                IT_KykKihon kykKihon = dairitenGetujiKykInfosBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = dairitenGetujiKykInfosBean.getKykSyouhn();
                IT_KykSonotaTkyk kykSonotaTkyk = dairitenGetujiKykInfosBean.getKykSonotaTkyk();
                IT_KykSya kykSya = dairitenGetujiKykInfosBean.getKykSya();
                IT_HhknSya hhknSya = dairitenGetujiKykInfosBean.getHhknSya();
                IT_AnsyuKihon ansyuKihon = dairitenGetujiKykInfosBean.getAnsyuKihon();
                String syono = kykDairiten.getSyono();
                C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kyktuukasyu);

                if(BizDateUtil.compareYmd(syoriYmd, kykKihon.getSeirituymd()) == BizDateUtil.COMPARE_LESSER ){
                    continue;
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                String haraikataKbn = "";
                String syouhinBunruiKbn = "00";
                String teikaiyakuhrkngataHyj = "0";
                String batukaiOyadrtncd = "";
                String batukaiDrtncd = "";
                String batukaiBosyuunincd = "000000";
                String hknkknManryouYmd = "";
                String hrkkaisuuKbn = "";
                String annaihuyouRiyuuKbn = "00";
                String syoumetuymd = "00000000";
                String syoumetuCd = "0000";
                BizCurrency hrkP = BizCurrency.valueOf(0);
                BizCurrency nenkansanPHeijyun = BizCurrency.valueOf(0);
                String kyksyaseiKbn = "0";
                BizDateYM hrkPJyuutouYm = BizDateYM.valueOf("999999");
                BizDateYM kihrkmPJytYm = BizDateYM.valueOf("999999");
                BizCurrency kihrkmPMf = BizCurrency.valueOf(0);
                BizCurrency kihrkmPRuikei = BizCurrency.valueOf(0);
                BizCurrency kaiyksymtjiW = BizCurrency.valueOf(0);
                BizCurrency kaiyksymtjiKihrkm = BizCurrency.valueOf(0);
                BizCurrency kyksymtjUnyoujisoneki = BizCurrency.valueOf(0);
                BizNumber kyksymtjUnyoujisonekiri = BizNumber.valueOf(0);
                String keisanWErrorKbnSyoumetuTime = "0";
                BizCurrency nenkansanPAnP = BizCurrency.valueOf(0);
                String nenkansanPKeisanErrKbn = "0";
                BizCurrency hrkPGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency kaiyksymtjiWGaika = BizCurrency.valueOf(0, tuukaType);
                String tuukaCd = "  ";
                BizCurrency itijibrPYen = BizCurrency.valueOf(0);
                BizCurrency itijibrPGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency tmttknYen = BizCurrency.valueOf(0);
                BizCurrency tmttknGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency kaiyakukjetcYen = BizCurrency.valueOf(0);
                BizCurrency kaiyakukjetcGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency kaiyakuhrYen = BizCurrency.valueOf(0);
                BizCurrency kaiyakuhrGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency sonekiYen = BizCurrency.valueOf(0);
                BizCurrency sonekiGaika = BizCurrency.valueOf(0, tuukaType);
                BizCurrency sbsetcYen = BizCurrency.valueOf(0);
                BizCurrency sbsetcGaika = BizCurrency.valueOf(0, tuukaType);
                String sonekiCalchunouFlg = "0";
                String hhknnmkj = "";
                BizDate targettkToutatubi = BizDate.valueOf("00000000");
                Integer mokuhyouTi = 0;
                BizCurrency mokuhyouknGk = BizCurrency.valueOf(0);
                BizCurrency kihrpRuikeiGk = BizCurrency.valueOf(0);
                BizNumber tousyoKykjiKawaserate = BizNumber.valueOf(0);
                String keisanWErrorKbnSyoriTime = "0";
                BizNumber gmeiGyoubijiKawaserate = BizNumber.valueOf(0);
                BizCurrency tmttHaitoukin = BizCurrency.valueOf(0);
                BizCurrency tkbtiHaitoukin = BizCurrency.valueOf(0);
                BizCurrency sonotahaitoukin = BizCurrency.valueOf(0);
                BizCurrency gstsZeigk = BizCurrency.valueOf(0);
                BizCurrency mikeikaMisyuuP = BizCurrency.valueOf(0);
                BizCurrency sonotaseisan = BizCurrency.valueOf(0);
                BizCurrency huho2SjkkktyouseigkMva = BizCurrency.valueOf(0, tuukaType);
                BizCurrency huho2Yendthnkhr = BizCurrency.valueOf(0);
                BizNumber huho2Sjkkktusirrt = BizNumber.valueOf(0);
                BizNumber huho2Koujyoritu = BizNumber.valueOf(0);
                boolean zennouseisankgkUmu = false;

                List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

                if (nyknJissekiRirekiList.size() == 0) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                        ResourceUtil.getApplicationResources().getString(IT_NyknJissekiRireki.TABLE_NAME), syono));
                }
                IT_NyknJissekiRireki nyknJissekiRirekiSkei = nyknJissekiRirekiList.get(0);

                BizNumber yenshrRateSyoriTime = BizNumber.valueOf(0);
                BizCurrency henkoumaeP = BizCurrency.valueOf(0, tuukaType);
                C_Tuukasyu henkoumaekyktuukasyu = C_Tuukasyu.BLNK;
                String syouhnCd = kykSyouhn.getSyouhncd();
                BizDate kykYmd = kykSyouhn.getKykymd();
                BizDate yendthnkYmd = kykSyouhn.getYendthnkymd();
                C_Kykjyoutai kykJyoutai = kykSyouhn.getKykjyoutai();
                C_Syoumetujiyuu syoumetuJiyuu = kykSyouhn.getSyoumetujiyuu();
                C_TkiktbrisyuruiKbn tikIktbriSyuruiKbn = kykKihon.getTikiktbrisyuruikbn();
                C_Hrkkaisuu hrkkaisuu = kykKihon.getHrkkaisuu();
                String[] kinouIds = new String[3];
                kinouIds[0] = IKhozenCommonConstants.KINOUID_KAIYAKU;
                kinouIds[1] = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;
                kinouIds[2] = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;

                if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                    if (C_Tuukasyu.USD.eq(kyktuukasyu)) {
                        gmeiGyoubijiKawaserate= gmeiGyoubijiKawaserateUSD;
                        nyuukinyouRateLastmonth = nyuukinyouRateLastmonthUSD;
                    }
                    else {
                        gmeiGyoubijiKawaserate= gmeiGyoubijiKawaserateAUD;
                        nyuukinyouRateLastmonth = nyuukinyouRateLastmonthAUD;
                    }
                    yenshrRateSyoriTime = gmeiGyoubijiKawaserate;

                    if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                        tousyoKykjiKawaserate = getKawaserate(kykKihon.getFstpnyknymd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            kyktuukasyu, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);
                    }
                    else {
                        C_UmuKbn zennoumousideUmu = C_UmuKbn.NONE;
                        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;
                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                        BizDate kwsrateKjYmd = null;
                        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.BLNK;

                        if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                            zennoumousideUmu = C_UmuKbn.ARI;
                        }
                        else {

                            zennoumousideUmu = C_UmuKbn.NONE;
                        }

                        if (C_UmuKbn.ARI.eq(nyknJissekiRirekiSkei.getIktnyuukinnumu())) {

                            ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                        }
                        else {

                            ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;
                        }

                        C_ErrorKbn getKawaseRateErrorKbn = getKawaseRate.execFstPNyuukin(kykKihon.getFstpnyknymd(),
                            kyktuukasyu,
                            C_Tuukasyu.JPY,
                            C_YouhiKbn.HUYOU,
                            nyknJissekiRirekiSkei.getHrkkaisuu(),
                            C_SysKbn.SKEI,
                            zennoumousideUmu,
                            ikkatubaraiKbn);

                        if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {

                            if (C_UmuKbn.ARI.eq(zennoumousideUmu) && C_IkkatubaraiKbn.BLNK.eq(ikkatubaraiKbn)) {

                                kwsrateKjYmd = kykKihon.getFstpnyknymd();
                                eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                            }
                            else {

                                kwsrateKjYmd = kykKihon.getFstpnyknymd().getPreviousDay();
                                eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                            }

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047, kwsrateKjYmd.toString(),
                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(), kyktuukasyu.getValue(), C_Tuukasyu.JPY.getValue(),
                                C_KawasetekiyoKbn.TTM.getValue(), C_KawasetsryKbn.NYUKINRATE.getValue(), eigyoubiHoseiKbn.getValue(),
                                C_YouhiKbn.HUYOU.getValue()));
                        }

                        tousyoKykjiKawaserate = getKawaseRate.getKawaserate();
                    }
                }

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = null;
                if (yendthnkYmd != null) {

                    kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(syono);

                    if (kykSyouhnHnkmae == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KykSyouhnHnkmae.TABLE_NAME), syono));
                    }

                    henkoumaeP = kykSyouhnHnkmae.getHokenryou();
                    henkoumaekyktuukasyu = kykSyouhnHnkmae.getKyktuukasyu();
                    kykSyouhnHnkmae.detach();
                }

                int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

                BizDate tmmsmhneiKiJyunYmd = null;
                C_UmuKbn tumimasiMihanei = C_UmuKbn.NONE;

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                    if (yendthnkYmd == null &&
                        (BizDateUtil.compareYmd(kykYmd, syoriYmd) == BizDateUtil.COMPARE_EQUAL
                        || BizDateUtil.compareYmd(kykYmd, syoriYmd) == BizDateUtil.COMPARE_LESSER)) {

                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector
                            .getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                        hanteiTmttknJyoutaiBean.setSyono(syono);
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                        hanteiTmttknJyoutaiBean.setKykymd(kykYmd);

                        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!result) {

                            tumimasiMihanei = C_UmuKbn.ARI;

                            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(syono, syoriYmd);

                            if (sisurendoTmttknInfoBean == null) {

                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                    ResourceUtil.getApplicationResources().getString(IT_KhSisuurendoTmttkn.TABLE_NAME), syono + "　計算基準日：" + syoriYmd));
                            }

                            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                            tmmsmhneiKiJyunYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                kykYmd,
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(sisurendoTmttknInfoBean.getTmttknTaisyouYM(), kykYmd.getDay()).getRekijyou()).getPreviousDay();
                        }
                    }
                }

                BizDate calckiJyunYmd = null;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){

                    calckiJyunYmd = tmmsmhneiKiJyunYmd;
                }
                else {

                    calckiJyunYmd = syoriYmd;

                    if (yendthnkYmd != null) {
                        if (BizDateUtil.compareYmd(syoriYmd, yendthnkYmd) == BizDateUtil.COMPARE_LESSER) {
                            calckiJyunYmd = yendthnkYmd;
                        }
                    }
                    else {
                        if (kykSyouhn.getTmttknitenymd() != null && BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_LESSER) {
                            calckiJyunYmd = kykSyouhn.getTmttknitenymd();
                        }
                    }
                }

                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

                if (syouhnZokusei == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0005,
                        ResourceUtil.getApplicationResources().getString(BM_SyouhnZokusei.TABLE_NAME), BM_SyouhnZokusei.SYOUHNCD, syouhnCd,
                        BM_SyouhnZokusei.SYOUHNSDNO, kykSyouhn.getSyouhnsdno().toString()));
                }

                C_UmuKbn syuusinhknUmu = syouhnZokusei.getSyuusinhknumu();
                C_UmuKbn nkhknUmu = syouhnZokusei.getNkhknumu();

                C_UmuKbn gengakuUmu = C_UmuKbn.NONE;
                List<IT_KhTtdkRireki> ttdkRirekiList =
                    kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);

                if (ttdkRirekiList.size() > 0) {
                    gengakuUmu = C_UmuKbn.ARI;
                }

                C_UmuKbn phndUmu = C_UmuKbn.NONE;
                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    List<IT_KhHenkouRireki> khHenkouRirekiList =
                        khDairitenGetujiKykInfoFSksDao.getKhHenkouRirekisBySyonoGyoumuKousinKinouTableidHenkoukoumokuid(
                            syono,
                            IKhozenCommonConstants.KINOUID_SEINENGAPPISEI,
                            IT_KykSyouhn.TABLE_NAME,
                            IT_KykSyouhn.HOKENRYOU);

                    if (khHenkouRirekiList.size() > 0) {
                        phndUmu = C_UmuKbn.ARI;
                    }
                }


                boolean checkKekka = checkKeisanCommonKaiyaku(syono);
                boolean  keisanWTsgFlg = false;

                if (!checkKekka) {

                    keisanWTsgFlg = true;
                }

                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {

                    keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
                    keisanKaiyakuBean = new KeisanKaiyakuBean();

                    keisanKaiyakuBean.setSyoruiukeymd(syoriYmd);
                    keisanKaiyakuBean.setKaiykymd(calckiJyunYmd);
                    keisanKaiyakuBean.setYenshrkwsrate(yenshrRateSyoriTime);
                    keisanKaiyakuBean.setGkshrkwsrate(yenshrRateSyoriTime);

                    C_ErrorKbn errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                        KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                        kykKihon,
                        calckiJyunYmd,
                        keisanKaiyakuBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        keisanWErrorKbnSyoriTime = "1";
                        keisanWErrorCnts++;
                    }
                    else {

                        keisanCommonKaiyakuOutBeanSyoriTime = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

                        if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai) && C_UmuKbn.ARI.eq(keisanCommonKaiyakuOutBeanSyoriTime.getZennoumijyuutouFlg())) {
                            keisanWErrorKbnSyoriTime = "1";
                            keisanWErrorCnts++;

                        }
                    }
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    haraikataKbn = "2";
                }
                else {
                    haraikataKbn = "1";
                }

                if (C_UmuKbn.ARI.eq(syuusinhknUmu)) {
                    syouhinBunruiKbn = "01";
                }
                else if (C_UmuKbn.ARI.eq(nkhknUmu)) {
                    syouhinBunruiKbn = "03";
                }

                if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

                    teikaiyakuhrkngataHyj = "1";
                }

                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    IT_KykDairiten kykDairitenKydbosyuu = kykKihon.getKykDairitenByDrtenrenno(2);

                    if (kykDairitenKydbosyuu == null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010,
                            ResourceUtil.getApplicationResources().getString(IT_KykDairiten.TABLE_NAME), syono + "　代理店連番：2"));
                    }

                    batukaiOyadrtncd = kykDairitenKydbosyuu.getOyadrtencd();
                    batukaiDrtncd = kykDairitenKydbosyuu.getDrtencd();
                    batukaiBosyuunincd = kykDairitenKydbosyuu.getBosyuucd();
                }

                if (C_UmuKbn.ARI.eq(syuusinhknUmu)) {
                    hknkknManryouYmd = "99999999";
                }
                else {
                    hknkknManryouYmd = String.valueOf(kykSyouhn.getHknkknmanryouymd().getPreviousDay());
                }

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykJyoutai)) {

                    hrkkaisuuKbn = "0";
                    annaihuyouRiyuuKbn = "01";
                }
                else if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                    hrkkaisuuKbn = "1";
                    annaihuyouRiyuuKbn = "07";
                }
                else {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                        hrkkaisuuKbn = "2";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                        hrkkaisuuKbn = "1";
                    }
                    else {

                        hrkkaisuuKbn = "3";
                    }

                    annaihuyouRiyuuKbn = "00";
                }

                if (C_Syoumetujiyuu.KYKTORIKESI.eq(syoumetuJiyuu) ||
                    C_Syoumetujiyuu.CLGOFF.eq(syoumetuJiyuu) ||
                    C_Syoumetujiyuu.MUKOU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "0350";
                }
                else if (C_Syoumetujiyuu.KAIJO.eq(syoumetuJiyuu)) {

                    syoumetuCd = "0351";
                }
                else if (C_Syoumetujiyuu.SIBOU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3090";
                }
                else if (C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3091";
                }
                else if (C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3092";
                }
                else if (C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3093";
                }
                else if (C_Syoumetujiyuu.SBKAIJO.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3250";
                }
                else if (C_Syoumetujiyuu.MENSEKI.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3251";
                }
                else if (C_Syoumetujiyuu.SBMUKOU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "3252";
                }
                else if (C_Syoumetujiyuu.KAIYAKU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "5010";
                }
                else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(syoumetuJiyuu) ||
                    C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(syoumetuJiyuu)) {

                    syoumetuCd = "5011";
                }
                else if (C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(syoumetuJiyuu)) {

                    syoumetuCd = "6020";
                }
                else if (C_Syoumetujiyuu.JIKOU.eq(syoumetuJiyuu)) {

                    syoumetuCd = "0100";
                }

                if (kykSyouhn.getSyoumetuymd() != null) {

                    syoumetuymd = kykSyouhn.getSyoumetuymd().toString();
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        hrkP = getIktnyknkgk(syono, syouhnCd, kykSyouhn.getSyouhnsdno(),
                            kykSyouhn.getRyouritusdno(), kykSyouhn.getHokenryou(), tikIktbriSyuruiKbn,
                            nyknJissekiRirekiSkei.getRstuukasyu());
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                            hrkP = kykSyouhn.getHokenryou();
                        }
                        else {

                            BizNumber enknsnyRt = BizNumber.valueOf(0);

                            if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                                enknsnyRt = tousyoKykjiKawaserate;
                            }
                            else {

                                enknsnyRt = nyuukinyouRateLastmonth;
                            }

                            hrkP = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getHokenryou(), enknsnyRt, C_HasuusyoriKbn.SUTE);
                        }
                    }
                }
                else {
                    C_Tuukasyu motokyktuukasyu = null;
                    if (yendthnkYmd != null) {

                        hrkP = henkoumaeP;
                        motokyktuukasyu = henkoumaekyktuukasyu;
                    }
                    else {

                        hrkP = kykSyouhn.getHokenryou();
                        motokyktuukasyu = kyktuukasyu;
                    }

                    if (C_UmuKbn.NONE.eq(gengakuUmu)) {

                        if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiSkei.getRstuukasyu())) {

                            hrkP = nyknJissekiRirekiSkei.getRsgaku();
                            motokyktuukasyu = nyknJissekiRirekiSkei.getRstuukasyu();
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(motokyktuukasyu)) {

                        if (yendthnkYmd != null) {

                            tousyoKykjiKawaserate = getKawaserate(
                                kykKihon.getFstpnyknymd(),
                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                                motokyktuukasyu,
                                C_Tuukasyu.JPY,
                                C_KawasetekiyoKbn.TTM,
                                C_KawasetsryKbn.NYUKINRATE ,
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                C_YouhiKbn.HUYOU);
                        }

                        hrkP = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            hrkP,
                            tousyoKykjiKawaserate,
                            C_HasuusyoriKbn.SUTE);
                    }
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {

                        nenkansanPHeijyun = hrkP;
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                        nenkansanPHeijyun = hrkP.multiply(2);
                    }
                    else {

                        nenkansanPHeijyun = hrkP.multiply(12);
                    }
                }

                int kykage = setNenrei.exec(kykYmd, kykSya.getKykseiymd());

                if (kykage > 99) {
                    kykage = 99;
                }

                String kykjiKyknen = Strings.padStart(String.valueOf(kykage), 2, '0');

                String genzaiKyknen = Strings.padStart(String.valueOf(setNenrei.exec(syoriYmd, kykSya.getKykseiymd())), 3, '0');

                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

                    KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(kykSya.getKyksei().getValue(),
                        C_Kyksei.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                    if (kbnInfoBean.isHenkanFlg()) {

                        kyksyaseiKbn = kbnInfoBean.getKbnData();
                    }
                    else {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                            IT_KykSya.KYKSEI, kykSya.getKyksei().getValue()));
                    }
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    hrkPJyuutouYm = ansyuKihon.getJkipjytym().getPreviousMonth();

                    if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai) && keisanCommonKaiyakuOutBeanSyoriTime.getLastpjytoym() != null) {

                        BizDateYM wkLastpjytoym = keisanCommonKaiyakuOutBeanSyoriTime.getLastpjytoym().addYears(1);

                        if (BizDateUtil.compareYm(wkLastpjytoym, ansyuKihon.getJkipjytym()) == BizDateUtil.COMPARE_LESSER) {
                            hrkPJyuutouYm = wkLastpjytoym.getPreviousMonth();
                            zennouseisankgkUmu = true;
                        }

                    }

                }
                else if (C_UmuKbn.ARI.eq(nkhknUmu)) {

                    hrkPJyuutouYm = kykSyouhn.getHknkknmanryouymd().getBizDateYM().getPreviousMonth();
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    if (C_Kykjyoutai.ZENNOU.eq(kykJyoutai)) {

                        IT_AnsyuKihon ansyuKihonForDetach = IT_AnsyuKihonDetacher.detachZennoustouched(ansyuKihon);
                        SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                        List<IT_Zennou> zennouList = sortIT_Zennou.OrderIT_ZennouByPkDesc(ansyuKihonForDetach.getZennous());

                        if (zennouList.size() == 0) {
                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                ResourceUtil.getApplicationResources().getString(IT_Zennou.TABLE_NAME), syono));
                        }

                        IT_Zennou zennou = zennouList.get(0);

                        kihrkmPJytYm = zennou.getAnnaisaikaiym().getPreviousMonth();
                    }
                    else {
                        kihrkmPJytYm = ansyuKihon.getJkipjytym().getPreviousMonth();
                    }
                }
                else if (C_UmuKbn.ARI.eq(nkhknUmu)) {

                    kihrkmPJytYm = kykSyouhn.getHknkknmanryouymd().getBizDateYM().getPreviousMonth();
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    IT_KykKihon kykKihonForNyknjisseki = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);
                    NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean =
                        kykKihonForNyknjisseki.getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg.BLNK);

                    kihrkmPMf = nyknJissekiRirekiByNyktrksflgBean.getSumRsgaku().get(nyknJissekiRirekiSkei.getRsgaku().getType());

                    if (zennouseisankgkUmu) {

                        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = khDairitenGetujiKykInfoFSksDao.getNyknJissekiRirekiBySyonoJyutoustartym(syono, hrkPJyuutouYm);

                        if (nyknJissekiRirekiLst != null && nyknJissekiRirekiLst.size() > 0) {
                            BizCurrency sumZennouseisankgk =
                                BizCurrency.valueOf(0, nyknJissekiRirekiSkei.getRsgaku().getType());

                            for (IT_NyknJissekiRireki nyknJissekiRirekiSaki : nyknJissekiRirekiLst) {

                                sumZennouseisankgk = sumZennouseisankgk.add(nyknJissekiRirekiSaki.getRsgaku());
                            }

                            kihrkmPMf = kihrkmPMf.subtract(sumZennouseisankgk);
                        }
                    }

                    if (!C_Tuukasyu.JPY.eq(nyknJissekiRirekiSkei.getRstuukasyu())) {

                        kihrkmPMf = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kihrkmPMf, tousyoKykjiKawaserate, C_HasuusyoriKbn.SUTE);
                    }

                    kihrkmPRuikei = kihrkmPMf;
                }
                else {

                    kihrkmPMf = hrkP;

                    kihrkmPRuikei = kihrkmPMf;
                }

                if ("5010".equals(syoumetuCd) || "5011".equals(syoumetuCd)) {

                    if (C_UmuKbn.ARI.eq(gengakuUmu)) {
                        keisanWErrorKbnSyoumetuTime = "2";
                        keisanWErrorSyoumetuTimeCnts++;

                    }

                    List<IT_KhTtdkRireki> ttdkRirekiKaiyakuList = hozenDomManager.getKhTtdkRirekisBySyonoGyoumuKousinKinous(syono, kinouIds);

                    if (ttdkRirekiKaiyakuList.size() == 0) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KhTtdkRireki.TABLE_NAME), syono));
                    }

                    IT_KhShrRireki khShrRireki = hozenDomManager
                        .getKhShrRirekiInfosBySyonoHenkousikibetukey(syono,
                            ttdkRirekiKaiyakuList.get(0).getHenkousikibetukey()).get(0).getIT_KhShrRireki();

                    if (khShrRireki == null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KhShrRireki.TABLE_NAME), syono));
                    }

                    List<IT_KhShrRirekiDetail> IT_KhShrRirekiDetailList = khShrRireki.getKhShrRirekiDetails();

                    kaiyksymtjiW = khShrRireki.getYensynykngk();
                    kaiyksymtjiKihrkm = khShrRireki.getYenhtykeihi();
                    kyksymtjUnyoujisoneki = kaiyksymtjiW.subtract(kaiyksymtjiKihrkm);
                    if (!kaiyksymtjiKihrkm.equalsValue(BizCurrency.valueOf(0))) {
                        kyksymtjUnyoujisonekiri = kyksymtjUnyoujisoneki.multiply(100).divideBizCurrency(kaiyksymtjiKihrkm, 0,
                            RoundingMode.DOWN);
                    }

                    if (yendthnkYmd == null) {

                        kaiyksymtjiWGaika = khShrRireki.getSyushrgkkei();

                        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                            huho2SjkkktyouseigkMva = IT_KhShrRirekiDetailList.get(0).getSjkkktyouseigk();
                            huho2Sjkkktusirrt = IT_KhShrRirekiDetailList.get(0).getKaiyakusjkkktyouseiriritu();
                            huho2Koujyoritu = IT_KhShrRirekiDetailList.get(0).getKaiyakukoujyoritu();

                        }
                    }
                    else {
                        huho2Yendthnkhr = khShrRireki.getYenkansansonotaseisangk();
                    }

                    for (IT_KhTtdkRireki ttdkRirekiKaiyaku : ttdkRirekiKaiyakuList) {
                        ttdkRirekiKaiyaku.detach();
                    }
                    khShrRireki.detach();
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    nenkansanPAnP = nenkansanPHeijyun;
                }
                else {
                    if (C_UmuKbn.ARI.eq(nkhknUmu)) {
                        nenkansanPAnP = hrkP.divide(kykSyouhn.getHknkkn(), 0, RoundingMode.DOWN);
                    }
                    else {

                        if (kykSyouhn.getHhknnen() >= 70) {

                            nenkansanPAnP = hrkP.divide(10, 0, RoundingMode.DOWN);
                        }
                        else {

                            nenkansanPAnP = hrkP.divide((80 - kykSyouhn.getHhknnen()), 0, RoundingMode.DOWN);
                        }
                    }
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                    if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {
                        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                            hrkPGaika = keisanGaikakanzan.execDivide(
                                kyktuukasyu,
                                kykSyouhn.getHokenryou(),
                                nyuukinyouRateLastmonth,
                                C_HasuusyoriKbn.AGE);
                        }
                        else {

                            hrkPGaika = kykSyouhn.getHokenryou();
                        }
                    }
                }
                else {

                    if (yendthnkYmd != null) {

                        hrkPGaika = henkoumaeP;
                    }
                    else {

                        hrkPGaika = kykSyouhn.getHokenryou();
                    }
                }

                if (yendthnkYmd == null) {

                    tuukaCd = convertTuukaCd(kyktuukasyu);

                    if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                        itijibrPGaika = kykSyouhn.getHokenryou();
                    }
                }
                else {

                    tuukaCd = convertTuukaCd(henkoumaekyktuukasyu);

                    if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                        itijibrPGaika = henkoumaeP;
                    }
                }
                if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    if (yendthnkYmd == null) {
                        itijibrPYen = hrkP;
                    }
                    else {
                        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            itijibrPYen =  kykSyouhn.getKihons();
                        }
                        else {

                            C_ErrorKbn errorKbn;

                            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                            KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
                            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

                            BizDateYM kijunYm = keisanWKijunYM.exec(
                                kykSyouhn.getKykymd(),
                                kykSyouhn.getYendthnkymd(),
                                null,
                                null,
                                kykSyouhn.getKykjyoutai(),
                                kykSyouhn.getSyouhncd(),
                                kykSyouhn.getYendthnkymd());

                            errorKbn = keisanWExt.exec(
                                kykSyouhn.getSyono(),
                                kykSyouhn.getYendthnkymd());

                            if (!C_ErrorKbn.OK.eq(errorKbn)) {
                                sonekiCalchunouFlg = "1";
                                sonekiCalchunouCnts++;
                            }
                            else {
                                keisanWExtBean = keisanWExt.getKeisanWExtBean();

                                errorKbn = keisanW.exec(
                                    kykSyouhn.getYendthnkymd(),
                                    kijunYm,
                                    keisanWExtBean);

                                if (!C_ErrorKbn.OK.eq(errorKbn)) {
                                    sonekiCalchunouFlg = "1";
                                    sonekiCalchunouCnts++;
                                }
                                else {
                                    itijibrPYen = keisanW.getV();
                                }
                            }
                        }
                    }
                }
                if (yendthnkYmd != null) {

                    List<IT_KhTtdkRireki> khTtdkRirekiLst = khDairitenGetujiKykInfoFSksDao.getKhTtdkRirekiInfos(
                        kykKihon, IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

                    if (khTtdkRirekiLst.size() == 0) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            ResourceUtil.getApplicationResources().getString(IT_KhTtdkRireki.TABLE_NAME), syono));
                    }

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(khTtdkRirekiLst.get(0).getSyorikbn())) {

                        targettkToutatubi = yendthnkYmd.getPreviousDay();
                    }

                }

                hhknnmkj = hhknSya.getHhknnmkj();

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                    mokuhyouTi = kykSonotaTkyk.getTargettkmokuhyouti();

                    KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
                    mokuhyouknGk = keisanTargetMokuhyougk.exec(kykSonotaTkyk.getTargettkykkijyungk(), mokuhyouTi);
                }

                if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    int getusuu = BizDateUtil.calcDifferenceMonths(kykYmd.getBizDateYM(), hrkPJyuutouYm.addMonths(1));


                    if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                        kihrpRuikeiGk = hrkP.multiply(getusuu).divide(12);

                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tikIktbriSyuruiKbn) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {

                        kihrpRuikeiGk = hrkP.multiply(getusuu).divide(6);
                    }
                    else {

                        kihrpRuikeiGk = hrkP.multiply(getusuu);
                    }
                }

                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {

                    if ("0".equals(keisanWErrorKbnSyoriTime)) {
                        kaiyakuhrYen = keisanCommonKaiyakuOutBeanSyoriTime.getKaiyakuHrYen();
                        if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {
                            kaiyakuhrGaika = keisanCommonKaiyakuOutBeanSyoriTime.getKaiyakuHr();
                        }
                        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                            if (yendthnkYmd == null) {
                                tmttknYen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    keisanCommonKaiyakuOutBeanSyoriTime.getPtumitatekin(),
                                    yenshrRateSyoriTime,
                                    C_HasuusyoriKbn.AGE);

                                tmttknGaika = keisanCommonKaiyakuOutBeanSyoriTime.getPtumitatekin();
                            }
                            else {
                                tmttknYen = keisanCommonKaiyakuOutBeanSyoriTime.getPtumitatekin();
                            }
                        }

                        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                            if (yendthnkYmd == null) {
                                kaiyakukjetcGaika = keisanCommonKaiyakuOutBeanSyoriTime.getKaiyakuKjgk();

                                kaiyakukjetcYen = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kaiyakukjetcGaika,
                                    yenshrRateSyoriTime,
                                    C_HasuusyoriKbn.AGE);
                            }
                        }

                        if (!(C_Hrkkaisuu.ITIJI.eq(hrkkaisuu))
                            && (C_UmuKbn.ARI.eq(gengakuUmu) || C_UmuKbn.ARI.eq(phndUmu))) {
                            sonekiCalchunouFlg = "1";
                            sonekiCalchunouCnts++;
                        }

                        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                            sonekiYen = kaiyakuhrYen.subtract(itijibrPYen);

                            if (yendthnkYmd == null) {

                                sonekiGaika = kaiyakuhrGaika.subtract(itijibrPGaika);
                            }
                        }
                        else {

                            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                                sonekiYen = kaiyakuhrYen.subtract(kihrkmPRuikei);
                            }
                        }
                    }
                    else {
                        sonekiCalchunouFlg = "1";
                        sonekiCalchunouCnts++;

                    }

                    C_ErrorKbn errorKbnP = calcHkShrKngk.execByKeisanWExt(syono, calckiJyunYmd,
                        C_SiinKbn.SP, C_HokenkinsyuruiKbn.SBHOKENKIN, kykKihon.getSdpdkbn(),
                        kykKihon.getHrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbnP)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "保険金額計算",syono));
                    }

                    CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

                    if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                        sbsetcYen = calcHkShrKngkBean.getSibousGk();
                    }
                    else {

                        sbsetcGaika = calcHkShrKngkBean.getSibousGk();
                        sbsetcYen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, sbsetcGaika, yenshrRateSyoriTime,
                            C_HasuusyoriKbn.AGE);
                    }

                    if ("0".equals(keisanWErrorKbnSyoriTime) && !keisanWTsgFlg) {
                        tmttHaitoukin = keisanCommonKaiyakuOutBeanSyoriTime.getTmtthaitoukinYen();
                        tkbtiHaitoukin = keisanCommonKaiyakuOutBeanSyoriTime.getYentkbthaitoukin();
                        sonotahaitoukin = keisanCommonKaiyakuOutBeanSyoriTime.getSonotahaitoukinYen();
                        gstsZeigk = keisanCommonKaiyakuOutBeanSyoriTime.getJpygstszeigk();
                    }

                    if (!C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
                        if ("0".equals(keisanWErrorKbnSyoriTime) && !keisanWTsgFlg) {

                            if (C_Tuukasyu.JPY.eq(kyktuukasyu) || syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                                mikeikaMisyuuP = keisanCommonKaiyakuOutBeanSyoriTime.getMikeikapYen();
                            }
                            else {

                                mikeikaMisyuuP = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    keisanCommonKaiyakuOutBeanSyoriTime.getMikeikapGk(),
                                    yenshrRateSyoriTime,
                                    C_HasuusyoriKbn.SUTE);
                            }

                            BizCurrency sonotaseisanGaikaEnknsn = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                keisanCommonKaiyakuOutBeanSyoriTime.getZennouseisankGk().add(
                                    keisanCommonKaiyakuOutBeanSyoriTime.getAzukariGanrikingk()),
                                    yenshrRateSyoriTime,
                                    C_HasuusyoriKbn.SUTE);


                            sonotaseisan =
                                keisanCommonKaiyakuOutBeanSyoriTime.getZennouseisankYen()
                                .add(keisanCommonKaiyakuOutBeanSyoriTime.getAzukariGanrikinYen())
                                .add(keisanCommonKaiyakuOutBeanSyoriTime.getKrkgkYen())
                                .add(sonotaseisanGaikaEnknsn);

                        }
                    }
                }

                if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {

                    if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn()) && "0".equals(keisanWErrorKbnSyoriTime)) {

                        if (yendthnkYmd == null) {

                            huho2Koujyoritu = keisanCommonKaiyakuOutBeanSyoriTime.getKaiyakuKjRitu();
                            huho2SjkkktyouseigkMva = keisanCommonKaiyakuOutBeanSyoriTime.getSjkkkTyouseiGk();
                            huho2Sjkkktusirrt = keisanCommonKaiyakuOutBeanSyoriTime.getKaiyakusjkkktyouseiriritu();
                        }
                        else {

                            huho2Yendthnkhr = keisanCommonKaiyakuOutBeanSyoriTime.getSonotaseisan();
                        }
                    }
                }

                ZT_SinBosyuuDrtenHoyuuKykTy sinBosyuuDrtenHoyuuKykTy = new ZT_SinBosyuuDrtenHoyuuKykTy();
                sinBosyuuDrtenHoyuuKykTy.setZtysyono(syono);
                sinBosyuuDrtenHoyuuKykTy.setZtymdhnaisyoumeicd(kykKihon.getAisyoumeikbn().getValue());
                sinBosyuuDrtenHoyuuKykTy.setZtyaisyoumeidrtengetuji(kykKihon.getAisyoumeikbn().getContent());
                sinBosyuuDrtenHoyuuKykTy.setZtyharaikatakbndrtengetuji(haraikataKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtysyohnbnrikbndrtengetuji(syouhinBunruiKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtyteikaiyakuhrkngatahyj(teikaiyakuhrkngataHyj);
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsyaatkioydrtencd(kykDairiten.getOyadrtencd());
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsybatkioydrtencd(batukaiOyadrtncd);
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsyaatkidrtencd(kykDairiten.getDrtencd());
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsybatkidrtencd(batukaiDrtncd);
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsyaatkibosyuucd(kykDairiten.getBosyuucd());
                sinBosyuuDrtenHoyuuKykTy.setZtyskeibsybatkibosyuucd(batukaiBosyuunincd);
                sinBosyuuDrtenHoyuuKykTy.setZtyhknsyukigou(syouhnCd.substring(0, 2));
                sinBosyuuDrtenHoyuuKykTy.setZtyhknsyuruikigousedaikbn(kykSyouhn.getRyouritusdno().substring(0, 1));
                sinBosyuuDrtenHoyuuKykTy.setZtykykymd(kykYmd.toString());
                sinBosyuuDrtenHoyuuKykTy.setZtyhknkknmanryouymd(hknkknManryouYmd);
                sinBosyuuDrtenHoyuuKykTy.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtyannaifuyouriyuukbn(annaihuyouRiyuuKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtysyoumetucd(syoumetuCd);
                sinBosyuuDrtenHoyuuKykTy.setZtysymtymd(syoumetuymd);
                sinBosyuuDrtenHoyuuKykTy.setZtyhrkpdrtengetuji(Long.parseLong(hrkP.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtynenkansanpheijyun(Long.parseLong(nenkansanPHeijyun.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtyknkyknm18(kykSya.getKyknmkn());
                sinBosyuuDrtenHoyuuKykTy.setZtykyknmdrtengetuji(kykSya.getKyknmkj());
                sinBosyuuDrtenHoyuuKykTy.setZtykyknenkykji(kykjiKyknen);
                sinBosyuuDrtenHoyuuKykTy.setZtykyknengenzai(genzaiKyknen);
                sinBosyuuDrtenHoyuuKykTy.setZtykyksyaseiymd(kykSya.getKykseiymd().toString());
                sinBosyuuDrtenHoyuuKykTy.setZtykyksyaseikbn(kyksyaseiKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtyhrkpjyuutouym(hrkPJyuutouYm.toString());
                sinBosyuuDrtenHoyuuKykTy.setZtykihrkmpjytym(kihrkmPJytYm.toString());
                sinBosyuuDrtenHoyuuKykTy.setZtykihrkmpmf(Long.parseLong(kihrkmPMf.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykihrkmpruikei(Long.parseLong(kihrkmPRuikei.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyksymtjiw(Long.parseLong(kaiyksymtjiW.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyksymtjikihrkmp(Long.parseLong(kaiyksymtjiKihrkm.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyksymtjiunyousoneki(Long.parseLong(kyksymtjUnyoujisoneki.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyksymtjiunyousonekirt(Long.parseLong(kyksymtjUnyoujisonekiri.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtywkeisanerrkbn(keisanWErrorKbnSyoumetuTime);
                sinBosyuuDrtenHoyuuKykTy.setZtymnknkskeisanerrkbn("0");
                sinBosyuuDrtenHoyuuKykTy.setZtynenkansanpanp(Long.parseLong(nenkansanPAnP.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtynenkansanpkeisanerrkbn(nenkansanPKeisanErrKbn);
                sinBosyuuDrtenHoyuuKykTy.setZtycifcd(kykKihon.getCifcd());
                sinBosyuuDrtenHoyuuKykTy.setZtyhrkpgaika(BizNumber.valueOf(new BigDecimal(hrkPGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyksymtjiwgaika(BizNumber.valueOf(new BigDecimal(kaiyksymtjiWGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtytuuka(tuukaCd);
                sinBosyuuDrtenHoyuuKykTy.setZtyitijibrpyendrtengetuji(Long.parseLong(itijibrPYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtyitijibrpgaika(BizNumber.valueOf(new BigDecimal(itijibrPGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtytmttknyen(Long.parseLong(tmttknYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtytmttkngaika(BizNumber.valueOf(new BigDecimal(tmttknGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyakukjetcyen(Long.parseLong(kaiyakukjetcYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyakukjetcgaika(BizNumber.valueOf(new BigDecimal(kaiyakukjetcGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtywyendrtengetuji(Long.parseLong(kaiyakuhrYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykaiyakuhrkngaika(BizNumber.valueOf(new BigDecimal(kaiyakuhrGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtysonekiyen(Long.parseLong(sonekiYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtysonekigaika(BizNumber.valueOf(new BigDecimal(sonekiGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtysbsetcyen(Long.parseLong(sbsetcYen.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtysbsetcgaika(BizNumber.valueOf(new BigDecimal(sbsetcGaika.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtysonekicalchunouflg(sonekiCalchunouFlg);
                sinBosyuuDrtenHoyuuKykTy.setZtyhhknnmkjdrtengetuji(hhknnmkj);
                sinBosyuuDrtenHoyuuKykTy.setZtytargettktoutatubi(targettkToutatubi.toString());
                sinBosyuuDrtenHoyuuKykTy.setZtymokuhyouti(mokuhyouTi.longValue());
                sinBosyuuDrtenHoyuuKykTy.setZtymokuhyoukngk(Long.parseLong(mokuhyouknGk.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtykihrpruikeigk(Long.parseLong(kihrpRuikeiGk.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtytousyokykjikawaserate(tousyoKykjiKawaserate);
                sinBosyuuDrtenHoyuuKykTy.setZtywkeisanerrorhyj(keisanWErrorKbnSyoriTime);
                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    sinBosyuuDrtenHoyuuKykTy.setZtygmeigyoubijikawaserate(gmeiGyoubijiKawaserate);
                }
                else {
                    sinBosyuuDrtenHoyuuKykTy.setZtygmeigyoubijikawaserate(BizNumber.valueOf(0));
                }
                sinBosyuuDrtenHoyuuKykTy.setZtytmtthaitoukin(Long.parseLong(tmttHaitoukin.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtytkbthaitoukin(Long.parseLong(tkbtiHaitoukin.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtysonotahaitoukin(Long.parseLong(sonotahaitoukin.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtygensentyousyuuzeigaku(Long.parseLong(gstsZeigk.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtymikeikamisyuup(Long.parseLong(mikeikaMisyuuP.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtysonotaseisankin(Long.parseLong(sonotaseisan.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtyhuho2sjkkktyouseigkmva(BizNumber.valueOf(new BigDecimal(huho2SjkkktyouseigkMva.toString())));
                sinBosyuuDrtenHoyuuKykTy.setZtyhuho2yendthnkhr(Long.parseLong(huho2Yendthnkhr.toString()));
                sinBosyuuDrtenHoyuuKykTy.setZtyhuho2sjkkktyouseiriritu(huho2Sjkkktusirrt);
                sinBosyuuDrtenHoyuuKykTy.setZtyhuho2kaiyakukoujyoritu(huho2Koujyoritu);

                BizPropertyInitializer.initialize(sinBosyuuDrtenHoyuuKykTy);

                sinBosyuuDrtenHoyuuKykTyInserter.add(sinBosyuuDrtenHoyuuKykTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        if (keisanWErrorCnts > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(keisanWErrorCnts), "解約返戻金計算エラー"));
        }

        if (keisanWErrorSyoumetuTimeCnts > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(keisanWErrorSyoumetuTimeCnts), "解約返戻金計算エラー（消滅分）"));
        }

        if (mnkNksKeisanErrCnts > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(mnkNksKeisanErrCnts), "満期年金開始計算エラー"));
        }

        if (nenkansanPKeisanErrCnts > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(nenkansanPKeisanErrCnts), "年換算保険料計算エラー"));
        }

        if (sonekiCalchunouCnts > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(sonekiCalchunouCnts), "損益計算不能"));
        }
    }

    private BizCurrency getIktnyknkgk(String pSyono, String pSyouhnCd, int pSyouhnsdNo,
        String pRyouritusdNo, BizCurrency pHokenryou, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn,
        C_Tuukasyu pRstuukasyu) {

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean = SWAKInjector
            .getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);

        keisanIkkatuNkgSyouhnBean.setSyouhnCd(pSyouhnCd);
        keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(pSyouhnsdNo);
        keisanIkkatuNkgSyouhnBean.setRyouritusdNo(pRyouritusdNo);
        keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
        keisanIkkatuNkgSyouhnBean.setHokenryou(pHokenryou);

        keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

        KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
        keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(pTkiktbrisyuruiKbn.getValue()));
        keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(pTkiktbrisyuruiKbn);
        keisanIkkatuNkgBean.setRstuukasyu(pRstuukasyu);
        keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
        keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
        keisanIkkatuNkgBean.setSyokaiprsYmd(null);
        keisanIkkatuNkgBean.setJyutoustartYm(null);

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);
        C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "月払一括入金額計算", pSyono));
        }
        return keisanTukiIkkatuNyuukinGk.getIktnyknkgk();
    }

    private String convertTuukaCd(C_Tuukasyu pTuukasyu) {

        String tuukaCd = "  ";

        if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            tuukaCd = "01";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

            tuukaCd = "15";
        }
        else if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            tuukaCd = "17";
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

    private boolean checkKeisanCommonKaiyaku(String pSyono) {

        List<JT_SkKihon> skKihonList =
            khDairitenGetujiKykInfoFSksDao.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
                pSyono, C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonList);

        if (skKihonList.size() != 0) {

            return false;
        }

        C_UktkSyoriKbn uktkSyoriKbn = C_UktkSyoriKbn.BLNK;

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = khDairitenGetujiKykInfoFSksDao.getKhHenkouUktkBySyono(pSyono);

        for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

            uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();
            if (C_UktkSyoriKbn.KAIYAKU.eq(uktkSyoriKbn)) {

                return false;
            }
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setSyoNo(pSyono);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

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

            if (TeisuuSiharai.JIMUTETUZUKICD_SISIBOU.equals(jimuTetuzukiCd)) {


                return false;
            }
        }

        return true;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
