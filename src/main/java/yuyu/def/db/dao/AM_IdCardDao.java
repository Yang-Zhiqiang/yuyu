package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AM_IdCard;
/**
 * ＩＤカードマスタ(AM_IdCardDao) アクセス用の DAO クラスです。<br />
 */
public class AM_IdCardDao extends AbstractDao<AM_IdCard> {

    public AM_IdCardDao() {
        super(AM_IdCard.class);
    }

    public AM_IdCard getIdCard(String pIdkbn, String pIdcd) {
        AM_IdCard aM_IdCard =  new AM_IdCard();
        aM_IdCard.setIdkbn(pIdkbn);
        aM_IdCard.setIdcd(pIdcd);
        return this.selectOne(aM_IdCard);
    }
}
