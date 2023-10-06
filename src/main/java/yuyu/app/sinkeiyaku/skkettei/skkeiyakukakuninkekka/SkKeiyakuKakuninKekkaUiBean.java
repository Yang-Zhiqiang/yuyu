package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 契約確認結果入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkKeiyakuKakuninKekkaUiBean extends GenSkKeiyakuKakuninKekkaUiBean implements SetSyoruiInfoItiranExecUiBeanParam,
SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    private String[] hubimsgData;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    private String[] imageids;

    public SkKeiyakuKakuninKekkaUiBean() {
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        this.syoriCTL = pSyoriCTL;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
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

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean)beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);

    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }
}
