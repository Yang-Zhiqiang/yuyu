package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.biz.result.bean.SyoruiZokuseiTyouhyouInfoBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;
import yuyu.def.db.meta.QBT_TyouhyouOutputKengen;

/**
 * 書類属性マスタ(AM_SyoruiZokusei) テーブルアクセス用の DAO クラスです。
 */
public class AM_SyoruiZokuseiExDao extends AbstractDao<AM_SyoruiZokusei> {

    protected AM_SyoruiZokuseiExDao() {
        super(AM_SyoruiZokusei.class);
    }

    public List<SyoruiZokuseiTyouhyouInfoBean> getSyoruiZokuseiTyouhyouInfo (String pSubSystemId, BizDate pSyoriYmd, String[] pRoleCd, C_SyoruiCdKbn pSyoruiCd) {


        QAM_SyoruiZokusei syoruiZokusei = new QAM_SyoruiZokusei();


        QAT_TyouhyouKensaku tyouhyouKensaku = new QAT_TyouhyouKensaku("q1");


        QAT_TyouhyouKensaku tyouhyouKensaku2 = new QAT_TyouhyouKensaku("q2");


        QBT_TyouhyouOutputKengen tyouhyouOutputKengen = new QBT_TyouhyouOutputKengen();


        String subQuery1 = $SELECT + $COUNT(tyouhyouKensaku.uniqueId) +
            $FROM(tyouhyouKensaku) +
            $WHERE + tyouhyouKensaku.subSystemId.eq(pSubSystemId) +
            $AND + tyouhyouKensaku.syoriYmd.eq(pSyoriYmd) +
            $AND + tyouhyouKensaku.syoruiCd.eq(syoruiZokusei.syoruiCd) +
            $AND + tyouhyouKensaku.outCount.eq(0);


        String subQuery2 = $SELECT + $COUNT(tyouhyouKensaku.uniqueId) +
            $FROM(tyouhyouKensaku) +
            $WHERE + tyouhyouKensaku.subSystemId.eq(pSubSystemId) +
            $AND + tyouhyouKensaku.syoriYmd.eq(pSyoriYmd) +
            $AND + tyouhyouKensaku.syoruiCd.eq(syoruiZokusei.syoruiCd);


        String subQuery3 = $SELECT + tyouhyouOutputKengen.roleCd +
            $FROM(tyouhyouOutputKengen) +
            $WHERE + tyouhyouOutputKengen.syoruiCd.eq(syoruiZokusei.syoruiCd) +
            $AND + tyouhyouOutputKengen.roleCd.in(pRoleCd) +
            $AND + tyouhyouOutputKengen.ikkatuoutputkahikbn.eq(C_KahiKbn.KA);


        String mainQuery = $SELECT_DISTINCT + $NEW(SyoruiZokuseiTyouhyouInfoBean.class,
            syoruiZokusei.syoruiCd,
            syoruiZokusei.syoruinm,
            syoruiZokusei.kensakuKey1,
            syoruiZokusei.kensakuKey2,
            syoruiZokusei.kensakuKey3,
            syoruiZokusei.kensakuKey4,
            syoruiZokusei.kensakuKey5,
            syoruiZokusei.sortNo,
            $(subQuery1),
            $(subQuery2)) +
            $FROM(syoruiZokusei,
                tyouhyouKensaku2) +
                $WHERE + $EXISTS(subQuery3) +
                $AND + syoruiZokusei.syoruiCd.eq(tyouhyouKensaku2.syoruiCd) +
                $AND + tyouhyouKensaku2.syoriYmd.eq(pSyoriYmd) +
                $AND + tyouhyouKensaku2.subSystemId.eq(pSubSystemId);

        if (pSyoruiCd != null) {
            mainQuery += $AND + syoruiZokusei.syoruiCd.eq(pSyoruiCd);
        }

        mainQuery += $ORDER_BY(syoruiZokusei.sortNo.asc());

        return em.createJPQL(mainQuery, SyoruiZokuseiTyouhyouInfoBean.class).bind(syoruiZokusei, tyouhyouKensaku, tyouhyouKensaku2, tyouhyouOutputKengen).getResultList();
    }
}