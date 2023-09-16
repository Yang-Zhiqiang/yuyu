package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkeisynyptoukeirigTy;
import yuyu.def.db.mapping.GenZT_SkeisynyptoukeirigTy;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeirigTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigTy;

/**
 * 新契約収入Ｐ統計例月Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkeisynyptoukeirigTy} の JavaDoc を参照してください。
 * @see     GenZT_SkeisynyptoukeirigTy
 * @see     PKZT_SkeisynyptoukeirigTy
 * @see     QZT_SkeisynyptoukeirigTy
 * @see     GenQZT_SkeisynyptoukeirigTy
 */
@Entity
public class ZT_SkeisynyptoukeirigTy extends GenZT_SkeisynyptoukeirigTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkeisynyptoukeirigTy() {
    }

    public ZT_SkeisynyptoukeirigTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
