package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKSV_AlmNnknHyu;
import yuyu.def.db.mapping.GenSV_AlmNnknHyu;
import yuyu.def.db.meta.GenQSV_AlmNnknHyu;
import yuyu.def.db.meta.QSV_AlmNnknHyu;

/**
 * ＡＬＭ用年金保有明細ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_AlmNnknHyu} の JavaDoc を参照してください。
 * @see     GenSV_AlmNnknHyu
 * @see     PKSV_AlmNnknHyu
 * @see     QSV_AlmNnknHyu
 * @see     GenQSV_AlmNnknHyu
 */
@Entity
public class SV_AlmNnknHyu extends GenSV_AlmNnknHyu {

    private static final long serialVersionUID = 1L;

    public SV_AlmNnknHyu() {
    }

    public SV_AlmNnknHyu(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
