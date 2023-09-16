package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.meta.QJT_SiHubiDetail;

/**
 * 支払不備詳細テーブル(JT_SiHubiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiHubiDetailDao extends AbstractDao<JT_SiHubiDetail> {

    public JT_SiHubiDetailDao() {
        super(JT_SiHubiDetail.class);
    }

    @Deprecated
    public JT_SiHubiDetail getSiHubiDetail(String pHubisikibetukey,
        Integer pRenno3keta){
        JT_SiHubiDetail jT_SiHubiDetail =  new JT_SiHubiDetail();
        jT_SiHubiDetail.setHubisikibetukey(pHubisikibetukey);
        jT_SiHubiDetail.setRenno3keta(pRenno3keta);
        return this.selectOne(jT_SiHubiDetail);
    }

    @Override
    @Deprecated
    public List<JT_SiHubiDetail> selectAll() {
        return super.selectAll();
    }

    public Integer getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(String pHubisikibetukey) {


        QJT_SiHubiDetail qJT_SiHubiDetail = new QJT_SiHubiDetail();


        String strSql = $SELECT + $MAX(qJT_SiHubiDetail.renno3keta) +
            $FROM + qJT_SiHubiDetail.JT_SiHubiDetail() +
            $WHERE + qJT_SiHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qJT_SiHubiDetail.hasinymd.isNotNull();


        return em.createJPQL(strSql).bind(qJT_SiHubiDetail).getSingleResult();
    }
}
