package yuyu.common.biz.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 進捗履歴情報取得出力Bean
 */
public class GetProgressHistoryOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }

    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String pTaskName) {
        taskName = pTaskName;
    }

    private C_SyorikekkaKbn syorikekkaKbn;

    public C_SyorikekkaKbn getSyorikekkaKbn() {
        return syorikekkaKbn;
    }

    public void setSyorikekkaKbn(C_SyorikekkaKbn pSyorikekkaKbn) {
        syorikekkaKbn = pSyorikekkaKbn;
    }

    private String tantousyaName;

    public String getTantousyaName() {
        return tantousyaName;
    }

    public void setTantousyaName(String pTantousyaName) {
        tantousyaName = pTantousyaName;
    }

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String pComment) {
        comment = pComment;
    }
}
