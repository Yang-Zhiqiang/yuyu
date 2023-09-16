package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_GyoumuKey;
import yuyu.def.db.mapping.GenWT_GyoumuKey;
import yuyu.def.db.meta.GenQWT_GyoumuKey;
import yuyu.def.db.meta.QWT_GyoumuKey;

/**
 * 業務キーテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_GyoumuKey} の JavaDoc を参照してください。
 * @see     GenWT_GyoumuKey
 * @see     PKWT_GyoumuKey
 * @see     QWT_GyoumuKey
 * @see     GenQWT_GyoumuKey
 */
@Entity
public class WT_GyoumuKey extends GenWT_GyoumuKey {

    private static final long serialVersionUID = 1L;

    public WT_GyoumuKey() {
    }

    public WT_GyoumuKey(String pFlowId, String pGyoumuKey) {
        super(pFlowId, pGyoumuKey);
    }

}
