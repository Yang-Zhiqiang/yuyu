package yuyu.common.biz.kaikei.dba4bzjkusymtgosknidougkkeisan;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;

/**
 * 業務共通 経理・会計 時効消滅後資金移動額計算Daoクラス
 */
public class BzJkuSymtgoSknidougkKeisanDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<SknidouzmgkBean> getSknidouzmgkBeans(String pSyono, BizDateYM pMkkpZennouseisanJyuutouym) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks");

        String mainQuerry = $SELECT + $NEW(SknidouzmgkBean.class,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName()) +
            $FROM(qBT_HijynNykSikinIdouListSks) +
            $WHERE + (qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.ge(pMkkpZennouseisanJyuutouym) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUKANRYOU));
        return exDBEntityManager.createJPQL(mainQuerry, SknidouzmgkBean.class).bind(qBT_HijynNykSikinIdouListSks)
            .getResultList();
    }

}
