package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_BikinIdouMeisaiTy;
import yuyu.def.db.mapping.GenZT_BikinIdouMeisaiTy;
import yuyu.def.db.meta.GenQZT_BikinIdouMeisaiTy;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiTy;

/**
 * 備金異動明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_BikinIdouMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_BikinIdouMeisaiTy
 * @see     PKZT_BikinIdouMeisaiTy
 * @see     QZT_BikinIdouMeisaiTy
 * @see     GenQZT_BikinIdouMeisaiTy
 */
@Entity
public class ZT_BikinIdouMeisaiTy extends GenZT_BikinIdouMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_BikinIdouMeisaiTy() {
    }

    public ZT_BikinIdouMeisaiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
