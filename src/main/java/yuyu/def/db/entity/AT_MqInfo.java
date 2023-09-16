package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAT_MqInfo;
import yuyu.def.db.mapping.GenAT_MqInfo;
import yuyu.def.db.meta.GenQAT_MqInfo;
import yuyu.def.db.meta.QAT_MqInfo;

/**
 * ＭＱ情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_MqInfo} の JavaDoc を参照してください。
 * @see     GenAT_MqInfo
 * @see     PKAT_MqInfo
 * @see     QAT_MqInfo
 * @see     GenQAT_MqInfo
 */
@Entity
public class AT_MqInfo extends GenAT_MqInfo {

    private static final long serialVersionUID = 1L;

    public AT_MqInfo() {
    }

    public AT_MqInfo(String pServerType) {
        super(pServerType);
    }

}
