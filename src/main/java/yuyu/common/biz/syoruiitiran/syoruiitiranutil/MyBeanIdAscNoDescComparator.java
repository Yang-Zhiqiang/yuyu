package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import java.util.Comparator;

/**
 * 【書類情報一覧】SyoruiJohoItiranBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛ソート番号の昇順、番号の降順｝です。
 */
public class MyBeanIdAscNoDescComparator implements Comparator<SyoruiJohoItiranBean> {

    @Override
    public int compare(SyoruiJohoItiranBean o1, SyoruiJohoItiranBean o2) {


        Integer sortNo1 = o1.getSortNo();
        Integer sortNo2 = o2.getSortNo();
        String sdt1 = o1.getSyoruiTtykYmdTime() == null ? "" : o1.getSyoruiTtykYmdTime();
        String sdt2 = o2.getSyoruiTtykYmdTime() == null ? "" : o2.getSyoruiTtykYmdTime();
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
            //            return (int) (Double.parseDouble(sdt1) - Double.parseDouble(sdt2));
        }
    }
}
