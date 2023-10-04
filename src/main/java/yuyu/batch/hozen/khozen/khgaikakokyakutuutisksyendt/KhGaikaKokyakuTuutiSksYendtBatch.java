package yuyu.batch.hozen.khozen.khgaikakokyakutuutisksyendt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
import yuyu.batch.hozen.khozen.khgaikakokyakutuutisksyendt.dba.KhGaikaKokyakuTuutiSksYendtDao;
import yuyu.batch.hozen.khozen.khgaikakokyakutuutisksyendt.dba.KhHenkouUktkBean;
import yuyu.batch.hozen.khozen.tyohyouhonbankakunin.dba.TyohyouHonbanKakuninBatchDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.CheckProcessKaishi;
import yuyu.common.hozen.khcommon.CheckTyohyouHnbnKknKokyakuTuutiSks;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase;
import yuyu.common.hozen.khcommon.EditSeikyuusyoParam;
import yuyu.common.hozen.khcommon.HanteiKekkaKokyakuTuutiSksBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TyohyouHonbanKakuninBean;
import yuyu.common.hozen.koutei.KhHituyousyoruiHanteiInBean;
import yuyu.common.hozen.prereport.HozenPreReportRenkeiBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 外貨建顧客通知作成（円建変更後）
 */
public class KhGaikaKokyakuTuutiSksYendtBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykKihon";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final String HASSOUKBN_HONSYAKAISOU = "2";

    private static final String GAIKAKOKYAKUTUUTI_SYORICD = "RBTD";

    private static final String TUUTISYURUICD_SIMO4KETA = "0001";

    private String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

    private int dataNo = 0;

    private List<EditKhMisslstParam> missListTblPrmLst = new ArrayList<>();

    private int missListSeqNo = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhGaikaKokyakuTuutiSksYendtBatchParam khGaikaKokyakuTuutiSksYendtBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhGaikaKokyakuTuutiSksYendtDao khGaikaKokyakuTuutiSksYendtDao;

    @Inject
    private TyohyouHonbanKakuninBatchDao tyohyouHonbanKakuninBatchDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Override
    public BatchParam getParam() {
        return khGaikaKokyakuTuutiSksYendtBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khGaikaKokyakuTuutiSksYendtBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = khGaikaKokyakuTuutiSksYendtBatchParam.getIbKakutyoujobcd();

        List<TyohyouHonbanKakuninBean> khTyouhyouHonbanHknList =
            tyohyouHonbanKakuninBatchDao.getKhTyouhyouHonbanKakuninMikakuninInfos(
                C_TyouhyouBunruiKbn.KOKYAKUTUUTI, syoriYmd);

        int syoriKensuu = 0;
        int khtyouhyouHonbanCount = 0;
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        CheckTyohyouHnbnKknKokyakuTuutiSks checkTyohyouHnbnKknKokyakuTuutiSks = SWAKInjector.getInstance(
            CheckTyohyouHnbnKknKokyakuTuutiSks.class);
        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);
        HashMap<String, Integer> hnbnKknnCntMap= new HashMap<>();
        List<TyohyouHonbanKakuninBean> khTyouhyouHonbanUbdList = new ArrayList<>();
        try (ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> exDBResults = khGaikaKokyakuTuutiSksYendtDao.
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

                int syohinHanteiKbn = SyouhinUtil.henkouKubetuHantei(kykSyouhn.getSyouhncd());

                String syouhinHanmeiKbn = "";

                if (syohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO) {
                    syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA;
                }
                else if (syohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO) {
                    syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_NENKIN_ENKA;
                }
                else if (syohinHanteiKbn == SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUGO) {
                    syouhinHanmeiKbn = EditKykNaiyouOsirase.SYOUHNHANMEIKBN_SYUUSIN_ENKA_19;
                }
                else{
                    continue;
                }

                if ((BizDateUtil.compareYmd(kykSyouhn.getYendthnkymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER)){
                    continue;
                }

                HashMap<Boolean, BizDate> syrYmdHanteiKekka = checkSyrTishYm(kykSyouhn.getYendthnkymd(), syoriYmd);

                if (syrYmdHanteiKekka.containsKey(true)) {

                    dataNo = dataNo + 1;
                }
                else{
                    continue;
                }

                List<JT_SkKihon> skKihonList =
                    siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
                        kykKihon.getSyono(), C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

                JT_SkKihonDetacher.detachSibouKariuketsuketouched(skKihonList);

                if (skKihonList.size() != 0) {
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "変更受付中", "変更後"));

                    continue;
                }

                C_UktkSyoriKbn uktkSyoriKbn = C_UktkSyoriKbn.BLNK;
                C_UmuKbn uktkFlag = C_UmuKbn.NONE;

                List<KhHenkouUktkBean> khHenkouUktkBeanLst =
                    khGaikaKokyakuTuutiSksYendtDao.getKhHenkouUktkBySyono(kykKihon.getSyono());

                for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

                    uktkSyoriKbn = khHenkouUktkBean.getUktkSyoriKbn();
                    if (C_UktkSyoriKbn.KAIYAKU.eq(uktkSyoriKbn)) {
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

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
                    bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

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

                ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = editKykNaiyouOsirase.editInfo(
                    kykKihon.getSyono(),
                    syoriYmd,
                    syrYmdHanteiKekka.get(true),
                    syouhinHanmeiKbn,
                    khGaikaKokyakuTuutiSksYendtBatchParam.getCampaignUmuKbn(),
                    null,
                    EditKykNaiyouOsirase.YOBIDASIMOTOKBN_BATCH);

                if(C_ErrorKbn.ERROR.eq(editKykNaiyouOsirase.getCommonErrorKbn())){
                    makeMissListData(dataNo, kykKihon.getSyono(),
                        MessageUtil.getMessage(MessageId.EIF1122, "金額計算エラー", "エラー解消後"));
                    continue;
                }

                if(C_UmuKbn.ARI.getValue().equals(gaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn())){
                    gaikaKokyakuTuutiTy = setYendtHnkhrSks(gaikaKokyakuTuutiTy);
                }

                HanteiKekkaKokyakuTuutiSksBean hanteiKekkaBean = checkTyohyouHnbnKknKokyakuTuutiSks.hanteiByCount(
                    khTyouhyouHonbanHknList, hnbnKknnCntMap, kykKihon, kykSyouhn, gaikaKokyakuTuutiTy);

                if (C_UmuKbn.ARI.eq(hanteiKekkaBean.getUpdateKbn())) {
                    gaikaKokyakuTuutiTy.setZtyhassoukbn(HASSOUKBN_HONSYAKAISOU);
                }

                if (hanteiKekkaBean.getTyohyouHonbanKakuninBeanList() != null &&
                    hanteiKekkaBean.getTyohyouHonbanKakuninBeanList().size() > 0) {
                    khTyouhyouHonbanUbdList.addAll(hanteiKekkaBean.getTyohyouHonbanKakuninBeanList());
                }

                hnbnKknnCntMap = hanteiKekkaBean.getTyouhyouHnbnKknnCntMap();

                BizPropertyInitializer.initialize(gaikaKokyakuTuutiTy);

                entityInserter.add(gaikaKokyakuTuutiTy);


                String saiban =
                    RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));

                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();

                tuutirirekiMeisaiHokan.setTuutirirekirenno(saiban);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + kykKihon.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutirirekiMeisaiHokan.setTuutisakuseino(0);
                tuutirirekiMeisaiHokan.setTuutisyuruicd(GAIKAKOKYAKUTUUTI_SYORICD + TUUTISYURUICD_SIMO4KETA);
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);

                entityInserterTuuti.add(tuutirirekiMeisaiHokan);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

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

    private HashMap<Boolean,BizDate> checkSyrTishYm(BizDate pKhKijyunYmd, BizDate pKhHanteiYmd) {

        HashMap<Boolean, BizDate> syrYmdHanteiKekka= new HashMap<>();

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        Boolean syrTisyuYmdHanteiKekka = false;

        BizDate keiyakuOutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, pKhKijyunYmd, C_Hrkkaisuu.NEN, pKhHanteiYmd);

        BizDate preBusinessDay = pKhHanteiYmd.addBusinessDays(-1);

        if (BizDateUtil.compareYmd(keiyakuOutoubi, pKhKijyunYmd) != BizDateUtil.COMPARE_EQUAL &&
            BizDateUtil.compareYmd(keiyakuOutoubi, preBusinessDay) == BizDateUtil.COMPARE_GREATER &&
            (BizDateUtil.compareYmd(keiyakuOutoubi, pKhHanteiYmd) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYmd(keiyakuOutoubi, pKhHanteiYmd) == BizDateUtil.COMPARE_LESSER)) {
            syrTisyuYmdHanteiKekka = true;
        }

        syrYmdHanteiKekka.put(syrTisyuYmdHanteiKekka,keiyakuOutoubi);

        return syrYmdHanteiKekka;
    }

    private void makeMissListData(int pKhDataNo, String pKhSyono, String pKhMsg) {

        missListSeqNo = missListSeqNo + 1;

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(pKhDataNo);
        editKhMisslstParam.setSeqNo(missListSeqNo);
        editKhMisslstParam.setSyoNo(pKhSyono);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
        editKhMisslstParam.setMisslistMsg(pKhMsg);

        missListTblPrmLst.add(editKhMisslstParam);
    }

    private ZT_GaikaKokyakuTuutiTy setYendtHnkhrSks(ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTy) {

        String syoNo = pGaikaKokyakuTuutiTy.getZtysyono();

        CheckProcessKaishi checkProcessKaishi = SWAKInjector.getInstance(CheckProcessKaishi.class);
        C_UmuKbn kouteiUmuKbn = checkProcessKaishi.exec(syoNo,IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);

        if (C_UmuKbn.ARI.eq(kouteiUmuKbn)) {

            KhHituyousyoruiHanteiInBean khHituyousyoruiHanteiInBean = SWAKInjector.getInstance(KhHituyousyoruiHanteiInBean.class);
            khHituyousyoruiHanteiInBean.setJimutetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR);
            khHituyousyoruiHanteiInBean.setHrkkeirohnkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setHrkkaisuuhnkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setDaisennintdkUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setTrhkjikakUmuKbn(C_UmuKbn.NONE);
            khHituyousyoruiHanteiInBean.setHubidataUmu(C_Hubidataumu.NONE);

            HozenPreReportRenkeiBean hozenPreReportRenkeiBean = SWAKInjector.getInstance(HozenPreReportRenkeiBean.class);
            hozenPreReportRenkeiBean.setSyoNo(syoNo);
            hozenPreReportRenkeiBean.setSyoriComment("");
            hozenPreReportRenkeiBean.setTaskNm(null);
            hozenPreReportRenkeiBean.setSakuseizumiKouteikanriId(checkProcessKaishi.getBzGetProcessSummaryOutBean().getKouteiKanriId());
            hozenPreReportRenkeiBean.setKhHituyousyoruiHanteiInBean(khHituyousyoruiHanteiInBean);

            EditSeikyuusyoParam editSeikyuusyoParam = SWAKInjector.getInstance(EditSeikyuusyoParam.class);
            editSeikyuusyoParam.setShrumu(C_UmuKbn.NONE);
            editSeikyuusyoParam.setKhhrshrjiyuu(C_Khhrshrjiyuu.TUUJYOU);
            editSeikyuusyoParam.setKhskssakuseijiyuu(C_Khskssakuseijiyuu.BLNK);

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
            khozenTyouhyouCtl.setEditSeikyuusyoParam(editSeikyuusyoParam);
            khozenTyouhyouCtl.setQrCodeYouhiKbn(C_YouhiKbn.YOU);

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoNo,
                new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS}, C_YouhiKbn.HUYOU);
            pGaikaKokyakuTuutiTy.setZtydocumentid(khozenTyouhyouCtl.getQrCode());
        }

        AM_SyoruiZokusei syoruiZokusei = baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);
        pGaikaKokyakuTuutiTy.setZtyskshozonnensuu(syoruiZokusei.getHozonKikan().toString());

        pGaikaKokyakuTuutiTy.setZtytoritugisyasyozokunm(C_TantousituKbn.getContentByValue(
            C_TantousituKbn.PATTERN_DEFAULT, C_TantousituKbn.DAIRITENJIMUSV.getValue()));

        return pGaikaKokyakuTuutiTy;
    }
}