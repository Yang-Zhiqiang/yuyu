package yuyu.def.db.entity;



import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_MosMikakuteiJyouhouKanri;



/**
 * 申込未確定情報管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosMikakuteiJyouhouKanri} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosMikakuteiJyouhouKanri<br />
 * @see     PKHT_MosMikakuteiJyouhouKanri<br />
 * @see     QHT_MosMikakuteiJyouhouKanri<br />
 * @see     GenQHT_MosMikakuteiJyouhouKanri<br />
 */
@Entity
public class HT_MosMikakuteiJyouhouKanri extends GenHT_MosMikakuteiJyouhouKanri {

    private static final long serialVersionUID = 1L;

    public HT_MosMikakuteiJyouhouKanri() {
    }

    public HT_MosMikakuteiJyouhouKanri(String pMosno) {
        super(pMosno);
    }



}

