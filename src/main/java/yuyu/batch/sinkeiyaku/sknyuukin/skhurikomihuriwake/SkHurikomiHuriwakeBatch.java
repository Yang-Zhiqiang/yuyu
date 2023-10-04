package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake.dba.SkHurikomiHuriwakeDao;
import yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake.dba.SkMosInfoBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumoku;
import yuyu.common.sinkeiyaku.moschk.SetSknnkaisiymd;
import yuyu.common.sinkeiyaku.skcommon.GetRsgakukei;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_NyuukinHuittiriyuuKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_ChkTesuuryou;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.def.db.entity.HT_HrkmNyknData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 入金 振込入金データ振分
 */
public class SkHurikomiHuriwakeBatch implements Batch {

    private static final String TABLEID1 = "HT_HrkmNyknData";

    private static final String TABLEID2 = "HT_GaikaHrkmNyknData";

    private static final String RECOVERYFILTERID = "Sk002";

    private static final String KOUZASYURUIKBN = "口座種類区分";

    private static final String YENKOUZA = "（円口座）";

    private static final String GAIKAKOUZA = "（外貨口座）";

    private static final String TESUURYOUERROR = "手数料チェックマスタが取得できません。";

    private static final String tskNm = "振込入金データ振分";

    private static final int NYKNKYOYOUMAXLENGTH = 10;

    private static final long GKNYKNKYOYOUMAXKGK = 1000000000L;

    private static final BizNumber RYOUGAERATE_YENKOUZA = BizNumber.valueOf(0.05);

    private static final BizNumber RYOUGAERATE_GAIKAKOUZA = BizNumber.valueOf(0.025);

    private long syoriKensuu;

    private static final String HANKAKUSPACE = " ";

    private static final String ZENKAKUSPACE  = "　";

    private static final String BLANK  = "";

    private static final String COMMA  = "、";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkHurikomiHuriwakeBatchParam skHrkmHuriwakeBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkHurikomiHuriwakeDao skHurikomiHuriwakeDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return skHrkmHuriwakeBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = skHrkmHuriwakeBatchParam.getSyoriYmd();

        String kakutyoujobCd = skHrkmHuriwakeBatchParam.getIbKakutyoujobcd();

        C_KouzasyuruiKbn kouzaSyuruiKbn = skHrkmHuriwakeBatchParam.getKouzaSyuruiKbn();

        syoriKensuu = 0;

        String logKouzaSyuruiKbn = "";

