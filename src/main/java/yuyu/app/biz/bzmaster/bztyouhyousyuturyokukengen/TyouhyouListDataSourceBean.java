package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 帳票出力権限登録 - tyouhyouList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TyouhyouListDataSourceBean extends GenTyouhyouListDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCd;

    public TyouhyouListDataSourceBean() {
    }

    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        this.syoruiCd = pSyoruiCd;
    }
}
