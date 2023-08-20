package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
/**
 * （数理）新契約決算ベース月次成立情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSinkeiyakuGetujiSeirituBatchParam extends GenSrSinkeiyakuGetujiSeirituBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSinkeiyakuGetujiSeirituBatchParam() {
    }

    public void setParam() {

        super.setIbTysyttaisyouym(super.getIbKijyunymd().getBizDateYM());

        super.setIbSyorikensuu(0);
    }

}
