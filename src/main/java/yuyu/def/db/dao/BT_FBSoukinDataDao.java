package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_FBSoukinData;

/**
 * ＦＢ送金データテーブル(BT_FBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_FBSoukinDataDao extends AbstractDao<BT_FBSoukinData> {

    public BT_FBSoukinDataDao() {
        super(BT_FBSoukinData.class);
    }

    public BT_FBSoukinData getFBSoukinData(String pFbsoukindatasikibetukey) {
        BT_FBSoukinData bT_FBSoukinData =  new BT_FBSoukinData();
        bT_FBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(bT_FBSoukinData);
    }

    public ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbn(BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn) {


        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM + qBT_FBSoukinData.BT_FBSoukinData() +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.shrhousiteikbn.eq(pShrhousiteikbn) +
            $ORDER_BY (qBT_FBSoukinData.gyoumucd.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        return em.createJPQL(mainStry).bind(qBT_FBSoukinData).getResults();

    }

    public ExDBUpdatableResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {


        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();


        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();


        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM + qBT_FBSoukinData.BT_FBSoukinData() + "," +
            qBM_FBSoukinListKanri.BM_FBSoukinListKanri() +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.gyoumucd.in(pGyoumucd) +
            $AND + qBT_FBSoukinData.syoricd.eq(qBM_FBSoukinListKanri.syoricd) +
            $AND + qBT_FBSoukinData.syorisosikicd.eq(qBM_FBSoukinListKanri.syorisosikicd) +
            $ORDER_BY (qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_FBSoukinData.shrhousiteikbn.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        return em.createJPQL(mainStry).bind(qBT_FBSoukinData,qBM_FBSoukinListKanri).getUpdatableResults();

    }

    public ExDBResults<BT_FBSoukinData> getFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucds(BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {


        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData();

        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();

        String mainStry = $SELECT + qBT_FBSoukinData +
            $FROM + qBT_FBSoukinData.BT_FBSoukinData() + "," +
            qBM_FBSoukinListKanri.BM_FBSoukinListKanri() +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.gyoumucd.in(pGyoumucd) +
            $AND + qBT_FBSoukinData.syoricd.eq(qBM_FBSoukinListKanri.syoricd) +
            $AND + qBT_FBSoukinData.syorisosikicd.eq(qBM_FBSoukinListKanri.syorisosikicd) +
            $ORDER_BY (qBM_FBSoukinListKanri.fbmeisaisyoruicd.asc(),
                qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_FBSoukinData.shrhousiteikbn.asc(),
                qBT_FBSoukinData.gyoumucd.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        return em.createJPQL(mainStry).bind(qBT_FBSoukinData, qBM_FBSoukinListKanri).getResults();
    }

}
