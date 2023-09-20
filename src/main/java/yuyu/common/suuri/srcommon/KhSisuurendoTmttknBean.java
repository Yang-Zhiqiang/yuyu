package yuyu.common.suuri.srcommon;

import java.io.Serializable;

import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;

/**
 * 数理 数理共通 指数連動積増型年金積立金テーブルエンティティBean
 */
public class KhSisuurendoTmttknBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private IT_KhSisuurendoTmttkn khSisuurendoTmttknMae;

    private IT_KhSisuurendoTmttkn khSisuurendoTmttknAto;

    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttknMae() {
        return khSisuurendoTmttknMae;
    }

    public void setKhSisuurendoTmttknMae(IT_KhSisuurendoTmttkn pKhSisuurendoTmttknMae) {
        khSisuurendoTmttknMae = pKhSisuurendoTmttknMae;
    }

    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttknAto() {
        return khSisuurendoTmttknAto;
    }

    public void setKhSisuurendoTmttknAto(IT_KhSisuurendoTmttkn pKhSisuurendoTmttknAto) {
        khSisuurendoTmttknAto = pKhSisuurendoTmttknAto;
    }
}
