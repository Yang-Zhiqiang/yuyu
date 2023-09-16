package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JW_HubiDetailWk;

/**
 * 支払不備詳細ワークテーブル(JW_HubiDetailWkDao) アクセス用の DAO クラスです。<br />
 */
public class JW_HubiDetailWkDao extends AbstractDao<JW_HubiDetailWk> {

    public JW_HubiDetailWkDao() {
        super(JW_HubiDetailWk.class);
    }

    @Deprecated
    public JW_HubiDetailWk getHubiDetailWk(String pKouteikanriid,
         Integer pRenno3keta){
        JW_HubiDetailWk jW_HubiDetailWk =  new JW_HubiDetailWk();
        jW_HubiDetailWk.setKouteikanriid(pKouteikanriid);
        jW_HubiDetailWk.setRenno3keta(pRenno3keta);
        return this.selectOne(jW_HubiDetailWk);
    }

    @Override
    @Deprecated
    public List<JW_HubiDetailWk> selectAll() {
        return super.selectAll();
    }
}
