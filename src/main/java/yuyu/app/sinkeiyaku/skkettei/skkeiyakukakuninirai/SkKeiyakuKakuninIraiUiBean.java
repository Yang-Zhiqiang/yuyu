package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninirai;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 契約確認依頼入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkKeiyakuKakuninIraiUiBean extends GenSkKeiyakuKakuninIraiUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private String[] hubimsgData;

    private String gmMsg;

    private String gmMsgid;

    public SkKeiyakuKakuninIraiUiBean() {
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

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    public String getGmMsg() {
        return gmMsg;
    }

    public void setGmMsg(String pGmMsg) {
        this.gmMsg = pGmMsg;
    }

    public String getGmMsgid() {
        return gmMsgid;
    }

    public void setGmMsgid(String pGmMsgid) {
        this.gmMsgid = pGmMsgid;
    }

    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo bzWorkflowInfo) {
        this.bzWorkflowInfo = bzWorkflowInfo;
    }
}
