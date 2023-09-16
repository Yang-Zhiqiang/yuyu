package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.mapping.GenZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykTy;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykTy;

/**
 * 代理店月次契約情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinBosyuuDrtenHoyuuKykTy} の JavaDoc を参照してください。
 * @see     GenZT_SinBosyuuDrtenHoyuuKykTy
 * @see     PKZT_SinBosyuuDrtenHoyuuKykTy
 * @see     QZT_SinBosyuuDrtenHoyuuKykTy
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykTy
 */
@Entity
public class ZT_SinBosyuuDrtenHoyuuKykTy extends GenZT_SinBosyuuDrtenHoyuuKykTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinBosyuuDrtenHoyuuKykTy() {
    }

    public ZT_SinBosyuuDrtenHoyuuKykTy(String pZtysyono) {
        super(pZtysyono);
    }

}
