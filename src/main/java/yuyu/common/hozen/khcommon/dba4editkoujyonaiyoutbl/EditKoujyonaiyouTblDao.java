package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * 契約保全 契約保全共通 控除証明内容TBL編集Daoクラス
 */
public class EditKoujyonaiyouTblDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Integer getKoujyoSymNaiyouMaxRenno3ketaBySyouhncd(IT_KykKihon pKykKihon, String pSyouhncd) {

        List<IT_KoujyoSymNaiyou> itKoujyoSymNaiyouLst = new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(
            pKykKihon.getKoujyoSymNaiyous(),
            new FilterKoujyoSymNaiyou1(pSyouhncd)));

        if (itKoujyoSymNaiyouLst.size() == 0) {
            return null;
        }

        SortEditKoujyonaiyouTbl sortEditKoujyonaiyouTbl = SWAKInjector.getInstance(SortEditKoujyonaiyouTbl.class);
        List<IT_KoujyoSymNaiyou> sortitKoujyoSymNaiyouLst =
            sortEditKoujyonaiyouTbl.OrderIT_KoujyoSymNaiyou1(itKoujyoSymNaiyouLst);

        Integer rennoMax = sortitKoujyoSymNaiyouLst.get(0).getRenno3keta();

        return rennoMax;
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekis(IT_KykKihon pKykKihon, String pHenkousikibetukey,
        C_YuukousyoumetuKbn pYuukousyoumetuKbn, C_SyutkKbn pSyutkKbn) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);

        List<IT_KykSyouhnRireki> kykSyouhnRireki = new ArrayList<IT_KykSyouhnRireki>(Collections2.filter(khTtdkRireki.getKykSyouhnRirekis(),
            new FilterKykSyouhnRireki1(pYuukousyoumetuKbn, pSyutkKbn)));

        return kykSyouhnRireki;
    }

    public List<NyknjiKoujyoSymNaiyouBean> getNyknjiKoujyoSymNaiyou(String pSyono, BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym, C_SyutkKbn pSyutkkbn) {

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String mainQuery = $SELECT + $NEW(NyknjiKoujyoSymNaiyouBean.class,
            qIT_KoujyoSymNaiyou.syono,
            qIT_KoujyoSymNaiyou.syouhncd,
            qIT_KoujyoSymNaiyou.koujyosyoumeinnd,
            qIT_KoujyoSymNaiyou.syoumeistartym,
            qIT_KoujyoSymNaiyou.syoumeiendym,
            qIT_KoujyoSymNaiyou.koujyosyoumeipkbn,
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getTypeFieldName(),
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getValueFieldName(),
            qIT_KoujyoSymNaiyou.zennoukaisiymd,
            qIT_KoujyoSymNaiyou.zennourenno,
            qIT_NyknJissekiRireki.jyutoustartym,
            qIT_NyknJissekiRireki.jyutouendym,
            qIT_NyknJissekiRireki.hrkkaisuu) +
            $FROM (qIT_KoujyoSymNaiyou,
                qIT_NyknJissekiRireki,
                qIT_KykSyouhn) +
                $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
                $AND + qIT_KoujyoSymNaiyou.syoumeiendym.ge(pSyoumeistartym) +
                $AND + qIT_KoujyoSymNaiyou.syoumeiendym.le(pSyoumeiendym) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
                $AND + qIT_KoujyoSymNaiyou.sakujyoflg.eq(C_Delflag.BLNK) +
                $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
                $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_KoujyoSymNaiyou.jyutoustartym) +
                $AND + qIT_NyknJissekiRireki.renno.eq(qIT_KoujyoSymNaiyou.nyknjskrrkrenno) +
                $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KoujyoSymNaiyou.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qIT_KoujyoSymNaiyou.syouhncd) +
                $ORDER_BY(qIT_KoujyoSymNaiyou.syoumeistartym.asc(),
                    qIT_KoujyoSymNaiyou.syouhncd.asc());

        return exDBEntityManager.createJPQL(mainQuery, NyknjiKoujyoSymNaiyouBean.class)
            .bind(qIT_KoujyoSymNaiyou, qIT_NyknJissekiRireki, qIT_KykSyouhn).getResultList();
    }

    public IT_Zennou getZennou(IT_AnsyuKihon pAnsyuKihon, BizDate pZennoukaisiymd, Integer pRenno) {

        List<IT_Zennou> zennouLst = pAnsyuKihon.getZennous();

        IT_Zennou zennou = Iterables.getFirst(Iterables.filter(zennouLst,
            new FilterZennou1(pZennoukaisiymd, pRenno)), null);

        return zennou;
    }
}
