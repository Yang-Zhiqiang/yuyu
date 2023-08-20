package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;

/**
 * （数理）解約返戻金相当額情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrKaiyakuHenreikinBatchParam extends GenSrKaiyakuHenreikinBatchParam {

    private static final long serialVersionUID = 1L;

    public SrKaiyakuHenreikinBatchParam() {
    }

    public void setParam() {

        super.setIbSyorikensuu(0);
    }

}
