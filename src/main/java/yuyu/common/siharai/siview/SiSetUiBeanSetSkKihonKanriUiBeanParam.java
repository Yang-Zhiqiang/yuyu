package yuyu.common.siharai.siview;

import java.util.List;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(同時請求契約情報設定)
 */
public interface SiSetUiBeanSetSkKihonKanriUiBeanParam {

    SkKihonKanriInfoDataSourceBeanCommonParam createSkKihonKanriInfoDataSourceBean();

    void convertSkKihonKanriInfoForCommonParam(List<SkKihonKanriInfoDataSourceBeanCommonParam> pSkKihonKanriInfo);

}
