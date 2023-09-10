package yuyu.def.sinkeiyaku.bean.report;

import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * （新契約）申込書類未到着期間経過リスト帳票BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkMossyoruimitoutyakulistBean extends GenSkMossyoruimitoutyakulistBean {

    private static final long serialVersionUID = 1L;

    public SkMossyoruimitoutyakulistBean() {
    }

    @Setter @Getter
    private C_SyoruiCdKbn irSyoruicd;
}
