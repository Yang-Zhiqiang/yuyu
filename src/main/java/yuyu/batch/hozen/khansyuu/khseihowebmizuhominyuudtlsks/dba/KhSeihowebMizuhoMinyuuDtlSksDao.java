package yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;

/**
 * 契約保全 案内収納 生保Ｗｅｂ・みずほ用未入明細作成機能DAOクラスです。
 */
public class KhSeihowebMizuhoMinyuuDtlSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSeihowebMizuhoMinyuuDtlSksBean> getKhSeihowebMizuhoMinyuuDtlSksBeans(String pKakutyouJobCd,
        BizDateYM pSyoribiYm) {
        QIT_DrtenMinyuKykNaiyou qIT_DrtenMinyuKykNaiyou = new QIT_DrtenMinyuKykNaiyou("qIT_DrtenMinyuKykNaiyou");
        String sql = $SELECT + $NEW(KhSeihowebMizuhoMinyuuDtlSksBean.class,
            qIT_DrtenMinyuKykNaiyou.kbnkey,
            qIT_DrtenMinyuKykNaiyou.syono,
            qIT_DrtenMinyuKykNaiyou.minyusyoriymd,
            qIT_DrtenMinyuKykNaiyou.bosyuuym,
            qIT_DrtenMinyuKykNaiyou.kydatkikbnkj,
            qIT_DrtenMinyuKykNaiyou.kyknm35keta,
            qIT_DrtenMinyuKykNaiyou.cifcd,
            qIT_DrtenMinyuKykNaiyou.jyuutouym,
            qIT_DrtenMinyuKykNaiyou.hrkp.getTypeFieldName(),
            qIT_DrtenMinyuKykNaiyou.hrkp.getValueFieldName(),
            qIT_DrtenMinyuKykNaiyou.keiyakuymd,
            qIT_DrtenMinyuKykNaiyou.hhknnmkj,
            qIT_DrtenMinyuKykNaiyou.tsintelno,
            qIT_DrtenMinyuKykNaiyou.dai2tsintelno,
            qIT_DrtenMinyuKykNaiyou.bankcd,
            qIT_DrtenMinyuKykNaiyou.sitencd,
            qIT_DrtenMinyuKykNaiyou.yokinkbn,
            qIT_DrtenMinyuKykNaiyou.kouzano,
            qIT_DrtenMinyuKykNaiyou.hrkkaisuu,
            qIT_DrtenMinyuKykNaiyou.hrkkeiro,
            qIT_DrtenMinyuKykNaiyou.tikiktbrisyuruikbn,
            qIT_DrtenMinyuKykNaiyou.tsinkihontikucd,
            qIT_DrtenMinyuKykNaiyou.kanjitsinkaiadr,
            qIT_DrtenMinyuKykNaiyou.kzmeiginmkn,
            qIT_DrtenMinyuKykNaiyou.jkiannaikg.getTypeFieldName(),
            qIT_DrtenMinyuKykNaiyou.jkiannaikg.getValueFieldName(),
            qIT_DrtenMinyuKykNaiyou.yykknmnryymd,
            qIT_DrtenMinyuKykNaiyou.hurihunokbn,
            qIT_DrtenMinyuKykNaiyou.nexthurikaeymd,
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikbn,
            qIT_DrtenMinyuKykNaiyou.ikkatubaraikaisuu,
            qIT_DrtenMinyuKykNaiyou.dairitencd1,
            qIT_DrtenMinyuKykNaiyou.bosyuucd1,
            qIT_DrtenMinyuKykNaiyou.drtenkanrisosikicd1,
            qIT_DrtenMinyuKykNaiyou.drtenchannelsyuruikbn1,
            qIT_DrtenMinyuKykNaiyou.dairitencd2,
            qIT_DrtenMinyuKykNaiyou.bosyuucd2,
            qIT_DrtenMinyuKykNaiyou.drtenkanrisosikicd2,
            qIT_DrtenMinyuKykNaiyou.drtenchannelsyuruikbn2) +
            $FROM(qIT_DrtenMinyuKykNaiyou) +
            $WHERE + qIT_DrtenMinyuKykNaiyou.syoriym.eq(pSyoribiYm);

        ExDBResults<KhSeihowebMizuhoMinyuuDtlSksBean> exDBResults = exDBEntityManager.createJPQL(sql,
            KhSeihowebMizuhoMinyuuDtlSksBean.class).bind(qIT_DrtenMinyuKykNaiyou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
