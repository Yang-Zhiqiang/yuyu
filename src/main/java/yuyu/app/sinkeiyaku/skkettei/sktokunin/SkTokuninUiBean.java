package yuyu.app.sinkeiyaku.skkettei.sktokunin;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 特認処理 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkTokuninUiBean extends GenSkTokuninUiBean {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn tokuninumukbn;

    private String[] hubimsgData;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    public SkTokuninUiBean() {
    }

    public C_UmuKbn getTokuninumukbn() {
        return tokuninumukbn;
    }

    public void setTokuninumukbn(C_UmuKbn pTokuninumukbn) {
        this.tokuninumukbn = pTokuninumukbn;
    }

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
        syoriCTL = pSyoriCTL;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo bzWorkflowInfo) {
        this.bzWorkflowInfo = bzWorkflowInfo;
    }
}
