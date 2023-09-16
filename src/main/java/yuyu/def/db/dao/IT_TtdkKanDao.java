package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.meta.QIT_TtdkKan;

/**
 * 手続完了テーブル(IT_TtdkKanDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TtdkKanDao extends AbstractDao<IT_TtdkKan> {

    public IT_TtdkKanDao() {
        super(IT_TtdkKan.class);
    }

    @Deprecated
    public IT_TtdkKan getTtdkKan(String pSyono,
            String pHenkousikibetukey){
        IT_TtdkKan iT_TtdkKan =  new IT_TtdkKan();
        iT_TtdkKan.setSyono(pSyono);
        iT_TtdkKan.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_TtdkKan);
    }

    public ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(BizDate pTyouhyouymd, C_SyoruiCdKbn... pSyoruiCd) {


        QIT_TtdkKan qIT_TtdkKan = new QIT_TtdkKan();


        String strSql = $SELECT + qIT_TtdkKan +
                $FROM + qIT_TtdkKan.IT_TtdkKan() +
                $WHERE + qIT_TtdkKan.tyouhyouymd.eq(pTyouhyouymd) +
                $AND + qIT_TtdkKan.syoruiCd.in(pSyoruiCd);


        return em.createJPQL(strSql).bind(qIT_TtdkKan).getResults();
    }

    public ExDBResults<IT_TtdkKan> getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(BizDate pTyouhyouymd, C_SyoruiCdKbn pSyoruiCd) {


        QIT_TtdkKan qIT_TtdkKan = new QIT_TtdkKan();


        String strSql = $SELECT + qIT_TtdkKan +
                $FROM + qIT_TtdkKan.IT_TtdkKan() +
                $WHERE + qIT_TtdkKan.tyouhyouymd.eq(pTyouhyouymd) +
                $AND + qIT_TtdkKan.syoruiCd.eq(pSyoruiCd);


        return em.createJPQL(strSql).bind(qIT_TtdkKan).getResults();
    }

    @Override
    @Deprecated
    public List<IT_TtdkKan> selectAll() {
        return super.selectAll();
    }
}
