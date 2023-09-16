package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.db.mapping.GenBT_LastSyoriYMDKanri;


/**
 * 最終処理日管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_LastSyoriYMDKanri} の JavaDoc を参照してください。<br />
 * @see     GenBT_LastSyoriYMDKanri<br />
 * @see     PKBT_LastSyoriYMDKanri<br />
 * @see     QBT_LastSyoriYMDKanri<br />
 * @see     GenQBT_LastSyoriYMDKanri<br />
 */
@Entity
public class BT_LastSyoriYMDKanri extends GenBT_LastSyoriYMDKanri {

    private static final long serialVersionUID = 1L;

    public BT_LastSyoriYMDKanri() {
    }

    public BT_LastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {
        super(pLastsyoriymdkanrikbn);
    }



}

