package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryOutBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;

/**
 * 業務共通 共通 業務共通イメージ取得クラス
 */
public class BzGetImage {

    @Inject
    private static Logger logger;

    @Inject
    private IwfImageClient iwfImageClient;

    @Inject
    private IwfKouteiClient iwfKouteiClient;

    public BzGetImage() {
        super();
    }

    public BzGetImageOutputBean exec(String[] pImageId, String pUserId) {

        logger.debug("▽ 業務共通イメージ取得 開始");

        BzGetImageOutputBean bzGetImageOutputBean = SWAKInjector.
            getInstance(BzGetImageOutputBean.class);

        List<BzImageInfoBean> bzImageInfoBeanList = new ArrayList<>();

        GetImageInBean getImageInBean = SWAKInjector.getInstance(GetImageInBean.class);

        getImageInBean.setImageids(pImageId);
        getImageInBean.setAccountid(pUserId);

        WSGetImageByIdResponse wsGetImageByIdResponse = iwfImageClient.execGetImage(getImageInBean);

        bzGetImageOutputBean.setSyousaiMessageCd(wsGetImageByIdResponse.getSyousaimsgcd());

        bzGetImageOutputBean.setSyousaiMessage(wsGetImageByIdResponse.getSyousaimsg());

        if (!"0".equals(wsGetImageByIdResponse.getKekkastatus())) {
            bzGetImageOutputBean.setSyoriKekkaStatus(wsGetImageByIdResponse.getKekkastatus());

            logger.debug("△ 業務共通イメージ取得 終了");

            return bzGetImageOutputBean;
        }

        if (wsGetImageByIdResponse.getImageinfolist().size() <= 0) {
            bzGetImageOutputBean.setSyoriKekkaStatus("-1");

            logger.debug("△ 業務共通イメージ取得 終了");

            return bzGetImageOutputBean;
        }

        for (int n = 0; n < wsGetImageByIdResponse.getImageinfolist().size(); n++) {

            BzImageInfoBean bzImageInfoBean = SWAKInjector.getInstance(BzImageInfoBean.class);

            GetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector.getInstance(GetProcessSummaryInBean.class);

            bzImageInfoBean.setImageId(wsGetImageByIdResponse.getImageinfolist().get(n).getImageid());

            bzImageInfoBean.setTorikomiSyoruiCd(wsGetImageByIdResponse.getImageinfolist().get(n).getTorikomisyoruicd());

            bzImageInfoBean.setSyoruiTtykYmdTime(wsGetImageByIdResponse.getImageinfolist().get(n)
                .getSyoruitoutyakutime());

            bzImageInfoBean.setKengenUmu(wsGetImageByIdResponse.getImageinfolist().get(n).getKengenumu());

            bzImageInfoBean.setPdfImage(wsGetImageByIdResponse.getImageinfolist().get(n).getPdfimage());

            getProcessSummaryInBean.setGyoumukey(wsGetImageByIdResponse.getImageinfolist().get(n).getGyoumukey());

            GetProcessSummaryOutBean getProcessSummaryOutBean =
                iwfKouteiClient.execGetProcessSummary(getProcessSummaryInBean);

            if ("0".equals(getProcessSummaryOutBean.getKekkastatus())) {
                bzImageInfoBean.setMosno(getProcessSummaryOutBean.getProcessSummaryBeanList().get(0).getExtparamBean()
                    .getExtparam14());

                bzImageInfoBean.setSyono(getProcessSummaryOutBean.getProcessSummaryBeanList().get(0).getExtparamBean()
                    .getExtparam12());

                bzImageInfoBean.setNksysyno(getProcessSummaryOutBean.getProcessSummaryBeanList().get(0)
                    .getExtparamBean().getExtparam13());
            }
            bzImageInfoBeanList.add(bzImageInfoBean);
        }

        bzGetImageOutputBean.setBzImageInfoBeanList(bzImageInfoBeanList);

        bzGetImageOutputBean.setSyoriKekkaStatus("0");

        logger.debug("△ 業務共通イメージ取得 終了");

        return bzGetImageOutputBean;
    }
}