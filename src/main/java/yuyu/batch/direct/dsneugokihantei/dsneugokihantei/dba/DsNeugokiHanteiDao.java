package yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;

/**
 * ダイレクトサービス 値動き判定機能DAOクラス
 */
public class DsNeugokiHanteiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public void deleteDsNeugokiHanteiKekkaWkByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        QMW_DsNeugokiHanteiKekkaWk qMW_DsNeugokiHanteiKekkaWk =
            new QMW_DsNeugokiHanteiKekkaWk("qMW_DsNeugokiHanteiKekkaWk");

        String querySql = $DELETE_FROM(qMW_DsNeugokiHanteiKekkaWk) +
            $WHERE + qMW_DsNeugokiHanteiKekkaWk.dsdatasakuseiymd.lt(pDsdatasakuseiymd);

        exDBEntityManager.createJPQL(querySql).bind(qMW_DsNeugokiHanteiKekkaWk).executeUpdate();
    }

    public void deleteDsMailHaisinBySousinymd(BizDate pSousinymd) {

        QMT_DsMailHaisin qMT_DsMailHaisin = new QMT_DsMailHaisin("qMT_DsMailHaisin");

        String querySql = $DELETE_FROM(qMT_DsMailHaisin) +
            $WHERE + qMT_DsMailHaisin.sousinymd.lt(pSousinymd) +
            $AND + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(C_DsSousinMailSyubetuKbn.NEUGOKIMAIL);

        exDBEntityManager.createJPQL(querySql).bind(qMT_DsMailHaisin).executeUpdate();
    }

    public void deleteDsMailHaisinRirekiWkByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        QMW_DsMailHaisinRirekiWk qMW_DsMailHaisinRirekiWk = new QMW_DsMailHaisinRirekiWk("qMW_DsMailHaisinRirekiWk");

        String querySql = $DELETE_FROM(qMW_DsMailHaisinRirekiWk) +
            $WHERE + qMW_DsMailHaisinRirekiWk.dsdatasakuseiymd.lt(pDsdatasakuseiymd) +
            $AND + qMW_DsMailHaisinRirekiWk.dssousinmailsyubetukbn.eq(C_DsSousinMailSyubetuKbn.NEUGOKIMAIL);

        exDBEntityManager.createJPQL(querySql).bind(qMW_DsMailHaisinRirekiWk).executeUpdate();
    }

    public ExDBResults<DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean>
    getDsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyorikyktuukasyu(
        String pKakutyouJobCd, BizDate pSyoriYmd, C_Tuukasyu pSyoriKykTuukasyu) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");
        QIT_KykDairiten qIT_KykDairitenA = new QIT_KykDairiten("qIT_KykDairitenA");
        QIT_KykDairiten qIT_KykDairitenB = new QIT_KykDairiten("qIT_KykDairitenB");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QJT_SibouKariuketsuke qJT_SibouKariuketsuke = new QJT_SibouKariuketsuke("qJT_SibouKariuketsuke");

        String strSubSql1 = $SELECT + qIT_KykDairitenA.drtencd +
            $FROM(qIT_KykDairitenA) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykDairitenA.syono) +
            $AND + qIT_KykDairitenA.drtenrenno.eq(1);

        String strSubSql2 = $SELECT + qIT_KykDairitenB.drtencd +
            $FROM(qIT_KykDairitenB) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KykDairitenB.syono) +
            $AND + qIT_KykDairitenB.drtenrenno.eq(2);

        String strSubSql3 = $SELECT + qJT_SibouKariuketsuke.syono +
            $FROM(qJT_SibouKariuketsuke) +
            $WHERE + qIT_KykKihon.syono.eq(qJT_SibouKariuketsuke.syono) +
            $AND + qJT_SibouKariuketsuke.torikesiflg.eq(C_UmuKbn.NONE);

        String queryStr = $SELECT + $NEW(
            DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean.class,
            qIT_KykKihon.kbnkey,
            qIT_KykKihon.syono,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.aisyoumeikbn,
            qIT_KykSya.kyknmkn,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.yoteiriritu,
            qIT_KykSyouhn.hknkknsmnkbn,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hrkkkn,
            qIT_KykSyouhn.hhknnen,
            qIT_KykSyouhn.hhknsei,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.kyksjkkktyouseiriritu,
            qIT_KykSyouhn.gengakugoyenitijibrpstgk.getTypeFieldName(),
            qIT_KykSyouhn.gengakugoyenitijibrpstgk.getValueFieldName(),
            qIT_KykSyouhn.yendthnkymd,
            qIT_KykSyouhn.kykjyoutai,
            $(strSubSql1),
            $(strSubSql2),
            qIT_NyknJissekiRireki.rsgaku.getTypeFieldName(),
            qIT_NyknJissekiRireki.rsgaku.getValueFieldName(),
            qIT_NyknJissekiRireki.hrkp.getTypeFieldName(),
            qIT_NyknJissekiRireki.hrkp.getValueFieldName(),
            qIT_NyknJissekiRireki.ryosyuymd,
            qIT_KykSonotaTkyk.yennykntkhkumu) +
            $FROM(qIT_KykKihon,
                qIT_KykSya,
                qIT_KykSyouhn,
                qIT_NyknJissekiRireki,
                qIT_KykSonotaTkyk) +
                $WHERE +  qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_NyknJissekiRireki.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono) +
                $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.kykymd.le(pSyoriYmd) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.yendthnkymd.isNull() +
                $AND + qIT_NyknJissekiRireki.nykkeiro.eq(C_Nykkeiro.SKEI);

        if (!C_Tuukasyu.BLNK.eq(pSyoriKykTuukasyu)) {
            queryStr = queryStr +
                $AND + qIT_KykSyouhn.kyktuukasyu.eq(pSyoriKykTuukasyu);
        }
        queryStr = queryStr +
            $AND + $NOT_EXISTS(strSubSql3) +
            $ORDER_BY(qIT_KykKihon.syono.asc());

        ExDBResults<DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean> exDBResults =
            exDBEntityManager.createJPQL(queryStr,
                DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean.class).bind(qIT_KykKihon,
                    qIT_KykSya, qIT_KykSyouhn, qIT_NyknJissekiRireki, qIT_KykDairitenA, qIT_KykDairitenB,
                    qIT_KykSonotaTkyk, qJT_SibouKariuketsuke).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<DsKokyakuInfoBySyonoBean> getDsKokyakuInfoBySyono(String pSyoNo) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");
        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsMailAddress qMT_DsMailAddress = new QMT_DsMailAddress("qMT_DsMailAddress");

        String queryStr = $SELECT + $NEW(DsKokyakuInfoBySyonoBean.class,
            qMT_DsKokyakuKanri.dskokno,
            qMT_DsKokyakuKanri.dskokyakujtkbn,
            qMT_DsKokyakuKanri.dsteisiriyuukbn,
            qMT_DsMailAddress.dsmailaddressrenban,
            qMT_DsMailAddress.dsmailaddress,
            qMT_DsMailAddress.dsmailtourokujyoutaikbn,
            qMT_DsMailAddress.dsmailsousinjyoutaikbn) +
            $FROM(qMT_DsKokyakuKanri,
                qMT_DsKokyakuKeiyaku,
                qMT_DsMailAddress) +
                $WHERE +  qMT_DsKokyakuKeiyaku.syono.eq(pSyoNo) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsKokyakuKanri.dskokno) +
                $AND + qMT_DsKokyakuKanri.dskokno.eq(qMT_DsMailAddress.dskokno);

        return exDBEntityManager.createJPQL(queryStr, DsKokyakuInfoBySyonoBean.class).bind(qMT_DsKokyakuKeiyaku,
            qMT_DsKokyakuKanri, qMT_DsMailAddress).getResultList();

    }

    public DsNeugokiHanteiKekkaBySyonoROWNUMBean getDsNeugokiHanteiKekkaBySyonoROWNUM(String pSyono) {

        QMT_DsNeugokiHanteiKekka qMT_DsNeugokiHanteiKekka = new QMT_DsNeugokiHanteiKekka("qMT_DsNeugokiHanteiKekka");

        String querySql = $SELECT + $NEW(DsNeugokiHanteiKekkaBySyonoROWNUMBean.class,
            qMT_DsNeugokiHanteiKekka.neugokiwari,
            qMT_DsNeugokiHanteiKekka.neugokitoutatulinefile) +
            $FROM(qMT_DsNeugokiHanteiKekka) +
            $WHERE + qMT_DsNeugokiHanteiKekka.syono.eq(pSyono) +
            $AND + qMT_DsNeugokiHanteiKekka.neugokihanteiumukbn.eq(C_UmuKbn.ARI) +
            $ORDER_BY (qMT_DsNeugokiHanteiKekka.dsdatasakuseiymd.desc());

        return exDBEntityManager.createJPQL(querySql,
            DsNeugokiHanteiKekkaBySyonoROWNUMBean.class).setFirstResult(0).setMaxResults(1).bind(
                qMT_DsNeugokiHanteiKekka).getSingleResult();
    }

    public Integer getDsMailHaisinRirekiWkMaxDsmailhaisinrenno() {

        QMW_DsMailHaisinRirekiWk qMW_DsMailHaisinRirekiWk = new QMW_DsMailHaisinRirekiWk("qMW_DsMailHaisinRirekiWk");

        String querySql = $SELECT + $MAX(qMW_DsMailHaisinRirekiWk.dsmailhaisinrenban) +
            $FROM(qMW_DsMailHaisinRirekiWk);

        return exDBEntityManager.createJPQL(querySql).bind(qMW_DsMailHaisinRirekiWk).getSingleResult();
    }

    public void addMultipleInsertEntity(MultipleEntityInserter pEntityInserter, AbstractExDBEntity<?, ?> pEntity) {

        pEntityInserter.add(pEntity);
    }

    public ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean
    getZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUM(String pSyono) {

        QMT_DsNeugokiHanteiKekka qMT_DsNeugokiHanteiKekka = new QMT_DsNeugokiHanteiKekka("qMT_DsNeugokiHanteiKekka");

        String querySql = $SELECT + $NEW(ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean.class,
            qMT_DsNeugokiHanteiKekka.neugokiwari,
            qMT_DsNeugokiHanteiKekka.neugokitoutatulinemail) +
            $FROM(qMT_DsNeugokiHanteiKekka) +
            $WHERE + qMT_DsNeugokiHanteiKekka.syono.eq(pSyono) +
            $AND + qMT_DsNeugokiHanteiKekka.mailsousinyhkbn.eq(C_YouhiKbn.YOU) +
            $ORDER_BY (qMT_DsNeugokiHanteiKekka.dsdatasakuseiymd.desc());

        return exDBEntityManager.createJPQL(querySql,
            ZenkaiMailHaisinjiDsNeugokiHanteiKekkaBySyonoROWNUMBean.class).setFirstResult(0).setMaxResults(1).bind(
                qMT_DsNeugokiHanteiKekka).getSingleResult();
    }

}
