package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.mapping.GenZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykTy;

/**
 * 募集代理店保有契約Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BosyuuDrtenHoyuuKykTy} の JavaDoc を参照してください。
 * @see     GenZT_BosyuuDrtenHoyuuKykTy
 * @see     PKZT_BosyuuDrtenHoyuuKykTy
 * @see     QZT_BosyuuDrtenHoyuuKykTy
 * @see     GenQZT_BosyuuDrtenHoyuuKykTy
 */
@Entity
public class ZT_BosyuuDrtenHoyuuKykTy extends GenZT_BosyuuDrtenHoyuuKykTy {

    private static final long serialVersionUID = 1L;

    public ZT_BosyuuDrtenHoyuuKykTy() {
    }

    public ZT_BosyuuDrtenHoyuuKykTy(String pZtysyonosyuban) {
        super(pZtysyonosyuban);
    }

}
