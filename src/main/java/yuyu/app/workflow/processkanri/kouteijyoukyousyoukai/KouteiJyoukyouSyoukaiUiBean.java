package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 工程状況照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KouteiJyoukyouSyoukaiUiBean extends GenKouteiJyoukyouSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public KouteiJyoukyouSyoukaiUiBean() {
    }


    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }

    private String savesubsystemid;

    public String getSavesubsystemid() {
        return savesubsystemid;
    }

    public void setSavesubsystemid(String pSaveSubSystemId) {
        savesubsystemid = pSaveSubSystemId;
    }

    private String resultSyono;

    public String getResultSyono() {
        return resultSyono;
    }

    public void setResultSyono(String pResultSyono) {
        this.resultSyono = pResultSyono;
    }

    private String resultNksysyno;

    public String getResultNksysyno() {
        return resultNksysyno;
    }

    public void setResultNksysyno(String pResultNksysyno) {
        this.resultNksysyno = pResultNksysyno;
    }


    private String resultmosno;

    public String getResultMosno() {
        return resultmosno;
    }

    public void setResultMosno(String pResultMosno) {
        this.resultmosno = pResultMosno;
    }
}
