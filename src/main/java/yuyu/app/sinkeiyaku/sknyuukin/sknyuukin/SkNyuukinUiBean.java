package yuyu.app.sinkeiyaku.sknyuukin.sknyuukin;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.def.classification.C_JgyiktKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 入金入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkNyuukinUiBean extends GenSkNyuukinUiBean {

    private static final long serialVersionUID = 1L;

    private String rssyouNo;

    private C_JgyiktKbn jgyiktKbn;

    private String soukinCd;

    private BizDate soukinYmd;

    private String[] hubiMsgDatas;

    private String warnmessage;

    private String kakuninmessage;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    public SkNyuukinUiBean() {

    }

    public String getRssyouNo() {
        return rssyouNo;
    }

    public void setRssyouNo(String pRssyouNo) {
        this.rssyouNo = pRssyouNo;
    }

    public C_JgyiktKbn getJgyiktKbn() {
        return jgyiktKbn;
    }
    public void setJgyiktKbn(C_JgyiktKbn pJgyiktKbn) {
        this.jgyiktKbn = pJgyiktKbn;
    }

    public void setSoukinCd(String pSoukinCd) {
        this.soukinCd = pSoukinCd;
    }

    public String getSoukinCd() {
        return soukinCd;
    }

    public void setSoukinYmd(BizDate pSoukinYmd) {
        this.soukinYmd = pSoukinYmd;
    }

    public BizDate getSoukinYmd() {
        return soukinYmd;
    }

    public String[] getHubiMsgDatas() {
        return hubiMsgDatas;
    }

    public void setHubiMsgDatas(String[] pHubiMsgDatas) {
        this.hubiMsgDatas = pHubiMsgDatas;
    }

    public String getWarnmessage() {
        return warnmessage;
    }

    public void setWarnmessage(String pWarnmessage) {
        warnmessage = pWarnmessage;
    }

    public String getKakuninmessage() {
        return kakuninmessage;
    }

    public void setKakuninmessage(String pKakuninmessage) {
        kakuninmessage = pKakuninmessage;
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
}
