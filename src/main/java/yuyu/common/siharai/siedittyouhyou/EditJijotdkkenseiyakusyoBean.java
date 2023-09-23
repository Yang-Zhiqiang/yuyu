package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 事情届兼誓約書Bean
 */
public class EditJijotdkkenseiyakusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String syono;

    private String hknknukt;

    private String drsk;

    public EditJijotdkkenseiyakusyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    public String getHknknukt() {
        return hknknukt;
    }

    public void setHknknukt(String pHknknukt) {
        hknknukt = pHknknukt;
    }

    public String getDrsk() {
        return drsk;
    }

    public void setDrsk(String pDrsk) {
        drsk = pDrsk;
    }
}
