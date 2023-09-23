package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書の送付案内編集Bean
 */
public class EditHubiteiseisyosouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private ToiawaseInfoBean toiawaseInfoBean;

    private String syono;

    private String hhknnmkj;

    private String renrakuarea;

    public EditHubiteiseisyosouhuannaiBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public SeikyuusyaInfoBean getSeikyuusyaInfoBean() {
        return seikyuusyaInfoBean;
    }

    public void setSeikyuusyaInfoBean(SeikyuusyaInfoBean pSeikyuusyaInfoBean) {
        seikyuusyaInfoBean = pSeikyuusyaInfoBean;
    }

    public ToiawaseInfoBean getToiawaseInfoBean() {
        return toiawaseInfoBean;
    }

    public void setToiawaseInfoBean(ToiawaseInfoBean pToiawaseInfoBean) {
        toiawaseInfoBean = pToiawaseInfoBean;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    public String getRenrakuarea() {
        return renrakuarea;
    }

    public void setRenrakuarea(String pRenrakuarea) {
        renrakuarea = pRenrakuarea;
    }
}
