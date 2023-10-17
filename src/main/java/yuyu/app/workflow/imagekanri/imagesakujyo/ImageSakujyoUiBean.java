package yuyu.app.workflow.imagekanri.imagesakujyo;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * イメージ削除 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class ImageSakujyoUiBean extends GenImageSakujyoUiBean {

    private static final long serialVersionUID = 1L;

    public ImageSakujyoUiBean() {
    }

    private String resultSubSystemId;

    public String getResultSubSystemId() {
        return resultSubSystemId;
    }

    public void setResultSubSystemId(String pSubSystemId) {
        this.resultSubSystemId = pSubSystemId;
    }

    private String kakuteiImageId;

    public String getKakuteiImageId() {
        return kakuteiImageId;
    }

    public void setKakuteiImageId(String pKakuteiImageId) {
        this.kakuteiImageId = pKakuteiImageId;
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

    private String gyoumukeylbl;

    public String getGyoumukeylbl() {
        return gyoumukeylbl;
    }

    public void setGyoumukeylbl(String pGyoumukeylbl) {
        gyoumukeylbl = pGyoumukeylbl;
    }

}
