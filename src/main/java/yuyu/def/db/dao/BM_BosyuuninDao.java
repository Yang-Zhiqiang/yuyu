package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.meta.QBM_Bosyuunin;

/**
 * 募集人マスタ(BM_BosyuuninDao) アクセス用の DAO クラスです。<br />
 */
public class BM_BosyuuninDao extends AbstractDao<BM_Bosyuunin> {

    public BM_BosyuuninDao() {
        super(BM_Bosyuunin.class);
    }

    public BM_Bosyuunin getBosyuunin(String pBosyuucd) {
        BM_Bosyuunin bM_Bosyuunin =  new BM_Bosyuunin();
        bM_Bosyuunin.setBosyuucd(pBosyuucd);
        return this.selectOne(bM_Bosyuunin);
    }

    public List<BM_Bosyuunin> getBosyuuninByBosyuutrkno(String pBosyuutrkno) {


        QBM_Bosyuunin qBM_Bosyuunin = new QBM_Bosyuunin();

        String sql = $SELECT + qBM_Bosyuunin +
            $FROM + qBM_Bosyuunin.BM_Bosyuunin() +
            $WHERE + qBM_Bosyuunin.bosyuutrkno.eq(pBosyuutrkno) +
            $ORDER_BY(qBM_Bosyuunin.bosyuuningyouhaiymd.desc() + "," +
                qBM_Bosyuunin.bosyuucd.asc());

        return em.createJPQL(sql).bind(qBM_Bosyuunin).getResultList();
    }
}
