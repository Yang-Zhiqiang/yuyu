package yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.kengen.BzSyanaiWebServiceKengenHantei;
//import yuyu.common.direct.dscommon.DsGetSyanaiWebKeiyakuInfo;
import yuyu.common.direct.renkei.DsGetSyanaiWebKeiyakuInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKeiyakuInfo;
import yuyu.common.hozen.renkei.KhansyuuGetSyanaiWebKeiyakuInfo;
// import yuyu.common.siharai.sicommon.SiGetSyanaiWebKeiyakuInfo;
import yuyu.common.siharai.renkei.SiGetSyanaiWebKeiyakuInfo;
import yuyu.def.biz.bean.param.IwssnBzWebserviceResParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiAnsyuInfoOutputBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiDsInfoOutputBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiKykNaiyouSyoukaiInputBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiKykNaiyouSyoukaiOutputBean;
import yuyu.def.biz.bean.webservice.IwssnSyanaiSiharaiInfoOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_KengenHntiKbn;
//import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;

/**
 * 社内用契約内容照会Webサービスの実装クラスです。<br />
 */
public class BzKeiyakunaiyouSyoukaiWebServiceImpl implements BzKeiyakunaiyouSyoukaiWebService {

    private IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = null;

    private IwssnSyanaiSiharaiInfoOutputBean iwssnSyanaiSiharaiInfoOutputBean = null;

    private IwssnSyanaiAnsyuInfoOutputBean iwssnSyanaiAnsyuInfoOutputBean = null;

    private IwssnSyanaiDsInfoOutputBean iwssnSyanaiDsInfoOutputBean = null;

    @Inject
    private static Logger logger;

    private static final String SPACE_HANKAKU = " ";

