package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 共通 業務共通実行可能タスク情報取得Beanクラス
 */
public class BzGetExecutableTasksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subSystemId;

    private String subSystemNm;

    private String jimutetuzukiCd;

    private String jimutetuzukiNm;

    private String tskId;

    private String tskNm;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        this.subSystemId = pSubSystemId;
    }

    public String getSubSystemNm() {
        return subSystemNm;
    }

    public void setSubSystemNm(String pSubSystemNm) {
        this.subSystemNm = pSubSystemNm;
    }

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        this.jimutetuzukiCd = pJimutetuzukiCd;
    }

    public String getJimutetuzukiNm() {
        return jimutetuzukiNm;
    }

    public void setJimutetuzukiNm(String pJimutetuzukiNm) {
        this.jimutetuzukiNm = pJimutetuzukiNm;
    }

    public String getTskId() {
        return tskId;
    }

    public void setTskId(String pTskId) {
        this.tskId = pTskId;
    }

    public String getTskNm() {
        return tskNm;
    }

    public void setTskNm(String pTskNm) {
        this.tskNm = pTskNm;
    }
}