package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.mapping.GenZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.GenQZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenTy;

/**
 * 死亡率統計整備後連動Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SbRituToukeiSeibiRenTy} の JavaDoc を参照してください。
 * @see     GenZT_SbRituToukeiSeibiRenTy
 * @see     PKZT_SbRituToukeiSeibiRenTy
 * @see     QZT_SbRituToukeiSeibiRenTy
 * @see     GenQZT_SbRituToukeiSeibiRenTy
 */
@Entity
public class ZT_SbRituToukeiSeibiRenTy extends GenZT_SbRituToukeiSeibiRenTy {

    private static final long serialVersionUID = 1L;

    public ZT_SbRituToukeiSeibiRenTy() {
    }

    public ZT_SbRituToukeiSeibiRenTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
