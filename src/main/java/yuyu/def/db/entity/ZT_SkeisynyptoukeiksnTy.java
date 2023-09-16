package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.mapping.GenZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnTy;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkeisynyptoukeiksnTy} の JavaDoc を参照してください。
 * @see     GenZT_SkeisynyptoukeiksnTy
 * @see     PKZT_SkeisynyptoukeiksnTy
 * @see     QZT_SkeisynyptoukeiksnTy
 * @see     GenQZT_SkeisynyptoukeiksnTy
 */
@Entity
public class ZT_SkeisynyptoukeiksnTy extends GenZT_SkeisynyptoukeiksnTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkeisynyptoukeiksnTy() {
    }

    public ZT_SkeisynyptoukeiksnTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
