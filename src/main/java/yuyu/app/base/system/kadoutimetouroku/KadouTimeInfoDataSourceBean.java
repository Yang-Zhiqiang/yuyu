package yuyu.app.base.system.kadoutimetouroku;

import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.entity.AT_KadouTime;

/**
 * 営業日・非営業日稼働時間情報データソースビーンのインタフェースです。
 */
public interface KadouTimeInfoDataSourceBean {
    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn);
    void setKadouTime(AT_KadouTime pAt_KadouTime, int idx);
    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn();
    public String getKadouTimeFrom1();
    public String getKadouTimeTo1();
    public String getKadouTimeFrom2();
    public String getKadouTimeTo2();
    public String getKadouTimeFrom3();
    public String getKadouTimeTo3();
    public String getKadouTimeFrom4();
    public String getKadouTimeTo4();
    public String getKadouTimeFrom5();
    public String getKadouTimeTo5();

}
