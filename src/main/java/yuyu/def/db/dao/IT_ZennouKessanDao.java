package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IT_ZennouKessan;

/**
 * 前納決算テーブル(IT_ZennouKessanDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ZennouKessanDao extends AbstractDao<IT_ZennouKessan> {

    public IT_ZennouKessanDao() {
        super(IT_ZennouKessan.class);
    }

    public IT_ZennouKessan getZennouKessan(String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn, BizDateYM pZennoustartym) {
        IT_ZennouKessan iT_ZennouKessan =  new IT_ZennouKessan();
        iT_ZennouKessan.setSyono(pSyono);
        iT_ZennouKessan.setSakuseiymd(pSakuseiymd);
        iT_ZennouKessan.setKbnkeirisegcd(pKbnkeirisegcd);
        iT_ZennouKessan.setZennoukbn(pZennoukbn);
        iT_ZennouKessan.setZennoutoukeilistkbn(pZennoutoukeilistkbn);
        iT_ZennouKessan.setZennoustartym(pZennoustartym);
        return this.selectOne(iT_ZennouKessan);
    }
}
