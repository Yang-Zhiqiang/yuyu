package yuyu.def.hozen.bean.report;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Nenkinsyu;

/**
 * （保全）ご契約内容のお知らせ帳票BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhKykNaiyouOsiraseBean extends GenKhKykNaiyouOsiraseBean {

    private static final long serialVersionUID = 1L;

    public KhKykNaiyouOsiraseBean() {
    }

    @Setter @Getter
    private String ytirrtitrnhskmsgcd5;

    @Setter @Getter
    private C_Nenkinsyu nksyukbn;

    @Setter @Getter
    private  List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearLeftList;

    @Setter @Getter
    private  List<KhKykNaiyouOsiraseDataSourceBean> ytrrtKwsrateP1yearRightList;

    @Setter @Getter
    private String irWarningMsg;

    @Setter @Getter
    private int irYobidasimotoKbn;
}
