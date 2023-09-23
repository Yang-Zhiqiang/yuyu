package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;

/**
 * 指数連動積増型年金積立金TBL取得Beanクラスです。<br />
 */
public class GetKhSisuurendoTmttknTblBean implements Serializable, EntityContainer {

    private static final long serialVersionUID = 1L;

    private IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

    public GetKhSisuurendoTmttknTblBean() {
        super();
    }

    public  IT_KhSisuurendoTmttkn getKhSisuurendoTmttkn() {
        return khSisuurendoTmttkn;
    }

    public void setKhSisuurendoTmttkn(IT_KhSisuurendoTmttkn pIT_KhSisuurendoTmttkn) {
        this.khSisuurendoTmttkn = pIT_KhSisuurendoTmttkn;
    }
}
