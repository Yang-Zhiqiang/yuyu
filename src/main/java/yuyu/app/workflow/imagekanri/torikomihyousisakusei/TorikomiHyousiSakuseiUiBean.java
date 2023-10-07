package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

import java.util.HashMap;
import java.util.Map;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 取込用表紙作成 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class TorikomiHyousiSakuseiUiBean extends GenTorikomiHyousiSakuseiUiBean {

    private static final long serialVersionUID = 1L;

    public TorikomiHyousiSakuseiUiBean() {
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        this.userId = pUserId;
    }

    private String resultSubSystemId;

    public String getResultSubSystemId() {
        return resultSubSystemId;
    }

    public void setResultSubSystemId(String pSubSystemId) {
        this.resultSubSystemId = pSubSystemId;
    }

    private String resultJimutetuzuki;

    public String getResultJimutetuzuki() {
        return resultJimutetuzuki;
    }

    public void setResultJimutetuzuki(String pJimutetuzuki) {
        this.resultJimutetuzuki = pJimutetuzuki;
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

    private Map<String, Object> jimutetuzukiMap = new HashMap<String, Object>();

    public Map<String, Object> getJimutetuzukiMap() {
        return jimutetuzukiMap;
    }

    public void setJimutetuzukiMap(Map<String, Object> pJimutetuzukiMap) {
        this.jimutetuzukiMap = pJimutetuzukiMap;
    }

    private Map<String, Object> torikomiSyoruiMap = new HashMap<String, Object>();

    public Map<String, Object> getTorikomiSyoruiMap() {
        return torikomiSyoruiMap;
    }

    public void setTorikomiSyoruiMap(Map<String, Object> pTorikomiSyoruiMap) {
        this.torikomiSyoruiMap = pTorikomiSyoruiMap;
    }

    private String kouteiKnrId;

    public String getKouteiKnrId() {
        return kouteiKnrId;
    }

    public void setKouteiKnrId(String kouteiKnrId) {
        this.kouteiKnrId = kouteiKnrId;
    }

    private String reportKey;

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

}
