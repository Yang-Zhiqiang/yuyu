package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHW_SikinIdouWk;
import yuyu.def.db.mapping.GenHW_SikinIdouWk;
import yuyu.def.db.meta.GenQHW_SikinIdouWk;
import yuyu.def.db.meta.QHW_SikinIdouWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * 資金移動ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHW_SikinIdouWk} の JavaDoc を参照してください。
 * @see     GenHW_SikinIdouWk
 * @see     PKHW_SikinIdouWk
 * @see     QHW_SikinIdouWk
 * @see     GenQHW_SikinIdouWk
 */
@Entity
public class HW_SikinIdouWk extends GenHW_SikinIdouWk {

    private static final long serialVersionUID = 1L;

    public HW_SikinIdouWk() {
    }

    public HW_SikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {
        super(pNyksyoriymd, pItirenno);
    }

}
