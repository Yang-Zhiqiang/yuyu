package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWM_TorikomiSyorui;
import yuyu.def.db.mapping.GenWM_TorikomiSyorui;
import yuyu.def.db.meta.GenQWM_TorikomiSyorui;
import yuyu.def.db.meta.QWM_TorikomiSyorui;

/**
 * 取込書類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWM_TorikomiSyorui} の JavaDoc を参照してください。
 * @see     GenWM_TorikomiSyorui
 * @see     PKWM_TorikomiSyorui
 * @see     QWM_TorikomiSyorui
 * @see     GenQWM_TorikomiSyorui
 */
@Entity
public class WM_TorikomiSyorui extends GenWM_TorikomiSyorui {

    private static final long serialVersionUID = 1L;

    public WM_TorikomiSyorui() {
    }

    public WM_TorikomiSyorui(String pTorikomiSyoruiCd) {
        super(pTorikomiSyoruiCd);
    }

}
