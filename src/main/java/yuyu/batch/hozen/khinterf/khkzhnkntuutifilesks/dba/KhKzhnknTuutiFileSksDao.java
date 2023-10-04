package yuyu.batch.hozen.khinterf.khkzhnkntuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.QIT_KouzaHnknTuuti;

/**
 * 契約保全 インターフェイス 口座返金通知Ｆ作成DAO
 */
public class KhKzhnknTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKzhnknTuutiDataBean> getKhKzhnknTuutiDataBeans(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_KouzaHnknTuuti qIT_KouzaHnknTuuti = new QIT_KouzaHnknTuuti("qIT_KouzaHnknTuuti");

        String strSql = $SELECT + $NEW(KhKzhnknTuutiDataBean.class,
            qIT_KouzaHnknTuuti.syono,
            qIT_KouzaHnknTuuti.tyouhyouymd,
            qIT_KouzaHnknTuuti.henkousikibetukey,
            qIT_KouzaHnknTuuti.hassoukbn,
            qIT_KouzaHnknTuuti.shskyno,
            qIT_KouzaHnknTuuti.shsadr1kj,
            qIT_KouzaHnknTuuti.shsadr2kj,
            qIT_KouzaHnknTuuti.shsadr3kj,
            qIT_KouzaHnknTuuti.shsnmkj,
            qIT_KouzaHnknTuuti.toiawasesosikinmkj,
            qIT_KouzaHnknTuuti.toiawaseyno,
            qIT_KouzaHnknTuuti.toiawaseadr1kj,
            qIT_KouzaHnknTuuti.toiawaseadr2kj,
            qIT_KouzaHnknTuuti.toiawaseadr3kj,
            qIT_KouzaHnknTuuti.toiawasetelno,
            qIT_KouzaHnknTuuti.toiawaseteluktkkanou1,
            qIT_KouzaHnknTuuti.toiawaseteluktkkanou2,
            qIT_KouzaHnknTuuti.toiawasesosikinmkj2,
            qIT_KouzaHnknTuuti.toiawasetelno2,
            qIT_KouzaHnknTuuti.hurikomiymd,
            qIT_KouzaHnknTuuti.shrgk.getTypeFieldName(),
            qIT_KouzaHnknTuuti.shrgk.getValueFieldName(),
            qIT_KouzaHnknTuuti.krkriyuukbn,
            qIT_KouzaHnknTuuti.bankcd,
            qIT_KouzaHnknTuuti.sitencd,
            qIT_KouzaHnknTuuti.yokinkbn,
            qIT_KouzaHnknTuuti.kouzano,
            qIT_KouzaHnknTuuti.kzmeiginmkn,
            qIT_KouzaHnknTuuti.ryosyuymd,
            qIT_KouzaHnknTuuti.rsgaku.getTypeFieldName(),
            qIT_KouzaHnknTuuti.rsgaku.getValueFieldName(),
            qIT_KouzaHnknTuuti.jyuutouym,
            qIT_KouzaHnknTuuti.jyutoukaisuuy,
            qIT_KouzaHnknTuuti.jyutoukaisuum,
            qIT_KouzaHnknTuuti.kbnkey) +
            $FROM(qIT_KouzaHnknTuuti) +
            $WHERE + qIT_KouzaHnknTuuti.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhKzhnknTuutiDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KhKzhnknTuutiDataBean.class).bind(qIT_KouzaHnknTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void addKouzaHnknTuutiTyInserter(MultipleEntityInserter pKouzaHnknTuutiTyInserter,
        ZT_KouzaHnknTuutiTy pKouzaHnknTuutiTy) {

        pKouzaHnknTuutiTyInserter.add(pKouzaHnknTuutiTy);
    }

    public void addTuutirirekiMeisaiHokanInserter(MultipleEntityInserter pTuutirirekiMeisaiHokanInserter,
        BT_TuutirirekiMeisaiHokan pTuutirirekiMeisaiHokan) {

        pTuutirirekiMeisaiHokanInserter.add(pTuutirirekiMeisaiHokan);
    }
}
