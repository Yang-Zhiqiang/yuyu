package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 指定代理請求届編集Bean
 */
public class EditSiteidairiseikyuutodokeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String syoNo;

    private String hihuokennshaNm;

    public EditSiteidairiseikyuutodokeBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyono(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getHihuokennshaNm() {
        return hihuokennshaNm;
    }

    public void setHihuokennshaNm(String pHihuokennshaNm) {
        hihuokennshaNm = pHihuokennshaNm;
    }
}
