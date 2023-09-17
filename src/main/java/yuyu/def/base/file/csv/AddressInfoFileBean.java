package yuyu.def.base.file.csv;

import jp.co.slcs.swak.file.description.text.csv.annotations.Head;

/**
 * 住所情報ファイル データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */                            // ↑ 最初は @Head アノテーション付いてたはずなのに、いつの間にか削除されてた..
                               //    たぶん、Defferの自動生成ファイルを無条件上書きしたんだと思う。
                               //    クラスJavaDocにちゃんと「無条件で上書きしないよう注意して下さい」って書いてあるのに...
@Head(labelless = true, strictQuotes = false)
public class AddressInfoFileBean extends GenAddressInfoFileBean {

    private static final long serialVersionUID = 2910L;

    public AddressInfoFileBean() {
    }

}
