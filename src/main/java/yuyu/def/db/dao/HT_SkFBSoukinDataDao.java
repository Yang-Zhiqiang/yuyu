package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.meta.QHT_SkFBSoukinData;

/**
 * 新契約ＦＢ送金データテーブル(HT_SkFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkFBSoukinDataDao extends AbstractDao<HT_SkFBSoukinData> {

    public HT_SkFBSoukinDataDao() {
        super(HT_SkFBSoukinData.class);
    }

    public HT_SkFBSoukinData getSkFBSoukinData(String pFbsoukindatasikibetukey){
        HT_SkFBSoukinData hT_SkFBSoukinData =  new HT_SkFBSoukinData();
        hT_SkFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(hT_SkFBSoukinData);
    }

    public ExDBResults<HT_SkFBSoukinData> getSkFBSoukinDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QHT_SkFBSoukinData qHT_SkFBSoukinData = new QHT_SkFBSoukinData();


        String  strSql = $SELECT + qHT_SkFBSoukinData +
            $FROM + qHT_SkFBSoukinData.HT_SkFBSoukinData() +
            $WHERE + qHT_SkFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qHT_SkFBSoukinData).getResults();
    }

    public List<HT_SkFBSoukinData> getSkFBSoukinDatasByMosno(String pMosno) {

        HT_SkFBSoukinData hT_SkFBSoukinData =  new HT_SkFBSoukinData();
        hT_SkFBSoukinData.setMosno(pMosno);
        return this.select(hT_SkFBSoukinData);
    }
}
