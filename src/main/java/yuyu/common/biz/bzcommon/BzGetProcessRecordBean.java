package yuyu.common.biz.bzcommon;

import java.io.Serializable;

import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 共通 業務共通工程履歴取得Bean
 */
public class BzGetProcessRecordBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriTime;

    private String kouteiKanriId;

    private String jimutetuzukicd;

    private String jimutetuzukinm;

    private String tasknmId;

    private String tasknm;

    private String userId;

    private C_IwfSyoriKbn iwfSyoriKbn;

    private C_RirekiKbn rirekiKbn;

    private String rirekiMessage;

    private C_SyorikekkaKbn syorikekkaKbn;

    public String getSyoriTime() {
        return syoriTime;
    }

    public void setSyoriTime(String pSyoriTime) {
        this.syoriTime = pSyoriTime;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        this.kouteiKanriId = pKouteiKanriId;
    }

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        this.jimutetuzukicd = pJimutetuzukicd;
    }

    public String getJimutetuzukinm() {
        return jimutetuzukinm;
    }

    public void setJimutetuzukinm(String pJimutetuzukinm) {
        this.jimutetuzukinm = pJimutetuzukinm;
    }

    public String getTasknmId() {
        return tasknmId;
    }

    public void setTasknmId(String pTasknmId) {
        this.tasknmId = pTasknmId;
    }

    public String getTasknm() {
        return tasknm;
    }

    public void setTasknm(String pTasknm) {
        this.tasknm = pTasknm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        this.userId = pUserId;
    }

    public C_IwfSyoriKbn getIwfSyoriKbn() {
        return iwfSyoriKbn;
    }

    public void setIwfSyoriKbn(C_IwfSyoriKbn pIwfSyoriKbn) {
        this.iwfSyoriKbn = pIwfSyoriKbn;
    }

    public C_RirekiKbn getRirekiKbn() {
        return rirekiKbn;
    }

    public void setRirekiKbn(C_RirekiKbn pRirekiKbn) {
        this.rirekiKbn = pRirekiKbn;
    }

    public String getRirekiMessage() {
        return rirekiMessage;
    }

    public void setRirekiMessage(String pRirekiMessage) {
        this.rirekiMessage = pRirekiMessage;
    }

    public C_SyorikekkaKbn getSyorikekkaKbn() {
        return syorikekkaKbn;
    }

    public void setSyorikekkaKbn(C_SyorikekkaKbn pSyorikekkaKbn) {
        this.syorikekkaKbn = pSyorikekkaKbn;
    }
}
