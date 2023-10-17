package yuyu.app.hozen.khozen.khmkhgktttyendthnkuktk.dba;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;

/**
 * 契約保全 契約保全 目標額到達時円建変更受付機能DAOクラス<br/>
 */
public class KhMkhgkTttYendtHnkUktkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;


    public String getNewnaiyouoriginalBySyonoSyoriymd(String pSyono,BizDate pSyoukaiymdfrom,BizDate pSyoukaiymdto){

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + qIT_KhHenkouRireki.newnaiyouoriginal +
            $FROM(qIT_KhHenkouRireki,qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI)+
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSyouhn.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSyouhn.KOURYOKUHASSEIYMD) +
            $AND + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.ge(pSyoukaiymdfrom) +
            $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoukaiymdto);

        String newnaiyouoriginal = exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki,qIT_KhHenkouRireki).getSingleResult();

        return newnaiyouoriginal;

    }
}
