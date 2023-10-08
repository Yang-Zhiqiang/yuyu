package yuyu.app.workflow.processkanri.kouteitorikesi;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 工程取消 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KouteiTorikesiUiBean extends GenKouteiTorikesiUiBean {

    private static final long serialVersionUID = 1L;

    public KouteiTorikesiUiBean() {
    }

    private String resultSubSystemId;

    public String getResultSubSystemId() {
        return resultSubSystemId;
    }

    public void setResultSubSystemId(String pSubSystemId) {
        this.resultSubSystemId = pSubSystemId;
    }

    private String resultJimutetuduki;

    public String getResultJimutetuduki() {
        return resultJimutetuduki;
    }

    public void setResultJimutetuduki(String pJimutetuduki) {
        this.resultJimutetuduki = pJimutetuduki;
    }

    private String resultNksysyno;

    public String getResultNksysyno() {
        return resultNksysyno;
    }

    public void setResultNksysyno(String pResultNksysyno) {
        this.resultNksysyno = pResultNksysyno;
    }

    private String resultSyono;

    public String getResultSyono() {
        return resultSyono;
    }

    public void setResultSyono(String pResultSyono) {
        this.resultSyono = pResultSyono;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String pKouteiKnrId) {
        this.kouteiKnrId = pKouteiKnrId;
    }

    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }
}
