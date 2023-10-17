package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 当日入金取消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkToujituNyuukinTorikesiUiBean extends GenSkToujituNyuukinTorikesiUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private Integer sentakuRenno;

    private String sentakuDenrenno;

    private String[] hubiMsgDatas;

    public SkToujituNyuukinTorikesiUiBean() {
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

    public Integer getSentakuRenno() {
        return sentakuRenno;
    }

    public void setSentakuRenno(Integer pSentakuRenno) {
        this.sentakuRenno = pSentakuRenno;
    }

    public String getSentakuDenrenno() {
        return sentakuDenrenno;
    }

    public void setSentakuDenrenno(String pSentakuDenrenno) {
        this.sentakuDenrenno = pSentakuDenrenno;
    }

    public String[] getHubiMsgDatas() {
        return hubiMsgDatas;
    }

    public void setHubiMsgDatas(String[] pHubiMsgDatas) {
        this.hubiMsgDatas = pHubiMsgDatas;
    }
}
