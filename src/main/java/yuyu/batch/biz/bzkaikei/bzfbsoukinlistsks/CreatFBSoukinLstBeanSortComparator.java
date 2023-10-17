package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.util.Comparator;

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 【ＦＢ送金リスト作成】CreatFBSoukinLstBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛書類コード区分の昇順、支払方法指定区分の昇順、業務コードの昇順｝です
 */
public class CreatFBSoukinLstBeanSortComparator implements Comparator<CreatFBSoukinLstBean> {

    @Override
    public int compare(CreatFBSoukinLstBean o1, CreatFBSoukinLstBean o2) {

        C_SyoruiCdKbn syoruiCdKbn1 = o1.getSyoruiCdKbn() == null ? C_SyoruiCdKbn.BLNK : o1.getSyoruiCdKbn();
        C_SyoruiCdKbn syoruiCdKbn2 = o2.getSyoruiCdKbn() == null ? C_SyoruiCdKbn.BLNK : o2.getSyoruiCdKbn();

        C_ShrhousiteiKbn shrhousiteikbn1 =
            o1.getShrhousiteikbn() == null ? C_ShrhousiteiKbn.BLNK : o1.getShrhousiteikbn();
        C_ShrhousiteiKbn shrhousiteikbn2 =
            o2.getShrhousiteikbn() == null ? C_ShrhousiteiKbn.BLNK : o2.getShrhousiteikbn();

        C_Gyoumucd  irGyoumucd1 = o1.getIrGyoumucd() == null ?  C_Gyoumucd.BLNK : o1.getIrGyoumucd();
        C_Gyoumucd  irGyoumucd2 = o2.getIrGyoumucd() == null ?  C_Gyoumucd.BLNK : o2.getIrGyoumucd();
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
        else{

            if(!shrhousiteikbn1.equals(shrhousiteikbn2)) {

                if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn1)) {
                    return -1;
                }
                if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn2)) {
                    return 1;
                }

                cmpret =  shrhousiteikbn1.compareTo(shrhousiteikbn2);

            }
            else {

                if(!irGyoumucd1.equals(irGyoumucd2)) {

                    if(C_Gyoumucd.BLNK.eq(irGyoumucd1)) {
                        return -1;
                    }
                    if(C_Gyoumucd.BLNK.eq(irGyoumucd2)) {
                        return 1;
                    }

                    cmpret =  irGyoumucd1.compareTo(irGyoumucd2);
                }
            }
        }

        return cmpret;
    }
}
