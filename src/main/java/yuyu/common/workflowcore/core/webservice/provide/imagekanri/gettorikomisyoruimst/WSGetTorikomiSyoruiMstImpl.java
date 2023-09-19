package yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 取込書類マスタ情報取得サービスメインクラス
 */
public class WSGetTorikomiSyoruiMstImpl implements WSGetTorikomiSyoruiMst {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetTorikomiSyoruiMstImpl.class);

    public WSGetTorikomiSyoruiMstImpl() {
        super();
    }

    public WSGetTorikomiSyoruiMstResponse validate(WSGetTorikomiSyoruiMstRequest request)
        throws Exception {
        WSGetTorikomiSyoruiMstResponse oResponse = new WSGetTorikomiSyoruiMstResponse();

        return oResponse;
    }

    public String getServiceName() {

        return WSGetTorikomiSyoruiMstRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetTorikomiSyoruiMstResponse executeBizMain(
        WSGetTorikomiSyoruiMstRequest request) throws Exception {
        WSGetTorikomiSyoruiMstResponse oWSResponse = new WSGetTorikomiSyoruiMstResponse();

        String sTorikomiSyoruiCd = request.getTorikomisyoruicd();
        String sSyzkDaibunruiId = request.getSyzkdaibunruiid();
        String sSyzkSyoubunruiId = request.getSyzksyoubunruiid();
        String sFlowId = request.getFlowid();
        String sNodeId = request.getNodeid();

        ArrayList<TorikomiSyoruiBean> torikomiSyoruis = new ArrayList<TorikomiSyoruiBean>();
        TorikomiSyoruiBean torikomiSyoruiBean = new TorikomiSyoruiBean();

        try {
            List<WM_TorikomiSyorui> syoruiList = iwfCoreDomManager.getTorikomiSyoruis(sTorikomiSyoruiCd, sSyzkDaibunruiId, sSyzkSyoubunruiId, sFlowId, sNodeId);
            Iterator<WM_TorikomiSyorui> itrsyorui = syoruiList.iterator();
            WM_TorikomiSyorui syorui = null;

            if(itrsyorui.hasNext()){
                while(itrsyorui.hasNext()){
                    syorui = itrsyorui.next();

                    String sTorikomiSyoruiCd_syorui =syorui.getTorikomiSyoruiCd();
                    String sTorikomiSyoruiNm_syorui =syorui.getTorikomiSyoruiNm();
                    String sTorikomiSyoruiRyaku_syorui =syorui.getTorikomiSyoruiRyaku();
                    String sSyzkDaiBunruiId_syorui =syorui.getSyzkDaiBunruiId();
                    String sSyzkSyouBunruiId_syorui =syorui.getSyzkSyouBunruiId();
                    String sZipHozonKbn_syorui = (null == syorui.getZipHozonKbn()) ? null : syorui.getZipHozonKbn()
                        .toString();
                    String sKouteiSeigyoUmuKbn_syorui = (null == syorui.getKouteiSeigyoUmuKbn()) ? null : syorui
                        .getKouteiSeigyoUmuKbn().toString();
                    String sFlowId_syorui =syorui.getFlowId();
                    String sNodeId_syorui =syorui.getNodeId();

                    torikomiSyoruiBean = new TorikomiSyoruiBean();

                    torikomiSyoruiBean.setTorikomisyoruicd(sTorikomiSyoruiCd_syorui);
                    torikomiSyoruiBean.setTorikomisyoruinm(sTorikomiSyoruiNm_syorui);
                    torikomiSyoruiBean.setTorikomisyoruiryaku(sTorikomiSyoruiRyaku_syorui);
                    torikomiSyoruiBean.setSyzkdaibunruiid(sSyzkDaiBunruiId_syorui);
                    torikomiSyoruiBean.setSyzksyoubunruiid(sSyzkSyouBunruiId_syorui);
                    torikomiSyoruiBean.setZiphozonkbn(sZipHozonKbn_syorui);
                    torikomiSyoruiBean.setKouteiseigyoumukbn(sKouteiSeigyoUmuKbn_syorui);
                    torikomiSyoruiBean.setFlowid(sFlowId_syorui);
                    torikomiSyoruiBean.setNodeid(sNodeId_syorui);

                    torikomiSyoruis.add(torikomiSyoruiBean);
                }
                oWSResponse.setTorikomisyoruilist(torikomiSyoruis);

            } else {
                IwfEditMessageUtil.setMsgResultNG_RecordNotFound(oWSResponse, WM_TorikomiSyorui.TABLE_NAME);
                return oWSResponse;
            }

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "取込書類マスタ情報取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "取込書類マスタ情報取得");
        } finally {

        }
        return oWSResponse;
    }

    public WSGetTorikomiSyoruiMstResponse getStubResult(
        WSGetTorikomiSyoruiMstRequest request) throws Exception {

        return null;
    }

    public void executeBizTerminate(WSGetTorikomiSyoruiMstRequest request, WSGetTorikomiSyoruiMstResponse response) throws Exception {
        LOGGER.debug("│終了開始・・・");
    }

    public WSGetTorikomiSyoruiMstResponse getBootErrResponse() {
        WSGetTorikomiSyoruiMstResponse res = new WSGetTorikomiSyoruiMstResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
