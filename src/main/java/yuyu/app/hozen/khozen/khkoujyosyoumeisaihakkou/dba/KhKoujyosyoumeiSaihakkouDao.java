package yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全 控除証明書再発行機能DAOクラス
 */
public class KhKoujyosyoumeiSaihakkouDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyou(IT_KykKihon pKykKihon, String pKoujyosyoumeinnd) {

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = pKykKihon.getKoujyoSymNaiyous();

        koujyoSymNaiyouLst = new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(koujyoSymNaiyouLst, new FilterKoujyoSymNaiyou(pKoujyosyoumeinnd)));

        return koujyoSymNaiyouLst;
    }

    public List<IT_KoujyoSymNaiyouD> getKoujyoSymNaiyouD(IT_KykKihon pKykKihon, String pKoujyosyoumeinnd) {

        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDLst = pKykKihon.getKoujyoSymNaiyouDs();

        koujyoSymNaiyouDLst = new ArrayList<IT_KoujyoSymNaiyouD>(Collections2.filter(koujyoSymNaiyouDLst, new FilterKoujyoSymNaiyouD(pKoujyosyoumeinnd)));

        return koujyoSymNaiyouDLst;
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRireki(String pSyono, BizDateY pRyosyunen, C_Nykkeiro pNykkeiro) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.ryosyuymd.substring(1, 4).eq(pRyosyunen.toString()) +
            $AND + qIT_NyknJissekiRireki.nykkeiro.eq(pNykkeiro) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.ne(C_Nyktrksflg.TORIKESI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();
    }
}
