package yuyu.batch.hozen.khozen.khgaikakokyakutuutisks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khgaikakokyakutuutisks.dba.KhGaikaKokyakuTuutiSksDao;
import yuyu.batch.hozen.khozen.khgaikakokyakutuutisks.dba.KhHenkouUktkBean;
import yuyu.batch.hozen.khozen.tyohyouhonbankakunin.dba.TyohyouHonbanKakuninBatchDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.CheckTyohyouHnbnKknKokyakuTuutiSks;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase;
import yuyu.common.hozen.khcommon.HanteiKekkaBean;
import yuyu.common.hozen.khcommon.HanteiKekkaKokyakuTuutiSksBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KawaseRateBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TyohyouHonbanKakuninBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 外貨建顧客通知作成
 */
public class KhGaikaKokyakuTuutiSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private static Logger logger;

    @Inject
    private KhGaikaKokyakuTuutiSksBatchParam khGaikaKokyakuTuutiSksBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhGaikaKokyakuTuutiSksDao khGaikaKokyakuTuutiSksDao;

    @Inject
    private TyohyouHonbanKakuninBatchDao tyohyouHonbanKakuninBatchDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykKihon";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final String SAISYORITAISYOU_1 = "01";

    private static final String SAISYORITAISYOU_2 = "02";

    private static final String HASSOUKBN_HONSYAKAISOU = "2";

    private static final String DSTRKJYKY_NASHI = "0";

    private static final String DSTRKJYKY_TRKARI_KIYK_ARI = "1";

    private static final String DSTRKJYKY_TRKARI_KIYK_NASHI = "2";

    private static final String DSTRKJYKY_MSKMARI_KIYK_ARI = "3";

    private static final String DSTRKJYKY_MSKMARI_KIYK_NASHI = "4";

    private static final String TUUTISYURUICD_SIMO4KETA = "0001";

    private static final String JYOUKENBUNRUI1_000 = "000";

    private static final String JYOUKENBUNRUI1_070 = "070";

    private static final String JYOUKENBUNRUI1_080 = "080";

    private static final String JYOUKENBUNRUI1_090 = "090";

    private static final String JYOUKENBUNRUI2_001 = "001";

    private static final String JYOUKENBUNRUI3_001 = "001";

    private static final String JYOUKENBUNRUI3_002 = "002";

    private static final String JYOUKENBUNRUI3_003 = "003";

    private static final String JYOUKENBUNRUI3_004 = "004";

    private static final String JYOUKENBUNRUI3_005 = "005";

    private static final String REPORTLAYOUTPTN_CAS_SISUU = "04";

    private boolean ds001Flg = true;

    private boolean ds002Flg = true;

    private boolean ds003Flg = true;

    private boolean ds004Flg = true;

    private boolean ds005Flg = true;

    HashMap<String, Boolean> hnbnKknnFlgMap= new HashMap<>();

    private String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

    private int dataNo = 0;

    private int missListDataNo_sisuu1 = 0;

    private int missListDataNo_sisuu2 = 0;

    private String missListSyoNo_sisuu1 = null;

    private String missListSyoNo_sisuu2 = null;

    private List<EditKhMisslstParam> missListTblPrmLst = new ArrayList<>();

    private int missListSeqNo = 0;

    @Override
    public BatchParam getParam() {
        return khGaikaKokyakuTuutiSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String saiSyoritaisyouKbn = khGaikaKokyakuTuutiSksBatchParam.getSaiSyoritaisyouKbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IIF1021, saiSyoritaisyouKbn));

        BizDate syoriYmd = khGaikaKokyakuTuutiSksBatchParam.getSyoriYmd();
        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);
        KawaseRateBean kawaseRateBean = editKykNaiyouOsirase.getKawaseRateBean(syoriYmd);

        C_ErrorKbn sisuu1ResultKbn = null;
        C_ErrorKbn sisuu2ResultKbn = null;
        long sisuu1SkipCount = 0;
        long sisuu2SkipCount = 0;
        BizDate sisuuKijunYmd = syoriYmd.addBusinessDays(-1);

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        sisuu1ResultKbn = getSisuu.exec(C_Sisuukbn.BLCON1,sisuuKijunYmd,C_YouhiKbn.HUYOU);
        sisuu2ResultKbn = getSisuu.exec(C_Sisuukbn.BLCON2,sisuuKijunYmd,C_YouhiKbn.HUYOU);

        List<TyohyouHonbanKakuninBean> khTyouhyouHonbanHknList = new ArrayList<>();
        List<TyohyouHonbanKakuninBean> khTyouhyouHonbanUbdList = new ArrayList<>();

        khTyouhyouHonbanHknList = tyohyouHonbanKakuninBatchDao.getKhTyouhyouHonbanKakuninMikakuninInfos(
            C_TyouhyouBunruiKbn.KOKYAKUTUUTI, syoriYmd);

        String ibKakutyoujobCd = khGaikaKokyakuTuutiSksBatchParam.getIbKakutyoujobcd();
        int syoriKensuu = 0;
        int khtyouhyouHonbanCount = 0;
        HashMap<Boolean, BizDate> syrYmdHanteiKekka;
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        CheckTyohyouHnbnKknKokyakuTuutiSks checkTyohyouHnbnKknKokyakuTuutiSks = SWAKInjector.getInstance(
            CheckTyohyouHnbnKknKokyakuTuutiSks.class);
        HashMap<String, Integer> hnbnKknnCntMap= new HashMap<>();

        try (ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> exDBResults = khGaikaKokyakuTuutiSksDao.
            getGaikaKokyakuTuutiInfosByKakutyoujobcd(ibKakutyoujobCd);
            EntityInserter<ZT_GaikaKokyakuTuutiTy> entityInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> entityInserterTuuti = new EntityInserter<>()) {

            for (GaikaKokyakuTuutiInfosByKakutyoujobcdBean gaikaKokyakuTuutiInfosByKakutyoujobcdBean : exDBResults) {

                IT_KykKihon kykKihon = gaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon();
                IT_KykSyouhn kykSyouhn = gaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykSyouhn();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                BizDate hknkknmanryouymd = kykSyouhn.getHknkknmanryouymd();

                String syouhinHanmeiKbn = "";

                BizDate kykOutouYMD = null;

                if ((BizDateUtil.compareYmd(kykKihon.getSeirituymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER)){
                    continue;
                }

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
                    syrYmdHanteiKekka= checkSyrTishYmd(kykSyouhn.getKykymd(),C_Hrkkaisuu.HALFY, syoriYmd);

                    if(syrYmdHanteiKekka.containsKey(true)){
                        syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA;
                        kykOutouYMD = syrYmdHanteiKekka.get(true);
                    }else{
                        continue;
                    }
                }
                else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                    syrYmdHanteiKekka= checkSyrTishYmd(kykSyouhn.getKykymd(),C_Hrkkaisuu.HALFY, syoriYmd);

                    if(syrYmdHanteiKekka.containsKey(true)){
                        syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_GAIKA_KAITEI;
                        kykOutouYMD = syrYmdHanteiKekka.get(true);
                    }else{
                        continue;
                    }
                }
                else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                    if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())){
                        syrYmdHanteiKekka= checkSyrTishYmd(kykSyouhn.getKykymd(),C_Hrkkaisuu.NEN, syoriYmd);
                        if(syrYmdHanteiKekka.containsKey(true)){
                            if(kykSyouhn.getTmttknitenymd() == null){
                                syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITU;
                            }else{
                                syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_TEIRITUITEN;
                            }
                            kykOutouYMD = syrYmdHanteiKekka.get(true);
                        }else {
                            continue;
                        }
                    }else{
                        syrYmdHanteiKekka= checkSyrTishYmd(kykSyouhn.getKykymd(),C_Hrkkaisuu.NEN, syoriYmd);
                        if(syrYmdHanteiKekka.containsKey(true)){
                            syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU;
                            kykOutouYMD = syrYmdHanteiKekka.get(true);
                        }else{

                            BizDate kijyunYmd3Mmae = kykSyouhn.getKykymd().addMonths(-3).getRekijyou();

                            syrYmdHanteiKekka= checkSyrTishYmd(kijyunYmd3Mmae,C_Hrkkaisuu.NEN, syoriYmd);
                            if(syrYmdHanteiKekka.containsKey(true) &&
                                syrYmdHanteiKekka.get(true).compareTo(kykSyouhn.getKykymd()) > 0 &&
                                syrYmdHanteiKekka.get(true).compareTo(hknkknmanryouymd.addYears(-1)) < 0){

                                syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE;

                                BizDate kykOutouYMD3MonthMae = syrYmdHanteiKekka.get(true);
                                kykOutouYMD = kykOutouYMD3MonthMae;

                            }else{
                                continue;
                            }
                        }
                    }
                }else{
                    continue;
                }


                if (saiSyoritaisyouKbn.equals(SAISYORITAISYOU_1) &&
                    C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())){
                    if(!kykSyouhn.getSisuukbn().eq(C_Sisuukbn.BLCON1)){
                        continue;
                    }
                }
                else if (saiSyoritaisyouKbn.equals(SAISYORITAISYOU_2) &&
                    C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())){
                    if(!kykSyouhn.getSisuukbn().eq(C_Sisuukbn.BLCON2)){
                        continue;
                    }
                }

                dataNo = dataNo + 1;

                List<JT_SkKihon> skKihonList =
                    khGaikaKokyakuTuutiSksDao.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
                        kykKihon.getSyono(), C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

                JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonList);

                if (skKihonList.size() != 0) {
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "変更受付中", "変更後"));

                    continue;
                }

                C_UktkSyoriKbn uktkSyoriKbn = C_UktkSyoriKbn.BLNK;

                C_UmuKbn uktkFlag = C_UmuKbn.NONE;

                List<KhHenkouUktkBean> khHenkouUktkBeanLst = khGaikaKokyakuTuutiSksDao.getKhHenkouUktkBySyono(kykKihon
                    .getSyono());

                for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

                    uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();
                    if (C_UktkSyoriKbn.KAIYAKU.eq(uktkSyoriKbn) ||
                        C_UktkSyoriKbn.MKHGKTTTYENDTHNK.eq(uktkSyoriKbn) ||
                        C_UktkSyoriKbn.NINISEIKYUU.eq(uktkSyoriKbn)) {

                        uktkFlag = C_UmuKbn.ARI;
                        break;
                    }
                }
                if (C_UmuKbn.ARI.eq(uktkFlag)) {
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "変更受付中", "変更後"));

                    continue;
                }
                BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
                    SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
                bzGetProcessSummaryInBean.setSyoNo(kykKihon.getSyono());
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                    .exec(bzGetProcessSummaryInBean);

                for (BzGetProcessSummaryOutBean processSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

                    String jimuTetuzukiCd = processSummaryOutBean.getJimuTetuzukiCd();
                    String syoriTaskid = processSummaryOutBean.getNowNodoId();

                    if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(jimuTetuzukiCd) ||
                        IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU.equals(jimuTetuzukiCd)) {

                        if (!IKhozenCommonConstants.NODEID_SYORUITOUTYAKU.equals(syoriTaskid)) {
                            uktkFlag = C_UmuKbn.ARI;
                        }
                    }

                    if (TeisuuSiharai.JIMUTETUZUKICD_SISIBOU.equals(jimuTetuzukiCd)) {

                        uktkFlag = C_UmuKbn.ARI;
                    }
                }

                if (C_UmuKbn.ARI.eq(uktkFlag)) {
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "事務手続き中", "手続き後"));

                    continue;
                }

                IT_KykKihon kykKihonForKhTtdkTyuui = hozenDomManager.getKykKihon(kykKihon.getSyono());
                IT_KykKihonDetacher.detachKhTtdkTyuuitouched(kykKihonForKhTtdkTyuui);
                IT_KhTtdkTyuui khTtdkTyuui = kykKihonForKhTtdkTyuui.getKhTtdkTyuui();
                if (khTtdkTyuui != null) {
                    if (C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn1())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn2())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn3())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn4())
                        || C_TtdktyuuiKbn.ADRHUMEI.eq(khTtdkTyuui.getTtdktyuuikbn5())) {

                        makeMissListData(dataNo, kykKihon.getSyono(),
                            MessageUtil.getMessage(MessageId.EIF1122, "住所未登録", "登録後"));
                        continue;
                    }
                }

                if(syouhinHanmeiKbn.equals(EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU) ||
                    syouhinHanmeiKbn.equals(EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_SISUU3MONTHMAE)){
                    if(kykSyouhn.getSisuukbn().eq(C_Sisuukbn.BLCON1) &&
                        C_ErrorKbn.ERROR.eq(sisuu1ResultKbn)){
                        sisuu1SkipCount = sisuu1SkipCount + 1;

                        if(missListDataNo_sisuu1 == 0 && missListSyoNo_sisuu1 == null){
                            missListDataNo_sisuu1 = dataNo;
                            missListSyoNo_sisuu1 = kykKihon.getSyono();
                        }

                        continue;
                    }
                    if(kykSyouhn.getSisuukbn().eq(C_Sisuukbn.BLCON2) &&
                        C_ErrorKbn.ERROR.eq(sisuu2ResultKbn)){
                        sisuu2SkipCount = sisuu2SkipCount + 1;

                        if(missListDataNo_sisuu2 == 0 && missListSyoNo_sisuu2 == null){
                            missListDataNo_sisuu2 = dataNo;
                            missListSyoNo_sisuu2 = kykKihon.getSyono();
                        }

                        continue;
                    }
                }

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                    HanteiKhSisuurendoTmttknJyoutai tmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                    HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

                    hanteiTmttknJyoutaiBean.setSyono(kykKihon.getSyono());
                    hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                    hanteiTmttknJyoutaiBean.setKykymd(kykSyouhn.getKykymd());

                    if(!tmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean)){
                        makeMissListData(dataNo, kykKihon.getSyono(),
                            MessageUtil.getMessage(MessageId.EIF1122, "積立金未反映", "反映後"));

                        continue;
                    }
                }

                ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(
                    kykKihon.getSyono(),
                    syoriYmd,
                    kykOutouYMD,
                    syouhinHanmeiKbn,
                    khGaikaKokyakuTuutiSksBatchParam.getCampaignUmuKbn(),
                    kawaseRateBean,
                    EditKykNaiyouOsirase.YOBIDASIMOTOKBN_BATCH);

                if(C_ErrorKbn.ERROR.eq(editKykNaiyouOsirase.getCommonErrorKbn())){
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "金額計算エラー", "エラー解消後"));
                    continue;
                }

                HanteiKekkaBean hanteiKekkaBean =
                    checkTyohyouHnbnKkn(khTyouhyouHonbanHknList, kykKihon, kykSyouhn, gaikaKokyakuTuutiTy);
                HanteiKekkaKokyakuTuutiSksBean hanteiKekkaKokyakuBean = checkTyohyouHnbnKknKokyakuTuutiSks.hanteiByCount(
                    khTyouhyouHonbanHknList, hnbnKknnCntMap, kykKihon, kykSyouhn, gaikaKokyakuTuutiTy);

                if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getUpdateKbn())||
                    C_UmuKbn.ARI.eq(hanteiKekkaKokyakuBean.getUpdateKbn())) {

                    gaikaKokyakuTuutiTy.setZtyhassoukbn(HASSOUKBN_HONSYAKAISOU);

                    if (hanteiKekkaBean.getTyohyouHonbanKakuninBeanList() != null &&
                        hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size() > 0) {
                        khTyouhyouHonbanUbdList.addAll(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList());
                    }
                    if (hanteiKekkaKokyakuBean.getTyohyouHonbanKakuninBeanList() != null &&
                        hanteiKekkaKokyakuBean.getTyohyouHonbanKakuninBeanList().size() > 0) {
                        khTyouhyouHonbanUbdList.addAll(hanteiKekkaKokyakuBean.getTyohyouHonbanKakuninBeanList());
                    }
                }

                hnbnKknnCntMap = hanteiKekkaKokyakuBean.getTyouhyouHnbnKknnCntMap();

                BizPropertyInitializer.initialize(gaikaKokyakuTuutiTy);

                entityInserter.add(gaikaKokyakuTuutiTy);


                String saiban =
                    RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();

                tuutirirekiMeisaiHokan.setTuutirirekirenno(saiban);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + kykKihon.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + TUUTISYURUICD_SIMO4KETA);
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                entityInserterTuuti.add(tuutirirekiMeisaiHokan);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if(sisuu1SkipCount > 0){
            batchLogger.info(MessageUtil.getMessage(MessageId.IIF1022,
                sisuuKijunYmd.toString(), C_Sisuukbn.BLCON1.getContent(), String.valueOf(sisuu1SkipCount)));
            makeMissListData(missListDataNo_sisuu1, missListSyoNo_sisuu1,
                MessageUtil.getMessage(MessageId.EIF1123, C_Sisuukbn.BLCON1.getContent(), String.valueOf(sisuu1SkipCount)));
        }
        if(sisuu2SkipCount > 0){
            batchLogger.info(MessageUtil.getMessage(MessageId.IIF1022,
                sisuuKijunYmd.toString(), C_Sisuukbn.BLCON2.getContent(), String.valueOf(sisuu2SkipCount)));
            makeMissListData(missListDataNo_sisuu2, missListSyoNo_sisuu2,
                MessageUtil.getMessage(MessageId.EIF1123, C_Sisuukbn.BLCON2.getContent(), String.valueOf(sisuu2SkipCount)));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        if (missListTblPrmLst.size() > 0){
            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
            khozenTyouhyouCtl.setEditKkMisslstParam(missListTblPrmLst);
            khozenTyouhyouCtl.setSyoriYmd(syoriYmd);

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_GAIKAKOKYAKUTUUTISKS_MISSLIST},
                C_YouhiKbn.HUYOU);

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(missListTblPrmLst.size()), "ミスリスト"));
        }

        try (EntityUpdater<IT_KhTyouhyouHonbanKakunin> entityUpdaterTyhyhnbn = new EntityUpdater<>();) {
            if (khTyouhyouHonbanUbdList.size() > 0) {
                HashSet<TyohyouHonbanKakuninBean>  khTyouhyouHonbanUbdListSet = new HashSet<TyohyouHonbanKakuninBean>();

                khTyouhyouHonbanUbdListSet.addAll(khTyouhyouHonbanUbdList);

                khTyouhyouHonbanUbdList.clear();

                khTyouhyouHonbanUbdList.addAll(khTyouhyouHonbanUbdListSet);

                for (TyohyouHonbanKakuninBean khTyouhyouHonbanUbd : khTyouhyouHonbanUbdList) {

                    IT_KhTyouhyouHonbanKakunin khTyouhyouHonbanKakunin = hozenDomManager.getKhTyouhyouHonbanKakunin(
                        khTyouhyouHonbanUbd.getTyouhyoubunrui(),
                        khTyouhyouHonbanUbd.getSyoruiCd(),
                        khTyouhyouHonbanUbd.getJyoukenbunrui1(),
                        khTyouhyouHonbanUbd.getJyoukenbunrui2(),
                        khTyouhyouHonbanUbd.getJyoukenbunrui3());

                    if (C_KakuninjyoutaiKbn.BLNK.eq(khTyouhyouHonbanKakunin.getKakuninjyoutaikbn()) ||
                        C_KakuninjyoutaiKbn.MISYORI.eq(khTyouhyouHonbanKakunin.getKakuninjyoutaikbn())) {

                        khTyouhyouHonbanKakunin.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.KAKUNINZUMI);
                        khTyouhyouHonbanKakunin.setFirstkaisouymd(syoriYmd);
                        khTyouhyouHonbanKakunin.setHonbankakuninymd(syoriYmd);
                        khTyouhyouHonbanKakunin.setGyoumuKousinKinou(kinou.getKinouId());
                        khTyouhyouHonbanKakunin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        khTyouhyouHonbanKakunin.setGyoumuKousinTime(sysDateTimeMilli);

                        entityUpdaterTyhyhnbn.add(khTyouhyouHonbanKakunin);

                        khtyouhyouHonbanCount++;
                    }
                }
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(khtyouhyouHonbanCount),
                    ResourceUtil.getApplicationResources().getString(IT_KhTyouhyouHonbanKakunin.TABLE_NAME)));
            }
        } catch(Exception e) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IIF1018,
                ResourceUtil.getApplicationResources().getString(IT_KhTyouhyouHonbanKakunin.TABLE_NAME)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private HanteiKekkaBean checkTyohyouHnbnKkn(List<TyohyouHonbanKakuninBean> pkhTyouhyouHonbanHknList,
        IT_KykKihon pkhKykKihon, IT_KykSyouhn pkhKykSyouhn, ZT_GaikaKokyakuTuutiTy pkhGikKkykTutiTy) {

        logger.debug("▽ 帳票本番確認判定 開始");

        String pkhSyono = pkhKykKihon.getSyono();
        HanteiKekkaBean hanteiKekkaBean = SWAKInjector.getInstance(HanteiKekkaBean.class);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = new ArrayList<>();

        logger.debug("   帳票本番確認判定条件 件数：" + String.valueOf(pkhTyouhyouHonbanHknList.size()) + "件");

        for (TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean : pkhTyouhyouHonbanHknList) {

            String joukenbunruiKey = tyohyouHonbanKakuninBean.getJyoukenbunrui1() +
                tyohyouHonbanKakuninBean.getJyoukenbunrui2() + tyohyouHonbanKakuninBean.getJyoukenbunrui3();

            logger.debug("   帳票本番確認判定条件 条件：" + joukenbunruiKey);

            if (JYOUKENBUNRUI1_000.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                logger.info(MessageUtil.getMessage(MessageId.IIF1017, JYOUKENBUNRUI1_000, pkhSyono));
            }

            if (JYOUKENBUNRUI1_070.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (JYOUKENBUNRUI2_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui2())) {
                    if (JYOUKENBUNRUI3_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei = check070001001(pkhSyono, pkhKykSyouhn, pkhGikKkykTutiTy, joukenbunruiKey);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        }
                    }
                    if (JYOUKENBUNRUI3_002.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei = check070001002(pkhSyono, pkhKykSyouhn, pkhGikKkykTutiTy, joukenbunruiKey);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        }
                    }
                }
            }

            if (JYOUKENBUNRUI1_080.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                IT_KykKihon kykKihonForSonotaTkyk = hozenDomManager.getKykKihon(pkhSyono);
                IT_KykKihonDetacher.detachKykSonotaTkyktouched(kykKihonForSonotaTkyk);
                IT_KykSonotaTkyk kKykSonotaTkyk = kykKihonForSonotaTkyk.getKykSonotaTkyk();

                if (JYOUKENBUNRUI2_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui2())) {
                    if (JYOUKENBUNRUI3_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (C_AisyoumeiKbn.GAIKAINDEXNK_MDHN.eq(pkhKykKihon.getAisyoumeikbn()) &&
                            pkhKykKihon.getSbuktnin() > 1 &&
                            C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(pkhKykSyouhn.getNksyukbn()) &&
                            C_UmuKbn.ARI.eq(kKykSonotaTkyk.getStdrsktkyhkumu()) &&
                            C_UmuKbn.ARI.eq(kKykSonotaTkyk.getYennykntkhkumu()) &&
                            REPORTLAYOUTPTN_CAS_SISUU.equals(pkhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) &&
                            hnbnKknnFlgMap.get(joukenbunruiKey)==null) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hnbnKknnFlgMap.put(joukenbunruiKey, false);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017, joukenbunruiKey, pkhSyono));
                        }
                    }
                    if (JYOUKENBUNRUI3_002.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (C_AisyoumeiKbn.GAIKAINDEXNK_SMBC.eq(pkhKykKihon.getAisyoumeikbn()) &&
                            pkhKykKihon.getSbuktnin() > 1 &&
                            C_Nenkinsyu.KAKUTEINENKIN.eq(pkhKykSyouhn.getNksyukbn()) &&
                            (pkhKykSyouhn.getNenkinkkn() == 5 || pkhKykSyouhn.getNenkinkkn() == 10) &&
                            C_UmuKbn.NONE.eq(kKykSonotaTkyk.getStdrsktkyhkumu()) &&
                            C_UmuKbn.NONE.eq(kKykSonotaTkyk.getYennykntkhkumu()) &&
                            REPORTLAYOUTPTN_CAS_SISUU.equals(pkhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) &&
                            hnbnKknnFlgMap.get(joukenbunruiKey)==null) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hnbnKknnFlgMap.put(joukenbunruiKey, false);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017, joukenbunruiKey, pkhSyono));
                        }
                    }
                    if (JYOUKENBUNRUI3_003.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (pkhKykKihon.getAisyoumeikbn().eq(C_AisyoumeiKbn.GAIKAINDEXNK_TR_MDHN) &&
                            pkhKykKihon.getSbuktnin() == 1 &&
                            pkhKykSyouhn.getNksyukbn().eq(C_Nenkinsyu.KAKUTEINENKIN) &&
                            pkhKykSyouhn.getNenkinkkn() == 10 &&
                            kKykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI) &&
                            kKykSonotaTkyk.getYennykntkhkumu().eq(C_UmuKbn.ARI) &&
                            hnbnKknnFlgMap.get(joukenbunruiKey)==null) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hnbnKknnFlgMap.put(joukenbunruiKey, false);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017, joukenbunruiKey, pkhSyono));
                        }
                    }
                    if (JYOUKENBUNRUI3_004.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (pkhKykSyouhn.getKyktuukasyu().eq(C_Tuukasyu.USD) &&
                            kKykSonotaTkyk.getGaikanykntkhkumu().eq(C_UmuKbn.ARI) &&
                            hnbnKknnFlgMap.get(joukenbunruiKey)==null) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hnbnKknnFlgMap.put(joukenbunruiKey, false);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017, joukenbunruiKey, pkhSyono));
                        }
                    }
                }
            }

            if (JYOUKENBUNRUI1_090.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (JYOUKENBUNRUI2_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui2())) {
                    String pkhDsTourokuJyou = pkhGikKkykTutiTy.getZtydstourokujyou();

                    if (JYOUKENBUNRUI3_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (ds001Flg && DSTRKJYKY_NASHI.equals(pkhDsTourokuJyou)) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017,
                                JYOUKENBUNRUI1_090 + JYOUKENBUNRUI2_001 + JYOUKENBUNRUI3_001, pkhSyono));
                            ds001Flg = false;
                        }
                    }
                    if (JYOUKENBUNRUI3_002.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (ds002Flg && DSTRKJYKY_TRKARI_KIYK_ARI.equals(pkhDsTourokuJyou)) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017,
                                JYOUKENBUNRUI1_090 + JYOUKENBUNRUI2_001 + JYOUKENBUNRUI3_002, pkhSyono));
                            ds002Flg = false;
                        }
                    }
                    if (JYOUKENBUNRUI3_003.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (ds003Flg && DSTRKJYKY_TRKARI_KIYK_NASHI.equals(pkhDsTourokuJyou)) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017,
                                JYOUKENBUNRUI1_090 + JYOUKENBUNRUI2_001 + JYOUKENBUNRUI3_003, pkhSyono));
                            ds003Flg = false;
                        }
                    }
                    if (JYOUKENBUNRUI3_004.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (ds004Flg && DSTRKJYKY_MSKMARI_KIYK_ARI.equals(pkhDsTourokuJyou)) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017,
                                JYOUKENBUNRUI1_090 + JYOUKENBUNRUI2_001 + JYOUKENBUNRUI3_004, pkhSyono));
                            ds004Flg = false;
                        }
                    }
                    if (JYOUKENBUNRUI3_005.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        if (ds005Flg && DSTRKJYKY_MSKMARI_KIYK_NASHI.equals(pkhDsTourokuJyou)) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            logger.info(MessageUtil.getMessage(MessageId.IIF1017,
                                JYOUKENBUNRUI1_090 + JYOUKENBUNRUI2_001 + JYOUKENBUNRUI3_005, pkhSyono));
                            ds005Flg = false;
                        }
                    }
                }
            }
        }
        hanteiKekkaBean.setUpdateKbn(C_UmuKbn.NONE);

        if (tyohyouHonbanKakuninBeanList.size() > 0) {

            hanteiKekkaBean.setTyohyouHonbanKakuninBeanList(tyohyouHonbanKakuninBeanList);
            hanteiKekkaBean.setUpdateKbn(C_UmuKbn.ARI);
        }

        logger.debug("△ 帳票本番確認判定 終了");

        return hanteiKekkaBean;
    }

    private HashMap<Boolean,BizDate> checkSyrTishYmd(BizDate pkhKijyunYmd, C_Hrkkaisuu pkhHrkkaisuu, BizDate pkhHanteiYmd) {

        logger.debug("▽ 処理対象日付判定 開始");

        logger.debug("   基準日：" + pkhKijyunYmd + ",払込回数：" + pkhHrkkaisuu.getContent() + ",判定日：" + pkhHanteiYmd);

        HashMap<Boolean, BizDate> syrYmdHanteiKekka= new HashMap<>();

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        BizDate keiyakuOutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, pkhKijyunYmd, pkhHrkkaisuu, pkhHanteiYmd);

        BizDate preBusinessDay = pkhHanteiYmd.addBusinessDays(-1);

        logger.debug("   契約応当日：" + keiyakuOutoubi + ",前営業日：" + preBusinessDay);

        Boolean syrTisyuYmdHanteiKekka = true;

        if (keiyakuOutoubi.equals(pkhKijyunYmd)) {
            syrTisyuYmdHanteiKekka = false;
        }

        if (((BizDateUtil.compareYmd(keiyakuOutoubi, preBusinessDay) == BizDateUtil.COMPARE_EQUAL) ||
            ((BizDateUtil.compareYmd(keiyakuOutoubi, preBusinessDay) == BizDateUtil.COMPARE_LESSER))) ||
            (BizDateUtil.compareYmd(pkhHanteiYmd, keiyakuOutoubi) == BizDateUtil.COMPARE_LESSER)) {
            syrTisyuYmdHanteiKekka = false;
        }

        syrYmdHanteiKekka.put(syrTisyuYmdHanteiKekka,keiyakuOutoubi);

        logger.debug("   処理対象日付判定結果：" + syrTisyuYmdHanteiKekka + " " + keiyakuOutoubi);

        logger.debug("△ 処理対象日付判定 終了");

        return syrYmdHanteiKekka;
    }

    protected boolean check070001001(String pSyono, IT_KykSyouhn pKykSyouhn, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy, String pJoukenbunruiKey) {
        boolean kousinHantei = false;

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pKykSyouhn.getTmttknhaibunjyoutai()) &&
            pKykSyouhn.getTmttknitenymd() != null &&
            C_UmuKbn.ARI.toString().equals(pGikKkykTutiTy.getZtygengkumu()) &&
            hnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            hnbnKknnFlgMap.put(pJoukenbunruiKey, false);
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check070001002(String pSyono, IT_KykSyouhn pKykSyouhn, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy, String pJoukenbunruiKey) {
        boolean kousinHantei = false;

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pKykSyouhn.getTmttknhaibunjyoutai()) &&
            pKykSyouhn.getTmttknitenymd() != null &&
            C_UmuKbn.NONE.toString().equals(pGikKkykTutiTy.getZtygengkumu()) &&
            hnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            hnbnKknnFlgMap.put(pJoukenbunruiKey, false);
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    private void makeMissListData(int pkhDataNo, String pkhSyono, String pkhMsg) {

        missListSeqNo = missListSeqNo + 1;

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(pkhDataNo);
        editKhMisslstParam.setSeqNo(missListSeqNo);
        editKhMisslstParam.setSyoNo(pkhSyono);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
        editKhMisslstParam.setMisslistMsg(pkhMsg);

        missListTblPrmLst.add(editKhMisslstParam);
    }
}