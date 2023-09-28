package yuyu.common.biz.koutei;

import java.io.Serializable;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * 業務共通 工程 工程ロック共通Bean
 */
@ConversationScoped
public class BzCommonLockProcessBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kouteiLockKey = "";

    private String lockTsyuKouteiKanriId = "";

    private String lockTsyuJimuTetuzukiCd = "";

    public BzCommonLockProcessBean() {
        super();
    }

    public String getKouteiLockKey() {
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey) {
        this.kouteiLockKey = pKouteiLockKey;
    }

    public String getLockTsyuKouteiKanriId() {
        return lockTsyuKouteiKanriId;
    }

    public void setLockTsyuKouteiKanriId(String pLockTsyuKouteiKanriId) {
        this.lockTsyuKouteiKanriId = pLockTsyuKouteiKanriId;
    }

    public String getLockTsyuJimuTetuzukiCd() {
        return lockTsyuJimuTetuzukiCd;
    }

    public void setLockTsyuJimuTetuzukiCd(String pLockTsyuJimuTetuzukiCd) {
        this.lockTsyuJimuTetuzukiCd = pLockTsyuJimuTetuzukiCd;
    }

}
