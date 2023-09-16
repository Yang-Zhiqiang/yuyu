package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * 指数連動積増型年金積立金テーブル(IT_KhSisuurendoTmttknDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhSisuurendoTmttknDao extends AbstractDao<IT_KhSisuurendoTmttkn> {

    public IT_KhSisuurendoTmttknDao() {
        super(IT_KhSisuurendoTmttkn.class);
    }

    @Deprecated
    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttkn(String pSyono, BizDateYM pTmttkntaisyouym, Integer pRenno) {
        IT_KhSisuurendoTmttkn iT_KhSisuurendoTmttkn = new IT_KhSisuurendoTmttkn(pSyono, pTmttkntaisyouym, pRenno);
        return this.selectOne(iT_KhSisuurendoTmttkn);
    }

    @Override
    @Deprecated
    public List<IT_KhSisuurendoTmttkn> selectAll() {
        return super.selectAll();
    }

    public SisurendoTmttknInfoBean getSisurendoTmttknInfoBean(String pSyono, BizDate pCalcKijyunYmd) {


        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");


        String strSql = $SELECT + $NEW(SisurendoTmttknInfoBean.class,
            qIT_KhSisuurendoTmttkn.tmttkntaisyouym,
            qIT_KhSisuurendoTmttkn.teiritutmttkngk.getTypeFieldName(),
            qIT_KhSisuurendoTmttkn.teiritutmttkngk.getValueFieldName(),
            qIT_KhSisuurendoTmttkn.sisuurendoutmttkngk.getTypeFieldName(),
            qIT_KhSisuurendoTmttkn.sisuurendoutmttkngk.getValueFieldName(),
            qIT_KhSisuurendoTmttkn.tmttknhaneisisuu
            ) +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pCalcKijyunYmd) +
            $ORDER_BY(qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());


        return em.createJPQL(strSql, SisurendoTmttknInfoBean.class).setFirstResult(0).setMaxResults(1).bind(
            qIT_KhSisuurendoTmttkn).getSingleResult();

    }
}
