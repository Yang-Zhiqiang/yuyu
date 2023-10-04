package yuyu.batch.hozen.khozen.tyohyouhonbankakunin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.common.hozen.khcommon.TyohyouHonbanKakuninBean;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KykKihon;

/**
 * 契約保全 契約保全 帳票本番確認DAOクラス
 */
public class TyohyouHonbanKakuninBatchDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBUpdatableResults<IT_KykKihon> getKykKihonInfos(String pKakutyouJobCd, String pSyoriYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + qIT_KykKihon +
            $FROM(qIT_KykKihon) +
            $WHERE + qIT_KykKihon.gyoumuKousinTime.ge(pSyoriYmd);

        ExDBUpdatableResults<IT_KykKihon> exDBUpdatableResults = exDBEntityManager.createJPQL(strSql).bind(qIT_KykKihon).getUpdatableResults();

        exDBUpdatableResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBUpdatableResults;
    }

    public List<TyohyouHonbanKakuninBean> getKhTyouhyouHonbanKakuninMikakuninInfos(C_TyouhyouBunruiKbn pTyouhyouBunrui, BizDate pHonbanKakuninStartYmd) {

        QIT_KhTyouhyouHonbanKakunin qIT_KhTyouhyouHonbanKakunin = new QIT_KhTyouhyouHonbanKakunin("qIT_KhTyouhyouHonbanKakunin");

        String strSql = $SELECT + $NEW(TyohyouHonbanKakuninBean.class,
            qIT_KhTyouhyouHonbanKakunin.tyouhyoubunrui,
            qIT_KhTyouhyouHonbanKakunin.syoruiCd,
            qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui1,
            qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui2,
            qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui3,
            qIT_KhTyouhyouHonbanKakunin.kakuninjyoutaikbn) +
            $FROM(qIT_KhTyouhyouHonbanKakunin) +
            $WHERE + qIT_KhTyouhyouHonbanKakunin.tyouhyoubunrui.eq(pTyouhyouBunrui) +
            $AND + qIT_KhTyouhyouHonbanKakunin.honbankakuninstartymd.le(pHonbanKakuninStartYmd) +
            $AND + qIT_KhTyouhyouHonbanKakunin.kakuninjyoutaikbn.ne(C_KakuninjyoutaiKbn.KAKUNINZUMI);

        return exDBEntityManager.createJPQL(strSql, TyohyouHonbanKakuninBean.class).bind(qIT_KhTyouhyouHonbanKakunin).getResultList();
    }

}
