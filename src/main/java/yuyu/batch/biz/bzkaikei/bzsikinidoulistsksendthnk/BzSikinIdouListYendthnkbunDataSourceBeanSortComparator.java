package yuyu.batch.biz.bzkaikei.bzsikinidoulistsksendthnk;

import java.util.Comparator;

import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunDataSourceBean;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * BzSikinIdouListYendthnkbunDataSourceBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛（ＩＲ）経理用資金移動グループ番号、（ＩＲ）経理用指定通貨種類、（ＩＲ）経理用取引通貨種類、
 * （ＩＲ）資金移動区分名、（ＩＲ）セグメント１コード、（ＩＲ）経理用円建変更区分名｝です。
 */
public class BzSikinIdouListYendthnkbunDataSourceBeanSortComparator implements Comparator<BzSikinIdouListYendthnkbunDataSourceBean> {

    @Override
    public int compare(BzSikinIdouListYendthnkbunDataSourceBean o1, BzSikinIdouListYendthnkbunDataSourceBean o2) {

        C_SikinidougroupKbn irKeirisikinidougroupno1 = o1.getIrKeirisikinidougroupno();
        C_SikinidougroupKbn irKeirisikinidougroupno2 = o2.getIrKeirisikinidougroupno();

        C_Tuukasyu irKeirisiteituukasyu1 = o1.getIrKeirisiteituukasyu();
        C_Tuukasyu irKeirisiteituukasyu2 = o2.getIrKeirisiteituukasyu();

        C_Tuukasyu irKeiritrhktuukasyu1 = o1.getIrKeiritrhktuukasyu();
        C_Tuukasyu irKeiritrhktuukasyu2 = o2.getIrKeiritrhktuukasyu();

        String irSikinidoukbnnm1 = o1.getIrSikinidoukbnnm();
        String irSikinidoukbnnm2 = o2.getIrSikinidoukbnnm();

        C_Segcd irSeg1cd1 = o1.getIrSeg1cd();
        C_Segcd irSeg1cd2 = o2.getIrSeg1cd();

        String irKeiriyendthnkkbnnm1 = o1.getIrKeiriyendthnkkbnnm();
        String irKeiriyendthnkkbnnm2 = o2.getIrKeiriyendthnkkbnnm();

        if (!irKeirisikinidougroupno1.eq(irKeirisikinidougroupno2)) {

            return irKeirisikinidougroupno1.compareTo(irKeirisikinidougroupno2);
        }
        else if (!irKeirisiteituukasyu1.eq(irKeirisiteituukasyu2)) {

            return irKeirisiteituukasyu1.compareTo(irKeirisiteituukasyu2);
        }
        else if (!irKeiritrhktuukasyu1.eq(irKeiritrhktuukasyu2)) {

            return irKeiritrhktuukasyu1.compareTo(irKeiritrhktuukasyu2);
        }
        else if (!irSikinidoukbnnm1.equals(irSikinidoukbnnm2)) {

            if ("".equals(irSikinidoukbnnm1)) {
                return -1;
            }

            if ("".equals(irSikinidoukbnnm2)) {
                return 1;
            }

            return irSikinidoukbnnm1.compareTo(irSikinidoukbnnm2);
        }
        else if (!irSeg1cd1.eq(irSeg1cd2)) {

            return irSeg1cd1.compareTo(irSeg1cd2);
        }
        else if (!irKeiriyendthnkkbnnm1.equals(irKeiriyendthnkkbnnm2)) {

            return irKeiriyendthnkkbnnm1.compareTo(irKeiriyendthnkkbnnm2);
        }

        return 0;
    }
}
