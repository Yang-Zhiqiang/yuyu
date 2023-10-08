package yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg;

import java.io.Serializable;
import java.util.List;

/**
 * 不備メッセージ 機能間遷移用Beanクラスです。<br />
 */
public class SkHubiMsgRenkeiInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String mosno;

    private String hhknnmkj;

    private List<String> hubimsgData;

    public SkHubiMsgRenkeiInfo() {
    }

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    public void setHhknnmkj(String pHhknnmk) {
        hhknnmkj = pHhknnmk;
    }

    public List<String> getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(List<String> pHubimsgData) {
        hubimsgData = pHubimsgData;
    }
}
