package yuyu.app.hozen.khansyuu.khtokusin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 *
 * 特伸処理 特伸処理DAOのクラスです。<br />
 */
public class KhTokusinDao {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public KhTokusinDao () {

    }

    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public void update (IT_KykKihon pKykKihon) {
        hozenDomManager.update(pKykKihon);
    }

    public IT_Tokusin createTokusin (IT_AnsyuKihon pAnsyuKihon) {
        IT_Tokusin tokusin =  pAnsyuKihon.createTokusin();

        return tokusin;
    }

    public void update (IT_AnsyuKihon pAnsyuKihon) {
        hozenDomManager.update(pAnsyuKihon);
    }

    public IT_Tokusin getTokusin(IT_AnsyuKihon pAnsyuKihon) {
        IT_Tokusin tokusin = pAnsyuKihon.getTokusin();

        return tokusin;
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        return ansyuKihon;
    }

    public IT_KhTtdkRireki createKhTtdkRireki (IT_KykKihon pKykKihon) {
        IT_KhTtdkRireki khTtdkRireki =  pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }

    public void setTokusin (IT_AnsyuKihon pAnsyuKihon,IT_Tokusin pTokusin) {
        pAnsyuKihon.setTokusin(pTokusin);
    }

    public List<IT_YykIdouUktk> getYykIdouUktks(String pSyono) {

        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("qIT_YykIdouUktk");

        String query = $SELECT + qIT_YykIdouUktk +
            $FROM(qIT_YykIdouUktk) +
            $WHERE + qIT_YykIdouUktk.syono.eq(pSyono) +
            $AND + qIT_YykIdouUktk.yykidousyorikbn.eq(C_YykidousyoriKbn.UKE) ;

        return  exDBEntityManager.createJPQL(query).bind(qIT_YykIdouUktk).getResultList();
    }

    public String getKinouNm (String pKinouId) {

        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String query = $SELECT + qAS_Kinou.kinouNm +
            $FROM(qAS_Kinou) +
            $WHERE + qAS_Kinou.kinouId.eq(pKinouId);

        return exDBEntityManager.createJPQL(query).bind(qAS_Kinou).getSingleResult();
    }
}
