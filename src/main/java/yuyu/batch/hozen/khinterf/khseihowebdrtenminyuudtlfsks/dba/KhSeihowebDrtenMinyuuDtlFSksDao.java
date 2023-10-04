package yuyu.batch.hozen.khinterf.khseihowebdrtenminyuudtlfsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_SeihowebMizuhoMinyuuDtl;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ代理店未入契約明細Ｆ作成機能DAOクラスです。<br />
 */
public class KhSeihowebDrtenMinyuuDtlFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SeihoWebMinyuuDtlBean> getSeihoWebMinyuuDtlBeans(String pKakutyouJobCd, BizDateYM pSyoriYm) {

        QIT_SeihowebMizuhoMinyuuDtl qIT_SeihowebMizuhoMinyuuDtl =
            new QIT_SeihowebMizuhoMinyuuDtl("qIT_SeihowebMizuhoMinyuuDtl");

        String subQuery = $SELECT + $NEW(SeihoWebMinyuuDtlBean.class,
            qIT_SeihowebMizuhoMinyuuDtl.kbnkey,
            qIT_SeihowebMizuhoMinyuuDtl.syono,
            qIT_SeihowebMizuhoMinyuuDtl.syoriym,
            qIT_SeihowebMizuhoMinyuuDtl.bosyuucd,
            qIT_SeihowebMizuhoMinyuuDtl.pjytym,
            qIT_SeihowebMizuhoMinyuuDtl.keiyakuymd,
            qIT_SeihowebMizuhoMinyuuDtl.bosyuuym,
            qIT_SeihowebMizuhoMinyuuDtl.hjnkykhyj,
            qIT_SeihowebMizuhoMinyuuDtl.drtenkanrisosikicd,
            qIT_SeihowebMizuhoMinyuuDtl.bosyuudairitengyousyukbn,
            qIT_SeihowebMizuhoMinyuuDtl.drtencd,
            qIT_SeihowebMizuhoMinyuuDtl.cifcd,
            qIT_SeihowebMizuhoMinyuuDtl.atesakinm,
            qIT_SeihowebMizuhoMinyuuDtl.minyujytymdyofuri,
            qIT_SeihowebMizuhoMinyuuDtl.minyujytymdyofuriigi,
            qIT_SeihowebMizuhoMinyuuDtl.hassinka,
            qIT_SeihowebMizuhoMinyuuDtl.telno,
            qIT_SeihowebMizuhoMinyuuDtl.tntnm10keta,
            qIT_SeihowebMizuhoMinyuuDtl.kydatkikbnkj,
            qIT_SeihowebMizuhoMinyuuDtl.kyknm35keta,
            qIT_SeihowebMizuhoMinyuuDtl.hrkkaisuukj,
            qIT_SeihowebMizuhoMinyuuDtl.hrkkeirokj,
            qIT_SeihowebMizuhoMinyuuDtl.hrkp.getTypeFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.hrkp.getValueFieldName(),
            qIT_SeihowebMizuhoMinyuuDtl.knkimnyuuryu,
            qIT_SeihowebMizuhoMinyuuDtl.jikaiminyuuji,
            qIT_SeihowebMizuhoMinyuuDtl.tntusygyouhaiinfo,
            qIT_SeihowebMizuhoMinyuuDtl.hrkkeirobtjhmidasi,
            qIT_SeihowebMizuhoMinyuuDtl.hrkkeirobtjh,
            qIT_SeihowebMizuhoMinyuuDtl.hknsyuruinm30keta,
            qIT_SeihowebMizuhoMinyuuDtl.dbskyoteiym) +
            $FROM(qIT_SeihowebMizuhoMinyuuDtl) +
            $WHERE + qIT_SeihowebMizuhoMinyuuDtl.syoriym.eq(pSyoriYm);

        ExDBResults<SeihoWebMinyuuDtlBean> exDBResults = exDBEntityManager.createJPQL(subQuery,
            SeihoWebMinyuuDtlBean.class).bind(qIT_SeihowebMizuhoMinyuuDtl).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
