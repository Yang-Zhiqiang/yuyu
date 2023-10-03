package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.meta.QSV_BikinIdouMeisai;

/**
 * 備金異動明細情報作成DAOクラスです。
 */
public class SrBikinIdouMeisaiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<SV_BikinIdouMeisai> getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(C_BknJkuKbn pBknjkukbn, C_BknrigiKbn pBknrigikbn, BizDate pKessankijyunymd) {
        QSV_BikinIdouMeisai qSV_BikinIdouMeisai = new QSV_BikinIdouMeisai();

        String queryStr = $SELECT + qSV_BikinIdouMeisai +
            $FROM + qSV_BikinIdouMeisai.SV_BikinIdouMeisai() +
            $WHERE + qSV_BikinIdouMeisai.bknjkukbn.eq(pBknjkukbn) +
            $AND + qSV_BikinIdouMeisai.bknrigikbn.ne(pBknrigikbn) +
            $AND + qSV_BikinIdouMeisai.kessankijyunymd.eq(pKessankijyunymd) +
            $ORDER_BY(qSV_BikinIdouMeisai.shrsyoriymd.asc(),
                qSV_BikinIdouMeisai.syono.asc(),
                qSV_BikinIdouMeisai.gyoumuKousinTime.asc());

        return exDBEntityManager.createJPQL(queryStr).bind(qSV_BikinIdouMeisai).getResultList();
    }
}
