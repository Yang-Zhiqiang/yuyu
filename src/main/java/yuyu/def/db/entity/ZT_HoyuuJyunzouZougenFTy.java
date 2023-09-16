package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.mapping.GenZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.GenQZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFTy;

/**
 * 保有純増増減Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HoyuuJyunzouZougenFTy} の JavaDoc を参照してください。
 * @see     GenZT_HoyuuJyunzouZougenFTy
 * @see     PKZT_HoyuuJyunzouZougenFTy
 * @see     QZT_HoyuuJyunzouZougenFTy
 * @see     GenQZT_HoyuuJyunzouZougenFTy
 */
@Entity
public class ZT_HoyuuJyunzouZougenFTy extends GenZT_HoyuuJyunzouZougenFTy {

    private static final long serialVersionUID = 1L;

    public ZT_HoyuuJyunzouZougenFTy() {
    }

    public ZT_HoyuuJyunzouZougenFTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
