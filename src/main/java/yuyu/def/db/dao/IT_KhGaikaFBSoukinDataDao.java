package yuyu.def.db.dao;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.meta.QIT_KhGaikaFBSoukinData;

/**
 * 契約保全外貨ＦＢ送金データテーブル(IT_KhGaikaFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhGaikaFBSoukinDataDao extends AbstractDao<IT_KhGaikaFBSoukinData> {

    public IT_KhGaikaFBSoukinDataDao() {
        super(IT_KhGaikaFBSoukinData.class);
    }

    public IT_KhGaikaFBSoukinData getKhGaikaFBSoukinData(String pFbsoukindatasikibetukey){
        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData =  new IT_KhGaikaFBSoukinData();
        iT_KhGaikaFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(iT_KhGaikaFBSoukinData);
    }

    public List<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasBySyono(String pSyono) {

        IT_KhGaikaFBSoukinData iT_KhGaikaFBSoukinData = new IT_KhGaikaFBSoukinData();
        iT_KhGaikaFBSoukinData.setSyono(pSyono);
        return this.select(iT_KhGaikaFBSoukinData);
    }

    public ExDBResults<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QIT_KhGaikaFBSoukinData qIT_KhGaikaFBSoukinData = new QIT_KhGaikaFBSoukinData();


        String strSql = $SELECT + qIT_KhGaikaFBSoukinData +
            $FROM + qIT_KhGaikaFBSoukinData.IT_KhGaikaFBSoukinData() +
            $WHERE + qIT_KhGaikaFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qIT_KhGaikaFBSoukinData).getResults();
    }
}
