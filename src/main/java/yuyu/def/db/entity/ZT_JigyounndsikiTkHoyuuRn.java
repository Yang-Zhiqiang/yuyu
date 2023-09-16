package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.mapping.GenZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.GenQZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuRn;

/**
 * 事業年度式特約保有Fテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_JigyounndsikiTkHoyuuRn} の JavaDoc を参照してください。
 * @see     GenZT_JigyounndsikiTkHoyuuRn
 * @see     PKZT_JigyounndsikiTkHoyuuRn
 * @see     QZT_JigyounndsikiTkHoyuuRn
 * @see     GenQZT_JigyounndsikiTkHoyuuRn
 */
@Entity
public class ZT_JigyounndsikiTkHoyuuRn extends GenZT_JigyounndsikiTkHoyuuRn {

    private static final long serialVersionUID = 1L;

    public ZT_JigyounndsikiTkHoyuuRn() {
    }

    public ZT_JigyounndsikiTkHoyuuRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
