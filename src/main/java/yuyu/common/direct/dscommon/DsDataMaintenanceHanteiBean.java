package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_DsDataMaintenanceRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳデータメンテナンス中判定Bean<br/>
 */
public class DsDataMaintenanceHanteiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn kekkaKbn;

    public C_ErrorKbn getKekkaKbn() {
        return kekkaKbn;
    }

    public void setKekkaKbn(C_ErrorKbn pKekkaKbn) {
        kekkaKbn = pKekkaKbn;
    }

    private C_UmuKbn dsDataMaintenanceUmuKbn;

    public C_UmuKbn getDsDataMaintenanceUmuKbn() {
        return dsDataMaintenanceUmuKbn;
    }

    public void setDsDataMaintenanceUmuKbn(C_UmuKbn pDsDataMaintenanceUmuKbn) {
        dsDataMaintenanceUmuKbn = pDsDataMaintenanceUmuKbn;
    }

    private C_DsDataMaintenanceRiyuuKbn dsDataMaintenanceRiyuuKbn;

    public C_DsDataMaintenanceRiyuuKbn getDsDataMaintenanceRiyuuKbn() {
        return dsDataMaintenanceRiyuuKbn;
    }

    public void setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn pDsDataMaintenanceRiyuuKbn) {
        dsDataMaintenanceRiyuuKbn = pDsDataMaintenanceRiyuuKbn;
    }
}
