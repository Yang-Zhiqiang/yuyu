package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.mapping.GenZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.GenQZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenRn;

/**
 * 死亡率統計整備後連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SbRituToukeiSeibiRenRn} の JavaDoc を参照してください。
 * @see     GenZT_SbRituToukeiSeibiRenRn
 * @see     PKZT_SbRituToukeiSeibiRenRn
 * @see     QZT_SbRituToukeiSeibiRenRn
 * @see     GenQZT_SbRituToukeiSeibiRenRn
 */
@Entity
public class ZT_SbRituToukeiSeibiRenRn extends GenZT_SbRituToukeiSeibiRenRn {

    private static final long serialVersionUID = 1L;

    public ZT_SbRituToukeiSeibiRenRn() {
    }

    public ZT_SbRituToukeiSeibiRenRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
