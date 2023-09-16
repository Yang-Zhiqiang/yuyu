package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;

/**
 * 契約保全変更受付テーブル(IT_KhHenkouUktkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenkouUktkDao extends AbstractDao<IT_KhHenkouUktk> {

    public IT_KhHenkouUktkDao() {
        super(IT_KhHenkouUktk.class);
    }

    public IT_KhHenkouUktk getKhHenkouUktk(String pSyono, Integer pHozenhenkouuktkrenno) {
        IT_KhHenkouUktk iT_KhHenkouUktk =  new IT_KhHenkouUktk();
        iT_KhHenkouUktk.setSyono(pSyono);
        iT_KhHenkouUktk.setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
        return this.selectOne(iT_KhHenkouUktk);
    }

    public List<IT_KhHenkouUktk> getKhHenkouUktksBySyono(String pSyono) {


        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String mainStry = $SELECT + qIT_KhHenkouUktk +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.in(C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.SYORIZUMI) +
            $ORDER_BY (qIT_KhHenkouUktk.hozenhenkouuktkrenno.desc());

        return em.createJPQL(mainStry).bind(qIT_KhHenkouUktk).getResultList();
    }

    public List<IT_KhHenkouUktk> getKhHenkouUktksBySyono1(String pSyono) {

        IT_KhHenkouUktk iT_KhHenkouUktk =  new IT_KhHenkouUktk();
        iT_KhHenkouUktk.setSyono(pSyono);
        return this.select(iT_KhHenkouUktk);
    }

    public List<KhHenkouUktkBean> getKhHenkouUktkBySyonoUktkjyoutaiKbn(String pSyono, C_UktkJyoutaiKbn[] pUktkjyoutaikbn) {


        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String mainStry = $SELECT + $NEW(KhHenkouUktkBean.class,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktk.tourokuroute) +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.in(pUktkjyoutaikbn) +
            $ORDER_BY (qIT_KhHenkouUktk.hozenhenkouuktkrenno.desc());

        return em.createJPQL(mainStry, KhHenkouUktkBean.class).bind(qIT_KhHenkouUktk).getResultList();
    }

    public IT_KhHenkouUktk getKykHozenHenkoUkt(String pSyono, C_UktkSyoriKbn pUktksyorikbn, C_UktkJyoutaiKbn pUktkjyoutaikbn, BizDate pKouryokuhasseiymd) {


        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String mainStry = $SELECT + qIT_KhHenkouUktk +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(pUktksyorikbn) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(pUktkjyoutaikbn) +
            $AND + qIT_KhHenkouUktk.kouryokuhasseiymd.eq(pKouryokuhasseiymd);

        return em.createJPQL(mainStry).bind(qIT_KhHenkouUktk).getSingleResult();
    }
}
