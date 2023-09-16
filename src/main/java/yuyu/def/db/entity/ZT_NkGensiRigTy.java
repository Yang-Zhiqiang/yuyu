package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiRigTy;
import yuyu.def.db.mapping.GenZT_NkGensiRigTy;
import yuyu.def.db.meta.GenQZT_NkGensiRigTy;
import yuyu.def.db.meta.QZT_NkGensiRigTy;

/**
 * 年金原資Ｆ例月用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiRigTy} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiRigTy
 * @see     PKZT_NkGensiRigTy
 * @see     QZT_NkGensiRigTy
 * @see     GenQZT_NkGensiRigTy
 */
@Entity
public class ZT_NkGensiRigTy extends GenZT_NkGensiRigTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiRigTy() {
    }

    public ZT_NkGensiRigTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
