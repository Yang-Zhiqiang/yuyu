package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkGensiKtyRn;
import yuyu.def.db.mapping.GenZT_NkGensiKtyRn;
import yuyu.def.db.meta.GenQZT_NkGensiKtyRn;
import yuyu.def.db.meta.QZT_NkGensiKtyRn;

/**
 * 年金原資Ｆ期中報告用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkGensiKtyRn} の JavaDoc を参照してください。
 * @see     GenZT_NkGensiKtyRn
 * @see     PKZT_NkGensiKtyRn
 * @see     QZT_NkGensiKtyRn
 * @see     GenQZT_NkGensiKtyRn
 */
@Entity
public class ZT_NkGensiKtyRn extends GenZT_NkGensiKtyRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkGensiKtyRn() {
    }

    public ZT_NkGensiKtyRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
