package yuyu.def.sinkeiyaku.bean.report;

import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * （新契約）振込入金訂正データリスト帳票BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SkHurikominyuukinteiseilistBean extends GenSkHurikominyuukinteiseilistBean {

    private static final long serialVersionUID = 1L;

    public SkHurikominyuukinteiseilistBean() {
    }

    @Setter @Getter
    private C_SyoruiCdKbn irSyoruicd;
}
