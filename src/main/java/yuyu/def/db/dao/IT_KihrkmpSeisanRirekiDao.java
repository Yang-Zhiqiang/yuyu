package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;

/**
 * 既払込Ｐ精算履歴テーブル(IT_KihrkmpSeisanRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KihrkmpSeisanRirekiDao extends AbstractDao<IT_KihrkmpSeisanRireki> {

    public IT_KihrkmpSeisanRirekiDao() {
        super(IT_KihrkmpSeisanRireki.class);
    }

    @Deprecated
    public IT_KihrkmpSeisanRireki getKihrkmpSeisanRireki(String pSyono,
        Integer pRenno){
        IT_KihrkmpSeisanRireki iT_KihrkmpSeisanRireki =  new IT_KihrkmpSeisanRireki();
        iT_KihrkmpSeisanRireki.setSyono(pSyono);
        iT_KihrkmpSeisanRireki.setRenno(pRenno);
        return this.selectOne(iT_KihrkmpSeisanRireki);
    }

    @Override
    @Deprecated
    public List<IT_KihrkmpSeisanRireki> selectAll() {
        return super.selectAll();
    }

    public Integer getKihrkmpSeisanRirekiMaxRennoBySyono(String pSyono) {


        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki();


        String quertSql = $SELECT + $MAX(qIT_KihrkmpSeisanRireki.renno) +
            $FROM + qIT_KihrkmpSeisanRireki.IT_KihrkmpSeisanRireki() +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono);

        return em.createJPQL(quertSql).bind(qIT_KihrkmpSeisanRireki).getSingleResult();
    }
}
