package yuyu.common.hozen.khview.viewtokusin;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全画面部品 特伸情報表示 <br />
 */
public interface ViewTokusinUiBeanParam extends CommonViewUiBeanParam {

    public C_TokusinKbn getVtstokusinkbn();

    public BizDate getVtshsgymd();

    public BizDate getVtstokusinendymd();

    public C_UmuKbn getVtsumukbn();
}
