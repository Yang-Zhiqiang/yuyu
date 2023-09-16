package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_SkLincJyusinData;
import yuyu.def.db.mapping.GenHT_SkLincJyusinData;
import yuyu.def.db.meta.GenQHT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;
import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約ＬＩＮＣ受信データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincJyusinData} の JavaDoc を参照してください。
 * @see     GenHT_SkLincJyusinData
 * @see     PKHT_SkLincJyusinData
 * @see     QHT_SkLincJyusinData
 * @see     GenQHT_SkLincJyusinData
 */
@Entity
public class HT_SkLincJyusinData extends GenHT_SkLincJyusinData {

    private static final long serialVersionUID = 1L;

    public HT_SkLincJyusinData() {
    }

    public HT_SkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {
        super(pSyoriYmd, pLinckyknaiykekdatarenno);
    }

}
