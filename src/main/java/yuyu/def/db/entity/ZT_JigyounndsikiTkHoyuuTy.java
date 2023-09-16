package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.mapping.GenZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.GenQZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuTy;

/**
 * 事業年度式特約保有Fテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_JigyounndsikiTkHoyuuTy} の JavaDoc を参照してください。
 * @see     GenZT_JigyounndsikiTkHoyuuTy
 * @see     PKZT_JigyounndsikiTkHoyuuTy
 * @see     QZT_JigyounndsikiTkHoyuuTy
 * @see     GenQZT_JigyounndsikiTkHoyuuTy
 */
@Entity
public class ZT_JigyounndsikiTkHoyuuTy extends GenZT_JigyounndsikiTkHoyuuTy {

    private static final long serialVersionUID = 1L;

    public ZT_JigyounndsikiTkHoyuuTy() {
    }

    public ZT_JigyounndsikiTkHoyuuTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
