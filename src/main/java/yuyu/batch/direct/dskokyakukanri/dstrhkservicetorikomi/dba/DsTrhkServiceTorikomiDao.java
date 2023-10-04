package yuyu.batch.direct.dskokyakukanri.dstrhkservicetorikomi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsTorihikiServiceKanri;
import yuyu.def.db.meta.QMT_DsTourokuUkKanri;

/**
 * ダイレクトサービス 顧客管理 取引サービス取込機能DAOクラス
 */
public class DsTrhkServiceTorikomiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakuToujitukanyuuBySyoriYmd(BizDate pSyoriYmd) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsTorihikiServiceKanri qMT_DsTorihikiServiceKanri = new QMT_DsTorihikiServiceKanri("qMT_DsTorihikiServiceKanri");

        String strSubSql1 = $SELECT + qMT_DsTorihikiServiceKanri.dskokno +
            $FROM(qMT_DsTorihikiServiceKanri) +
            $WHERE + qMT_DsTorihikiServiceKanri.syono.eq(qMT_DsKokyakuKeiyaku.syono) +
            $AND + qMT_DsTorihikiServiceKanri.dstrhkserviceriyoujkkbn.eq(C_DsTrhkserviceRiyoujkKbn.RIYOU_KA);

        String strSql = $SELECT + qMT_DsKokyakuKeiyaku +
            $FROM(qMT_DsKokyakuKeiyaku) +
            $WHERE + qMT_DsKokyakuKeiyaku.dskykkanyuuymd.eq(pSyoriYmd) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.ne(C_MukouHyj.MUKOU) +
            $AND + $NOT_EXISTS(strSubSql1) +
            $ORDER_BY(qMT_DsKokyakuKeiyaku.dskokno.asc(),
                qMT_DsKokyakuKeiyaku.syono.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKeiyaku, qMT_DsTorihikiServiceKanri).getResultList();
    }

    public List<HT_SyoriCTL> detachMosKihonUketoriKouzaJyouhoutouched(List<HT_SyoriCTL> pSyoriCTLList) {

        for (HT_SyoriCTL entity : pSyoriCTLList) {

            if (entity != null) {

                entity.getMosKihon();

                entity.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA);

                entity.detach();
            }
            else {
                continue;
            }
        }

        return pSyoriCTLList;
    }

    public MT_DsTourokuUkKanri getDsTourokuUkKanriBySyono(String pSyoNo) {

        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri");

        String strSubSql1 = $SELECT + $MAX(qMT_DsTourokuUkKanri.datarenno) +
            $FROM(qMT_DsTourokuUkKanri) +
            $WHERE + qMT_DsTourokuUkKanri.syono.eq(pSyoNo) +
            $AND + qMT_DsTourokuUkKanri.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU) +
            $AND + qMT_DsTourokuUkKanri.tourokustatus.eq(C_TourokustatusKbn.NYUURYOKUZUMI);

        String strSql = $SELECT + qMT_DsTourokuUkKanri +
            $FROM(qMT_DsTourokuUkKanri) +
            $WHERE + qMT_DsTourokuUkKanri.syono.eq(pSyoNo) +
            $AND + qMT_DsTourokuUkKanri.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU) +
            $AND + qMT_DsTourokuUkKanri.datarenno + $EQ + $(strSubSql1);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsTourokuUkKanri).getSingleResult();
    }
}
