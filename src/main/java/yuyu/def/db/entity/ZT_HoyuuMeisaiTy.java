package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HoyuuMeisaiTy;
import yuyu.def.db.mapping.GenZT_HoyuuMeisaiTy;
import yuyu.def.db.meta.GenQZT_HoyuuMeisaiTy;
import yuyu.def.db.meta.QZT_HoyuuMeisaiTy;

/**
 * 保有明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HoyuuMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_HoyuuMeisaiTy
 * @see     PKZT_HoyuuMeisaiTy
 * @see     QZT_HoyuuMeisaiTy
 * @see     GenQZT_HoyuuMeisaiTy
 */
@Entity
public class ZT_HoyuuMeisaiTy extends GenZT_HoyuuMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_HoyuuMeisaiTy() {
    }

    public ZT_HoyuuMeisaiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
