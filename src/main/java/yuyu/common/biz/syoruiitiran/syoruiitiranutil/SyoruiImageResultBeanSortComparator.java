package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.util.Comparator;

/**
 * 【書類情報一覧】WkImageInfoBeanをソートするためのコンパレータクラス。<br />
 * ソート条件は｛ソート番号の昇順、書類到着日時の降順｝です。
 */
public class SyoruiImageResultBeanSortComparator implements Comparator<WkImageInfoBean> {

    @Override
    public int compare(WkImageInfoBean o1, WkImageInfoBean o2) {


        Integer sortNo1 = o1.getSortNo();
        Integer sortNo2 = o2.getSortNo();
        String sdt1 = o1.getSyoruitoutyakutime() == null ? "" : o1.getSyoruitoutyakutime();
        String sdt2 = o2.getSyoruitoutyakutime() == null ? "" : o2.getSyoruitoutyakutime();
        int cmpret = 0;

        if(sortNo1.compareTo(sortNo2) != 0){
            cmpret = sortNo1.compareTo(sortNo2);
            return cmpret;

        }
        else{

            if(sdt2.equals("")) {
                return -1;
            }
            if(sdt1.equals("")) {
                return 1;
            }

            return (int) (Double.parseDouble(sdt2) - Double.parseDouble(sdt1));
        }
    }
}
