package yuyu.def.siharai.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;

import com.google.common.base.Predicate;

/**
 * 保険金給付金備金管理テーブル用 Predicate<br/>
 * 証券番号（一致）、決算基準日（一致）、備金コード区分(死亡受付、死亡仮受付以外)<br/>
 */
public class FilterSiBikinkanriBySyonoKessankijyunymdBkncdkbn implements Predicate<JT_SiBikinkanri>{

    String syono;

    BizDate kessankijyunymd;

    public FilterSiBikinkanriBySyonoKessankijyunymdBkncdkbn(String pSyono, BizDate pKessankijyunymd){

        super();

        syono = pSyono;
        kessankijyunymd = pKessankijyunymd;
    }

    @Override
    public boolean apply(JT_SiBikinkanri pSiBikinkanri){

        if (syono.equals(pSiBikinkanri.getSyono()) &&
            kessankijyunymd.compareTo(pSiBikinkanri.getKessankijyunymd()) == 0 &&
            !C_BkncdKbn.SIBOUUKETUKE.eq(pSiBikinkanri.getBkncdkbn()) &&
            !C_BkncdKbn.SIBOUKARIUKETUKE.eq(pSiBikinkanri.getBkncdkbn())) {

            return true;
        }

        return false;
    }
}
