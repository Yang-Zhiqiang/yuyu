package iwf.callback.arriveimage.toutyakuYoteiNotFound;

import iwf.callback.arriveimage.ToutyakuYoteiInfo;
import iwf.callback.arriveimage.ToutyakuYoteiNotFound;

import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.iwfcommon.CheckException;

/**
 * 到着予定未存在時サービスメインクラス
 */
public class WSToutyakuYoteiNotFoundImpl implements WSToutyakuYoteiNotFound {

    private final static Logger LOGGER = LoggerFactory.getLogger(WSToutyakuYoteiNotFoundImpl.class);

    @Override
    @Transactional
    public WSToutyakuYoteiNotFoundResponse exec(WSToutyakuYoteiNotFoundRequest request) throws Exception {

        LOGGER.debug("│主処理を開始します。");

        WSToutyakuYoteiNotFoundResponse response = new WSToutyakuYoteiNotFoundResponse();

        String sToutyakuKey = request.getToutyakuKey();

        try {
            ToutyakuYoteiNotFound yoteiNotFound = SWAKInjector.getInstance(ToutyakuYoteiNotFound.class);

            ToutyakuYoteiInfo yoteiInfo = yoteiNotFound.exec(sToutyakuKey);

            response.setToutyakuKey(yoteiInfo.getToutyakuKey());
            response.setAppKey(yoteiInfo.getAppKey());
            response.setFlowid(yoteiInfo.getFlowId());
            response.setSyoruicd(yoteiInfo.getSyoruiCd());
            response.setSubsystemid(yoteiInfo.getSubSystemId());

            IwfEditMessageUtil.setMsgResultOK(response, "到着予定未存在時処理");

            return response;
        } catch (BizLogicException e) {
            e.printStackTrace();

            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWFCB20);

            response.setCberrmsg(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.error("想定外のエラーが発生しました。", e);

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWFCB21);
        }

        return response;
    }

    public WSToutyakuYoteiNotFoundResponse validate(String toutyakuKey) throws Exception {

        WSToutyakuYoteiNotFoundResponse response = new WSToutyakuYoteiNotFoundResponse();

        if (StringUtils.isEmpty(toutyakuKey)) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "到着キー");
        }

        return response;
    }
}
