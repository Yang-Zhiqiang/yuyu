package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JM_Kyuuhu;

/**
 * 給付マスタ(JM_KyuuhuDao) アクセス用の DAO クラスです。<br />
 */
public class JM_KyuuhuDao extends AbstractDao<JM_Kyuuhu> {

    public JM_KyuuhuDao() {
        super(JM_Kyuuhu.class);
    }

    public JM_Kyuuhu getKyuuhu(String pKyuuhucd){
        JM_Kyuuhu jM_Kyuuhu =  new JM_Kyuuhu();
        jM_Kyuuhu.setKyuuhucd(pKyuuhucd);
        return this.selectOne(jM_Kyuuhu);
    }
}
