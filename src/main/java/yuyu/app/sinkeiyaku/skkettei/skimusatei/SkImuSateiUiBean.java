package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 医務査定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkImuSateiUiBean extends GenSkImuSateiUiBean implements ViewSyoruiInfoItiranUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    public SkImuSateiUiBean() {
    }

    private String[] hubimsgData;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    private String[] imageids;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public List<String> getGmwarningIdLst() {
        return gmwarningIdLst;
    }

    public void setGmwarningIdLst(List<String> pGmwarningIdLst) {
        gmwarningIdLst = pGmwarningIdLst;
    }

    public List<String> getGmwarningLst() {
        return gmwarningLst;
    }

    public void setGmwarningLst(List<String> pGmwarningLst) {
        gmwarningLst = pGmwarningLst;
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        this.syoriCTL = pSyoriCTL;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo bzWorkflowInfo) {
        this.bzWorkflowInfo = bzWorkflowInfo;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo () {
        return bzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    @Override
    public void setHubihassintns(Boolean b){
        super.setHubihassintns(b);
        C_HubihassintnsKbn kbn = b ? C_HubihassintnsKbn.ARI : C_HubihassintnsKbn.BLNK;
        super.setHubihassintnskbn(kbn);
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {

        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean)beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);
    }
}
