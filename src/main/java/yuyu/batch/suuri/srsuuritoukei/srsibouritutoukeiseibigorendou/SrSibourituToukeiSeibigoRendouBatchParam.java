package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * （数理）死亡率統計整備後連動情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSibourituToukeiSeibigoRendouBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String IBKAKUTYOUJOBCD = "RGHHM000";

    private BizDateYM tysyttaisyouYm;

    private int sequenceNo;

    private int errorSyoriKensuu;

    private int kykmfksnctrNo;

    private int keikokuSyoriCount;

    public BizDateYM getTysyttaisyouYm() {
        return tysyttaisyouYm;
    }

    public void setTysyttaisyouYm(BizDateYM pTysyttaisyouYm) {
        this.tysyttaisyouYm = pTysyttaisyouYm;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int pSequenceNo) {
        this.sequenceNo = pSequenceNo;
    }

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        this.errorSyoriKensuu = pErrorSyoriKensuu;
    }

    public int getKykmfksnctrNo() {
        return kykmfksnctrNo;
    }

    public void setKykmfksnctrNo(int pKykmfksnctrNo) {
        this.kykmfksnctrNo = pKykmfksnctrNo;
    }

    public int getKeikokuSyoriCount() {
        return keikokuSyoriCount;
    }

    public void setKeikokuSyoriCount(int pKeikokuSyoriCount) {
        keikokuSyoriCount = pKeikokuSyoriCount;
    }

    public SrSibourituToukeiSeibigoRendouBatchParam() {
    }

    public void setParam() {

        setTysyttaisyouYm(super.getSyoriYmd().getBizDateYM().getPreviousMonth());
    }
}
