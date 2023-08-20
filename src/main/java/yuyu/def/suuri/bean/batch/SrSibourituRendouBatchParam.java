package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
/**
 * （数理）死亡率用連動情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSibourituRendouBatchParam extends GenSrSibourituRendouBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSibourituRendouBatchParam() {
    }

    public void setParam() {

        super.setIbTysyttaisyouym(super.getSyoriYmd().getBizDateYM().addMonths(-5));

        super.setIbSyorikensuu(0);
    }
}
