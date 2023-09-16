package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;

/**
 * 支払契約基本テーブル(JT_SiKykKihonDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiKykKihonDao extends AbstractDao<JT_SiKykKihon> {

    public JT_SiKykKihonDao() {
        super(JT_SiKykKihon.class);
    }

    public JT_SiKykKihon getSiKykKihon(String pSyono){
        JT_SiKykKihon jT_SiKykKihon =  new JT_SiKykKihon();
        jT_SiKykKihon.setSyono(pSyono);
        return this.selectOne(jT_SiKykKihon);
    }

    public ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean>  getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {


        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");


        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki("qJT_SiRireki");

        String queryStr = $SELECT + qJT_SkKihon + "," + qJT_SiRireki +
            $FROM + qJT_SkKihon.JT_SkKihon() + "," +
            qJT_SiRireki.JT_SiRireki() +
            $WHERE + qJT_SkKihon.seikyuusyubetu.ne(pSeikyuusyubetu) +
            $AND + qJT_SiRireki.shrsyoriymd.ge(pSyoriYmdFrom) +
            $AND + qJT_SiRireki.shrsyoriymd.le(pSyoriYmdTo) +
            $AND + qJT_SkKihon.skno.eq(qJT_SiRireki.skno) +
            $AND + qJT_SkKihon.syono.eq(qJT_SiRireki.syono) +
            $ORDER_BY (qJT_SkKihon.syono.asc() ,
                qJT_SkKihon.skno.asc());

        return em.createJPQL(queryStr).bind(qJT_SkKihon, qJT_SiRireki).getResults(SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean.class);
    }
}
