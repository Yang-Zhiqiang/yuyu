package yuyu.def.sinkeiyaku.bean.report;

import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * （新契約）返金未処理リスト明細帳票BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkHenkinmisyorilistDetailBean extends GenSkHenkinmisyorilistDetailBean implements IReportDataSouceBean{

    private static final long serialVersionUID = 1L;

    public SkHenkinmisyorilistDetailBean() {
    }

    @Setter @Getter
    private C_SyoruiCdKbn irSyoruicd;
}
