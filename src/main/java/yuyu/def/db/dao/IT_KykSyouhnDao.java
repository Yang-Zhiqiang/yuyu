package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyouhntaniBySyonoBean;
import yuyu.def.hozen.result.bean.KykSyouhnsyutaniBySyonoBean;

/**
 * 契約商品テーブル(IT_KykSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSyouhnDao extends AbstractDao<IT_KykSyouhn> {

    public IT_KykSyouhnDao() {
        super(IT_KykSyouhn.class);
    }

    @Deprecated
    public IT_KykSyouhn getKykSyouhn(String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno){
        IT_KykSyouhn iT_KykSyouhn =  new IT_KykSyouhn();
        iT_KykSyouhn.setSyono(pSyono);
        iT_KykSyouhn.setSyutkkbn(pSyutkkbn);
        iT_KykSyouhn.setSyouhncd(pSyouhncd);
        iT_KykSyouhn.setSyouhnsdno(pSyouhnsdno);
        iT_KykSyouhn.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_KykSyouhn);
    }

    @Override
    @Deprecated
    public List<IT_KykSyouhn> selectAll() {
        return super.selectAll();
    }

    public List<IT_KykSyouhn> getKykSyouhnsBySyonoKouryokuhasseiymd(String pSyono, BizDate pKouryokuhasseiymd) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();

        String queryStr = $SELECT + qIT_KykSyouhn +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.kouryokuhasseiymd.ne(qIT_KykSyouhn.kykymd) +
            $AND + qIT_KykSyouhn.kouryokuhasseiymd.gt(pKouryokuhasseiymd);

        return em.createJPQL(queryStr).bind(qIT_KykSyouhn).getResultList();

    }


    public List<KykSyouhnsyutaniBySyonoBean> getKykSyouhnsyutaniBySyono(String pSyono) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String queryStr1 = $SELECT +  $NEW(KykSyouhnsyutaniBySyonoBean.class,
            $MAX(qIT_KykSyouhn.kouryokuhasseiymd),
            qIT_KykSyouhn.gyoumuKousinKinou) +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $GROUP_BY + qIT_KykSyouhn.gyoumuKousinKinou;


        List<KykSyouhnsyutaniBySyonoBean> kykSyouhnBeanLst = em.createJPQL(queryStr1,KykSyouhnsyutaniBySyonoBean.class).bind(qIT_KykSyouhn).getResultList();

        String queryStr2 = $SELECT +  $NEW(KykSyouhnsyutaniBySyonoBean.class,
            $MAX(qIT_KykSyouhnRireki.kouryokuhasseiymd),
            qIT_KykSyouhnRireki.gyoumuKousinKinou) +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(C_SyutkKbn.SYU) +
            $GROUP_BY + qIT_KykSyouhnRireki.gyoumuKousinKinou;


        List<KykSyouhnsyutaniBySyonoBean> kykSyouhnRirekiBeanLst = em.createJPQL(queryStr2,KykSyouhnsyutaniBySyonoBean.class).bind(qIT_KykSyouhnRireki).getResultList();

        Map<Object, Object> mapKykSyouhn = new HashMap<Object, Object>();
        for (KykSyouhnsyutaniBySyonoBean kykSyouhnBean : kykSyouhnBeanLst) {


            mapKykSyouhn.put(kykSyouhnBean.getGyoumuKousinKinou(), kykSyouhnBean.getKouryokuhasseiymd());
        }

        Object objGyoumuKousinKinouKykSyouhnRireki = null;
        Object objKouryokuhasseiymdKykSyouhnRireki = null;
        BizDate bzGyoumuKousinKinouKykSyouhnRireki = null;
        Object objKouryokuhasseiymdKykSyouhn = null;
        BizDate bzGyoumuKousinKinouKykSyouhn = null;
        for (KykSyouhnsyutaniBySyonoBean kykSyouhnRirekiBean : kykSyouhnRirekiBeanLst) {

            objKouryokuhasseiymdKykSyouhnRireki = kykSyouhnRirekiBean.getKouryokuhasseiymd();
            objGyoumuKousinKinouKykSyouhnRireki = kykSyouhnRirekiBean.getGyoumuKousinKinou();

            if (mapKykSyouhn.containsKey(objGyoumuKousinKinouKykSyouhnRireki)) {


                if (objKouryokuhasseiymdKykSyouhnRireki == null) {

                    continue;
                }

                bzGyoumuKousinKinouKykSyouhnRireki =(BizDate)  objKouryokuhasseiymdKykSyouhnRireki;


                objKouryokuhasseiymdKykSyouhn = mapKykSyouhn.get(objGyoumuKousinKinouKykSyouhnRireki);


                if (objKouryokuhasseiymdKykSyouhn != null) {

                    bzGyoumuKousinKinouKykSyouhn = (BizDate) objKouryokuhasseiymdKykSyouhn;


                    if (bzGyoumuKousinKinouKykSyouhn.compareTo(bzGyoumuKousinKinouKykSyouhnRireki) >= 0) {

                        continue;
                    }
                }
            }


            mapKykSyouhn.put(objGyoumuKousinKinouKykSyouhnRireki, objKouryokuhasseiymdKykSyouhnRireki);
        }

        List<KykSyouhnsyutaniBySyonoBean> KykSyouhnsyutaniBySyonoBeanLst = new ArrayList<>();
        Iterator<Object> iter = mapKykSyouhn.keySet().iterator();
        while (iter.hasNext()) {

            objGyoumuKousinKinouKykSyouhnRireki = iter.next();
            KykSyouhnsyutaniBySyonoBeanLst.add(new KykSyouhnsyutaniBySyonoBean((BizDate) mapKykSyouhn.get(objGyoumuKousinKinouKykSyouhnRireki), (String)objGyoumuKousinKinouKykSyouhnRireki));
        }


        return KykSyouhnsyutaniBySyonoBeanLst;

    }


    public List<KykSyouhnsyouhntaniBySyonoBean> getKykSyouhnsyouhntaniBySyono(String pSyono) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String queryStr1 = $SELECT + $NEW(KykSyouhnsyouhntaniBySyonoBean.class,
            $MAX(qIT_KykSyouhn.kouryokuhasseiymd),
            qIT_KykSyouhn.gyoumuKousinKinou) +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $GROUP_BY + qIT_KykSyouhn.gyoumuKousinKinou;


        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnBeanLst = em.createJPQL(queryStr1,KykSyouhnsyouhntaniBySyonoBean.class).bind(qIT_KykSyouhn).getResultList();

        String queryStr2 = $SELECT +  $NEW(KykSyouhnsyouhntaniBySyonoBean.class,
            $MAX(qIT_KykSyouhnRireki.kouryokuhasseiymd),
            qIT_KykSyouhnRireki.gyoumuKousinKinou) +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $GROUP_BY + qIT_KykSyouhnRireki.gyoumuKousinKinou;


        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnRirekiBeanLst = em.createJPQL(queryStr2,KykSyouhnsyouhntaniBySyonoBean.class).bind(qIT_KykSyouhnRireki).getResultList();

        Map<Object, Object> mapKykSyouhn = new HashMap<Object, Object>();
        for (KykSyouhnsyouhntaniBySyonoBean kykSyouhnBean : kykSyouhnBeanLst) {


            mapKykSyouhn.put(kykSyouhnBean.getGyoumuKousinKinou(), kykSyouhnBean.getKouryokuhasseiymd());
        }

        Object objGyoumuKousinKinouKykSyouhnRireki = null;
        Object objKouryokuhasseiymdKykSyouhnRireki = null;
        BizDate bzGyoumuKousinKinouKykSyouhnRireki = null;
        Object objKouryokuhasseiymdKykSyouhn = null;
        BizDate bzGyoumuKousinKinouKykSyouhn = null;
        for (KykSyouhnsyouhntaniBySyonoBean kykSyouhnRirekiBean : kykSyouhnRirekiBeanLst) {

            objKouryokuhasseiymdKykSyouhnRireki = kykSyouhnRirekiBean.getKouryokuhasseiymd();
            objGyoumuKousinKinouKykSyouhnRireki = kykSyouhnRirekiBean.getGyoumuKousinKinou();

            if (mapKykSyouhn.containsKey(objGyoumuKousinKinouKykSyouhnRireki)) {


                if (objKouryokuhasseiymdKykSyouhnRireki == null) {

                    continue;
                }

                bzGyoumuKousinKinouKykSyouhnRireki =(BizDate)  objKouryokuhasseiymdKykSyouhnRireki;


                objKouryokuhasseiymdKykSyouhn = mapKykSyouhn.get(objGyoumuKousinKinouKykSyouhnRireki);


                if (objKouryokuhasseiymdKykSyouhn != null) {

                    bzGyoumuKousinKinouKykSyouhn = (BizDate) objKouryokuhasseiymdKykSyouhn;


                    if (bzGyoumuKousinKinouKykSyouhn.compareTo(bzGyoumuKousinKinouKykSyouhnRireki) >= 0) {

                        continue;
                    }
                }
            }


            mapKykSyouhn.put(objGyoumuKousinKinouKykSyouhnRireki, objKouryokuhasseiymdKykSyouhnRireki);
        }

        List<KykSyouhnsyouhntaniBySyonoBean> KykSyouhnsyouhntaniBySyonoBeanLst = new ArrayList<>();
        Iterator<Object> iter = mapKykSyouhn.keySet().iterator();
        while (iter.hasNext()) {

            objGyoumuKousinKinouKykSyouhnRireki = iter.next();
            KykSyouhnsyouhntaniBySyonoBeanLst.add(new KykSyouhnsyouhntaniBySyonoBean((BizDate) mapKykSyouhn.get(objGyoumuKousinKinouKykSyouhnRireki), (String)objGyoumuKousinKinouKykSyouhnRireki));
        }


        return KykSyouhnsyouhntaniBySyonoBeanLst;
    }

    public List<Object[]> getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(String pSyono) {


        QIT_KykSyouhn qIT_KykSyouhn =  new  QIT_KykSyouhn();


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon();


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya();

        String mainQuery = $SELECT + qIT_KykSyouhn + "," +
            qIT_KykKihon.hrkkeiro +  "," +
            qIT_KykKihon.tikiktbrisyuruikbn + "," +
            qIT_HhknSya.hhknsei +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() + ","+
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_HhknSya.IT_HhknSya() +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono);

        return em.createJPQL(mainQuery).bind(qIT_KykSyouhn, qIT_KykKihon, qIT_HhknSya).getResultList();
    }

    public ExDBResults<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(
        C_SyutkKbn pSyutkkbn) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();


        String strSql = $SELECT + qIT_KykSyouhn +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn);


        return em.createJPQL(strSql).bind(qIT_KykSyouhn).getResults();
    }

    public List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getHoyuKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        String strSql = $SELECT + $NEW(HoyuKykSyouhnsBySyonoSyutkkbnBean.class,
            qIT_KykSyouhn.syono,
            qIT_KykSyouhn.henkousikibetukey,
            qIT_KykSyouhn.syutkkbn,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.syoumetuymd,
            qIT_KykSyouhn.syoumetujiyuu
            )  + $FROM (qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn);


        return em.createJPQL(strSql,HoyuKykSyouhnsBySyonoSyutkkbnBean.class).bind(qIT_KykSyouhn).getResultList();
    }
}
