package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
/**
 * （数理）保有明細情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrHoyuuMeisaiBatchParam extends GenSrHoyuuMeisaiBatchParam {

    private static final long serialVersionUID = 1L;

    public SrHoyuuMeisaiBatchParam() {

    }

    public void setParam(BizDate pSyoriYmd, BizDate pKijyunYmd) {

        super.setSyoriYmd(pSyoriYmd);

        super.setIbKijyunymd(pKijyunYmd);

        super.setIbSyorikensuu(0);
    }
}
