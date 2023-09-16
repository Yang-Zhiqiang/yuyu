package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_TestKykData;
import yuyu.def.db.mapping.GenBT_TestKykData;
import yuyu.def.db.meta.GenQBT_TestKykData;
import yuyu.def.db.meta.QBT_TestKykData;

/**
 * テスト用契約データ抽出テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TestKykData} の JavaDoc を参照してください。
 * @see     GenBT_TestKykData
 * @see     PKBT_TestKykData
 * @see     QBT_TestKykData
 * @see     GenQBT_TestKykData
 */
@Entity
public class BT_TestKykData extends GenBT_TestKykData {

    private static final long serialVersionUID = 1L;

    public BT_TestKykData() {
    }

    public BT_TestKykData(String pUniqueId) {
        super(pUniqueId);
    }

}
