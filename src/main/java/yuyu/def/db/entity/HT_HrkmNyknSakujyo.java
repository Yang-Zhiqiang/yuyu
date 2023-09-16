package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_HrkmNyknSakujyo;
import yuyu.def.db.mapping.GenHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.GenQHT_HrkmNyknSakujyo;
import yuyu.def.db.meta.QHT_HrkmNyknSakujyo;

/**
 * 振込入金削除テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_HrkmNyknSakujyo} の JavaDoc を参照してください。
 * @see     GenHT_HrkmNyknSakujyo
 * @see     PKHT_HrkmNyknSakujyo
 * @see     QHT_HrkmNyknSakujyo
 * @see     GenQHT_HrkmNyknSakujyo
 */
@Entity
public class HT_HrkmNyknSakujyo extends GenHT_HrkmNyknSakujyo {

    private static final long serialVersionUID = 1L;

    public HT_HrkmNyknSakujyo() {
    }

    public HT_HrkmNyknSakujyo(String pHrkmdeldataskbtkey) {
        super(pHrkmdeldataskbtkey);
    }

}
