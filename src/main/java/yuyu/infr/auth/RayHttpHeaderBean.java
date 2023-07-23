package yuyu.infr.auth;

import java.io.Serializable;

import com.google.inject.servlet.SessionScoped;

/**
 * S社で認証情報として使用する端末設置組織コード・名を保持するクラスです。
 */
@SessionScoped
public class RayHttpHeaderBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String tmSosikiCd;

    private String tmSosikiNm;

    private String ssoId;

    private String idKind;

    private String personCd;

    private String issueNum;

    private String pcCd;

    private String ipAddress;

    private String machineKind;

    private String nodeNum;


    public String getSsoId() {
        return ssoId;
    }

    void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getTmSosikiCd() {
        return tmSosikiCd;
    }

    void setTmSosikiCd(String tmSosikiCd) {
        this.tmSosikiCd = tmSosikiCd;
    }

    public String getTmSosikiNm() {
        return tmSosikiNm;
    }

    void setTmSosikiNm(String tmSosikiNm) {
        this.tmSosikiNm = tmSosikiNm;
    }

    public String getIdKind() {
        return idKind;
    }

    void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getPersonCd() {
        return personCd;
    }

    void setPersonCd(String personCd) {
        this.personCd = personCd;
    }

    public String getIssueNum() {
        return issueNum;
    }

    void setIssueNum(String issueNum) {
        this.issueNum = issueNum;
    }

    public String getPcCd() {
        return pcCd;
    }

    void setPcCd(String pcCd) {
        this.pcCd = pcCd;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMachineKind() {
        return machineKind;
    }

    void setMachineKind(String machineKind) {
        this.machineKind = machineKind;
    }

    public String getNodeNum() {
        return nodeNum;
    }

    void setNodeNum(String nodeNum) {
        this.nodeNum = nodeNum;
    }

}
