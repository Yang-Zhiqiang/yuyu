package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;
import yuyu.def.db.meta.QBT_GkFBSoukinData;

/**
 * 外貨ＦＢ送金データテーブル(BT_GkFBSoukinDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_GkFBSoukinDataDao extends AbstractDao<BT_GkFBSoukinData> {

    public BT_GkFBSoukinDataDao() {
        super(BT_GkFBSoukinData.class);
    }

    public BT_GkFBSoukinData getGkFBSoukinData(String pFbsoukindatasikibetukey) {
        BT_GkFBSoukinData bT_GkFBSoukinData =  new BT_GkFBSoukinData();
        bT_GkFBSoukinData.setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
        return this.selectOne(bT_GkFBSoukinData);
    }

    public ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(BizDate pSyoriYmd) {


        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData();


        String strSql = $SELECT + qBT_GkFBSoukinData +
            $FROM + qBT_GkFBSoukinData.BT_GkFBSoukinData() +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd);


        return em.createJPQL(strSql).bind(qBT_GkFBSoukinData).getUpdatableResults();
    }

    public ExDBUpdatableResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucd(BizDate pSyoriYmd,
        C_Gkgyoumucd[] pGkgyoumucd) {


        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData();


        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();


        String mainStry = $SELECT + qBT_GkFBSoukinData +
            $FROM + qBT_GkFBSoukinData.BT_GkFBSoukinData() +
            "," + qBM_FBSoukinListKanri.BM_FBSoukinListKanri() +
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_GkFBSoukinData.gkgyoumucd.in(pGkgyoumucd) +
            $AND + qBT_GkFBSoukinData.syoricd.eq(qBM_FBSoukinListKanri.syoricd) +
            $AND + qBT_GkFBSoukinData.syorisosikicd.eq(qBM_FBSoukinListKanri.syorisosikicd) +
            $ORDER_BY (qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_GkFBSoukinData.shrhousiteikbn.asc(),
                qBT_GkFBSoukinData.shrtuukasyu.asc(),
                qBT_GkFBSoukinData.bankcd.asc(),
                qBT_GkFBSoukinData.sitencd.asc(),
                qBT_GkFBSoukinData.kouzano.asc(),
                qBT_GkFBSoukinData.kzmeiginmei.asc(),
                qBT_GkFBSoukinData.keirisyono.asc());

        return em.createJPQL(mainStry).bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getUpdatableResults();
    }

    public ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdShrhousiteikbnGkgyoumucds(
        BizDate pSyoriYmd, C_ShrhousiteiKbn pShrhousiteikbn, BizDate pDratekakuteiymd, C_Gkgyoumucd... pGkgyoumucd) {


        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData();


        String where = "";


        if (pDratekakuteiymd == null) {
            where = $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qBT_GkFBSoukinData.shrhousiteikbn.eq(pShrhousiteikbn) +
                $AND + qBT_GkFBSoukinData.gkgyoumucd.in(pGkgyoumucd);
        }

        else {
            where = $WHERE  + $(qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
                $AND + qBT_GkFBSoukinData.shrhousiteikbn.eq(pShrhousiteikbn) +
                $AND + qBT_GkFBSoukinData.gkgyoumucd.in(pGkgyoumucd)) +
                $OR  + $(qBT_GkFBSoukinData.syoriYmd.gt(pDratekakuteiymd) +
                    $AND + qBT_GkFBSoukinData.shrhousiteikbn.eq(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI) +
                    $AND + $(qBT_GkFBSoukinData.gkgyoumucd.eq(C_Gkgyoumucd.GK_GKSOUKIN_HAITOU_TUIBARAI_KH) +
                        $OR  + qBT_GkFBSoukinData.gkgyoumucd.eq(C_Gkgyoumucd.GK_GKSOUKIN_HAITOU_TUIBARAI_SI)));
        }


        String strSql = $SELECT + qBT_GkFBSoukinData +
            $FROM + qBT_GkFBSoukinData.BT_GkFBSoukinData() +
            where +
            $ORDER_BY (qBT_GkFBSoukinData.denymd.asc(),
                qBT_GkFBSoukinData.gkgyoumucd.asc(),
                qBT_GkFBSoukinData.shrtuukasyu.asc(),
                qBT_GkFBSoukinData.bankcd.asc(),
                qBT_GkFBSoukinData.sitencd.asc(),
                qBT_GkFBSoukinData.kouzano.asc(),
                qBT_GkFBSoukinData.kzmeiginmei.asc(),
                qBT_GkFBSoukinData.keirisyono.asc());


        return em.createJPQL(strSql).bind(qBT_GkFBSoukinData).getResults();
    }

    public ExDBResults<BT_GkFBSoukinData> getGkFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucdWithFBSoukinListKanri(BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {


        QBT_GkFBSoukinData qBT_GkFBSoukinData = new QBT_GkFBSoukinData();
        QBM_FBSoukinListKanri qBM_FBSoukinListKanri = new QBM_FBSoukinListKanri();


        String strSql = $SELECT + qBT_GkFBSoukinData +
            $FROM + qBT_GkFBSoukinData.BT_GkFBSoukinData() +","+
            qBM_FBSoukinListKanri.BM_FBSoukinListKanri()+
            $WHERE + qBT_GkFBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_GkFBSoukinData.gkgyoumucd.in(pGkgyoumucd) +
            $AND + qBT_GkFBSoukinData.syoricd.eq(qBM_FBSoukinListKanri.syoricd) +
            $AND + qBT_GkFBSoukinData.syorisosikicd.eq(qBM_FBSoukinListKanri.syorisosikicd) +
            $ORDER_BY (qBM_FBSoukinListKanri.gkfbmeisaisyoruicd.asc(),
                qBM_FBSoukinListKanri.tantositucd.asc(),
                qBT_GkFBSoukinData.shrhousiteikbn.asc(),
                qBT_GkFBSoukinData.denymd.asc(),
                qBT_GkFBSoukinData.gkgyoumucd.asc(),
                qBT_GkFBSoukinData.shrtuukasyu.asc(),
                qBT_GkFBSoukinData.bankcd.asc(),
                qBT_GkFBSoukinData.sitencd.asc(),
                qBT_GkFBSoukinData.kouzano.asc(),
                qBT_GkFBSoukinData.kzmeiginmei.asc(),
                qBT_GkFBSoukinData.keirisyono.asc());


        return em.createJPQL(strSql).bind(qBT_GkFBSoukinData, qBM_FBSoukinListKanri).getResults();
    }
}
