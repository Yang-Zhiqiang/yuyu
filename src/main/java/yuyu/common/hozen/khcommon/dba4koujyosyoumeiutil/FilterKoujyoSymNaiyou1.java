package yuyu.common.hozen.khcommon.dba4koujyosyoumeiutil;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;

import com.google.common.base.Predicate;

/**
 * 控除証明内容用Predicateクラス１
 *
 */
public class FilterKoujyoSymNaiyou1 implements Predicate<IT_KoujyoSymNaiyou> {

    private BizDateYM syoumeistartym;

    private BizDateYM syoumeiendym;

    public FilterKoujyoSymNaiyou1(BizDateYM pSyoumeistartym, BizDateYM pSyoumeiendym) {
        super();
        syoumeistartym = pSyoumeistartym;
        syoumeiendym = pSyoumeiendym;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyou pKoujyoSymNaiyou) {

        if ((BizDateUtil.compareYm(syoumeistartym, pKoujyoSymNaiyou.getSyoumeistartym()) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(syoumeistartym, pKoujyoSymNaiyou.getSyoumeistartym()) == BizDateUtil.COMPARE_LESSER)
            &&
            (BizDateUtil.compareYm(syoumeiendym, pKoujyoSymNaiyou.getSyoumeistartym()) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(syoumeiendym, pKoujyoSymNaiyou.getSyoumeistartym()) == BizDateUtil.COMPARE_GREATER)
            &&
            C_Delflag.BLNK.eq(pKoujyoSymNaiyou.getSakujyoflg())
            &&
            C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK.eq(pKoujyoSymNaiyou.getKoujyosymnaiyoureckbn())) {
            return true;
        }
        return false;
    }
}
