package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.mapping.GenST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.GenQST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.QST_SynypTukiYkgtIkouHozon;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * 収入Ｐ統計翌月以降保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SynypTukiYkgtIkouHozon} の JavaDoc を参照してください。
 * @see     GenST_SynypTukiYkgtIkouHozon
 * @see     PKST_SynypTukiYkgtIkouHozon
 * @see     QST_SynypTukiYkgtIkouHozon
 * @see     GenQST_SynypTukiYkgtIkouHozon
 */
@Entity
public class ST_SynypTukiYkgtIkouHozon extends GenST_SynypTukiYkgtIkouHozon {

    private static final long serialVersionUID = 1L;

    public ST_SynypTukiYkgtIkouHozon() {
    }

    public ST_SynypTukiYkgtIkouHozon(
        String pSrkijyunym,
        Integer pSequenceno,
        String pSyono,
        BizDateYM pJyutoustartym,
        BizDateYM pJyutouendym,
        C_TaisyakuKbn pTaisyakukbn
    ) {
        super(
            pSrkijyunym,
            pSequenceno,
            pSyono,
            pJyutoustartym,
            pJyutouendym,
            pTaisyakukbn
        );
    }

}
