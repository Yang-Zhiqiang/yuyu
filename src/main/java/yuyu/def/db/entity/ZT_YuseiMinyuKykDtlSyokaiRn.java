package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.mapping.GenZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.GenQZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiRn;

/**
 * 郵政未入契約明細照会用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuseiMinyuKykDtlSyokaiRn} の JavaDoc を参照してください。
 * @see     GenZT_YuseiMinyuKykDtlSyokaiRn
 * @see     PKZT_YuseiMinyuKykDtlSyokaiRn
 * @see     QZT_YuseiMinyuKykDtlSyokaiRn
 * @see     GenQZT_YuseiMinyuKykDtlSyokaiRn
 */
@Entity
public class ZT_YuseiMinyuKykDtlSyokaiRn extends GenZT_YuseiMinyuKykDtlSyokaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_YuseiMinyuKykDtlSyokaiRn() {
    }

    public ZT_YuseiMinyuKykDtlSyokaiRn(
        String pZrnsakuseiym,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono
    ) {
        super(
            pZrnsakuseiym,
            pZrnbsydrtencd,
            pZrntntusycd,
            pZrnsyono
        );
    }

}
