package yuyu.app.direct.dskokyakukanri.dstrhkservicetouroku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsTourokuUkKanri;
import yuyu.def.db.meta.QMT_DsTourokuUkKouzaAnsyono;

/**
 * ダイレクトサービス 顧客管理 取引サービス登録機能DAOクラス<br/>
 */
public class DsTrhkServiceTourokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<DsTourokuUkKanriInfoBean> getDsTourokuUkKanriInfoByDsjimukaisiymdDsjimukanryouymdTourokustatus(
        BizDate pJimuStartYmdFrom, BizDate pJimuStartYmdTo, C_TourokustatusKbn pTourokuStatus) {

        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri1 = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri1");
        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri2 = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri2");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("QHT_SyoriCTL");

        String strSubSql1 = $SELECT + qIT_KykSya.kyknmkj + $AS + "kyknmkjkh"          +
            $FROM(qIT_KykSya)                                                         +
            $WHERE + qIT_KykSya.syono.eq(qMT_DsTourokuUkKanri1.syono);

        String  mosKihonJoinSql = $FROM(
            qHT_MosKihon,
            qHT_SyoriCTL
            ) +
            $WHERE + qHT_SyoriCTL.mosno.eq(qMT_DsTourokuUkKanri1.mosno)               +
            $AND + qHT_SyoriCTL.syono.eq(qMT_DsTourokuUkKanri1.syono)                 +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno);

        String strSubSql2 = $SELECT + qHT_MosKihon.kyknmkj + $AS + "kyknmkjsk"        +
            mosKihonJoinSql;

        String strSubSql3 = $SELECT + qHT_MosKihon.hhknnmkj + $AS + "hhknnmkjsk"      +
            mosKihonJoinSql;

        String strSubSql4 = $SELECT + qHT_MosKihon.kykkbn + $AS + "kykkbn"            +
            mosKihonJoinSql;

        String strSubSql5 = $SELECT + $MAX(qMT_DsTourokuUkKanri2.datarenno) +
            $FROM(qMT_DsTourokuUkKanri2) +
            $WHERE + qMT_DsTourokuUkKanri2.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU) +
            $AND + qMT_DsTourokuUkKanri2.syono.eq(qMT_DsTourokuUkKanri1.syono);

        String jyoukenHensuu = "";

        if (!C_TourokustatusKbn.BLNK.eq(pTourokuStatus)) {
            jyoukenHensuu = qMT_DsTourokuUkKanri1.tourokustatus.eq(pTourokuStatus);
        }

        if (pJimuStartYmdFrom != null) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_DsTourokuUkKanri1.dsjimukaisiymd.ge(pJimuStartYmdFrom);
            }
            else {
                jyoukenHensuu = qMT_DsTourokuUkKanri1.dsjimukaisiymd.ge(pJimuStartYmdFrom);
            }
        }

        if (pJimuStartYmdTo != null) {
            if (!BizUtil.isBlank(jyoukenHensuu)) {
                jyoukenHensuu = jyoukenHensuu + $AND + qMT_DsTourokuUkKanri1.dsjimukaisiymd.le(pJimuStartYmdTo);
            }
            else {
                jyoukenHensuu = qMT_DsTourokuUkKanri1.dsjimukaisiymd.le(pJimuStartYmdTo);
            }
        }

        String strSql = $SELECT + $NEW(DsTourokuUkKanriInfoBean.class,
            qMT_DsTourokuUkKanri1.syono,
            qMT_DsTourokuUkKanri1.mosno,
            qMT_DsTourokuUkKanri1.tourokustatus,
            qMT_DsTourokuUkKanri1.dsjimukaisiymd,
            qMT_DsTourokuUkKanri1.gyoumuKousinsyaId,
            $(strSubSql1),
            $(strSubSql2),
            $(strSubSql3),
            $(strSubSql4)
            ) +
            $FROM(qMT_DsTourokuUkKanri1) +
            $WHERE +
            jyoukenHensuu +
            $AND + qMT_DsTourokuUkKanri1.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU) +
            $AND + qMT_DsTourokuUkKanri1.tourokustatus.ne(C_TourokustatusKbn.TOUROKUZUMI) +
            $AND + qMT_DsTourokuUkKanri1.datarenno + $EQ + $(strSubSql5) +
            $ORDER_BY(
                qMT_DsTourokuUkKanri1.dsjimukaisiymd.asc(),
                qMT_DsTourokuUkKanri1.syono.asc()
                );

        return exDBEntityManager.createJPQL(strSql, DsTourokuUkKanriInfoBean.class).bind(
            qMT_DsTourokuUkKanri1 ,qMT_DsTourokuUkKanri2, qIT_KykSya, qHT_MosKihon, qHT_SyoriCTL).getResultList();
    }

    public MT_DsTourokuUkKanri getDsTourokuUkKanriBySyono(String pSyono) {

        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri1 = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri1");
        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri2 = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri2");
        QMT_DsTourokuUkKouzaAnsyono qMT_DsTourokuUkKouzaAnsyono = new QMT_DsTourokuUkKouzaAnsyono("qMT_DsTourokuUkKouzaAnsyono");

        String strSubSql = $SELECT + $MAX(qMT_DsTourokuUkKanri2.datarenno) +
            $FROM(qMT_DsTourokuUkKanri2) +
            $WHERE + qMT_DsTourokuUkKanri2.syono.eq(pSyono)+
            $AND + qMT_DsTourokuUkKanri2.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU);

        String strSql = $SELECT + qMT_DsTourokuUkKanri1 +
            $FROM (qMT_DsTourokuUkKanri1,
                qMT_DsTourokuUkKouzaAnsyono)  +
                $WHERE + qMT_DsTourokuUkKanri1.syono.eq(qMT_DsTourokuUkKouzaAnsyono.syono) +
                $AND + qMT_DsTourokuUkKanri1.dsttdksyubetukbn.eq(qMT_DsTourokuUkKouzaAnsyono.dsttdksyubetukbn) +
                $AND + qMT_DsTourokuUkKanri1.datarenno.eq(qMT_DsTourokuUkKouzaAnsyono.datarenno) +
                $AND + qMT_DsTourokuUkKanri1.syono.eq(pSyono) +
                $AND + qMT_DsTourokuUkKanri1.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU) +
                $AND + qMT_DsTourokuUkKanri1.datarenno + $EQ + $(strSubSql);

        return exDBEntityManager.createJPQL(strSql).bind(
            qMT_DsTourokuUkKanri1 ,qMT_DsTourokuUkKanri2, qMT_DsTourokuUkKouzaAnsyono).getSingleResult();
    }

    public List<String> getDsKokyakuKeiyakuBySyono(String pSyono) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");

        String strSql = $SELECT + qMT_DsKokyakuKeiyaku.dskokno +
            $FROM (qMT_DsKokyakuKeiyaku) +
            $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
            $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKeiyaku).getResultList();
    }

    public MT_DsKokyakuKanri getDsKokyakuKanriByDskokno(String pDskokno) {

        QMT_DsKokyakuKanri qMT_DsKokyakuKanri = new QMT_DsKokyakuKanri("qMT_DsKokyakuKanri");

        String strSql = $SELECT + qMT_DsKokyakuKanri           +
            $FROM (qMT_DsKokyakuKanri) +
            $WHERE + qMT_DsKokyakuKanri.dskokno.eq(pDskokno) +
            $AND + $(qMT_DsKokyakuKanri.dskokyakujtkbn.eq(C_DsKokyakuJtKbn.YUUKOU) +
                $OR + qMT_DsKokyakuKanri.dskokyakujtkbn.eq(C_DsKokyakuJtKbn.ITIJI_TEISI));

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsKokyakuKanri).getSingleResult();
    }

    public Integer getDsTourokuUkKanriMaxBySyono(String pSyono) {

        QMT_DsTourokuUkKanri qMT_DsTourokuUkKanri = new QMT_DsTourokuUkKanri("qMT_DsTourokuUkKanri");

        String strSql = $SELECT + $MAX(qMT_DsTourokuUkKanri.datarenno)  +
            $FROM (qMT_DsTourokuUkKanri) +
            $WHERE + qMT_DsTourokuUkKanri.syono.eq(pSyono)              +
            $AND + qMT_DsTourokuUkKanri.dsttdksyubetukbn.eq(C_DsTtdksyubetuKbn.TORIHIKITOUROKU);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsTourokuUkKanri).getSingleResult();
    }
}