    @Override
    public IwssnBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) {
        //public WsBzWebserviceResParamBean exec(MultivaluedMap<String, String> pMap) {
        //public WsBzWebserviceResParamHandmadeBean exec(MultivaluedMap<String, String> pMap) {

        List<String> list = new ArrayList<>(pMap.keySet());
        System.out.println(list);

        List<List<String>> list2 = new ArrayList<>(pMap.values());
        System.out.println(list2);

        for (String key : pMap.keySet()) {
            logger.info(key);
        }
        for (List<String> Name : pMap.values()) {
            for (int i=0; i < Name.size(); i++) {
                logger.info(Name.get(i));
            }
        }

        logger.info("▽社内用契約内容照会処理を開始します。");

        try {
            logger.info("▽初期処理開始");

            IwssnSyanaiKykNaiyouSyoukaiOutputBean iwssnSyanaiKykNaiyouSyoukaiOutputBean =
                    SWAKInjector.getInstance(IwssnSyanaiKykNaiyouSyoukaiOutputBean.class);
            //IwssnBzWebserviceReqParamBean iwssnBzWebserviceReqParamBean = SWAKInjector.getInstance(IwssnBzWebserviceReqParamBean.class);
            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            IwssnBzWebserviceResParamBean iwssnBzWebserviceResParamBean = SWAKInjector.getInstance(IwssnBzWebserviceResParamBean.class);
            //WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            //WsBzWebserviceResParamHandmadeBean wsBzWebserviceResParamHandmadeBean = SWAKInjector.getInstance(WsBzWebserviceResParamHandmadeBean.class);

            String syorikbn = "0";
            C_IwssnKykSyoukaiKekkaKbn syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            String syoriErrorFlag = "0";
            String syorikekkakbnnm = syorikekkakbn.getContent();

            logger.info("▽BeanPopulate実行");
            //BeanUtils.populate(iwssnBzWebserviceReqParamBean, pMap);
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            logger.info("▽BeanPopulate実行完了");

            logger.info("▽Jsonデコード実行");
            //IwssnSyanaiKykNaiyouSyoukaiInputBean iwssnSyanaiKykNaiyouSyoukaiInputBean =
            //JSON.decode(iwssnBzWebserviceReqParamBean.getIwssnGyoumuData(), IwssnSyanaiKykNaiyouSyoukaiInputBean.class);
            IwssnSyanaiKykNaiyouSyoukaiInputBean iwssnSyanaiKykNaiyouSyoukaiInputBean =
                    JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), IwssnSyanaiKykNaiyouSyoukaiInputBean.class);

            logger.info("△Jsonデコード実行完了");
            //WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
            WebServiceAccesslogOutput webServiceAccesslogOutput = SWAKInjector.getInstance(WebServiceAccesslogOutput.class);

            logger.info("▽アクセスログ出力実行します。");
            webServiceAccesslogOutput.exec(
                    C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, iwssnSyanaiKykNaiyouSyoukaiInputBean);

            logger.info("△アクセスログ出力完了します。");

            logger.info("▽入力値チェック実行します。");
            boolean hissuMChkKekka = iwssnSyanaiKykNaiyouSyoukaiInputBean.chkHissuMInput();

            logger.info("△入力値チェック完了します。");

            if (!hissuMChkKekka) {

                syorikbn = "E";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.SYONOINPUT_ERROR;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("証券番号入力値エラー");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコードします。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            Validator validator = SWAKInjector.getInstance(Validator.class);

            Set<ConstraintViolation<IwssnSyanaiKykNaiyouSyoukaiInputBean>> validatorChkKekkaSet =
                    validator.validate(iwssnSyanaiKykNaiyouSyoukaiInputBean);

            if (validatorChkKekkaSet.size() > 0) {

                syorikbn = "E";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.SYONOINPUT_ERROR;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("証券番号入力値エラー");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            BzSyanaiWebServiceKengenHantei bzSyanaiWebServiceKengenHantei = SWAKInjector.getInstance(BzSyanaiWebServiceKengenHantei.class);
            C_KengenHntiKbn kengenHntiKbn = bzSyanaiWebServiceKengenHantei.exec(
                    wsBzWebserviceReqParamBean.getOperatorId(), wsBzWebserviceReqParamBean.getOrgCode(),
                    wsBzWebserviceReqParamBean.getMethodName());

            if (C_KengenHntiKbn.TANMATUERROR.eq(kengenHntiKbn)) {

                syorikbn = "E";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.KENGEN_ERROR;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("端末権限エラー");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }
            else if (C_KengenHntiKbn.SIYOSYAERROR.eq(kengenHntiKbn)) {

                syorikbn = "E";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.KENGEN_ERROR;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("ユーザー権限エラー");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            logger.info("▽社内用Web用保全契約内容情報取得処理実行します。");
            KhGetSyanaiWebKeiyakuInfo khGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(KhGetSyanaiWebKeiyakuInfo.class);
            C_IwssnKykSyoukaiKekkaKbn khnaiyoujouhousyutokukekka = khGetSyanaiWebKeiyakuInfo.exec(iwssnSyanaiKykNaiyouSyoukaiInputBean.getIwssnSyono());
            iwssnSyanaiHozenInfoOutputBean = khGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyono(iwssnSyanaiHozenInfoOutputBean.getIwssnSyono());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyknmkn(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyknmkj(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyksyaseiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyksyanen(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyksyasei(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykseikj(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyktdk(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKyktdkkj(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknsyanmkn(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknnmkj(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknseiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknkyknen(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknnen(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknsei(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhknseikj(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTsinyno(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTsinadr1kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTsinadr2kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTsinadr3kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTsintelno(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouuktkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouuktkj(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknbunwari1(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknbunwari2(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknbunwari3(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknbunwari4(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikana1(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikana2(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikana3(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikana4(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikanji1(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikanji2(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikanji3(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSibouhknknuktsmikanji4(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNenkinuktkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNenkinuktkj(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStdrsknkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStdrsknkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStdrsknsmikanji(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikanji());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStdrskntkyhkkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrskntkyhkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStdrsknsmikana(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikana());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyouhncd(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhncd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyouhnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnAisyoumeikj(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnAisyoumeikbn(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyoumetujiyuu(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyoumetujiyuukj(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuukj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykjyoutaikbn(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykjyoutaikbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykymd(iwssnSyanaiHozenInfoOutputBean.getIwssnKykymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSknnkaisiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSknnkaisiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnBosyuuym(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuuym());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyoumetuymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetuymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNksyouhnnkshrstartymd(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNksyouhnnenkinsyukbn(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNksyouhnnenkinsyukj(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKjnnkpzeitekitkhukakbn(iwssnSyanaiHozenInfoOutputBean.getIwssnKjnnkpzeitekitkhukakbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnPyenhrktkkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnPyenhrktkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnPstigihrktkkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnMkhyouyensysnnktkkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnMkhyouyensysnnktkwra(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnInitsbjiyensitihsykbn(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjiyensitihsykbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn1from(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn1to(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn2from(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn2to(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2to());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHknkkn3(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkkkn(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnNksyouhnnenkinkkn(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrktuuka(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYoteiriritu(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyokaipnyknrate(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykjisjkkktusirrt(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyokaijikkktusirrt(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTumitateriritu(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSetteibairitu(iwssnSyanaiHozenInfoOutputBean.getIwssnSetteibairitu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykjiTmttknzkrtjygn(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjiTmttknzkrtjygn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSisuuwari(iwssnSyanaiHozenInfoOutputBean.getIwssnSisuuwari());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTeirituwari(iwssnSyanaiHozenInfoOutputBean.getIwssnTeirituwari());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSiteituuka(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpgaika(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpyen(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKihonhokenkngk(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnGenzaisbhknkngaku(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKijyunkingakuyen(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKijyunkingakugaika(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnMkhyouyensysnnktkjnkg(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnInitsbjyensitihsykjnkg(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnJyudkaigomeharaitkkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakuhrgaika(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakuhryen(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnShrgkkeigaika(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnShrgkkeiyen(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnPtumitatekin(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnZennouseisankin(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnShrkwsrate(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKwsratesyutokuymd(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDairitencd1(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDairitencd2(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDairitenm1(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDairitenm2(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDaibosyuucd1(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnBosyuunin1(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnBosyuunin2(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbn1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbn2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbn3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbn4(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbn5(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn5());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbnkj1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbnkj2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbnkj3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbnkj4(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuikbnkj5(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj5());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuisetymd1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuisetymd2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuisetymd3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuisetymd4(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuisetymd5(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd5());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuinaiyo1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuinaiyo2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuinaiyo3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuinaiyo4(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo4());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdktyuuinaiyo5(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo5());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyoriymd1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyoriymd2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyoriymd3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyorinaiyou1(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyorinaiyou2(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTtdkrrksyorinaiyou3(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyhenkouymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkouymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyhenkousyorinm(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkousyorinm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyokensakuseiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokensakuseiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyosaihkymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSyosaihkymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYensysnhkyenhnkymd(iwssnSyanaiHozenInfoOutputBean.getIwssnYensysnhkyenhnkymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYennknhkyenhnkymd(iwssnSyanaiHozenInfoOutputBean.getIwssnYennknhkyenhnkymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnWarnmongon(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYakkanjyuryouhoukbn(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYakkanjyuryouhoukbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSioriyakkansearchcd(iwssnSyanaiHozenInfoOutputBean.getIwssnSioriyakkansearchcd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssn10nentumitateriritu(iwssnSyanaiHozenInfoOutputBean.getIwssn10nentumitateriritu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdrtkykhukakbn(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrtkykhukakbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdrkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdrkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdairinmkj(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdairinmkn(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdrseiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrseiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdryno(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdryno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdradr1kj(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr1kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdradr2kj(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr2kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdradr3kj(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr3kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKykdrknhatudoujyoutai(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrknhatudoujyoutai());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzknm1kn(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzknm1kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1seiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1sei(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1sei());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1seinm(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seinm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1tdk(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1tdknm(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdknm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1yno(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1yno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1adr1kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr1kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1adr2kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr2kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1adr3kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr3kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1telno(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1telno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzknm2kn(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzknm2kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2seiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2sei(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2sei());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2seinm(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seinm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2tdk(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2tdknm(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdknm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2yno(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2yno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2adr1kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr1kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2adr2kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr2kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2adr3kj(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr3kj());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2telno(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2telno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakukjgk(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakukjgktuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakukoujyoritu(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyuhrkkknsmnkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyuhrkkknsmnkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyuhknkknsmnkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyuhknkknsmnkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnMkhynsysnnktkjnkgtuksy(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpgaikatuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpyentuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKihonhokenkngktuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngktuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnGenzaisbhknkngakutuksy(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKijyunkingakuyentuksyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKijyunkingakugktuksyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnInitsbjyensykjnkgtksy(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensykjnkgtksy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakuhrgaikatuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaiyakuhryentuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnShrgkkeigaikatuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnShrgkkeiyentuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnZennouseisankintuukasy(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnPtumitatekintuukasyu(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSykaipnyknratesyutkymd(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHhkdrseiymd(iwssnSyanaiHozenInfoOutputBean.getIwssnHhkdrseiymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpnykntuuka(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnItijibrpnykntuukatuksy(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKzktrkserviceryumu(iwssnSyanaiHozenInfoOutputBean.getIwssnKzktrkserviceryumu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnRendouritu(iwssnSyanaiHozenInfoOutputBean.getIwssnRendouritu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk1tsindousiteikbn(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tsindousiteikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTrkkzk2tsindousiteikbn(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tsindousiteikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStknsetkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnStknsetkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnStknsetkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnStknsetkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYnkhrkmgkannittkbn(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYnkhrkmgkannittkbnnm(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDai2tsintelno(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno());

            if (C_IwssnKykSyoukaiKekkaKbn.GAITOUKEIYAKUNASI_ERROR.eq(khnaiyoujouhousyutokukekka)) {
                syorikbn = "E";
                syorikekkakbn = khnaiyoujouhousyutokukekka;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("該当契約がありません。");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            if (C_IwssnKykSyoukaiKekkaKbn.SOUGOUSYOUKAI_MITAIOUSYOUHN.eq(khnaiyoujouhousyutokukekka)) {
                syorikbn = "E";
                syorikekkakbn = khnaiyoujouhousyutokukekka;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("該当する証券番号は未対応商品です。");

                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
            }

            logger.info("△社内用Web用保全契約内容情報取得処理実行完了しました。");

            logger.info("▽社内Web用保険金契約内容情報取得処理実行します。");
            SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
            C_IwssnKykSyoukaiKekkaKbn sinaiyoujouhousyutokukekka = siGetSyanaiWebKeiyakuInfo.exec(iwssnSyanaiKykNaiyouSyoukaiInputBean.getIwssnSyono());
            iwssnSyanaiSiharaiInfoOutputBean = siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean();
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSiboushryymd(iwssnSyanaiSiharaiInfoOutputBean.getIwssnSiboushryymd());
            logger.info("△社内Web用保険金契約内容情報取得処理実行完了しました。");

            logger.info("▽社内Web用案内収納契約内容情報取得処理実行します。");
            KhansyuuGetSyanaiWebKeiyakuInfo khansyuuGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(KhansyuuGetSyanaiWebKeiyakuInfo.class);
            C_IwssnKykSyoukaiKekkaKbn khansyuunaiyoujouhousyutokukekka = khansyuuGetSyanaiWebKeiyakuInfo.exec(
                    iwssnSyanaiKykNaiyouSyoukaiInputBean.getIwssnSyono());
            iwssnSyanaiAnsyuInfoOutputBean = khansyuuGetSyanaiWebKeiyakuInfo.getIwssnSyanaiAnsyuInfoOutputBean();

            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunjkipjytym(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunjkipjytym());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunanjoannaiym1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunanjoannaiym1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunanjoannaiym2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunanjoannaiym2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunanjoannaiym3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunanjoannaiym3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijytym1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijytym1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijytym2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijytym2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijytym3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijytym3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbn1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbn1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbn2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbn2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbn3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbn3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbnnm1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbnnm1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbnnm2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbnnm2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynanjoannaijokbnnm3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynanjoannaijokbnnm3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynannaijytkaisuuy(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynannaijytkaisuuy());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHijynannaijytkaisuum(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHijynannaijytkaisuum());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunannaigk(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunannaigk());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTeikiikkatubaraijkkbn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnTeikiikkatubaraijkkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTikiktbrjkkbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnTikiktbrjkkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkkaisuukbn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkkaisuukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkkaisuukbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkkaisuukbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkkeirokbn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkkeirokbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkkeirokbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkkeirokbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkp(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkp());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDattairiyuukbn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnDattairiyuukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDattairiyuukbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnDattairiyuukbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjkouzano(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjkouzano());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjkzmeigikn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjkzmeigikn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjbanknm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjbanknm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjsitennm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjsitennm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjyokinkbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjyokinkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjbankcd(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjbankcd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjsitencd(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjsitencd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYfrjyokinkbn(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYfrjyokinkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDattaisyoriymd(iwssnSyanaiAnsyuInfoOutputBean.getIwssnDattaisyoriymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDtjcomment(iwssnSyanaiAnsyuInfoOutputBean.getIwssnDtjcomment());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunannaiym(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunannaiym());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHeijyunannaijyutouym(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHeijyunannaijyutouym());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnCreyuukoukakkekka(iwssnSyanaiAnsyuInfoOutputBean.getIwssnCreyuukoukakkekka());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnCreyuukoukakkekkakbnnm(iwssnSyanaiAnsyuInfoOutputBean.getIwssnCreyuukoukakkekkakbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnCredityuukoukakym(iwssnSyanaiAnsyuInfoOutputBean.getIwssnCredityuukoukakym());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbn1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbn1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbn2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbn2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbn3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbn3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbnnm1(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbnnm1());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbnnm2(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbnnm2());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnUragngjiyuukbnnm3(iwssnSyanaiAnsyuInfoOutputBean.getIwssnUragngjiyuukbnnm3());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnHrkptuukasyu(iwssnSyanaiAnsyuInfoOutputBean.getIwssnHrkptuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYenkansanp(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYenkansanp());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYenkansanptuukasyu(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYenkansanptuukasyu());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKktikwsrate(iwssnSyanaiAnsyuInfoOutputBean.getIwssnKktikwsrate());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKnsnkijyunymd(iwssnSyanaiAnsyuInfoOutputBean.getIwssnKnsnkijyunymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnYykknmnryymd(iwssnSyanaiAnsyuInfoOutputBean.getIwssnYykknmnryymd());
            logger.info("△社内Web用案内収納契約内容情報取得処理実行完了しました。");

            logger.info("▽社内用Web用DS契約内容情報取得処理実行します。");
            DsGetSyanaiWebKeiyakuInfo dsGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(DsGetSyanaiWebKeiyakuInfo.class);
            C_IwssnKykSyoukaiKekkaKbn dsnaiyoujouhousyutokukekka = dsGetSyanaiWebKeiyakuInfo.exec(
                    iwssnSyanaiKykNaiyouSyoukaiInputBean.getIwssnSyono());
            iwssnSyanaiDsInfoOutputBean = dsGetSyanaiWebKeiyakuInfo.getIwssnSyanaiDsInfoOutputBean();

            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDsokyksmno(iwssnSyanaiDsInfoOutputBean.getIwssnDsokyksmno());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDsmailaddress(iwssnSyanaiDsInfoOutputBean.getIwssnDsmailaddress());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskokyakujtkbn(iwssnSyanaiDsInfoOutputBean.getIwssnDskokyakujtkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskokyakujtkbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnDskokyakujtkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaripasswordhkymd(iwssnSyanaiDsInfoOutputBean.getIwssnKaripasswordhkymd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTelttdkkahikbn(iwssnSyanaiDsInfoOutputBean.getIwssnTelttdkkahikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTelttdkahikbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnTelttdkahikbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTelttdkhukariyuukbn(iwssnSyanaiDsInfoOutputBean.getIwssnTelttdkhukariyuukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnTelttdkhukariyuukbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnTelttdkhukariyuukbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskouzano(iwssnSyanaiDsInfoOutputBean.getIwssnDskouzano());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskzmeigii(iwssnSyanaiDsInfoOutputBean.getIwssnDskzmeigii());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskinyunm(iwssnSyanaiDsInfoOutputBean.getIwssnDskinyunm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSitennm(iwssnSyanaiDsInfoOutputBean.getIwssnSitennm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDsyokinkbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnDsyokinkbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskzsyuruikbn(iwssnSyanaiDsInfoOutputBean.getIwssnDskzsyuruikbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskzsyuruikbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnDskzsyuruikbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDsbankcd(iwssnSyanaiDsInfoOutputBean.getIwssnDsbankcd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDssitencd(iwssnSyanaiDsInfoOutputBean.getIwssnDssitencd());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDsyokinkbn(iwssnSyanaiDsInfoOutputBean.getIwssnDsyokinkbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskzdoukbn(iwssnSyanaiDsInfoOutputBean.getIwssnDskzdoukbn());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnDskzdoukbnnm(iwssnSyanaiDsInfoOutputBean.getIwssnDskzdoukbnnm());
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnKaripasswordykymd(iwssnSyanaiDsInfoOutputBean.getIwssnKaripasswordykymd());
            logger.info("△社内Web用DS契約内容情報取得処理実行完了しました。");

            if (C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(khnaiyoujouhousyutokukekka) && C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(sinaiyoujouhousyutokukekka) &&
                    C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(khansyuunaiyoujouhousyutokukekka) && C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(dsnaiyoujouhousyutokukekka)) {
                syorikbn = "0";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("共通機能正常終了");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            logger.info("保全内容情報取得結果（社内用契約内容照会結果区分）：" + khnaiyoujouhousyutokukekka.getValue());
            logger.info("保険金契約内容情報取得結果（社内用契約内容照会結果区分）：" + sinaiyoujouhousyutokukekka.getValue());
            logger.info("案内収納契約内容情報取得結果（社内用契約内容照会結果区分）：" + khansyuunaiyoujouhousyutokukekka.getValue());
            logger.info("DS契約内容情報取得結果（社内用契約内容照会結果区分）：" + dsnaiyoujouhousyutokukekka.getValue());

            if (C_IwssnKykSyoukaiKekkaKbn.EXCEPTION.eq(khnaiyoujouhousyutokukekka) || C_IwssnKykSyoukaiKekkaKbn.EXCEPTION.eq(sinaiyoujouhousyutokukekka) ||
                    C_IwssnKykSyoukaiKekkaKbn.EXCEPTION.eq(khansyuunaiyoujouhousyutokukekka) || C_IwssnKykSyoukaiKekkaKbn.EXCEPTION.eq(dsnaiyoujouhousyutokukekka)) {
                syorikbn = "E";
                syorikekkakbn = C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();
                logger.info("プログラム不正想定外エラー");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }
            if (C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR.eq(khnaiyoujouhousyutokukekka) || C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR.eq(khnaiyoujouhousyutokukekka) ||
                    C_IwssnKykSyoukaiKekkaKbn.CASHVALUEINFO_ERROR.eq(khnaiyoujouhousyutokukekka) || C_IwssnKykSyoukaiKekkaKbn.KIOUREKI_ERROR.eq(khnaiyoujouhousyutokukekka) ||
                    C_IwssnKykSyoukaiKekkaKbn.TANTOUSYAINFO_ERROR.eq(khnaiyoujouhousyutokukekka) || C_IwssnKykSyoukaiKekkaKbn.TDKTYUUIINFO_ERROR.eq(khnaiyoujouhousyutokukekka)) {
                syorikbn = "W";
                syorikekkakbn = khnaiyoujouhousyutokukekka;
                syorikekkakbnnm = syorikekkakbn.getContent();
                if (!C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(sinaiyoujouhousyutokukekka) || !C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(khansyuunaiyoujouhousyutokukekka) ||
                        !C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(dsnaiyoujouhousyutokukekka)) {
                    syoriErrorFlag = "1";
                }
                else {
                    syoriErrorFlag = "0";
                }

                logger.info("社内用Web用保全契約内容情報取得処理に失敗しました。（" + syorikekkakbnnm + ")");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }
            if (C_IwssnKykSyoukaiKekkaKbn.DSKANRENKOUMOKU_ERROR.eq(dsnaiyoujouhousyutokukekka)) {

                syorikbn = "W";
                syorikekkakbn =dsnaiyoujouhousyutokukekka;
                syorikekkakbnnm = syorikekkakbn.getContent();

                if (!C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(sinaiyoujouhousyutokukekka) || !C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(khansyuunaiyoujouhousyutokukekka)) {
                    syoriErrorFlag = "1";
                }
                else {
                    syoriErrorFlag = "0";
                }

                logger.info("社内Web用DS契約内容情報取得処理に失敗しました。（" + syorikekkakbnnm + ")");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }
            if (C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR.eq(sinaiyoujouhousyutokukekka)) {
                syorikbn = "W";
                syorikekkakbn = sinaiyoujouhousyutokukekka;
                syorikekkakbnnm = syorikekkakbn.getContent();
                if (!C_IwssnKykSyoukaiKekkaKbn.NORMAL.eq(khansyuunaiyoujouhousyutokukekka)) {
                    syoriErrorFlag = "1";
                }
                else {
                    syoriErrorFlag = "0";
                }

                logger.info("社内Web用保険金契約内容情報取得処理に失敗しました。（" + syorikekkakbnnm + ")");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }
            if (C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR.eq(khansyuunaiyoujouhousyutokukekka)) {
                syorikbn = "W";
                syorikekkakbn = khansyuunaiyoujouhousyutokukekka;
                syoriErrorFlag = "0";
                syorikekkakbnnm = syorikekkakbn.getContent();

                logger.info("社内Web用案内収納契約情報取得処理に失敗しました。（" + syorikekkakbnnm + ")");

                //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
                iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

                logger.info("▽JSONエンコード実行します。");
                iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
                logger.info("△JSONエンコード完了します。");

                logger.info("△ 社内用契約内容照会処理を終了します｡");

                return iwssnBzWebserviceResParamBean;
                //return wsBzWebserviceResParamBean;
                //return wsBzWebserviceResParamHandmadeBean;
            }

            //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + "△");
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn(syorikbn + syorikekkakbn.getValue() + syoriErrorFlag + SPACE_HANKAKU);
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm(syorikekkakbnnm);

            logger.info("▽JSONエンコード実行します。");
            iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
            //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
            //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
            logger.info("△JSONエンコード完了します。");

            logger.info("△ 社内用契約内容照会処理を終了します｡");

            return iwssnBzWebserviceResParamBean;
            //return wsBzWebserviceResParamBean;
            //return wsBzWebserviceResParamHandmadeBean;

        }
        catch (Exception e) {

            //logger.info(e.getMessage());
            //for(StackTraceElement s : e.getStackTrace()){
            //    logger.info("class名：" + s.getClassName() + "行：" + s.getLineNumber() + "メソッド名：" + s.getMethodName());
            //}

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stacktrace = sw.toString();
            logger.info(stacktrace);


            logger.info("プログラム不正想定外エラー");

            IwssnBzWebserviceResParamBean iwssnBzWebserviceResParamBean = SWAKInjector.getInstance(IwssnBzWebserviceResParamBean.class);
            //WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            //WsBzWebserviceResParamHandmadeBean wsBzWebserviceResParamHandmadeBean = SWAKInjector.getInstance(WsBzWebserviceResParamHandmadeBean.class);

            IwssnSyanaiKykNaiyouSyoukaiOutputBean iwssnSyanaiKykNaiyouSyoukaiOutputBean =
                    SWAKInjector.getInstance(IwssnSyanaiKykNaiyouSyoukaiOutputBean.class);

            //iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn("EZZ0△");
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbn("EZZ0" + SPACE_HANKAKU);
            iwssnSyanaiKykNaiyouSyoukaiOutputBean.setIwssnSyorikekkakbnnm("プログラム不正想定外エラー");

            logger.info("▽JSONエンコード実行します。");
            iwssnBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
            //wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));
            //wsBzWebserviceResParamHandmadeBean.setGyoumuData(JSON.encode(iwssnSyanaiKykNaiyouSyoukaiOutputBean));

            logger.info("△JSONエンコード完了します。");

            return iwssnBzWebserviceResParamBean;
            //return wsBzWebserviceResParamBean;
            //return wsBzWebserviceResParamHandmadeBean;
        }
    }

}
