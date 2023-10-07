package yuyu.app.sinkeiyaku.sknyuukin.skhenkin;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 返金入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkHenkinUiBean extends GenSkHenkinUiBean implements ViewSyoruiInfoItiranUiBeanParam,
SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private String[] hubimsgData;

    private List<String> gmWarningIdLst;

    private List<String> gmWarningLst;

    private C_Tuukasyu tuukaSyu;

    private String[] imageids;

    private String kouteiLockKey;

    private C_UmuKbn mainKouteiUmu;

    private C_UmuKbn henkinKouteiUmu;

    private C_UmuKbn henkinKouteiKaisiUmu;

    public SkHenkinUiBean() {
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        syoriCTL = pSyoriCTL;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public KinouMode getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(KinouMode pKinouMode) {
        kinouMode = pKinouMode;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public List<String> getGmWarningIdLst() {
        return gmWarningIdLst;
    }

    public void setGmWarningIdLst(List<String> pGmWarningIdLst) {
        gmWarningIdLst = pGmWarningIdLst;
    }

    public List<String> getGmWarningLst() {
        return gmWarningLst;
    }

    public void setGmWarningLst(List<String> pGmWarningLst) {
        gmWarningLst = pGmWarningLst;
    }

    public C_Tuukasyu getTuukaSyu() {
        return tuukaSyu;
    }

    public void setTuukaSyu(C_Tuukasyu pTuukaSyu) {
        tuukaSyu = pTuukaSyu;
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

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        kouteiLockKey = pKouteiLockKey;
    }

    public C_UmuKbn getMainKouteiUmu() {
        return mainKouteiUmu;
    }

    public void setMainKouteiUmu(C_UmuKbn pMainKouteiUmu) {
        this.mainKouteiUmu = pMainKouteiUmu;
    }

    public C_UmuKbn getHenkinKouteiUmu() {
        return henkinKouteiUmu;
    }

    public void setHenkinKouteiUmu(C_UmuKbn pHenkinKouteiUmu) {
        this.henkinKouteiUmu = pHenkinKouteiUmu;
    }

    public C_UmuKbn getHenkinKouteiKaisiUmu() {
        return henkinKouteiKaisiUmu;
    }

    public void setHenkinKouteiKaisiUmu(C_UmuKbn pHenkinKouteiKaisiUmu) {
        this.henkinKouteiKaisiUmu = pHenkinKouteiKaisiUmu;
    }
}
