package yuyu.common.biz.syoruiitiran;

import java.util.List;

import javax.inject.Inject;

import yuyu.common.biz.koutei.BzWorkflowInfo;

/**
 * 業務共通 書類情報一覧 書類情報一覧設定UiBean
 */
public class SetSyoruiInfoItiranExecUiBeanParamImpl implements SetSyoruiInfoItiranExecUiBeanParam{

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private String[] imageids;

    public List<SyoruiInfoItiranDataSourceBeanCommonParam> syoruiInfoItiranDataSourceBeanCommonParamLst ;

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoItiranDataSourceBeanCommonParamImpl();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(
        List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiranLst) {
        syoruiInfoItiranDataSourceBeanCommonParamLst = pSyoruiInfoItiranLst;
    }


    public void setBzWorkflowInfo(BzWorkflowInfo bzWorkflowInfo) {
        this.bzWorkflowInfo = bzWorkflowInfo;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] imageids) {
        this.imageids = imageids;
    }

    public List<SyoruiInfoItiranDataSourceBeanCommonParam> getSyoruiInfoItiranDataSourceBeanCommonParamLst() {
        return syoruiInfoItiranDataSourceBeanCommonParamLst;
    }

}
