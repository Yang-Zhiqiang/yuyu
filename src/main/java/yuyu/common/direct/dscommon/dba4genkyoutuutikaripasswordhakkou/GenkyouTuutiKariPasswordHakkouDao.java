package yuyu.common.direct.dscommon.dba4genkyoutuutikaripasswordhakkou;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QMT_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;

/**
 * ダイレクトサービス ダイレクトサービス共通 現況通知用仮パスワード発行Daoクラス
 */
public class GenkyouTuutiKariPasswordHakkouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean
    getDsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUM(String pSyoNo) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsHonninKakuninCd qMT_DsHonninKakuninCd = new QMT_DsHonninKakuninCd("qMT_DsHonninKakuninCd");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String strSql = $SELECT + $NEW(DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.class,
            qMT_DsHonninKakuninCd.dskrhnnkakcd,
            qMT_DsHonninKakuninCd.zenkaidskrhnnkakcd,
            qMT_DsHonninKakuninCd.dskrhnnkakcdyuukouymd,
            qMT_DsKokyakuKeiyaku.dskykmukouhyj,
            qMT_DsKokyakuKanri.dskokyakujtkbn,
            qMT_DsKokyakuKanri.dsteisiriyuukbn,
            qMT_DsKokyakuKanri.dskokno,
            qMT_DsHonninKakuninCd.dskrhnnkakcdsetkbn,
            qMT_DsKokyakuKanri.dskokyakuseiymd,
            qIT_KykSya.tsintelno
            ) +
            $FROM(qMT_DsKokyakuKanri,
                qMT_DsHonninKakuninCd,
                qMT_DsKokyakuKeiyaku,
                qIT_KykSya) +
                $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyoNo) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsHonninKakuninCd.dskokno) +
                $AND + qIT_KykSya.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
                $ORDER_BY(qMT_DsKokyakuKeiyaku.dskokno.desc());

        return exDBEntityManager.createJPQL(strSql,
            DsGenkyouTuutiKariPasswordTeijiHandanKijyunBySyonoROWNUMBean.class).
            setFirstResult(0).setMaxResults(1).bind(qMT_DsKokyakuKanri, qMT_DsHonninKakuninCd, qMT_DsKokyakuKeiyaku
                , qIT_KykSya).getSingleResult();
    }

    public MT_DsKokyakuKanri detachDsTorihikiServiceKanri(MT_DsKokyakuKanri pEntity) {

        if (pEntity != null) {

            pEntity.getDsKokyakuKeiyakus().size();

            List<MT_DsKokyakuKeiyaku> entityLst = pEntity.getDsKokyakuKeiyakus();

            for (MT_DsKokyakuKeiyaku entity : entityLst) {

                entity.getDsTorihikiServiceKanris().size();
            }
            pEntity.detach();
            return pEntity;
        }

        return null;
    }

}
