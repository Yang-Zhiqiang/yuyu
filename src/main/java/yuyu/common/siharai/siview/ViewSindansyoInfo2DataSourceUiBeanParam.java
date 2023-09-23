package yuyu.common.siharai.siview;

import java.util.List;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求病名UiBeanパラメータ（明細）
 */
public interface ViewSindansyoInfo2DataSourceUiBeanParam {

    public ViewSindansyoInfo2DataSourceBeanCommonParam createSindansyoInfo2DataSourceBean();

    public void convertSindansyoInfo2ForCommonParam(List<ViewSindansyoInfo2DataSourceBeanCommonParam> pSindansyoInfo);

}
