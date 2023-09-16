package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_FileRireki;
import yuyu.def.db.mapping.GenAT_FileRireki;
import yuyu.def.db.meta.GenQAT_FileRireki;
import yuyu.def.db.meta.QAT_FileRireki;

/**
 * ファイル履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileRireki} の JavaDoc を参照してください。
 * @see     GenAT_FileRireki
 * @see     PKAT_FileRireki
 * @see     QAT_FileRireki
 * @see     GenQAT_FileRireki
 */
@Entity
public class AT_FileRireki extends GenAT_FileRireki {

    private static final long serialVersionUID = 1L;

    public AT_FileRireki() {
    }

    public AT_FileRireki(
        String pUniqueId,
        String pHistoryId,
        String pTourokuTime,
        Integer pFileNmSuffix
        ) {
        super(
            pUniqueId,
            pHistoryId,
            pTourokuTime,
            pFileNmSuffix
            );
    }

}
