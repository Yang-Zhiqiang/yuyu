package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 新契約 工程 新契約工程遷移入力Bean
 */
public class SkProcessForwardInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    private String tskNm;

    private String kouteiLockkey;

    private C_SyorikekkaKbn syorikekkaKbn;

    private String syoriComment;

    private C_SyorikekkaKbn mostenkenkekkaKbn;

    private String mostenkentnsketsyaCd;

    private C_SyorikekkaKbn knksateikekkaKbn;

    private String knktnsketsyaCd;

    private C_SyorikekkaKbn imusateikekkaKbn;

    private String imutnsketsyaCd;

    private C_HubihassintnsKbn hubihassintnsKbn;

    private C_YouhiKbn hnkninputTorikesiyhKbn;

    private C_YouhiKbn moscheckrirekiyhKbn;

    public SkProcessForwardInBean() {
        super();

        mosNo = "";
        tskNm = "";
        kouteiLockkey = "";
        syorikekkaKbn = C_SyorikekkaKbn.BLNK;
        syoriComment = "";
        mostenkenkekkaKbn = C_SyorikekkaKbn.BLNK;
        mostenkentnsketsyaCd = "";
        knksateikekkaKbn = C_SyorikekkaKbn.BLNK;
        knktnsketsyaCd = "";
        imusateikekkaKbn = C_SyorikekkaKbn.BLNK;
        imutnsketsyaCd = "";
        hubihassintnsKbn = C_HubihassintnsKbn.BLNK;
        hnkninputTorikesiyhKbn = C_YouhiKbn.HUYOU;
        moscheckrirekiyhKbn = C_YouhiKbn.HUYOU;
    }

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    public String getTskNm() {
        return tskNm;
    }

    public void setTskNm(String pTskNm) {
        tskNm = pTskNm;
    }

    public String getKouteiLockkey() {
        return kouteiLockkey;
    }

    public void setKouteiLockkey(String pKouteiLockkey) {
        kouteiLockkey = pKouteiLockkey;
    }

    public C_SyorikekkaKbn getSyorikekkaKbn() {
        return syorikekkaKbn;
    }

    public void setSyorikekkaKbn(C_SyorikekkaKbn pSyorikekkaKbn) {
        syorikekkaKbn = pSyorikekkaKbn;
    }

    public String getSyoriComment() {
        return syoriComment;
    }

    public void setSyoriComment(String pSyoriComment) {
        syoriComment = pSyoriComment;
    }

    public C_SyorikekkaKbn getMostenkenkekkaKbn() {
        return mostenkenkekkaKbn;
    }

    public void setMostenkenkekkaKbn(C_SyorikekkaKbn pMostenkenkekkaKbn) {
        mostenkenkekkaKbn = pMostenkenkekkaKbn;
    }

    public String getMostenkentnsketsyaCd() {
        return mostenkentnsketsyaCd;
    }

    public void setMostenkentnsketsyaCd(String pMostenkentnsketsyaCd) {
        mostenkentnsketsyaCd = pMostenkentnsketsyaCd;
    }

    public C_SyorikekkaKbn getKnksateikekkaKbn() {
        return knksateikekkaKbn;
    }

    public void setKnksateikekkaKbn(C_SyorikekkaKbn pKnksateikekkaKbn) {
        knksateikekkaKbn = pKnksateikekkaKbn;
    }

    public String getKnktnsketsyaCd() {
        return knktnsketsyaCd;
    }

    public void setKnktnsketsyaCd(String pKnktnsketsyaCd) {
        knktnsketsyaCd = pKnktnsketsyaCd;
    }

    public C_SyorikekkaKbn getImusateikekkaKbn() {
        return imusateikekkaKbn;
    }

    public void setImusateikekkaKbn(C_SyorikekkaKbn pImusateikekkaKbn) {
        imusateikekkaKbn = pImusateikekkaKbn;
    }

    public String getImutnsketsyaCd() {
        return imutnsketsyaCd;
    }

    public void setImutnsketsyaCd(String pImutnsketsyaCd) {
        imutnsketsyaCd = pImutnsketsyaCd;
    }

    public C_HubihassintnsKbn getHubihassintnsKbn() {
        return hubihassintnsKbn;
    }

    public void setHubihassintnsKbn(C_HubihassintnsKbn pHubihassintnsKbn) {
        hubihassintnsKbn = pHubihassintnsKbn;
    }

    public C_YouhiKbn getHnkninputTorikesiyhKbn() {
        return hnkninputTorikesiyhKbn;
    }

    public void setHnkninputTorikesiyhKbn(C_YouhiKbn pHnkninputTorikesiyhKbn) {
        hnkninputTorikesiyhKbn = pHnkninputTorikesiyhKbn;
    }

    public C_YouhiKbn getMoscheckrirekiyhKbn() {
        return moscheckrirekiyhKbn;
    }

    public void setMoscheckrirekiyhKbn(C_YouhiKbn pMoscheckrirekiyhKbn) {
        moscheckrirekiyhKbn = pMoscheckrirekiyhKbn;
    }
}
