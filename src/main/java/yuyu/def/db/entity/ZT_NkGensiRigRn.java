package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiRigRn;
import yuyu.def.db.mapping.GenZT_NkGensiRigRn;
import yuyu.def.db.meta.GenQZT_NkGensiRigRn;
import yuyu.def.db.meta.QZT_NkGensiRigRn;

/**
 * 年金原資Ｆ例月用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiRigRn} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiRigRn
 * @see     PKZT_NkGensiRigRn
 * @see     QZT_NkGensiRigRn
 * @see     GenQZT_NkGensiRigRn
 */
@Entity
public class ZT_NkGensiRigRn extends GenZT_NkGensiRigRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiRigRn() {
    }

    public ZT_NkGensiRigRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