        HashMap<String, List<String>> mosInfoMap = new HashMap<String, List<String>>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobCd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, KOUZASYURUIKBN, kouzaSyuruiKbn.getValue()));

        BizDate idougoYmd = syoriYmd.addBusinessDays(1);

        BizDateYM mosNyuuryokuYm = idougoYmd.getBizDateYM().addMonths(
            -YuyuSinkeiyakuConfig.getInstance().getMosnyuuryokumatitukisuu());

        try (
            EntityInserter<HW_JidouNyknTaisyougaiWk> jidouNyknTaisyougaiWkInserter = new EntityInserter<>();
            EntityInserter<HW_NyuukinJyouhouHuittiWk> nyuukinJyouhouHuittiWkInserter = new EntityInserter<>();
            EntityInserter<HW_MosMatiKknKeikaWk> mosMatiKknKeikaWkInserter = new EntityInserter<>();
            EntityInserter<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWkInserter = new EntityInserter<>();
            EntityInserter<HW_SikinIdouWk> sikinIdouWkInserter = new EntityInserter<>()) {

            if (C_KouzasyuruiKbn.YENKOUZA.eq(kouzaSyuruiKbn)) {

                logKouzaSyuruiKbn = YENKOUZA;

                List<HM_ChkTesuuryou> chkTesuuryouLst = sinkeiyakuDomManager.getAllChkTesuuryou();

                if (chkTesuuryouLst.size() == 0) {

                    throw new CommonBizAppException(TESUURYOUERROR);
                }

                BizCurrency tesuuKijyunKingaku = chkTesuuryouLst.get(0).getHrkmtsry();

                List<String> skHrkmNykMosnoList = skHurikomiHuriwakeDao.getSkHrkmNykMosnoList();

                try (ExDBUpdatableResults<HT_HrkmNyknData> hrkmNyknDatas = sinkeiyakuDomManager.
                    getHrkmNyknDatasByKakutyoujobcdSyorizumiflg(kakutyoujobCd, C_Syorizumiflg.MISYORI)) {

                    List<SkMosInfoBean> skMosInfoBeanLst = skHurikomiHuriwakeDao.getSkMosInfo();

                    for (SkMosInfoBean skMosInfoBean : skMosInfoBeanLst) {

                        List<String> mosNoList1 = new ArrayList<>();
                        List<String> mosNoList2 = new ArrayList<>();

                        if (C_KykKbn.KEIHI_BETU.eq(skMosInfoBean.getKykkbn())) {

                            List<String> mosNoListTmp = mosInfoMap.get(kuuhakuJyokyo(skMosInfoBean.getKyknmkn()));

                            if(mosNoListTmp != null) {

                                mosNoList1 = mosNoListTmp;
                            }

                            mosNoList1.add(skMosInfoBean.getMosno());

                            mosNoListTmp = mosInfoMap.get(kuuhakuJyokyo(skMosInfoBean.getKyknmkn()).concat(
                                HANKAKUSPACE).concat(skMosInfoBean.getOyadrtencd()));

                            if(mosNoListTmp != null) {

                                mosNoList2 = mosNoListTmp;
                            }

                            mosNoList2.add(skMosInfoBean.getMosno());

                            mosInfoMap.put(kuuhakuJyokyo(skMosInfoBean.getKyknmkn()), mosNoList1);

                            mosInfoMap.put(kuuhakuJyokyo(skMosInfoBean.getKyknmkn()).concat(
                                HANKAKUSPACE).concat(skMosInfoBean.getOyadrtencd()), mosNoList2);
                        }
                        else if (C_KykKbn.KEIHI_DOUITU.eq(skMosInfoBean.getKykkbn())) {

                            List<String> mosNoListTmp = mosInfoMap.get(kuuhakuJyokyo(skMosInfoBean.getHhknnmkn()));

                            if(mosNoListTmp != null) {

                                mosNoList1 = mosNoListTmp;
                            }

                            mosNoList1.add(skMosInfoBean.getMosno());

                            mosNoListTmp = mosInfoMap.get(kuuhakuJyokyo(skMosInfoBean.getHhknnmkn()).concat(
                                HANKAKUSPACE).concat(skMosInfoBean.getOyadrtencd()));

                            if(mosNoListTmp != null) {

                                mosNoList2 = mosNoListTmp;
                            }

                            mosNoList2.add(skMosInfoBean.getMosno());

                            mosInfoMap.put(kuuhakuJyokyo(skMosInfoBean.getHhknnmkn()), mosNoList1);

                            mosInfoMap.put(kuuhakuJyokyo(skMosInfoBean.getHhknnmkn()).concat(
                                HANKAKUSPACE).concat(skMosInfoBean.getOyadrtencd()), mosNoList2);
                        }
                    }

                    for (HT_HrkmNyknData hrkmNyknData : hrkmNyknDatas) {

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                        bzRecoveryDatasikibetuBean.setIbTableid(TABLEID1);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hrkmNyknData.getDensyskbn().getValue());
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(hrkmNyknData.getSyoriYmd().toString());
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(hrkmNyknData.getItirenno());

                        if (C_TaisyouKbn.HITAISYOU.eq(hrkmNyknData.getJidonykntargethyouji())) {

                            HW_JidouNyknTaisyougaiWk jidouNyknTaisyougaiWk = new HW_JidouNyknTaisyougaiWk();

                            jidouNyknTaisyougaiWk.setNyksyoriymd(hrkmNyknData.getSyoriYmd());
                            jidouNyknTaisyougaiWk.setItirenno(hrkmNyknData.getItirenno());
                            jidouNyknTaisyougaiWk.setNykmosno(hrkmNyknData.getNykmosno());
                            jidouNyknTaisyougaiWk.setOyadrtencd(hrkmNyknData.getOyadrtencd());
                            jidouNyknTaisyougaiWk.setTrhkkgk(hrkmNyknData.getTrhkkgk());
                            jidouNyknTaisyougaiWk.setRstuukasyu(C_Tuukasyu.JPY);
                            jidouNyknTaisyougaiWk.setSyoriYmd(syoriYmd);
                            jidouNyknTaisyougaiWk.setNyktyhyoutkbn(hrkmNyknData.getNyktyhyoutkbn());
                            jidouNyknTaisyougaiWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                            jidouNyknTaisyougaiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            BizPropertyInitializer.initialize(jidouNyknTaisyougaiWk);

                            jidouNyknTaisyougaiWkInserter.add(jidouNyknTaisyougaiWk);

                            updateHrkmNyknData(hrkmNyknData);

                            syoriKensuu++;

                            continue;
                        }

                        if (BizUtil.isBlank(hrkmNyknData.getOyadrtencd())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.OYADRTENCDERROR);

                            continue;
                        }

                        if (!MousikomiNoCheck.isValid(hrkmNyknData.getNykmosno())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.MOSNO);

                            continue;
                        }

                        if (!MousikomiNoCheck.ifExistMousikomiNo(hrkmNyknData.getNykmosno())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.MOSNO);

                            continue;
                        }

                        if (skHrkmNykMosnoList.size() != 0 && skHrkmNykMosnoList.contains(hrkmNyknData.getNykmosno())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.DOUITUMOSNO);

                            continue;
                        }

                        HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosKihonMosDairitenNyuukinHenkintouched(
                            sinkeiyakuDomManager.getSyoriCTL(hrkmNyknData.getNykmosno()));

                        if (syoriCTL == null) {

                            String mosno = null;
                            List<String> nyknInfoMosnoList = null;

                            if (C_TaisyouKbn.HITAISYOU.eq(hrkmNyknData.getOyadrtensyoritarget())) {
                                nyknInfoMosnoList = mosInfoMap.get(kuuhakuJyokyo(hrkmNyknData.getHrkmirninnm()));

                                if (nyknInfoMosnoList != null) {
                                    mosno = nyknInfoMosnoList.get(0);
                                }
                            }
                            else {
                                nyknInfoMosnoList = mosInfoMap.get(kuuhakuJyokyo(hrkmNyknData.getHrkmirninnm()).concat(
                                    HANKAKUSPACE).concat(hrkmNyknData.getOyadrtencd()));

                                if (nyknInfoMosnoList != null) {
                                    mosno = nyknInfoMosnoList.get(0);
                                }
                            }

                            if (mosno != null) {
                                String nykmosno = hrkmNyknData.getNykmosno();
                                hrkmNyknData.setNykmosno(mosno);

                                if (nyknInfoMosnoList != null && nyknInfoMosnoList.size() > 1) {

                                    addNyknJyhHuittiWk(hrkmNyknData,
                                        nyuukinJyouhouHuittiWkInserter,
                                        C_NyuukinHuittiriyuuKbn.MOSNOHUKUSUU);

                                    String otherMosno = "";
                                    for (int i = 1; i <= 10 && i < nyknInfoMosnoList.size(); i ++) {
                                        if (i == 1) {
                                            otherMosno = nyknInfoMosnoList.get(i);
                                        }
                                        else {
                                            otherMosno = otherMosno.concat(COMMA).concat(nyknInfoMosnoList.get(i));
                                        }
                                    }

                                    batchLogger.info(MessageUtil.getMessage(MessageId.IHF1008, mosno, otherMosno));
                                }
                                else {

                                    addNyknJyhHuittiWk(hrkmNyknData,
                                        nyuukinJyouhouHuittiWkInserter,
                                        C_NyuukinHuittiriyuuKbn.MOSNO);
                                }

                                hrkmNyknData.setNykmosno(nykmosno);

                                continue;
                            }


                            if (BizDateUtil.compareYm(mosNyuuryokuYm, hrkmNyknData.getAzkrhrdsymd().getBizDateYM())
                                == BizDateUtil.COMPARE_GREATER) {

                                addMosMatiKknKeikaWk(hrkmNyknData, mosMatiKknKeikaWkInserter);

                                continue;

                            }

                            syoriKensuu++;

                            continue;
                        }

                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu()) || mosKihon == null) {

                            if (BizDateUtil.compareYm(mosNyuuryokuYm, hrkmNyknData.getAzkrhrdsymd().getBizDateYM())
                                == BizDateUtil.COMPARE_GREATER) {

                                addMosMatiKknKeikaWk(hrkmNyknData, mosMatiKknKeikaWkInserter);

                                continue;
                            }

                            syoriKensuu++;

                            continue;
                        }

                        if (!C_FstphrkkeiroKbn.HURIKOMI.eq(mosKihon.getFstphrkkeirokbn())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.FSTPHRKKEIRO);

                            continue;
                        }

                        String kyknmknCheck = mosKihon.getKyknmkn();
                        kyknmknCheck = kuuhakuJyokyo(kyknmknCheck);

                        String hhknnmknCheck = mosKihon.getHhknnmkn();
                        hhknnmknCheck = kuuhakuJyokyo(hhknnmknCheck);

                        String hrkmirninnmCheck = hrkmNyknData.getHrkmirninnm();
                        hrkmirninnmCheck = kuuhakuJyokyo(hrkmirninnmCheck);

                        if ((C_KykKbn.KEIHI_BETU.eq(mosKihon.getKykkbn()) &&
                            !kyknmknCheck.equals(hrkmirninnmCheck)) ||
                            (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn()) &&
                                !hhknnmknCheck.equals(hrkmirninnmCheck))) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.KNKYKNM);

                            continue;
                        }

                        if (C_TaisyouKbn.TAISYOU.eq(hrkmNyknData.getOyadrtensyoritarget())) {

                            HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                            if (mosDairiten == null ||
                                !mosDairiten.getOyadrtencd().equals(hrkmNyknData.getOyadrtencd())) {

                                addNyknJyhHuittiWk(hrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.OYADRTENCD);

                                continue;
                            }
                        }

                        if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
                            C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                            C_NyuukinHuittiriyuuKbn nyuukinHuittiriyuuKbn = null;

                            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                                nyuukinHuittiriyuuKbn = C_NyuukinHuittiriyuuKbn.SRGONYKN;
                            }
                            else if ( C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                                nyuukinHuittiriyuuKbn = C_NyuukinHuittiriyuuKbn.HSRGONYKN;
                            }

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                nyuukinHuittiriyuuKbn);

                            continue;
                        }

                        if (!C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.TUUKA);

                            continue;
                        }

                        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

                        getRsgakukei.getHenkinsumiRsgaku(syoriCTL);

                        BizCurrency rsGakukei = getRsgakukei.getRsgakukei();

                        if (!rsGakukei.equalsValue(BizCurrency.valueOf(0, rsGakukei.getType()))) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.TUIKANYUUKIN);

                            continue;
                        }

                        List<HT_MosSyouhn> mosSyouhnLst = sinkeiyakuDomManager.getSyoriCTL(hrkmNyknData.getNykmosno()
                            ).getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

                        if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                            if (mosKihon.getMosfstpkei().equalsValue(
                                BizCurrency.valueOf(0, mosKihon.getMosfstpkei().getType()))) {

                                addNyknJyhHuittiWk(hrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.ZENNOUPKEISAN);

                                continue;
                            }

                            BizDate kariSknnKaisiYmd = null;
                            BizDate kykYmd = null;
                            int nenrei = 0;

                            SetSknnkaisiymd setSknnkaisiymd = SWAKInjector.getInstance(SetSknnkaisiymd.class);
                            SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
                            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

                            setSknnkaisiymd.exec(mosKihon.getSntkhoukbn(),
                                syoriCTL.getKktymd(),
                                mosKihon.getMosymd(),
                                hrkmNyknData.getAzkrhrdsymd(),
                                mosKihon.getSknnkaisikitkhukakbn(),
                                mosKihon.getMosukeymd());

                            kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

                            kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon,
                                mosSyouhn,
                                hrkmNyknData.getAzkrhrdsymd(),
                                mosKihon.getMosymd(),
                                kariSknnKaisiYmd,
                                BizDate.getSysDate(),
                                C_SysKbn.SKEI,
                                C_YoteikykymdKbn.SITEI);

                            nenrei = setNenrei.exec(kykYmd, mosKihon.getHhknseiymd());

                            if (mosKihon.getHhknnen() != nenrei) {

                                addNyknJyhHuittiWk(hrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.ZENNOUPKEISAN);

                                continue;
                            }
                        }

                        String trhkkgkStr = hrkmNyknData.getTrhkkgk().toString();

                        int trhkkgkKetasuu = trhkkgkStr.length();

                        if (trhkkgkKetasuu > NYKNKYOYOUMAXLENGTH) {

                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.KINGAKU);

                            continue;
                        }

                        BizCurrency mosfstpkei = BizCurrency.valueOf(0);

                        BM_SyouhnZokusei syouhnZokusei = mosSyouhn.getSyouhnZokusei();

                        if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                            !C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                            C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(
                                hrkmNyknData.getAzkrhrdsymd(),
                                mosKihon.getKyktuukasyu(),
                                C_Tuukasyu.JPY,
                                C_YouhiKbn.HUYOU,
                                mosKihon.getHrkkaisuu(),
                                C_SysKbn.SKEI,
                                mosKihon.getZennoumousideumu(),
                                mosKihon.getIkkatubaraikbn());

                            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                                String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                                    hrkmNyknData.getAzkrhrdsymd().toString(),
                                    mosKihon.getKyktuukasyu().getValue(),
                                    C_Tuukasyu.JPY.getValue(),
                                    C_YouhiKbn.HUYOU.getValue(),
                                    mosKihon.getHrkkaisuu().getValue(),
                                    C_SysKbn.SKEI.getValue(),
                                    mosKihon.getZennoumousideumu().getValue(),
                                    mosKihon.getIkkatubaraikbn().getValue()
                                    );

                                batchLogger.error(errMessage);

                                throw new BizAppException(MessageId.EHA1045);
                            }

                            BizNumber koujiKawaserate = getKawaseRate.getKawaserate();

                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                                mosfstpkei = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosKihon.getMosheijyunp(),
                                    koujiKawaserate,
                                    C_HasuusyoriKbn.SUTE);

                                mosfstpkei = mosfstpkei.add(keisanGaikakanzan.exec(
                                    C_Tuukasyu.JPY,
                                    mosKihon.getMosfstpkei().subtract(mosKihon.getMosheijyunp()),
                                    koujiKawaserate,
                                    C_HasuusyoriKbn.SUTE));
                            }
                            else {


                                mosfstpkei = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                                    mosKihon.getMosfstpkei(),
                                    koujiKawaserate,
                                    C_HasuusyoriKbn.SUTE);
                            }
                        }
                        else {
                            mosfstpkei = mosKihon.getMosfstpkei();
                        }

                        BizCurrency hrkmTsry = mosfstpkei.subtract(hrkmNyknData.getTrhkkgk());

                        int hikakuRes1 = hrkmTsry.compareTo(BizCurrency.valueOf(0, hrkmTsry.getType()));
                        int hikakuRes2 = hrkmTsry.compareTo(tesuuKijyunKingaku);

                        if (hikakuRes1 >= 0 && hikakuRes2 <= 0) {
                        }
                        else {
                            addNyknJyhHuittiWk(hrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.KINGAKU);

                            continue;
                        }

                        String hrkmHonkouzaCd = hrkmNyknData.getHonkouzacd();
                        HM_SyouhnTaniHonkouza2 syouhnTaniHonkouza2 = sinkeiyakuDomManager.getSyouhnTaniHonkouza2(
                            mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
                        String kykInfoHonkouzaCd = syouhnTaniHonkouza2.getHonkouzacd();
                        if (!hrkmHonkouzaCd.equals(kykInfoHonkouzaCd)) {
                            BizCurrency sikinIdouGaku;
                            if (hrkmNyknData.getSiteituuka().eq(mosKihon.getHrktuukasyu())) {
                                sikinIdouGaku = hrkmNyknData.getTrhkkgk();
                            }
                            else {
                                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                                C_ErrorKbn errorKbn = getKawaseRate.exec(hrkmNyknData.getAzkrhrdsymd(),
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                    hrkmNyknData.getSiteituuka(),
                                    C_Tuukasyu.JPY,
                                    C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE,
                                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                    C_YouhiKbn.HUYOU);
                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                                        hrkmNyknData.getAzkrhrdsymd().toString(),
                                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                                        hrkmNyknData.getSiteituuka().getValue(),
                                        C_Tuukasyu.JPY.getValue(),
                                        C_KawasetekiyoKbn.TTM.getValue(),
                                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                                        C_YouhiKbn.HUYOU.getValue()
                                        );

                                    batchLogger.error(errMessage);

                                    throw new BizAppException(MessageId.EHA1045);
                                }
                                BizNumber ryougaeRate = getKawaseRate.getKawaserate().add(RYOUGAERATE_YENKOUZA);
                                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                                sikinIdouGaku = keisanGaikakanzan.execDivide(hrkmNyknData.getSiteituuka(),
                                    hrkmNyknData.getTrhkkgk(),
                                    ryougaeRate,
                                    C_HasuusyoriKbn.AGE);
                            }
                            HW_SikinIdouWk sikinIdouWk = new HW_SikinIdouWk();
                            sikinIdouWk.setNyksyoriymd(hrkmNyknData.getSyoriYmd());
                            sikinIdouWk.setItirenno(hrkmNyknData.getItirenno());
                            sikinIdouWk.setSyoriYmd(syoriYmd);
                            sikinIdouWk.setSikinidoumotohonkouzacd(hrkmHonkouzaCd);
                            sikinIdouWk.setSikinidousakihonkouzacd(kykInfoHonkouzaCd);
                            sikinIdouWk.setSikinidougaku(sikinIdouGaku);
                            sikinIdouWk.setNykmosno(hrkmNyknData.getNykmosno());
                            sikinIdouWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                            sikinIdouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                            BizPropertyInitializer.initialize(sikinIdouWk);
                            sikinIdouWkInserter.add(sikinIdouWk);
                        }
                        HW_HrkmNyknTaisyouWk hrkmNyknTaisyouWk = new HW_HrkmNyknTaisyouWk();

                        hrkmNyknTaisyouWk.setSyoriYmd(syoriYmd);
                        hrkmNyknTaisyouWk.setMosno(hrkmNyknData.getNykmosno());
                        hrkmNyknTaisyouWk.setRenno(1);
                        hrkmNyknTaisyouWk.setOyadrtencd(hrkmNyknData.getOyadrtencd());
                        hrkmNyknTaisyouWk.setRyosyuymd(hrkmNyknData.getAzkrhrdsymd());
                        hrkmNyknTaisyouWk.setHrkmirninnm(hrkmNyknData.getHrkmirninnm());
                        hrkmNyknTaisyouWk.setRsgaku(hrkmNyknData.getTrhkkgk());
                        hrkmNyknTaisyouWk.setRsgakuen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                        hrkmNyknTaisyouWk.setRstuukasyu(C_Tuukasyu.JPY);
                        hrkmNyknTaisyouWk.setHrkmtsry(hrkmTsry);
                        hrkmNyknTaisyouWk.setNyksyoriymd(hrkmNyknData.getSyoriYmd());
                        hrkmNyknTaisyouWk.setHrkmnykndatarenmotoKbn(hrkmNyknData.getHrkmnykndatarenmotoKbn());
                        hrkmNyknTaisyouWk.setNyktyhyoutkbn(hrkmNyknData.getNyktyhyoutkbn());
                        hrkmNyknTaisyouWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                        hrkmNyknTaisyouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        BizPropertyInitializer.initialize(hrkmNyknTaisyouWk);

                        hrkmNyknTaisyouWkInserter.add(hrkmNyknTaisyouWk);

                        updateHrkmNyknData(hrkmNyknData);

                        syoriKensuu++;
                        continue;
                    }
                }
            }
            else if (C_KouzasyuruiKbn.GAIKAKOUZA.eq(kouzaSyuruiKbn)) {

                logKouzaSyuruiKbn = GAIKAKOUZA;

                List<String> skGkHrkmNykMosnoList = skHurikomiHuriwakeDao.getSkGkHrkmNykMosnoList();

                try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> gaikaHrkmNyknDataResults = sinkeiyakuDomManager.
                    getGaikaHrkmNyknDatasByKakutyoujobcdSyorizumiflg(kakutyoujobCd, C_Syorizumiflg.MISYORI)) {

                    for (HT_GaikaHrkmNyknData gaikaHrkmNyknData : gaikaHrkmNyknDataResults) {

                        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                        bzRecoveryDatasikibetuBean.setIbTableid(TABLEID2);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gaikaHrkmNyknData.getDensyskbn().getValue());
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(gaikaHrkmNyknData.getSyoriYmd().toString());
                        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(gaikaHrkmNyknData.getItirenno());

                        if (C_TaisyouKbn.HITAISYOU.eq(gaikaHrkmNyknData.getJidonykntargethyouji())) {

                            HW_JidouNyknTaisyougaiWk jidouNyknTaisyougaiWk = new HW_JidouNyknTaisyougaiWk();

                            jidouNyknTaisyougaiWk.setNyksyoriymd(gaikaHrkmNyknData.getSyoriYmd());
                            jidouNyknTaisyougaiWk.setItirenno(gaikaHrkmNyknData.getItirenno());
                            jidouNyknTaisyougaiWk.setNykmosno(gaikaHrkmNyknData.getNykmosno());
                            jidouNyknTaisyougaiWk.setOyadrtencd(gaikaHrkmNyknData.getOyadrtencd());
                            jidouNyknTaisyougaiWk.setTrhkkgk(gaikaHrkmNyknData.getTrhkkgk());
                            jidouNyknTaisyougaiWk.setRstuukasyu(gaikaHrkmNyknData.getTuukasyu());
                            jidouNyknTaisyougaiWk.setSyoriYmd(syoriYmd);
                            jidouNyknTaisyougaiWk.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);
                            jidouNyknTaisyougaiWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                            jidouNyknTaisyougaiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            BizPropertyInitializer.initialize(jidouNyknTaisyougaiWk);

                            jidouNyknTaisyougaiWkInserter.add(jidouNyknTaisyougaiWk);

                            updateGaikaHrkmNyknData(gaikaHrkmNyknData);

                            syoriKensuu++;

                            continue;
                        }

                        if (BizUtil.isBlank(gaikaHrkmNyknData.getOyadrtencd())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.OYADRTENCDERROR);

                            continue;
                        }

                        if (!MousikomiNoCheck.isValid(gaikaHrkmNyknData.getNykmosno())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.MOSNO);

                            continue;
                        }

                        if (!MousikomiNoCheck.ifExistMousikomiNo(gaikaHrkmNyknData.getNykmosno())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.MOSNO);

                            continue;
                        }

                        if (skGkHrkmNykMosnoList.size() != 0 && skGkHrkmNykMosnoList.contains(gaikaHrkmNyknData.getNykmosno())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.DOUITUMOSNO);

                            continue;
                        }

                        HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosKihonMosDairitenNyuukinHenkintouched(
                            sinkeiyakuDomManager.getSyoriCTL(gaikaHrkmNyknData.getNykmosno()));

                        if (syoriCTL == null) {

                            if (BizDateUtil.compareYm(mosNyuuryokuYm, gaikaHrkmNyknData.getKsnymd().getBizDateYM())
                                == BizDateUtil.COMPARE_GREATER) {

                                addGkMosMtKknKeikaWk(gaikaHrkmNyknData,
                                    mosMatiKknKeikaWkInserter);

                                continue;
                            }

                            syoriKensuu++;

                            continue;
                        }

                        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu()) || mosKihon == null) {

                            if (BizDateUtil.compareYm(mosNyuuryokuYm, gaikaHrkmNyknData.getKsnymd().getBizDateYM())
                                == BizDateUtil.COMPARE_GREATER) {

                                addGkMosMtKknKeikaWk(gaikaHrkmNyknData,
                                    mosMatiKknKeikaWkInserter);

                                continue;
                            }

                            syoriKensuu++;

                            continue;
                        }

                        if (!C_FstphrkkeiroKbn.HURIKOMI.eq(mosKihon.getFstphrkkeirokbn())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.FSTPHRKKEIRO);

                            continue;
                        }

                        if (C_TaisyouKbn.TAISYOU.eq(gaikaHrkmNyknData.getOyadrtensyoritarget())) {

                            HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                            if (mosDairiten == null ||
                                !mosDairiten.getOyadrtencd().equals(gaikaHrkmNyknData.getOyadrtencd())) {

                                addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.OYADRTENCD);

                                continue;
                            }
                        }

                        if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) ||
                            C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                            C_NyuukinHuittiriyuuKbn nyuukinHuittiriyuuKbn = null;

                            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {

                                nyuukinHuittiriyuuKbn = C_NyuukinHuittiriyuuKbn.SRGONYKN;
                            }
                            else if ( C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {

                                nyuukinHuittiriyuuKbn = C_NyuukinHuittiriyuuKbn.HSRGONYKN;
                            }

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                nyuukinHuittiriyuuKbn);

                            continue;
                        }

                        if (!mosKihon.getHrktuukasyu().eq(gaikaHrkmNyknData.getTuukasyu())) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.TUUKA);

                            continue;
                        }

                        GetRsgakukei getRsgakukei = SWAKInjector.getInstance(GetRsgakukei.class);

                        getRsgakukei.getHenkinsumiRsgaku(syoriCTL);

                        BizCurrency rsGakukei = getRsgakukei.getRsgakukei();

                        if (!rsGakukei.equalsValue(BizCurrency.valueOf(0, rsGakukei.getType()))) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.TUIKANYUUKIN);

                            continue;
                        }

                        List<HT_MosSyouhn> mosSyouhnLst = sinkeiyakuDomManager.getSyoriCTL(gaikaHrkmNyknData.getNykmosno()
                            ).getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

                        if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                            if (mosKihon.getMosfstpkei().equalsValue(
                                BizCurrency.valueOf(0, mosKihon.getMosfstpkei().getType()))) {

                                addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.ZENNOUPKEISAN);

                                continue;
                            }

                            BizDate kariSknnKaisiYmd = null;
                            BizDate kykYmd = null;
                            int nenrei = 0;

                            SetSknnkaisiymd setSknnkaisiymd = SWAKInjector.getInstance(SetSknnkaisiymd.class);
                            SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
                            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

                            setSknnkaisiymd.exec(mosKihon.getSntkhoukbn(),
                                syoriCTL.getKktymd(),
                                mosKihon.getMosymd(),
                                gaikaHrkmNyknData.getKsnymd(),
                                mosKihon.getSknnkaisikitkhukakbn(),
                                mosKihon.getMosukeymd());

                            kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

                            kykYmd = setKisoKoumoku.setkykymdHantei(mosKihon,
                                mosSyouhn,
                                gaikaHrkmNyknData.getKsnymd(),
                                mosKihon.getMosymd(),
                                kariSknnKaisiYmd,
                                BizDate.getSysDate(),
                                C_SysKbn.SKEI,
                                C_YoteikykymdKbn.SITEI);

                            nenrei = setNenrei.exec(kykYmd, mosKihon.getHhknseiymd());

                            if (mosKihon.getHhknnen() != nenrei) {

                                addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                    nyuukinJyouhouHuittiWkInserter,
                                    C_NyuukinHuittiriyuuKbn.ZENNOUPKEISAN);

                                continue;
                            }
                        }

                        if (BizCurrency.valueOf(GKNYKNKYOYOUMAXKGK, gaikaHrkmNyknData.getTrhkkgk().getType())
                            .compareTo(gaikaHrkmNyknData.getTrhkkgk()) <= 0) {

                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.KINGAKU);

                            continue;
                        }

                        if (mosKihon.getMosfstpkei().equalsValue(gaikaHrkmNyknData.getTrhkkgk())) {
                        }
                        else {
                            addGkNyknJyhHuittiWk(gaikaHrkmNyknData,
                                nyuukinJyouhouHuittiWkInserter,
                                C_NyuukinHuittiriyuuKbn.KINGAKU);

                            continue;
                        }


                        String hrkmHonkouzaCd = gaikaHrkmNyknData.getHonkouzacd();
                        HM_SyouhnTaniHonkouza2 syouhnTaniHonkouza2 = sinkeiyakuDomManager.getSyouhnTaniHonkouza2(
                            mosSyouhn.getSyouhncd(), mosKihon.getKyktuukasyu());
                        String kykInfoHonkouzaCd = syouhnTaniHonkouza2.getHonkouzacd();
                        if (!hrkmHonkouzaCd.equals(kykInfoHonkouzaCd)) {
                            BizCurrency sikinIdouGaku;
                            if (gaikaHrkmNyknData.getSiteituuka().eq(mosKihon.getHrktuukasyu())) {
                                sikinIdouGaku = gaikaHrkmNyknData.getTrhkkgk();
                            }
                            else if (!gaikaHrkmNyknData.getSiteituuka().eq(mosKihon.getHrktuukasyu())
                                && !C_Tuukasyu.JPY.eq(gaikaHrkmNyknData.getSiteituuka())) {
                                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                                C_ErrorKbn errorKbn = getKawaseRate.exec(gaikaHrkmNyknData.getKsnymd(),
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                    gaikaHrkmNyknData.getSiteituuka(),
                                    C_Tuukasyu.JPY,
                                    C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE,
                                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                    C_YouhiKbn.HUYOU);
                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                                        gaikaHrkmNyknData.getKsnymd().toString(),
                                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                                        gaikaHrkmNyknData.getSiteituuka().getValue(),
                                        C_Tuukasyu.JPY.getValue(),
                                        C_KawasetekiyoKbn.TTM.getValue(),
                                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                                        C_YouhiKbn.HUYOU.getValue()
                                        );

                                    batchLogger.error(errMessage);

                                    throw new BizAppException(MessageId.EHA1045);
                                }
                                BizNumber gokouzaRyougaeRate = getKawaseRate.getKawaserate().add(RYOUGAERATE_GAIKAKOUZA);

                                errorKbn = getKawaseRate.exec(gaikaHrkmNyknData.getKsnymd(),
                                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                                    mosKihon.getHrktuukasyu(),
                                    C_Tuukasyu.JPY,
                                    C_KawasetekiyoKbn.TTM,
                                    C_KawasetsryKbn.JISSEIRATE,
                                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                                    C_YouhiKbn.HUYOU);
                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    String errMessage = MessageUtil.getMessage(MessageId.ESA1004,
                                        gaikaHrkmNyknData.getKsnymd().toString(),
                                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                                        mosKihon.getHrktuukasyu().getValue(),
                                        C_Tuukasyu.JPY.getValue(),
                                        C_KawasetekiyoKbn.TTM.getValue(),
                                        C_KawasetsryKbn.JISSEIRATE.getValue(),
                                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                                        C_YouhiKbn.HUYOU.getValue()
                                        );

                                    batchLogger.error(errMessage);

                                    throw new BizAppException(MessageId.EHA1045);
                                }
                                BizNumber hrktuukaRyougaeRate = getKawaseRate.getKawaserate().subtract(
                                    RYOUGAERATE_GAIKAKOUZA);

                                BizNumber ryougaeRate = gokouzaRyougaeRate.divide(
                                    hrktuukaRyougaeRate, 4, RoundingMode.HALF_UP);

                                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                                sikinIdouGaku = keisanGaikakanzan.execDivide(gaikaHrkmNyknData.getSiteituuka(),
                                    gaikaHrkmNyknData.getTrhkkgk(),
                                    ryougaeRate,
                                    C_HasuusyoriKbn.AGE);
                            }
                            else {
                                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(
                                    gaikaHrkmNyknData.getSiteituuka());
                                sikinIdouGaku = BizCurrency.valueOf(0, currencyType);
                            }
                            HW_SikinIdouWk sikinIdouWk = new HW_SikinIdouWk();
                            sikinIdouWk.setNyksyoriymd(gaikaHrkmNyknData.getSyoriYmd());
                            sikinIdouWk.setItirenno(gaikaHrkmNyknData.getItirenno());
                            sikinIdouWk.setSyoriYmd(syoriYmd);
                            sikinIdouWk.setSikinidoumotohonkouzacd(hrkmHonkouzaCd);
                            sikinIdouWk.setSikinidousakihonkouzacd(kykInfoHonkouzaCd);
                            sikinIdouWk.setSikinidougaku(sikinIdouGaku);
                            sikinIdouWk.setNykmosno(gaikaHrkmNyknData.getNykmosno());
                            sikinIdouWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                            sikinIdouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                            BizPropertyInitializer.initialize(sikinIdouWk);
                            sikinIdouWkInserter.add(sikinIdouWk);
                        }
                        BizCurrency hrkmTsry = mosKihon.getMosfstpkei().subtract(gaikaHrkmNyknData.getTrhkkgk());

                        HW_HrkmNyknTaisyouWk hrkmNyknTaisyouWk = new HW_HrkmNyknTaisyouWk();

                        hrkmNyknTaisyouWk.setSyoriYmd(syoriYmd);
                        hrkmNyknTaisyouWk.setMosno(gaikaHrkmNyknData.getNykmosno());
                        hrkmNyknTaisyouWk.setRenno(1);
                        hrkmNyknTaisyouWk.setOyadrtencd(gaikaHrkmNyknData.getOyadrtencd());
                        hrkmNyknTaisyouWk.setRyosyuymd(gaikaHrkmNyknData.getKsnymd());
                        hrkmNyknTaisyouWk.setHrkmirninnm(gaikaHrkmNyknData.getHrkmirninnm());
                        hrkmNyknTaisyouWk.setRsgaku(gaikaHrkmNyknData.getTrhkkgk());
                        hrkmNyknTaisyouWk.setRsgakuen(gaikaHrkmNyknData.getDengk());
                        hrkmNyknTaisyouWk.setRstuukasyu(gaikaHrkmNyknData.getTuukasyu());
                        hrkmNyknTaisyouWk.setHrkmtsry(hrkmTsry);
                        hrkmNyknTaisyouWk.setNyksyoriymd(gaikaHrkmNyknData.getSyoriYmd());
                        hrkmNyknTaisyouWk.setHrkmnykndatarenmotoKbn(gaikaHrkmNyknData.getHrkmnykndatarenmotoKbn());
                        hrkmNyknTaisyouWk.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);
                        hrkmNyknTaisyouWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
                        hrkmNyknTaisyouWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        BizPropertyInitializer.initialize(hrkmNyknTaisyouWk);

                        hrkmNyknTaisyouWkInserter.add(hrkmNyknTaisyouWk);

                        updateGaikaHrkmNyknData(gaikaHrkmNyknData);

                        syoriKensuu++;

                        continue;
                    }
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriKensuu), tskNm + logKouzaSyuruiKbn));
        }
    }

    private void addNyknJyhHuittiWk(HT_HrkmNyknData pHrkmNyknData,
        EntityInserter<HW_NyuukinJyouhouHuittiWk> pNyknJhHuittiWkInserter,
        C_NyuukinHuittiriyuuKbn pNyuukinHuittiriyuuKbn) {

        HW_NyuukinJyouhouHuittiWk nyknJyouhouHuittiWk = new HW_NyuukinJyouhouHuittiWk();

        nyknJyouhouHuittiWk.setNyksyoriymd(pHrkmNyknData.getSyoriYmd());
        nyknJyouhouHuittiWk.setItirenno(pHrkmNyknData.getItirenno());
        nyknJyouhouHuittiWk.setKouzano(pHrkmNyknData.getKouzano());
        nyknJyouhouHuittiWk.setHrkmirnincd(pHrkmNyknData.getHrkmirnincd());
        nyknJyouhouHuittiWk.setHrkmirninnm(pHrkmNyknData.getHrkmirninnm());
        nyknJyouhouHuittiWk.setHrkmirninnm140(pHrkmNyknData.getHrkmirninnm140());
        nyknJyouhouHuittiWk.setTrhkkgk(pHrkmNyknData.getTrhkkgk());
        nyknJyouhouHuittiWk.setRstuukasyu(C_Tuukasyu.JPY);
        nyknJyouhouHuittiWk.setBanknmkn(pHrkmNyknData.getBanknmkn());
        nyknJyouhouHuittiWk.setSitennmkn(pHrkmNyknData.getSitennmkn());
        nyknJyouhouHuittiWk.setSimukebanknm(pHrkmNyknData.getSimukebanknmkn());
        nyknJyouhouHuittiWk.setSimuketennm(pHrkmNyknData.getSimuketennmkn());
        nyknJyouhouHuittiWk.setSeikeijizenkizennouumu(C_UmuKbn.NONE);
        nyknJyouhouHuittiWk.setNyuukinhuittiriyuukbn(pNyuukinHuittiriyuuKbn);
        nyknJyouhouHuittiWk.setOyadrtencd(pHrkmNyknData.getOyadrtencd());
        nyknJyouhouHuittiWk.setKnjyymd(pHrkmNyknData.getAzkrhrdsymd());
        nyknJyouhouHuittiWk.setNykmosno(pHrkmNyknData.getNykmosno());
        nyknJyouhouHuittiWk.setSyoriYmd(skHrkmHuriwakeBatchParam.getSyoriYmd());
        nyknJyouhouHuittiWk.setNyktyhyoutkbn(pHrkmNyknData.getNyktyhyoutkbn());
        nyknJyouhouHuittiWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        nyknJyouhouHuittiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        nyknJyouhouHuittiWk.setHrkmnykndatarenmotoKbn(pHrkmNyknData.getHrkmnykndatarenmotoKbn());
        nyknJyouhouHuittiWk.setOyadrtensyoritarget(pHrkmNyknData.getOyadrtensyoritarget());
        BizPropertyInitializer.initialize(nyknJyouhouHuittiWk);

        pNyknJhHuittiWkInserter.add(nyknJyouhouHuittiWk);

        updateHrkmNyknData(pHrkmNyknData);

        syoriKensuu++;
    }

    private void addMosMatiKknKeikaWk(HT_HrkmNyknData pHrkmNyknData,
        EntityInserter<HW_MosMatiKknKeikaWk> pMosMatiKknKeikaWkInserter) {

        HW_MosMatiKknKeikaWk mosMatiKknKeikaWk = new HW_MosMatiKknKeikaWk();

        mosMatiKknKeikaWk.setNyksyoriymd(pHrkmNyknData.getSyoriYmd());
        mosMatiKknKeikaWk.setItirenno(pHrkmNyknData.getItirenno());
        mosMatiKknKeikaWk.setOyadrtencd(pHrkmNyknData.getOyadrtencd());
        mosMatiKknKeikaWk.setKnjyymd(pHrkmNyknData.getAzkrhrdsymd());
        mosMatiKknKeikaWk.setMosno(pHrkmNyknData.getNykmosno());
        mosMatiKknKeikaWk.setHrkmirninnm(pHrkmNyknData.getHrkmirninnm());
        mosMatiKknKeikaWk.setTrhkkgk(pHrkmNyknData.getTrhkkgk());
        mosMatiKknKeikaWk.setRstuukasyu(C_Tuukasyu.JPY);
        mosMatiKknKeikaWk.setSyoriYmd(skHrkmHuriwakeBatchParam.getSyoriYmd());
        mosMatiKknKeikaWk.setHrkmnykndatarenmotoKbn(pHrkmNyknData.getHrkmnykndatarenmotoKbn());
        mosMatiKknKeikaWk.setNyktyhyoutkbn(pHrkmNyknData.getNyktyhyoutkbn());
        mosMatiKknKeikaWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        mosMatiKknKeikaWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        mosMatiKknKeikaWk.setNyuukinoyadrtennm(pHrkmNyknData.getNyuukinoyadrtennm());
        BizPropertyInitializer.initialize(mosMatiKknKeikaWk);

        pMosMatiKknKeikaWkInserter.add(mosMatiKknKeikaWk);

        updateHrkmNyknData(pHrkmNyknData);

        syoriKensuu++;
    }

    private void addGkNyknJyhHuittiWk(HT_GaikaHrkmNyknData pGaikaHrkmNyknData,
        EntityInserter<HW_NyuukinJyouhouHuittiWk> pNyknJhHuittiWkInserter,
        C_NyuukinHuittiriyuuKbn pNyuukinHuittiriyuuKbn) {

        HW_NyuukinJyouhouHuittiWk nyuukinJyouhouHuittiWk = new HW_NyuukinJyouhouHuittiWk();

        String simukeBankNmEiji = ConvertUtil.toZenAll(
            pGaikaHrkmNyknData.getSimukebanknmeiji(), 0, 1);

        String simukeTenNmEiji = ConvertUtil.toZenAll(
            pGaikaHrkmNyknData.getSimuketennmeiji(), 0, 1);

        nyuukinJyouhouHuittiWk.setNyksyoriymd(pGaikaHrkmNyknData.getSyoriYmd());
        nyuukinJyouhouHuittiWk.setItirenno(pGaikaHrkmNyknData.getItirenno());
        nyuukinJyouhouHuittiWk.setKouzano(pGaikaHrkmNyknData.getKouzano());
        nyuukinJyouhouHuittiWk.setHrkmirnincd("");
        nyuukinJyouhouHuittiWk.setHrkmirninnm(pGaikaHrkmNyknData.getHrkmirninnm());
        nyuukinJyouhouHuittiWk.setHrkmirninnm140(pGaikaHrkmNyknData.getHrkmirninnm140());
        nyuukinJyouhouHuittiWk.setTrhkkgk(pGaikaHrkmNyknData.getTrhkkgk());
        nyuukinJyouhouHuittiWk.setRstuukasyu(pGaikaHrkmNyknData.getTuukasyu());
        nyuukinJyouhouHuittiWk.setBanknmkn(pGaikaHrkmNyknData.getBanknmkn());
        nyuukinJyouhouHuittiWk.setSitennmkn(pGaikaHrkmNyknData.getSitennmkn());
        nyuukinJyouhouHuittiWk.setSimukebanknm(simukeBankNmEiji);
        nyuukinJyouhouHuittiWk.setSimuketennm(simukeTenNmEiji);
        nyuukinJyouhouHuittiWk.setSeikeijizenkizennouumu(C_UmuKbn.NONE);
        nyuukinJyouhouHuittiWk.setNyuukinhuittiriyuukbn(pNyuukinHuittiriyuuKbn);
        nyuukinJyouhouHuittiWk.setOyadrtencd(pGaikaHrkmNyknData.getOyadrtencd());
        nyuukinJyouhouHuittiWk.setKnjyymd(pGaikaHrkmNyknData.getKsnymd());
        nyuukinJyouhouHuittiWk.setNykmosno(pGaikaHrkmNyknData.getNykmosno());
        nyuukinJyouhouHuittiWk.setSyoriYmd(skHrkmHuriwakeBatchParam.getSyoriYmd());
        nyuukinJyouhouHuittiWk.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);
        nyuukinJyouhouHuittiWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        nyuukinJyouhouHuittiWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        nyuukinJyouhouHuittiWk.setHrkmnykndatarenmotoKbn(pGaikaHrkmNyknData.getHrkmnykndatarenmotoKbn());
        nyuukinJyouhouHuittiWk.setOyadrtensyoritarget(pGaikaHrkmNyknData.getOyadrtensyoritarget());
        BizPropertyInitializer.initialize(nyuukinJyouhouHuittiWk);

        pNyknJhHuittiWkInserter.add(nyuukinJyouhouHuittiWk);

        updateGaikaHrkmNyknData(pGaikaHrkmNyknData);

        syoriKensuu++;
    }

    private void addGkMosMtKknKeikaWk(HT_GaikaHrkmNyknData pGaikaHrkmNyknData,
        EntityInserter<HW_MosMatiKknKeikaWk> pMosMatiKknKeikaWkInserter) {

        HW_MosMatiKknKeikaWk mosMatiKknKeikaWk = new HW_MosMatiKknKeikaWk();

        mosMatiKknKeikaWk.setNyksyoriymd(pGaikaHrkmNyknData.getSyoriYmd());
        mosMatiKknKeikaWk.setItirenno(pGaikaHrkmNyknData.getItirenno());
        mosMatiKknKeikaWk.setOyadrtencd(pGaikaHrkmNyknData.getOyadrtencd());
        mosMatiKknKeikaWk.setKnjyymd(pGaikaHrkmNyknData.getKsnymd());
        mosMatiKknKeikaWk.setMosno(pGaikaHrkmNyknData.getNykmosno());
        mosMatiKknKeikaWk.setHrkmirninnm(pGaikaHrkmNyknData.getHrkmirninnm());
        mosMatiKknKeikaWk.setTrhkkgk(pGaikaHrkmNyknData.getTrhkkgk());
        mosMatiKknKeikaWk.setRstuukasyu(pGaikaHrkmNyknData.getTuukasyu());
        mosMatiKknKeikaWk.setSyoriYmd(skHrkmHuriwakeBatchParam.getSyoriYmd());
        mosMatiKknKeikaWk.setHrkmnykndatarenmotoKbn(pGaikaHrkmNyknData.getHrkmnykndatarenmotoKbn());
        mosMatiKknKeikaWk.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);
        mosMatiKknKeikaWk.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        mosMatiKknKeikaWk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        mosMatiKknKeikaWk.setNyuukinoyadrtennm(pGaikaHrkmNyknData.getNyuukinoyadrtennm());
        BizPropertyInitializer.initialize(mosMatiKknKeikaWk);

        pMosMatiKknKeikaWkInserter.add(mosMatiKknKeikaWk);

        updateGaikaHrkmNyknData(pGaikaHrkmNyknData);

        syoriKensuu++;
    }

    private void updateHrkmNyknData(HT_HrkmNyknData pHrkmNyknData) {

        pHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
        pHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
        pHrkmNyknData.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        pHrkmNyknData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
    }

    private void updateGaikaHrkmNyknData(HT_GaikaHrkmNyknData pGaikaHrkmNyknData) {

        pGaikaHrkmNyknData.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
        pGaikaHrkmNyknData.setGyoumuKousinKinou(kinou.getKinouId());
        pGaikaHrkmNyknData.setGyoumuKousinsyaId(skHrkmHuriwakeBatchParam.getUserId());
        pGaikaHrkmNyknData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private String kuuhakuJyokyo(String pSiteiMojiretu) {
        String henkanKekka = pSiteiMojiretu;
        henkanKekka = henkanKekka.replaceAll(HANKAKUSPACE, BLANK);
        henkanKekka = henkanKekka.replaceAll(ZENKAKUSPACE, BLANK);

        return henkanKekka;
    }
}
