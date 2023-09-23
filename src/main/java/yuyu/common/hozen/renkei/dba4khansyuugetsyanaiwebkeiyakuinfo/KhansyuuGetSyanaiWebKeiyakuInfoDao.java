package yuyu.common.hozen.renkei.dba4khansyuugetsyanaiwebkeiyakuinfo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;

/**
 * 契約保全 サブシステム連携 社内Web用案内収納契約内容情報取得DAOクラスです
 */
public class KhansyuuGetSyanaiWebKeiyakuInfoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_AnsyuRireki> getAnsyuRirekis (String pSyono) {

        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + qIT_AnsyuRireki +
            $FROM (qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $ORDER_BY (qIT_AnsyuRireki.annaisakuseiymd.desc() +
                qIT_AnsyuRireki.jyuutouym.desc() +
                qIT_AnsyuRireki.annaino.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuRireki).getResultList();
    }

}
