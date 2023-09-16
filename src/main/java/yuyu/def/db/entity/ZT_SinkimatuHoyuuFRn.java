package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkimatuHoyuuFRn;
import yuyu.def.db.mapping.GenZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.GenQZT_SinkimatuHoyuuFRn;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFRn;

/**
 * 新期末保有Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkimatuHoyuuFRn} の JavaDoc を参照してください。
 * @see     GenZT_SinkimatuHoyuuFRn
 * @see     PKZT_SinkimatuHoyuuFRn
 * @see     QZT_SinkimatuHoyuuFRn
 * @see     GenQZT_SinkimatuHoyuuFRn
 */
@Entity
public class ZT_SinkimatuHoyuuFRn extends GenZT_SinkimatuHoyuuFRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinkimatuHoyuuFRn() {
    }

    public ZT_SinkimatuHoyuuFRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
