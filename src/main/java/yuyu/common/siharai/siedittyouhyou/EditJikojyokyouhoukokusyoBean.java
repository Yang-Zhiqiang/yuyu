package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 事故状況報告書Bean
 */
public class EditJikojyokyouhoukokusyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean SiTyouhyouHensyuuCommonBean;

    public EditJikojyokyouhoukokusyoBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return SiTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        SiTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

}
