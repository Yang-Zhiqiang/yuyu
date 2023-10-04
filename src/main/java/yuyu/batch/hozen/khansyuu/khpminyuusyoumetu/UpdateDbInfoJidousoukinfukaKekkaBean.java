package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu;

import java.io.Serializable;

import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 案内収納 ＤＢ更新情報作成（自動送金不可）結果Bean<br />
 */

public class UpdateDbInfoJidousoukinfukaKekkaBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private IT_KykKihon kykKihon;

    private IT_KhTyousyo khTyousyo;

    public IT_KykKihon  getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon  pKykKihon) {
        kykKihon = pKykKihon;
    }

    public IT_KhTyousyo  getKhTyousyo() {
        return khTyousyo;
    }

    public void setKhTyousyo(IT_KhTyousyo  pKhTyousyo) {
        khTyousyo = pKhTyousyo;
    }

}
