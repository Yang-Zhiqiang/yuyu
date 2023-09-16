package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_KobetuInfo;
import yuyu.def.db.mapping.GenAT_KobetuInfo;
import yuyu.def.db.meta.GenQAT_KobetuInfo;
import yuyu.def.db.meta.QAT_KobetuInfo;

/**
 * 個別情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_KobetuInfo} の JavaDoc を参照してください。
 * @see     GenAT_KobetuInfo
 * @see     PKAT_KobetuInfo
 * @see     QAT_KobetuInfo
 * @see     GenQAT_KobetuInfo
 */
@Entity
public class AT_KobetuInfo extends GenAT_KobetuInfo {

    private static final long serialVersionUID = 1L;

    public AT_KobetuInfo() {
    }

    public AT_KobetuInfo(String pUserId, String pInfoSeqNo) {
        super(pUserId, pInfoSeqNo);
    }
}
