package yuyu.common.biz.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_KouteiLockKekkaKbn;

/**
 * 業務共通 工程 業務共通工程ロック開始出力Bean
 */
public class BzLockProcessOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KouteiLockKekkaKbn kouteiLockKekkaKbn;

    private String kouteiLockKey;

    public C_KouteiLockKekkaKbn getKouteiLockKekkaKbn(){
        return kouteiLockKekkaKbn;
    }

    public void setKouteiLockKekkaKbn(C_KouteiLockKekkaKbn pKouteiLockKekkaKbn){
        kouteiLockKekkaKbn = pKouteiLockKekkaKbn;
    }

    public String getKouteiLockKey(){
        return kouteiLockKey;
    }

    public void setKouteiLockKey(String pKouteiLockKey){
        kouteiLockKey = pKouteiLockKey;
    }
}
