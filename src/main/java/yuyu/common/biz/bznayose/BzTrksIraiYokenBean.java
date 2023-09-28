package yuyu.common.biz.bznayose;

import java.io.Serializable;

import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;

/**
 * 取消依頼与件Beanクラスです。<br />
 */
public class BzTrksIraiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String youkyuuno;

    private C_Huho2kyknoKbn huho2kyknokbn;

    private String huho2kykno;

    private C_KyknaiyouhaneiErrKbn kyknaiyouhaneierrkbn;

    public BzTrksIraiYokenBean() {
        super();
    }

    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    public C_KyknaiyouhaneiErrKbn getKyknaiyouhaneierrkbn() {
        return kyknaiyouhaneierrkbn;
    }

    public void setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn pKyknaiyouhaneierrkbn) {
        kyknaiyouhaneierrkbn = pKyknaiyouhaneierrkbn;
    }

}
