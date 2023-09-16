package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;

/**
 * 支払不備解消詳細ワークテーブル(JW_HubiKaisyouDetailWkDao) アクセス用の DAO クラスです。<br />
 */
public class JW_HubiKaisyouDetailWkDao extends AbstractDao<JW_HubiKaisyouDetailWk> {

    public JW_HubiKaisyouDetailWkDao() {
        super(JW_HubiKaisyouDetailWk.class);
    }

    public JW_HubiKaisyouDetailWk getHubiKaisyouDetailWk(String pKouteikanriid,
        Integer pRenno3keta){
        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk =  new JW_HubiKaisyouDetailWk();
        jW_HubiKaisyouDetailWk.setKouteikanriid(pKouteikanriid);
        jW_HubiKaisyouDetailWk.setRenno3keta(pRenno3keta);
        return this.selectOne(jW_HubiKaisyouDetailWk);
    }

    public List<JW_HubiKaisyouDetailWk> getHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid) {


        JW_HubiKaisyouDetailWk jW_HubiKaisyouDetailWk = new JW_HubiKaisyouDetailWk();

        jW_HubiKaisyouDetailWk.setKouteikanriid(pKouteikanriid);


        return this.select(jW_HubiKaisyouDetailWk);
    }
}
