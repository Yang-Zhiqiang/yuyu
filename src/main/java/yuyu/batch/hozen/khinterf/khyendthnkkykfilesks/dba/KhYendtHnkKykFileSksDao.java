package yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 契約保全 インターフェイス 円建変更契約ファイル作成Daoクラス<br />
 */
public class KhYendtHnkKykFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<KhYendtHnkKykBean> getKhYendtHnkKykBeans(BizDate pSyoriYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");
        QIT_KhHenkouUktkYendtHnk qIT_KhHenkouUktkYendtHnk = new QIT_KhHenkouUktkYendtHnk("qIT_KhHenkouUktkYendtHnk");
        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        String sql = $SELECT + $NEW(KhYendtHnkKykBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.syoumetujiyuu,
            qIT_KykSyouhn.hknkkn,
            qIT_KhHenkouUktk.hozenhenkouuktkrenno,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktkYendtHnk.yendthnkymd,
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhryen.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkaiyakuhryen.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkhr.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkhr.getValueFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkihons.getTypeFieldName(),
            qIT_KhHenkouUktkYendtHnk.yendthnkkihons.getValueFieldName(),
            qIT_KykSya.kyknmkj) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KhHenkouUktk,
                qIT_KhHenkouUktkYendtHnk,
                qIT_KhTtdkRireki,
                qIT_KykSya) +
                $WHERE + qIT_KhHenkouUktk.syono.eq(qIT_KhTtdkRireki.syono) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.kyktuukasyu.eq(C_Tuukasyu.JPY) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KhHenkouUktkYendtHnk.syono) +
                $AND + qIT_KhHenkouUktk.hozenhenkouuktkrenno.eq(qIT_KhHenkouUktkYendtHnk.hozenhenkouuktkrenno) +
                $AND + $(qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.YENDTHNK_MKHGKTTT) +
                    $OR + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.YENDTHNK_NINISEIKYUU)) +
                    $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
                    $AND + qIT_KhHenkouUktk.syono.eq(qIT_KykSya.syono) +
                    $ORDER_BY (qIT_KykKihon.syono.asc(),
                        qIT_KhHenkouUktk.hozenhenkouuktkrenno.desc());

        return exDBEntityManager.createJPQL(sql, KhYendtHnkKykBean.class).bind(qIT_KykKihon,
            qIT_KykSyouhn, qIT_KhHenkouUktk, qIT_KhHenkouUktkYendtHnk, qIT_KhTtdkRireki, qIT_KykSya).getResultList();
    }

    public KykSyouhnHnkmaeBean getKykSyouhnHnkmaeBeanMaxRennoSyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae  = new QIT_KykSyouhnHnkmae("qIT_KykSyouhnHnkmae");

        String sql = $SELECT + $NEW(KykSyouhnHnkmaeBean.class,
            qIT_KykSyouhnHnkmae.hokenryou.getTypeFieldName(),
            qIT_KykSyouhnHnkmae.hokenryou.getValueFieldName(),
            qIT_KykSyouhnHnkmae.kyktuukasyu,
            qIT_KykSyouhnHnkmae.targettkmokuhyouti,
            qIT_KykSyouhnHnkmae.targettkykkijyungk.getTypeFieldName(),
            qIT_KykSyouhnHnkmae.targettkykkijyungk.getValueFieldName()) +
            $FROM(qIT_KykSyouhnHnkmae) +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnHnkmae.syutkkbn.eq(pSyutkkbn) +
            $ORDER_BY (qIT_KykSyouhnHnkmae.renno.desc());

        return exDBEntityManager.createJPQL(sql, KykSyouhnHnkmaeBean.class).setFirstResult(0).setMaxResults(1).bind(
            qIT_KykSyouhnHnkmae).getSingleResult();
    }
}
