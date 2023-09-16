package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;

/**
 * 死亡仮受付テーブル(JT_SibouKariuketsukeDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SibouKariuketsukeDao extends AbstractDao<JT_SibouKariuketsuke> {

    public JT_SibouKariuketsukeDao() {
        super(JT_SibouKariuketsuke.class);
    }

    @Deprecated
    public JT_SibouKariuketsuke getSibouKariuketsuke(String pSkno,
        String pSyono){
        JT_SibouKariuketsuke jT_SibouKariuketsuke =  new JT_SibouKariuketsuke();
        jT_SibouKariuketsuke.setSkno(pSkno);
        jT_SibouKariuketsuke.setSyono(pSyono);
        return this.selectOne(jT_SibouKariuketsuke);
    }

    @Override
    @Deprecated
    public List<JT_SibouKariuketsuke> selectAll() {
        return super.selectAll();
    }

    public Long getSibouKariuketsukeCountBySyono(String pSyono) {

        QJT_SibouKariuketsuke sibouKariuketsuke = new QJT_SibouKariuketsuke();


        String querySql = $SELECT + $COUNT(sibouKariuketsuke.syono) +
            $FROM + sibouKariuketsuke.JT_SibouKariuketsuke() +
            $WHERE + sibouKariuketsuke.syono.eq(pSyono) +
            $AND + sibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE);


        return em.createJPQL(querySql).bind(sibouKariuketsuke).getSingleResult();
    }
}
