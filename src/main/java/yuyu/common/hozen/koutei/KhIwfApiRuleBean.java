package yuyu.common.hozen.koutei;

import java.io.Serializable;

/**
 * 契約保全 工程 契約保全分岐条件Bean（IWFAPI用）
 */
public class KhIwfApiRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKekkaKbnNaiyou;

    private String sasimodosisakiKbnNaiyou;

    private String kyuukouzaAnnaiKbnNaiyou;

    private String authorijkKbnNaiyou;

    public KhIwfApiRuleBean() {
        super();
    }

    public String getSyoriKekkaKbnNaiyou(){
        return syoriKekkaKbnNaiyou;
    }

    public void setSyoriKekkaKbnNaiyou(String pSyoriKekkaKbnNaiyou){
        syoriKekkaKbnNaiyou = pSyoriKekkaKbnNaiyou;
    }

    public String getSasimodosisakiKbnNaiyou(){
        return sasimodosisakiKbnNaiyou;
    }

    public void setSasimodosisakiKbnNaiyou(String pSasimodosisakiKbnNaiyou){
        sasimodosisakiKbnNaiyou = pSasimodosisakiKbnNaiyou;
    }

    public String getKyuukouzaAnnaiKbnNaiyou(){
        return kyuukouzaAnnaiKbnNaiyou;
    }

    public void setKyuukouzaAnnaiKbnNaiyou(String pKyuukouzaAnnaiKbnNaiyou){
        kyuukouzaAnnaiKbnNaiyou = pKyuukouzaAnnaiKbnNaiyou;
    }

    public String getAuthorijkKbnNaiyou(){
        return authorijkKbnNaiyou;
    }

    public void setAuthorijkKbnNaiyou(String pAuthorijkKbnNaiyou){
        authorijkKbnNaiyou = pAuthorijkKbnNaiyou;
    }
}
