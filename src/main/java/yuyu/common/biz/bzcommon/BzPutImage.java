package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;

/**
 * 業務共通 共通 業務共通イメージ登録
 */
public class BzPutImage {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    public BzPutImage() {
        super();
    }

    public BzPutImageOutputBean exec(BzPutImageInputBean pBzPutImageInputBean) {

        logger.debug("▽ 業務共通イメージ登録 開始");

        String userId = "";

        String jimuTetuzukiCd = "";

        BzPutImageOutputBean bzPutImageOutputBean = SWAKInjector.getInstance(BzPutImageOutputBean.class);

        if (BizUtil.isBlank(pBzPutImageInputBean.getUserId())) {
            userId = baseUserInfo.getUserId();
        }

        else {
            userId = pBzPutImageInputBean.getUserId();
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(pBzPutImageInputBean.getKouteiKanriId());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst =
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.size() == 0)  {
            bzPutImageOutputBean.setKekkaStatus(WorkFlowResultConstants.RESULT_NG);
            logger.debug("△ 業務共通イメージ登録 終了");
            return bzPutImageOutputBean;
        }

        jimuTetuzukiCd = bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd();

        IwfImageClient iwfImageClient = SWAKInjector.getInstance(IwfImageClient.class);

        PutImageInBean putImageInBean = SWAKInjector.getInstance(PutImageInBean.class);

        putImageInBean.setSyoruicd(pBzPutImageInputBean.getSyoruiCd().getValue());

        putImageInBean.setAccountid(userId);

        putImageInBean.setFlowid(jimuTetuzukiCd);

        putImageInBean.setImagedata(pBzPutImageInputBean.getImageDatas());

        putImageInBean.setGyoumukey(pBzPutImageInputBean.getKouteiKanriId());

        putImageInBean.setSyoruitoutyakutime(pBzPutImageInputBean.getSyoruiTtykYmdTime());

        putImageInBean.setTourokutime(pBzPutImageInputBean.getTourokuYmdTime());

        WSPutImageResponse putImageOutBean = iwfImageClient.execPutImage(putImageInBean);

        if (!WorkFlowResultConstants.RESULT_OK.equals(putImageOutBean.getKekkastatus())) {

            bzPutImageOutputBean.setKekkaStatus(putImageOutBean.getKekkastatus());

            bzPutImageOutputBean.setSyousaiMsgCd(putImageOutBean.getSyousaimsgcd());

            bzPutImageOutputBean.setSyousaiMsg(putImageOutBean.getSyousaimsg());

            bzPutImageOutputBean.setImageId("");
        }

        else {

            bzPutImageOutputBean.setKekkaStatus(WorkFlowResultConstants.RESULT_OK);

            bzPutImageOutputBean.setImageId(putImageOutBean.getImgid());
        }

        logger.debug("△ 業務共通イメージ登録 終了");

        return bzPutImageOutputBean;
    }
}
