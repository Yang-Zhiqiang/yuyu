package yuyu.batch.direct.dskokyakukanri.dshanyoukokyakutuutisakusei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;

import com.google.common.base.Predicate;

/**
 * ＤＳ汎用顧客宛通知２テーブル用Predicateクラス１<br/>
 */
public class FilterDsHanyouKokyakuateTuuti2 implements Predicate<MT_DsHanyouKokyakuateTuuti2> {

    BizDate dsdatasakuseiymd;
    String dskoktuutirenno;
    String dskokno;
    C_DsHanyouKokyakuateTuutiKbn dshanyoukokyakuatetuutikbn;

    public FilterDsHanyouKokyakuateTuuti2(BizDate pDsdatasakuseiymd, String pDskoktuutirenno, String pDskokno, C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        super();
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dskoktuutirenno = pDskoktuutirenno;
        dskokno = pDskokno;
        dshanyoukokyakuatetuutikbn = pDshanyoukokyakuatetuutikbn;
    }

    @Override
    public boolean apply(MT_DsHanyouKokyakuateTuuti2 pDsHanyouKokyakuateTuuti2) {
        if (BizDateUtil.compareYmd(dsdatasakuseiymd, pDsHanyouKokyakuateTuuti2.getDsdatasakuseiymd()) == BizDateUtil.COMPARE_EQUAL &&
            pDsHanyouKokyakuateTuuti2.getDskoktuutirenno().equals(dskoktuutirenno) &&
            pDsHanyouKokyakuateTuuti2.getDskokno().equals(dskokno)&&
            dshanyoukokyakuatetuutikbn.eq(pDsHanyouKokyakuateTuuti2.getDshanyoukokyakuatetuutikbn())){
            return true;
        }
        return false;
    }
}
