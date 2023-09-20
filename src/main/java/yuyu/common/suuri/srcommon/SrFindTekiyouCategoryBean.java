package yuyu.common.suuri.srcommon;

import java.io.Serializable;

/**
 *  摘要項目取得Beanクラス
 */
public class SrFindTekiyouCategoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tekiyoucd;

    private String tekiyounm;

    SrFindTekiyouCategoryBean() {
        tekiyoucd = "";
        tekiyounm = "";
    }

    public String getTekiyoucd() {
        return tekiyoucd;
    }

    public void setTekiyoucd(String pTekiyoucd) {
        tekiyoucd = pTekiyoucd;
    }

    public String getTekiyounm() {
        return tekiyounm;
    }

    public void setTekiyounm(String pTekiyounm) {
        tekiyounm = pTekiyounm;
    }

}
