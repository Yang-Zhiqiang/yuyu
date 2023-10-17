package yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 当日ＦＢ返金取消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkToujituFbHenkinTorikesiUiBean extends GenSkToujituFbHenkinTorikesiUiBean {

    private static final long serialVersionUID = 1L;

    private String hnknInputRenNo;

    private String gmMsgId;

    private String gmMsg;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    public SkToujituFbHenkinTorikesiUiBean() {
    }

    public String getHnknInputRenNo() {
        return hnknInputRenNo;
    }

    public void setHnknInputRenNo(String pHnknInputRenNo) {
        hnknInputRenNo = pHnknInputRenNo;
    }

    public String getGmMsgId() {
        return gmMsgId;
    }

    public void setGmMsgId(String pGmMsgId) {
        gmMsgId = pGmMsgId;
    }

    public String getGmMsg() {
        return gmMsg;
    }

    public void setGmMsg(String pGmMsg) {
        gmMsg = pGmMsg;
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
        skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }
}
