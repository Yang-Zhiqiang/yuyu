package yuyu.common.biz.koutei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 進捗履歴情報データソース情報
 */
public class ProgressHistoryDataSourceBeanCommonParamImpl implements ProgressHistoryDataSourceBeanCommonParam{

    private BizDate vprghsdispsyoriymd;

    @Override
    public void setVprghsdispsyoriymd(BizDate pVprghsdispsyoriymd) {
        vprghsdispsyoriymd = pVprghsdispsyoriymd;
    }

    @Override
    public BizDate getVprghsdispsyoriymd() {
        return vprghsdispsyoriymd;
    }

    private String vprghsdisptasknm;

    @Override
    public void setVprghsdisptasknm(String pVprghsdisptasknm) {
        vprghsdisptasknm = pVprghsdisptasknm;
    }

    @Override
    public String getVprghsdisptasknm() {
        return vprghsdisptasknm;
    }

    private C_SyorikekkaKbn vprghsdispsyorikekkakbn;

    @Override
    public void setVprghsdispsyorikekkakbn(C_SyorikekkaKbn pVprghsdispsyorikekkakbn) {
        vprghsdispsyorikekkakbn = pVprghsdispsyorikekkakbn;
    }

    @Override
    public C_SyorikekkaKbn getVprghsdispsyorikekkakbn() {
        return vprghsdispsyorikekkakbn;
    }

    private String vprghsdispsousasyanm;

    @Override
    public void setVprghsdispsousasyanm(String pVprghsdispsousasyanm) {
        vprghsdispsousasyanm = pVprghsdispsousasyanm;
    }

    @Override
    public String getVprghsdispsousasyanm() {
        return vprghsdispsousasyanm;
    }

    private String vprghsdispcomment;

    @Override
    public void setVprghsdispcomment(String pVprghsdispcomment) {
        vprghsdispcomment = pVprghsdispcomment;
    }

    @Override
    public String getVprghsdispcomment() {
        return vprghsdispcomment;
    }

}
