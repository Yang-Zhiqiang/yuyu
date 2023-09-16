package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.result.bean.KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean;
import yuyu.def.hozen.result.bean.KykDairitensMinDrtenrennoBySyonoBean;

/**
 * 契約代理店テーブル(IT_KykDairitenDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykDairitenDao extends AbstractDao<IT_KykDairiten> {

    public IT_KykDairitenDao() {
        super(IT_KykDairiten.class);
    }

    @Deprecated
    public IT_KykDairiten getKykDairiten(String pSyono,
        Integer pDrtenrenno){
        IT_KykDairiten iT_KykDairiten =  new IT_KykDairiten();
        iT_KykDairiten.setSyono(pSyono);
        iT_KykDairiten.setDrtenrenno(pDrtenrenno);
        return this.selectOne(iT_KykDairiten);
    }

    @Override
    @Deprecated
    public List<IT_KykDairiten> selectAll() {
        return super.selectAll();
    }

    public List<KykDairitensMinDrtenrennoBySyonoBean> getKykDairitensDrtencdMinDrtenrennoBySyono(String pSyono) {


        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten();

        String queryStr = $SELECT +  $NEW(KykDairitensMinDrtenrennoBySyonoBean.class,
            qIT_KykDairiten.drtencd,
            $($MIN(qIT_KykDairiten.drtenrenno)) ) +
            $FROM + qIT_KykDairiten.IT_KykDairiten() +
            $WHERE + qIT_KykDairiten.syono.eq(pSyono) +
            $GROUP_BY + qIT_KykDairiten.drtencd;

        return em.createJPQL(queryStr, KykDairitensMinDrtenrennoBySyonoBean.class).bind(qIT_KykDairiten).getResultList();
    }

    public ExDBResults<KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean> getKykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbn(C_SyutkKbn pSyutkkbn) {


        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");


        String strSql = $SELECT + qIT_KykDairiten + "," +
            qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_KykSonotaTkyk + "," +
            qIT_KykSya + "," +
            qIT_HhknSya + "," +
            qIT_AnsyuKihon +
            $FROM + qIT_KykDairiten.IT_KykDairiten() +","+
            qIT_KykKihon.IT_KykKihon() +","+
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qIT_KykSonotaTkyk.IT_KykSonotaTkyk() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() + "," +
            qIT_AnsyuKihon.IT_AnsyuKihon() +
            $WHERE + qIT_KykDairiten.drtenrenno.eq(new Integer(1)) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSonotaTkyk.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_KykSya.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_HhknSya.syono.eq(qIT_KykDairiten.syono) +
            $AND + qIT_AnsyuKihon.syono.eq(qIT_KykDairiten.syono) +
            $ORDER_BY(qIT_KykDairiten.syono.asc());


        return em.createJPQL(strSql).bind(qIT_KykDairiten, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_KykSya, qIT_HhknSya, qIT_AnsyuKihon)
            .getResults(KykDairitenInfosByKakutyoujobcdDrtenrennoSyutkkbnBean.class);
    }
}
