package yuyu.batch.hozen.khozen.khdhaneisel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 契約保全 配当金反映対象抽出機能DAOクラス
 */
public class KhDHaneiSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HaitoukinHanneiBean> getHaitoukinHanneiByKakutyoujobcd(BizDate pSyoriYokueigyohiZennen,
        BizDateY pSyoriYokueigyohiJigyounendo, String pKakutyoujobcd){

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("QIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("QIT_KykSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("QBM_SyouhnZokusei");

        String strSql = $SELECT + $NEW(HaitoukinHanneiBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.haitoukinuketorihoukbn,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.haitounendo,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.yoteiriritu,
            qIT_KykSyouhn.hhknsei,
            qIT_KykSyouhn.hhknnen,
            qIT_KykSyouhn.hknkknsmnkbn,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hrkkkn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.yendthnkymd,
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykSyouhn.hrkkknsmnkbn,
            qIT_KykSyouhn.dai1hknkkn,
            qBM_SyouhnZokusei.haitoukbn) +

            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei) +

                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qBM_SyouhnZokusei.haitoukbn.ne(C_HaitouKbn.NONE) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.kykymd.le(pSyoriYokueigyohiZennen) +
                $AND + $(qIT_KykKihon.haitounendo.isNull() +
                    $OR + qIT_KykKihon.haitounendo.ne(pSyoriYokueigyohiJigyounendo));

        ExDBResults<HaitoukinHanneiBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, HaitoukinHanneiBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qBM_SyouhnZokusei).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
