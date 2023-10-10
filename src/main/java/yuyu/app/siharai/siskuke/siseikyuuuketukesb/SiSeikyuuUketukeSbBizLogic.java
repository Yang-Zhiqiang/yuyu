package yuyu.app.siharai.siskuke.siseikyuuuketukesb;

import static yuyu.app.siharai.siskuke.siseikyuuuketukesb.GenSiSeikyuuUketukeSbConstants.*;
import static yuyu.app.siharai.siskuke.siseikyuuuketukesb.SiSeikyuuUketukeSbConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.TtzkRrkListDataSourceBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzForceTaskStart;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessCreate;
import yuyu.common.biz.koutei.BzProcessCreateInBean;
import yuyu.common.biz.koutei.BzProcessCreateOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.siharai.chksk.CheckSbSkNaiyou;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.SiSKNaiyouChkWarningmsgSettei;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.edittbl.EditSkTbl;
import yuyu.common.siharai.edittbl.EditSkTblBean;
import yuyu.common.siharai.edittbl.SkTblSetBean;
import yuyu.common.siharai.koutei.SiProcessForward;
import yuyu.common.siharai.koutei.SiRuleBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.BetuskSyorityuChk;
import yuyu.common.siharai.sicommon.DouituSyonoStyChk;
import yuyu.common.siharai.sicommon.HanteiSaikenInfoNyuuryoku;
import yuyu.common.siharai.sicommon.HanteiSateiRank;
import yuyu.common.siharai.sicommon.HanteiSateiRankBean;
import yuyu.common.siharai.sicommon.HanteiSateiRankKekkaBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.Siinhantei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_NenkinInfo;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * （死亡）請求受付 のビジネスロジックです。
 */
public class SiSeikyuuUketukeSbBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSeikyuuUketukeSbUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    private static final C_Kouteikanristatus[] KOUTEIKANRISTATUS_SYORITYUU_KANRYOU = { C_Kouteikanristatus.SYORITYUU,
        C_Kouteikanristatus.KANRYOU };
    private static final C_Kouteikanristatus[] KOUTEIKANRISTATUS_SYORITYUU = { C_Kouteikanristatus.SYORITYUU };
    private static final C_Kouteikanristatus[] KOUTEIKANRISTATUS_KANRYOU = { C_Kouteikanristatus.KANRYOU };
    private static final String BLNK = "";

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    String pushKetteiBL() {

        uiBean.setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn.HUYOU);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);

        siKinouModeSettei.exec();

        if (C_SikinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode())) {
            throw new BizLogicException(MessageId.EBS0003);
        }

        uiBean.setKidougmKbn(C_KidougmKbn.INPUTKEY);


        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        if (keiyakuInfoSyutoku.getKykKihons().get(0) == null) {

            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        uiBean.setSiKykKihon(keiyakuInfoSyutoku.getKykKihons().get(0));

        List<JT_SiKykSyouhn> siKykSyouhnLst = uiBean.getSiKykKihon().getSiKykSyouhns();

        JT_SiKykSyouhn siKykSyouhn = getSiKykSyouhnSyuInfo(siKykSyouhnLst);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(siKykSyouhn.getSyouhncd(),
            siKykSyouhn.getSyouhnsdno());
        if (syouhnZokusei == null) {
            throw new BizAppException(MessageId.EBS0005, BM_SyouhnZokusei.TABLE_NAME, BM_SyouhnZokusei.SYOUHNCD,
                siKykSyouhn.getSyouhncd(), BM_SyouhnZokusei.SYOUHNSDNO, String.valueOf(siKykSyouhn.getSyouhnsdno()));
        }

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke(uiBean.getSyono());

        List<JT_SibouKariuketsuke> sibouKariuketsukeLst = Lists.newArrayList();

        for (JT_SkKihon skKihon : skKihonLst) {
            JT_SibouKariuketsuke sibouKariuketsuke = skKihon.getSibouKariuketsuke();

            if (sibouKariuketsuke != null) {
                sibouKariuketsukeLst.add(sibouKariuketsuke);
            }
        }

        if (sibouKariuketsukeLst.size() == 0) {

            throw new BizLogicException(MessageId.EJA1001);
        }

        uiBean.setSiboukaritrkymd(skKihonLst.get(0).getSiboukaritrkymd());
        uiBean.setSiboukariuketukejiGeninKbn(skKihonLst.get(0).getSibouKariuketsuke().getGeninkbn());

        if (C_SaisateiKbn.BLNK.eq(uiBean.getSaisateikbn())) {
            if (!douituSyonoStyChk(uiBean.getSyono(), KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)) {
                throw new BizLogicException(MessageId.EJA1033);
            }

        } else if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
            if (C_UmuKbn.NONE.eq(syouhnZokusei.getSgsbhsyumu())) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1101));
            }

            if (C_YuukousyoumetuKbn.YUUKOU.eq(uiBean.getSiKykKihon().getYuukousyoumetukbn())) {
                throw new BizLogicException(MessageId.EJA1034, MessageUtil.getMessage(MessageId.IJW1079));
            }

            if (douituSyonoStyChk(uiBean.getSyono(), KOUTEIKANRISTATUS_KANRYOU)) {
                throw new BizLogicException(MessageId.EJA1035);
            }
            if (!douituSyonoStyChk(uiBean.getSyono(), KOUTEIKANRISTATUS_SYORITYUU)) {
                throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1030));
            }
        }

        betuskSyorityuChk(uiBean.getSyono(), "");

        HanteiSaikenInfoNyuuryoku hanteiSaikenInfoNyuuryoku = SWAKInjector.getInstance(HanteiSaikenInfoNyuuryoku.class);
        uiBean.setViewSaikenInfoFlg(hanteiSaikenInfoNyuuryoku.exec(uiBean.getSiKykKihon()));

        String seikyuBangou = SaibanBiz.getSeikyuBangou();

        uiBean.setSkno(seikyuBangou);
        uiBean.setViewSkjyouhouInputDispFlg(true);
        uiBean.setViewSouhusakiInputDispFlg(true);
        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);
        if (C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_YENDATE);
        } else {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_DEFAULT);
        }
        if (C_SaisateiKbn.BLNK.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(true);
            uiBean.setPatterninputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_DEFAULT);
        } else if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(false);
            uiBean.setPatterninputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_NOFBSOUKIN);
        }

        newViewSindansyoinfoSibouInfo();

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushKakuninBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        List<String> byoumeitourokunolist = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {
                byoumeitourokunolist.add(dataSourceBean.getByoumeitourokuno());
            }
        }
        uiBean.setByoumeitourokunolist(byoumeitourokunolist);
        CheckSbSkNaiyou checkSbSkNaiyou = SWAKInjector.getInstance(CheckSbSkNaiyou.class);
        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(uiBean, kinou.getKinouId(),
            C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));

        if (C_SKNaiyouChkkekkaKbn.ERROR.eq(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn())) {
            throw new BizLogicException(checkSbSkNaiyouKekkaBean.getErrorMessageCollector());
        }

        if (C_SKNaiyouChkkekkaKbn.WARNING.eq(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn())) {

            SiSKNaiyouChkWarningmsgSettei siSKNaiyouChkWarningmsgSettei = SWAKInjector
                .getInstance(SiSKNaiyouChkWarningmsgSettei.class);

            siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_TWO,
                checkSbSkNaiyouKekkaBean.getWarningMessageList());
        }

        uiBean.setCheckSbSkNaiyouKekkaBean(checkSbSkNaiyouKekkaBean);

        C_GeninKbn siboukariuketukejiGeninKbn = C_GeninKbn.BLNK;

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);
            if (getSyoruittykymd.exec(uiBean.getKouteikanriid(), C_SyoruiCdKbn.HK_KD_JIKOJKS) != null) {
                siboukariuketukejiGeninKbn = C_GeninKbn.SG;
            }
            if (C_GeninKbn.BLNK.eq(siboukariuketukejiGeninKbn)) {
                if (getSyoruittykymd.exec(uiBean.getKouteikanriid(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS) != null) {
                    siboukariuketukejiGeninKbn = C_GeninKbn.JS;
                }
            }
        }
        if (C_GeninKbn.BLNK.eq(siboukariuketukejiGeninKbn)) {
            siboukariuketukejiGeninKbn = uiBean.getSiboukariuketukejiGeninKbn();
        }

        Siinhantei siinhantei = SWAKInjector.getInstance(Siinhantei.class);
        uiBean.setSiinkbn(siinhantei.hanteiSkuke(siboukariuketukejiGeninKbn, uiBean.getGeninkbn(),
            uiBean.getByoumeitourokunolist(), uiBean.getSateikaksaigaikanouseikbn(), uiBean.getSateikakhusyousikbn()));


        SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siSiharaiKingakuKeisanBean.setSyoNo(uiBean.getSyono());
        siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getSibouymd());
        siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(uiBean.getInputshrhousiteikbn());
        siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(uiBean.getSyoruiukeymd());
        siSiharaiKingakuKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siSiharaiKingakuKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(uiBean.getSuketorihouhoukbn());
        siSiharaiKingakuKeisanBean.setSiharaiTuukaKbn(uiBean.getSiharaituukakbn());
        siSiharaiKingakuKeisanBean.setSiKykKihon(uiBean.getSiKykKihon());
        siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(uiBean.getSihonninkakninkbn());
        siSiharaiKingakuKeisanBean.setKeisanKahiKbn(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn());
        siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
        siSiharaiKingakuKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.valueOf(kinouMode.getKinouMode()));
        siSiharaiKingakuKeisanBean.setSiinKbn(uiBean.getSiinkbn());
        siSiharaiKingakuKeisanBean.setSaisateiKbn(uiBean.getSaisateikbn());
        siSiharaiKingakuKeisanBean.setUktMnmeigiBangou(uiBean.getUktmnmeigibangou());
        siSiharaiKingakuKeisanBean.setKykMnmeigiBango(uiBean.getKykmnmeigibangou());
        siSiharaiKingakuKeisanBean.setBankCd(uiBean.getBankcd());
        siSiharaiKingakuKeisanBean.setSeikyuusyaKbn(uiBean.getSeikyuusyakbn());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType type = henkanTuuka.henkanTuukaKbnToType(uiBean.getSiKykKihon().getSiKykSyouhns().get(0).getKyktuukasyu());
        BizCurrency nkKknJyutouGk = BizCurrency.valueOf(0, type);
        siSiharaiKingakuKeisanBean.setNkKknJyutouGk(nkKknJyutouGk);

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

        uiBean.setErrorKbn(errorKbn);

        uiBean.setSiHkkingakuSisanParamBean(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean());
        uiBean.setSiSiDetailParamBean(siSiharaiKingakuKeisan.getSiSiDetailParamBean());

        uiBean.setSiNenkinInfoBean(siSiharaiKingakuKeisan.getSiNenkinInfoBean());

        if (C_ErrorKbn.OK.eq(errorKbn)
            && C_SKNaiyouChkkekkaKbn.WARNING.eq(siSiharaiKingakuKeisan.getCSKNaiyouChkkekkaKbn())) {
            SiSKNaiyouChkWarningmsgSettei siSKNaiyouChkWarningmsgSettei = SWAKInjector
                .getInstance(SiSKNaiyouChkWarningmsgSettei.class);
            siSKNaiyouChkWarningmsgSettei.exec(GROUP_WARNING_MESSAGE_TWO, siSiharaiKingakuKeisan.getWarnMsg());
        }

        String ukthonninKn = "";
        String ukthonninKj = "";
        BizDate ukthonninYmd = null;
        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())) {
            List<JT_SiUkt> siUktLst = uiBean.getSiKykKihon().getSiUkts();
            for (JT_SiUkt siUkt : siUktLst) {
                if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())) {
                    ukthonninKn = siUkt.getUktnmkn();
                    ukthonninKj = siUkt.getUktnmkj();
                    ukthonninYmd = siUkt.getUktseiymd();
                    break;
                }
            }
            uiBean.setSeikyuusyanmkn(ukthonninKn);
            uiBean.setSeikyuusyanmkj(ukthonninKj);
            uiBean.setSeikyuusyaseiymd(ukthonninYmd);
        }

        if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            uiBean.setSeikyuusyaseiymd(uiBean.getSiKykKihon().getKykdrseiymd());
            uiBean.setSeikyuusyanmkn(uiBean.getSiKykKihon().getKykdairinmkn());
            uiBean.setSeikyuusyanmkj(uiBean.getSiKykKihon().getKykdairinmkj());
        }

        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            if (C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
                uiBean.setTsinyno(uiBean.getSiKykKihon().getKykdryno());
                uiBean.setTsinadr1kj(uiBean.getSiKykKihon().getKykdradr1kj());
                uiBean.setTsinadr2kj(uiBean.getSiKykKihon().getKykdradr2kj());
                uiBean.setTsinadr3kj(uiBean.getSiKykKihon().getKykdradr3kj());
                uiBean.setTsintelno(uiBean.getSiKykKihon().getKykdrtelno());
            }
            else {
                SiSetUiBean.setSouhusakiKykAdr(uiBean, uiBean.getSiKykKihon());
            }
        }

        String bankNm = "";
        String sitenNm = "";

        if (!BizUtil.isBlank(uiBean.getBankcd()) && !BizUtil.isBlank(uiBean.getSitencd())) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(uiBean.getBankcd(), uiBean.getSitencd());

            bankNm = bzGetBankDataBean.getBankNmKj();
            sitenNm = bzGetBankDataBean.getSitenNmKj();
        }

        uiBean.setBanknmkj(bankNm);
        uiBean.setSitennmkj(sitenNm);

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())) {
                uiBean.setKzmeiginmkn(ukthonninKn);
            }
            else {
                uiBean.setKzmeiginmkn(uiBean.getSeikyuusyanmkn());
            }
        }

        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
            int yenkaKouzaKetasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();
            CheckKouzaNo checkKouzaNo = SWAKInjector.getInstance(CheckKouzaNo.class);
            if (checkKouzaNo.isCheckOK(uiBean.getKouzano(), C_Tuukasyu.JPY)
                && uiBean.getKouzano().length() < yenkaKouzaKetasuu) {
                uiBean.setKouzano(Strings.padStart(uiBean.getKouzano(), yenkaKouzaKetasuu, '0'));
            }
        }

        uiBean.setViewSkjyouhouInputDispFlg(false);
        uiBean.setViewSouhusakiInputDispFlg(false);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {
                dataSourceBeanLst.add(dataSourceBean);
            }
        }

        uiBean.setViewSindansyoinfoSibouInfo1(dataSourceBeanLst);

        messageManager.addMessageId(MessageId.QBA0001);

        return FORWARDNAME_CONFIRM;
    }

    String pushFunctionNameBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();

        if (uiBean.isKidougmKbnWorkListSeigyo()) {

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    String pushModoruByInputContentsBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();

        if (uiBean.isKidougmKbnWorkListSeigyo()) {

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    void pushTojiruBL() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    @Transactional
    String pushKakuteiBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTime = BizDate.getSysDateTimeMilli();

        if (!uiBean.isKidougmKbnWorkListSeigyo()) {
            if (C_SaisateiKbn.BLNK.eq(uiBean.getSaisateikbn())) {
                if (!douituSyonoStyChk(uiBean.getSyono(), KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)) {
                    throw new BizLogicException(MessageId.EJA1033);
                }

            } else if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
                if (!douituSyonoStyChk(uiBean.getSyono(), KOUTEIKANRISTATUS_SYORITYUU)) {
                    throw new BizLogicException(MessageId.EJA0087, MessageUtil.getMessage(MessageId.IJW1030));
                }
            }
        }


        Integer maxSeikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(uiBean.getSkno(),
            uiBean.getSyono());

        if (maxSeikyuurirekino != null) {
            maxSeikyuurirekino = maxSeikyuurirekino + 1;
        }
        else {
            maxSeikyuurirekino = 1;
        }
        List<JT_SiKykSyouhn> siKykSyouhnLst = uiBean.getSiKykKihon().getSiKykSyouhns();
        List<JT_SiUkt> siUktLst = uiBean.getSiKykKihon().getSiUkts();

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        for (JT_SiKykSyouhn siKykSyouhnEntry : siKykSyouhnLst) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhnEntry.getSyutkkbn())) {
                siKykSyouhn = siKykSyouhnEntry;
                break;
            }
        }

        C_UktKbn uktKbn = C_UktKbn.BLNK;
        for (JT_SiUkt siUkt : siUktLst) {
            if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu())) {
                uktKbn = siUkt.getUktkbn();
                break;
            }
        }

        C_UktKyksyaTdk uktKyksyaTdk = C_UktKyksyaTdk.BLNK;

        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())
            || C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            if (C_UktKbn.KYK.eq(uktKbn)) {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKHNN;
            }
            else {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
            }
        }
        else {
            if (C_SeikyuusyaKbn.UKTDAIHYOU.eq(uiBean.getSeikyuusyakbn()) ||
                C_SeikyuusyaKbn.SONOTA.eq(uiBean.getSeikyuusyakbn())) {
                uktKyksyaTdk = C_UktKyksyaTdk.KYKIGAI;
            }
        }


        BizDate kwsrateKjYmd = uiBean.getSibouymd();
        BizNumber zeimukwsrate = BizNumber.optional();
        C_KawasetekiyoKbn kawaseteKiyoKbn = C_KawasetekiyoKbn.BLNK;

        if (kwsrateKjYmd != null && !C_UktKyksyaTdk.BLNK.eq(uktKyksyaTdk)) {
            if (C_UktKyksyaTdk.KYKHNN.eq(uktKyksyaTdk)) {
                kawaseteKiyoKbn = C_KawasetekiyoKbn.TTM;
            }
            else if (C_UktKyksyaTdk.KYKIGAI.eq(uktKyksyaTdk)) {
                kawaseteKiyoKbn = C_KawasetekiyoKbn.TTB;
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                siKykSyouhn.getKyktuukasyu(), C_Tuukasyu.JPY, kawaseteKiyoKbn, C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI, C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
                zeimukwsrate = getKawaseRate.getKawaserate();
            }
        }


        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);

        hanteiSateiRankBean.setSyono(uiBean.getSyono());
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        if (C_ErrorKbn.OK.eq(uiBean.getErrorKbn())) {
            if (C_YouhiKbn.YOU.eq(uiBean.getCheckSbSkNaiyouKekkaBean().getSateiKaisouYouhiKbn())) {
                hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
            }
            else {
                hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
            }
        }
        else {
            hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        }
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(uiBean.getCheckSbSkNaiyouKekkaBean().getSkNaiyouChkkekkaKbn());
        hanteiSateiRankBean.setSaisateikbn(uiBean.getSaisateikbn());

        HanteiSateiRank hanteiSateiRank = SWAKInjector.getInstance(HanteiSateiRank.class);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);

        SkTblSetBean skTblSetBean = SWAKInjector.getInstance(SkTblSetBean.class);

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = uiBean.getSiHkkingakuSisanParamBean();

        skTblSetBean.setUktkyksyatdk(uktKyksyaTdk);
        skTblSetBean.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        skTblSetBean.setRikoukityuutuudannissuu(0);
        skTblSetBean.setTienrisokukisanymd(siHkkingakuSisanParamBean.getTienRisokuKisanYmd());
        skTblSetBean.setTienrsknissuu(siHkkingakuSisanParamBean.getTienRskNissuu());
        skTblSetBean.setKyktuukasyu(siKykSyouhn.getKyktuukasyu());
        skTblSetBean.setShrkwsratekjnymd(siHkkingakuSisanParamBean.getKnsnKijyunYmd());
        skTblSetBean.setShrkwsrate(siHkkingakuSisanParamBean.getKawaseRate());
        skTblSetBean.setKykhnkkaisuu(uiBean.getSiKykKihon().getKykhnkkaisuu());
        skTblSetBean.setShrkykhtykeihi(siHkkingakuSisanParamBean.getShrkykhtykeihi());
        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(uiBean.getSiharaituukakbn())) {
            skTblSetBean.setShrtuukasyu(C_Tuukasyu.JPY);
            skTblSetBean.setZeimukwsratekjnymd(siHkkingakuSisanParamBean.getKnsnKijyunYmd());
            skTblSetBean.setZeimukwsrate(siHkkingakuSisanParamBean.getKawaseRate());
        }
        else {
            skTblSetBean.setShrtuukasyu(siKykSyouhn.getKyktuukasyu());
            skTblSetBean.setZeimukwsratekjnymd(kwsrateKjYmd);
            skTblSetBean.setZeimukwsrate(zeimukwsrate);
        }

        if (C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(uiBean.getSuketorihouhoukbn())) {
            skTblSetBean.setGoukeihituyoukeihi(siHkkingakuSisanParamBean.getYenHtyKeihi());
        }
        else if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(uiBean.getSuketorihouhoukbn())) {
            skTblSetBean.setGoukeihituyoukeihi(BizCurrency.valueOf(0));
        }
        else {
            skTblSetBean.setGoukeihituyoukeihi(siHkkingakuSisanParamBean.getYenItjknhtyKeihi());
        }

        skTblSetBean.setShrgk(siHkkingakuSisanParamBean.getShrgkkei());
        skTblSetBean.setHokenkngkgoukei(siHkkingakuSisanParamBean.getHokenknGk());
        skTblSetBean.setShrtienrsk(siHkkingakuSisanParamBean.getTienRsk());
        skTblSetBean.setYenshrgk(siHkkingakuSisanParamBean.getYenkashrgkgoukei());
        skTblSetBean.setYenhkgkgoukei(siHkkingakuSisanParamBean.getYenHokenknGk());
        skTblSetBean.setYenshrtienrsk(siHkkingakuSisanParamBean.getYenTienRsk());
        skTblSetBean.setMisyuupjyuutouym(siHkkingakuSisanParamBean.getMisyuupjyuutouym());
        skTblSetBean.setMisyuupjyuutoukaisuuy(siHkkingakuSisanParamBean.getMisyuupjyuutoukaisuuy());
        skTblSetBean.setMisyuupjyuutoukaisuum(siHkkingakuSisanParamBean.getMisyuupjyuutoukaisuum());
        skTblSetBean.setGaikaknsnkwsratekjymd(siHkkingakuSisanParamBean.getKnsnKijyunYmd());
        skTblSetBean.setGaikaknsnkwsrate(siHkkingakuSisanParamBean.getGaikaknsnkwsrate());
        skTblSetBean.setHaitoukin(siHkkingakuSisanParamBean.getHaitoukin());
        skTblSetBean.setSonotahaitoukin(siHkkingakuSisanParamBean.getSonotahaitoukin());
        skTblSetBean.setMisyuup(siHkkingakuSisanParamBean.getMisyuup());
        skTblSetBean.setMikeikap(siHkkingakuSisanParamBean.getMikeikap());
        skTblSetBean.setZennouseisankgk(siHkkingakuSisanParamBean.getZennouseisank());
        skTblSetBean.setAzukarikingk(siHkkingakuSisanParamBean.getAzukarikingk());
        skTblSetBean.setSonotaseisangk(siHkkingakuSisanParamBean.getSonotaseisangk());
        skTblSetBean.setKrkgk(siHkkingakuSisanParamBean.getKrkgk());
        skTblSetBean.setYenkahaitoukin(siHkkingakuSisanParamBean.getYenkahaitoukin());
        skTblSetBean.setYenkasonotahaitoukin(siHkkingakuSisanParamBean.getYenkasonotahaitoukin());
        skTblSetBean.setYenkamisyuup(siHkkingakuSisanParamBean.getYenkamisyuup());
        skTblSetBean.setYenkamikeikap(siHkkingakuSisanParamBean.getYenkamikeikap());
        skTblSetBean.setYenkazennouseisankgk(siHkkingakuSisanParamBean.getYenkazennouseisank());
        skTblSetBean.setYenkaazukarikingk(siHkkingakuSisanParamBean.getYenkaazukarikingk());
        skTblSetBean.setYenkasonotaseisangk(siHkkingakuSisanParamBean.getYenkasonotaseisangk());
        skTblSetBean.setYenkakrkgk(siHkkingakuSisanParamBean.getYenkakrkgk());
        skTblSetBean.setZitkazukarikingksiteituuka(siHkkingakuSisanParamBean.getZitkazukarikingksiteituuka());
        skTblSetBean.setZitkazukarikingkyen(siHkkingakuSisanParamBean.getZitkazukarikingkyen());
        skTblSetBean.setGaikaknsntkgk(siHkkingakuSisanParamBean.getGaikaknsntskgk());
        skTblSetBean.setGaikaknsnkekkakgk(siHkkingakuSisanParamBean.getGaikaknsnkkkgk());
        skTblSetBean.setYenkaknsntkgk(siHkkingakuSisanParamBean.getYenkaknsntskgk());
        skTblSetBean.setYenkaknsnkekkakgk(siHkkingakuSisanParamBean.getYenkaknsnkkkgk());
        skTblSetBean.setMisyuusyonendojikaiikoup(siHkkingakuSisanParamBean.getMisyuusyonendojikaiikoup());
        skTblSetBean.setMisyuujinendoikoup(siHkkingakuSisanParamBean.getMisyuujinendoikoup());
        skTblSetBean.setMikeikapjyuutouym(siHkkingakuSisanParamBean.getMikeikapjyuutouym());
        skTblSetBean.setMikeikapjyuutoukaisuuy(siHkkingakuSisanParamBean.getMikeikapjyuutoukaisuuy());
        skTblSetBean.setMikeikapjyuutoukaisuum(siHkkingakuSisanParamBean.getMikeikapjyuutoukaisuum());
        skTblSetBean.setVhtnaiteikakuteikbn(siHkkingakuSisanParamBean.getVhtnaiteikakuteikbn());

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            uiBean.getSkkihon().setKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
            uiBean.getSkkihon().setKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
            uiBean.getSkkihon().setKykseiymd(uiBean.getSiKykKihon().getKykseiymd());
            uiBean.getSkkihon().setKyksei(uiBean.getSiKykKihon().getKyksei());
            uiBean.getSkkihon().setHhknnmkj(uiBean.getSiKykKihon().getHhknnmkj());
            uiBean.getSkkihon().setHhknnmkn(uiBean.getSiKykKihon().getHhknnmkn());
            uiBean.getSkkihon().setHhknseiymd(uiBean.getSiKykKihon().getHhknseiymd());
            uiBean.getSkkihon().setHhknsei(uiBean.getSiKykKihon().getHhknsei());
            uiBean.getSkkihon().setSateiyhkbn(hanteiSateiRankKekkaBean.getSateiYouhiKbn());
            uiBean.getSkkihon().setKossyoricd(kinou.getKinouId());
            uiBean.getSkkihon().setKossyorisscd(kinouMode.getKinouMode());
            uiBean.getSkkihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            uiBean.getSkkihon().setGyoumuKousinTime(sysDateTime);

            tableEdit(uiBean.getSkkihon(),maxSeikyuurirekino,sysDate,skTblSetBean);

            siharaiDomManager.update(uiBean.getSkkihon());
        }
        else {
            JT_SkKihon skKihon = new JT_SkKihon();
            skKihon.setSkno(uiBean.getSkno());
            skKihon.setSyono(uiBean.getSyono());
            skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
            skKihon.setSaisateikbn(uiBean.getSaisateikbn());
            skKihon.setSiboukaritrkymd(uiBean.getSiboukaritrkymd());
            skKihon.setKyknmkj(uiBean.getSiKykKihon().getKyknmkj());
            skKihon.setKyknmkn(uiBean.getSiKykKihon().getKyknmkn());
            skKihon.setKykseiymd(uiBean.getSiKykKihon().getKykseiymd());
            skKihon.setKyksei(uiBean.getSiKykKihon().getKyksei());
            skKihon.setHhknnmkj(uiBean.getSiKykKihon().getHhknnmkj());
            skKihon.setHhknnmkn(uiBean.getSiKykKihon().getHhknnmkn());
            skKihon.setHhknseiymd(uiBean.getSiKykKihon().getHhknseiymd());
            skKihon.setHhknsei(uiBean.getSiKykKihon().getHhknsei());
            skKihon.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
            skKihon.setSateiyhkbn(hanteiSateiRankKekkaBean.getSateiYouhiKbn());
            skKihon.setKossyoricd(kinou.getKinouId());
            skKihon.setKossyorisscd(kinouMode.getKinouMode());
            skKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            skKihon.setGyoumuKousinTime(sysDateTime);

            BizPropertyInitializer.initialize(skKihon);

            tableEdit(skKihon,maxSeikyuurirekino,sysDate,skTblSetBean);

            siharaiDomManager.insert(skKihon);
        }


        String kouteiKanriId = "";
        if (!uiBean.isKidougmKbnWorkListSeigyo()) {
            BzProcessCreateInBean bzProcessCreateInBean = SWAKInjector.getInstance(BzProcessCreateInBean.class);

            bzProcessCreateInBean.setSkNo(uiBean.getSkno());
            bzProcessCreateInBean.setSyoNo(uiBean.getSyono());
            bzProcessCreateInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

            if (!C_KouteiSakuseiKekkaKbn.SUCCESS.eq(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn())) {
                throw new BizLogicException(MessageId.EBS0008);
            }

            bzCommonLockProcess.lockProcess(bzProcessCreateOutBean.getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

            BzForceTaskStart bzForceTaskStart = SWAKInjector.getInstance(BzForceTaskStart.class);
            bzForceTaskStart.exec(bzProcessCreateOutBean.getKouteiKanriId(),
                TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, kinouMode.getKinouMode(), bzCommonLockProcess.getKouteiLockKey());

            kouteiKanriId = bzProcessCreateOutBean.getKouteiKanriId();
        } else {
            BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
            kouteiKanriId = bzWorkflowInfo.getKouteiKanriId();
        }


        SiRuleBean siRuleBean = SWAKInjector.getInstance(SiRuleBean.class);

        siRuleBean.setSateiYhKbn(hanteiSateiRankKekkaBean.getSateiYouhiKbn());

        SiProcessForward siProcessForward = SWAKInjector.getInstance(SiProcessForward.class);

        siProcessForward.exec(kouteiKanriId, TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, bzCommonLockProcess.getKouteiLockKey(),
            uiBean.getSyanaicomment(), siRuleBean, "");

        bzCommonLockProcess.unlockProcess();

        messageManager.addMessageId(MessageId.IAC0009);

        return FORWARDNAME_RESULT;
    }

    String pushModoruByConfirmBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();

        uiBean.setBanknmkj("");
        uiBean.setSitennmkj("");

        if (C_Kzdou.DOUITU.eq(uiBean.getKzdoukbn())) {
            uiBean.setKzmeiginmkn("");
        }
        if (C_SeikyuusyaKbn.UKTHONNIN.eq(uiBean.getSeikyuusyakbn())
            || C_SeikyuusyaKbn.KYKDAIRININ.eq(uiBean.getSeikyuusyakbn())) {
            uiBean.setSeikyuusyaseiymd(null);
            uiBean.setSeikyuusyanmkn("");
            uiBean.setSeikyuusyanmkj("");
        }
        if (C_SouhusakiKbn.TDADD.eq(uiBean.getSouhusakikbn())) {
            uiBean.setTsinyno("");
            uiBean.setTsinadr1kj("");
            uiBean.setTsinadr2kj("");
            uiBean.setTsinadr3kj("");
            uiBean.setTsintelno("");
        }

        uiBean.setViewSkjyouhouInputDispFlg(true);
        uiBean.setViewSouhusakiInputDispFlg(true);
        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);

        setViewSindansyoinfoSibouInfo();

        messageManager.removeConversationMessage(GROUP_WARNING_MESSAGE_TWO);

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushSyokigamenheBL () {

        if (uiBean.isKidougmKbnWorkListSeigyo()) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    @Transactional
    String pushFromSiharaiWorkListBL () {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn.HUYOU);

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo =  bizDomManager.getGyoumuKouteiInfo(bzWorkflowInfo.getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(bzWorkflowInfo.getKouteiKanriId(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU);

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn =  bzTaskStart.exec(bzWorkflowInfo.getKouteiKanriId(),
            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, kinouMode.getKinouMode(), bzCommonLockProcess.getKouteiLockKey());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }


        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        keiyakuPrm.setSyono(gyoumuKouteiInfo.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        uiBean.setSiKykKihon(siKykKihonLst.get(0));

        List<JT_SiKykSyouhn> siKykSyouhnLst = uiBean.getSiKykKihon().getSiKykSyouhns();

        JT_SiKykSyouhn siKykSyouhn = getSiKykSyouhnSyuInfo(siKykSyouhnLst);

        JT_SkKihon skKihon = getSkKihonInfo(gyoumuKouteiInfo.getSkno(),gyoumuKouteiInfo.getSyono());

        uiBean.setSkkihon(skKihon);

        Integer  seikyuurirekino = null;
        JT_Sk sk = new JT_Sk();
        List<JT_SkJiyuu> skJiyuuLst = Lists.newArrayList();
        List<JT_SkByoumei> skByoumeiLst = Lists.newArrayList();

        if (C_SikinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode())) {
            seikyuurirekino = siharaiDomManager.getSkMaxSeikyuurirekinoBySknoSyono(gyoumuKouteiInfo.getSkno(),
                gyoumuKouteiInfo.getSyono());
            if (seikyuurirekino == null || seikyuurirekino == 0) {
                throw new BizAppException(MessageId.EBS1003, JT_Sk.SEIKYUURIREKINO, "null");
            }

            sk = getSkInfo(seikyuurirekino,skKihon);

            skJiyuuLst = getSkJiyuuInfo(sk);

            skByoumeiLst = getSkByoumeiInfo(skJiyuuLst);
        }

        List<JT_SkKihon> skKihonLst = siharaiDomManager
            .getSkKihonsBySyonoSibouKariuketsuke(gyoumuKouteiInfo.getSyono());

        List<JT_SibouKariuketsuke> sibouKariuketsukeLst = Lists.newArrayList();

        for (JT_SkKihon wkSkKihon : skKihonLst) {
            JT_SibouKariuketsuke sibouKariuketsuke = wkSkKihon.getSibouKariuketsuke();

            if (sibouKariuketsuke != null) {
                sibouKariuketsukeLst.add(sibouKariuketsuke);
            }
        }

        if (sibouKariuketsukeLst.size() == 0) {
            throw new BizAppException(MessageId.EBS0004, JT_SibouKariuketsuke.TABLE_NAME, JT_SibouKariuketsuke.SYONO,
                uiBean.getSyono());
        }
        uiBean.setSiboukariuketukejiGeninKbn(skKihonLst.get(0).getSibouKariuketsuke().getGeninkbn());

        SetKouteiInfo setKouteiInfo  = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        BizDate syoruittykYmd = null;
        if (C_SikinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setKouteiKanriId(bzWorkflowInfo.getKouteiKanriId());

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            List<BzGetProcessSummaryOutBean>  bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.size() != 0) {
                syoruittykYmd = bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd();
            }
        }

        betuskSyorityuChk(gyoumuKouteiInfo.getSyono(), gyoumuKouteiInfo.getSkno());

        String bankNm = "";
        String sitenNm = "";

        if (!BizUtil.isBlank(sk.getBankcd()) && !BizUtil.isBlank(sk.getSitencd())) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(sk.getBankcd(), sk.getSitencd());

            bankNm = bzGetBankDataBean.getBankNmKj();
            sitenNm = bzGetBankDataBean.getSitenNmKj();
        }

        uiBean.setDispbanknmkj(bankNm);
        uiBean.setDispsitennmkj(sitenNm);

        uiBean.setSyono(gyoumuKouteiInfo.getSyono());
        uiBean.setSkno(gyoumuKouteiInfo.getSkno());
        uiBean.setKouteikanriid(gyoumuKouteiInfo.getKouteikanriid());
        uiBean.setSaisateikbn(skKihon.getSaisateikbn());

        if (C_SikinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {
            uiBean.setSyoruiukeymd(syoruittykYmd);
        }
        else {
            SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
            siSetUiBean.setSk(uiBean, sk);
            siSetUiBean.setSkJiyuu(uiBean, skJiyuuLst, skByoumeiLst);
        }
        uiBean.setKidougmKbn(C_KidougmKbn.WORKLIST);
        if (C_SikinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {
            newViewSindansyoinfoSibouInfo();
        }
        else {
            setViewSindansyoinfoSibouInfo();
        }

        uiBean.setViewSkjyouhouInputDispFlg(true);
        uiBean.setViewSouhusakiInputDispFlg(true);
        uiBean.setViewSoukinsakiInputDispFlg(true);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(true);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(true);
        if (C_SaisateiKbn.BLNK.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(true);
            uiBean.setPatterninputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_DEFAULT);
        } else if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(false);
            uiBean.setPatterninputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_NOFBSOUKIN);
        }
        if (C_Tuukasyu.JPY.eq(siKykSyouhn.getKyktuukasyu())) {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_YENDATE);
        } else {
            uiBean.setPatternsiharaituukakbn(C_SiharaiTuukaKbn.PATTERN_DEFAULT);
        }
        HanteiSaikenInfoNyuuryoku hanteiSaikenInfoNyuuryoku = SWAKInjector.getInstance(HanteiSaikenInfoNyuuryoku.class);
        uiBean.setViewSaikenInfoFlg(hanteiSaikenInfoNyuuryoku.exec(uiBean.getSiKykKihon()));
        if (C_SikinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) && !uiBean.isViewSaikenInfoFlg()) {
            uiBean.setSaikennmkj(BLNK);
            uiBean.setSaikennyno(BLNK);
            uiBean.setSaikenadr1kj(BLNK);
            uiBean.setSaikenadr2kj(BLNK);
            uiBean.setSaikenadr3kj(BLNK);
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    String pushFromSiSeikyuuUketukeSbBL () {

        BizPropertyInitializer.initialize(uiBean);

        List<TtzkRrkListDataSourceBean> dataSourceBeanLst = uiBean.getSiTtzkRirekiSyoukaiUiBean().getTtzkRrkListDataSource().getAllData();
        TtzkRrkListDataSourceBean ttzkRrkListDataSourceBean = SWAKInjector.getInstance(TtzkRrkListDataSourceBean.class);
        int sntkgyouno = uiBean.getSiTtzkRirekiSyoukaiUiBean().getSntkgyouno();

        for (int i = 0 ; i < dataSourceBeanLst.size(); i++ ) {
            if (i == sntkgyouno) {
                ttzkRrkListDataSourceBean = dataSourceBeanLst.get(sntkgyouno);
                break;
            }
        }

        JT_SkKihon skKihon= getSkKihonInfo(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());

        JT_Sk sk = getSkInfo(ttzkRrkListDataSourceBean.getSeiRrkNo(),skKihon);

        List<JT_SkJiyuu> skJiyuuLst = getSkJiyuuInfo(sk);

        List<JT_SkByoumei> skByoumeiLst = getSkByoumeiInfo(skJiyuuLst);


        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekByTtdkrrkskbtkey(ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey());

        uiBean.setSyono(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());
        uiBean.setSkno(uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno());

        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
        siSetUiBean.setSk(uiBean, sk);
        siSetUiBean.setSkJiyuu(uiBean, skJiyuuLst, skByoumeiLst);

        uiBean.setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn.YOU);

        uiBean.setSyanaicomment(ttdkRireki.getSyanaicomment());

        if (C_Kzdou.DOUITU.eq(sk.getKzdoukbn())) {
            uiBean.setKzmeiginmkn(sk.getKzmeiginmkn());
        }

        AS_Kinou kinouNm = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);
        uiBean.setKinouNm(kinouNm.getKinouNm());

        uiBean.setViewSkjyouhouInputDispFlg(false);
        uiBean.setViewSouhusakiInputDispFlg(false);
        uiBean.setViewSoukinsakiInputDispFlg(false);
        uiBean.setViewSindansyoinfoSibouInputDispFlg(false);
        uiBean.setViewShrdtlSakuseiKbnInputDispFlg(false);
        if (C_SaisateiKbn.BLNK.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(true);
        } else if (C_SaisateiKbn.SAISATEI.eq(uiBean.getSaisateikbn())) {
            uiBean.setViewShrdtlSakuseiKbnFlg(false);
        }
        uiBean.setPatterninputshrhousiteikbn(C_InputShrhousiteiKbn.PATTERN_DEFAULT);

        return FORWARDNAME_CONFIRM;
    }

    void pushUnlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }


    private void tableEdit (JT_SkKihon pSkKihon,Integer pSeikyuurirekino,BizDate pSysDate,SkTblSetBean pSkTblSetBean) {

        EditSkTblBean editSkTblBean = SWAKInjector.getInstance(EditSkTblBean.class);

        editSkTblBean.setSkNo(uiBean.getSkno());
        editSkTblBean.setSyoNo(uiBean.getSyono());
        editSkTblBean.setSeikyuuRirekiNo(pSeikyuurirekino);
        editSkTblBean.setUketukeNo(1);
        editSkTblBean.setSkTblSetBean(pSkTblSetBean);
        editSkTblBean.setSiSiDetailParamBeanLst(uiBean.getSiSiDetailParamBean());
        editSkTblBean.setSiNenkinInfoBean(uiBean.getSiNenkinInfoBean());

        EditSkTbl editSkTbl = SWAKInjector.getInstance(EditSkTbl.class);
        editSkTblBean =  editSkTbl.setEditKyhSkTbl(uiBean, editSkTblBean);

        JT_Sk sk = pSkKihon.createSk();
        BeanUtil.copyProperties(sk, editSkTblBean.getSk());
        BizPropertyInitializer.initialize(sk);

        for (JT_SkJiyuu skJiyuu : editSkTblBean.getSkJiyuuLst()) {
            JT_SkJiyuu newSkJiyuu = sk.createSkJiyuu();
            BeanUtil.copyProperties(newSkJiyuu, skJiyuu);
            BizPropertyInitializer.initialize(newSkJiyuu);

            if (editSkTblBean.getSkByoumeiLst() != null) {
                for (JT_SkByoumei skByoumei : editSkTblBean.getSkByoumeiLst()) {
                    JT_SkByoumei newSkByoumei = newSkJiyuu.createSkByoumei();
                    BeanUtil.copyProperties(newSkByoumei, skByoumei);
                    BizPropertyInitializer.initialize(newSkByoumei);
                }
            }

            if (editSkTblBean.getSiDetailLst() != null) {
                for (JT_SiDetail siDetail : editSkTblBean.getSiDetailLst()) {
                    JT_SiDetail newSiDetail = newSkJiyuu.createSiDetail();
                    BeanUtil.copyProperties(newSiDetail, siDetail);
                    BizPropertyInitializer.initialize(newSiDetail);
                }
            }
        }

        if (editSkTblBean.getNenkinInfo() != null) {
            JT_NenkinInfo nenkinInfo = sk.createNenkinInfo();
            BeanUtil.copyProperties(nenkinInfo, editSkTblBean.getNenkinInfo());
            BizPropertyInitializer.initialize(nenkinInfo);
        }

        EditRrkTblBean editRrkTblBean = SWAKInjector.getInstance(EditRrkTblBean.class);
        editRrkTblBean.setSeiNo(uiBean.getSkno());
        editRrkTblBean.setSyoNo(uiBean.getSyono());
        editRrkTblBean.setSyoriYmd(pSysDate);
        if (C_SikinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode())) {
            editRrkTblBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.MIKAKUTEI);
        }
        else {
            editRrkTblBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);
        }

        EditRrk editRrk = SWAKInjector.getInstance(EditRrk.class);
        editRrkTblBean = editRrk.makeTtdkRrk(uiBean, editRrkTblBean);

        JT_TtdkRireki ttdkRireki = pSkKihon.createTtdkRireki();

        BeanUtil.copyProperties(ttdkRireki, editRrkTblBean.getTtdkRireki());

        ttdkRireki.setSeikyuurirekino(pSeikyuurirekino);
        BizPropertyInitializer.initialize(ttdkRireki);
    }

    private JT_SkKihon getSkKihonInfo(String pSkno,String pSyono) {
        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        if (skKihon == null) {
            throw new BizAppException(MessageId.EBS0005, JT_SkKihon.TABLE_NAME, JT_SkKihon.SKNO, pSkno,
                JT_SkKihon.SYONO, pSyono);
        }
        return skKihon;
    }

    private JT_Sk getSkInfo(Integer pSeikyuurirekino,JT_SkKihon pSkKihon) {

        JT_Sk sk =  pSkKihon.getSkBySeikyuurirekino(pSeikyuurirekino);

        if (sk == null) {
            throw new BizAppException(MessageId.EBS0006, JT_Sk.TABLE_NAME, JT_Sk.SKNO, pSkKihon.getSkno(), JT_Sk.SYONO,
                pSkKihon.getSyono(), JT_Sk.SEIKYUURIREKINO, String.valueOf(pSeikyuurirekino));
        }
        return sk;
    }

    private List<JT_SkJiyuu> getSkJiyuuInfo(JT_Sk pSk){

        List<JT_SkJiyuu> skJiyuuLst = pSk.getSkJiyuus();

        if (skJiyuuLst.size() == 0) {
            throw new BizAppException(MessageId.EBS0006, JT_SkJiyuu.TABLE_NAME, JT_SkJiyuu.SKNO, pSk.getSkno(),
                JT_SkJiyuu.SYONO, pSk.getSyono(), JT_SkJiyuu.SEIKYUURIREKINO, String.valueOf(pSk.getSeikyuurirekino()));
        }
        return skJiyuuLst;
    }

    private void betuskSyorityuChk(String pSyono, String pSkno) {

        BetuskSyorityuChk betuskSyorityuChk = SWAKInjector.getInstance(BetuskSyorityuChk.class);

        boolean betuskSyorityuChkFlg = betuskSyorityuChk.exec(pSyono, pSkno);

        if (!betuskSyorityuChkFlg) {
            messageManager.addConversationMessageId(GROUP_WARNING_MESSAGE_ONE, MessageId.WJA0052,
                betuskSyorityuChk.getWmJimutetuzukinm(),betuskSyorityuChk.getWmNodenm());
        }
    }

    private boolean douituSyonoStyChk(String pSyono, C_Kouteikanristatus[] kouteikanristatus) {
        DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
        return douituSyonoStyChk.exec(pSyono, TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, kouteikanristatus);
    }

    private void setViewSindansyoinfoSibouInfo() {
        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = uiBean.getViewSindansyoinfoSibouInfo1DataSource().getAllData();
        int dataSourceBeanSize = dataSourceBeanLst.size();

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> viewSindansyoinfoSibouInfo = Lists.newArrayList();
        ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean = null;

        String sakujyoLink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SAKUJYOLINK.getErrorResourceKey());

        String searchlink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SEARCHLINK.getErrorResourceKey());

        for (ViewSindansyoinfoSibouInfo1DataSourceBean bean : dataSourceBeanLst) {
            dataSourceBean = SWAKInjector.getInstance(ViewSindansyoinfoSibouInfo1DataSourceBean.class);
            BeanUtil.copyProperties(dataSourceBean, bean);
            dataSourceBean.setSearchlink(searchlink);
            dataSourceBean.setSakujyoLink(sakujyoLink);
            dataSourceBean.setSakujyoflg(C_Delflag.BLNK);

            viewSindansyoinfoSibouInfo.add(dataSourceBean);
        }
        for (int i = dataSourceBeanSize; i<  MAX_ROW_COUNT ; i++) {
            dataSourceBean = SWAKInjector.getInstance(ViewSindansyoinfoSibouInfo1DataSourceBean.class);
            dataSourceBean.setSearchlink(searchlink);
            dataSourceBean.setSakujyoLink(sakujyoLink);
            dataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);

            viewSindansyoinfoSibouInfo.add(dataSourceBean);
        }
        uiBean.setViewSindansyoinfoSibouInfo1(viewSindansyoinfoSibouInfo);
    }

    private List<JT_SkByoumei> getSkByoumeiInfo(List<JT_SkJiyuu> pSkJiyuuLst) {
        List<JT_SkByoumei> skByoumeiLst = Lists.newArrayList();

        for (JT_SkJiyuu skJiyuu : pSkJiyuuLst) {
            List<JT_SkByoumei> skByoumeiInfo = skJiyuu.getSkByoumeis();

            if (skByoumeiInfo.size() != 0) {
                for (JT_SkByoumei skByoumei : skByoumeiInfo) {
                    skByoumeiLst.add(skByoumei);
                    if (skByoumeiLst.size() == MAX_ROW_COUNT) {
                        break;
                    }
                }
            }

            if (skByoumeiLst.size() == MAX_ROW_COUNT) {
                break;
            }
        }
        return skByoumeiLst;
    }

    private void newViewSindansyoinfoSibouInfo() {

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanLst = Lists.newArrayList();
        ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean = null;

        String sakujyoLink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SAKUJYOLINK.getErrorResourceKey());

        String searchlink = MessageUtil.getMessage(DDID_VIEWSINDANSYOINFOSIBOUINFO1_SEARCHLINK.getErrorResourceKey());

        for (int i = 0; i < MAX_ROW_COUNT; i++) {
            dataSourceBean = SWAKInjector.getInstance(ViewSindansyoinfoSibouInfo1DataSourceBean.class);

            dataSourceBean.setSearchlink(searchlink);
            dataSourceBean.setSakujyoLink(sakujyoLink);

            if (i == 0) {
                dataSourceBean.setSakujyoflg(C_Delflag.BLNK);
            }
            else {
                dataSourceBean.setSakujyoflg(C_Delflag.SAKUJYO);
            }
            dataSourceBeanLst.add(dataSourceBean);
        }

        uiBean.setViewSindansyoinfoSibouInfo1(dataSourceBeanLst);
    }

    private JT_SiKykSyouhn getSiKykSyouhnSyuInfo(List<JT_SiKykSyouhn> pSiKykSyouhnLst){

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        for (JT_SiKykSyouhn siKykSyouhnEntry : pSiKykSyouhnLst) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhnEntry.getSyutkkbn())) {
                siKykSyouhn = siKykSyouhnEntry;
                break;
            }
        }

        return siKykSyouhn;
    }
}
