package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_YendthnkSikinIdouData;
import yuyu.def.db.mapping.GenBT_YendthnkSikinIdouData;
import yuyu.def.db.meta.GenQBT_YendthnkSikinIdouData;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouData;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 円建変更資金移動データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_YendthnkSikinIdouData} の JavaDoc を参照してください。
 * @see     GenBT_YendthnkSikinIdouData
 * @see     PKBT_YendthnkSikinIdouData
 * @see     QBT_YendthnkSikinIdouData
 * @see     GenQBT_YendthnkSikinIdouData
 */
@Entity
public class BT_YendthnkSikinIdouData extends GenBT_YendthnkSikinIdouData {

    private static final long serialVersionUID = 1L;

    public BT_YendthnkSikinIdouData() {
    }

    public BT_YendthnkSikinIdouData(
        String pSyono,
        C_KeiriyendthnkKbn pKeiriyendthnkkbn,
        BizDate pSyoriYmd
    ) {
        super(
            pSyono,
            pKeiriyendthnkkbn,
            pSyoriYmd
        );
    }

}
