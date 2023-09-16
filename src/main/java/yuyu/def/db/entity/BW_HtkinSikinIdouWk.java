package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_HtkinSikinIdouWk;
import yuyu.def.db.mapping.GenBW_HtkinSikinIdouWk;
import yuyu.def.db.meta.GenQBW_HtkinSikinIdouWk;
import yuyu.def.db.meta.QBW_HtkinSikinIdouWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 配当金資金移動ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_HtkinSikinIdouWk} の JavaDoc を参照してください。
 * @see     GenBW_HtkinSikinIdouWk
 * @see     PKBW_HtkinSikinIdouWk
 * @see     QBW_HtkinSikinIdouWk
 * @see     GenQBW_HtkinSikinIdouWk
 */
@Entity
public class BW_HtkinSikinIdouWk extends GenBW_HtkinSikinIdouWk {

    private static final long serialVersionUID = 1L;

    public BW_HtkinSikinIdouWk() {
    }

    public BW_HtkinSikinIdouWk(String pSyono, BizDate pKijyunymd) {
        super(pSyono, pKijyunymd);
    }

}
