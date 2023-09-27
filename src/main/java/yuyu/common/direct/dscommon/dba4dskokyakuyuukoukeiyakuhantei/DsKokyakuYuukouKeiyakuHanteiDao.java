package yuyu.common.direct.dscommon.dba4dskokyakuyuukoukeiyakuhantei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ顧客有効契約判定Dao
 */
public class DsKokyakuYuukouKeiyakuHanteiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<DsKokyakuKeiyakuInfoBean> getDsKokyakuKeiyakuInfoByDskokno(String pDsKokNo) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");

        String strSql = $SELECT + $NEW(DsKokyakuKeiyakuInfoBean.class,
            qMT_DsKokyakuKeiyaku.syono)                        +
            $FROM(qMT_DsKokyakuKeiyaku)                        +
            $WHERE + qMT_DsKokyakuKeiyaku.dskokno.eq(pDsKokNo) +
            $AND   + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        return exDBEntityManager.createJPQL(strSql, DsKokyakuKeiyakuInfoBean.class).bind(qMT_DsKokyakuKeiyaku).getResultList();
    }

    public Long getKykSyouhnCountBySyono(String pSyoNo) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $COUNT + " (*) "             +
            $FROM(qIT_KykSyouhn)                               +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyoNo)            +
            $AND   + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND   + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn).getSingleResult();
    }

    public Long getSibouKariuketsukeCountBySyono(String pSyoNo) {

        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke("qJT_SibouKariuketsuke");

        String strSql = $SELECT + $COUNT + " (*) "                     +
            $FROM(qJT_SibouKariuketsuke)                               +
            $WHERE + qJT_SibouKariuketsuke.syono.eq(pSyoNo)            +
            $AND   + qJT_SibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE);

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SibouKariuketsuke).getSingleResult();
    }
}
