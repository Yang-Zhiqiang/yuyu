package yuyu.common.biz.koutei;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 業務共通 工程 進捗履歴情報データソース情報
 */
public interface ProgressHistoryDataSourceBeanCommonParam {

    void setVprghsdispsyoriymd(BizDate pVprghsdispsyoriymd);

    BizDate getVprghsdispsyoriymd();

    void setVprghsdisptasknm(String pVprghsdisptasknm);

    String getVprghsdisptasknm();

    void setVprghsdispsyorikekkakbn(C_SyorikekkaKbn pVprghsdispsyorikekkakbn);

    C_SyorikekkaKbn getVprghsdispsyorikekkakbn();

    void setVprghsdispsousasyanm(String pVprghsdispsousasyanm);

    String getVprghsdispsousasyanm();

    void setVprghsdispcomment(String pVprghsdispcomment);

    String getVprghsdispcomment();
}
