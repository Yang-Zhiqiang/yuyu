package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.BV_SiharaiTyousyo;
import yuyu.def.db.meta.QBV_SiharaiTyousyo;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

/**
 * 支払調書ビュー(BV_SiharaiTyousyoDao) アクセス用の DAO クラスです。<br />
 */
public class BV_SiharaiTyousyoDao extends AbstractDao<BV_SiharaiTyousyo> {

    public BV_SiharaiTyousyoDao() {
        super(BV_SiharaiTyousyo.class);
    }

    public BV_SiharaiTyousyo getSiharaiTyousyo(String pSubSystemId, String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        BV_SiharaiTyousyo bV_SiharaiTyousyo =  new BV_SiharaiTyousyo();
        bV_SiharaiTyousyo.setSubSystemId(pSubSystemId);
        bV_SiharaiTyousyo.setSyono(pSyono);
        bV_SiharaiTyousyo.setTyouhyouymd(pTyouhyouymd);
        bV_SiharaiTyousyo.setShrtysyrenno(pShrtysyrenno);
        return this.selectOne(bV_SiharaiTyousyo);
    }

    public ExDBResults<BV_SiharaiTyousyo> getSiharaiTyousyosByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QBV_SiharaiTyousyo qBV_SiharaiTyousyo = new QBV_SiharaiTyousyo();

        String sql = $SELECT + qBV_SiharaiTyousyo +
            $FROM + qBV_SiharaiTyousyo.BV_SiharaiTyousyo() +
            $WHERE + qBV_SiharaiTyousyo.tyouhyouymd.eq(pSyoriYmd);

        return em.createJPQL(sql).bind(qBV_SiharaiTyousyo).getResults();
    }
}
