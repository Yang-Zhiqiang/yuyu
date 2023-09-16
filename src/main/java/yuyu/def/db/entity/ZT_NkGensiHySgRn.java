package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiHySgRn;
import yuyu.def.db.mapping.GenZT_NkGensiHySgRn;
import yuyu.def.db.meta.GenQZT_NkGensiHySgRn;
import yuyu.def.db.meta.QZT_NkGensiHySgRn;

/**
 * 年金原資Ｆ保有照合用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiHySgRn} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiHySgRn
 * @see     PKZT_NkGensiHySgRn
 * @see     QZT_NkGensiHySgRn
 * @see     GenQZT_NkGensiHySgRn
 */
@Entity
public class ZT_NkGensiHySgRn extends GenZT_NkGensiHySgRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiHySgRn() {
    }

    public ZT_NkGensiHySgRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
