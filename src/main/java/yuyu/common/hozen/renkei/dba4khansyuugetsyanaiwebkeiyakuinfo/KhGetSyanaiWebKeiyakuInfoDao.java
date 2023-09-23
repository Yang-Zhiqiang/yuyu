package yuyu.common.hozen.renkei.dba4khansyuugetsyanaiwebkeiyakuinfo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsMailAddress;

/**
 * 契約保全 サブシステム連携 社内Web用保全契約内容情報取得DAOクラスです
 */
public class KhGetSyanaiWebKeiyakuInfoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<MT_DsMailAddress> getDsMailAddressTrkjkInfoList (String pSyono) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsMailAddress qMT_DsMailAddress = new QMT_DsMailAddress("qMT_DsMailAddress");

        String strSql = $SELECT + qMT_DsMailAddress +
            $FROM(qMT_DsKokyakuKeiyaku,
                qMT_DsMailAddress) +
                $WHERE + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsMailAddress.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        List<MT_DsMailAddress> dsMailAddressTrkjkInfoList = exDBEntityManager.createJPQL(strSql)
            .bind(qMT_DsKokyakuKeiyaku, qMT_DsMailAddress).getResultList();

        return dsMailAddressTrkjkInfoList;
    }
}
