package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.QJT_SiJinsokuShrTtdkInfo;

/**
 * 保険金給付金迅速支払手続情報テーブル(JT_SiJinsokuShrTtdkInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiJinsokuShrTtdkInfoDao extends AbstractDao<JT_SiJinsokuShrTtdkInfo> {

    public JT_SiJinsokuShrTtdkInfoDao() {
        super(JT_SiJinsokuShrTtdkInfo.class);
    }

    public JT_SiJinsokuShrTtdkInfo getSiJinsokuShrTtdkInfo(String pSyorisosikicd, String pSyoricd, String pHknknshrsntkno, BizDate pSyoruiukeymd, BizDate pSyoriYmd, BizDate pDenymd, String pSyono) {
        JT_SiJinsokuShrTtdkInfo jT_SiJinsokuShrTtdkInfo =  new JT_SiJinsokuShrTtdkInfo();
        jT_SiJinsokuShrTtdkInfo.setSyorisosikicd(pSyorisosikicd);
        jT_SiJinsokuShrTtdkInfo.setSyoricd(pSyoricd);
        jT_SiJinsokuShrTtdkInfo.setHknknshrsntkno(pHknknshrsntkno);
        jT_SiJinsokuShrTtdkInfo.setSyoruiukeymd(pSyoruiukeymd);
        jT_SiJinsokuShrTtdkInfo.setSyoriYmd(pSyoriYmd);
        jT_SiJinsokuShrTtdkInfo.setDenymd(pDenymd);
        jT_SiJinsokuShrTtdkInfo.setSyono(pSyono);
        return this.selectOne(jT_SiJinsokuShrTtdkInfo);
    }

    public ExDBResults<JT_SiJinsokuShrTtdkInfo> getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate pSyoriYmdFrom,
        BizDate pSyoriYmdTo) {

        QJT_SiJinsokuShrTtdkInfo qJT_SiJinsokuShrTtdkInfo = new QJT_SiJinsokuShrTtdkInfo();


        String strSql = $SELECT +  qJT_SiJinsokuShrTtdkInfo +
            $FROM + qJT_SiJinsokuShrTtdkInfo.JT_SiJinsokuShrTtdkInfo() +
            $WHERE + qJT_SiJinsokuShrTtdkInfo.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qJT_SiJinsokuShrTtdkInfo.syoriYmd.le(pSyoriYmdTo);


        return em.createJPQL(strSql).bind(qJT_SiJinsokuShrTtdkInfo).getResults();
    }
}
