package yuyu.batch.hozen.khinterf.khboshudairitenhoyukyksks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khboshudairitenhoyukyksks.dba.KhBoshuDairitenHoyuKykSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanNkNengk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.def.hozen.sorter.SortIT_KykUkt;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 募集代理店保有契約Ｆ作成クラス
 */
public class KhBoshuDairitenHoyuKykSksBatch implements Batch {

    private static final String TABLEID = "IT_KykKihon";

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhBoshuDairitenHoyuKykSksDao khBoshuDairitenHoyuKykSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        int kensuCount = 0;
        BizNumber syoriymdJisseikawaseRateUSD = BizNumber.ZERO;
        BizNumber syoriymdJisseikawaseRateAUD = BizNumber.ZERO;
        BizNumber syoriymdJisseikawaseRate = BizNumber.ZERO;
        BizNumber syoriymdNyukinkawaseRateUSD = BizNumber.ZERO;
        BizNumber syoriymdNyukinkawaseRateAUD = BizNumber.ZERO;
        BizNumber syoriymdNyukinkawaseRate = BizNumber.ZERO;

        syoriymdJisseikawaseRateUSD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        syoriymdJisseikawaseRateAUD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        syoriymdNyukinkawaseRateUSD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        syoriymdNyukinkawaseRateAUD = getKawaserate(
            syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        try (ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> kykDrtenInfoBeanList =
            hozenDomManager.getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(bzBatchParam.getIbKakutyoujobcd(),
                C_SyutkKbn.SYU);
            EntityInserter<ZT_BosyuuDrtenHoyuuKykTy> bosyuuDrtenHoyuuKykTyInserter = new EntityInserter<>()) {

            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            SortIT_KykUkt sortKykUkt =  SWAKInjector.getInstance(SortIT_KykUkt.class);
            SortIT_KhTtdkRireki sortKhTtdkRireki =  SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);
            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

            for (KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean kykDrtenInfoBean : kykDrtenInfoBeanList) {

                BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(
                    BzRecoveryDatasikibetuBean.class);

                IT_KykDairiten kykDairiten = kykDrtenInfoBean.getIT_KykDairiten();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykDairiten.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykDairiten.getSyono());

                IT_KykSyouhn kykSyouhn = kykDrtenInfoBean.getIT_KykSyouhn();
                IT_KykSonotaTkyk kykSonotaTkyk = kykDrtenInfoBean.getIT_KykSonotaTkyk();

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                    kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

                if (syouhnZokusei == null ) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0005,
                        BM_SyouhnZokusei.TABLE_NAME, BM_SyouhnZokusei.SYOUHNCD, kykSyouhn.getSyouhncd(),
                        BM_SyouhnZokusei.SYOUHNSDNO, kykSyouhn.getSyouhnsdno().toString()));
                }
                IT_KykSyouhnHnkmae kykSyouhnHnkmae = null;

                if (kykSyouhn.getYendthnkymd() != null) {

                    kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(kykDairiten.getSyono());

                    if (kykSyouhnHnkmae == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            IT_KykSyouhnHnkmae.TABLE_NAME, kykDairiten.getSyono()));
                    }

                }

                IT_KykSya kykSya = kykDrtenInfoBean.getIT_KykSya();

                List<BM_Address> addresses = bizDomManager.getAddressesByPostalCd(kykSya.getTsinyno());
                String todouhukencd = null;
                if (addresses.size() == 0) {
                    todouhukencd = "";
                }
                else {
                    todouhukencd = addresses.get(0).getTodouhukencd().getValue();
                }

                String syono = kykDairiten.getSyono();
                String syonosyuban = kykDairiten.getSyono() + " ";
                String kihontikucdkami3 = kykSya.getTsinyno().substring(0, 3);
                String kjkykadr = kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj() + kykSya.getTsinadr3kj();
                if (kjkykadr.length() > 50) {
                    kjkykadr = kjkykadr.substring(0, 50);
                }
                String syouhinBunruiKbn = "0";

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {

                    syouhinBunruiKbn = "C";
                }

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                    syouhinBunruiKbn = "B";
                }

                C_UmuKbn kyoudoubosyuUmu = kykDairiten.getDrtenbunumu();

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                BizDate tmmsmhneiKiJyunYmd = null;
                C_UmuKbn tumimasiMihanei = C_UmuKbn.NONE;

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    if (kykSyouhn.getYendthnkymd() == null &&
                        (BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYmd) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYmd) == BizDateUtil.COMPARE_EQUAL)) {

                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                            SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
                        hanteiTmttknJyoutaiBean.setSyono(syono);
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                        hanteiTmttknJyoutaiBean.setKykymd(kykSyouhn.getKykymd());

                        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!result) {
                            tumimasiMihanei = C_UmuKbn.ARI;

                            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(syono, syoriYmd);

                            if (sisurendoTmttknInfoBean == null) {

                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                    IT_KhSisuurendoTmttkn.TABLE_NAME, syono + "　計算基準日：" + syoriYmd));
                            }

                            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                            tmmsmhneiKiJyunYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                kykSyouhn.getKykymd(),
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(sisurendoTmttknInfoBean.getTmttknTaisyouYM(), kykSyouhn.getKykymd().getDay()).getRekijyou()).getPreviousDay();
                        }
                    }
                }

                BizDate calckiJyunYmd = null;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){

                    calckiJyunYmd = tmmsmhneiKiJyunYmd;
                }
                else {
                    if (BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER) {

                        calckiJyunYmd = kykSyouhn.getKykymd();
                    }
                    else {

                        calckiJyunYmd = syoriYmd;

                        if (kykSyouhn.getYendthnkymd() != null) {
                            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                                calckiJyunYmd = kykSyouhn.getYendthnkymd();
                            }
                        }
                        else {
                            if (kykSyouhn.getTmttknitenymd() != null && BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_LESSER) {
                                calckiJyunYmd = kykSyouhn.getTmttknitenymd();
                            }
                        }
                    }
                }

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                        syoriymdJisseikawaseRate = syoriymdJisseikawaseRateUSD;
                        syoriymdNyukinkawaseRate = syoriymdNyukinkawaseRateUSD;
                    }
                    else {
                        syoriymdJisseikawaseRate = syoriymdJisseikawaseRateAUD;
                        syoriymdNyukinkawaseRate = syoriymdNyukinkawaseRateAUD;
                    }
                }


                C_Tuukasyu rstuukasyuhanteiKekka = C_Tuukasyu.BLNK;

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    C_ErrorKbn asPRsTuukaErrorKbn = getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(
                        kykSyouhn.getKyktuukasyu(),
                        kykSonotaTkyk.getYennykntkhkumu(),
                        kykSonotaTkyk.getGaikanykntkhkumu());

                    if (C_ErrorKbn.ERROR.eq(asPRsTuukaErrorKbn)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010,"保険料領収通貨取得"));
                    }
                    rstuukasyuhanteiKekka = getasPRsTuuka.getRstuukasyu();
                }

                IT_KykKihon kykKihon = kykDrtenInfoBean.getIT_KykKihon();

                List<IT_NyknJissekiRireki> nyknJissekiRirekiList = new ArrayList<>();
                BizCurrency rsgaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                C_Tuukasyu rsTuukaSyu = C_Tuukasyu.BLNK;

                nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

                if (nyknJissekiRirekiList == null || nyknJissekiRirekiList.size() == 0) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                        IT_NyknJissekiRireki.TABLE_NAME, syono));
                }

                rsgaku = nyknJissekiRirekiList.get(0).getRsgaku();
                rsTuukaSyu = nyknJissekiRirekiList.get(0).getRstuukasyu();

                IT_KykSyouhn kyksyouhnnenkanzanp = new IT_KykSyouhn();
                BeanUtil.copyProperties(kyksyouhnnenkanzanp, kykSyouhn);

                List<IT_KykSyouhnRireki> kyksyouhnrirekiLst = khBoshuDairitenHoyuKykSksDao.getKykSyouhnRirekisBySyonoSyutkKbn(syono, C_SyutkKbn.SYU);

                if (kyksyouhnrirekiLst.size() > 0) {
                    BeanUtil.copyProperties(kyksyouhnnenkanzanp, kyksyouhnrirekiLst.get(0));
                }

                IT_Zennou zennou = null;
                if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
                    IT_AnsyuKihon ansyuKihon = kykDrtenInfoBean.getIT_AnsyuKihon();
                    List<IT_Zennou> zennouList = ansyuKihon.getZennous();
                    if (zennouList.size() == 0) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            IT_Zennou.TABLE_NAME, syono));
                    }

                    zennou = zennouList.get(0);
                }

                BizNumber zrnnnknsnpssykawaseraten5 = BizNumber.ZERO;

                if (!C_Tuukasyu.JPY.eq(kyksyouhnnenkanzanp.getKyktuukasyu())) {
                    C_UmuKbn zennoumousideUmu = C_UmuKbn.NONE;
                    C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;
                    GetKawaseRate getKawaseRateNenp = SWAKInjector.getInstance(GetKawaseRate.class);
                    BizDate kwsrateKjYmd = null;

                    if (zennou != null) {

                        zennoumousideUmu = C_UmuKbn.ARI;
                    }

                    if (C_UmuKbn.ARI.eq(nyknJissekiRirekiList.get(0).getIktnyuukinnumu())) {

                        ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                    }

                    C_ErrorKbn getKawaseRateErrorKbn;

                    if (C_Tuukasyu.JPY.eq(rstuukasyuhanteiKekka)) {
                        getKawaseRateErrorKbn = getKawaseRateNenp.execFstPNyuukin(
                            kykKihon.getFstpnyknymd(),
                            kyksyouhnnenkanzanp.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_YouhiKbn.HUYOU,
                            nyknJissekiRirekiList.get(0).getHrkkaisuu(),
                            C_SysKbn.SKEI,
                            zennoumousideUmu,
                            ikkatubaraiKbn);

                    }
                    else {
                        getKawaseRateErrorKbn  = getKawaseRateNenp.execHyoukagk(
                            kykKihon.getFstpnyknymd(),
                            kyksyouhnnenkanzanp.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_YouhiKbn.HUYOU,
                            nyknJissekiRirekiList.get(0).getHrkkaisuu(),
                            zennoumousideUmu,
                            ikkatubaraiKbn);
                    }

                    if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                            getKawaseRateNenp.getKwsrateKjYmd().toString(),
                            kyksyouhnnenkanzanp.getKyktuukasyu().getValue(),
                            C_Tuukasyu.JPY.getValue()));
                    }

                    zrnnnknsnpssykawaseraten5 = getKawaseRateNenp.getKawaserate();

                }

                String hrkhouhoukbn = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    hrkhouhoukbn = "1";
                }
                else {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                        hrkhouhoukbn = "6";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                        hrkhouhoukbn = "5";
                    }
                    else {

                        hrkhouhoukbn = "8";
                    }
                }

                String syukinkbn = "";

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro()) ||
                    C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {
                    syukinkbn = "2";
                }
                else {
                    syukinkbn = "1";
                }

                String bnkaisuu = "";

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                        bnkaisuu = "02";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                        bnkaisuu = "01";
                    }
                    else {

                        bnkaisuu = "12";
                    }
                }

                String bnkyk1KaiPbsDirtnhykyk = "";
                BizCurrency bnkyk1KaiP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    bnkyk1KaiPbsDirtnhykyk = "0000000000";
                }
                else {

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        BizCurrency wkIkkatuNkg = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
                        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
                        KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
                        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

                        keisanIkkatuNkgSyouhnBean.setSyouhnCd(kykSyouhn.getSyouhncd());
                        keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                        keisanIkkatuNkgSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
                        keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
                        keisanIkkatuNkgSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());

                        keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

                        keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
                        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().toString()));
                        keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(kykKihon.getTikiktbrisyuruikbn());
                        keisanIkkatuNkgBean.setRstuukasyu(C_Tuukasyu.JPY);
                        keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                        keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
                        keisanIkkatuNkgBean.setSyokaiprsYmd(null);
                        keisanIkkatuNkgBean.setJyutoustartYm(null);

                        C_ErrorKbn errorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010,
                                    "月払一括入金額計算",
                                    syono));
                        }

                        wkIkkatuNkg = keisanTukiIkkatuNyuukinGk.getIktnyknkgk();

                        bnkyk1KaiP = wkIkkatuNkg;
                        bnkyk1KaiPbsDirtnhykyk = wkIkkatuNkg.toAdsoluteString();
                    }
                    else {
                        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            bnkyk1KaiP = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                kykSyouhn.getHokenryou(),
                                zrnnnknsnpssykawaseraten5,
                                C_HasuusyoriKbn.SUTE);

                            bnkyk1KaiPbsDirtnhykyk = bnkyk1KaiP.toAdsoluteString();

                        }
                        else {
                            bnkyk1KaiP = kykSyouhn.getHokenryou();
                            bnkyk1KaiPbsDirtnhykyk = kykSyouhn.getHokenryou().toAdsoluteString();
                        }
                    }
                }

                String goukeiPbsDirtnhyKyk = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    goukeiPbsDirtnhyKyk = "0000000000";
                }
                else {
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        goukeiPbsDirtnhyKyk = BizNumber.valueOf(new BigDecimal(bnkyk1KaiP.
                            toAdsoluteString())).multiply(BizNumber.valueOf(12).divide(BizNumber.valueOf
                                (Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue())))).toString();
                    }
                    else {
                        goukeiPbsDirtnhyKyk = BizNumber.valueOf(new BigDecimal(bnkyk1KaiP.
                            toAdsoluteString())).multiply(BizNumber.valueOf(12).divide(BizNumber.valueOf
                                (Integer.valueOf(kykKihon.getHrkkaisuu().getValue())))).toString();
                    }
                }

                String bnsyuruiKbn = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    bnsyuruiKbn = "00";
                }
                else {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                        bnsyuruiKbn = "14";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                        bnsyuruiKbn = "15";
                    }
                    else {

                        bnsyuruiKbn = "01";
                    }
                }

                IT_KykDairiten kykDairitenTmp = new IT_KykDairiten();
                if (C_UmuKbn.ARI.eq(kyoudoubosyuUmu)) {

                    IT_KykKihon kykKihonTmp = hozenDomManager.getKykKihon(syono);
                    kykKihonTmp = IT_KykKihonDetacher.detachKykDairitentouched(kykKihonTmp);

                    kykDairitenTmp = kykKihonTmp.getKykDairitenByDrtenrenno(2);

                    if (null == kykDairitenTmp) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            IT_KykDairiten.TABLE_NAME, syono + "　代理店連番：2"));
                    }
                }

                String hhkntdk = "";
                String hhknyno = "";
                String kjhhknadr = "";

                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

                    hhkntdk = "01";
                    hhknyno = kykSya.getTsinyno();
                    kjhhknadr = kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj() + kykSya.getTsinadr3kj();
                    if (kjhhknadr.length() > 50) {
                        kjhhknadr = kjhhknadr.substring(0, 50);
                    }
                }
                else {

                    hhkntdk = "99";
                    hhknyno = "";
                    kjhhknadr = "";
                }

                IT_HhknSya hhknSya = kykDrtenInfoBean.getIT_HhknSya();
                String hhknsei = "";

                KbnInfoBean kbnInfoBean =  bzKbnHenkanUtil.convKbn(hhknSya.getHhknsei().getValue(),
                    C_Hhknsei.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                if (kbnInfoBean.isHenkanFlg()) {
                    hhknsei = kbnInfoBean.getKbnData();
                }
                else {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                        IT_HhknSya.HHKNSEI, hhknSya.getHhknsei().getValue()));
                }

                String hrkkeiro = "";

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    hrkkeiro = "1";
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())){

                    hrkkeiro = "6";
                }
                else {

                    hrkkeiro = "5";
                }

                String mankiymd = "";
                String syuhknkkn = "";

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {
                    mankiymd = "";
                    syuhknkkn = "00";
                }
                else {
                    mankiymd = kykSyouhn.getHknkknmanryouymd().addDays(-1).getRekijyou().toString();
                    syuhknkkn = kykSyouhn.getHknkkn().toString();
                }

                String syuhknkknkbn = "";
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {
                    syuhknkknkbn = "3";
                }
                else if (C_HknkknsmnKbn.NENMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {
                    syuhknkknkbn = "1";
                }
                else if (C_HknkknsmnKbn.SAIMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {
                    syuhknkknkbn = "2";
                }

                String syuHrkkknKbn = "";

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    syuHrkkknKbn = "2";
                }

                String syuHrkkkn = "";

                if ("2".equals(syuHrkkknKbn)) {

                    syuHrkkkn = kykSyouhn.getHrkkkn().toString();
                }

                C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

                kykKihon = hozenDomManager.getKykKihon(syono);

                List<IT_KhTtdkRireki> ttdkRirekiList =
                    kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(
                        IKhozenCommonConstants.KINOUID_GENGAKU);

                if (ttdkRirekiList != null && ttdkRirekiList.size() > 0) {
                    gengakuExistsCheck = C_UmuKbn.ARI;

                }

                BizNumber fstpnyknymdJisseikawaseRate = BizNumber.ZERO;
                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    fstpnyknymdJisseikawaseRate = getKawaserate(
                        kykKihon.getFstpnyknymd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                }

                BizNumber fstpnyknymdNyukinkawaseRate = BizNumber.ZERO;
                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        fstpnyknymdNyukinkawaseRate = getKawaserate(
                            kykKihon.getFstpnyknymd().getPreviousDay(),
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                    }else{
                        fstpnyknymdNyukinkawaseRate = getKawaserate(
                            kykKihon.getFstpnyknymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.NYUKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);
                    }
                }

                BizCurrency itijibrp = null;

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    if (kykSyouhn.getYendthnkymd() != null) {

                        itijibrp = kykKihon.getHrkp();
                    }
                    else {

                        if (!C_UmuKbn.ARI.eq(gengakuExistsCheck)) {
                            if (!C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                                itijibrp = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykKihon.getHrkp(),
                                    fstpnyknymdJisseikawaseRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                            else {
                                itijibrp = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykKihon.getHrkp(),
                                    fstpnyknymdNyukinkawaseRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                        }
                        else {
                            if (!C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
                                itijibrp = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykKihon.getHrkp(),
                                    syoriymdJisseikawaseRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                            else {
                                itijibrp = keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    kykKihon.getHrkp(),
                                    syoriymdNyukinkawaseRate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                        }
                    }
                }
                else {

                    itijibrp = BizCurrency.valueOf(0);
                }

                BizCurrency syus = null;
                BizCurrency dais = null;
                BizCurrency saiGaisbs = null;
                CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
                KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);
                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
                KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);

                KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

                if ((syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) ||
                    ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                    BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYmd) <= BizDateUtil.COMPARE_EQUAL)) {
                    C_ErrorKbn errorKbnWExt = keisanWExt.exec(syono, calckiJyunYmd);
                    if (C_ErrorKbn.OK.eq(errorKbnWExt)) {

                        keisanWExtBean = keisanWExt.getKeisanWExtBean();
                    }
                    else {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算拡張情報作成",
                            syono));
                    }

                }

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
                    GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
                    getYoteirirituBean.setSyouhncd(keisanWExtBean.getSyouhncd());
                    getYoteirirituBean.setKijyunymd(keisanWExtBean.getKykymd());
                    getYoteirirituBean.setSknnkaisiymd(keisanWExtBean.getKykymd());
                    getYoteirirituBean.setKykymd(keisanWExtBean.getKykymd());
                    getYoteirirituBean.setHknkkn(keisanWExtBean.getHknkkn());
                    getYoteirirituBean.setHknkknsmnkbn(keisanWExtBean.getHknkknsmnkbn());
                    getYoteirirituBean.setHhknnen(keisanWExtBean.getHhknnen());
                    getYoteirirituBean.setSitihsyuriritu(keisanWExtBean.getYoteirrthendohosyurrt());
                    getYoteirirituBean.setTuukasyu(keisanWExtBean.getTuukasyu());

                    C_ErrorKbn errorKbnRiritu = getYoteiriritu.exec(getYoteirirituBean);
                    if (!C_ErrorKbn.OK.eq(errorKbnRiritu)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "予定利率取得",
                            kykKihon.getSyono()));
                    }

                    CurrencyType keiyakuType = henkanTuuka.henkanTuukaKbnToType(keisanWExtBean.getTuukasyu());

                    keisanVHeijyunBean.setSyouhncd(keisanWExtBean.getSyouhncd());
                    keisanVHeijyunBean.setRyouritusdno(keisanWExtBean.getRyouritusdno());
                    keisanVHeijyunBean.setCalckijyunYm(kykSyouhn.getHknkknmanryouymd().getBizDateYM());
                    keisanVHeijyunBean.setKykymd(keisanWExtBean.getKykymd());
                    keisanVHeijyunBean.setHokenryou(keisanWExtBean.getHokenryou());
                    keisanVHeijyunBean.setKyktuukasyu(keisanWExtBean.getTuukasyu());
                    keisanVHeijyunBean.setHhknsei(keisanWExtBean.getHhknsei());
                    keisanVHeijyunBean.setHhknnen(keisanWExtBean.getHhknnen());
                    keisanVHeijyunBean.setHknkkn(keisanWExtBean.getHknkkn());
                    keisanVHeijyunBean.setHknkknsmnkbn(keisanWExtBean.getHknkknsmnkbn());
                    keisanVHeijyunBean.setHrkkkn(keisanWExtBean.getHrkkkn());
                    keisanVHeijyunBean.setHrkkknsmnkbn(keisanWExtBean.getHrkkknsmnkbn());
                    keisanVHeijyunBean.setHrkkaisuu(keisanWExtBean.getHrkkaisuu());
                    keisanVHeijyunBean.setFstpryosyu(keisanWExtBean.getFstpryosyuymd());
                    keisanVHeijyunBean.setSitihsyuriritu(keisanWExtBean.getYoteirrthendohosyurrt());
                    keisanVHeijyunBean.setTmttkntaisyouym(null);
                    keisanVHeijyunBean.setCalckaisiYmjitenv(BizCurrency.valueOf(0, keiyakuType));
                    keisanVHeijyunBean.setCalckaisiYmjitensump(BizCurrency.valueOf(0, keiyakuType));
                    keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
                    keisanVHeijyunBean.setSisansyoriYmd(keisanWExtBean.getKykymd());
                    keisanVHeijyunBean.setSisanyoteiriritu(getYoteiriritu.getYoteiriritu());
                    keisanVHeijyunBean.setSisankawaserate(fstpnyknymdNyukinkawaseRate);

                    C_ErrorKbn kekkaKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

                    if (!C_ErrorKbn.OK.eq(kekkaKbn)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "平準払用保険料積立金計算",
                            kykKihon.getSyono()));
                    }

                    KeisanNkNengk keisanNkNengk = SWAKInjector.getInstance(KeisanNkNengk.class);
                    C_ErrorKbn errorKbnNK = keisanNkNengk.exec(kykSyouhn.getNksyukbn(), kykSyouhn.getRyouritusdno(),
                        kykSyouhn.getKyktuukasyu(), kykSyouhn.getNenkinkkn(), kykSyouhn.getHknkkn(),
                        C_Seibetu.valueOf(kykSyouhn.getHhknsei().getValue()), keisanVHeijyun.getV());

                    if (!C_ErrorKbn.OK.eq(errorKbnNK)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "年金年額計算",
                            kykKihon.getSyono()));
                    }


                    C_ErrorKbn errorKbnP = calcHkShrKngk.execByKeisanWExt(
                        syono,
                        calckiJyunYmd,
                        C_SiinKbn.SP,
                        C_HokenkinsyuruiKbn.SBHOKENKIN,
                        kykKihon.getSdpdkbn(),
                        kykKihon.getHrkkeiro());

                    if (!C_ErrorKbn.OK.eq(errorKbnP)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "保険金額計算",
                            kykKihon.getSyono()));
                    }

                    syus = keisanGaikakanzan.exec(C_Tuukasyu.JPY, keisanNkNengk.getNkNengk(), syoriymdJisseikawaseRate,
                        C_HasuusyoriKbn.SUTE);

                    dais = keisanGaikakanzan.exec(C_Tuukasyu.JPY, calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk(),
                        syoriymdJisseikawaseRate, C_HasuusyoriKbn.SUTE);

                    saiGaisbs = keisanGaikakanzan.exec(C_Tuukasyu.JPY, calcHkShrKngk.getCalcHkShrKngkBean()
                        .getHokenknGk(), syoriymdJisseikawaseRate, C_HasuusyoriKbn.SUTE);
                }
                else {

                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                            C_ErrorKbn errorKbnP = calcHkShrKngk.execByKeisanWExt(
                                syono,
                                calckiJyunYmd,
                                C_SiinKbn.SP,
                                C_HokenkinsyuruiKbn.SBHOKENKIN,
                                kykKihon.getSdpdkbn(),
                                kykKihon.getHrkkeiro());

                            if (!C_ErrorKbn.OK.eq(errorKbnP)) {

                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "保険金額計算",
                                    syono));
                            }

                            syus = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                            dais = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                            saiGaisbs = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                        }
                        else {
                            syus = kykSyouhn.getKihons();
                            dais = kykSyouhn.getKihons();
                            saiGaisbs = kykSyouhn.getKihons();

                        }
                    }
                    else {
                        BizNumber kawaseRate = null;
                        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                            kawaseRate = syoriymdJisseikawaseRate;
                        }
                        else {
                            kawaseRate = fstpnyknymdJisseikawaseRate;
                        }
                        syus = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getKihons(),
                            kawaseRate, C_HasuusyoriKbn.SUTE);

                        dais = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getKihons(),
                            kawaseRate, C_HasuusyoriKbn.SUTE);

                        saiGaisbs = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getKihons(),
                            kawaseRate, C_HasuusyoriKbn.SUTE);
                    }
                }

                BizCurrency siteiTuukaItijiBrp = BizCurrency.valueOf(0);
                BizCurrency siteiTuukaSyus = BizCurrency.valueOf(0);
                BizCurrency siteiTuukaSbs = BizCurrency.valueOf(0);
                BizCurrency siteiTuukaSaigaiBs = BizCurrency.valueOf(0);

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    siteiTuukaItijiBrp = kykKihon.getHrkp();
                }

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                    siteiTuukaSyus = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                    siteiTuukaSbs = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                    siteiTuukaSaigaiBs = calcHkShrKngk.getCalcHkShrKngkBean().getHokenknGk();
                }
                else {

                    if (kykSyouhn.getYendthnkymd() != null) {
                        siteiTuukaSyus = kykSyouhnHnkmae.getKihons();
                        siteiTuukaSbs = kykSyouhnHnkmae.getKihons();
                        siteiTuukaSaigaiBs = kykSyouhnHnkmae.getKihons();

                    }
                    else {
                        if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                            siteiTuukaSyus = kykSyouhn.getKihons();
                            siteiTuukaSbs = kykSyouhn.getKihons();
                            siteiTuukaSaigaiBs = kykSyouhn.getKihons();
                        }
                    }
                }

                String siteiTuukaCd = "";

                if (kykSyouhn.getYendthnkymd() != null) {
                    if (C_Tuukasyu.JPY.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteiTuukaCd = "000";
                    }
                    else if (C_Tuukasyu.USD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteiTuukaCd = "001";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {
                        siteiTuukaCd = "002";
                    }

                }
                else {
                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                        siteiTuukaCd = "";
                    }
                    else if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteiTuukaCd = "001";
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhn.getKyktuukasyu())) {
                        siteiTuukaCd = "002";
                    }
                }

                BizCurrency hrkTuukaitijiBrp = BizCurrency.valueOf(0);

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    hrkTuukaitijiBrp = rsgaku;
                }

                String hrkTuukaCd = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    if (C_Tuukasyu.JPY.eq(rsTuukaSyu)) {
                        hrkTuukaCd = "000";
                    }
                    if (C_Tuukasyu.USD.eq(rsTuukaSyu)) {
                        hrkTuukaCd = "001";
                    }
                    if (C_Tuukasyu.AUD.eq(rsTuukaSyu)) {
                        hrkTuukaCd = "002";
                    }
                }
                else {
                    if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                        hrkTuukaCd = "";
                    }
                    else {
                        if (C_Tuukasyu.JPY.eq(rstuukasyuhanteiKekka)) {
                            hrkTuukaCd = "000";
                        }
                        if (C_Tuukasyu.USD.eq(rstuukasyuhanteiKekka)) {
                            hrkTuukaCd = "001";
                        }
                        if (C_Tuukasyu.AUD.eq(rstuukasyuhanteiKekka)) {
                            hrkTuukaCd = "002";
                        }
                    }
                }

                String nkshrkknkbn = "";
                String nkshrkknnen = "";
                String nkshrstartymd = "";
                BizNumber tumitateriritu = BizNumber.valueOf(0);
                BizNumber tmttknzoukaritujygn = BizNumber.valueOf(0);
                BizNumber setteibairitu = BizNumber.valueOf(0);
                long tumitatekngk = 0;


                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                    nkshrstartymd = kykSyouhn.getHknkknmanryouymd().toString();

                    if (C_Nenkinsyu.KAKUTEINENKIN.eq(kykSyouhn.getNksyukbn())
                        || C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.eq(kykSyouhn.getNksyukbn())) {

                        nkshrkknkbn = "1";
                        nkshrkknnen = String.valueOf(kykSyouhn.getNenkinkkn());
                    }
                    else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(kykSyouhn.getNksyukbn())) {

                        nkshrkknkbn = "3";
                        nkshrkknnen = "000";
                    }
                    else {

                        nkshrkknkbn = "";
                        nkshrkknnen = "000";
                    }

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        tumitateriritu = kykSyouhn.getTumitateriritu();
                    }

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                        tmttknzoukaritujygn = kykSyouhn.getTmttknzoukaritujygn();
                        setteibairitu = kykSyouhn.getSetteibairitu();
                    }

                    if ((syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                        BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER) {

                        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(syono, calckiJyunYmd);

                        if (sisurendoTmttknInfoBean == null) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                IT_KhSisuurendoTmttkn.TABLE_NAME, syono + "　計算基準日：" + calckiJyunYmd));
                        }

                        tumitatekngk = Long.parseLong(sisurendoTmttknInfoBean.getTeirituTmttknGK().add(
                            sisurendoTmttknInfoBean.getSisuuRendouTmttknGK()).toAdsoluteString());
                    }
                    else {
                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
                        IT_AnsyuKihon ansyuKihon = kykDrtenInfoBean.getIT_AnsyuKihon();

                        BizDateYM kijyunYM = keisanWKijunYM.exec(kykSyouhn.getKykymd(), calckiJyunYmd,
                            ansyuKihon.getJkipjytym(), kykKihon.getHrkkaisuu(), kykSyouhn.getKykjyoutai(),
                            keisanWExtBean.getSyouhncd(), keisanWExtBean.getYendthnkymd());

                        C_ErrorKbn errorKbn = keisanW.exec(calckiJyunYmd, kijyunYM, keisanWExtBean);
                        if (!C_ErrorKbn.OK.eq(errorKbn)) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算", syono));
                        }
                        tumitatekngk = Long.parseLong(keisanW.getV().toAdsoluteString());
                    }
                }
                else {
                    nkshrkknkbn = "";
                    nkshrkknnen = "000";
                    nkshrstartymd = "00000000";
                    tmttknzoukaritujygn = BizNumber.ZERO;
                    setteibairitu =BizNumber.ZERO;
                    tumitatekngk = 0;

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                        tumitateriritu = kykSyouhn.getTumitateriritu();
                    }
                }


                List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();

                List<String> kjtkhosyunmList = new ArrayList<>();
                int tksuu = 0;

                if (kykSyouhn.getYendthnkymd() != null) {

                    tksuu++;
                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                        kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTNKIKOU);
                    }
                    else {
                        kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTSYSNIKOU);
                    }

                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KYKDRTKYK);
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU);
                }

                if (itTrkKzkList.size() > 0) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KZKTOUROKUSERVICE);
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTSBSAITEIHOSYOU);

                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KAIGOMAEHRTKYK);

                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                    tksuu = tksuu + 1;

                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                        kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTNKHENTK);
                    }
                    else {
                        kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTSYSNHENTK);
                    }

                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENKHRIKMTK);

                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {

                    tksuu = tksuu + 1;

                    kjtkhosyunmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_STIGITUUKAHRK);

                }

                for (int i = 0; i < 6 - tksuu; i++) {

                    kjtkhosyunmList.add("");
                }

                String sinsakbn = "";

                if (C_SntkhouKbn.KKT.eq(kykKihon.getSntkhoukbn())) {
                    sinsakbn = "1";
                }
                else {
                    sinsakbn = "";
                }

                String zeiseitekikaku = "";

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

                    zeiseitekikaku = "1";
                }

                String kykjyoutaikbn = "";
                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    kykjyoutaikbn = "1";
                }
                else if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {

                    if (C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kykjyoutaikbn = "3";
                    }
                    else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())
                        || C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhn.getSyoumetujiyuu())
                        || C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kykjyoutaikbn = "2";
                    }
                    else {
                        kykjyoutaikbn = "4";
                    }
                }

                IT_KykKihon kykKihonTemp = IT_KykKihonDetacher.detachKykUkttouched(
                    hozenDomManager.getKykKihon(kykDairiten.getSyono()));

                String sbuktdisphukusuhyj = "";
                String sbuktnmkn = "";
                String sbuktnmkj = "";

                if (kykKihon.getSbuktnin() > 1) {
                    sbuktdisphukusuhyj = "1";
                }
                else {
                    sbuktdisphukusuhyj = "0";
                }

                if (kykKihon.getSbuktnin() >= 5) {
                    sbuktnmkn = "";
                    sbuktnmkj = "";
                }
                else {
                    List<IT_KykUkt> kykSbUktList = sortKykUkt.OrderIT_KykUktByPkAsc(
                        kykKihonTemp.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT));

                    if (kykSbUktList == null || kykSbUktList.size() == 0) {
                        sbuktnmkn = "";
                        sbuktnmkj = "";
                    }
                    else {
                        if (C_UktKbn.KYK.eq(kykSbUktList.get(0).getUktkbn())) {
                            sbuktnmkn = kykSya.getKyknmkn();
                            sbuktnmkj = kykSya.getKyknmkj();
                        }
                        else if (C_UktKbn.HHKN.eq(kykSbUktList.get(0).getUktkbn())) {
                            sbuktnmkn = hhknSya.getHhknnmkn();
                            sbuktnmkj = hhknSya.getHhknnmkj();
                        }
                        else {
                            sbuktnmkn = kykSbUktList.get(0).getUktnmkn();
                            sbuktnmkj = kykSbUktList.get(0).getUktnmkj();
                        }
                    }
                }

                String mnkuktnmkn = "";
                String mnkuktnmkj = "";

                List<IT_KykUkt> kykNkUktList = sortKykUkt.OrderIT_KykUktByPkAsc(
                    kykKihonTemp.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT));

                if (kykNkUktList == null || kykNkUktList.size() == 0 || kykNkUktList.size() >= 5) {
                    mnkuktnmkn = "";
                    mnkuktnmkj = "";
                }
                else {
                    if (C_UktKbn.KYK.eq(kykNkUktList.get(0).getUktkbn())) {
                        mnkuktnmkn = kykSya.getKyknmkn();
                        mnkuktnmkj = kykSya.getKyknmkj();
                    }
                    else if (C_UktKbn.HHKN.eq(kykNkUktList.get(0).getUktkbn())) {
                        mnkuktnmkn = hhknSya.getHhknnmkn();
                        mnkuktnmkj = hhknSya.getHhknnmkj();
                    }
                    else {
                        mnkuktnmkn = kykNkUktList.get(0).getUktnmkn();
                        mnkuktnmkj = kykNkUktList.get(0).getUktnmkj();
                    }
                }

                String bankCd = "";
                String shitenCd = "";
                String yokinKbn = "";
                String kouzano7Keta = "";

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                    IT_KykKihon kykKihonEntity = IT_KykKihonDetacher.detachKouzatouched(hozenDomManager.getKykKihon(syono));
                    IT_Kouza kouza = kykKihonEntity.getKouza();
                    if (kouza == null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048, IT_Kouza.TABLE_NAME,
                            syono));
                    }

                    bankCd = kouza.getBankcd();
                    shitenCd = kouza.getSitencd();
                    yokinKbn = kouza.getYokinkbn().getValue();
                    kouzano7Keta = kouza.getKouzano();
                }
                else {

                    bankCd = "0000";
                    shitenCd = "000";
                    yokinKbn = "0";
                    kouzano7Keta = "0000000";
                }

                String kyoutuuDrtencd;
                if (C_UmuKbn.ARI.eq(kykDairiten.getDrtenbunumu())) {

                    kyoutuuDrtencd = kykDairitenTmp.getDrtencd();
                }
                else {

                    kyoutuuDrtencd = "";
                }

                int kykage = setNenrei.exec(kykSyouhn.getKykymd(), kykSya.getKykseiymd());

                if (kykage > 99) {
                    kykage = 99;
                }

                BizNumber kaiyakuhrmkhritu = BizNumber.valueOf(0);

                if (C_UmuKbn.NONE.eq(kykSonotaTkyk.getTargettkhkumu()) ||
                    kykSyouhn.getYendthnkymd() != null) {
                    kaiyakuhrmkhritu = BizNumber.valueOf(0);
                }
                else {
                    kaiyakuhrmkhritu = BizNumber.valueOf(kykSonotaTkyk.getTargettkmokuhyouti()).divide(100, 2, RoundingMode.DOWN);
                }

                List<IT_KhTtdkRireki> khTtdkRirekiList = new ArrayList<>();

                if (kykSyouhn.getYendthnkymd() != null) {

                    IT_KykKihon kykKihonTmp = hozenDomManager.getKykKihon(syono);
                    kykKihonTmp = IT_KykKihonDetacher.detachKhTtdkRirekitouched(kykKihonTmp);
                    khTtdkRirekiList = kykKihonTmp
                        .getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);
                    khTtdkRirekiList = sortKhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(khTtdkRirekiList);

                    if (khTtdkRirekiList.size() == 0) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                            IT_KhTtdkRireki.TABLE_NAME, syono));
                    }
                }

                String toutatukaiyakuhrmkhritu ="";
                if (kykSyouhn.getYendthnkymd() != null) {

                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(khTtdkRirekiList.get(0).getSyorikbn())) {
                        toutatukaiyakuhrmkhritu = kykSyouhnHnkmae.getTargettkmokuhyouti().toString();
                    }
                    else {
                        toutatukaiyakuhrmkhritu = "000";
                    }
                }
                else {
                    toutatukaiyakuhrmkhritu = "000";
                }

                String kaiyakuhrmkhtoutatuymd = "";
                if (kykSyouhn.getYendthnkymd() != null) {
                    if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(khTtdkRirekiList.get(0).getSyorikbn())) {
                        kaiyakuhrmkhtoutatuymd = kykSyouhn.getYendthnkymd().addDays(-1).toString();
                    }
                    else {
                        kaiyakuhrmkhtoutatuymd = "00000000";
                    }
                }
                else {
                    kaiyakuhrmkhtoutatuymd = "00000000";
                }

                String hrkkeirokbn = "";

                kbnInfoBean = bzKbnHenkanUtil.convKbn(kykKihon.getHrkkeiro().getValue(), C_Hrkkeiro.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {

                    hrkkeirokbn = kbnInfoBean.getKbnData();
                }
                else {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046, IT_KykKihon.HRKKEIRO,
                        kykKihon.getHrkkeiro().getValue()));
                }

                String trkkzknmKj1 = "";
                String trkkzknmKj2 = "";
                for (IT_TrkKzk itTrkKzk : itTrkKzkList) {
                    if (C_TrkKzkKbn.TRKKZK1.eq(itTrkKzk.getTrkkzkkbn())){
                        trkkzknmKj1 = itTrkKzk.getTrkkzknmkj();
                    }
                    if (C_TrkKzkKbn.TRKKZK2.eq(itTrkKzk.getTrkkzkkbn())){
                        trkkzknmKj2 = itTrkKzk.getTrkkzknmkj();
                    }
                }

                String siteidruktnmlKj = "";

                List<IT_KykUkt> kykSbUktStdruktList = sortKykUkt.OrderIT_KykUktByPkAsc(kykKihonTemp
                    .getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK));

                if (kykSbUktStdruktList == null || kykSbUktStdruktList.size() == 0 || kykSbUktStdruktList.size() >= 5) {

                    siteidruktnmlKj = "";
                }
                else {

                    if (C_UktKbn.KYK.eq(kykSbUktStdruktList.get(0).getUktkbn())) {

                        siteidruktnmlKj = kykSya.getKyknmkj();
                    }
                    else if (C_UktKbn.HHKN.eq(kykSbUktStdruktList.get(0).getUktkbn())) {

                        siteidruktnmlKj = hhknSya.getHhknnmkj();
                    }
                    else if (C_UktKbn.SBUK.eq(kykSbUktStdruktList.get(0).getUktkbn())) {

                        siteidruktnmlKj = sbuktnmkj;
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU1.eq(kykSbUktStdruktList.get(0).getUktkbn())) {

                        siteidruktnmlKj = trkkzknmKj1;
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykSbUktStdruktList.get(0).getUktkbn())) {

                        siteidruktnmlKj = trkkzknmKj2;
                    }
                    else {

                        siteidruktnmlKj = kykSbUktStdruktList.get(0).getUktnmkj();
                    }
                }


                String kykdrnmkj = "";
                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())){
                    GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
                    GetKhKykdrInfoBean getKhKykdrInfoBean =  getKhKykdrInfo.exec(kykKihon);

                    kykdrnmkj = getKhKykdrInfoBean.getKkdairinmKj();
                }

                String ikkatubaraiKbn = "";

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())
                    || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                    ikkatubaraiKbn = "2";
                }
                else {

                    ikkatubaraiKbn = "0";
                }

                String ikkatubaraiKaisuu = "";

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                    ikkatubaraiKaisuu = "06";
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                    ikkatubaraiKaisuu = "12";
                }
                else {

                    ikkatubaraiKaisuu = "00";
                }

                String annaiHuyouRiyuuKbn = "";

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    annaiHuyouRiyuuKbn = "01";
                }
                else if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

                    annaiHuyouRiyuuKbn = "07";
                }
                else {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())
                        || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        annaiHuyouRiyuuKbn = "09";
                    }
                    else {

                        annaiHuyouRiyuuKbn = "00";
                    }
                }

                BizNumber rendouritu = BizNumber.ZERO;

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    rendouritu = kykSyouhn.getRendouritu();
                }

                String nnknsnpssyhknsyukigou = kyksyouhnnenkanzanp.getSyouhncd().substring(0, 2);

                String nnknsnpssyhknkkn;
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                    if (C_HknkknsmnKbn.NENMANKI.eq(kyksyouhnnenkanzanp.getHknkknsmnkbn())) {
                        nnknsnpssyhknkkn = String.valueOf(kyksyouhnnenkanzanp.getHknkkn() + kyksyouhnnenkanzanp.getHhknnen());
                    }
                    else {
                        nnknsnpssyhknkkn = String.valueOf(kyksyouhnnenkanzanp.getHknkkn());
                    }
                }
                else {
                    nnknsnpssyhknkkn = String.valueOf(kyksyouhnnenkanzanp.getHknkkn());
                }

                String nnknsnpssyphrkkikn;
                if (C_Kykjyoutai.ITIJIBARAI.eq(kyksyouhnnenkanzanp.getKykjyoutai())) {
                    nnknsnpssyphrkkikn = "00";
                }
                else {
                    nnknsnpssyphrkkikn = kyksyouhnnenkanzanp.getHrkkkn().toString();
                }

                String nnknsnpssysaimnkkykhyj;
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                    nnknsnpssysaimnkkykhyj = "1";
                }
                else {
                    if (C_HknkknsmnKbn.SAIMANKI.eq(kyksyouhnnenkanzanp.getHknkknsmnkbn())) {
                        nnknsnpssysaimnkkykhyj = "1";
                    }
                    else {
                        nnknsnpssysaimnkkykhyj = "0";
                    }
                }

                String nknsnpssyhrkkskbn;
                if (C_Hrkkaisuu.NEN.eq(nyknJissekiRirekiList.get(0).getHrkkaisuu())) {
                    nknsnpssyhrkkskbn = "1";
                }
                else if (C_Hrkkaisuu.HALFY.eq(nyknJissekiRirekiList.get(0).getHrkkaisuu())) {
                    nknsnpssyhrkkskbn = "2";
                }
                else if (C_Hrkkaisuu.TUKI.eq(nyknJissekiRirekiList.get(0).getHrkkaisuu())) {
                    nknsnpssyhrkkskbn = "3";
                }
                else {
                    nknsnpssyhrkkskbn = "0";
                }

                String nnknsnpssyhhknnen;
                if (kyksyouhnnenkanzanp.getHhknnen() >= 100) {
                    nnknsnpssyhhknnen = "99";
                }
                else {
                    nnknsnpssyhhknnen = kyksyouhnnenkanzanp.getHhknnen().toString();
                }

                BizNumber nnknsnpssyitijibrpkyktk;
                if (C_Kykjyoutai.ITIJIBARAI.eq(kyksyouhnnenkanzanp.getKykjyoutai())) {
                    nnknsnpssyitijibrpkyktk = BizNumber.valueOf(new BigDecimal(nyknJissekiRirekiList.get(0).getHrkp().toAdsoluteString()).longValue());
                }
                else {
                    nnknsnpssyitijibrpkyktk = BizNumber.valueOf(BizNumber.ZERO);
                }

                Long nnknsnpssysyup;
                if (C_Kykjyoutai.ITIJIBARAI.eq(kyksyouhnnenkanzanp.getKykjyoutai())) {
                    nnknsnpssysyup = 0L;
                }
                else {
                    nnknsnpssysyup = new BigDecimal(nyknJissekiRirekiList.get(0).getHrkp().toAdsoluteString()).longValue();
                }

                Long zennoup = 0L;
                if (zennou != null) {
                    if (C_Tuukasyu.JPY.eq(rstuukasyuhanteiKekka)) {
                        zennoup = new BigDecimal(zennou.getZennounyuukinkgkrstk().toAdsoluteString()).longValue();
                    }
                    else {
                        zennoup = new BigDecimal(keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            zennou.getZennounyuukinkgk(),
                            zrnnnknsnpssykawaseraten5,
                            C_HasuusyoriKbn.SUTE)
                            .toAdsoluteString()).longValue();
                    }
                }

                ZT_BosyuuDrtenHoyuuKykTy bosyuuDrtenHoyuuKykTy = new ZT_BosyuuDrtenHoyuuKykTy();

                bosyuuDrtenHoyuuKykTy.setZtysyonosyuban(syonosyuban);

                bosyuuDrtenHoyuuKykTy.setZtyhrkhuhukbn(hrkhouhoukbn);

                bosyuuDrtenHoyuuKykTy.setZtysyukinkbn(syukinkbn);

                if (BizUtil.isBlank(bnkaisuu)) {

                    bosyuuDrtenHoyuuKykTy.setZtybnkaisuu(bnkaisuu);
                }
                else {

                    bosyuuDrtenHoyuuKykTy.setZtybnkaisuu(BizUtil.num(bnkaisuu, BizUtil.ZERO_FILL, 2));
                }

                bosyuuDrtenHoyuuKykTy.setZtygoukeipbsdirtnhykyk(BizUtil.num(goukeiPbsDirtnhyKyk, BizUtil.ZERO_FILL, 10));

                bosyuuDrtenHoyuuKykTy.setZtyyno7keta(kykSya.getTsinyno());

                if (kykSyouhn.getKykymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtysikiymd(kykSyouhn.getKykymd().toString());
                }

                bosyuuDrtenHoyuuKykTy.setZtymankiymd(mankiymd);

                if (kykSyouhn.getSyoumetuymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtyidokaiyakuymd(kykSyouhn.getSyoumetuymd().toString());
                }

                if (kykSyouhn.getKykymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtymusymd(kykSyouhn.getKykymd().toString());
                }

                bosyuuDrtenHoyuuKykTy.setZtykihontikucdkami3(kihontikucdkami3);

                bosyuuDrtenHoyuuKykTy.setZtytelnobsdirtnhykyk(kykSya.getTsintelno());

                bosyuuDrtenHoyuuKykTy.setZtykyknmknbsdirtnhykyk(kykSya.getKyknmkn());

                bosyuuDrtenHoyuuKykTy.setZtybnkyk1kaipbsdirtnhykyk(BizUtil.num(bnkyk1KaiPbsDirtnhykyk,
                    BizUtil.ZERO_FILL, 10));

                bosyuuDrtenHoyuuKykTy.setZtybnsyuruikbn(bnsyuruiKbn);

                bosyuuDrtenHoyuuKykTy.setZtyhhknnmknbsdirtnhykyk(hhknSya.getHhknnmkn());

                bosyuuDrtenHoyuuKykTy.setZtyknjhhknmei(hhknSya.getHhknnmkj());

                if (hhknSya.getHhknseiymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtyhhknseiymd(hhknSya.getHhknseiymd().toString());
                }

                bosyuuDrtenHoyuuKykTy.setZtyhhknnenbsdirtnhykyk(
                    BizUtil.num(String.valueOf(kykSyouhn.getHhknnen()), BizUtil.ZERO_FILL, 3));

                bosyuuDrtenHoyuuKykTy.setZtyhhknseikbn(hhknsei);

                bosyuuDrtenHoyuuKykTy.setZtyhhkntdk(hhkntdk);

                bosyuuDrtenHoyuuKykTy.setZtyhhknynobsdirtnhykyk(hhknyno);

                bosyuuDrtenHoyuuKykTy.setZtyhhknadrkj50(kjhhknadr);

                bosyuuDrtenHoyuuKykTy.setZtyhrkkeiro(hrkkeiro);

                bosyuuDrtenHoyuuKykTy.setZtyitijibrpbsdirtnhykyk(
                    BizUtil.num(itijibrp.toAdsoluteString(), BizUtil.ZERO_FILL, 10));

                bosyuuDrtenHoyuuKykTy.setZtynkshrkknkbn(nkshrkknkbn);

                bosyuuDrtenHoyuuKykTy.setZtynkshrkknnen(BizUtil.num(nkshrkknnen, BizUtil.ZERO_FILL, 3));

                bosyuuDrtenHoyuuKykTy.setZtynkshrstartymd(nkshrstartymd);

                bosyuuDrtenHoyuuKykTy.setZtytksuu("000");

                bosyuuDrtenHoyuuKykTy.setZtysinsakbn(sinsakbn);

                bosyuuDrtenHoyuuKykTy.setZtyzeiseitekikaku(zeiseitekikaku);

                bosyuuDrtenHoyuuKykTy.setZtylivingneeds("0");

                bosyuuDrtenHoyuuKykTy.setZtysyusbsdirtnhykyk(BizUtil.num(syus.toAdsoluteString(), BizUtil.ZERO_FILL, 11));

                bosyuuDrtenHoyuuKykTy.setZtysyuhknkknkbn(syuhknkknkbn);

                bosyuuDrtenHoyuuKykTy.setZtysyuhknkkn(syuhknkkn);

                bosyuuDrtenHoyuuKykTy.setZtysyuhrkkknkbn(syuHrkkknKbn);

                bosyuuDrtenHoyuuKykTy.setZtysyuhrkkkn(syuHrkkkn);

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm1(kjtkhosyunmList.get(0));

                bosyuuDrtenHoyuuKykTy.setZtytks1bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm2(kjtkhosyunmList.get(1));

                bosyuuDrtenHoyuuKykTy.setZtytks2bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm3(kjtkhosyunmList.get(2));

                bosyuuDrtenHoyuuKykTy.setZtytks3bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm4(kjtkhosyunmList.get(3));

                bosyuuDrtenHoyuuKykTy.setZtytks4bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm5(kjtkhosyunmList.get(4));

                bosyuuDrtenHoyuuKykTy.setZtytks5bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtykjtkhosyunm6(kjtkhosyunmList.get(5));

                bosyuuDrtenHoyuuKykTy.setZtytks6bsdirtnhykyk("00000000000");

                bosyuuDrtenHoyuuKykTy.setZtyhjnkojinkbn("2");

                bosyuuDrtenHoyuuKykTy.setZtykykadrkj50(kjkykadr);

                bosyuuDrtenHoyuuKykTy.setZtykyknmkjbsdirtnhykyk(kykSya.getKyknmkj());

                if (kykSya.getKykseiymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtykyksyaseiymd(kykSya.getKykseiymd().toString());
                }

                bosyuuDrtenHoyuuKykTy.setZtysakuseiym("000000");

                bosyuuDrtenHoyuuKykTy.setZtydairitencd(kykDairiten.getDrtencd());

                bosyuuDrtenHoyuuKykTy.setZtybosyuunincd(kykDairiten.getBosyuucd());

                bosyuuDrtenHoyuuKykTy.setZtybosyuujtkbn("0");

                bosyuuDrtenHoyuuKykTy.setZtysyouhinbunruikbn(syouhinBunruiKbn);

                bosyuuDrtenHoyuuKykTy.setZtyhknnmcd(kykSyouhn.getSyouhncd());

                bosyuuDrtenHoyuuKykTy.setZtykykjyutikbn(kykjyoutaikbn);

                bosyuuDrtenHoyuuKykTy.setZtytkbthsyukiknmanryouym("000000");

                bosyuuDrtenHoyuuKykTy.setZtyldownym("000000");

                bosyuuDrtenHoyuuKykTy.setZtyhrkmanryouym("000000");

                bosyuuDrtenHoyuuKykTy.setZtymrtiksnym("000000");

                bosyuuDrtenHoyuuKykTy.setZtyhaneikykhyj("0");

                bosyuuDrtenHoyuuKykTy.setZtyzenzeikyohyj("0");

                bosyuuDrtenHoyuuKykTy.setZtysikijikbn("0");

                bosyuuDrtenHoyuuKykTy.setZtysbuktdisphukusuhyj(sbuktdisphukusuhyj);

                bosyuuDrtenHoyuuKykTy.setZtysbuktnmbsdirtnhykyk(sbuktnmkn);

                bosyuuDrtenHoyuuKykTy.setZtymnkuktdisphukusuhyj("0");

                bosyuuDrtenHoyuuKykTy.setZtymnkuktnmbsdirtnhykyk(mnkuktnmkn);

                bosyuuDrtenHoyuuKykTy.setZtytodouhukencd(todouhukencd);

                bosyuuDrtenHoyuuKykTy.setZtybankcd(bankCd);

                bosyuuDrtenHoyuuKykTy.setZtyshitencd(shitenCd);

                bosyuuDrtenHoyuuKykTy.setZtyyokinkbn(yokinKbn);

                bosyuuDrtenHoyuuKykTy.setZtykouzano7keta(kouzano7Keta);

                bosyuuDrtenHoyuuKykTy.setZtyalcardkbn("0");

                bosyuuDrtenHoyuuKykTy.setZtysibous(Long.parseLong(dais.toString()));

                bosyuuDrtenHoyuuKykTy.setZtysgsbs(Long.parseLong(saiGaisbs.toString()));

                bosyuuDrtenHoyuuKykTy.setZtysgwrmstksbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtysyougaitkkatakbn("0");

                bosyuuDrtenHoyuuKykTy.setZtysyougaitksbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtyreguardtksbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtyreguardtkkbn("0");

                bosyuuDrtenHoyuuKykTy.setZtyvreguardtksbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtykzkmrthgukatakbn("0");

                bosyuuDrtenHoyuuKykTy.setZtykzkmrthgusbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtykzkmrtkosbsdirtnhykyk("000000000");

                bosyuuDrtenHoyuuKykTy.setZtykaneeztkarihyj("0");

                bosyuuDrtenHoyuuKykTy.setZtystjmkbn("01");

                bosyuuDrtenHoyuuKykTy.setZtysyokaiphrkkeiro("0");

                bosyuuDrtenHoyuuKykTy.setZtycifcd(kykKihon.getCifcd());

                bosyuuDrtenHoyuuKykTy.setZtytsrybnwari(0L);

                bosyuuDrtenHoyuuKykTy.setZtydrtenkeijyouym("000000");

                bosyuuDrtenHoyuuKykTy.setZtykydatkidairitencd(kyoutuuDrtencd);

                bosyuuDrtenHoyuuKykTy.setZtymdhnsyouhntsryshrkbn("0");

                bosyuuDrtenHoyuuKykTy.setZtykyksyanen(BizUtil.num(String.valueOf(kykage), BizUtil.ZERO_FILL, 2));

                bosyuuDrtenHoyuuKykTy.setZtyhknsyukigou(kykSyouhn.getSyouhncd().substring(0, 2));

                bosyuuDrtenHoyuuKykTy.setZtymdhnaisyoumeicd(kykKihon.getAisyoumeikbn().getValue());

                if (kykKihon.getFstpnyknymd() != null) {
                    bosyuuDrtenHoyuuKykTy.setZtysyokaipryosyuymd(kykKihon.getFstpnyknymd().toString());
                }

                bosyuuDrtenHoyuuKykTy.setZtysykgycd(kykKihon.getHhknsykgycd());

                bosyuuDrtenHoyuuKykTy.setZtykaiyakuhrmkhritu(BizNumber.valueOf(kaiyakuhrmkhritu));

                bosyuuDrtenHoyuuKykTy.setZtytoutatukaiyakuhrmkhritu(toutatukaiyakuhrmkhritu);

                bosyuuDrtenHoyuuKykTy.setZtykaiyakuhrmkhtoutatuymd(kaiyakuhrmkhtoutatuymd);

                bosyuuDrtenHoyuuKykTy.setZtyanniskcd("00000000");

                bosyuuDrtenHoyuuKykTy.setZtyhjnkykhyj("0");

                bosyuuDrtenHoyuuKykTy.setZtyhrkkeirokbn(hrkkeirokbn);

                bosyuuDrtenHoyuuKykTy.setZtylivguardtkyks("000000000");

                bosyuuDrtenHoyuuKykTy.setZtysiteituukaitijibrp(Long.valueOf(siteiTuukaItijiBrp.toAdsoluteString()));

                bosyuuDrtenHoyuuKykTy.setZtysiteituukasyus(Long.parseLong(siteiTuukaSyus.toAdsoluteString()));

                bosyuuDrtenHoyuuKykTy.setZtysiteituukasbs(Long.parseLong(siteiTuukaSbs.toAdsoluteString()));

                bosyuuDrtenHoyuuKykTy.setZtysiteituukasaigaisbs(Long.parseLong(siteiTuukaSaigaiBs.toAdsoluteString()));

                bosyuuDrtenHoyuuKykTy.setZtysiteituukacd(siteiTuukaCd);

                bosyuuDrtenHoyuuKykTy.setZtyhrktuukaitijibrp(Long.valueOf(hrkTuukaitijiBrp.toAdsoluteString()));

                bosyuuDrtenHoyuuKykTy.setZtyhrktuukacd(hrkTuukaCd);

                bosyuuDrtenHoyuuKykTy.setZtytumitateriritu(tumitateriritu);

                bosyuuDrtenHoyuuKykTy.setZtytmttknzoukaritujygn(tmttknzoukaritujygn);

                bosyuuDrtenHoyuuKykTy.setZtysetteibairitu(setteibairitu);

                bosyuuDrtenHoyuuKykTy.setZtytumitatekngk(tumitatekngk);

                bosyuuDrtenHoyuuKykTy.setZtykjsbuktnm30(sbuktnmkj);

                bosyuuDrtenHoyuuKykTy.setZtymnkuktnm30(mnkuktnmkj);

                bosyuuDrtenHoyuuKykTy.setZtykjkykdairinm(kykdrnmkj);

                bosyuuDrtenHoyuuKykTy.setZtykjsiteidairinm30(siteidruktnmlKj);

                bosyuuDrtenHoyuuKykTy.setZtytrkkzknmkj1(trkkzknmKj1);

                bosyuuDrtenHoyuuKykTy.setZtytrkkzknmkj2(trkkzknmKj2);

                bosyuuDrtenHoyuuKykTy.setZtyikkatubaraikbn(ikkatubaraiKbn);

                bosyuuDrtenHoyuuKykTy.setZtyikkatubaraikaisuu(ikkatubaraiKaisuu);

                bosyuuDrtenHoyuuKykTy.setZtyannaifuyouriyuukbn(annaiHuyouRiyuuKbn);

                bosyuuDrtenHoyuuKykTy.setZtyrendouritu(rendouritu);

                bosyuuDrtenHoyuuKykTy.setZtyteikishrritu(BizNumber.ZERO);

                bosyuuDrtenHoyuuKykTy.setZtytikskzbankcd("0000");

                bosyuuDrtenHoyuuKykTy.setZtytikskzsitencd("000");

                bosyuuDrtenHoyuuKykTy.setZtytikskzyokinkbn("0");

                bosyuuDrtenHoyuuKykTy.setZtytikskzkouzano("000000000000");
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssyhknsyukigou(nnknsnpssyhknsyukigou);
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssyhknkkn(BizUtil.num(nnknsnpssyhknkkn, BizUtil.ZERO_FILL, 2));
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssyphrkkikn(BizUtil.num(nnknsnpssyphrkkikn, BizUtil.ZERO_FILL, 2));
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssysaimnkkykhyj(nnknsnpssysaimnkkykhyj);
                bosyuuDrtenHoyuuKykTy.setZtynknsnpssyhrkkskbn(nknsnpssyhrkkskbn);
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssyhhknnen(nnknsnpssyhhknnen);
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssyitijibrpkyktk(nnknsnpssyitijibrpkyktk);
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssysyup(nnknsnpssysyup);
                bosyuuDrtenHoyuuKykTy.setZtynnknsnpssykawaseraten5(zrnnnknsnpssykawaseraten5);
                bosyuuDrtenHoyuuKykTy.setZtyzennoup(zennoup);

                BizPropertyInitializer.initialize(bosyuuDrtenHoyuuKykTy);

                bosyuuDrtenHoyuuKykTyInserter.add(bosyuuDrtenHoyuuKykTy);

                kensuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
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

}
