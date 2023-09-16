package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.meta.QIT_KhFBSoukinData;

/**
 * 契約保全ＦＢ送金データテーブル(IT_KhFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhFBSoukinDataDao extends AbstractDao<IT_KhFBSoukinData> {

    public IT_KhFBSoukinDataDao() {
        super(IT_KhFBSoukinData.class);
    }

    public IT_KhFBSoukinData getKhFBSoukinData(String pFbsoukindatasikibetukey){
        IT_KhFBSoukinData iT_KhFBSoukinData =  new IT_KhFBSoukinData();
        iT_KhFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(iT_KhFBSoukinData);
    }

    public List<IT_KhFBSoukinData> getKhFBSoukinDatasBySyono(String pSyono) {

        IT_KhFBSoukinData iT_KhFBSoukinData = new IT_KhFBSoukinData();
        iT_KhFBSoukinData.setSyono(pSyono);
        return this.select(iT_KhFBSoukinData);
    }

    public ExDBResults<IT_KhFBSoukinData> getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QIT_KhFBSoukinData qIT_KhFBSoukinData = new QIT_KhFBSoukinData();


        String strSql = $SELECT + qIT_KhFBSoukinData +
            $FROM + qIT_KhFBSoukinData.IT_KhFBSoukinData() +
            $WHERE + qIT_KhFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qIT_KhFBSoukinData).getResults();
    }
}
