package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JW_HubiWk;

/**
 * 支払不備ワークテーブル(JW_HubiWkDao) アクセス用の DAO クラスです。<br />
 */
public class JW_HubiWkDao extends AbstractDao<JW_HubiWk> {

    public JW_HubiWkDao() {
        super(JW_HubiWk.class);
    }

    public JW_HubiWk getHubiWk(String pKouteikanriid){
        JW_HubiWk jW_HubiWk =  new JW_HubiWk();
        jW_HubiWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(jW_HubiWk);
    }
}
