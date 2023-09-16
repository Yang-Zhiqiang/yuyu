package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;

/**
 * 保険料積立金テーブル(IT_HokenryouTmttknDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HokenryouTmttknDao extends AbstractDao<IT_HokenryouTmttkn> {

    public IT_HokenryouTmttknDao() {
        super(IT_HokenryouTmttkn.class);
    }

    public IT_HokenryouTmttkn getHokenryouTmttkn(String pSyono, BizDateYM pTmttkntaisyouym, Integer pRenno) {
        IT_HokenryouTmttkn iT_HokenryouTmttkn =  new IT_HokenryouTmttkn( pSyono,  pTmttkntaisyouym,  pRenno);
        return this.selectOne(iT_HokenryouTmttkn);
    }

    public IT_HokenryouTmttkn getHokenryouTmttknBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {


        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn("qIT_HokenryouTmttkn");


        String strSql = $SELECT + qIT_HokenryouTmttkn +
            $FROM(qIT_HokenryouTmttkn) +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.tmttkntaisyouym.le(pTmttkntaisyouym) +
            $ORDER_BY(qIT_HokenryouTmttkn.tmttkntaisyouym.desc(),
                qIT_HokenryouTmttkn.renno.desc());


        return em.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(
            qIT_HokenryouTmttkn).getSingleResult();
    }

    public Integer getHokenryouTmttknMaxRennoBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttkntaisyouym) {


        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn("qIT_HokenryouTmttkn");


        String mainStr = $SELECT + $MAX(qIT_HokenryouTmttkn.renno) +
            $FROM(qIT_HokenryouTmttkn) +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.tmttkntaisyouym.eq(pTmttkntaisyouym);


        return em.createJPQL(mainStr).bind(qIT_HokenryouTmttkn).getSingleResult();
    }
}
