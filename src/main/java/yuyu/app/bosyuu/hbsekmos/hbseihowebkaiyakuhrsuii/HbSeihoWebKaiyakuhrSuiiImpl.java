package yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.WSuiihyou;
import yuyu.common.hozen.khcommon.WSuiihyouParam;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin2;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebKaiyakuhrSuiiInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebKaiyakuhrSuiiOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 生保Ｗｅｂ解約返戻金推移表作成サービスの実装クラスです。<br />
 */
public class HbSeihoWebKaiyakuhrSuiiImpl implements HbSeihoWebKaiyakuhrSuii {

    private static final String SEIJOU = "0";

    private static final String ERROR = "1";

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {
            logger.debug("▽ 生保Ｗｅｂ解約返戻金推移表作成 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebKaiyakuhrSuiiInputBean seihoWebKaiyakuhrSuiiInputBean;
            try {
                seihoWebKaiyakuhrSuiiInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebKaiyakuhrSuiiInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    CvtVdtException cvtVdtException = (CvtVdtException)e.getCause();

                    String cvtMessage = cvtVdtException.getMessages()[0].getMessage();

                    String koumokuNm = getKoumoku(cvtMessage);
                    String message = MessageUtil.getMessage(MessageId.EGA1006, koumokuNm);

                    return creatResponseError(ERROR, message, "");
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput = SWAKInjector
                .getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean,
                seihoWebKaiyakuhrSuiiInputBean);

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen = SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);
            C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen
                .execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn)) {
                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(ERROR,
                    MessageUtil.getMessage(MessageId.EGA1006, "端末権限"), "");
                return wsBzWebserviceResParamBean;
            }
            else if (C_SeihowebkengenKbn.SIYOUSHAERROR.eq(seihowebkengenKbn)) {
                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(ERROR,
                    MessageUtil.getMessage(MessageId.EGA1006, "使用者権限"), "");
                return wsBzWebserviceResParamBean;
            }


            C_UmuKbn syksbyenSitihsyutktekiUmu;
            if ("1".equals(seihoWebKaiyakuhrSuiiInputBean.getIwsSyksbyensitihsyutkykhyj())) {
                syksbyenSitihsyutktekiUmu = C_UmuKbn.ARI;
            }
            else {
                syksbyenSitihsyutktekiUmu = C_UmuKbn.NONE;
            }

            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

            C_Tuukasyu tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(seihoWebKaiyakuhrSuiiInputBean.getIwsKyktuukakbn());

            C_HknsyuruiNo hknSyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(
                seihoWebKaiyakuhrSuiiInputBean.getIwsDisphokensyuruino());

            BizDate mosymd = seihoWebKaiyakuhrSuiiInputBean.getIwsSeksakuseiymd();

            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(hknSyuruino, mosymd);

            if (skHokenSyuruiNoLst.size() == 0) {

                logger.error(creatErrorMsg("保険種類マスタ取得　0件" , wsBzWebserviceReqParamBean));

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                    creatResponseError(ERROR, MessageUtil.getMessage(MessageId.EGC1002), "");

                return wsBzWebserviceResParamBean;
            }

            HM_SkHokenSyuruiNo skHokenSyuruiNo = skHokenSyuruiNoLst.get(0);

            List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByKykymdItems(
                seihoWebKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymd(),
                C_SyutkKbn.SYU,
                skHokenSyuruiNo.getDaihyouhknsyuruino(),
                0,
                Integer.parseInt(seihoWebKaiyakuhrSuiiInputBean.getIwsHknkkn1()),
                tuukasyu,
                syksbyenSitihsyutktekiUmu,
                C_Sknenkinsyu.BLNK,
                C_UmuKbn.NONE);

            if (syouhnZokuseiLst.size() == 0) {
                logger.error(creatErrorMsg("商品属性マスタ取得　0件" , wsBzWebserviceReqParamBean));

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                    creatResponseError(ERROR, MessageUtil.getMessage(MessageId.EGC1002), "");

                return wsBzWebserviceResParamBean;
            }

            BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

            BizNumber kykjiYoteiRiritu = seihoWebKaiyakuhrSuiiInputBean.getIwsKykjiyoteiriritu().divide(10000);
            BizNumber kykjitumitateriritu = seihoWebKaiyakuhrSuiiInputBean.getIwsKykjitumitateriritu().divide(10000);

            C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(seihoWebKaiyakuhrSuiiInputBean.getIwsHaraikomikaisuukbn());

            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(seihoWebKaiyakuhrSuiiInputBean.getIwsSaimankihyj(),
                C_HknkknsmnKbn.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);
            if (!kbnInfoBean.isHenkanFlg()) {
                WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                    creatResponseError(ERROR, MessageUtil.getMessage(MessageId.EGA1006, "才満期表示"), "");

                return wsBzWebserviceResParamBean;
            }
            C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.valueOf(kbnInfoBean.getKbnData());

            int hknkkn = Integer.parseInt(seihoWebKaiyakuhrSuiiInputBean.getIwsHknkkn());
            int haraikomiKikan = Integer.parseInt(seihoWebKaiyakuhrSuiiInputBean.getIwsPharaikomikikan());
            C_Hhknsei hhknsei = editSeihoWebRenkeiKoumoku.hhknseiHenkan(seihoWebKaiyakuhrSuiiInputBean.getIwsHhknseikbn());

            BizCurrency kihonS;
            BizCurrency kihonP;
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            if (C_Tuukasyu.JPY.equals(tuukasyu)) {
                kihonS = BizCurrency.valueOf(new BigDecimal(seihoWebKaiyakuhrSuiiInputBean.getIwsMoss()));
                kihonP = BizCurrency.valueOf(new BigDecimal(seihoWebKaiyakuhrSuiiInputBean.getIwsKihonp().toString()));
            }
            else {
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukasyu);

                kihonS = BizCurrency.valueOf(new BigDecimal(
                    seihoWebKaiyakuhrSuiiInputBean.getIwsGaikamoss().toString()).divide(new BigDecimal("100")), currencyType);
                kihonP = BizCurrency.valueOf(new BigDecimal(
                    seihoWebKaiyakuhrSuiiInputBean.getIwsGaikakihonp().toString()).divide(new BigDecimal("100")), currencyType);
            }

            BizDate kykYmd   = seihoWebKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymd();
            BizDate calckijyunYmd   = seihoWebKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymd();

            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            int hhknnen = setNenrei.exec(calckijyunYmd, BizDate.valueOf(seihoWebKaiyakuhrSuiiInputBean.getIwsDisphhknseiymd()));

            int keikaNensuu = 0;
            int maxKeikaNensuu = 105 - hhknnen;

            BizNumber kykjiSjkkktyusiRrt = seihoWebKaiyakuhrSuiiInputBean.getIwsKykjisjkkktyusirrt().divide(10000);
            if (C_HugouKbn.HU.eq(seihoWebKaiyakuhrSuiiInputBean.getIwsKykjisjkkktyusirrtfgu())) {
                kykjiSjkkktyusiRrt = kykjiSjkkktyusiRrt.multiply(-1);
            }

            WSuiihyou wSuiihyou = SWAKInjector.getInstance(WSuiihyou.class);

            WSuiihyouSyuusin2 wSuiihyouSyuusin2 = SWAKInjector.getInstance(WSuiihyouSyuusin2.class);

            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

            WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

            List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

            if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI.eq(hknSyuruino)) {

                wSuiihyou.setYenkansannYhKbn(C_YouhiKbn.HUYOU);

                keisanWExtBean.setSyouhncd(syouhnZokusei.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(syouhnZokusei.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(syouhnZokusei.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(kykjiYoteiRiritu);
                keisanWExtBean.setHrkkaisuu(hrkkaisuu);
                keisanWExtBean.setHknkknsmnkbn(hknkknsmnKbn);
                keisanWExtBean.setHrkkkn(haraikomiKikan);
                keisanWExtBean.setHknkkn(hknkkn);
                keisanWExtBean.setHhknnen(hhknnen);
                keisanWExtBean.setHhknsei(hhknsei);
                keisanWExtBean.setKihons(kihonS);
                keisanWExtBean.setKykymd(kykYmd);
                keisanWExtBean.setTuukasyu(tuukasyu);
                keisanWExtBean.setKyksjkkktyouseiriritu(kykjiSjkkktyusiRrt);

                wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
                wSuiihyouParam.setKwsratekjymd(null);
                wSuiihyouParam.setCalcKijyunYmd(calckijyunYmd);
                wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
                wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
                wSuiihyouParam.setMvaTekiUmu(syouhnZokusei.getMvatekiumu());
                wSuiihyouParam.setMvaTekiKkn(syouhnZokusei.getMvatekikkn());

                try {
                    wsuiihyouLst = wSuiihyou.exec(wSuiihyouParam);

                } catch(Exception e) {

                    errHukaMsg = creatErrorMsg("解約返戻金取得エラー" , wsBzWebserviceReqParamBean);

                    throw e;
                }
            }
            else if (C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI.eq(hknSyuruino)) {

                wSuiihyouSyuusin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);

                keisanWExtBean.setSyouhncd(syouhnZokusei.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(syouhnZokusei.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(syouhnZokusei.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(kykjiYoteiRiritu);
                keisanWExtBean.setHrkkaisuu(hrkkaisuu);
                keisanWExtBean.setHknkknsmnkbn(hknkknsmnKbn);
                keisanWExtBean.setHrkkkn(haraikomiKikan);
                keisanWExtBean.setHknkkn(hknkkn);
                keisanWExtBean.setHhknnen(hhknnen);
                keisanWExtBean.setHhknsei(hhknsei);
                keisanWExtBean.setKihons(kihonS);
                keisanWExtBean.setHokenryou(kihonP);
                keisanWExtBean.setKykymd(kykYmd);
                keisanWExtBean.setTuukasyu(tuukasyu);
                keisanWExtBean.setKyksjkkktyouseiriritu(kykjiSjkkktyusiRrt);
                keisanWExtBean.setTumitateriritu(kykjitumitateriritu);

                wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
                wSuiihyouParam.setKwsratekjymd(null);
                wSuiihyouParam.setCalcKijyunYmd(calckijyunYmd);
                wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
                wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
                wSuiihyouParam.setMvaTekiUmu(syouhnZokusei.getMvatekiumu());
                wSuiihyouParam.setMvaTekiKkn(syouhnZokusei.getMvatekikkn());

                try {
                    wsuiihyouLst = wSuiihyouSyuusin2.exec(wSuiihyouParam);

                } catch(Exception e) {

                    errHukaMsg = creatErrorMsg("解約返戻金取得エラー" , wsBzWebserviceReqParamBean);

                    throw e;
                }
            }
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = null;

            try {
                wsBzWebserviceResParamBean = creatResponseSeijou(wsuiihyouLst);
            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                creatResponseError(ERROR, MessageUtil.getMessage(MessageId.EGC1002), "");

            return wsBzWebserviceResParamBean;
        }
    }

    private String getKoumoku(String pMsg) {

        int begin = pMsg.indexOf(":") + 1;
        int end = pMsg.indexOf(" ", begin);

        String koumokuId = pMsg.substring(begin, end);

        String koumokuNm = getKoumokuNm(koumokuId);

        if (koumokuNm.contains("（ＩＷＳ）")) {

            koumokuNm = koumokuNm.replace("（ＩＷＳ）", "");
        }

        return koumokuNm;
    }

    private String getKoumokuNm(String pKoumokuId) {

        Map<String, String> koumokuNmMap = new HashMap<String, String>();

        koumokuNmMap.put("iwsDrtentyouhyougyoutaikbn", "（ＩＷＳ）代理店帳票用業態区分");
        koumokuNmMap.put("iwsDispkykseiymd", "（ＩＷＳ）（表示用）契約者生年月日");
        koumokuNmMap.put("iwsKyksyaseikbn", "（ＩＷＳ）契約者性別区分");
        koumokuNmMap.put("iwsDisphhknseiymd", "（ＩＷＳ）（表示用）被保険者生年月日");
        koumokuNmMap.put("iwsHhknseikbn", "（ＩＷＳ）被保険者性別区分");
        koumokuNmMap.put("iwsDisphokensyuruino", "（ＩＷＳ）（表示用）保険種類番号");
        koumokuNmMap.put("iwsNrkcalckijyunymd", "（ＩＷＳ）入力計算基準年月日");
        koumokuNmMap.put("iwsSeksakuseiymd", "（ＩＷＳ）設計書作成年月日");
        koumokuNmMap.put("iwsBosyuuym", "（ＩＷＳ）募集年月");
        koumokuNmMap.put("iwsHjkktkbn", "（ＩＷＳ）報状告知区分");
        koumokuNmMap.put("iwsSdpdkbn", "（ＩＷＳ）Ｓ建Ｐ建区分");
        koumokuNmMap.put("iwsHaitousiharaikbn", "（ＩＷＳ）配当支払区分");
        koumokuNmMap.put("iwsMoss", "（ＩＷＳ）申込Ｓ");
        koumokuNmMap.put("iwsGaikamoss", "（ＩＷＳ）外貨申込Ｓ");
        koumokuNmMap.put("iwsKihonp", "（ＩＷＳ）基本Ｐ");
        koumokuNmMap.put("iwsGaikakihonp", "（ＩＷＳ）外貨基本Ｐ");
        koumokuNmMap.put("iwsKyktuukakbn", "（ＩＷＳ）契約通貨区分");
        koumokuNmMap.put("iwsHrktuukakbn", "（ＩＷＳ）払込通貨区分");
        koumokuNmMap.put("iwsSaimankihyj", "（ＩＷＳ）才満期表示");
        koumokuNmMap.put("iwsHknkkn", "（ＩＷＳ）保険期間");
        koumokuNmMap.put("iwsPharaikomikikan", "（ＩＷＳ）Ｐ払込期間");
        koumokuNmMap.put("iwsHaraikomikaisuukbn", "（ＩＷＳ）払込回数区分");
        koumokuNmMap.put("iwsHrkkeirokbn", "（ＩＷＳ）払込経路区分");
        koumokuNmMap.put("iwsTksykmcd1", "（ＩＷＳ）特殊項目コード１");
        koumokuNmMap.put("iwsTksykmcd2", "（ＩＷＳ）特殊項目コード２");
        koumokuNmMap.put("iwsTksykmcd3", "（ＩＷＳ）特殊項目コード３");
        koumokuNmMap.put("iwsTksykmcd4", "（ＩＷＳ）特殊項目コード４");
        koumokuNmMap.put("iwsTksykmcd5", "（ＩＷＳ）特殊項目コード５");
        koumokuNmMap.put("iwsSekmossakuseikbn", "（ＩＷＳ）設計書申込書作成区分");
        koumokuNmMap.put("iwsSekno", "（ＩＷＳ）設計書番号");
        koumokuNmMap.put("iwsKykjiyoteiriritu", "（ＩＷＳ）契約時予定利率");
        koumokuNmMap.put("iwsKykjisjkkktyusirrtfgu", "（ＩＷＳ）契約時市場価格調整用利率負号");
        koumokuNmMap.put("iwsKykjisjkkktyusirrt", "（ＩＷＳ）契約時市場価格調整用利率");
        koumokuNmMap.put("iwsHknkkn1", "（ＩＷＳ）第１保険期間");
        koumokuNmMap.put("iwsSyksbyensitihsyutkykhyj", "（ＩＷＳ）初期死亡時円換算最低保証特約有表示");
        koumokuNmMap.put("iwsKykjitumitateriritu", "（ＩＷＳ）契約時積立利率");

        String koumokuNm = koumokuNmMap.get(pKoumokuId);

        return koumokuNm;
    }

    private WsBzWebserviceResParamBean creatResponseError(
        String pErrorKbn,
        String pMsg1,
        String pMst2) {

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
        WsHbSeihoWebKaiyakuhrSuiiOutputBean seihoWebKaiyakuhrSuiiOutputBean =
            SWAKInjector.getInstance(WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);

        initOutputBean(seihoWebKaiyakuhrSuiiOutputBean);
        seihoWebKaiyakuhrSuiiOutputBean.setIwsErrkbn(pErrorKbn);
        seihoWebKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg1(pMsg1);
        seihoWebKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg2(pMst2);

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebKaiyakuhrSuiiOutputBean));

        logger.debug("△ 生保Ｗｅｂ解約返戻金推移表作成 終了");

        return wsBzWebserviceResParamBean;
    }

    private WsBzWebserviceResParamBean creatResponseSeijou(List<IT_Suiihyou> pKaiyakuHenreiKinBeanLst) {

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
        WsHbSeihoWebKaiyakuhrSuiiOutputBean seihoWebKaiyakuhrSuiiOutputBean =
            SWAKInjector.getInstance(WsHbSeihoWebKaiyakuhrSuiiOutputBean.class);
        initOutputBean(seihoWebKaiyakuhrSuiiOutputBean);
        seihoWebKaiyakuhrSuiiOutputBean.setIwsErrkbn(SEIJOU);

        IT_Suiihyou suiihyou;
        for (int index = 0; index < pKaiyakuHenreiKinBeanLst.size(); index++) {
            suiihyou = pKaiyakuHenreiKinBeanLst.get(index);

            if(index == 0) {
                BizNumber zero = BizNumber.valueOf(0);

                if(suiihyou.getSjkkktusirrtsame().compareTo(zero) == -1) {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn1(C_HugouKbn.HU);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt1(suiihyou.getSjkkktusirrtsame().multiply(-10000));
                } else {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn1(C_HugouKbn.SEI);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt1(suiihyou.getSjkkktusirrtsame().multiply(10000));
                }

                if(suiihyou.getSjkkktusirrtup().compareTo(zero) == -1) {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn2(C_HugouKbn.HU);

                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt2(suiihyou.getSjkkktusirrtup().multiply(-10000));
                } else {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn2(C_HugouKbn.SEI);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt2(suiihyou.getSjkkktusirrtup().multiply(10000));
                }

                if(suiihyou.getSjkkktusirrtdown().compareTo(zero) == -1) {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn3(C_HugouKbn.HU);

                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt3(suiihyou.getSjkkktusirrtdown().multiply(-10000));
                } else {
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn3(C_HugouKbn.SEI);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt3(suiihyou.getSjkkktusirrtdown().multiply(10000));
                }

            }

            C_MvaTekiyoujyoutaiKbn mvaTkyjutikbn = suiihyou.getMvatekijyoutaikbn();

            if(C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTkyjutikbn)) {
                seihoWebKaiyakuhrSuiiOutputBean.setIwsMvatkykknmnryutykgw(BizNumber.valueOf(suiihyou.getMvanonewsame()).multiply(100));
                seihoWebKaiyakuhrSuiiOutputBean.setIwsMvatkykknmnryutykgv(BizNumber.valueOf(suiihyou.getMvanoneptumitatekin()).multiply(100));

            }


            BizNumber iwsMaitosikaiyakuhr1 = BizNumber.valueOf(0);
            BizNumber iwsMaitosikaiyakuhr2 = BizNumber.valueOf(0);
            BizNumber iwsMaitosikaiyakuhr3 = BizNumber.valueOf(0);
            BizNumber iwsMaitositumitatekin = BizNumber.valueOf(0);

            if(!C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTkyjutikbn)) {
                iwsMaitosikaiyakuhr1 = BizNumber.valueOf(suiihyou.getMvaariwsame().multiply(100));
                iwsMaitosikaiyakuhr2 = BizNumber.valueOf(suiihyou.getMvaariwup().multiply(100));
                iwsMaitosikaiyakuhr3 = BizNumber.valueOf(suiihyou.getMvaariwdown().multiply(100));
                iwsMaitositumitatekin = BizNumber.valueOf(suiihyou.getMvaariptumitatekin().multiply(100));
            } else {
                iwsMaitosikaiyakuhr1 = BizNumber.valueOf(suiihyou.getMvanonewsame().multiply(100));
                iwsMaitosikaiyakuhr2 = BizNumber.valueOf(suiihyou.getMvanonewsame().multiply(100));
                iwsMaitosikaiyakuhr3 = BizNumber.valueOf(suiihyou.getMvanonewsame().multiply(100));
                iwsMaitositumitatekin = BizNumber.valueOf(suiihyou.getMvanoneptumitatekin().multiply(100));
            }

            switch(index) {
                case 0:

                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x1(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x1(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x1(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x1(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x1(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x1(iwsMaitositumitatekin);
                    break;
                case 1:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x2(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x2(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x2(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x2(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x2(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x2(iwsMaitositumitatekin);
                    break;
                case 2:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x3(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x3(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x3(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x3(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x3(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x3(iwsMaitositumitatekin);
                    break;
                case 3:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x4(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x4(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x4(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x4(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x4(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x4(iwsMaitositumitatekin);
                    break;
                case 4:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x5(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x5(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x5(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x5(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x5(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x5(iwsMaitositumitatekin);
                    break;
                case 5:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x6(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x6(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x6(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x6(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x6(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x6(iwsMaitositumitatekin);
                    break;
                case 6:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x7(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x7(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x7(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x7(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x7(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x7(iwsMaitositumitatekin);
                    break;
                case 7:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x8(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x8(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x8(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x8(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x8(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x8(iwsMaitositumitatekin);
                    break;
                case 8:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x9(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x9(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x9(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x9(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x9(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x9(iwsMaitositumitatekin);
                    break;
                case 9:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x10(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x10(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x10(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x10(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x10(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x10(iwsMaitositumitatekin);
                    break;
                case 10:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x11(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x11(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x11(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x11(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x11(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x11(iwsMaitositumitatekin);
                    break;
                case 11:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x12(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x12(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x12(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x12(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x12(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x12(iwsMaitositumitatekin);
                    break;
                case 12:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x13(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x13(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x13(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x13(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x13(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x13(iwsMaitositumitatekin);
                    break;
                case 13:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x14(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x14(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x14(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x14(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x14(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x14(iwsMaitositumitatekin);
                    break;
                case 14:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x15(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x15(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x15(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x15(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x15(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x15(iwsMaitositumitatekin);
                    break;
                case 15:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x16(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x16(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x16(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x16(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x16(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x16(iwsMaitositumitatekin);
                    break;
                case 16:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x17(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x17(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x17(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x17(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x17(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x17(iwsMaitositumitatekin);
                    break;
                case 17:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x18(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x18(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x18(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x18(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x18(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x18(iwsMaitositumitatekin);
                    break;
                case 18:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x19(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x19(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x19(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x19(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x19(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x19(iwsMaitositumitatekin);
                    break;
                case 19:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x20(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x20(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x20(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x20(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x20(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x20(iwsMaitositumitatekin);
                    break;
                case 20:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x21(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x21(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x21(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x21(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x21(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x21(iwsMaitositumitatekin);
                    break;
                case 21:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x22(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x22(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x22(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x22(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x22(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x22(iwsMaitositumitatekin);
                    break;
                case 22:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x23(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x23(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x23(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x23(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x23(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x23(iwsMaitositumitatekin);
                    break;
                case 23:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x24(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x24(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x24(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x24(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x24(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x24(iwsMaitositumitatekin);
                    break;
                case 24:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x25(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x25(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x25(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x25(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x25(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x25(iwsMaitositumitatekin);
                    break;
                case 25:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x26(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x26(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x26(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x26(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x26(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x26(iwsMaitositumitatekin);
                    break;
                case 26:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x27(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x27(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x27(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x27(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x27(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x27(iwsMaitositumitatekin);
                    break;
                case 27:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x28(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x28(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x28(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x28(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x28(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x28(iwsMaitositumitatekin);
                    break;
                case 28:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x29(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x29(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x29(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x29(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x29(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x29(iwsMaitositumitatekin);
                    break;
                case 29:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x30(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x30(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x30(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x30(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x30(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x30(iwsMaitositumitatekin);
                    break;
                case 30:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x31(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x31(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x31(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x31(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x31(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x31(iwsMaitositumitatekin);
                    break;
                case 31:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x32(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x32(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x32(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x32(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x32(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x32(iwsMaitositumitatekin);
                    break;
                case 32:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x33(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x33(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x33(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x33(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x33(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x33(iwsMaitositumitatekin);
                    break;
                case 33:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x34(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x34(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x34(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x34(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x34(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x34(iwsMaitositumitatekin);
                    break;
                case 34:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x35(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x35(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x35(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x35(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x35(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x35(iwsMaitositumitatekin);
                    break;
                case 35:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x36(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x36(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x36(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x36(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x36(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x36(iwsMaitositumitatekin);
                    break;
                case 36:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x37(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x37(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x37(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x37(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x37(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x37(iwsMaitositumitatekin);
                    break;
                case 37:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x38(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x38(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x38(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x38(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x38(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x38(iwsMaitositumitatekin);
                    break;
                case 38:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x39(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x39(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x39(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x39(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x39(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x39(iwsMaitositumitatekin);
                    break;
                case 39:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x40(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x40(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x40(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x40(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x40(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x40(iwsMaitositumitatekin);
                    break;
                case 40:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x41(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x41(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x41(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x41(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x41(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x41(iwsMaitositumitatekin);
                    break;
                case 41:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x42(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x42(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x42(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x42(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x42(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x42(iwsMaitositumitatekin);
                    break;
                case 42:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x43(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x43(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x43(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x43(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x43(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x43(iwsMaitositumitatekin);
                    break;
                case 43:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x44(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x44(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x44(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x44(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x44(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x44(iwsMaitositumitatekin);
                    break;
                case 44:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x45(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x45(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x45(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x45(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x45(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x45(iwsMaitositumitatekin);
                    break;
                case 45:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x46(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x46(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x46(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x46(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x46(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x46(iwsMaitositumitatekin);
                    break;
                case 46:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x47(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x47(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x47(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x47(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x47(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x47(iwsMaitositumitatekin);
                    break;
                case 47:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x48(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x48(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x48(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x48(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x48(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x48(iwsMaitositumitatekin);
                    break;
                case 48:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x49(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x49(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x49(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x49(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x49(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x49(iwsMaitositumitatekin);
                    break;
                case 49:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x50(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x50(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x50(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x50(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x50(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x50(iwsMaitositumitatekin);
                    break;
                case 50:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x51(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x51(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x51(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x51(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x51(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x51(iwsMaitositumitatekin);
                    break;
                case 51:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x52(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x52(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x52(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x52(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x52(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x52(iwsMaitositumitatekin);
                    break;
                case 52:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x53(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x53(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x53(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x53(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x53(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x53(iwsMaitositumitatekin);
                    break;
                case 53:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x54(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x54(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x54(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x54(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x54(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x54(iwsMaitositumitatekin);
                    break;
                case 54:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x55(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x55(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x55(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x55(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x55(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x55(iwsMaitositumitatekin);
                    break;
                case 55:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x56(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x56(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x56(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x56(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x56(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x56(iwsMaitositumitatekin);
                    break;
                case 56:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x57(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x57(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x57(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x57(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x57(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x57(iwsMaitositumitatekin);
                    break;
                case 57:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x58(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x58(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x58(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x58(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x58(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x58(iwsMaitositumitatekin);
                    break;
                case 58:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x59(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x59(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x59(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x59(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x59(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x59(iwsMaitositumitatekin);
                    break;
                case 59:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x60(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x60(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x60(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x60(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x60(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x60(iwsMaitositumitatekin);
                    break;
                case 60:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x61(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x61(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x61(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x61(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x61(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x61(iwsMaitositumitatekin);
                    break;
                case 61:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x62(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x62(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x62(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x62(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x62(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x62(iwsMaitositumitatekin);
                    break;
                case 62:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x63(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x63(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x63(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x63(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x63(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x63(iwsMaitositumitatekin);
                    break;
                case 63:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x64(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x64(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x64(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x64(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x64(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x64(iwsMaitositumitatekin);
                    break;
                case 64:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x65(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x65(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x65(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x65(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x65(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x65(iwsMaitositumitatekin);
                    break;
                case 65:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x66(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x66(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x66(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x66(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x66(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x66(iwsMaitositumitatekin);
                    break;
                case 66:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x67(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x67(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x67(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x67(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x67(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x67(iwsMaitositumitatekin);
                    break;
                case 67:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x68(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x68(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x68(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x68(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x68(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x68(iwsMaitositumitatekin);
                    break;
                case 68:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x69(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x69(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x69(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x69(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x69(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x69(iwsMaitositumitatekin);
                    break;
                case 69:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x70(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x70(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x70(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x70(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x70(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x70(iwsMaitositumitatekin);
                    break;
                case 70:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x71(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x71(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x71(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x71(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x71(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x71(iwsMaitositumitatekin);
                    break;
                case 71:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x72(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x72(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x72(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x72(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x72(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x72(iwsMaitositumitatekin);
                    break;
                case 72:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x73(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x73(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x73(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x73(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x73(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x73(iwsMaitositumitatekin);
                    break;
                case 73:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x74(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x74(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x74(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x74(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x74(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x74(iwsMaitositumitatekin);
                    break;
                case 74:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x75(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x75(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x75(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x75(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x75(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x75(iwsMaitositumitatekin);
                    break;
                case 75:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x76(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x76(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x76(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x76(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x76(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x76(iwsMaitositumitatekin);
                    break;
                case 76:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x77(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x77(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x77(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x77(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x77(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x77(iwsMaitositumitatekin);
                    break;
                case 77:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x78(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x78(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x78(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x78(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x78(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x78(iwsMaitositumitatekin);
                    break;
                case 78:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x79(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x79(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x79(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x79(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x79(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x79(iwsMaitositumitatekin);
                    break;
                case 79:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x80(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x80(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x80(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x80(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x80(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x80(iwsMaitositumitatekin);
                    break;
                case 80:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x81(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x81(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x81(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x81(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x81(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x81(iwsMaitositumitatekin);
                    break;
                case 81:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x82(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x82(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x82(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x82(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x82(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x82(iwsMaitositumitatekin);
                    break;
                case 82:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x83(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x83(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x83(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x83(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x83(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x83(iwsMaitositumitatekin);
                    break;
                case 83:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x84(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x84(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x84(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x84(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x84(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x84(iwsMaitositumitatekin);
                    break;
                case 84:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x85(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x85(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x85(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x85(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x85(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x85(iwsMaitositumitatekin);
                    break;
                case 85:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x86(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x86(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x86(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x86(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x86(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x86(iwsMaitositumitatekin);
                    break;
                case 86:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x87(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x87(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x87(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x87(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x87(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x87(iwsMaitositumitatekin);
                    break;
                case 87:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x88(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x88(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x88(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x88(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x88(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x88(iwsMaitositumitatekin);
                    break;
                case 88:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x89(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x89(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x89(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x89(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x89(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x89(iwsMaitositumitatekin);
                    break;
                case 89:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x90(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x90(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x90(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x90(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x90(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x90(iwsMaitositumitatekin);
                    break;
                case 90:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x91(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x91(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x91(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x91(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x91(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x91(iwsMaitositumitatekin);
                    break;
                case 91:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x92(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x92(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x92(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x92(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x92(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x92(iwsMaitositumitatekin);
                    break;
                case 92:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x93(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x93(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x93(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x93(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x93(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x93(iwsMaitositumitatekin);
                    break;
                case 93:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x94(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x94(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x94(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x94(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x94(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x94(iwsMaitositumitatekin);
                    break;
                case 94:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x95(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x95(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x95(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x95(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x95(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x95(iwsMaitositumitatekin);
                    break;
                case 95:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x96(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x96(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x96(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x96(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x96(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x96(iwsMaitositumitatekin);
                    break;
                case 96:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x97(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x97(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x97(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x97(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x97(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x97(iwsMaitositumitatekin);
                    break;
                case 97:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x98(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x98(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x98(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x98(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x98(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x98(iwsMaitositumitatekin);
                    break;
                case 98:
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x99(iwsMaitosikaiyakuhr1);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x99(iwsMaitosikaiyakuhr2);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x99(iwsMaitosikaiyakuhr3);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x99(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x99(iwsMaitositumitatekin);
                    seihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x99(iwsMaitositumitatekin);
                    break;
                default :
            }

        }

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebKaiyakuhrSuiiOutputBean));

        logger.debug("△ 生保Ｗｅｂ解約返戻金推移表作成 終了" + wsBzWebserviceResParamBean.getGyoumuData());

        return wsBzWebserviceResParamBean;
    }

    private void initOutputBean(WsHbSeihoWebKaiyakuhrSuiiOutputBean pWsHbSeihoWebKaiyakuhrSuiiOutputBean) {
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsErrkbn(SEIJOU);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg1("　");
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg2("　");

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr1x99(BizNumber.ZERO);

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr2x99(BizNumber.ZERO);

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitosikaiyakuhr3x99(BizNumber.ZERO);

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin1x99(BizNumber.ZERO);

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin2x99(BizNumber.ZERO);

        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x3(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x4(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x5(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x6(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x7(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x8(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x9(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x10(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x11(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x12(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x13(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x14(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x15(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x16(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x17(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x18(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x19(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x20(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x21(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x22(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x23(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x24(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x25(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x26(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x27(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x28(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x29(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x30(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x31(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x32(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x33(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x34(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x35(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x36(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x37(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x38(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x39(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x40(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x41(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x42(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x43(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x44(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x45(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x46(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x47(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x48(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x49(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x50(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x51(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x52(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x53(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x54(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x55(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x56(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x57(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x58(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x59(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x60(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x61(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x62(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x63(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x64(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x65(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x66(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x67(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x68(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x69(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x70(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x71(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x72(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x73(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x74(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x75(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x76(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x77(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x78(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x79(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x80(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x81(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x82(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x83(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x84(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x85(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x86(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x87(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x88(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x89(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x90(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x91(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x92(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x93(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x94(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x95(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x96(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x97(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x98(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMaitositumitatekin3x99(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMvatkykknmnryutykgw(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsMvatkykknmnryutykgv(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn1(C_HugouKbn.SEI);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt1(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn2(C_HugouKbn.SEI);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt2(BizNumber.ZERO);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrtfgukbn3(C_HugouKbn.SEI);
        pWsHbSeihoWebKaiyakuhrSuiiOutputBean.setIwsKykjsjkkktyusirrt3(BizNumber.ZERO);

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
