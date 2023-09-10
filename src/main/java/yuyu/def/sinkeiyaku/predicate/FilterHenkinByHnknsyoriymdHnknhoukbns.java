package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金処理日（一致）、返金方法区分（一致）
 */
public class FilterHenkinByHnknsyoriymdHnknhoukbns implements Predicate<HT_Henkin>{

    BizDate hnknsyoriymd;
    C_HnknhouKbn[] hnknhoukbns;

    public FilterHenkinByHnknsyoriymdHnknhoukbns(BizDate pHnknsyoriymd,C_HnknhouKbn... pHnknhoukbn){
        super();

        hnknsyoriymd = pHnknsyoriymd;
        hnknhoukbns = pHnknhoukbn;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (hnknsyoriymd.equals(pHenkin.getHnknsyoriymd())) {

            for(C_HnknhouKbn hnknhouKbn: hnknhoukbns) {

                if(hnknhouKbn.eq(pHenkin.getHnknhoukbn())) {

                    return true;
                }
            }
        }
        return false;
    }

}
