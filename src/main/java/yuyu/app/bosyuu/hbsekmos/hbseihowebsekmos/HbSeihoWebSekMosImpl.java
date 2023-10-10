package yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.exception.CvtVdtException.Message;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCalcable.Signum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageBuilder;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.dba.HbSeihoWebSekMosImplDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuKekkaBean;
import yuyu.common.biz.bzdairiten.DairitenTsrSyutokuYokenBean;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.hozen.khcommon.KeisanPJyuutougk;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkKykTmttkn;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.sinkeiyaku.moschk.CheckSP;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusan;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhin;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumoku;
import yuyu.common.sinkeiyaku.moschk.SetSP;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetSinkeiyakuGuidance;
import yuyu.common.sinkeiyaku.skcommon.GetSinkeiyakuGuidanceOutBean;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosOutputBean;
import yuyu.def.bosyuu.configuration.YuyuBosyuuConfig;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infrext.mq.RayWebServiceAuthInfo;

import com.google.common.base.Strings;

/**
 * 生保Ｗｅｂ設計書申込書作成サービスの実装クラスです。<br />
 */
public class HbSeihoWebSekMosImpl implements HbSeihoWebSekMos {

    private static final int RIRITUKIRIKAEBI_1 = 1;

    private static final int RIRITUKIRIKAEBI_16 = 16;

    private static final String DRTENREPORTGYOUTAIKBN_SMBC = "1";

    private static final String DRTENREPORTGYOUTAIKBN_TIGIN = "2";

    private static final String DRTENREPORTGYOUTAIKBN_SINKIN = "3";

    private static final String DRTENREPORTGYOUTAIKBN_DIRECT = "4";

    private static final String DRTENREPORTGYOUTAIKBN_MARUKIN = "5";

    private static final String DRTENREPORTGYOUTAIKBN_SMTB = "6";

    private static final String DRTENREPORTGYOUTAIKBN_GAISANTIGIN = "7";

    private static final String DRTENREPORTGYOUTAIKBN_GAISANSINKIN = "8";

    private static final String DRTENREPORTGYOUTAIKBN_SONOTAMADOHAN = "9";

    private static final String DRTENREPORTGYOUTAIKBN_YUUSEIGINKOU = "A";

    private static final String DRTENREPORTGYOUTAIKBN_YUUSEIKAISYA = "B";

    private static final String DRTENREPORTGYOUTAIKBN_UUSEIKANPO = "C";

    private static final String DRTENREPORTGYOUTAIKBN_SHOPMDHN = "D";

    private static final String DRTENREPORTGYOUTAIKBN_MIZUHO = "E";

    private static final String SKGUIDANCESKSHYJ_HUYOU  = "0";

    private static final String SKGUIDANCESKSHYJ_YOU  = "1";

    private static final String SYKSBYENSITIHSYUTKYKHYJ_HUKA  = "1";

    private static final String TIKSHRTKYKHYJ_HUKA  = "1";

    private static final String HRKSIKINNRKHYJ_ARI = "1";

    private static final String DAI1HKNKKN_SITEITUUKA_YOU = "1";

    private C_Sdpd sdpdKbn;

    private C_HaitouKbn haitouKbn;

    private C_HknkknsmnKbn hknkknsmnKbn;

    private C_Tdk kykTdkKbn;

    private C_Tdk uktTdk1;

    private C_Tdk uktTdk2;

    private C_Tdk uktTdk3;

    private C_Tdk uktTdk4;

    private C_Tdk uktTdk5;

    private C_Tuukasyu kyktuukasyu;

    private int syohinHanteiKbn;

    private BizDate mosYmd;

    private C_HknsyuruiNo hknsyuruiNo = C_HknsyuruiNo.BLNK;

    private String hrktuukasyutkp;

    private String gaikaHrktuukasyutkp;

    private String mostuukakbn;

    private C_Tuukasyu mostuukasyu;

    private BizNumber zennouwrbkrt;

    @Inject
    private static Logger logger;

    @Inject
    private RayWebServiceAuthInfo rayWebAuthInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    @Inject
    private MessageBuilder messageBuilder;

