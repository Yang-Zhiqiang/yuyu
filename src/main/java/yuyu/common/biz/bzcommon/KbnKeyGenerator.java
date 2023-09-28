package yuyu.common.biz.bzcommon;

/**
 * 区分キー生成用クラスです。<br />
 * <br />
 * 当クラス自体は空実装であり、業務層においてサブクラスを作成の上、<br />
 * Moduleクラスで当クラスに対するバインド定義を行なうと、当クラスの代わりにバインドクラスの処理が実行されます。
 */
public class KbnKeyGenerator {

    public String generate(String pSyono){

        return "0".concat(pSyono.substring(9, 10));
    }

}