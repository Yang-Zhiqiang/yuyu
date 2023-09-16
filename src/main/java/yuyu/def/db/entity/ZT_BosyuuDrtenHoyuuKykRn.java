package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.mapping.GenZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.GenQZT_BosyuuDrtenHoyuuKykRn;
import yuyu.def.db.meta.QZT_BosyuuDrtenHoyuuKykRn;

/**
 * 募集代理店保有契約Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BosyuuDrtenHoyuuKykRn} の JavaDoc を参照してください。
 * @see     GenZT_BosyuuDrtenHoyuuKykRn
 * @see     PKZT_BosyuuDrtenHoyuuKykRn
 * @see     QZT_BosyuuDrtenHoyuuKykRn
 * @see     GenQZT_BosyuuDrtenHoyuuKykRn
 */
@Entity
public class ZT_BosyuuDrtenHoyuuKykRn extends GenZT_BosyuuDrtenHoyuuKykRn {

    private static final long serialVersionUID = 1L;

    public ZT_BosyuuDrtenHoyuuKykRn() {
    }

    public ZT_BosyuuDrtenHoyuuKykRn(String pZrnsyonosyuban) {
        super(pZrnsyonosyuban);
    }

}
