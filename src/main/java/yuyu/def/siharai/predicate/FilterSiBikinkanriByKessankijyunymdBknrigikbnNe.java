package yuyu.def.siharai.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;

import com.google.common.base.Predicate;

/**
 * 保険金給付金備金管理テーブル用 Predicate<br/>
 * 決算基準日（一致）、備金例外区分（不一致）<br/>
 */
public class FilterSiBikinkanriByKessankijyunymdBknrigikbnNe implements Predicate<JT_SiBikinkanri>{

    BizDate kessankijyunymd;

    C_BknrigiKbn bknrigikbn;

    public FilterSiBikinkanriByKessankijyunymdBknrigikbnNe(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn){

        super();

        kessankijyunymd = pKessankijyunymd;
        bknrigikbn = pBknrigikbn;
    }

    @Override
    public boolean apply(JT_SiBikinkanri pSiBikinkanri){

        if (kessankijyunymd.equals(pSiBikinkanri.getKessankijyunymd()) && !bknrigikbn.eq(pSiBikinkanri.getBknrigikbn())) {

            return true;
        }

        return false;
    }
}
