package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNkgnsHonken;
import yuyu.def.db.meta.QBM_ChkNkgnsHonken;

/**
 * 年金原資本件チェックマスタ(BM_ChkNkgnsHonkenDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNkgnsHonkenDao extends AbstractDao<BM_ChkNkgnsHonken> {

    public BM_ChkNkgnsHonkenDao() {
        super(BM_ChkNkgnsHonken.class);
    }

    @Deprecated
    public BM_ChkNkgnsHonken getChkNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkNkgnsHonken bM_ChkNkgnsHonken =  new BM_ChkNkgnsHonken();
        bM_ChkNkgnsHonken.setSyouhncd(pSyouhncd);
        bM_ChkNkgnsHonken.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkNkgnsHonken.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkNkgnsHonken.setHhknfromnen(pHhknfromnen);
        bM_ChkNkgnsHonken.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkNkgnsHonken);
    }

    @Override
    @Deprecated
    public List<BM_ChkNkgnsHonken> selectAll() {
        return super.selectAll();
    }

    public List<BM_ChkNkgnsHonken> getChkNkgnsHonkenByPk(String pSyouhncd, Integer pSyouhnsdno, Integer pHhknnen) {


        QBM_ChkNkgnsHonken qBM_ChkNkgnsHonken = new QBM_ChkNkgnsHonken("qBM_ChkNkgnsHonken");


        String strSql = $SELECT + qBM_ChkNkgnsHonken +
            $FROM(qBM_ChkNkgnsHonken) +
            $WHERE + qBM_ChkNkgnsHonken.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkNkgnsHonken.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkNkgnsHonken.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkNkgnsHonken.hhknfromnen.le(BizNumber.valueOf(pHhknnen)) +
            $AND + qBM_ChkNkgnsHonken.hhkntonen.ge(BizNumber.valueOf(pHhknnen));


        return em.createJPQL(strSql).bind(qBM_ChkNkgnsHonken).getResultList();
    }
}
