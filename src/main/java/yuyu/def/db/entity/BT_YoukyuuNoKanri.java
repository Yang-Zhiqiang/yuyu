package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBT_YoukyuuNoKanri;


/**
 * 要求通番管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_YoukyuuNoKanri} の JavaDoc を参照してください。<br />
 * @see     GenBT_YoukyuuNoKanri<br />
 * @see     PKBT_YoukyuuNoKanri<br />
 * @see     QBT_YoukyuuNoKanri<br />
 * @see     GenQBT_YoukyuuNoKanri<br />
 */
@Entity
public class BT_YoukyuuNoKanri extends GenBT_YoukyuuNoKanri {

    private static final long serialVersionUID = 1L;

    public BT_YoukyuuNoKanri() {
    }

    public BT_YoukyuuNoKanri(String pYoukyuuno) {
        super(pYoukyuuno);
    }



}

