package yuyu.def.biz.bean.param;

import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * （共通）リカバリデータ識別用BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class BzRecoveryDatasikibetuBean extends GenBzRecoveryDatasikibetuBean {

    private static final long serialVersionUID = 1L;

    public BzRecoveryDatasikibetuBean() {
    }

    public void initializeBlank() {


        setIbKakutyoujobcd("");

        setIbTableid("");

        setIbRecoveryfilterid("");

        setIbRecoveryfilterkey1("");

        setIbRecoveryfilterkey2("");

        setIbRecoveryfilterkey3("");

        setIbRecoveryfilterkey4("");

        setIbRecoveryfilterkey5("");

    }

}
