package yuyu.common.siharai.sicommon;

import java.util.List;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiByoumeiParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 病名Paramインターフェース実現クラス（テスト用）
 */
public class SiByoumeiParamImplTest implements SiByoumeiParam ,EditSkTblParam {

    private List<ViewSindansyoInfo2DataSourceBeanCommonParam> viewSindansyoInfo2Lst;

    public void setViewSindansyoInfo2Lst(List<ViewSindansyoInfo2DataSourceBeanCommonParam> pViewSindansyoInfo2Lst) {
        this.viewSindansyoInfo2Lst = pViewSindansyoInfo2Lst;
    }

    @Override
    public List<ViewSindansyoInfo2DataSourceBeanCommonParam> convertCommonParamForSindansyoInfo2(){
        return viewSindansyoInfo2Lst;
    }

}
