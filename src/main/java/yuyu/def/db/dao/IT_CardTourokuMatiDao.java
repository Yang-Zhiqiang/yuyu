package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_CardTourokuMati;

/**
 * カード情報登録待ちテーブル(IT_CardTourokuMatiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_CardTourokuMatiDao extends AbstractDao<IT_CardTourokuMati> {

    public IT_CardTourokuMatiDao() {
        super(IT_CardTourokuMati.class);
    }

    public IT_CardTourokuMati getCardTourokuMati(String pKouteikanriid) {
        IT_CardTourokuMati iT_CardTourokuMati =  new IT_CardTourokuMati();
        iT_CardTourokuMati.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iT_CardTourokuMati);
    }
}
