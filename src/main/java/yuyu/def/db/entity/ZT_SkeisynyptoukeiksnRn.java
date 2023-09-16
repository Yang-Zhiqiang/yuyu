package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.mapping.GenZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnRn;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkeisynyptoukeiksnRn} の JavaDoc を参照してください。
 * @see     GenZT_SkeisynyptoukeiksnRn
 * @see     PKZT_SkeisynyptoukeiksnRn
 * @see     QZT_SkeisynyptoukeiksnRn
 * @see     GenQZT_SkeisynyptoukeiksnRn
 */
@Entity
public class ZT_SkeisynyptoukeiksnRn extends GenZT_SkeisynyptoukeiksnRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkeisynyptoukeiksnRn() {
    }

    public ZT_SkeisynyptoukeiksnRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
