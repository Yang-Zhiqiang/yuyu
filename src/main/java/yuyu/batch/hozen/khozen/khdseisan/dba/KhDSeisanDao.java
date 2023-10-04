package yuyu.batch.hozen.khozen.khdseisan.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_SiTyousyo;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 契約保全 契約保全 精算ＤDAOクラス
 */
public class KhDSeisanDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhDSeisanBean> getKhDSeisanDaoByKessankijyunymdDratekakuteiymdSyoumetujiyuus(
        BizDate pKessanKijyunYmd, BizDate pDrateKakuteiYmd, C_Syoumetujiyuu[] pSyoumetuJiyuus, String pKakutyoujobCd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String mainStr = $SELECT + $NEW(KhDSeisanBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.stknsetkbn,
            qIT_KykKihon.haitounendo,
            qIT_KykSya.tsinyno,
            qIT_KykSya.kyknmkj,
            qIT_KykSyouhn.henkousikibetukey,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.yoteiriritu,
            qIT_KykSyouhn.hhknsei,
            qIT_KykSyouhn.hhknnen,
            qIT_KykSyouhn.hknkknsmnkbn,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hrkkknsmnkbn,
            qIT_KykSyouhn.hrkkkn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.yendthnkymd,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KykSyouhn.kykjyoutai,
            qIT_KykSyouhn.syoumetuymd,
            qIT_KykSyouhn.syoumetujiyuu,
            qIT_KykSyouhn.dai1hknkkn,
            qIT_AnsyuKihon.jkipjytym) +
            $FROM (qIT_KykKihon,
                qIT_KykSya,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei,
                qIT_AnsyuKihon
                ) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qBM_SyouhnZokusei.haitoukbn.ne(C_HaitouKbn.NONE ) +
                $AND + qIT_KykSyouhn.syoumetuymd.ge(pKessanKijyunYmd) +
                $AND + qIT_KykSyouhn.syoumetuymd.lt(pDrateKakuteiYmd) +
                $AND + qIT_KykSyouhn.syoumetujiyuu + "IN" + "(" + pSyoumetuJiyuus[0].getValue() + ","+
                pSyoumetuJiyuus[1].getValue() + "," +
                pSyoumetuJiyuus[2].getValue() + "," +
                pSyoumetuJiyuus[3].getValue() + "," +
                pSyoumetuJiyuus[4].getValue() + "," +
                pSyoumetuJiyuus[5].getValue() + "," +
                pSyoumetuJiyuus[6].getValue() + ")" ;

        ExDBResults<KhDSeisanBean> exDBResults = exDBEntityManager.createJPQL(mainStr, KhDSeisanBean.class)
            .bind(qIT_KykKihon, qIT_KykSya, qIT_KykSyouhn, qBM_SyouhnZokusei).getResults();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobCd));

        return exDBResults;
    }

    public IT_KhHaitouKanri getKhHaitouKanriBySyonoHaitounendon(String pSyono, String pHaitouNendon) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String mainStr = $SELECT  + qIT_KhHaitouKanri +
            $FROM (qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitounendo.eq(BizDateY.valueOf(pHaitouNendon)) +
            $AND + qIT_KhHaitouKanri.haitoukinskskbn.ne(C_HaitoukinsksKbn.SEISIKI) +
            $AND + qIT_KhHaitouKanri.haitoukinskskbn.ne(C_HaitoukinsksKbn.YENDTHNKSEISIKI) +
            $ORDER_BY (qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(mainStr).setFirstResult(0).setMaxResults(1).bind(qIT_KhHaitouKanri)
            .getSingleResult();
    }

    public JT_Sk getSkBySyono(String pSyono) {

        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");
        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");

        String mainStr = $SELECT + qJT_Sk +
            $FROM (qJT_Sk,
                qJT_SkKihon) +
                $WHERE + qJT_SkKihon.syono.eq(pSyono)+
                $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
                $AND + qJT_SkKihon.syono.eq(qJT_Sk.syono) +
                $AND + qJT_SkKihon.skno.eq(qJT_Sk.skno) +
                $ORDER_BY(qJT_Sk.seikyuurirekino.desc());

        return exDBEntityManager.createJPQL(mainStr).setFirstResult(0).setMaxResults(1).bind(qJT_Sk, qJT_SkKihon)
            .getSingleResult();
    }

    public IT_KykSyouhnRireki getKhTtdkRirekiInfosBySyonoKouryokuhasseiymdGyoumukousinkinou(String pSyono,
        BizDate pKouryokuHasseiYmdFrom, BizDate pKouryokuHasseiYmdTo, String pGyoumuKousinKinou) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String mainStr = $SELECT + qIT_KykSyouhnRireki +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono)+
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.ge(pKouryokuHasseiYmdFrom) +
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.le(pKouryokuHasseiYmdTo) +
            $AND + qIT_KykSyouhnRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $ORDER_BY(qIT_KykSyouhnRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(mainStr).setFirstResult(0).setMaxResults(1).bind(qIT_KykSyouhnRireki)
            .getSingleResult();
    }

    public JT_SiRireki getSiRirekiBySknoSyono(String pSkno, String pSyono) {

        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki("qJT_SiRireki");

        String mainStr = $SELECT + qJT_SiRireki +
            $FROM(qJT_SiRireki) +
            $WHERE + qJT_SiRireki.skno.eq(pSkno) +
            $AND + qJT_SiRireki.syono.eq(pSyono) +
            $ORDER_BY(qJT_SiRireki.shrsikibetukey.desc());

        return exDBEntityManager.createJPQL(mainStr).setFirstResult(0).setMaxResults(1).bind(qJT_SiRireki)
            .getSingleResult();
    }

    public JT_SiTyousyo getSiTyousyoBySyono(String pSyono) {

        QJT_SiTyousyo qJT_SiTyousyo = new QJT_SiTyousyo("qJT_SiTyousyo");

        String mainStr = $SELECT + qJT_SiTyousyo +
            $FROM(qJT_SiTyousyo) +
            $WHERE + qJT_SiTyousyo.syono.eq(pSyono) +
            $AND + qJT_SiTyousyo.shrtysykurikosidisp.eq("1") +
            $ORDER_BY(qJT_SiTyousyo.tyouhyouymd.desc(),
                qJT_SiTyousyo.shrtysyrenno.desc());

        return exDBEntityManager.createJPQL(mainStr).setFirstResult(0).setMaxResults(1).bind(qJT_SiTyousyo)
            .getSingleResult();
    }
}
