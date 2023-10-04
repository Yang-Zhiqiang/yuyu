package yuyu.batch.siharai.sisatei.sihigaitouichiransakusei;

import java.io.Serializable;

/**
 * 非該当一覧抽出処理結果Beanクラスです。<br />
 */
public class SiHigaitouIchiranTyuusyutuSyoriKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skNo;

    private String syoNo;

    public SiHigaitouIchiranTyuusyutuSyoriKekkaBean() {
        super();
    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

}
