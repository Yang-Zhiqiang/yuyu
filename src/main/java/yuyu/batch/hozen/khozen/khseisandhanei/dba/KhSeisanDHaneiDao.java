package yuyu.batch.hozen.khozen.khseisandhanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

/**
 * 契約保全 契約保全 精算Ｄ反映機能DAOクラス
 */
public class KhSeisanDHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhHaitouKanriBean> getKhHaitouKanriBeans(String pKakutyoujobcd, BizDateY pSyoriYmdJigyounendo) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + $NEW(KhHaitouKanriBean.class,
            qIT_KhHaitouKanri.kbnkey,
            qIT_KhHaitouKanri.syono,
            qIT_KhHaitouKanri.haitounendo,
            qIT_KhHaitouKanri.renno,
            qIT_KhHaitouKanri.haitoukinskskbn,
            qIT_KhHaitouKanri.haitoumeisaikbn,
            qIT_KhHaitouKanri.fstkariwariatednendo,
            qIT_KhHaitouKanri.tounendod.getTypeFieldName(),
            qIT_KhHaitouKanri.tounendod.getValueFieldName(),
            qIT_KhHaitouKanri.naiteikakuteikbn,
            qIT_KhHaitouKanri.kariwariatedshrymd,
            qIT_KhHaitouKanri.kariwariatedruigk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedruigk.getValueFieldName(),
            qIT_KhHaitouKanri.kariwariatedgngkkngk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedgngkkngk.getValueFieldName(),
            qIT_KhHaitouKanri.kariwariatedshrgk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedshrgk.getValueFieldName()) +

            $FROM(qIT_KykSyouhn,
                qIT_KhHaitouKanri) +

                $WHERE + qIT_KhHaitouKanri.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(C_HaitoumeisaiKbn.SYU) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KhHaitouKanri.naiteikakuteikbn.eq(C_NaiteiKakuteiKbn.NAITEI) +
                $AND + qIT_KhHaitouKanri.haitounendo.eq(pSyoriYmdJigyounendo) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU)+
                $ORDER_BY(qIT_KhHaitouKanri.syono.asc(),
                    qIT_KhHaitouKanri.renno.asc());

        ExDBResults<KhHaitouKanriBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhHaitouKanriBean.class)
            .bind(qIT_KhHaitouKanri, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public KhHaitouKanriBean getKhHaitouKanriBeanBySyonoHaitoumeisaikbn(String pSyono,
        C_HaitoumeisaiKbn pHaitoumeisaikbn) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + $NEW(KhHaitouKanriBean.class,
            qIT_KhHaitouKanri.kbnkey,
            qIT_KhHaitouKanri.syono,
            qIT_KhHaitouKanri.haitounendo,
            qIT_KhHaitouKanri.renno,
            qIT_KhHaitouKanri.haitoukinskskbn,
            qIT_KhHaitouKanri.haitoumeisaikbn,
            qIT_KhHaitouKanri.fstkariwariatednendo,
            qIT_KhHaitouKanri.tounendod.getTypeFieldName(),
            qIT_KhHaitouKanri.tounendod.getValueFieldName(),
            qIT_KhHaitouKanri.naiteikakuteikbn,
            qIT_KhHaitouKanri.kariwariatedshrymd,
            qIT_KhHaitouKanri.kariwariatedruigk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedruigk.getValueFieldName(),
            qIT_KhHaitouKanri.kariwariatedgngkkngk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedgngkkngk.getValueFieldName(),
            qIT_KhHaitouKanri.kariwariatedshrgk.getTypeFieldName(),
            qIT_KhHaitouKanri.kariwariatedshrgk.getValueFieldName()) +

            $FROM(qIT_KhHaitouKanri) +

            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaikbn) +
            $AND + qIT_KhHaitouKanri.naiteikakuteikbn.eq(C_NaiteiKakuteiKbn.KAKUTEI) +
            $ORDER_BY(qIT_KhHaitouKanri.haitounendo.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhHaitouKanri)
            .getSingleResult();
    }

    public KhTumitateDKanriBean getKhTumitateDKanriBeanBySyonoTumitatedtumitateymdTumitatedskskbn(String pSyono,
        BizDate pTumitatedtumitateymd, C_TumitateDSakuseiKbn pTumitatedskskbn) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + $NEW(KhTumitateDKanriBean.class,
            qIT_KhTumitateDKanri.kbnkey,
            qIT_KhTumitateDKanri.syono,
            qIT_KhTumitateDKanri.tumitatedtumitateymd,
            qIT_KhTumitateDKanri.renno,
            qIT_KhTumitateDKanri.tumitatedskskbn,
            qIT_KhTumitateDKanri.tumitated.getTypeFieldName(),
            qIT_KhTumitateDKanri.tumitated.getValueFieldName(),
            qIT_KhTumitateDKanri.tumitatedshrkrkymd,
            qIT_KhTumitateDKanri.naiteikakuteikbn) +

            $FROM(qIT_KhTumitateDKanri) +

            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.eq(pTumitatedtumitateymd) +
            $AND + qIT_KhTumitateDKanri.tumitatedskskbn.eq(pTumitatedskskbn) +
            $AND + qIT_KhTumitateDKanri.naiteikakuteikbn.eq(C_NaiteiKakuteiKbn.NAITEI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getSingleResult();

    }

    public KhTumitateDKanriBean getKhTumitateDKanriBeanBySyono(String pSyono) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + $NEW(KhTumitateDKanriBean.class,
            qIT_KhTumitateDKanri.kbnkey,
            qIT_KhTumitateDKanri.syono,
            qIT_KhTumitateDKanri.tumitatedtumitateymd,
            qIT_KhTumitateDKanri.renno,
            qIT_KhTumitateDKanri.tumitatedskskbn,
            qIT_KhTumitateDKanri.tumitated.getTypeFieldName(),
            qIT_KhTumitateDKanri.tumitated.getValueFieldName(),
            qIT_KhTumitateDKanri.tumitatedshrkrkymd,
            qIT_KhTumitateDKanri.naiteikakuteikbn) +

            $FROM(qIT_KhTumitateDKanri) +

            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.naiteikakuteikbn.ne(C_NaiteiKakuteiKbn.NAITEI) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.desc(),
                qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhTumitateDKanri)
            .getSingleResult();
    }

    public List<KhTumitateDKanriBean> getKhTumitateDKanriBeansBySyonoTumitatedtumitateymdTumitatedskskbn(
        String pSyono, BizDate pTumitatedtumitateymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + $NEW(KhTumitateDKanriBean.class,
            qIT_KhTumitateDKanri.kbnkey,
            qIT_KhTumitateDKanri.syono,
            qIT_KhTumitateDKanri.tumitatedtumitateymd,
            qIT_KhTumitateDKanri.renno,
            qIT_KhTumitateDKanri.tumitatedskskbn,
            qIT_KhTumitateDKanri.tumitated.getTypeFieldName(),
            qIT_KhTumitateDKanri.tumitated.getValueFieldName(),
            qIT_KhTumitateDKanri.tumitatedshrkrkymd,
            qIT_KhTumitateDKanri.naiteikakuteikbn) +

            $FROM(qIT_KhTumitateDKanri) +

            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.eq(pTumitatedtumitateymd) +
            $AND
            + qIT_KhTumitateDKanri.tumitatedskskbn.in(C_TumitateDSakuseiKbn.ITIBUHIKIDASI,
                C_TumitateDSakuseiKbn.ZENHIKIDASI) +
                $AND + qIT_KhTumitateDKanri.naiteikakuteikbn.eq(C_NaiteiKakuteiKbn.NAITEI) +
                $ORDER_BY(qIT_KhTumitateDKanri.renno.asc());

        List<KhTumitateDKanriBean> hTumitateDKanriLst = exDBEntityManager
            .createJPQL(strSql, KhTumitateDKanriBean.class).bind(qIT_KhTumitateDKanri).getResultList();

        return hTumitateDKanriLst;
    }

    public IT_KykSyouhnRireki getKykSyouhnRirekiBySyonoKijyunymd(String pSyono, BizDate pKijyunymd) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String strSql = $SELECT + qIT_KykSyouhnRireki +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono)+
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.le(pKijyunymd) +
            $ORDER_BY(qIT_KykSyouhnRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KykSyouhnRireki)
            .getSingleResult();
    }

    public List<IT_KhShrRireki> getKhShrRirekisBySyonoShrsyoriymd(String pSyono, BizDate pShrsyoriymd) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String strSql = $SELECT + qIT_KhShrRireki +
            $FROM + qIT_KhShrRireki.IT_KhShrRireki() +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono)+
            $AND + qIT_KhShrRireki.shrsyoriymd.ge(pShrsyoriymd) +
            $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.DSHR) +
            $ORDER_BY(qIT_KhShrRireki.henkousikibetukey.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhShrRireki).getResultList();
    }

    public Integer getKhHaitouKanriRennoBySyonoHaitoumeisaikbnHhaitounendo(String pSyono,
        C_HaitoumeisaiKbn pHaitoumeisaikbn, BizDateY pHaitounendo) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String strSql = $SELECT + qIT_KhHaitouKanri.renno +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono)+
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaikbn) +
            $AND + qIT_KhHaitouKanri.haitounendo.eq(pHaitounendo) +
            $ORDER_BY(qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhHaitouKanri)
            .getSingleResult();
    }

    public Integer getKhTumitateDKanriRennoBySyonoTumitatedtumitateymd(String pSyono, BizDate pTumitatedtumitateymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri("qIT_KhTumitateDKanri");

        String strSql = $SELECT + qIT_KhTumitateDKanri.renno +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono)+
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.eq(pTumitatedtumitateymd) +
            $ORDER_BY(qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhTumitateDKanri)
            .getSingleResult();
    }
}
