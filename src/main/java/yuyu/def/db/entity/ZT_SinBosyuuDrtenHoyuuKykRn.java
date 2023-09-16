package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.mapping.GenZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_SinBosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_SinBosyuuDrtenHoyuuKykRn;

/**
 * 代理店月次契約情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinBosyuuDrtenHoyuuKykRn} の JavaDoc を参照してください。
 * @see     GenZT_SinBosyuuDrtenHoyuuKykRn
 * @see     PKZT_SinBosyuuDrtenHoyuuKykRn
 * @see     QZT_SinBosyuuDrtenHoyuuKykRn
 * @see     GenQZT_SinBosyuuDrtenHoyuuKykRn
 */
@Entity
public class ZT_SinBosyuuDrtenHoyuuKykRn extends GenZT_SinBosyuuDrtenHoyuuKykRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinBosyuuDrtenHoyuuKykRn() {
    }

    public ZT_SinBosyuuDrtenHoyuuKykRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
