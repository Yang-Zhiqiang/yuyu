package yuyu.app.bosyuu.hbkeiyakusyoukai.hbkeiyakusyoukaiwebservice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukai;
import yuyu.common.bosyuu.hbkeiyakusyoukai.WebKykNaiyouSyoukaiInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKeiyakuSyoukaiWebServiceInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbKeiyakuSyoukaiWebServiceOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_TanmatuSiyouKbn;
import yuyu.infrext.mq.RayWebServiceAuthInfo;

/**
 * 生保Ｗｅｂ契約内容照会サービスの実装クラスです。<br />
 */
public class HbKeiyakuSyoukaiWebServiceImpl implements HbKeiyakuSyoukaiWebService {

    @Inject
    private static Logger logger;

    @Inject
    private RayWebServiceAuthInfo rayWebAuthInfo;

    private static final String ERRORMESSAGE1 =
        "誤った証券番号が入力されています。正しい証券番号を確認のうえ、再度照会ください。";

    private static final String ERRORMESSAGE2 =
        "参照権限がありません。";

    private static List<String> SIYOUSYAKENGEN_TANMATUSIYOUKBN = new ArrayList<String>();

    static {
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("1");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("2");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("8");
    }

    @Override
    public WsBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) throws Exception {

        try {

            logger.debug("▽ 生保Ｗｅｂ契約内容照会 開始");

            WsHbKeiyakuSyoukaiWebServiceOutputBean keiyakuSyoukaiWebServiceOutputBean =
                SWAKInjector.getInstance(WsHbKeiyakuSyoukaiWebServiceOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            C_TanmatuSiyouKbn tanmatuSiyouKbn = C_TanmatuSiyouKbn.BLNK;
            String kojinCd = "";

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
                SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbKeiyakuSyoukaiWebServiceInputBean keiyakuSyoukaiWebServiceInputBean;
            try {

                keiyakuSyoukaiWebServiceInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbKeiyakuSyoukaiWebServiceInputBean.class);

            }
            catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    logger.debug("△ 生保Ｗｅｂ契約内容照会エラー 終了");

                    keiyakuSyoukaiWebServiceOutputBean.setIwsErrkbn("1");
                    keiyakuSyoukaiWebServiceOutputBean.setIwsErrormsg(ERRORMESSAGE1);

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(keiyakuSyoukaiWebServiceOutputBean));

                    return wsBzWebserviceResParamBean;
                }

                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

            webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, keiyakuSyoukaiWebServiceInputBean);

            String tanmatuSiyouKbnVal = wsBzWebserviceReqParamBean.getOperatorId().substring(10, 11);
            kojinCd = wsBzWebserviceReqParamBean.getOperatorId().substring(2, 8);

            if (!SIYOUSYAKENGEN_TANMATUSIYOUKBN.contains(tanmatuSiyouKbnVal)) {

                logger.debug("△ 生保Ｗｅｂ契約内容照会エラー 終了");

                keiyakuSyoukaiWebServiceOutputBean.setIwsErrkbn("1");
                keiyakuSyoukaiWebServiceOutputBean.setIwsErrormsg(ERRORMESSAGE2);

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(keiyakuSyoukaiWebServiceOutputBean));

                return wsBzWebserviceResParamBean;
            }
            else if ("1".equals(tanmatuSiyouKbnVal)) {
                tanmatuSiyouKbn = C_TanmatuSiyouKbn.SOUGOU_IPPAN;
            }
            else if ("2".equals(tanmatuSiyouKbnVal)) {
                tanmatuSiyouKbn = C_TanmatuSiyouKbn.SONOTA;
            }
            else if ("8".equals(tanmatuSiyouKbnVal)) {
                tanmatuSiyouKbn = C_TanmatuSiyouKbn.DAIRITENBOSYUUNIN;
            }

            keiyakuSyoukaiWebServiceOutputBean.setIwsSyono11keta(keiyakuSyoukaiWebServiceInputBean.getIwsSyono11keta());

            HbKeiyakuSyoukai keiyakuSyoukai = SWAKInjector.getInstance(HbKeiyakuSyoukai.class);
            WebKykNaiyouSyoukaiInfoBean webKykNaiyouSyoukaiInfoBean =
                keiyakuSyoukai.exec(keiyakuSyoukaiWebServiceInputBean.getIwsSyono11keta(), BizDate.getSysDate(), tanmatuSiyouKbn, kojinCd);

            keiyakuSyoukaiWebServiceOutputBean.setIwsErrkbn(webKykNaiyouSyoukaiInfoBean.getErrorKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsErrormsg(webKykNaiyouSyoukaiInfoBean.getErrorMsg());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTanmatutyouhyoucd("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsKyknmkn43keta(webKykNaiyouSyoukaiInfoBean.getKyknmkn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsKyknmkj38keta(webKykNaiyouSyoukaiInfoBean.getKyknmkj());
            keiyakuSyoukaiWebServiceOutputBean.setIwsKyksyaseiymdwareki(webKykNaiyouSyoukaiInfoBean.getKykseiymd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsKojinhjnkbn(webKykNaiyouSyoukaiInfoBean.getKojinhjnKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsintelno15keta(webKykNaiyouSyoukaiInfoBean.getTelno());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinynozenkaku(webKykNaiyouSyoukaiInfoBean.getPostalCd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinadr(webKykNaiyouSyoukaiInfoBean.getAdr());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinadrkn(webKykNaiyouSyoukaiInfoBean.getAdrkn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknnm17keta(webKykNaiyouSyoukaiInfoBean.getHhknnm());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknseikj(webKykNaiyouSyoukaiInfoBean.getHhknsei());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknseiymdwareki(webKykNaiyouSyoukaiInfoBean.getHhknseiymd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknnenzenkaku(webKykNaiyouSyoukaiInfoBean.getHhknNen());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknkyknen(webKykNaiyouSyoukaiInfoBean.getHhknKykjiNen());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyouhnnm61keta(webKykNaiyouSyoukaiInfoBean.getSyouhnnm());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHokensyurui(webKykNaiyouSyoukaiInfoBean.getSyurui());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyono11keta(webKykNaiyouSyoukaiInfoBean.getSyono());
            keiyakuSyoukaiWebServiceOutputBean.setIwsCifcd(webKykNaiyouSyoukaiInfoBean.getCifCd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsKykymd(webKykNaiyouSyoukaiInfoBean.getKykymd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHaraikomihou(webKykNaiyouSyoukaiInfoBean.getHrkhou());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSibouhknkn(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getSibous()));
            if (!webKykNaiyouSyoukaiInfoBean.getSibous().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsSibouhknkntuukasyu(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getSibous().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsHrkp(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getHrkp()));
            if (!webKykNaiyouSyoukaiInfoBean.getHrkp().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsHrkptuukasyu(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getHrkp().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsNkshrstartymd(webKykNaiyouSyoukaiInfoBean.getNkShrStartYmd());
            keiyakuSyoukaiWebServiceOutputBean.setIwsNenkinhosyouy(webKykNaiyouSyoukaiInfoBean.getNenkinHosyouYear());
            keiyakuSyoukaiWebServiceOutputBean.setIwsNenkinkbn(webKykNaiyouSyoukaiInfoBean.getNenkinKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHaitoukbn(webKykNaiyouSyoukaiInfoBean.getHaitouKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSinsakbn(webKykNaiyouSyoukaiInfoBean.getSinsaKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyksuu(String.valueOf(webKykNaiyouSyoukaiInfoBean.getTksuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsLivingneedstkykhyj(webKykNaiyouSyoukaiInfoBean.getLivingneedsTkhyj());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHknmnkymd(webKykNaiyouSyoukaiInfoBean.getHokenMankiDay());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyunm(webKykNaiyouSyoukaiInfoBean.getSyunm());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyus(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getSyus()));
            if (!webKykNaiyouSyoukaiInfoBean.getSyus().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsSyustuukasyu(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getSyus().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyuhknkkn(webKykNaiyouSyoukaiInfoBean.getSyuhknkkn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyuhrkkkn(webKykNaiyouSyoukaiInfoBean.getSyuhrkkkn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknaiyoulinecnt(String.valueOf(webKykNaiyouSyoukaiInfoBean.getTkNaiyouGyousuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykyknm1(webKykNaiyouSyoukaiInfoBean.getTknm1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykyks1(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks1()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks1().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu1(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks1().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn1(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn1(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm2(webKykNaiyouSyoukaiInfoBean.getTknm2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks2(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks2()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks2().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu2(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks2().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn2(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn2(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm3(webKykNaiyouSyoukaiInfoBean.getTknm3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks3(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks3()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks3().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu3(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks3().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn3(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn3(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm4(webKykNaiyouSyoukaiInfoBean.getTknm4());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks4(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks4()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks4().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu4(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks4().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn4(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan4());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn4(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan4());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm5(webKykNaiyouSyoukaiInfoBean.getTknm5());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks5(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks5()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks5().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu5(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks5().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn5(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan5());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn5(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan5());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm6(webKykNaiyouSyoukaiInfoBean.getTknm6());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks6(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks6()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks6().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu6(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks6().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn6(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan6());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn6(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan6());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm7(webKykNaiyouSyoukaiInfoBean.getTknm7());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks7(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks7()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks7().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu7(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks7().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn7(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan7());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn7(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan7());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm8(webKykNaiyouSyoukaiInfoBean.getTknm8());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks8(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks8()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks8().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu8(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks8().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn8(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan8());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn8(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan8());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm9(webKykNaiyouSyoukaiInfoBean.getTknm9());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks9(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks9()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks9().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu9(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks9().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn9(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan9());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn9(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan9());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm10(webKykNaiyouSyoukaiInfoBean.getTknm10());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks10(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks10()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks10().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu10(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks10().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn10(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan10());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn10(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan10());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm11(webKykNaiyouSyoukaiInfoBean.getTknm11());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks11(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks11()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks11().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu11(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks11().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn11(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan11());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn11(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan11());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm12(webKykNaiyouSyoukaiInfoBean.getTknm12());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks12(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks12()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks12().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu12(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks12().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn12(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan12());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn12(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan12());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm13(webKykNaiyouSyoukaiInfoBean.getTknm13());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks13(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks13()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks13().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu13(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks13().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn13(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan13());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn13(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan13());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm14(webKykNaiyouSyoukaiInfoBean.getTknm14());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks14(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks14()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks14().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu14(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks14().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn14(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan14());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn14(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan14());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyknm15(webKykNaiyouSyoukaiInfoBean.getTknm15());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkyks15(hensyuuComma(webKykNaiyouSyoukaiInfoBean.getTks15()));
            if (!webKykNaiyouSyoukaiInfoBean.getTks15().isOptional()) {
                keiyakuSyoukaiWebServiceOutputBean.setIwsTkykstuukasyu15(henkanTuukaKbn(webKykNaiyouSyoukaiInfoBean.getTks15().getType()));
            }
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhknkkn15(webKykNaiyouSyoukaiInfoBean.getTokuyakuhokenkikan15());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTkykhrkkkn15(webKykNaiyouSyoukaiInfoBean.getTokuyakuharaikomikikan15());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyouhnnylinecnt(String.valueOf(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyouGyousuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyouhnnaiyou1(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyouhnnaiyou2(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyouhnnaiyou3(webKykNaiyouSyoukaiInfoBean.getSyouhnNaiyou3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyoulinecnt(String.valueOf(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyouGyousuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou1(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou2(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou3(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou4(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou4());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou5(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou5());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou6(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou6());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou7(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou7());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou8(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou8());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou9(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou9());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou10(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou10());
            keiyakuSyoukaiWebServiceOutputBean.setIwsTanmatutyouhyoucd2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou11(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou11());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou12(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou12());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou13(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou13());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou14(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou14());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou15(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou15());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou16(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou16());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou17(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou17());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou18(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou18());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou19(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou19());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou20(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou20());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou21(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou21());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou22(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou22());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou23(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou23());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou24(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou24());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyounaiyou25(webKykNaiyouSyoukaiInfoBean.getHosyouNaiyou25());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeiilinecnt(String.valueOf(webKykNaiyouSyoukaiInfoBean.getHenkouKeiiGyousuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii1(webKykNaiyouSyoukaiInfoBean.getHenkouKeii1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii2(webKykNaiyouSyoukaiInfoBean.getHenkouKeii2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii3(webKykNaiyouSyoukaiInfoBean.getHenkouKeii3());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii4(webKykNaiyouSyoukaiInfoBean.getHenkouKeii4());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii5(webKykNaiyouSyoukaiInfoBean.getHenkouKeii5());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii6(webKykNaiyouSyoukaiInfoBean.getHenkouKeii6());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii7(webKykNaiyouSyoukaiInfoBean.getHenkouKeii7());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii8(webKykNaiyouSyoukaiInfoBean.getHenkouKeii8());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii9(webKykNaiyouSyoukaiInfoBean.getHenkouKeii9());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii10(webKykNaiyouSyoukaiInfoBean.getHenkouKeii10());
            keiyakuSyoukaiWebServiceOutputBean.setIwsBsydairitenlinecnt(String.valueOf(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenGyousuu()));
            keiyakuSyoukaiWebServiceOutputBean.setIwsBosyuudairitennm1(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsDairitenbnwari1(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari1());
            keiyakuSyoukaiWebServiceOutputBean.setIwsBosyuudairitennm2(webKykNaiyouSyoukaiInfoBean.getBosyuDrtenNm2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsDairitenbnwari2(webKykNaiyouSyoukaiInfoBean.getDrtenBnwari2());
            keiyakuSyoukaiWebServiceOutputBean.setIwsmsgoutkbn(webKykNaiyouSyoukaiInfoBean.getMsgOutKbn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHosyouiktmnoskykhyj(webKykNaiyouSyoukaiInfoBean.getHosyouIkkatuMinaokeiyakuHyouji());
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknsyanmkn(webKykNaiyouSyoukaiInfoBean.getHhknnmkn());
            keiyakuSyoukaiWebServiceOutputBean.setIwsPsyuunoujk(webKykNaiyouSyoukaiInfoBean.getHokenryouSyuunouJyoukyou());
            keiyakuSyoukaiWebServiceOutputBean.setIwsJkipjytym(webKykNaiyouSyoukaiInfoBean.getJikaiHokenryouJyuutouYm());
            keiyakuSyoukaiWebServiceOutputBean.setIwsMdhnsyubetukbn(webKykNaiyouSyoukaiInfoBean.getMdhansybetuKbn());

            keiyakuSyoukaiWebServiceOutputBean.setIwsTanmatutyouhyoucd3("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNkuktnmkn("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNkuktnmkj("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNkukesei("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNkuktseiymdwareki("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsKojinhjnkbn2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsintelno15ketax2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinynozenkakux2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinadrknx2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsTsinadrx2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknsyanmkn18keta("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknnmkj17keta("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknseikj2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHhknseiymdwareki2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNksyouhnnm("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNksysyno("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyokainkshrymd("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsSyokainkshrjk("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNextnkshrymd("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsLastnkshrymd("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsKhnnkgk("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsKhnnkgktuukasyu("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBnkaisuu("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNenkinsyu("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNenkinsiharaikikan("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNenkinhosyoukikan("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHaitoukinuketorihou("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeiilinecnt2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii1x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii2x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii3x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii4x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsHenkoukeii5x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsKeiyakuymd("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBsydairitenlinecnt2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBosyuudairitennm1x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBosyuudairitennm2x2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsCifcd2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikoulinecnt("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikou1("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikou2("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikou3("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikou4("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsBikou5("");
            keiyakuSyoukaiWebServiceOutputBean.setIwsNknaiyousyoukaihyj("");

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(keiyakuSyoukaiWebServiceOutputBean));

            logger.debug("△ 生保Ｗｅｂ契約内容照会 終了");

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.debug("△ 生保Ｗｅｂ契約内容照会 エラー");

            WsHbKeiyakuSyoukaiWebServiceOutputBean keiyakuSyoukaiWebServiceOutputBean =
                SWAKInjector.getInstance(WsHbKeiyakuSyoukaiWebServiceOutputBean.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

            keiyakuSyoukaiWebServiceOutputBean.setIwsErrkbn("1");
            keiyakuSyoukaiWebServiceOutputBean.setIwsErrormsg(MessageUtil.getMessage(MessageId.EGC1001));

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(keiyakuSyoukaiWebServiceOutputBean));

            return wsBzWebserviceResParamBean;

        }
    }

    private String henkanTuukaKbn(CurrencyType pCurrencyType) {

        String tuukasyu = "";

        if (BizCurrencyTypes.YEN == pCurrencyType) {

            tuukasyu = "1";
        }
        else if (BizCurrencyTypes.DOLLAR == pCurrencyType) {

            tuukasyu = "2";
        }
        else if (BizCurrencyTypes.EURO == pCurrencyType) {

            tuukasyu = "3";
        }
        else if (BizCurrencyTypes.AU_DOLLAR == pCurrencyType) {

            tuukasyu = "4";
        }
        else {

            tuukasyu = "0";
        }

        return tuukasyu;
    }

    private String hensyuuComma(BizCurrency pKingaku) {

        String kingaku = "";

        if (pKingaku.isOptional()){
            return kingaku;
        }

        if (pKingaku.getType() == BizCurrencyTypes.YEN) {

            kingaku = BizUtil.comma(pKingaku.toString());
        }
        else {

            kingaku = BizUtil.comma(pKingaku.toString(), 0, 2);
        }

        return kingaku;
    }

}
