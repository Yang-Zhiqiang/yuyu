package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.meta.QAM_User;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QBT_KinouHukaInfo;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.hozen.result.bean.KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean;
import yuyu.def.hozen.result.bean.KhTtdkRirekiInfosBySyonoBean;

/**
 * 契約保全手続履歴テーブル(IT_KhTtdkRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTtdkRirekiDao extends AbstractDao<IT_KhTtdkRireki> {

    public IT_KhTtdkRirekiDao() {
        super(IT_KhTtdkRireki.class);
    }

    @Deprecated
    public IT_KhTtdkRireki getKhTtdkRireki(String pSyono,
        String pHenkousikibetukey){
        IT_KhTtdkRireki iT_KhTtdkRireki =  new IT_KhTtdkRireki();
        iT_KhTtdkRireki.setSyono(pSyono);
        iT_KhTtdkRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_KhTtdkRireki);
    }

    @Override
    @Deprecated
    public List<IT_KhTtdkRireki> selectAll() {
        return super.selectAll();
    }

    public List<Object[]> getKhTtdkRirekiCountBySyoriYmdSubSystemId(BizDate pSyoriYmd, String pSubSystemId) {


        QAS_Kinou kinou = new QAS_Kinou();


        QBT_KinouHukaInfo kinouHukaInfo = new QBT_KinouHukaInfo();


        QIT_KhTtdkRireki khTtdkRireki = new QIT_KhTtdkRireki();


        String subQuery = $SELECT + $COUNT(khTtdkRireki.gyoumuKousinKinou) +
            $FROM + khTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + khTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND + khTtdkRireki.gyoumuKousinKinou.eq(kinou.kinouId);


        String querySql = $SELECT + kinou.kinouNm + ","
            + $(subQuery) +
            $FROM + kinou.AS_Kinou() +
            "," + kinouHukaInfo.BT_KinouHukaInfo() +
            $WHERE + kinou.kinouId.eq(kinouHukaInfo.kinouId) +
            $AND + kinouHukaInfo.kensuuhyoujijyun.gt(0) +
            $AND + kinou.subSystemId.eq(pSubSystemId) +
            $GROUP_BY + kinou.kinouId +
            "," + kinou.kinouNm +
            "," + kinouHukaInfo.kensuuhyoujijyun +
            $ORDER_BY(kinouHukaInfo.kensuuhyoujijyun.asc());

        return em.createJPQL(querySql).bind(kinou, kinouHukaInfo, khTtdkRireki).getResultList();
    }

    public Long getKykSyouhnRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinKinou2) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();


        String querySql = $SELECT + $COUNT + "(*)" +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + "(" +qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $OR + "(" + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou2) +
            $AND + qIT_KhTtdkRireki.syorikbn.ne(C_SyoriKbn.GANSINDAN) + ")" +")";


        return em.createJPQL(querySql).bind(qIT_KhTtdkRireki).getSingleResult();
    }

    public Long getKhTtdkRirekiCountBySyono(String pSyono) {


        QIT_KhTtdkRireki khTtdkRireki = new QIT_KhTtdkRireki();


        String querySql = $SELECT + $COUNT(khTtdkRireki.syono) +
            $FROM + khTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + khTtdkRireki.syono.eq(pSyono);

        return em.createJPQL(querySql).bind(khTtdkRireki).getSingleResult();
    }

    public List<KhTtdkRirekiInfosBySyonoBean> getKhTtdkRirekiInfosBySyono(String pSyono) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");


        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");


        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");


        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");


        QAM_User qAM_User = new QAM_User("qAM_User");

        String subQuery1 = $SELECT + $COUNT + "(*)" +
            $FROM (qIT_KhHenkouRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.kbnkey.eq(qIT_KhHenkouRireki.kbnkey) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) ;

        String subQuery2 = $SELECT + $COUNT + "(*)" +
            $FROM (qIT_KhShrRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhTtdkRireki.kbnkey.eq(qIT_KhShrRireki.kbnkey) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhShrRireki.henkousikibetukey)  ;

        String querySql = $SELECT + $NEW(KhTtdkRirekiInfosBySyonoBean.class,
            qIT_KhTtdkRireki.syoriYmd,
            qIT_KhTtdkRireki.syorikbn,
            qIT_KhTtdkRireki.syorisosikicd,
            qIT_KhTtdkRireki.henkousikibetukey,
            qIT_KhTtdkRireki.henkourrkumu,
            qIT_KhTtdkRireki.shrsyousaiumu,
            qIT_KhTtdkRireki.kouteikanriid,
            qIT_KhTtdkRireki.gyoumuKousinKinou,
            qAS_Kinou.kinouNm,
            qAM_User.userNm,
            $(subQuery1),
            $(subQuery2) )+
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $LEFT_OUTER_JOIN + qIT_KhTtdkRireki.AS_Kinou() +
            $AS + qAS_Kinou +
            $LEFT_OUTER_JOIN + qIT_KhTtdkRireki.AM_User() +
            $AS + qAM_User +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $ORDER_BY(qIT_KhTtdkRireki.gyoumuKousinTime.desc());

        return em.createJPQL(querySql).bind(qIT_KhTtdkRireki, qAS_Kinou, qAM_User,qIT_KhHenkouRireki,qIT_KhShrRireki).getResultList();
    }

    public List<KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean> getKhTtdkRirekiInfoBySyonoHenkousikibetukey(
        String pSyono, String pHenkousikibetukey) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");


        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");


        QAM_User qAM_User = new QAM_User("qAM_User");

        String querySql = $SELECT + $NEW(KhTtdkRirekiInfoBySyonoHenkousikibetukeyBean.class,
            qIT_KhTtdkRireki,
            qAS_Kinou,
            qAM_User) +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $LEFT_OUTER_JOIN + qIT_KhTtdkRireki.AS_Kinou() +
            $AS + qAS_Kinou +
            $LEFT_OUTER_JOIN + qIT_KhTtdkRireki.AM_User() +
            $AS + qAM_User +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(pHenkousikibetukey);

        return em.createJPQL(querySql).bind(qIT_KhTtdkRireki, qAS_Kinou, qAM_User).getResultList();
    }

    public ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean> getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(
        BizDate pSyoriYmd, C_SyutkKbn pSyutkkbn, String[] pGyoumuKousinKinou) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        String mainStry = $SELECT + qIT_KhTtdkRireki + "," +
            qIT_KykDairiten + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSonotaTkyk + "," +
            qIT_KykSya + "," +
            qIT_HhknSya +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() + "," +
            qIT_KykDairiten.IT_KykDairiten() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn()  + "," +
            qIT_KykSonotaTkyk.IT_KykSonotaTkyk() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() +
            $WHERE + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.in(pGyoumuKousinKinou) +
            $AND + qIT_KykDairiten.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KykDairiten.drtenrenno.eq(1) +
            $AND + qIT_KykKihon.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSonotaTkyk.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KykSya.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KhTtdkRireki.syono) +
            $ORDER_BY (qIT_KhTtdkRireki.syono.asc(),
                qIT_KhTtdkRireki.henkousikibetukey.asc());

        return em.createJPQL(mainStry).bind(qIT_KhTtdkRireki, qIT_KykDairiten, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_KykSya, qIT_HhknSya).getResults(KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean.class);
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekisBySyonoGyoumuKousinKinous(String pSyono, String[] pGyoumuKousinKinou) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String sql = $SELECT + qIT_KhTtdkRireki +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.in(pGyoumuKousinKinou) +
            $ORDER_BY (qIT_KhTtdkRireki.gyoumuKousinTime.desc());
        return em.createJPQL(sql).bind(qIT_KhTtdkRireki).getResultList();
    }

    public Long getKhTtdkRirekiCountBySyonoGyoumuKousinKinou(String pSyono, String pGyoumuKousinKinou) {


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String querySql = $SELECT + $COUNT + "(*)" +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou);

        return em.createJPQL(querySql).bind(qIT_KhTtdkRireki).getSingleResult();
    }


    public HoyuuKhTtdkRirekiByPkBean getHoyuuKhTtdkRirekiByPk(String pSyono,String pHenkousikibetukey){


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String queryStr = $SELECT +  $NEW(HoyuuKhTtdkRirekiByPkBean.class,
            qIT_KhTtdkRireki.syoriYmd) +
            $FROM (qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(pHenkousikibetukey);

        return em.createJPQL(queryStr, HoyuuKhTtdkRirekiByPkBean.class).bind(qIT_KhTtdkRireki).getSingleResult();
    }
}
