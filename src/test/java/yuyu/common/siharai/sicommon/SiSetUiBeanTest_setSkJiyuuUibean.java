package yuyu.common.siharai.sicommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceUiBeanParam;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;

import com.google.common.collect.Lists;

/**
 * 診断書情報設定（死亡）UiBeanParam(テスト用)
 */
public class SiSetUiBeanTest_setSkJiyuuUibean implements ViewSindansyoinfoSibouUiBeanParam,
ViewSindansyoInfo2DataSourceUiBeanParam {

    private C_GeninKbn geninkbn;

    private BizDate sibouymd;

    private C_SibouBasyoKbn siboubasyokbn;

    private String siboubasyo;

    private List<ViewSindansyoInfo2DataSourceBeanCommonParamImpl> viewSindansyoInfo2DataSourceBeanCommonParamImpl;

    public List<ViewSindansyoInfo2DataSourceBeanCommonParamImpl> getViewSindansyoInfo2DataSourceBeanCommonParamImpl() {
        return viewSindansyoInfo2DataSourceBeanCommonParamImpl;
    }

    @Override
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    @Override
    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @Override
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Override
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    @Override
    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    @Override
    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    @Override
    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Override
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }

    @Override
    public ViewSindansyoInfo2DataSourceBeanCommonParam createSindansyoInfo2DataSourceBean() {
        return new ViewSindansyoInfo2DataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertSindansyoInfo2ForCommonParam(List<ViewSindansyoInfo2DataSourceBeanCommonParam> pSindansyoInfo) {

        viewSindansyoInfo2DataSourceBeanCommonParamImpl = Lists.newArrayList();

        for (ViewSindansyoInfo2DataSourceBeanCommonParam beanCommonParam : pSindansyoInfo) {

            ViewSindansyoInfo2DataSourceBeanCommonParamImpl bataSourceBean = (ViewSindansyoInfo2DataSourceBeanCommonParamImpl) beanCommonParam;

            viewSindansyoInfo2DataSourceBeanCommonParamImpl.add(bataSourceBean);
        }

    }

    @Override
    public DataSource<?> getViewSindansyoinfoSibouInfo1DataSource() {
        return null;
    }

    @Override
    public boolean isViewSindansyoinfoSibouInputDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSindansyoinfoSibouSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSindansyoinfoSibouDispFlg() {
        return false;
    }

}
