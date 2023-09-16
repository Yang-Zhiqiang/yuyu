package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.db.entity.JT_SiUkt;

/**
 * 支払受取人テーブル(JT_SiUktDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiUktDao extends AbstractDao<JT_SiUkt> {

    public JT_SiUktDao() {
        super(JT_SiUkt.class);
    }

    @Deprecated
    public JT_SiUkt getSiUkt(String pSyono,
         C_Hkuktsyu pHkuktsyu,
         Integer pUktsyurenno){
        JT_SiUkt jT_SiUkt =  new JT_SiUkt();
        jT_SiUkt.setSyono(pSyono);
        jT_SiUkt.setHkuktsyu(pHkuktsyu);
        jT_SiUkt.setUktsyurenno(pUktsyurenno);
        return this.selectOne(jT_SiUkt);
    }

    @Override
    @Deprecated
    public List<JT_SiUkt> selectAll() {
        return super.selectAll();
    }
}
