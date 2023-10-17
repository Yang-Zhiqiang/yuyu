package yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuKekkaBean;
import yuyu.common.biz.bzdairiten.KeijouYmSyutokuYokenBean;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.hozen.khcommon.SetSyokenhakkouymd;
import yuyu.common.sinkeiyaku.skcommon.EditNenkinKoumokuUtil;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetHknsyuruinm;
import yuyu.common.sinkeiyaku.skcommon.HknsyuruinmBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosSyoukaiInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosSyoukaiOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infrext.mq.RayWebServiceAuthInfo;

/**
 * 生保Ｗｅｂ申込状況照会サービスの実装クラスです。<br />
 */
public class HbSeihoWebMosSyoukaiImpl implements HbSeihoWebMosSyoukai {

    private static final String HKNSYURUI_ITIJIBR_19_SGARI = "Ⅱ型";

    private static final String HKNSYURUI_ITIJIBR_19_SGNASI = "Ⅰ型";

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private RayWebServiceAuthInfo rayWebAuthInfo;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String wkMosno = null;
        String errHukaMsg = "";

        try {

            logger.debug("▽ 生保Ｗｅｂ申込状況照会 開始");

            WsHbSeihoWebMosSyoukaiOutputBean seihoWebMosSyoukaiOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebMosSyoukaiOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
                SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebMosSyoukaiInputBean seihoWebMosSyoukaiInputBean;
            try {

                seihoWebMosSyoukaiInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebMosSyoukaiInputBean.class);

            }
            catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    logger.debug("△ 生保Ｗｅｂ申込状況照会 入力値エラー");

