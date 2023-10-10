package yuyu.app.bosyuu.hbsekmos.hbseihowebmosno;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtil;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomi;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosNoInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosNoOutputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 生保Ｗｅｂ申込番号取得サービスの実装クラスです。<br />
 */
public class HbSeihoWebMosnoImpl implements HbSeihoWebMosno {

    private static final String ERRORKBN_MOSNO_OK = "0";

    private static final String ERRORKBN_MOSNO_NONE = "1";

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

    private String errHukaMsg = "";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) throws Exception {

        try {
            logger.debug("▽ 生保Ｗｅｂ申込番号取得 開始");

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebMosNoOutputBean seihoWebMosNoOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebMosNoOutputBean.class);

            seihoWebMosNoOutputBean = initOutputBean(seihoWebMosNoOutputBean);

            WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean =
                SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

            String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

            WsHbSeihoWebMosNoInputBean seihoWebMosNoInputBean;

            try {
                seihoWebMosNoInputBean =
                    FixedlengthConvertUtil.stringToBeanForFixedlength(gyoumuData, WsHbSeihoWebMosNoInputBean.class);
            }
            catch (RuntimeException e) {

                if (e.getCause() != null && e.getCause() instanceof CvtVdtException) {

                    logger.debug("△ 生保Ｗｅｂ申込番号取得 入力値エラー");

                    seihoWebMosNoOutputBean.setIwsErrkbn(ERRORKBN_MOSNO_NONE);

                    seihoWebMosNoOutputBean = paddingOutputBean(seihoWebMosNoOutputBean);

                    logger.debug("WsHbSeihoWebMosNoOutputBean:"+ seihoWebMosNoOutputBean.toString());

                    wsBzWebserviceResParamBean.setGyoumuData(
                        FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosNoOutputBean));

                    logger.debug("△ 生保Ｗｅｂ申込番号取得 終了");

                    return wsBzWebserviceResParamBean;
                }

                errHukaMsg = creatErrorMsg("入力値エラー" , wsBzWebserviceReqParamBean);
                throw e;
            }

            WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
            webServiceAccesslogOutput.exec(
                C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, seihoWebMosNoInputBean);

            HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen = SWAKInjector.getInstance(HbSeihoWebHanteiKengen.class);
            C_SeihowebkengenKbn seihowebkengenKbn =
                hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

            if (C_SeihowebkengenKbn.TANMATUERROR.eq(seihowebkengenKbn)) {

                logger.debug("△ 生保Ｗｅｂ申込番号取得 端末権限エラー");

                seihoWebMosNoOutputBean.setIwsErrkbn(ERRORKBN_MOSNO_NONE);

                seihoWebMosNoOutputBean = paddingOutputBean(seihoWebMosNoOutputBean);

                logger.debug("WsHbSeihoWebMosNoOutputBean:"+ seihoWebMosNoOutputBean.toString());

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosNoOutputBean));

                logger.debug("△ 生保Ｗｅｂ申込番号取得 終了");

                return wsBzWebserviceResParamBean;
            }
            else if (C_SeihowebkengenKbn.SIYOUSHAERROR.eq(seihowebkengenKbn)) {

                logger.debug("△ 生保Ｗｅｂ申込番号取得 使用者権限エラー");

                seihoWebMosNoOutputBean.setIwsErrkbn(ERRORKBN_MOSNO_NONE);

                seihoWebMosNoOutputBean = paddingOutputBean(seihoWebMosNoOutputBean);

                logger.debug("WsHbSeihoWebMosNoOutputBean:"+ seihoWebMosNoOutputBean.toString());

                wsBzWebserviceResParamBean.setGyoumuData(
                    FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosNoOutputBean));

                logger.debug("△ 生保Ｗｅｂ申込番号取得 終了");

                return wsBzWebserviceResParamBean;
            }

            mosnoSaiban(seihoWebMosNoInputBean, seihoWebMosNoOutputBean, wsBzWebserviceReqParamBean, wsBzWebserviceResParamBean);


            logger.debug("△ 生保Ｗｅｂ申込番号取得 終了");

            return wsBzWebserviceResParamBean;

        }
        catch (Exception e) {

            logger.error(errHukaMsg, e);

            WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
                SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            WsHbSeihoWebMosNoOutputBean seihoWebMosNoOutputBean =
                SWAKInjector.getInstance(WsHbSeihoWebMosNoOutputBean.class);

            seihoWebMosNoOutputBean = initOutputBean(seihoWebMosNoOutputBean);

            seihoWebMosNoOutputBean.setIwsErrkbn(ERRORKBN_MOSNO_NONE);

            seihoWebMosNoOutputBean = paddingOutputBean(seihoWebMosNoOutputBean);

            logger.debug("WsHbSeihoWebMosNoOutputBean:"+ seihoWebMosNoOutputBean.toString());

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosNoOutputBean));

            logger.debug("△ 生保Ｗｅｂ申込番号取得 終了");

            return wsBzWebserviceResParamBean;

        }
    }

    private WsHbSeihoWebMosNoOutputBean paddingOutputBean(WsHbSeihoWebMosNoOutputBean seihoWebMosNoOutputBean) {

        seihoWebMosNoOutputBean.setIwsMosno(Strings.padEnd(seihoWebMosNoOutputBean.getIwsMosno(), 9, '0'));
        seihoWebMosNoOutputBean.setIwsDocumentid1(Strings.padEnd(seihoWebMosNoOutputBean.getIwsDocumentid1(), 21, '0'));
        seihoWebMosNoOutputBean.setIwsDocumentid2(Strings.padEnd(seihoWebMosNoOutputBean.getIwsDocumentid2(), 21, '0'));
        seihoWebMosNoOutputBean.setIwsDocumentid3(Strings.padEnd(seihoWebMosNoOutputBean.getIwsDocumentid3(), 21, '0'));
        seihoWebMosNoOutputBean.setIwsDocumentid4(Strings.padEnd(seihoWebMosNoOutputBean.getIwsDocumentid4(), 21, '0'));

        return seihoWebMosNoOutputBean;
    }

    private WsHbSeihoWebMosNoOutputBean initOutputBean(WsHbSeihoWebMosNoOutputBean seihoWebMosNoOutputBean) {

        seihoWebMosNoOutputBean.setIwsErrkbn(null);
        seihoWebMosNoOutputBean.setIwsMosno("");
        seihoWebMosNoOutputBean.setIwsDocumentid1("");
        seihoWebMosNoOutputBean.setIwsDocumentid2("");
        seihoWebMosNoOutputBean.setIwsDocumentid3("");
        seihoWebMosNoOutputBean.setIwsDocumentid4("");

        return seihoWebMosNoOutputBean;
    }

    private C_SkeijimuKbn getSkeijimukbn(WsHbSeihoWebMosNoInputBean seihoWebMosNoInputBean) {

        C_BosyuusysctrlKbn bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.BLNK;
        C_SkeijimuKbn skeijimukbn = C_SkeijimuKbn.BLNK;

        if (DRTENREPORTGYOUTAIKBN_SMBC.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.SMBC;
        }
        else if (DRTENREPORTGYOUTAIKBN_TIGIN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.TIGIN;
        }
        else if (DRTENREPORTGYOUTAIKBN_SINKIN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.SINKIN;
        }
        else if (DRTENREPORTGYOUTAIKBN_DIRECT.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.DIRECT;
        }
        else if (DRTENREPORTGYOUTAIKBN_MARUKIN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.MARUKIN;
        }
        else if (DRTENREPORTGYOUTAIKBN_SMTB.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.SMTB;
        }
        else if (DRTENREPORTGYOUTAIKBN_GAISANTIGIN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.GAISANTIGIN;
        }
        else if (DRTENREPORTGYOUTAIKBN_GAISANSINKIN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.GAISANSINKIN;
        }
        else if (DRTENREPORTGYOUTAIKBN_SONOTAMADOHAN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.SONOTAMADOHAN;
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIGINKOU.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.YUUSEIGINKOU;
        }
        else if (DRTENREPORTGYOUTAIKBN_YUUSEIKAISYA.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.YUUSEIKAISYA;
        }
        else if (DRTENREPORTGYOUTAIKBN_UUSEIKANPO.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.YUUSEIKANPO;
        }
        else if (DRTENREPORTGYOUTAIKBN_SHOPMDHN.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.SHOPMDHN;
        }
        else if (DRTENREPORTGYOUTAIKBN_MIZUHO.equals(
            seihoWebMosNoInputBean.getIwsDrtentyouhyougyoutaikbn())) {

            bosyuuSysCtrlKbn = C_BosyuusysctrlKbn.MIZUHO;
        }

        if (C_BosyuusysctrlKbn.SMBC.eq(bosyuuSysCtrlKbn)) {
            skeijimukbn = C_SkeijimuKbn.SMBC;
        }
        else if (C_BosyuusysctrlKbn.TIGIN.eq(bosyuuSysCtrlKbn)
            || C_BosyuusysctrlKbn.SINKIN.eq(bosyuuSysCtrlKbn)
            || C_BosyuusysctrlKbn.GAISANTIGIN.eq(bosyuuSysCtrlKbn)
            || C_BosyuusysctrlKbn.GAISANSINKIN.eq(bosyuuSysCtrlKbn)) {
            skeijimukbn = C_SkeijimuKbn.TIGINSINKIN;
        }
        else if (C_BosyuusysctrlKbn.SMTB.eq(bosyuuSysCtrlKbn)) {
            skeijimukbn = C_SkeijimuKbn.SMTB;
        }
        else if (C_BosyuusysctrlKbn.SHOPMDHN.eq(bosyuuSysCtrlKbn)) {
            skeijimukbn = C_SkeijimuKbn.SHOP;
        }
        else if (C_BosyuusysctrlKbn.MIZUHO.eq(bosyuuSysCtrlKbn)) {
            skeijimukbn = C_SkeijimuKbn.MIZUHO;
        }

        return skeijimukbn;
    }

    @Transactional
    public void mosnoSaiban(WsHbSeihoWebMosNoInputBean seihoWebMosNoInputBean,
        WsHbSeihoWebMosNoOutputBean seihoWebMosNoOutputBean, WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean,
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean) {

        C_SkeijimuKbn skeiJimuKbn = getSkeijimukbn(seihoWebMosNoInputBean);

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = wsBzWebserviceReqParamBean.getOperatorId().substring(0, 8);

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku =
            SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
        C_HknsyuruiNo hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(seihoWebMosNoInputBean.getIwsHknsyuruino());

        String mosNo = "";
        MousikomiNoUtil mousikomiNoUtil = SWAKInjector.getInstance(MousikomiNoUtil.class);

        try {

            mosNo = mousikomiNoUtil.getMosNo(skeiJimuKbn, mosUketukeKbn, sousasyaCd);

        }
        catch (CommonBizAppException e) {

            errHukaMsg = creatErrorMsg("申込番号採番エラー" , wsBzWebserviceReqParamBean);

            throw e;
        }

        List<C_SyoruiCdKbn> syoruiCdLst = new ArrayList<>();

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsMossakuseiyh())) {

            syoruiCdLst.add(C_SyoruiCdKbn.SK_MOSSYO);
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsTahukksakuseiyh())) {

            syoruiCdLst.add(C_SyoruiCdKbn.SK_TORIHOUSYO);
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsUkthukusuustsakuseiyh())) {

            syoruiCdLst.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI);
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsIkokaksyosakuseiyh())) {

            syoruiCdLst.add(C_SyoruiCdKbn.SK_IKOUKAKSYO);
        }

        SkPreSyoruiTorikomi skPreSyoruiTorikomi =
            SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] documentIds = null;

        try {
            documentIds = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(mosNo,
                syoruiCdLst.toArray(new C_SyoruiCdKbn[syoruiCdLst.size()]), skeiJimuKbn, hknsyuruino,
                mosUketukeKbn, seihoWebMosNoInputBean.getIwsDrtencd());
        } catch(Exception e) {

            errHukaMsg = creatErrorMsg("新契約書類取込前処理エラー" , wsBzWebserviceReqParamBean);

            throw e;
        }


        String errkbn = ERRORKBN_MOSNO_OK;

        int syoruiCdCnt = -1;
        String documentId1 = "";
        String documentId2 = "";
        String documentId3 = "";
        String documentId4 = "";

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsMossakuseiyh())) {
            syoruiCdCnt = syoruiCdCnt + 1;

            documentId1 = documentIds[syoruiCdCnt];
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsTahukksakuseiyh())) {
            syoruiCdCnt = syoruiCdCnt + 1;

            documentId2 = documentIds[syoruiCdCnt];
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsUkthukusuustsakuseiyh())) {
            syoruiCdCnt = syoruiCdCnt + 1;

            documentId3 = documentIds[syoruiCdCnt];
        }

        if (C_YouhiKbn.YOU.eq(seihoWebMosNoInputBean.getIwsIkokaksyosakuseiyh())) {
            syoruiCdCnt = syoruiCdCnt + 1;

            documentId4 = documentIds[syoruiCdCnt];
        }

        seihoWebMosNoOutputBean.setIwsErrkbn(errkbn);
        seihoWebMosNoOutputBean.setIwsMosno(mosNo);
        seihoWebMosNoOutputBean.setIwsDocumentid1(documentId1);
        seihoWebMosNoOutputBean.setIwsDocumentid2(documentId2);
        seihoWebMosNoOutputBean.setIwsDocumentid3(documentId3);
        seihoWebMosNoOutputBean.setIwsDocumentid4(documentId4);

        paddingOutputBean(seihoWebMosNoOutputBean);

        logger.debug("WsHbSeihoWebMosNoOutputBean:"+ seihoWebMosNoOutputBean.toString());

        try {

            wsBzWebserviceResParamBean.setGyoumuData(
                FixedlengthConvertUtil.beanToStringForFixedlength(seihoWebMosNoOutputBean));
        } catch(Exception e) {

            errHukaMsg = creatErrorMsg("出力データエラー" , wsBzWebserviceReqParamBean);

            throw e;
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
