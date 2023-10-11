package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import yuyu.def.classification.C_UmuKbn;

/**
 * 申込状況照会 - ●不備一覧 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HubiItiranDataSourceBean extends GenHubiItiranDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn tyoubunFlg = null;

    public HubiItiranDataSourceBean() {
    }

    public C_UmuKbn getTyoubunFlg() {
        return tyoubunFlg;
    }

    public void setTyoubunFlg(C_UmuKbn pTyoubunFlg) {
        tyoubunFlg = pTyoubunFlg;
    }
}
