package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 【ＦＢ送金リスト作成】CreatFBSoukinLstBeanをソートするためのコンパレータです。<br />
 * ソート条件は
 * ｛書類コード区分の昇順、支払方法指定区分の昇順、業務コードの昇順、伝票日付、支払通貨種類の昇順｝です。
 */
public class CreatGKFBSoukinLstBeanSortComparator implements Comparator<CreatGKFBSoukinLstBean> {

    @Override
    public int compare(CreatGKFBSoukinLstBean o1, CreatGKFBSoukinLstBean o2) {

        C_SyoruiCdKbn syoruiCdKbn1 = o1.getSyoruiCdKbn() == null ? C_SyoruiCdKbn.BLNK : o1.getSyoruiCdKbn();
        C_SyoruiCdKbn syoruiCdKbn2 = o2.getSyoruiCdKbn() == null ? C_SyoruiCdKbn.BLNK : o2.getSyoruiCdKbn();

        C_ShrhousiteiKbn shrhousiteikbn1 = o1.getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o1.getShrhousiteikbn();
        C_ShrhousiteiKbn shrhousiteikbn2 = o2.getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o2.getShrhousiteikbn();

        C_Gkgyoumucd  irGyoumucd1 = o1.getIrGyoumucd() == null ? C_Gkgyoumucd.BLNK : o1.getIrGyoumucd();
        C_Gkgyoumucd  irGyoumucd2 = o2.getIrGyoumucd() == null ? C_Gkgyoumucd.BLNK : o2.getIrGyoumucd();

        BizDate  denymd1 = o1.getDenYmd() == null ? BizDate.MIN_VALUE : o1.getDenYmd();
        BizDate  denymd2 = o2.getDenYmd() == null ? BizDate.MIN_VALUE : o2.getDenYmd();

        C_Tuukasyu  tuukasyu1 = o1.getTuukasyu() == null ? C_Tuukasyu.BLNK : o1.getTuukasyu();
        C_Tuukasyu  tuukasyu2 = o2.getTuukasyu() == null ? C_Tuukasyu.BLNK : o2.getTuukasyu();
        int cmpret = 0;

        if(!syoruiCdKbn1.equals(syoruiCdKbn2)) {

            if(C_SyoruiCdKbn.BLNK.eq(syoruiCdKbn1)) {
                return -1;
            }
            if(C_SyoruiCdKbn.BLNK.eq(syoruiCdKbn2)) {
                return 1;
            }

            cmpret = syoruiCdKbn1.compareTo(syoruiCdKbn2);

        }
        else {

            if(!shrhousiteikbn1.equals(shrhousiteikbn2)) {

                if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn1)) {
                    return -1;
                }
                if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn2)) {
                    return 1;
                }

                cmpret = shrhousiteikbn1.compareTo(shrhousiteikbn2);

            }
            else {

                if(0 != BizDateUtil.compareYmd(denymd1, denymd2)) {

                    if(0 == BizDateUtil.compareYmd(BizDate.MIN_VALUE, denymd1)) {
                        return -1;
                    }
                    if(0 == BizDateUtil.compareYmd(BizDate.MIN_VALUE, denymd2)) {
                        return 1;
                    }

                    cmpret = BizDateUtil.compareYmd(denymd1, denymd2);

                }
                else {

                    if(!irGyoumucd1.eq(irGyoumucd2)) {

                        if(C_Gkgyoumucd.BLNK.eq(irGyoumucd1)) {
                            return -1;
                        }
                        if(C_Gkgyoumucd.BLNK.eq(irGyoumucd2)) {
                            return 1;
                        }

                        cmpret =  irGyoumucd1.compareTo(irGyoumucd2);

                    }
                    else {

                        if(!tuukasyu1.eq(tuukasyu2)) {

                            if(C_Tuukasyu.BLNK.eq(tuukasyu1)) {
                                return -1;
                            }
                            if(C_Tuukasyu.BLNK.eq(tuukasyu2)) {
                                return 1;
                            }

                            cmpret =  tuukasyu1.compareTo(tuukasyu2);

                        }
                    }
                }
            }
        }

        return cmpret;
    }
}
