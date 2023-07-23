package iwf.callback.arriveimage.imageTerminator;

import iwf.callback.arriveimage.ImportImageTerminator;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.iwfcommon.CheckException;

/**
 * イメージ到着後処理サービスメインクラス
 */
public class WSImageTerminatorImpl implements WSImageTerminator {

    private final static Logger LOGGER = LoggerFactory.getLogger(WSImageTerminatorImpl.class);

    @Override
    public WSImageTerminatorResponse terminate(WSImageTerminatorRequest request) throws Exception {

        LOGGER.debug("│主処理を開始します。");

        WSImageTerminatorResponse response = new WSImageTerminatorResponse();

        String sToutyakuKey = request.getToutyakuKey();
        String sAppKey =      request.getAppKey();
        String sSyoruicd =    request.getSyoruicd();
        String sFlowid =      request.getFlowid();
        String sSubsystemid = request.getSubsystemid();
        String sImageid =     request.getImageid();

        try {
            ImportImageTerminator imageTerminator = SWAKInjector.getInstance(ImportImageTerminator.class);

            imageTerminator.terminate(sToutyakuKey, sAppKey, sSyoruicd, sFlowid, sSubsystemid, sImageid);

            IwfEditMessageUtil.setMsgResultOK(response, "イメージ到着後処理");

            return response;

        } catch (BizLogicException e) {
            e.printStackTrace();

            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWFCB30);

            response.setCberrmsg(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.error("想定外のエラーが発生しました。", e);

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWFCB31);
        }

        return response;
    }

    public WSImageTerminatorResponse validate(WSImageTerminatorRequest request) throws Exception {

        WSImageTerminatorResponse response = new WSImageTerminatorResponse();

        return response;
    }
}
