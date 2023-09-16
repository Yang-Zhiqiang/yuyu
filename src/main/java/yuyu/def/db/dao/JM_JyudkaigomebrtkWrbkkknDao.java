package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;

/**
 * 重度介護前払特約割引期間マスタ(JM_JyudkaigomebrtkWrbkkknDao) アクセス用の DAO クラスです。<br />
 */
public class JM_JyudkaigomebrtkWrbkkknDao extends AbstractDao<JM_JyudkaigomebrtkWrbkkkn> {

    public JM_JyudkaigomebrtkWrbkkknDao() {
        super(JM_JyudkaigomebrtkWrbkkkn.class);
    }

    public JM_JyudkaigomebrtkWrbkkkn getJyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {
        JM_JyudkaigomebrtkWrbkkkn jM_JyudkaigomebrtkWrbkkkn =  new JM_JyudkaigomebrtkWrbkkkn();
        jM_JyudkaigomebrtkWrbkkkn.setHhknnen(pHhknnen);
        jM_JyudkaigomebrtkWrbkkkn.setSeibetu(pSeibetu);
        return this.selectOne(jM_JyudkaigomebrtkWrbkkkn);
    }
}
