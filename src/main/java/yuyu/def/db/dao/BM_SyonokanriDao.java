package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.db.meta.QBM_Syonokanri;

/**
 * 証券番号管理マスタ(BM_SyonokanriDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyonokanriDao extends AbstractDao<BM_Syonokanri> {

    public BM_SyonokanriDao() {
        super(BM_Syonokanri.class);
    }

    public BM_Syonokanri getSyonokanri(String pSeirekinen2keta,
        String pBosyuusosikicd,
        Integer pSyonorenno){
        BM_Syonokanri bM_Syonokanri =  new BM_Syonokanri();
        bM_Syonokanri.setSeirekinen2keta(pSeirekinen2keta);
        bM_Syonokanri.setBosyuusosikicd(pBosyuusosikicd);
        bM_Syonokanri.setSyonorenno(pSyonorenno);
        return this.selectOne(bM_Syonokanri);
    }

    public String getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(String pSeirekinen2keta) {
        QBM_Syonokanri qBM_Syonokanri = new QBM_Syonokanri();
        String strSql = $SELECT + $MAX(qBM_Syonokanri.bosyuusosikicd) +
            $FROM + qBM_Syonokanri.BM_Syonokanri() +
            $WHERE + qBM_Syonokanri.seirekinen2keta.eq(pSeirekinen2keta);
        return em.createJPQL(strSql).bind(qBM_Syonokanri).getSingleResult();
    }

    public String getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(String pSeirekinen2keta, BizDate pSaibanymd) {
        QBM_Syonokanri qBM_Syonokanri = new QBM_Syonokanri();
        String strSql = $SELECT + $MAX(qBM_Syonokanri.bosyuusosikicd) +
            $FROM + qBM_Syonokanri.BM_Syonokanri() +
            $WHERE + qBM_Syonokanri.seirekinen2keta.eq(pSeirekinen2keta) +
            $AND + qBM_Syonokanri.saibanymd.eq(pSaibanymd);
        return em.createJPQL(strSql).bind(qBM_Syonokanri).getSingleResult();
    }

    public Integer getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd) {
        QBM_Syonokanri qBM_Syonokanri = new QBM_Syonokanri();
        String strSql = $SELECT + $MAX(qBM_Syonokanri.syonorenno) +
            $FROM + qBM_Syonokanri.BM_Syonokanri() +
            $WHERE + qBM_Syonokanri.seirekinen2keta.eq(pSeirekinen2keta) +
            $AND + qBM_Syonokanri.bosyuusosikicd.eq(pBosyuusosikicd);

        return em.createJPQL(strSql).bind(qBM_Syonokanri).getSingleResult();
    }

    public List<BM_Syonokanri> getSyonokanrisBySyono(String pSyono) {

        BM_Syonokanri bM_Syonokanri = new BM_Syonokanri();
        bM_Syonokanri.setSyono(pSyono);
        return this.select(bM_Syonokanri);
    }
}
