package yuyu.app.siharai.simouside.simousideuketuke;

import static yuyu.app.siharai.simouside.simousideuketuke.GenSiMousideUketukeConstants.*;
import static yuyu.app.siharai.simouside.simousideuketuke.SiMousideUketukeConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.TtzkRrkListDataSourceBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuOutBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGet;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetParam;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoResultBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.chksk.ChkSubEndtHenkouYmd;
import yuyu.common.siharai.chksk.ChkSubHnrkinMbr;
import yuyu.common.siharai.chksk.ChkSubJisatuMenseki;
import yuyu.common.siharai.chksk.ChkSubKhSyorityuu;
import yuyu.common.siharai.chksk.ChkSubKykYmd;
import yuyu.common.siharai.chksk.ChkSubPHrkmYuuyokkn;
import yuyu.common.siharai.chksk.ChkSubSasiosae;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.ChkSubStknset;
import yuyu.common.siharai.edittbl.EditRrk;
import yuyu.common.siharai.edittbl.EditRrkTblBean;
import yuyu.common.siharai.koutei.SiHituyousyoruiHanteiInBean;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.prereport.SiharaiPreReportRenkeiBean;
import yuyu.common.siharai.sicommon.BetuskSyorityuChk;
import yuyu.common.siharai.sicommon.DouituSyonoStyChk;
import yuyu.common.siharai.sicommon.KykCommonHantei;
import yuyu.common.siharai.sicommon.SiKinouModeSettei;
import yuyu.common.siharai.sicommon.SiMessageGroupConstants;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisan;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanBean;
import yuyu.common.siharai.sicommon.Siinhantei;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditDaihyousennintodoke;
import yuyu.common.siharai.siedittyouhyou.EditDaihyousennintodokeBean;
import yuyu.common.siharai.siedittyouhyou.EditJijotdkkenseiyakusyo;
import yuyu.common.siharai.siedittyouhyou.EditJijotdkkenseiyakusyoBean;
import yuyu.common.siharai.siedittyouhyou.EditJikojyokyouhoukokusyo;
import yuyu.common.siharai.siedittyouhyou.EditJikojyokyouhoukokusyoBean;
import yuyu.common.siharai.siedittyouhyou.EditMynumberC;
import yuyu.common.siharai.siedittyouhyou.EditMynumberCBean;
import yuyu.common.siharai.siedittyouhyou.EditSeikyuusyo;
import yuyu.common.siharai.siedittyouhyou.EditSeikyuusyoBean;
import yuyu.common.siharai.siedittyouhyou.EditSeisankinhurikomiiraisyo;
import yuyu.common.siharai.siedittyouhyou.EditSeisankinhurikomiiraisyoBean;
import yuyu.common.siharai.siedittyouhyou.EditSouhuannai;
import yuyu.common.siharai.siedittyouhyou.EditSouhuannaiBean;
import yuyu.common.siharai.siedittyouhyou.EditTeisyutusyorui;
import yuyu.common.siharai.siedittyouhyou.EditTeisyutusyoruiBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.common.siharai.siedittyouhyou.ToiawaseInfoBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SensinKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SindansyoSksMaisuuKbn;
import yuyu.def.classification.C_SindansyoSksSiteiKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TiryousakiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * 申出受付 のビジネスロジックです。
 */
