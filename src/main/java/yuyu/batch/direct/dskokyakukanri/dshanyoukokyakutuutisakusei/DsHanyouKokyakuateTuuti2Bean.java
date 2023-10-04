package yuyu.batch.direct.dskokyakukanri.dshanyoukokyakutuutisakusei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;

/**
 * ダイレクトサービス 顧客管理 ＤＳ汎用顧客宛通知２テーブルBeanクラス
 */
@AllArgsConstructor
public class DsHanyouKokyakuateTuuti2Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate dsdatasakuseiymd;

    @Getter @Setter
    private String dskoktuutirenno;

    @Getter @Setter
    private String dskokno;

    @Getter @Setter
    private C_DsHanyouKokyakuateTuutiKbn dshanyoukokyakuatetuutikbn;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String dssousinno;

    @Getter @Setter
    private C_DsHagakiSouhuJyoukyouKbn dshagakisouhujyoukyoukbn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
