package yuyu.batch.hozen.khozen.khdhanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIW_KhHaitouTaisyouWK;

/**
 * 契約保全 契約保全 配当金反映（KhDHanei）の機能DAOクラスです。
 */
public class KhDHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhHaitouTaisyouWKBean> getKhHaitouTaisyouWKByKakutyoujobcdSyoriYmd(String pKakutyoujobcd,BizDate pSyoriYmd) {

        QIW_KhHaitouTaisyouWK qIW_KhHaitouTaisyouWK = new QIW_KhHaitouTaisyouWK("qIW_KhHaitouTaisyouWK") ;

        String strSql = $SELECT + $NEW(KhHaitouTaisyouWKBean.class,
            qIW_KhHaitouTaisyouWK.kbnkey,
            qIW_KhHaitouTaisyouWK.syono,
            qIW_KhHaitouTaisyouWK.haitoumeisaikbn,
            qIW_KhHaitouTaisyouWK.haitoujyoutaihanteikbn,
            qIW_KhHaitouTaisyouWK.haitoushrkijyunymd,
            qIW_KhHaitouTaisyouWK.haitoukbn,
            qIW_KhHaitouTaisyouWK.kihons.getTypeFieldName(),
            qIW_KhHaitouTaisyouWK.kihons.getValueFieldName(),
            qIW_KhHaitouTaisyouWK.haitoukaisuu,
            qIW_KhHaitouTaisyouWK.syouhncd,
            qIW_KhHaitouTaisyouWK.ryouritusdno,
            qIW_KhHaitouTaisyouWK.yoteiriritu,
            qIW_KhHaitouTaisyouWK.hrkkaisuu,
            qIW_KhHaitouTaisyouWK.hhknsei,
            qIW_KhHaitouTaisyouWK.hhknnen,
            qIW_KhHaitouTaisyouWK.hknkknsmnkbn,
            qIW_KhHaitouTaisyouWK.hknkkn,
            qIW_KhHaitouTaisyouWK.hrkkkn,
            qIW_KhHaitouTaisyouWK.dratenendo,
            qIW_KhHaitouTaisyouWK.keisandnendo,
            qIW_KhHaitouTaisyouWK.kyktuukasyu,
            qIW_KhHaitouTaisyouWK.kykymd,
            qIW_KhHaitouTaisyouWK.kykjyoutai,
            qIW_KhHaitouTaisyouWK.dai1hknkkn,
            qIW_KhHaitouTaisyouWK.hrkkknsmnkbn) +
            $FROM(qIW_KhHaitouTaisyouWK) +
            $WHERE  + qIW_KhHaitouTaisyouWK.syoriYmd.eq(pSyoriYmd);

        ExDBResults<KhHaitouTaisyouWKBean> exDBResults = exDBEntityManager.createJPQL(strSql,KhHaitouTaisyouWKBean.class).bind(qIW_KhHaitouTaisyouWK).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

}
