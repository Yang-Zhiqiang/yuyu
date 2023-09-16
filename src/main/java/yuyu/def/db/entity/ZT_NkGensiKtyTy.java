package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiKtyTy;
import yuyu.def.db.mapping.GenZT_NkGensiKtyTy;
import yuyu.def.db.meta.GenQZT_NkGensiKtyTy;
import yuyu.def.db.meta.QZT_NkGensiKtyTy;

/**
 * 年金原資Ｆ期中報告用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiKtyTy} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiKtyTy
 * @see     PKZT_NkGensiKtyTy
 * @see     QZT_NkGensiKtyTy
 * @see     GenQZT_NkGensiKtyTy
 */
@Entity
public class ZT_NkGensiKtyTy extends GenZT_NkGensiKtyTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiKtyTy() {
    }

    public ZT_NkGensiKtyTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
