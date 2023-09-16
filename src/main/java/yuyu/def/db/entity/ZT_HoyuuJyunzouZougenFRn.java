package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.mapping.GenZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.GenQZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFRn;

/**
 * 保有純増増減Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HoyuuJyunzouZougenFRn} の JavaDoc を参照してください。
 * @see     GenZT_HoyuuJyunzouZougenFRn
 * @see     PKZT_HoyuuJyunzouZougenFRn
 * @see     QZT_HoyuuJyunzouZougenFRn
 * @see     GenQZT_HoyuuJyunzouZougenFRn
 */
@Entity
public class ZT_HoyuuJyunzouZougenFRn extends GenZT_HoyuuJyunzouZougenFRn {

    private static final long serialVersionUID = 1L;

    public ZT_HoyuuJyunzouZougenFRn() {
    }

    public ZT_HoyuuJyunzouZougenFRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
