package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_HtkinSikinIdouListSksWk;
import yuyu.def.db.mapping.GenBW_HtkinSikinIdouListSksWk;
import yuyu.def.db.meta.GenQBW_HtkinSikinIdouListSksWk;
import yuyu.def.db.meta.QBW_HtkinSikinIdouListSksWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 配当金資金移動リスト作成用ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_HtkinSikinIdouListSksWk} の JavaDoc を参照してください。
 * @see     GenBW_HtkinSikinIdouListSksWk
 * @see     PKBW_HtkinSikinIdouListSksWk
 * @see     QBW_HtkinSikinIdouListSksWk
 * @see     GenQBW_HtkinSikinIdouListSksWk
 */
@Entity
public class BW_HtkinSikinIdouListSksWk extends GenBW_HtkinSikinIdouListSksWk {

    private static final long serialVersionUID = 1L;

    public BW_HtkinSikinIdouListSksWk() {
    }

    public BW_HtkinSikinIdouListSksWk(String pSyono, BizDate pKijyunymd) {
        super(pSyono, pKijyunymd);
    }

}
