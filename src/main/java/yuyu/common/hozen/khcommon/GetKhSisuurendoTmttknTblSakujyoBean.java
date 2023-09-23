package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.db.EntityContainer;
import yuyu.def.db.entity.IT_KhHenkouRireki;

/**
 * 指数連動積増型年金積立金TBL削除情報取得入力Beanクラス。<br />
 */
public class GetKhSisuurendoTmttknTblSakujyoBean implements Serializable, EntityContainer {


    private static final long serialVersionUID = 1L;

    private IT_KhHenkouRireki khHenkouRireki = null;

    public GetKhSisuurendoTmttknTblSakujyoBean() {
        super();
    }

    public  IT_KhHenkouRireki getKhHenkouRireki() {
        return khHenkouRireki;
    }

    public void setKhHenkouRireki(IT_KhHenkouRireki pIT_KhHenkouRireki) {
        this.khHenkouRireki = pIT_KhHenkouRireki;
    }
}
