package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KktatkichkkekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TsnchkptnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.infr.auth.RayBCPBean;
import yuyu.infr.auth.RayCreator;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.YuyuFunctionTestUtil;

import com.google.common.collect.Lists;

/**
 * 申込内容チェックドライバ <br /> *
 * ① 申込内容チェック呼び出し時の処理コントロールテーブルツリーをケース分用意する。<br />
 * ② ドライバを実行すると、ＤＢを読み込み、データ数分ＭＰを生成して申込内容チェックを実行する。<br />
 * ③ 申込内容チェック実行後の処理コントロールテーブルツリーをコミット。
 *
 */
@RunWith(OrderedRunner.class)
public class MosnaiCheckTest {

    @Inject
    private static Logger logger;

    private static final String USER_ID = "56560401";

    private static final String SOSIKI_ID = "5650000";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseManager;

    @Inject
    private MosnaiCheckParam chkPrm;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private AS_Category category;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private RayBCPBean bcpBean;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    private List<String> kouteikanriIdLst = Lists.newArrayList();

    private List<String> pageIdLst = Lists.newArrayList();

    private static final boolean AUTOMAKEDATAFLG = true;

    @Test
    @Transactional
    public void exec() {

        logger.debug("▽ 申込内容チェックドライバ 処理開始");

        prepareTest();

        BizDate sysDate = BizDate.getSysDate();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        String userId = baseUserInfo.getUserId();
        MosnaiCheck mosnaiCheck;

        List<HT_SyoriCTL> syoriCtls = sinkeiyakuDomManager.getAllSyoriCTL();
        if(syoriCtls == null || syoriCtls.size() == 0) {
            throw new CommonBizAppException("処理コントロールTBLが取得できません。");
        }

        for (HT_SyoriCTL syoriCtl : syoriCtls) {

            if (C_UmuKbn.ARI.eq(syoriCtl.getMosnrkumu()) &&
                (C_SeirituKbn.NONE.eq(syoriCtl.getSeiritukbn()) ||
                    C_SeirituKbn.ITIPMATI.eq(syoriCtl.getSeiritukbn()))) {

                if (AUTOMAKEDATAFLG) {
                    makeKouteiInfoData(syoriCtl.getMosno(), syoriCtl.getSyono());
                }


                BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean =
                    getProcessSummary(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                        new C_Kouteikanristatus[] { C_Kouteikanristatus.SYORITYUU }, "", syoriCtl.getMosno());

                BT_GyoumuKouteiInfo gyoumuKouteiInfo =
                    bizDomManager.getGyoumuKouteiInfo(bzGetProcessSummaryOutBean.getKouteiKanriId());
                if (gyoumuKouteiInfo == null) {
                    throw new CommonBizAppException("業務用工程情報TBLが取得できません。");
                }

                initMp(chkPrm);

                chkPrm.setCategoryID(category.getCategoryId());
                chkPrm.setKinouID(kinou.getKinouId());
                chkPrm.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
                chkPrm.setSysDate(sysDate);
                chkPrm.setKosID(userId);
                chkPrm.setKosTime(sysDateTimeMilli);
                chkPrm.setDataSyoriControl(syoriCtl);
                chkPrm.setGyoumuKouteiInfo(gyoumuKouteiInfo);

                chkPrm.debug("<<<<申込内容チェック実行前>>>>");

                mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);
                mosnaiCheck.exec(chkPrm);
            }
        }

        sinkeiyakuDomManager.update(syoriCtls);

        if (AUTOMAKEDATAFLG) {
            deleteTestData();
        }

