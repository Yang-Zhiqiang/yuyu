package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAT_SystemControlInfo;
import yuyu.def.db.mapping.GenAT_SystemControlInfo;
import yuyu.def.db.meta.GenQAT_SystemControlInfo;
import yuyu.def.db.meta.QAT_SystemControlInfo;

/**
 * システム制御情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_SystemControlInfo} の JavaDoc を参照してください。
 * @see     GenAT_SystemControlInfo
 * @see     PKAT_SystemControlInfo
 * @see     QAT_SystemControlInfo
 * @see     GenQAT_SystemControlInfo
 */
@Entity
public class AT_SystemControlInfo extends GenAT_SystemControlInfo {

    private static final long serialVersionUID = 1L;

    public AT_SystemControlInfo() {
    }

    public AT_SystemControlInfo(String pSystemCtrlInfo) {
        super(pSystemCtrlInfo);
    }

}
