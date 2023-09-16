package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubiDetail;
import yuyu.def.db.meta.QIT_KhHubiDetail;

/**
 * 契約保全不備詳細テーブル(IT_KhHubiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHubiDetailDao extends AbstractDao<IT_KhHubiDetail> {

    public IT_KhHubiDetailDao() {
        super(IT_KhHubiDetail.class);
    }

    @Deprecated
    public IT_KhHubiDetail getKhHubiDetail(String pHubisikibetukey,
        Integer pRenno3keta){
        IT_KhHubiDetail iT_KhHubiDetail =  new IT_KhHubiDetail();
        iT_KhHubiDetail.setHubisikibetukey(pHubisikibetukey);
        iT_KhHubiDetail.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_KhHubiDetail);
    }

    public Integer getKhHubiDetailMaxRenno3ketaByHubisikibetukey(String pHubisikibetukey) {


        QIT_KhHubiDetail qIT_KhHubiDetail= new QIT_KhHubiDetail();

        String strSql = $SELECT + $MAX(qIT_KhHubiDetail.renno3keta) +
            $FROM + qIT_KhHubiDetail.IT_KhHubiDetail() +
            $WHERE + qIT_KhHubiDetail.hubisikibetukey.eq(pHubisikibetukey);

        return em.createJPQL(strSql).bind(qIT_KhHubiDetail).getSingleResult();
    }

    @Override
    @Deprecated
    public List<IT_KhHubiDetail> selectAll() {
        return super.selectAll();
    }

    public BizDate getKhHubiMaxHasinymdByHubisikibetukeyHassinsakikbnKaisyouymd(String pHubisikibetukey,
        C_HassinsakiKbn pHassinsakikbn) {


        QIT_KhHubiDetail qIT_KhHubiDetail = new QIT_KhHubiDetail();


        String strSql = $SELECT + $MAX(qIT_KhHubiDetail.hasinymd) +
            $FROM + qIT_KhHubiDetail.IT_KhHubiDetail() +
            $WHERE + qIT_KhHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qIT_KhHubiDetail.hassinsakikbn.eq(pHassinsakikbn) +
            $AND + qIT_KhHubiDetail.kaisyouymd.isNull();


        return em.createJPQL(strSql).bind(qIT_KhHubiDetail).getSingleResult();
    }
}
