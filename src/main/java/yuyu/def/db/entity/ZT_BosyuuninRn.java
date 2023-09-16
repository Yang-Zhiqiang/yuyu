package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_BosyuuninRn;
import yuyu.def.db.mapping.GenZT_BosyuuninRn;
import yuyu.def.db.meta.GenQZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;

/**
 * 募集人ＰＲＴ用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BosyuuninRn} の JavaDoc を参照してください。
 * @see     GenZT_BosyuuninRn
 * @see     PKZT_BosyuuninRn
 * @see     QZT_BosyuuninRn
 * @see     GenQZT_BosyuuninRn
 */
@Entity
public class ZT_BosyuuninRn extends GenZT_BosyuuninRn {

    private static final long serialVersionUID = 1L;

    public ZT_BosyuuninRn() {
    }

    public ZT_BosyuuninRn(String pZrnbosyuunincd) {
        super(pZrnbosyuunincd);
    }

}
