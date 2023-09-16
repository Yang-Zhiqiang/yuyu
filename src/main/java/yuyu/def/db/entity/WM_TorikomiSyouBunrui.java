package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWM_TorikomiSyouBunrui;
import yuyu.def.db.mapping.GenWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.QWM_TorikomiSyouBunrui;

/**
 * 取込書類小分類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWM_TorikomiSyouBunrui} の JavaDoc を参照してください。
 * @see     GenWM_TorikomiSyouBunrui
 * @see     PKWM_TorikomiSyouBunrui
 * @see     QWM_TorikomiSyouBunrui
 * @see     GenQWM_TorikomiSyouBunrui
 */
@Entity
public class WM_TorikomiSyouBunrui extends GenWM_TorikomiSyouBunrui {

    private static final long serialVersionUID = 1L;

    public WM_TorikomiSyouBunrui() {
    }

    public WM_TorikomiSyouBunrui(String pSyzkSyouBunruiId) {
        super(pSyzkSyouBunruiId);
    }

}
