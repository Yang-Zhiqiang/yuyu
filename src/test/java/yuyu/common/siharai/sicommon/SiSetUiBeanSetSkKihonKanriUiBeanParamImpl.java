package yuyu.common.siharai.sicommon;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.siharai.siview.SiSetUiBeanSetSkKihonKanriUiBeanParam;
import yuyu.common.siharai.siview.SkKihonKanriInfoDataSourceBeanCommonParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ実現クラス(同時請求契約情報設定)
 */
public class SiSetUiBeanSetSkKihonKanriUiBeanParamImpl implements SiSetUiBeanSetSkKihonKanriUiBeanParam{

    List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> skKihonKanriInfo;

    @Override
    public SkKihonKanriInfoDataSourceBeanCommonParamImpl createSkKihonKanriInfoDataSourceBean() {
        return new SkKihonKanriInfoDataSourceBeanCommonParamImpl();

    }

    public List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> getSkKihonKanriInfo() {
        return skKihonKanriInfo;
    }

    @Override public void convertSkKihonKanriInfoForCommonParam(List<SkKihonKanriInfoDataSourceBeanCommonParam> pSkKihonKanriInfo) {
        List<SkKihonKanriInfoDataSourceBeanCommonParamImpl> bSBCParamLst = new ArrayList<>();
        for (SkKihonKanriInfoDataSourceBeanCommonParam beanCommonParam : pSkKihonKanriInfo) {
            bSBCParamLst.add((SkKihonKanriInfoDataSourceBeanCommonParamImpl)beanCommonParam);
        }

        skKihonKanriInfo = bSBCParamLst;
    }
}
