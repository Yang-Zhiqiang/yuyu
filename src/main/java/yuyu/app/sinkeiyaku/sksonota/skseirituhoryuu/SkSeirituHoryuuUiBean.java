package yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 成立保留処理 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkSeirituHoryuuUiBean extends GenSkSeirituHoryuuUiBean {

    private static final long serialVersionUID = 1L;


    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private C_JimusrhKbn initjimusrhkbn ;

    private String[] hubimsgData;

    private String gmMsg;

    private String gmMsgid;

    public SkSeirituHoryuuUiBean() {
    }

    public C_JimusrhKbn getInitjimusrhkbn() {
        return initjimusrhkbn;
    }

    public void setInitjimusrhkbn(C_JimusrhKbn pInitjimusrhkbn) {
        this.initjimusrhkbn = pInitjimusrhkbn;
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

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }
}
