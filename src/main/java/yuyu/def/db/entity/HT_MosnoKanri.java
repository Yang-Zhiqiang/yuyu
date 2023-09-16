package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_MosnoKanri;


/**
 * 申込番号管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosnoKanri} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosnoKanri<br />
 * @see     PKHT_MosnoKanri<br />
 * @see     QHT_MosnoKanri<br />
 * @see     GenQHT_MosnoKanri<br />
 */
@Entity
public class HT_MosnoKanri extends GenHT_MosnoKanri {

    private static final long serialVersionUID = 1L;

    public HT_MosnoKanri() {
    }

    public HT_MosnoKanri(String pMosno8keta) {
        super(pMosno8keta);
    }



}

