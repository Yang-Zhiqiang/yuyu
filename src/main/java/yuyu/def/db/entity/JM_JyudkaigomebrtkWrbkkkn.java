package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.mapping.GenJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.GenQJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.QJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.classification.C_Seibetu;

/**
 * 重度介護前払特約割引期間マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_JyudkaigomebrtkWrbkkkn} の JavaDoc を参照してください。
 * @see     GenJM_JyudkaigomebrtkWrbkkkn
 * @see     PKJM_JyudkaigomebrtkWrbkkkn
 * @see     QJM_JyudkaigomebrtkWrbkkkn
 * @see     GenQJM_JyudkaigomebrtkWrbkkkn
 */
@Entity
public class JM_JyudkaigomebrtkWrbkkkn extends GenJM_JyudkaigomebrtkWrbkkkn {

    private static final long serialVersionUID = 1L;

    public JM_JyudkaigomebrtkWrbkkkn() {
    }

    public JM_JyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {
        super(pHhknnen, pSeibetu);
    }

}
