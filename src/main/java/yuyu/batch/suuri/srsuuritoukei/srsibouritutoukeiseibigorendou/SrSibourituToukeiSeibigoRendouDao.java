package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.meta.QSV_SibourituToukeiSeibigo;

/**
 * 死亡率統計整備後連動情報作成DAOクラスです。
 */
public class SrSibourituToukeiSeibigoRendouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SV_SibourituToukeiSeibigo> getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_SyutkKbn pSyutkkbn) {

        QSV_SibourituToukeiSeibigo qSV_SibourituToukeiSeibigo = new QSV_SibourituToukeiSeibigo();

        String strSql = $SELECT + qSV_SibourituToukeiSeibigo +
            $FROM(qSV_SibourituToukeiSeibigo) +
            $WHERE + "(" + "(" + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.KYKTORIKESI) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.KYKTORIKESI) + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.CLGOFF) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.CLGOFF) + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.KAIJO) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.KAIJO) + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.MUKOU) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.MUKOU) + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.SBKAIJO) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBKAIJO) + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.MENSEKI) +
            $AND + "(" + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBMENSEKI) +
            $OR + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBMENSEKI_SHRNASI) + ")" + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.syoumetujiyuu.eq(C_Syoumetujiyuu.SBMUKOU) +
            $AND + "(" + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBMUKOU_KIHRKPSHR) +
            $OR + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBMUKOU_SHRNASI) +
            $OR + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.SBMUKOU) + ")" + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KAIYAKU)+
            $AND + qSV_SibourituToukeiSeibigo.syoumetujiyuu.ne(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM) + ")"+
            $OR + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU) +
            $OR + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_GENGAKU) +
            $OR + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI) +
            $OR + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK) +
            $OR + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU) +
            $OR + "(" + qSV_SibourituToukeiSeibigo.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) +
            $AND + qSV_SibourituToukeiSeibigo.syorikbn.eq(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI) + ")" + ")" +
            $OR + "(" + qSV_SibourituToukeiSeibigo.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB) +
            $AND + qSV_SibourituToukeiSeibigo.shrkekkakbn.ne(C_ShrKekkaKbn.BLNK) +
            $AND + qSV_SibourituToukeiSeibigo.shrkekkakbn.ne(C_ShrKekkaKbn.HSHR) + ")" + ")" +
            $AND + qSV_SibourituToukeiSeibigo.syoriYmd.ge(pSyoriYmdFrom) +
            $AND + qSV_SibourituToukeiSeibigo.syoriYmd.le(pSyoriYmdTo) +
            $AND + qSV_SibourituToukeiSeibigo.syutkkbn.eq(pSyutkkbn) +
            $ORDER_BY(qSV_SibourituToukeiSeibigo.syoriYmd.asc(),
                qSV_SibourituToukeiSeibigo.syono.asc(),
                qSV_SibourituToukeiSeibigo.gyoumuKousinTime.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qSV_SibourituToukeiSeibigo).getResults();
    }
}
