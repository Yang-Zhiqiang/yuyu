package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_KouteiSummary;
import yuyu.def.db.mapping.GenWT_KouteiSummary;
import yuyu.def.db.meta.GenQWT_KouteiSummary;
import yuyu.def.db.meta.QWT_KouteiSummary;

/**
 * 工程サマリテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_KouteiSummary} の JavaDoc を参照してください。
 * @see     GenWT_KouteiSummary
 * @see     PKWT_KouteiSummary
 * @see     QWT_KouteiSummary
 * @see     GenQWT_KouteiSummary
 */
@Entity
public class WT_KouteiSummary extends GenWT_KouteiSummary {

    private static final long serialVersionUID = 1L;

    public WT_KouteiSummary() {
    }

    public WT_KouteiSummary(String pGyoumuKey) {
        super(pGyoumuKey);
    }

}
