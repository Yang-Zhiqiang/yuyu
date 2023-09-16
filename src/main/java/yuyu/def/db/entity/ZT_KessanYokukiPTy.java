package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KessanYokukiPTy;
import yuyu.def.db.mapping.GenZT_KessanYokukiPTy;
import yuyu.def.db.meta.GenQZT_KessanYokukiPTy;
import yuyu.def.db.meta.QZT_KessanYokukiPTy;

/**
 * 決算用翌期Ｐテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KessanYokukiPTy} の JavaDoc を参照してください。
 * @see     GenZT_KessanYokukiPTy
 * @see     PKZT_KessanYokukiPTy
 * @see     QZT_KessanYokukiPTy
 * @see     GenQZT_KessanYokukiPTy
 */
@Entity
public class ZT_KessanYokukiPTy extends GenZT_KessanYokukiPTy {

    private static final long serialVersionUID = 1L;

    public ZT_KessanYokukiPTy() {
    }

    public ZT_KessanYokukiPTy(String pZtykeijyouym, String pZtysyono) {
        super(pZtykeijyouym, pZtysyono);
    }

}
