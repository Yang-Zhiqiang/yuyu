package yuyu.common.biz.workflow.io.image;

import java.util.List;

import yuyu.common.biz.workflow.io.image.sub.ArrivalNoticeBean;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getExpectedArrivalNotice.WSGetExpectedArrivalNoticeResponse;

/**
 * 到着予定通知取得サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetExpectedArrivalNoticeOutBean extends WSGetExpectedArrivalNoticeResponse {

    private List<ArrivalNoticeBean> oNoticeBeanList;

    public List<ArrivalNoticeBean> getNoticeBeanList() {
        return oNoticeBeanList;
    }

    public void setNoticeBeanList(List<ArrivalNoticeBean> poNoticeBeanList) {
        oNoticeBeanList = poNoticeBeanList;
    }
}
