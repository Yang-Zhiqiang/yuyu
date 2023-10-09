package yuyu.app.hozen.khansyuu.khzennouseisangksyoukai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;

import com.google.common.base.Strings;

/**
 *
 * 案内収納 前納精算額照会 前納精算額照会機能DAOクラス<br/>
 */
public class KhZennouSeisanGkSyoukaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KykSyouhn> getKykSyouhns(IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        return kykSyouhnLst;
    }

    public Long getZennouCount(String pSyono) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Zennou).getSingleResult();
    }

    public List<IT_Zennou> getZennous (String pSyono , BizDate pCalckijyunymd,int pDay) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String day = Strings.padStart(String.valueOf(pDay), 2, '0');

        String sql = $SELECT + qIT_Zennou +
            $FROM(qIT_Zennou)+
            $WHERE + qIT_Zennou.syono.eq(pSyono) +
            $AND + qIT_Zennou.ryosyuymd.le(pCalckijyunymd) +
            $AND + qIT_Zennou.annaisaikaiym.concat(day).gt(pCalckijyunymd.toString()) +
            $ORDER_BY(qIT_Zennou.zennoukaisiymd.desc(), qIT_Zennou.renno.desc());

        List<IT_Zennou> zennoulst = exDBEntityManager.createJPQL(sql).bind(qIT_Zennou).getResultList();

        return zennoulst;
    }
}
