package yuyu.common.hozen.khcommon.dba4koujyosyoumeiutil;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;

import com.google.common.base.Predicate;

/**
 * 既払込Ｐ精算履歴用Predicateクラス１
 *
 */
public class FilterKihrkmpSeisanRireki1 implements Predicate<IT_KihrkmpSeisanRireki> {

    private Integer renno;

    private BizDateYM jyuutouym;

    public FilterKihrkmpSeisanRireki1(Integer pRenno, BizDateYM pJyuutouym) {
        super();
        renno = pRenno;
        jyuutouym = pJyuutouym;
    }

    @Override
    public boolean apply(IT_KihrkmpSeisanRireki pKihrkmpSeisanRireki) {

        if (pKihrkmpSeisanRireki.getJyuutouym() == null) {
            return false;
        }

        BizDateYM seisanEndYm = pKihrkmpSeisanRireki.getJyuutouym().addMonths(
            pKihrkmpSeisanRireki.getSeijyutoukaisuum() + (pKihrkmpSeisanRireki.getSeijyutoukaisuuy() * 12) - 1);

        if (!renno.equals(pKihrkmpSeisanRireki.getRenno())
            &&
            (BizDateUtil.compareYm(jyuutouym, pKihrkmpSeisanRireki.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(jyuutouym, pKihrkmpSeisanRireki.getJyuutouym()) == BizDateUtil.COMPARE_GREATER)
            &&
            (BizDateUtil.compareYm(jyuutouym, seisanEndYm) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(jyuutouym, seisanEndYm) == BizDateUtil.COMPARE_LESSER)
            &&
            C_KiharaiPseisanNaiyouKbn.SEISANP.eq(pKihrkmpSeisanRireki.getKihrkpssnaiyoukbn())
            &&
            C_MisyuumikeikaKbn.MIKEIKAP.eq(pKihrkmpSeisanRireki.getMisyuumikeikakbn())) {
            return true;
        }
        return false;
    }
}
