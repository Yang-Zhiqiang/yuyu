package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuriwake.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KykKbn;

/**
 * 振込入金データ振分の処理対象を保持するBeanクラス<br />
 */
public class SkMosInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String mosno;

    @Getter
    @Setter
    private C_KykKbn kykkbn;

    @Getter
    @Setter
    private String kyknmkn;

    @Getter
    @Setter
    private String hhknnmkn;

    @Getter
    @Setter
    private String oyadrtencd;

    public SkMosInfoBean(
        String pMosno,
        C_KykKbn pKykkbn,
        String pKyknmkn,
        String pHhknnmkn,
        String pOyadrtencd) {

        mosno = pMosno;
        kykkbn = pKykkbn;
        kyknmkn = pKyknmkn;
        hhknnmkn = pHhknnmkn;
        oyadrtencd = pOyadrtencd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
