package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.mapping.GenBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.GenQBT_HtkinSikinIdouListSksRk;
import yuyu.def.db.meta.QBT_HtkinSikinIdouListSksRk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 配当金資金移動リスト作成用履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HtkinSikinIdouListSksRk} の JavaDoc を参照してください。
 * @see     GenBT_HtkinSikinIdouListSksRk
 * @see     PKBT_HtkinSikinIdouListSksRk
 * @see     QBT_HtkinSikinIdouListSksRk
 * @see     GenQBT_HtkinSikinIdouListSksRk
 */
@Entity
public class BT_HtkinSikinIdouListSksRk extends GenBT_HtkinSikinIdouListSksRk {

    private static final long serialVersionUID = 1L;

    public BT_HtkinSikinIdouListSksRk() {
    }

    public BT_HtkinSikinIdouListSksRk(String pSyono, BizDate pKijyunymd) {
        super(pSyono, pKijyunymd);
    }

}
