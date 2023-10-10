package yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.SibouSBean;
import yuyu.common.hozen.khcommon.WSuiihyouParam;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin3;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
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
 * 生保Ｗｅｂ平準払終身用解約返戻金推移表作成サービスの実装クラスです。<br />
 */
public class HbSeihoWebHeijyunKaiyakuhrSuiiImpl implements HbSeihoWebHeijyunKaiyakuhrSuii {

    private static final String ERRORKBN_SEIJOU = "0";

    private static final String ERRORKBN_KEISANERR = "1";

    private static final String ZENKAKUSPACE  = "　";

    private C_Tuukasyu tuukaSyu;

    private BizCurrency kihonS;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        String errHukaMsg = "";

        try {
            logger.debug("▽ 生保Ｗｅｂ平準払終身用解約返戻金推移表作成 開始");

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector
                .getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean;

            try {
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
                    gyoumuData, WsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.class);

            } catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    CvtVdtException cvtVdtException = (CvtVdtException)e.getCause();

                    String cvtMessage = cvtVdtException.getMessages()[0].getMessage();

                    String koumokuNm = getKoumoku(cvtMessage);

                    String message = MessageUtil.getMessage(MessageId.EGA1006, koumokuNm);

                    return creatResponseError(ERRORKBN_KEISANERR, message, "");
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput = SWAKInjector
                .getInstance(WebServiceAccesslogOutput.class);

            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN
                , wsBzWebserviceReqParamBean
                , wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean);

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen = SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);
            C_SeihowebkengenKbn seihowebkengenKbn =
                hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn)) {

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGA1006, "端末権限"), "");

                return wsBzWebserviceResParamBean;
            }
            else if (C_SeihowebkengenKbn.SIYOUSHAERROR.eq(seihowebkengenKbn)) {

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGA1006, "使用者権限"), "");

                return wsBzWebserviceResParamBean;
            }

            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku = SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            C_HknsyuruiNo hknsyuruiNo = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsDisphokensyuruino());

            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager
                .getSkHokenSyuruiNosByHknsyuruinoHyoujidate(
                    hknsyuruiNo, BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsSyoriymdstr()));

            if (skHokenSyuruiNoLst.size() == 0) {

                errHukaMsg = creatErrorMsg("保険種類マスタ取得　0件", wsBzWebserviceReqParamBean);

                logger.error(errHukaMsg);

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGC1002), "");

                return wsBzWebserviceResParamBean;
            }

            HM_SkHokenSyuruiNo skHokenSyuruiNo = skHokenSyuruiNoLst.get(0);

            List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisByKykymdItems2(
                BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymdstr()),
                C_SyutkKbn.SYU,
                skHokenSyuruiNo.getDaihyouhknsyuruino(),
                0,
                C_UmuKbn.NONE,
                C_Sknenkinsyu.BLNK,
                C_UmuKbn.NONE);

            if (syouhnZokuseiLst.size() == 0) {

                errHukaMsg = creatErrorMsg("商品属性マスタ取得　0件", wsBzWebserviceReqParamBean);

                logger.debug(errHukaMsg);

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGC1002), "");

                return wsBzWebserviceResParamBean;
            }

            BM_SyouhnZokusei syouhnZokusei = syouhnZokuseiLst.get(0);

            BizNumber kykjiYoteiriRitu = BizNumber.valueOf(
                Integer.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsKykjiyoteiriritustr())).divide(10000);

            C_Hrkkaisuu hrkkaisuu = editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsHaraikomikaisuukbn());

            C_Hrkkeiro hrkkeiro = editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsHrkkeirokbn());

            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

            KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsSaimankihyj(),
                C_HknkknsmnKbn.class,
                C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

            if (!kbnInfoBean.isHenkanFlg()) {

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGA1006, "才満期表示"), "");

                return wsBzWebserviceResParamBean;
            }

            C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.valueOf(kbnInfoBean.getKbnData());

            C_HrkkknsmnKbn hrkkknsmnKbn = editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(hknsyuruiNo,
                Integer.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsPharaikomikikan()));

            kbnInfoBean = bzKbnHenkanUtil.convKbn(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsSdpdkbn(),
                C_Sdpd.class,
                C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

            if (!kbnInfoBean.isHenkanFlg()) {

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                    ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGA1006, "Ｓ建Ｐ建区分"), "");

                return wsBzWebserviceResParamBean;
            }
            C_Sdpd sdpd = C_Sdpd.valueOf(kbnInfoBean.getKbnData());

            C_Hhknsei hhknSei = editSeihoWebRenkeiKoumoku.hhknseiHenkan(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsHhknseikbn());

            tuukaSyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsKyktuukakbn());

            C_UmuKbn zennouUmu = C_UmuKbn.ARI;

            if ("0".equals(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsZennouhyouji())) {

                zennouUmu = C_UmuKbn.NONE;
            }

            BizCurrency kihonP = BizCurrency.valueOf(0);
            BizCurrency zennouPSyokaiari = BizCurrency.valueOf(0);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

            if (C_Tuukasyu.JPY.eq(tuukaSyu)) {

                kihonS = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsKihonsstr()), currencyType);
                kihonP = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsKihonpstr()), currencyType);
                zennouPSyokaiari = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsZennoupstr()), currencyType);
            }
            else {

                kihonS = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsGaikakihonsstr()), currencyType)
                    .divide(100);
                kihonP = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsGaikakihonpstr()), currencyType)
                    .divide(100);
                zennouPSyokaiari = BizCurrency.valueOf(
                    new BigDecimal(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsGaikazennoupstr()), currencyType)
                    .divide(100);
            }

            BizDate calcKijyunYmd = BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymdstr());

            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            int hhknnen = setNenrei.exec(calcKijyunYmd,
                BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsDisphhknseiymd()));

            KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
            keisanWExtBean.setSyouhncd(syouhnZokusei.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(syouhnZokusei.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(syouhnZokusei.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(kykjiYoteiriRitu);
            keisanWExtBean.setHrkkaisuu(hrkkaisuu);
            keisanWExtBean.setHknkknsmnkbn(hknkknsmnKbn);
            keisanWExtBean.setHrkkknsmnkbn(hrkkknsmnKbn);
            keisanWExtBean.setHrkkkn(Integer.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsPharaikomikikan()));
            keisanWExtBean.setHknkkn(Integer.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsHknkkn()));
            keisanWExtBean.setHhknnen(hhknnen);
            keisanWExtBean.setHhknsei(hhknSei);
            keisanWExtBean.setKihons(kihonS);
            keisanWExtBean.setHokenryou(kihonP);
            keisanWExtBean.setKykymd(calcKijyunYmd);
            keisanWExtBean.setTuukasyu(tuukaSyu);
            keisanWExtBean.setDai1hknkkn(Integer.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsHknkkn1()));

            if (C_UmuKbn.ARI.eq(zennouUmu)) {

                keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ZENNOU);
            }
            else {

                keisanWExtBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
            }

            WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
            wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
            wSuiihyouParam.setKwsratekjymd(null);
            wSuiihyouParam.setCalcKijyunYmd(calcKijyunYmd);
            wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
            wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
            wSuiihyouParam.setZennouUmuKbn(zennouUmu);
            wSuiihyouParam.setSdpd(sdpd);
            wSuiihyouParam.setHrkkeiro(hrkkeiro);

            if (C_UmuKbn.ARI.eq(zennouUmu)) {

                wSuiihyouParam.setZennoujiHrkP(kihonP);

                wSuiihyouParam.setZennouKaisiYmd(
                    BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymdstr())
                    .addYears(1).getRekijyou());

                wSuiihyouParam.setRyosyuYmd(
                    BizDate.valueOf(wsHbSeihoWebHeijyunKaiyakuhrSuiiInputBean.getIwsNrkcalckijyunymdstr()));

                wSuiihyouParam.setZennouNyuukingk(zennouPSyokaiari.subtract(kihonP));
            }
            else {

                wSuiihyouParam.setRyosyuYmd(null);
                wSuiihyouParam.setZennouNyuukingk(null);
            }

            List<IT_Suiihyou> suiihyouLst = new ArrayList<IT_Suiihyou>();
            List<SibouSBean> sibouSBeanLst = new ArrayList<SibouSBean>();

            try {
                WSuiihyouSyuusin3 wSuiihyouSyuusin3 = SWAKInjector.getInstance(WSuiihyouSyuusin3.class);
                wSuiihyouSyuusin3.setYenkansannYhKbn(C_YouhiKbn.HUYOU);

                suiihyouLst = wSuiihyouSyuusin3.exec(wSuiihyouParam);

                sibouSBeanLst = wSuiihyouSyuusin3.getSibouSBeanList();

            } catch (Exception e) {

                errHukaMsg = creatErrorMsg("解約返戻金取得エラー" , wsBzWebserviceReqParamBean);

                throw e;
            }

            try {

                WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseSeijou(suiihyouLst, sibouSBeanLst);

                return wsBzWebserviceResParamBean;

            } catch(Exception e) {

                errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

                throw e;
            }
        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = creatResponseError(
                ERRORKBN_KEISANERR, MessageUtil.getMessage(MessageId.EGC1002), "");

            return wsBzWebserviceResParamBean;
        }
    }

    private WsBzWebserviceResParamBean creatResponseError(String pErrorKbn, String pMsg1, String pMst2) {

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = SWAKInjector
            .getInstance(WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        initOutputBean(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean);

        wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsErrkbn(pErrorKbn);
        wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg1(pMsg1);
        wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg2(pMst2);

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean));

        logger.debug("△ 生保Ｗｅｂ平準払終身用解約返戻金推移表作成  終了");

        return wsBzWebserviceResParamBean;
    }

    private WsBzWebserviceResParamBean creatResponseSeijou(List<IT_Suiihyou> pSuiihyouLst, List<SibouSBean> pSibouSBeanLst) {

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = SWAKInjector
            .getInstance(WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        initOutputBean(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean);

        wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsErrkbn(ERRORKBN_SEIJOU);

        C_UmuKbn hrkkknMnryUmuKbn = C_UmuKbn.NONE;

        for (int index = 0; index < pSuiihyouLst.size(); index++) {

            IT_Suiihyou suiihyou = pSuiihyouLst.get(index);

            BizCurrency maitosipHrkrkGk = BizCurrency.valueOf(0);
            BizCurrency maitosiKaiyakuhr = BizCurrency.valueOf(0);
            BizCurrency maitosiSbs = BizCurrency.valueOf(0);
            BizCurrency maitosiZnnzndk = BizCurrency.valueOf(0);

            if (C_Tuukasyu.JPY.eq(tuukaSyu)) {

                maitosiKaiyakuhr = suiihyou.getMvanonewsame();
                maitosiZnnzndk = suiihyou.getZennouzndkyen1();
                maitosipHrkrkGk = suiihyou.getKihrkmpyen1();

                if (C_UmuKbn.NONE.eq(hrkkknMnryUmuKbn)) {

                    maitosiSbs = pSibouSBeanLst.get(index).getSibouS();
                }
                else {

                    maitosiSbs = kihonS;
                }
            }
            else {

                maitosiKaiyakuhr = suiihyou.getMvanonewsame().multiply(100);
                maitosiZnnzndk = suiihyou.getZennouzndk1().multiply(100);
                maitosipHrkrkGk = suiihyou.getKihrkmp1().multiply(100);

                if (C_UmuKbn.NONE.eq(hrkkknMnryUmuKbn)) {

                    maitosiSbs = pSibouSBeanLst.get(index).getSibouS().multiply(100);
                }
                else {

                    maitosiSbs = kihonS.multiply(100);
                }
            }

            if (C_UmuKbn.ARI.eq(suiihyou.getHrkkknmnryumukbn())) {

                wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsHrkkknmnryutykgw(BizNumber.valueOf(maitosiKaiyakuhr));

                hrkkknMnryUmuKbn = C_UmuKbn.ARI;
            }

            setMaitosiGk(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean
                , index
                , BizNumber.valueOf(maitosipHrkrkGk)
                , BizNumber.valueOf(maitosiKaiyakuhr)
                , BizNumber.valueOf(maitosiSbs)
                , BizNumber.valueOf(maitosiZnnzndk));
        }

        wsBzWebserviceResParamBean.setGyoumuData(
            FixedlengthConvertUtil.beanToStringForFixedlength(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean));

        logger.debug("△ 生保Ｗｅｂ平準払終身用解約返戻金推移表作成  終了" + wsBzWebserviceResParamBean.getGyoumuData());

        return wsBzWebserviceResParamBean;
    }

    private void initOutputBean(WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean) {

        pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsErrkbn(ERRORKBN_SEIJOU);
        pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg1(ZENKAKUSPACE);
        pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsSekmoserrormsg2(ZENKAKUSPACE);
        pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.setIwsHrkkknmnryutykgw(BizNumber.valueOf(0));

        for (int i = 0; i < 99; i++) {

            setMaitosiGk(pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean
                , i, BizNumber.valueOf(0), BizNumber.valueOf(0), BizNumber.valueOf(0), BizNumber.valueOf(0));
        }

        for (int j = 0; j < 10; j++) {

            setKyakKjrtKjgk(pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean, j, BizNumber.valueOf(0), BizNumber.valueOf(0));

        }
    }

    private void setMaitosiGk(WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean
        , int pCount, BizNumber pMaitosipHrkrkGk, BizNumber pMaitosiKaiyakuhr, BizNumber pMaitosiSbs
        , BizNumber pMaitosiZnnzndk) {

        try {

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsMaitosiphrkrkgk",
                pCount + 1, pMaitosipHrkrkGk);

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsMaitosikaiyakuhr",
                pCount + 1, pMaitosiKaiyakuhr);

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsMaitosisbs",
                pCount + 1, pMaitosiSbs);

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsMaitosiznnzndk",
                pCount + 1, pMaitosiZnnzndk);

        } catch (IllegalAccessException
            | NoSuchMethodException
            | InvocationTargetException e) {

            throw new CommonBizAppException();

        }
    }

    private void setKyakKjrtKjgk(WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean
        ,int pCount, BizNumber pKaiyakukoujyoRitu, BizNumber pKaiyakukjGk) {

        try {

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsKaiyakukoujyoritu",
                pCount + 1, pKaiyakukoujyoRitu);

            methodNmEditAndExec(
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class,
                pWsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
                "setIwsKaiyakukjgk",
                pCount + 1, pKaiyakukjGk);

        } catch (IllegalAccessException
            | NoSuchMethodException
            | InvocationTargetException e) {

            throw new CommonBizAppException();

        }
    }

    private String creatErrorMsg(String pErrorSyoriNm, WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean) {

        String errUserMsg = pErrorSyoriNm.concat(":【オペレータＩＤ ＝ ")
            .concat(pWsBzWebserviceReqParamBean.getOperatorId())
            .concat(", 事務単位コード ＝ ")
            .concat(pWsBzWebserviceReqParamBean.getOrgCode() + "】 ");

        return errUserMsg;
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
        koumokuNmMap.put("iwsDispkykseiymd", "（ＩＷＳ）契約者生年月日");
        koumokuNmMap.put("iwsKyksyaseikbn", "（ＩＷＳ）契約者性別区分");
        koumokuNmMap.put("iwsDisphhknseiymd", "（ＩＷＳ）被保険者生年月日");
        koumokuNmMap.put("iwsHhknseikbn", "（ＩＷＳ）被保険者性別区分");
        koumokuNmMap.put("iwsDisphokensyuruino", "（ＩＷＳ）保険種類番号");
        koumokuNmMap.put("iwsNrkcalckijyunymdstr", "（ＩＷＳ）入力計算基準年月日（文字列）");
        koumokuNmMap.put("iwsSyoriymdstr", "（ＩＷＳ）処理年月日（文字列）");
        koumokuNmMap.put("iwsBosyuuymstr", "（ＩＷＳ）募集年月（文字列）");
        koumokuNmMap.put("iwsHjkktkbn", "（ＩＷＳ）報状告知区分");
        koumokuNmMap.put("iwsSdpdkbn", "（ＩＷＳ）Ｓ建Ｐ建区分");
        koumokuNmMap.put("iwsHaitousiharaikbn", "（ＩＷＳ）配当支払区分");
        koumokuNmMap.put("iwsKihonsstr", "（ＩＷＳ）基本Ｓ（文字列）");
        koumokuNmMap.put("iwsGaikakihonsstr", "（ＩＷＳ）外貨基本Ｓ（文字列）");
        koumokuNmMap.put("iwsKihonpstr", "（ＩＷＳ）基本Ｐ（文字列）");
        koumokuNmMap.put("iwsGaikakihonpstr", "（ＩＷＳ）外貨基本Ｐ（文字列）");
        koumokuNmMap.put("iwsKyktuukakbn", "（ＩＷＳ）契約通貨区分");
        koumokuNmMap.put("iwsSaimankihyj", "（ＩＷＳ）才満期表示");
        koumokuNmMap.put("iwsHknkkn", "（ＩＷＳ）保険期間");
        koumokuNmMap.put("iwsHknkkn1", "（ＩＷＳ）第１保険期間");
        koumokuNmMap.put("iwsPharaikomikikan", "（ＩＷＳ）Ｐ払込期間");
        koumokuNmMap.put("iwsHaraikomikaisuukbn", "（ＩＷＳ）払込回数区分");
        koumokuNmMap.put("iwsHrkkeirokbn", "（ＩＷＳ）払込経路区分");
        koumokuNmMap.put("iwsKykjiyoteiriritustr", "（ＩＷＳ）契約時予定利率（文字列）");
        koumokuNmMap.put("iwsIkkatubaraikbn", "（ＩＷＳ）一括払区分");
        koumokuNmMap.put("iwsIkkatubaraikaisuu", "（ＩＷＳ）一括払回数");
        koumokuNmMap.put("iwsIkkatupstr", "（ＩＷＳ）一括払Ｐ（文字列）");
        koumokuNmMap.put("iwsZennouhyouji", "（ＩＷＳ）前納表示");
        koumokuNmMap.put("iwsZennoukkn", "（ＩＷＳ）前納期間");
        koumokuNmMap.put("iwsZennoupstr", "（ＩＷＳ）前納Ｐ（文字列）");
        koumokuNmMap.put("iwsGaikazennoupstr", "（ＩＷＳ）外貨前納Ｐ（文字列）");
        koumokuNmMap.put("iwsTksykmcd1", "（ＩＷＳ）特殊項目コード１");
        koumokuNmMap.put("iwsTksykmcd2", "（ＩＷＳ）特殊項目コード２");
        koumokuNmMap.put("iwsTksykmcd3", "（ＩＷＳ）特殊項目コード３");
        koumokuNmMap.put("iwsTksykmcd4", "（ＩＷＳ）特殊項目コード４");
        koumokuNmMap.put("iwsTksykmcd5", "（ＩＷＳ）特殊項目コード５");
        koumokuNmMap.put("iwsSekmossakuseikbn", "（ＩＷＳ）設計書申込書作成区分");

        String koumokuNm = koumokuNmMap.get(pKoumokuId);

        return koumokuNm;
    }

    private void methodNmEditAndExec (
        Class<WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean> pClass,
        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean,
        String pMethodNm,
        int pMethodNo,
        Object pValue) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        Method setMethod = pClass.getMethod(pMethodNm + String.valueOf(pMethodNo), pValue.getClass());
        setMethod.invoke(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean, pValue);
    }
}
