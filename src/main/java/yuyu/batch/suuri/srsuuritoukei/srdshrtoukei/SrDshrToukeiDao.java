package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.meta.QIT_KhDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;
import yuyu.def.db.meta.QSV_BikinKykHaitouMeisai;

/**
 * Ｄ支払統計情報作成DAOクラスです。
 */

public class SrDshrToukeiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_KhDshrTuki> getItKhDshrTuki(BizDate pZenkaidensimeYmd, BizDate pKonkaidensimeYmd) {

        QIT_KhDshrTuki qIT_KhDshrTuki = new QIT_KhDshrTuki("qIT_KhDshrTuki");

        String queryStr = $SELECT + qIT_KhDshrTuki +
            $FROM (qIT_KhDshrTuki) +
            $WHERE + qIT_KhDshrTuki.syoriYmd.gt(pZenkaidensimeYmd) +
            $AND + qIT_KhDshrTuki.syoriYmd.le(pKonkaidensimeYmd);

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_KhDshrTuki).getResults();
    }

    public ExDBResults<JT_SiDshrTuki> getJtSiDshrTuki(BizDate pZenkaidensimeYmd, BizDate pKonkaidensimeYmd) {

        QJT_SiDshrTuki qJT_SiDshrTuki = new QJT_SiDshrTuki("qJT_SiDshrTuki");

        String queryStr = $SELECT + qJT_SiDshrTuki +
            $FROM (qJT_SiDshrTuki) +
            $WHERE + qJT_SiDshrTuki.syoriYmd.gt(pZenkaidensimeYmd) +
            $AND + qJT_SiDshrTuki.syoriYmd.le(pKonkaidensimeYmd);

        return exDBEntityManager.createJPQL(queryStr).bind(qJT_SiDshrTuki).getResults();
    }

    public long getBikinKykHaitouMeisaiCount(String pSyono, BizDate pKessanKijyunYmd) {

        QSV_BikinKykHaitouMeisai qSV_BikinKykHaitouMeisai = new QSV_BikinKykHaitouMeisai("qSV_BikinKykHaitouMeisai");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qSV_BikinKykHaitouMeisai)  +
            $WHERE + qSV_BikinKykHaitouMeisai.syono.eq(pSyono) +
            $AND + qSV_BikinKykHaitouMeisai.kessankijyunymd.eq(pKessanKijyunYmd) +
            $AND + qSV_BikinKykHaitouMeisai.bknjkukbn.ne(C_BknJkuKbn.BLNK) +
            $AND + qSV_BikinKykHaitouMeisai.bknjkukbn.ne(C_BknJkuKbn.JIKOU) ;

        return exDBEntityManager.createJPQL(strSql).bind(qSV_BikinKykHaitouMeisai).getSingleResult();
    }
}
