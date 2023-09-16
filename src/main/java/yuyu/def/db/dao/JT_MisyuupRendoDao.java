package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_MisyuupRendo;

/**
 * 未収Ｐ連動テーブル(JT_MisyuupRendoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_MisyuupRendoDao extends AbstractDao<JT_MisyuupRendo> {

    public JT_MisyuupRendoDao() {
        super(JT_MisyuupRendo.class);
    }

    public JT_MisyuupRendo getMisyuupRendo(String pSyono,
         Integer pDatarenno){
        JT_MisyuupRendo jT_MisyuupRendo =  new JT_MisyuupRendo();
        jT_MisyuupRendo.setSyono(pSyono);
        jT_MisyuupRendo.setDatarenno(pDatarenno);
        return this.selectOne(jT_MisyuupRendo);
    }
}
