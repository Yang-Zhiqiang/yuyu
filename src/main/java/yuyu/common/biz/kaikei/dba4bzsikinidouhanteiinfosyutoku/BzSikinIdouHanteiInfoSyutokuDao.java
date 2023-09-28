package yuyu.common.biz.kaikei.dba4bzsikinidouhanteiinfosyutoku;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SyouhnZokusei;

/**
 * 業務共通 経理・会計 資金移動判定情報取得Daoクラス
 */
public class BzSikinIdouHanteiInfoSyutokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<SikinIdouHanteiInfoBean> getSikinIdouHanteiInfoBeans() {

        QBM_SegmentSikinidou qBM_SegmentSikinidou = new QBM_SegmentSikinidou("qBM_SegmentSikinidou");

        QBM_SyouhnZokusei qBM_SyouhnZokuseiA = new QBM_SyouhnZokusei("qBM_SyouhnZokuseiA");

        QBM_SyouhnZokusei qBM_SyouhnZokuseiB = new QBM_SyouhnZokusei("qBM_SyouhnZokuseiB");

        String subQuerry = $SELECT + qBM_SyouhnZokuseiB.syouhncd +
            $FROM(qBM_SyouhnZokuseiB) +
            $WHERE + qBM_SyouhnZokuseiB.syouhncd.eq(qBM_SyouhnZokuseiA.syouhncd) +
            $AND + qBM_SyouhnZokuseiB.syouhnsdno.gt(qBM_SyouhnZokuseiA.syouhnsdno);

        String mainQuerry = $SELECT + $NEW(
            SikinIdouHanteiInfoBean.class,
            qBM_SegmentSikinidou.segcd,
            qBM_SegmentSikinidou.hijynnykzndkkouzakbn,
            qBM_SegmentSikinidou.fstpgkhnkzidourt,
            qBM_SegmentSikinidou.zenkizennougkhnkzidourt,
            qBM_SegmentSikinidou.keizokupgkhnkzidourt,
            qBM_SegmentSikinidou.seiymdseitstuityouhnknumu,
            qBM_SyouhnZokuseiA.zeiseitekikakuumu,
            qBM_SyouhnZokuseiA.itijibrumu,
            qBM_SyouhnZokuseiA.sbhkuktumu,
            qBM_SyouhnZokuseiA.sbkyuuhukinuktumu) +
            $FROM(qBM_SegmentSikinidou,
                qBM_SyouhnZokuseiA) +
                $WHERE + $NOT_EXISTS(subQuerry) +
                $AND + qBM_SegmentSikinidou.daihyousyouhncd.eq(qBM_SyouhnZokuseiA.syouhncd);

        return exDBEntityManager.createJPQL(mainQuerry, SikinIdouHanteiInfoBean.class)
            .bind(qBM_SegmentSikinidou, qBM_SyouhnZokuseiA, qBM_SyouhnZokuseiB).getResultList();
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd) {

        QBM_SyouhnZokusei qBM_SyouhnZokuseiA = new QBM_SyouhnZokusei("qBM_SyouhnZokuseiA");

        QBM_SyouhnZokusei qBM_SyouhnZokuseiB = new QBM_SyouhnZokusei("qBM_SyouhnZokuseiB");

        String subQuerry = $SELECT + qBM_SyouhnZokuseiB.syouhncd +
            $FROM(qBM_SyouhnZokuseiB) +
            $WHERE + qBM_SyouhnZokuseiB.syouhncd.eq(qBM_SyouhnZokuseiA.syouhncd) +
            $AND + qBM_SyouhnZokuseiB.syouhnsdno.gt(qBM_SyouhnZokuseiA.syouhnsdno);

        String mainQuerry = $SELECT + qBM_SyouhnZokuseiA +
            $FROM(qBM_SyouhnZokuseiA) +
            $WHERE + qBM_SyouhnZokuseiA.syouhncd.eq(pSyouhncd) +
            $AND + $NOT_EXISTS(subQuerry);

        return exDBEntityManager.createJPQL(mainQuerry).bind(qBM_SyouhnZokuseiA, qBM_SyouhnZokuseiB).getSingleResult();
    }
}
