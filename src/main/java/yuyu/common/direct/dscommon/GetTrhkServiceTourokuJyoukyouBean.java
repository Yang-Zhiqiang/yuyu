package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 取引サービス登録状況取得Beanクラス
 */
public class GetTrhkServiceTourokuJyoukyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorkbn;

    private C_UmuKbn dsKaiykServiceTourokuUmu;

    public C_ErrorKbn getErrorkbn() {
        return errorkbn;
    }

    public void setErrorkbn(C_ErrorKbn pErrorkbn) {
        errorkbn = pErrorkbn;
    }

    public C_UmuKbn getDsKaiykServiceTourokuUmu() {
        return dsKaiykServiceTourokuUmu;
    }

    public void setDsKaiykServiceTourokuUmu(C_UmuKbn pDsKaiykServiceTourokuUmu) {
        dsKaiykServiceTourokuUmu = pDsKaiykServiceTourokuUmu;
    }

}
