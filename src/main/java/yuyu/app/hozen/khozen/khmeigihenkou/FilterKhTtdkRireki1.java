package yuyu.app.hozen.khozen.khmeigihenkou;



import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;

import com.google.common.base.Predicate;


/**
 * 処理区分が指定されていて、
 * 処理区分が同一の場合に一致するデータをフィルタリングする。
 */
public class FilterKhTtdkRireki1 implements Predicate<IT_KhTtdkRireki>{

    C_SyoriKbn syorikbn;

    FilterKhTtdkRireki1(C_SyoriKbn pSyoriKbn){
        this.syorikbn = pSyoriKbn;
    }

    @Override
    public boolean apply(IT_KhTtdkRireki iT_KhTtdkRireki) {

        if(syorikbn.eq(iT_KhTtdkRireki.getSyorikbn())){
            return true;
        }

        return false;
    }

}