package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_Mouside;

/**
 * 申出テーブル(JT_MousideDao) アクセス用の DAO クラスです。<br />
 */
public class JT_MousideDao extends AbstractDao<JT_Mouside> {

    public JT_MousideDao() {
        super(JT_Mouside.class);
    }

    @Deprecated
    public JT_Mouside getMouside(String pSkno,
         String pSyono){
        JT_Mouside jT_Mouside =  new JT_Mouside();
        jT_Mouside.setSkno(pSkno);
        jT_Mouside.setSyono(pSyono);
        return this.selectOne(jT_Mouside);
    }

    @Override
    @Deprecated
    public List<JT_Mouside> selectAll() {
        return super.selectAll();
    }
}
