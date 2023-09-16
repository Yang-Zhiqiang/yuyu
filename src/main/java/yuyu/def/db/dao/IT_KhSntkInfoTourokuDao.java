package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.meta.QIT_KhSntkInfoTouroku;

/**
 * 契約保全選択情報登録テーブル(IT_KhSntkInfoTourokuDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhSntkInfoTourokuDao extends AbstractDao<IT_KhSntkInfoTouroku> {

    public IT_KhSntkInfoTourokuDao() {
        super(IT_KhSntkInfoTouroku.class);
    }

    public IT_KhSntkInfoTouroku getKhSntkInfoTouroku(String pSyono,
        Integer pRenno){
        IT_KhSntkInfoTouroku iT_KhSntkInfoTouroku =  new IT_KhSntkInfoTouroku();
        iT_KhSntkInfoTouroku.setSyono(pSyono);
        iT_KhSntkInfoTouroku.setRenno(pRenno);
        return this.selectOne(iT_KhSntkInfoTouroku);
    }

    public List<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusBySyono(String pSyono) {

        IT_KhSntkInfoTouroku iT_KhSntkInfoTouroku = new IT_KhSntkInfoTouroku();
        iT_KhSntkInfoTouroku.setSyono(pSyono);
        return this.select(iT_KhSntkInfoTouroku);
    }

    public ExDBUpdatableResults<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(C_Syorizumiflg  pSyorizumiflg) {


        QIT_KhSntkInfoTouroku qIT_KhSntkInfoTouroku = new QIT_KhSntkInfoTouroku();

        String queryStr = $SELECT + qIT_KhSntkInfoTouroku +
            $FROM (qIT_KhSntkInfoTouroku) +
            $WHERE +  qIT_KhSntkInfoTouroku.syorizumiflg.eq(pSyorizumiflg);

        return em.createJPQL(queryStr).bind(qIT_KhSntkInfoTouroku).getUpdatableResults();
    }

    public Integer getKhSntkInfoTourokuMaxRennoBySyono(String pSyono) {


        QIT_KhSntkInfoTouroku qIT_KhSntkInfoTouroku = new QIT_KhSntkInfoTouroku();


        String querySql = $SELECT + $MAX(qIT_KhSntkInfoTouroku.renno) +
            $FROM + qIT_KhSntkInfoTouroku.IT_KhSntkInfoTouroku() +
            $WHERE + qIT_KhSntkInfoTouroku.syono.eq(pSyono);

        return em.createJPQL(querySql).bind(qIT_KhSntkInfoTouroku).getSingleResult();
    }
}
