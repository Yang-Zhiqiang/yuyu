package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_SkLincSousinData;
import yuyu.def.db.mapping.GenHT_SkLincSousinData;
import yuyu.def.db.meta.GenQHT_SkLincSousinData;
import yuyu.def.db.meta.QHT_SkLincSousinData;
import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約ＬＩＮＣ送信データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincSousinData} の JavaDoc を参照してください。
 * @see     GenHT_SkLincSousinData
 * @see     PKHT_SkLincSousinData
 * @see     QHT_SkLincSousinData
 * @see     GenQHT_SkLincSousinData
 */
@Entity
public class HT_SkLincSousinData extends GenHT_SkLincSousinData {

    private static final long serialVersionUID = 1L;

    public HT_SkLincSousinData() {
    }

    public HT_SkLincSousinData(
        String pMosno,
        BizDate pSyoriYmd,
        Integer pRenno
    ) {
        super(
            pMosno,
            pSyoriYmd,
            pRenno
        );
    }

}
