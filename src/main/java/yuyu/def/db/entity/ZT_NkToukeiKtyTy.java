package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiKtyTy;
import yuyu.def.db.mapping.GenZT_NkToukeiKtyTy;
import yuyu.def.db.meta.GenQZT_NkToukeiKtyTy;
import yuyu.def.db.meta.QZT_NkToukeiKtyTy;

/**
 * 年金統計Ｆ期中報告用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiKtyTy} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiKtyTy
 * @see     PKZT_NkToukeiKtyTy
 * @see     QZT_NkToukeiKtyTy
 * @see     GenQZT_NkToukeiKtyTy
 */
@Entity
public class ZT_NkToukeiKtyTy extends GenZT_NkToukeiKtyTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiKtyTy() {
    }

    public ZT_NkToukeiKtyTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
