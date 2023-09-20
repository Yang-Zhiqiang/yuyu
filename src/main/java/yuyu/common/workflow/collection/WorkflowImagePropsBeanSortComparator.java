package yuyu.common.workflow.collection;

import java.util.Comparator;

import yuyu.common.workflow.workflowutility.ImagePropsBean;

/**
 * ImagePropsBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛申込番号の昇順、事務手続コードの昇順、証券番号の昇順、年金証書番号の昇順、書類到着日時の降順｝です。
 */
public class WorkflowImagePropsBeanSortComparator implements Comparator<ImagePropsBean> {

    @Override
    public int compare(ImagePropsBean o1, ImagePropsBean o2) {

        String jimu1 = o1.getJimutetuzukiCd() == null ? "" : o1.getJimutetuzukiCd();
        String jimu2 = o2.getJimutetuzukiCd() == null ? "" : o2.getJimutetuzukiCd();

        String mos1 = o1.getMosNo() == null ? "" : o1.getMosNo();
        String mos2 = o2.getMosNo() == null ? "" : o2.getMosNo();

        String syo1 = o1.getSyoNo() == null ? "" : o1.getSyoNo();
        String syo2 = o2.getSyoNo() == null ? "" : o2.getSyoNo();

        String nkSy1 = o1.getNkSysyNo() == null ? "" : o1.getNkSysyNo();
        String nkSy2 = o2.getNkSysyNo() == null ? "" : o2.getNkSysyNo();

        String ttyk1 = o1.getSyoruiTtykYmdTime() == null ? "99999999999999999" : o1.getSyoruiTtykYmdTime();
        String ttyk2 = o2.getSyoruiTtykYmdTime() == null ? "99999999999999999" : o2.getSyoruiTtykYmdTime();

        if (!jimu1.equals(jimu2)) {

            if (jimu1.equals("")) {
                return -1;
            }
            if (jimu2.equals("")) {
                return 1;
            }

            return jimu1.compareTo(jimu2);
        }
        else if (!mos1.equals(mos2)) {
            if (mos1.equals("")) {
                return -1;
            }
            if (mos2.equals("")) {
                return 1;
            }

            return mos1.compareTo(mos2);
        }
        else if (!syo1.equals(syo2)) {
            if (syo1.equals("")) {
                return -1;
            }
            if (syo2.equals("")) {
                return 1;
            }

            return syo1.compareTo(syo2);
        }
        else if (!nkSy1.equals(nkSy2)) {
            if (nkSy1.equals("")) {
                return -1;
            }
            if (nkSy2.equals("")) {
                return 1;
            }

            return nkSy1.compareTo(nkSy2);

        }
        else {
            return ttyk2.compareTo(ttyk1);
        }
    }
}
