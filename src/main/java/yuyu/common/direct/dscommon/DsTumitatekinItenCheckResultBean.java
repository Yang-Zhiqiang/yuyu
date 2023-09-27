package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ積立金移転共通チェック結果Beanクラス
 */
public class DsTumitatekinItenCheckResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_DsTmttknitenchkkekkaKbn dsTmttknitenchkkekkaKbn;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public C_DsTmttknitenchkkekkaKbn getDsTmttknitenchkkekkaKbn() {
        return dsTmttknitenchkkekkaKbn;
    }

    public void setDsTmttknitenchkkekkaKbn(C_DsTmttknitenchkkekkaKbn pDsTmttknitenchkkekkaKbn) {
        dsTmttknitenchkkekkaKbn = pDsTmttknitenchkkekkaKbn;
    }
}
