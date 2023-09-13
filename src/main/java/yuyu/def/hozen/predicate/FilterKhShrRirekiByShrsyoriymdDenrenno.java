package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhShrRireki;

import com.google.common.base.Predicate;

/**
 *  契約保全支払履歴テーブル用 Predicate<br/>
 * 支払処理日 伝票データ連番（一致）<br/>
 */
public class FilterKhShrRirekiByShrsyoriymdDenrenno implements Predicate<IT_KhShrRireki> {

    BizDate shrsyoriymd;
    String  denrenno;

    public FilterKhShrRirekiByShrsyoriymdDenrenno(BizDate pShrsyoriymd, String pDenrenno){

        super();

        shrsyoriymd = pShrsyoriymd;
        denrenno = pDenrenno;
    }

    @Override
    public boolean apply(IT_KhShrRireki pKhShrRireki) {

        if (shrsyoriymd.equals(pKhShrRireki.getShrsyoriymd())&& denrenno.equals(pKhShrRireki.getDenrenno())){
            return true;
        }
        return false;
    }
}