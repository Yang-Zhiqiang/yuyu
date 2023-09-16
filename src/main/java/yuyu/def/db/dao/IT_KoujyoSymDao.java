package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.meta.QIT_KoujyoSym;
/**
 * 控除証明書テーブル(IT_KoujyoSymDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KoujyoSymDao extends AbstractDao<IT_KoujyoSym> {

    public IT_KoujyoSymDao() {
        super(IT_KoujyoSym.class);
    }

    @Deprecated
    public IT_KoujyoSym getKoujyoSym(String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno){
        IT_KoujyoSym iT_KoujyoSym =  new IT_KoujyoSym();
        iT_KoujyoSym.setSyono(pSyono);
        iT_KoujyoSym.setNendo(pNendo);
        iT_KoujyoSym.setTyouhyouymd(pTyouhyouymd);
        iT_KoujyoSym.setRenno(pRenno);
        return this.selectOne(iT_KoujyoSym);
    }

    @Override
    @Deprecated
    public List<IT_KoujyoSym> selectAll() {
        return super.selectAll();
    }

    public Integer getKoujyoSymMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {


        QIT_KoujyoSym qIT_KoujyoSym = new QIT_KoujyoSym();


        String querySql = $SELECT + $MAX(qIT_KoujyoSym.renno) +
            $FROM + qIT_KoujyoSym.IT_KoujyoSym() +
            $WHERE + qIT_KoujyoSym.syono.eq(pSyono) +
            $AND + qIT_KoujyoSym.nendo.eq(pNendo) +
            $AND + qIT_KoujyoSym.tyouhyouymd.eq(pTyouhyouymd);

        return em.createJPQL(querySql).bind(qIT_KoujyoSym).getSingleResult();

    }

    public List<String> getKoujyoSymNendosBySyono(String pSyono) {


        QIT_KoujyoSym qIT_KoujyoSym = new QIT_KoujyoSym();


        String querySql = $SELECT_DISTINCT + qIT_KoujyoSym.nendo +
            $FROM + qIT_KoujyoSym.IT_KoujyoSym() +
            $WHERE + qIT_KoujyoSym.syono.eq(pSyono) +
            $ORDER_BY(qIT_KoujyoSym.nendo.desc());

        return em.createJPQL(querySql).bind(qIT_KoujyoSym).getResultList();

    }

    public Long getKoujyoSymCountBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {


        QIT_KoujyoSym qIT_KoujyoSym = new QIT_KoujyoSym();

        String quertSql = $SELECT + $COUNT +"(" +qIT_KoujyoSym.syono +")"+
            $FROM + qIT_KoujyoSym.IT_KoujyoSym() +
            $WHERE + qIT_KoujyoSym.syono.eq(pSyono) +
            $AND + qIT_KoujyoSym.nendo.eq(pNendo) +
            $AND + qIT_KoujyoSym.tyouhyouymd.eq(pTyouhyouymd);

        return em.createJPQL(quertSql).bind(qIT_KoujyoSym).getSingleResult();
    }

    public ExDBResults<IT_KoujyoSym> getKoujyoSymsByKakutyoujobcdTyouhyouymd(BizDate pTyouhyouymd) {


        QIT_KoujyoSym qIT_KoujyoSym = new QIT_KoujyoSym();


        String strSql = $SELECT + qIT_KoujyoSym +
            $FROM (qIT_KoujyoSym) +
            $WHERE + qIT_KoujyoSym.tyouhyouymd.eq(pTyouhyouymd)+
            $AND + qIT_KoujyoSym.kjsmsakuseisyorikbn.eq(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);


        return em.createJPQL(strSql).bind(qIT_KoujyoSym).getResults();
    }
}
