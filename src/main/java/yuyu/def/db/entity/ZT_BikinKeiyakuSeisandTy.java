package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.mapping.GenZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.GenQZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandTy;

/**
 * 備金契約精算ＤＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BikinKeiyakuSeisandTy} の JavaDoc を参照してください。
 * @see     GenZT_BikinKeiyakuSeisandTy
 * @see     PKZT_BikinKeiyakuSeisandTy
 * @see     QZT_BikinKeiyakuSeisandTy
 * @see     GenQZT_BikinKeiyakuSeisandTy
 */
@Entity
public class ZT_BikinKeiyakuSeisandTy extends GenZT_BikinKeiyakuSeisandTy {

    private static final long serialVersionUID = 1L;

    public ZT_BikinKeiyakuSeisandTy() {
    }

    public ZT_BikinKeiyakuSeisandTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
