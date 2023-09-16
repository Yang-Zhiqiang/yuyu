package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWM_TorikomiDaiBunrui;
import yuyu.def.db.mapping.GenWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.QWM_TorikomiDaiBunrui;

/**
 * 取込書類大分類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWM_TorikomiDaiBunrui} の JavaDoc を参照してください。
 * @see     GenWM_TorikomiDaiBunrui
 * @see     PKWM_TorikomiDaiBunrui
 * @see     QWM_TorikomiDaiBunrui
 * @see     GenQWM_TorikomiDaiBunrui
 */
@Entity
public class WM_TorikomiDaiBunrui extends GenWM_TorikomiDaiBunrui {

    private static final long serialVersionUID = 1L;

    public WM_TorikomiDaiBunrui() {
    }

    public WM_TorikomiDaiBunrui(String pSyzkDaiBunruiId) {
        super(pSyzkDaiBunruiId);
    }

}
