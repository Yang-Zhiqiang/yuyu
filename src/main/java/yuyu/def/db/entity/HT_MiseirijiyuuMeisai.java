package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_MiseirijiyuuMeisai;
import yuyu.def.db.mapping.GenHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.GenQHT_MiseirijiyuuMeisai;
import yuyu.def.db.meta.QHT_MiseirijiyuuMeisai;

/**
 * 未整理事由別明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MiseirijiyuuMeisai} の JavaDoc を参照してください。
 * @see     GenHT_MiseirijiyuuMeisai
 * @see     PKHT_MiseirijiyuuMeisai
 * @see     QHT_MiseirijiyuuMeisai
 * @see     GenQHT_MiseirijiyuuMeisai
 */
@Entity
public class HT_MiseirijiyuuMeisai extends GenHT_MiseirijiyuuMeisai {

    private static final long serialVersionUID = 1L;

    public HT_MiseirijiyuuMeisai() {
    }

    public HT_MiseirijiyuuMeisai(String pMosno) {
        super(pMosno);
    }

}
