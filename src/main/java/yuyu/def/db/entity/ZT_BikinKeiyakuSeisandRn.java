package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.mapping.GenZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.GenQZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandRn;

/**
 * 備金契約精算ＤＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BikinKeiyakuSeisandRn} の JavaDoc を参照してください。
 * @see     GenZT_BikinKeiyakuSeisandRn
 * @see     PKZT_BikinKeiyakuSeisandRn
 * @see     QZT_BikinKeiyakuSeisandRn
 * @see     GenQZT_BikinKeiyakuSeisandRn
 */
@Entity
public class ZT_BikinKeiyakuSeisandRn extends GenZT_BikinKeiyakuSeisandRn {

    private static final long serialVersionUID = 1L;

    public ZT_BikinKeiyakuSeisandRn() {
    }

    public ZT_BikinKeiyakuSeisandRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
