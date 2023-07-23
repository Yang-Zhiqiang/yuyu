package yuyu.infr.auth;

import java.io.Serializable;

import com.google.inject.servlet.RequestScoped;

/**
 * BCP時の組織代行情報を保持するBeanです。
 */
@RequestScoped
public class RayBCPBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean bcp;

    private String daikouSosikiCd;

    public boolean isBcp() {
        return bcp;
    }

    public void setBcp(boolean bcp) {
        this.bcp = bcp;
    }

    public String getDaikouSosikiCd() {
        return daikouSosikiCd;
    }

    public void setDaikouSosikiCd(String daikouSosikiCd) {
        this.daikouSosikiCd = daikouSosikiCd;
    }
}
