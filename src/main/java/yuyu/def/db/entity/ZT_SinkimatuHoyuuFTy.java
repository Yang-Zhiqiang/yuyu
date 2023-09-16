package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkimatuHoyuuFTy;
import yuyu.def.db.mapping.GenZT_SinkimatuHoyuuFTy;
import yuyu.def.db.meta.GenQZT_SinkimatuHoyuuFTy;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFTy;

/**
 * 新期末保有Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkimatuHoyuuFTy} の JavaDoc を参照してください。
 * @see     GenZT_SinkimatuHoyuuFTy
 * @see     PKZT_SinkimatuHoyuuFTy
 * @see     QZT_SinkimatuHoyuuFTy
 * @see     GenQZT_SinkimatuHoyuuFTy
 */
@Entity
public class ZT_SinkimatuHoyuuFTy extends GenZT_SinkimatuHoyuuFTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinkimatuHoyuuFTy() {
    }

    public ZT_SinkimatuHoyuuFTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
