package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_ToriatukaibiKbn;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.def.db.meta.QBM_TuukabetuKyuusibi;

/**
 * 通貨別取扱休止日マスタ(BM_TuukabetuKyuusibiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TuukabetuKyuusibiDao extends AbstractDao<BM_TuukabetuKyuusibi> {

    public BM_TuukabetuKyuusibiDao() {
        super(BM_TuukabetuKyuusibi.class);
    }

    public BM_TuukabetuKyuusibi getTuukabetuKyuusibi(BizDate pTuukatoriatukaiymd){
        BM_TuukabetuKyuusibi bM_TuukabetuKyuusibi =  new BM_TuukabetuKyuusibi();
        bM_TuukabetuKyuusibi.setTuukatoriatukaiymd(pTuukatoriatukaiymd);
        return this.selectOne(bM_TuukabetuKyuusibi);
    }

    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiusdkbnBlank(
        BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {


        QBM_TuukabetuKyuusibi qBM_TuukabetuKyuusibi = new QBM_TuukabetuKyuusibi();

        String mainQuerryStr = $SELECT + qBM_TuukabetuKyuusibi +
            $FROM + qBM_TuukabetuKyuusibi.BM_TuukabetuKyuusibi() +
            $WHERE + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.ge(pTyakkinyoteiymd) +
            $AND + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.le(pSyutokuendymd) +
            $AND + qBM_TuukabetuKyuusibi.kyuusiusdkbn.eq(C_ToriatukaibiKbn.BLNK) +
            $ORDER_BY(qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.asc());

        return em.createJPQL(mainQuerryStr).bind(qBM_TuukabetuKyuusibi).getResultList();
    }

    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusiaudkbnBlank(
        BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {


        QBM_TuukabetuKyuusibi qBM_TuukabetuKyuusibi = new QBM_TuukabetuKyuusibi();

        String mainQuerryStr = $SELECT + qBM_TuukabetuKyuusibi +
            $FROM + qBM_TuukabetuKyuusibi.BM_TuukabetuKyuusibi() +
            $WHERE + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.ge(pTyakkinyoteiymd) +
            $AND + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.le(pSyutokuendymd) +
            $AND + qBM_TuukabetuKyuusibi.kyuusiaudkbn.eq(C_ToriatukaibiKbn.BLNK) +
            $ORDER_BY(qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.asc());

        return em.createJPQL(mainQuerryStr).bind(qBM_TuukabetuKyuusibi).getResultList();
    }

    public List<BM_TuukabetuKyuusibi> getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank(
        BizDate pTyakkinyoteiymd, BizDate pSyutokuendymd) {


        QBM_TuukabetuKyuusibi qBM_TuukabetuKyuusibi = new QBM_TuukabetuKyuusibi();

        String mainQuerryStr = $SELECT + qBM_TuukabetuKyuusibi +
            $FROM + qBM_TuukabetuKyuusibi.BM_TuukabetuKyuusibi() +
            $WHERE + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.ge(pTyakkinyoteiymd) +
            $AND + qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.le(pSyutokuendymd) +
            $AND + qBM_TuukabetuKyuusibi.kyuusieurkbn.eq(C_ToriatukaibiKbn.BLNK) +
            $ORDER_BY(qBM_TuukabetuKyuusibi.tuukatoriatukaiymd.asc());

        return em.createJPQL(mainQuerryStr).bind(qBM_TuukabetuKyuusibi).getResultList();
    }
}
