package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;

/**
 * 契約保全変更履歴テーブル(IT_KhHenkouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHenkouRirekiDao extends AbstractDao<IT_KhHenkouRireki> {

    public IT_KhHenkouRirekiDao() {
        super(IT_KhHenkouRireki.class);
    }

    @Deprecated
    public IT_KhHenkouRireki getKhHenkouRireki(String pKbnkey, String pSyono, String pHenkousikibetukey, Integer pRenno3keta) {
        IT_KhHenkouRireki iT_KhHenkouRireki =  new IT_KhHenkouRireki();
        iT_KhHenkouRireki.setKbnkey(pKbnkey);
        iT_KhHenkouRireki.setSyono(pSyono);
        iT_KhHenkouRireki.setHenkousikibetukey(pHenkousikibetukey);
        iT_KhHenkouRireki.setRenno3keta(pRenno3keta);
        return this.selectOne(iT_KhHenkouRireki);
    }

    @Override
    @Deprecated
    public List<IT_KhHenkouRireki> selectAll() {
        return super.selectAll();
    }

    public Long getKhHenkouRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM + qIT_KhHenkouRireki.IT_KhHenkouRireki() +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.henkoukoumokunm.eq("効力発生日");

        return em.createJPQL(strSql).bind(qIT_KhHenkouRireki).getSingleResult();
    }

    public List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey(String pSyono,String pHenkousikibetukey) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);


        return em.createJPQL(strSql,KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean> getKhHenkouRirekiHenkousikibetukeyItemsBySyono(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.desc());


        return em.createJPQL(strSql,KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.asc());


        return em.createJPQL(strSql,KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKMOKUHYOUTI)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.desc());


        return em.createJPQL(strSql,KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiAscList(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKMOKUHYOUTI)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.asc());


        return em.createJPQL(strSql,KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(String pSyono, String pHenkousikibetukey) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKYKKYKHENKOYMD);


        return em.createJPQL(strSql,KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkDescList(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKYKKIJYUNGK)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.desc());


        return em.createJPQL(strSql,KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkAscList(String pSyono) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKYKKIJYUNGK)+
            $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.asc());


        return em.createJPQL(strSql,KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkList(String pSyono, String pHenkousikibetukey) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKYKKIJYUNGK);


        return em.createJPQL(strSql,KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiList(String pSyono, String pHenkousikibetukey) {


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKMOKUHYOUTI);


        return em.createJPQL(strSql,KhHenkouRirekiTargetBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

}
