package yuyu.def.direct.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;

import com.google.common.base.Predicate;
/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル用 Predicate<br/>
 * ＤＳデータ作成日（一致）<br/>
 * ＤＳメールアドレス連番（一致）<br/>
 */
public class FilterDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban implements Predicate<MT_DsMailAddressSpiralYyk> {

    BizDate dsdatasakuseiymd;
    Integer dsmailaddressrenban;

    public FilterDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate pDsdatasakuseiymd,
            Integer pDsmailaddressrenban) {

        super();
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    @Override
    public boolean apply(MT_DsMailAddressSpiralYyk pDsMailAddressSpiralYyk) {

        if (dsdatasakuseiymd.compareTo(pDsMailAddressSpiralYyk.getDsdatasakuseiymd()) == 0 &&
                dsmailaddressrenban.equals(pDsMailAddressSpiralYyk.getDsmailaddressrenban())) {

            return true;
        }
        return false;
    }

}
