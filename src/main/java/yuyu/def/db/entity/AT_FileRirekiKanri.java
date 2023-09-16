package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_FileRirekiKanri;
import yuyu.def.db.mapping.GenAT_FileRirekiKanri;
import yuyu.def.db.meta.GenQAT_FileRirekiKanri;
import yuyu.def.db.meta.QAT_FileRirekiKanri;

/**
 * ファイル履歴管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_FileRirekiKanri} の JavaDoc を参照してください。
 * @see     GenAT_FileRirekiKanri
 * @see     PKAT_FileRirekiKanri
 * @see     QAT_FileRirekiKanri
 * @see     GenQAT_FileRirekiKanri
 */
@Entity
public class AT_FileRirekiKanri extends GenAT_FileRirekiKanri {

    private static final long serialVersionUID = 1L;

    public AT_FileRirekiKanri() {
    }

    public AT_FileRirekiKanri(String pHistoryId) {
        super(pHistoryId);
    }

}
