package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean;
import yuyu.def.hozen.result.bean.KhShrRirekiInfosBySyonoHenkousikibetukeyBean;

/**
 * 契約保全支払履歴テーブル(IT_KhShrRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhShrRirekiDao extends AbstractDao<IT_KhShrRireki> {

    public IT_KhShrRirekiDao() {
        super(IT_KhShrRireki.class);
    }

    @Deprecated
    public IT_KhShrRireki getKhShrRireki(String pSyono,
        String pHenkousikibetukey){
        IT_KhShrRireki iT_KhShrRireki =  new IT_KhShrRireki();
        iT_KhShrRireki.setSyono(pSyono);
        iT_KhShrRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_KhShrRireki);
    }

    @Override
    @Deprecated
    public List<IT_KhShrRireki> selectAll() {
        return super.selectAll();
    }

    public List<KhShrRirekiInfosBySyonoHenkousikibetukeyBean> getKhShrRirekiInfosBySyonoHenkousikibetukey(String pSyono,
        String pHenkousikibetukey) {


        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String querySql = $SELECT + $NEW(KhShrRirekiInfosBySyonoHenkousikibetukeyBean.class,
            qIT_KhShrRireki,
            qIT_KykSyouhn,
            qIT_KykSonotaTkyk ,
            qBM_SyouhnZokusei) +
            $FROM + qIT_KhShrRireki.IT_KhShrRireki() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSonotaTkyk.IT_KykSonotaTkyk() + "," +
            qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSonotaTkyk.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qBM_SyouhnZokusei.syouhncd.eq(qIT_KykSyouhn.syouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno.eq(qIT_KykSyouhn.syouhnsdno);

        return em.createJPQL(querySql).bind(qIT_KhShrRireki, qIT_KykSyouhn, qIT_KykSonotaTkyk, qBM_SyouhnZokusei).getResultList();
    }

    public ExDBResults<KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean> getKhShrRirekiInfosByKakutyoujobcdShrsyoriymd(
        BizDate pShrsyoriymd) {


        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");


        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");


        String strSql = $SELECT + $NEW(KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean.class,
            qIT_KhShrRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KhTtdkRireki) +
            $FROM(qIT_KhShrRireki,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KhTtdkRireki) +
                $WHERE + qIT_KhShrRireki.shrtysysyuruikbn.ne(C_HtsiryosyuKbn.BLNK) +
                $AND + qIT_KhShrRireki.shrsyoriymd.eq(pShrsyoriymd) +
                $AND + qIT_KhShrRireki.syono.eq(qIT_KhTtdkRireki.syono) +
                $AND + qIT_KhShrRireki.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
                $AND + qIT_KhShrRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $ORDER_BY(qIT_KhShrRireki.syono.asc());


        return em.createJPQL(strSql, KhShrRirekiInfosByKakutyoujobcdShrsyoriymdBean.class).bind(qIT_KhShrRireki, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya,
            qIT_HhknSya, qIT_KhTtdkRireki).getResults();
    }
}
