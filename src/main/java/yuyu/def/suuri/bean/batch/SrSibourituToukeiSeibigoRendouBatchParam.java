package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
/**
 * （数理）死亡率統計整備後連動情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSibourituToukeiSeibigoRendouBatchParam extends GenSrSibourituToukeiSeibigoRendouBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSibourituToukeiSeibigoRendouBatchParam() {

        super.setIbSyorikensuu(0);
    }

    public void setParam() {

        super.setIbTysyttaisyouym(super.getSyoriYmd().getBizDateYM().getPreviousMonth());
    }
}
