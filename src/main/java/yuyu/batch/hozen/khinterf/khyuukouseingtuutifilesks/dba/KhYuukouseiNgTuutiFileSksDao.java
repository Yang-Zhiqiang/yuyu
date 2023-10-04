package yuyu.batch.hozen.khinterf.khyuukouseingtuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_YuukouseiNgTuuti;

/**
 * 契約保全 インターフェイス 有効性確認ＮＧ通知Ｆ作成機能DAOクラス
 */
public class KhYuukouseiNgTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhYuukouseiNgTuutiBean> getYuukouseiNgTuutiBeans(String pKakutyouJobCd,
        BizDate pTyouhyouymd) {

        QIT_YuukouseiNgTuuti qIT_YuukouseiNgTuuti = new QIT_YuukouseiNgTuuti("qIT_YuukouseiNgTuuti");

        String sql = $SELECT + $NEW(KhYuukouseiNgTuutiBean.class,
            qIT_YuukouseiNgTuuti.kbnkey,
            qIT_YuukouseiNgTuuti.syono,
            qIT_YuukouseiNgTuuti.tyouhyouymd,
            qIT_YuukouseiNgTuuti.shskyno,
            qIT_YuukouseiNgTuuti.shsadr1kj,
            qIT_YuukouseiNgTuuti.shsadr2kj,
            qIT_YuukouseiNgTuuti.shsadr3kj,
            qIT_YuukouseiNgTuuti.shsnmkj,
            qIT_YuukouseiNgTuuti.toiawasesosikinmkj,
            qIT_YuukouseiNgTuuti.toiawaseyno,
            qIT_YuukouseiNgTuuti.toiawaseadr1kj,
            qIT_YuukouseiNgTuuti.toiawaseadr2kj,
            qIT_YuukouseiNgTuuti.toiawaseadr3kj,
            qIT_YuukouseiNgTuuti.toiawasetelno,
            qIT_YuukouseiNgTuuti.toiawaseteluktkkanou1,
            qIT_YuukouseiNgTuuti.toiawaseteluktkkanou2,
            qIT_YuukouseiNgTuuti.toiawasesosikinmkj2,
            qIT_YuukouseiNgTuuti.toiawasetelno2,
            qIT_YuukouseiNgTuuti.osirasemongon46keta1,
            qIT_YuukouseiNgTuuti.osirasemongon46keta2,
            qIT_YuukouseiNgTuuti.osirasemongon46keta3,
            qIT_YuukouseiNgTuuti.osirasemongon46keta4,
            qIT_YuukouseiNgTuuti.osirasemongon46keta5,
            qIT_YuukouseiNgTuuti.osirasemongon46keta6,
            qIT_YuukouseiNgTuuti.osirasemongon46keta7,
            qIT_YuukouseiNgTuuti.osirasemongon46keta8,
            qIT_YuukouseiNgTuuti.osirasemongon46keta9,
            qIT_YuukouseiNgTuuti.osirasemongon46keta10,
            qIT_YuukouseiNgTuuti.kyknmkj,
            qIT_YuukouseiNgTuuti.hokenryou.getTypeFieldName(),
            qIT_YuukouseiNgTuuti.hokenryou.getValueFieldName(),
            qIT_YuukouseiNgTuuti.creditcardinfo1,
            qIT_YuukouseiNgTuuti.creditcardinfo2,
            qIT_YuukouseiNgTuuti.creditcardinfo3,
            qIT_YuukouseiNgTuuti.creditcardmaskingmsg,
            qIT_YuukouseiNgTuuti.goiraijikoutoumongon1,
            qIT_YuukouseiNgTuuti.goiraijikoutoumongon2,
            qIT_YuukouseiNgTuuti.goiraijikoutoumongon3,
            qIT_YuukouseiNgTuuti.phrkmongon1,
            qIT_YuukouseiNgTuuti.phrkmongon2,
            qIT_YuukouseiNgTuuti.phrkmongon3,
            qIT_YuukouseiNgTuuti.phrkmongon4,
            qIT_YuukouseiNgTuuti.phrkmongon5,
            qIT_YuukouseiNgTuuti.phrkmongon6,
            qIT_YuukouseiNgTuuti.phrkmongon7,
            qIT_YuukouseiNgTuuti.phrkmongon8,
            qIT_YuukouseiNgTuuti.phrkmongon9,
            qIT_YuukouseiNgTuuti.syoruiCd,
            qIT_YuukouseiNgTuuti.hassoukbn) +
            $FROM(qIT_YuukouseiNgTuuti) +
            $WHERE + qIT_YuukouseiNgTuuti.tyouhyouymd.eq(pTyouhyouymd);

        ExDBResults<KhYuukouseiNgTuutiBean> exDBResults = exDBEntityManager.createJPQL(sql,
            KhYuukouseiNgTuutiBean.class).bind(qIT_YuukouseiNgTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
