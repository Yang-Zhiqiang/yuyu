package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;

/**
 * 保険金給付金Ｄ支払統計テーブル(JT_SiDshrTukiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiDshrTukiDao extends AbstractDao<JT_SiDshrTuki> {

    public JT_SiDshrTukiDao() {
        super(JT_SiDshrTuki.class);
    }

    public JT_SiDshrTuki getSiDshrTuki(String pDshrtoukeisikibetukey) {
        JT_SiDshrTuki jT_SiDshrTuki =  new JT_SiDshrTuki();
        jT_SiDshrTuki.setDshrtoukeisikibetukey(pDshrtoukeisikibetukey);
        return this.selectOne(jT_SiDshrTuki);
    }

    public JT_SiDshrTuki getSiDshrTukiBySyonoSknoRirekino(String pSyono, String pSkno, Integer pSeikyuurirekino) {

        QJT_SiDshrTuki qJT_SiDshrTuki = new QJT_SiDshrTuki();


        String  strSql = $SELECT + qJT_SiDshrTuki +
            $FROM + qJT_SiDshrTuki.JT_SiDshrTuki() +
            $WHERE + qJT_SiDshrTuki.syono.eq(pSyono) +
            $AND + qJT_SiDshrTuki.skno.eq(pSkno) +
            $AND + qJT_SiDshrTuki.seikyuurirekino.eq(pSeikyuurirekino);


        return em.createJPQL(strSql).bind(qJT_SiDshrTuki).getSingleResult();
    }
}
