package yuyu.common.biz.syoruiitiran;

import java.util.List;

import yuyu.common.biz.koutei.BzWorkflowInfo;

/**
 * 業務共通 書類情報一覧 書類情報一覧設定UiBeanパラメータ
 */

public interface SetSyoruiInfoItiranExecUiBeanParam {
    SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean();

    void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran);

    String[] getImageids();

    void setImageids(String[] pImageids);

    BzWorkflowInfo getBzWorkflowInfo();
}
