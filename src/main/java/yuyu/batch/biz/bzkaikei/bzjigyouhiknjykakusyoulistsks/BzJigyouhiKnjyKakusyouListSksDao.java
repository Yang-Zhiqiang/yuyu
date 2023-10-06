package yuyu.batch.biz.bzkaikei.bzjigyouhiknjykakusyoulistsks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BT_HuriDenpyou;
import yuyu.def.db.meta.QBT_HuriDenpyou;

/**
 * 事業費勘定確証リスト作成（BzJigyouhiKnjyKakusyouListSks）のDAOクラスです。<br />
 */
public class BzJigyouhiKnjyKakusyouListSksDao {

    private static final String JIGYOUHI = "41101";

    @Inject
    ExDBEntityManager em;

    public List<BT_HuriDenpyou> getJigyouhiHuriDenpyouBySyoriYmd(BizDate pSyoriYmd) {

        QBT_HuriDenpyou qBT_HuriDenpyou = new QBT_HuriDenpyou();

        String strSql = $SELECT + qBT_HuriDenpyou +
            $FROM + qBT_HuriDenpyou.BT_HuriDenpyou() +
            $WHERE + qBT_HuriDenpyou.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_HuriDenpyou.denkanjokamokucd.eq(JIGYOUHI);

        return em.createJPQL(strSql).bind(qBT_HuriDenpyou).getResultList();
    }
}
