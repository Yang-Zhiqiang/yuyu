package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_KouteiRireki;
import yuyu.def.db.mapping.GenWT_KouteiRireki;
import yuyu.def.db.meta.GenQWT_KouteiRireki;
import yuyu.def.db.meta.QWT_KouteiRireki;
import yuyu.def.classification.C_RirekiKbn;

/**
 * 工程履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_KouteiRireki} の JavaDoc を参照してください。
 * @see     GenWT_KouteiRireki
 * @see     PKWT_KouteiRireki
 * @see     QWT_KouteiRireki
 * @see     GenQWT_KouteiRireki
 */
@Entity
public class WT_KouteiRireki extends GenWT_KouteiRireki {

    private static final long serialVersionUID = 1L;

    public WT_KouteiRireki() {
    }

    public WT_KouteiRireki(
        String pTokenId,
        C_RirekiKbn pRirekiKbn,
        String pSyoriTime
    ) {
        super(
            pTokenId,
            pRirekiKbn,
            pSyoriTime
        );
    }

}
