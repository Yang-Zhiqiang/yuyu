package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsmsyoriKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean;
import yuyu.def.hozen.result.bean.KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean;
/**
 * 控除証明内容テーブル(IT_KoujyoSymNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KoujyoSymNaiyouDao extends AbstractDao<IT_KoujyoSymNaiyou> {

    public IT_KoujyoSymNaiyouDao() {
        super(IT_KoujyoSymNaiyou.class);
    }

    @Deprecated
    public IT_KoujyoSymNaiyou getKoujyoSymNaiyou(String pSyono,
        String pSyouhncd,
        Integer pRenno3keta){
        IT_KoujyoSymNaiyou iT_KoujyoSymNaiyou =  new IT_KoujyoSymNaiyou();
        iT_KoujyoSymNaiyou.setSyono(pSyono);
        iT_KoujyoSymNaiyou.setSyouhncd(pSyouhncd);
        iT_KoujyoSymNaiyou.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_KoujyoSymNaiyou);
    }

    @Override
    @Deprecated
    public List<IT_KoujyoSymNaiyou> selectAll() {
        return super.selectAll();
    }

    public Integer getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(String pSyono, String pSyouhncd) {


        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou();


        String querySql = $SELECT + $MAX(qIT_KoujyoSymNaiyou.renno3keta) +
            $FROM + qIT_KoujyoSymNaiyou.IT_KoujyoSymNaiyou() +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
            $AND + qIT_KoujyoSymNaiyou.syouhncd.eq(pSyouhncd);

        return em.createJPQL(querySql).bind(qIT_KoujyoSymNaiyou).getSingleResult();
    }

    public List<KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean> getKoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbn(
        String pSyono, String pKoujyosyoumeinnd, C_Hrkkaisuu pHrkkaisuu, C_KjsmsyoriKbn pKjsmsyoriKbn) {


        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou();


        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();


        String subquery1 = "";


        if (pHrkkaisuu.eq(C_Hrkkaisuu.TUKI)) {

            subquery1 = subquery1 + $AND + qIT_NyknJissekiRireki.hrkkaisuu.eq(C_Hrkkaisuu.TUKI);
        }


        if (!pHrkkaisuu.eq(C_Hrkkaisuu.TUKI)) {

            subquery1 = subquery1 + $AND + qIT_NyknJissekiRireki.hrkkaisuu.in(C_Hrkkaisuu.NEN,C_Hrkkaisuu.HALFY);
        }


        if (pKjsmsyoriKbn.eq(C_KjsmsyoriKbn.KJSMBATCH)) {

            subquery1 = subquery1 + $AND + qIT_KoujyoSymNaiyou.kjsmhakkouzumiflg.eq(C_Kjsmhakkouzumiflg.BLNK);
        }

        String querySql = $SELECT + $NEW(KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean.class,
            qIT_KoujyoSymNaiyou.syouhncd,
            qIT_KoujyoSymNaiyou.renno3keta,
            qIT_KoujyoSymNaiyou.koujyosyoumeipkbn,
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getTypeFieldName(),
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getValueFieldName(),
            qIT_KoujyoSymNaiyou.syoumeistartym,
            qIT_KoujyoSymNaiyou.syoumeiendym,
            qIT_NyknJissekiRireki.hrkkaisuu) +
            $FROM + qIT_KoujyoSymNaiyou.IT_KoujyoSymNaiyou() + "," +
            qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
            $AND + qIT_KoujyoSymNaiyou.koujyosyoumeinnd.eq(pKoujyosyoumeinnd) +
            $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_KoujyoSymNaiyou.jyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.eq(qIT_KoujyoSymNaiyou.nyknjskrrkrenno) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK) +
            subquery1 +
            $ORDER_BY(qIT_KoujyoSymNaiyou.syoumeistartym.asc());

        return em.createJPQL(querySql, KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean.class).bind(qIT_KoujyoSymNaiyou, qIT_NyknJissekiRireki).getResultList();
    }

    public List<KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean> getKoujyoSymNaiyouKihrkmpSeisanRirekisBySyono(
        String pSyono) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki();

        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou();

        String querySql = $SELECT + $NEW(KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean.class,
            qIT_KoujyoSymNaiyou.koujyosyoumeipkbn,
            qIT_KoujyoSymNaiyou.koujyosymnaiyoureckbn,
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getTypeFieldName(),
            qIT_KoujyoSymNaiyou.koujyosyoumeigk.getValueFieldName(),
            qIT_KihrkmpSeisanRireki.jyuutouym,
            qIT_KihrkmpSeisanRireki.seijyutoukaisuum,
            qIT_KihrkmpSeisanRireki.seijyutoukaisuuy,
            qIT_KihrkmpSeisanRireki.gyoumuKousinKinou,
            qIT_KykSyouhn.yuukousyoumetukbn) +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KihrkmpSeisanRireki.IT_KihrkmpSeisanRireki() + "," +
            qIT_KoujyoSymNaiyou.IT_KoujyoSymNaiyou() +
            $WHERE + qIT_KoujyoSymNaiyou.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_KihrkmpSeisanRireki.renno.eq(qIT_KoujyoSymNaiyou.kihrkpssrrkrenno) +
            $AND + qIT_KihrkmpSeisanRireki.seisanpgoukei.gtZero() +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KoujyoSymNaiyou.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $ORDER_BY(qIT_KihrkmpSeisanRireki.jyuutouym.asc());

        return em.createJPQL(querySql, KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean.class).bind(qIT_KykSyouhn, qIT_KihrkmpSeisanRireki, qIT_KoujyoSymNaiyou).getResultList();
    }
}
