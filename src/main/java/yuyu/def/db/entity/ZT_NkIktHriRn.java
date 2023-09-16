package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkIktHriRn;
import yuyu.def.db.mapping.GenZT_NkIktHriRn;
import yuyu.def.db.meta.GenQZT_NkIktHriRn;
import yuyu.def.db.meta.QZT_NkIktHriRn;

/**
 * 年金一括払テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkIktHriRn} の JavaDoc を参照してください。
 * @see     GenZT_NkIktHriRn
 * @see     PKZT_NkIktHriRn
 * @see     QZT_NkIktHriRn
 * @see     GenQZT_NkIktHriRn
 */
@Entity
public class ZT_NkIktHriRn extends GenZT_NkIktHriRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkIktHriRn() {
    }

    public ZT_NkIktHriRn(String pZrndatakanrino) {
        super(pZrndatakanrino);
    }

}
