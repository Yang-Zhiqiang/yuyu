package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiHySgTy;
import yuyu.def.db.mapping.GenZT_NkGensiHySgTy;
import yuyu.def.db.meta.GenQZT_NkGensiHySgTy;
import yuyu.def.db.meta.QZT_NkGensiHySgTy;

/**
 * 年金原資Ｆ保有照合用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiHySgTy} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiHySgTy
 * @see     PKZT_NkGensiHySgTy
 * @see     QZT_NkGensiHySgTy
 * @see     GenQZT_NkGensiHySgTy
 */
@Entity
public class ZT_NkGensiHySgTy extends GenZT_NkGensiHySgTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiHySgTy() {
    }

    public ZT_NkGensiHySgTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
