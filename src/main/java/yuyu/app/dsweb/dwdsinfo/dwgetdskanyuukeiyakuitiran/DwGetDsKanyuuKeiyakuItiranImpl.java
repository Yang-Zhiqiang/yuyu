package yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.CheckDsKaiyaku;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDataMaintenanceHantei;
import yuyu.common.direct.dscommon.DsDataMaintenanceHanteiBean;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.detacher.MT_DsKokyakuKanriDetacher;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranKykInfoBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ＤＳ加入契約一覧取得サービスの実装クラスです。<br />
 */
public class DwGetDsKanyuuKeiyakuItiranImpl implements DwGetDsKanyuuKeiyakuItiran {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1004)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {
            wsBzWebserviceResParamBean = getDsKanyuuKeiyakuItiranMain(pMap);
        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_004202;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_004201;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwGetDsKanyuuKeiyakuItiranOutputBean wsDwGetDsKanyuuKeiyakuItiranOutputBean = SWAKInjector.getInstance(WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwGetDsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwGetDsKanyuuKeiyakuItiranOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1004)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean getDsKanyuuKeiyakuItiranMain(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwGetDsKanyuuKeiyakuItiranInputBean dsKanyuuKeiyakuItiranInputBean =
            JSON.decode(gyoumuData, WsDwGetDsKanyuuKeiyakuItiranInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, dsKanyuuKeiyakuItiranInputBean);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean dsKanyuuKeiyakuItiranOutputBean =
            SWAKInjector.getInstance(WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean =
            SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean hissuChkKekka = dsKanyuuKeiyakuItiranInputBean.chkHissuInput();

        if (!hissuChkKekka) {
            dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKanyuuKeiyakuItiranOutputBean));

            return wsBzWebserviceResParamBean;

        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwGetDsKanyuuKeiyakuItiranInputBean>> chkKekkaSet =
            validator.validate(dsKanyuuKeiyakuItiranInputBean);

        if (chkKekkaSet.size() > 0) {
            dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004100);

            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKanyuuKeiyakuItiranOutputBean));

            return wsBzWebserviceResParamBean;
        }

        dsKanyuuKeiyakuItiranOutputBean = getDsKanyuuKeiyakuItiran(dsKanyuuKeiyakuItiranInputBean.getIwsDskokno());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(dsKanyuuKeiyakuItiranOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwGetDsKanyuuKeiyakuItiranOutputBean getDsKanyuuKeiyakuItiran(String pDskokno) {

        WsDwGetDsKanyuuKeiyakuItiranOutputBean dsKanyuuKeiyakuItiranOutputBean =
            SWAKInjector.getInstance(WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokno);

        dsKokyakuKanri = MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakutouched(dsKokyakuKanri);
        if (dsKokyakuKanri == null) {
            dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004200);

            return dsKanyuuKeiyakuItiranOutputBean;
        }

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst =
            dsKokyakuKanri.getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.BLANK);

        HozenKeiyakuIdouJyoutaiSyutoku hozenKeiyakuIdouJyoutaiSyutoku =
            SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
        WsDwGetDsKanyuuKeiyakuItiranKykInfoBean wsDwGetDsKanyuuKeiyakuItiranKykInfoBean = null;
        List<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean> wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst =
            new ArrayList<WsDwGetDsKanyuuKeiyakuItiranKykInfoBean>();
        C_UmuKbn kaiyakuUkeKykUmu = C_UmuKbn.NONE;

        for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuLst) {

            HozenKeiyakuIdouJyoutaiSyutokuBean hzKykIdouBean =
                hozenKeiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(dsKokyakuKeiyaku.getSyono());

            boolean checkYuuyokkngaiKekka = checkYuuyokkngai.exec(dsKokyakuKeiyaku.getSyono(), BizDate.getSysDate());

            if (C_YuukshantkekKbn.OK.eq(hzKykIdouBean.getYuukouKbn()) &&
                C_IdoutyuuHanteiKekkaKbn.IDOUNASHI.eq(hzKykIdouBean.getIdoutyuuKbn()) &&
                checkYuuyokkngaiKekka) {

                String syoNo = dsKokyakuKeiyaku.getSyono();

                CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

                C_UmuKbn kaiyakuUkeUmu = checkDsKaiyaku.kaiyakuUkeUmuChk(syoNo);

                if (C_UmuKbn.NONE.eq(kaiyakuUkeUmu)) {

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

                    List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnLst.get(0).getSyouhncd());

                    C_DsSyouhnbunruiKbn dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.BLNK;

                    String syohnkiticd = "";

                    if(syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19){
                        if (kykSyouhnLst.get(0).getYendthnkymd() == null){

                            dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.GKDTITIJIBRSYSN;
                        }
                        else {

                            dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN;
                        }

                        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {

                            syohnkiticd = "1";
                        }
                        else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            syohnkiticd = "2";
                        }
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                        if (kykSyouhnLst.get(0).getYendthnkymd() == null){

                            dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.GKDTITIJIBRNK;

                            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                                syohnkiticd = "1";
                            }
                            else if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                                syohnkiticd = "2";
                            }
                        }
                        else {

                            dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.YENDTITIJIBRNK;
                        }
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){

                        dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK;
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){

                        dsSyouhnbunruiKbn = C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN;
                    }
                    else {
                        dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004203);

                        return dsKanyuuKeiyakuItiranOutputBean;
                    }

                    DsDataMaintenanceHantei dsDataMaintenanceHantei = SWAKInjector.getInstance(DsDataMaintenanceHantei.class);
                    String kykssmongon = "";
                    BizDate sysDate = BizDate.getSysDate();

                    if (BizDateUtil.compareYmd(sysDate, kykSyouhnLst.get(0).getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(sysDate, kykSyouhnLst.get(0).getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean =
                            dsDataMaintenanceHantei.exec(dsKokyakuKeiyaku.getSyono());

                        if (C_ErrorKbn.ERROR.eq(dsDataMaintenanceHanteiBean.getKekkaKbn())) {

                            dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004204);

                            return dsKanyuuKeiyakuItiranOutputBean;
                        }

                        if (C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN.eq(dsSyouhnbunruiKbn)) {

                            kykssmongon = "（円建終身保険へ変更済）";
                        }
                        else if (C_DsSyouhnbunruiKbn.YENDTITIJIBRNK.eq(dsSyouhnbunruiKbn)){

                            kykssmongon = "（円建年金保険へ変更済）";
                        }

                        if (C_UmuKbn.ARI.eq(dsDataMaintenanceHanteiBean.getDsDataMaintenanceUmuKbn())){

                            kykssmongon = "（データメンテナンス中）";
                        }
                    }

                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBean = SWAKInjector.getInstance(WsDwGetDsKanyuuKeiyakuItiranKykInfoBean.class);

                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBean.setIwsSyono(syoNo);
                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBean.setIwsDssyouhnbunruikbn(dsSyouhnbunruiKbn.getValue());
                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBean.setIwsSyohnkiticd(syohnkiticd);
                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBean.setIwsKykssmongon(kykssmongon);
                    wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst.add(wsDwGetDsKanyuuKeiyakuItiranKykInfoBean);
                }
                else {
                    kaiyakuUkeKykUmu = C_UmuKbn.ARI;
                }
            }
        }

        if (wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst.size() == 0) {
            dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_004001);

            return dsKanyuuKeiyakuItiranOutputBean;
        }

        String dsMsgCd = "";
        if (C_UmuKbn.ARI.eq(kaiyakuUkeKykUmu)) {
            dsMsgCd = DwMessageCodeConstants.IWSDSMSGCD_004002;
        }
        else {
            dsMsgCd = DwMessageCodeConstants.IWSDSMSGCD_004000;
        }

        dsKanyuuKeiyakuItiranOutputBean.setIwsDsmsgcd(dsMsgCd);
        dsKanyuuKeiyakuItiranOutputBean.setWsDwGetDsKanyuuKeiyakuItiranKykInfoBeanList(wsDwGetDsKanyuuKeiyakuItiranKykInfoBeanLst);

        return dsKanyuuKeiyakuItiranOutputBean;
    }
}