        logger.debug("△ 申込内容チェックドライバ 処理終了");
    }

    private void prepareTest() {

        AM_User am_user = baseManager.getUser(USER_ID);
        YuyuFunctionTestUtil.changeCurrentUser(baseUserInfo, am_user);
        baseUserInfo.refresh();

        bcpBean.setBcp(true);
        bcpBean.setDaikouSosikiCd(SOSIKI_ID);
        RayCreator.create();
    }

    private BzGetProcessSummaryOutBean getProcessSummary(String pJimuTetuzukiCd,
        C_Kouteikanristatus[] pKouteikanriStatuss,
        String pKouteiKanriId,
        String pMosNo) {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(pKouteikanriStatuss);
        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setMosNo(pMosNo);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);

        return bzGetProcessSummaryOutBean;
    }

    private void initMp(MosnaiCheckParam pMp) {

        pMp.setCategoryID("");
        pMp.setKinouID("");
        pMp.setKetteiYouhiKbn(C_KetteiyouhiKbn.HUYOU);
        pMp.setSateiKanryouKbn(C_SateikanKbn.BLNK);
        pMp.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        pMp.setKykKbn_HnkMae(C_KykKbn.BLNK);
        pMp.setHhknTeisei(C_UmuKbn.NONE);
        pMp.setKykTeisei(C_UmuKbn.NONE);
        pMp.setKetteiSijiKbn(C_HandketsijiKbn.HUYOU);
        pMp.setKykKakuninSyurui(C_Kykkaksyrui.BLNK);
        pMp.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMp.setSysKbn(C_SysKbn.SKEI);
        pMp.setSysDate(null);
        pMp.setEshienRiyoumotoSysKbn(null);
        pMp.setKosID("");
        pMp.setKosTime("");
        pMp.setKetteiSijisyoYouhiKbn(C_KetsijisyoyhKbn.HUYOU);
        pMp.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.HUYOU);
        pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        pMp.setChkKekkaKbn(C_ChkkekkaKbn.SEIJYOU);
        pMp.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.NONE);
        pMp.setKokutiChkHuyoUmu(C_UmuKbn.NONE);
        pMp.setSakuinTsnKbn(C_SakuintsnKbn.SEIJYOU);
        pMp.setListKetteiSijiMsgId(new ArrayList<String>());
        pMp.setListKetteiSijiMsg(new ArrayList<String>());
        pMp.setListKykKakuninMsg(new ArrayList<String>());
        pMp.setListKekkaGmnMsg(new ArrayList<String>());
        pMp.setDataSyoriControl(null);
        pMp.setSetAiteMosNo("");
        pMp.setSetAiteSyuSyouhnCd("");
        pMp.setTratkiAgCd("");
        pMp.setTsnCheckPtnKbn(C_TsnchkptnKbn.HUYOU);
        pMp.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.BLNK);
        pMp.setTksyTratkiKjn(null);
        pMp.setKaiyakuDoujiSekUmu(C_UmuKbn.NONE);
        pMp.setFreeinsuranceUmu(C_UmuKbn.NONE);
        pMp.setCreditCardInfoTblChkErrUmu(C_UmuKbn.NONE);
        pMp.setSaiteiPChkErrUmu(C_UmuKbn.NONE);
        pMp.setMosUketukeKbn(C_MosUketukeKbn.BLNK);
        pMp.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        pMp.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        pMp.setUktTratkityuiUmuKbnMr(C_UmuKbn.NONE);
        pMp.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        pMp.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        pMp.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
        pMp.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setUktTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setUktInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
        pMp.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
        pMp.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
        pMp.setUktSinsntkhnsyumukbn(C_UmuKbn.NONE);
        pMp.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);
        pMp.setUktNayosehumeiuUmuKbn(C_UmuKbn.NONE);
        pMp.setListKkiykDoujiMosSyonoPal(new ArrayList<String>());
        pMp.setListSkDoujiMosMosnoPal(new ArrayList<String>());
        pMp.setFstnyknTyakkinYmd(null);
        pMp.setNyuukinKawaseRate(null);
        pMp.setGyoumuKouteiInfo(null);
        pMp.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        pMp.setMosnoKanri(null);
        pMp.setNyuuryokuKawaseRate(null);
        pMp.setNensyuTuusanSOverHanteiKekka(false);
        pMp.setTsnketsibous(BizCurrency.valueOf(0));
        pMp.setSekmossakuseiKbn(C_SekmossakuseiKbn.NONE);
        pMp.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);
        pMp.setSekmossakuseiErrmsg1("");
        pMp.setSekmossakuseiErrmsg2("");
        pMp.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.DIRTNBSYNN);

    }

    private void makeKouteiInfoData(String pMosNo, String pSyono) {

        String[] jimuTetuzukiCds = {"skmaindairiten", "skinputmos", "skinputkokuti",
            "sktenken", "skkankyou", "skimu", "skhubitouroku"};

        String[] nodeNms = {"state-mousikomitenken", "state-kouteikanryou", "state-kouteikaisi",
            "mostenken_1ji", "state-kouteikanryou",  "state-kouteikanryou", "state-kouteikanryou"};

        String[] torikomiSyoruiCds = {"sk001", "sk011", "sk005", "sk002", "sk012"};

        String sysDateTime = IwfDateUtils.getSysDate();
        String sysDate = IwfDateUtils.getYYYYMMDD();

        String kouteikanriid_skmaindairiten = "";


        List<BT_GyoumuKouteiInfo> kouteiInfoList = Lists.newArrayList();
        List<WT_KouteiSummary> kouteiSummaryList = Lists.newArrayList();

        for (int i = 0; i < jimuTetuzukiCds.length; i++) {

            String kouteiKanriId = uniqueKeyGenerator.generateUniqueKey();

            kouteikanriIdLst.add(kouteiKanriId);

            if ("skmaindairiten".equals(jimuTetuzukiCds[i])) {
                kouteikanriid_skmaindairiten = kouteiKanriId;
            }

            BT_GyoumuKouteiInfo kouteiInfo = new BT_GyoumuKouteiInfo();
            kouteiInfo.setKouteikanriid(kouteiKanriId);
            kouteiInfo.setSubSystemId("sinkeiyaku");
            kouteiInfo.setJimutetuzukicd(jimuTetuzukiCds[i]);
            kouteiInfo.setMosno(pMosNo);
            kouteiInfo.setSyono(pSyono);
            kouteiInfo.setSkno("");
            kouteiInfo.setNksysyno("");
            kouteiInfo.setSyukouteikanriid(kouteikanriid_skmaindairiten);
            kouteiInfo.setSyukouteijimutetuzukicd("skmaindairiten");
            kouteiInfo.setGyoumuKousinKinou("kouteikaisitouroku");
            kouteiInfo.setGyoumuKousinsyaId("56510501");
            kouteiInfo.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(kouteiInfo);

            if ("skmaindairiten".equals(jimuTetuzukiCds[i])) {

                for (String torikomiSyoruiCd : torikomiSyoruiCds) {
                    BT_HituyouSyoruiKanri hituyouSyoruiKanri = kouteiInfo.createHituyouSyoruiKanri();

                    hituyouSyoruiKanri.setKouteikanriid(kouteiKanriId);
                    hituyouSyoruiKanri.setSyoruiCd(C_SyoruiCdKbn.valueOf(torikomiSyoruiCd));

                    BizPropertyInitializer.initialize(hituyouSyoruiKanri);
                }
            }

            kouteiInfoList.add(kouteiInfo);

            WT_KouteiSummary wtKouteisummary = new WT_KouteiSummary();

            wtKouteisummary.setGyoumuKey(kouteiKanriId);
            wtKouteisummary.setFlowId(jimuTetuzukiCds[i]);
            wtKouteisummary.setLastSyoriTime(sysDateTime);
            wtKouteisummary.setSyokaiAccountId("56510501");
            wtKouteisummary.setZenkaiAccountId("56510501");
            wtKouteisummary.setZenkaiNodeNm(nodeNms[i]);
            wtKouteisummary.setZenkaiTaskLocalNm("");
            wtKouteisummary.setNodeNm(nodeNms[i]);
            wtKouteisummary.setGenzaiAccountId("");
            wtKouteisummary.setGenzaiTaskLocalNm("");
            wtKouteisummary.setIwfKouteiKaisiYmd(sysDate);
            wtKouteisummary.setKouteiKanryouYmd("");
            wtKouteisummary.setSyoriStatus("10");
            wtKouteisummary.setKousinTime(sysDateTime);
            wtKouteisummary.setExtParam1("02");
            wtKouteisummary.setExtParam2("1");
            wtKouteisummary.setExtParam3("444");
            wtKouteisummary.setExtParam4("5100001");
            wtKouteisummary.setExtParam5("");
            wtKouteisummary.setExtParam6("");
            wtKouteisummary.setExtParam7("");
            wtKouteisummary.setExtParam8("1");
            wtKouteisummary.setExtParam9("0");
            wtKouteisummary.setExtParam10(sysDate);
            wtKouteisummary.setExtParam11(sysDateTime);
            wtKouteisummary.setExtParam12(pSyono);
            wtKouteisummary.setExtParam13("");
            wtKouteisummary.setExtParam14(pMosNo);
            wtKouteisummary.setExtParam15("0");
            wtKouteisummary.setExtParam16("0");
            wtKouteisummary.setExtParam17("0");
            wtKouteisummary.setExtParam18("");
            wtKouteisummary.setExtParam19("");
            wtKouteisummary.setExtParam20("");
            wtKouteisummary.setExtParam21("");
            wtKouteisummary.setExtParam22("");
            wtKouteisummary.setExtParam23("");
            wtKouteisummary.setExtParam24("");
            wtKouteisummary.setExtParam25("");
            wtKouteisummary.setExtParam26("");
            wtKouteisummary.setExtParam27("");
            wtKouteisummary.setExtParam28("");
            wtKouteisummary.setExtParam29("");
            wtKouteisummary.setExtParam30("");

            BizPropertyInitializer.initialize(wtKouteisummary);

            kouteiSummaryList.add(wtKouteisummary);
        }

        WT_GyoumuKey gyoumuKey = new WT_GyoumuKey();

        gyoumuKey.setFlowId("skmaindairiten");
        gyoumuKey.setGyoumuKey(kouteikanriid_skmaindairiten);
        gyoumuKey.setTokenId("1");
        gyoumuKey.setCreateTime(sysDateTime);

        BizPropertyInitializer.initialize(gyoumuKey);

        bizDomManager.insert(kouteiInfoList);
        iwfCoreDomManager.insert(kouteiSummaryList);
        iwfCoreDomManager.insert(gyoumuKey);



        List<WT_TorikomiRelation> torikomiRelationLst = Lists.newArrayList();
        List<WT_TorikomiKanri> torikomiKanriLst = Lists.newArrayList();
        List<WT_Page> pageLst = Lists.newArrayList();

        for (String torikomiSyoruiCd : torikomiSyoruiCds) {

            String iwfImageId = uniqueKeyGenerator.generateUniqueKey();

            pageIdLst.add(iwfImageId);

            WT_TorikomiRelation torikomiRelation = new WT_TorikomiRelation();

            torikomiRelation.setIwfImageId(iwfImageId);
            torikomiRelation.setGyoumuKey(kouteikanriid_skmaindairiten);

            BizPropertyInitializer.initialize(gyoumuKey);

            WT_TorikomiKanri torikomiKanri = new WT_TorikomiKanri();

            torikomiKanri.setIwfImageId(iwfImageId);
            torikomiKanri.setTorikomiSyoruiCd(torikomiSyoruiCd);
            torikomiKanri.setTourokuTime(sysDateTime);
            torikomiKanri.setKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(torikomiKanri);

            WT_Page itPage = new WT_Page();

            itPage.setIwfImageId(iwfImageId);
            itPage.setSyoruittykymdtime(sysDateTime);
            itPage.setPageno(1);
            itPage.setKousinTime(sysDateTime);
            itPage.setPageId(uniqueKeyGenerator.generateUniqueKey());

            BizPropertyInitializer.initialize(torikomiKanri);

            torikomiRelation.setTorikomiKanri(torikomiKanri);

            List<WT_TorikomiRelation> torikomiRelationList = new ArrayList<WT_TorikomiRelation>();
            torikomiRelationList.add(torikomiRelation);
            torikomiKanri.setTorikomiRelation(torikomiRelationList);

            torikomiRelation.setKouteiSummary(iwfCoreDomManager.getKouteiSummary(kouteikanriid_skmaindairiten));

            torikomiRelationLst.add(torikomiRelation);
            torikomiKanriLst.add(torikomiKanri);
            pageLst.add(itPage);
        }

        iwfCoreDomManager.insert(torikomiRelationLst);
        iwfCoreDomManager.insert(torikomiKanriLst);
        iwfCoreDomManager.insert(pageLst);
    }

    public void deleteTestData() {

        // TODO コメントアウト
        //        for (String kouteikanriId : kouteikanriIdLst) {
        //            bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo(kouteikanriId));
        //            iwfCoreDomManager.delete(iwfCoreDomManager.getKouteiSummary(kouteikanriId));
        //            iwfCoreDomManager.delete(iwfCoreDomManager.getGyoumuKeys(kouteikanriId));
        //            iwfCoreDomManager.delete(iwfCoreDomManager.getTorikomiRelations(kouteikanriId));
        //        }
        //
        //        for (String pageId : pageIdLst) {
        //            iwfCoreDomManager.delete(iwfCoreDomManager.getTorikomiKanri(pageId));
        //            iwfCoreDomManager.delete(iwfCoreDomManager.getPages(pageId));
        //        }
    }
}
