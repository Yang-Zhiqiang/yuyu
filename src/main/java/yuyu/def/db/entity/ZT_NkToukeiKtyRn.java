package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiKtyRn;
import yuyu.def.db.mapping.GenZT_NkToukeiKtyRn;
import yuyu.def.db.meta.GenQZT_NkToukeiKtyRn;
import yuyu.def.db.meta.QZT_NkToukeiKtyRn;

/**
 * 年金統計Ｆ期中報告用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiKtyRn} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiKtyRn
 * @see     PKZT_NkToukeiKtyRn
 * @see     QZT_NkToukeiKtyRn
 * @see     GenQZT_NkToukeiKtyRn
 */
@Entity
public class ZT_NkToukeiKtyRn extends GenZT_NkToukeiKtyRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiKtyRn() {
    }

    public ZT_NkToukeiKtyRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
