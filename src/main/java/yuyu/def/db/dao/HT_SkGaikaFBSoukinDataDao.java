package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.meta.QHT_SkGaikaFBSoukinData;

/**
 * 新契約外貨ＦＢ送金データテーブル(HT_SkGaikaFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkGaikaFBSoukinDataDao extends AbstractDao<HT_SkGaikaFBSoukinData> {

    public HT_SkGaikaFBSoukinDataDao() {
        super(HT_SkGaikaFBSoukinData.class);
    }

    public HT_SkGaikaFBSoukinData getSkGaikaFBSoukinData(String pFbsoukindatasikibetukey){
        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData =  new HT_SkGaikaFBSoukinData();
        hT_SkGaikaFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(hT_SkGaikaFBSoukinData);
    }

    public ExDBResults<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QHT_SkGaikaFBSoukinData qHT_SkGaikaFBSoukinData = new QHT_SkGaikaFBSoukinData();


        String  strSql = $SELECT + qHT_SkGaikaFBSoukinData +
            $FROM + qHT_SkGaikaFBSoukinData.HT_SkGaikaFBSoukinData() +
            $WHERE + qHT_SkGaikaFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qHT_SkGaikaFBSoukinData).getResults();
    }

    public List<HT_SkGaikaFBSoukinData> getSkGaikaFBSoukinDatasByMosno(String pMosno) {

        HT_SkGaikaFBSoukinData hT_SkGaikaFBSoukinData = new HT_SkGaikaFBSoukinData();
        hT_SkGaikaFBSoukinData.setMosno(pMosno);
        return this.select(hT_SkGaikaFBSoukinData);

    }
}
