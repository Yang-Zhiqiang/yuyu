package yuyu.batch.hozen.khinterf.khkessanzennoufsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.db.meta.QIT_ZennouKessan;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 インターフェイス 決算用前納Ｆ作成DAOクラスです。<br />
 */
public class KhKessanZennouFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KessanZennouBean> getKessanZennou(BizDate pSakuseiymd) {

        QIT_ZennouKessan qIT_ZennouKessan = new QIT_ZennouKessan("qIT_ZennouKessan");

        String sql = $SELECT + $NEW(KessanZennouBean.class,
            qIT_ZennouKessan.syono,
            qIT_ZennouKessan.kbnkeirisegcd,
            qIT_ZennouKessan.zennoutoukeilistkbn,
            qIT_ZennouKessan.zennoukbn,
            qIT_ZennouKessan.zennoustartym,
            qIT_ZennouKessan.zennoukaisiymd,
            qIT_ZennouKessan.zennoukaisijizndk.getTypeFieldName(),
            qIT_ZennouKessan.zennoukaisijizndk.getValueFieldName(),
            qIT_ZennouKessan.keiyakuymd,
            qIT_ZennouKessan.zennouwrbkrt,
            qIT_ZennouKessan.rthndzndk1.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk1.getValueFieldName(),
            qIT_ZennouKessan.tkyrt1,
            qIT_ZennouKessan.rthndymd1,
            qIT_ZennouKessan.rthndzndk2.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk2.getValueFieldName(),
            qIT_ZennouKessan.tkyrt2,
            qIT_ZennouKessan.rthndymd2,
            qIT_ZennouKessan.rthndzndk3.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk3.getValueFieldName(),
            qIT_ZennouKessan.tkyrt3,
            qIT_ZennouKessan.rthndymd3,
            qIT_ZennouKessan.rthndzndk4.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk4.getValueFieldName(),
            qIT_ZennouKessan.tkyrt4,
            qIT_ZennouKessan.rthndymd4,
            qIT_ZennouKessan.tndmatuzndk.getTypeFieldName(),
            qIT_ZennouKessan.tndmatuzndk.getValueFieldName(),
            qIT_ZennouKessan.tndmatutkyrt,
            qIT_ZennouKessan.zennounyuukinymd,
            qIT_ZennouKessan.tndzndkhikakukbn,
            qIT_ZennouKessan.zennoukikan,
            qIT_ZennouKessan.bosyuukeitaikbn,
            qIT_ZennouKessan.gkdtznnhyj,
            qIT_ZennouKessan.znngaikakbn,
            qIT_ZennouKessan.yenkanyknhyj,
            qIT_ZennouKessan.znnnyknjikawaserate,
            qIT_ZennouKessan.znnnyknjikawaseratetkyuymd,
            qIT_ZennouKessan.ksnkisikawaserate,
            qIT_ZennouKessan.tndmatuzndkksnjkwsrate,
            qIT_ZennouKessan.zennounyuukinkgkgaika.getTypeFieldName(),
            qIT_ZennouKessan.zennounyuukinkgkgaika.getValueFieldName(),
            qIT_ZennouKessan.zennounyuukinkgktkmatu.getTypeFieldName(),
            qIT_ZennouKessan.zennounyuukinkgktkmatu.getValueFieldName(),
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getTypeFieldName(),
            qIT_ZennouKessan.zennoukaisijizndktkmatu.getValueFieldName(),
            qIT_ZennouKessan.rthndzndk1tkmatu.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk1tkmatu.getValueFieldName(),
            qIT_ZennouKessan.rthndzndk2tkmatu.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk2tkmatu.getValueFieldName(),
            qIT_ZennouKessan.rthndzndk3tkmatu.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk3tkmatu.getValueFieldName(),
            qIT_ZennouKessan.rthndzndk4tkmatu.getTypeFieldName(),
            qIT_ZennouKessan.rthndzndk4tkmatu.getValueFieldName(),
            qIT_ZennouKessan.tndmatuzndktkmatu.getTypeFieldName(),
            qIT_ZennouKessan.tndmatuzndktkmatu.getValueFieldName()) +
            $FROM(qIT_ZennouKessan) +
            $WHERE + qIT_ZennouKessan.sakuseiymd.eq(pSakuseiymd);

        return exDBEntityManager.createJPQL(sql, KessanZennouBean.class).bind(qIT_ZennouKessan).getResults();
    }
}
