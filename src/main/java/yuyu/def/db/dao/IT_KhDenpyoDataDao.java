package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.meta.QIT_KhDenpyoData;

/**
 * 契約保全伝票データテーブル(IT_KhDenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhDenpyoDataDao extends AbstractDao<IT_KhDenpyoData> {

    public IT_KhDenpyoDataDao() {
        super(IT_KhDenpyoData.class);
    }

    public IT_KhDenpyoData getKhDenpyoData(String pDenrenno,
        Integer pEdano){
        IT_KhDenpyoData iT_KhDenpyoData =  new IT_KhDenpyoData();
        iT_KhDenpyoData.setDenrenno(pDenrenno);
        iT_KhDenpyoData.setEdano(pEdano);
        return this.selectOne(iT_KhDenpyoData);
    }

    public List<IT_KhDenpyoData> getKhDenpyoDatasBySyono(String pSyono) {

        IT_KhDenpyoData iT_KhDenpyoData = new IT_KhDenpyoData();
        iT_KhDenpyoData.setSyono(pSyono);
        return this.select(iT_KhDenpyoData);
    }

    public ExDBUpdatableResults<IT_KhDenpyoData> getKhDenpyoDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriymd) {


        QIT_KhDenpyoData qIT_KhDenpyoData = new QIT_KhDenpyoData();


        String strSql = $SELECT + qIT_KhDenpyoData +
            $FROM + qIT_KhDenpyoData.IT_KhDenpyoData() +
            $WHERE + qIT_KhDenpyoData.syoriYmd.eq(pSyoriymd) +
            $ORDER_BY(qIT_KhDenpyoData.denrenno,
                qIT_KhDenpyoData.edano);


        return em.createJPQL(strSql).bind(qIT_KhDenpyoData).getUpdatableResults();
    }
}
