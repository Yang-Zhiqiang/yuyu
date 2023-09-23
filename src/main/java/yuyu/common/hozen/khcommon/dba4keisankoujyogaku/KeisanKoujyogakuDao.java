package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyouD;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * 契約保全 契約保全共通 控除証明額計算Daoクラス
 */
public class KeisanKoujyogakuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<KoujyoSymNaiyouNyknJissekiRirekisBean> getKoujyoSymNaiyouNyknJissekiRirekis(
        IT_KykKihon pKykKihon, String pKoujyoNendo, C_Hrkkaisuu pHrkkaisuu) {

        List<IT_KoujyoSymNaiyou> itKoujyoSymNaiyouLst = new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(
            pKykKihon.getKoujyoSymNaiyous(),
            new FilterKoujyoSymNaiyou1(pKoujyoNendo)));

        List<IT_NyknJissekiRireki> itNyknJissekiRirekiLst = new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(
            pKykKihon.getNyknJissekiRirekis(),
            new FilterNyknJissekiRireki1(pHrkkaisuu)));

        Map<List<Object>, IT_NyknJissekiRireki> joinMap = Maps.newHashMap();

        for (IT_NyknJissekiRireki itNyknJissekiRireki : itNyknJissekiRirekiLst) {
            List<Object> joinKeyLst1 = Lists.newArrayList();
            joinKeyLst1.add(itNyknJissekiRireki.getJyutoustartym());
            joinKeyLst1.add(itNyknJissekiRireki.getRenno());
            joinMap.put(joinKeyLst1, itNyknJissekiRireki);
        }

        List<KoujyoSymNaiyouNyknJissekiRirekisBean> beanLst = Lists.newArrayList();

        for (IT_KoujyoSymNaiyou itKoujyoSymNaiyou : itKoujyoSymNaiyouLst) {
            List<Object> joinKeyLst2 = Lists.newArrayList();
            joinKeyLst2.add(itKoujyoSymNaiyou.getJyutoustartym());
            joinKeyLst2.add(itKoujyoSymNaiyou.getNyknjskrrkrenno());

            if (joinMap.containsKey(joinKeyLst2)) {
                IT_NyknJissekiRireki itNyknJissekiRireki = joinMap.get(joinKeyLst2);

                KoujyoSymNaiyouNyknJissekiRirekisBean bean = new KoujyoSymNaiyouNyknJissekiRirekisBean();
                bean.setSyouhncd(itKoujyoSymNaiyou.getSyouhncd());
                bean.setRenno3keta(itKoujyoSymNaiyou.getRenno3keta());
                bean.setKoujyosyoumeipkbn(itKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                bean.setKoujyosyoumeigk(itKoujyoSymNaiyou.getKoujyosyoumeigk());
                bean.setSyoumeistartym(itKoujyoSymNaiyou.getSyoumeistartym());
                bean.setSyoumeiendym(itKoujyoSymNaiyou.getSyoumeiendym());
                bean.setKeisanhukahyoujikbn(itKoujyoSymNaiyou.getKeisanhukahyoujikbn());
                bean.setKeisanhukariyuucd(itKoujyoSymNaiyou.getKeisanhukariyuucd());
                bean.setHrkkaisuu(itNyknJissekiRireki.getHrkkaisuu());
                beanLst.add(bean);
            }
        }

        List<KoujyoSymNaiyouNyknJissekiRirekisBean> sortedBeanLst = Lists.newArrayList();
        Ordering<KoujyoSymNaiyouNyknJissekiRirekisBean> ordering = Ordering.natural().nullsLast()
            .onResultOf(new KoujyoSymNaiyouNyknJissekiRirekisBeanSortFunction());
        sortedBeanLst = ordering.sortedCopy(beanLst);

        return sortedBeanLst;
    }

    public List<KoujyoSymNaiyouKihrkmpSeisanRirekisBean> getKoujyoSymNaiyouKihrkmpSeisanRirekis(String pSyono) {

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String mainQuery = $SELECT + $NEW(KoujyoSymNaiyouKihrkmpSeisanRirekisBean.class,
            qIT_KoujyoSymNaiyou.syoumeistartym,
            qIT_KoujyoSymNaiyou.syoumeiendym,
            qIT_KoujyoSymNaiyou.koujyosyoumeipkbn,
            qIT_KoujyoSymNaiyou.koujyosymnaiyoureckbn,
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getTypeFieldName(),
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getValueFieldName(),
            qIT_KoujyoSymNaiyou.keisanhukahyoujikbn,
            qIT_KoujyoSymNaiyou.keisanhukariyuucd,
            qIT_KihrkmpSeisanRireki.henkousikibetukey,
            qIT_KihrkmpSeisanRireki.gyoumuKousinKinou,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.kykjyoutai) +
            $FROM (qIT_KoujyoSymNaiyou,
                qIT_KihrkmpSeisanRireki,
                qIT_KykSyouhn) +
                $WHERE  + $(
                    qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
                    $AND + qIT_KoujyoSymNaiyou.sakujyoflg.eq(C_Delflag.BLNK) +
                    $AND + qIT_KihrkmpSeisanRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
                    $AND + qIT_KihrkmpSeisanRireki.renno.eq(qIT_KoujyoSymNaiyou.kihrkpssrrkrenno) +
                    $AND  + qIT_KykSyouhn.syono.eq(qIT_KoujyoSymNaiyou.syono) +
                    $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU)) +
                    $ORDER_BY(qIT_KoujyoSymNaiyou.syoumeistartym.asc(),
                        qIT_KihrkmpSeisanRireki.henkousikibetukey.asc());
        return  exDBEntityManager.createJPQL(mainQuery, KoujyoSymNaiyouKihrkmpSeisanRirekisBean.class).bind(
            qIT_KoujyoSymNaiyou, qIT_KihrkmpSeisanRireki, qIT_KykSyouhn).getResultList();
    }

    public BizDateYM getJissekiMaxSyoumeiendym(String pSyono, String pKoujyosyoumeinnd) {

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String mainQuery = $SELECT + $MAX(qIT_KoujyoSymNaiyou.syoumeiendym) +
            $FROM (qIT_KoujyoSymNaiyou,
                qIT_NyknJissekiRireki) +
                $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
                $AND + qIT_KoujyoSymNaiyou.koujyosyoumeinnd.eq(pKoujyosyoumeinnd) +
                $AND + qIT_KoujyoSymNaiyou.sakujyoflg.eq(C_Delflag.BLNK) +
                $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
                $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_KoujyoSymNaiyou.jyutoustartym) +
                $AND + qIT_NyknJissekiRireki.renno.eq(qIT_KoujyoSymNaiyou.nyknjskrrkrenno) +
                $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK) +
                $AND + $(qIT_NyknJissekiRireki.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
                    $OR + qIT_NyknJissekiRireki.hrkkaisuu.eq(C_Hrkkaisuu.NEN) +
                    $OR + qIT_NyknJissekiRireki.hrkkaisuu.eq(C_Hrkkaisuu.HALFY));

        return exDBEntityManager.createJPQL(mainQuery).bind(qIT_KoujyoSymNaiyou, qIT_NyknJissekiRireki)
            .getSingleResult();
    }

    public List<SyuKykSyouhnRirekisBean> getSyuKykSyouhnRirekis(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String queryStr1 = $SELECT + $NEW(SyuKykSyouhnRirekisBean.class,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.kykjyoutai) +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);

        List<SyuKykSyouhnRirekisBean> kykSyouhnLst = exDBEntityManager
            .createJPQL(queryStr1, SyuKykSyouhnRirekisBean.class).bind(qIT_KykSyouhn).getResultList();

        String queryStr2 = $SELECT + $NEW(SyuKykSyouhnRirekisBean.class,
            qIT_KykSyouhnRireki.yuukousyoumetukbn,
            qIT_KykSyouhnRireki.kykjyoutai) +
            $FROM(qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(C_SyutkKbn.SYU);

        List<SyuKykSyouhnRirekisBean> KykSyouhnRirekiLst = exDBEntityManager
            .createJPQL(queryStr2, SyuKykSyouhnRirekisBean.class).bind(qIT_KykSyouhnRireki).getResultList();

        kykSyouhnLst.addAll(KykSyouhnRirekiLst);

        return kykSyouhnLst;
    }

    public List<KoujyoSymNaiyouDsBean> getKoujyoSymNaiyouDs(String pSyono, String pSymNendo) {

        QIT_KoujyoSymNaiyouD qIT_KoujyoSymNaiyouD = new QIT_KoujyoSymNaiyouD("qIT_KoujyoSymNaiyouD");

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri("qIT_KhHaitouKanri");

        String mainQuery = $SELECT + $NEW(KoujyoSymNaiyouDsBean.class,
            qIT_KoujyoSymNaiyouD.koujyosyoumeid.getTypeFieldName(),
            qIT_KoujyoSymNaiyouD.koujyosyoumeid.getValueFieldName(),
            qIT_KhHaitouKanri.naiteikakuteikbn) +
            $FROM(qIT_KoujyoSymNaiyouD,
                qIT_KhHaitouKanri) +
                $WHERE + qIT_KoujyoSymNaiyouD.syono.eq(pSyono) +
                $AND + qIT_KoujyoSymNaiyouD.koujyosyoumeinnd.eq(pSymNendo) +
                $AND + qIT_KoujyoSymNaiyouD.sakujyoflg.eq(C_Delflag.BLNK) +
                $AND + qIT_KhHaitouKanri.syono.eq(qIT_KoujyoSymNaiyouD.syono) +
                $AND + qIT_KhHaitouKanri.haitounendo.eq(qIT_KoujyoSymNaiyouD.haitounendo) +
                $AND + qIT_KhHaitouKanri.renno.eq(qIT_KoujyoSymNaiyouD.haitoukanrirenno) +
                $AND + qIT_KhHaitouKanri.haitoukinskskbn.eq(qIT_KoujyoSymNaiyouD.haitoukinskskbn) +
                $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(qIT_KoujyoSymNaiyouD.haitoumeisaikbn);

        return exDBEntityManager.createJPQL(mainQuery, KoujyoSymNaiyouDsBean.class).bind(
            qIT_KoujyoSymNaiyouD, qIT_KhHaitouKanri).getResultList();

    }
}
