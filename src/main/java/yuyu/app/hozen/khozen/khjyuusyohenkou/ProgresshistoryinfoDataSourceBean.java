package yuyu.app.hozen.khozen.khjyuusyohenkou;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 住所変更 - ●進捗履歴情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class ProgresshistoryinfoDataSourceBean extends GenProgresshistoryinfoDataSourceBean
implements ProgressHistoryDataSourceBeanCommonParam{

    private static final long serialVersionUID = 1L;

    public ProgresshistoryinfoDataSourceBean() {
    }

    private BizDate dispsyoriymd;

    @Override
    public void setVprghsdispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }

    @Override
    public BizDate getVprghsdispsyoriymd() {
        return dispsyoriymd;
    }

    private String disptasknm;

    @Override
    public void setVprghsdisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }

    @Override
    public String getVprghsdisptasknm() {
        return disptasknm;
    }

    private C_SyorikekkaKbn dispsyorikekkakbn;

    @Override
    public void setVprghsdispsyorikekkakbn(C_SyorikekkaKbn pSyorikekkaKbn) {
        dispsyorikekkakbn = pSyorikekkaKbn;
    }

    @Override
    public C_SyorikekkaKbn getVprghsdispsyorikekkakbn() {
        return dispsyorikekkakbn;
    }

    private String dispsousasyanm;

    @Override
    public void setVprghsdispsousasyanm(String pDispsousasyanm) {
        dispsousasyanm = pDispsousasyanm;
    }

    @Override
    public String getVprghsdispsousasyanm() {
        return dispsousasyanm;
    }
    private String dispcomment;

    @Override
    public void setVprghsdispcomment(String pDispcomment) {
        dispcomment = pDispcomment;
    }

    @Override
    public String getVprghsdispcomment() {
        return dispcomment;
    }

}
