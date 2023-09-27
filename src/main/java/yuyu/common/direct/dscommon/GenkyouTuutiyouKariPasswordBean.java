package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsKrPswdGnkTtStrkHnCdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  現況通知用仮パスワードBean
 */
public class GenkyouTuutiyouKariPasswordBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorkbn;

    private C_UmuKbn dsKanyuuUmu;

    private C_KahiKbn dsKrPswdGnkTtkahikbn;

    private C_DsKrPswdGnkTtStrkHnCdKbn dsKrPswdGnkTtStrkHnCdKbn;

    private String dsKrPswdYoken;

    private BizDate dsKrPswdyuukouymd;

    private C_UmuKbn dsKaiykServiceTourokuUmu;

    public GenkyouTuutiyouKariPasswordBean() {

        errorkbn = C_ErrorKbn.ERROR;
        dsKanyuuUmu = C_UmuKbn.NONE;
        dsKrPswdGnkTtkahikbn = C_KahiKbn.HUKA;
        dsKrPswdGnkTtStrkHnCdKbn = C_DsKrPswdGnkTtStrkHnCdKbn.BLNK;
        dsKrPswdYoken = "";
        dsKrPswdyuukouymd = null;
        dsKaiykServiceTourokuUmu = C_UmuKbn.NONE;
    }
    public C_ErrorKbn getErrorkbn() {
        return errorkbn;
    }

    public void setErrorkbn(C_ErrorKbn pErrorkbn) {
        errorkbn = pErrorkbn;
    }

    public C_UmuKbn getDsKanyuuUmu() {
        return dsKanyuuUmu;
    }

    public void setDsKanyuuUmu(C_UmuKbn pDsKanyuuUmu) {
        dsKanyuuUmu = pDsKanyuuUmu;
    }

    public C_KahiKbn getDsKrPswdGnkTtkahikbn() {
        return dsKrPswdGnkTtkahikbn;
    }

    public void setDsKrPswdGnkTtkahikbn(C_KahiKbn pDsKrPswdGnkTtkahikbn) {
        dsKrPswdGnkTtkahikbn = pDsKrPswdGnkTtkahikbn;
    }

    public C_DsKrPswdGnkTtStrkHnCdKbn getDsKrPswdGnkTtStrkHnCdKbn() {
        return dsKrPswdGnkTtStrkHnCdKbn;
    }

    public void setDsKrPswdGnkTtStrkHnCdKbn(C_DsKrPswdGnkTtStrkHnCdKbn pDsKrPswdGnkTtStrkHnCdKbn) {
        dsKrPswdGnkTtStrkHnCdKbn = pDsKrPswdGnkTtStrkHnCdKbn;
    }

    public String getDsKrPswdYoken() {
        return dsKrPswdYoken;
    }

    public void setDsKrPswdYoken(String pDsKrPswdYoken) {
        dsKrPswdYoken = pDsKrPswdYoken;
    }

    public BizDate getDsKrPswdyuukouymd() {
        return dsKrPswdyuukouymd;
    }

    public void setDsKrPswdyuukouymd(BizDate pDsKrPswdyuukouymd) {
        dsKrPswdyuukouymd = pDsKrPswdyuukouymd;
    }


    public C_UmuKbn getDsKaiykServiceTourokuUmu() {
        return dsKaiykServiceTourokuUmu;
    }

    public void setDsKaiykServiceTourokuUmu(C_UmuKbn pDsKaiykServiceTourokuUmu) {
        dsKaiykServiceTourokuUmu = pDsKaiykServiceTourokuUmu;
    }
}
