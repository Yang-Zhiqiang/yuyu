package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.IT_KessanZennou;

/**
 * 決算用前納テーブル(IT_KessanZennouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KessanZennouDao extends AbstractDao<IT_KessanZennou> {

    public IT_KessanZennouDao() {
        super(IT_KessanZennou.class);
    }

    public IT_KessanZennou getKessanZennou(String pSyono, C_Segcd pKbnkeirisegcd, String pZennoukbn, String pZennoutoukeilistkbn, BizDateYM pZennoustartym) {
        IT_KessanZennou iT_KessanZennou =  new IT_KessanZennou( pSyono,  pKbnkeirisegcd,  pZennoukbn,  pZennoutoukeilistkbn,  pZennoustartym);
        return this.selectOne(iT_KessanZennou);
    }

}
