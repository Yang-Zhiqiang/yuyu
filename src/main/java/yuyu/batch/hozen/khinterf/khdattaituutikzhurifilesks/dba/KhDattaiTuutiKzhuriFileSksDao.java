package yuyu.batch.hozen.khinterf.khdattaituutikzhurifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_DattaiTuutiKzhuri;

/**
 * 契約保全 インターフェイス 脱退通知（口座振替）Ｆ作成DAO
 */
public class KhDattaiTuutiKzhuriFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhDattaiTuutiKzhuriBean> getDattaiTuutiKzhuriBeans(String pKakutyoujobcd,
        BizDate pTyouhyouYmd) {

        QIT_DattaiTuutiKzhuri qIT_DattaiTuutiKzhuri = new QIT_DattaiTuutiKzhuri("qIT_DattaiTuutiKzhuri");

        String strSql = $SELECT + $NEW(KhDattaiTuutiKzhuriBean.class,
            qIT_DattaiTuutiKzhuri.kbnkey,
            qIT_DattaiTuutiKzhuri.syono,
            qIT_DattaiTuutiKzhuri.tyouhyouymd,
            qIT_DattaiTuutiKzhuri.syoruiCd,
            qIT_DattaiTuutiKzhuri.hassoukbn,
            qIT_DattaiTuutiKzhuri.shskyno,
            qIT_DattaiTuutiKzhuri.shsadr1kj,
            qIT_DattaiTuutiKzhuri.shsadr2kj,
            qIT_DattaiTuutiKzhuri.shsadr3kj,
            qIT_DattaiTuutiKzhuri.shsnmkj,
            qIT_DattaiTuutiKzhuri.toiawasesosikinmkj,
            qIT_DattaiTuutiKzhuri.toiawaseyno,
            qIT_DattaiTuutiKzhuri.toiawaseadr1kj,
            qIT_DattaiTuutiKzhuri.toiawaseadr2kj,
            qIT_DattaiTuutiKzhuri.toiawaseadr3kj,
            qIT_DattaiTuutiKzhuri.toiawasetelno,
            qIT_DattaiTuutiKzhuri.toiawaseteluktkkanou1,
            qIT_DattaiTuutiKzhuri.toiawaseteluktkkanou2,
            qIT_DattaiTuutiKzhuri.toiawasesosikinmkj2,
            qIT_DattaiTuutiKzhuri.toiawasetelno2,
            qIT_DattaiTuutiKzhuri.hhknnmkj,
            qIT_DattaiTuutiKzhuri.kzinfo30keta1,
            qIT_DattaiTuutiKzhuri.kzinfo30keta2,
            qIT_DattaiTuutiKzhuri.kzinfo30keta3,
            qIT_DattaiTuutiKzhuri.kouzamaskingmsg,
            qIT_DattaiTuutiKzhuri.osirasemongon1,
            qIT_DattaiTuutiKzhuri.osirasemongon2,
            qIT_DattaiTuutiKzhuri.osirasemongon3,
            qIT_DattaiTuutiKzhuri.osirasemongon4,
            qIT_DattaiTuutiKzhuri.osirasemongon5,
            qIT_DattaiTuutiKzhuri.osirasemongon6,
            qIT_DattaiTuutiKzhuri.osirasemongon7,
            qIT_DattaiTuutiKzhuri.osirasemongon8,
            qIT_DattaiTuutiKzhuri.osirasemongon9) +
            $FROM(qIT_DattaiTuutiKzhuri) +
            $WHERE + qIT_DattaiTuutiKzhuri.tyouhyouymd.eq(pTyouhyouYmd);

        ExDBResults<KhDattaiTuutiKzhuriBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhDattaiTuutiKzhuriBean.class)
            .bind(qIT_DattaiTuutiKzhuri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