    @Inject
    private HbSeihoWebSekMosImplDao hbSeihoWebSekMosImplDao;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {
            logger.debug("▽ 生保Ｗｅｂ設計書申込書作成 開始");

            HT_SyoriCTL syoriCTL = SWAKInjector.getInstance(HT_SyoriCTL.class);
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
            BzGetBsInfoBean bzGetBsInfoBeanA = SWAKInjector.getInstance(BzGetBsInfoBean.class);
            BzGetBsInfoBean bzGetBsInfoBeanB = SWAKInjector.getInstance(BzGetBsInfoBean.class);
            List<BzGetAgInfoBean> bzGetAgInfoBeanALst = new ArrayList<>();
            List<BzGetAgInfoBean> bzGetAgInfoBeanBLst = new ArrayList<>();
            boolean drtenTesuuryouKekka = true;
            GetSinkeiyakuGuidanceOutBean guidanceOutBean = SWAKInjector.getInstance(GetSinkeiyakuGuidanceOutBean.class);
            WsHbSeihoWebSekMosOutputBean seihoWebSekMosOutputBean = SWAKInjector.getInstance(WsHbSeihoWebSekMosOutputBean.class);
            initOutputBean(seihoWebSekMosOutputBean);
            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
                SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);


            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebSekMosInputBean seihoWebSekMosInputBean;
            try {
                seihoWebSekMosInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebSekMosInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    CvtVdtException cvtVdtException = (CvtVdtException)e.getCause();

                    Message[] cvtMessage = cvtVdtException.getMessages();

                    List<String> koumokuNms = getKoumoku(cvtMessage);
                    String message = makeMessage(koumokuNms);

                    return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(), message, "");
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, seihoWebSekMosInputBean);

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsKyknm())){
                seihoWebSekMosInputBean.setIwsKyknm(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsKyknm(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsHhknnm())){
                seihoWebSekMosInputBean.setIwsHhknnm(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsHhknnm(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsUktnm1())){
                seihoWebSekMosInputBean.setIwsUktnm1(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsUktnm1(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsUktnm2())){
                seihoWebSekMosInputBean.setIwsUktnm2(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsUktnm2(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsUktnm3())){
                seihoWebSekMosInputBean.setIwsUktnm3(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsUktnm3(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsUktnm4())){
                seihoWebSekMosInputBean.setIwsUktnm4(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsUktnm4(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsUktnm5())){
                seihoWebSekMosInputBean.setIwsUktnm5(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsUktnm5(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsKzkknnm1())){
                seihoWebSekMosInputBean.setIwsKzkknnm1(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsKzkknnm1(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsKzkknnm2())){
                seihoWebSekMosInputBean.setIwsKzkknnm2(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsKzkknnm2(), 1, 1));
            }

            if(!Strings.isNullOrEmpty(seihoWebSekMosInputBean.getIwsHhkndrknnm())){
                seihoWebSekMosInputBean.setIwsHhkndrknnm(ConvertUtil.toZenAll(seihoWebSekMosInputBean.getIwsHhkndrknnm(), 1, 1));
            }

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen = SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);
            C_SeihowebkengenKbn seihowebkengenKbn =
                hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn)) {

                return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGA1006, "端末権限"), "");
            }
            else if (C_SeihowebkengenKbn.SIYOUSHAERROR.eq(seihowebkengenKbn)) {

                return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGA1006, "使用者権限"), "");
            }

            rayWebAuthInfo.setSosikiCd(wsBzWebserviceReqParamBean.getOrgCode());
            rayWebAuthInfo.setOperatorId(wsBzWebserviceReqParamBean.getOperatorId());

            String mosNo = uniqueKeyGenerator.generateUniqueKey();

            WsBzWebserviceResParamBean webserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            checkSeigousei(seihoWebSekMosInputBean, seihoWebSekMosOutputBean);

            if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(seihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {

                webserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebSekMosOutputBean));

                logger.debug("△ 生保Ｗｅｂ設計書申込書作成 終了");

                return webserviceResParamBean;
            }

            mosYmd = seihoWebSekMosInputBean.getIwsSyoriymd();

            hknsyuruiNo = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(
                seihoWebSekMosInputBean.getIwsHknsyuruino());

            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(
                    hknsyuruiNo, mosYmd);

            if (skHokenSyuruiNoLst.size() == 0) {
                logger.error(creatErrorMsg("保険種類番号マスタ取得　0件" , wsBzWebserviceReqParamBean));

                return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGC1002), "");
            }

            HM_SkHokenSyuruiNo skHokenSyuruiNo = skHokenSyuruiNoLst.get(0);

            C_UmuKbn syksbyensitihsyutkykhyj = C_UmuKbn.NONE;

            if (SYKSBYENSITIHSYUTKYKHYJ_HUKA.equals(seihoWebSekMosInputBean.getIwsSyksbyensitihsyutkykhyj())){
                syksbyensitihsyutkykhyj = C_UmuKbn.ARI;

            }

            C_Sknenkinsyu skNenkinSyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan(
                seihoWebSekMosInputBean.getIwsNksyukbn());

            C_UmuKbn teikishrkinUmu = C_UmuKbn.NONE;

            if (TIKSHRTKYKHYJ_HUKA.equals(seihoWebSekMosInputBean.getIwsTeikisiharaitkarihyj())) {
                teikishrkinUmu = C_UmuKbn.ARI;
            }

            kyktuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(seihoWebSekMosInputBean.getIwsKyktuukakbn());

            String syouhnHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(hknsyuruiNo);

            List<BM_SyouhnZokusei> syouhnZokuseiLst = new ArrayList<>();

            if (DAI1HKNKKN_SITEITUUKA_YOU.equals(syouhnHantei)) {

                syouhnZokuseiLst =
                    bizDomManager.getSyouhnZokuseisByKykymdItems(
                        seihoWebSekMosInputBean.getIwsNrkcalckijyunymd(),
                        C_SyutkKbn.SYU,
                        skHokenSyuruiNo.getDaihyouhknsyuruino(),
                        Integer.valueOf(0),
                        Integer.valueOf(seihoWebSekMosInputBean.getIwsHknkkn1()),
                        kyktuukasyu,
                        syksbyensitihsyutkykhyj,
                        skNenkinSyu,
                        teikishrkinUmu);
            }
            else {

                syouhnZokuseiLst =
                    bizDomManager.getSyouhnZokuseisByKykymdItems2(
                        seihoWebSekMosInputBean.getIwsNrkcalckijyunymd(),
                        C_SyutkKbn.SYU,
                        skHokenSyuruiNo.getDaihyouhknsyuruino(),
                        0,
                        syksbyensitihsyutkykhyj,
                        skNenkinSyu,
                        teikishrkinUmu);
            }

            if (syouhnZokuseiLst.size() == 0) {
                logger.debug("商品属性マスタ取得　0件");

                return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGA1006, "保険種類番号"), "");
            }

            BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

            syohinHanteiKbn = SyouhinUtil.hantei(syouhnZokusei.getSyouhncd());

            C_SeihowebsousasyaKbn seihowebsousasyaKbn = hbSeihoWebHanteiKengen.getSeihowebUserKbn(
                wsBzWebserviceReqParamBean, seihoWebSekMosInputBean.getIwsAatukaikojincd());

            if (C_SeihowebsousasyaKbn.DIRTNBSYNN.eq(seihowebsousasyaKbn)) {

                BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                bzGetBsInfoBeanA = bzGetBsInfo.exec(seihoWebSekMosInputBean.getIwsAatukaikojincd());
                if (bzGetBsInfoBeanA == null) {
                    return creatResponseError(C_SekmossakuseiErroutKbn.ERRORSHEET.getValue(),
                        MessageUtil.getMessage(MessageId.EGA1006, "Ａ担当者コード"), "");
                }

                bzGetAgInfoBeanALst = bzGetAgInfo.exec(bzGetBsInfoBeanA.getDairiten1Cd());
                if (bzGetAgInfoBeanALst.size() == 0) {
                    return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                        MessageUtil.getMessage(MessageId.EGA1006, "Ａ担当者組織コード"), "");
                }

                if (!"000000".equals(seihoWebSekMosInputBean.getIwsBatukaikojincd())) {

                    bzGetBsInfoBeanB = bzGetBsInfo.exec(seihoWebSekMosInputBean.getIwsBatukaikojincd());
                    if (bzGetBsInfoBeanB == null) {
                        return creatResponseError(C_SekmossakuseiErroutKbn.ERRORSHEET.getValue(),
                            MessageUtil.getMessage(MessageId.EGA1006, "Ｂ担当者コード"), "");
                    }

                    bzGetAgInfoBeanBLst = bzGetAgInfo.exec(bzGetBsInfoBeanB.getDairiten1Cd());
                    if (bzGetAgInfoBeanBLst.size() == 0) {
                        return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                            MessageUtil.getMessage(MessageId.EGA1006, "Ｂ担当者組織コード"), "");
                    }
                }
            }

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {

                hrktuukasyutkp  = seihoWebSekMosInputBean.getIwsHrktuukakihonp();
                gaikaHrktuukasyutkp = seihoWebSekMosInputBean.getIwsGaikahrktuukakihonp();
                mostuukakbn = seihoWebSekMosInputBean.getIwsHrktuukakbn();

            }
            else {

                hrktuukasyutkp  = seihoWebSekMosInputBean.getIwsKihonpstr();
                gaikaHrktuukasyutkp = seihoWebSekMosInputBean.getIwsGaikakihonpstr();
                mostuukakbn = seihoWebSekMosInputBean.getIwsKyktuukakbn();
            }

            mostuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(mostuukakbn);

            syoriCTL.setMosno(mosNo);
            syoriCTL.setMosuketukekbn(C_MosUketukeKbn.SEIHOWEB);

            BizPropertyInitializer.initialize(syoriCTL);

            editMosKihon(syoriCTL, syouhnZokusei, skHokenSyuruiNo, seihoWebSekMosInputBean);
            editMosDairiten(syoriCTL, bzGetAgInfoBeanALst, 1, bzGetBsInfoBeanA.getBosyuuTrkNo());
            if (!"000000".equals(seihoWebSekMosInputBean.getIwsBatukaikojincd())) {
                editMosDairiten(syoriCTL, bzGetAgInfoBeanBLst, 2, bzGetBsInfoBeanB.getBosyuuTrkNo());
            }
            editUketorinin(syoriCTL, seihoWebSekMosInputBean);
            editStdrskUketorinin(syoriCTL, seihoWebSekMosInputBean);
            editKykdrnUketorinin(syoriCTL, seihoWebSekMosInputBean);
            editMosTrkKzk(syoriCTL, seihoWebSekMosInputBean);

            HT_MosSyouhn mosSyouhn0 = syoriCTL.createMosSyouhn();
            HT_MosKihon mosKihon0 = syoriCTL.getMosKihon();
            editMosSyouhn(mosSyouhn0, mosKihon0, syouhnZokusei, seihoWebSekMosInputBean);
            BizPropertyInitializer.initialize(mosSyouhn0);

            if (HRKSIKINNRKHYJ_ARI.equals(seihoWebSekMosInputBean.getIwsHrksikinnrkhyj())) {
                SkZennouIkkatuUtil skZennouIkkatuUtil = SWAKInjector.getInstance(SkZennouIkkatuUtil.class);
                String kiteiChkOyaAgCd = null;
                BizCurrency haraikomipOrg = null;
                BizCurrency haraikomiSikin = BizCurrency.valueOf(new BigDecimal(seihoWebSekMosInputBean.getIwsHrksikin()),
                    BizCurrencyTypes.YEN);
                BizCurrency hoseiTukiharaiP = null;
                BizCurrency mosfstpkei = null;

                if (bzGetAgInfoBeanALst.size() > 0) {
                    for (BzGetAgInfoBean bzGetAgInfoBeanA : bzGetAgInfoBeanALst) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBeanA.getDiritenJyouhouKbn())) {
                            kiteiChkOyaAgCd = bzGetAgInfoBeanA.getOyadrtenCd();
                            break;
                        }
                    }
                }
                else {
                    kiteiChkOyaAgCd = getOyadrtencdSyanaiUser(seihoWebSekMosInputBean.getIwsOyadrtencd(),
                        seihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn());
                }

                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(mosKihon0.getIkkatubaraikbn())) {

                    haraikomipOrg = skZennouIkkatuUtil.getHaraikomiPTanni(syouhnZokusei.getSyouhncd(),
                        syouhnZokusei.getSyouhnsdno(), C_Hrkkaisuu.TUKI, null, kiteiChkOyaAgCd, C_Tuukasyu.JPY);

                    if (C_UmuKbn.ARI.eq(mosKihon0.getZennoumousideumu())) {

                        hoseiTukiharaiP = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(mosKihon0.getKykymd(),
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            true, null, kiteiChkOyaAgCd, mosKihon0.getZnnkai()+1, haraikomiSikin);

                        mosfstpkei = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg(true,
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            mosKihon0.getKykymd(), hoseiTukiharaiP, haraikomipOrg, mosKihon0.getZnnkai()+1, 0);

                        mosKihon0.setMosheijyunp(hoseiTukiharaiP);
                        mosKihon0.setMosfstpkei(mosfstpkei);
                        mosSyouhn0.setHrktuukasyutkp(hoseiTukiharaiP);
                    }
                    else {

                        hoseiTukiharaiP = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen(
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            true, null, kiteiChkOyaAgCd, mosKihon0.getIkkatubaraikaisuu(), haraikomiSikin);

                        mosfstpkei = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg(true,
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            hoseiTukiharaiP, haraikomipOrg, mosKihon0.getIkkatubaraikaisuu(), 0);

                        mosKihon0.setMosheijyunp(hoseiTukiharaiP);
                        mosKihon0.setMosfstpkei(mosfstpkei);
                        mosSyouhn0.setHrktuukasyutkp(hoseiTukiharaiP);
                    }
                }
                else {
                    haraikomipOrg = skZennouIkkatuUtil.getHaraikomiPTanni(syouhnZokusei.getSyouhncd(),
                        syouhnZokusei.getSyouhnsdno(), mosKihon0.getHrkkaisuu(), null, kiteiChkOyaAgCd, mosKihon0.getKyktuukasyu());

                    if (C_UmuKbn.ARI.eq(mosKihon0.getZennoumousideumu())) {

                        hoseiTukiharaiP = skZennouIkkatuUtil.getInRangeNenbaraiPSpecifiedZennouP(mosKihon0.getKykymd(),
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            true, null, kiteiChkOyaAgCd, mosKihon0.getZnnkai()+1, haraikomiSikin);

                        mosfstpkei = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg(true,
                            syouhnZokusei.getSyouhncd(), syouhnZokusei.getSyouhnsdno(), syouhnZokusei.getRyouritusdno(),
                            mosKihon0.getKykymd(), hoseiTukiharaiP, haraikomipOrg, mosKihon0.getZnnkai()+1, 0);

                        mosKihon0.setMosheijyunp(hoseiTukiharaiP);
                        mosKihon0.setMosfstpkei(mosfstpkei);
                        mosSyouhn0.setHrktuukasyutkp(hoseiTukiharaiP);
                    }
                }
            }

            editMosnaiCheckParam(mosnaiCheckParam, syoriCTL, seihoWebSekMosInputBean, seihowebsousasyaKbn);


            SeihowebMosnaiCheck seihowebMosnaiCheck = SWAKInjector.getInstance(SeihowebMosnaiCheck.class);

            try {

                seihowebMosnaiCheck.exec(mosnaiCheckParam);
            } catch(Exception e) {
                errHukaMsg = creatErrorMsg("申込内容チェックエラー" , wsBzWebserviceReqParamBean);
                throw e;

            }

            if (!C_SekmossakuseiErroutKbn.NONE.eq(mosnaiCheckParam.getSekmossakuseiErroutKbn())) {
                webserviceResParamBean = creatResponseError(
                    mosnaiCheckParam.getSekmossakuseiErroutKbn().getValue(),
                    mosnaiCheckParam.getSekmossakuseiErrmsg1(),
                    mosnaiCheckParam.getSekmossakuseiErrmsg2());

                return webserviceResParamBean;
            }


            String aOyadrtencd = null;
            if (!C_SeihowebsousasyaKbn.DIRTNBSYNN.eq(seihowebsousasyaKbn)) {

                if (DRTENREPORTGYOUTAIKBN_SMBC.equals(seihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {
                    aOyadrtencd = YuyuBizConfig.getInstance().getSmbcOyadrtencd();
                } else {
                    aOyadrtencd = "0000000";
                }
            }
            else {
                aOyadrtencd = mosnaiCheckParam.getDataSyoriControl().getMosDairitens().get(0).getOyadrtencd();
            }

            aOyadrtencd = hbSeihoWebHanteiKengen.convDairiten(wsBzWebserviceReqParamBean, aOyadrtencd);

            aOyadrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(seihoWebSekMosInputBean, aOyadrtencd);

            DairitenTesuuryouInfoSyutokuKekkaBean dairitenKekkaBean = null;

            HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
            HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
            DairitenTesuuryouInfoSyutoku dairitenTesuuryouInfoSyutoku =
                SWAKInjector.getInstance(DairitenTesuuryouInfoSyutoku.class);
            DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean =
                SWAKInjector.getInstance(DairitenTsrSyutokuYokenBean.class);


            BizNumber yenKnsnTekiRate = BizNumber.valueOf(
                new BigDecimal(seihoWebSekMosInputBean.getIwsNyknkwsrateyen())).divide(100);

            dairitenTsrSyutokuYokenBean.setOyaDrtenCd(aOyadrtencd);
            dairitenTsrSyutokuYokenBean.setSyouhnCd(mosSyouhn.getSyouhncd());
            dairitenTsrSyutokuYokenBean.setRyourituSdNo(mosSyouhn.getRyouritusdno());
            dairitenTsrSyutokuYokenBean.setHrkKaisuu(mosKihon.getHrkkaisuu());
            dairitenTsrSyutokuYokenBean.setSaimankiKeiyakuHyouji(mosSyouhn.getHknkknsmnkbn().getValue());
            dairitenTsrSyutokuYokenBean.setHhknNen(mosKihon.getHhknnen().toString());
            dairitenTsrSyutokuYokenBean.setHknKkn(mosSyouhn.getHknkkn());
            dairitenTsrSyutokuYokenBean.setpHaraikomiKikan(mosSyouhn.getHrkkkn());
            dairitenTsrSyutokuYokenBean.setSyuKeiyakuP(mosSyouhn.getSyutkp());
            dairitenTsrSyutokuYokenBean.setDrtenTsryHushrKykHyouji(mosKihon.getTsryhshrkykumukbn().getValue());
            dairitenTsrSyutokuYokenBean.setYenKnsnTekiRate(yenKnsnTekiRate);
            dairitenTsrSyutokuYokenBean.setSyuKeiyakuPTuukaSyu(mosKihon.getKyktuukasyu());
            dairitenTsrSyutokuYokenBean.setYoteiRiritu(mosSyouhn.getYoteiriritu());
            dairitenTsrSyutokuYokenBean.setCalckijyunymd(seihoWebSekMosInputBean.getIwsNrkcalckijyunymd());

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {
                dairitenTsrSyutokuYokenBean.setHrktuukasyu(mosKihon.getHrktuukasyu());
                dairitenTsrSyutokuYokenBean.setSyupHrktuuka(mosSyouhn.getHrktuukasyutkp());
            }
            else {
                dairitenTsrSyutokuYokenBean.setHrktuukasyu(mosKihon.getKyktuukasyu());
                dairitenTsrSyutokuYokenBean.setSyupHrktuuka(mosSyouhn.getSyutkp());
            }

            dairitenTsrSyutokuYokenBean.setIkkatubaraikbn(mosKihon.getIkkatubaraikbn());
            dairitenTsrSyutokuYokenBean.setIkkatubaraikaisuu(mosKihon.getIkkatubaraikaisuu());
            dairitenTsrSyutokuYokenBean.setKihonnS(mosSyouhn.getSeitoukihons());

            try {

                dairitenKekkaBean = dairitenTesuuryouInfoSyutoku.exec(dairitenTsrSyutokuYokenBean, null);
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("代理店手数料取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            if (C_MQSyorikekkaKbn.ERROR.eq(dairitenKekkaBean.getMqSyoriKekkaKbn()) ||
                C_ErrorKbn.ERROR.eq(dairitenKekkaBean.getTsrSisanKekkaKbn()) ||
                C_ErrorKbn.ERROR.eq(dairitenKekkaBean.getAcsKibanKekkaKbn())) {
                drtenTesuuryouKekka = false;

                logger.debug("代理店手数料取得取得　エラー");
            }

            BizDate drtnskYuukouKigenYmd = getDrtnskYuukouKigenYmd(mosnaiCheckParam, syouhnZokusei,
                seihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn());

            if ((C_SekmossakuseiKbn.SEKKEISYO.eq(mosnaiCheckParam.getSekmossakuseiKbn()) ||
                C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.eq(mosnaiCheckParam.getSekmossakuseiKbn()) ||
                C_SekmossakuseiKbn.MOUSIKOMISYO.eq(mosnaiCheckParam.getSekmossakuseiKbn())) &&
                SKGUIDANCESKSHYJ_YOU.equals(seihoWebSekMosInputBean.getIwsSkguidanceskshyj()) ) {

                GetSinkeiyakuGuidance getSinkeiyakuGuidance = SWAKInjector.getInstance(GetSinkeiyakuGuidance.class);
                guidanceOutBean = getSinkeiyakuGuidance.exec(mosnaiCheckParam);
            }

            BizNumber sjkkkTyouseiyouRiritu = BizNumber.ZERO;

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getMvatekiumu())) {

                C_ErrorKbn sjkkkTyouseiyouRirituErrorKbn = C_ErrorKbn.ERROR;

                try {

                    getSjkkktyouseiyourirituBean.setSyouhncd(mosSyouhn.getSyouhncd());
                    getSjkkktyouseiyourirituBean.setKijyunymd(null);
                    getSjkkktyouseiyourirituBean.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                    getSjkkktyouseiyourirituBean.setKykymd(mosKihon.getKykymd());
                    getSjkkktyouseiyourirituBean.setHknkkn(mosSyouhn.getHknkkn());
                    getSjkkktyouseiyourirituBean.setHknkknsmnkbn(mosSyouhn.getHknkknsmnkbn());
                    getSjkkktyouseiyourirituBean.setHhknnen(mosKihon.getHhknnen());

                    sjkkkTyouseiyouRirituErrorKbn = getSjkkktyouseiyouriritu.execKykji(getSjkkktyouseiyourirituBean);
                    sjkkkTyouseiyouRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();

                } catch(Exception e) {
                    errHukaMsg = creatErrorMsg("市場価格調整用利率取得エラー" , wsBzWebserviceReqParamBean);

                    throw e;

                }

                if (C_ErrorKbn.ERROR.eq(sjkkkTyouseiyouRirituErrorKbn)) {
                    logger.error(creatErrorMsg("市場価格調整用利率マスタ取得　0件" , wsBzWebserviceReqParamBean));

                    return creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                        MessageUtil.getMessage(MessageId.EGC1002), "");
                }
            }

            BizNumber wkPhireialpha = BizNumber.ZERO;

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

                KeisanPJyuutougk keisanPJyuutougk = SWAKInjector.getInstance(KeisanPJyuutougk.class);

                C_ErrorKbn errorKbn = keisanPJyuutougk.exec(mosSyouhn.getSyutkp(), mosSyouhn.getHrktuukasyutkp(),
                    mosKihon.getHhknnen(), mosSyouhn.getHrkkkn(), mosSyouhn.getHrkkknsmnkbn(), mosKihon.getKykymd(),
                    mosKihon.getKykymd().getBizDateYM());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    creatErrorMsg("Ｐ比例α取得エラー", wsBzWebserviceReqParamBean);
                }

                wkPhireialpha = keisanPJyuutougk.getYoteiSinkeiyakuhiRitu();
            }

            zennouwrbkrt = BizNumber.ZERO;

            if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

                    List<BM_ZennouRiritu2> zennouGenkaRitu2Lst = hbSeihoWebSekMosImplDao.getZennouRiritu2(
                        mosKihon.getKyktuukasyu(), mosKihon.getKykymd());

                    if (zennouGenkaRitu2Lst.size() == 0) {

                        errHukaMsg = creatErrorMsg("前納利率マスタ２取得　0件" , wsBzWebserviceReqParamBean);

                        logger.error(errHukaMsg);

                        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                            creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                                MessageUtil.getMessage(MessageId.EGC1002), "");

                        return wsBzWebserviceResParamBean;
                    }

                    zennouwrbkrt = zennouGenkaRitu2Lst.get(0).getZennouriritu();
                }
            }

            editResponseSeijou(
                seihoWebSekMosOutputBean,
                seihoWebSekMosInputBean,
                guidanceOutBean,
                bzGetBsInfoBeanA,
                bzGetAgInfoBeanALst,
                dairitenKekkaBean,
                syoriCTL,
                drtnskYuukouKigenYmd,
                drtenTesuuryouKekka,
                sjkkkTyouseiyouRiritu,
                wkPhireialpha,
                mosnaiCheckParam,
                syouhnZokusei
                );

            BizCurrency gaikasisans = BizCurrency.valueOf(0);

            if ((C_SekmossakuseiKbn.SEKKEISYO.eq(mosnaiCheckParam.getSekmossakuseiKbn()) ||
                C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.eq(mosnaiCheckParam.getSekmossakuseiKbn())) &&
                C_UmuKbn.ARI.eq(syksbyensitihsyutkykhyj)) {



                gaikasisans = BizCurrency.valueOf(new BigDecimal("9999999999999"));

                List<BM_SyouhnZokusei> syouhnZokuseiLst1 = null;

                try {

                    if (DAI1HKNKKN_SITEITUUKA_YOU.equals(syouhnHantei)) {

                        syouhnZokuseiLst1 =
                            bizDomManager.getSyouhnZokuseisByKykymdItems(
                                seihoWebSekMosInputBean.getIwsNrkcalckijyunymd(),
                                C_SyutkKbn.SYU,
                                skHokenSyuruiNo.getDaihyouhknsyuruino(),
                                Integer.valueOf(0),
                                mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0).getDai1hknkkn(),
                                mosnaiCheckParam.getDataSyoriControl().getMosKihon().getKyktuukasyu(),
                                C_UmuKbn.NONE,
                                mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0).getSknenkinsyu(),
                                teikishrkinUmu);
                    }
                    else {

                        syouhnZokuseiLst1 =
                            bizDomManager.getSyouhnZokuseisByKykymdItems2(
                                seihoWebSekMosInputBean.getIwsNrkcalckijyunymd(),
                                C_SyutkKbn.SYU,
                                skHokenSyuruiNo.getDaihyouhknsyuruino(),
                                0,
                                C_UmuKbn.NONE,
                                mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0).getSknenkinsyu(),
                                teikishrkinUmu);
                    }

                } catch(Exception e) {
                    errHukaMsg = creatErrorMsg("設計書比較用外貨基本Ｓエラー" , wsBzWebserviceReqParamBean);

                    throw e;

                }

                if (syouhnZokuseiLst1.size() != 0) {
                    BM_SyouhnZokusei syouhnZokusei1 = syouhnZokuseiLst1.get(0);


                    HT_MosKihon mosKihon1 = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon1.getKyktuukasyu());
                    CurrencyType hrkCurrencyType = henkanTuuka.henkanTuukaKbnToType(mosKihon1.getHrktuukasyu());
                    mosKihon1.setSeitoufstpkei(BizCurrency.valueOf(0, kykCurrencyType));
                    mosKihon1.setFstphrkgk(BizCurrency.valueOf(0, hrkCurrencyType));
                    mosKihon1.setHyouteip(BizCurrency.valueOf(0, kykCurrencyType));
                    mosKihon1.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);

                    HT_MosSyouhn mosSyouhn1 = mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0);
                    editMosSyouhn(mosSyouhn1, mosKihon1, syouhnZokusei1, seihoWebSekMosInputBean);
                    mosSyouhn1.setSeitoukihons(BizCurrency.valueOf(0, kykCurrencyType));
                    mosSyouhn1.setSyutkp(BizCurrency.valueOf(0, kykCurrencyType));
                    mosSyouhn1.setTkjyp(BizCurrency.valueOf(0, kykCurrencyType));

                    SetKisoKoumoku setKisoKoumoku = SWAKInjector.getInstance(SetKisoKoumoku.class);
                    setKisoKoumoku.exec(mosnaiCheckParam);

                    CheckTblMosSyouhin checkTblMosSyouhin = SWAKInjector.getInstance(CheckTblMosSyouhin.class);
                    checkTblMosSyouhin.exec(mosnaiCheckParam);

                    if (C_SekmossakuseiErroutKbn.NONE.eq(mosnaiCheckParam.getSekmossakuseiErroutKbn())) {
                        SetSP setSP = SWAKInjector.getInstance(SetSP.class);
                        setSP.exec(mosnaiCheckParam);

                        CheckSP checkSP = SWAKInjector.getInstance(CheckSP.class);
                        checkSP.exec(mosnaiCheckParam);

                        CheckSkTuusan checkSkTuusan =  SWAKInjector.getInstance(CheckSkTuusan.class);
                        checkSkTuusan.exec(mosnaiCheckParam);

                        if (C_Tuukasyu.JPY.eq(mosKihon1.getKyktuukasyu())) {
                            gaikasisans = mosSyouhn1.getSeitoukihons();
                        }
                        else {
                            gaikasisans = mosSyouhn1.getSeitoukihons().multiply(100);
                        }
                    }
                }
            }

            seihoWebSekMosOutputBean.setIwsGaikasisankihons(BizNumber.valueOf(gaikasisans));

            try {
                webserviceResParamBean = creatResponseSeijou(seihoWebSekMosOutputBean);
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            return webserviceResParamBean;
        }
        catch (Exception e) {
            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGC1002), "");

            return wsBzWebserviceResParamBean;
        }
    }

    private List<String> getKoumoku(Message[] pMsgs) {

        List<String> koumokuNms = new ArrayList<>();

        for (int i = 0; i < pMsgs.length; i++) {

            String wkMsg = pMsgs[i].getMessage();

            int begin = wkMsg.indexOf(":") + 1;

            int end = wkMsg.indexOf(" ", begin);

            String koumokuNm = wkMsg.substring(begin, end);

            koumokuNms.add(koumokuNm);
        }
        return koumokuNms;
    }

    private String makeMessage(List<String> pKoumokuNms) {

        Map<String, String[]> messageMap = new HashMap<String, String[]>();

        messageMap.put("iwsSekmossakuseikbn", new String[] {MessageId.EGA1006, "作成区分", "34"});
        messageMap.put("iwsSekmoswebsyorikbn", new String[] {MessageId.EGA1006, "設計書申込書ＷＥＢ処理区分", "35"});
        messageMap.put("iwsDrtentyouhyougyoutaikbn", new String[] {MessageId.EGA1006, "代理店帳票用業態区分", "36"});
        messageMap.put("iwsSkguidanceskshyj", new String[] {MessageId.EGA1006, "新契約ガイダンス作成表示", "37"});
        messageMap.put("iwsAatukaikojincd", new String[] {MessageId.EGA1006, "Ａ扱者個人コード", "38"});
        messageMap.put("iwsBatukaikojincd", new String[] {MessageId.EGA1006, "Ｂ扱者個人コード", "39"});
        messageMap.put("iwsKyknm", new String[] {MessageId.EGA1006, "契約者名", "1"});
        messageMap.put("iwsKjkyknm11", new String[] {MessageId.EGA1006, "漢字契約者名", "2"});
        messageMap.put("iwsTsintelno", new String[] {MessageId.EGA1018, "", "3"});
        messageMap.put("iwsTuusinsakijyuusyokbn", new String[] {MessageId.EGA1006, "通信先住所区分", "4"});
        messageMap.put("iwsTsinyno",  new String[] {MessageId.EGA1006, "通信先郵便番号", "5"});
        messageMap.put("iwsKanjitsinkaiadr", new String[] {MessageId.EGA1006, "漢字通信先下位住所", "6"});
        messageMap.put("iwsHhknnm", new String[] {MessageId.EGA1006, "被保険者名", "7"});
        messageMap.put("iwsKjhhknnm11", new String[] {MessageId.EGA1006, "漢字被保険者名", "8"});
        messageMap.put("iwsHhknseiymd", new String[] {MessageId.EGA1006, "被保険者生年月日", "9"});
        messageMap.put("iwsHhknyno", new String[] {MessageId.EGA1006, "被保険者郵便番号", "10"});
        messageMap.put("iwsHhknkaiadr", new String[] {MessageId.EGA1006, "被保険者下位住所", "11"});
        messageMap.put("iwsUktkbn1", new String[] {MessageId.EGA1006, "受取人区分", "12"});
        messageMap.put("iwsUktkbn2", new String[] {MessageId.EGA1006, "受取人区分", "12"});
        messageMap.put("iwsUktkbn3", new String[] {MessageId.EGA1006, "受取人区分", "12"});
        messageMap.put("iwsUktkbn4", new String[] {MessageId.EGA1006, "受取人区分", "12"});
        messageMap.put("iwsUktkbn5", new String[] {MessageId.EGA1006, "受取人区分", "12"});
        messageMap.put("iwsUktnm1", new String[] {MessageId.EGA1006, "受取人名", "13"});
        messageMap.put("iwsUktnm2", new String[] {MessageId.EGA1006, "受取人名", "13"});
        messageMap.put("iwsUktnm3", new String[] {MessageId.EGA1006, "受取人名", "13"});
        messageMap.put("iwsUktnm4", new String[] {MessageId.EGA1006, "受取人名", "13"});
        messageMap.put("iwsUktnm5", new String[] {MessageId.EGA1006, "受取人名", "13"});
        messageMap.put("iwsKjuktnm1", new String[] {MessageId.EGA1006, "漢字受取人名", "14"});
        messageMap.put("iwsKjuktnm2", new String[] {MessageId.EGA1006, "漢字受取人名", "14"});
        messageMap.put("iwsKjuktnm3", new String[] {MessageId.EGA1006, "漢字受取人名", "14"});
        messageMap.put("iwsKjuktnm4", new String[] {MessageId.EGA1006, "漢字受取人名", "14"});
        messageMap.put("iwsKjuktnm5", new String[] {MessageId.EGA1006, "漢字受取人名", "14"});
        messageMap.put("iwsUkttdkkbn1", new String[] {MessageId.EGA1006, "受取人続柄区分", "15"});
        messageMap.put("iwsUkttdkkbn2", new String[] {MessageId.EGA1006, "受取人続柄区分", "15"});
        messageMap.put("iwsUkttdkkbn3", new String[] {MessageId.EGA1006, "受取人続柄区分", "15"});
        messageMap.put("iwsUkttdkkbn4", new String[] {MessageId.EGA1006, "受取人続柄区分", "15"});
        messageMap.put("iwsUkttdkkbn5", new String[] {MessageId.EGA1006, "受取人続柄区分", "15"});
        messageMap.put("iwsHknsyuruino", new String[] {MessageId.EGA1006, "保険種類番号", "16"});
        messageMap.put("iwsHknkkn1", new String[] {MessageId.EGA1006, "第１保険期間", "17"});
        messageMap.put("iwsNyknkwsrateyen", new String[] {MessageId.EGA1006, "入金用為替レート円", "18"});
        messageMap.put("iwsNyknkwsrategk", new String[] {MessageId.EGA1006, "入金用為替レート外貨", "19"});
        messageMap.put("iwsKihonsstr", new String[] {MessageId.EGA1006, "基本Ｓ", "20"});
        messageMap.put("iwsGaikakihonsstr", new String[] {MessageId.EGA1006, "外貨基本Ｓ", "21"});
        messageMap.put("iwsKihonpstr", new String[] {MessageId.EGA1006, "申込主契約Ｐ", "58"});
        messageMap.put("iwsGaikakihonpstr", new String[] {MessageId.EGA1006, "外貨申込主契約Ｐ", "59"});
        messageMap.put("iwsHrktuukakihonp", new String[] {MessageId.EGA1006, "申込主契約Ｐ", "22"});
        messageMap.put("iwsGaikahrktuukakihonp", new String[] {MessageId.EGA1006, "外貨申込主契約Ｐ", "23"});
        messageMap.put("iwsHknkkn", new String[] {MessageId.EGA1006, "保険期間", "24"});
        messageMap.put("iwsPharaikomikikan", new String[] {MessageId.EGA1006, "Ｐ払込期間", "25"});
        messageMap.put("iwsZennoukkn", new String[] {MessageId.EGA1006, "前納期間", "26"});
        messageMap.put("iwsTargettkarihyj", new String[] {MessageId.EGA1006, "ターゲット特約有表示", "27"});
        messageMap.put("iwsTargettksyuruikbn", new String[] {MessageId.EGA1006, "ターゲット特約種類区分", "28"});
        messageMap.put("iwsTargettkmkht", new String[] {MessageId.EGA1006, "ターゲット特約目標値", "29"});
        messageMap.put("iwsJyudkaigomehrtkarihyj", new String[] {MessageId.EGA1006, "重度介護前払特約有表示", "30"});
        messageMap.put("iwsSyksbyensitihsyutkykhyj", new String[] {MessageId.EGA1006, "初期死亡時円換算最低保証特約有表示", "31"});
        messageMap.put("iwsTksykmcd1", new String[] {MessageId.EGA1006, "特殊項目コード", "32"});
        messageMap.put("iwsTksykmcd2", new String[] {MessageId.EGA1006, "特殊項目コード", "32"});
        messageMap.put("iwsTksykmcd3", new String[] {MessageId.EGA1006, "特殊項目コード", "32"});
        messageMap.put("iwsTksykmcd4", new String[] {MessageId.EGA1006, "特殊項目コード", "32"});
        messageMap.put("iwsTksykmcd5", new String[] {MessageId.EGA1006, "特殊項目コード", "32"});
        messageMap.put("iwsSyoriymd", new String[] {MessageId.EGA1006, "処理年月日", "33"});
        messageMap.put("iwsOyadrtencd", new String[] {MessageId.EGA1006, "親代理店コード", "40"});
        messageMap.put("iwsSueokikkn", new String[] {MessageId.EGA1006, "据置期間", "41"});
        messageMap.put("iwsNksyukbn", new String[] {MessageId.EGA1006, "年金種類区分", "42"});
        messageMap.put("iwsSisuurendouhbnwr", new String[] {MessageId.EGA1006, "指数連動部分配分割合", "43"});
        messageMap.put("iwsTeiritutumitatehbnwr", new String[] {MessageId.EGA1006, "定率積立部分配分割合", "44"});
        messageMap.put("iwsIkkatubaraikbn", new String[] { MessageId.EGA1006, "一括払区分", "45" });
        messageMap.put("iwsIkkatubaraikaisuu", new String[] { MessageId.EGA1006, "一括払回数", "46" });
        messageMap.put("iwsZennouhyouji", new String[] { MessageId.EGA1006, "前納表示", "47" });
        messageMap.put("iwsHrksikin", new String[] { MessageId.EGA1006, "払込資金", "48"});
        messageMap.put("iwsHrksikinnrkhyj", new String[] { MessageId.EGA1006, "払込資金入力有表示", "49"});
        messageMap.put("iwsKzkknnm1", new String[] { MessageId.EGA1006, "ご家族カナ氏名", "50"});
        messageMap.put("iwsKzkknnm2", new String[] { MessageId.EGA1006, "ご家族カナ氏名", "50"});
        messageMap.put("iwsKzkkjnm1", new String[] { MessageId.EGA1006, "ご家族漢字氏名", "51"});
        messageMap.put("iwsKzkkjnm2", new String[] { MessageId.EGA1006, "ご家族漢字氏名", "51"});
        messageMap.put("iwsKzkyno1", new String[] { MessageId.EGA1006, "ご家族郵便番号", "52"});
        messageMap.put("iwsKzkyno2", new String[] { MessageId.EGA1006, "ご家族郵便番号", "52"});
        messageMap.put("iwsKzkadr1", new String[] { MessageId.EGA1006, "ご家族住所", "53"});
        messageMap.put("iwsKzkadr2", new String[] { MessageId.EGA1006, "ご家族住所", "53"});
        messageMap.put("iwsHhkndrtdkkbn", new String[] { MessageId.EGA1006, "被代理続柄区分", "54"});
        messageMap.put("iwsHhkndrknnm", new String[] { MessageId.EGA1006, "被代理カナ氏名", "55"});
        messageMap.put("iwsHhkndrkjnm", new String[] { MessageId.EGA1006, "被代理漢字氏名", "56"});
        messageMap.put("iwsTeikisiharaitkarihyj", new String[] { MessageId.EGA1006, "定期支払特約有表示", "57"});
        messageMap.put("iwsNyskaihihyj", new String[] { MessageId.EGA1006, "名寄せ回避表示", "60"});

        String[] taisyouHairetu = null;
        int wkNum = 99;

        for(String koumokuNm : pKoumokuNms) {
            String[] msgHairetu = messageMap.get(koumokuNm);

            if(Integer.parseInt(msgHairetu[2]) < wkNum) {

                wkNum = Integer.parseInt(msgHairetu[2]);
                taisyouHairetu = msgHairetu;
            }
        }

        if (BizUtil.isBlank(taisyouHairetu[1])) {

            return MessageUtil.getMessage(taisyouHairetu[0]);
        }

        return MessageUtil.getMessage(taisyouHairetu[0], taisyouHairetu[1]);
    }

    private void initOutputBean(WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.NONE.getValue());
        pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1("");
        pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

        pSeihoWebSekMosOutputBean.setIwsYoteikykymd(BizDate.valueOf("00000000"));
        pSeihoWebSekMosOutputBean.setIwsDairitensekykkigenymd(BizDate.valueOf("00000000"));
        pSeihoWebSekMosOutputBean.setIwsHhknnen(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSbs(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasbs(BizNumber.ZERO);


        pSeihoWebSekMosOutputBean.setIwsKihons(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikakihons(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSyupn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasyup(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSyokaiharaikomip(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasyokaiharaikomip(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsNextharaikomip(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikanextharaikomip(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsHrktuukasyukykp(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyukykp(BizNumber.ZERO);

        pSeihoWebSekMosOutputBean.setIwsHrktuukasyokaihrkp(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyokaihrkp(BizNumber.ZERO);


        pSeihoWebSekMosOutputBean.setIwsHrktuukanexthrkp(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikahrktuukanexthrkp(BizNumber.ZERO);

        pSeihoWebSekMosOutputBean.setIwsikkatup(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsZennoup(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikazennoup(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsTargetyenknsnp(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsTargettokuyakumkhgk(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsHendouknrtumitateriritu(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSjkkktyusirrtfgu(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSjkkktyouseiriritu(BizNumber.ZERO);

        pSeihoWebSekMosOutputBean.setIwsBsyutrkno("");
        pSeihoWebSekMosOutputBean.setIwsDirtnbosyuuninkanji("");
        pSeihoWebSekMosOutputBean.setIwsBosyuudairitennm("");
        pSeihoWebSekMosOutputBean.setIwsKinyuukikancd("");
        pSeihoWebSekMosOutputBean.setIwsTsrycd("");
        pSeihoWebSekMosOutputBean.setIwsDrtentsryshrkaisuu(BizNumber.ZERO);

        pSeihoWebSekMosOutputBean.setIwsDrtenshrfsttsry(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikadrtenshrfsttsry(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGkdrtenshrfsttsrytukkbn("");
        pSeihoWebSekMosOutputBean.setIwsDrtenshrkztsry(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikadrtenshrkztsry(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGkdrtenshrkztsrytukkbn("");

        pSeihoWebSekMosOutputBean.setIwsSyotsryruigkn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasyotsryruigk(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasyotsrytuukakbn("0");

        pSeihoWebSekMosOutputBean.setIwsNitsryruigkn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikanitsryruigkn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikanitsrytuukakbn("0");


        pSeihoWebSekMosOutputBean.setIwsSougktsryn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasougktsry(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikasougktsrytuukakbn("0");

        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd01("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd02("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd03("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd04("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd05("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd06("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd07("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd08("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd09("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd10("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd11("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd12("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd13("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd14("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd15("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd16("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd17("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd18("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd19("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd20("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd21("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd22("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd23("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd24("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd25("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd26("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd27("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd28("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd29("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd30("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd31("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd32("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd33("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd34("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd35("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd36("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd37("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd38("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd39("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd40("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd41("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd42("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd43("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd44("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd45("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd46("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd47("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd48("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd49("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd50("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd51("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd52("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd53("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd54("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd55("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd56("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd57("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd58("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd59("");
        pSeihoWebSekMosOutputBean.setIwsHtysyoruicd60("");
        pSeihoWebSekMosOutputBean.setIwsGaikasisankihons(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsKnsnkanouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsNngndkkkanouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsMnstskanouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsSyktkikanouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsSyaikanouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsSndnzknsyouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsKtekknsyouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsKnsnsysndnzyou("0");
        pSeihoWebSekMosOutputBean.setIwsKnsnketuekikensayouhyj("0");
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu1(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu2(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu3(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu4(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu5(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsTumitateriritu(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsSetteibairitu(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsTmttknzkrtjygn(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsNayosehumeikbn("0");
        pSeihoWebSekMosOutputBean.setIwsSisuurendoup(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsTeiritutumitatep(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsPwaribikirankkbn("0");
        pSeihoWebSekMosOutputBean.setIwsTumitateriritu2(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsRendouritu(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsGaikateikisiharaigk(BizNumber.ZERO);
        pSeihoWebSekMosOutputBean.setIwsZennouwrbkrt(BizNumber.ZERO);
    }

    private void editMosKihon(HT_SyoriCTL pSyoriCTL, BM_SyouhnZokusei pSyouhnZokusei,
        HM_SkHokenSyuruiNo pSkHokenSyuruiNo, WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
        HT_MosKihon mosKihon = pSyoriCTL.createMosKihon();

        mosKihon.setMosymd(mosYmd);

        if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsNrkcalckijyunymd().toString())) {
            mosKihon.setKykymd(pSeihoWebSekMosInputBean.getIwsNrkcalckijyunymd());
        }

        mosKihon.setKykkbn(editSeihoWebRenkeiKoumoku.kykkbnkyktdkkbnHenkan(pSeihoWebSekMosInputBean.getIwsKyktdkkbn()));
        mosKihon.setHknsyuruino(hknsyuruiNo);
        mosKihon.setHknsyuruinosd(pSkHokenSyuruiNo.getHknsyuruinosd());
        mosKihon.setKzktourokuservicetourokukbn(editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan(pSeihoWebSekMosInputBean.getIwsKzktrkmoskbn()));
        mosKihon.setKykdrtkykhukakbn(editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan(pSeihoWebSekMosInputBean.getIwsDrtkkbn()));
        mosKihon.setStdrsktkyhkkbn(editSeihoWebRenkeiKoumoku.hhkdrtkykhukakbnHenkan(pSeihoWebSekMosInputBean.getIwsDrtkkbn()));
        mosKihon.setSdpdkbn(sdpdKbn);
        mosKihon.setSntkhoukbn(editSeihoWebRenkeiKoumoku.sntkhouKbnsyokugyouHenkan(
            pSeihoWebSekMosInputBean.getIwsHjkktkbn(), pSyouhnZokusei));
        mosKihon.setHaitoukbn(haitouKbn);
        mosKihon.setHaitoukinuketorihoukbn(editSeihoWebRenkeiKoumoku.haitoukinuketorihoukbnHenkan(
            pSeihoWebSekMosInputBean.getIwsHtkinuthoukbn()));
        mosKihon.setKyktuukasyu(kyktuukasyu);
        mosKihon.setHrktuukasyu(editSeihoWebRenkeiKoumoku.tuukasyuHenkan(pSeihoWebSekMosInputBean.getIwsHrktuukakbn()));

        if (!C_Tuukasyu.BLNK.eq(mosKihon.getHrktuukasyu()) &&
            !C_Tuukasyu.BLNK.eq(mosKihon.getKyktuukasyu())) {
            if (!mosKihon.getHrktuukasyu().eq(mosKihon.getKyktuukasyu())) {
                if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                    mosKihon.setYennykntkhkkbn(C_Tkhukaumu.HUKA);
                }
                else {
                    mosKihon.setGaikanykntkhkkbn(C_Tkhukaumu.HUKA);
                }
            }
            else {
                mosKihon.setYennykntkhkkbn(C_Tkhukaumu.NONE);
                mosKihon.setGaikanykntkhkkbn(C_Tkhukaumu.NONE);
            }
        }

        mosKihon.setMosheijyunp(editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
            pSeihoWebSekMosInputBean.getIwsHaraikomikaisuukbn(),
            mostuukakbn,
            Long.valueOf(hrktuukasyutkp), Long.valueOf(gaikaHrktuukasyutkp)));

        mosKihon.setIkkatubaraikbn(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(
            pSeihoWebSekMosInputBean.getIwsIkkatubaraikbn()));

        mosKihon.setIkkatubaraikaisuu(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(
            pSeihoWebSekMosInputBean.getIwsIkkatubaraikaisuu()));

        mosKihon.setMosikkatup(BizCurrency.valueOf(new BigDecimal(0)));

        mosKihon.setZennoumousideumu(editSeihoWebRenkeiKoumoku.huho2GetZennoumousideumu(
            pSeihoWebSekMosInputBean.getIwsZennouhyouji()));

        mosKihon.setZenkizennouumu(editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
            pSyouhnZokusei.getZenkizennoutekiumu(),
            pSeihoWebSekMosInputBean.getIwsZennouhyouji()));

        mosKihon.setZnnkai(editSeihoWebRenkeiKoumoku.huho2GetZnnkai(
            Integer.parseInt(pSeihoWebSekMosInputBean.getIwsZennoukkn())));

        mosKihon.setMoszennoupsyokaiari(BizCurrency.valueOf(new BigDecimal(0)));


        if (C_Tuukasyu.JPY.eq(mostuukasyu)) {
            mosKihon.setMosfstpkei(BizCurrency.valueOf(new BigDecimal(hrktuukasyutkp)));
        }
        else {
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(mostuukasyu);
            mosKihon.setMosfstpkei(BizCurrency.valueOf(new BigDecimal(
                gaikaHrktuukasyutkp).divide(new BigDecimal(100)), currencyType));
        }

        mosKihon.setHrkkaisuu(editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(
            pSeihoWebSekMosInputBean.getIwsHaraikomikaisuukbn()));
        mosKihon.setHrkkeiro(editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(
            pSeihoWebSekMosInputBean.getIwsHrkkeirokbn()));
        mosKihon.setFstphrkkeirokbn(editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(
            pSeihoWebSekMosInputBean.getIwsHaraikomikaisuukbn(), pSeihoWebSekMosInputBean.getIwsHrkkeirokbn(),
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn()));
        mosKihon.setHhknnmkn(pSeihoWebSekMosInputBean.getIwsHhknnm());
        mosKihon.setHhknnmkj(pSeihoWebSekMosInputBean.getIwsKjhhknnm11());
        mosKihon.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);

        if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsHhknseiymd().toString())) {
            mosKihon.setHhknseiymd(pSeihoWebSekMosInputBean.getIwsHhknseiymd());
        }

        mosKihon.setHhknsei(editSeihoWebRenkeiKoumoku.hhknseiHenkan(pSeihoWebSekMosInputBean.getIwsHhknseikbn()));
        mosKihon.setHhknyno(pSeihoWebSekMosInputBean.getIwsHhknyno());
        mosKihon.setHhknadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(pSeihoWebSekMosInputBean.getIwsHhknkaiadr()));
        mosKihon.setHhknadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(pSeihoWebSekMosInputBean.getIwsHhknkaiadr()));
        mosKihon.setHhknadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(pSeihoWebSekMosInputBean.getIwsHhknkaiadr()));

        if (!C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
            mosKihon.setKyknmkn(pSeihoWebSekMosInputBean.getIwsKyknm());
            mosKihon.setKyknmkj(pSeihoWebSekMosInputBean.getIwsKjkyknm11());
            mosKihon.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);

            if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsKyksyaseiymd().toString())) {
                mosKihon.setKykseiymd(pSeihoWebSekMosInputBean.getIwsKyksyaseiymd());
            }

            mosKihon.setKyksei(editSeihoWebRenkeiKoumoku.kykseiHenkan(pSeihoWebSekMosInputBean.getIwsKyksyaseikbn()));
            mosKihon.setKyktdk(kykTdkKbn);
        }

        mosKihon.setTsinyno(pSeihoWebSekMosInputBean.getIwsTsinyno());
        mosKihon.setTsinadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(pSeihoWebSekMosInputBean.getIwsKanjitsinkaiadr()));
        mosKihon.setTsinadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(pSeihoWebSekMosInputBean.getIwsKanjitsinkaiadr()));
        mosKihon.setTsinadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(pSeihoWebSekMosInputBean.getIwsKanjitsinkaiadr()));
        mosKihon.setTsintelno(pSeihoWebSekMosInputBean.getIwsTsintelno());


        if (!C_TargetTkHukaKanouKbn.NONE.eq(pSyouhnZokusei.getTargettkhukakanoukbn())) {
            if ("1".equals(pSeihoWebSekMosInputBean.getIwsTargettkarihyj())) {
                mosKihon.setTargettkhkkbn(C_Tkhukaumu.HUKA);
            }
            else {
                mosKihon.setTargettkhkkbn(C_Tkhukaumu.NONE);
            }
        }
        else {
            mosKihon.setTargettkhkkbn(C_Tkhukaumu.BLNK);
        }

        mosKihon.setTargettkkbn(editSeihoWebRenkeiKoumoku.targettkkbnSyutoku(pSeihoWebSekMosInputBean.getIwsTargettksyuruikbn()));

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsTargettkarihyj())) {

            if ("000".equals(pSeihoWebSekMosInputBean.getIwsTargettkmkht())) {
                mosKihon.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
            }
            else {
                mosKihon.setTargettkmkhtkbn(editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(
                    Integer.valueOf(pSeihoWebSekMosInputBean.getIwsTargettkmkht())));
            }
        }
        else {
            mosKihon.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.BLNK);
        }

        mosKihon.setSyksbyensitihsyutkhkkbn(editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(
            pSeihoWebSekMosInputBean.getIwsSyksbyensitihsyutkykhyj(),
            hknsyuruiNo
            ));

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsJyudkaigomehrtkarihyj())) {
            mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        }
        else {
            if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getJyudkaigomehrtktekiumu())) {
                mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
            }
            else {
                mosKihon.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.BLNK);
            }
        }

        C_Tkhukaumu kjnnkpzeitekitkhukakbn = editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
            pSyouhnZokusei.getZeiseitekikakuumu(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setKjnnkpzeitekitkhukakbn(kjnnkpzeitekitkhukakbn);

        mosKihon.setTeikisiharaitkykhkkbn(
            editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku(
                pSeihoWebSekMosInputBean.getIwsTeikisiharaitkarihyj(), hknsyuruiNo));

        C_UmuKbn kjmeigiUmuKbn = editSeihoWebRenkeiKoumoku.kjmeigihkhunouumukbnSyutoku(
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setKjmeigihkhunouumukbn(kjmeigiUmuKbn);

        C_UmuKbn tsryhshrKykUmuKbn = editSeihoWebRenkeiKoumoku.tsryhshrkykumukbnSyutoku(
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setTsryhshrkykumukbn(tsryhshrKykUmuKbn);

        C_UmuKbn syosisyaTodokeUmuKbn = editSeihoWebRenkeiKoumoku.syosisyatodokeumukbnSyutoku(
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setSyosisyatodokeumukbn(syosisyaTodokeUmuKbn);

        C_UmuKbn kakuKisyouryakukbUmuKbn = editSeihoWebRenkeiKoumoku.kakukisyouryakukbumukbnSyutoku(
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setKakukisyouryakukbumukbn(kakuKisyouryakukbUmuKbn);

        C_UmuKbn seiymdMosseitouUmuKbn = editSeihoWebRenkeiKoumoku.seiymdmosseitouumukbnSyutoku(
            pSeihoWebSekMosInputBean.getIwsTksykmcd1(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd2(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd3(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd4(),
            pSeihoWebSekMosInputBean.getIwsTksykmcd5());
        mosKihon.setSeiymdmosseitouumukbn(seiymdMosseitouUmuKbn);

        mosKihon.setTeirituhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
            Integer.valueOf(pSeihoWebSekMosInputBean.getIwsTeiritutumitatehbnwr()),
            pSyouhnZokusei.getTmttknhaibunwarisiteiumu()));

        mosKihon.setSisuukbn(pSyouhnZokusei.getSisuukbn());

        mosKihon.setSisuuhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
            Integer.valueOf(pSeihoWebSekMosInputBean.getIwsSisuurendouhbnwr()),
            pSyouhnZokusei.getTmttknhaibunwarisiteiumu()));

        mosKihon.setTrhkjikakkbn(C_TrhkjiKakKbn.KAKUNINZUMI);

        BizPropertyInitializer.initialize(mosKihon);
    }

    private void editMosDairiten(HT_SyoriCTL pSyoriCTL, List<BzGetAgInfoBean> pAgInfoBeanLst, int pRenNo,
        String pBosyuuTrkNo) {
        HT_MosDairiten mosDairiten = pSyoriCTL.createMosDairiten();

        mosDairiten.setRenno(pRenNo);
        for (BzGetAgInfoBean bzGetAgInfoBean : pAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                mosDairiten.setJimusyocd(bzGetAgInfoBean.getDrtenJimCd());
                break;
            }
        }

        mosDairiten.setBosyuutrkno(pBosyuuTrkNo);

        BizPropertyInitializer.initialize(mosDairiten);
    }

    private void editUketorinin(HT_SyoriCTL pSyoriCTL, WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {
        int renNo = 0;
        int sbuktRenNo = 0;
        int mnkuktRenNo = 0;

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1()) ||
            "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(sbuktRenNo + 1);
                sbuktRenNo = sbuktRenNo + 1;
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorinin.setUktsyurenno(mnkuktRenNo + 1);
                mnkuktRenNo = mnkuktRenNo + 1;
            }
            else {
                uketorinin.setUktsyukbn(C_UktsyuKbn.BLNK);
                uketorinin.setUktsyurenno(renNo + 1);
                renNo = renNo + 1;
            }

            if (("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1()) || "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn1())) &&
                ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn1()) || "8".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn1()))) {

                if ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn1())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                } else {
                    uketorinin.setUktkbn(C_UktKbn.HHKN);
                }
            } else {
                uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

                uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsUktnm1());
                uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsKjuktnm1());
                uketorinin.setUkttdk(uktTdk1);

                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsUktseiymd1().toString())) {
                    uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsUktseiymd1());
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2()) ||
            "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(sbuktRenNo + 1);
                sbuktRenNo = sbuktRenNo + 1;
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorinin.setUktsyurenno(mnkuktRenNo + 1);
                mnkuktRenNo = mnkuktRenNo + 1;
            }
            else {
                uketorinin.setUktsyukbn(C_UktsyuKbn.BLNK);
                uketorinin.setUktsyurenno(renNo + 1);
                renNo = renNo + 1;
            }

            if (("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2()) || "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn2())) &&
                ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn2()) || "8".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn2()))) {

                if ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn2())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                } else {
                    uketorinin.setUktkbn(C_UktKbn.HHKN);
                }
            } else {

                uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsUktnm2());
                uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsKjuktnm2());
                uketorinin.setUkttdk(uktTdk2);

                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsUktseiymd2().toString())) {
                    uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsUktseiymd2());
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3()) ||
            "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(sbuktRenNo + 1);
                sbuktRenNo = sbuktRenNo + 1;
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorinin.setUktsyurenno(mnkuktRenNo + 1);
                mnkuktRenNo = mnkuktRenNo + 1;
            }
            else {
                uketorinin.setUktsyukbn(C_UktsyuKbn.BLNK);
                uketorinin.setUktsyurenno(renNo + 1);
                renNo = renNo + 1;
            }

            if (("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3()) || "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn3())) &&
                ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn3()) || "8".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn3()))) {

                if ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn3())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                } else {
                    uketorinin.setUktkbn(C_UktKbn.HHKN);
                }
            } else {

                uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsUktnm3());
                uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsKjuktnm3());
                uketorinin.setUkttdk(uktTdk3);

                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsUktseiymd3().toString())) {
                    uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsUktseiymd3());
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4()) ||
            "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(sbuktRenNo + 1);
                sbuktRenNo = sbuktRenNo + 1;
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorinin.setUktsyurenno(mnkuktRenNo + 1);
                mnkuktRenNo = mnkuktRenNo + 1;
            }
            else {
                uketorinin.setUktsyukbn(C_UktsyuKbn.BLNK);
                uketorinin.setUktsyurenno(renNo + 1);
                renNo = renNo + 1;
            }

            if (("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4()) || "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn4())) &&
                ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn4()) || "8".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn4()))) {

                if ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn4())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                } else {
                    uketorinin.setUktkbn(C_UktKbn.HHKN);
                }
            } else {

                uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsUktnm4());
                uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsKjuktnm4());
                uketorinin.setUkttdk(uktTdk4);

                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsUktseiymd4().toString())) {
                    uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsUktseiymd4());
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5()) ||
            "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                uketorinin.setUktsyurenno(sbuktRenNo + 1);
                sbuktRenNo = sbuktRenNo + 1;
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5())) {
                uketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                uketorinin.setUktsyurenno(mnkuktRenNo + 1);
                mnkuktRenNo = mnkuktRenNo + 1;
            }
            else {
                uketorinin.setUktsyukbn(C_UktsyuKbn.BLNK);
                uketorinin.setUktsyurenno(renNo + 1);
                renNo = renNo + 1;
            }

            if (("1".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5()) || "2".equals(pSeihoWebSekMosInputBean.getIwsUktkbn5())) &&
                ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn5()) || "8".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn5()))) {

                if ("0".equals(pSeihoWebSekMosInputBean.getIwsUkttdkkbn5())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                } else {
                    uketorinin.setUktkbn(C_UktKbn.HHKN);
                }
            } else {

                uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsUktnm5());
                uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsKjuktnm5());
                uketorinin.setUkttdk(uktTdk5);

                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsUktseiymd5().toString())) {
                    uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsUktseiymd5());
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }
    }

    private void editStdrskUketorinin(HT_SyoriCTL pSyoriCTL, WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {
        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

        if (!"0".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            uketorinin.setUktsyukbn(C_UktsyuKbn.STDRSK);
            uketorinin.setUktsyurenno(1);

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);
            }
            else if ("3".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.KYK);
            }
            else if ("4".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.SBUK);
            }
            else if ("5".equals(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn())) {
                if ("0".equals(pSeihoWebSekMosInputBean.getIwsHhkndrtdkkbn())) {
                    uketorinin.setUktkbn(C_UktKbn.KYK);
                }
                else if ("7".equals(pSeihoWebSekMosInputBean.getIwsHhkndrtdkkbn())) {
                    uketorinin.setUktkbn(C_UktKbn.SBUK);
                }
                else {
                    uketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

                    uketorinin.setUktnmkn(pSeihoWebSekMosInputBean.getIwsHhkndrknnm());
                    uketorinin.setUktnmkj(pSeihoWebSekMosInputBean.getIwsHhkndrkjnm());
                    uketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pSeihoWebSekMosInputBean.getIwsHhkndrtdkkbn()));

                    if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsHhkndrseiymd().toString())) {
                        uketorinin.setUktseiymd(pSeihoWebSekMosInputBean.getIwsHhkndrseiymd());
                    }
                }
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

    }

    private void editKykdrnUketorinin(HT_SyoriCTL pSyoriCTL, WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {

        if (!"0".equals(pSeihoWebSekMosInputBean.getIwsKykdrnrkkbn()) &&
            !"3".equals(pSeihoWebSekMosInputBean.getIwsKykdrnrkkbn())) {
            HT_Uketorinin uketorinin = pSyoriCTL.createUketorinin();

            uketorinin.setUktsyukbn(C_UktsyuKbn.KYKDRN);
            uketorinin.setUktsyurenno(1);

            if ("1".equals(pSeihoWebSekMosInputBean.getIwsKykdrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);
            }
            else if ("2".equals(pSeihoWebSekMosInputBean.getIwsKykdrnrkkbn())) {

                uketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);
            }

            uketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            BizPropertyInitializer.initialize(uketorinin);
        }

    }

    private void editMosTrkKzk(HT_SyoriCTL pSyoriCTL, WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsKzktrkmoskbn())) {
            if (!BizUtil.isBlank(pSeihoWebSekMosInputBean.getIwsKzkknnm1())) {

                HT_MosTrkKzk mosTrkKzk = pSyoriCTL.createMosTrkKzk();

                mosTrkKzk.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK1);
                mosTrkKzk.setTrkkzknmkn(pSeihoWebSekMosInputBean.getIwsKzkknnm1());
                mosTrkKzk.setTrkkzknmkj(pSeihoWebSekMosInputBean.getIwsKzkkjnm1());
                mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);
                mosTrkKzk.setTrkkzksei(editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(
                    pSeihoWebSekMosInputBean.getIwsKzkseikbn1()));
                mosTrkKzk.setTrkkzktdk(editSeihoWebRenkeiKoumoku.kzktdkkbnHenkan(
                    pSeihoWebSekMosInputBean.getIwsKzktdkkbn1()));
                mosTrkKzk.setTrkkzkyno(pSeihoWebSekMosInputBean.getIwsKzkyno1());
                mosTrkKzk.setTrkkzkadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr1()));
                mosTrkKzk.setTrkkzkadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr1()));
                mosTrkKzk.setTrkkzkadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr1()));
                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsKzkseiymd1().toString())) {

                    mosTrkKzk.setTrkkzkseiymd(pSeihoWebSekMosInputBean.getIwsKzkseiymd1());
                }

                BizPropertyInitializer.initialize(mosTrkKzk);
            }

            if (!BizUtil.isBlank(pSeihoWebSekMosInputBean.getIwsKzkknnm2())) {

                HT_MosTrkKzk mosTrkKzk = pSyoriCTL.createMosTrkKzk();

                mosTrkKzk.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK2);
                mosTrkKzk.setTrkkzknmkn(pSeihoWebSekMosInputBean.getIwsKzkknnm2());
                mosTrkKzk.setTrkkzknmkj(pSeihoWebSekMosInputBean.getIwsKzkkjnm2());
                mosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);
                mosTrkKzk.setTrkkzksei(editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(
                    pSeihoWebSekMosInputBean.getIwsKzkseikbn2()));
                mosTrkKzk.setTrkkzktdk(editSeihoWebRenkeiKoumoku.kzktdkkbnHenkan(
                    pSeihoWebSekMosInputBean.getIwsKzktdkkbn2()));
                mosTrkKzk.setTrkkzkyno(pSeihoWebSekMosInputBean.getIwsKzkyno2());
                mosTrkKzk.setTrkkzkadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr2()));
                mosTrkKzk.setTrkkzkadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr2()));
                mosTrkKzk.setTrkkzkadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(
                    pSeihoWebSekMosInputBean.getIwsKzkadr2()));
                if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsKzkseiymd2().toString())) {

                    mosTrkKzk.setTrkkzkseiymd(pSeihoWebSekMosInputBean.getIwsKzkseiymd2());
                }

                BizPropertyInitializer.initialize(mosTrkKzk);
            }
        }
    }



    private void editMosSyouhn(HT_MosSyouhn pMosSyouhn, HT_MosKihon pMosKihon, BM_SyouhnZokusei pSyouhnZokusei,
        WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean) {

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

        pMosSyouhn.setSyouhncd(pSyouhnZokusei.getSyouhncd());
        pMosSyouhn.setSyouhnsdno(0);
        pMosSyouhn.setRyouritusdno(pSyouhnZokusei.getRyouritusdno());
        pMosSyouhn.setSyutkkbn(pSyouhnZokusei.getSyutkkbn());

        pMosSyouhn.setDai1hknkkn(Integer.valueOf(pSeihoWebSekMosInputBean.getIwsHknkkn1()));

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        pMosSyouhn.setSknenkinsyu(editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan(pSeihoWebSekMosInputBean.getIwsNksyukbn()));

        if (C_Tuukasyu.JPY.eq(pMosKihon.getKyktuukasyu())) {

            pMosSyouhn.setKihons(BizCurrency.valueOf(new BigDecimal(pSeihoWebSekMosInputBean.getIwsKihonsstr())));

        }
        else {

            CurrencyType CurrencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());

            pMosSyouhn.setKihons(BizCurrency.valueOf(
                new BigDecimal(pSeihoWebSekMosInputBean.getIwsGaikakihonsstr()).divide(new BigDecimal("100")),
                CurrencyType));
        }

        if (C_Tuukasyu.JPY.eq(mostuukasyu)) {

            pMosSyouhn.setHrktuukasyutkp(BizCurrency.valueOf(new BigDecimal(hrktuukasyutkp)));
        }
        else{

            CurrencyType CurrencyType = henkanTuuka.henkanTuukaKbnToType(mostuukasyu);
            pMosSyouhn.setHrktuukasyutkp(BizCurrency.valueOf(
                new BigDecimal(gaikaHrktuukasyutkp).divide(new BigDecimal("100")),
                CurrencyType));
        }

        pMosSyouhn.setHknkkn(editSeihoWebRenkeiKoumoku.hknkknSyutoku(
            Integer.valueOf(pSeihoWebSekMosInputBean.getIwsHknkkn()),
            Integer.valueOf(pSeihoWebSekMosInputBean.getIwsSueokikkn()),
            hknsyuruiNo
            ));

        pMosSyouhn.setHrkkkn(Integer.valueOf(pSeihoWebSekMosInputBean.getIwsPharaikomikikan()));
        pMosSyouhn.setHknkknsmnkbn(hknkknsmnKbn);

        pMosSyouhn.setHrkkknsmnkbn(editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(
            hknsyuruiNo,
            Integer.parseInt(pSeihoWebSekMosInputBean.getIwsPharaikomikikan())));
    }

    private void editMosnaiCheckParam(MosnaiCheckParam pMosnaiCheckParam, HT_SyoriCTL pSyoriCTL,
        WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean, C_SeihowebsousasyaKbn pSeihowebsousasyaKbn) {

        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();

        pMosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);

        if ("00000000".equals(pSeihoWebSekMosInputBean.getIwsNrkcalckijyunymd().toString())) {
            pMosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.AUTO);
        }
        else {
            pMosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        }

        pMosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        pMosnaiCheckParam.setSysDate(pSeihoWebSekMosInputBean.getIwsSyoriymd());
        pMosnaiCheckParam.setDataSyoriControl(pSyoriCTL);

        if (DRTENREPORTGYOUTAIKBN_SMBC.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMBC);
        }
        else if (DRTENREPORTGYOUTAIKBN_TIGIN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.TIGIN);
        }
        else if (DRTENREPORTGYOUTAIKBN_SINKIN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SINKIN);
        }
        else if (DRTENREPORTGYOUTAIKBN_DIRECT.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.DIRECT);
        }
        else if (DRTENREPORTGYOUTAIKBN_MARUKIN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.MARUKIN);
        }
        else if (DRTENREPORTGYOUTAIKBN_SMTB.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMTB);
        }
        else if (DRTENREPORTGYOUTAIKBN_GAISANTIGIN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.GAISANTIGIN);
        }
        else if (DRTENREPORTGYOUTAIKBN_GAISANSINKIN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.GAISANSINKIN);
        }
        else if (DRTENREPORTGYOUTAIKBN_SONOTAMADOHAN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SONOTAMADOHAN);
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIGINKOU.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIGINKOU);
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIKAISYA.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIKAISYA);
        }
        else if (DRTENREPORTGYOUTAIKBN_UUSEIKANPO.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.YUUSEIKANPO);
        }
        else if (DRTENREPORTGYOUTAIKBN_SHOPMDHN.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SHOPMDHN);
        }
        else if (DRTENREPORTGYOUTAIKBN_MIZUHO.equals(
            pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            pMosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.MIZUHO);
        }

        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
            pMosnaiCheckParam.setNyuuryokuKawaseRate(
                BizNumber.valueOf(new BigDecimal(pSeihoWebSekMosInputBean.getIwsNyknkwsrateyen())).divide(100));
        }
        else {
            pMosnaiCheckParam.setNyuuryokuKawaseRate(
                BizNumber.valueOf(new BigDecimal(pSeihoWebSekMosInputBean.getIwsNyknkwsrategk())).divide(10000));
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsNyskaihihyj())) {

            pMosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.ARI);
        }
        else {

            pMosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.NONE);
        }

        if (C_SekmossakuseiKbn.SISAN.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn())) {
            pMosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SISAN);
        }
        else if (C_SekmossakuseiKbn.MOUSIKOMISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn())) {
            pMosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);
        }
        else if (C_SekmossakuseiKbn.SEKKEISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn())) {
            pMosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);
        }
        else if (C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn())) {
            pMosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);
        }

        pMosnaiCheckParam.setSekmossakuseiSousasyaKbn(pSeihowebsousasyaKbn);

        if (pSeihoWebSekMosInputBean.getIwsOyadrtencd() != null) {

            if (C_SeihowebsousasyaKbn.DIRTNBSYNN.eq(pSeihowebsousasyaKbn)) {
                pMosnaiCheckParam.setSekmossakuseiOyaAgCd(pSeihoWebSekMosInputBean.getIwsOyadrtencd());
            }
            else {
                pMosnaiCheckParam.setSekmossakuseiOyaAgCd(getOyadrtencdSyanaiUser(pSeihoWebSekMosInputBean.getIwsOyadrtencd(),
                    pSeihoWebSekMosInputBean.getIwsDrtentyouhyougyoutaikbn()));
            }
        }

        if ("1".equals(pSeihoWebSekMosInputBean.getIwsHrksikinnrkhyj())) {

            pMosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        }
        else {

            pMosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.NONE);
        }
    }

    private String getOyadrtencdSyanaiUser(String oyadrtencd, String drtentyouhyougyoutaikbn) {
        if (oyadrtencd == null) {
            return null;
        }

        Map<String, String> syanaiuserTokusyudrtenMap = YuyuBosyuuConfig.getInstance().getSyanaiuserTokusyudrtenMap();

        String syanaiuserSyozokuTokusyudrten = syanaiuserTokusyudrtenMap.get(oyadrtencd);

        if (syanaiuserSyozokuTokusyudrten != null){
            return syanaiuserSyozokuTokusyudrten;
        }

        if (DRTENREPORTGYOUTAIKBN_SMBC.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getSmbcOyadrtencd();
        }
        else if (DRTENREPORTGYOUTAIKBN_SMTB.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getSmtbOyadrtencd();
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIGINKOU.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getYuutyoginkouOyadrtencd();
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIKAISYA.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getNihonyuubinOyadrtencd();
        }
        else if (DRTENREPORTGYOUTAIKBN_UUSEIKANPO.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getKanposeimeiOyadrtencd();
        }
        else if (DRTENREPORTGYOUTAIKBN_MIZUHO.equals(drtentyouhyougyoutaikbn)) {
            return YuyuBizConfig.getInstance().getMizuhoOyadrtencd();
        }
        else {
            return oyadrtencd;
        }
    }

    private BizDate getDrtnskYuukouKigenYmd(MosnaiCheckParam pMP, BM_SyouhnZokusei pSyouhnZokusei,
        String pDrtentyouhyougyoutaikbn) {

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        Integer hhkn1SaiUpYmd = mosKihon.getHhknnen();
        BizDate hhknKyknenYmd = null;
        BizDate kyknenYuukouYmd = null;
        BizDate drtenSekYkkgYmd = null;
        BizDate kykYmd = mosKihon.getKykymd();
        C_Hrkkaisuu hrkkaisuu = mosKihon.getHrkkaisuu();
        boolean kyknenYuukouYmdHanteiYouhiFlg = false;

        if (mosKihon.getHhknseiymd() != null) {
            hhknKyknenYmd = mosKihon.getHhknseiymd().addYears(hhkn1SaiUpYmd + 1).getRekijyou();
            kyknenYuukouYmd = hhknKyknenYmd.addDays(-1);
        }

        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {

            if (RIRITUKIRIKAEBI_16 > kykYmd.getDay()) {

                drtenSekYkkgYmd = kykYmd.getBizDateYM().getBizDate(RIRITUKIRIKAEBI_16).addDays(-1);
            }
            else {

                drtenSekYkkgYmd = kykYmd.getBizDateYM().getNextMonth().getBizDate(RIRITUKIRIKAEBI_1).addDays(-1);
            }

            kyknenYuukouYmdHanteiYouhiFlg = true;
        }
        else if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {

            if (RIRITUKIRIKAEBI_16 > kykYmd.getDay()) {

                drtenSekYkkgYmd = kykYmd.getBizDateYM().getPreviousMonth().getBizDate(RIRITUKIRIKAEBI_16).addDays(-1);
            }
            else {

                drtenSekYkkgYmd = kykYmd.getBizDateYM().getBizDate(RIRITUKIRIKAEBI_1).addDays(-1);
            }
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {

            drtenSekYkkgYmd = kykYmd.addDays(-1);
        }
        else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {

                drtenSekYkkgYmd = kykYmd.getBizDateYM().getPreviousMonth().getLastDay();
            }
            else {

                if (kykYmd.getDay() != RIRITUKIRIKAEBI_1) {

                    drtenSekYkkgYmd = kykYmd.getBizDateYM().getNextMonth().getFirstDay();

                    kyknenYuukouYmdHanteiYouhiFlg = true;
                }
                else {

                    drtenSekYkkgYmd = kykYmd;
                }
            }
        }
        else {

            drtenSekYkkgYmd = kyknenYuukouYmd;
        }

        if (kyknenYuukouYmdHanteiYouhiFlg) {

            if (BizDateUtil.compareYmd(kykYmd, hhknKyknenYmd) == BizDateUtil.COMPARE_LESSER  &&
                (BizDateUtil.compareYmd(hhknKyknenYmd, drtenSekYkkgYmd) == BizDateUtil.COMPARE_LESSER  ||
                BizDateUtil.compareYmd(hhknKyknenYmd, drtenSekYkkgYmd) == BizDateUtil.COMPARE_EQUAL)) {

                drtenSekYkkgYmd = kyknenYuukouYmd;
            }
        }

        return drtenSekYkkgYmd;
    }

    private WsBzWebserviceResParamBean creatResponseError(
        String pErrorKbn,
        String pMsg1,
        String pMst2) {

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = SWAKInjector.getInstance(WsHbSeihoWebSekMosOutputBean.class);

        initOutputBean(wsHbSeihoWebSekMosOutputBean);


        wsHbSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(pErrorKbn);
        wsHbSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(ConvertUtil.toZenAll(pMsg1, 1, 1));
        wsHbSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2(ConvertUtil.toZenAll(pMst2, 1, 1));

        logger.debug("WsHbSeihoWebSekMosOutputBean:"+ wsHbSeihoWebSekMosOutputBean.toString());

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebSekMosOutputBean));

        logger.debug("△ 生保Ｗｅｂ設計書申込書作成 終了");

        return wsBzWebserviceResParamBean;
    }

    private void editResponseSeijou(
        WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean,
        WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean,
        GetSinkeiyakuGuidanceOutBean pSkeiGuidanceOutBean,
        BzGetBsInfoBean pBsInfoBeanA,
        List<BzGetAgInfoBean> pAgInfoBeanLst,
        DairitenTesuuryouInfoSyutokuKekkaBean pDairitenKekkaBean,
        HT_SyoriCTL pSyoriCTL,
        BizDate pDrtnskYuukouKigenYmd,
        boolean pDrtenTesuuryouKekka,
        BizNumber pSjkkkTyouseiyouRiritu,
        BizNumber pPhireialpha,
        MosnaiCheckParam pMosnaiCheckParam,
        BM_SyouhnZokusei pSyouhnZokusei
        ) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector.getInstance(KeisanTargetMokuhyougk.class);
        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        List<HT_MosSyouhn> mosSyouhnLst = pSyoriCTL.getMosSyouhns();
        HT_MosSyouhn mosSyouhnSyu = null;
        KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkKykTmttkn.class);
        BizCurrency syutkPkei = BizCurrency.valueOf(0, mosSyouhnLst.get(0).getSyutkp().getType());

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
            syutkPkei = syutkPkei.add(mosSyouhn.getSyutkp());
            if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn())) {
                mosSyouhnSyu = mosSyouhn;
            }
        }
        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);


        if (mosKihon.getKykymd() != null) {
            pSeihoWebSekMosOutputBean.setIwsYoteikykymd(mosKihon.getKykymd());
        }

        if (pDrtnskYuukouKigenYmd != null) {
            pSeihoWebSekMosOutputBean.setIwsDairitensekykkigenymd(pDrtnskYuukouKigenYmd);
        }

        pSeihoWebSekMosOutputBean.setIwsHhknnen(BizNumber.valueOf(mosKihon.getHhknnen()));

        if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

            pSeihoWebSekMosOutputBean.setIwsSyupn(BizNumber.valueOf(mosSyouhnSyu.getSyutkp()));
            pSeihoWebSekMosOutputBean.setIwsSyokaiharaikomip(BizNumber.valueOf(syutkPkei));
            pSeihoWebSekMosOutputBean.setIwsSbs(BizNumber.valueOf(mosSyouhnSyu.getSeitoukihons()));
            pSeihoWebSekMosOutputBean.setIwsKihons(BizNumber.valueOf(mosSyouhnSyu.getSeitoukihons()));

        }
        else {

            pSeihoWebSekMosOutputBean.setIwsGaikasyup(BizNumber.valueOf(mosSyouhnSyu.getSyutkp().multiply(100)));
            pSeihoWebSekMosOutputBean.setIwsGaikasyokaiharaikomip(BizNumber.valueOf(syutkPkei.multiply(100)));
            pSeihoWebSekMosOutputBean.setIwsGaikasbs(BizNumber.valueOf(mosSyouhnSyu.getSeitoukihons().multiply(100)));
            pSeihoWebSekMosOutputBean.setIwsGaikakihons(BizNumber.valueOf(mosSyouhnSyu.getSeitoukihons().multiply(100)));

        }

        if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                if (C_Sdpd.SD.eq(mosKihon.getSdpdkbn())) {
                    pSeihoWebSekMosOutputBean.setIwsHrktuukasyukykp(pSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip());
                }
                else if (C_Sdpd.PD.eq(mosKihon.getSdpdkbn())) {
                    pSeihoWebSekMosOutputBean.setIwsHrktuukasyukykp(BizNumber.valueOf(mosSyouhnSyu.getHrktuukasyutkp()));
                }

                pSeihoWebSekMosOutputBean.setIwsHrktuukasyokaihrkp(BizNumber.valueOf(mosSyouhnSyu.getHrktuukasyutkp()));

            }
            else{

                if (C_Sdpd.SD.eq(mosKihon.getSdpdkbn())) {
                    pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyukykp(
                        pSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip().multiply(100));
                }
                else if (C_Sdpd.PD.eq(mosKihon.getSdpdkbn())) {
                    pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyukykp(
                        BizNumber.valueOf(mosSyouhnSyu.getHrktuukasyutkp().multiply(100)));

                }
                pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyokaihrkp(BizNumber.valueOf(mosSyouhnSyu.getHrktuukasyutkp().multiply(100)));
            }
        }
        else{

            pSeihoWebSekMosOutputBean.setIwsHrktuukasyukykp(BizNumber.valueOf(new BigDecimal(pSeihoWebSekMosInputBean.getIwsHrktuukakihonp())));
            pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyukykp(BizNumber.valueOf(new BigDecimal(pSeihoWebSekMosInputBean.getIwsGaikahrktuukakihonp())));

            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                if (mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu())) {

                    pSeihoWebSekMosOutputBean.setIwsHrktuukasyokaihrkp(BizNumber.valueOf(mosSyouhnSyu.getSyutkp()));
                }
                else{

                    pSeihoWebSekMosOutputBean.setIwsHrktuukasyokaihrkp(BizNumber.valueOf(mosKihon.getHrktuukaheijyunp()));
                }
            }
            else {

                if (mosKihon.getKyktuukasyu().eq(mosKihon.getHrktuukasyu())) {

                    pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyokaihrkp(BizNumber.valueOf(mosSyouhnSyu.getSyutkp().multiply(100)));
                }
                else{

                    pSeihoWebSekMosOutputBean.setIwsGaikahrktuukasyokaihrkp(BizNumber.valueOf(mosKihon.getHrktuukaheijyunp().multiply(100)));
                }
            }
        }

        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
            pSeihoWebSekMosOutputBean.setIwsikkatup(BizNumber.valueOf(mosKihon.getIkkatup()));
        }

        if (C_UmuKbn.ARI.eq(mosKihon.getZennoumousideumu())) {

            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(pSyouhnZokusei.getPtratkituukasiteikbn())) {

                if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                    pSeihoWebSekMosOutputBean.setIwsZennoup(BizNumber.valueOf(mosKihon.getZennoup().add(
                        mosKihon.getZennoujyuutoup())));
                }
                else {

                    pSeihoWebSekMosOutputBean.setIwsGaikazennoup(BizNumber.valueOf(mosKihon.getZennoup().add(
                        mosKihon.getZennoujyuutoup())).multiply(100));
                }
            }
            else {

                if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                    pSeihoWebSekMosOutputBean.setIwsZennoup(BizNumber.valueOf(mosKihon.getZennoup().add(
                        mosKihon.getZennoujyuutoup())));
                }
                else if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                    pSeihoWebSekMosOutputBean.setIwsZennoup(BizNumber.valueOf(mosKihon.getHrktuukafstphrkgk()));
                }

                if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())){

                    pSeihoWebSekMosOutputBean.setIwsGaikazennoup(BizNumber.valueOf(mosKihon.getZennoup().add(
                        mosKihon.getZennoujyuutoup())).multiply(100));
                }
            }
        }


        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
            if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                pSeihoWebSekMosOutputBean.setIwsTargetyenknsnp(BizNumber.valueOf(
                    new BigDecimal(pSeihoWebSekMosInputBean.getIwsHrktuukakihonp())));
            }
            else {
                pSeihoWebSekMosOutputBean.setIwsTargetyenknsnp(BizNumber.valueOf(keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY, mosSyouhnSyu.getSyutkp(), BizNumber.valueOf(
                        new BigDecimal(pSeihoWebSekMosInputBean.getIwsNyknkwsrateyen())).divide(100), C_HasuusyoriKbn.AGE)));
            }
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getTargettkhkkbn())) {
            if (!C_TargetTkMokuhyoutiKbn.BLNK.eq(mosKihon.getTargettkmkhtkbn()) &&
                !C_TargetTkMokuhyoutiKbn.NOTARGET.eq(mosKihon.getTargettkmkhtkbn())) {
                pSeihoWebSekMosOutputBean.setIwsTargettokuyakumkhgk(BizNumber.valueOf(
                    keisanTargetMokuhyougk.exec(BizCurrency.valueOf(new BigDecimal(
                        pSeihoWebSekMosOutputBean.getIwsTargetyenknsnp().toString())), Integer.parseInt(
                            pSeihoWebSekMosInputBean.getIwsTargettkmkht()))));
            }
        }

        pSeihoWebSekMosOutputBean.setIwsHendouknrtumitateriritu(mosSyouhnSyu.getYoteiriritu().multiply(10000));

        BizNumber sjkkkTyouseiyouRiritu = pSjkkkTyouseiyouRiritu;

        if (Signum.Minus.equals(sjkkkTyouseiyouRiritu.signum())) {

            pSeihoWebSekMosOutputBean.setIwsSjkkktyusirrtfgu(BizNumber.ONE);

            sjkkkTyouseiyouRiritu = sjkkkTyouseiyouRiritu.multiply(-1);

        }
        pSeihoWebSekMosOutputBean.setIwsSjkkktyouseiriritu(sjkkkTyouseiyouRiritu.multiply(10000));


        if (pBsInfoBeanA.getBosyuuTrkNo() != null) {
            pSeihoWebSekMosOutputBean.setIwsBsyutrkno(pBsInfoBeanA.getBosyuuTrkNo());
        }

        if (pBsInfoBeanA.getKanjiBosyuuninNm() != null) {
            pSeihoWebSekMosOutputBean.setIwsDirtnbosyuuninkanji(pBsInfoBeanA.getKanjiBosyuuninNm());
        }

        for (BzGetAgInfoBean bzGetAgInfoBean : pAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                if (bzGetAgInfoBean.getKanjiDairitenNm() != null) {
                    if (bzGetAgInfoBean.getKanjiDairitenNm().length() > 20) {
                        pSeihoWebSekMosOutputBean.setIwsBosyuudairitennm(bzGetAgInfoBean.getKanjiDairitenNm()
                            .substring(0, 20));
                    }
                    else {
                        pSeihoWebSekMosOutputBean.setIwsBosyuudairitennm(bzGetAgInfoBean.getKanjiDairitenNm());
                    }
                }

                if (bzGetAgInfoBean.getKinyuuCd() != null) {
                    pSeihoWebSekMosOutputBean.setIwsKinyuukikancd(bzGetAgInfoBean.getKinyuuCd());
                }

                break;
            }
        }

        if(pDairitenKekkaBean != null){

            if (pDrtenTesuuryouKekka) {

                pSeihoWebSekMosOutputBean.setIwsTsrycd(pDairitenKekkaBean.getTsryCd());
                pSeihoWebSekMosOutputBean.setIwsDrtenshrfsttsry(
                    BizNumber.valueOf(pDairitenKekkaBean.getSyotsryGkYen()));
                pSeihoWebSekMosOutputBean.setIwsGaikadrtenshrfsttsry(
                    BizNumber.valueOf(pDairitenKekkaBean.getSyotsryGkKykTuuka().multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsGkdrtenshrfsttsrytukkbn(
                    editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pDairitenKekkaBean.getSyotsrygkTuukasyu()));
                pSeihoWebSekMosOutputBean.setIwsDrtenshrkztsry(
                    BizNumber.valueOf(pDairitenKekkaBean.getJitsryGkYen()));
                pSeihoWebSekMosOutputBean.setIwsGaikadrtenshrkztsry(
                    BizNumber.valueOf(pDairitenKekkaBean.getJitsryGkKykTuuka().multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsGkdrtenshrkztsrytukkbn(
                    editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pDairitenKekkaBean.getJitsrygkTuukasyu()));
                pSeihoWebSekMosOutputBean.setIwsSyotsryruigkn(
                    BizNumber.valueOf(pDairitenKekkaBean.getSyotsryRuiGkYen()));
                pSeihoWebSekMosOutputBean.setIwsNitsryruigkn(
                    BizNumber.valueOf(pDairitenKekkaBean.getJitsryruiGkYen()));
                pSeihoWebSekMosOutputBean.setIwsSougktsryn(
                    BizNumber.valueOf(pDairitenKekkaBean.getSoutsryGkYen()));
                pSeihoWebSekMosOutputBean.setIwsGaikasyotsryruigk(
                    BizNumber.valueOf(pDairitenKekkaBean.getSyotsryRuiGkGaika().multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsGaikasyotsrytuukakbn(
                    editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pDairitenKekkaBean.getSyotsryruigkTuukasyu()));
                pSeihoWebSekMosOutputBean.setIwsGaikanitsryruigkn(
                    BizNumber.valueOf(pDairitenKekkaBean.getJitsryruiGkGaika().multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsGaikanitsrytuukakbn(
                    editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pDairitenKekkaBean.getJitsryruigkTuukasyu()));
                pSeihoWebSekMosOutputBean.setIwsGaikasougktsry(
                    BizNumber.valueOf(pDairitenKekkaBean.getSoutsryGkGaika().multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsGaikasougktsrytuukakbn(
                    editSeihoWebRenkeiKoumoku.tuukaKbnHenkan(pDairitenKekkaBean.getSoutsrygkTuukasyu()));
            }
            else {
                pSeihoWebSekMosOutputBean.setIwsTsrycd("9999999");
            }
        }

        List<String> msgLst =  pSkeiGuidanceOutBean.getGuidansuMessageList();
        for (int index = 0; index < msgLst.size(); index++) {
            switch(index) {
                case 0:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd01(msgLst.get(index));
                    break;
                case 1:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd02(msgLst.get(index));
                    break;
                case 2:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd03(msgLst.get(index));
                    break;
                case 3:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd04(msgLst.get(index));
                    break;
                case 4:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd05(msgLst.get(index));
                    break;
                case 5:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd06(msgLst.get(index));
                    break;
                case 6:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd07(msgLst.get(index));
                    break;
                case 7:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd08(msgLst.get(index));
                    break;
                case 8:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd09(msgLst.get(index));
                    break;
                case 9:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd10(msgLst.get(index));
                    break;
                case 10:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd11(msgLst.get(index));
                    break;
                case 11:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd12(msgLst.get(index));
                    break;
                case 12:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd13(msgLst.get(index));
                    break;
                case 13:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd14(msgLst.get(index));
                    break;
                case 14:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd15(msgLst.get(index));
                    break;
                case 15:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd16(msgLst.get(index));
                    break;
                case 16:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd17(msgLst.get(index));
                    break;
                case 17:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd18(msgLst.get(index));
                    break;
                case 18:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd19(msgLst.get(index));
                    break;
                case 19:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd20(msgLst.get(index));
                    break;
                case 20:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd21(msgLst.get(index));
                    break;
                case 21:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd22(msgLst.get(index));
                    break;
                case 22:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd23(msgLst.get(index));
                    break;
                case 23:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd24(msgLst.get(index));
                    break;
                case 24:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd25(msgLst.get(index));
                    break;
                case 25:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd26(msgLst.get(index));
                    break;
                case 26:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd27(msgLst.get(index));
                    break;
                case 27:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd28(msgLst.get(index));
                    break;
                case 28:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd29(msgLst.get(index));
                    break;
                case 29:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd30(msgLst.get(index));
                    break;
                case 30:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd31(msgLst.get(index));
                    break;
                case 31:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd32(msgLst.get(index));
                    break;
                case 32:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd33(msgLst.get(index));
                    break;
                case 33:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd34(msgLst.get(index));
                    break;
                case 34:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd35(msgLst.get(index));
                    break;
                case 35:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd36(msgLst.get(index));
                    break;
                case 36:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd37(msgLst.get(index));
                    break;
                case 37:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd38(msgLst.get(index));
                    break;
                case 38:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd39(msgLst.get(index));
                    break;
                case 39:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd40(msgLst.get(index));
                    break;
                case 40:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd41(msgLst.get(index));
                    break;
                case 41:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd42(msgLst.get(index));
                    break;
                case 42:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd43(msgLst.get(index));
                    break;
                case 43:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd44(msgLst.get(index));
                    break;
                case 44:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd45(msgLst.get(index));
                    break;
                case 45:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd46(msgLst.get(index));
                    break;
                case 46:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd47(msgLst.get(index));
                    break;
                case 47:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd48(msgLst.get(index));
                    break;
                case 48:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd49(msgLst.get(index));
                    break;
                case 49:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd50(msgLst.get(index));
                    break;
                case 50:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd51(msgLst.get(index));
                    break;
                case 51:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd52(msgLst.get(index));
                    break;
                case 52:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd53(msgLst.get(index));
                    break;
                case 53:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd54(msgLst.get(index));
                    break;
                case 54:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd55(msgLst.get(index));
                    break;
                case 55:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd56(msgLst.get(index));
                    break;
                case 56:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd57(msgLst.get(index));
                    break;
                case 57:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd58(msgLst.get(index));
                    break;
                case 58:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd59(msgLst.get(index));
                    break;
                case 59:
                    pSeihoWebSekMosOutputBean.setIwsHtysyoruicd60(msgLst.get(index));
                    break;
                default :
            }
        }

        pSeihoWebSekMosOutputBean.setIwsKnsnkanouhyj(pSkeiGuidanceOutBean.getKnsnkanouhyj());
        pSeihoWebSekMosOutputBean.setIwsNngndkkkanouhyj(pSkeiGuidanceOutBean.getNngndkkkanouhyj());
        pSeihoWebSekMosOutputBean.setIwsMnstskanouhyj(pSkeiGuidanceOutBean.getMnstskanouhyj());
        pSeihoWebSekMosOutputBean.setIwsSyktkikanouhyj(pSkeiGuidanceOutBean.getSyktkikanouhyj());
        pSeihoWebSekMosOutputBean.setIwsSyaikanouhyj(pSkeiGuidanceOutBean.getSyaikanouhyj());
        pSeihoWebSekMosOutputBean.setIwsSndnzknsyouhyj(pSkeiGuidanceOutBean.getSndnzknsyouhyj());
        pSeihoWebSekMosOutputBean.setIwsKtekknsyouhyj(pSkeiGuidanceOutBean.getKtekknsyouhyj());
        pSeihoWebSekMosOutputBean.setIwsKnsnsysndnzyou(pSkeiGuidanceOutBean.getKnsnsysndnzyou());
        pSeihoWebSekMosOutputBean.setIwsKnsnketuekikensayouhyj(pSkeiGuidanceOutBean.getKnsnktekknsyou());
        pSeihoWebSekMosOutputBean.setIwsYoteijigyouhiritu1(pPhireialpha.multiply(100000));
        pSeihoWebSekMosOutputBean.setIwsTumitateriritu(mosSyouhnSyu.getTumitateriritu().multiply(10000));
        pSeihoWebSekMosOutputBean.setIwsSetteibairitu(mosSyouhnSyu.getSetteibairitu().multiply(100));
        pSeihoWebSekMosOutputBean.setIwsTmttknzkrtjygn(mosSyouhnSyu.getTmttknzoukaritujygn().multiply(10000));
        pSeihoWebSekMosOutputBean.setIwsNayosehumeikbn(pMosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn().getValue());
        pSeihoWebSekMosOutputBean.setIwsTumitateriritu2(mosSyouhnSyu.getLoadinghnkgtumitateriritu().multiply(10000));

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

        if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getTmttknhaibunwarisiteiumu())) {
            errorKbn = keisanSisuuRendouNkKykTmttkn.exec(
                mosKihon.getKyktuukasyu(),
                mosSyouhnSyu.getSyutkp(),
                BizNumber.valueOf(Integer.valueOf(mosKihon.getSisuuhaibunwarikbn().getValue()))
                );
        }

        if (C_ErrorKbn.OK.eq(errorKbn)) {
            BizCurrency sisuurendoutmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();
            BizCurrency teiritutmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();

            if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
                pSeihoWebSekMosOutputBean.setIwsSisuurendoup(BizNumber.valueOf(sisuurendoutmttkngk));
                pSeihoWebSekMosOutputBean.setIwsTeiritutumitatep(BizNumber.valueOf(teiritutmttkngk));
            }
            else {
                pSeihoWebSekMosOutputBean.setIwsSisuurendoup(BizNumber.valueOf(sisuurendoutmttkngk.multiply(100)));
                pSeihoWebSekMosOutputBean.setIwsTeiritutumitatep(BizNumber.valueOf(teiritutmttkngk.multiply(100)));
            }
        }

        pSeihoWebSekMosOutputBean.setIwsPwaribikirankkbn(editSeihoWebRenkeiKoumoku.seihoWebGetPwaribikirankkbn(
            mosKihon.getPwaribikitekiyoukbn()));

        pSeihoWebSekMosOutputBean.setIwsRendouritu(mosSyouhnSyu.getRendouritu().multiply(10000));

        if (!C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {
            pSeihoWebSekMosOutputBean.setIwsGaikateikisiharaigk(
                BizNumber.valueOf(mosSyouhnSyu.getTeikisiharaikin().multiply(100)));
        }

        pSeihoWebSekMosOutputBean.setIwsZennouwrbkrt(zennouwrbkrt.multiply(10000));
    }

    private WsBzWebserviceResParamBean creatResponseSeijou(
        WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsHbSeihoWebSekMosOutputBean>> chkKekkaSet = validator.validate(pSeihoWebSekMosOutputBean);

        if (chkKekkaSet.size() > 0) {
            Iterator<ConstraintViolation<WsHbSeihoWebSekMosOutputBean>> iterator = chkKekkaSet.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<WsHbSeihoWebSekMosOutputBean> chkKekka = iterator.next();
                String msg = messageBuilder.buildMessage(chkKekka);

                logger.debug("｜ " + chkKekka.getPropertyPath().toString() + " " + msg);
            }

            wsBzWebserviceResParamBean =
                creatResponseError(C_SekmossakuseiErroutKbn.GAMEN.getValue(),
                    MessageUtil.getMessage(MessageId.EGC1002), "");

            return wsBzWebserviceResParamBean;
        }

        logger.debug("WsHbSeihoWebSekMosOutputBean:"+ pSeihoWebSekMosOutputBean.toString());

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(pSeihoWebSekMosOutputBean));

        logger.debug("△ 生保Ｗｅｂ設計書申込書作成 終了");

        return wsBzWebserviceResParamBean;
    }

    private void checkSeigousei(WsHbSeihoWebSekMosInputBean pSeihoWebSekMosInputBean,
        WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        C_Kojinhjn kojinHoujinKbn = C_Kojinhjn.KOJIN;
        if ("0".equals(pSeihoWebSekMosInputBean.getIwsKyksyaseikbn())) {
            kojinHoujinKbn = C_Kojinhjn.HJN;
        }

        C_Kojinhjn hhkKojinHoujinKbn = C_Kojinhjn.KOJIN;
        if ("0".equals(pSeihoWebSekMosInputBean.getIwsHhknseikbn())) {
            hhkKojinHoujinKbn = C_Kojinhjn.HJN;
        }

        if (!C_SekmossakuseiKbn.SISAN.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn()) &&
            !C_SekmossakuseiKbn.MOUSIKOMISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn()) &&
            !C_SekmossakuseiKbn.SEKKEISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn()) &&
            !C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.getValue().equals(pSeihoWebSekMosInputBean.getIwsSekmossakuseikbn())){

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "作成区分"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        if (!CheckMeigininNmKana.isCheckOK(pSeihoWebSekMosInputBean.getIwsKyknm(), kojinHoujinKbn)) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1047, "契約者カナ氏名"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsKyksyaseiymd().toString()) &&
            !pSeihoWebSekMosInputBean.getIwsKyksyaseiymd().isRekijyou()) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "契約者生年月日"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }


        kykTdkKbn = editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(pSeihoWebSekMosInputBean.getIwsKyktdkkbn());

        checkUktInfo(1,
            pSeihoWebSekMosInputBean.getIwsUktkbn1(),
            pSeihoWebSekMosInputBean.getIwsUktnm1(),
            pSeihoWebSekMosInputBean.getIwsKjuktnm1(),
            pSeihoWebSekMosInputBean.getIwsUkttdkkbn1(),
            pSeihoWebSekMosInputBean.getIwsUktseiymd1(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkUktInfo(2,
            pSeihoWebSekMosInputBean.getIwsUktkbn2(),
            pSeihoWebSekMosInputBean.getIwsUktnm2(),
            pSeihoWebSekMosInputBean.getIwsKjuktnm2(),
            pSeihoWebSekMosInputBean.getIwsUkttdkkbn2(),
            pSeihoWebSekMosInputBean.getIwsUktseiymd2(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkUktInfo(3,
            pSeihoWebSekMosInputBean.getIwsUktkbn3(),
            pSeihoWebSekMosInputBean.getIwsUktnm3(),
            pSeihoWebSekMosInputBean.getIwsKjuktnm3(),
            pSeihoWebSekMosInputBean.getIwsUkttdkkbn3(),
            pSeihoWebSekMosInputBean.getIwsUktseiymd3(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkUktInfo(4,
            pSeihoWebSekMosInputBean.getIwsUktkbn4(),
            pSeihoWebSekMosInputBean.getIwsUktnm4(),
            pSeihoWebSekMosInputBean.getIwsKjuktnm4(),
            pSeihoWebSekMosInputBean.getIwsUkttdkkbn4(),
            pSeihoWebSekMosInputBean.getIwsUktseiymd4(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkUktInfo(5,
            pSeihoWebSekMosInputBean.getIwsUktkbn5(),
            pSeihoWebSekMosInputBean.getIwsUktnm5(),
            pSeihoWebSekMosInputBean.getIwsKjuktnm5(),
            pSeihoWebSekMosInputBean.getIwsUkttdkkbn5(),
            pSeihoWebSekMosInputBean.getIwsUktseiymd5(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        if (!CheckMeigininNmKana.isCheckOK(pSeihoWebSekMosInputBean.getIwsHhknnm(), hhkKojinHoujinKbn)) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1047, "被保険者カナ氏名"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        if (!"00000000".equals(pSeihoWebSekMosInputBean.getIwsNrkcalckijyunymd().toString()) &&
            !pSeihoWebSekMosInputBean.getIwsNrkcalckijyunymd().isRekijyou()) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "入力計算基準年月日"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pSeihoWebSekMosInputBean.getIwsSdpdkbn(),
            C_Sdpd.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY );

        if (!kbnInfoBean.isHenkanFlg()) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "Ｓ建Ｐ建区分"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }
        sdpdKbn = C_Sdpd.valueOf(kbnInfoBean.getKbnData());

        if ("0".equals(pSeihoWebSekMosInputBean.getIwsHaitousiharaikbn())) {
            haitouKbn = C_HaitouKbn.YUUHAI;
        }
        else if ("1".equals(pSeihoWebSekMosInputBean.getIwsHaitousiharaikbn())) {
            haitouKbn = C_HaitouKbn.RISAHAI;
        }
        else if ("2".equals(pSeihoWebSekMosInputBean.getIwsHaitousiharaikbn())) {
            haitouKbn = C_HaitouKbn.NONE;
        }
        else if ("3".equals(pSeihoWebSekMosInputBean.getIwsHaitousiharaikbn())) {
            haitouKbn = C_HaitouKbn.BLNK;
        }
        else {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "配当支払区分"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        kbnInfoBean = bzKbnHenkanUtil.convKbn(pSeihoWebSekMosInputBean.getIwsSaimankihyj(),
            C_HknkknsmnKbn.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY );

        if (!kbnInfoBean.isHenkanFlg()) {

            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, "才満期表示"), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }
        hknkknsmnKbn = C_HknkknsmnKbn.valueOf(kbnInfoBean.getKbnData());

        checkKzkInfo(1,
            pSeihoWebSekMosInputBean.getIwsKzktrkmoskbn(),
            pSeihoWebSekMosInputBean.getIwsKzkknnm1(),
            pSeihoWebSekMosInputBean.getIwsKzkkjnm1(),
            pSeihoWebSekMosInputBean.getIwsKzkseiymd1(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkKzkInfo(2,
            pSeihoWebSekMosInputBean.getIwsKzktrkmoskbn(),
            pSeihoWebSekMosInputBean.getIwsKzkknnm2(),
            pSeihoWebSekMosInputBean.getIwsKzkkjnm2(),
            pSeihoWebSekMosInputBean.getIwsKzkseiymd2(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }

        checkHhkndrInfo(pSeihoWebSekMosInputBean.getIwsHhkndrnrkkbn(),
            pSeihoWebSekMosInputBean.getIwsHhkndrtdkkbn(),
            pSeihoWebSekMosInputBean.getIwsHhkndrknnm(),
            pSeihoWebSekMosInputBean.getIwsHhkndrkjnm(),
            pSeihoWebSekMosInputBean.getIwsHhkndrseiymd(),
            pSeihoWebSekMosOutputBean);

        if (!C_SekmossakuseiErroutKbn.NONE.getValue().equals(pSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn())) {
            return;
        }
    }

    private void checkUktInfo(int pUktOrder, String pUktkbn, String pUktnm, String pKjuktnm,
        String pUkttdkkbn, BizDate pUktseiymd, WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        if ("1".equals(pUktkbn) || "2".equals(pUktkbn)) {

            String maikomiStr;

            if (pUktnm != null &&
                (pUktnm.startsWith("　") ||
                    pUktnm.contains("＊"))) {

                if ("1".equals(pUktkbn)) {
                    maikomiStr = "死亡受取人名";
                }
                else {
                    maikomiStr = "満期受取人名";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }

            if (pKjuktnm.contains("＊")) {

                if ("1".equals(pUktkbn)) {
                    maikomiStr = "漢字死亡受取人名";
                }
                else {
                    maikomiStr = "漢字満期受取人名";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }

            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            C_Tdk uktTdk = editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(pUkttdkkbn);

            if ("1".equals(pUktkbn)) {

                if (!"0".equals(pUkttdkkbn) &&
                    C_Tdk.BLNK.eq(uktTdk)) {

                    maikomiStr = "死亡受取人続柄区分";
                    pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                    pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                        ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                    pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                    return;
                }
            }
            else {
                if (!"0".equals(pUkttdkkbn) && !"8".equals(pUkttdkkbn) &&
                    C_Tdk.BLNK.eq(uktTdk)) {

                    maikomiStr = "満期受取人続柄区分";
                    pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                    pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                        ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                    pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                    return;
                }
            }

            if (pUktOrder == 1) {
                uktTdk1 = uktTdk;
            }
            else if (pUktOrder == 2) {
                uktTdk2 = uktTdk;
            }
            else if (pUktOrder == 3) {
                uktTdk3 = uktTdk;
            }
            else if (pUktOrder == 4) {
                uktTdk4 = uktTdk;
            }
            else if (pUktOrder == 5) {
                uktTdk5 = uktTdk;
            }

            if (pUktseiymd != null &&
                !"00000000".equals(pUktseiymd.toString()) &&
                !pUktseiymd.isRekijyou()) {

                if ("1".equals(pUktkbn)) {
                    maikomiStr = "死亡受取人生年月日";
                }
                else {
                    maikomiStr = "満期受取人生年月日";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }
        }
    }

    private void checkKzkInfo(int pKzkOrder, String pKzktrkmoskbn, String pKzkknnm, String pKzkkjnm,
        BizDate pKzkseiymd, WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        if ("1".equals(pKzktrkmoskbn)) {

            String maikomiStr;

            if (pKzkknnm != null &&
                (pKzkknnm.startsWith("　") ||
                    pKzkknnm.contains("＊"))) {

                if (pKzkOrder == 1) {
                    maikomiStr = "ご家族カナ氏名（１人目）";
                }
                else {
                    maikomiStr = "ご家族カナ氏名（２人目）";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }

            if (pKzkkjnm.contains("＊")) {

                if (pKzkOrder == 1) {
                    maikomiStr = "ご家族漢字氏名（１人目）";
                }
                else {
                    maikomiStr = "ご家族漢字氏名（２人目）";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }

            if (pKzkseiymd != null &&
                !"00000000".equals(pKzkseiymd.toString()) &&
                !pKzkseiymd.isRekijyou()) {

                if (pKzkOrder == 1) {
                    maikomiStr = "ご家族生年月日（１人目）";
                }
                else {
                    maikomiStr = "ご家族生年月日（２人目）";
                }
                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }
        }
    }

    private void checkHhkndrInfo(String pHhkndrnrkkbn, String pHhkndrtdkkbn, String pHhkndrknnm, String pHhkndrkjnm,
        BizDate pHhkndrseiymd, WsHbSeihoWebSekMosOutputBean pSeihoWebSekMosOutputBean) {

        String maikomiStr;

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
        C_Tdk uktTdk = editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(pHhkndrtdkkbn);

        if ("5".equals(pHhkndrnrkkbn)) {
            if (!"0".equals(pHhkndrtdkkbn) && !"7".equals(pHhkndrtdkkbn) &&
                C_Tdk.BLNK.eq(uktTdk)) {

                maikomiStr = "被代理続柄区分";

                pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                    ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
                pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

                return;
            }

        }
        if (pHhkndrknnm != null &&
            (pHhkndrknnm.startsWith("　") ||
                pHhkndrknnm.contains("＊"))) {

            maikomiStr = "被代理カナ氏名";
            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        if (pHhkndrkjnm.contains("＊")) {

            maikomiStr = "被代理漢字氏名";
            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }

        if (pHhkndrseiymd != null &&
            !"00000000".equals(pHhkndrseiymd.toString()) &&
            !pHhkndrseiymd.isRekijyou()) {

            maikomiStr = "被代理生年月日";
            pSeihoWebSekMosOutputBean.setIwsSekmossakuseierroutkbn(C_SekmossakuseiErroutKbn.GAMEN.getValue());
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg1(
                ConvertUtil.toZenAll(MessageUtil.getMessage(MessageId.EGA1006, maikomiStr), 1, 1));
            pSeihoWebSekMosOutputBean.setIwsSekmoserrormsg2("");

            return;
        }
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
