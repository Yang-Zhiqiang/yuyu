package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IdouMeisaiTy;
import yuyu.def.db.mapping.GenZT_IdouMeisaiTy;
import yuyu.def.db.meta.GenQZT_IdouMeisaiTy;
import yuyu.def.db.meta.QZT_IdouMeisaiTy;

/**
 * 異動明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdouMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_IdouMeisaiTy
 * @see     PKZT_IdouMeisaiTy
 * @see     QZT_IdouMeisaiTy
 * @see     GenQZT_IdouMeisaiTy
 */
@Entity
public class ZT_IdouMeisaiTy extends GenZT_IdouMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_IdouMeisaiTy() {
    }

    public ZT_IdouMeisaiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
