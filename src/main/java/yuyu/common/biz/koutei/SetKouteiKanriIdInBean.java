package yuyu.common.biz.koutei;

import java.io.Serializable;

/**
 * 業務共通 工程 工程管理ＩＤ設定入力Bean
 */
public class SetKouteiKanriIdInBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subSystemId;

    private String jimutetuzukiCd;

    private String mosNo;

    private String syoNo;

    private String skNo;

    private String nkSysyNo;

    private String oyaKouteiKanriId;

    private String oyaKouteiJimutetuzukiCd;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    public String getJimutetuzukiCd() {
        return jimutetuzukiCd;
    }

    public void setJimutetuzukiCd(String pJimutetuzukiCd) {
        jimutetuzukiCd = pJimutetuzukiCd;
    }

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        mosNo = pMosNo;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
    }

    public String getNkSysyNo() {
        return nkSysyNo;
    }

    public void setNkSysyNo(String pNkSysyNo) {
        nkSysyNo = pNkSysyNo;
    }

    public String getOyaKouteiKanriId() {
        return oyaKouteiKanriId;
    }

    public void setOyaKouteiKanriId(String pOyaKouteiKanriId) {
        oyaKouteiKanriId = pOyaKouteiKanriId;
    }

    public String getOyaKouteiJimutetuzukiCd() {
        return oyaKouteiJimutetuzukiCd;
    }

    public void setOyaKouteiJimutetuzukiCd(String pOyaKouteiJimutetuzukiCd) {
        oyaKouteiJimutetuzukiCd = pOyaKouteiJimutetuzukiCd;
    }
}
