package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeirituInfoRn;
import yuyu.def.db.mapping.GenZT_SeirituInfoRn;
import yuyu.def.db.meta.GenQZT_SeirituInfoRn;
import yuyu.def.db.meta.QZT_SeirituInfoRn;

/**
 * 成立情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeirituInfoRn} の JavaDoc を参照してください。
 * @see     GenZT_SeirituInfoRn
 * @see     PKZT_SeirituInfoRn
 * @see     QZT_SeirituInfoRn
 * @see     GenQZT_SeirituInfoRn
 */
@Entity
public class ZT_SeirituInfoRn extends GenZT_SeirituInfoRn {

    private static final long serialVersionUID = 1L;

    public ZT_SeirituInfoRn() {
    }

    public ZT_SeirituInfoRn(String pZrnkijyunym, String pZrnsyono) {
        super(pZrnkijyunym, pZrnsyono);
    }

}
