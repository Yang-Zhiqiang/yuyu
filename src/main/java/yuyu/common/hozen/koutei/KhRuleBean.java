package yuyu.common.hozen.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 契約保全 工程 契約保全分岐条件Bean
 */
public class KhRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyorikekkaKbn syoriKekkaKbn;

    private C_SasimodosisakiKbn sasimodosisakiKbn;

    private String saiwariateUserId;

    private C_KyuukouzaAnnaiKbn kyuukouzaAnnaiKbn;

    private C_AuthorijkKbn authorijkKbn;

    public KhRuleBean() {
        super();
        init();
    }

    public C_SyorikekkaKbn getSyoriKekkaKbn(){
        return syoriKekkaKbn;
    }

    public void setSyoriKekkaKbn(C_SyorikekkaKbn pSyoriKekkaKbn){
        syoriKekkaKbn = pSyoriKekkaKbn;
    }

    public C_SasimodosisakiKbn getSasimodosisakiKbn(){
        return sasimodosisakiKbn;
    }

    public void setSasimodosisakiKbn(C_SasimodosisakiKbn pSasimodosisakiKbn){
        sasimodosisakiKbn = pSasimodosisakiKbn;
    }

    public String getSaiwariateUserId(){
        return saiwariateUserId;
    }

    public void setSaiwariateUserId(String pSaiwariateUserId){
        saiwariateUserId = pSaiwariateUserId;
    }

    public C_KyuukouzaAnnaiKbn getKyuukouzaAnnaiKbn(){
        return kyuukouzaAnnaiKbn;
    }

    public void setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn pKyuukouzaAnnaiKbn){
        kyuukouzaAnnaiKbn = pKyuukouzaAnnaiKbn;
    }

    public C_AuthorijkKbn getAuthorijkKbn(){
        return authorijkKbn;
    }

    public void setAuthorijkKbn(C_AuthorijkKbn pAuthorijkKbn){
        authorijkKbn = pAuthorijkKbn;
    }
    public void init() {
        syoriKekkaKbn = C_SyorikekkaKbn.BLNK;
        sasimodosisakiKbn = C_SasimodosisakiKbn.BLNK;
        saiwariateUserId = "";
        kyuukouzaAnnaiKbn = C_KyuukouzaAnnaiKbn.BLNK;
        authorijkKbn = C_AuthorijkKbn.HUYOU;
    }
}
