package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_KawaseRateData;
import yuyu.def.db.mapping.GenBT_KawaseRateData;
import yuyu.def.db.meta.GenQBT_KawaseRateData;
import yuyu.def.db.meta.QBT_KawaseRateData;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KwsrendouKbn;

/**
 * 為替レートデータテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KawaseRateData} の JavaDoc を参照してください。
 * @see     GenBT_KawaseRateData
 * @see     PKBT_KawaseRateData
 * @see     QBT_KawaseRateData
 * @see     GenQBT_KawaseRateData
 */
@Entity
public class BT_KawaseRateData extends GenBT_KawaseRateData {

    private static final long serialVersionUID = 1L;

    public BT_KawaseRateData() {
    }

    public BT_KawaseRateData(BizDate pKwsratekjymd, C_KwsrendouKbn pKwsrendoukbn) {
        super(pKwsratekjymd, pKwsrendoukbn);
    }

}
