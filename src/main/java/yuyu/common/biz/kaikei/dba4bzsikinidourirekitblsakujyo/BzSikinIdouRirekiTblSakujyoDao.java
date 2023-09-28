package yuyu.common.biz.kaikei.dba4bzsikinidourirekitblsakujyo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.meta.QBT_SikinIdouRireki;

/**
 * 業務共通 経理・会計 資金移動用履歴テーブル削除DAO
 */
public class BzSikinIdouRirekiTblSakujyoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BT_SikinIdouRireki> getBtSikinIdouRirekiItDelData(String pSyono, String pHenKouSikiBetuKey) {

        QBT_SikinIdouRireki qBT_SikinIdouRireki = new QBT_SikinIdouRireki("qBT_SikinIdouRireki");

        String sql = $SELECT + qBT_SikinIdouRireki +
            $FROM (qBT_SikinIdouRireki) +
            $WHERE + qBT_SikinIdouRireki.syono.eq(pSyono) +
            $AND + qBT_SikinIdouRireki.henkousikibetukey.eq(pHenKouSikiBetuKey);

        return exDBEntityManager.createJPQL(sql).bind(qBT_SikinIdouRireki).getResultList();
    }

    public List<BT_SikinIdouRireki> getBtSikinIdouRirekiJtDelDeta(String pSyono, String pSkno, Integer pSkrrkno) {

        QBT_SikinIdouRireki qBT_SikinIdouRireki = new QBT_SikinIdouRireki("qBT_SikinIdouRireki");

        String sql = $SELECT + qBT_SikinIdouRireki +
            $FROM  (qBT_SikinIdouRireki) +
            $WHERE + qBT_SikinIdouRireki.syono.eq(pSyono) +
            $AND + qBT_SikinIdouRireki.skno.eq(pSkno) +
            $AND + qBT_SikinIdouRireki.seikyuurirekino.eq(pSkrrkno);

        return exDBEntityManager.createJPQL(sql).bind(qBT_SikinIdouRireki).getResultList();
    }
}
