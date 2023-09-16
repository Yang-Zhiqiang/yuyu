package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_SkDenpyoData;


/**
 * 新契約伝票データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkDenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkDenpyoData<br />
 * @see     PKHT_SkDenpyoData<br />
 * @see     QHT_SkDenpyoData<br />
 * @see     GenQHT_SkDenpyoData<br />
 */
@Entity
public class HT_SkDenpyoData extends GenHT_SkDenpyoData {

    private static final long serialVersionUID = 1L;

    public HT_SkDenpyoData() {
    }

    public HT_SkDenpyoData(String pDenrenno,Integer pEdano) {
        super(pDenrenno,pEdano);
    }



}

