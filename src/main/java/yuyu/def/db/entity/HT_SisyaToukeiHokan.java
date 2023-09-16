package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_SisyaToukeiHokan;
import yuyu.def.db.mapping.GenHT_SisyaToukeiHokan;
import yuyu.def.db.meta.GenQHT_SisyaToukeiHokan;
import yuyu.def.db.meta.QHT_SisyaToukeiHokan;

/**
 * 支社統計保管テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SisyaToukeiHokan} の JavaDoc を参照してください。
 * @see     GenHT_SisyaToukeiHokan
 * @see     PKHT_SisyaToukeiHokan
 * @see     QHT_SisyaToukeiHokan
 * @see     GenQHT_SisyaToukeiHokan
 */
@Entity
public class HT_SisyaToukeiHokan extends GenHT_SisyaToukeiHokan {

    private static final long serialVersionUID = 1L;

    public HT_SisyaToukeiHokan() {
    }

    public HT_SisyaToukeiHokan(String pSstmosno, Integer pRenno) {
        super(pSstmosno, pRenno);
    }

}