public class SiMousideUketukeBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    Map<String, SiHituyousyoruiHanteiInBean> siHituyousyoruiHanteiInBeanMp = new HashMap<>();
    Map<String, C_UmuKbn> sbumnskUmuMp = new HashMap<>();
    @Inject
    private SiMousideUketukeUiBean uiBean;
    @Inject
    private SiharaiDomManager siharaiDomManager;
    @Inject
    private BaseDomManager baseDomManager;
    @Inject
    private BizDomManager bizDomManager;
    @Inject
    private AS_Kinou kinou;
    @Inject
    private KinouMode kinouMode;
    @Inject
    private MessageManager messageManager;
    @Inject
    private ErrorMessageCollector errMessages;
    @Inject
    private BaseUserInfo baseUserInfo;
    @Inject
    private EditRrk editRrk;
    @Inject
    private CreateReport createReport;
    @Inject
    private OutputReport outputReport;
    @Inject
    private DBAOutputReport dbaOutputReport;
    @Inject
    private SiharaiPreReportRenkeiBean siharaiPreReportRenkeiBean;

    void init() {

        BizPropertyInitializer.initialize(uiBean);
        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();
    }

    void clear() {
    }

    void pushTtdkAnnaiSkiBL() {
        uiBean.setPatternMousideninKbn(C_MousideninKbn.PATTERN_TTD);
        uiBean.setGamensyorikbn(SYO_TTDKANNAISKI);
        chkInputKey();
    }

    void pushHknkMosUkeBL() {
        uiBean.setPatternMousideninKbn(C_MousideninKbn.PATTERN_HKKYH);
        uiBean.setPatternGeninKbn(C_GeninKbn.PATTERN_SIBOU_MSD);
        uiBean.setGamensyorikbn(SYO_HKNKMOSUKE);
        uiBean.setYouhiKbn(C_YouhiKbn.HUYOU);
        chkInputKey();
    }

    void pushKakuninBL() {

        String gmSyoriKbn = uiBean.getGamensyorikbn();
        BizDate syoriYmd = BizDate.getSysDate();

        initParam_Message();

        List<JT_SiKykKihon> taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

        if(taiSiKykKihonLst.isEmpty()) {
            throw new CommonBizAppException("対象契約リストの取得に失敗しました。");
        }

        JT_SiKykKihon kykKihon = taiSiKykKihonLst.get(0);

        chkRequired();

        chkRelation();

        if(gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {
            chkRelation_HknkMosuke(syoriYmd, kykKihon);

            chkRelation_Kyh();
        }

        setUiBean();

        setOutaiInfoMaxRenNo();

    }

    void pushmodoruBtnByConfirmBL() {

        initParamGotoInputContents();
    }

    @Transactional
    void pushKakuteiBL() {

        List<MousideReportEditBean> mousideReportEditBeanLst = insTable();

        siharaiPreReportRenkeiBean.setBzWorkflowInfo(uiBean.getBzWorkflowInfo());
        siharaiPreReportRenkeiBean.setSkNo(uiBean.getSkno());
        siharaiPreReportRenkeiBean.setSyoriComment(uiBean.getSyanaicomment());
        siharaiPreReportRenkeiBean.setTaskNm(kinou.getKinouNm());

        String tyouhyouKey = "";
        ArrayList<ReportServicesBean> tyohyoBeanLst = Lists.newArrayList();
        ReportServicesBean[] beans = null;

        for (int iI = 0; iI < mousideReportEditBeanLst.size(); iI++){
            MousideReportEditBean mousideReportEditBean = null;
            mousideReportEditBean = mousideReportEditBeanLst.get(iI);
            for(int iJ = 0; iJ < mousideReportEditBean.getReportServicesBeanLst().size(); iJ++){

                tyohyoBeanLst.add(mousideReportEditBean.getReportServicesBeanLst().get(iJ));
            }
        }

        beans = tyohyoBeanLst.toArray(new ReportServicesBean[tyohyoBeanLst.size()]);

        tyouhyouKey =  createReport.execNoCommit(beans);

        uiBean.setReportKey(tyouhyouKey);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printReport() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByTyouhyouJoinKey(uiBean.getReportKey());

        PdfBuilder pdfBuilder = new PdfBuilder();
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.BLNK;

        try {
            for (int i = 0; i < tyouhyouKensakuLst.size(); i++){

                kykTuukasyu = uiBean.getKykTuukaHntiMap().get(tyouhyouKensakuLst.get(i).getKensakuKey1());

                if (C_SyoruiCdKbn.HK_SB_HOKEN_SKS.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL_KOTEIPDF,tyouhyouKensakuLst.get(i).getReportKey(),YuyuSiharaiConfig.getInstance().getPdfpathSamplesisksyendt());

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_KOTEIPDF,null,YuyuSiharaiConfig.getInstance().getPdfpathSamplesibouzeimuyendt());

                    } else {
                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL_KOTEIPDF,tyouhyouKensakuLst.get(i).getReportKey(),YuyuSiharaiConfig.getInstance().getPdfpathSamplesisks());

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_KOTEIPDF,null,YuyuSiharaiConfig.getInstance().getPdfpathSamplesibouzeimu());
                    }

                } else if (C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL_KOTEIPDF,tyouhyouKensakuLst.get(i).getReportKey(),YuyuSiharaiConfig.getInstance().getPdfpathSampleseisansksyendt());

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_KOTEIPDF,null,YuyuSiharaiConfig.getInstance().getPdfpathSamplesibouzeimuyendt());

                    } else {

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL_KOTEIPDF,tyouhyouKensakuLst.get(i).getReportKey(),YuyuSiharaiConfig.getInstance().getPdfpathSampleseisansks());

                        pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_KOTEIPDF,null,YuyuSiharaiConfig.getInstance().getPdfpathSamplesibouzeimu());
                    }

                }else if (C_SyoruiCdKbn.HK_SB_DAIHYOU.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL,tyouhyouKensakuLst.get(i).getReportKey(),null);

                }else if (C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL,tyouhyouKensakuLst.get(i).getReportKey(),null);

                }else if (C_SyoruiCdKbn.HK_KD_JIKOJKS.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL_KOTEIPDF,tyouhyouKensakuLst.get(i).getReportKey(),YuyuSiharaiConfig.getInstance().getPdfpathSamplejikojyokyou());

                }else if (C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.eq(tyouhyouKensakuLst.get(i).getSyoruiCd())){

                    String mnTyouhyouPtn = uiBean.getSyoNoMnTyouhyouPtnMap().get(tyouhyouKensakuLst.get(i).getKensakuKey1());
                    String myNumberTkyrPdfPath = "";
                    if (TeisuuSiharai.MNTYOUHYOUPTN_SOUZOKUZEI.equals(mnTyouhyouPtn)){
                        myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrSouzoku();

                    } else if (TeisuuSiharai.MNTYOUHYOUPTN_SYOTOKUZEI.equals(mnTyouhyouPtn)){

                        myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrSyotoku();

                    }else if (TeisuuSiharai.MNTYOUHYOUPTN_ZOUYOZEI.equals(mnTyouhyouPtn)){

                        myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrZouyo();

                    }else if (TeisuuSiharai.MNTYOUHYOUPTN_UKETORININHUKUSUU.equals(mnTyouhyouPtn)){

                        myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrHukusuu();

                    }else if (TeisuuSiharai.MNTYOUHYOUPTN_MENSEKI.equals(mnTyouhyouPtn)){

                        myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrMenseki();
                    }
                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_KOTEIPDF,null,myNumberTkyrPdfPath);

                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL,tyouhyouKensakuLst.get(i).getReportKey(),null);

                }else {

                    pdfBuilder = pdfJoin(pdfBuilder,PDFSOURCE_TBL,tyouhyouKensakuLst.get(i).getReportKey(),null);

                }

            }

            byte[] joinedReport = pdfBuilder.toByteArray();
            outputReport.outputJoinedPDFByBinary(joinedReport,uiBean.getReportKey());

        } catch (Exception e){

            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));

        }

    }

    String fromSiTtzkRirekiSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(
            uiBean.getSiTtzkRirekiSyoukaiUiBean().getSkno(),
            uiBean.getSiTtzkRirekiSyoukaiUiBean().getSyono());

        JT_Mouside mouside = skKihon.getMouside();

        JM_Byoumei byoumei = siharaiDomManager.getByoumei(mouside.getByoumeitourokuno());

        List<TtzkRrkListDataSourceBean> dataSourceBeanLst = uiBean.getSiTtzkRirekiSyoukaiUiBean().getTtzkRrkListDataSource().getAllData();
        TtzkRrkListDataSourceBean ttzkRrkListDataSourceBean = SWAKInjector.getInstance(TtzkRrkListDataSourceBean.class);
        int sntkgyouno = uiBean.getSiTtzkRirekiSyoukaiUiBean().getSntkgyouno();
        for (int i = 0 ; i < dataSourceBeanLst.size(); i++ ) {
            if (i == sntkgyouno) {
                ttzkRrkListDataSourceBean = dataSourceBeanLst.get(sntkgyouno);
                break;
            }
        }

        JT_TtdkRireki ttdkRireki = skKihon.getTtdkRirekByTtdkrrkskbtkey(ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey());

        uiBean.setSyono(mouside.getSyono());
        uiBean.setMousideninkbn(mouside.getMousideninkbn());
        uiBean.setMousideninnmkj(mouside.getMousideninnmkj());
        uiBean.setUketorininsibouumukbn(mouside.getUketorininsibouumukbn());
        uiBean.setKyksyasibouumukbn(mouside.getKyksyasibouumukbn());
        uiBean.setSouhusakikbn(mouside.getSouhusakikbn());
        uiBean.setTsinyno(mouside.getTsinyno());
        uiBean.setTsinadr1kj(mouside.getTsinadr1kj());
        uiBean.setTsinadr2kj(mouside.getTsinadr2kj());
        uiBean.setTsinadr3kj(mouside.getTsinadr3kj());
        uiBean.setTsintelno(mouside.getTsintelno());
        uiBean.setSeikyuusyubetu(mouside.getSeikyuusyubetu());
        uiBean.setGeninkbn(mouside.getGeninkbn());
        uiBean.setSibouymd(mouside.getSibouymd());
        if (byoumei != null) {
            uiBean.setByoumeikj(byoumei.getByoumeikj());
        } else {
            uiBean.setByoumeikj("");
        }

        uiBean.setSyanaicomment(ttdkRireki.getSyanaicomment());

        uiBean.setGamensyorikbn(SYO_HKNKMOSUKE);

        uiBean.setYouhiKbn(C_YouhiKbn.YOU);

        AS_Kinou kinous = baseDomManager.getKinou(TeisuuSiharai.SITTZKRIREKISYOUKAI);

        String sKinouNm = kinous.getKinouNm();

        uiBean.setKinouNm(sKinouNm);

        return FORWARDNAME_CONFIRM;
    }


    private void chkInputKey() {

        List<JT_SiKykKihon>      kykKihonLst;
        List<JT_SiKykKihon>      taiSiKykKihonLst  = Lists.newArrayList();

        JT_SiKykKihon            kykKihon_Main;
        String                   syoNo_Main;
        JT_SiKykSyouhn           kykSyouhin_Main_Syu  = new JT_SiKykSyouhn();
        JT_SiKykKihon            kykKihon_Betu;
        JT_SiKykSyouhn           kykSyouhin_Betu_Syu = new JT_SiKykSyouhn();
        String                   syoNo_Betu = "";
        BM_SyouhnZokusei         syouhnZokusei_Betu;
        String                   syouhinNm_Syu;
        C_YuukousyoumetuKbn      yuukouKbn;
        C_Syoumetujiyuu          syometuJiyu;
        BizDate                  syometuYmd;

        List<BetukeiyakuListDataSourceBean> betukeiyakuListDataSourceBeanLst = Lists.newArrayList();
        List<BetukykInfoDataSourceBean> betukeiyakuInfoDataSourceBeanLst = Lists.newArrayList();

        syoNo_Main = uiBean.getSyono();
        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(syoNo_Main);
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.YOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);
        kykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if(kykKihonLst.isEmpty() || kykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
        }

        for(int iI=0; iI < kykKihonLst.size(); iI++) {

            if(iI == CNT_KYKKIHON_MAIN) {
                kykKihon_Main = kykKihonLst.get(iI);

                setUiBean_Main(kykKihon_Main);

                taiSiKykKihonLst.add(kykKihon_Main);

                kykSyouhin_Main_Syu = getSiKykSyouhnSyukyk(kykKihon_Main);

            }
            else {
                kykKihon_Betu       = kykKihonLst.get(iI);
                kykSyouhin_Betu_Syu    = getSiKykSyouhnSyukyk(kykKihon_Betu);

                syoNo_Betu = kykKihon_Betu.getSyono();

                syouhnZokusei_Betu = bizDomManager.getSyouhnZokusei(
                    kykSyouhin_Betu_Syu.getSyouhncd(),
                    kykSyouhin_Betu_Syu.getSyouhnsdno());

                if (syouhnZokusei_Betu == null) {
                    throw new CommonBizAppException("商品属性マスタの取得に失敗しました。");
                }

                syouhinNm_Syu = syouhnZokusei_Betu.getSyouhnnm();

                yuukouKbn = kykKihon_Betu.getYuukousyoumetukbn();

                if (C_YuukousyoumetuKbn.YUUKOU.eq(yuukouKbn)){

                    syometuJiyu = C_Syoumetujiyuu.BLNK;

                    syometuYmd = null;

                }
                else {

                    syometuJiyu = kykKihon_Betu.getSyoumetujiyuu();

                    syometuYmd = kykKihon_Betu.getSyoumetuymd();
                }

                String uktnmkj = "";
                if (kykKihon_Betu.getSbuktnin() == 0) {

                    uktnmkj = "";
                }

                else if (kykKihon_Betu.getSbuktnin() == 1) {

                    for (int i = 0; i < kykKihon_Betu.getSiUkts().size(); i++) {

                        if (C_Hkuktsyu.SBHKKUKT.eq(kykKihon_Betu.getSiUkts().get(i).getHkuktsyu())) {

                            uktnmkj = kykKihon_Betu.getSiUkts().get(i).getUktnmkj();
                        }
                    }
                }

                else if (kykKihon_Betu.getSbuktnin() > 1) {

                    uktnmkj = MessageUtil.getMessage(MessageId.IJW1049);
                }

                BetukeiyakuListDataSourceBean betukeiyakuListDataSourceBean = SWAKInjector.getInstance(BetukeiyakuListDataSourceBean.class);

                betukeiyakuListDataSourceBean.setDispsyono(syoNo_Betu);
                betukeiyakuListDataSourceBean.setSyscdkbn(C_SysCdKbn.RAY);
                betukeiyakuListDataSourceBean.setUktnmkj(uktnmkj);
                betukeiyakuListDataSourceBean.setDispsyoumetujiyuu(syometuJiyu);
                betukeiyakuListDataSourceBean.setDispsyoumetuymd(syometuYmd);
                betukeiyakuListDataSourceBean.setDispsyouhnnm(syouhinNm_Syu);
                betukeiyakuListDataSourceBean.setSiteidruktnmkn(kykKihon_Betu.getSiteidruktnmkn());
                betukeiyakuListDataSourceBean.setSiteidruktnmkj(kykKihon_Betu.getSiteidruktnmkj());
                betukeiyakuListDataSourceBean.setHhknnmkj(kykKihon_Betu.getHhknnmkj());
                betukeiyakuListDataSourceBeanLst.add(betukeiyakuListDataSourceBean);

                taiSiKykKihonLst.add(kykKihon_Betu);
            }
        }

        if(kykKihonLst.size() > 1) {

            uiBean.setBetukeiyakuList(betukeiyakuListDataSourceBeanLst);
        }

        BetukutiKeiyakuInfoGet betukutiKeiyakuInfoGet = SWAKInjector.getInstance(BetukutiKeiyakuInfoGet.class);

        BetukutiKeiyakuInfoGetParam betukutiKeiyakuInfoGetParam = SWAKInjector
            .getInstance(BetukutiKeiyakuInfoGetParam.class);

        betukutiKeiyakuInfoGetParam.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        betukutiKeiyakuInfoGetParam.setHuho2kykno(syoNo_Main);
        betukutiKeiyakuInfoGetParam.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);

        BetukutiKeiyakuInfoResultBean betukutiKeiyakuInfoResultBean = betukutiKeiyakuInfoGet.exec(betukutiKeiyakuInfoGetParam);

        for (int i = 0; i < betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().size(); i++) {

            if (C_SysCdKbn.RAY.eq(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getSyscdkbn())
                && C_BetukutiKeiyakuKbn.KEIYAKU.eq(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getBetukutikeiyakukbn())) {

            } else {

                BetukykInfoDataSourceBean betukykInfoDataSourceBean = SWAKInjector.getInstance(BetukykInfoDataSourceBean.class);
                betukykInfoDataSourceBean.setBtkyksyono(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getBtkyksyono());
                betukykInfoDataSourceBean.setSyscdkbn(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getSyscdkbn());
                betukykInfoDataSourceBean.setBetukutikeiyakukbn(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getBetukutikeiyakukbn());
                betukykInfoDataSourceBean.setKankeisyakbnname(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getKankeisyakbnname());
                betukykInfoDataSourceBean.setSyoumetuymd(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getSyoumetuymd());
                betukykInfoDataSourceBean.setSyoumetujiyuuname(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getSyoumetujiyuuname());
                betukykInfoDataSourceBean.setSyouhnnm(betukutiKeiyakuInfoResultBean.getBetukutiKeiyakuInfoBeanLst().get(i).getSyouhnnm());
                betukeiyakuInfoDataSourceBeanLst.add(betukykInfoDataSourceBean);
            }
        }

        if (C_MQSyorikekkaKbn.ERROR.eq(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn())) {
            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_WARNING, MessageId.WJA1057, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyorikekkaKbn.SEIJYOU.eq(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn()) &&
            C_PalSyoukaiJissiumuKbn.NONE.eq(betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn())) {
            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_WARNING, MessageId.WJA1058, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn())) {
            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_WARNING, MessageId.WJA1059, MessageUtil.getMessage(MessageId.IJW1084));
        }

        if (C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getKykmfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getNkfkensuutyoukaumu()) ||
            C_BlnktkumuKbn.ARI.eq(betukutiKeiyakuInfoResultBean.getSueokifkensuutyoukaumu())) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_WARNING,
                MessageId.WBA0012);
        }

        uiBean.setBetukykInfo(betukeiyakuInfoDataSourceBeanLst);

        uiBean.setTaiSiKykKihonLst(taiSiKykKihonLst);

        uiBean.setBetukyksuu(kykKihonLst.size() - 1);

        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);

        chkSubKhSyorityuu.exec(kykKihonLst.get(0), kinou.getKinouId(), chkKekkaBeanLst);

        if (chkKekkaBeanLst.size() != 0) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1069, syoNo_Main);
        }

        BetuskSyorityuChk betuskSyorityuChk = SWAKInjector.getInstance(BetuskSyorityuChk.class);
        boolean result = betuskSyorityuChk.exec(syoNo_Main, null);

        if (!result) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1070, betuskSyorityuChk.getWmJimutetuzukinm(), betuskSyorityuChk.getWmNodenm(), syoNo_Main);
        }

        boolean bChkResult = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(kykKihonLst.get(0).getOyadrtencd());

        if (bChkResult) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1060, syoNo_Main);
        }

        if (kykSyouhin_Main_Syu.getYendthnkymd() != null) {

            List<ChkKekkaBean> chkKekkaBeanLstHnri = Lists.newArrayList();

            ChkSubHnrkinMbr chkSubHnrkinMbr = SWAKInjector.getInstance(ChkSubHnrkinMbr.class);

            chkSubHnrkinMbr.exec(kykKihonLst.get(0), chkKekkaBeanLstHnri);

            if (chkKekkaBeanLstHnri.size() != 0) {
                if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                        MessageId.WJA1064,
                        syoNo_Main);

                } else if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                        MessageId.WJA1065,
                        syoNo_Main);
                }
            }
        }

        if (C_KykdrknHtdjytKbn.SETTEI.eq(kykKihonLst.get(0).getKykdrknhatudoujyoutai())) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1079, syoNo_Main);
        }
    }

    private void setUiBean_Main(JT_SiKykKihon pKykKihon_Main) {

        uiBean.setKyknmkn(pKykKihon_Main.getKyknmkn());
        uiBean.setKyknmkj(pKykKihon_Main.getKyknmkj());
        uiBean.setKykseiymd(pKykKihon_Main.getKykseiymd());
        uiBean.setKyksei(pKykKihon_Main.getKyksei());
        uiBean.setHhknnmkn(pKykKihon_Main.getHhknnmkn());
        uiBean.setHhknnmkj(pKykKihon_Main.getHhknnmkj());
        uiBean.setHhknseiymd(pKykKihon_Main.getHhknseiymd());
        uiBean.setHhknsei(pKykKihon_Main.getHhknsei());
        uiBean.setTdkdtsinyno(pKykKihon_Main.getTsinyno());
        uiBean.setTdkdtsinadr1kj(pKykKihon_Main.getTsinadr1kj());
        uiBean.setTdkdtsinadr2kj(pKykKihon_Main.getTsinadr2kj());
        uiBean.setTdkdtsinadr3kj(pKykKihon_Main.getTsinadr3kj());
        uiBean.setTdkdtsintelno(pKykKihon_Main.getTsintelno());
        uiBean.setSiteidruktnmkn(pKykKihon_Main.getSiteidruktnmkn());
        uiBean.setSiteidruktnmkj(pKykKihon_Main.getSiteidruktnmkj());
        uiBean.setYuukousyoumetukbn(pKykKihon_Main.getYuukousyoumetukbn());
        uiBean.setKykdairinmkj(pKykKihon_Main.getKykdairinmkj());
        uiBean.setKykdryno(pKykKihon_Main.getKykdryno());
        uiBean.setKykdradr1kj(pKykKihon_Main.getKykdradr1kj());
        uiBean.setKykdradr2kj(pKykKihon_Main.getKykdradr2kj());
        uiBean.setKykdradr3kj(pKykKihon_Main.getKykdradr3kj());
        uiBean.setKykdrtelno(pKykKihon_Main.getKykdrtelno());

        for (int i = 0; i < pKykKihon_Main.getSiKykSyouhns().size(); i++) {

            if (C_SyutkKbn.SYU.eq(pKykKihon_Main.getSiKykSyouhns().get(i).getSyutkkbn())) {

                uiBean.setSknnkaisiymd(pKykKihon_Main.getSiKykSyouhns().get(i).getSknnkaisiymd());

                break;
            }
        }

        if (C_Tdk.HONNIN.eq(pKykKihon_Main.getKkkyktdk())) {

            uiBean.setKeiyakushahihokenshadouituFlg(true);
        }

        if (pKykKihon_Main.getSbuktnin() > 0) {

            SiSetUiBean.setUketorinin(uiBean, pKykKihon_Main, pKykKihon_Main.getSiUkts());
        }
    }

    private JT_SiKykSyouhn getSiKykSyouhnSyukyk(JT_SiKykKihon pKykKihon){

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        for (int i = 0; i < pKykKihon.getSiKykSyouhns().size(); i++) {

            if (C_SyutkKbn.SYU.eq(pKykKihon.getSiKykSyouhns().get(i).getSyutkkbn())) {

                siKykSyouhn = pKykKihon.getSiKykSyouhns().get(i);

                break;
            }
        }
        return siKykSyouhn;

    }

    void initParam_Message() {
        messageManager.removeConversationMessage(SiMessageGroupConstants.GROUP_HUBIMESSAGE);
    }

    private void chkRequired() {

        String gmSyoriKbn = uiBean.getGamensyorikbn();

        if(gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {
            if(C_SeikyuuSyubetu.BLNK.eq(uiBean.getSeikyuusyubetu())) {

                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SEIKYUUSYUBETU.getErrorResourceKey()));

            }

            if(C_GeninKbn.BLNK.eq(uiBean.getGeninkbn())) {
                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENAIYOU_GENINKBN.getErrorResourceKey()));
            }
        }

    }

    private void chkRelation() {
        C_MousideninKbn mosninKbn = uiBean.getMousideninkbn();
        String mosninNmKj         = uiBean.getMousideninnmkj();
        String siteiDruktNmKn     = uiBean.getSiteidruktnmkn();
        C_SouhusakiKbn shskKbn    = uiBean.getSouhusakikbn();
        String tsnskYno           = uiBean.getTsinyno();
        String tsnskAdr1Kj        = uiBean.getTsinadr1kj();
        String tsnskAdr2Kj        = uiBean.getTsinadr2kj();
        String tsnskAdr3Kj        = uiBean.getTsinadr3kj();
        String tsnskTelno        = uiBean.getTsintelno();

        if (C_MousideninKbn.UKTHONNIN.eq(mosninKbn)
            || C_MousideninKbn.STDRNIN.eq(mosninKbn)
            || C_MousideninKbn.HHKNHONNIN.eq(mosninKbn)
            || C_MousideninKbn.KYKDAIRININ.eq(mosninKbn)) {

            if(!BizUtil.isBlank(mosninNmKj)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO_MOUSIDENINNMKJ.getErrorResourceKey()));

            }
        }
        else {

            if(BizUtil.isBlank(mosninNmKj)) {
                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO_MOUSIDENINNMKJ.getErrorResourceKey()));
            }

        }

        if(C_MousideninKbn.STDRNIN.eq(mosninKbn)) {
            if(BizUtil.isBlank(siteiDruktNmKn)) {
                errMessages.addMessage(MessageId.EBA0024, C_MousideninKbn.STDRNIN.getContent());
            }
        }

        if(C_SouhusakiKbn.TDADD.eq(shskKbn)) {
            if(!BizUtil.isBlank(tsnskYno)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINYNO.getErrorResourceKey()));
            }
            if(!BizUtil.isBlank(tsnskAdr1Kj)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINADR1KJ.getErrorResourceKey()));
            }
            if(!BizUtil.isBlank(tsnskAdr2Kj)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINADR1KJ.getErrorResourceKey()));
            }
            if(!BizUtil.isBlank(tsnskAdr3Kj)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINADR1KJ.getErrorResourceKey()));
            }
            if(!BizUtil.isBlank(tsnskTelno)) {
                errMessages.addMessage(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINTELNO.getErrorResourceKey()));
            }
        }
        else {
            if(BizUtil.isBlank(tsnskYno)) {
                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINYNO.getErrorResourceKey()));
            }
            if(BizUtil.isBlank(tsnskAdr1Kj)) {
                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINADR1KJ.getErrorResourceKey()));
            }

            BzChkAdrKetasuu bzChkAdrKetasuu = SWAKInjector.getInstance(BzChkAdrKetasuu.class);
            BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(tsnskAdr1Kj, tsnskAdr2Kj, tsnskAdr3Kj);
            C_JyougenketasuutyoukaKbn  jyougenketasuutyoukaKbn  = bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn();

            if (C_JyougenketasuutyoukaKbn.CYOUKA.eq(jyougenketasuutyoukaKbn)) {

                errMessages.addMessage(MessageId.EBA1003,
                    new String[]{MessageUtil.getMessage(DDID_MOUSIDENININFO2_TSINADR1KJ.getErrorResourceKey()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInKetasuu()),
                    String.valueOf(bzChkAdrKetasuuOutBean.getInJyougenKetasuu())});
            }
        }
    }

    private void chkRelation_HknkMosuke(BizDate pSyoriYmd, JT_SiKykKihon pKykkihon) {

        C_SeikyuuSyubetu skSyubetu    = uiBean.getSeikyuusyubetu();
        BizDate sibouYmd              = uiBean.getSibouymd();
        C_MousideninKbn mosninKbn     = uiBean.getMousideninkbn();

        if(C_SeikyuuSyubetu.SB.eq(skSyubetu)) {
            if(sibouYmd == null) {
                errMessages.addMessage(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey()));
            }
            else{

                if(BizDateUtil.compareYmd(pSyoriYmd, sibouYmd) == BizDateUtil.COMPARE_LESSER) {
                    errMessages.addMessage(MessageId.EBF0124,
                        MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey()));
                }

                if(C_MousideninKbn.STDRNIN.eq(mosninKbn)) {
                    errMessages.addMessage(MessageId.EJA0035);
                }
            }
        }
    }

    private void chkRelation_Kyh() {

        List<JT_SiKykKihon> taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

        if(taiSiKykKihonLst.isEmpty()) {
            throw new CommonBizAppException("対象契約リストの取得に失敗しました。");
        }

        JT_SiKykKihon kykKihon;

        List<BetukeiyakuListDataSourceBean> betukeiyakuList = uiBean.getBetukeiyakuListDataSource().getAllData();

        for(int iI = 0; iI < taiSiKykKihonLst.size() ; iI++) {
            kykKihon    = taiSiKykKihonLst.get(iI);

            if(iI == CNT_KYKKIHON_MAIN) {
                chkRelation_Kyh_Messeage(kykKihon);
            }

            else {
                if(betukeiyakuList.get(iI - 1).getCommonCheckBox()) {
                    chkRelation_Kyh_Messeage(kykKihon);
                }
            }
        }
        uiBean.setSbMnskumMap(sbumnskUmuMp);
    }

    private void chkRelation_Kyh_Messeage(JT_SiKykKihon pKykkihon){

        String errorMsgId    = "";

        JT_SiKykSyouhn siKykSyouhn = getSiKykSyouhnSyukyk(pKykkihon);

        if(uiBean.getGamensyorikbn().equals(SYO_HKNKMOSUKE)){

            List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

            ChkSubSasiosae chkSubSasiosae = SWAKInjector.getInstance(ChkSubSasiosae.class);

            chkSubSasiosae.exec(pKykkihon, chkKekkaBeanLst);

            if (chkKekkaBeanLst.size() != 0) {

                errMessages.addMessage(MessageId.EJA0144, pKykkihon.getSyono());
            }

            chkKekkaBeanLst = Lists.newArrayList();

            ChkSubStknset chkSubStknset = SWAKInjector.getInstance(ChkSubStknset.class);

            chkSubStknset.exec(pKykkihon, chkKekkaBeanLst);

            if (chkKekkaBeanLst.size() != 0) {

                errMessages.addMessage(MessageId.EJA0143, pKykkihon.getSyono());
            }

            if (C_MousideninKbn.KYKDAIRININ.eq(uiBean.getMousideninkbn())) {
                KykCommonHantei kykCommonHantei = SWAKInjector.getInstance(KykCommonHantei.class);

                boolean chkFlag1 = kykCommonHantei.chkKykdrtkykumu(pKykkihon);

                if (!chkFlag1) {

                    errMessages.addMessage(MessageId.EJA1057,
                        MessageUtil.getMessage(DDID_MOUSIDENININFO_MOUSIDENINKBN.getErrorResourceKey()),
                        pKykkihon.getSyono());
                }

                boolean chkFlag2 = kykCommonHantei.chkKeiukedou(pKykkihon);

                if (!chkFlag2) {

                    errMessages.addMessage(MessageId.EJA1057,
                        MessageUtil.getMessage(DDID_MOUSIDENININFO_MOUSIDENINKBN.getErrorResourceKey()),
                        pKykkihon.getSyono());
                }
            }

            if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                C_YuukousyoumetuKbn yuukouSyoumetuKbn = pKykkihon.getYuukousyoumetukbn();

                if (!C_YuukousyoumetuKbn.YUUKOU.eq(yuukouSyoumetuKbn)) {

                    BizDate syometuYmd = pKykkihon.getSyoumetuymd();

                    if (BizDateUtil.compareYmd(syometuYmd, uiBean.getSibouymd()) == BizDateUtil.COMPARE_LESSER) {

                        errMessages.addMessage(MessageId.EJA1047, pKykkihon.getSyono());
                    }
                    else {

                        messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, MessageId.WJA1067, pKykkihon.getSyono());
                    }
                }

                if (siKykSyouhn.getYendthnkymd() != null) {

                    List<ChkKekkaBean> chkKekkaBeanLstYendt = Lists.newArrayList();

                    ChkSubEndtHenkouYmd chkSubEndtHenkouYmd = SWAKInjector.getInstance(ChkSubEndtHenkouYmd.class);

                    chkSubEndtHenkouYmd.exec(uiBean.getSibouymd(), siKykSyouhn.getYendthnkymd(), chkKekkaBeanLstYendt);

                    if (chkKekkaBeanLstYendt.size() != 0) {

                        errMessages.addMessage(MessageId.EJA1048, MessageUtil.getMessage(MessageId.IJW1091),
                            MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey()), pKykkihon.getSyono());

                    }
                }

                List<ChkKekkaBean> chkKekkaBeanPHrkmYuuyokknLst = Lists.newArrayList();

                ChkSubPHrkmYuuyokkn chkSubPHrkmYuuyokkn = SWAKInjector.getInstance(ChkSubPHrkmYuuyokkn.class);

                chkSubPHrkmYuuyokkn.exec(uiBean.getSibouymd(), pKykkihon.getSyono(),chkKekkaBeanPHrkmYuuyokknLst);

                if (chkKekkaBeanPHrkmYuuyokknLst.size() != 0){
                    errMessages.addMessage(MessageId.EJA1050,
                        MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey()), pKykkihon.getSyono());
                }

                boolean chkFlgSbumensk = chkSbMensekiTgt(pKykkihon, uiBean.getSibouymd(), uiBean.getGeninkbn());

                if (chkFlgSbumensk) {
                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, MessageId.WJA1068, pKykkihon.getSyono());
                    sbumnskUmuMp.put(pKykkihon.getSyono(), C_UmuKbn.ARI);
                }
                else {
                    sbumnskUmuMp.put(pKykkihon.getSyono(), C_UmuKbn.NONE);
                }

                errorMsgId = chkSibouKariuketuke(pKykkihon.getSyono());

                if (!BizUtil.isBlank(errorMsgId)) {

                    errMessages.addMessage(errorMsgId, pKykkihon.getSyono());
                    errorMsgId = "";
                }

                DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
                if(!douituSyonoStyChk.exec(pKykkihon.getSyono(), TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                    KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)){
                    errMessages.addMessage(MessageId.EJA1044, pKykkihon.getSyono());
                }

                setWarningSknnKaisiKykYmd(pKykkihon);

                List<ChkKekkaBean> chkKekkaBeanLstKh = Lists.newArrayList();

                ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);
                chkSubKhSyorityuu.exec(pKykkihon, kinou.getKinouId(), chkKekkaBeanLstKh);

                if (chkKekkaBeanLstKh.size() != 0) {

                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, MessageId.WJA1069, pKykkihon.getSyono());
                }

                BetuskSyorityuChk betuskSyorityuChk = SWAKInjector.getInstance(BetuskSyorityuChk.class);

                boolean result = betuskSyorityuChk.exec(pKykkihon.getSyono(), null);

                if (!result) {

                    messageManager.addConversationMessageId(
                        SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                        MessageId.WJA1070,
                        betuskSyorityuChk.getWmJimutetuzukinm(),
                        betuskSyorityuChk.getWmNodenm(),
                        pKykkihon.getSyono());
                }
            }

            boolean bChkResult = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(pKykkihon.getOyadrtencd());

            if (bChkResult) {

                messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                    MessageId.WJA1060, pKykkihon.getSyono());
            }

            if (siKykSyouhn.getYendthnkymd() != null) {

                List<ChkKekkaBean> chkKekkaBeanLstHnri = Lists.newArrayList();

                ChkSubHnrkinMbr chkSubHnrkinMbr = SWAKInjector.getInstance(ChkSubHnrkinMbr.class);

                chkSubHnrkinMbr.exec(pKykkihon, chkKekkaBeanLstHnri);

                if (chkKekkaBeanLstHnri.size() != 0) {
                    if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                        messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                            MessageId.WJA1064,
                            pKykkihon.getSyono());

                    } else if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                        messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                            MessageId.WJA1065,
                            pKykkihon.getSyono());
                    }
                }
            }

            errorMsgId = chkKykdrknHatudouzumi(pKykkihon.getKykdrknhatudoujyoutai());

            if (!BizUtil.isBlank(errorMsgId)) {

                messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, errorMsgId,
                    pKykkihon.getSyono());
                errorMsgId = "";
            }

            errorMsgId = chkKykdrknMihatudou(pKykkihon.getKykdrknhatudoujyoutai(), uiBean.getMousideninkbn());

            if (!BizUtil.isBlank(errorMsgId)) {

                messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, errorMsgId,
                    pKykkihon.getSyono());
                errorMsgId = "";
            }

            errorMsgId = chkTtdkKykisinouryokunasi(pKykkihon, uiBean.getMousideninkbn());

            if (!BizUtil.isBlank(errorMsgId)) {

                messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, errorMsgId,
                    pKykkihon.getSyono());
                errorMsgId = "";
            }
        }
    }

    private void setUiBean() {

        C_MousideninKbn mosninKbn = uiBean.getMousideninkbn();
        C_SouhusakiKbn shskKbn    = uiBean.getSouhusakikbn();

        if(C_MousideninKbn.UKTHONNIN.eq(mosninKbn)) {

            String gmSyoriKbn = uiBean.getGamensyorikbn();

            List<JT_SiKykKihon> taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

            JT_SiKykKihon kykKihon = taiSiKykKihonLst.get(0);

            List<JT_SiUkt> siUktLst = kykKihon.getSiUkts();

            C_Hkuktsyu ukeKbn = C_Hkuktsyu.BLNK;

            if (SYO_HKNKMOSUKE.equals(gmSyoriKbn)) {

                if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                    ukeKbn = C_Hkuktsyu.SBHKKUKT;
                }
            } else {

                ukeKbn = C_Hkuktsyu.SBHKKUKT;
            }

            C_Hkuktsyu dbUkeSyuKbn = C_Hkuktsyu.BLNK;
            List<String> ukeNmKJLst = Lists.newArrayList();

            for (int iI = 0; iI < siUktLst.size(); iI++){

                dbUkeSyuKbn = siUktLst.get(iI).getHkuktsyu();

                if (dbUkeSyuKbn.eq(ukeKbn)){

                    ukeNmKJLst.add(siUktLst.get(iI).getUktnmkj());
                }
            }

            if (ukeNmKJLst.size() == 0){
                errMessages.addMessage(MessageId.EBA0024, "受取人情報");
            }
            else if (BizUtil.isBlank(ukeNmKJLst.get(0))){
                errMessages.addMessage(MessageId.EJA1031,
                    MessageUtil.getMessage(MessageId.IJW1034),
                    MessageUtil.getMessage(C_MousideninKbn.UKTHONNIN.getContent()));
            }
            else{

                if (SYO_HKNKMOSUKE.equals(gmSyoriKbn)) {

                    if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                        if (ukeNmKJLst.size() > 1){
                            errMessages.addMessage(MessageId.EJA0070,
                                MessageUtil.getMessage(DDID_MOUSIDENININFO_MOUSIDENINKBN.getErrorResourceKey()));
                        }

                        if (C_UketorininSibouUmuKbn.UKTSBARI.eq(uiBean.getUketorininsibouumukbn())){
                            errMessages.addMessage(MessageId.EJA1043,
                                MessageUtil.getMessage(DDID_MOUSIDENININFO_UKETORININSIBOUUMUKBN.getErrorResourceKey()),
                                MessageUtil.getMessage(C_MousideninKbn.UKTHONNIN.getContent()));
                        }

                        if (!errMessages.exists()){
                            uiBean.setMousideninnmkj(ukeNmKJLst.get(0));
                        }

                    }
                }
            }
        }
        else if (C_MousideninKbn.STDRNIN.eq(mosninKbn)) {

            if (!errMessages.exists()){
                uiBean.setMousideninnmkj(uiBean.getSiteidruktnmkj());
            }
        }
        else if (C_MousideninKbn.KYKHONNIN.eq(mosninKbn)) {

            if (!errMessages.exists()){
                uiBean.setMousideninnmkj(uiBean.getKyknmkj());
            }
        }
        else if (C_MousideninKbn.HHKNHONNIN.eq(mosninKbn)){

            if (!errMessages.exists()){
                uiBean.setMousideninnmkj(uiBean.getHhknnmkj());
            }
        }
        else if (C_MousideninKbn.KYKDAIRININ.eq(mosninKbn)) {

            if (C_UketorininSibouUmuKbn.UKTSBARI.eq(uiBean.getUketorininsibouumukbn())){
                errMessages.addMessage(MessageId.EJA1043,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO_UKETORININSIBOUUMUKBN.getErrorResourceKey()),
                    MessageUtil.getMessage(C_MousideninKbn.KYKDAIRININ.getContent()));
            }

            if (C_KyksyaSibouUmuKbn.KYKSBARI.eq(uiBean.getKyksyasibouumukbn())){
                errMessages.addMessage(MessageId.EJA1043,
                    MessageUtil.getMessage(DDID_MOUSIDENININFO_KYKSYASIBOUUMUKBN.getErrorResourceKey()),
                    MessageUtil.getMessage(C_MousideninKbn.KYKDAIRININ.getContent()));
            }

            if (!errMessages.exists()){
                uiBean.setMousideninnmkj(uiBean.getKykdairinmkj());
            }
        }

        if (!errMessages.exists()) {

            if (C_SouhusakiKbn.TDADD.eq(shskKbn)) {
                if (C_MousideninKbn.KYKDAIRININ.eq(mosninKbn)) {
                    uiBean.setTsinyno(uiBean.getKykdryno());
                    uiBean.setTsinadr1kj(uiBean.getKykdradr1kj());
                    uiBean.setTsinadr2kj(uiBean.getKykdradr2kj());
                    uiBean.setTsinadr3kj(uiBean.getKykdradr3kj());
                    uiBean.setTsintelno(uiBean.getKykdrtelno());
                }
                else {
                    uiBean.setTsinyno(uiBean.getTdkdtsinyno());
                    uiBean.setTsinadr1kj(uiBean.getTdkdtsinadr1kj());
                    uiBean.setTsinadr2kj(uiBean.getTdkdtsinadr2kj());
                    uiBean.setTsinadr3kj(uiBean.getTdkdtsinadr3kj());
                    uiBean.setTsintelno(uiBean.getTdkdtsintelno());
                }
            }
        }
        else {
            throw new BizLogicException(errMessages);
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    private void setOutaiInfoMaxRenNo() {

        JT_SiKykKihon            kykKihon;
        HashMap<String, Integer> outaiRenNoMap  = new HashMap<>();
        Integer                  renNo;
        String                   syoNo;

        String gmSyoriKbn = uiBean.getGamensyorikbn();

        List<JT_SiKykKihon> taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

        for(int iI = 0; iI < taiSiKykKihonLst.size() ; iI++) {
            kykKihon = taiSiKykKihonLst.get(iI);
            syoNo = kykKihon.getSyono();

            if(iI == CNT_KYKKIHON_MAIN) {

                if(gmSyoriKbn.equals(SYO_TTDKANNAISKI)) {

                    renNo = siharaiDomManager.getOutaiMaxRennoBySyono(syoNo);
                    if (renNo == null) {

                        renNo = 0;
                    }
                    else {
                        renNo = renNo + 1;
                    }

                    outaiRenNoMap.put(syoNo, renNo);
                }
            }
            else {

                List<BetukeiyakuListDataSourceBean> betukeiyakuList = uiBean.getBetukeiyakuListDataSource().getAllData();

                if(betukeiyakuList.get(iI - 1).getCommonCheckBox()) {

                    if(gmSyoriKbn.equals(SYO_TTDKANNAISKI)) {

                        renNo = siharaiDomManager.getOutaiMaxRennoBySyono(syoNo);
                        if (renNo == null) {

                            renNo = 0;
                        }
                        else {
                            renNo = renNo + 1;
                        }
                        outaiRenNoMap.put(syoNo, renNo);
                    }
                }
            }
        }

        uiBean.setOutaiRenNoMap(outaiRenNoMap);
    }

    private void setWarningSknnKaisiKykYmd(JT_SiKykKihon pSiKykKihon) {
        String gmSyoriKbn = uiBean.getGamensyorikbn();
        BizDate sbYmd     = null;
        String dispSbYmd  = "";
        if (gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {
            if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {
                sbYmd = uiBean.getSibouymd();
                dispSbYmd = MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey());
            }
        }

        JT_SiKykSyouhn siKykSyouhn = getSiKykSyouhnSyukyk(pSiKykKihon);

        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        ChkSubSknnKaisiYmd chkSubSknnKaisiYmd = SWAKInjector.getInstance(ChkSubSknnKaisiYmd.class);
        chkSubSknnKaisiYmd.exec(sbYmd, pSiKykKihon.getHksknnkaisiymd(), siKykSyouhn, chkKekkaBeanLst);

        if (chkKekkaBeanLst.size() != 0) {
            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1066, chkKekkaBeanLst.get(0).getMsgHikisuu1(), dispSbYmd, pSiKykKihon.getSyono());
        } else {

            List<ChkKekkaBean> chkKekkaBeanKykymd = new ArrayList<>();

            ChkSubKykYmd chkSubKykYmd = SWAKInjector.getInstance(ChkSubKykYmd.class);

            chkSubKykYmd.exec(sbYmd, siKykSyouhn.getKykymd(), chkKekkaBeanKykymd);

            if (chkKekkaBeanKykymd.size() != 0) {
                messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                    MessageId.WJA1066,
                    MessageUtil.getMessage(JT_SiKykSyouhn.KYKYMD),
                    MessageUtil.getMessage(DDID_MOUSIDENAIYOU_SIBOUYMD.getErrorResourceKey()),
                    pSiKykKihon.getSyono());
            }
        }
    }

    private List<MousideReportEditBean> insTable() {

        JT_SiKykKihon         kykKihon;
        String                syoNo;
        Integer               outaiRenNo;
        String                skNo       = "";

        List<MousideReportEditBean> mousideReportEditBeanLst = Lists.newArrayList();
        List<JT_SkKihon> skKihonLst;
        BizDate siboukaritrkymd = null;

        List<JT_SiKykKihon> taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

        if(taiSiKykKihonLst.isEmpty()) {
            throw new CommonBizAppException("対象契約リストの取得に失敗しました。");
        }

        HashMap<String, Integer> outaiRenNoMap  = uiBean.getOutaiRenNoMap();

        String gmSyoriKbn = uiBean.getGamensyorikbn();

        for(int iI = 0; iI < taiSiKykKihonLst.size() ; iI++) {
            kykKihon = taiSiKykKihonLst.get(iI);
            syoNo    = kykKihon.getSyono();

            if(iI == CNT_KYKKIHON_MAIN) {
                if(gmSyoriKbn.equals(SYO_TTDKANNAISKI)) {

                    outaiRenNo = outaiRenNoMap.get(syoNo);
                    doInsJT_Outai(kykKihon, outaiRenNo);

                }
                else if(gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {

                    skNo = SaibanBiz.getSeikyuBangou();

                    uiBean.setSkno(skNo);

                    if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                        DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
                        if(!douituSyonoStyChk.exec(syoNo, TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                            KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)){
                            throw new BizLogicException(MessageId.EJA1044, syoNo);
                        }

                        skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(syoNo,
                            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

                        siboukaritrkymd = skKihonLst.get(0).getSiboukaritrkymd();
                    }

                    doInsJTMouside_JTSkKihon_JTTtdkRrk(kykKihon, skNo, siboukaritrkymd);
                }

                MousideReportEditBean mousideReportEditBean = makePDF(kykKihon);

                mousideReportEditBeanLst.add(mousideReportEditBean);
            }
            else {
                List<BetukeiyakuListDataSourceBean> betukeiyakuList = uiBean.getBetukeiyakuListDataSource().getAllData();

                if(betukeiyakuList.get(iI - 1).getCommonCheckBox()) {

                    if(gmSyoriKbn.equals(SYO_TTDKANNAISKI)) {
                        outaiRenNo = outaiRenNoMap.get(syoNo);

                        doInsJT_Outai(kykKihon, outaiRenNo);

                    }
                    else if(gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {

                        skNo = uiBean.getSkno();

                        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                            DouituSyonoStyChk douituSyonoStyChk = SWAKInjector.getInstance(DouituSyonoStyChk.class);
                            if(!douituSyonoStyChk.exec(syoNo, TeisuuSiharai.JIMUTETUZUKICD_SISIBOU,
                                KOUTEIKANRISTATUS_SYORITYUU_KANRYOU)){
                                throw new BizLogicException(MessageId.EJA1044, syoNo);
                            }

                            skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
                                syoNo,
                                C_SeikyuuSyubetu.SBKRUKTK,
                                C_UmuKbn.NONE);

                            siboukaritrkymd = skKihonLst.get(0).getSiboukaritrkymd();
                        }

                        doInsJTMouside_JTSkKihon_JTTtdkRrk(kykKihon, skNo, siboukaritrkymd);
                    }

                    MousideReportEditBean mousideReportEditBean = makePDF(kykKihon);

                    if (mousideReportEditBean != null) {

                        mousideReportEditBeanLst.add(mousideReportEditBean);
                    }
                }
            }
        }

        return mousideReportEditBeanLst;
    }

    private void doInsJT_Outai(JT_SiKykKihon pKykKihon, Integer pOutaiRenNo) {

        String functionId   = kinou.getKinouId();
        String userId       = baseUserInfo.getUserId();
        String sysTime      = BizDate.getSysDateTimeMilli();
        String kinouModeId  = kinouMode.getKinouMode();

        JT_Outai outai = new JT_Outai();

        outai.setSyono(pKykKihon.getSyono());
        outai.setRenno(pOutaiRenNo);
        outai.setNayoseyouhi(C_NayoseYouhi.YOU);
        outai.setMousideninkbn(uiBean.getMousideninkbn());
        outai.setSyuhiyouhi(C_SyuhiYouhi.HUYOU);
        outai.setMousideninnmkj(uiBean.getMousideninnmkj());
        outai.setSouhusakikbn(uiBean.getSouhusakikbn());
        outai.setTsinyno(uiBean.getTsinyno());
        outai.setTsinadr1kj(uiBean.getTsinadr1kj());
        outai.setTsinadr2kj(uiBean.getTsinadr2kj());
        outai.setTsinadr3kj(uiBean.getTsinadr3kj());
        outai.setTsintelno(uiBean.getTsintelno());
        outai.setBetukyksuu(uiBean.getBetukyksuu());
        outai.setKossyoricd(functionId);
        outai.setKossyorisscd(kinouModeId);
        outai.setGyoumuKousinsyaId(userId);
        outai.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(outai);

        siharaiDomManager.insert(outai);
    }

    private void doInsJTMouside_JTSkKihon_JTTtdkRrk(JT_SiKykKihon pKykKihon, String pSkNo, BizDate pSiboukaritrkymd) {

        String functionId   = kinou.getKinouId();
        String userId       = baseUserInfo.getUserId();
        String sysTime      = BizDate.getSysDateTimeMilli();
        String kinouModeId  = kinouMode.getKinouMode();

        JT_SkKihon skKihon = new JT_SkKihon();

        C_SeikyuuSyubetu skSyubetu = null;

        String gmSyoriKbn = uiBean.getGamensyorikbn();

        EditRrkTblBean editRrkTblBean = SWAKInjector.getInstance(EditRrkTblBean.class);

        if(gmSyoriKbn.equals(SYO_HKNKMOSUKE)) {
            skSyubetu = uiBean.getSeikyuusyubetu();
        }

        skKihon.setSkno(pSkNo);
        skKihon.setSyono(pKykKihon.getSyono());
        skKihon.setSeikyuusyubetu(skSyubetu);
        skKihon.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon.setSiboukaritrkymd(pSiboukaritrkymd);
        skKihon.setKyknmkj(pKykKihon.getKyknmkj());
        skKihon.setKyknmkn(pKykKihon.getKyknmkn());
        skKihon.setKykseiymd(pKykKihon.getKykseiymd());
        skKihon.setKyksei(pKykKihon.getKyksei());
        skKihon.setHhknnmkj(pKykKihon.getHhknnmkj());
        skKihon.setHhknnmkn(pKykKihon.getHhknnmkn());
        skKihon.setHhknseiymd(pKykKihon.getHhknseiymd());
        skKihon.setHhknsei(pKykKihon.getHhknsei());
        skKihon.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.SYORITYUU);
        skKihon.setSateiyhkbn(C_SateiYouhiKbn.BLNK);
        skKihon.setKakninumukbn(C_UmuKbn.NONE);
        skKihon.setHubijyoukyoukbn(C_HubiJyoukyouKbn.BLNK);
        skKihon.setTyousajyoukyoukbn(C_TyousaJyoukyouKbn.BLNK);
        skKihon.setShrkekkakbn(C_ShrKekkaKbn.BLNK);
        skKihon.setSbjishrumukbn(C_UmuKbn.ARI);
        skKihon.setSaigaihigaitoukbn(C_SaigaiHigaitouKbn.BLNK);
        skKihon.setGaibuinsatuoutymd(null);
        skKihon.setKossyoricd(functionId);
        skKihon.setKossyorisscd(kinouModeId);
        skKihon.setGyoumuKousinsyaId(userId);
        skKihon.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(skKihon);

        JT_Mouside mouside = skKihon.createMouside();

        mouside.setSkno(pSkNo);
        mouside.setSyono(pKykKihon.getSyono());
        mouside.setSeikyuusyubetu(skSyubetu);
        mouside.setNayoseyouhi(C_NayoseYouhi.YOU);
        mouside.setMousideninkbn(uiBean.getMousideninkbn());
        mouside.setSyuhiyouhi(C_SyuhiYouhi.HUYOU);
        mouside.setMousideninnmkj(uiBean.getMousideninnmkj());
        mouside.setUketorininsibouumukbn(uiBean.getUketorininsibouumukbn());
        mouside.setKyksyasibouumukbn(uiBean.getKyksyasibouumukbn());
        mouside.setSouhusakikbn(uiBean.getSouhusakikbn());
        mouside.setTsinyno(uiBean.getTsinyno());
        mouside.setTsinadr1kj(uiBean.getTsinadr1kj());
        mouside.setTsinadr2kj(uiBean.getTsinadr2kj());
        mouside.setTsinadr3kj(uiBean.getTsinadr3kj());
        mouside.setTsintelno(uiBean.getTsintelno());
        mouside.setPmenkbn(C_PmenKbn.BLNK);
        mouside.setGeninkbn(uiBean.getGeninkbn());
        mouside.setJikosyosinymd(null);
        mouside.setSaigaigeninkbn(C_SaigaiGeninKbn.BLNK);
        mouside.setSibouymd(uiBean.getSibouymd());
        mouside.setSyougaikoteiymd(null);
        mouside.setByoumeitourokuno(uiBean.getByoumeitourokuno());
        mouside.setTiryousakikbn(C_TiryousakiKbn.BLNK);
        mouside.setNyuuinymd(null);
        mouside.setTaiinymd(null);
        mouside.setSyujyutuymd(null);
        mouside.setSyujyututourokuno("");
        mouside.setSensinkbn(C_SensinKbn.BLNK);
        mouside.setSindansyosksmaisuukbn(C_SindansyoSksMaisuuKbn.ZERO);
        mouside.setSindansyoskssiteikbn(C_SindansyoSksSiteiKbn.BLNK);
        mouside.setBetukyksuu(uiBean.getBetukyksuu());
        mouside.setKossyoricd(functionId);
        mouside.setKossyorisscd(kinouModeId);
        mouside.setGyoumuKousinsyaId(userId);
        mouside.setGyoumuKousinTime(sysTime);

        BizPropertyInitializer.initialize(mouside);

        editRrkTblBean.setSeiNo(pSkNo);
        editRrkTblBean.setSyoNo(pKykKihon.getSyono());
        editRrkTblBean.setSyoriYmd(BizDate.getSysDate());
        editRrkTblBean.setJimKakuteiUmuKbn(C_JimukakuteiKbn.KAKUTEI);

        editRrkTblBean = editRrk.makeTtdkRrk(uiBean, editRrkTblBean);

        JT_TtdkRireki ttdkRireki = skKihon.createTtdkRireki();

        BeanUtil.copyProperties(ttdkRireki, editRrkTblBean.getTtdkRireki());

        BizPropertyInitializer.initialize(ttdkRireki);

        siharaiDomManager.insert(skKihon);
    }

    private MousideReportEditBean makePDF(JT_SiKykKihon pKykKihon) {

        List<JT_SiKykSyouhn> siKykSyouhnLst = pKykKihon.getSiKykSyouhns();
        String syono = pKykKihon.getSyono();
        String hhknnmkj = pKykKihon.getHhknnmkj();
        int sbuktnin = pKykKihon.getSbuktnin();
        C_UmuKbn initsbhukaUmu = pKykKihon.getInitsbjiyensitihsytkhukaumu();
        int syukykIndex = 0;
        String syouhnCd = null;
        C_SbjiShrKbn sbjiShrKbn = C_SbjiShrKbn.BLNK;
        C_UmuKbn dhysntdkUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn jikojyoukyouhksUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn mynumbersksUmuKbn = C_UmuKbn.NONE;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        BizDate syoriYmd = BizDate.getSysDate();
        BizDate zeneiYmd = syoriYmd.getPreviousDay().getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        String tntSosikiCd = null;
        String toritugisyaKojinCd = null;
        String toritugisyaKojinNm = null;
        String toritugisyaSosikiNm = null;
        BizDate sknnkaisiYmd = null;
        String kanjisosikinm = null;
        String postalCd = null;
        String kanjisosikiadr1 = null;
        String kanjisosikiadr2 = null;
        String kanjisosikiadr3 = null;
        String telno = null;
        boolean jisatumensekiFlg = false;
        boolean kykshahhokenshadouituFlg = false;
        C_Tuukasyu kyktuukasyu = C_Tuukasyu.BLNK;
        Map<String, C_Tuukasyu> kykTuukaHntimp = new HashMap<String, C_Tuukasyu>();
        BizCurrency mynumberHanteiKingaku = BizCurrency.valueOf(0);
        C_HknKknKbn hknKknKbn = C_HknKknKbn.BLNK;
        BizDate kykYmd = null;
        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        ToiawaseInfoBean toiawaseInfoBean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        MousideReportEditBean mousideReportEditBean = SWAKInjector.getInstance(MousideReportEditBean.class);
        SiHituyousyoruiHanteiInBean siHituyousyoruiHanteiInBean = SWAKInjector.getInstance(SiHituyousyoruiHanteiInBean.class);
        ArrayList<C_SyoruiCdKbn> syoruiCdKbnLst = Lists.newArrayList();
        ArrayList<ReportServicesBean> reportServicesBeanLst = Lists.newArrayList();
        String mnTyouhyouPtn = null;
        HashMap<String, String> syoNoMnTyouhyouPtnMap  = new HashMap<>();
        C_UktKbn uktKbn = C_UktKbn.BLNK;

        for (int i = 0; i < siKykSyouhnLst.size(); i++) {

            if (C_SyutkKbn.SYU.eq(siKykSyouhnLst.get(i).getSyutkkbn())) {

                syukykIndex = i;
                syouhnCd = siKykSyouhnLst.get(i).getSyouhncd();
                kyktuukasyu = siKykSyouhnLst.get(i).getKyktuukasyu();
                kykYmd = siKykSyouhnLst.get(i).getKykymd();

                if (uiBean.getKykTuukaHntiMap() != null) {
                    kykTuukaHntimp = uiBean.getKykTuukaHntiMap();
                }

                kykTuukaHntimp.put(pKykKihon.getSyono(), kyktuukasyu);

                uiBean.setKykTuukaHntiMap(kykTuukaHntimp);

                if (pKykKihon.getHksknnkaisiymd() != null) {

                    sknnkaisiYmd = pKykKihon.getHksknnkaisiymd();
                } else {

                    sknnkaisiYmd = siKykSyouhnLst.get(i).getSknnkaisiymd();
                }

                break;
            }
        }

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisByKyuuhu(
            siKykSyouhnLst.get(syukykIndex).getSyouhncd(),
            siKykSyouhnLst.get(syukykIndex).getKyhgndkatakbn(), siKykSyouhnLst.get(syukykIndex).getSyouhnsdno());

        sbjiShrKbn = siSyouhnZokuseiLst.get(0).getSbjishrkbn();

        if (SYO_HKNKMOSUKE.equals(uiBean.getGamensyorikbn())) {

            if (C_UmuKbn.ARI.eq(uiBean.getSbMnskumMap().get(pKykKihon.getSyono()))) {

                if (C_KyksyaSibouUmuKbn.KYKSBARI.eq(uiBean.getKyksyasibouumukbn())) {

                    dhysntdkUmuKbn = C_UmuKbn.ARI;
                }
            } else {

                if (C_MousideninKbn.SOUZOKUNIN.eq(uiBean.getMousideninkbn())) {

                    dhysntdkUmuKbn = C_UmuKbn.ARI;
                }
                else if (C_UketorininSibouUmuKbn.UKTSBARI.eq(uiBean.getUketorininsibouumukbn())) {

                    dhysntdkUmuKbn = C_UmuKbn.ARI;
                }
                else {

                    if (sbuktnin > 1 && C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                        dhysntdkUmuKbn = C_UmuKbn.ARI;
                    }
                }
            }
        }

        if (pKykKihon.getSbuktnin() == 1) {

            uktKbn = pKykKihon.getSiUkts().get(0).getUktkbn();
        }

        SiSiharaiKingakuKeisan siSiharaiKingakuKeisan = SWAKInjector.getInstance(SiSiharaiKingakuKeisan.class);

        if (SYO_HKNKMOSUKE.equals(uiBean.getGamensyorikbn())) {

            Siinhantei siinhantei = SWAKInjector.getInstance(Siinhantei.class);
            siinKbn = (siinhantei.hanteiGeninKbn(uiBean.getGeninkbn()));

            SiSiharaiKingakuKeisanBean siSiharaiKingakuKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

            siSiharaiKingakuKeisanBean.setSyoNo(syono);
            siSiharaiKingakuKeisanBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
            siSiharaiKingakuKeisanBean.setCalcKijyunYmd(uiBean.getSibouymd());
            siSiharaiKingakuKeisanBean.setKnsnKijyunYmd(zeneiYmd);
            siSiharaiKingakuKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
            siSiharaiKingakuKeisanBean.setSyoruiUkeYmd(BizDate.getSysDate());
            siSiharaiKingakuKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
            siSiharaiKingakuKeisanBean.setSiKykKihon(pKykKihon);
            siSiharaiKingakuKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);
            siSiharaiKingakuKeisanBean.setYobidasimotoKinouId(kinou.getKinouId());
            siSiharaiKingakuKeisanBean.setSiinKbn(siinKbn);

            C_ErrorKbn errorKbn = siSiharaiKingakuKeisan.exec(siSiharaiKingakuKeisanBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)){
                throw new BizLogicException(siSiharaiKingakuKeisan.getErrMsg());
            }

            hknKknKbn = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getHknKknKbn();

            if ((C_SiinKbn.SG.eq(siinKbn)) && (C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn))){
                jikojyoukyouhksUmuKbn = C_UmuKbn.ARI;
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbMnskumMap().get(pKykKihon.getSyono()))) {
                if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {
                    if (siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKaiyakuHr().compareTo(
                        siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getTutaknGk()) < 0) {
                        mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getTutaknGk();
                    } else {
                        mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getKaiyakuHr();
                    }
                } else {
                    if (siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenKaiyakuHr().compareTo(
                        siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenTutaknGk()) < 0) {
                        mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenTutaknGk();
                    } else {
                        mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenKaiyakuHr();
                    }
                }
            } else {
                if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {
                    mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getHokenknGk();
                } else {
                    mynumberHanteiKingaku = siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getYenHokenknGk();
                }
            }

            if (YuyuBizConfig.getInstance().getShrtysyTsytHuyou().compareTo(mynumberHanteiKingaku) < 0){
                mynumbersksUmuKbn = C_UmuKbn.ARI;
            }
        }

        seikyuusyaInfoBean.setSeikyuusyanmKj(uiBean.getMousideninnmkj());
        seikyuusyaInfoBean.setTsinyno(uiBean.getTsinyno());
        seikyuusyaInfoBean.setTsinadr1kj(uiBean.getTsinadr1kj());
        seikyuusyaInfoBean.setTsinadr2kj(uiBean.getTsinadr2kj());
        seikyuusyaInfoBean.setTsinadr3kj(uiBean.getTsinadr3kj());
        seikyuusyaInfoBean.setTsintelno(uiBean.getTsintelno());


        BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = null;

        tntSosikiCd = baseUserInfo.getTmSosikiCd();

        boolean ccFlag = BzHanteiSosikiUtil.isCallcenterKeySosikicd(tntSosikiCd);

        if (ccFlag) {

            bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(YuyuBizConfig.getInstance().getCallcentersosikicd());
            toritugisyaKojinCd = "";
            toritugisyaKojinNm = "";
            toritugisyaSosikiNm = baseUserInfo.getTmSosikiNm();

        } else {

            bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(tntSosikiCd);
            toritugisyaKojinCd = baseUserInfo.getUserId();
            toritugisyaKojinNm = baseUserInfo.getUserNm();

            if (bzGetSosikiMadogutiInfoKekkaBean != null) {
                toritugisyaSosikiNm = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm();
            }
        }

        if (bzGetSosikiMadogutiInfoKekkaBean != null) {
            kanjisosikinm = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm();
            postalCd = bzGetSosikiMadogutiInfoKekkaBean.getPostalCd();
            kanjisosikiadr1 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1();
            kanjisosikiadr2 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2();
            kanjisosikiadr3 = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3();
            telno = bzGetSosikiMadogutiInfoKekkaBean.getTelno();
        }

        toiawaseInfoBean.setSosikiNm(kanjisosikinm);
        toiawaseInfoBean.setTsinyno(postalCd);
        toiawaseInfoBean.setTsinadr1kj(kanjisosikiadr1);
        toiawaseInfoBean.setTsinadr2kj(kanjisosikiadr2);
        toiawaseInfoBean.setTsinadr3kj(kanjisosikiadr3);
        toiawaseInfoBean.setTsintelno(telno);
        toiawaseInfoBean.setTelUktkKanouTime(YuyuBizConfig.getInstance().getUketimetantousitu1());
        toiawaseInfoBean.setTelUktkkanouTimeHigou(YuyuBizConfig.getInstance().getUketimetantousitu2());

        if (C_UmuKbn.ARI.eq(uiBean.getSbMnskumMap().get(pKykKihon.getSyono()))) {

            jisatumensekiFlg = true;
        }

        if (C_Tdk.HONNIN.eq(pKykKihon.getKkkyktdk())) {

            kykshahhokenshadouituFlg = true;
        }

        syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_SOUHU);

        if (SYO_HKNKMOSUKE.equals(uiBean.getGamensyorikbn())) {

            if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
            }
        }

        if (SYO_HKNKMOSUKE.equals(uiBean.getGamensyorikbn())) {

            if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {

                if (jisatumensekiFlg) {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
                }
                else {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(dhysntdkUmuKbn)) {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        }

        if (C_MousideninKbn.KYKDAIRININ.eq(uiBean.getMousideninkbn())) {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO);
        }

        if (C_UmuKbn.ARI.eq(jikojyoukyouhksUmuKbn)) {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        }

        if (C_UmuKbn.ARI.eq(mynumbersksUmuKbn)) {

            syoruiCdKbnLst.add(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);

            if (jisatumensekiFlg){

                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_MENSEKI;

            } else {

                if (sbuktnin == 1){

                    if (C_UktKbn.KYK.eq(uktKbn)) {

                        mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_SYOTOKUZEI;

                    } else {

                        if (kykshahhokenshadouituFlg){

                            mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_SOUZOKUZEI;

                        } else {

                            mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_ZOUYOZEI;
                        }
                    }

                } else {

                    mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_UKETORININHUKUSUU;
                }
            }

            if (uiBean.getSyoNoMnTyouhyouPtnMap() != null){
                syoNoMnTyouhyouPtnMap = uiBean.getSyoNoMnTyouhyouPtnMap();
            }
            syoNoMnTyouhyouPtnMap.put(syono, mnTyouhyouPtn);
            uiBean.setSyoNoMnTyouhyouPtnMap(syoNoMnTyouhyouPtnMap);

        }

        for (int i = 0; i < syoruiCdKbnLst.size(); i++) {

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);

            siTyouhyouHensyuuCommonBean.setSyoriYmd(syoriYmd);
            siTyouhyouHensyuuCommonBean.setSyoruiCd(syoruiCdKbnLst.get(i));

            if (C_SyoruiCdKbn.HK_SOUHU.eq(syoruiCdKbnLst.get(i))) {

                EditSouhuannaiBean editSouhuannaiBean = new EditSouhuannaiBean();
                editSouhuannaiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editSouhuannaiBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
                editSouhuannaiBean.setToiawaseInfoBean(toiawaseInfoBean);
                editSouhuannaiBean.setSyono(syono);

                if (SYO_TTDKANNAISKI.equals(uiBean.getGamensyorikbn())) {
                    editSouhuannaiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
                } else {
                    editSouhuannaiBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
                }

                editSouhuannaiBean.setJisatuMenseki(jisatumensekiFlg);
                editSouhuannaiBean.setInitsbjiyensitihsytkhukaUmu(initsbhukaUmu);
                editSouhuannaiBean.setHknkknKbn(hknKknKbn);
                editSouhuannaiBean.setKykTuukasyu(kyktuukasyu);
                editSouhuannaiBean.setMynumbertksUmuKbn(mynumbersksUmuKbn);

                EditSouhuannai editSouhuannai = SWAKInjector.getInstance(EditSouhuannai.class);
                ReportServicesBean reportServicesBean = editSouhuannai.exec(editSouhuannaiBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_TEISYUTUSYORUI.eq(syoruiCdKbnLst.get(i))) {

                EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
                editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editTeisyutusyoruiBean.setSyoNo(syono);
                editTeisyutusyoruiBean.setKykHhknDou(kykshahhokenshadouituFlg);
                editTeisyutusyoruiBean.setSbuktNin(sbuktnin);
                editTeisyutusyoruiBean.setMousideninKbn(uiBean.getMousideninkbn());
                editTeisyutusyoruiBean.setUketorininsibouUmukbn(uiBean.getUketorininsibouumukbn());
                editTeisyutusyoruiBean.setKyksyasibouUmukbn(uiBean.getKyksyasibouumukbn());
                editTeisyutusyoruiBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
                editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
                editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.NONE);
                editTeisyutusyoruiBean.setUktKbn(uktKbn);
                editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(0));
                editTeisyutusyoruiBean.setJisatuMenseki(jisatumensekiFlg);
                editTeisyutusyoruiBean.setJikojyoukyouhksUmu(jikojyoukyouhksUmuKbn);
                editTeisyutusyoruiBean.setKykdrknHtdjyt(pKykKihon.getKykdrknhatudoujyoutai());
                editTeisyutusyoruiBean.setMynumbertksUmuKbn(mynumbersksUmuKbn);

                EditTeisyutusyorui editTeisyutusyorui = SWAKInjector.getInstance(EditTeisyutusyorui.class);

                ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_SB_HOKEN_SKS.eq(syoruiCdKbnLst.get(i))) {

                EditSeikyuusyoBean editSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
                editSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
                editSeikyuusyoBean.setSyono(syono);
                editSeikyuusyoBean.setSeikyuusyubetu(uiBean.getSeikyuusyubetu());
                editSeikyuusyoBean.setUktKbn(uktKbn);
                editSeikyuusyoBean.setToritsugisyakjncd(toritugisyaKojinCd);
                editSeikyuusyoBean.setToritsugisyaKjnmei(toritugisyaKojinNm);
                editSeikyuusyoBean.setToritsugisyaSosikimei(toritugisyaSosikiNm);
                editSeikyuusyoBean.setTuukasyu(kyktuukasyu);

                EditSeikyuusyo editSeikyuusyo = SWAKInjector.getInstance(EditSeikyuusyo.class);

                ReportServicesBean reportServicesBean = editSeikyuusyo.exec(editSeikyuusyoBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.eq(syoruiCdKbnLst.get(i))) {

                EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean = SWAKInjector.getInstance(
                    EditSeisankinhurikomiiraisyoBean.class);
                editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
                editSeisankinhurikomiiraisyoBean.setUktnmkj(uiBean.getMousideninnmkj());
                editSeisankinhurikomiiraisyoBean.setSyono(syono);
                editSeisankinhurikomiiraisyoBean.setHhknNmkj(hhknnmkj);
                editSeisankinhurikomiiraisyoBean.setKykYmd(kykYmd);
                editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(sknnkaisiYmd);
                editSeisankinhurikomiiraisyoBean.setKyksyasibouumukbn(uiBean.getKyksyasibouumukbn());
                editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd(toritugisyaKojinCd);
                editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei(toritugisyaKojinNm);
                editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei(toritugisyaSosikiNm);
                editSeisankinhurikomiiraisyoBean.setKyktuukasyu(kyktuukasyu);
                editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(siSiharaiKingakuKeisan.getSiHkkingakuSisanParamBean().getHokenkinsyuruiKbn());
                editSeisankinhurikomiiraisyoBean.setSyouhncd(syouhnCd);

                EditSeisankinhurikomiiraisyo editSeisankinhurikomiiraisyo = SWAKInjector.getInstance(
                    EditSeisankinhurikomiiraisyo.class);

                ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(
                    editSeisankinhurikomiiraisyoBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_SB_DAIHYOU.eq(syoruiCdKbnLst.get(i))) {

                EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector.getInstance(EditDaihyousennintodokeBean.class);
                editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editDaihyousennintodokeBean.setSyoNo(syono);

                EditDaihyousennintodoke editDaihyousennintodoke = SWAKInjector.getInstance(
                    EditDaihyousennintodoke.class);

                ReportServicesBean reportServicesBean = editDaihyousennintodoke.exec(
                    editDaihyousennintodokeBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_JIJYOUTODOKEKENSEIYAKUSYO.eq(syoruiCdKbnLst.get(i))) {

                EditJijotdkkenseiyakusyoBean editJijotdkkenseiyakusyoBean = SWAKInjector
                    .getInstance(EditJijotdkkenseiyakusyoBean.class);
                editJijotdkkenseiyakusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editJijotdkkenseiyakusyoBean.setSyono(syono);
                editJijotdkkenseiyakusyoBean.setHknknukt(pKykKihon.getKyknmkj());
                editJijotdkkenseiyakusyoBean.setDrsk(pKykKihon.getKykdairinmkj());

                EditJijotdkkenseiyakusyo editJijotdkkenseiyakusyo = SWAKInjector
                    .getInstance(EditJijotdkkenseiyakusyo.class);

                ReportServicesBean reportServicesBean = editJijotdkkenseiyakusyo.exec(
                    editJijotdkkenseiyakusyoBean);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_KD_JIKOJKS.eq(syoruiCdKbnLst.get(i))) {

                EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector.getInstance(EditJikojyokyouhoukokusyoBean.class);
                editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

                EditJikojyokyouhoukokusyo editJikojyokyouhoukokusyo = SWAKInjector.getInstance(EditJikojyokyouhoukokusyo.class);

                ReportServicesBean reportServicesBean = editJikojyokyouhoukokusyo.exec(
                    editJikojyokyouhoukokusyoBean);

                reportServicesBean.setKensakuKeys(syono);

                reportServicesBeanLst.add(reportServicesBean);
            }

            else if (C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.eq(syoruiCdKbnLst.get(i))) {

                EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);
                editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
                editMynumberCBean.setSyono(syono);
                editMynumberCBean.setMntyouhyouptn(mnTyouhyouPtn);

                EditMynumberC editMynumberC = SWAKInjector.getInstance(EditMynumberC.class);

                ReportServicesBean reportServicesBean = editMynumberC.exec(editMynumberCBean);

                reportServicesBeanLst.add(reportServicesBean);
            }
        }

        mousideReportEditBean.setSkno(uiBean.getSkno());
        mousideReportEditBean.setSyoNo(syono);
        mousideReportEditBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
        mousideReportEditBean.setReportServicesBeanLst(reportServicesBeanLst);

        if (!SYO_TTDKANNAISKI.equals(uiBean.getGamensyorikbn())) {

            siHituyousyoruiHanteiInBean.setSeikyuuSyubetu(uiBean.getSeikyuusyubetu());
            siHituyousyoruiHanteiInBean.setHrkmnryUmuKbn(C_UmuKbn.NONE);
            siHituyousyoruiHanteiInBean.setMikeikapUmuKbn(C_UmuKbn.NONE);
            siHituyousyoruiHanteiInBean.setSbjiShrKbn(sbjiShrKbn);
            siHituyousyoruiHanteiInBean.setKanitratkiUmuKbn(C_UmuKbn.NONE);
            siHituyousyoruiHanteiInBean.setSyouhnCd(syouhnCd);
            siHituyousyoruiHanteiInBean.setGeninKbn(uiBean.getGeninkbn());
            siHituyousyoruiHanteiInBean.setSaigaiGeninKbn(C_SaigaiGeninKbn.BLNK);
            siHituyousyoruiHanteiInBean.setMousideninKbn(uiBean.getMousideninkbn());
            siHituyousyoruiHanteiInBean.setDhysntdkUmuKbn(dhysntdkUmuKbn);
            siHituyousyoruiHanteiInBean.setPmenKbn(C_PmenKbn.BLNK);
            siHituyousyoruiHanteiInBean.setStikasUmuKbn(C_UmuKbn.NONE);
            siHituyousyoruiHanteiInBean.setNstkhukaumukbn(C_UmuKbn.NONE);
            siHituyousyoruiHanteiInBean.setJisatumensekiumukbn(uiBean.getSbMnskumMap().get(pKykKihon.getSyono()));
            siHituyousyoruiHanteiInBean.setKyksyasibouumukbn(uiBean.getKyksyasibouumukbn());
            siHituyousyoruiHanteiInBean.setJikojksumukbn(jikojyoukyouhksUmuKbn);
            siHituyousyoruiHanteiInBean.setMynumbersinkokuumukbn(mynumbersksUmuKbn);
            siHituyousyoruiHanteiInBean.setKkkyktdk(pKykKihon.getKkkyktdk());

            siHituyousyoruiHanteiInBeanMp.put(syono, siHituyousyoruiHanteiInBean);

            siharaiPreReportRenkeiBean.setSiHituyousyoruiHanteiInBeanMp(siHituyousyoruiHanteiInBeanMp);
        }

        return mousideReportEditBean;
    }

    private void initParamGotoInputContents() {
        C_MousideninKbn     mosninKbn;
        C_SouhusakiKbn      shskKbn;
        List<JT_SiKykKihon> taiSiKykKihonLst;
        JT_SiKykKihon       kykKihon;
        JT_SiKykSyouhn      kykSyouhn;

        mosninKbn = uiBean.getMousideninkbn();
        shskKbn   = uiBean.getSouhusakikbn();

        taiSiKykKihonLst = uiBean.getTaiSiKykKihonLst();

        String errorMsgId    = "";

        if(taiSiKykKihonLst == null || taiSiKykKihonLst.isEmpty()) {
            throw new CommonBizAppException("対象契約リストの取得に失敗しました。");
        }
        kykKihon = taiSiKykKihonLst.get(0);

        kykSyouhn = getSiKykSyouhnSyukyk(kykKihon);

        if( C_MousideninKbn.KYKHONNIN.eq(mosninKbn)
            || C_MousideninKbn.UKTHONNIN.eq(mosninKbn)
            || C_MousideninKbn.STDRNIN.eq(mosninKbn)
            || C_MousideninKbn.HHKNHONNIN.eq(mosninKbn)
            || C_MousideninKbn.KYKDAIRININ.eq(mosninKbn)) {

            uiBean.setMousideninnmkj("");
        }

        if(C_SouhusakiKbn.TDADD.eq(shskKbn)) {

            uiBean.setTsinyno("");
            uiBean.setTsinadr1kj("");
            uiBean.setTsinadr2kj("");
            uiBean.setTsinadr3kj("");
            uiBean.setTsintelno("");
        }

        initParam_Message();

        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        ChkSubKhSyorityuu chkSubKhSyorityuu = SWAKInjector.getInstance(ChkSubKhSyorityuu.class);

        chkSubKhSyorityuu.exec(kykKihon, kinou.getKinouId(), chkKekkaBeanLst);

        if (chkKekkaBeanLst.size() != 0) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1069, kykKihon.getSyono());
        }

        BetuskSyorityuChk betuskSyorityuChk = SWAKInjector.getInstance(BetuskSyorityuChk.class);

        boolean result = betuskSyorityuChk.exec(kykKihon.getSyono(), null);

        if (!result) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, MessageId.WJA1070,
                betuskSyorityuChk.getWmJimutetuzukinm(), betuskSyorityuChk.getWmNodenm(), kykKihon.getSyono());
        }

        boolean bChkResult = BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(kykKihon.getOyadrtencd());

        if (bChkResult) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                MessageId.WJA1060, kykKihon.getSyono());
        }

        if (kykSyouhn.getYendthnkymd() != null) {

            List<ChkKekkaBean> chkKekkaBeanLstHnri = Lists.newArrayList();

            ChkSubHnrkinMbr chkSubHnrkinMbr = SWAKInjector.getInstance(ChkSubHnrkinMbr.class);

            chkSubHnrkinMbr.exec(kykKihon, chkKekkaBeanLstHnri);

            if (chkKekkaBeanLstHnri.size() != 0) {
                if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                        MessageId.WJA1064,
                        kykKihon.getSyono());

                } else if (C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK.eq(chkKekkaBeanLstHnri.get(0).getSKNaiyouChkKbn())) {

                    messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE,
                        MessageId.WJA1065,
                        kykKihon.getSyono());
                }
            }
        }

        errorMsgId = chkKykdrknHatudouzumi(kykKihon.getKykdrknhatudoujyoutai());

        if (!BizUtil.isBlank(errorMsgId)) {

            messageManager.addConversationMessageId(SiMessageGroupConstants.GROUP_HUBIMESSAGE, errorMsgId,
                kykKihon.getSyono());
            errorMsgId = "";
        }

    }

    private boolean chkSbMensekiTgt(JT_SiKykKihon pSikykKihon, BizDate pKijunYmd, C_GeninKbn pGeninKbn) {

        boolean sbmensekitaishouFlg = false;

        JT_SiKykSyouhn siKykSyouhn = getSiKykSyouhnSyukyk(pSikykKihon);

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(siKykSyouhn.getSyouhncd(),
            siKykSyouhn.getKyhgndkatakbn(), siKykSyouhn.getSyouhnsdno());

        List<ChkKekkaBean> chkKekkaBeanLst = Lists.newArrayList();

        ChkSubJisatuMenseki chkSubJisatuMenseki = SWAKInjector.getInstance(ChkSubJisatuMenseki.class);

        chkSubJisatuMenseki.exec(pKijunYmd, pGeninKbn, pSikykKihon.getHksknnkaisiymd(), siKykSyouhn,
            siSyouhnZokuseiLst.get(0), chkKekkaBeanLst);

        if (chkKekkaBeanLst.size() != 0) {

            sbmensekitaishouFlg = true;
        }

        return sbmensekitaishouFlg;
    }

    private String chkSibouKariuketuke(String pSyoNo) {

        String messageId = "";

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyoNo,
            C_SeikyuuSyubetu.SBKRUKTK, C_UmuKbn.NONE);

        if (skKihonLst.size() == 0) {

            messageId = MessageId.EJA1030;
        }

        return messageId;
    }

    private String chkKykdrknHatudouzumi(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai) {

        String messageId = "";

        if (C_KykdrknHtdjytKbn.SETTEI.eq(pKykdrknhatudoujyoutai)) {

            messageId = MessageId.WJA1079;
        }

        return messageId;
    }

    private String chkKykdrknMihatudou(C_KykdrknHtdjytKbn pKykdrknhatudoujyoutai, C_MousideninKbn pMousideninKbn) {

        String messageId = "";

        if (!C_KykdrknHtdjytKbn.SETTEI.eq(pKykdrknhatudoujyoutai)) {
            if (C_MousideninKbn.KYKDAIRININ.eq(pMousideninKbn)) {

                messageId = MessageId.WJA1080;
            }
        }

        return messageId;
    }

    private String chkTtdkKykisinouryokunasi(JT_SiKykKihon pSiKykKihon, C_MousideninKbn pMousideninKbn) {

        String messageId = "";

        if (C_MousideninKbn.UKTHONNIN.eq(pMousideninKbn)) {
            if (C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.eq(pSiKykKihon.getTtdktyuuikbn1())
                || C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.eq(pSiKykKihon.getTtdktyuuikbn2())
                || C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.eq(pSiKykKihon.getTtdktyuuikbn3())
                || C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.eq(pSiKykKihon.getTtdktyuuikbn4())
                || C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.eq(pSiKykKihon.getTtdktyuuikbn5())) {

                messageId = MessageId.WJA1081;
            }
        }

        return messageId;
    }

    private PdfBuilder pdfJoin(PdfBuilder pPdfBuilder, int pPdfSource, String pReportKey, String pPdfPath) {

        PdfBuilder pdfBuilder = pPdfBuilder;

        try{

            if (pPdfSource == PDFSOURCE_TBL){

                PdfReader pdfReader = new PdfReader(dbaOutputReport.getPdfImages(new String[]{pReportKey}));
                pdfBuilder.append(pdfReader);

            } else if (pPdfSource == PDFSOURCE_KOTEIPDF){

                PdfReader pdfReader = new PdfReader(SWAK.getApplicationRootPath() + pPdfPath);
                pdfBuilder.append(pdfReader);

            } else if (pPdfSource == PDFSOURCE_TBL_KOTEIPDF){

                PdfReader pdfReader1 = new PdfReader(dbaOutputReport.getPdfImages(new String[]{pReportKey}));
                pdfBuilder.append(pdfReader1);
                PdfReader pdfReader2 = new PdfReader(SWAK.getApplicationRootPath() + pPdfPath);
                pdfBuilder.append(pdfReader2);

            }

        } catch (Exception e) {

            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));

        }

        return pdfBuilder;
    }

}