                    seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("02");
                    seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1001));

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            wkMosno = seihoWebMosSyoukaiInputBean.getIwsMosno();

            seihoWebMosSyoukaiOutputBean.setIwsMosno(wkMosno);

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

            webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, seihoWebMosSyoukaiInputBean);

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen =
                SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);

            C_SeihowebkengenKbn seihoWebKengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (!C_SeihowebkengenKbn.ARI.eq(seihoWebKengenKbn)) {

                seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("01");
                seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1035));

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                logger.debug("△ 生保Ｗｅｂ申込状況照会  端末操作権限エラー");

                return wsBzWebserviceResParamBean;
            }

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(seihoWebMosSyoukaiOutputBean.getIwsMosno());

            if (syoriCTL == null) {

                logger.debug("△ 生保Ｗｅｂ申込状況照会 該当契約なし");

                seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("03");
                seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1002));

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                return wsBzWebserviceResParamBean;
            }

            if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {

                logger.debug("△ 生保Ｗｅｂ申込状況照会 成契連絡未了");

                seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("05");
                seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1002));

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                return wsBzWebserviceResParamBean;
            }

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
            List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
            String bosyuuDrtenNm = "";
            String bosyuuNm = "";
            String bosyuuTrkNo = "";
            String kouinCd = "";
            String kydBosyuuDrtenNm = "";
            String kydBosyuuNm = "";
            String kydBosyuuTrkNo = "";
            List<BzGetAgInfoBean> aBzGetAgInfoBeanList = null;

            try {
                aBzGetAgInfoBeanList = bzGetAgInfo.exec(mosDairitenLst.get(0).getTratkiagcd());
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("A扱者代理店情報取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            for (BzGetAgInfoBean bzGetAgInfoBean : aBzGetAgInfoBeanList) {
                if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    bosyuuDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();

                    break;
                }
            }

            BzGetBsInfoBean aBzGetBsInfoBean = null;

            try {
                aBzGetBsInfoBean = bzGetBsInfo.exec(mosDairitenLst.get(0).getBosyuucd());
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("A扱者募集人情報取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            if (aBzGetBsInfoBean != null) {
                bosyuuNm = aBzGetBsInfoBean.getKanjiBosyuuninNm();
                bosyuuTrkNo = aBzGetBsInfoBean.getBosyuuTrkNo();
                kouinCd = aBzGetBsInfoBean.getKouinCd();
            }

            List<BzGetAgInfoBean> bBzGetAgInfoBeanList = new ArrayList<>();

            if (mosDairitenLst.size() > 1) {
                try {
                    bBzGetAgInfoBeanList = bzGetAgInfo.exec(mosDairitenLst.get(1).getTratkiagcd());
                } catch(Exception e) {

                    errHukaMsg = creatErrorMsg("B扱者代理店情報エラー" , wsBzWebserviceReqParamBean);

                    throw e;
                }

                for (BzGetAgInfoBean bzGetAgInfoBean : bBzGetAgInfoBeanList) {
                    if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                        kydBosyuuDrtenNm = bzGetAgInfoBean.getKanjiDairitenNm();

                        break;
                    }
                }

                BzGetBsInfoBean bBzGetBsInfoBean = null;
                try {
                    bBzGetBsInfoBean = bzGetBsInfo.exec(mosDairitenLst.get(1).getBosyuucd());
                } catch(Exception e) {

                    errHukaMsg = creatErrorMsg("B扱者募集人情報エラー" , wsBzWebserviceReqParamBean);

                    throw e;
                }

                if (bBzGetBsInfoBean != null) {
                    kydBosyuuNm = bBzGetBsInfoBean.getKanjiBosyuuninNm();
                    kydBosyuuTrkNo = bBzGetBsInfoBean.getBosyuuTrkNo();
                }
            }

            seihoWebKengenKbn = hbSeihoWebHanteiKengen.execChkDairitenKengen(
                wsBzWebserviceReqParamBean, aBzGetAgInfoBeanList, bBzGetAgInfoBeanList);

            if (C_SeihowebkengenKbn.DRTENSYOUKAERROR.eq(seihoWebKengenKbn)) {

                seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("01");
                seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1035));

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                logger.debug("△ 生保Ｗｅｂ申込状況照会  代理店用照会権限エラー");

                return wsBzWebserviceResParamBean;

            }
            else if (C_SeihowebkengenKbn.KEIYAKUERROR.eq(seihoWebKengenKbn)){

                seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("04");
                seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGA1003));

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

                logger.debug("△ 生保Ｗｅｂ申込状況照会  銀行代理店募集契約エラー");

                return wsBzWebserviceResParamBean;

            }

            List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
            List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
            List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
            List<HT_Uketorinin> uketorininSibouLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);
            List<HT_Uketorinin> uketorininNenkinLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.NKUKT);
            int nkuktNin = uketorininNenkinLst.size();
            List<HT_Uketorinin> uketorininSiteiDrSkLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

            HT_MosSyouhn mosSyouhnSyu = null;
            for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
                if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {
                    mosSyouhnSyu = mosSyouhn;
                    break;
                }
            }

            BM_SyouhnZokusei syouhnZokusei = null;
            try {
                syouhnZokusei = bizDomManager.getSyouhnZokusei(
                    mosSyouhnSyu.getSyouhncd(), mosSyouhnSyu.getSyouhnsdno());
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("商品属性マスタ取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }
            int syohinHanteiKbn = SyouhinUtil.hantei(syouhnZokusei.getSyouhncd());
            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

            BizDate sysDate = BizDate.getSysDate();
            SetSyokenhakkouymd setSyokenhakkouymd = SWAKInjector.getInstance(SetSyokenhakkouymd.class);
            String syoukenHakkouYtiYmd = "";
            String syoSakuseiYmd = "";
            String syoukenjk = "";

            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) &&
                C_Mfrenflg.SUMI.eq(syoriCTL.getMfrenflg())) {

                BizDate syoukenHakkouYtiYmdTemp = setSyokenhakkouymd.exec(syoriCTL.getSrsyoriymd());
                syoukenHakkouYtiYmd = syoukenHakkouYtiYmdTemp.toString();
                syoSakuseiYmd = syoriCTL.getSrsyoriymd().toString();

                if (BizDateUtil.compareYmd(sysDate, syoukenHakkouYtiYmdTemp) == BizDateUtil.COMPARE_LESSER) {
                    syoukenjk = "作成中";
                }
                else {
                    syoukenjk = "作成済";
                }
            }

            String ketteijk = "";

            if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn())) {
                ketteijk = "完了";
            }
            else if ((C_MostenkenjyouKbn.MOSTENKEN_ZUMI.eq(syoriCTL.getMostenkenjoukbn()) ||
                C_MostenkenjyouKbn.NONE.eq(syoriCTL.getMostenkenjoukbn())) &&
                (C_KnkysateijyouKbn.SATEIMATI_1.eq(syoriCTL.getKnkysateijyoukbn()) ||
                    C_KnkysateijyouKbn.SATEIMATI_2A.eq(syoriCTL.getKnkysateijyoukbn()) ||
                    C_KnkysateijyouKbn.SATEIMATI_2B.eq(syoriCTL.getKnkysateijyoukbn()) ||
                    C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(syoriCTL.getImusateijyoukbn()) ||
                    C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(syoriCTL.getImusateijyoukbn()))) {

                ketteijk = "査定中";
            }
            else {
                ketteijk = "未査定";
            }

            String nenkinSyuStr = "";
            String dispNenkinSyu = "";

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                    if (C_Sknenkinsyu.KKTI5DAI1BAIGAKU.eq(mosSyouhnSyu.getSknenkinsyu())) {
                        nenkinSyuStr = "第１回年金倍額型５年確定年金";
                    }
                    else {
                        nenkinSyuStr = "定額年金型" +
                            mosSyouhnSyu.getSknenkinsyu().getContent(C_Sknenkinsyu.PATTERN_DEFAULT) + "年金";
                    }
                }
                else {
                    nenkinSyuStr = mosSyouhnSyu.getSknenkinsyu().getContent(C_Sknenkinsyu.PATTERN_DEFAULT) + "年金";
                }
            }

            dispNenkinSyu = mojiPad(nenkinSyuStr, "　", 15);

            GetHknsyuruinm getHknsyuruinm = SWAKInjector.getInstance(GetHknsyuruinm.class);
            HknsyuruinmBean hknsyuruinmBean = null;
            String kokyakuHknnsyuruiNm = "";
            String hknsyuruiNm = "";

            try {
                hknsyuruinmBean = getHknsyuruinm.getHknsyuruinm(mosKihon.getHknsyuruino(),
                    mosKihon.getHknsyuruinosd(), mosKihon.getAisyoumeikbn());

                if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(mosKihon.getHknsyuruino())) {
                    kokyakuHknnsyuruiNm = hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou1() + HKNSYURUI_ITIJIBR_19_SGARI;
                }
                else if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGNASI.eq(mosKihon.getHknsyuruino())) {
                    kokyakuHknnsyuruiNm = hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou1() + HKNSYURUI_ITIJIBR_19_SGNASI;
                }
                else {
                    kokyakuHknnsyuruiNm = hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou1();
                }

                if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn
                    || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                    hknsyuruiNm = "　「" + hknsyuruinmBean.getAisyoumei() + "（第１保険期間" +
                        ConvertUtil.toZenNumeric(String.valueOf(mosSyouhnSyu.getDai1hknkkn())) + "年）」";
                }
                else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
                    || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn
                    || SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                    hknsyuruiNm = "　" + nenkinSyuStr + hknsyuruinmBean.getKokyakuhknnsyuruinmtwogyou2();
                }
                else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                    hknsyuruiNm = "　「" + hknsyuruinmBean.getAisyoumei() + "」";
                }
                else {
                    hknsyuruiNm = "";
                }

            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("保険種類名称取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            HT_MosTrkKzk mosTrkKzk1 = null;
            HT_MosTrkKzk mosTrkKzk2 = null;
            String kzktrkservice = "";
            String trkkzk01 = "";
            String trkkzkknnm01 = "";
            String trkkzkkjnm01 = "";
            BizDate trkkzkseiymd01 = null;
            String trkkzksei01 = "";
            String trkkzkyno01 = "";
            String trkkzkadr1x01 = "";
            String trkkzkadr2x01 = "";
            String trkkzktelno01 = "";
            String trkkzktdk01 = "";
            String trkkzk02 = "";
            String trkkzkknnm02 = "";
            String trkkzkkjnm02 = "";
            BizDate trkkzkseiymd02 = null;
            String trkkzksei02 = "";
            String trkkzkyno02 = "";
            String trkkzkadr1x02 = "";
            String trkkzkadr2x02 = "";
            String trkkzktelno02 = "";
            String trkkzktdk02 = "";

            if (C_KzktourokuserviceTourokuKbn.ARI.eq(mosKihon.getKzktourokuservicetourokukbn())) {

                kzktrkservice = "申し込みあり";
                List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();
                for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {

                    if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {

                        mosTrkKzk1 = mosTrkKzk;

                        trkkzk01 = "１人目";

                        trkkzkknnm01 = ConvertUtil.toHanAll(mosTrkKzk1.getTrkkzknmkn(), 0, 1);
                        if (trkkzkknnm01.length() > 18) {
                            trkkzkknnm01 = trkkzkknnm01.substring(0, 18);
                        }
                        trkkzkkjnm01 = mosTrkKzk1.getTrkkzknmkj();
                        trkkzkseiymd01 = mosTrkKzk1.getTrkkzkseiymd();
                        if (C_Seibetu.MALE.eq(mosTrkKzk1.getTrkkzksei())) {
                            trkkzksei01 = "男性";
                        }
                        else if (C_Seibetu.FEMALE.eq(mosTrkKzk1.getTrkkzksei())) {
                            trkkzksei01 = "女性";
                        }
                        if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk1.getTrkkzktsindousiteikbn())) {

                            trkkzkyno01 = BizUtil.editYno(mosTrkKzk1.getTrkkzkyno());
                            trkkzkadr1x01 = mosTrkKzk1.getTrkkzkadr1kj().concat(mosTrkKzk1.getTrkkzkadr2kj());
                            trkkzkadr2x01 = mosTrkKzk1.getTrkkzkadr3kj();
                        }
                        else {
                            trkkzkyno01 = BizUtil.editYno(mosKihon.getTsinyno());
                            trkkzkadr1x01 = mosKihon.getTsinadr1kj().concat(mosKihon.getTsinadr2kj());
                            trkkzkadr2x01 = mosKihon.getTsinadr3kj();
                        }
                        trkkzktelno01 = mosTrkKzk1.getTrkkzktelno();
                        if (C_Tdk.HGU.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "配偶者";
                        }
                        else if (C_Tdk.KO.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "子";
                        }
                        else if (C_Tdk.MAGO.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "孫";
                        }
                        else if (C_Tdk.KYDSM.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "兄弟姉妹";
                        }
                        else if (C_Tdk.SINTOU3.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "３親等の親族";
                        }
                        else if (C_Tdk.SONOTA.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "その他";
                        }
                        else if (C_Tdk.OYA.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "親";
                        }
                        else if (C_Tdk.SHB.eq(mosTrkKzk1.getTrkkzktdk())) {
                            trkkzktdk01 = "祖父母";
                        }
                    }
                    else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {

                        mosTrkKzk2 = mosTrkKzk;

                        trkkzk02 = "２人目";
                        trkkzkknnm02 = ConvertUtil.toHanAll(mosTrkKzk2.getTrkkzknmkn(), 0, 1);
                        if (trkkzkknnm02.length() > 18) {
                            trkkzkknnm02 = trkkzkknnm02.substring(0, 18);
                        }
                        trkkzkkjnm02 = mosTrkKzk2.getTrkkzknmkj();
                        trkkzkseiymd02 = mosTrkKzk2.getTrkkzkseiymd();
                        if (C_Seibetu.MALE.eq(mosTrkKzk2.getTrkkzksei())) {
                            trkkzksei02 = "男性";
                        }
                        else if (C_Seibetu.FEMALE.eq(mosTrkKzk2.getTrkkzksei())) {
                            trkkzksei02 = "女性";
                        }
                        if (C_TsindousiteiKbn.BLNK.eq(mosTrkKzk2.getTrkkzktsindousiteikbn())) {
                            trkkzkyno02 = BizUtil.editYno(mosTrkKzk2.getTrkkzkyno());
                            trkkzkadr1x02 = mosTrkKzk2.getTrkkzkadr1kj().concat(mosTrkKzk2.getTrkkzkadr2kj());
                            trkkzkadr2x02 = mosTrkKzk2.getTrkkzkadr3kj();
                        }
                        else {
                            trkkzkyno02 = BizUtil.editYno(mosKihon.getTsinyno());
                            trkkzkadr1x02 = mosKihon.getTsinadr1kj().concat(mosKihon.getTsinadr2kj());
                            trkkzkadr2x02 = mosKihon.getTsinadr3kj();
                        }

                        trkkzktelno02 = mosTrkKzk2.getTrkkzktelno();
                        if (C_Tdk.HGU.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "配偶者";
                        }
                        else if (C_Tdk.KO.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "子";
                        }
                        else if (C_Tdk.MAGO.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "孫";
                        }
                        else if (C_Tdk.KYDSM.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "兄弟姉妹";
                        }
                        else if (C_Tdk.SINTOU3.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "３親等の親族";
                        }
                        else if (C_Tdk.SONOTA.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "その他";
                        }
                        else if (C_Tdk.OYA.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "親";
                        }
                        else if (C_Tdk.SHB.eq(mosTrkKzk2.getTrkkzktdk())) {
                            trkkzktdk02 = "祖父母";
                        }
                    }
                }
            }


            String kykdrtky = "";
            String kykdrtkynm = "";

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getKykdrtkykhukakbn())) {

                kykdrtky = "あり";

                List<HT_Uketorinin> uketorininKykdrLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

                if (uketorininKykdrLst.size() != 0) {

                    HT_Uketorinin uketorininKykdr = uketorininKykdrLst.get(0);

                    if (C_UktKbn.TOUROKUKAZOKU1.eq(uketorininKykdr.getUktkbn()) && mosTrkKzk1 != null) {
                        kykdrtkynm = "登録家族１人目と同じ";
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(uketorininKykdr.getUktkbn()) && mosTrkKzk2 != null) {
                        kykdrtkynm = "登録家族２人目と同じ";
                    }
                }
            }

            String stdrskNm = "";
            C_Tdk ukttdk = null;
            BizDate uktseiymd = null;

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getStdrsktkyhkkbn())) {
                if (uketorininSiteiDrSkLst.size() != 0) {

                    HT_Uketorinin uketorininSiteiDrSk = uketorininSiteiDrSkLst.get(0);

                    if (C_UktKbn.NASI.eq(uketorininSiteiDrSk.getUktkbn())) {
                        stdrskNm = "指定意思なし";
                    }
                    else if (C_UktKbn.SBUK.eq(uketorininSiteiDrSk.getUktkbn())) {

                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getSbkyuuhukinuktumu())) {
                            stdrskNm = "死亡給付金受取人と同じ";
                        }
                        else if (C_UmuKbn.ARI.eq(syouhnZokusei.getSbhkuktumu())) {
                            stdrskNm = "死亡保険金受取人と同じ";
                        }
                        else {
                            stdrskNm = "";
                        }
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU1.eq(uketorininSiteiDrSk.getUktkbn()) && mosTrkKzk1 != null) {
                        stdrskNm = "登録家族１人目と同じ";
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(uketorininSiteiDrSk.getUktkbn()) && mosTrkKzk2 != null) {
                        stdrskNm = "登録家族２人目と同じ";
                    }
                    else if (C_UktKbn.KYK.eq(uketorininSiteiDrSk.getUktkbn())) {
                        stdrskNm = "契約者と同じ";
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(uketorininSiteiDrSk.getUktkbn())) {
                        if (C_Tdk.HGU.eq(uketorininSiteiDrSk.getUkttdk()) &&
                            BizUtil.isBlank(uketorininSiteiDrSk.getUktnmkj())) {
                            stdrskNm = "被保険者の配偶者";
                        }
                        else {
                            stdrskNm = uketorininSiteiDrSk.getUktnmkj();
                            ukttdk = uketorininSiteiDrSk.getUkttdk();
                            uktseiymd = uketorininSiteiDrSk.getUktseiymd();
                        }
                    }
                }
            }

            String kykknNm = "";
            String hhknknNm = "";
            String kykkjNm = "";
            String hhknkjNm = "";
            BizDate kykseiYmd = null;
            BizDate hhknseiYmd = null;
            Integer kyksyanen2Keta = null;
            Integer hhknnen2Keta = null;

            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                kykknNm = mosKihon.getHhknnmkn();
                hhknknNm = mosKihon.getHhknnmkn();
                kykkjNm = mosKihon.getHhknnmkj();
                hhknkjNm = mosKihon.getHhknnmkj();
                kykseiYmd = mosKihon.getHhknseiymd();
                hhknseiYmd = mosKihon.getHhknseiymd();
                kyksyanen2Keta = mosKihon.getHhknnen();
                hhknnen2Keta = mosKihon.getHhknnen();
            }
            else {
                kykknNm = mosKihon.getKyknmkn();
                hhknknNm = mosKihon.getHhknnmkn();
                kykkjNm = mosKihon.getKyknmkj();
                hhknkjNm = mosKihon.getHhknnmkj();
                kykseiYmd = mosKihon.getKykseiymd();
                hhknseiYmd = mosKihon.getHhknseiymd();
                kyksyanen2Keta = mosKihon.getKyknen();
                hhknnen2Keta = mosKihon.getHhknnen();
            }

            kykknNm = ConvertUtil.toHanAll(kykknNm, 0, 1);
            hhknknNm = ConvertUtil.toHanAll(hhknknNm, 0, 1);

            String nkshrtkyk = "";
            boolean bungenAriHyj = false;

            if (C_Nstkumu.ST_ARI.eq(syouhnZokusei.getNstkumu())) {

                nkshrtkyk = "年金支払特約Ⅰ型";

                if (C_Nstknsyu.KAKUTEINENKIN.eq(mosKihon.getNstksbnsyu())) {
                    nkshrtkyk = nkshrtkyk.concat("（確定年金");
                    bungenAriHyj = true;
                }

                if (mosKihon.getNstksbnkkn() != 0) {
                    String nstksbnkknStr = mosKihon.getNstksbnkkn().toString();
                    nstksbnkknStr = ConvertUtil.toZenNumeric(nstksbnkknStr);

                    if (bungenAriHyj) {
                        nkshrtkyk = nkshrtkyk.concat("　年金支払期間　").concat(nstksbnkknStr).concat("年");
                    }
                    else {
                        nkshrtkyk = nkshrtkyk.concat("（年金支払期間　").concat(nstksbnkknStr).concat("年");
                    }

                    bungenAriHyj = true;
                }

                if (bungenAriHyj) {
                    nkshrtkyk = nkshrtkyk.concat("）");
                }
            }

            Integer monthNum = sysDate.getMonth();
            Integer dayNum = sysDate.getDay();
            String mounthStr = monthNum.toString();
            String dayStr = dayNum.toString();

            mounthStr = ConvertUtil.toZenNumeric(mounthStr);
            dayStr = ConvertUtil.toZenNumeric(dayStr);

            if (monthNum < 10) {
                mounthStr = "　".concat(mounthStr);
            }

            if (dayNum < 10) {
                dayStr = "　".concat(dayStr);
            }

            String dispMd = mounthStr.concat("月").concat(dayStr).concat("日");

            KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = SWAKInjector.getInstance(KeijouYmSyutokuYokenBean.class);
            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
            BizDate mosSyumtKktYmd = null;

            String mosSyoumetuKbn;
            List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();

            if(dakuhiKetteiLst.size() == 0){

                mosSyoumetuKbn = "0";

            }
            else {

                mosSyoumetuKbn = editPalRenkeiKoumoku.editMosSyoumetuKbn(
                    syoriCTL.getSeiritukbn(), dakuhiKetteiLst.get(0).getKetkekkacd());
            }

            if (!"0".equals(mosSyoumetuKbn)) {
                mosSyumtKktYmd = syoriCTL.getSrsyoriymd();
            }

            keijouYmSyutokuYokenBean.setTratkiagCd(mosDairitenLst.get(0).getOyadrtencd());
            keijouYmSyutokuYokenBean.setSyouhnCd(mosSyouhnSyu.getSyouhncd());

            if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) ||
                C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) {
                keijouYmSyutokuYokenBean.setKokutiymd(syoriCTL.getKktymd());
            }
            else if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {
                keijouYmSyutokuYokenBean.setKokutiymd(mosKihon.getMosymd());
            }
            keijouYmSyutokuYokenBean.setSyokaiPRyosyuuYmd(syoriCTL.getRyosyuymd());
            keijouYmSyutokuYokenBean.setMosYmd(mosKihon.getMosymd());
            keijouYmSyutokuYokenBean.setMosSyoumetuKbn(mosSyoumetuKbn);
            keijouYmSyutokuYokenBean.setMosSyumtKktYmd(mosSyumtKktYmd);
            keijouYmSyutokuYokenBean.setBosyuuYm(mosKihon.getBosyuuym());

            rayWebAuthInfo.setSosikiCd(wsBzWebserviceReqParamBean.getOrgCode());
            rayWebAuthInfo.setOperatorId(wsBzWebserviceReqParamBean.getOperatorId());

            DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku =
                SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
            BizDateYM keijyouYm;
            DairitenTesuuryouInfoSyutokuKekkaBean dairitenTesuuryouInfoSyutokuKekkaBean = null;
            try {

                dairitenTesuuryouInfoSyutokuKekkaBean =
                    dairitenTesuuryouInfoSyutoku.exec(null, keijouYmSyutokuYokenBean);
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("計上年月取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            if (C_MQSyorikekkaKbn.ERROR.eq(dairitenTesuuryouInfoSyutokuKekkaBean.getMqSyoriKekkaKbn())) {
                logger.debug("計上年月取得　MQエラー");
                keijyouYm = null;
            }
            else if (C_ErrorKbn.ERROR.eq(dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYmSyoukaiKekkaKbn())) {
                logger.debug("計上年月取得　取得エラー");
                keijyouYm = null;
            }
            else {
                keijyouYm = dairitenTesuuryouInfoSyutokuKekkaBean.getKeijyouYm();
            }

            String wkMokuhyougk = "";
            String wkKijyungk = "";

            try {
                if(mosKihon.getTargettkhkkbn().eq(C_Tkhukaumu.HUKA)&&
                    syoriCTL.getNyknnrkumu().eq(C_UmuKbn.ARI)&&
                    mosKihon.getSeitoufstpkei().compareTo(BizCurrency.valueOf(0,mosKihon.getSeitoufstpkei().getType()))!=0){

                    KeisanKijyungk keisankijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                    C_ErrorKbn errorKbn = keisankijyungk.exec(syoriCTL.getRyosyuymd(),mosKihon.getMosfstpkei(),mosKihon.getSeitoufstpkei(),
                        mosKihon.getKyktuukasyu(),mosKihon.getYennykntkhkkbn());

                    if(errorKbn.eq(C_ErrorKbn.OK)){
                        wkKijyungk = keisankijyungk.getKijyungk().toFormatString();
                        if(wkKijyungk.length()<=14){
                            wkKijyungk = mojiPad(wkKijyungk," ",14);

                        }else{
                            wkKijyungk = "";
                        }

                        if(!mosKihon.getTargettkmkhtkbn().eq(C_TargetTkMokuhyoutiKbn.BLNK)&&
                            !mosKihon.getTargettkmkhtkbn().eq(C_TargetTkMokuhyoutiKbn.NOTARGET)){
                            KeisanTargetMokuhyougk gettarget = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
                            BizCurrency targetMokuhyougk = gettarget.exec(keisankijyungk.getKijyungk(),
                                Integer.valueOf(mosKihon.getTargettkmkhtkbn().getValue()));

                            wkMokuhyougk = targetMokuhyougk.toFormatString();

                            if(wkMokuhyougk.length()<=14){
                                wkMokuhyougk = mojiPad(wkMokuhyougk," ",14);

                            }else{
                                wkMokuhyougk = "";
                            }
                        }

                    }else{
                        logger.debug("△ 生保Ｗｅｂ申込状況照会 基準金額計算エラー");
                    }
                }

            }catch(Exception e){
                errHukaMsg = creatErrorMsg("基準金額取得、目標額取得エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            BizCurrency hrKgk = null;
            BizCurrency tikiKtbriyenHrkgk = null;
            BizCurrency znnTikiKtbriyenHrkgk = null;
            String dispHrkgk = "";
            String dispTikiKtbriyenHrkgk = "";
            String dispZnnTikiKtbriyenHrkgk = "";

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) ||
                (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn()) &&
                mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu()))) {
                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())
                    && C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                    hrKgk = mosKihon.getZennoup().add(mosKihon.getZennoujyuutoup());
                }
                else if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {
                    hrKgk = mosKihon.getIkkatup();
                }
                else {
                    hrKgk = mosSyouhnSyu.getHrktuukasyutkp();
                }
            }
            else {
                hrKgk = mosKihon.getHrktuukafstphrkgk();
            }

            if (hrKgk != null && hrKgk.compareTo(BizCurrency.valueOf(0, hrKgk.getType())) != 0) {
                dispHrkgk = hrKgk.toFormatString();
                if (dispHrkgk.length() <= 14) {
                    dispHrkgk = mojiPad(dispHrkgk, " ", 14);
                }
                else {
                    dispHrkgk = "";
                }
            }
            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {
                tikiKtbriyenHrkgk = mosKihon.getIkkatup();
                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())
                    && C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                    znnTikiKtbriyenHrkgk = mosKihon.getZennoup().add(mosKihon.getZennoujyuutoup());
                }
            }
            if (tikiKtbriyenHrkgk != null
                && tikiKtbriyenHrkgk.compareTo(BizCurrency.valueOf(0, tikiKtbriyenHrkgk.getType())) != 0) {
                dispTikiKtbriyenHrkgk = tikiKtbriyenHrkgk.toFormatString();
                if (dispTikiKtbriyenHrkgk.length() <= 14) {
                    dispTikiKtbriyenHrkgk = mojiPad(dispTikiKtbriyenHrkgk, " ", 14);
                }
                else {
                    dispTikiKtbriyenHrkgk = "";
                }
            }
            if (znnTikiKtbriyenHrkgk != null
                && znnTikiKtbriyenHrkgk.compareTo(BizCurrency.valueOf(0, znnTikiKtbriyenHrkgk.getType())) != 0) {
                dispZnnTikiKtbriyenHrkgk = znnTikiKtbriyenHrkgk.toFormatString();
                if (dispZnnTikiKtbriyenHrkgk.length() <= 14) {
                    dispZnnTikiKtbriyenHrkgk = mojiPad(dispZnnTikiKtbriyenHrkgk, " ", 14);
                }
                else {
                    dispZnnTikiKtbriyenHrkgk = "";
                }
            }

            BizCurrency hokenKngk = null;
            String dispHokenKngk = "";
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                hokenKngk = mosKihon.getPharaikomisougaku();
            }
            else if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                hokenKngk = mosSyouhnSyu.getKihons();
            }
            else if (mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu()) ||
                (!mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu()) &&
                    C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu()))) {
                hokenKngk = mosSyouhnSyu.getSeitoukihons();
            }

            if (hokenKngk != null && hokenKngk.compareTo(BizCurrency.valueOf(0, hokenKngk.getType())) != 0) {
                dispHokenKngk = hokenKngk.toFormatString();
                if (dispHokenKngk.length() <= 14) {
                    dispHokenKngk = mojiPad(dispHokenKngk, " ", 14);
                }
                else {
                    dispHokenKngk = "";
                }
            }

            String hknKkn = "";
            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSiharaiKaisiNenrei(
                    mosSyouhnSyu.getHknkkn(),
                    mosSyouhnSyu.getHknkknsmnkbn(),
                    mosKihon.getHhknnen()
                    );
                if (C_ErrorKbn.OK.eq(errorKbn)) {
                    hknKkn = mojiPad(ConvertUtil.toZenNumeric(String.valueOf(
                        editNenkinKoumokuUtil.getNenkinSiharaiKaisiNenrei())) + "歳", "　", 3);
                }
            }
            else {
                if (mosSyouhnSyu.getHknkkn() == 99) {
                    hknKkn = "終身";
                }
                else if (C_HknkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHknkknsmnkbn())) {
                    hknKkn = ConvertUtil.toZenNumeric(String.valueOf(mosSyouhnSyu.getHknkkn())) + "歳";
                }
                else {
                    hknKkn = ConvertUtil.toZenNumeric(String.valueOf(mosSyouhnSyu.getHknkkn())) + "年";
                }
                hknKkn = mojiPad(hknKkn, "　", 3);
            }

            if (hknKkn.length() > 3) {
                hknKkn = "９９歳";
            }

            BizCurrency hokenRyou = null;
            String dispHokenRyou = "";
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                hokenRyou = mosSyouhnSyu.getHrktuukasyutkp();
            }
            else if (C_PtratkituukasiteiKbn.SITEITUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                hokenRyou = mosSyouhnSyu.getHrktuukasyutkp();
            }
            else if (mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu()) ||
                (!mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu()) &&
                    C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu()))) {
                hokenRyou = mosSyouhnSyu.getSyutkp();
            }

            if (hokenRyou != null && hokenRyou.compareTo(BizCurrency.valueOf(0, hokenRyou.getType())) != 0) {
                dispHokenRyou = hokenRyou.toFormatString();

                if (dispHokenRyou.length() <= 14) {
                    dispHokenRyou = mojiPad(dispHokenRyou, " ", 14);
                }
                else {
                    dispHokenRyou = "";
                }
            }

            String dispHrkkkn = "";
            if (C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu())) {
                dispHrkkkn = "一時払";
            }
            else {
                if (C_HrkkknsmnKbn.SAIMANKI.eq(mosSyouhnSyu.getHrkkknsmnkbn())) {
                    dispHrkkkn = ConvertUtil.toZenNumeric(String.valueOf(mosSyouhnSyu.getHrkkkn())) + "歳";
                }
                else {
                    dispHrkkkn = ConvertUtil.toZenNumeric(String.valueOf(mosSyouhnSyu.getHrkkkn())) + "年";
                }
            }

            if (dispHrkkkn.length() <= 4) {
                dispHrkkkn = mojiPad(dispHrkkkn, "　", 4);
            }
            else {
                dispHrkkkn = "";
            }

            String dispHrktkykNm = "";

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {
                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                    dispHrktkykNm = "（保険料円貨払込特約（円貨払込額指定型））";
                }
                else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                    dispHrktkykNm = "（保険料円貨払込特約（一時払い））";
                }
                else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                    dispHrktkykNm = "（保険料円貨払込特約（円貨払込額変動型））";
                }
                else {
                    if (BizDateUtil.compareYmd(mosKihon.getMosymd(), BizDate.valueOf(20200401)) == BizDateUtil.COMPARE_LESSER) {
                        dispHrktkykNm = "（保険料円貨払込特約）";
                    }
                    else {
                        dispHrktkykNm = "（保険料円貨払込特約（一時払い））";
                    }
                }
            }
            else if (C_Tkhukaumu.HUKA.eq(mosKihon.getGaikanykntkhkkbn())) {
                dispHrktkykNm = "（保険料指定外通貨払込特約）";
            }

            String sueokiKkn = "";
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                C_ErrorKbn errorKbn = editNenkinKoumokuUtil.editNenkinSueokikikan(
                    mosSyouhnSyu.getHknkkn(),
                    mosSyouhnSyu.getHknkknsmnkbn(),
                    mosSyouhnSyu.getHrkkkn(),
                    mosSyouhnSyu.getHrkkknsmnkbn(),
                    mosKihon.getHhknnen()
                    );
                if (C_ErrorKbn.OK.eq(errorKbn)) {
                    sueokiKkn = mojiPad(ConvertUtil.toZenNumeric(String.valueOf(
                        editNenkinKoumokuUtil.getNenkinSueokikikan())) + "年", "　", 3);
                }
            }

            String sisuuNm = "";

            if (!C_Sisuukbn.BLNK.eq(mosKihon.getSisuukbn()) &&
                !C_TumitatekinHaibunWariKbn.BLNK.eq(mosKihon.getSisuuhaibunwarikbn()) &&
                !C_TumitatekinHaibunWariKbn.WARIAI000.eq(mosKihon.getSisuuhaibunwarikbn())) {

                BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(mosKihon.getSisuukbn());

                if (sisuuKihon != null) {
                    sisuuNm = sisuuKihon.getSisuunm();
                }
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispmd(dispMd);
            seihoWebMosSyoukaiOutputBean.setIwsMosjksyoukaimosno(seihoWebMosSyoukaiInputBean.getIwsMosno());
            seihoWebMosSyoukaiOutputBean.setIwsSksyono(syoriCTL.getSyono());
            if (bosyuuDrtenNm.length() > 20) {
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuudrtennm(bosyuuDrtenNm.substring(0, 20));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuudrtennm(bosyuuDrtenNm);
            }
            seihoWebMosSyoukaiOutputBean.setIwsDispbosyuunm(bosyuuNm);


            if (!BizUtil.isBlank(kouinCd)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuuninmds("行員コード");
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuutrknokouincd(kouinCd);
            }
            else if (!BizUtil.isBlank(bosyuuTrkNo)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuuninmds("募集人登録番号");
                seihoWebMosSyoukaiOutputBean.setIwsDispbosyuutrknokouincd(bosyuuTrkNo);
            }
            if (kydBosyuuDrtenNm.length() > 20) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkydatkidrtennm(kydBosyuuDrtenNm.substring(0, 20));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkydatkidrtennm(kydBosyuuDrtenNm);
            }
            seihoWebMosSyoukaiOutputBean.setIwsDispkydatkibosyuunm(kydBosyuuNm);
            seihoWebMosSyoukaiOutputBean.setIwsDispkydatkibosyuutrkno(kydBosyuuTrkNo);


            if (!BizUtil.isBlank(mosDairitenLst.get(0).getCifcd())){
                seihoWebMosSyoukaiOutputBean.setIwsDispsonotainfomds("ＣＩＦコード");
                seihoWebMosSyoukaiOutputBean.setIwsDispcifcduktkid(mosDairitenLst.get(0).getCifcd());
            }
            else if (!BizUtil.isBlank(mosKihon.getUktkid())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispsonotainfomds("受付管理ＩＤ");
                seihoWebMosSyoukaiOutputBean.setIwsDispcifcduktkid(mosKihon.getUktkid());
            }


            seihoWebMosSyoukaiOutputBean.setIwsDispsekno(mosKihon.getSekno());
            seihoWebMosSyoukaiOutputBean.setIwsDispykkigenymd(dateToStr(mosKihon.getPykkigenymd()));
            seihoWebMosSyoukaiOutputBean.setIwsDisphknnm01(kokyakuHknnsyuruiNm);
            seihoWebMosSyoukaiOutputBean.setIwsDisphknnm02(hknsyuruiNm);
            if (kykknNm.length() > 18) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkykknnm(kykknNm.substring(0, 18));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkykknnm(kykknNm);
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispkykkjnm(kykkjNm + "　様");
            seihoWebMosSyoukaiOutputBean.setIwsDispkykseiymd(dateToStr(kykseiYmd));

            if (kyksyanen2Keta > 99) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyksyanen2keta("99");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyksyanen2keta(mojiPad(String.valueOf(kyksyanen2Keta), " ", 2));
            }

            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                if (C_Hhknsei.MALE.eq(mosKihon.getHhknsei())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkyksei("男性");
                }
                else if (C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkyksei("女性");
                }
            }
            else {
                if (C_Kyksei.MALE.eq(mosKihon.getKyksei())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkyksei("男性");
                }
                else if (C_Kyksei.FEMALE.eq(mosKihon.getKyksei())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkyksei("女性");
                }
            }

            if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("被保険者本人");
            }
            else if (C_Tdk.HGU.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("配偶者");
            }
            else if (C_Tdk.OYA.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("親");
            }
            else if (C_Tdk.KO.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("子");
            }
            else if (C_Tdk.SHB.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("祖父母");
            }
            else if (C_Tdk.KYDSM.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("兄弟姉妹");
            }
            else if (C_Tdk.MAGO.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("孫");
            }
            else if (C_Tdk.SONOTA.eq(mosKihon.getKyktdk())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("その他");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktdk("未設定");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispkyktelno(mosKihon.getTsintelno());
            seihoWebMosSyoukaiOutputBean.setIwsDispkykyno(BizUtil.editYno(mosKihon.getTsinyno()));
            seihoWebMosSyoukaiOutputBean.setIwsDispkykadr01(mosKihon.getTsinadr1kj().concat(mosKihon.getTsinadr2kj()));
            seihoWebMosSyoukaiOutputBean.setIwsDispkykadr02(mosKihon.getTsinadr3kj());

            if (hhknknNm.length() > 18) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknknnm(hhknknNm.substring(0, 18));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknknnm(hhknknNm);
            }

            seihoWebMosSyoukaiOutputBean.setIwsDisphhknkjnm(hhknkjNm + "　様");
            seihoWebMosSyoukaiOutputBean.setIwsDisphhknseiymd(dateToStr(hhknseiYmd));

            if (hhknnen2Keta > 99) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknnen2keta("99");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknnen2keta(mojiPad(String.valueOf(hhknnen2Keta), " ",2));
            }

            if (C_Hhknsei.MALE.eq(mosKihon.getHhknsei())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknsei("男性");
            }
            else if (C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknsei("女性");
            }

            if(C_TsindousiteiKbn.BLNK.eq(mosKihon.getTsindousiteikbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknyno(BizUtil.editYno(mosKihon.getHhknyno()));

                seihoWebMosSyoukaiOutputBean.setIwsDisphhknadr01(mosKihon.getHhknadr1kj().concat(mosKihon.getHhknadr2kj()));
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknadr02(mosKihon.getHhknadr3kj());
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknyno("");

                seihoWebMosSyoukaiOutputBean.setIwsDisphhknadr01("契約者と同一");
                seihoWebMosSyoukaiOutputBean.setIwsDisphhknadr02("");
            }


            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispmosjk("成立");
            }
            else if (C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispmosjk("不成立");
            }
            else if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCTL.getKetteikbn()) &&
                C_UmuKbn.NONE.eq(syoriCTL.getKthhbkbn()) &&
                C_UmuKbn.NONE.eq(syoriCTL.getSrhhbkbn()) &&
                C_UmuKbn.NONE.eq(syoriCTL.getKhnhbkbn()) &&
                (C_HubikaisyoujoutaiKbn.BLNK.eq(syoriCTL.getHubikaisyoujoutaikbn()) ||
                    C_HubikaisyoujoutaiKbn.HUBIKAISYOUZUMI.eq(syoriCTL.getHubikaisyoujoutaikbn())) &&
                    (C_KykkakjkKbn.KAKUNIN_SUMI.eq(syoriCTL.getKykkakjkkbn()) ||
                        C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY.eq(syoriCTL.getKykkakjkkbn())) &&
                        C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())){
                seihoWebMosSyoukaiOutputBean.setIwsDispmosjk("入金勧奨");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispmosjk("未確定");
            }

            if (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) ||
                C_UmuKbn.ARI.eq(syoriCTL.getSrhhbkbn()) ||
                C_UmuKbn.ARI.eq(syoriCTL.getKhnhbkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphubijk("不備解消手続き中");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphubijk("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispmosymd(dateToStr(mosKihon.getMosymd()));

            if (C_SntkhouKbn.KKT.eq(mosKihon.getSntkhoukbn()) ||
                C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkokutiymd(dateToStr(syoriCTL.getKktymd()));
                seihoWebMosSyoukaiOutputBean.setIwsDispsinsahouhou("告知書扱");
            }
            else if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispsinsahouhou("無告知");
            }

            if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkeiyakuymd(dateToStr(mosKihon.getKykymd()));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkeiyakuymd("");
            }

            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispseirituymd(dateToStr(syoriCTL.getSrsyoriymd()));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispseirituymd("");
            }
            if (C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn())) {
                if (keijyouYm == null) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkeijyouymstr("");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispkeijyouymstr(String.valueOf(keijyouYm));
                }
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkeijyouymstr("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispsyoukenjk(syoukenjk);
            seihoWebMosSyoukaiOutputBean.setIwsDispsyoukensakuseiymd(syoSakuseiYmd);
            seihoWebMosSyoukaiOutputBean.setIwsDispsyoukenhakkouytiymd(syoukenHakkouYtiYmd);

            C_NyuukinjyoutaiKbn nyuukinjyoutaiKbn = syoriCTL.getNyuukinjoutaikbn();
            if (C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("未入金");
            }
            else if (C_NyuukinjyoutaiKbn.NYUUKINCHKMIRYOU.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("入金あり");
            }
            else if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("入金額が過剰です");
            }
            else if (C_NyuukinjyoutaiKbn.SEIRITUHORYUU_HUSOKUKIN.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("入金額が不足です");
            }
            else if (C_NyuukinjyoutaiKbn.MARUSIIKKATUYOU.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("一括入金が必要です");
            }
            else if (C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("入金あり");
            }
            else if (C_NyuukinjyoutaiKbn.YOSIN2KAGETUIKKATU.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("一括入金が必要です");
            }
            else if (C_NyuukinjyoutaiKbn.SYOUMETU.eq(nyuukinjyoutaiKbn)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkjk("入金あり");
            }

            int nyuukinLstNum = nyuukinLst.size();
            if (nyuukinLstNum >= 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkrirekidtlsuu("4");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispnkrirekidtlsuu(String.valueOf(nyuukinLstNum));
            }

            if (nyuukinLstNum > 0) {
                HT_Nyuukin nyuukin01 = nyuukinLst.get(0);
                String rsgakuComma = nyuukin01.getRsgaku().toFormatString();

                if (rsgakuComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku01(mojiPad(rsgakuComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku01("");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispryousyuuymd01(dateToStr(nyuukin01.getRyosyuymd()));
            }

            if (nyuukinLstNum > 1) {
                HT_Nyuukin nyuukin02 = nyuukinLst.get(1);
                String rsgakuComma = nyuukin02.getRsgaku().toFormatString();

                if (rsgakuComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku02(mojiPad(rsgakuComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku02("");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispryousyuuymd02(dateToStr(nyuukin02.getRyosyuymd()));
            }

            if (nyuukinLstNum > 2) {
                HT_Nyuukin nyuukin03 = nyuukinLst.get(2);
                String rsgakuComma = nyuukin03.getRsgaku().toFormatString();

                if (rsgakuComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku03(mojiPad(rsgakuComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku03("");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispryousyuuymd03(dateToStr(nyuukin03.getRyosyuymd()));
            }

            if (nyuukinLstNum > 3) {
                HT_Nyuukin nyuukin04 = nyuukinLst.get(3);
                String rsgakuComma = nyuukin04.getRsgaku().toFormatString();

                if (rsgakuComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku04(mojiPad(rsgakuComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispprsgaku04("");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispryousyuuymd04(dateToStr(nyuukin04.getRyosyuymd()));
            }

            int henkinLstNum = henkinLst.size();

            if (henkinLstNum >= 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnktyouseiniyudtlsuu("4");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispnktyouseiniyudtlsuu(String.valueOf(henkinLstNum));
            }

            if (henkinLstNum > 0) {
                HT_Henkin henkin01 = henkinLst.get(0);
                String hnkngkComma = henkin01.getHnkngk().toFormatString();

                if (hnkngkComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk01(mojiPad(hnkngkComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk01("");
                }

                if(henkin01.getHnknymd() != null) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou01("精算済");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou01("未精算");
                }
            }

            if (henkinLstNum > 1) {
                HT_Henkin henkin02 = henkinLst.get(1);
                String hnkngkComma = henkin02.getHnkngk().toFormatString();

                if (hnkngkComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk02(mojiPad(hnkngkComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk02("");
                }

                if (henkin02.getHnknymd() != null) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou02("精算済");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou02("未精算");
                }
            }

            if (henkinLstNum > 2) {
                HT_Henkin henkin03 = henkinLst.get(2);
                String hnkngkComma = henkin03.getHnkngk().toFormatString();

                if (hnkngkComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk03(mojiPad(hnkngkComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk03("");
                }

                if(henkin03.getHnknymd() != null) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou03("精算済");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou03("未精算");
                }
            }

            if (henkinLstNum > 3) {
                HT_Henkin henkin04 = henkinLst.get(3);
                String hnkngkComma = henkin04.getHnkngk().toFormatString();

                if (hnkngkComma.length() <= 14) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk04(mojiPad(hnkngkComma, " ", 14));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphnkngk04("");
                }

                if(henkin04.getHnknymd() != null) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou04("精算済");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispssnaiyou04("未精算");
                }
            }

            if (!C_IkkatubaraiKbn.BLNK.eq(mosKihon.getIkkatubaraikbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispiktkaisuu(mosKihon.getIkkatubaraikaisuu().getValue());
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispiktkaisuu("");
            }

            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {
                if (mosKihon.getZnnkai() + 1 > 99) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispznnkai("99");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispznnkai(String.valueOf(mosKihon.getZnnkai() + 1));
                }
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispznnkai("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispketteijk(ketteijk);
            seihoWebMosSyoukaiOutputBean.setIwsDispsinsatehaiinfokbn("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakuukeno("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakutehaijk("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakusinsahouhou("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakusindenzu("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakuketuekikensa("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai1kiboumd("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai1kiboutime("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai1kiboubasyo("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai1kibouadr("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai2kiboumd("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai2kiboutime("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai2kiboubasyo("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai2kibouadr("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai3kiboumd("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai3kiboutime("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai3kiboubasyo("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudai3kibouadr("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakuokyksmrenraku("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakubosyuutntrnrk("");
            seihoWebMosSyoukaiOutputBean.setIwsDispyoyakudoukoukibouyh("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiukeno("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaijk("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaikekka("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisinsahouhou("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisindenzu("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiketuekikensa("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyadtlsuu("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyacd01("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyanm01("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyacd02("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyanm02("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyacd03("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaisnssyanm03("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiyoteimd("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiyoteitime("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiyoteibasyo("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiyoteipostalcd("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaiyoteiadr("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaidksyatehaikekka("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaidksyakjsosikinm("");
            seihoWebMosSyoukaiOutputBean.setIwsDisptehaidksyakjnm("");

            int sbuktnin = mosKihon.getSbuktnin();
            if (sbuktnin > 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktdtlsuu("0");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktdtlsuu(String.valueOf(sbuktnin));
            }

            if (sbuktnin != 0) {
                if (C_UmuKbn.ARI.eq(syouhnZokusei.getSbhkuktumu())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktmds("死亡保険金受取人");
                }
                else if (C_UmuKbn.ARI.eq(syouhnZokusei.getSbkyuuhukinuktumu())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktmds("死亡給付金受取人");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktmds("");
                }

            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktmds("");
            }

            if (sbuktnin > 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnin(String.valueOf(sbuktnin));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnin("");
            }

            if (uketorininSibouLst.size() > 0) {
                HT_Uketorinin uketorinin01 = uketorininSibouLst.get(0);
                C_Tdk ukttdk01 = uketorinin01.getUkttdk();

                if(sbuktnin == 1 && C_UktKbn.KYK.eq(uketorinin01.getUktkbn())) {

                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm01("契約者と同じ");
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd01("");
                }
                else if(sbuktnin > 1 && C_UktKbn.KYK.eq(uketorinin01.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm01(kykkjNm);
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd01(dateToStr(kykseiYmd));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm01(uketorinin01.getUktnmkj());
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd01(dateToStr(uketorinin01.getUktseiymd()));
                }


                if(sbuktnin > 1 && C_UktKbn.KYK.eq(uketorinin01.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("契約者と同じ");
                }
                else if(sbuktnin == 1 && C_UktKbn.KYK.eq(uketorinin01.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("");
                }
                else if (C_Tdk.HGU.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("配偶者");
                }
                else if (C_Tdk.KO.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("子");
                }
                else if (C_Tdk.OYA.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("親");
                }
                else if (C_Tdk.MAGO.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("孫");
                }
                else if (C_Tdk.SHB.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("祖父母");
                }
                else if (C_Tdk.KYDSM.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("兄弟姉妹");
                }
                else if (C_Tdk.SONOTA.eq(ukttdk01)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("その他");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk01("未設定");
                }

                if(sbuktnin == 1) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktbnwari01("");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktbnwari01(String.valueOf(uketorinin01.getUktbnwari()));
                }
            }

            if (uketorininSibouLst.size() > 1) {
                HT_Uketorinin uketorinin02 = uketorininSibouLst.get(1);
                C_Tdk ukttdk02 = uketorinin02.getUkttdk();

                if(C_UktKbn.KYK.eq(uketorinin02.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm02(kykkjNm);
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd02(dateToStr(kykseiYmd));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm02(uketorinin02.getUktnmkj());
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd02(dateToStr(uketorinin02.getUktseiymd()));
                }

                if(C_UktKbn.KYK.eq(uketorinin02.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("契約者と同じ");
                }
                else if (C_Tdk.HGU.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("配偶者");
                }
                else if (C_Tdk.KO.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("子");
                }
                else if (C_Tdk.OYA.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("親");
                }
                else if (C_Tdk.MAGO.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("孫");
                }
                else if (C_Tdk.SHB.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("祖父母");
                }
                else if (C_Tdk.KYDSM.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("兄弟姉妹");
                }
                else if (C_Tdk.SONOTA.eq(ukttdk02)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("その他");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk02("未設定");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktbnwari02(String.valueOf(uketorinin02.getUktbnwari()));
            }

            if (uketorininSibouLst.size() > 2) {
                HT_Uketorinin uketorinin03 = uketorininSibouLst.get(2);
                C_Tdk ukttdk03 = uketorinin03.getUkttdk();

                if(C_UktKbn.KYK.eq(uketorinin03.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm03(kykkjNm);
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd03(dateToStr(kykseiYmd));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm03(uketorinin03.getUktnmkj());
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd03(dateToStr(uketorinin03.getUktseiymd()));
                }

                if(C_UktKbn.KYK.eq(uketorinin03.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("契約者と同じ");
                }
                else if (C_Tdk.HGU.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("配偶者");
                }
                else if (C_Tdk.KO.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("子");
                }
                else if (C_Tdk.OYA.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("親");
                }
                else if (C_Tdk.MAGO.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("孫");
                }
                else if (C_Tdk.SHB.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("祖父母");
                }
                else if (C_Tdk.KYDSM.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("兄弟姉妹");
                }
                else if (C_Tdk.SONOTA.eq(ukttdk03)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("その他");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk03("未設定");
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktbnwari03(String.valueOf(uketorinin03.getUktbnwari()));
            }

            if (uketorininSibouLst.size() > 3) {
                HT_Uketorinin uketorinin04 = uketorininSibouLst.get(3);
                C_Tdk ukttdk04 = uketorinin04.getUkttdk();

                if(C_UktKbn.KYK.eq(uketorinin04.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm04(kykkjNm);
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd04(dateToStr(kykseiYmd));
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktnm04(uketorinin04.getUktnmkj());
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbuktseiymd04(dateToStr(uketorinin04.getUktseiymd()));
                }

                if(C_UktKbn.KYK.eq(uketorinin04.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("契約者と同じ");
                }
                else if (C_Tdk.HGU.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("配偶者");
                }
                else if (C_Tdk.KO.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("子");
                }
                else if (C_Tdk.OYA.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("親");
                }
                else if (C_Tdk.MAGO.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("孫");
                }
                else if (C_Tdk.SHB.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("祖父母");
                }
                else if (C_Tdk.KYDSM.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("兄弟姉妹");
                }
                else if (C_Tdk.SONOTA.eq(ukttdk04)) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("その他");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispsbukttdk04("未設定");
                }
                seihoWebMosSyoukaiOutputBean.setIwsDispsbuktbnwari04(String.valueOf(uketorinin04.getUktbnwari()));
            }

            if (nkuktNin > 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktdtlsuu("0");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktdtlsuu(String.valueOf(nkuktNin));
            }

            if (nkuktNin != 0) {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktmds("年金受取人");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktmds("");
            }

            if (nkuktNin > 4) {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnin(String.valueOf(nkuktNin));
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnin("");
            }

            if (uketorininNenkinLst.size() > 0) {
                HT_Uketorinin uketorininnenkin = uketorininNenkinLst.get(0);
                C_Tdk uktTdk = uketorininnenkin.getUkttdk();

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    if (nkuktNin == 1) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm01("契約者と同じ");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm01(kykkjNm);
                    }
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    if (nkuktNin == 1) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm01("被保険者と同じ");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm01(hhknkjNm);
                    }
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm01(uketorininnenkin.getUktnmkj());
                }

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    if (nkuktNin == 1) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("契約者と同じ");
                    }
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    if (nkuktNin == 1) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("被保険者と同じ");
                    }
                }
                else {
                    if (C_Tdk.HGU.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("配偶者");
                    }
                    else if (C_Tdk.KO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("子");
                    }
                    else if (C_Tdk.OYA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("親");
                    }
                    else if (C_Tdk.MAGO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("孫");
                    }
                    else if (C_Tdk.SHB.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("祖父母");
                    }
                    else if (C_Tdk.KYDSM.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("兄弟姉妹");
                    }
                    else if (C_Tdk.SONOTA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("その他");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk01("未設定");
                    }
                }

                if (nkuktNin == 1) {

                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktbnwari01("");
                } else {

                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktbnwari01(String.valueOf(uketorininnenkin.getUktbnwari()));
                }
            }

            if (uketorininNenkinLst.size() > 1) {
                HT_Uketorinin uketorininnenkin = uketorininNenkinLst.get(1);
                C_Tdk uktTdk = uketorininnenkin.getUkttdk();

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm02(kykkjNm);
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm02(hhknkjNm);
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm02(uketorininnenkin.getUktnmkj());
                }

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("契約者と同じ");
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("被保険者と同じ");
                }
                else {
                    if (C_Tdk.HGU.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("配偶者");
                    }
                    else if (C_Tdk.KO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("子");
                    }
                    else if (C_Tdk.OYA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("親");
                    }
                    else if (C_Tdk.MAGO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("孫");
                    }
                    else if (C_Tdk.SHB.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("祖父母");
                    }
                    else if (C_Tdk.KYDSM.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("兄弟姉妹");
                    }
                    else if (C_Tdk.SONOTA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("その他");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk02("未設定");
                    }
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktbnwari02(String.valueOf(uketorininnenkin.getUktbnwari()));
            }

            if (uketorininNenkinLst.size() > 2) {
                HT_Uketorinin uketorininnenkin = uketorininNenkinLst.get(2);
                C_Tdk uktTdk = uketorininnenkin.getUkttdk();

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm03(kykkjNm);
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm03(hhknkjNm);
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm03(uketorininnenkin.getUktnmkj());
                }

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("契約者と同じ");
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("被保険者と同じ");
                }
                else {
                    if (C_Tdk.HGU.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("配偶者");
                    }
                    else if (C_Tdk.KO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("子");
                    }
                    else if (C_Tdk.OYA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("親");
                    }
                    else if (C_Tdk.MAGO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("孫");
                    }
                    else if (C_Tdk.SHB.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("祖父母");
                    }
                    else if (C_Tdk.KYDSM.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("兄弟姉妹");
                    }
                    else if (C_Tdk.SONOTA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("その他");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk03("未設定");
                    }
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktbnwari03(String.valueOf(uketorininnenkin.getUktbnwari()));
            }

            if (uketorininNenkinLst.size() > 3) {
                HT_Uketorinin uketorininnenkin = uketorininNenkinLst.get(3);
                C_Tdk uktTdk = uketorininnenkin.getUkttdk();

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm04(kykkjNm);
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm04(hhknkjNm);
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktnm04(uketorininnenkin.getUktnmkj());
                }

                if (C_UktKbn.KYK.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("契約者と同じ");
                }
                else if (C_UktKbn.HHKN.eq(uketorininnenkin.getUktkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("被保険者と同じ");
                }
                else {
                    if (C_Tdk.HGU.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("配偶者");
                    }
                    else if (C_Tdk.KO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("子");
                    }
                    else if (C_Tdk.OYA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("親");
                    }
                    else if (C_Tdk.MAGO.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("孫");
                    }
                    else if (C_Tdk.SHB.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("祖父母");
                    }
                    else if (C_Tdk.KYDSM.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("兄弟姉妹");
                    }
                    else if (C_Tdk.SONOTA.eq(uktTdk)) {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("その他");
                    }
                    else {
                        seihoWebMosSyoukaiOutputBean.setIwsDispmnkukttdk04("未設定");
                    }
                }

                seihoWebMosSyoukaiOutputBean.setIwsDispmnkuktbnwari04(String.valueOf(uketorininnenkin.getUktbnwari()));
            }

            seihoWebMosSyoukaiOutputBean.setIwsDisptoksiphokenkinuktnm("");
            seihoWebMosSyoukaiOutputBean.setIwsDispjdmnsihokenkinuktnm("");
            seihoWebMosSyoukaiOutputBean.setIwsDispstdrsknm(stdrskNm);

            if (C_Tdk.HGU.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("配偶者");
            }
            else if (C_Tdk.KO.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("子");
            }
            else if (C_Tdk.OYA.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("親");
            }
            else if (C_Tdk.MAGO.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("孫");
            }
            else if (C_Tdk.SHB.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("祖父母");
            }
            else if (C_Tdk.KYDSM.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("兄弟姉妹");
            }
            else if (C_Tdk.SINTOU3.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("３親等の親族");
            }
            else if (C_Tdk.SONOTA.eq(ukttdk)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("その他");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktdk("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispstkeisyouninmds("");
            seihoWebMosSyoukaiOutputBean.setIwsDispstkeisyouninnm("");
            seihoWebMosSyoukaiOutputBean.setIwsDispstkeisyounintdk("");
            seihoWebMosSyoukaiOutputBean.setIwsDispsetaitemosno(mosKihon.getAitemosno());
            seihoWebMosSyoukaiOutputBean.setIwsDispknhjnnm(ConvertUtil.toHanAll(mosKihon.getHjndainmkn(),0 ,1));
            seihoWebMosSyoukaiOutputBean.setIwsDispkjhjnnm(mosKihon.getHjndainmkj());

            if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon.getIkkatubaraikbn())) {
                if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())
                    && C_BlnktkumuKbn.ARI.eq(mosKihon.getZenkizennouumu())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphrkkaisuu("前納定期一括払");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisphrkkaisuu(mosKihon.getIkkatubaraikaisuu().getContent(
                        C_IkkatubaraiKaisuuKbn.PATTERN_TEIKI));
                }
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphrkkaisuu(mosKihon.getHrkkaisuu().getContent(
                    C_Hrkkaisuu.PATTERN_DISPKANANASI));
            }

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getItijibrumu())) {
                String dispHrkKeiro = mosKihon.getHrkkeiro().getContent(C_Hrkkeiro.PATTERN_DISPKANANASI);
                if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())
                    && C_YouhiblnkKbn.YOU.eq(kouzaJyouhou.getKouzakakuniniraikbn())) {
                    dispHrkKeiro = dispHrkKeiro + "（ＣＳＳ）";
                }
                seihoWebMosSyoukaiOutputBean.setIwsDisphrkkeiro(dispHrkKeiro);
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphrkkeiro("");
            }

            if (C_Livhukaumu.ARI.eq(mosKihon.getLivhukaumu())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisplivingneedstkyk("あり");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisplivingneedstkyk("");
            }

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getStdrsktkyhkkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktkyk("あり");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktkyk("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispnkshrtkyk(nkshrtkyk);

            if (C_DirectServiceMosKbn.ENTRY.eq(mosKihon.getDrctservicemoskbn()) ||
                C_DirectServiceMosKbn.CHECK.eq(mosKihon.getDrctservicemoskbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispdrctservicemosnai("加入（新規）");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispdrctservicemosnai("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispcardmosnai("");
            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
                || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn
                || SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphokenkngkmds("基準金額");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphokenkngkmds("保険金額");
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphknkknmds("年金支払開始");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphknkknmds("保険期間" );
            }

            seihoWebMosSyoukaiOutputBean.setIwsDisphokenkngk(dispHokenKngk);
            seihoWebMosSyoukaiOutputBean.setIwsDisphknkkn(hknKkn);
            seihoWebMosSyoukaiOutputBean.setIwsDisphokenryou(dispHokenRyou);
            seihoWebMosSyoukaiOutputBean.setIwsDisptkbtknjdtllinecnt("00");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari01("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari01("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi01("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi01("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari02("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari02("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi02("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi02("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari03("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari03("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi03("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi03("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari04("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari04("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi04("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi04("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari05("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari05("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi05("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi05("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari06("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari06("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi06("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi06("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari07("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari07("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi07("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi07("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari08("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari08("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi08("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi08("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari09("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari09("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi09("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi09("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmhidari10("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarihidari10("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundnmmigi10("");
            seihoWebMosSyoukaiOutputBean.setIwsDispfundwarimigi10("");
            seihoWebMosSyoukaiOutputBean.setIwsDisphrkkknmds("払込期間");
            seihoWebMosSyoukaiOutputBean.setIwsDisphrkkkn(dispHrkkkn);

            if (C_TargetTkHukaKanouKbn.NONE.eq(syouhnZokusei.getTargettkhukakanoukbn())) {

                seihoWebMosSyoukaiOutputBean.setIwsDispmkhyoututtosrsmosnai("");
            }
            else {

                if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {

                    if(C_TargetTkMokuhyoutiKbn.NOTARGET.eq(mosKihon.getTargettkmkhtkbn())){

                        seihoWebMosSyoukaiOutputBean.setIwsDispmkhyoututtosrsmosnai("設定なし");
                    }
                    else {

                        seihoWebMosSyoukaiOutputBean.setIwsDispmkhyoututtosrsmosnai(mosKihon.getTargettkmkhtkbn().getContent());
                    }
                }
                else {

                    seihoWebMosSyoukaiOutputBean.setIwsDispmkhyoututtosrsmosnai("申込なし");
                }
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispteikaiyakuhrkkn("");

            if (nyuukinLstNum > 0) {
                seihoWebMosSyoukaiOutputBean.setIwsDispprskngkutuktnikbn01(
                    henkanTuukaKbn(nyuukinLst.get(0).getRstuukasyu()));
            }
            if (nyuukinLstNum > 1) {
                seihoWebMosSyoukaiOutputBean.setIwsDispprskngkutuktnikbn02(
                    henkanTuukaKbn(nyuukinLst.get(1).getRstuukasyu()));
            }
            if (nyuukinLstNum > 2) {
                seihoWebMosSyoukaiOutputBean.setIwsDispprskngkutuktnikbn03(
                    henkanTuukaKbn(nyuukinLst.get(2).getRstuukasyu()));
            }
            if (nyuukinLstNum > 3) {
                seihoWebMosSyoukaiOutputBean.setIwsDispprskngkutuktnikbn04(
                    henkanTuukaKbn(nyuukinLst.get(3).getRstuukasyu()));
            }

            if (henkinLstNum > 0) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphnkngktuktnikbn01(
                    henkanTuukaKbn(henkinLst.get(0).getHnkntuukasyu()));
            }
            if (henkinLstNum > 1) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphnkngktuktnikbn02(
                    henkanTuukaKbn(henkinLst.get(1).getHnkntuukasyu()));
            }
            if (henkinLstNum > 2) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphnkngktuktnikbn03(
                    henkanTuukaKbn(henkinLst.get(2).getHnkntuukasyu()));
            }
            if (henkinLstNum > 3) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphnkngktuktnikbn04(
                    henkanTuukaKbn(henkinLst.get(3).getHnkntuukasyu()));
            }

            String henkanKyktuukasyu = henkanTuukaKbn(mosKihon.getKyktuukasyu());

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getTeikisiharaikinumu())) {
                if (C_Tkhukaumu.HUKA.eq(mosKihon.getYenshrtkhkkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisptkuktrknshrtuktnikbn("1");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisptkuktrknshrtuktnikbn(henkanKyktuukasyu);
                }

                seihoWebMosSyoukaiOutputBean.setIwsDisptkuktrknshrtukmds("定期受取金支払通貨");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisptkuktrknshrtuktnikbn("");
                seihoWebMosSyoukaiOutputBean.setIwsDisptkuktrknshrtukmds("");
            }

            String henkanHrktuukasyu = henkanTuukaKbn(mosKihon.getHrktuukasyu());

            seihoWebMosSyoukaiOutputBean.setIwsDisphrktuktnikbn(henkanHrktuukasyu);

            seihoWebMosSyoukaiOutputBean.setIwsDisphrktkyknm(dispHrktkykNm);
            seihoWebMosSyoukaiOutputBean.setIwsDisphrkgk(dispHrkgk);
            seihoWebMosSyoukaiOutputBean.setIwsDispkyktuktnikbn(henkanKyktuukasyu);
            seihoWebMosSyoukaiOutputBean.setIwsDispkwsratetekiymd(dateToStr(syoriCTL.getNyknkwsratekijyunymd()));
            seihoWebMosSyoukaiOutputBean.setIwsDispkwsratemdstuktnikbn(henkanHrktuukasyu);
            seihoWebMosSyoukaiOutputBean.setIwsDispkwsrate(mojiPad(String.valueOf(syoriCTL.getNyknkwsrate()), " ", 6));

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            if (!BizUtil.isBlank(dispHokenKngk) && hokenKngk != null
                && hokenKngk.compareTo(BizCurrency.valueOf(0, hokenKngk.getType())) != 0) {

                seihoWebMosSyoukaiOutputBean.setIwsDisphokenkngktuktnikbn(henkanTuukaKbn(
                    henkanTuuka.henkanTuukaTypeToKbn(hokenKngk.getType())));
            }
            else {

                seihoWebMosSyoukaiOutputBean.setIwsDisphokenkngktuktnikbn("");
            }

            if (!BizUtil.isBlank(dispHokenRyou) && hokenRyou != null
                && hokenRyou.compareTo(BizCurrency.valueOf(0, hokenRyou.getType())) != 0) {

                seihoWebMosSyoukaiOutputBean.setIwsDispptuktnikbn(henkanTuukaKbn(
                    henkanTuuka.henkanTuukaTypeToKbn(hokenRyou.getType())));
            }
            else {

                seihoWebMosSyoukaiOutputBean.setIwsDispptuktnikbn("");
            }

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
                if (C_TargetTkKbn.SYUUSIN.eq(mosKihon.getTargettkkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisptargettkyknm("（目標到達時円建終身保険変更特約）");
                }
                else if (C_TargetTkKbn.NENKIN.eq(mosKihon.getTargettkkbn())) {
                    seihoWebMosSyoukaiOutputBean.setIwsDisptargettkyknm("（目標到達時円建年金保険変更特約）");
                }
                else {
                    seihoWebMosSyoukaiOutputBean.setIwsDisptargettkyknm("");
                }
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisptargettkyknm("");
            }

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn &&
                C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDisphokensyuruino("326");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisphokensyuruino(mosKihon.getHknsyuruino().getValue());
            }

            if (!mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstitukhrktukditkbn("0");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispstitukhrktukditkbn("1");
            }

            if (C_UmuKbn.NONE.eq(syoriCTL.getNyknnrkumu())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispnyknzumihyouji("0");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispnyknzumihyouji("1");
            }

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getSyksbyensitihsyutkhkkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispSyksbyensitihsyutkyk("あり");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispSyksbyensitihsyutkyk("");
            }

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispJyudkaigomehrtkyk("あり");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispJyudkaigomehrtkyk("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispmkhgk(wkMokuhyougk);
            seihoWebMosSyoukaiOutputBean.setIwsDispkjnkngk(wkKijyungk);

            if(syouhnZokusei.getTargettkhukakanoukbn().eq(C_TargetTkHukaKanouKbn.YENSYUUSIN)){
                seihoWebMosSyoukaiOutputBean.setIwsDispkijyunkingakumds("基準金額");
            }else if (syouhnZokusei.getTargettkhukakanoukbn().eq(C_TargetTkHukaKanouKbn.YENNENKIN)) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkijyunkingakumds("円建基準金額");
            }else{
                seihoWebMosSyoukaiOutputBean.setIwsDispkijyunkingakumds("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispsueokikkn(sueokiKkn);
            seihoWebMosSyoukaiOutputBean.setIwsDispnenkinsyu(dispNenkinSyu);

            if (C_HknsyuruiNo.GAIKAINDEXNK_SISUU.eq(mosKihon.getHknsyuruino()) ||
                C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU.eq(mosKihon.getHknsyuruino())) {

                if (C_AisyoumeiKbn.GAIKAINDEXNK_SMBC.eq(mosKihon.getAisyoumeikbn()) ||
                    C_AisyoumeiKbn.GAIKAINDEXNK_20_SMBC.eq(mosKihon.getAisyoumeikbn())) {

                    seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("保険料の指数連動部分への充当割合１００％");
                }
                else {

                    seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("指数連動プラン（保険料の指数連動部分への充当割合１００％）");
                }
            }
            else if (C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU.eq(mosKihon.getHknsyuruino())) {

                seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("定率増加プラン（保険料の定率積立部分への充当割合１００％）");
            }
            else if (C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI.eq(mosKihon.getHknsyuruino())) {

                if (C_Tkhukaumu.NONE.eq(mosKihon.getTeikisiharaitkykhkkbn())) {

                    seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("定率増加プラン（保険料の定率積立部分への充当割合１００％）");
                }
                else if (C_Tkhukaumu.HUKA.eq(mosKihon.getTeikisiharaitkykhkkbn())) {

                    seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("定期支払プラン（保険料の定率積立部分への充当割合１００％）");
                }
                else {

                    seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("");
                }
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisptumitatekintypenm("");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDispsisuunm(sisuuNm);

            if (C_Tkhukaumu.HUKA.eq(mosKihon.getKjnnkpzeitekitkhukakbn())) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkjnnkpzeitekitk("あり");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkjnnkpzeitekitk("");
            }
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
                seihoWebMosSyoukaiOutputBean.setIwsDisppmds("円貨払込額");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDisppmds("保険料");
            }

            seihoWebMosSyoukaiOutputBean.setIwsDisptikiktbriyenhrkgk(dispTikiKtbriyenHrkgk);
            seihoWebMosSyoukaiOutputBean.setIwsDispznntikiktbriyenhrkgk(dispZnnTikiKtbriyenHrkgk);
            if (BizDateUtil.compareYmd(mosKihon.getMosymd(), YuyuSinkeiyakuConfig.getInstance().getHhkndairiTkykHukaYmd()) == BizDateUtil.COMPARE_LESSER) {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktkymds("指定代理請求特約");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispstdrsktkymds("被保険者代理特約");
            }
            seihoWebMosSyoukaiOutputBean.setIwsDispstdrskseiymd(dateToStr(uktseiymd));
            seihoWebMosSyoukaiOutputBean.setIwsDispkykdrtky(kykdrtky);
            seihoWebMosSyoukaiOutputBean.setIwsDispkykdrtkynm(kykdrtkynm);
            seihoWebMosSyoukaiOutputBean.setIwsDispkzktrkservice(kzktrkservice);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzk01(trkkzk01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkknnm01(trkkzkknnm01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkkjnm01(trkkzkkjnm01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkseiymd01(dateToStr(trkkzkseiymd01));
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzksei01(trkkzksei01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkyno01(trkkzkyno01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkadr1x01(trkkzkadr1x01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkadr2x01(trkkzkadr2x01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzktelno01(trkkzktelno01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzktdk01(trkkzktdk01);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzk02(trkkzk02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkknnm02(trkkzkknnm02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkkjnm02(trkkzkkjnm02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkseiymd02(dateToStr(trkkzkseiymd02));
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzksei02(trkkzksei02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkyno02(trkkzkyno02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkadr1x02(trkkzkadr1x02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzkadr2x02(trkkzkadr2x02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzktelno02(trkkzktelno02);
            seihoWebMosSyoukaiOutputBean.setIwsDisptrkkzktdk02(trkkzktdk02);
            seihoWebMosSyoukaiOutputBean.setIwsDispsioriyakkansearchcd(mosKihon.getYakkanbunsyono());
            seihoWebMosSyoukaiOutputBean.setIwsDispyakkanjyuryouhou(mosKihon.getYakkanjyuryouhoukbn().getContent(
                C_YakkanJyuryouKbn.PATTERN_DISP));
            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktuktnikbnmidasi("選択通貨");
            }
            else {
                seihoWebMosSyoukaiOutputBean.setIwsDispkyktuktnikbnmidasi("指定通貨");
            }
            seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("00");
            seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.IGC1001));

            try {
                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            logger.debug("△ 生保Ｗｅｂ申込状況照会 終了");

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsHbSeihoWebMosSyoukaiOutputBean seihoWebMosSyoukaiOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebMosSyoukaiOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            seihoWebMosSyoukaiOutputBean.setIwsMosno(wkMosno);

            seihoWebMosSyoukaiOutputBean.setIwsMossyoukaierrkbn("02");
            seihoWebMosSyoukaiOutputBean.setIwsErrormsgv40(MessageUtil.getMessage(MessageId.EGC1002));

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosSyoukaiOutputBean));

            return wsBzWebserviceResParamBean;

        }
    }

    private String henkanTuukaKbn(C_Tuukasyu pTuukasyu) {

        String tuukasyu = "";

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            tuukasyu = "1";
        }
        else if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            tuukasyu = "2";
        }
        else if (C_Tuukasyu.EUR.eq(pTuukasyu)) {

            tuukasyu = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukasyu)) {

            tuukasyu = "4";
        }
        else {

            tuukasyu = "0";
        }

        return tuukasyu;
    }

    private String mojiPad(String pObject, String pPadStr, int pMaxLength) {

        if (pObject.length() >= pMaxLength) {

            return pObject;
        }

        int padStrNum = pMaxLength - pObject.length();

        int count = 0;
        String padAfter = "";

        while (count < padStrNum) {
            padAfter = padAfter.concat(pPadStr);

            count++;
        }

        padAfter = padAfter.concat(pObject);

        return padAfter;
    }

    private String dateToStr(BizDate pDate) {
        if (pDate == null) {
            return "";
        }

        return pDate.toString();
    }

    private String creatErrorMsg(
        String syoriNm,
        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean) {

        String errUserMsg = syoriNm.concat(":【オペレータＩＤ ＝ ")
            .concat(wsBzWebserviceReqParamBean.getOperatorId())
            .concat(", 事務単位コード ＝ ")
            .concat(wsBzWebserviceReqParamBean.getOrgCode() + "】 ");

        return errUserMsg;
    }

}
